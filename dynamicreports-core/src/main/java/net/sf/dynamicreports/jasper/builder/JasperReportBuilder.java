/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.jasper.builder;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.Validate;

import net.sf.dynamicreports.design.base.DRDesignReport;
import net.sf.dynamicreports.design.definition.DRIDesignReport;
import net.sf.dynamicreports.jasper.base.JasperReportDesign;
import net.sf.dynamicreports.jasper.base.export.AbstractJasperExporter;
import net.sf.dynamicreports.jasper.base.export.JasperImageExporter;
import net.sf.dynamicreports.jasper.base.tableofcontents.JasperTocReport;
import net.sf.dynamicreports.jasper.base.templatedesign.JasperEmptyTemplateDesign;
import net.sf.dynamicreports.jasper.base.templatedesign.JasperTemplateDesign;
import net.sf.dynamicreports.jasper.builder.export.AbstractJasperExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.Exporters;
import net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperDocxExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperImageExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperOdsExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperOdtExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperPptxExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperRtfExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperXmlExporterBuilder;
import net.sf.dynamicreports.jasper.constant.ImageType;
import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.dynamicreports.jasper.transformation.ExporterTransform;
import net.sf.dynamicreports.jasper.transformation.JasperTransform;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.QueryBuilder;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.QueryLanguage;
import net.sf.dynamicreports.report.definition.DRITemplateDesign;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JRRewindableDataSource;
import net.sf.jasperreports.engine.JRVirtualizer;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.xml.JRXmlWriter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleGraphics2DExporterConfiguration;
import net.sf.jasperreports.export.SimpleGraphics2DExporterOutput;
import net.sf.jasperreports.export.SimpleGraphics2DReportConfiguration;
import net.sf.jasperreports.view.JasperDesignViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 * The most used report builder for creating reports. It allows constructing and customizing the whole report content.
 * A report consists of bands, columns, subtotals, groups, and other parts.
 * Each part is created and configured using a particular builder method and it's passed to the report builder instance.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperReportBuilder extends ReportBuilder<JasperReportBuilder> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private JasperReportDesign reportDesign;
	private JasperDesign jasperDesign;
	private JasperReport jasperReport;
	private JasperPrint jasperPrint;
	private transient JRDataSource dataSource;
	private transient Connection connection;
	private transient JRVirtualizer virtualizer;
	private Integer startPageNumber;
	private Map<String, Object> parameters;

	public JasperReportBuilder() {
		setTemplateDesign(new JasperEmptyTemplateDesign());
	}

	public JasperReportBuilder setStartPageNumber(Integer startPageNumber) throws DRException {
		if (this.startPageNumber == startPageNumber) {
			return this;
		}
		this.startPageNumber = startPageNumber;
		rebuild();
		return this;
	}

	public JasperReportBuilder setConnection(Connection connection) {
		Validate.notNull(connection, "connection must not be null");
		this.connection = connection;
		return this;
	}

	/**
	 * Sets a data source object.
	 * Creates a new JRBeanCollectionDataSource data source object.
	 *
	 * @param collection
	 *          - the collection values
	 * @return a report builder
	 */
	public JasperReportBuilder setDataSource(Collection<?> collection) {
		return setDataSource(new JRBeanCollectionDataSource(collection));
	}

	/**
	 * Sets a database data source.
	 * In this type of data source, data are retrieved from a database.
	 *
	 * @param resultSet
	 *          - the resultSet object
	 * @return a report builder
	 */
	public JasperReportBuilder setDataSource(ResultSet resultSet) {
		return setDataSource(new JRResultSetDataSource(resultSet));
	}

	/**
	 * Sets a database data source.
	 * In this type of data source, data are retrieved from a database.
	 *
	 * @param sql
	 *          - the sql query
	 * @param connection
	 *          - the database connection
	 * @return a report builder
	 */
	public JasperReportBuilder setDataSource(String sql, Connection connection) {
		Validate.notNull(sql, "sql must not be null");
		return setDataSource(DynamicReports.query(sql, QueryLanguage.SQL), connection);
	}

	/**
	 * Sets a database data source.
	 * In this type of data source, data are retrieved from a database.
	 *
	 * @param query
	 *          - the query definition
	 * @param connection
	 *          - the database connection
	 * @return a report builder
	 */
	public JasperReportBuilder setDataSource(QueryBuilder query, Connection connection) {
		Validate.notNull(query, "query must not be null");
		Validate.notNull(connection, "connection must not be null");
		getObject().setQuery(query.build());
		this.connection = connection;
		dataSource = null;
		return this;
	}

	/**
	 * Sets a data source object.
	 *
	 * @param dataSource
	 *          - the JRDataSource object
	 * @return a report builder
	 */
	public JasperReportBuilder setDataSource(JRDataSource dataSource) {
		this.dataSource = dataSource;
		connection = null;
		return this;
	}

	// template design
	public JasperReportBuilder setTemplateDesign(InputStream inputStream) throws DRException {
		return setTemplateDesign(new JasperTemplateDesign(inputStream));
	}

	public JasperReportBuilder setTemplateDesign(File file) throws DRException {
		return setTemplateDesign(new JasperTemplateDesign(file));
	}

	public JasperReportBuilder setTemplateDesign(String fileName) throws DRException {
		return setTemplateDesign(new JasperTemplateDesign(fileName));
	}

	public JasperReportBuilder setTemplateDesign(JasperDesign jasperDesign) throws DRException {
		return setTemplateDesign(new JasperTemplateDesign(jasperDesign));
	}

	public JasperReportBuilder setTemplateDesign(URL jasperDesignUrl) throws DRException {
		return setTemplateDesign(new JasperTemplateDesign(jasperDesignUrl));
	}

	private JasperReportBuilder setTemplateDesign(DRITemplateDesign<JasperDesign> templateDesign) {
		getObject().setTemplateDesign(templateDesign);
		return this;
	}

	@Override
	public JasperReportBuilder setParameter(String name, Object value) {
		super.setParameter(name, value);
		parameters = null;
		jasperPrint = null;
		return this;
	}

	@Override
	public JasperReportBuilder setParameters(Map<String, Object> parameters) {
		super.setParameters(parameters);
		this.parameters = null;
		jasperPrint = null;
		return this;
	}

	public JasperReportBuilder rebuild() throws DRException {
		builded = false;
		reportDesign = null;
		jasperDesign = null;
		jasperReport = null;
		parameters = null;
		jasperPrint = null;
		if (dataSource != null && dataSource instanceof JRRewindableDataSource) {
			try {
				((JRRewindableDataSource) dataSource).moveFirst();
			} catch (JRException e) {
				throw new DRException(e);
			}
		}
		return this;
	}

	private JasperReportDesign toJasperReportDesign() throws DRException {
		if (reportDesign == null) {
			DRIDesignReport report = new DRDesignReport(build());
			reportDesign = new JasperReportDesign(report, startPageNumber);
			JasperTransform jasperTransform = new JasperTransform(report, reportDesign);
			jasperTransform.transform();
		}
		return reportDesign;
	}

	public JasperDesign toJasperDesign() throws DRException {
		if (jasperDesign == null) {
			jasperDesign = toJasperReportDesign().getDesign();
		}
		return jasperDesign;
	}

	public JasperReport toJasperReport() throws DRException {
		if (jasperReport == null) {
			try {
				jasperReport = JasperCompileManager.compileReport(toJasperDesign());
			} catch (JRException e) {
				throw new DRException(e);
			}
		}
		return jasperReport;
	}

	public Map<String, Object> getJasperParameters() throws DRException {
		if (parameters == null) {
			parameters = new HashMap<>();
			JasperReportDesign jasperReportDesign = toJasperReportDesign();
			parameters.putAll(jasperReportDesign.getParameters());
			if (getReport().getParameterValues() != null) {
				parameters.putAll(getReport().getParameterValues());
			}
		}
		return parameters;
	}

	public JasperPrint toJasperPrint() throws DRException {
		if (jasperPrint == null) {
			Map<String, Object> parameters = getJasperParameters();
			if (virtualizer != null) {
				parameters.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
			}

			try {
				if (connection != null && toJasperReport().getQuery() != null) {
					jasperPrint = JasperFillManager.fillReport(toJasperReport(), parameters, connection);
				} else if (dataSource != null) {
					jasperPrint = JasperFillManager.fillReport(toJasperReport(), parameters, dataSource);
				} else {
					jasperPrint = JasperFillManager.fillReport(toJasperReport(), parameters);
				}

				if (toJasperReportDesign().isTableOfContents()) {
					JasperTocReport.createTocReport(toJasperReportDesign(), jasperPrint, parameters);
				}
			} catch (JRException e) {
				throw new DRException(e);
			}

		}
		return jasperPrint;
	}

	public JasperReportBuilder show() throws DRException {
		JasperViewer.viewReport(toJasperPrint());
		return this;
	}

	public JasperReportBuilder show(boolean exitOnClose) throws DRException {
		JasperViewer.viewReport(toJasperPrint(), exitOnClose, null);
		return this;
	}

	public JasperReportBuilder showJrXml() throws DRException {
		try {
			JasperDesignViewer.viewReportDesign(toJasperDesign());
		} catch (JRException e) {
			throw new DRException(e);
		}
		return this;
	}

	public JasperReportBuilder toJrXml(OutputStream outputStream) throws DRException {
		Validate.notNull(outputStream, "outputStream must not be null");
		try {
			JRXmlWriter.writeReport(toJasperDesign(), outputStream, "UTF-8");
		} catch (JRException e) {
			throw new DRException(e);
		}
		return this;
	}

	public JasperReportBuilder print() throws DRException {
		return print(true);
	}

	public JasperReportBuilder print(boolean withPrintDialog) throws DRException {
		try {
			JasperPrintManager.printReport(toJasperPrint(), withPrintDialog);
		} catch (JRException e) {
			throw new DRException(e);
		}
		return this;
	}

	public JasperReportBuilder setVirtualizer(JRVirtualizer virtualizer) {
		this.virtualizer = virtualizer;
		return this;
	}

	// image
	public JasperReportBuilder toImage(OutputStream outputStream, ImageType imageType) throws DRException {
		return toImage(Exporters.imageExporter(outputStream, imageType));
	}

	public JasperReportBuilder toImage(JasperImageExporterBuilder imageExporterBuilder) throws DRException {
		Validate.notNull(imageExporterBuilder, "imageExporterBuilder must not be null");

		JasperImageExporter imageExporter = imageExporterBuilder.build();

		JasperPrint jasperPrint = toJasperPrint();
		Integer fromPage = null;
		Integer toPage = null;
		float zoom = 1;
		String imageType = imageExporter.getImageType().name().toLowerCase();
		int offsetX = 0;
		int offsetY = 0;
		int pageGap = 0;

		if (imageExporter.getZoomRatio() != null) {
			zoom = imageExporter.getZoomRatio();
		}
		if (imageExporter.getOffsetX() != null) {
			offsetX = imageExporter.getOffsetX();
		}
		if (imageExporter.getOffsetY() != null) {
			offsetY = imageExporter.getOffsetY();
		}
		if (imageExporter.getPageGap() != null) {
			pageGap = imageExporter.getPageGap();
		}

		if (imageExporter.getPageIndex() != null && imageExporter.getPageIndex() >= 0) {
			fromPage = imageExporter.getPageIndex();
			toPage = imageExporter.getPageIndex() + 1;
		} else {
			if (imageExporter.getStartPageIndex() != null) {
				fromPage = imageExporter.getStartPageIndex();
			}
			if (imageExporter.getEndPageIndex() != null) {
				toPage = imageExporter.getEndPageIndex();
			}
		}
		if (fromPage == null) {
			fromPage = 0;
		}
		if (toPage == null) {
			toPage = jasperPrint.getPages().size();
		}

		int pages = toPage - fromPage;

		int pageWidth = (int) (jasperPrint.getPageWidth() * zoom);
		int pageHeight = (int) (jasperPrint.getPageHeight() * zoom);
		int width = pageWidth * pages + pages - 1 + offsetX * 2;
		int height = (int) (jasperPrint.getPageHeight() * zoom) + offsetY * 2;
		Image image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		int offset = offsetX;
		for (int i = 0; i < pages; i++) {
			try {
				SimpleExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
				SimpleGraphics2DExporterOutput exporterOutput = new SimpleGraphics2DExporterOutput();
				Image pageImage = new BufferedImage(pageWidth, pageHeight, BufferedImage.TYPE_INT_RGB);
				exporterOutput.setGraphics2D((Graphics2D) pageImage.getGraphics());
				SimpleGraphics2DReportConfiguration reportExportConfiguration = new SimpleGraphics2DReportConfiguration();
				reportExportConfiguration.setPageIndex(fromPage);
				reportExportConfiguration.setZoomRatio(zoom);
				SimpleGraphics2DExporterConfiguration exporterConfiguration = new SimpleGraphics2DExporterConfiguration();

				JRGraphics2DExporter jrExporter = new JRGraphics2DExporter();
				jrExporter.setExporterInput(exporterInput);
				jrExporter.setExporterOutput(exporterOutput);
				jrExporter.setConfiguration(reportExportConfiguration);
				jrExporter.setConfiguration(exporterConfiguration);

				jrExporter.exportReport();
				((Graphics2D) image.getGraphics()).drawImage(pageImage, offset, offsetY, null);
				fromPage++;
				offset += pageWidth + pageGap;
			} catch (JRException e) {
				throw new DRException(e);
			}
		}
		try {
			if (imageExporter.getOutputStream() != null) {
				ImageIO.write((RenderedImage) image, imageType, imageExporter.getOutputStream());
			} else if (imageExporter.getOutputFileName() != null) {
				ImageIO.write((RenderedImage) image, imageType, new File(imageExporter.getOutputFileName()));
			} else if (imageExporter.getOutputFile() != null) {
				ImageIO.write((RenderedImage) image, imageType, imageExporter.getOutputFile());
			} else {
				throw new JasperDesignException("ImageExporter output not supported");
			}
		} catch (IOException e) {
			throw new DRException(e);
		}
		return this;
	}

	// csv
	public JasperReportBuilder toCsv(OutputStream outputStream) throws DRException {
		return toCsv(Exporters.csvExporter(outputStream));
	}

	public JasperReportBuilder toCsv(JasperCsvExporterBuilder csvExporterBuilder) throws DRException {
		return export(csvExporterBuilder);
	}

	// docx
	public JasperReportBuilder toDocx(OutputStream outputStream) throws DRException {
		return toDocx(Exporters.docxExporter(outputStream));
	}

	public JasperReportBuilder toDocx(JasperDocxExporterBuilder docxExporterBuilder) throws DRException {
		return export(docxExporterBuilder);
	}

	// html
	public JasperReportBuilder toHtml(OutputStream outputStream) throws DRException {
		return toHtml(Exporters.htmlExporter(outputStream));
	}

	public JasperReportBuilder toHtml(JasperHtmlExporterBuilder htmlExporterBuilder) throws DRException {
		return export(htmlExporterBuilder);
	}

	// ods
	public JasperReportBuilder toOds(OutputStream outputStream) throws DRException {
		return toOds(Exporters.odsExporter(outputStream));
	}

	public JasperReportBuilder toOds(JasperOdsExporterBuilder odsExporterBuilder) throws DRException {
		return export(odsExporterBuilder);
	}

	// odt
	public JasperReportBuilder toOdt(OutputStream outputStream) throws DRException {
		return toOdt(Exporters.odtExporter(outputStream));
	}

	public JasperReportBuilder toOdt(JasperOdtExporterBuilder odtExporterBuilder) throws DRException {
		return export(odtExporterBuilder);
	}

	// pdf
	public JasperReportBuilder toPdf(OutputStream outputStream) throws DRException {
		return toPdf(Exporters.pdfExporter(outputStream));
	}

	public JasperReportBuilder toPdf(JasperPdfExporterBuilder pdfExporterBuilder) throws DRException {
		return export(pdfExporterBuilder);
	}

	// rtf
	public JasperReportBuilder toRtf(OutputStream outputStream) throws DRException {
		return toRtf(Exporters.rtfExporter(outputStream));
	}

	public JasperReportBuilder toRtf(JasperRtfExporterBuilder rtfExporterBuilder) throws DRException {
		return export(rtfExporterBuilder);
	}

	// text
	public JasperReportBuilder toText(OutputStream outputStream) throws DRException {
		return toText(Exporters.textExporter(outputStream));
	}

	public JasperReportBuilder toText(JasperTextExporterBuilder textExporterBuilder) throws DRException {
		return export(textExporterBuilder);
	}

	// xls
	public JasperReportBuilder toXls(OutputStream outputStream) throws DRException {
		return toXls(Exporters.xlsExporter(outputStream));
	}

	public JasperReportBuilder toXls(JasperXlsExporterBuilder xlsExporterBuilder) throws DRException {
		return export(xlsExporterBuilder);
	}

	// xlsx
	public JasperReportBuilder toXlsx(OutputStream outputStream) throws DRException {
		return toXlsx(Exporters.xlsxExporter(outputStream));
	}

	public JasperReportBuilder toXlsx(JasperXlsxExporterBuilder xlsxExporterBuilder) throws DRException {
		return export(xlsxExporterBuilder);
	}

	// xml
	public JasperReportBuilder toXml(OutputStream outputStream) throws DRException {
		return toXml(Exporters.xmlExporter(outputStream));
	}

	public JasperReportBuilder toXml(JasperXmlExporterBuilder xmlExporterBuilder) throws DRException {
		return export(xmlExporterBuilder);
	}

	// pptx
	public JasperReportBuilder toPptx(OutputStream outputStream) throws DRException {
		return toPptx(Exporters.pptxExporter(outputStream));
	}

	public JasperReportBuilder toPptx(JasperPptxExporterBuilder pptxExporterBuilder) throws DRException {
		return export(pptxExporterBuilder);
	}

	public JasperReportBuilder export(AbstractJasperExporterBuilder<?, ? extends AbstractJasperExporter> exporterBuilder) throws DRException {
		Validate.notNull(exporterBuilder, "exporterBuilder must not be null");
		try {
			ExporterTransform exporterTransform = new ExporterTransform(exporterBuilder.build());
			@SuppressWarnings("unchecked")
			Exporter<ExporterInput, ?, ?, ?> exporter = (Exporter<ExporterInput, ?, ?, ?>) exporterTransform.transform();
			exporter.setExporterInput(new SimpleExporterInput(toJasperPrint()));
			exporter.exportReport();
		} catch (JRException e) {
			throw new DRException(e);
		}
		return this;
	}

	public Connection getConnection() {
		return connection;
	}

	public JRDataSource getDataSource() {
		return dataSource;
	}
}

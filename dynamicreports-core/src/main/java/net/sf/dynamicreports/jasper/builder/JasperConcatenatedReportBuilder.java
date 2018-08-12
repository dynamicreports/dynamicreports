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

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.Validate;

import net.sf.dynamicreports.jasper.base.export.AbstractJasperExporter;
import net.sf.dynamicreports.jasper.base.reporthandler.JasperReportBuilderHandler;
import net.sf.dynamicreports.jasper.builder.export.AbstractJasperExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.Exporters;
import net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperDocxExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperOdsExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperOdtExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperPptxExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperRtfExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperXmlExporterBuilder;
import net.sf.dynamicreports.jasper.definition.JasperReportHandler;
import net.sf.dynamicreports.jasper.transformation.ExporterTransform;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleGraphics2DExporterConfiguration;
import net.sf.jasperreports.export.SimpleGraphics2DExporterOutput;
import net.sf.jasperreports.export.SimpleGraphics2DReportConfiguration;

/**
 * This report builder allows concatenating several separated reports into one single document.
 * Each report starts on a new page with its own page dimension.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class JasperConcatenatedReportBuilder implements Serializable {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private JasperReportHandler jasperReportHandler;

	/**
	 * <p>Constructor for JasperConcatenatedReportBuilder.</p>
	 */
	public JasperConcatenatedReportBuilder() {
		this(new JasperReportBuilderHandler());
	}

	/**
	 * <p>Constructor for JasperConcatenatedReportBuilder.</p>
	 *
	 * @param jasperReportHandler a {@link net.sf.dynamicreports.jasper.definition.JasperReportHandler} object.
	 */
	public JasperConcatenatedReportBuilder(JasperReportHandler jasperReportHandler) {
		this.jasperReportHandler = jasperReportHandler;
	}

	/**
	 * <p>concatenate.</p>
	 *
	 * @param jasperReportBuilders a {@link net.sf.dynamicreports.jasper.builder.JasperReportBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 */
	public JasperConcatenatedReportBuilder concatenate(JasperReportBuilder... jasperReportBuilders) {
		Validate.notNull(jasperReportBuilders, "jasperReportBuilders must not be null");
		Validate.noNullElements(jasperReportBuilders, "jasperReportBuilders must not contains null jasperReportBuilder");
		jasperReportHandler.concatenate(jasperReportBuilders);
		return this;
	}

	/**
	 * <p>toPng.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toPng(OutputStream outputStream) throws DRException {
		return toPng(outputStream, 1);
	}

	/**
	 * <p>toPng.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @param zoom a float.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toPng(OutputStream outputStream, float zoom) throws DRException {
		Validate.notNull(outputStream, "outputStream must not be null");
		Validate.isTrue(zoom > 0, "zoom must be > 0");

		int maxWidth = 0;
		int maxHeight = 0;

		for (JasperPrint jasperPrint : jasperReportHandler.getPrintList()) {
			int pages = jasperPrint.getPages().size();
			int pageWidth = (int) (jasperPrint.getPageWidth() * zoom);
			maxWidth += pageWidth * pages + pages - 1 + 2;
			int height = (int) (jasperPrint.getPageHeight() * zoom) + 2;
			if (height > maxHeight) {
				maxHeight = height;
			}
		}

		Image image = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = (Graphics2D) image.getGraphics();
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fill(new Rectangle2D.Float(1, 1, maxWidth - 1, maxHeight - 1));

		int offset = 1;
		for (JasperPrint jasperPrint : jasperReportHandler.getPrintList()) {
			int pageWidth = (int) (jasperPrint.getPageWidth() * zoom);
			int pageHeight = (int) (jasperPrint.getPageHeight() * zoom);
			for (int i = 0; i < jasperPrint.getPages().size(); i++) {
				try {
					SimpleExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
					SimpleGraphics2DExporterOutput exporterOutput = new SimpleGraphics2DExporterOutput();
					Image pageImage = new BufferedImage(pageWidth, pageHeight, BufferedImage.TYPE_INT_RGB);
					exporterOutput.setGraphics2D((Graphics2D) pageImage.getGraphics());
					SimpleGraphics2DReportConfiguration reportExportConfiguration = new SimpleGraphics2DReportConfiguration();
					reportExportConfiguration.setPageIndex(i);
					reportExportConfiguration.setZoomRatio(zoom);
					SimpleGraphics2DExporterConfiguration exporterConfiguration = new SimpleGraphics2DExporterConfiguration();

					JRGraphics2DExporter jrExporter = new JRGraphics2DExporter();
					jrExporter.setExporterInput(exporterInput);
					jrExporter.setExporterOutput(exporterOutput);
					jrExporter.setConfiguration(reportExportConfiguration);
					jrExporter.setConfiguration(exporterConfiguration);

					jrExporter.exportReport();
					((Graphics2D) image.getGraphics()).drawImage(pageImage, offset, 1, null);
					offset += pageWidth + 1;
				} catch (JRException e) {
					throw new DRException(e);
				}
			}
		}
		try {
			ImageIO.write((RenderedImage) image, "png", outputStream);
		} catch (IOException e) {
			throw new DRException(e);
		}
		return this;
	}

	/**
	 * <p>continuousPageNumbering.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 */
	public JasperConcatenatedReportBuilder continuousPageNumbering() {
		return setContinuousPageNumbering(true);
	}

	/**
	 * <p>setContinuousPageNumbering.</p>
	 *
	 * @param continuousPageNumbering a boolean.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 */
	public JasperConcatenatedReportBuilder setContinuousPageNumbering(boolean continuousPageNumbering) {
		jasperReportHandler.setContinuousPageNumbering(continuousPageNumbering);
		return this;
	}

	// csv
	/**
	 * <p>toCsv.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toCsv(OutputStream outputStream) throws DRException {
		return toCsv(Exporters.csvExporter(outputStream));
	}

	/**
	 * <p>toCsv.</p>
	 *
	 * @param csvExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toCsv(JasperCsvExporterBuilder csvExporterBuilder) throws DRException {
		return export(csvExporterBuilder);
	}

	// docx
	/**
	 * <p>toDocx.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toDocx(OutputStream outputStream) throws DRException {
		return toDocx(Exporters.docxExporter(outputStream));
	}

	/**
	 * <p>toDocx.</p>
	 *
	 * @param docxExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperDocxExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toDocx(JasperDocxExporterBuilder docxExporterBuilder) throws DRException {
		return export(docxExporterBuilder);
	}

	// html
	/**
	 * <p>toHtml.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toHtml(OutputStream outputStream) throws DRException {
		return toHtml(Exporters.htmlExporter(outputStream));
	}

	/**
	 * <p>toHtml.</p>
	 *
	 * @param htmlExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toHtml(JasperHtmlExporterBuilder htmlExporterBuilder) throws DRException {
		return export(htmlExporterBuilder);
	}

	// ods
	/**
	 * <p>toOds.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toOds(OutputStream outputStream) throws DRException {
		return toOds(Exporters.odsExporter(outputStream));
	}

	/**
	 * <p>toOds.</p>
	 *
	 * @param odsExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdsExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toOds(JasperOdsExporterBuilder odsExporterBuilder) throws DRException {
		return export(odsExporterBuilder);
	}

	// odt
	/**
	 * <p>toOdt.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toOdt(OutputStream outputStream) throws DRException {
		return toOdt(Exporters.odtExporter(outputStream));
	}

	/**
	 * <p>toOdt.</p>
	 *
	 * @param odtExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdtExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toOdt(JasperOdtExporterBuilder odtExporterBuilder) throws DRException {
		return export(odtExporterBuilder);
	}

	// pdf
	/**
	 * <p>toPdf.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toPdf(OutputStream outputStream) throws DRException {
		return toPdf(Exporters.pdfExporter(outputStream));
	}

	/**
	 * <p>toPdf.</p>
	 *
	 * @param pdfExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toPdf(JasperPdfExporterBuilder pdfExporterBuilder) throws DRException {
		return export(pdfExporterBuilder);
	}

	// rtf
	/**
	 * <p>toRtf.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toRtf(OutputStream outputStream) throws DRException {
		return toRtf(Exporters.rtfExporter(outputStream));
	}

	/**
	 * <p>toRtf.</p>
	 *
	 * @param rtfExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperRtfExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toRtf(JasperRtfExporterBuilder rtfExporterBuilder) throws DRException {
		return export(rtfExporterBuilder);
	}

	// text
	/**
	 * <p>toText.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toText(OutputStream outputStream) throws DRException {
		return toText(Exporters.textExporter(outputStream));
	}

	/**
	 * <p>toText.</p>
	 *
	 * @param textExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toText(JasperTextExporterBuilder textExporterBuilder) throws DRException {
		return export(textExporterBuilder);
	}

	// xls
	/**
	 * <p>toXls.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toXls(OutputStream outputStream) throws DRException {
		return toXls(Exporters.xlsExporter(outputStream));
	}

	/**
	 * <p>toXls.</p>
	 *
	 * @param xlsExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toXls(JasperXlsExporterBuilder xlsExporterBuilder) throws DRException {
		return export(xlsExporterBuilder);
	}

	// xlsx
	/**
	 * <p>toXlsx.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toXlsx(OutputStream outputStream) throws DRException {
		return toXlsx(Exporters.xlsxExporter(outputStream));
	}

	/**
	 * <p>toXlsx.</p>
	 *
	 * @param xlsxExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toXlsx(JasperXlsxExporterBuilder xlsxExporterBuilder) throws DRException {
		return export(xlsxExporterBuilder);
	}

	// xml
	/**
	 * <p>toXml.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toXml(OutputStream outputStream) throws DRException {
		return toXml(Exporters.xmlExporter(outputStream));
	}

	/**
	 * <p>toXml.</p>
	 *
	 * @param xmlExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperXmlExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toXml(JasperXmlExporterBuilder xmlExporterBuilder) throws DRException {
		return export(xmlExporterBuilder);
	}

	// pptx
	/**
	 * <p>toPptx.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toPptx(OutputStream outputStream) throws DRException {
		return toPptx(Exporters.pptxExporter(outputStream));
	}

	/**
	 * <p>toPptx.</p>
	 *
	 * @param pptxExporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.JasperPptxExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder toPptx(JasperPptxExporterBuilder pptxExporterBuilder) throws DRException {
		return export(pptxExporterBuilder);
	}

	/**
	 * <p>export.</p>
	 *
	 * @param exporterBuilder a {@link net.sf.dynamicreports.jasper.builder.export.AbstractJasperExporterBuilder} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public JasperConcatenatedReportBuilder export(AbstractJasperExporterBuilder<?, ? extends AbstractJasperExporter> exporterBuilder) throws DRException {
		Validate.notNull(exporterBuilder, "exporterBuilder must not be null");
		try {
			ExporterTransform exporterTransform = new ExporterTransform(exporterBuilder.build());
			@SuppressWarnings("unchecked")
			Exporter<ExporterInput, ?, ?, ?> exporter = (Exporter<ExporterInput, ?, ?, ?>) exporterTransform.transform();
			exporter.setExporterInput(SimpleExporterInput.getInstance(jasperReportHandler.getPrintList()));
			exporter.exportReport();
		} catch (JRException e) {
			throw new DRException(e);
		}
		return this;
	}
}

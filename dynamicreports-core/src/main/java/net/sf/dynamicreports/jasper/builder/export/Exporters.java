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

package net.sf.dynamicreports.jasper.builder.export;

import java.io.File;
import java.io.OutputStream;
import java.io.Writer;

import net.sf.dynamicreports.jasper.constant.ImageType;

/**
 * A set of methods of creating exporters
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class Exporters {

	// csv
	/**
	 * <p>csvExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder} object.
	 */
	public static JasperCsvExporterBuilder csvExporter(Writer outputWriter) {
		return new JasperCsvExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>csvExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder} object.
	 */
	public static JasperCsvExporterBuilder csvExporter(OutputStream outputStream) {
		return new JasperCsvExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>csvExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder} object.
	 */
	public static JasperCsvExporterBuilder csvExporter(File outputFile) {
		return new JasperCsvExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>csvExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder} object.
	 */
	public static JasperCsvExporterBuilder csvExporter(String outputFileName) {
		return new JasperCsvExporterBuilder().setOutputFileName(outputFileName);
	}

	// docx
	/**
	 * <p>docxExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperDocxExporterBuilder} object.
	 */
	public static JasperDocxExporterBuilder docxExporter(Writer outputWriter) {
		return new JasperDocxExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>docxExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperDocxExporterBuilder} object.
	 */
	public static JasperDocxExporterBuilder docxExporter(OutputStream outputStream) {
		return new JasperDocxExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>docxExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperDocxExporterBuilder} object.
	 */
	public static JasperDocxExporterBuilder docxExporter(File outputFile) {
		return new JasperDocxExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>docxExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperDocxExporterBuilder} object.
	 */
	public static JasperDocxExporterBuilder docxExporter(String outputFileName) {
		return new JasperDocxExporterBuilder().setOutputFileName(outputFileName);
	}

	// html
	/**
	 * <p>htmlExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder} object.
	 */
	public static JasperHtmlExporterBuilder htmlExporter(Writer outputWriter) {
		return new JasperHtmlExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>htmlExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder} object.
	 */
	public static JasperHtmlExporterBuilder htmlExporter(OutputStream outputStream) {
		return new JasperHtmlExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>htmlExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder} object.
	 */
	public static JasperHtmlExporterBuilder htmlExporter(File outputFile) {
		return new JasperHtmlExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>htmlExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder} object.
	 */
	public static JasperHtmlExporterBuilder htmlExporter(String outputFileName) {
		return new JasperHtmlExporterBuilder().setOutputFileName(outputFileName);
	}

	// ods
	/**
	 * <p>odsExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdsExporterBuilder} object.
	 */
	public static JasperOdsExporterBuilder odsExporter(Writer outputWriter) {
		return new JasperOdsExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>odsExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdsExporterBuilder} object.
	 */
	public static JasperOdsExporterBuilder odsExporter(OutputStream outputStream) {
		return new JasperOdsExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>odsExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdsExporterBuilder} object.
	 */
	public static JasperOdsExporterBuilder odsExporter(File outputFile) {
		return new JasperOdsExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>odsExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdsExporterBuilder} object.
	 */
	public static JasperOdsExporterBuilder odsExporter(String outputFileName) {
		return new JasperOdsExporterBuilder().setOutputFileName(outputFileName);
	}

	// odt
	/**
	 * <p>odtExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdtExporterBuilder} object.
	 */
	public static JasperOdtExporterBuilder odtExporter(Writer outputWriter) {
		return new JasperOdtExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>odtExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdtExporterBuilder} object.
	 */
	public static JasperOdtExporterBuilder odtExporter(OutputStream outputStream) {
		return new JasperOdtExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>odtExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdtExporterBuilder} object.
	 */
	public static JasperOdtExporterBuilder odtExporter(File outputFile) {
		return new JasperOdtExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>odtExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdtExporterBuilder} object.
	 */
	public static JasperOdtExporterBuilder odtExporter(String outputFileName) {
		return new JasperOdtExporterBuilder().setOutputFileName(outputFileName);
	}

	// pdf
	/**
	 * <p>pdfExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
	 */
	public static JasperPdfExporterBuilder pdfExporter(Writer outputWriter) {
		return new JasperPdfExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>pdfExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
	 */
	public static JasperPdfExporterBuilder pdfExporter(OutputStream outputStream) {
		return new JasperPdfExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>pdfExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
	 */
	public static JasperPdfExporterBuilder pdfExporter(File outputFile) {
		return new JasperPdfExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>pdfExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
	 */
	public static JasperPdfExporterBuilder pdfExporter(String outputFileName) {
		return new JasperPdfExporterBuilder().setOutputFileName(outputFileName);
	}

	// rtf
	/**
	 * <p>rtfExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperRtfExporterBuilder} object.
	 */
	public static JasperRtfExporterBuilder rtfExporter(Writer outputWriter) {
		return new JasperRtfExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>rtfExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperRtfExporterBuilder} object.
	 */
	public static JasperRtfExporterBuilder rtfExporter(OutputStream outputStream) {
		return new JasperRtfExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>rtfExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperRtfExporterBuilder} object.
	 */
	public static JasperRtfExporterBuilder rtfExporter(File outputFile) {
		return new JasperRtfExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>rtfExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperRtfExporterBuilder} object.
	 */
	public static JasperRtfExporterBuilder rtfExporter(String outputFileName) {
		return new JasperRtfExporterBuilder().setOutputFileName(outputFileName);
	}

	// text
	/**
	 * <p>textExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
	 */
	public static JasperTextExporterBuilder textExporter(Writer outputWriter) {
		return new JasperTextExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>textExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
	 */
	public static JasperTextExporterBuilder textExporter(OutputStream outputStream) {
		return new JasperTextExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>textExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
	 */
	public static JasperTextExporterBuilder textExporter(File outputFile) {
		return new JasperTextExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>textExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
	 */
	public static JasperTextExporterBuilder textExporter(String outputFileName) {
		return new JasperTextExporterBuilder().setOutputFileName(outputFileName);
	}

	// xls
	/**
	 * <p>xlsExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder} object.
	 */
	public static JasperXlsExporterBuilder xlsExporter(Writer outputWriter) {
		return new JasperXlsExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>xlsExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder} object.
	 */
	public static JasperXlsExporterBuilder xlsExporter(OutputStream outputStream) {
		return new JasperXlsExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>xlsExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder} object.
	 */
	public static JasperXlsExporterBuilder xlsExporter(File outputFile) {
		return new JasperXlsExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>xlsExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder} object.
	 */
	public static JasperXlsExporterBuilder xlsExporter(String outputFileName) {
		return new JasperXlsExporterBuilder().setOutputFileName(outputFileName);
	}

	// xlsx
	/**
	 * <p>xlsxExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder} object.
	 */
	public static JasperXlsxExporterBuilder xlsxExporter(Writer outputWriter) {
		return new JasperXlsxExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>xlsxExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder} object.
	 */
	public static JasperXlsxExporterBuilder xlsxExporter(OutputStream outputStream) {
		return new JasperXlsxExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>xlsxExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder} object.
	 */
	public static JasperXlsxExporterBuilder xlsxExporter(File outputFile) {
		return new JasperXlsxExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>xlsxExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder} object.
	 */
	public static JasperXlsxExporterBuilder xlsxExporter(String outputFileName) {
		return new JasperXlsxExporterBuilder().setOutputFileName(outputFileName);
	}

	// xml
	/**
	 * <p>xmlExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXmlExporterBuilder} object.
	 */
	public static JasperXmlExporterBuilder xmlExporter(Writer outputWriter) {
		return new JasperXmlExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>xmlExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXmlExporterBuilder} object.
	 */
	public static JasperXmlExporterBuilder xmlExporter(OutputStream outputStream) {
		return new JasperXmlExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>xmlExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXmlExporterBuilder} object.
	 */
	public static JasperXmlExporterBuilder xmlExporter(File outputFile) {
		return new JasperXmlExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>xmlExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXmlExporterBuilder} object.
	 */
	public static JasperXmlExporterBuilder xmlExporter(String outputFileName) {
		return new JasperXmlExporterBuilder().setOutputFileName(outputFileName);
	}

	// pptx
	/**
	 * <p>pptxExporter.</p>
	 *
	 * @param outputWriter a {@link java.io.Writer} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPptxExporterBuilder} object.
	 */
	public static JasperPptxExporterBuilder pptxExporter(Writer outputWriter) {
		return new JasperPptxExporterBuilder().setOutputWriter(outputWriter);
	}

	/**
	 * <p>pptxExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPptxExporterBuilder} object.
	 */
	public static JasperPptxExporterBuilder pptxExporter(OutputStream outputStream) {
		return new JasperPptxExporterBuilder().setOutputStream(outputStream);
	}

	/**
	 * <p>pptxExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPptxExporterBuilder} object.
	 */
	public static JasperPptxExporterBuilder pptxExporter(File outputFile) {
		return new JasperPptxExporterBuilder().setOutputFile(outputFile);
	}

	/**
	 * <p>pptxExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPptxExporterBuilder} object.
	 */
	public static JasperPptxExporterBuilder pptxExporter(String outputFileName) {
		return new JasperPptxExporterBuilder().setOutputFileName(outputFileName);
	}

	// image
	/**
	 * <p>imageExporter.</p>
	 *
	 * @param outputStream a {@link java.io.OutputStream} object.
	 * @param imageType a {@link net.sf.dynamicreports.jasper.constant.ImageType} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperImageExporterBuilder} object.
	 */
	public static JasperImageExporterBuilder imageExporter(OutputStream outputStream, ImageType imageType) {
		return new JasperImageExporterBuilder().setOutputStream(outputStream).setImageType(imageType);
	}

	/**
	 * <p>imageExporter.</p>
	 *
	 * @param outputFile a {@link java.io.File} object.
	 * @param imageType a {@link net.sf.dynamicreports.jasper.constant.ImageType} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperImageExporterBuilder} object.
	 */
	public static JasperImageExporterBuilder imageExporter(File outputFile, ImageType imageType) {
		return new JasperImageExporterBuilder().setOutputFile(outputFile).setImageType(imageType);
	}

	/**
	 * <p>imageExporter.</p>
	 *
	 * @param outputFileName a {@link java.lang.String} object.
	 * @param imageType a {@link net.sf.dynamicreports.jasper.constant.ImageType} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperImageExporterBuilder} object.
	 */
	public static JasperImageExporterBuilder imageExporter(String outputFileName, ImageType imageType) {
		return new JasperImageExporterBuilder().setOutputFileName(outputFileName).setImageType(imageType);
	}
}

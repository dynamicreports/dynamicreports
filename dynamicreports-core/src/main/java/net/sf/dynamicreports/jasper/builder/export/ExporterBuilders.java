/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
 * @author Ricardo Mariaca
 *
 */
public class ExporterBuilders {

    // csv

    /**
     * <p>csvExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder} object.
     */
    public JasperCsvExporterBuilder csvExporter(Writer outputWriter) {
        return Exporters.csvExporter(outputWriter);
    }

    /**
     * <p>csvExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder} object.
     */
    public JasperCsvExporterBuilder csvExporter(OutputStream outputStream) {
        return Exporters.csvExporter(outputStream);
    }

    /**
     * <p>csvExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder} object.
     */
    public JasperCsvExporterBuilder csvExporter(File outputFile) {
        return Exporters.csvExporter(outputFile);
    }

    /**
     * <p>csvExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder} object.
     */
    public JasperCsvExporterBuilder csvExporter(String outputFileName) {
        return Exporters.csvExporter(outputFileName);
    }

    // docx

    /**
     * <p>docxExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperDocxExporterBuilder} object.
     */
    public JasperDocxExporterBuilder docxExporter(Writer outputWriter) {
        return Exporters.docxExporter(outputWriter);
    }

    /**
     * <p>docxExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperDocxExporterBuilder} object.
     */
    public JasperDocxExporterBuilder docxExporter(OutputStream outputStream) {
        return Exporters.docxExporter(outputStream);
    }

    /**
     * <p>docxExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperDocxExporterBuilder} object.
     */
    public JasperDocxExporterBuilder docxExporter(File outputFile) {
        return Exporters.docxExporter(outputFile);
    }

    /**
     * <p>docxExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperDocxExporterBuilder} object.
     */
    public JasperDocxExporterBuilder docxExporter(String outputFileName) {
        return Exporters.docxExporter(outputFileName);
    }

    // html

    /**
     * <p>htmlExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder} object.
     */
    public JasperHtmlExporterBuilder htmlExporter(Writer outputWriter) {
        return Exporters.htmlExporter(outputWriter);
    }

    /**
     * <p>htmlExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder} object.
     */
    public JasperHtmlExporterBuilder htmlExporter(OutputStream outputStream) {
        return Exporters.htmlExporter(outputStream);
    }

    /**
     * <p>htmlExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder} object.
     */
    public JasperHtmlExporterBuilder htmlExporter(File outputFile) {
        return Exporters.htmlExporter(outputFile);
    }

    /**
     * <p>htmlExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder} object.
     */
    public JasperHtmlExporterBuilder htmlExporter(String outputFileName) {
        return Exporters.htmlExporter(outputFileName);
    }

    // json

    /**
     * <p>htmlExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperJsonExporterBuilder} object.
     */
    public JasperJsonExporterBuilder jsonExporter(Writer outputWriter) {
        return Exporters.jsonExporter(outputWriter);
    }

    /**
     * <p>htmlExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperJsonExporterBuilder} object.
     */
    public JasperJsonExporterBuilder jsonExporter(OutputStream outputStream) {
        return Exporters.jsonExporter(outputStream);
    }

    /**
     * <p>htmlExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperJsonExporterBuilder} object.
     */
    public JasperJsonExporterBuilder jsonExporter(File outputFile) {
        return Exporters.jsonExporter(outputFile);
    }

    /**
     * <p>htmlExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperJsonExporterBuilder} object.
     */
    public JasperJsonExporterBuilder jsonExporter(String outputFileName) {
        return Exporters.jsonExporter(outputFileName);
    }

    // ods

    /**
     * <p>odsExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdsExporterBuilder} object.
     */
    public JasperOdsExporterBuilder odsExporter(Writer outputWriter) {
        return Exporters.odsExporter(outputWriter);
    }

    /**
     * <p>odsExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdsExporterBuilder} object.
     */
    public JasperOdsExporterBuilder odsExporter(OutputStream outputStream) {
        return Exporters.odsExporter(outputStream);
    }

    /**
     * <p>odsExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdsExporterBuilder} object.
     */
    public JasperOdsExporterBuilder odsExporter(File outputFile) {
        return Exporters.odsExporter(outputFile);
    }

    /**
     * <p>odsExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdsExporterBuilder} object.
     */
    public JasperOdsExporterBuilder odsExporter(String outputFileName) {
        return Exporters.odsExporter(outputFileName);
    }

    // odt

    /**
     * <p>odtExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdtExporterBuilder} object.
     */
    public JasperOdtExporterBuilder odtExporter(Writer outputWriter) {
        return Exporters.odtExporter(outputWriter);
    }

    /**
     * <p>odtExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdtExporterBuilder} object.
     */
    public JasperOdtExporterBuilder odtExporter(OutputStream outputStream) {
        return Exporters.odtExporter(outputStream);
    }

    /**
     * <p>odtExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdtExporterBuilder} object.
     */
    public JasperOdtExporterBuilder odtExporter(File outputFile) {
        return Exporters.odtExporter(outputFile);
    }

    /**
     * <p>odtExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperOdtExporterBuilder} object.
     */
    public JasperOdtExporterBuilder odtExporter(String outputFileName) {
        return Exporters.odtExporter(outputFileName);
    }

    // pdf

    /**
     * <p>pdfExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder pdfExporter(Writer outputWriter) {
        return Exporters.pdfExporter(outputWriter);
    }

    /**
     * <p>pdfExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder pdfExporter(OutputStream outputStream) {
        return Exporters.pdfExporter(outputStream);
    }

    /**
     * <p>pdfExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder pdfExporter(File outputFile) {
        return Exporters.pdfExporter(outputFile);
    }

    /**
     * <p>pdfExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder pdfExporter(String outputFileName) {
        return Exporters.pdfExporter(outputFileName);
    }

    // rtf

    /**
     * <p>rtfExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperRtfExporterBuilder} object.
     */
    public JasperRtfExporterBuilder rtfExporter(Writer outputWriter) {
        return Exporters.rtfExporter(outputWriter);
    }

    /**
     * <p>rtfExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperRtfExporterBuilder} object.
     */
    public JasperRtfExporterBuilder rtfExporter(OutputStream outputStream) {
        return Exporters.rtfExporter(outputStream);
    }

    /**
     * <p>rtfExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperRtfExporterBuilder} object.
     */
    public JasperRtfExporterBuilder rtfExporter(File outputFile) {
        return Exporters.rtfExporter(outputFile);
    }

    /**
     * <p>rtfExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperRtfExporterBuilder} object.
     */
    public JasperRtfExporterBuilder rtfExporter(String outputFileName) {
        return Exporters.rtfExporter(outputFileName);
    }

    // text

    /**
     * <p>textExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    public JasperTextExporterBuilder textExporter(Writer outputWriter) {
        return Exporters.textExporter(outputWriter);
    }

    /**
     * <p>textExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    public JasperTextExporterBuilder textExporter(OutputStream outputStream) {
        return Exporters.textExporter(outputStream);
    }

    /**
     * <p>textExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    public JasperTextExporterBuilder textExporter(File outputFile) {
        return Exporters.textExporter(outputFile);
    }

    /**
     * <p>textExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    public JasperTextExporterBuilder textExporter(String outputFileName) {
        return Exporters.textExporter(outputFileName);
    }

    // xls

    /**
     * <p>xlsExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder} object.
     */
    public JasperXlsExporterBuilder xlsExporter(Writer outputWriter) {
        return Exporters.xlsExporter(outputWriter);
    }

    /**
     * <p>xlsExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder} object.
     */
    public JasperXlsExporterBuilder xlsExporter(OutputStream outputStream) {
        return Exporters.xlsExporter(outputStream);
    }

    /**
     * <p>xlsExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder} object.
     */
    public JasperXlsExporterBuilder xlsExporter(File outputFile) {
        return Exporters.xlsExporter(outputFile);
    }

    /**
     * <p>xlsExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsExporterBuilder} object.
     */
    public JasperXlsExporterBuilder xlsExporter(String outputFileName) {
        return Exporters.xlsExporter(outputFileName);
    }

    // xlsx

    /**
     * <p>xlsxExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder} object.
     */
    public JasperXlsxExporterBuilder xlsxExporter(Writer outputWriter) {
        return Exporters.xlsxExporter(outputWriter);
    }

    /**
     * <p>xlsxExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder} object.
     */
    public JasperXlsxExporterBuilder xlsxExporter(OutputStream outputStream) {
        return Exporters.xlsxExporter(outputStream);
    }

    /**
     * <p>xlsxExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder} object.
     */
    public JasperXlsxExporterBuilder xlsxExporter(File outputFile) {
        return Exporters.xlsxExporter(outputFile);
    }

    /**
     * <p>xlsxExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder} object.
     */
    public JasperXlsxExporterBuilder xlsxExporter(String outputFileName) {
        return Exporters.xlsxExporter(outputFileName);
    }

    // xml

    /**
     * <p>xmlExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXmlExporterBuilder} object.
     */
    public JasperXmlExporterBuilder xmlExporter(Writer outputWriter) {
        return Exporters.xmlExporter(outputWriter);
    }

    /**
     * <p>xmlExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXmlExporterBuilder} object.
     */
    public JasperXmlExporterBuilder xmlExporter(OutputStream outputStream) {
        return Exporters.xmlExporter(outputStream);
    }

    /**
     * <p>xmlExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXmlExporterBuilder} object.
     */
    public JasperXmlExporterBuilder xmlExporter(File outputFile) {
        return Exporters.xmlExporter(outputFile);
    }

    /**
     * <p>xmlExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXmlExporterBuilder} object.
     */
    public JasperXmlExporterBuilder xmlExporter(String outputFileName) {
        return Exporters.xmlExporter(outputFileName);
    }

    // pptx

    /**
     * <p>pptxExporter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPptxExporterBuilder} object.
     */
    public JasperPptxExporterBuilder pptxExporter(Writer outputWriter) {
        return Exporters.pptxExporter(outputWriter);
    }

    /**
     * <p>pptxExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPptxExporterBuilder} object.
     */
    public JasperPptxExporterBuilder pptxExporter(OutputStream outputStream) {
        return Exporters.pptxExporter(outputStream);
    }

    /**
     * <p>pptxExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPptxExporterBuilder} object.
     */
    public JasperPptxExporterBuilder pptxExporter(File outputFile) {
        return Exporters.pptxExporter(outputFile);
    }

    /**
     * <p>pptxExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPptxExporterBuilder} object.
     */
    public JasperPptxExporterBuilder pptxExporter(String outputFileName) {
        return Exporters.pptxExporter(outputFileName);
    }

    // image

    /**
     * <p>imageExporter.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @param imageType    a {@link net.sf.dynamicreports.jasper.constant.ImageType} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperImageExporterBuilder} object.
     */
    public JasperImageExporterBuilder imageExporter(OutputStream outputStream, ImageType imageType) {
        return Exporters.imageExporter(outputStream, imageType);
    }

    /**
     * <p>imageExporter.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @param imageType  a {@link net.sf.dynamicreports.jasper.constant.ImageType} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperImageExporterBuilder} object.
     */
    public JasperImageExporterBuilder imageExporter(File outputFile, ImageType imageType) {
        return Exporters.imageExporter(outputFile, imageType);
    }

    /**
     * <p>imageExporter.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @param imageType      a {@link net.sf.dynamicreports.jasper.constant.ImageType} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperImageExporterBuilder} object.
     */
    public JasperImageExporterBuilder imageExporter(String outputFileName, ImageType imageType) {
        return Exporters.imageExporter(outputFileName, imageType);
    }
}

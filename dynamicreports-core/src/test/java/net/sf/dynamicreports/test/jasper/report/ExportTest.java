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
package net.sf.dynamicreports.test.jasper.report;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.concatenatedReport;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;

import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import net.sf.dynamicreports.jasper.builder.JasperConcatenatedReportBuilder;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.constant.ImageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca
 */
public class ExportTest {
    static JasperReportBuilder report;
    static JasperConcatenatedReportBuilder concatenatedReport;

    @BeforeAll
    public static void init() {
        report = report();
        report.columns(col.column("Column1", "field1", String.class));
        report.setDataSource(createDataSource());

        concatenatedReport = concatenatedReport();
        concatenatedReport.concatenate(report, report, report);
    }

    @Test
    public void exportTest() {
        try {
            report.toJrXml(new ByteArrayOutputStream());
            report.toImage(new ByteArrayOutputStream(), ImageType.PNG);
            report.toCsv(new ByteArrayOutputStream());
            report.toDocx(new ByteArrayOutputStream());
            report.toHtml(new ByteArrayOutputStream());
            report.toOds(new ByteArrayOutputStream());
            report.toOdt(new ByteArrayOutputStream());
            report.toPdf(new ByteArrayOutputStream());
            report.toRtf(new ByteArrayOutputStream());
            report.toText(new ByteArrayOutputStream());
            report.toXls(new ByteArrayOutputStream());
            report.toXlsx(new ByteArrayOutputStream());
            report.toXml(new ByteArrayOutputStream());
            report.toPptx(new ByteArrayOutputStream());
        } catch (final DRException e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void concatenatedExportTest() {
        try {
            concatenatedReport.toPng(new ByteArrayOutputStream());
            concatenatedReport.toCsv(new ByteArrayOutputStream());
            concatenatedReport.toDocx(new ByteArrayOutputStream());
            concatenatedReport.toHtml(new ByteArrayOutputStream());
            concatenatedReport.toOds(new ByteArrayOutputStream());
            concatenatedReport.toOdt(new ByteArrayOutputStream());
            concatenatedReport.toPdf(new ByteArrayOutputStream());
            concatenatedReport.toRtf(new ByteArrayOutputStream());
            concatenatedReport.toText(new ByteArrayOutputStream());
            concatenatedReport.toXls(new ByteArrayOutputStream());
            concatenatedReport.toXlsx(new ByteArrayOutputStream());
            concatenatedReport.toXml(new ByteArrayOutputStream());
            concatenatedReport.toPptx(new ByteArrayOutputStream());
        } catch (final DRException e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }
    }

    private static JRDataSource createDataSource() {
        final DRDataSource dataSource = new DRDataSource("field1");
        dataSource.add("field1");
        return dataSource;
    }
}

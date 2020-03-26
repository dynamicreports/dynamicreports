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
package net.sf.dynamicreports.test.jasper.templatedesign;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;

import java.io.InputStream;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;

/**
 * @author Ricardo Mariaca
 */
public class TemplateDesign5Test extends AbstractJasperValueTest {
    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<Integer> column2;

    @Override
    protected void configureReport(JasperReportBuilder rb) throws DRException {
        InputStream is = TemplateDesign5Test.class.getResourceAsStream("templatedesign5.jrxml");
        JasperReportBuilder report = report();
        report.setTemplateDesign(is);
        report.addParameter("parameter", "parametertest");
        report.setDataSource(new JREmptyDataSource(1));
        report.setPageFormat(575, 842, PageOrientation.PORTRAIT);

        rb.title(cmp.subreport(report)).columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class));
    }

    @Override
    protected boolean serializableTest() {
        return false;
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        columnTitleValueTest(column1, "Column1");
        columnDetailValueTest(column1, "row0", "row1");
        columnTitleValueTest(column2, "Column2");
        columnDetailValueTest(column2, "0", "1");

        elementValueTest("templateDesign.title1", "title");
        elementValueTest("templateDesign.title2", "parametertest");
        elementValueTest("templateDesign.pageHeader", "pageHeader");
        elementValueTest("templateDesign.pageFooter", "pageFooter");
        elementValueTest("templateDesign.detail", "detail");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 2; i++) {
            dataSource.add("row" + i, i);
        }
        return dataSource;
    }
}

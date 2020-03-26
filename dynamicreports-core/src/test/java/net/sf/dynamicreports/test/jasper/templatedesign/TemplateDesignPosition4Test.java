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
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.InputStream;
import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.margin;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;

/**
 * @author Ricardo Mariaca
 */
public class TemplateDesignPosition4Test extends AbstractJasperPositionTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<Integer> column2;

    @Override
    protected void configureReport(JasperReportBuilder rb) throws DRException {
        InputStream is = TemplateDesignPosition4Test.class.getResourceAsStream("templatedesign1.jrxml");
        JasperReportBuilder report = report();
        report.setTemplateDesign(is)
              .setPageMargin(margin(25))
              .columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class))
              .setDataSource(createSubreportDataSource());
        rb.setPageMargin(margin(25)).title(cmp.subreport(report));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementPositionTest("columnHeader.list1", 0, 50, 164, 495, 16);
        columnTitlePositionTest(column1, 0, 0, 0, 247, 16);
        columnTitlePositionTest(column2, 0, 247, 0, 248, 16);
        elementPositionTest("detail.list1", 0, 50, 201, 495, 16);
        columnDetailPositionTest(column1, 0, 0, 0, 247, 16);
        columnDetailPositionTest(column2, 0, 247, 0, 248, 16);
        elementPositionTest("detail.list1", 1, 50, 238, 495, 16);
        columnDetailPositionTest(column1, 1, 0, 0, 247, 16);
        columnDetailPositionTest(column2, 1, 247, 0, 248, 16);

        elementPositionTest("templateDesign.title1", 0, 176, 78, 100, 20);
        elementPositionTest("templateDesign.pageHeader", 0, 176, 142, 100, 20);
        elementPositionTest("templateDesign.pageFooter", 0, 176, 358, 100, 20);
        elementPositionTest("templateDesign.detail", 0, 176, 180, 100, 20);
    }

    private JRDataSource createSubreportDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 2; i++) {
            dataSource.add("row" + i, i);
        }
        return dataSource;
    }
}

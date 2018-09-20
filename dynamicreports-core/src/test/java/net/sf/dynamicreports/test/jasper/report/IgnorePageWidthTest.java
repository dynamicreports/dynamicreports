/*
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
package net.sf.dynamicreports.test.jasper.report;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class IgnorePageWidthTest extends AbstractJasperPositionTest {
    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<String> column2;
    private TextColumnBuilder<String> column3;
    private TextColumnBuilder<String> column4;
    private TextColumnBuilder<String> column5;
    private TextColumnBuilder<String> column6;
    private TextColumnBuilder<String> column7;
    private TextColumnBuilder<String> column8;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.ignorePageWidth()
          .title(cmp.text("text"))
          .columns(column1 = col.column("Column2", "field1", String.class), column2 = col.column("Column2", "field2", String.class), column3 = col.column("Column3", "field3", String.class), column4 =
                       col.column("Column4", "field4", String.class)
                          .setWidth(150), column5 = col.column("Column5", "field5", String.class)
                                                       .setFixedWidth(50), column6 = col.column("Column6", "field6", String.class), column7 = col.column("Column7", "field7", String.class),
                   column8 = col.column("Column8", "field8", String.class));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementPositionTest("title.textField1", 0, 10, 10, 800, 16);
        elementPositionTest("columnHeader.list1", 0, 10, 26, 800, 16);

        // column1
        columnTitlePositionTest(column1, 0, 0, 0, 100, 16);
        columnDetailPositionTest(column1, 0, 0, 0, 100, 16);
        // column2
        columnTitlePositionTest(column2, 0, 100, 0, 100, 16);
        columnDetailPositionTest(column2, 0, 100, 0, 100, 16);
        // column3
        columnTitlePositionTest(column3, 0, 200, 0, 100, 16);
        columnDetailPositionTest(column3, 0, 200, 0, 100, 16);
        // column4
        columnTitlePositionTest(column4, 0, 300, 0, 150, 16);
        columnDetailPositionTest(column4, 0, 300, 0, 150, 16);
        // column5
        columnTitlePositionTest(column5, 0, 450, 0, 50, 16);
        columnDetailPositionTest(column5, 0, 450, 0, 50, 16);
        // column6
        columnTitlePositionTest(column6, 0, 500, 0, 100, 16);
        columnDetailPositionTest(column6, 0, 500, 0, 100, 16);
        // column7
        columnTitlePositionTest(column7, 0, 600, 0, 100, 16);
        columnDetailPositionTest(column7, 0, 600, 0, 100, 16);
        // column8
        columnTitlePositionTest(column8, 0, 700, 0, 100, 16);
        columnDetailPositionTest(column8, 0, 700, 0, 100, 16);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5", "field6", "field7", "field8");
        dataSource.add("text", "text", "text", "text", "text", "text", "text", "text");
        return dataSource;
    }
}

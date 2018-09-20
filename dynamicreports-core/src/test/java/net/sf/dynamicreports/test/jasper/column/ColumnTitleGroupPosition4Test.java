/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.test.jasper.column;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grid;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ColumnTitleGroupPosition4Test extends AbstractJasperPositionTest {
    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<Integer> column2;
    private TextColumnBuilder<String> column3;
    private TextColumnBuilder<String> column4;
    private TextColumnBuilder<String> column5;
    private AggregationSubtotalBuilder<Integer> subtotal1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        column1 = col.column("Col1", "field1", String.class);
        column2 = col.column("Col2", "field2", Integer.class);
        column3 = col.column("Col3", "field3", String.class);
        column4 = col.column("Col4", "field4", String.class);
        column5 = col.column("Col5", "field5", String.class);

        rb.columnGrid(column1, grid.titleGroup("Group1", column2, column3)
                                   .setTitleFixedWidth(400), grid.titleGroup("Group2", column4, column5)
                                                                 .setTitleFixedWidth(80))
          .columns(column1, column2, column3, column4, column5)
          .subtotalsAtSummary(subtotal1 = sbt.sum(column2));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementPositionTest("columnHeader.list1", 0, 10, 10, 575, 32);
        elementPositionTest("columnHeader.list3", 0, 95, 16, 400, 16);
        elementPositionTest("columnHeader.list5", 0, 495, 16, 80, 16);
        elementPositionTest("columnHeader.columngroup.title1", 0, 95, 0, 400, 16);
        elementPositionTest("columnHeader.columngroup.title2", 0, 495, 0, 80, 16);
        // column1
        columnTitlePositionTest(column1, 0, 0, 0, 95, 32);
        columnDetailPositionTest(column1, 0, 0, 0, 95, 16);
        // column2
        columnTitlePositionTest(column2, 0, 0, 0, 200, 16);
        columnDetailPositionTest(column2, 0, 95, 0, 200, 16);
        // column3
        columnTitlePositionTest(column3, 0, 200, 0, 200, 16);
        columnDetailPositionTest(column3, 0, 295, 0, 200, 16);
        // column4
        columnTitlePositionTest(column4, 0, 0, 0, 40, 16);
        columnDetailPositionTest(column4, 0, 495, 0, 40, 16);
        // column5
        columnTitlePositionTest(column5, 0, 40, 0, 40, 16);
        columnDetailPositionTest(column5, 0, 535, 0, 40, 16);
        // subtotal
        subtotalPositionTest(subtotal1, 0, 95, 0, 200, 16);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5");
        dataSource.add("text", 1, "text");
        return dataSource;
    }
}

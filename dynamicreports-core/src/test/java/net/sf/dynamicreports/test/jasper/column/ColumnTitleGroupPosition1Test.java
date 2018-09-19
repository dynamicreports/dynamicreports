/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
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
public class ColumnTitleGroupPosition1Test extends AbstractJasperPositionTest {
    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<String> column2;
    private TextColumnBuilder<Integer> column3;
    private TextColumnBuilder<String> column4;
    private AggregationSubtotalBuilder<Integer> subtotal1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        column1 = col.column("Column1", "field1", String.class);
        column2 = col.column("Column2", "field2", String.class);
        column3 = col.column("Column3", "field3", Integer.class);
        column4 = col.column("Column4", "field4", String.class);

        rb.columnGrid(column1, grid.titleGroup("Group1", column2, grid.titleGroup("group2", column3, column4)))
          .columns(column1, column2, column3, column4)
          .subtotalsAtSummary(subtotal1 = sbt.sum(column3));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementPositionTest("columnHeader.list1", 0, 10, 10, 575, 48);
        elementPositionTest("columnHeader.list3", 0, 143, 16, 432, 32);
        elementPositionTest("columnHeader.list5", 0, 144, 16, 288, 16);
        elementPositionTest("columnHeader.columngroup.title1", 0, 143, 0, 432, 16);
        elementPositionTest("columnHeader.columngroup.title2", 0, 144, 0, 288, 16);
        // column1
        columnTitlePositionTest(column1, 0, 0, 0, 143, 48);
        columnDetailPositionTest(column1, 0, 0, 0, 143, 26);
        // column2
        columnTitlePositionTest(column2, 0, 0, 0, 144, 32);
        columnDetailPositionTest(column2, 0, 143, 0, 144, 26);
        // column3
        columnTitlePositionTest(column3, 0, 0, 0, 144, 16);
        columnDetailPositionTest(column3, 0, 287, 0, 144, 26);
        // column4
        columnTitlePositionTest(column4, 0, 144, 0, 144, 16);
        columnDetailPositionTest(column4, 0, 431, 0, 144, 26);
        // subtotal
        subtotalPositionTest(subtotal1, 0, 287, 0, 144, 16);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4");
        dataSource.add("text", "text text text text text text text text", 1, "text");
        return dataSource;
    }
}

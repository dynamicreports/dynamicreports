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
package net.sf.dynamicreports.test.jasper.column;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grid;

/**
 * @author Ricardo Mariaca
 */
public class ColumnTitleGroupPosition6Test extends AbstractJasperPositionTest {
    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<Integer> column2;
    private TextColumnBuilder<String> column3;
    private TextColumnBuilder<String> column4;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        column1 = col.column("field1", String.class);
        column2 = col.column("field2", Integer.class);
        column3 = col.column("field3", String.class).setFixedWidth(50);
        column4 = col.column("field4", String.class);

        rb.columnGrid(column1, grid.titleGroup("Group 1", column2), grid.titleGroup("Group 2", column3, column4)).columns(column1, column2, column3, column4);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementPositionTest("columnHeader.list1", 0, 10, 10, 575, 16);
        elementPositionTest("columnHeader.columngroup.title1", 0, 164, 0, 164, 16);
        elementPositionTest("columnHeader.columngroup.title2", 0, 328, 0, 247, 16);
        // column1
        columnDetailPositionTest(column1, 0, 0, 0, 164, 16);
        // column2
        columnDetailPositionTest(column2, 0, 164, 0, 164, 16);
        // column3
        columnDetailPositionTest(column3, 0, 328, 0, 50, 16);
        // column4
        columnDetailPositionTest(column4, 0, 378, 0, 197, 16);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4");
        dataSource.add("text", 1, "text", "text");
        return dataSource;
    }
}

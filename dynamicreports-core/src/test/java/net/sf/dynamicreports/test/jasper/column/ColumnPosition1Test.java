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
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca
 */
public class ColumnPosition1Test extends AbstractJasperPositionTest {
    private TextColumnBuilder<String> column2;
    private TextColumnBuilder<Integer> column3;
    private TextColumnBuilder<Integer> column4;
    private TextColumnBuilder<Integer> column5;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.addField("field1", type.integerType())
          .columns(column2 = col.column("Very long Column2 title", "field2", String.class).setFixedWidth(70), column3 = col.column("Column3", "field3", Integer.class),
                   column4 = col.column("Column4", "field4", Integer.class), column5 = col.column("Column5", "field5", Integer.class));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);
        elementPositionTest("columnHeader.list1", 0, 10, 10, 575, 26);
        elementPositionTest("detail.list1", 0, 10, 36, 575, 16);
        elementPositionTest("detail.list1", 1, 10, 52, 575, 26);

        // column2
        columnTitlePositionTest(column2, 0, 0, 0, 70, 26);
        columnDetailPositionTest(column2, 0, 0, 0, 70, 16);
        columnDetailPositionTest(column2, 1, 0, 0, 70, 26);
        // column3
        columnTitlePositionTest(column3, 0, 70, 0, 168, 26);
        columnDetailPositionTest(column3, 0, 70, 0, 168, 16);
        columnDetailPositionTest(column3, 1, 70, 0, 168, 26);
        // column4
        columnTitlePositionTest(column4, 0, 238, 0, 168, 26);
        columnDetailPositionTest(column4, 0, 238, 0, 168, 16);
        columnDetailPositionTest(column4, 1, 238, 0, 168, 26);
        // column5
        columnTitlePositionTest(column5, 0, 406, 0, 169, 26);
        columnDetailPositionTest(column5, 0, 406, 0, 169, 16);
        columnDetailPositionTest(column5, 1, 406, 0, 169, 26);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5");
        dataSource.add(1, "2", 3, 4, 5);
        dataSource.add(1, "very very very long value 2", 3, 4, 5);
        return dataSource;
    }
}

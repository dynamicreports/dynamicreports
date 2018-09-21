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
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.util.ArrayList;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Column2Test extends AbstractJasperValueTest {
    private TextColumnBuilder<Integer> column1;
    private TextColumnBuilder<Integer> column2;
    private TextColumnBuilder<Integer> column3;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.setPageColumnsPerPage(2)
          .fields(field("field1", Integer.class))
          .columns(column1 = col.reportRowNumberColumn("Column1")
                                .setWidth(50), column2 = col.pageRowNumberColumn("Column2")
                                                            .setWidth(50), column3 = col.columnRowNumberColumn("Column3")
                                                                                        .setWidth(50));
    }

    @Override
    public void test() {
        super.test();

        List<String> rows = new ArrayList<String>();
        for (int i = 0; i < 110; i++) {
            rows.add(String.valueOf(i + 1));
        }
        List<String> pageRows = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            pageRows.add(String.valueOf(i + 1));
        }
        for (int i = 0; i < 10; i++) {
            pageRows.add(String.valueOf(i + 1));
        }
        List<String> columnRows = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            columnRows.add(String.valueOf(i + 1));
        }
        for (int i = 0; i < 50; i++) {
            columnRows.add(String.valueOf(i + 1));
        }
        for (int i = 0; i < 10; i++) {
            columnRows.add(String.valueOf(i + 1));
        }

        numberOfPagesTest(2);
        // column1
        columnDetailCountTest(column1, 110);
        columnDetailValueTest(column1, rows.toArray(new String[] {}));
        columnTitleCountTest(column1, 3);
        columnTitleValueTest(column1, "Column1", "Column1", "Column1");
        // column2
        columnDetailCountTest(column2, 110);
        columnDetailValueTest(column2, pageRows.toArray(new String[] {}));
        columnTitleCountTest(column2, 3);
        columnTitleValueTest(column2, "Column2", "Column2", "Column2");
        // column3
        columnDetailCountTest(column3, 110);
        columnDetailValueTest(column3, columnRows.toArray(new String[] {}));
        columnTitleCountTest(column3, 3);
        columnTitleValueTest(column3, "Column3", "Column3", "Column3");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1");
        for (int i = 0; i < 110; i++) {
            dataSource.add(i);
        }
        return dataSource;
    }
}

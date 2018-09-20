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
package net.sf.dynamicreports.test.jasper.column;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Column4Test extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<Integer> column2;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.columns(column1 = col.column("Column1", "field1", type.stringType())
                                .setPrintRepeatedDetailValues(false)
                                .setPrintInFirstWholeBand(true), column2 = col.column("Column2", "field2", type.integerType()));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(2);
        // column1
        columnDetailCountTest(column1, 3);
        columnDetailValueTest(column1, "test1", "test2", "test2");
        columnTitleCountTest(column1, 2);
        columnTitleValueTest(column1, "Column1", "Column1");
        // column2
        columnDetailCountTest(column2, 60);
        columnDetailValueTest(column2, 0, "0");
        columnTitleCountTest(column2, 2);
        columnTitleValueTest(column2, "Column2", "Column2");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 30; i++) {
            dataSource.add("test1", i);
        }
        for (int i = 0; i < 30; i++) {
            dataSource.add("test2", i);
        }
        return dataSource;
    }
}

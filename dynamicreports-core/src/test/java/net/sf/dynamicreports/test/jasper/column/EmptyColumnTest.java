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
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class EmptyColumnTest extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<String> column2;
    private TextColumnBuilder<String> column3;
    private TextColumnBuilder<String> column4;
    private TextColumnBuilder<String> column5;
    private TextColumnBuilder<String> column6;
    private TextColumnBuilder<String> column7;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.columns(column1 = col.column("Column1", "field1", String.class), column2 = col.emptyColumn(), column3 = col.column("Column3", "field3", String.class),
                   column4 = col.emptyColumn(false, true), column5 = col.emptyColumn(true, false), column6 = col.emptyColumn(true, true), column7 = col.column("Column7", "field7", String.class));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // column1
        columnDetailCountTest(column1, 1);
        columnDetailValueTest(column1, "test1");
        columnTitleCountTest(column1, 1);
        columnTitleValueTest(column1, "Column1");

        // column2
        columnDetailCountTest(column2, 0);
        columnTitleCountTest(column2, 0);

        // column3
        columnDetailCountTest(column3, 1);
        columnDetailValueTest(column3, "test3");
        columnTitleCountTest(column3, 1);
        columnTitleValueTest(column3, "Column3");

        // column4
        columnDetailCountTest(column4, 1);
        columnDetailValueTest(column4, "");
        columnTitleCountTest(column4, 0);

        // column5
        columnDetailCountTest(column5, 0);
        columnTitleCountTest(column5, 1);
        columnTitleValueTest(column5, "");

        // column6
        columnDetailCountTest(column6, 1);
        columnDetailValueTest(column6, "");
        columnTitleCountTest(column6, 1);
        columnTitleValueTest(column6, "");

        // column7
        columnDetailCountTest(column7, 1);
        columnDetailValueTest(column7, "test7");
        columnTitleCountTest(column7, 1);
        columnTitleValueTest(column7, "Column7");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5", "field6", "field7");
        dataSource.add("test1", "test2", "test3", "test4", "test5", "test6", "test7");
        return dataSource;
    }
}

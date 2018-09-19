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

package net.sf.dynamicreports.test.jasper.tableofcontents;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class TableOfContents7Test extends AbstractJasperValueTest {
    private ColumnGroupBuilder group1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1 = col.column("Column1", "field1", type.stringType());
        group1 = grp.group(column1)
                    .setReprintHeaderOnEachPage(true);

        rb.tableOfContents()
          .columns(column1, col.column("Column2", "field2", type.stringType()))
          .groupBy(group1);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(3);

        elementCountTest("detail.textField1", 3);
        elementValueTest("detail.textField1", "value1", "value2", "value3");

        groupHeaderCountTest(group1, 4);
        groupHeaderValueTest(group1, "value1", "value2", "value2", "value3");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 30; i++) {
            dataSource.add("value1", "text");
        }
        for (int i = 0; i < 30; i++) {
            dataSource.add("value2", "text");
        }
        for (int i = 0; i < 30; i++) {
            dataSource.add("value3", "text");
        }
        return dataSource;
    }
}

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
package net.sf.dynamicreports.test.jasper.group;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Group3Test extends AbstractJasperValueTest {
    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<String> column2;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.setShowColumnTitle(false)
          .columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", String.class))
          .groupBy(grp.group(column1).setShowColumnHeaderAndFooter(true));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        columnTitleCountTest(column1, 0);
        columnTitleCountTest(column2, 0);

        elementCountTest("columnHeaderForGroup.column_field2.title1", 1);
        elementValueTest("columnHeaderForGroup.column_field2.title1", "Column2");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 1; i++) {
            dataSource.add("1", "1");
        }
        return dataSource;
    }
}

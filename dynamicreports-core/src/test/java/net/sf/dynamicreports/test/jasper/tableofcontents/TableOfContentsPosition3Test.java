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
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.margin;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class TableOfContentsPosition3Test extends AbstractJasperPositionTest {
    private TextColumnBuilder<String> column1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.setPageFormat(PageType.A6, PageOrientation.LANDSCAPE)
          .setPageMargin(margin(10).setLeft(30))
          .tableOfContents()
          .columns(column1 = col.column("Column1", "field1", type.stringType()), col.column("Column2", "field2", type.stringType()))
          .groupBy(column1);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(5);

        elementPositionTest("title.textField1", 0, 30, 10, 381, 19);

        for (int i = 0; i < 14; i++) {
            elementPositionTest("detail.list2", i, 30, 49 + 16 * i, 381, 16);
            elementPositionTest("detail.textField1", i, 0, 0, 179, 16);
            elementPositionTest("detail.textField2", i, 179, 0, 180, 16);
            elementPositionTest("detail.textField3", i, 359, 0, 22, 16);
        }
        for (int i = 14; i < 20; i++) {
            elementPositionTest("detail.list2", i, 30, 10 + 16 * (i - 14), 381, 16);
            elementPositionTest("detail.textField1", i, 0, 0, 179, 16);
            elementPositionTest("detail.textField2", i, 179, 0, 180, 16);
            elementPositionTest("detail.textField3", i, 359, 0, 22, 16);
        }

        containsElement("title.textField1", 0);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 20; i++) {
            dataSource.add("value" + i, "text");
        }
        return dataSource;
    }
}

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
package net.sf.dynamicreports.test.jasper.component;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.TextAdjust;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Jan Moxter
 */
public class TextField6Test extends AbstractJasperPositionTest {
    private TextColumnBuilder<String> column1;

    @Override
    protected void configureReport(final JasperReportBuilder rb) {
        rb.columns(column1 = col.column("test test", "field1", String.class)
                        .setFixedWidth(25)
                        .setTextAdjust(TextAdjust.CUT_TEXT)
                        .setTitleTextAdjust(TextAdjust.CUT_TEXT))
          .title(cmp.text("test test").setFixedWidth(25)
                          .setTextAdjust(TextAdjust.CUT_TEXT), cmp.text("test test").setFixedWidth(25));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementPositionTest("title.textField1", 0, 10, 10, 25, 16);
        elementPositionTest("title.textField2", 0, 10, 26, 25, 26);

        columnTitlePositionTest(column1, 0, 10, 52, 25, 16);
        columnDetailPositionTest(column1, 0, 10, 68, 25, 16);
    }

    @Override
    protected JRDataSource createDataSource() {
        final DRDataSource dataSource = new DRDataSource("field1");
        dataSource.add("test test");
        return dataSource;
    }
}

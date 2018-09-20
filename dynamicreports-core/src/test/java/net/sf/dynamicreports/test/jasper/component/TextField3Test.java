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
package net.sf.dynamicreports.test.jasper.component;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.constant.JasperProperty;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class TextField3Test extends AbstractJasperValueTest {
    private TextColumnBuilder<String> column1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.columns(column1 = col.column("test test", "field1", String.class)
                                .setFixedWidth(25)
                                .setStretchWithOverflow(false)
                                .addProperty(JasperProperty.PRINT_KEEP_FULL_TEXT, "true")
                                .setTitleStretchWithOverflow(false)
                                .addTitleProperty(JasperProperty.PRINT_KEEP_FULL_TEXT, "true"))
          .title(cmp.text("test test")
                    .setFixedWidth(25)
                    .setStretchWithOverflow(false)
                    .addProperty(JasperProperty.PRINT_KEEP_FULL_TEXT, "true"), cmp.text("test test")
                                                                                  .setFixedWidth(25), cmp.text("test test")
                                                                                                         .setFixedWidth(25)
                                                                                                         .setStretchWithOverflow(false));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementValueTest("title.textField1", 0, "test ");
        elementFullValueTest("title.textField1", 0, "test test");
        elementValueTest("title.textField2", 0, "test test");
        elementValueTest("title.textField3", 0, "test ");
        elementFullValueTest("title.textField3", 0, "test ");

        columnTitleValueTest(column1, 0, "test ");
        columnTitleFullValueTest(column1, 0, "test test");

        columnDetailValueTest(column1, 0, "test ");
        columnDetailFullValueTest(column1, 0, "test test");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1");
        dataSource.add("test test");
        return dataSource;
    }
}

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
package net.sf.dynamicreports.test.jasper.tableofcontents;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.tableOfContentsCustomizer;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca
 */
public class TableOfContentsPosition2Test extends AbstractJasperPositionTest {
    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<String> column2;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TableOfContentsCustomizerBuilder tableOfContentsCustomizer = tableOfContentsCustomizer().setTextFixedWidth(100).setPageIndexFixedWidth(30);

        rb.tableOfContents(tableOfContentsCustomizer)
          .columns(column1 = col.column("Column1", "field1", type.stringType()), column2 = col.column("Column2", "field2", type.stringType()), col.column("Column3", "field3", type.stringType()))
          .groupBy(column1, column2);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(3);

        elementPositionTest("title.textField1", 0, 10, 10, 575, 19);

        for (int i = 0; i < 3; i++) {
            elementPositionTest("detail.list3", i, 10, 49 + 64 * i, 575, 16);
            elementPositionTest("detail.textField1", i, 0, 0, 100, 16);
            elementPositionTest("detail.textField2", i, 100, 0, 445, 16);
            elementPositionTest("detail.textField3", i, 545, 0, 30, 16);
        }

        for (int i = 0; i < 9; i++) {
            elementPositionTest("detail.textField4", i, 10, 0, 100, 16);
            elementPositionTest("detail.textField5", i, 120, 0, 425, 16);
            elementPositionTest("detail.textField6", i, 545, 0, 30, 16);
        }

        for (int i = 0; i < 3; i++) {
            elementPositionTest("detail.list5", i, 10, 65 + 16 * i, 575, 16);
        }
        int index = 0;
        for (int i = 3; i < 6; i++) {
            elementPositionTest("detail.list5", i, 10, 129 + 16 * index++, 575, 16);
        }
        index = 0;
        for (int i = 6; i < 9; i++) {
            elementPositionTest("detail.list5", i, 10, 193 + 16 * index++, 575, 16);
        }
    }

    @Override
    protected JRDataSource createDataSource() {
        String[] values = new String[] {"value1", "value2", "value3"};
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        for (String field1 : values) {
            for (String field2 : values) {
                for (int i = 0; i < 8; i++) {
                    dataSource.add(field1, field2, "text");
                }
            }
        }
        return dataSource;
    }
}

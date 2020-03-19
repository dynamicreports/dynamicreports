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

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.MultiPageListBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;

/**
 * @author Ricardo Mariaca
 */
public class MultiPageList1Test extends AbstractJasperValueTest {
    private TextColumnBuilder<Integer> column1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        MultiPageListBuilder multiPageList = cmp.multiPageList();
        for (int i = 0; i < 150; i++) {
            multiPageList.add(cmp.text("text" + i));
        }
        rb.title(multiPageList).columns(column1 = col.column("Column1", "field1", Integer.class));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(3);

        for (int i = 0; i < 150; i++) {
            elementValueTest("title.textField1", i, "text" + i);
        }

        columnTitleValueTest(column1, "Column1");
        columnDetailValueTest(column1, "0", "1");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1");
        for (int i = 0; i < 2; i++) {
            dataSource.add(i);
        }
        return dataSource;
    }
}

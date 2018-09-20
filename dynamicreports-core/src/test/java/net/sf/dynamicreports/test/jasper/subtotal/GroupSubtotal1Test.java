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
package net.sf.dynamicreports.test.jasper.subtotal;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GroupSubtotal1Test extends AbstractJasperValueTest {
    private AggregationSubtotalBuilder<Double> subtotal1;
    private AggregationSubtotalBuilder<Integer> subtotal2;
    private AggregationSubtotalBuilder<Double> subtotal3;
    private AggregationSubtotalBuilder<Integer> subtotal4;
    private AggregationSubtotalBuilder<Integer> subtotal5;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1, column2;
        TextColumnBuilder<Integer> column3;
        ColumnGroupBuilder group1, group2;

        rb.setLocale(Locale.ENGLISH)
          .columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", String.class), column3 = col.column("Column3", "field3", Integer.class))
          .groupBy(group1 = grp.group(column1), group2 = grp.group(column2))
          .subtotalsAtGroupHeader(group1, subtotal1 = sbt.aggregate(column3, Calculation.AVERAGE))
          .subtotalsAtGroupFooter(group1, subtotal2 = sbt.sum(column3))
          .subtotalsAtGroupHeader(group2, subtotal3 = sbt.aggregate(column3, Calculation.AVERAGE))
          .subtotalsAtGroupFooter(group2, subtotal4 = sbt.sum(column3))
          .subtotalsAtSummary(subtotal5 = sbt.sum(column3));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);
        // groupHeader
        subtotalCountTest(subtotal1, 2);
        subtotalValueTest(subtotal1, "3.5", "9.5");
        // groupFooter
        subtotalCountTest(subtotal2, 2);
        subtotalValueTest(subtotal2, "21", "57");

        // groupHeader
        subtotalIndexCountTest(subtotal3, 2, 4);
        subtotalIndexValueTest(subtotal3, 2, "2", "5", "8", "11");
        // groupFooter
        subtotalIndexCountTest(subtotal4, 2, 4);
        subtotalIndexValueTest(subtotal4, 2, "6", "15", "24", "33");

        subtotalCountTest(subtotal5, 1);
        subtotalValueTest(subtotal5, "78");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        int count = 1;
        for (int i = 0; i < 3; i++) {
            dataSource.add("group1", "group1_1", count++);
        }
        for (int i = 0; i < 3; i++) {
            dataSource.add("group1", "group1_2", count++);
        }
        for (int i = 0; i < 3; i++) {
            dataSource.add("group2", "group2_1", count++);
        }
        for (int i = 0; i < 3; i++) {
            dataSource.add("group2", "group2_2", count++);
        }
        return dataSource;
    }
}

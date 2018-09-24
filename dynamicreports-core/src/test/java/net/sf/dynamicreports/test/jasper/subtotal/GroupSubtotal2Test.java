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
public class GroupSubtotal2Test extends AbstractJasperValueTest {
    private AggregationSubtotalBuilder<Double> subtotal1;
    private AggregationSubtotalBuilder<Integer> subtotal2;
    private AggregationSubtotalBuilder<Integer> subtotal3;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1;
        TextColumnBuilder<Integer> column2;
        ColumnGroupBuilder group1;

        rb.setLocale(Locale.ENGLISH)
          .columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class))
          .groupBy(group1 = grp.group(column1).headerWithSubtotal())
          .subtotalsAtFirstGroupHeader(subtotal1 = sbt.aggregate(column2, Calculation.AVERAGE))
          .subtotalsAtGroupHeader(group1, subtotal2 = sbt.sum(column2))
          .subtotalsAtSummary(subtotal3 = sbt.sum(column2));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // groupHeader
        subtotalCountTest(subtotal1, 2);
        subtotalValueTest(subtotal1, "2", "4.5");
        subtotalIndexCountTest(subtotal2, 2, 2);
        subtotalIndexValueTest(subtotal2, 2, "6", "9");

        subtotalCountTest(subtotal3, 1);
        subtotalValueTest(subtotal3, "15");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        int count = 1;
        for (int i = 0; i < 3; i++) {
            dataSource.add("group1", count++);
        }
        for (int i = 0; i < 2; i++) {
            dataSource.add("group2", count++);
        }
        return dataSource;
    }
}

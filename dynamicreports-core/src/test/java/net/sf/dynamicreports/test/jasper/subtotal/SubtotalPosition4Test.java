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
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class SubtotalPosition4Test extends AbstractJasperPositionTest {
    private AggregationSubtotalBuilder<Integer> subtotal1;
    private AggregationSubtotalBuilder<Integer> subtotal2;
    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<Integer> column2;
    private ColumnGroupBuilder group1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.columns(column1 = col.column("Column1", "field1", type.stringType())
                                .setFixedWidth(540), column2 = col.column("Column2", "field2", type.integerType()))
          .groupBy(group1 = grp.group(column1)
                               .setHeaderWithSubtotal(true))
          .subtotalsAtFirstGroupHeader(subtotal1 = sbt.sum(column2))
          .subtotalsAtSummary(subtotal2 = sbt.sum(column2));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // columns
        columnDetailPositionTest(column2, 0, 10, 0, 565, 16);

        // group
        groupHeaderPositionTest(group1, 0, 10, 26, 575, 16);
        groupHeaderPositionTest(group1, 1, 10, 74, 575, 16);

        // group header
        elementPositionTest("subtotalGroupHeader.list1", 0, 10, 26, 575, 16);
        subtotalPositionTest(subtotal1, 0, 10, 0, 565, 16);
        elementPositionTest("subtotalGroupHeader.list1", 1, 10, 74, 575, 16);
        subtotalPositionTest(subtotal1, 0, 10, 0, 565, 16);

        // summary
        elementPositionTest("summary.list1", 0, 10, 122, 575, 16);
        subtotalPositionTest(subtotal2, 0, 10, 0, 565, 16);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        dataSource.add("group1", 1);
        dataSource.add("group1", 2);
        dataSource.add("group2", 3);
        dataSource.add("group2", 4);
        return dataSource;
    }
}

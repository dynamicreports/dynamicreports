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
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class SubtotalPosition5Test extends AbstractJasperPositionTest {
    private AggregationSubtotalBuilder<Integer> subtotal1;
    private AggregationSubtotalBuilder<Integer> subtotal2;
    private AggregationSubtotalBuilder<Integer> subtotal3;
    private AggregationSubtotalBuilder<Integer> subtotal4;
    private AggregationSubtotalBuilder<Integer> subtotal5;
    private AggregationSubtotalBuilder<Integer> subtotal6;
    private AggregationSubtotalBuilder<Integer> subtotal7;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<Integer> column1;

        rb.columns(column1 = col.column("Column1", "field1", Integer.class).setWidth(600))
          .subtotalsAtSummary(subtotal1 = sbt.sum(column1).setLabel("subtotal"), subtotal2 = sbt.sum(column1).setLabel("subtotal").setLabelPosition(Position.TOP),
                              subtotal3 = sbt.sum(column1).setLabel("subtotal").setLabelPosition(Position.BOTTOM), subtotal4 = sbt.sum(column1).setLabel("subtotal").setLabelPosition(Position.LEFT),
                              subtotal5 = sbt.sum(column1).setLabel("subtotal").setLabelPosition(Position.RIGHT),
                              subtotal6 = sbt.sum(column1).setLabel("subtotal").setLabelPosition(Position.LEFT).setLabelFixedWidth(100),
                              subtotal7 = sbt.sum(column1).setLabel("subtotal").setLabelPosition(Position.RIGHT).setLabelFixedWidth(150));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);
        // summary
        // TOP
        subtotalIndexPositionTest(subtotal1, 1, 0, 10, 58, 575, 16);
        subtotalLabelIndexPositionTest(subtotal1, 1, 0, 10, 42, 575, 16);
        // TOP
        subtotalIndexPositionTest(subtotal2, 2, 0, 10, 90, 575, 16);
        subtotalLabelIndexPositionTest(subtotal2, 2, 0, 10, 74, 575, 16);
        // BOTTOM
        subtotalIndexPositionTest(subtotal3, 3, 0, 10, 106, 575, 16);
        subtotalLabelIndexPositionTest(subtotal3, 3, 0, 10, 122, 575, 16);
        // LEFT
        subtotalIndexPositionTest(subtotal4, 4, 0, 287, 0, 288, 16);
        subtotalLabelIndexPositionTest(subtotal4, 4, 0, 0, 0, 287, 16);
        // RIGHT
        subtotalIndexPositionTest(subtotal5, 5, 0, 0, 0, 287, 16);
        subtotalLabelIndexPositionTest(subtotal5, 5, 0, 287, 0, 288, 16);
        // LEFT
        subtotalIndexPositionTest(subtotal6, 6, 0, 100, 0, 475, 16);
        subtotalLabelIndexPositionTest(subtotal6, 6, 0, 0, 0, 100, 16);
        // RIGHT
        subtotalIndexPositionTest(subtotal7, 7, 0, 0, 0, 425, 16);
        subtotalLabelIndexPositionTest(subtotal7, 7, 0, 425, 0, 150, 16);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1");
        dataSource.add(1);
        return dataSource;
    }
}

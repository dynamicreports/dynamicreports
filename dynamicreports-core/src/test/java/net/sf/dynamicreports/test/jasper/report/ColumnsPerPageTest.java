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
package net.sf.dynamicreports.test.jasper.report;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca
 */
public class ColumnsPerPageTest extends AbstractJasperPositionTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<Integer> column1;
    private TextColumnBuilder<Integer> column2;
    private TextColumnBuilder<Integer> column3;
    private TextColumnBuilder<Integer> column4;
    private TextColumnBuilder<Integer> column5;
    private AggregationSubtotalBuilder<Integer> subtotal1;
    private AggregationSubtotalBuilder<Integer> subtotal2;
    private AggregationSubtotalBuilder<?> subtotal3;
    private AggregationSubtotalBuilder<Integer> subtotal4;
    private AggregationSubtotalBuilder<?> subtotal5;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.setTextStyle(stl.style().setPadding(1))
          .setPageColumnSpace(10)
          .setPageColumnsPerPage(3)
          .columnGrid(ListType.HORIZONTAL_FLOW)
          .columns(column1 = col.column("Column1", "field1", Integer.class).setWidth(50), column2 = col.column("Column2", "field2", Integer.class).setWidth(50),
                   column3 = col.column("Column3", "field3", Integer.class).setWidth(50), column4 = col.column("Column4", "field4", Integer.class).setWidth(50),
                   column5 = col.column("Column5", "field5", Integer.class).setWidth(50))
          .subtotalsAtColumnFooter(subtotal1 = sbt.sum(column1).setLabel("sum"), subtotal2 = sbt.sum(column3).setLabel("sum"), subtotal3 = sbt.aggregate(column3, Calculation.AVERAGE).setLabel("avg"),
                                   subtotal4 = sbt.sum(column4).setLabel("sum"), subtotal5 = sbt.aggregate(column4, Calculation.AVERAGE).setLabel("avg"))
          .subtotalsAtSummary(subtotal1 = sbt.sum(column1).setLabel("sum"), subtotal2 = sbt.sum(column3).setLabel("sum"), subtotal3 = sbt.aggregate(column3, Calculation.AVERAGE).setLabel("avg"),
                              subtotal4 = sbt.sum(column4).setLabel("sum"), subtotal5 = sbt.aggregate(column4, Calculation.AVERAGE).setLabel("avg"));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(2);
        // column header
        // elementPositionTest("columnHeader.list1", 0, 10, 10, 185, 28);
        // elementPositionTest("columnHeader.list1", 1, 205, 10, 185, 28);
        // elementPositionTest("columnHeader.list1", 2, 400, 10, 185, 28);
        // elementPositionTest("columnHeader.list1", 3, 10, 10, 185, 28);

        elementPositionTest("columnHeader.list2", 0, 10, 10, 185, 14);
        columnTitlePositionTest(column1, 0, 0, 0, 61, 14);
        columnTitlePositionTest(column2, 0, 61, 0, 62, 14);
        columnTitlePositionTest(column3, 0, 123, 0, 62, 14);

        elementPositionTest("columnHeader.list3", 0, 10, 24, 185, 14);
        columnTitlePositionTest(column4, 0, 0, 0, 92, 14);
        columnTitlePositionTest(column5, 0, 92, 0, 93, 14);

        // detail
        // elementPositionTest("detail.list1", 0, 10, 38, 185, 28);
        // elementPositionTest("detail.list1", 24, 205, 38, 185, 28);
        // elementPositionTest("detail.list1", 48, 400, 38, 185, 28);
        // elementPositionTest("detail.list1", 72, 10, 38, 185, 28);

        elementPositionTest("detail.list2", 0, 10, 38, 185, 14);
        columnDetailPositionTest(column1, 0, 0, 0, 61, 14);
        columnDetailPositionTest(column2, 0, 61, 0, 62, 14);
        columnDetailPositionTest(column3, 0, 123, 0, 62, 14);

        elementPositionTest("detail.list3", 0, 10, 52, 185, 14);
        columnDetailPositionTest(column4, 0, 0, 0, 92, 14);
        columnDetailPositionTest(column5, 0, 92, 0, 93, 14);

        // subtotal at column footer
        // elementPositionTest("columnFooter.list1", 0, 10, 720, 185, 112);
        // elementPositionTest("columnFooter.list1", 1, 205, 720, 185, 112);
        // elementPositionTest("columnFooter.list1", 2, 400, 720, 185, 112);
        // elementPositionTest("columnFooter.list1", 3, 10, 720, 185, 112);

        elementPositionTest("columnFooter.list2", 0, 10, 720, 185, 56);
        // elementPositionTest("columnFooter.list3", 0, 0, 0, 61, 28);
        subtotalLabelPositionTest(subtotal1, 0, 0, 0, 61, 14);
        subtotalPositionTest(subtotal1, 0, 0, 14, 61, 14);

        // elementPositionTest("columnFooter.list4", 0, 123, 0, 62, 56);
        // elementPositionTest("columnFooter.list5", 0, 0, 0, 62, 28);
        subtotalLabelPositionTest(subtotal2, 0, 123, 0, 62, 14);
        subtotalPositionTest(subtotal2, 0, 123, 14, 62, 14);
        // elementPositionTest("columnFooter.list6", 0, 0, 28, 62, 28);
        subtotalLabelPositionTest(subtotal3, 0, 123, 0, 62, 14);
        subtotalPositionTest(subtotal3, 0, 123, 14, 62, 14);

        elementPositionTest("columnFooter.list7", 0, 10, 776, 185, 56);
        // elementPositionTest("columnFooter.list8", 0, 0, 0, 92, 56);
        // elementPositionTest("columnFooter.list9", 0, 0, 0, 92, 28);
        subtotalLabelPositionTest(subtotal4, 0, 0, 0, 92, 14);
        subtotalPositionTest(subtotal4, 0, 0, 14, 92, 14);
        // elementPositionTest("columnFooter.list10", 0, 0, 28, 92, 28);
        subtotalLabelPositionTest(subtotal5, 0, 0, 0, 92, 14);
        subtotalPositionTest(subtotal5, 0, 0, 14, 92, 14);

        // subtotal at summary
        elementPositionTest("summary.list1", 0, 10, 262, 575, 112);

        // elementPositionTest("summary.list2", 0, 0, 0, 185, 112);
        elementPositionTest("summary.list3", 0, 0, 0, 185, 56);
        subtotalLabelPositionTest(subtotal1, 0, 0, 0, 61, 14);
        subtotalPositionTest(subtotal1, 0, 0, 14, 61, 14);

        // elementPositionTest("summary.list4", 0, 0, 0, 61, 28);
        // elementPositionTest("summary.list5", 0, 123, 0, 62, 56);
        subtotalLabelPositionTest(subtotal2, 0, 123, 0, 62, 14);
        subtotalPositionTest(subtotal2, 0, 123, 14, 62, 14);
        // elementPositionTest("summary.list6", 0, 0, 0, 62, 28);
        subtotalLabelPositionTest(subtotal3, 0, 123, 0, 62, 14);
        subtotalPositionTest(subtotal3, 0, 123, 14, 62, 14);

        // elementPositionTest("summary.list7", 0, 0, 28, 62, 28);
        elementPositionTest("summary.list8", 0, 0, 56, 185, 56);
        // elementPositionTest("summary.list9", 0, 0, 0, 92, 56);
        subtotalLabelPositionTest(subtotal4, 0, 0, 0, 92, 14);
        subtotalPositionTest(subtotal4, 0, 0, 14, 92, 14);
        // elementPositionTest("summary.list10", 0, 0, 0, 92, 28);
        subtotalLabelPositionTest(subtotal5, 0, 0, 0, 92, 14);
        subtotalPositionTest(subtotal5, 0, 0, 14, 92, 14);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5");
        for (int i = 0; i < 80; i++) {
            dataSource.add(1, 1, 1, 1, 1);
        }
        return dataSource;
    }
}

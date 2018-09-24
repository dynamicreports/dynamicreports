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
package net.sf.dynamicreports.test.jasper.report;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class BandTest extends AbstractJasperPositionTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<Integer> column2;
    private ColumnGroupBuilder group1;
    private AggregationSubtotalBuilder<Integer> subtotal1;
    private AggregationSubtotalBuilder<Integer> subtotal2;
    private AggregationSubtotalBuilder<Integer> subtotal3;
    private AggregationSubtotalBuilder<Integer> subtotal4;
    private AggregationSubtotalBuilder<Integer> subtotal5;
    private AggregationSubtotalBuilder<Integer> subtotal6;
    private AggregationSubtotalBuilder<Integer> subtotal7;
    private AggregationSubtotalBuilder<Integer> subtotal8;
    private AggregationSubtotalBuilder<Integer> subtotal9;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1;

        rb.setPageColumnsPerPage(2)
          .columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class).setWidth(500))
          .groupBy(group1 = grp.group(column1))

          .subtotalsAtTitle(subtotal1 = sbt.sum(column2))
          .subtotalsAtPageHeader(subtotal2 = sbt.sum(column2))
          .subtotalsAtPageFooter(subtotal3 = sbt.sum(column2))
          .subtotalsAtColumnHeader(subtotal4 = sbt.sum(column2))
          .subtotalsAtColumnFooter(subtotal5 = sbt.sum(column2))
          .subtotalsAtGroupHeader(group1, subtotal6 = sbt.sum(column2))
          .subtotalsAtGroupFooter(group1, subtotal7 = sbt.sum(column2))
          .subtotalsAtLastPageFooter(subtotal8 = sbt.sum(column2))
          .subtotalsAtSummary(subtotal9 = sbt.sum(column2))

          .title(cmp.text("title"))
          .pageHeader(cmp.text("pageHeader"))
          .pageFooter(cmp.text("pageFooter"))
          .columnHeader(cmp.text("columnHeader"))
          .columnFooter(cmp.text("columnFooter"))
          .groupHeader(group1, cmp.text("groupHeader"))
          .groupFooter(group1, cmp.text("groupFooter"))
          .detail(cmp.text("detail"))
          .lastPageFooter(cmp.text("lastPageFooter"))
          .summary(cmp.text("summary"))
          .background(cmp.text("background"));

    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(2);

        // title
        // elementPositionTest("title.list1", 0, 10, 10, 575, 32);
        elementPositionTest("title.textField1", 0, 10, 10, 575, 16);
        elementPositionTest("title.list2", 0, 10, 26, 575, 16);
        subtotalPositionTest(subtotal1, 0, 10, 0, 277, 16);

        // page header
        // elementPositionTest("pageHeader.list1", 0, 10, 42, 575, 32);
        elementPositionTest("pageHeader.textField1", 0, 10, 42, 575, 16);
        elementPositionTest("pageHeader.list2", 0, 10, 58, 575, 16);
        subtotalPositionTest(subtotal2, 0, 10, 0, 277, 16);

        // page footer
        // elementPositionTest("pageFooter.list1", 0, 10, 800, 575, 32);
        elementPositionTest("pageFooter.list2", 0, 10, 800, 575, 16);
        subtotalPositionTest(subtotal3, 0, 10, 0, 277, 16);
        elementPositionTest("pageFooter.textField1", 0, 10, 816, 575, 16);

        // column header
        // elementPositionTest("columnHeader.list1", 0, 10, 74, 287, 48);
        elementPositionTest("columnHeader.list2", 0, 10, 74, 287, 16);
        columnTitlePositionTest(column2, 0, 10, 0, 277, 16);
        elementPositionTest("columnHeader.textField1", 0, 10, 90, 287, 16);
        elementPositionTest("columnHeader.list3", 0, 10, 106, 287, 16);
        subtotalPositionTest(subtotal4, 0, 10, 0, 277, 16);

        // column footer
        // elementPositionTest("columnFooter.list1", 0, 10, 768, 287, 32);
        elementPositionTest("columnFooter.list2", 0, 10, 768, 287, 16);
        subtotalPositionTest(subtotal5, 0, 10, 0, 277, 16);
        elementPositionTest("columnFooter.textField1", 0, 10, 784, 287, 16);

        // group header
        groupHeaderPositionTest(group1, 0, 10, 122, 287, 16);
        elementPositionTest("groupHeader.textField1", 0, 10, 138, 287, 16);
        elementPositionTest("subtotalGroupHeader.list1", 0, 10, 154, 287, 16);
        subtotalPositionTest(subtotal6, 0, 10, 0, 277, 16);

        // group footer
        elementPositionTest("subtotalGroupFooter.list1", 0, 297, 346, 287, 16);
        subtotalPositionTest(subtotal7, 0, 10, 0, 277, 16);
        elementPositionTest("groupFooter.textField1", 0, 297, 362, 287, 16);

        // detail
        // elementPositionTest("detail.list1", 0, 10, 170, 287, 32);
        elementPositionTest("detail.textField1", 0, 10, 170, 287, 16);
        elementPositionTest("detail.list2", 0, 10, 186, 287, 16);
        columnDetailPositionTest(column2, 0, 10, 0, 277, 16);

        // last page footer
        // elementPositionTest("lastPageFooter.list1", 0, 10, 800, 575, 32);
        elementPositionTest("lastPageFooter.list2", 0, 10, 800, 575, 16);
        subtotalPositionTest(subtotal8, 0, 10, 0, 277, 16);
        elementPositionTest("lastPageFooter.textField1", 0, 10, 816, 575, 16);

        // summary
        // elementPositionTest("summary.list1", 0, 10, 602, 575, 32);
        elementPositionTest("summary.list2", 0, 10, 602, 575, 16);
        subtotalPositionTest(subtotal9, 0, 10, 0, 277, 16);
        elementPositionTest("summary.textField1", 0, 10, 618, 575, 16);

        // background
        elementPositionTest("background.textField1", 0, 10, 10, 575, 16);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 25; i++) {
            dataSource.add("group1", i);
        }
        for (int i = 0; i < 25; i++) {
            dataSource.add("group2", i);
        }
        return dataSource;
    }
}

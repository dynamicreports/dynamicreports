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
package net.sf.dynamicreports.test.jasper.group;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.GroupFooterPosition;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRGroup;
import org.junit.Assert;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;

/**
 * @author Ricardo Mariaca
 */
public class GroupPosition3Test extends AbstractJasperPositionTest {

    private ColumnGroupBuilder group1;
    private TextColumnBuilder<Integer> column2;
    private AggregationSubtotalBuilder<Integer> subtotal1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1;

        rb.columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class))
          .groupBy(group1 = grp.group(column1).setFooterPosition(GroupFooterPosition.FORCE_AT_BOTTOM).keepTogether().setMinHeightToStartNewPage(100))
          .subtotalsAtFirstGroupFooter(subtotal1 = sbt.sum(column2));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);
        elementPositionTest("columnHeader.list1", 0, 10, 10, 575, 16);
        elementPositionTest("columnHeader.filler1", 0, 0, 0, 10, 16);
        elementPositionTest("detail.list1", 0, 10, 42, 575, 16);
        elementPositionTest("detail.list1", 1, 10, 58, 575, 16);

        // group1
        groupHeaderPositionTest(group1, 0, 10, 26, 575, 16);
        // column2
        columnTitlePositionTest(column2, 0, 10, 0, 565, 16);
        columnDetailPositionTest(column2, 0, 10, 0, 565, 16);
        columnDetailPositionTest(column2, 1, 10, 0, 565, 16);
        // summary
        elementPositionTest("subtotalGroupFooter.list1", 0, 10, 816, 575, 16);
        subtotalPositionTest(subtotal1, 0, 10, 0, 565, 16);

        JRGroup jrGroup = getJasperReport().getGroups()[0];
        Assert.assertTrue("Keep together", jrGroup.isKeepTogether());
        // Assert.assertEquals("Min height to start new page", new Integer(100), jrGroup.getMinHeightToStartNewPage()); // remove this ambiguous function call
        Assert.assertEquals("Min height to start new page", 100, jrGroup.getMinHeightToStartNewPage());
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 10; i++) {
            dataSource.add("group1", i);
        }
        return dataSource;
    }
}

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
package net.sf.dynamicreports.test.jasper.component;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

import java.util.List;

import org.junit.Assert;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.RectangleBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRPrintElement;

/**
 * @author Ricardo Mariaca
 */
public class ListBackgroundComponentTest extends AbstractJasperPositionTest {
    private TextColumnBuilder<String> column;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        final RectangleBuilder background = cmp.rectangle();
        final ReportTemplateBuilder template = template().setDetailBackgroundComponent(background);

        rb.setTemplate(template)
          .setTitleBackgroundComponent(background)
          .setSummaryBackgroundComponent(background)
          .title(cmp.text("title").setFixedHeight(300))
          .columns(column = col.column("field1", String.class))
          .summary(cmp.text("text\ntext"), cmp.horizontalList(cmp.text("text"), cmp.horizontalList(cmp.text("text"), cmp.text("text")).setBackgroundComponent(background), cmp.text("text")),
                   cmp.verticalList(cmp.text("text"), cmp.text("text")).setStyle(stl.style(5)).setBackgroundComponent(background));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementPositionTest("title.list1", 0, 10, 10, 575, 300);
        elementPositionTest("title.list1.background", 0, 0, 0, 575, 300);

        columnDetailPositionTest(column, 0, 0, 0, 575, 16);
        elementPositionTest("detail.list1", 0, 10, 310, 575, 16);
        elementPositionTest("detail.list1.background", 0, 0, 0, 575, 16);
        columnDetailPositionTest(column, 1, 0, 0, 575, 16);
        elementPositionTest("detail.list1", 1, 10, 326, 575, 16);
        elementPositionTest("detail.list1.background", 1, 0, 0, 575, 16);

        elementPositionTest("summary.list1", 0, 10, 342, 575, 85);
        elementPositionTest("summary.list1.background", 0, 0, 0, 575, 85);
        elementPositionTest("summary.list2", 0, 0, 27, 575, 16);
        final List<JRPrintElement> elements = findElement("summary.list2.background");
        Assert.assertTrue("list background", elements.isEmpty());
        elementPositionTest("summary.list3", 0, 143, 0, 288, 16);
        elementPositionTest("summary.list3.background", 0, 0, 0, 288, 16);
        elementPositionTest("summary.list4", 0, 0, 43, 575, 42);
        elementPositionTest("summary.list4.background", 0, 0, 0, 565, 32);
    }

    @Override
    protected JRDataSource createDataSource() {
        final DRDataSource dataSource = new DRDataSource("field1");
        dataSource.add("value1");
        dataSource.add("value2");
        return dataSource;
    }
}

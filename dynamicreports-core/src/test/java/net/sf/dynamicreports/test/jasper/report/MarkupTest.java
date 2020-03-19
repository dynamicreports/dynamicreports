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
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca
 */
public class MarkupTest extends AbstractJasperValueTest {
    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<Integer> column2;
    private AggregationSubtotalBuilder<Integer> subtotal1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        StyleBuilder style = stl.style().setMarkup(Markup.HTML);

        rb.setColumnStyle(style)
          .columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class))
          .subtotalsAtSummary(subtotal1 = sbt.sum(column2).setLabel("subtotal <b>subtotal</b> subtotal").setLabelStyle(style))
          .title(cmp.text("title <b>title</b> title").setMarkup(Markup.HTML));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        columnDetailValueTest(column1, "column <style isItalic=\"true\">column</style> column");
        elementValueTest("title.textField1", "title <style isBold=\"true\">title</style> title");
        subtotalLabelValueTest(subtotal1, "subtotal <style isBold=\"true\">subtotal</style> subtotal");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 1; i++) {
            dataSource.add("column <i>column</i> column", i);
        }
        return dataSource;
    }
}

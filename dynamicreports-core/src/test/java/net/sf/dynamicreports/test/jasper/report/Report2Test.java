/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Report2Test extends AbstractJasperPositionTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private AggregationSubtotalBuilder<Integer> subtotal1;
    private AggregationSubtotalBuilder<Integer> subtotal2;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<Integer> column1;

        rb.setTitleOnANewPage(true)
          .setSummaryOnANewPage(true)
          .setFloatColumnFooter(true)
          .columns(column1 = col.column("Column1", "field1", Integer.class))
          .subtotalsAtColumnFooter(subtotal1 = sbt.sum(column1))
          .subtotalsAtSummary(subtotal2 = sbt.sum(column1))
          .title(cmp.text("title"));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(3);

        // title
        elementPositionTest("title.textField1", 0, 10, 10, 575, 16);

        // column footer
        subtotalPositionTest(subtotal1, 0, 10, 186, 575, 16);

        // summary
        subtotalPositionTest(subtotal2, 0, 10, 10, 575, 16);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1");
        for (int i = 0; i < 10; i++) {
            dataSource.add(i);
        }
        return dataSource;
    }
}

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
package net.sf.dynamicreports.examples.chart;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.chart.BarChartBuilder;
import net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder;
import net.sf.dynamicreports.report.builder.chart.LineChartBuilder;
import net.sf.dynamicreports.report.constant.AxisPosition;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.util.Calendar;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>MultiAxisChartReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class MultiAxisChartReport {

    /**
     * <p>Constructor for MultiAxisChartReport.</p>
     */
    public MultiAxisChartReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new MultiAxisChartReport();
    }

    private void build() {
        FieldBuilder<Date> dateField = field("date", type.dateType());
        FieldBuilder<Integer> stock1Field = field("stock1", type.integerType());
        FieldBuilder<Integer> stock2Field = field("stock2", type.integerType());

        CategoryChartSerieBuilder stock1Serie = cht.serie(stock1Field)
                                                   .setLabel("Stock1");
        CategoryChartSerieBuilder stock2Serie = cht.serie(stock2Field)
                                                   .setLabel("Stock2");

        LineChartBuilder chart1 = cht.lineChart()
                                     .setCategory(new CategoryExpression())
                                     .series(stock1Serie)
                                     .setValueAxisFormat(cht.axisFormat()
                                                            .setLabel("Stock1"));

        BarChartBuilder chart2 = cht.barChart()
                                    .setCategory(new CategoryExpression())
                                    .series(stock2Serie)
                                    .setValueAxisFormat(cht.axisFormat()
                                                           .setLabel("Stock2"));

        try {
            report().setTemplate(Templates.reportTemplate)
                    .fields(dateField)
                    .title(Templates.createTitleComponent("MultiAxisChart"), cht.multiAxisChart(chart1, chart2), cht.multiAxisChart()
                                                                                                                    .addChart(chart1, AxisPosition.LEFT_OR_TOP)
                                                                                                                    .addChart(chart2, AxisPosition.RIGHT_OR_BOTTOM))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("date", "stock1", "stock2");
        dataSource.add(toDate(2010, 1), 25, 300);
        dataSource.add(toDate(2010, 2), 11, 450);
        dataSource.add(toDate(2010, 3), 17, 280);
        dataSource.add(toDate(2010, 4), 15, 620);
        dataSource.add(toDate(2010, 5), 30, 400);
        dataSource.add(toDate(2010, 6), 8, 320);
        dataSource.add(toDate(2010, 7), 25, 490);
        return dataSource;
    }

    private Date toDate(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        return c.getTime();
    }

    private class CategoryExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return type.dateYearToMonthType()
                       .valueToString("date", reportParameters);
        }
    }
}

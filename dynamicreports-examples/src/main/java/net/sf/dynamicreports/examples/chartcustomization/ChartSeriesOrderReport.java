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
package net.sf.dynamicreports.examples.chartcustomization;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.chart.BarChartBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.OrderType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.util.Calendar;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>ChartSeriesOrderReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class ChartSeriesOrderReport {

    /**
     * <p>Constructor for ChartSeriesOrderReport.</p>
     */
    public ChartSeriesOrderReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new ChartSeriesOrderReport();
    }

    private void build() {
        TextColumnBuilder<Date> dateColumn = col.column("Date", "date", type.dateYearToMonthType());
        TextColumnBuilder<String> stockColumn = col.column("Stock", "stock", type.stringType());
        TextColumnBuilder<Integer> valueColumn = col.column("Value", "value", type.integerType());

        BarChartBuilder chart = cht.barChart()
                                   .setCategory(new CategoryExpression())
                                   .series(cht.serie(valueColumn).setSeries(stockColumn))
                                   .setSeriesOrderType(OrderType.ASCENDING)
                                   .setValueAxisFormat(cht.axisFormat().setLabel("Stock"));

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(dateColumn, stockColumn, valueColumn)
                    .title(Templates.createTitleComponent("ChartSeriesOrder"))
                    .groupBy(dateColumn)
                    .summary(chart)
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("date", "stock", "value");
        dataSource.add(toDate(2010, 1), "stock3", 25);
        dataSource.add(toDate(2010, 2), "stock3", 10);
        dataSource.add(toDate(2010, 2), "stock1", 18);
        dataSource.add(toDate(2010, 3), "stock3", 12);
        dataSource.add(toDate(2010, 3), "stock1", 19);
        dataSource.add(toDate(2010, 3), "stock2", 9);
        dataSource.add(toDate(2010, 4), "stock1", 15);
        dataSource.add(toDate(2010, 4), "stock2", 14);
        dataSource.add(toDate(2010, 5), "stock2", 22);
        dataSource.add(toDate(2010, 5), "stock1", 15);
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
            return type.dateYearToMonthType().valueToString("date", reportParameters);
        }
    }
}

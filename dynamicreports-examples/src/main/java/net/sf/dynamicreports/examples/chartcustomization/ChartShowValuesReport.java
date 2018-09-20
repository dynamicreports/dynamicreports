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
import net.sf.dynamicreports.report.builder.chart.AreaChartBuilder;
import net.sf.dynamicreports.report.builder.chart.BarChartBuilder;
import net.sf.dynamicreports.report.builder.chart.LineChartBuilder;
import net.sf.dynamicreports.report.builder.chart.PieChartBuilder;
import net.sf.dynamicreports.report.builder.chart.StackedBar3DChartBuilder;
import net.sf.dynamicreports.report.builder.chart.StackedBarChartBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>ChartShowValuesReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ChartShowValuesReport {

    /**
     * <p>Constructor for ChartShowValuesReport.</p>
     */
    public ChartShowValuesReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new ChartShowValuesReport();
    }

    private void build() {
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Integer> stock1Column = col.column("Stock 1", "stock1", type.integerType());
        TextColumnBuilder<Integer> stock2Column = col.column("Stock 2", "stock2", type.integerType());
        TextColumnBuilder<Integer> stock3Column = col.column("Stock 3", "stock3", type.integerType());

        BarChartBuilder barChart = cht.barChart()
                                      .setShowValues(true)
                                      .setCategory(itemColumn)
                                      .series(cht.serie(stock1Column), cht.serie(stock2Column), cht.serie(stock3Column));
        StackedBarChartBuilder stackedBarChart = cht.stackedBarChart()
                                                    .setShowValues(true)
                                                    .setCategory(itemColumn)
                                                    .series(cht.serie(stock1Column), cht.serie(stock2Column), cht.serie(stock3Column));
        LineChartBuilder lineChart = cht.lineChart()
                                        .setShowValues(true)
                                        .setCategory(itemColumn)
                                        .series(cht.serie(stock1Column), cht.serie(stock2Column), cht.serie(stock3Column));
        AreaChartBuilder areaChart = cht.areaChart()
                                        .setShowValues(true)
                                        .setCategory(itemColumn)
                                        .series(cht.serie(stock1Column), cht.serie(stock2Column), cht.serie(stock3Column));
        StackedBar3DChartBuilder stackedBar3DChart = cht.stackedBar3DChart()
                                                        .setShowValues(true)
                                                        .setCategory(itemColumn)
                                                        .series(cht.serie(stock1Column), cht.serie(stock2Column), cht.serie(stock3Column));
        PieChartBuilder pieChart = cht.pieChart()
                                      .setShowValues(true)
                                      .setKey(itemColumn)
                                      .series(cht.serie(stock1Column));

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(itemColumn, stock1Column, stock2Column, stock3Column)
                    .title(Templates.createTitleComponent("ChartShowValues"))
                    .summary(cmp.horizontalList(barChart, stackedBarChart), cmp.horizontalList(lineChart, areaChart), cmp.horizontalList(stackedBar3DChart, pieChart))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "stock1", "stock2", "stock3");
        dataSource.add("Laptop", 95, 80, 50);
        dataSource.add("Tablet", 170, 100, 80);
        dataSource.add("Smartphone", 120, 80, 60);
        return dataSource;
    }
}

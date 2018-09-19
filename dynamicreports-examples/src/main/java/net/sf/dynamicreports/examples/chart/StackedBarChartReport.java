/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.examples.chart;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>StackedBarChartReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class StackedBarChartReport {

    /**
     * <p>Constructor for StackedBarChartReport.</p>
     */
    public StackedBarChartReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new StackedBarChartReport();
    }

    private void build() {
        FontBuilder boldFont = stl.fontArialBold()
                                  .setFontSize(12);

        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Integer> stock1Column = col.column("Stock 1", "stock1", type.integerType());
        TextColumnBuilder<Integer> stock2Column = col.column("Stock 2", "stock2", type.integerType());
        TextColumnBuilder<Integer> stock3Column = col.column("Stock 3", "stock3", type.integerType());

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(itemColumn, stock1Column, stock2Column, stock3Column)
                    .title(Templates.createTitleComponent("StackedBarChart"))
                    .summary(cht.stackedBarChart()
                                .setTitle("Stacked bar chart")
                                .setTitleFont(boldFont)
                                .setCategory(itemColumn)
                                .series(cht.serie(stock1Column), cht.serie(stock2Column), cht.serie(stock3Column))
                                .setCategoryAxisFormat(cht.axisFormat()
                                                          .setLabel("Item")))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "stock1", "stock2", "stock3");
        dataSource.add("Tablet", 90, 85, 40);
        dataSource.add("Laptop", 170, 100, 150);
        dataSource.add("Smartphone", 120, 80, 60);
        return dataSource;
    }
}

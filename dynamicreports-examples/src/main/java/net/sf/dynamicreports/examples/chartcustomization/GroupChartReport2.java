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

package net.sf.dynamicreports.examples.chartcustomization;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.chart.BarChartBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.expression.AbstractComplexExpression;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>GroupChartReport2 class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GroupChartReport2 {

    /**
     * <p>Constructor for GroupChartReport2.</p>
     */
    public GroupChartReport2() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new GroupChartReport2();
    }

    private void build() {
        FontBuilder boldFont = stl.fontArialBold()
                                  .setFontSize(12);

        TextColumnBuilder<String> yearColumn = col.column("Year", "year", type.stringType());
        TextColumnBuilder<String> stockColumn = col.column("Stock", "stock", type.stringType());
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());

        BarChartBuilder chart1 = cht.barChart()
                                    .setTitle(new ChartTitleExpression(stockColumn))
                                    .setTitleFont(boldFont)
                                    .setCategory(yearColumn)
                                    .series(cht.serie(quantityColumn)
                                               .setSeries(itemColumn));

        ColumnGroupBuilder stockGroup = grp.group(stockColumn)
                                           .setHeaderLayout(GroupHeaderLayout.EMPTY)
                                           .footer(chart1);

        JasperReportBuilder subReport = report().sortBy(stockColumn)
                                                .groupBy(stockGroup)
                                                .setDataSource(createDataSource());

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(yearColumn, stockColumn, itemColumn, quantityColumn)
                    .title(Templates.createTitleComponent("GroupChart2"))
                    .summary(cmp.subreport(subReport))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("year", "stock", "item", "quantity");
        dataSource.add("2010", "Stock1", "Tablet", 80);
        dataSource.add("2010", "Stock1", "Smartphone", 40);
        dataSource.add("2010", "Stock2", "Tablet", 70);
        dataSource.add("2010", "Stock2", "Smartphone", 250);
        dataSource.add("2011", "Stock1", "Tablet", 40);
        dataSource.add("2011", "Stock1", "Smartphone", 90);
        dataSource.add("2011", "Stock2", "Tablet", 180);
        dataSource.add("2011", "Stock2", "Smartphone", 150);
        return dataSource;
    }

    private class ChartTitleExpression extends AbstractComplexExpression<String> {
        private static final long serialVersionUID = 1L;

        public ChartTitleExpression(TextColumnBuilder<String> stockColumn) {
            addExpression(stockColumn);
        }

        @Override
        public String evaluate(List<?> values, ReportParameters reportParameters) {
            return (String) values.get(0);
        }
    }
}

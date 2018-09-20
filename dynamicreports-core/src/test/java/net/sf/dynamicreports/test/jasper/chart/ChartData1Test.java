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
package net.sf.dynamicreports.test.jasper.chart;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;
import org.jfree.chart.JFreeChart;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.variable;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ChartData1Test extends AbstractJasperChartTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1;
        TextColumnBuilder<Integer> column2;

        rb.columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class))
          .variables(variable("var1", column2, Calculation.SUM))
          .summary(cht.barChart()
                      .setTitle(new TitleExpression())
                      .setCategory(column1)
                      .series(cht.serie(column2), cht.serie("field3", Integer.class)
                                                     .setLabel("f3"), cht.serie(column2.multiply(2)
                                                                                       .add(1))
                                                                         .setLabel("exp")), cht.barChart()
                                                                                               .setCategory("field1", String.class)
                                                                                               .customizers(new Customizer1(), new Customizer2())
                                                                                               .setUseSeriesAsCategory(true)
                                                                                               .series(cht.serie(column2), cht.serie("field3", Integer.class)
                                                                                                                              .setLabel("f3"), cht.serie(new ValueExpression())
                                                                                                                                                  .setLabel("exp")), cht.barChart()
                                                                                                                                                                        .setCategory(
                                                                                                                                                                            new CategoryExpression())
                                                                                                                                                                        .series(cht.serie(column2),
                                                                                                                                                                                cht.serie("field3",
                                                                                                                                                                                          Integer.class)
                                                                                                                                                                                   .setLabel("f3"),
                                                                                                                                                                                cht.serie(
                                                                                                                                                                                    new ValueExpression())
                                                                                                                                                                                   .setLabel("exp")));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        String[] categories = new String[] {"value1", "value2", "value3", "value4"};
        String[] series = new String[] {"Column2", "f3", "exp"};
        Number[][] values = new Number[][] {{2d, 4d, 6d}, {4d, 6d, 10d}, {6d, 8d, 14d}, {8d, 10d, 18d}};

        chartCountTest("summary.chart1", 1);
        chartTitleTest("summary.chart1", 0, "Title sum=20");
        chartCategoryCountTest("summary.chart1", 0, 4);
        chartSeriesCountTest("summary.chart1", 0, 3);
        chartDataTest("summary.chart1", 0, categories, series, values);

        chartCountTest("summary.chart2", 1);
        chartTitleTest("summary.chart2", 0, "customizer1 1 customizer2");
        chartCategoryCountTest("summary.chart2", 0, 3);
        chartSeriesCountTest("summary.chart2", 0, 4);
        chartDataTest("summary.chart2", 0, series, categories, new Number[][] {{2d, 4d, 6d, 8d}, {4d, 6d, 8d, 10d}, {6d, 10d, 14d, 18d}});

        categories = new String[] {"value1_exp", "value2_exp", "value3_exp", "value4_exp"};
        chartCountTest("summary.chart3", 1);
        chartTitleTest("summary.chart3", 0, null);
        chartCategoryCountTest("summary.chart3", 0, 4);
        chartSeriesCountTest("summary.chart3", 0, 3);
        chartDataTest("summary.chart3", 0, categories, series, values);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        for (int i = 0; i < 4; i++) {
            dataSource.add("value" + (i + 1), i + 1, i + 2);
            dataSource.add("value" + (i + 1), i + 1, i + 2);
        }
        return dataSource;
    }

    private class ValueExpression extends AbstractSimpleExpression<Double> {
        private static final long serialVersionUID = 1L;

        @Override
        public Double evaluate(ReportParameters reportParameters) {
            double f1 = ((Number) reportParameters.getValue("field2")).doubleValue();
            double f2 = ((Number) reportParameters.getValue("field3")).doubleValue();
            return f1 + f2;
        }
    }

    private class CategoryExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return (String) reportParameters.getValue("field1") + "_exp";
        }
    }

    private class TitleExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return "Title sum=" + reportParameters.getValue("var1");
        }
    }

    private class Customizer1 implements DRIChartCustomizer, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public void customize(JFreeChart chart, ReportParameters reportParameters) {
            chart.setTitle("customizer1 " + reportParameters.getPageNumber());
        }
    }

    private class Customizer2 implements DRIChartCustomizer, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public void customize(JFreeChart chart, ReportParameters reportParameters) {
            chart.setTitle(chart.getTitle()
                                .getText() + " customizer2");
        }
    }
}

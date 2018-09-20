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
package net.sf.dynamicreports.test.jasper.dataset;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.DatasetBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
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
import static net.sf.dynamicreports.report.builder.DynamicReports.dataset;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.variable;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ChartDatasetTest extends AbstractJasperChartTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        FieldBuilder<Integer> field2 = field("field2", Integer.class);

        DatasetBuilder dataset1 = dataset();
        dataset1.addField(field2);
        dataset1.setDataSource(createDataSource());

        DatasetBuilder dataset2 = dataset();
        dataset2.addField("field1", String.class);
        dataset2.setDataSource(createDataSource());

        DatasetBuilder dataset3 = dataset();
        VariableBuilder<Integer> variable = variable("var1", field2, Calculation.SUM);
        dataset3.variables(variable);
        dataset3.setDataSource(new Datasource3Expression());

        rb.addParameter("parameter", "parameter_value")
          .title(cht.barChart()
                    .setSubDataset(dataset1)
                    .setTitle(new TitleExpression())
                    .setCategory("field1", String.class)
                    .series(cht.serie("field3", Integer.class)
                               .setLabel("f3"), cht.serie(new ValueExpression())
                                                   .setLabel("exp")), cht.barChart()
                                                                         .setSubDataset(dataset2)
                                                                         .customizers(new Customizer())
                                                                         .setCategory(new CategoryExpression())
                                                                         .series(cht.serie(col.column("Column2", "field2", Integer.class)), cht.serie("field3", Integer.class)
                                                                                                                                               .setLabel("f3"), cht.serie(new ValueExpression())
                                                                                                                                                                   .setLabel("exp")), cht.barChart()
                                                                                                                                                                                         .setSubDataset(
                                                                                                                                                                                             dataset3)
                                                                                                                                                                                         .setCategory(
                                                                                                                                                                                             "field1",
                                                                                                                                                                                             String
                                                                                                                                                                                                 .class)
                                                                                                                                                                                         .series(
                                                                                                                                                                                             cht.serie(
                                                                                                                                                                                                 variable)
                                                                                                                                                                                                .setLabel(
                                                                                                                                                                                                    "exp")));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        String[] categories = new String[] {"value1", "value2", "value3", "value4"};
        String[] series = new String[] {"f3", "exp"};
        Number[][] values = new Number[][] {{4d, 6d}, {6d, 10d}, {8d, 14d}, {10d, 18d}};

        chartCountTest("title.chart1", 1);
        chartTitleTest("title.chart1", 0, "Title");
        chartCategoryCountTest("title.chart1", 0, 4);
        chartSeriesCountTest("title.chart1", 0, 2);
        chartDataTest("title.chart1", 0, categories, series, values);

        categories = new String[] {"value1_exp", "value2_exp", "value3_exp", "value4_exp"};
        series = new String[] {"Column2", "f3", "exp"};
        values = new Number[][] {{2d, 4d, 6d}, {4d, 6d, 10d}, {6d, 8d, 14d}, {8d, 10d, 18d}};

        chartCountTest("title.chart2", 1);
        chartTitleTest("title.chart2", 0, "customizer1");
        chartCategoryCountTest("title.chart2", 0, 4);
        chartSeriesCountTest("title.chart2", 0, 3);
        chartDataTest("title.chart2", 0, categories, series, values);

        categories = new String[] {"value1", "value2", "value3", "value4"};
        series = new String[] {"exp"};
        values = new Number[][] {{2}, {6}, {12}, {20}};

        chartCountTest("title.chart3", 1);
        chartTitleTest("title.chart3", 0, null);
        chartCategoryCountTest("title.chart3", 0, 4);
        chartSeriesCountTest("title.chart3", 0, 1);
        chartDataTest("title.chart3", 0, categories, series, values);
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
            Assert.assertNotNull(reportParameters.getMasterParameters());
            try {
                reportParameters.getValue("parameter");
                Assert.fail("parameter is not null");
            } catch (Exception e) {
            }
            Assert.assertEquals("parameter_value", reportParameters.getMasterParameters()
                                                                   .getValue("parameter"));

            double f1 = ((Number) reportParameters.getValue("field2")).doubleValue();
            double f2 = ((Number) reportParameters.getValue("field3")).doubleValue();
            return f1 + f2;
        }
    }

    private class CategoryExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            Assert.assertNotNull(reportParameters.getMasterParameters());
            try {
                reportParameters.getValue("parameter");
                Assert.fail("parameter is not null");
            } catch (Exception e) {
            }
            Assert.assertEquals("parameter_value", reportParameters.getMasterParameters()
                                                                   .getValue("parameter"));
            return (String) reportParameters.getValue("field1") + "_exp";
        }
    }

    private class TitleExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            Assert.assertNull(reportParameters.getMasterParameters());
            Assert.assertEquals("parameter_value", reportParameters.getValue("parameter"));
            return "Title";
        }
    }

    private class Customizer implements DRIChartCustomizer, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public void customize(JFreeChart chart, ReportParameters reportParameters) {
            Assert.assertNull(reportParameters.getMasterParameters());
            Assert.assertEquals("parameter_value", reportParameters.getValue("parameter"));
            chart.setTitle("customizer" + reportParameters.getPageNumber());
        }
    }

    private class Datasource3Expression extends AbstractSimpleExpression<JRDataSource> {
        private static final long serialVersionUID = 1L;

        @Override
        public JRDataSource evaluate(ReportParameters reportParameters) {
            Assert.assertNull(reportParameters.getMasterParameters());
            Assert.assertEquals("parameter_value", reportParameters.getValue("parameter"));
            return createDataSource();
        }
    }
}

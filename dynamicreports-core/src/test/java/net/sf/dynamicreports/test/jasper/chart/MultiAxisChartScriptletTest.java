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

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.chart.BarChartBuilder;
import net.sf.dynamicreports.report.builder.chart.LineChartBuilder;
import net.sf.dynamicreports.report.builder.chart.TimeSeriesChartBuilder;
import net.sf.dynamicreports.report.constant.TimePeriod;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class MultiAxisChartScriptletTest extends AbstractJasperChartTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        FieldBuilder<Date> field1 = field("field1", type.dateType());
        FieldBuilder<Integer> field2 = field("field2", type.integerType());
        FieldBuilder<Integer> field3 = field("field3", type.integerType());
        FieldBuilder<String> field4 = field("field4", type.stringType());

        TimeSeriesChartBuilder chart1 = cht.timeSeriesChart()
                                           .customizers(new Customizer1())
                                           .setTimePeriod(field1)
                                           .setTimePeriodType(TimePeriod.DAY)
                                           .series(cht.serie(field2)
                                                      .setLabel("serie1"));

        TimeSeriesChartBuilder chart2 = cht.timeSeriesChart()
                                           .setTimePeriod(field1)
                                           .setTimePeriodType(TimePeriod.DAY)
                                           .series(cht.serie(field3)
                                                      .setLabel("serie2"));

        BarChartBuilder chart3 = cht.barChart()
                                    .customizers(new Customizer3())
                                    .setCategory(field4)
                                    .series(cht.serie(field2));

        LineChartBuilder chart4 = cht.lineChart()
                                     .customizers(new Customizer4())
                                     .setCategory(field4)
                                     .series(cht.serie(field3));

        rb.summary(cht.multiAxisChart(chart1, chart2)
                      .customizers(new Customizer2()), cht.multiAxisChart(chart3, chart4)
                                                          .customizers(new Customizer5()));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        for (int i = 0; i < 4; i++) {
            dataSource.add(c.getTime(), i + 1, i * i, "value" + i);
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dataSource;
    }

    private class Customizer1 implements DRIChartCustomizer, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public void customize(JFreeChart chart, ReportParameters reportParameters) {
            XYItemRenderer renderer = chart.getXYPlot()
                                           .getRenderer();
            Assert.assertEquals("renderer", XYLineAndShapeRenderer.class, renderer.getClass());
        }
    }

    private class Customizer2 implements DRIChartCustomizer, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public void customize(JFreeChart chart, ReportParameters reportParameters) {
            XYItemRenderer renderer = chart.getXYPlot()
                                           .getRenderer(0);
            Assert.assertEquals("renderer", XYLineAndShapeRenderer.class, renderer.getClass());
            renderer = chart.getXYPlot()
                            .getRenderer(1);
            Assert.assertEquals("renderer", XYLineAndShapeRenderer.class, renderer.getClass());
        }
    }

    private class Customizer3 implements DRIChartCustomizer, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public void customize(JFreeChart chart, ReportParameters reportParameters) {
            CategoryItemRenderer renderer = chart.getCategoryPlot()
                                                 .getRenderer();
            Assert.assertEquals("renderer", BarRenderer.class, renderer.getClass());
        }
    }

    private class Customizer4 implements DRIChartCustomizer, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public void customize(JFreeChart chart, ReportParameters reportParameters) {
            CategoryItemRenderer renderer = chart.getCategoryPlot()
                                                 .getRenderer();
            Assert.assertEquals("renderer", LineAndShapeRenderer.class, renderer.getClass());
        }
    }

    private class Customizer5 implements DRIChartCustomizer, Serializable {
        private static final long serialVersionUID = 1L;

        @Override
        public void customize(JFreeChart chart, ReportParameters reportParameters) {
            CategoryItemRenderer renderer = chart.getCategoryPlot()
                                                 .getRenderer(0);
            Assert.assertEquals("renderer", BarRenderer.class, renderer.getClass());
            renderer = chart.getCategoryPlot()
                            .getRenderer(1);
            Assert.assertEquals("renderer", LineAndShapeRenderer.class, renderer.getClass());
        }
    }

}

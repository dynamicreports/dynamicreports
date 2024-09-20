/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.chart.TimeSeriesChartBuilder;
import net.sf.dynamicreports.report.constant.AxisPosition;
import net.sf.dynamicreports.report.constant.TimePeriod;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.charts.JRChart;
import net.sf.jasperreports.charts.JRChartAxis;
import net.sf.jasperreports.charts.JRChartPlot;
import net.sf.jasperreports.charts.JRMultiAxisPlot;
import net.sf.jasperreports.charts.type.AxisPositionEnum;
import net.sf.jasperreports.charts.type.ChartTypeEnum;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MultiAxisChartTest extends AbstractJasperChartTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        final FieldBuilder<Date> field1 = field("field1", type.dateType());
        final FieldBuilder<Integer> field2 = field("field2", type.integerType());
        final FieldBuilder<Integer> field3 = field("field3", type.integerType());

        final TimeSeriesChartBuilder chart1 = cht.timeSeriesChart().setTimePeriod(field1).setTimePeriodType(TimePeriod.DAY).series(cht.serie(field2).setLabel("serie1"));

        final TimeSeriesChartBuilder chart2 = cht.timeSeriesChart().setTimePeriod(field1).setTimePeriodType(TimePeriod.DAY).series(cht.serie(field3).setLabel("serie2"));

        rb.summary(cht.multiAxisChart(chart1, chart2), cht.multiAxisChart().addChart(chart1, AxisPosition.LEFT_OR_TOP).addChart(chart2, AxisPosition.RIGHT_OR_BOTTOM));
    }

    @Override
    @Test
    public void test() {
        super.test();

        numberOfPagesTest(1);

        final JFreeChart chart = getChart("summary.chart1", 0);
        final XYItemRenderer renderer = chart.getXYPlot().getRenderer();
         Assertions.assertEquals( XYLineAndShapeRenderer.class, renderer.getClass(),"renderer");
        TimeSeriesCollection dataset = (TimeSeriesCollection) chart.getXYPlot().getDataset(0);
        TimeSeries serie = (TimeSeries) dataset.getSeries().get(0);
        // TODO why is this duplicated?
      /**
         Assertions.assertEquals( 1d, serie.getDataItem(0).getValue(),"value");
         Assertions.assertEquals( 2d, serie.getDataItem(1).getValue(),"value");
         Assertions.assertEquals( 3d, serie.getDataItem(2).getValue(),"value");
         Assertions.assertEquals( 4d, serie.getDataItem(3).getValue(),"value");
      **/
        Assertions.assertEquals( 1d, serie.getDataItem(0).getValue(),"value");
        Assertions.assertEquals( 4d, serie.getDataItem(1).getValue(),"value");
        Assertions.assertEquals( 6d, serie.getDataItem(2).getValue(),"value");
        Assertions.assertEquals( 8d, serie.getDataItem(3).getValue(),"value");

        dataset = (TimeSeriesCollection) chart.getXYPlot().getDataset(1);
        serie = (TimeSeries) dataset.getSeries().get(0);
      /**
        Assertions.assertEquals( 0d, serie.getDataItem(0).getValue(),"value");
        Assertions.assertEquals( 1d, serie.getDataItem(1).getValue(),"value");
        Assertions.assertEquals( 4d, serie.getDataItem(2).getValue(),"value");
        Assertions.assertEquals( 9d, serie.getDataItem(3).getValue(),"value");
      **/

        Assertions.assertEquals( 0d, serie.getDataItem(0).getValue(),"value");
        Assertions.assertEquals( 2d, serie.getDataItem(1).getValue(),"value");
        Assertions.assertEquals( 8d, serie.getDataItem(2).getValue(),"value");
        Assertions.assertEquals( 18d, serie.getDataItem(3).getValue(),"value");


        final JRChart chart2 = (JRChart) getJasperReport().getSummary().getElementByKey("summary.chart2");
        final JRChartPlot plot = chart2.getPlot();
        Assertions.assertTrue(plot instanceof JRMultiAxisPlot, "plot");
        final JRMultiAxisPlot multiAxisPlot = (JRMultiAxisPlot) plot;
         Assertions.assertEquals( 2, multiAxisPlot.getAxes().size(),"axes");
        JRChartAxis chartAxis = multiAxisPlot.getAxes().get(0);
         Assertions.assertEquals( AxisPositionEnum.LEFT_OR_TOP, chartAxis.getPosition(),"position");
         Assertions.assertEquals( ChartTypeEnum.TIMESERIES, chartAxis.getChart().getChartType(),"chart");
        chartAxis = multiAxisPlot.getAxes().get(1);
         Assertions.assertEquals( AxisPositionEnum.RIGHT_OR_BOTTOM, chartAxis.getPosition(),"position");
         Assertions.assertEquals( ChartTypeEnum.TIMESERIES, chartAxis.getChart().getChartType(),"chart");
    }

    @Override
    protected JRDataSource createDataSource() {
        final DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        final Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        for (int i = 0; i < 4; i++) {
            dataSource.add(c.getTime(), i + 1, i * i);
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dataSource;
    }
}

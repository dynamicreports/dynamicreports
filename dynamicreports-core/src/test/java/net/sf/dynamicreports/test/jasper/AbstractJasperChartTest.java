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
package net.sf.dynamicreports.test.jasper;

import junit.framework.Assert;
import net.sf.jasperreports.charts.util.DrawChartRendererImpl;
import net.sf.jasperreports.engine.JRPrintImage;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.gantt.GanttCategoryDataset;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class AbstractJasperChartTest extends AbstractJasperValueTest {

    protected void chartCountTest(String name, int expectedNumberOfCharts) {
        Assert.assertEquals("chart count " + name, expectedNumberOfCharts, findElement(name).size());
    }

    protected void chartCategoryCountTest(String name, int index, int expectedNumberOfCategories) {
        Assert.assertEquals("chart category count " + name, expectedNumberOfCategories, getChart(name, index).getCategoryPlot()
                                                                                                             .getDataset()
                                                                                                             .getColumnCount());
    }

    protected void chartSeriesCountTest(String name, int index, int expectedNumberOfSeries) {
        Assert.assertEquals("chart series count " + name, expectedNumberOfSeries, getChart(name, index).getCategoryPlot()
                                                                                                       .getDataset()
                                                                                                       .getRowCount());
    }

    protected void chartTitleTest(String name, int index, String title) {
        TextTitle chartTitle = getChart(name, index).getTitle();
        if (title != null) {
            Assert.assertEquals("chart title", title, chartTitle.getText());
        } else {
            Assert.assertNull("chart title", chartTitle);
        }
    }

    protected void chartDataTest(String name, int index, String[] categories, String[] series, Number[][] values) {
        CategoryDataset dataset = getChart(name, index).getCategoryPlot()
                                                       .getDataset();
        for (int i = 0; i < categories.length; i++) {
            for (int j = 0; j < series.length; j++) {
                Assert.assertEquals("chart data", values[i][j], dataset.getValue(series[j], categories[i]));
            }
        }
    }

    protected void xyChartDataTest(JFreeChart chart, int series, String seriesName, Number[][] values) {
        XYDataset dataset = chart.getXYPlot()
                                 .getDataset();
        int index = 0;
        for (Number[] numbers : values) {
            Assert.assertEquals("chart data series name", seriesName, dataset.getSeriesKey(series));
            Assert.assertEquals("chart data x", numbers[0], dataset.getXValue(series, index));
            Assert.assertEquals("chart data y", numbers[1], dataset.getYValue(series, index));
            index++;
        }
    }

    protected void xyzChartDataTest(JFreeChart chart, int series, String seriesName, Number[][] values) {
        XYZDataset dataset = (XYZDataset) chart.getXYPlot()
                                               .getDataset();
        int index = 0;
        for (Number[] numbers : values) {
            Assert.assertEquals("chart data series name", seriesName, dataset.getSeriesKey(series));
            Assert.assertEquals("chart data x", numbers[0], dataset.getXValue(series, index));
            Assert.assertEquals("chart data y", numbers[1], dataset.getYValue(series, index));
            Assert.assertEquals("chart data z", numbers[2], dataset.getZValue(series, index));
            index++;
        }
    }

    protected void highLowChartDataTest(JFreeChart chart, int series, Object[][] values) {
        DefaultHighLowDataset dataset = (DefaultHighLowDataset) chart.getXYPlot()
                                                                     .getDataset();
        int index = 0;
        for (Object[] value : values) {
            Assert.assertEquals("chart data series", value[0], dataset.getSeriesKey(series));
            Assert.assertEquals("chart data date", value[1], dataset.getXDate(series, index));
            Assert.assertEquals("chart data high value", value[2], dataset.getHigh(series, index));
            Assert.assertEquals("chart data low value", value[3], dataset.getLow(series, index));
            Assert.assertEquals("chart data open value", value[4], dataset.getOpenValue(series, index));
            Assert.assertEquals("chart data close value", value[5], dataset.getClose(series, index));
            Assert.assertEquals("chart data volume value", value[6], dataset.getVolume(series, index));
            index++;
        }
    }

    protected void ganttChartDataTest(JFreeChart chart, String serie, String[] tasks, Object[][] values) {
        GanttCategoryDataset dataset = (GanttCategoryDataset) chart.getCategoryPlot()
                                                                   .getDataset();
        for (int i = 0; i < tasks.length; i++) {
            Assert.assertEquals("chart data start value", ((Date) values[i][0]).getTime(), dataset.getStartValue(serie, tasks[i]));
            Assert.assertEquals("chart data end value", ((Date) values[i][1]).getTime(), dataset.getEndValue(serie, tasks[i]));
            Assert.assertEquals("chart data percent value", values[i][2], dataset.getPercentComplete(serie, tasks[i], 0));
        }
    }

    protected JFreeChart getChart(String key, int index) {
        JRPrintImage image = (JRPrintImage) getElementAt(key, index);
        return getChart(image);
    }

    protected JFreeChart getChart(JRPrintImage image) {
        DrawChartRendererImpl renderer = (DrawChartRendererImpl) image.getRenderer();
        try {
            Field field = renderer.getClass()
                                  .getDeclaredField("chart");
            field.setAccessible(true);
            return (JFreeChart) field.get(renderer);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        return null;
    }
}

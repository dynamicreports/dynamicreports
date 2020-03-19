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
package net.sf.dynamicreports.adhoc.test;

import net.sf.dynamicreports.adhoc.configuration.AdhocConfiguration;
import net.sf.dynamicreports.adhoc.report.DefaultAdhocReportCustomizer;
import net.sf.dynamicreports.report.base.chart.DRChart;
import net.sf.dynamicreports.report.base.chart.dataset.DRCategoryDataset;
import net.sf.dynamicreports.report.base.chart.dataset.DRSeriesDataset;
import net.sf.dynamicreports.report.base.chart.dataset.DRTimeSeriesDataset;
import net.sf.dynamicreports.report.base.chart.plot.DRAxisPlot;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.definition.chart.dataset.DRICategoryChartSerie;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIChartSerie;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIXyChartSerie;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIXyzChartSerie;
import net.sf.dynamicreports.report.exception.DRException;
import org.junit.Assert;
import org.junit.Test;

import java.awt.Color;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ricardo Mariaca
 */
public class AdhocChartLoadTest extends AdhocTests {

    @Test
    public void test() {
        try {
            InputStream is = AdhocChartLoadTest.class.getResourceAsStream("adhocconfiguration3.xml");
            AdhocConfiguration adhocConfiguration = adhocManager.loadConfiguration(is);
            testConfiguration(adhocConfiguration);
        } catch (DRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    private void testConfiguration(AdhocConfiguration adhocConfiguration) {
        ReportCustomizer customizer = new ReportCustomizer();
        try {
            adhocManager.createReport(adhocConfiguration.getReport(), customizer);
        } catch (DRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

        DRChart chart = (DRChart) customizer.getComponents().get(0).getComponent();
        Assert.assertEquals("component key", adhocConfiguration.getReport().getComponents().get(0), adhocConfiguration.getReport().getComponent("chart1"));
        Assert.assertEquals("chart type", ChartType.AREA, chart.getChartType());
        Assert.assertNotNull("chart title", chart.getTitle().getTitle());
        Assert.assertNotNull("chart title font", chart.getTitle().getFont());
        Assert.assertEquals("chart title color", Color.MAGENTA, chart.getTitle().getColor());
        Assert.assertTrue("chart show legend", chart.getLegend().getShowLegend());
        Assert.assertNotNull("chart category", ((DRCategoryDataset) chart.getDataset()).getValueExpression());
        DRIChartSerie chartSerie = ((DRCategoryDataset) chart.getDataset()).getSeries().get(0);
        Assert.assertNotNull("chart serie series", chartSerie.getSeriesExpression());
        Assert.assertNotNull("chart serie value", ((DRICategoryChartSerie) chartSerie).getValueExpression());
        Assert.assertNotNull("chart serie label", ((DRICategoryChartSerie) chartSerie).getLabelExpression());
        Assert.assertEquals("chart series color", Color.LIGHT_GRAY, ((DRAxisPlot) chart.getPlot()).getSeriesColors().get(0));
        Assert.assertNotNull("chart category axis format", ((DRAxisPlot) chart.getPlot()).getXAxisFormat());
        Assert.assertNotNull("chart value axis format", ((DRAxisPlot) chart.getPlot()).getYAxisFormat());
        Assert.assertNotNull("axis format label", ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelExpression());
        Assert.assertNotNull("axis format label font", ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelFont());
        Assert.assertEquals("axis format label color", Color.BLUE, ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelColor());
        Assert.assertEquals("chart orientation", Orientation.VERTICAL, ((DRAxisPlot) chart.getPlot()).getOrientation());
        Assert.assertTrue("chart use series as category", ((DRCategoryDataset) chart.getDataset()).getUseSeriesAsCategory());

        chart = (DRChart) customizer.getComponents().get(1).getComponent();
        Assert.assertEquals("component key", adhocConfiguration.getReport().getComponents().get(1), adhocConfiguration.getReport().getComponent("chart2"));
        Assert.assertEquals("chart type", ChartType.TIMESERIES, chart.getChartType());
        Assert.assertNotNull("chart title", chart.getTitle().getTitle());
        Assert.assertNotNull("chart title font", chart.getTitle().getFont());
        Assert.assertEquals("chart title color", Color.MAGENTA, chart.getTitle().getColor());
        Assert.assertTrue("chart show legend", chart.getLegend().getShowLegend());
        Assert.assertNotNull("chart time value", ((DRTimeSeriesDataset) chart.getDataset()).getValueExpression());
        chartSerie = ((DRTimeSeriesDataset) chart.getDataset()).getSeries().get(0);
        Assert.assertNotNull("chart serie series", chartSerie.getSeriesExpression());
        Assert.assertNotNull("chart serie value", ((DRICategoryChartSerie) chartSerie).getValueExpression());
        Assert.assertNotNull("chart serie label", ((DRICategoryChartSerie) chartSerie).getLabelExpression());
        Assert.assertEquals("chart series color", Color.LIGHT_GRAY, ((DRAxisPlot) chart.getPlot()).getSeriesColors().get(0));
        Assert.assertNotNull("chart category axis format", ((DRAxisPlot) chart.getPlot()).getXAxisFormat());
        Assert.assertNotNull("chart value axis format", ((DRAxisPlot) chart.getPlot()).getYAxisFormat());
        Assert.assertNotNull("axis format label", ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelExpression());
        Assert.assertNotNull("axis format label font", ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelFont());
        Assert.assertEquals("axis format label color", Color.BLUE, ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelColor());
        Assert.assertEquals("chart orientation", Orientation.VERTICAL, ((DRAxisPlot) chart.getPlot()).getOrientation());

        chart = (DRChart) customizer.getComponents().get(2).getComponent();
        Assert.assertEquals("component key", adhocConfiguration.getReport().getComponents().get(2), adhocConfiguration.getReport().getComponent("chart3"));
        Assert.assertEquals("chart type", ChartType.PIE, chart.getChartType());
        Assert.assertNotNull("chart title", chart.getTitle().getTitle());
        Assert.assertNotNull("chart title font", chart.getTitle().getFont());
        Assert.assertEquals("chart title color", Color.MAGENTA, chart.getTitle().getColor());
        Assert.assertTrue("chart show legend", chart.getLegend().getShowLegend());
        Assert.assertNotNull("chart key value", ((DRSeriesDataset) chart.getDataset()).getValueExpression());
        chartSerie = ((DRSeriesDataset) chart.getDataset()).getSeries().get(0);
        Assert.assertNotNull("chart serie series", chartSerie.getSeriesExpression());
        Assert.assertNotNull("chart serie value", ((DRICategoryChartSerie) chartSerie).getValueExpression());
        Assert.assertNotNull("chart serie label", ((DRICategoryChartSerie) chartSerie).getLabelExpression());

        chart = (DRChart) customizer.getComponents().get(3).getComponent();
        Assert.assertEquals("component key", adhocConfiguration.getReport().getComponents().get(3), adhocConfiguration.getReport().getComponent("chart4"));
        Assert.assertEquals("chart type", ChartType.XYBAR, chart.getChartType());
        Assert.assertNotNull("chart title", chart.getTitle().getTitle());
        Assert.assertNotNull("chart title font", chart.getTitle().getFont());
        Assert.assertEquals("chart title color", Color.MAGENTA, chart.getTitle().getColor());
        Assert.assertTrue("chart show legend", chart.getLegend().getShowLegend());
        Assert.assertNotNull("chart time value", ((DRSeriesDataset) chart.getDataset()).getValueExpression());
        chartSerie = ((DRSeriesDataset) chart.getDataset()).getSeries().get(0);
        Assert.assertNotNull("chart serie series", chartSerie.getSeriesExpression());
        Assert.assertNotNull("chart serie value", ((DRIXyChartSerie) chartSerie).getYValueExpression());
        Assert.assertNotNull("chart serie label", ((DRIXyChartSerie) chartSerie).getLabelExpression());
        Assert.assertEquals("chart series color", Color.LIGHT_GRAY, ((DRAxisPlot) chart.getPlot()).getSeriesColors().get(0));
        Assert.assertNotNull("chart category axis format", ((DRAxisPlot) chart.getPlot()).getXAxisFormat());
        Assert.assertNotNull("chart value axis format", ((DRAxisPlot) chart.getPlot()).getYAxisFormat());
        Assert.assertNotNull("axis format label", ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelExpression());
        Assert.assertNotNull("axis format label font", ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelFont());
        Assert.assertEquals("axis format label color", Color.BLUE, ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelColor());
        Assert.assertEquals("chart orientation", Orientation.VERTICAL, ((DRAxisPlot) chart.getPlot()).getOrientation());

        chart = (DRChart) customizer.getComponents().get(4).getComponent();
        Assert.assertEquals("component key", adhocConfiguration.getReport().getComponents().get(4), adhocConfiguration.getReport().getComponent("chart5"));
        Assert.assertEquals("chart type", ChartType.SPIDER, chart.getChartType());
        Assert.assertNotNull("chart title", chart.getTitle().getTitle());
        Assert.assertNotNull("chart title font", chart.getTitle().getFont());
        Assert.assertEquals("chart title color", Color.MAGENTA, chart.getTitle().getColor());
        Assert.assertTrue("chart show legend", chart.getLegend().getShowLegend());
        Assert.assertNotNull("chart time value", ((DRCategoryDataset) chart.getDataset()).getValueExpression());
        chartSerie = ((DRCategoryDataset) chart.getDataset()).getSeries().get(0);
        Assert.assertNotNull("chart serie series", chartSerie.getSeriesExpression());
        Assert.assertNotNull("chart serie value", ((DRICategoryChartSerie) chartSerie).getValueExpression());
        Assert.assertNotNull("chart serie label", ((DRICategoryChartSerie) chartSerie).getLabelExpression());

        chart = (DRChart) customizer.getComponents().get(5).getComponent();
        Assert.assertEquals("component key", adhocConfiguration.getReport().getComponents().get(5), adhocConfiguration.getReport().getComponent("chart6"));
        Assert.assertEquals("chart type", ChartType.BUBBLE, chart.getChartType());
        Assert.assertNotNull("chart title", chart.getTitle().getTitle());
        Assert.assertNotNull("chart title font", chart.getTitle().getFont());
        Assert.assertEquals("chart title color", Color.MAGENTA, chart.getTitle().getColor());
        Assert.assertTrue("chart show legend", chart.getLegend().getShowLegend());
        Assert.assertNotNull("chart time value", ((DRSeriesDataset) chart.getDataset()).getValueExpression());
        chartSerie = ((DRSeriesDataset) chart.getDataset()).getSeries().get(0);
        Assert.assertNotNull("chart serie series", chartSerie.getSeriesExpression());
        Assert.assertNotNull("chart serie value", ((DRIXyzChartSerie) chartSerie).getYValueExpression());
        Assert.assertNotNull("chart serie label", ((DRIXyzChartSerie) chartSerie).getZValueExpression());
        Assert.assertEquals("chart series color", Color.LIGHT_GRAY, ((DRAxisPlot) chart.getPlot()).getSeriesColors().get(0));
        Assert.assertNotNull("chart category axis format", ((DRAxisPlot) chart.getPlot()).getXAxisFormat());
        Assert.assertNotNull("chart value axis format", ((DRAxisPlot) chart.getPlot()).getYAxisFormat());
        Assert.assertNotNull("axis format label", ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelExpression());
        Assert.assertNotNull("axis format label font", ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelFont());
        Assert.assertEquals("axis format label color", Color.BLUE, ((DRAxisPlot) chart.getPlot()).getXAxisFormat().getLabelColor());
        Assert.assertEquals("chart orientation", Orientation.VERTICAL, ((DRAxisPlot) chart.getPlot()).getOrientation());
    }

    private class ReportCustomizer extends DefaultAdhocReportCustomizer {

        private List<ComponentBuilder<?, ?>> getComponents() {
            return new ArrayList<ComponentBuilder<?, ?>>(components.values());
        }
    }
}

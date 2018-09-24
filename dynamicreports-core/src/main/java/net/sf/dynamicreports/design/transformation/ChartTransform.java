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
package net.sf.dynamicreports.design.transformation;

import net.sf.dynamicreports.design.base.DRDesignDataset;
import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.chart.DRDesignChart;
import net.sf.dynamicreports.design.base.chart.DRDesignChartLegend;
import net.sf.dynamicreports.design.base.chart.DRDesignChartSubtitle;
import net.sf.dynamicreports.design.base.chart.DRDesignChartTitle;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignCategoryChartSerie;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignCategoryDataset;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignChartDataset;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignChartSerie;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignGanttChartSerie;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignHighLowDataset;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignSeriesDataset;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignTimeSeriesDataset;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignValueDataset;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignXyChartSerie;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignXyzChartSerie;
import net.sf.dynamicreports.design.base.chart.plot.AbstractDesignBasePlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignAxisFormat;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignAxisPlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignBar3DPlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignBarPlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignBubblePlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignCandlestickPlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignChartAxis;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignHighLowPlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignLinePlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignMeterInterval;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignMeterPlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignMultiAxisPlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignPie3DPlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignPiePlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignSpiderPlot;
import net.sf.dynamicreports.design.base.chart.plot.DRDesignThermometerPlot;
import net.sf.dynamicreports.design.constant.DefaultStyleType;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.DRIDesignHyperLink;
import net.sf.dynamicreports.design.definition.DRIDesignVariable;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignPlot;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.exception.DRDesignReportException;
import net.sf.dynamicreports.design.transformation.chartcustomizer.DifferenceRendererCustomizer;
import net.sf.dynamicreports.design.transformation.chartcustomizer.GroupedStackedBarRendererCustomizer;
import net.sf.dynamicreports.design.transformation.chartcustomizer.LayeredBarRendererCustomizer;
import net.sf.dynamicreports.design.transformation.chartcustomizer.PieChartLabelFormatCustomizer;
import net.sf.dynamicreports.design.transformation.chartcustomizer.SeriesColorsByNameCustomizer;
import net.sf.dynamicreports.design.transformation.chartcustomizer.SeriesOrderCustomizer;
import net.sf.dynamicreports.design.transformation.chartcustomizer.ShowPercentagesCustomizer;
import net.sf.dynamicreports.design.transformation.chartcustomizer.ShowValuesCustomizer;
import net.sf.dynamicreports.design.transformation.chartcustomizer.WaterfallBarRendererCustomizer;
import net.sf.dynamicreports.design.transformation.chartcustomizer.XyBlockRendererCustomizer;
import net.sf.dynamicreports.design.transformation.chartcustomizer.XyStepRendererCustomizer;
import net.sf.dynamicreports.design.transformation.expressions.GroupedSeriesExpression;
import net.sf.dynamicreports.design.transformation.expressions.SerieValueExpression;
import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.OrderType;
import net.sf.dynamicreports.report.definition.DRIDataset;
import net.sf.dynamicreports.report.definition.chart.DRIChart;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
import net.sf.dynamicreports.report.definition.chart.DRIChartLegend;
import net.sf.dynamicreports.report.definition.chart.DRIChartSubtitle;
import net.sf.dynamicreports.report.definition.chart.DRIChartTitle;
import net.sf.dynamicreports.report.definition.chart.dataset.DRICategoryChartSerie;
import net.sf.dynamicreports.report.definition.chart.dataset.DRICategoryDataset;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIChartDataset;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIChartSerie;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIGanttChartSerie;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIGroupedCategoryChartSerie;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIHighLowDataset;
import net.sf.dynamicreports.report.definition.chart.dataset.DRISeriesDataset;
import net.sf.dynamicreports.report.definition.chart.dataset.DRITimeSeriesDataset;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIValueDataset;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIXyChartSerie;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIXyzChartSerie;
import net.sf.dynamicreports.report.definition.chart.plot.DRIAxisFormat;
import net.sf.dynamicreports.report.definition.chart.plot.DRIAxisPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIBar3DPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIBarPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIBasePlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIBubblePlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRICandlestickPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIChartAxis;
import net.sf.dynamicreports.report.definition.chart.plot.DRIDifferencePlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIGroupedStackedBarPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIHighLowPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRILayeredBarPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRILinePlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIMeterInterval;
import net.sf.dynamicreports.report.definition.chart.plot.DRIMeterPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIMultiAxisPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIPie3DPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIPiePlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRISpiderPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIThermometerPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIWaterfallBarPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIXyBlockPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIXyStepPlot;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.exception.DRException;

import java.awt.Color;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * <p>ChartTransform class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ChartTransform {
    private DesignTransformAccessor accessor;

    /**
     * <p>Constructor for ChartTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
     */
    public ChartTransform(DesignTransformAccessor accessor) {
        this.accessor = accessor;
    }

    // chart

    /**
     * <p>transform.</p>
     *
     * @param chart      a {@link net.sf.dynamicreports.report.definition.chart.DRIChart} object.
     * @param resetType  a {@link net.sf.dynamicreports.design.constant.ResetType} object.
     * @param resetGroup a {@link net.sf.dynamicreports.design.base.DRDesignGroup} object.
     * @return a {@link net.sf.dynamicreports.design.base.chart.DRDesignChart} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRDesignChart transform(DRIChart chart, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        return transform(chart, null, resetType, resetGroup);
    }

    private DRDesignChart transform(DRIChart chart, DRIDataset subDataset, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignChart designChart = new DRDesignChart();
        designChart.setWidth(accessor.getTemplateTransform().getChartWidth(chart));
        designChart.setHeight(accessor.getTemplateTransform().getChartHeight(chart));
        designChart.setChartType(chart.getChartType());
        designChart.setTheme(accessor.getTemplateTransform().getChartTheme(chart));
        if (!(chart.getPlot() instanceof DRIMultiAxisPlot)) {
            designChart.setDataset(dataset(chart.getDataset(), subDataset, resetType, resetGroup));
        }
        designChart.setPlot(plot(chart.getPlot(), designChart.getCustomizers(), chart.getDataset().getSubDataset(), resetType, resetGroup));
        designChart.setTitle(title(chart.getTitle()));
        designChart.setSubtitle(subtitle(chart.getSubtitle()));
        designChart.setLegend(legend(chart.getLegend()));

        if (!chart.getCustomizers().isEmpty()) {
            designChart.getCustomizers().addAll(chart.getCustomizers());
        }

        return designChart;
    }

    // plot
    private DRIDesignPlot plot(DRIPlot plot, List<DRIChartCustomizer> chartCustomizers, DRIDataset subDataset, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRIDesignPlot designPlot;

        if (plot instanceof DRIBar3DPlot) {
            designPlot = bar3DPlot((DRIBar3DPlot) plot, chartCustomizers);
        } else if (plot instanceof DRILayeredBarPlot) {
            designPlot = layeredBarPlot((DRILayeredBarPlot) plot, chartCustomizers);
        } else if (plot instanceof DRIWaterfallBarPlot) {
            designPlot = waterfallBarPlot((DRIWaterfallBarPlot) plot, chartCustomizers);
        } else if (plot instanceof DRIGroupedStackedBarPlot) {
            designPlot = groupedStackedBarPlot((DRIGroupedStackedBarPlot) plot, chartCustomizers);
        } else if (plot instanceof DRIBarPlot) {
            designPlot = barPlot((DRIBarPlot) plot, chartCustomizers);
        } else if (plot instanceof DRIDifferencePlot) {
            designPlot = differencePlot((DRIDifferencePlot) plot, chartCustomizers);
        } else if (plot instanceof DRIXyStepPlot) {
            designPlot = xyStepPlot((DRIXyStepPlot) plot, chartCustomizers);
        } else if (plot instanceof DRILinePlot) {
            designPlot = linePlot((DRILinePlot) plot, chartCustomizers);
        } else if (plot instanceof DRIMultiAxisPlot) {
            designPlot = multiAxisPlot((DRIMultiAxisPlot) plot, chartCustomizers, subDataset, resetType, resetGroup);
        } else if (plot instanceof DRIPie3DPlot) {
            designPlot = pie3DPlot((DRIPie3DPlot) plot, chartCustomizers);
        } else if (plot instanceof DRIPiePlot) {
            designPlot = piePlot((DRIPiePlot) plot, chartCustomizers);
        } else if (plot instanceof DRISpiderPlot) {
            designPlot = spiderPlot((DRISpiderPlot) plot);
        } else if (plot instanceof DRIXyBlockPlot) {
            designPlot = xyBlockPlot((DRIXyBlockPlot) plot, chartCustomizers);
        } else if (plot instanceof DRIBubblePlot) {
            designPlot = bubblePlot((DRIBubblePlot) plot, chartCustomizers);
        } else if (plot instanceof DRICandlestickPlot) {
            designPlot = candlestickPlot((DRICandlestickPlot) plot, chartCustomizers);
        } else if (plot instanceof DRIHighLowPlot) {
            designPlot = highLowPlot((DRIHighLowPlot) plot, chartCustomizers);
        } else if (plot instanceof DRIMeterPlot) {
            designPlot = meterPlot((DRIMeterPlot) plot);
        } else if (plot instanceof DRIThermometerPlot) {
            designPlot = thermometerPlot((DRIThermometerPlot) plot);
        } else if (plot instanceof DRIAxisPlot) {
            designPlot = axisPlot((DRIAxisPlot) plot, chartCustomizers);
        } else {
            throw new DRDesignReportException("Chart plot " + plot.getClass().getName() + " not supported");
        }

        if (plot instanceof DRIBasePlot) {
            AbstractDesignBasePlot designBasePlot = ((AbstractDesignBasePlot) designPlot);
            DRIBasePlot basePlot = (DRIBasePlot) plot;
            designBasePlot.setOrientation(basePlot.getOrientation());
            designBasePlot.setSeriesColors(accessor.getTemplateTransform().getChartSeriesColors(basePlot));
            Map<String, Color> seriesColorsByName = basePlot.getSeriesColorsByName();
            if (!seriesColorsByName.isEmpty()) {
                chartCustomizers.add(new SeriesColorsByNameCustomizer(seriesColorsByName));
            }
        }

        return designPlot;
    }

    private DRDesignBar3DPlot bar3DPlot(DRIBar3DPlot bar3DPlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        DRDesignBar3DPlot designBar3DPlot = new DRDesignBar3DPlot();
        axisPlot(designBar3DPlot, bar3DPlot, chartCustomizers);
        designBar3DPlot.setXOffset(bar3DPlot.getXOffset());
        designBar3DPlot.setYOffset(bar3DPlot.getYOffset());
        designBar3DPlot.setShowLabels(bar3DPlot.getShowLabels());
        return designBar3DPlot;
    }

    private DRDesignBarPlot barPlot(DRIBarPlot barPlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        DRDesignBarPlot designBarPlot = new DRDesignBarPlot();
        axisPlot(designBarPlot, barPlot, chartCustomizers);
        designBarPlot.setShowTickMarks(barPlot.getShowTickMarks());
        designBarPlot.setShowTickLabels(barPlot.getShowTickLabels());
        designBarPlot.setShowLabels(barPlot.getShowLabels());
        return designBarPlot;
    }

    private DRDesignBarPlot groupedStackedBarPlot(DRIGroupedStackedBarPlot groupedStackedBarPlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        GroupedStackedBarRendererCustomizer renderer = new GroupedStackedBarRendererCustomizer();
        chartCustomizers.add(renderer);
        DRDesignBarPlot designBarPlot = barPlot(groupedStackedBarPlot, chartCustomizers);
        return designBarPlot;
    }

    private DRDesignBarPlot layeredBarPlot(DRILayeredBarPlot layeredBarPlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        chartCustomizers.add(new LayeredBarRendererCustomizer(layeredBarPlot.getSeriesBarWidths()));
        DRDesignBarPlot designBarPlot = barPlot(layeredBarPlot, chartCustomizers);
        return designBarPlot;
    }

    private DRDesignBarPlot waterfallBarPlot(DRIWaterfallBarPlot waterfallBarPlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        WaterfallBarRendererCustomizer waterfallBarCustomizer = new WaterfallBarRendererCustomizer(waterfallBarPlot);
        chartCustomizers.add(waterfallBarCustomizer);
        DRDesignBarPlot designBarPlot = barPlot(waterfallBarPlot, chartCustomizers);
        return designBarPlot;
    }

    private DRDesignLinePlot linePlot(DRILinePlot linePlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        DRDesignLinePlot designLinePlot = new DRDesignLinePlot();
        axisPlot(designLinePlot, linePlot, chartCustomizers);
        designLinePlot.setShowShapes(linePlot.getShowShapes());
        designLinePlot.setShowLines(linePlot.getShowLines());
        return designLinePlot;
    }

    private DRDesignLinePlot differencePlot(DRIDifferencePlot differencePlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        DRDesignLinePlot designLinePlot = new DRDesignLinePlot();
        chartCustomizers.add(new DifferenceRendererCustomizer(differencePlot));
        axisPlot(designLinePlot, differencePlot, chartCustomizers);
        return designLinePlot;
    }

    private DRDesignLinePlot xyStepPlot(DRIXyStepPlot xyStepPlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        DRDesignLinePlot designLinePlot = new DRDesignLinePlot();
        chartCustomizers.add(new XyStepRendererCustomizer(xyStepPlot.getStepPoint()));
        axisPlot(designLinePlot, xyStepPlot, chartCustomizers);
        return designLinePlot;
    }

    private DRDesignMultiAxisPlot multiAxisPlot(DRIMultiAxisPlot multiAxisPlot, List<DRIChartCustomizer> chartCustomizers, DRIDataset subDataset, ResetType resetType, DRDesignGroup resetGroup)
        throws DRException {
        DRDesignMultiAxisPlot designMultiAxisPlot = new DRDesignMultiAxisPlot();
        axisPlot(designMultiAxisPlot, multiAxisPlot, chartCustomizers);
        for (DRIChartAxis axis : multiAxisPlot.getAxes()) {
            DRDesignChartAxis designAxis = new DRDesignChartAxis();
            designAxis.setPosition(axis.getPosition());
            DRDesignChart chart = transform(axis.getChart(), subDataset, resetType, resetGroup);
            chart.setStyle(accessor.getStyleTransform().transformStyle(axis.getChart().getStyle(), false, DefaultStyleType.CHART));
            chart.setUniqueName(ReportUtils.generateUniqueName("chart"));
            designAxis.setChart(chart);
            designMultiAxisPlot.getAxes().add(designAxis);
        }
        return designMultiAxisPlot;
    }

    private DRDesignPie3DPlot pie3DPlot(DRIPie3DPlot pie3DPlot, List<DRIChartCustomizer> chartCustomizers) {
        DRDesignPie3DPlot designPie3DPlot = new DRDesignPie3DPlot();
        piePlot(designPie3DPlot, pie3DPlot, chartCustomizers);
        designPie3DPlot.setDepthFactor(pie3DPlot.getDepthFactor());
        return designPie3DPlot;
    }

    private DRDesignPiePlot piePlot(DRIPiePlot piePlot, List<DRIChartCustomizer> chartCustomizers) {
        DRDesignPiePlot designPiePlot = new DRDesignPiePlot();
        piePlot(designPiePlot, piePlot, chartCustomizers);
        return designPiePlot;
    }

    private void piePlot(DRDesignPiePlot designPiePlot, DRIPiePlot piePlot, List<DRIChartCustomizer> chartCustomizers) {
        designPiePlot.setCircular(piePlot.getCircular());
        designPiePlot.setLabelFormat(piePlot.getLabelFormat());
        designPiePlot.setLegendLabelFormat(piePlot.getLegendLabelFormat());
        if (piePlot.getShowLabels() != null && !piePlot.getShowLabels()) {
            chartCustomizers.add(new PieChartLabelFormatCustomizer(null, null, null));
        } else {
            String labelFormat = piePlot.getLabelFormat();
            if (labelFormat == null) {
                labelFormat = "{0}";
            }
            if (piePlot.getShowValues() != null && piePlot.getShowValues()) {
                labelFormat += " = {1}";
            }
            if (piePlot.getShowPercentages() != null && piePlot.getShowPercentages()) {
                labelFormat += " ({2})";
            }
            String valuePattern = accessor.getTemplateTransform().getChartValuePattern(piePlot);
            String percentValuePattern = accessor.getTemplateTransform().getChartPercentValuePattern(piePlot);
            chartCustomizers.add(new PieChartLabelFormatCustomizer(labelFormat, valuePattern, percentValuePattern));
        }
    }

    private DRDesignSpiderPlot spiderPlot(DRISpiderPlot spiderPlot) throws DRException {
        DRDesignSpiderPlot designSpiderPlot = new DRDesignSpiderPlot();
        designSpiderPlot.setMaxValueExpression(accessor.getExpressionTransform().transformExpression(spiderPlot.getMaxValueExpression()));
        designSpiderPlot.setRotation(spiderPlot.getRotation());
        designSpiderPlot.setTableOrder(spiderPlot.getTableOrder());
        designSpiderPlot.setWebFilled(spiderPlot.getWebFilled());
        designSpiderPlot.setStartAngle(spiderPlot.getStartAngle());
        designSpiderPlot.setHeadPercent(spiderPlot.getHeadPercent());
        designSpiderPlot.setInteriorGap(spiderPlot.getInteriorGap());
        designSpiderPlot.setAxisLineColor(spiderPlot.getAxisLineColor());
        designSpiderPlot.setAxisLineWidth(spiderPlot.getAxisLineWidth());
        designSpiderPlot.setLabelFont(accessor.getStyleTransform().transformFont(spiderPlot.getLabelFont()));
        designSpiderPlot.setLabelGap(spiderPlot.getLabelGap());
        designSpiderPlot.setLabelColor(spiderPlot.getLabelColor());
        return designSpiderPlot;
    }

    private DRDesignAxisPlot xyBlockPlot(DRIXyBlockPlot xyBlockPlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        DRDesignBubblePlot designBubblePlot = new DRDesignBubblePlot();
        chartCustomizers.add(new XyBlockRendererCustomizer(xyBlockPlot));
        axisPlot(designBubblePlot, xyBlockPlot, chartCustomizers);
        return designBubblePlot;
    }

    private DRDesignBubblePlot bubblePlot(DRIBubblePlot bubblePlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        DRDesignBubblePlot designBubblePlot = new DRDesignBubblePlot();
        axisPlot(designBubblePlot, bubblePlot, chartCustomizers);
        designBubblePlot.setScaleType(bubblePlot.getScaleType());
        return designBubblePlot;
    }

    private DRDesignCandlestickPlot candlestickPlot(DRICandlestickPlot candlestickPlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        DRDesignCandlestickPlot designCandlestickPlot = new DRDesignCandlestickPlot();
        axisPlot(designCandlestickPlot, candlestickPlot, chartCustomizers);
        designCandlestickPlot.setShowVolume(candlestickPlot.getShowVolume());
        return designCandlestickPlot;
    }

    private DRDesignHighLowPlot highLowPlot(DRIHighLowPlot highLowPlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        DRDesignHighLowPlot designHighLowPlot = new DRDesignHighLowPlot();
        axisPlot(designHighLowPlot, highLowPlot, chartCustomizers);
        designHighLowPlot.setShowOpenTicks(highLowPlot.getShowOpenTicks());
        designHighLowPlot.setShowCloseTicks(highLowPlot.getShowCloseTicks());
        return designHighLowPlot;
    }

    private DRDesignMeterPlot meterPlot(DRIMeterPlot meterPlot) throws DRException {
        DRDesignMeterPlot designMeterPlot = new DRDesignMeterPlot();
        designMeterPlot.setDataRangeLowExpression(accessor.getExpressionTransform().transformExpression(meterPlot.getDataRangeLowExpression()));
        designMeterPlot.setDataRangeHighExpression(accessor.getExpressionTransform().transformExpression(meterPlot.getDataRangeHighExpression()));
        designMeterPlot.setValueColor(meterPlot.getValueColor());
        designMeterPlot.setValueMask(meterPlot.getValueMask());
        designMeterPlot.setValueFont(accessor.getStyleTransform().transformFont(meterPlot.getValueFont()));
        designMeterPlot.setShape(meterPlot.getShape());
        for (DRIMeterInterval interval : meterPlot.getIntervals()) {
            designMeterPlot.getIntervals().add(meterInterval(interval));
        }
        designMeterPlot.setMeterAngle(meterPlot.getMeterAngle());
        designMeterPlot.setUnits(meterPlot.getUnits());
        designMeterPlot.setTickInterval(meterPlot.getTickInterval());
        designMeterPlot.setMeterBackgroundColor(meterPlot.getMeterBackgroundColor());
        designMeterPlot.setNeedleColor(meterPlot.getNeedleColor());
        designMeterPlot.setTickColor(meterPlot.getTickColor());
        designMeterPlot.setTickLabelFont(accessor.getStyleTransform().transformFont(meterPlot.getTickLabelFont()));
        return designMeterPlot;
    }

    private DRDesignThermometerPlot thermometerPlot(DRIThermometerPlot thermometerPlot) throws DRException {
        DRDesignThermometerPlot designThermometerPlot = new DRDesignThermometerPlot();
        designThermometerPlot.setDataRangeLowExpression(accessor.getExpressionTransform().transformExpression(thermometerPlot.getDataRangeLowExpression()));
        designThermometerPlot.setDataRangeHighExpression(accessor.getExpressionTransform().transformExpression(thermometerPlot.getDataRangeHighExpression()));
        designThermometerPlot.setValueColor(thermometerPlot.getValueColor());
        designThermometerPlot.setValueMask(thermometerPlot.getValueMask());
        designThermometerPlot.setValueFont(accessor.getStyleTransform().transformFont(thermometerPlot.getValueFont()));
        designThermometerPlot.setValueLocation(accessor.getTemplateTransform().getChartThermometerPlotValueLocation(thermometerPlot));
        designThermometerPlot.setMercuryColor(thermometerPlot.getMercuryColor());
        designThermometerPlot.setLowDataRangeLowExpression(accessor.getExpressionTransform().transformExpression(thermometerPlot.getLowDataRangeLowExpression()));
        designThermometerPlot.setLowDataRangeHighExpression(accessor.getExpressionTransform().transformExpression(thermometerPlot.getLowDataRangeHighExpression()));
        designThermometerPlot.setMediumDataRangeLowExpression(accessor.getExpressionTransform().transformExpression(thermometerPlot.getMediumDataRangeLowExpression()));
        designThermometerPlot.setMediumDataRangeHighExpression(accessor.getExpressionTransform().transformExpression(thermometerPlot.getMediumDataRangeHighExpression()));
        designThermometerPlot.setHighDataRangeLowExpression(accessor.getExpressionTransform().transformExpression(thermometerPlot.getHighDataRangeLowExpression()));
        designThermometerPlot.setHighDataRangeHighExpression(accessor.getExpressionTransform().transformExpression(thermometerPlot.getHighDataRangeHighExpression()));
        return designThermometerPlot;
    }

    private DRDesignMeterInterval meterInterval(DRIMeterInterval interval) throws DRException {
        DRDesignMeterInterval designInterval = new DRDesignMeterInterval();
        designInterval.setLabel(interval.getLabel());
        designInterval.setBackgroundColor(interval.getBackgroundColor());
        designInterval.setAlpha(interval.getAlpha());
        designInterval.setDataRangeLowExpression(accessor.getExpressionTransform().transformExpression(interval.getDataRangeLowExpression()));
        designInterval.setDataRangeHighExpression(accessor.getExpressionTransform().transformExpression(interval.getDataRangeHighExpression()));
        return designInterval;
    }

    private DRDesignAxisPlot axisPlot(DRIAxisPlot axisPlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        DRDesignAxisPlot designAxisPlot = new DRDesignAxisPlot();
        axisPlot(designAxisPlot, axisPlot, chartCustomizers);
        return designAxisPlot;
    }

    private void axisPlot(DRDesignAxisPlot designAxisPlot, DRIAxisPlot axisPlot, List<DRIChartCustomizer> chartCustomizers) throws DRException {
        designAxisPlot.setXAxisFormat(axisFormat(axisPlot.getXAxisFormat()));
        designAxisPlot.setYAxisFormat(axisFormat(axisPlot.getYAxisFormat()));
        Comparator<String> seriesOrderBy = axisPlot.getSeriesOrderBy();
        OrderType seriesOrderType = axisPlot.getSeriesOrderType();
        if (seriesOrderBy != null || seriesOrderType != null) {
            chartCustomizers.add(new SeriesOrderCustomizer(seriesOrderBy, seriesOrderType));
        }
        if (axisPlot.getShowPercentages() != null && axisPlot.getShowPercentages()) {
            chartCustomizers.add(new ShowPercentagesCustomizer());
        }
        if (axisPlot.getShowValues() != null && axisPlot.getShowValues()) {
            String valuePattern;
            if (axisPlot.getShowPercentages() != null && axisPlot.getShowPercentages()) {
                valuePattern = accessor.getTemplateTransform().getChartPercentValuePattern(axisPlot);
            } else {
                valuePattern = accessor.getTemplateTransform().getChartValuePattern(axisPlot);
            }
            boolean customRangeMaxValue = false;
            if (axisPlot.getYAxisFormat() != null) {
                customRangeMaxValue = axisPlot.getYAxisFormat().getRangeMaxValueExpression() != null;
            }
            chartCustomizers.add(new ShowValuesCustomizer(valuePattern, customRangeMaxValue));
        }
    }

    // axis format
    private DRDesignAxisFormat axisFormat(DRIAxisFormat axisFormat) throws DRException {
        DRDesignAxisFormat designAxisFormat = new DRDesignAxisFormat();
        designAxisFormat.setLabelExpression(accessor.getExpressionTransform().transformExpression(axisFormat.getLabelExpression()));
        designAxisFormat.setLabelFont(accessor.getStyleTransform().transformFont(axisFormat.getLabelFont()));
        designAxisFormat.setLabelColor(axisFormat.getLabelColor());
        designAxisFormat.setTickLabelFont(accessor.getStyleTransform().transformFont(axisFormat.getTickLabelFont()));
        designAxisFormat.setTickLabelColor(axisFormat.getTickLabelColor());
        designAxisFormat.setTickLabelMask(axisFormat.getTickLabelMask());
        designAxisFormat.setVerticalTickLabels(axisFormat.getVerticalTickLabels());
        designAxisFormat.setTickLabelRotation(axisFormat.getTickLabelRotation());
        designAxisFormat.setLineColor(axisFormat.getLineColor());
        designAxisFormat.setRangeMinValueExpression(accessor.getExpressionTransform().transformExpression(axisFormat.getRangeMinValueExpression()));
        designAxisFormat.setRangeMaxValueExpression(accessor.getExpressionTransform().transformExpression(axisFormat.getRangeMaxValueExpression()));
        return designAxisFormat;
    }

    // title
    private DRDesignChartTitle title(DRIChartTitle title) throws DRException {
        DRDesignChartTitle designTitle = new DRDesignChartTitle();
        subtitle(designTitle, title);
        designTitle.setPosition(title.getPosition());
        return designTitle;
    }

    // subtitle
    private DRDesignChartSubtitle subtitle(DRIChartSubtitle subtitle) throws DRException {
        DRDesignChartSubtitle designSubtitle = new DRDesignChartSubtitle();
        subtitle(designSubtitle, subtitle);
        return designSubtitle;
    }

    private void subtitle(DRDesignChartSubtitle designSubtitle, DRIChartSubtitle subtitle) throws DRException {
        designSubtitle.setColor(subtitle.getColor());
        designSubtitle.setFont(accessor.getStyleTransform().transformFont(subtitle.getFont()));
        designSubtitle.setTitle(accessor.getExpressionTransform().transformExpression(subtitle.getTitle()));
    }

    // legend
    private DRDesignChartLegend legend(DRIChartLegend legend) {
        DRDesignChartLegend designLegend = new DRDesignChartLegend();
        designLegend.setColor(legend.getColor());
        designLegend.setBackgroundColor(legend.getBackgroundColor());
        designLegend.setShowLegend(legend.getShowLegend());
        designLegend.setFont(accessor.getStyleTransform().transformFont(legend.getFont()));
        designLegend.setPosition(legend.getPosition());
        return designLegend;
    }

    // dataset
    private DRDesignChartDataset dataset(DRIChartDataset dataset, DRIDataset subDataset, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignDataset designSubDataset = null;
        if (dataset.getSubDataset() != null) {
            designSubDataset = accessor.getDatasetTransform().transform(dataset.getSubDataset());
            accessor.transformToDataset(dataset.getSubDataset());
        } else {
            designSubDataset = accessor.getDatasetTransform().transform(subDataset);
            accessor.transformToDataset(subDataset);
        }

        DRDesignChartDataset designDataset;
        if (dataset instanceof DRICategoryDataset) {
            designDataset = categoryDataset((DRICategoryDataset) dataset, resetType, resetGroup);
        } else if (dataset instanceof DRITimeSeriesDataset) {
            designDataset = timeSeriesDataset((DRITimeSeriesDataset) dataset, resetType, resetGroup);
        } else if (dataset instanceof DRISeriesDataset) {
            designDataset = seriesDataset((DRISeriesDataset) dataset, resetType, resetGroup);
        } else if (dataset instanceof DRIHighLowDataset) {
            designDataset = highLowDataset((DRIHighLowDataset) dataset);
        } else if (dataset instanceof DRIValueDataset) {
            designDataset = valueDataset((DRIValueDataset) dataset);
        } else {
            throw new DRDesignReportException("Dataset " + dataset.getClass().getName() + " not supported");
        }

        designDataset.setSubDataset(designSubDataset);
        if (resetType != null && resetType.equals(ResetType.NONE)) {
            designDataset.setResetType(ResetType.REPORT);
        } else {
            designDataset.setResetType(resetType);
        }
        designDataset.setResetGroup(resetGroup);
        accessor.transformToMainDataset();

        return designDataset;
    }

    private void seriesDataset(DRISeriesDataset dataset, DRDesignSeriesDataset designDataset, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRIDesignExpression valueExpression = accessor.getExpressionTransform().transformExpression(dataset.getValueExpression());
        DRIDesignHyperLink datasetItemHyperLink = accessor.getReportTransform().hyperlink(dataset.getItemHyperLink());
        designDataset.setValueExpression(valueExpression);
        int index = 0;
        for (DRIChartSerie serie : dataset.getSeries()) {
            DRDesignChartSerie designSerie;
            if (serie instanceof DRIGroupedCategoryChartSerie) {
                designSerie = groupedCategorySerie(dataset.getSubDataset(), (DRIGroupedCategoryChartSerie) serie, valueExpression, resetType, resetGroup, index++);
            } else if (serie instanceof DRICategoryChartSerie) {
                designSerie = categorySerie(dataset.getSubDataset(), (DRICategoryChartSerie) serie, valueExpression, resetType, resetGroup, index++);
            } else if (serie instanceof DRIXyChartSerie) {
                designSerie = xySerie(dataset.getSubDataset(), (DRIXyChartSerie) serie, valueExpression, resetType, resetGroup, index++);
            } else if (serie instanceof DRIXyzChartSerie) {
                designSerie = xyzSerie(dataset.getSubDataset(), (DRIXyzChartSerie) serie, valueExpression, resetType, resetGroup, index++);
            } else if (serie instanceof DRIGanttChartSerie) {
                designSerie = ganttSerie(dataset.getSubDataset(), (DRIGanttChartSerie) serie, valueExpression, resetType, resetGroup, index++);
            } else {
                throw new DRDesignReportException("Chart serie " + serie.getClass().getName() + " not supported");
            }
            DRIDesignHyperLink itemHyperLink = accessor.getReportTransform().hyperlink(serie.getItemHyperLink());
            if (itemHyperLink == null) {
                itemHyperLink = datasetItemHyperLink;
            }
            designSerie.setItemHyperLink(itemHyperLink);

            designDataset.addSerie(designSerie);
        }
    }

    private DRDesignSeriesDataset seriesDataset(DRISeriesDataset dataset, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignSeriesDataset designDataset = new DRDesignSeriesDataset();
        seriesDataset(dataset, designDataset, resetType, resetGroup);
        return designDataset;
    }

    private DRDesignCategoryDataset categoryDataset(DRICategoryDataset dataset, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignCategoryDataset designDataset = new DRDesignCategoryDataset();
        seriesDataset(dataset, designDataset, resetType, resetGroup);
        designDataset.setUseSeriesAsCategory(accessor.getTemplateTransform().isChartCategoryDatasetUseSeriesAsCategory(dataset));
        return designDataset;
    }

    private DRDesignTimeSeriesDataset timeSeriesDataset(DRITimeSeriesDataset dataset, ResetType resetType, DRDesignGroup resetGroup) throws DRException {
        DRDesignTimeSeriesDataset designDataset = new DRDesignTimeSeriesDataset();
        seriesDataset(dataset, designDataset, resetType, resetGroup);
        designDataset.setTimePeriodType(accessor.getTemplateTransform().getChartTimeSeriesDatasetTimePeriodType(dataset));
        return designDataset;
    }

    private DRDesignHighLowDataset highLowDataset(DRIHighLowDataset dataset) throws DRException {
        DRDesignHighLowDataset designDataset = new DRDesignHighLowDataset();
        AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        designDataset.setItemHyperLink(accessor.getReportTransform().hyperlink(dataset.getItemHyperLink()));
        designDataset.setSeriesExpression(expressionTransform.transformExpression(dataset.getSeriesExpression()));
        designDataset.setDateExpression(expressionTransform.transformExpression(dataset.getDateExpression()));
        designDataset.setHighExpression(expressionTransform.transformExpression(dataset.getHighExpression()));
        designDataset.setLowExpression(expressionTransform.transformExpression(dataset.getLowExpression()));
        designDataset.setOpenExpression(expressionTransform.transformExpression(dataset.getOpenExpression()));
        designDataset.setCloseExpression(expressionTransform.transformExpression(dataset.getCloseExpression()));
        designDataset.setVolumeExpression(expressionTransform.transformExpression(dataset.getVolumeExpression()));
        return designDataset;
    }

    private DRDesignValueDataset valueDataset(DRIValueDataset dataset) throws DRException {
        DRDesignValueDataset designDataset = new DRDesignValueDataset();
        AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        designDataset.setValueExpression(expressionTransform.transformExpression(dataset.getValueExpression()));
        return designDataset;
    }

    // design serie
    private DRDesignCategoryChartSerie categorySerie(DRIDataset dataset, DRICategoryChartSerie serie, DRIDesignExpression valueExpression, ResetType resetType, DRDesignGroup resetGroup, int index)
        throws DRException {
        DRDesignCategoryChartSerie designSerie = new DRDesignCategoryChartSerie();

        AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        DRIDesignExpression seriesExpression = expressionTransform.transformExpression(serie.getSeriesExpression());
        designSerie.setSeriesExpression(seriesExpression);
        DRIDesignExpression serieValueExpression = expressionTransform.transformExpression(serie.getValueExpression());
        if (serieValueExpression instanceof DRIDesignVariable) {
            designSerie.setValueExpression(serieValueExpression);
        } else {
            if (seriesExpression == null) {
                designSerie.setValueExpression(expressionTransform.transformExpression(new SerieValueExpression(valueExpression, serieValueExpression, resetType, resetGroup, null)));
            } else {
                designSerie.setValueExpression(
                    expressionTransform.transformExpression(new SerieValueExpression(valueExpression, serieValueExpression, resetType, resetGroup, seriesExpression.getName())));
            }
        }
        DRIExpression<?> labelExpression = serie.getLabelExpression();
        if (labelExpression == null) {
            labelExpression = Expressions.text("serie" + index);
        }
        designSerie.setLabelExpression(expressionTransform.transformExpression(labelExpression));

        return designSerie;
    }

    private DRDesignCategoryChartSerie groupedCategorySerie(DRIDataset dataset, DRIGroupedCategoryChartSerie serie, DRIDesignExpression valueExpression, ResetType resetType, DRDesignGroup resetGroup,
                                                            int index) throws DRException {
        DRDesignCategoryChartSerie designSerie = new DRDesignCategoryChartSerie();

        AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        GroupedSeriesExpression groupedSeriesExpression = new GroupedSeriesExpression(serie.getGroupExpression(), serie.getSeriesExpression(), serie.getLabelExpression(), index);
        DRIDesignExpression seriesExpression = expressionTransform.transformExpression(groupedSeriesExpression);
        designSerie.setSeriesExpression(seriesExpression);
        DRIDesignExpression serieValueExpression = expressionTransform.transformExpression(serie.getValueExpression());
        if (serieValueExpression instanceof DRIDesignVariable) {
            designSerie.setValueExpression(serieValueExpression);
        } else {
            designSerie.setValueExpression(expressionTransform.transformExpression(new SerieValueExpression(valueExpression, serieValueExpression, resetType, resetGroup, seriesExpression.getName())));
        }
        DRIExpression<?> labelExpression = serie.getLabelExpression();
        if (labelExpression == null) {
            labelExpression = Expressions.text("serie" + index);
        }
        designSerie.setLabelExpression(expressionTransform.transformExpression(labelExpression));

        return designSerie;
    }

    // xy serie
    private DRDesignXyChartSerie xySerie(DRIDataset dataset, DRIXyChartSerie serie, DRIDesignExpression valueExpression, ResetType resetType, DRDesignGroup resetGroup, int index) throws DRException {
        DRDesignXyChartSerie designSerie = new DRDesignXyChartSerie();

        AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        designSerie.setSeriesExpression(expressionTransform.transformExpression(serie.getSeriesExpression()));
        designSerie.setXValueExpression(expressionTransform.transformExpression(serie.getXValueExpression()));
        designSerie.setYValueExpression(expressionTransform.transformExpression(serie.getYValueExpression()));
        DRIExpression<?> labelExpression = serie.getLabelExpression();
        if (labelExpression == null) {
            labelExpression = Expressions.text("serie" + index);
        }
        designSerie.setLabelExpression(expressionTransform.transformExpression(labelExpression));

        return designSerie;
    }

    // xyz serie
    private DRDesignXyzChartSerie xyzSerie(DRIDataset dataset, DRIXyzChartSerie serie, DRIDesignExpression valueExpression, ResetType resetType, DRDesignGroup resetGroup, int index)
        throws DRException {
        DRDesignXyzChartSerie designSerie = new DRDesignXyzChartSerie();
        AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        DRIExpression<?> seriesExpression = serie.getSeriesExpression();
        if (seriesExpression == null) {
            seriesExpression = Expressions.text("serie" + index);
        }
        designSerie.setSeriesExpression(expressionTransform.transformExpression(seriesExpression));
        designSerie.setXValueExpression(expressionTransform.transformExpression(serie.getXValueExpression()));
        designSerie.setYValueExpression(expressionTransform.transformExpression(serie.getYValueExpression()));
        designSerie.setZValueExpression(expressionTransform.transformExpression(serie.getZValueExpression()));
        return designSerie;
    }

    // gantt serie
    private DRDesignGanttChartSerie ganttSerie(DRIDataset dataset, DRIGanttChartSerie serie, DRIDesignExpression valueExpression, ResetType resetType, DRDesignGroup resetGroup, int index)
        throws DRException {
        DRDesignGanttChartSerie designSerie = new DRDesignGanttChartSerie();
        AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        designSerie.setSeriesExpression(expressionTransform.transformExpression(serie.getSeriesExpression()));
        designSerie.setStartDateExpression(expressionTransform.transformExpression(serie.getStartDateExpression()));
        designSerie.setEndDateExpression(expressionTransform.transformExpression(serie.getEndDateExpression()));
        designSerie.setPercentExpression(expressionTransform.transformExpression(serie.getPercentExpression()));
        DRIExpression<?> labelExpression = serie.getLabelExpression();
        if (labelExpression == null) {
            labelExpression = Expressions.text("serie" + index);
        }
        designSerie.setLabelExpression(expressionTransform.transformExpression(labelExpression));
        return designSerie;
    }

}

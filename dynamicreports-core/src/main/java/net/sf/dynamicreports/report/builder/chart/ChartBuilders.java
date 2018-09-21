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
package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import java.awt.Paint;

/**
 * A set of methods of creating and customizing charts
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ChartBuilders {

    /**
     * <p>axisFormat.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     */
    public AxisFormatBuilder axisFormat() {
        return Charts.axisFormat();
    }

    /**
     * <p>paintScale.</p>
     *
     * @param label a {@link java.lang.String} object.
     * @param value a double.
     * @param paint a {@link java.awt.Paint} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.PaintScaleBuilder} object.
     */
    public PaintScaleBuilder paintScale(String label, double value, Paint paint) {
        return Charts.paintScale(label, value, paint);
    }

    // category serie

    /**
     * <p>serie.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     */
    public CategoryChartSerieBuilder serie(ValueColumnBuilder<?, ? extends Number> column) {
        return Charts.serie(column);
    }

    /**
     * <p>serie.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     */
    public CategoryChartSerieBuilder serie(String fieldName, Class<? extends Number> valueClass) {
        return Charts.serie(fieldName, valueClass);
    }

    /**
     * <p>serie.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     */
    public CategoryChartSerieBuilder serie(FieldBuilder<? extends Number> field) {
        return Charts.serie(field);
    }

    /**
     * <p>serie.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     */
    public CategoryChartSerieBuilder serie(DRIExpression<? extends Number> valueExpression) {
        return Charts.serie(valueExpression);
    }

    /**
     * <p>serie.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     */
    public CategoryChartSerieBuilder serie(VariableBuilder<? extends Number> variable) {
        return Charts.serie(variable);
    }

    // grouped category serie

    /**
     * <p>groupedSerie.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedCategoryChartSerieBuilder} object.
     */
    public GroupedCategoryChartSerieBuilder groupedSerie(ValueColumnBuilder<?, ? extends Number> column) {
        return Charts.groupedSerie(column);
    }

    /**
     * <p>groupedSerie.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedCategoryChartSerieBuilder} object.
     */
    public GroupedCategoryChartSerieBuilder groupedSerie(String fieldName, Class<? extends Number> valueClass) {
        return Charts.groupedSerie(fieldName, valueClass);
    }

    /**
     * <p>groupedSerie.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedCategoryChartSerieBuilder} object.
     */
    public GroupedCategoryChartSerieBuilder groupedSerie(FieldBuilder<? extends Number> field) {
        return Charts.groupedSerie(field);
    }

    /**
     * <p>groupedSerie.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedCategoryChartSerieBuilder} object.
     */
    public GroupedCategoryChartSerieBuilder groupedSerie(DRIExpression<? extends Number> valueExpression) {
        return Charts.groupedSerie(valueExpression);
    }

    /**
     * <p>groupedSerie.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedCategoryChartSerieBuilder} object.
     */
    public GroupedCategoryChartSerieBuilder groupedSerie(VariableBuilder<? extends Number> variable) {
        return Charts.groupedSerie(variable);
    }

    // xy serie

    /**
     * <p>xySerie.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     */
    public XyChartSerieBuilder xySerie(ValueColumnBuilder<?, ? extends Number> column) {
        return Charts.xySerie(column);
    }

    /**
     * <p>xySerie.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     */
    public XyChartSerieBuilder xySerie(String fieldName, Class<? extends Number> valueClass) {
        return Charts.xySerie(fieldName, valueClass);
    }

    /**
     * <p>xySerie.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     */
    public XyChartSerieBuilder xySerie(FieldBuilder<? extends Number> field) {
        return Charts.xySerie(field);
    }

    /**
     * <p>xySerie.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     */
    public XyChartSerieBuilder xySerie(DRIExpression<? extends Number> valueExpression) {
        return Charts.xySerie(valueExpression);
    }

    /**
     * <p>xySerie.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     */
    public XyChartSerieBuilder xySerie(VariableBuilder<? extends Number> variable) {
        return Charts.xySerie(variable);
    }

    // xyz serie

    /**
     * <p>xyzSerie.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder xyzSerie() {
        return Charts.xyzSerie();
    }

    // gantt serie

    /**
     * <p>ganttSerie.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder ganttSerie() {
        return Charts.ganttSerie();
    }

    // charts

    /**
     * <p>areaChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.AreaChartBuilder} object.
     */
    public AreaChartBuilder areaChart() {
        return Charts.areaChart();
    }

    /**
     * <p>stackedAreaChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.StackedAreaChartBuilder} object.
     */
    public StackedAreaChartBuilder stackedAreaChart() {
        return Charts.stackedAreaChart();
    }

    /**
     * <p>barChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.BarChartBuilder} object.
     */
    public BarChartBuilder barChart() {
        return Charts.barChart();
    }

    /**
     * <p>layeredBarChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.LayeredBarChartBuilder} object.
     */
    public LayeredBarChartBuilder layeredBarChart() {
        return Charts.layeredBarChart();
    }

    /**
     * <p>waterfallBarChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public WaterfallBarChartBuilder waterfallBarChart() {
        return Charts.waterfallBarChart();
    }

    /**
     * <p>stackedBarChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.StackedBarChartBuilder} object.
     */
    public StackedBarChartBuilder stackedBarChart() {
        return Charts.stackedBarChart();
    }

    /**
     * <p>groupedStackedBarChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedStackedBarChartBuilder} object.
     */
    public GroupedStackedBarChartBuilder groupedStackedBarChart() {
        return Charts.groupedStackedBarChart();
    }

    /**
     * <p>bar3DChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.Bar3DChartBuilder} object.
     */
    public Bar3DChartBuilder bar3DChart() {
        return Charts.bar3DChart();
    }

    /**
     * <p>stackedBar3DChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.StackedBar3DChartBuilder} object.
     */
    public StackedBar3DChartBuilder stackedBar3DChart() {
        return Charts.stackedBar3DChart();
    }

    /**
     * <p>lineChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.LineChartBuilder} object.
     */
    public LineChartBuilder lineChart() {
        return Charts.lineChart();
    }

    /**
     * <p>pieChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.PieChartBuilder} object.
     */
    public PieChartBuilder pieChart() {
        return Charts.pieChart();
    }

    /**
     * <p>pie3DChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.Pie3DChartBuilder} object.
     */
    public Pie3DChartBuilder pie3DChart() {
        return Charts.pie3DChart();
    }

    /**
     * <p>timeSeriesChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.TimeSeriesChartBuilder} object.
     */
    public TimeSeriesChartBuilder timeSeriesChart() {
        return Charts.timeSeriesChart();
    }

    /**
     * <p>differenceChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.DifferenceChartBuilder} object.
     */
    public DifferenceChartBuilder differenceChart() {
        return Charts.differenceChart();
    }

    /**
     * <p>xyAreaChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyAreaChartBuilder} object.
     */
    public XyAreaChartBuilder xyAreaChart() {
        return Charts.xyAreaChart();
    }

    /**
     * <p>xyBarChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBarChartBuilder} object.
     */
    public XyBarChartBuilder xyBarChart() {
        return Charts.xyBarChart();
    }

    /**
     * <p>xyLineChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyLineChartBuilder} object.
     */
    public XyLineChartBuilder xyLineChart() {
        return Charts.xyLineChart();
    }

    /**
     * <p>xyStepChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyStepChartBuilder} object.
     */
    public XyStepChartBuilder xyStepChart() {
        return Charts.xyStepChart();
    }

    /**
     * <p>scatterChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ScatterChartBuilder} object.
     */
    public ScatterChartBuilder scatterChart() {
        return Charts.scatterChart();
    }

    /**
     * <p>spiderChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder spiderChart() {
        return Charts.spiderChart();
    }

    /**
     * <p>multiAxisChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MultiAxisChartBuilder} object.
     */
    public MultiAxisChartBuilder multiAxisChart() {
        return Charts.multiAxisChart();
    }

    /**
     * <p>multiAxisChart.</p>
     *
     * @param charts a {@link net.sf.dynamicreports.report.builder.chart.AbstractBaseChartBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MultiAxisChartBuilder} object.
     */
    public MultiAxisChartBuilder multiAxisChart(AbstractBaseChartBuilder<?, ?, ?>... charts) {
        return Charts.multiAxisChart(charts);
    }

    /**
     * <p>xyBlockChart.</p>
     *
     * @param defaultLowerBound a double.
     * @param defaultUpperBound a double.
     * @param defaultPaint a {@link java.awt.Paint} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder xyBlockChart(double defaultLowerBound, double defaultUpperBound, Paint defaultPaint) {
        return Charts.xyBlockChart(defaultLowerBound, defaultUpperBound, defaultPaint);
    }

    /**
     * <p>bubbleChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.BubbleChartBuilder} object.
     */
    public BubbleChartBuilder bubbleChart() {
        return Charts.bubbleChart();
    }

    /**
     * <p>candlestickChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CandlestickChartBuilder} object.
     */
    public CandlestickChartBuilder candlestickChart() {
        return Charts.candlestickChart();
    }

    /**
     * <p>highLowChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.HighLowChartBuilder} object.
     */
    public HighLowChartBuilder highLowChart() {
        return Charts.highLowChart();
    }

    /**
     * <p>meterChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder meterChart() {
        return Charts.meterChart();
    }

    /**
     * <p>meterInterval.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterIntervalBuilder} object.
     */
    public MeterIntervalBuilder meterInterval() {
        return Charts.meterInterval();
    }

    /**
     * <p>thermometerChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder thermometerChart() {
        return Charts.thermometerChart();
    }

    /**
     * <p>ganttChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder ganttChart() {
        return Charts.ganttChart();
    }
}

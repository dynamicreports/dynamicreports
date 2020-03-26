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
package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import java.awt.Paint;

/**
 * A set of methods of creating and customizing charts
 *
 * @author Ricardo Mariaca
 * 
 */
public class Charts {

    /**
     * <p>axisFormat.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     */
    public static AxisFormatBuilder axisFormat() {
        return new AxisFormatBuilder();
    }

    /**
     * <p>paintScale.</p>
     *
     * @param label a {@link java.lang.String} object.
     * @param value a double.
     * @param paint a {@link java.awt.Paint} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.PaintScaleBuilder} object.
     */
    public static PaintScaleBuilder paintScale(String label, double value, Paint paint) {
        return new PaintScaleBuilder(label, value, paint);
    }

    // category serie

    /**
     * <p>serie.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     */
    public static CategoryChartSerieBuilder serie(ValueColumnBuilder<?, ? extends Number> column) {
        return new CategoryChartSerieBuilder(column);
    }

    /**
     * <p>serie.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     */
    public static CategoryChartSerieBuilder serie(String fieldName, Class<? extends Number> valueClass) {
        return serie(DynamicReports.<Number>field(fieldName, valueClass));
    }

    /**
     * <p>serie.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     */
    public static CategoryChartSerieBuilder serie(FieldBuilder<? extends Number> field) {
        return new CategoryChartSerieBuilder(field);
    }

    /**
     * <p>serie.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     */
    public static CategoryChartSerieBuilder serie(DRIExpression<? extends Number> valueExpression) {
        return new CategoryChartSerieBuilder(valueExpression);
    }

    /**
     * <p>serie.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     */
    public static CategoryChartSerieBuilder serie(VariableBuilder<? extends Number> variable) {
        return new CategoryChartSerieBuilder(variable);
    }

    // grouped category serie

    /**
     * <p>groupedSerie.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedCategoryChartSerieBuilder} object.
     */
    public static GroupedCategoryChartSerieBuilder groupedSerie(ValueColumnBuilder<?, ? extends Number> column) {
        return new GroupedCategoryChartSerieBuilder(column);
    }

    /**
     * <p>groupedSerie.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedCategoryChartSerieBuilder} object.
     */
    public static GroupedCategoryChartSerieBuilder groupedSerie(String fieldName, Class<? extends Number> valueClass) {
        return groupedSerie(DynamicReports.<Number>field(fieldName, valueClass));
    }

    /**
     * <p>groupedSerie.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedCategoryChartSerieBuilder} object.
     */
    public static GroupedCategoryChartSerieBuilder groupedSerie(FieldBuilder<? extends Number> field) {
        return new GroupedCategoryChartSerieBuilder(field);
    }

    /**
     * <p>groupedSerie.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedCategoryChartSerieBuilder} object.
     */
    public static GroupedCategoryChartSerieBuilder groupedSerie(DRIExpression<? extends Number> valueExpression) {
        return new GroupedCategoryChartSerieBuilder(valueExpression);
    }

    /**
     * <p>groupedSerie.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedCategoryChartSerieBuilder} object.
     */
    public static GroupedCategoryChartSerieBuilder groupedSerie(VariableBuilder<? extends Number> variable) {
        return new GroupedCategoryChartSerieBuilder(variable);
    }

    // xy serie

    /**
     * <p>xySerie.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     */
    public static XyChartSerieBuilder xySerie(ValueColumnBuilder<?, ? extends Number> column) {
        return new XyChartSerieBuilder(column);
    }

    /**
     * <p>xySerie.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     */
    public static XyChartSerieBuilder xySerie(String fieldName, Class<? extends Number> valueClass) {
        return xySerie(DynamicReports.<Number>field(fieldName, valueClass));
    }

    /**
     * <p>xySerie.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     */
    public static XyChartSerieBuilder xySerie(FieldBuilder<? extends Number> field) {
        return new XyChartSerieBuilder(field);
    }

    /**
     * <p>xySerie.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     */
    public static XyChartSerieBuilder xySerie(DRIExpression<? extends Number> valueExpression) {
        return new XyChartSerieBuilder(valueExpression);
    }

    /**
     * <p>xySerie.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     */
    public static XyChartSerieBuilder xySerie(VariableBuilder<? extends Number> variable) {
        return new XyChartSerieBuilder(variable);
    }

    // xyz serie

    /**
     * <p>xyzSerie.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public static XyzChartSerieBuilder xyzSerie() {
        return new XyzChartSerieBuilder();
    }

    // gantt serie

    /**
     * <p>ganttSerie.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public static GanttChartSerieBuilder ganttSerie() {
        return new GanttChartSerieBuilder();
    }

    // charts

    /**
     * <p>areaChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.AreaChartBuilder} object.
     */
    public static AreaChartBuilder areaChart() {
        return new AreaChartBuilder();
    }

    /**
     * <p>stackedAreaChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.StackedAreaChartBuilder} object.
     */
    public static StackedAreaChartBuilder stackedAreaChart() {
        return new StackedAreaChartBuilder();
    }

    /**
     * <p>barChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.BarChartBuilder} object.
     */
    public static BarChartBuilder barChart() {
        return new BarChartBuilder();
    }

    /**
     * <p>layeredBarChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.LayeredBarChartBuilder} object.
     */
    public static LayeredBarChartBuilder layeredBarChart() {
        return new LayeredBarChartBuilder();
    }

    /**
     * <p>waterfallBarChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public static WaterfallBarChartBuilder waterfallBarChart() {
        return new WaterfallBarChartBuilder();
    }

    /**
     * <p>stackedBarChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.StackedBarChartBuilder} object.
     */
    public static StackedBarChartBuilder stackedBarChart() {
        return new StackedBarChartBuilder();
    }

    /**
     * <p>groupedStackedBarChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedStackedBarChartBuilder} object.
     */
    public static GroupedStackedBarChartBuilder groupedStackedBarChart() {
        return new GroupedStackedBarChartBuilder();
    }

    /**
     * <p>bar3DChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.Bar3DChartBuilder} object.
     */
    public static Bar3DChartBuilder bar3DChart() {
        return new Bar3DChartBuilder();
    }

    /**
     * <p>stackedBar3DChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.StackedBar3DChartBuilder} object.
     */
    public static StackedBar3DChartBuilder stackedBar3DChart() {
        return new StackedBar3DChartBuilder();
    }

    /**
     * <p>lineChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.LineChartBuilder} object.
     */
    public static LineChartBuilder lineChart() {
        return new LineChartBuilder();
    }

    /**
     * <p>pieChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.PieChartBuilder} object.
     */
    public static PieChartBuilder pieChart() {
        return new PieChartBuilder();
    }

    /**
     * <p>pie3DChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.Pie3DChartBuilder} object.
     */
    public static Pie3DChartBuilder pie3DChart() {
        return new Pie3DChartBuilder();
    }

    /**
     * <p>timeSeriesChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.TimeSeriesChartBuilder} object.
     */
    public static TimeSeriesChartBuilder timeSeriesChart() {
        return new TimeSeriesChartBuilder();
    }

    /**
     * <p>differenceChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.DifferenceChartBuilder} object.
     */
    public static DifferenceChartBuilder differenceChart() {
        return new DifferenceChartBuilder();
    }

    /**
     * <p>xyAreaChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyAreaChartBuilder} object.
     */
    public static XyAreaChartBuilder xyAreaChart() {
        return new XyAreaChartBuilder();
    }

    /**
     * <p>xyBarChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBarChartBuilder} object.
     */
    public static XyBarChartBuilder xyBarChart() {
        return new XyBarChartBuilder();
    }

    /**
     * <p>xyLineChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyLineChartBuilder} object.
     */
    public static XyLineChartBuilder xyLineChart() {
        return new XyLineChartBuilder();
    }

    /**
     * <p>xyStepChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyStepChartBuilder} object.
     */
    public static XyStepChartBuilder xyStepChart() {
        return new XyStepChartBuilder();
    }

    /**
     * <p>scatterChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ScatterChartBuilder} object.
     */
    public static ScatterChartBuilder scatterChart() {
        return new ScatterChartBuilder();
    }

    /**
     * <p>spiderChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public static SpiderChartBuilder spiderChart() {
        return new SpiderChartBuilder();
    }

    /**
     * <p>multiAxisChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MultiAxisChartBuilder} object.
     */
    public static MultiAxisChartBuilder multiAxisChart() {
        return new MultiAxisChartBuilder();
    }

    /**
     * <p>multiAxisChart.</p>
     *
     * @param charts a {@link net.sf.dynamicreports.report.builder.chart.AbstractBaseChartBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MultiAxisChartBuilder} object.
     */
    public static MultiAxisChartBuilder multiAxisChart(AbstractBaseChartBuilder<?, ?, ?>... charts) {
        return new MultiAxisChartBuilder().charts(charts);
    }

    /**
     * <p>xyBlockChart.</p>
     *
     * @param defaultLowerBound a double.
     * @param defaultUpperBound a double.
     * @param defaultPaint      a {@link java.awt.Paint} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public static XyBlockChartBuilder xyBlockChart(double defaultLowerBound, double defaultUpperBound, Paint defaultPaint) {
        return new XyBlockChartBuilder(defaultLowerBound, defaultUpperBound, defaultPaint);
    }

    /**
     * <p>bubbleChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.BubbleChartBuilder} object.
     */
    public static BubbleChartBuilder bubbleChart() {
        return new BubbleChartBuilder();
    }

    /**
     * <p>candlestickChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.CandlestickChartBuilder} object.
     */
    public static CandlestickChartBuilder candlestickChart() {
        return new CandlestickChartBuilder();
    }

    /**
     * <p>highLowChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.HighLowChartBuilder} object.
     */
    public static HighLowChartBuilder highLowChart() {
        return new HighLowChartBuilder();
    }

    /**
     * <p>meterChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public static MeterChartBuilder meterChart() {
        return new MeterChartBuilder();
    }

    /**
     * <p>meterInterval.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterIntervalBuilder} object.
     */
    public static MeterIntervalBuilder meterInterval() {
        return new MeterIntervalBuilder();
    }

    /**
     * <p>thermometerChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public static ThermometerChartBuilder thermometerChart() {
        return new ThermometerChartBuilder();
    }

    /**
     * <p>ganttChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public static GanttChartBuilder ganttChart() {
        return new GanttChartBuilder();
    }
}

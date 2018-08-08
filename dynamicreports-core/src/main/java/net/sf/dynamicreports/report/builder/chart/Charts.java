/**
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

package net.sf.dynamicreports.report.builder.chart;

import java.awt.Paint;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * A set of methods of creating and customizing charts
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Charts {

	public static AxisFormatBuilder axisFormat() {
		return new AxisFormatBuilder();
	}

	public static PaintScaleBuilder paintScale(String label, double value, Paint paint) {
		return new PaintScaleBuilder(label, value, paint);
	}

	// category serie
	public static CategoryChartSerieBuilder serie(ValueColumnBuilder<?, ? extends Number> column) {
		return new CategoryChartSerieBuilder(column);
	}

	public static CategoryChartSerieBuilder serie(String fieldName, Class<? extends Number> valueClass) {
		return serie(DynamicReports.<Number>field(fieldName, valueClass));
	}

	public static CategoryChartSerieBuilder serie(FieldBuilder<? extends Number> field) {
		return new CategoryChartSerieBuilder(field);
	}

	public static CategoryChartSerieBuilder serie(DRIExpression<? extends Number> valueExpression) {
		return new CategoryChartSerieBuilder(valueExpression);
	}

	public static CategoryChartSerieBuilder serie(VariableBuilder<? extends Number> variable) {
		return new CategoryChartSerieBuilder(variable);
	}

	// grouped category serie
	public static GroupedCategoryChartSerieBuilder groupedSerie(ValueColumnBuilder<?, ? extends Number> column) {
		return new GroupedCategoryChartSerieBuilder(column);
	}

	public static GroupedCategoryChartSerieBuilder groupedSerie(String fieldName, Class<? extends Number> valueClass) {
		return groupedSerie(DynamicReports.<Number>field(fieldName, valueClass));
	}

	public static GroupedCategoryChartSerieBuilder groupedSerie(FieldBuilder<? extends Number> field) {
		return new GroupedCategoryChartSerieBuilder(field);
	}

	public static GroupedCategoryChartSerieBuilder groupedSerie(DRIExpression<? extends Number> valueExpression) {
		return new GroupedCategoryChartSerieBuilder(valueExpression);
	}

	public static GroupedCategoryChartSerieBuilder groupedSerie(VariableBuilder<? extends Number> variable) {
		return new GroupedCategoryChartSerieBuilder(variable);
	}

	// xy serie
	public static XyChartSerieBuilder xySerie(ValueColumnBuilder<?, ? extends Number> column) {
		return new XyChartSerieBuilder(column);
	}

	public static XyChartSerieBuilder xySerie(String fieldName, Class<? extends Number> valueClass) {
		return xySerie(DynamicReports.<Number>field(fieldName, valueClass));
	}

	public static XyChartSerieBuilder xySerie(FieldBuilder<? extends Number> field) {
		return new XyChartSerieBuilder(field);
	}

	public static XyChartSerieBuilder xySerie(DRIExpression<? extends Number> valueExpression) {
		return new XyChartSerieBuilder(valueExpression);
	}

	public static XyChartSerieBuilder xySerie(VariableBuilder<? extends Number> variable) {
		return new XyChartSerieBuilder(variable);
	}

	// xyz serie
	public static XyzChartSerieBuilder xyzSerie() {
		return new XyzChartSerieBuilder();
	}

	// gantt serie
	public static GanttChartSerieBuilder ganttSerie() {
		return new GanttChartSerieBuilder();
	}

	// charts
	public static AreaChartBuilder areaChart() {
		return new AreaChartBuilder();
	}

	public static StackedAreaChartBuilder stackedAreaChart() {
		return new StackedAreaChartBuilder();
	}

	public static BarChartBuilder barChart() {
		return new BarChartBuilder();
	}

	public static LayeredBarChartBuilder layeredBarChart() {
		return new LayeredBarChartBuilder();
	}

	public static WaterfallBarChartBuilder waterfallBarChart() {
		return new WaterfallBarChartBuilder();
	}

	public static StackedBarChartBuilder stackedBarChart() {
		return new StackedBarChartBuilder();
	}

	public static GroupedStackedBarChartBuilder groupedStackedBarChart() {
		return new GroupedStackedBarChartBuilder();
	}

	public static Bar3DChartBuilder bar3DChart() {
		return new Bar3DChartBuilder();
	}

	public static StackedBar3DChartBuilder stackedBar3DChart() {
		return new StackedBar3DChartBuilder();
	}

	public static LineChartBuilder lineChart() {
		return new LineChartBuilder();
	}

	public static PieChartBuilder pieChart() {
		return new PieChartBuilder();
	}

	public static Pie3DChartBuilder pie3DChart() {
		return new Pie3DChartBuilder();
	}

	public static TimeSeriesChartBuilder timeSeriesChart() {
		return new TimeSeriesChartBuilder();
	}

	public static DifferenceChartBuilder differenceChart() {
		return new DifferenceChartBuilder();
	}

	public static XyAreaChartBuilder xyAreaChart() {
		return new XyAreaChartBuilder();
	}

	public static XyBarChartBuilder xyBarChart() {
		return new XyBarChartBuilder();
	}

	public static XyLineChartBuilder xyLineChart() {
		return new XyLineChartBuilder();
	}

	public static XyStepChartBuilder xyStepChart() {
		return new XyStepChartBuilder();
	}

	public static ScatterChartBuilder scatterChart() {
		return new ScatterChartBuilder();
	}

	public static SpiderChartBuilder spiderChart() {
		return new SpiderChartBuilder();
	}

	public static MultiAxisChartBuilder multiAxisChart() {
		return new MultiAxisChartBuilder();
	}

	public static MultiAxisChartBuilder multiAxisChart(AbstractBaseChartBuilder<?, ?, ?>... charts) {
		return new MultiAxisChartBuilder().charts(charts);
	}

	public static XyBlockChartBuilder xyBlockChart(double defaultLowerBound, double defaultUpperBound, Paint defaultPaint) {
		return new XyBlockChartBuilder(defaultLowerBound, defaultUpperBound, defaultPaint);
	}

	public static BubbleChartBuilder bubbleChart() {
		return new BubbleChartBuilder();
	}

	public static CandlestickChartBuilder candlestickChart() {
		return new CandlestickChartBuilder();
	}

	public static HighLowChartBuilder highLowChart() {
		return new HighLowChartBuilder();
	}

	public static MeterChartBuilder meterChart() {
		return new MeterChartBuilder();
	}

	public static MeterIntervalBuilder meterInterval() {
		return new MeterIntervalBuilder();
	}

	public static ThermometerChartBuilder thermometerChart() {
		return new ThermometerChartBuilder();
	}

	public static GanttChartBuilder ganttChart() {
		return new GanttChartBuilder();
	}
}

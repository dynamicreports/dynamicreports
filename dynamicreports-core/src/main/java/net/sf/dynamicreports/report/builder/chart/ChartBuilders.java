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

import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * A set of methods of creating and customizing charts
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ChartBuilders {

	public AxisFormatBuilder axisFormat() {
		return Charts.axisFormat();
	}

	public PaintScaleBuilder paintScale(String label, double value, Paint paint) {
		return Charts.paintScale(label, value, paint);
	}

	// category serie
	public CategoryChartSerieBuilder serie(ValueColumnBuilder<?, ? extends Number> column) {
		return Charts.serie(column);
	}

	public CategoryChartSerieBuilder serie(String fieldName, Class<? extends Number> valueClass) {
		return Charts.serie(fieldName, valueClass);
	}

	public CategoryChartSerieBuilder serie(FieldBuilder<? extends Number> field) {
		return Charts.serie(field);
	}

	public CategoryChartSerieBuilder serie(DRIExpression<? extends Number> valueExpression) {
		return Charts.serie(valueExpression);
	}

	public CategoryChartSerieBuilder serie(VariableBuilder<? extends Number> variable) {
		return Charts.serie(variable);
	}

	// grouped category serie
	public GroupedCategoryChartSerieBuilder groupedSerie(ValueColumnBuilder<?, ? extends Number> column) {
		return Charts.groupedSerie(column);
	}

	public GroupedCategoryChartSerieBuilder groupedSerie(String fieldName, Class<? extends Number> valueClass) {
		return Charts.groupedSerie(fieldName, valueClass);
	}

	public GroupedCategoryChartSerieBuilder groupedSerie(FieldBuilder<? extends Number> field) {
		return Charts.groupedSerie(field);
	}

	public GroupedCategoryChartSerieBuilder groupedSerie(DRIExpression<? extends Number> valueExpression) {
		return Charts.groupedSerie(valueExpression);
	}

	public GroupedCategoryChartSerieBuilder groupedSerie(VariableBuilder<? extends Number> variable) {
		return Charts.groupedSerie(variable);
	}

	// xy serie
	public XyChartSerieBuilder xySerie(ValueColumnBuilder<?, ? extends Number> column) {
		return Charts.xySerie(column);
	}

	public XyChartSerieBuilder xySerie(String fieldName, Class<? extends Number> valueClass) {
		return Charts.xySerie(fieldName, valueClass);
	}

	public XyChartSerieBuilder xySerie(FieldBuilder<? extends Number> field) {
		return Charts.xySerie(field);
	}

	public XyChartSerieBuilder xySerie(DRIExpression<? extends Number> valueExpression) {
		return Charts.xySerie(valueExpression);
	}

	public XyChartSerieBuilder xySerie(VariableBuilder<? extends Number> variable) {
		return Charts.xySerie(variable);
	}

	// xyz serie
	public XyzChartSerieBuilder xyzSerie() {
		return Charts.xyzSerie();
	}

	// gantt serie
	public GanttChartSerieBuilder ganttSerie() {
		return Charts.ganttSerie();
	}

	// charts
	public AreaChartBuilder areaChart() {
		return Charts.areaChart();
	}

	public StackedAreaChartBuilder stackedAreaChart() {
		return Charts.stackedAreaChart();
	}

	public BarChartBuilder barChart() {
		return Charts.barChart();
	}

	public LayeredBarChartBuilder layeredBarChart() {
		return Charts.layeredBarChart();
	}

	public WaterfallBarChartBuilder waterfallBarChart() {
		return Charts.waterfallBarChart();
	}

	public StackedBarChartBuilder stackedBarChart() {
		return Charts.stackedBarChart();
	}

	public GroupedStackedBarChartBuilder groupedStackedBarChart() {
		return Charts.groupedStackedBarChart();
	}

	public Bar3DChartBuilder bar3DChart() {
		return Charts.bar3DChart();
	}

	public StackedBar3DChartBuilder stackedBar3DChart() {
		return Charts.stackedBar3DChart();
	}

	public LineChartBuilder lineChart() {
		return Charts.lineChart();
	}

	public PieChartBuilder pieChart() {
		return Charts.pieChart();
	}

	public Pie3DChartBuilder pie3DChart() {
		return Charts.pie3DChart();
	}

	public TimeSeriesChartBuilder timeSeriesChart() {
		return Charts.timeSeriesChart();
	}

	public DifferenceChartBuilder differenceChart() {
		return Charts.differenceChart();
	}

	public XyAreaChartBuilder xyAreaChart() {
		return Charts.xyAreaChart();
	}

	public XyBarChartBuilder xyBarChart() {
		return Charts.xyBarChart();
	}

	public XyLineChartBuilder xyLineChart() {
		return Charts.xyLineChart();
	}

	public XyStepChartBuilder xyStepChart() {
		return Charts.xyStepChart();
	}

	public ScatterChartBuilder scatterChart() {
		return Charts.scatterChart();
	}

	public SpiderChartBuilder spiderChart() {
		return Charts.spiderChart();
	}

	public MultiAxisChartBuilder multiAxisChart() {
		return Charts.multiAxisChart();
	}

	public MultiAxisChartBuilder multiAxisChart(AbstractBaseChartBuilder<?, ?, ?>... charts) {
		return Charts.multiAxisChart(charts);
	}

	public XyBlockChartBuilder xyBlockChart(double defaultLowerBound, double defaultUpperBound, Paint defaultPaint) {
		return Charts.xyBlockChart(defaultLowerBound, defaultUpperBound, defaultPaint);
	}

	public BubbleChartBuilder bubbleChart() {
		return Charts.bubbleChart();
	}

	public CandlestickChartBuilder candlestickChart() {
		return Charts.candlestickChart();
	}

	public HighLowChartBuilder highLowChart() {
		return Charts.highLowChart();
	}

	public MeterChartBuilder meterChart() {
		return Charts.meterChart();
	}

	public MeterIntervalBuilder meterInterval() {
		return Charts.meterInterval();
	}

	public ThermometerChartBuilder thermometerChart() {
		return Charts.thermometerChart();
	}

	public GanttChartBuilder ganttChart() {
		return Charts.ganttChart();
	}
}

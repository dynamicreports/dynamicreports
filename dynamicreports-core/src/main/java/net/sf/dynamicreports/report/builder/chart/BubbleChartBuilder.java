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

import net.sf.dynamicreports.report.base.chart.dataset.DRSeriesDataset;
import net.sf.dynamicreports.report.base.chart.plot.DRBubblePlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ScaleType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class BubbleChartBuilder extends AbstractBaseChartBuilder<BubbleChartBuilder, DRBubblePlot, DRSeriesDataset> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected BubbleChartBuilder() {
		super(ChartType.BUBBLE);
	}

	// dataset
	public BubbleChartBuilder setXValue(ValueColumnBuilder<?, ? extends Number> column) {
		Validate.notNull(column, "column must not be null");
		getDataset().setValueExpression(column.getColumn());
		return this;
	}

	public BubbleChartBuilder setXValue(String fieldName, Class<? extends Number> valueClass) {
		return setXValue(DynamicReports.<Number>field(fieldName, valueClass));
	}

	public BubbleChartBuilder setXValue(FieldBuilder<? extends Number> field) {
		Validate.notNull(field, "field must not be null");
		getDataset().setValueExpression(field.build());
		return this;
	}

	public BubbleChartBuilder setXValue(DRIExpression<? extends Number> expression) {
		getDataset().setValueExpression(expression);
		return this;
	}

	public BubbleChartBuilder series(XyzChartSerieBuilder... chartSeries) {
		return addSerie(chartSeries);
	}

	public BubbleChartBuilder addSerie(XyzChartSerieBuilder... chartSeries) {
		Validate.notNull(chartSeries, "chartSeries must not be null");
		Validate.noNullElements(chartSeries, "chartSeries must not contains null chartSerie");
		for (XyzChartSerieBuilder chartSerie : chartSeries) {
			getDataset().addSerie(chartSerie.build());
		}
		return this;
	}

	public BubbleChartBuilder setItemHyperLink(HyperLinkBuilder itemHyperLink) {
		Validate.notNull(itemHyperLink, "itemHyperLink must not be null");
		getDataset().setItemHyperLink(itemHyperLink.build());
		return this;
	}

	// plot
	public BubbleChartBuilder setXAxisFormat(AxisFormatBuilder xAxisFormat) {
		Validate.notNull(xAxisFormat, "xAxisFormat must not be null");
		getPlot().setXAxisFormat(xAxisFormat.build());
		return this;
	}

	public BubbleChartBuilder setYAxisFormat(AxisFormatBuilder yAxisFormat) {
		Validate.notNull(yAxisFormat, "yAxisFormat must not be null");
		getPlot().setYAxisFormat(yAxisFormat.build());
		return this;
	}

	public BubbleChartBuilder setScaleType(ScaleType scaleType) {
		getPlot().setScaleType(scaleType);
		return this;
	}
}

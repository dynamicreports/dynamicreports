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

import net.sf.dynamicreports.report.base.chart.plot.DRWaterfallBarPlot;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class WaterfallBarChartBuilder extends AbstractCategoryChartBuilder<WaterfallBarChartBuilder, DRWaterfallBarPlot> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected WaterfallBarChartBuilder() {
		super(ChartType.WATERFALLBAR);
	}

	protected WaterfallBarChartBuilder(ChartType chartType) {
		super(chartType);
	}

	public WaterfallBarChartBuilder setShowLabels(Boolean showLabels) {
		getPlot().setShowLabels(showLabels);
		return this;
	}

	public WaterfallBarChartBuilder setShowTickLabels(Boolean showTickLabels) {
		getPlot().setShowTickLabels(showTickLabels);
		return this;
	}

	public WaterfallBarChartBuilder setShowTickMarks(Boolean showTickMarks) {
		getPlot().setShowTickMarks(showTickMarks);
		return this;
	}

	public WaterfallBarChartBuilder setShowValues(Boolean showValues) {
		getPlot().setShowValues(showValues);
		return this;
	}

	public WaterfallBarChartBuilder setValuePattern(String valuePattern) {
		getPlot().setValuePattern(valuePattern);
		return this;
	}

	public WaterfallBarChartBuilder setPercentValuePattern(String percentValuePattern) {
		getPlot().setPercentValuePattern(percentValuePattern);
		return this;
	}

	public WaterfallBarChartBuilder setFirstBarPaint(Paint firstBarPaint) {
		getPlot().setFirstBarPaint(firstBarPaint);
		return this;
	}

	public WaterfallBarChartBuilder setLastBarPaint(Paint lastBarPaint) {
		getPlot().setLastBarPaint(lastBarPaint);
		return this;
	}

	public WaterfallBarChartBuilder setPositiveBarPaint(Paint positiveBarPaint) {
		getPlot().setPositiveBarPaint(positiveBarPaint);
		return this;
	}

	public WaterfallBarChartBuilder setNegativeBarPaint(Paint negativeBarPaint) {
		getPlot().setNegativeBarPaint(negativeBarPaint);
		return this;
	}
}

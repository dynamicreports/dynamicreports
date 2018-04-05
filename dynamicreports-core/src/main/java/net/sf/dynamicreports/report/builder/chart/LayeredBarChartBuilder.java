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

import net.sf.dynamicreports.report.base.chart.plot.DRLayeredBarPlot;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class LayeredBarChartBuilder extends AbstractCategoryChartBuilder<LayeredBarChartBuilder, DRLayeredBarPlot> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected LayeredBarChartBuilder() {
		super(ChartType.LAYEREDBAR);
	}

	public LayeredBarChartBuilder setShowLabels(Boolean showLabels) {
		getPlot().setShowLabels(showLabels);
		return this;
	}

	public LayeredBarChartBuilder setShowTickLabels(Boolean showTickLabels) {
		getPlot().setShowTickLabels(showTickLabels);
		return this;
	}

	public LayeredBarChartBuilder setShowTickMarks(Boolean showTickMarks) {
		getPlot().setShowTickMarks(showTickMarks);
		return this;
	}

	public LayeredBarChartBuilder seriesBarWidths(Double... seriesBarWidths) {
		return addSeriesBarWidth(seriesBarWidths);
	}

	public LayeredBarChartBuilder addSeriesBarWidth(Double... seriesBarWidths) {
		Validate.notNull(seriesBarWidths, "seriesBarWidths must not be null");
		Validate.noNullElements(seriesBarWidths, "seriesBarWidths must not contains null seriesBarWidth");
		for (Double seriesBarWidth : seriesBarWidths) {
			getPlot().addSeriesBarWidth(seriesBarWidth);
		}
		return this;
	}
}

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

import net.sf.dynamicreports.report.base.chart.plot.DRBar3DPlot;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Bar3DChartBuilder extends AbstractCategoryChartBuilder<Bar3DChartBuilder, DRBar3DPlot> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected Bar3DChartBuilder() {
		super(ChartType.BAR3D);
	}

	public Bar3DChartBuilder setShowLabels(Boolean showLabels) {
		getPlot().setShowLabels(showLabels);
		return this;
	}

	public Bar3DChartBuilder setXOffset(Double xOffset) {
		getPlot().setXOffset(xOffset);
		return this;
	}

	public Bar3DChartBuilder setYOffset(Double yOffset) {
		getPlot().setYOffset(yOffset);
		return this;
	}

	public Bar3DChartBuilder setShowValues(Boolean showValues) {
		getPlot().setShowValues(showValues);
		return this;
	}

	public Bar3DChartBuilder setValuePattern(String valuePattern) {
		getPlot().setValuePattern(valuePattern);
		return this;
	}

	public Bar3DChartBuilder setPercentValuePattern(String percentValuePattern) {
		getPlot().setPercentValuePattern(percentValuePattern);
		return this;
	}
}

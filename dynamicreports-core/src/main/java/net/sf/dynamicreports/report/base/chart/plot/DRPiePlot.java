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

package net.sf.dynamicreports.report.base.chart.plot;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.chart.plot.DRIPiePlot;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRPiePlot extends AbstractBasePlot implements DRIPiePlot {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Boolean circular;
	private Boolean showLabels;
	private Boolean showValues;
	private String valuePattern;
	private Boolean showPercentages;
	private String percentValuePattern;
	private String labelFormat;
	private String legendLabelFormat;

	@Override
	public Boolean getCircular() {
		return circular;
	}

	public void setCircular(Boolean circular) {
		this.circular = circular;
	}

	public void setShowLabels(Boolean showLabels) {
		this.showLabels = showLabels;
	}

	@Override
	public Boolean getShowLabels() {
		return showLabels;
	}

	@Override
	public Boolean getShowValues() {
		return showValues;
	}

	public void setShowValues(Boolean showValues) {
		this.showValues = showValues;
	}

	@Override
	public String getValuePattern() {
		return valuePattern;
	}

	public void setValuePattern(String valuePattern) {
		this.valuePattern = valuePattern;
	}

	@Override
	public Boolean getShowPercentages() {
		return showPercentages;
	}

	public void setShowPercentages(Boolean showPercentages) {
		this.showPercentages = showPercentages;
	}

	@Override
	public String getPercentValuePattern() {
		return percentValuePattern;
	}

	public void setPercentValuePattern(String percentValuePattern) {
		this.percentValuePattern = percentValuePattern;
	}

	@Override
	public String getLabelFormat() {
		return labelFormat;
	}

	public void setLabelFormat(String labelFormat) {
		this.labelFormat = labelFormat;
	}

	@Override
	public String getLegendLabelFormat() {
		return legendLabelFormat;
	}

	public void setLegendLabelFormat(String legendLabelFormat) {
		this.legendLabelFormat = legendLabelFormat;
	}
}

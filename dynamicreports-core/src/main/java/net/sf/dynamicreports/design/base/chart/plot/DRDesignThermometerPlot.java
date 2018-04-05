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

package net.sf.dynamicreports.design.base.chart.plot;

import java.awt.Color;

import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignThermometerPlot;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.style.DRIDesignFont;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ValueLocation;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignThermometerPlot extends DRDesignAxisPlot implements DRIDesignThermometerPlot {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIDesignExpression dataRangeLowExpression;
	private DRIDesignExpression dataRangeHighExpression;
	private Color valueColor;
	private String valueMask;
	private DRIDesignFont valueFont;
	private ValueLocation valueLocation;
	private Color mercuryColor;
	private DRIDesignExpression lowDataRangeLowExpression;
	private DRIDesignExpression lowDataRangeHighExpression;
	private DRIDesignExpression mediumDataRangeLowExpression;
	private DRIDesignExpression mediumDataRangeHighExpression;
	private DRIDesignExpression highDataRangeLowExpression;
	private DRIDesignExpression highDataRangeHighExpression;

	@Override
	public DRIDesignExpression getDataRangeLowExpression() {
		return dataRangeLowExpression;
	}

	public void setDataRangeLowExpression(DRIDesignExpression dataRangeLowExpression) {
		this.dataRangeLowExpression = dataRangeLowExpression;
	}

	@Override
	public DRIDesignExpression getDataRangeHighExpression() {
		return dataRangeHighExpression;
	}

	public void setDataRangeHighExpression(DRIDesignExpression dataRangeHighExpression) {
		this.dataRangeHighExpression = dataRangeHighExpression;
	}

	@Override
	public Color getValueColor() {
		return valueColor;
	}

	public void setValueColor(Color valueColor) {
		this.valueColor = valueColor;
	}

	@Override
	public String getValueMask() {
		return valueMask;
	}

	public void setValueMask(String valueMask) {
		this.valueMask = valueMask;
	}

	@Override
	public DRIDesignFont getValueFont() {
		return valueFont;
	}

	public void setValueFont(DRIDesignFont valueFont) {
		this.valueFont = valueFont;
	}

	@Override
	public ValueLocation getValueLocation() {
		return valueLocation;
	}

	public void setValueLocation(ValueLocation valueLocation) {
		this.valueLocation = valueLocation;
	}

	@Override
	public Color getMercuryColor() {
		return mercuryColor;
	}

	public void setMercuryColor(Color mercuryColor) {
		this.mercuryColor = mercuryColor;
	}

	@Override
	public DRIDesignExpression getLowDataRangeLowExpression() {
		return lowDataRangeLowExpression;
	}

	public void setLowDataRangeLowExpression(DRIDesignExpression lowDataRangeLowExpression) {
		this.lowDataRangeLowExpression = lowDataRangeLowExpression;
	}

	@Override
	public DRIDesignExpression getLowDataRangeHighExpression() {
		return lowDataRangeHighExpression;
	}

	public void setLowDataRangeHighExpression(DRIDesignExpression lowDataRangeHighExpression) {
		this.lowDataRangeHighExpression = lowDataRangeHighExpression;
	}

	@Override
	public DRIDesignExpression getMediumDataRangeLowExpression() {
		return mediumDataRangeLowExpression;
	}

	public void setMediumDataRangeLowExpression(DRIDesignExpression mediumDataRangeLowExpression) {
		this.mediumDataRangeLowExpression = mediumDataRangeLowExpression;
	}

	@Override
	public DRIDesignExpression getMediumDataRangeHighExpression() {
		return mediumDataRangeHighExpression;
	}

	public void setMediumDataRangeHighExpression(DRIDesignExpression mediumDataRangeHighExpression) {
		this.mediumDataRangeHighExpression = mediumDataRangeHighExpression;
	}

	@Override
	public DRIDesignExpression getHighDataRangeLowExpression() {
		return highDataRangeLowExpression;
	}

	public void setHighDataRangeLowExpression(DRIDesignExpression highDataRangeLowExpression) {
		this.highDataRangeLowExpression = highDataRangeLowExpression;
	}

	@Override
	public DRIDesignExpression getHighDataRangeHighExpression() {
		return highDataRangeHighExpression;
	}

	public void setHighDataRangeHighExpression(DRIDesignExpression highDataRangeHighExpression) {
		this.highDataRangeHighExpression = highDataRangeHighExpression;
	}

}

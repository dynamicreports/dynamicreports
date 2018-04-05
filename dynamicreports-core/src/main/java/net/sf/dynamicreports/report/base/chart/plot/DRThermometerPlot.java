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

import java.awt.Color;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ValueLocation;
import net.sf.dynamicreports.report.definition.chart.plot.DRIThermometerPlot;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIFont;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRThermometerPlot implements DRIThermometerPlot {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIExpression<? extends Number> dataRangeLowExpression;
	private DRIExpression<? extends Number> dataRangeHighExpression;
	private Color valueColor;
	private String valueMask;
	private DRIFont valueFont;
	private ValueLocation valueLocation;
	private Color mercuryColor;
	private DRIExpression<? extends Number> lowDataRangeLowExpression;
	private DRIExpression<? extends Number> lowDataRangeHighExpression;
	private DRIExpression<? extends Number> mediumDataRangeLowExpression;
	private DRIExpression<? extends Number> mediumDataRangeHighExpression;
	private DRIExpression<? extends Number> highDataRangeLowExpression;
	private DRIExpression<? extends Number> highDataRangeHighExpression;

	@Override
	public DRIExpression<? extends Number> getDataRangeLowExpression() {
		return dataRangeLowExpression;
	}

	public void setDataRangeLowExpression(DRIExpression<? extends Number> dataRangeLowExpression) {
		this.dataRangeLowExpression = dataRangeLowExpression;
	}

	@Override
	public DRIExpression<? extends Number> getDataRangeHighExpression() {
		return dataRangeHighExpression;
	}

	public void setDataRangeHighExpression(DRIExpression<? extends Number> dataRangeHighExpression) {
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
	public DRIFont getValueFont() {
		return valueFont;
	}

	public void setValueFont(DRIFont valueFont) {
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
	public DRIExpression<? extends Number> getLowDataRangeLowExpression() {
		return lowDataRangeLowExpression;
	}

	public void setLowDataRangeLowExpression(DRIExpression<? extends Number> lowDataRangeLowExpression) {
		this.lowDataRangeLowExpression = lowDataRangeLowExpression;
	}

	@Override
	public DRIExpression<? extends Number> getLowDataRangeHighExpression() {
		return lowDataRangeHighExpression;
	}

	public void setLowDataRangeHighExpression(DRIExpression<? extends Number> lowDataRangeHighExpression) {
		this.lowDataRangeHighExpression = lowDataRangeHighExpression;
	}

	@Override
	public DRIExpression<? extends Number> getMediumDataRangeLowExpression() {
		return mediumDataRangeLowExpression;
	}

	public void setMediumDataRangeLowExpression(DRIExpression<? extends Number> mediumDataRangeLowExpression) {
		this.mediumDataRangeLowExpression = mediumDataRangeLowExpression;
	}

	@Override
	public DRIExpression<? extends Number> getMediumDataRangeHighExpression() {
		return mediumDataRangeHighExpression;
	}

	public void setMediumDataRangeHighExpression(DRIExpression<? extends Number> mediumDataRangeHighExpression) {
		this.mediumDataRangeHighExpression = mediumDataRangeHighExpression;
	}

	@Override
	public DRIExpression<? extends Number> getHighDataRangeLowExpression() {
		return highDataRangeLowExpression;
	}

	public void setHighDataRangeLowExpression(DRIExpression<? extends Number> highDataRangeLowExpression) {
		this.highDataRangeLowExpression = highDataRangeLowExpression;
	}

	@Override
	public DRIExpression<? extends Number> getHighDataRangeHighExpression() {
		return highDataRangeHighExpression;
	}

	public void setHighDataRangeHighExpression(DRIExpression<? extends Number> highDataRangeHighExpression) {
		this.highDataRangeHighExpression = highDataRangeHighExpression;
	}

}

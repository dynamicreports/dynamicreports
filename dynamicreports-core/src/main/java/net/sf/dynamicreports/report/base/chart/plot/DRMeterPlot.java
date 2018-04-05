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
import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.base.style.DRFont;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.MeterShape;
import net.sf.dynamicreports.report.definition.chart.plot.DRIMeterInterval;
import net.sf.dynamicreports.report.definition.chart.plot.DRIMeterPlot;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRMeterPlot implements DRIMeterPlot {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIExpression<? extends Number> dataRangeLowExpression;
	private DRIExpression<? extends Number> dataRangeHighExpression;
	private Color valueColor;
	private String valueMask;
	private DRFont valueFont;
	private MeterShape shape;
	private List<DRIMeterInterval> intervals;
	private Integer meterAngle;
	private String units;
	private Double tickInterval;
	private Color meterBackgroundColor;
	private Color needleColor;
	private Color tickColor;
	private DRFont tickLabelFont;

	public DRMeterPlot() {
		intervals = new ArrayList<DRIMeterInterval>();
	}

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
	public DRFont getValueFont() {
		return valueFont;
	}

	public void setValueFont(DRFont valueFont) {
		this.valueFont = valueFont;
	}

	@Override
	public MeterShape getShape() {
		return shape;
	}

	public void setShape(MeterShape shape) {
		this.shape = shape;
	}

	@Override
	public List<DRIMeterInterval> getIntervals() {
		return intervals;
	}

	public void addInterval(DRIMeterInterval interval) {
		Validate.notNull(interval, "interval must not be null");
		intervals.add(interval);
	}

	public void setIntervals(List<DRIMeterInterval> intervals) {
		this.intervals = intervals;
	}

	@Override
	public Integer getMeterAngle() {
		return meterAngle;
	}

	public void setMeterAngle(Integer meterAngle) {
		this.meterAngle = meterAngle;
	}

	@Override
	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	@Override
	public Double getTickInterval() {
		return tickInterval;
	}

	public void setTickInterval(Double tickInterval) {
		this.tickInterval = tickInterval;
	}

	@Override
	public Color getMeterBackgroundColor() {
		return meterBackgroundColor;
	}

	public void setMeterBackgroundColor(Color meterBackgroundColor) {
		this.meterBackgroundColor = meterBackgroundColor;
	}

	@Override
	public Color getNeedleColor() {
		return needleColor;
	}

	public void setNeedleColor(Color needleColor) {
		this.needleColor = needleColor;
	}

	@Override
	public Color getTickColor() {
		return tickColor;
	}

	public void setTickColor(Color tickColor) {
		this.tickColor = tickColor;
	}

	@Override
	public DRFont getTickLabelFont() {
		return tickLabelFont;
	}

	public void setTickLabelFont(DRFont tickLabelFont) {
		this.tickLabelFont = tickLabelFont;
	}

}

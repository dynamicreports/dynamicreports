/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import net.sf.dynamicreports.report.base.style.DRFont;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.MeterShape;
import net.sf.dynamicreports.report.definition.chart.plot.DRIMeterInterval;
import net.sf.dynamicreports.report.definition.chart.plot.DRIMeterPlot;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRMeterPlot class.</p>
 *
 * @author Ricardo Mariaca
 * 
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

    /**
     * <p>Constructor for DRMeterPlot.</p>
     */
    public DRMeterPlot() {
        intervals = new ArrayList<DRIMeterInterval>();
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Number> getDataRangeLowExpression() {
        return dataRangeLowExpression;
    }

    /**
     * <p>Setter for the field <code>dataRangeLowExpression</code>.</p>
     *
     * @param dataRangeLowExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setDataRangeLowExpression(DRIExpression<? extends Number> dataRangeLowExpression) {
        this.dataRangeLowExpression = dataRangeLowExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Number> getDataRangeHighExpression() {
        return dataRangeHighExpression;
    }

    /**
     * <p>Setter for the field <code>dataRangeHighExpression</code>.</p>
     *
     * @param dataRangeHighExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setDataRangeHighExpression(DRIExpression<? extends Number> dataRangeHighExpression) {
        this.dataRangeHighExpression = dataRangeHighExpression;
    }

    /** {@inheritDoc} */
    @Override
    public Color getValueColor() {
        return valueColor;
    }

    /**
     * <p>Setter for the field <code>valueColor</code>.</p>
     *
     * @param valueColor a {@link java.awt.Color} object.
     */
    public void setValueColor(Color valueColor) {
        this.valueColor = valueColor;
    }

    /** {@inheritDoc} */
    @Override
    public String getValueMask() {
        return valueMask;
    }

    /**
     * <p>Setter for the field <code>valueMask</code>.</p>
     *
     * @param valueMask a {@link java.lang.String} object.
     */
    public void setValueMask(String valueMask) {
        this.valueMask = valueMask;
    }

    /** {@inheritDoc} */
    @Override
    public DRFont getValueFont() {
        return valueFont;
    }

    /**
     * <p>Setter for the field <code>valueFont</code>.</p>
     *
     * @param valueFont a {@link net.sf.dynamicreports.report.base.style.DRFont} object.
     */
    public void setValueFont(DRFont valueFont) {
        this.valueFont = valueFont;
    }

    /** {@inheritDoc} */
    @Override
    public MeterShape getShape() {
        return shape;
    }

    /**
     * <p>Setter for the field <code>shape</code>.</p>
     *
     * @param shape a {@link net.sf.dynamicreports.report.constant.MeterShape} object.
     */
    public void setShape(MeterShape shape) {
        this.shape = shape;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIMeterInterval> getIntervals() {
        return intervals;
    }

    /**
     * <p>Setter for the field <code>intervals</code>.</p>
     *
     * @param intervals a {@link java.util.List} object.
     */
    public void setIntervals(List<DRIMeterInterval> intervals) {
        this.intervals = intervals;
    }

    /**
     * <p>addInterval.</p>
     *
     * @param interval a {@link net.sf.dynamicreports.report.definition.chart.plot.DRIMeterInterval} object.
     */
    public void addInterval(DRIMeterInterval interval) {
        Validate.notNull(interval, "interval must not be null");
        intervals.add(interval);
    }

    /** {@inheritDoc} */
    @Override
    public Integer getMeterAngle() {
        return meterAngle;
    }

    /**
     * <p>Setter for the field <code>meterAngle</code>.</p>
     *
     * @param meterAngle a {@link java.lang.Integer} object.
     */
    public void setMeterAngle(Integer meterAngle) {
        this.meterAngle = meterAngle;
    }

    /** {@inheritDoc} */
    @Override
    public String getUnits() {
        return units;
    }

    /**
     * <p>Setter for the field <code>units</code>.</p>
     *
     * @param units a {@link java.lang.String} object.
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /** {@inheritDoc} */
    @Override
    public Double getTickInterval() {
        return tickInterval;
    }

    /**
     * <p>Setter for the field <code>tickInterval</code>.</p>
     *
     * @param tickInterval a {@link java.lang.Double} object.
     */
    public void setTickInterval(Double tickInterval) {
        this.tickInterval = tickInterval;
    }

    /** {@inheritDoc} */
    @Override
    public Color getMeterBackgroundColor() {
        return meterBackgroundColor;
    }

    /**
     * <p>Setter for the field <code>meterBackgroundColor</code>.</p>
     *
     * @param meterBackgroundColor a {@link java.awt.Color} object.
     */
    public void setMeterBackgroundColor(Color meterBackgroundColor) {
        this.meterBackgroundColor = meterBackgroundColor;
    }

    /** {@inheritDoc} */
    @Override
    public Color getNeedleColor() {
        return needleColor;
    }

    /**
     * <p>Setter for the field <code>needleColor</code>.</p>
     *
     * @param needleColor a {@link java.awt.Color} object.
     */
    public void setNeedleColor(Color needleColor) {
        this.needleColor = needleColor;
    }

    /** {@inheritDoc} */
    @Override
    public Color getTickColor() {
        return tickColor;
    }

    /**
     * <p>Setter for the field <code>tickColor</code>.</p>
     *
     * @param tickColor a {@link java.awt.Color} object.
     */
    public void setTickColor(Color tickColor) {
        this.tickColor = tickColor;
    }

    /** {@inheritDoc} */
    @Override
    public DRFont getTickLabelFont() {
        return tickLabelFont;
    }

    /**
     * <p>Setter for the field <code>tickLabelFont</code>.</p>
     *
     * @param tickLabelFont a {@link net.sf.dynamicreports.report.base.style.DRFont} object.
     */
    public void setTickLabelFont(DRFont tickLabelFont) {
        this.tickLabelFont = tickLabelFont;
    }

}

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
package net.sf.dynamicreports.design.base.chart.plot;

import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignMeterInterval;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignMeterPlot;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.style.DRIDesignFont;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.MeterShape;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRDesignMeterPlot class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class DRDesignMeterPlot extends DRDesignAxisPlot implements DRIDesignMeterPlot {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIDesignExpression dataRangeLowExpression;
    private DRIDesignExpression dataRangeHighExpression;
    private Color valueColor;
    private String valueMask;
    private DRIDesignFont valueFont;
    private MeterShape shape;
    private List<DRIDesignMeterInterval> intervals;
    private Integer meterAngle;
    private String units;
    private Double tickInterval;
    private Color meterBackgroundColor;
    private Color needleColor;
    private Color tickColor;
    private DRIDesignFont tickLabelFont;

    /**
     * <p>Constructor for DRDesignMeterPlot.</p>
     */
    public DRDesignMeterPlot() {
        intervals = new ArrayList<DRIDesignMeterInterval>();
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getDataRangeLowExpression() {
        return dataRangeLowExpression;
    }

    /**
     * <p>Setter for the field <code>dataRangeLowExpression</code>.</p>
     *
     * @param dataRangeLowExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setDataRangeLowExpression(DRIDesignExpression dataRangeLowExpression) {
        this.dataRangeLowExpression = dataRangeLowExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getDataRangeHighExpression() {
        return dataRangeHighExpression;
    }

    /**
     * <p>Setter for the field <code>dataRangeHighExpression</code>.</p>
     *
     * @param dataRangeHighExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setDataRangeHighExpression(DRIDesignExpression dataRangeHighExpression) {
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
    public DRIDesignFont getValueFont() {
        return valueFont;
    }

    /**
     * <p>Setter for the field <code>valueFont</code>.</p>
     *
     * @param valueFont a {@link net.sf.dynamicreports.design.definition.style.DRIDesignFont} object.
     */
    public void setValueFont(DRIDesignFont valueFont) {
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
    public List<DRIDesignMeterInterval> getIntervals() {
        return intervals;
    }

    /**
     * <p>Setter for the field <code>intervals</code>.</p>
     *
     * @param intervals a {@link java.util.List} object.
     */
    public void setIntervals(List<DRIDesignMeterInterval> intervals) {
        this.intervals = intervals;
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
    public DRIDesignFont getTickLabelFont() {
        return tickLabelFont;
    }

    /**
     * <p>Setter for the field <code>tickLabelFont</code>.</p>
     *
     * @param tickLabelFont a {@link net.sf.dynamicreports.design.definition.style.DRIDesignFont} object.
     */
    public void setTickLabelFont(DRIDesignFont tickLabelFont) {
        this.tickLabelFont = tickLabelFont;
    }

}

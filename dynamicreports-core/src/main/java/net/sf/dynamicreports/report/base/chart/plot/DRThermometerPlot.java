/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.report.base.chart.plot;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ValueLocation;
import net.sf.dynamicreports.report.definition.chart.plot.DRIThermometerPlot;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIFont;

import java.awt.Color;

/**
 * <p>DRThermometerPlot class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
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
    public DRIFont getValueFont() {
        return valueFont;
    }

    /**
     * <p>Setter for the field <code>valueFont</code>.</p>
     *
     * @param valueFont a {@link net.sf.dynamicreports.report.definition.style.DRIFont} object.
     */
    public void setValueFont(DRIFont valueFont) {
        this.valueFont = valueFont;
    }

    /** {@inheritDoc} */
    @Override
    public ValueLocation getValueLocation() {
        return valueLocation;
    }

    /**
     * <p>Setter for the field <code>valueLocation</code>.</p>
     *
     * @param valueLocation a {@link net.sf.dynamicreports.report.constant.ValueLocation} object.
     */
    public void setValueLocation(ValueLocation valueLocation) {
        this.valueLocation = valueLocation;
    }

    /** {@inheritDoc} */
    @Override
    public Color getMercuryColor() {
        return mercuryColor;
    }

    /**
     * <p>Setter for the field <code>mercuryColor</code>.</p>
     *
     * @param mercuryColor a {@link java.awt.Color} object.
     */
    public void setMercuryColor(Color mercuryColor) {
        this.mercuryColor = mercuryColor;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Number> getLowDataRangeLowExpression() {
        return lowDataRangeLowExpression;
    }

    /**
     * <p>Setter for the field <code>lowDataRangeLowExpression</code>.</p>
     *
     * @param lowDataRangeLowExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setLowDataRangeLowExpression(DRIExpression<? extends Number> lowDataRangeLowExpression) {
        this.lowDataRangeLowExpression = lowDataRangeLowExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Number> getLowDataRangeHighExpression() {
        return lowDataRangeHighExpression;
    }

    /**
     * <p>Setter for the field <code>lowDataRangeHighExpression</code>.</p>
     *
     * @param lowDataRangeHighExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setLowDataRangeHighExpression(DRIExpression<? extends Number> lowDataRangeHighExpression) {
        this.lowDataRangeHighExpression = lowDataRangeHighExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Number> getMediumDataRangeLowExpression() {
        return mediumDataRangeLowExpression;
    }

    /**
     * <p>Setter for the field <code>mediumDataRangeLowExpression</code>.</p>
     *
     * @param mediumDataRangeLowExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setMediumDataRangeLowExpression(DRIExpression<? extends Number> mediumDataRangeLowExpression) {
        this.mediumDataRangeLowExpression = mediumDataRangeLowExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Number> getMediumDataRangeHighExpression() {
        return mediumDataRangeHighExpression;
    }

    /**
     * <p>Setter for the field <code>mediumDataRangeHighExpression</code>.</p>
     *
     * @param mediumDataRangeHighExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setMediumDataRangeHighExpression(DRIExpression<? extends Number> mediumDataRangeHighExpression) {
        this.mediumDataRangeHighExpression = mediumDataRangeHighExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Number> getHighDataRangeLowExpression() {
        return highDataRangeLowExpression;
    }

    /**
     * <p>Setter for the field <code>highDataRangeLowExpression</code>.</p>
     *
     * @param highDataRangeLowExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setHighDataRangeLowExpression(DRIExpression<? extends Number> highDataRangeLowExpression) {
        this.highDataRangeLowExpression = highDataRangeLowExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Number> getHighDataRangeHighExpression() {
        return highDataRangeHighExpression;
    }

    /**
     * <p>Setter for the field <code>highDataRangeHighExpression</code>.</p>
     *
     * @param highDataRangeHighExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setHighDataRangeHighExpression(DRIExpression<? extends Number> highDataRangeHighExpression) {
        this.highDataRangeHighExpression = highDataRangeHighExpression;
    }

}

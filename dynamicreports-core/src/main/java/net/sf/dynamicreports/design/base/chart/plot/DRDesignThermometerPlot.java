/*
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

import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignThermometerPlot;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.style.DRIDesignFont;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ValueLocation;

import java.awt.Color;

/**
 * <p>DRDesignThermometerPlot class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
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
    public DRIDesignExpression getLowDataRangeLowExpression() {
        return lowDataRangeLowExpression;
    }

    /**
     * <p>Setter for the field <code>lowDataRangeLowExpression</code>.</p>
     *
     * @param lowDataRangeLowExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setLowDataRangeLowExpression(DRIDesignExpression lowDataRangeLowExpression) {
        this.lowDataRangeLowExpression = lowDataRangeLowExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getLowDataRangeHighExpression() {
        return lowDataRangeHighExpression;
    }

    /**
     * <p>Setter for the field <code>lowDataRangeHighExpression</code>.</p>
     *
     * @param lowDataRangeHighExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setLowDataRangeHighExpression(DRIDesignExpression lowDataRangeHighExpression) {
        this.lowDataRangeHighExpression = lowDataRangeHighExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getMediumDataRangeLowExpression() {
        return mediumDataRangeLowExpression;
    }

    /**
     * <p>Setter for the field <code>mediumDataRangeLowExpression</code>.</p>
     *
     * @param mediumDataRangeLowExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setMediumDataRangeLowExpression(DRIDesignExpression mediumDataRangeLowExpression) {
        this.mediumDataRangeLowExpression = mediumDataRangeLowExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getMediumDataRangeHighExpression() {
        return mediumDataRangeHighExpression;
    }

    /**
     * <p>Setter for the field <code>mediumDataRangeHighExpression</code>.</p>
     *
     * @param mediumDataRangeHighExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setMediumDataRangeHighExpression(DRIDesignExpression mediumDataRangeHighExpression) {
        this.mediumDataRangeHighExpression = mediumDataRangeHighExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getHighDataRangeLowExpression() {
        return highDataRangeLowExpression;
    }

    /**
     * <p>Setter for the field <code>highDataRangeLowExpression</code>.</p>
     *
     * @param highDataRangeLowExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setHighDataRangeLowExpression(DRIDesignExpression highDataRangeLowExpression) {
        this.highDataRangeLowExpression = highDataRangeLowExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getHighDataRangeHighExpression() {
        return highDataRangeHighExpression;
    }

    /**
     * <p>Setter for the field <code>highDataRangeHighExpression</code>.</p>
     *
     * @param highDataRangeHighExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setHighDataRangeHighExpression(DRIDesignExpression highDataRangeHighExpression) {
        this.highDataRangeHighExpression = highDataRangeHighExpression;
    }

}

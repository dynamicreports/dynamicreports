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
import net.sf.dynamicreports.report.definition.chart.plot.DRIAxisFormat;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import java.awt.Color;

/**
 * <p>DRAxisFormat class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRAxisFormat implements DRIAxisFormat {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<String> labelExpression;
    private DRFont labelFont;
    private Color labelColor;
    private DRFont tickLabelFont;
    private Color tickLabelColor;
    private String tickLabelMask;
    private Boolean verticalTickLabels;
    private Double tickLabelRotation;
    private Color lineColor;
    private DRIExpression<? extends Number> rangeMinValueExpression;
    private DRIExpression<? extends Number> rangeMaxValueExpression;

    /** {@inheritDoc} */
    @Override
    public DRIExpression<String> getLabelExpression() {
        return labelExpression;
    }

    /**
     * <p>Setter for the field <code>labelExpression</code>.</p>
     *
     * @param labelExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setLabelExpression(DRIExpression<String> labelExpression) {
        this.labelExpression = labelExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRFont getLabelFont() {
        return labelFont;
    }

    /**
     * <p>Setter for the field <code>labelFont</code>.</p>
     *
     * @param labelFont a {@link net.sf.dynamicreports.report.base.style.DRFont} object.
     */
    public void setLabelFont(DRFont labelFont) {
        this.labelFont = labelFont;
    }

    /** {@inheritDoc} */
    @Override
    public Color getLabelColor() {
        return labelColor;
    }

    /**
     * <p>Setter for the field <code>labelColor</code>.</p>
     *
     * @param labelColor a {@link java.awt.Color} object.
     */
    public void setLabelColor(Color labelColor) {
        this.labelColor = labelColor;
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

    /** {@inheritDoc} */
    @Override
    public Color getTickLabelColor() {
        return tickLabelColor;
    }

    /**
     * <p>Setter for the field <code>tickLabelColor</code>.</p>
     *
     * @param tickLabelColor a {@link java.awt.Color} object.
     */
    public void setTickLabelColor(Color tickLabelColor) {
        this.tickLabelColor = tickLabelColor;
    }

    /** {@inheritDoc} */
    @Override
    public String getTickLabelMask() {
        return tickLabelMask;
    }

    /**
     * <p>Setter for the field <code>tickLabelMask</code>.</p>
     *
     * @param tickLabelMask a {@link java.lang.String} object.
     */
    public void setTickLabelMask(String tickLabelMask) {
        this.tickLabelMask = tickLabelMask;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getVerticalTickLabels() {
        return verticalTickLabels;
    }

    /**
     * <p>Setter for the field <code>verticalTickLabels</code>.</p>
     *
     * @param verticalTickLabels a {@link java.lang.Boolean} object.
     */
    public void setVerticalTickLabels(Boolean verticalTickLabels) {
        this.verticalTickLabels = verticalTickLabels;
    }

    /** {@inheritDoc} */
    @Override
    public Double getTickLabelRotation() {
        return tickLabelRotation;
    }

    /**
     * <p>Setter for the field <code>tickLabelRotation</code>.</p>
     *
     * @param tickLabelRotation a {@link java.lang.Double} object.
     */
    public void setTickLabelRotation(Double tickLabelRotation) {
        this.tickLabelRotation = tickLabelRotation;
    }

    /** {@inheritDoc} */
    @Override
    public Color getLineColor() {
        return lineColor;
    }

    /**
     * <p>Setter for the field <code>lineColor</code>.</p>
     *
     * @param lineColor a {@link java.awt.Color} object.
     */
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Number> getRangeMinValueExpression() {
        return rangeMinValueExpression;
    }

    /**
     * <p>Setter for the field <code>rangeMinValueExpression</code>.</p>
     *
     * @param rangeMinValueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setRangeMinValueExpression(DRIExpression<? extends Number> rangeMinValueExpression) {
        this.rangeMinValueExpression = rangeMinValueExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Number> getRangeMaxValueExpression() {
        return rangeMaxValueExpression;
    }

    /**
     * <p>Setter for the field <code>rangeMaxValueExpression</code>.</p>
     *
     * @param rangeMaxValueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setRangeMaxValueExpression(DRIExpression<? extends Number> rangeMaxValueExpression) {
        this.rangeMaxValueExpression = rangeMaxValueExpression;
    }
}

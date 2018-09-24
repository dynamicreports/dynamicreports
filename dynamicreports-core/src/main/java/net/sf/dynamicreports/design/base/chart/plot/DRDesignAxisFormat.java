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

import net.sf.dynamicreports.design.base.style.DRDesignFont;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignAxisFormat;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

import java.awt.Color;

/**
 * <p>DRDesignAxisFormat class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignAxisFormat implements DRIDesignAxisFormat {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIDesignExpression labelExpression;
    private DRDesignFont labelFont;
    private Color labelColor;
    private DRDesignFont tickLabelFont;
    private Color tickLabelColor;
    private String tickLabelMask;
    private Boolean verticalTickLabels;
    private Double tickLabelRotation;
    private Color lineColor;
    private DRIDesignExpression rangeMinValueExpression;
    private DRIDesignExpression rangeMaxValueExpression;

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getLabelExpression() {
        return labelExpression;
    }

    /**
     * <p>Setter for the field <code>labelExpression</code>.</p>
     *
     * @param labelExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setLabelExpression(DRIDesignExpression labelExpression) {
        this.labelExpression = labelExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRDesignFont getLabelFont() {
        return labelFont;
    }

    /**
     * <p>Setter for the field <code>labelFont</code>.</p>
     *
     * @param labelFont a {@link net.sf.dynamicreports.design.base.style.DRDesignFont} object.
     */
    public void setLabelFont(DRDesignFont labelFont) {
        this.labelFont = labelFont;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public DRDesignFont getTickLabelFont() {
        return tickLabelFont;
    }

    /**
     * <p>Setter for the field <code>tickLabelFont</code>.</p>
     *
     * @param tickLabelFont a {@link net.sf.dynamicreports.design.base.style.DRDesignFont} object.
     */
    public void setTickLabelFont(DRDesignFont tickLabelFont) {
        this.tickLabelFont = tickLabelFont;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getRangeMinValueExpression() {
        return rangeMinValueExpression;
    }

    /**
     * <p>Setter for the field <code>rangeMinValueExpression</code>.</p>
     *
     * @param rangeMinValueExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setRangeMinValueExpression(DRIDesignExpression rangeMinValueExpression) {
        this.rangeMinValueExpression = rangeMinValueExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getRangeMaxValueExpression() {
        return rangeMaxValueExpression;
    }

    /**
     * <p>Setter for the field <code>rangeMaxValueExpression</code>.</p>
     *
     * @param rangeMaxValueExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setRangeMaxValueExpression(DRIDesignExpression rangeMaxValueExpression) {
        this.rangeMaxValueExpression = rangeMaxValueExpression;
    }
}

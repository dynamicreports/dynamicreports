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

import net.sf.dynamicreports.report.base.style.DRFont;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.SpiderRotation;
import net.sf.dynamicreports.report.constant.TableOrder;
import net.sf.dynamicreports.report.definition.chart.plot.DRISpiderPlot;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import java.awt.Color;

/**
 * <p>DRSpiderPlot class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRSpiderPlot implements DRISpiderPlot {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<Double> maxValueExpression;
    private SpiderRotation rotation;
    private TableOrder tableOrder;
    private Boolean webFilled;
    private Double startAngle;
    private Double headPercent;
    private Double interiorGap;
    private Color axisLineColor;
    private Float axisLineWidth;
    private DRFont labelFont;
    private Double labelGap;
    private Color labelColor;

    /** {@inheritDoc} */
    @Override
    public DRIExpression<Double> getMaxValueExpression() {
        return maxValueExpression;
    }

    /**
     * <p>Setter for the field <code>maxValueExpression</code>.</p>
     *
     * @param maxValueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setMaxValueExpression(DRIExpression<Double> maxValueExpression) {
        this.maxValueExpression = maxValueExpression;
    }

    /** {@inheritDoc} */
    @Override
    public SpiderRotation getRotation() {
        return rotation;
    }

    /**
     * <p>Setter for the field <code>rotation</code>.</p>
     *
     * @param rotation a {@link net.sf.dynamicreports.report.constant.SpiderRotation} object.
     */
    public void setRotation(SpiderRotation rotation) {
        this.rotation = rotation;
    }

    /** {@inheritDoc} */
    @Override
    public TableOrder getTableOrder() {
        return tableOrder;
    }

    /**
     * <p>Setter for the field <code>tableOrder</code>.</p>
     *
     * @param tableOrder a {@link net.sf.dynamicreports.report.constant.TableOrder} object.
     */
    public void setTableOrder(TableOrder tableOrder) {
        this.tableOrder = tableOrder;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getWebFilled() {
        return webFilled;
    }

    /**
     * <p>Setter for the field <code>webFilled</code>.</p>
     *
     * @param webFilled a {@link java.lang.Boolean} object.
     */
    public void setWebFilled(Boolean webFilled) {
        this.webFilled = webFilled;
    }

    /** {@inheritDoc} */
    @Override
    public Double getStartAngle() {
        return startAngle;
    }

    /**
     * <p>Setter for the field <code>startAngle</code>.</p>
     *
     * @param startAngle a {@link java.lang.Double} object.
     */
    public void setStartAngle(Double startAngle) {
        this.startAngle = startAngle;
    }

    /** {@inheritDoc} */
    @Override
    public Double getHeadPercent() {
        return headPercent;
    }

    /**
     * <p>Setter for the field <code>headPercent</code>.</p>
     *
     * @param headPercent a {@link java.lang.Double} object.
     */
    public void setHeadPercent(Double headPercent) {
        this.headPercent = headPercent;
    }

    /** {@inheritDoc} */
    @Override
    public Double getInteriorGap() {
        return interiorGap;
    }

    /**
     * <p>Setter for the field <code>interiorGap</code>.</p>
     *
     * @param interiorGap a {@link java.lang.Double} object.
     */
    public void setInteriorGap(Double interiorGap) {
        this.interiorGap = interiorGap;
    }

    /** {@inheritDoc} */
    @Override
    public Color getAxisLineColor() {
        return axisLineColor;
    }

    /**
     * <p>Setter for the field <code>axisLineColor</code>.</p>
     *
     * @param axisLineColor a {@link java.awt.Color} object.
     */
    public void setAxisLineColor(Color axisLineColor) {
        this.axisLineColor = axisLineColor;
    }

    /** {@inheritDoc} */
    @Override
    public Float getAxisLineWidth() {
        return axisLineWidth;
    }

    /**
     * <p>Setter for the field <code>axisLineWidth</code>.</p>
     *
     * @param axisLineWidth a {@link java.lang.Float} object.
     */
    public void setAxisLineWidth(Float axisLineWidth) {
        this.axisLineWidth = axisLineWidth;
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
    public Double getLabelGap() {
        return labelGap;
    }

    /**
     * <p>Setter for the field <code>labelGap</code>.</p>
     *
     * @param labelGap a {@link java.lang.Double} object.
     */
    public void setLabelGap(Double labelGap) {
        this.labelGap = labelGap;
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
}

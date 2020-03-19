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
package net.sf.dynamicreports.report.definition.chart.plot;

import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIFont;

import java.awt.Color;
import java.io.Serializable;

/**
 * <p>DRIAxisFormat interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRIAxisFormat extends Serializable {

    /**
     * <p>getLabelExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<String> getLabelExpression();

    /**
     * <p>getLabelFont.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIFont} object.
     */
    public DRIFont getLabelFont();

    /**
     * <p>getLabelColor.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
    public Color getLabelColor();

    /**
     * <p>getTickLabelFont.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIFont} object.
     */
    public DRIFont getTickLabelFont();

    /**
     * <p>getTickLabelColor.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
    public Color getTickLabelColor();

    /**
     * <p>getTickLabelMask.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTickLabelMask();

    /**
     * <p>getVerticalTickLabels.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getVerticalTickLabels();

    /**
     * <p>getTickLabelRotation.</p>
     *
     * @return a {@link java.lang.Double} object.
     */
    public Double getTickLabelRotation();

    /**
     * <p>getLineColor.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
    public Color getLineColor();

    /**
     * <p>getRangeMinValueExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<? extends Number> getRangeMinValueExpression();

    /**
     * <p>getRangeMaxValueExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<? extends Number> getRangeMaxValueExpression();
}

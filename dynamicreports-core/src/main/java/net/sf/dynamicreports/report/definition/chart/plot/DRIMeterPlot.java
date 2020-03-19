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

import net.sf.dynamicreports.report.constant.MeterShape;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIFont;

import java.awt.Color;
import java.util.List;

/**
 * <p>DRIMeterPlot interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public interface DRIMeterPlot extends DRIPlot {

    /**
     * <p>getDataRangeLowExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<? extends Number> getDataRangeLowExpression();

    /**
     * <p>getDataRangeHighExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<? extends Number> getDataRangeHighExpression();

    /**
     * <p>getValueColor.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
    public Color getValueColor();

    /**
     * <p>getValueMask.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getValueMask();

    /**
     * <p>getValueFont.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIFont} object.
     */
    public DRIFont getValueFont();

    /**
     * <p>getShape.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.MeterShape} object.
     */
    public MeterShape getShape();

    /**
     * <p>getIntervals.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRIMeterInterval> getIntervals();

    /**
     * <p>getMeterAngle.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getMeterAngle();

    /**
     * <p>getUnits.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUnits();

    /**
     * <p>getTickInterval.</p>
     *
     * @return a {@link java.lang.Double} object.
     */
    public Double getTickInterval();

    /**
     * <p>getMeterBackgroundColor.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
    public Color getMeterBackgroundColor();

    /**
     * <p>getNeedleColor.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
    public Color getNeedleColor();

    /**
     * <p>getTickColor.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
    public Color getTickColor();

    /**
     * <p>getTickLabelFont.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIFont} object.
     */
    public DRIFont getTickLabelFont();
}

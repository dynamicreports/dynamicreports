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

import net.sf.dynamicreports.report.constant.RectangleAnchor;

import java.awt.Paint;
import java.util.List;

/**
 * <p>DRIXyBlockPlot interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRIXyBlockPlot extends DRIAxisPlot {

    /**
     * <p>getBlockWidth.</p>
     *
     * @return a {@link java.lang.Double} object.
     */
    public Double getBlockWidth();

    /**
     * <p>getBlockHeight.</p>
     *
     * @return a {@link java.lang.Double} object.
     */
    public Double getBlockHeight();

    /**
     * <p>getBlockAnchor.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.RectangleAnchor} object.
     */
    public RectangleAnchor getBlockAnchor();

    /**
     * <p>getDefaultLowerBound.</p>
     *
     * @return a double.
     */
    public double getDefaultLowerBound();

    /**
     * <p>getDefaultUpperBound.</p>
     *
     * @return a double.
     */
    public double getDefaultUpperBound();

    /**
     * <p>getDefaultPaint.</p>
     *
     * @return a {@link java.awt.Paint} object.
     */
    public Paint getDefaultPaint();

    /**
     * <p>getPaintScales.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRIPaintScale> getPaintScales();

}

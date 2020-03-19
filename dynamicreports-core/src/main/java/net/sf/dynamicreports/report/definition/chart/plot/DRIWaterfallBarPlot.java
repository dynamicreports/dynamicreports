/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import java.awt.Paint;

/**
 * <p>DRIWaterfallBarPlot interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRIWaterfallBarPlot extends DRIBarPlot {

    /**
     * <p>getFirstBarPaint.</p>
     *
     * @return a {@link java.awt.Paint} object.
     */
    public Paint getFirstBarPaint();

    /**
     * <p>getLastBarPaint.</p>
     *
     * @return a {@link java.awt.Paint} object.
     */
    public Paint getLastBarPaint();

    /**
     * <p>getPositiveBarPaint.</p>
     *
     * @return a {@link java.awt.Paint} object.
     */
    public Paint getPositiveBarPaint();

    /**
     * <p>getNegativeBarPaint.</p>
     *
     * @return a {@link java.awt.Paint} object.
     */
    public Paint getNegativeBarPaint();

}

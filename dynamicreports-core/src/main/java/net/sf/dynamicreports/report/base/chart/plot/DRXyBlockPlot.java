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

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.RectangleAnchor;
import net.sf.dynamicreports.report.definition.chart.plot.DRIPaintScale;
import net.sf.dynamicreports.report.definition.chart.plot.DRIXyBlockPlot;
import org.apache.commons.lang3.Validate;

import java.awt.Paint;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRXyBlockPlot class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRXyBlockPlot extends DRAxisPlot implements DRIXyBlockPlot {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Double blockWidth;
    private Double blockHeight;
    private RectangleAnchor blockAnchor;
    private double defaultLowerBound;
    private double defaultUpperBound;
    private Paint defaultPaint;
    private List<DRIPaintScale> paintScales;

    /**
     * <p>Constructor for DRXyBlockPlot.</p>
     */
    public DRXyBlockPlot() {
        paintScales = new ArrayList<DRIPaintScale>();
    }

    /** {@inheritDoc} */
    @Override
    public Double getBlockWidth() {
        return blockWidth;
    }

    /**
     * <p>Setter for the field <code>blockWidth</code>.</p>
     *
     * @param blockWidth a {@link java.lang.Double} object.
     */
    public void setBlockWidth(Double blockWidth) {
        this.blockWidth = blockWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Double getBlockHeight() {
        return blockHeight;
    }

    /**
     * <p>Setter for the field <code>blockHeight</code>.</p>
     *
     * @param blockHeight a {@link java.lang.Double} object.
     */
    public void setBlockHeight(Double blockHeight) {
        this.blockHeight = blockHeight;
    }

    /** {@inheritDoc} */
    @Override
    public RectangleAnchor getBlockAnchor() {
        return blockAnchor;
    }

    /**
     * <p>Setter for the field <code>blockAnchor</code>.</p>
     *
     * @param blockAnchor a {@link net.sf.dynamicreports.report.constant.RectangleAnchor} object.
     */
    public void setBlockAnchor(RectangleAnchor blockAnchor) {
        this.blockAnchor = blockAnchor;
    }

    /** {@inheritDoc} */
    @Override
    public double getDefaultLowerBound() {
        return defaultLowerBound;
    }

    /**
     * <p>Setter for the field <code>defaultLowerBound</code>.</p>
     *
     * @param defaultLowerBound a double.
     */
    public void setDefaultLowerBound(double defaultLowerBound) {
        this.defaultLowerBound = defaultLowerBound;
    }

    /** {@inheritDoc} */
    @Override
    public double getDefaultUpperBound() {
        return defaultUpperBound;
    }

    /**
     * <p>Setter for the field <code>defaultUpperBound</code>.</p>
     *
     * @param defaultUpperBound a double.
     */
    public void setDefaultUpperBound(double defaultUpperBound) {
        this.defaultUpperBound = defaultUpperBound;
    }

    /** {@inheritDoc} */
    @Override
    public Paint getDefaultPaint() {
        return defaultPaint;
    }

    /**
     * <p>Setter for the field <code>defaultPaint</code>.</p>
     *
     * @param defaultPaint a {@link java.awt.Paint} object.
     */
    public void setDefaultPaint(Paint defaultPaint) {
        Validate.notNull(defaultPaint, "defaultPaint must not be null");
        this.defaultPaint = defaultPaint;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIPaintScale> getPaintScales() {
        return paintScales;
    }

    /**
     * <p>Setter for the field <code>paintScales</code>.</p>
     *
     * @param paintScales a {@link java.util.List} object.
     */
    public void setPaintScales(List<DRIPaintScale> paintScales) {
        Validate.notNull(paintScales, "paintScales must not be null");
        Validate.noNullElements(paintScales, "paintScales must not contain null paintScale");
        this.paintScales = paintScales;
    }

    /**
     * <p>addPaintScale.</p>
     *
     * @param paintScale a {@link net.sf.dynamicreports.report.definition.chart.plot.DRIPaintScale} object.
     */
    public void addPaintScale(DRIPaintScale paintScale) {
        Validate.notNull(paintScale, "paintScale must not be null");
        this.paintScales.add(paintScale);
    }

}

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

import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignBar3DPlot;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignBar3DPlot class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignBar3DPlot extends DRDesignAxisPlot implements DRIDesignBar3DPlot {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Double xOffset;
    private Double yOffset;
    private Boolean showLabels;

    /** {@inheritDoc} */
    @Override
    public Double getXOffset() {
        return xOffset;
    }

    /**
     * <p>Setter for the field <code>xOffset</code>.</p>
     *
     * @param xOffset a {@link java.lang.Double} object.
     */
    public void setXOffset(Double xOffset) {
        this.xOffset = xOffset;
    }

    /** {@inheritDoc} */
    @Override
    public Double getYOffset() {
        return yOffset;
    }

    /**
     * <p>Setter for the field <code>yOffset</code>.</p>
     *
     * @param yOffset a {@link java.lang.Double} object.
     */
    public void setYOffset(Double yOffset) {
        this.yOffset = yOffset;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getShowLabels() {
        return showLabels;
    }

    /**
     * <p>Setter for the field <code>showLabels</code>.</p>
     *
     * @param showLabels a {@link java.lang.Boolean} object.
     */
    public void setShowLabels(Boolean showLabels) {
        this.showLabels = showLabels;
    }
}

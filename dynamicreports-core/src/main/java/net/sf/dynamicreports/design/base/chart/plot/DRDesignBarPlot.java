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

import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignBarPlot;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignBarPlot class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignBarPlot extends DRDesignAxisPlot implements DRIDesignBarPlot {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Boolean showTickMarks;
    private Boolean showTickLabels;
    private Boolean showLabels;

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

    /** {@inheritDoc} */
    @Override
    public Boolean getShowTickLabels() {
        return showTickLabels;
    }

    /**
     * <p>Setter for the field <code>showTickLabels</code>.</p>
     *
     * @param showTickLabels a {@link java.lang.Boolean} object.
     */
    public void setShowTickLabels(Boolean showTickLabels) {
        this.showTickLabels = showTickLabels;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getShowTickMarks() {
        return showTickMarks;
    }

    /**
     * <p>Setter for the field <code>showTickMarks</code>.</p>
     *
     * @param showTickMarks a {@link java.lang.Boolean} object.
     */
    public void setShowTickMarks(Boolean showTickMarks) {
        this.showTickMarks = showTickMarks;
    }
}

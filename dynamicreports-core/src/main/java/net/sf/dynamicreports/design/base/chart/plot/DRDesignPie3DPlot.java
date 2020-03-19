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
package net.sf.dynamicreports.design.base.chart.plot;

import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignPie3DPlot;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignPie3DPlot class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignPie3DPlot extends DRDesignPiePlot implements DRIDesignPie3DPlot {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Double depthFactor;

    /** {@inheritDoc} */
    @Override
    public Double getDepthFactor() {
        return depthFactor;
    }

    /**
     * <p>Setter for the field <code>depthFactor</code>.</p>
     *
     * @param depthFactor a {@link java.lang.Double} object.
     */
    public void setDepthFactor(Double depthFactor) {
        this.depthFactor = depthFactor;
    }
}

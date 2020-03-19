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
import net.sf.dynamicreports.report.definition.chart.plot.DRIXyStepPlot;

/**
 * <p>DRXyStepPlot class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRXyStepPlot extends DRAxisPlot implements DRIXyStepPlot {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Double stepPoint;

    /** {@inheritDoc} */
    @Override
    public Double getStepPoint() {
        return stepPoint;
    }

    /**
     * <p>Setter for the field <code>stepPoint</code>.</p>
     *
     * @param stepPoint a {@link java.lang.Double} object.
     */
    public void setStepPoint(Double stepPoint) {
        this.stepPoint = stepPoint;
    }

}

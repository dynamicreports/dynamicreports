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

import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignAxisPlot;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignAxisPlot class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignAxisPlot extends AbstractDesignBasePlot implements DRIDesignAxisPlot {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRDesignAxisFormat xAxisFormat;
    private DRDesignAxisFormat yAxisFormat;

    /** {@inheritDoc} */
    @Override
    public DRDesignAxisFormat getXAxisFormat() {
        return xAxisFormat;
    }

    /**
     * <p>Setter for the field <code>xAxisFormat</code>.</p>
     *
     * @param xAxisFormat a {@link net.sf.dynamicreports.design.base.chart.plot.DRDesignAxisFormat} object.
     */
    public void setXAxisFormat(DRDesignAxisFormat xAxisFormat) {
        this.xAxisFormat = xAxisFormat;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignAxisFormat getYAxisFormat() {
        return yAxisFormat;
    }

    /**
     * <p>Setter for the field <code>yAxisFormat</code>.</p>
     *
     * @param yAxisFormat a {@link net.sf.dynamicreports.design.base.chart.plot.DRDesignAxisFormat} object.
     */
    public void setYAxisFormat(DRDesignAxisFormat yAxisFormat) {
        this.yAxisFormat = yAxisFormat;
    }

}

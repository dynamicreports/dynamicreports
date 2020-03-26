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

import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignPiePlot;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignPiePlot class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignPiePlot extends AbstractDesignBasePlot implements DRIDesignPiePlot {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Boolean circular;
    private String labelFormat;
    private String legendLabelFormat;

    /** {@inheritDoc} */
    @Override
    public Boolean getCircular() {
        return circular;
    }

    /**
     * <p>Setter for the field <code>circular</code>.</p>
     *
     * @param circular a {@link java.lang.Boolean} object.
     */
    public void setCircular(Boolean circular) {
        this.circular = circular;
    }

    /** {@inheritDoc} */
    @Override
    public String getLabelFormat() {
        return labelFormat;
    }

    /**
     * <p>Setter for the field <code>labelFormat</code>.</p>
     *
     * @param labelFormat a {@link java.lang.String} object.
     */
    public void setLabelFormat(String labelFormat) {
        this.labelFormat = labelFormat;
    }

    /** {@inheritDoc} */
    @Override
    public String getLegendLabelFormat() {
        return legendLabelFormat;
    }

    /**
     * <p>Setter for the field <code>legendLabelFormat</code>.</p>
     *
     * @param legendLabelFormat a {@link java.lang.String} object.
     */
    public void setLegendLabelFormat(String legendLabelFormat) {
        this.legendLabelFormat = legendLabelFormat;
    }
}

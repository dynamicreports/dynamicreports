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
import net.sf.dynamicreports.report.definition.chart.plot.DRILayeredBarPlot;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRLayeredBarPlot class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRLayeredBarPlot extends DRBarPlot implements DRILayeredBarPlot {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private List<Double> seriesBarWidths;

    /**
     * <p>Constructor for DRLayeredBarPlot.</p>
     */
    public DRLayeredBarPlot() {
        seriesBarWidths = new ArrayList<Double>();
    }

    /**
     * <p>addSeriesBarWidth.</p>
     *
     * @param barWidth a {@link java.lang.Double} object.
     */
    public void addSeriesBarWidth(Double barWidth) {
        Validate.notNull(barWidth, "barWidth must not be null");
        this.seriesBarWidths.add(barWidth);
    }

    /** {@inheritDoc} */
    @Override
    public List<Double> getSeriesBarWidths() {
        return seriesBarWidths;
    }

    /**
     * <p>Setter for the field <code>seriesBarWidths</code>.</p>
     *
     * @param seriesBarWidths a {@link java.util.List} object.
     */
    public void setSeriesBarWidths(List<Double> seriesBarWidths) {
        Validate.notNull(seriesBarWidths, "seriesBarWidths must not be null");
        Validate.noNullElements(seriesBarWidths, "seriesBarWidths must not contain null seriesBarWidth");
        this.seriesBarWidths = seriesBarWidths;
    }
}

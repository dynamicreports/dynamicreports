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

import net.sf.dynamicreports.design.definition.chart.DRIDesignChart;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignChartAxis;
import net.sf.dynamicreports.report.constant.AxisPosition;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignChartAxis class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignChartAxis implements DRIDesignChartAxis {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private AxisPosition position;
    private DRIDesignChart chart;

    /** {@inheritDoc} */
    @Override
    public AxisPosition getPosition() {
        return position;
    }

    /**
     * <p>Setter for the field <code>position</code>.</p>
     *
     * @param position a {@link net.sf.dynamicreports.report.constant.AxisPosition} object.
     */
    public void setPosition(AxisPosition position) {
        this.position = position;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignChart getChart() {
        return chart;
    }

    /**
     * <p>Setter for the field <code>chart</code>.</p>
     *
     * @param chart a {@link net.sf.dynamicreports.design.definition.chart.DRIDesignChart} object.
     */
    public void setChart(DRIDesignChart chart) {
        this.chart = chart;
    }

}

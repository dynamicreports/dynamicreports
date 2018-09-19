/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.report.base.chart.plot.DRXyStepPlot;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>XyStepChartBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class XyStepChartBuilder extends AbstractXyChartBuilder<XyStepChartBuilder, DRXyStepPlot> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for XyStepChartBuilder.</p>
     */
    protected XyStepChartBuilder() {
        super(ChartType.XYSTEP);
    }

    /**
     * <p>setShowValues.</p>
     *
     * @param showValues a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyStepChartBuilder} object.
     */
    public XyStepChartBuilder setShowValues(Boolean showValues) {
        getPlot().setShowValues(showValues);
        return this;
    }

    /**
     * <p>setValuePattern.</p>
     *
     * @param valuePattern a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyStepChartBuilder} object.
     */
    public XyStepChartBuilder setValuePattern(String valuePattern) {
        getPlot().setValuePattern(valuePattern);
        return this;
    }

	/*public XyStepChartBuilder setPercentValuePattern(String percentValuePattern) {
		getPlot().setPercentValuePattern(percentValuePattern);
		return this;
	}*/

    /**
     * <p>setStepPoint.</p>
     *
     * @param stepPoint a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyStepChartBuilder} object.
     */
    public XyStepChartBuilder setStepPoint(Double stepPoint) {
        getPlot().setStepPoint(stepPoint);
        return this;
    }

}

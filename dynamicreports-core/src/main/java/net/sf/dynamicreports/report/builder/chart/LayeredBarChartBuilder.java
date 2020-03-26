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
package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.report.base.chart.plot.DRLayeredBarPlot;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import org.apache.commons.lang3.Validate;

/**
 * <p>LayeredBarChartBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class LayeredBarChartBuilder extends AbstractCategoryChartBuilder<LayeredBarChartBuilder, DRLayeredBarPlot> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for LayeredBarChartBuilder.</p>
     */
    protected LayeredBarChartBuilder() {
        super(ChartType.LAYEREDBAR);
    }

    /**
     * <p>setShowLabels.</p>
     *
     * @param showLabels a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.LayeredBarChartBuilder} object.
     */
    public LayeredBarChartBuilder setShowLabels(Boolean showLabels) {
        getPlot().setShowLabels(showLabels);
        return this;
    }

    /**
     * <p>setShowTickLabels.</p>
     *
     * @param showTickLabels a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.LayeredBarChartBuilder} object.
     */
    public LayeredBarChartBuilder setShowTickLabels(Boolean showTickLabels) {
        getPlot().setShowTickLabels(showTickLabels);
        return this;
    }

    /**
     * <p>setShowTickMarks.</p>
     *
     * @param showTickMarks a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.LayeredBarChartBuilder} object.
     */
    public LayeredBarChartBuilder setShowTickMarks(Boolean showTickMarks) {
        getPlot().setShowTickMarks(showTickMarks);
        return this;
    }

    /**
     * <p>seriesBarWidths.</p>
     *
     * @param seriesBarWidths a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.LayeredBarChartBuilder} object.
     */
    public LayeredBarChartBuilder seriesBarWidths(Double... seriesBarWidths) {
        return addSeriesBarWidth(seriesBarWidths);
    }

    /**
     * <p>addSeriesBarWidth.</p>
     *
     * @param seriesBarWidths a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.LayeredBarChartBuilder} object.
     */
    public LayeredBarChartBuilder addSeriesBarWidth(Double... seriesBarWidths) {
        Validate.notNull(seriesBarWidths, "seriesBarWidths must not be null");
        Validate.noNullElements(seriesBarWidths, "seriesBarWidths must not contains null seriesBarWidth");
        for (Double seriesBarWidth : seriesBarWidths) {
            getPlot().addSeriesBarWidth(seriesBarWidth);
        }
        return this;
    }
}

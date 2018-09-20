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
package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.report.base.chart.plot.DRGroupedStackedBarPlot;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>GroupedStackedBarChartBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GroupedStackedBarChartBuilder extends AbstractCategoryChartBuilder<GroupedStackedBarChartBuilder, DRGroupedStackedBarPlot> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for GroupedStackedBarChartBuilder.</p>
     */
    protected GroupedStackedBarChartBuilder() {
        super(ChartType.GROUPEDSTACKEDBAR);
    }

    /**
     * <p>setShowLabels.</p>
     *
     * @param showLabels a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedStackedBarChartBuilder} object.
     */
    public GroupedStackedBarChartBuilder setShowLabels(Boolean showLabels) {
        getPlot().setShowLabels(showLabels);
        return this;
    }

    /**
     * <p>setShowTickLabels.</p>
     *
     * @param showTickLabels a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedStackedBarChartBuilder} object.
     */
    public GroupedStackedBarChartBuilder setShowTickLabels(Boolean showTickLabels) {
        getPlot().setShowTickLabels(showTickLabels);
        return this;
    }

    /**
     * <p>setShowTickMarks.</p>
     *
     * @param showTickMarks a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedStackedBarChartBuilder} object.
     */
    public GroupedStackedBarChartBuilder setShowTickMarks(Boolean showTickMarks) {
        getPlot().setShowTickMarks(showTickMarks);
        return this;
    }

    /**
     * <p>setShowValues.</p>
     *
     * @param showValues a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedStackedBarChartBuilder} object.
     */
    public GroupedStackedBarChartBuilder setShowValues(Boolean showValues) {
        getPlot().setShowValues(showValues);
        return this;
    }

    /**
     * <p>setValuePattern.</p>
     *
     * @param valuePattern a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedStackedBarChartBuilder} object.
     */
    public GroupedStackedBarChartBuilder setValuePattern(String valuePattern) {
        getPlot().setValuePattern(valuePattern);
        return this;
    }

    /**
     * <p>setPercentValuePattern.</p>
     *
     * @param percentValuePattern a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GroupedStackedBarChartBuilder} object.
     */
    public GroupedStackedBarChartBuilder setPercentValuePattern(String percentValuePattern) {
        getPlot().setPercentValuePattern(percentValuePattern);
        return this;
    }
}

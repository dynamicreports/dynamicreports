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

import net.sf.dynamicreports.report.base.chart.plot.DRWaterfallBarPlot;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;

import java.awt.Paint;

/**
 * <p>WaterfallBarChartBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class WaterfallBarChartBuilder extends AbstractCategoryChartBuilder<WaterfallBarChartBuilder, DRWaterfallBarPlot> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for WaterfallBarChartBuilder.</p>
     */
    protected WaterfallBarChartBuilder() {
        super(ChartType.WATERFALLBAR);
    }

    /**
     * <p>Constructor for WaterfallBarChartBuilder.</p>
     *
     * @param chartType a {@link net.sf.dynamicreports.report.constant.ChartType} object.
     */
    protected WaterfallBarChartBuilder(ChartType chartType) {
        super(chartType);
    }

    /**
     * <p>setShowLabels.</p>
     *
     * @param showLabels a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public WaterfallBarChartBuilder setShowLabels(Boolean showLabels) {
        getPlot().setShowLabels(showLabels);
        return this;
    }

    /**
     * <p>setShowTickLabels.</p>
     *
     * @param showTickLabels a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public WaterfallBarChartBuilder setShowTickLabels(Boolean showTickLabels) {
        getPlot().setShowTickLabels(showTickLabels);
        return this;
    }

    /**
     * <p>setShowTickMarks.</p>
     *
     * @param showTickMarks a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public WaterfallBarChartBuilder setShowTickMarks(Boolean showTickMarks) {
        getPlot().setShowTickMarks(showTickMarks);
        return this;
    }

    /**
     * <p>setShowValues.</p>
     *
     * @param showValues a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public WaterfallBarChartBuilder setShowValues(Boolean showValues) {
        getPlot().setShowValues(showValues);
        return this;
    }

    /**
     * <p>setValuePattern.</p>
     *
     * @param valuePattern a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public WaterfallBarChartBuilder setValuePattern(String valuePattern) {
        getPlot().setValuePattern(valuePattern);
        return this;
    }

    /**
     * <p>setPercentValuePattern.</p>
     *
     * @param percentValuePattern a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public WaterfallBarChartBuilder setPercentValuePattern(String percentValuePattern) {
        getPlot().setPercentValuePattern(percentValuePattern);
        return this;
    }

    /**
     * <p>setFirstBarPaint.</p>
     *
     * @param firstBarPaint a {@link java.awt.Paint} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public WaterfallBarChartBuilder setFirstBarPaint(Paint firstBarPaint) {
        getPlot().setFirstBarPaint(firstBarPaint);
        return this;
    }

    /**
     * <p>setLastBarPaint.</p>
     *
     * @param lastBarPaint a {@link java.awt.Paint} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public WaterfallBarChartBuilder setLastBarPaint(Paint lastBarPaint) {
        getPlot().setLastBarPaint(lastBarPaint);
        return this;
    }

    /**
     * <p>setPositiveBarPaint.</p>
     *
     * @param positiveBarPaint a {@link java.awt.Paint} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public WaterfallBarChartBuilder setPositiveBarPaint(Paint positiveBarPaint) {
        getPlot().setPositiveBarPaint(positiveBarPaint);
        return this;
    }

    /**
     * <p>setNegativeBarPaint.</p>
     *
     * @param negativeBarPaint a {@link java.awt.Paint} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.WaterfallBarChartBuilder} object.
     */
    public WaterfallBarChartBuilder setNegativeBarPaint(Paint negativeBarPaint) {
        getPlot().setNegativeBarPaint(negativeBarPaint);
        return this;
    }
}

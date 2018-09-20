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

import net.sf.dynamicreports.report.base.chart.dataset.DRChartDataset;
import net.sf.dynamicreports.report.base.chart.plot.AbstractBasePlot;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Orientation;
import org.apache.commons.lang3.Validate;

import java.awt.Color;
import java.util.Map;

/**
 * <p>Abstract AbstractBaseChartBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
@SuppressWarnings("unchecked")
public abstract class AbstractBaseChartBuilder<T extends AbstractBaseChartBuilder<T, U, V>, U extends AbstractBasePlot, V extends DRChartDataset> extends AbstractChartBuilder<T> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for AbstractBaseChartBuilder.</p>
     *
     * @param chartType a {@link net.sf.dynamicreports.report.constant.ChartType} object.
     */
    protected AbstractBaseChartBuilder(ChartType chartType) {
        super(chartType);
    }

    /**
     * <p>setTheme.</p>
     *
     * @param theme a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setTheme(String theme) {
        getObject().setTheme(theme);
        return (T) this;
    }

    // plot

    /**
     * <p>setOrientation.</p>
     *
     * @param orientation a {@link net.sf.dynamicreports.report.constant.Orientation} object.
     * @return a T object.
     */
    public T setOrientation(Orientation orientation) {
        getPlot().setOrientation(orientation);
        return (T) this;
    }

    /**
     * <p>seriesColors.</p>
     *
     * @param seriesColors a {@link java.awt.Color} object.
     * @return a T object.
     */
    public T seriesColors(Color... seriesColors) {
        return addSeriesColor(seriesColors);
    }

    /**
     * <p>addSeriesColor.</p>
     *
     * @param seriesColors a {@link java.awt.Color} object.
     * @return a T object.
     */
    public T addSeriesColor(Color... seriesColors) {
        Validate.notNull(seriesColors, "seriesColors must not be null");
        Validate.noNullElements(seriesColors, "seriesColors must not contains null seriesColor");
        for (Color seriesColor : seriesColors) {
            getPlot().addSeriesColor(seriesColor);
        }
        return (T) this;
    }

    /**
     * <p>seriesColorsByName.</p>
     *
     * @param seriesColorsByName a {@link java.util.Map} object.
     * @return a T object.
     */
    public T seriesColorsByName(Map<String, Color> seriesColorsByName) {
        getPlot().setSeriesColorsByName(seriesColorsByName);
        return (T) this;
    }

    /**
     * <p>addSeriesColorByName.</p>
     *
     * @param seriesName a {@link java.lang.String} object.
     * @param color a {@link java.awt.Color} object.
     * @return a T object.
     */
    public T addSeriesColorByName(String seriesName, Color color) {
        getPlot().addSeriesColorByName(seriesName, color);
        return (T) this;
    }

    /**
     * <p>getPlot.</p>
     *
     * @return a U object.
     */
    protected U getPlot() {
        return (U) getObject().getPlot();
    }

    /**
     * <p>getDataset.</p>
     *
     * @return a V object.
     */
    protected V getDataset() {
        return (V) getObject().getDataset();
    }
}

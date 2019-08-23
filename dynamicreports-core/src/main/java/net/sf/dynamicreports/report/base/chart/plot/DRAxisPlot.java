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
import net.sf.dynamicreports.report.constant.OrderType;
import net.sf.dynamicreports.report.definition.chart.plot.DRIAxisPlot;
import org.apache.commons.lang3.Validate;

import java.util.Comparator;

/**
 * <p>DRAxisPlot class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRAxisPlot extends AbstractBasePlot implements DRIAxisPlot {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRAxisFormat xAxisFormat;
    private DRAxisFormat yAxisFormat;
    private Boolean showValues;
    private String valuePattern;
    private Boolean showPercentages;
    private String percentValuePattern;
    private Comparator<String> seriesOrderBy;
    private OrderType seriesOrderType;

    /** {@inheritDoc} */
    @Override
    protected void init() {
        super.init();
        this.xAxisFormat = new DRAxisFormat();
        this.yAxisFormat = new DRAxisFormat();
    }

    /** {@inheritDoc} */
    @Override
    public DRAxisFormat getXAxisFormat() {
        return xAxisFormat;
    }

    /**
     * <p>Setter for the field <code>xAxisFormat</code>.</p>
     *
     * @param xAxisFormat a {@link net.sf.dynamicreports.report.base.chart.plot.DRAxisFormat} object.
     */
    public void setXAxisFormat(DRAxisFormat xAxisFormat) {
        Validate.notNull(xAxisFormat, "xAxisFormat must not be null");
        this.xAxisFormat = xAxisFormat;
    }

    /** {@inheritDoc} */
    @Override
    public DRAxisFormat getYAxisFormat() {
        return yAxisFormat;
    }

    /**
     * <p>Setter for the field <code>yAxisFormat</code>.</p>
     *
     * @param yAxisFormat a {@link net.sf.dynamicreports.report.base.chart.plot.DRAxisFormat} object.
     */
    public void setYAxisFormat(DRAxisFormat yAxisFormat) {
        Validate.notNull(yAxisFormat, "yAxisFormat must not be null");
        this.yAxisFormat = yAxisFormat;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getShowValues() {
        return showValues;
    }

    /**
     * <p>Setter for the field <code>showValues</code>.</p>
     *
     * @param showValues a {@link java.lang.Boolean} object.
     */
    public void setShowValues(Boolean showValues) {
        this.showValues = showValues;
    }

    /** {@inheritDoc} */
    @Override
    public String getValuePattern() {
        return valuePattern;
    }

    /**
     * <p>Setter for the field <code>valuePattern</code>.</p>
     *
     * @param valuePattern a {@link java.lang.String} object.
     */
    public void setValuePattern(String valuePattern) {
        this.valuePattern = valuePattern;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getShowPercentages() {
        return showPercentages;
    }

    /**
     * <p>Setter for the field <code>showPercentages</code>.</p>
     *
     * @param showPercentages a {@link java.lang.Boolean} object.
     */
    public void setShowPercentages(Boolean showPercentages) {
        this.showPercentages = showPercentages;
    }

    /** {@inheritDoc} */
    @Override
    public String getPercentValuePattern() {
        return percentValuePattern;
    }

    /**
     * <p>Setter for the field <code>percentValuePattern</code>.</p>
     *
     * @param percentValuePattern a {@link java.lang.String} object.
     */
    public void setPercentValuePattern(String percentValuePattern) {
        this.percentValuePattern = percentValuePattern;
    }

    /** {@inheritDoc} */
    @Override
    public Comparator<String> getSeriesOrderBy() {
        return seriesOrderBy;
    }

    /**
     * <p>Setter for the field <code>seriesOrderBy</code>.</p>
     *
     * @param seriesOrderBy a {@link java.util.Comparator} object.
     */
    public void setSeriesOrderBy(Comparator<String> seriesOrderBy) {
        this.seriesOrderBy = seriesOrderBy;
    }

    /** {@inheritDoc} */
    @Override
    public OrderType getSeriesOrderType() {
        return seriesOrderType;
    }

    /**
     * <p>Setter for the field <code>seriesOrderType</code>.</p>
     *
     * @param seriesOrderType a {@link net.sf.dynamicreports.report.constant.OrderType} object.
     */
    public void setSeriesOrderType(OrderType seriesOrderType) {
        this.seriesOrderType = seriesOrderType;
    }

}

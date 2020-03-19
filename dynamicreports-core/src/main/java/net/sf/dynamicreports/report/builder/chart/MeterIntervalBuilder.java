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

import net.sf.dynamicreports.report.base.chart.plot.DRMeterInterval;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import java.awt.Color;

/**
 * <p>MeterIntervalBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class MeterIntervalBuilder extends AbstractBuilder<MeterIntervalBuilder, DRMeterInterval> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for MeterIntervalBuilder.</p>
     */
    protected MeterIntervalBuilder() {
        super(new DRMeterInterval());
    }

    /**
     * <p>setLabel.</p>
     *
     * @param label a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterIntervalBuilder} object.
     */
    public MeterIntervalBuilder setLabel(String label) {
        getObject().setLabel(label);
        return this;
    }

    /**
     * <p>setBackgroundColor.</p>
     *
     * @param backgroundColor a {@link java.awt.Color} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterIntervalBuilder} object.
     */
    public MeterIntervalBuilder setBackgroundColor(Color backgroundColor) {
        getObject().setBackgroundColor(backgroundColor);
        return this;
    }

    /**
     * <p>setAlpha.</p>
     *
     * @param alpha a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterIntervalBuilder} object.
     */
    public MeterIntervalBuilder setAlpha(Double alpha) {
        getObject().setAlpha(alpha);
        return this;
    }

    /**
     * <p>setDataRangeLowExpression.</p>
     *
     * @param dataRangeLowValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterIntervalBuilder} object.
     */
    public MeterIntervalBuilder setDataRangeLowExpression(Number dataRangeLowValue) {
        getObject().setDataRangeLowExpression(Expressions.number(dataRangeLowValue));
        return this;
    }

    /**
     * <p>setDataRangeLowExpression.</p>
     *
     * @param dataRangeLowExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterIntervalBuilder} object.
     */
    public MeterIntervalBuilder setDataRangeLowExpression(DRIExpression<? extends Number> dataRangeLowExpression) {
        getObject().setDataRangeLowExpression(dataRangeLowExpression);
        return this;
    }

    /**
     * <p>setDataRangeHighExpression.</p>
     *
     * @param dataRangeHighValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterIntervalBuilder} object.
     */
    public MeterIntervalBuilder setDataRangeHighExpression(Number dataRangeHighValue) {
        getObject().setDataRangeHighExpression(Expressions.number(dataRangeHighValue));
        return this;
    }

    /**
     * <p>setDataRangeHighExpression.</p>
     *
     * @param dataRangeHighExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterIntervalBuilder} object.
     */
    public MeterIntervalBuilder setDataRangeHighExpression(DRIExpression<? extends Number> dataRangeHighExpression) {
        getObject().setDataRangeHighExpression(dataRangeHighExpression);
        return this;
    }

}

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

import net.sf.dynamicreports.report.base.chart.dataset.DRValueDataset;
import net.sf.dynamicreports.report.base.chart.plot.DRMeterPlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.MeterShape;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

import java.awt.Color;

/**
 * <p>MeterChartBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class MeterChartBuilder extends AbstractChartBuilder<MeterChartBuilder> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for MeterChartBuilder.</p>
     */
    protected MeterChartBuilder() {
        super(ChartType.METER);
    }

    /**
     * <p>setTheme.</p>
     *
     * @param theme a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setTheme(String theme) {
        getObject().setTheme(theme);
        return this;
    }

    // dataset

    /**
     * <p>setValue.</p>
     *
     * @param value a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setValue(Number value) {
        getDataset().setValueExpression(Expressions.number(value));
        return this;
    }

    /**
     * <p>setValue.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setValue(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setValueExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setValue.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setValue(String fieldName, Class<? extends Number> valueClass) {
        return setValue(DynamicReports.<Number>field(fieldName, valueClass));
    }

    /**
     * <p>setValue.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setValue(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setValueExpression(field.build());
        return this;
    }

    /**
     * <p>setValue.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setValue(DRIExpression<? extends Number> expression) {
        getDataset().setValueExpression(expression);
        return this;
    }

    // plot

    /**
     * <p>setDataRangeLowExpression.</p>
     *
     * @param dataRangeLowValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setDataRangeLowExpression(Number dataRangeLowValue) {
        getPlot().setDataRangeLowExpression(Expressions.number(dataRangeLowValue));
        return this;
    }

    /**
     * <p>setDataRangeLowExpression.</p>
     *
     * @param dataRangeLowExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setDataRangeLowExpression(DRIExpression<? extends Number> dataRangeLowExpression) {
        getPlot().setDataRangeLowExpression(dataRangeLowExpression);
        return this;
    }

    /**
     * <p>setDataRangeHighExpression.</p>
     *
     * @param dataRangeHighValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setDataRangeHighExpression(Number dataRangeHighValue) {
        getPlot().setDataRangeHighExpression(Expressions.number(dataRangeHighValue));
        return this;
    }

    /**
     * <p>setDataRangeHighExpression.</p>
     *
     * @param dataRangeHighExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setDataRangeHighExpression(DRIExpression<? extends Number> dataRangeHighExpression) {
        getPlot().setDataRangeHighExpression(dataRangeHighExpression);
        return this;
    }

    /**
     * <p>setValueColor.</p>
     *
     * @param valueColor a {@link java.awt.Color} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setValueColor(Color valueColor) {
        getPlot().setValueColor(valueColor);
        return this;
    }

    /**
     * <p>setValueMask.</p>
     *
     * @param valueMask a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setValueMask(String valueMask) {
        getPlot().setValueMask(valueMask);
        return this;
    }

    /**
     * <p>setValueFont.</p>
     *
     * @param valueFont a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setValueFont(FontBuilder valueFont) {
        Validate.notNull(valueFont, "valueFont must not be null");
        getPlot().setValueFont(valueFont.build());
        return this;
    }

    /**
     * <p>setShape.</p>
     *
     * @param shape a {@link net.sf.dynamicreports.report.constant.MeterShape} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setShape(MeterShape shape) {
        getPlot().setShape(shape);
        return this;
    }

    /**
     * <p>intervals.</p>
     *
     * @param intervals a {@link net.sf.dynamicreports.report.builder.chart.MeterIntervalBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder intervals(MeterIntervalBuilder... intervals) {
        return addInterval(intervals);
    }

    /**
     * <p>addInterval.</p>
     *
     * @param intervals a {@link net.sf.dynamicreports.report.builder.chart.MeterIntervalBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder addInterval(MeterIntervalBuilder... intervals) {
        Validate.notNull(intervals, "intervals must not be null");
        Validate.noNullElements(intervals, "intervals must not contains null interval");
        for (MeterIntervalBuilder interval : intervals) {
            getPlot().addInterval(interval.build());
        }
        return this;
    }

    /**
     * <p>setMeterAngle.</p>
     *
     * @param meterAngle a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setMeterAngle(Integer meterAngle) {
        getPlot().setMeterAngle(meterAngle);
        return this;
    }

    /**
     * <p>setUnits.</p>
     *
     * @param units a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setUnits(String units) {
        getPlot().setUnits(units);
        return this;
    }

    /**
     * <p>setTickInterval.</p>
     *
     * @param tickInterval a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setTickInterval(Double tickInterval) {
        getPlot().setTickInterval(tickInterval);
        return this;
    }

    /**
     * <p>setMeterBackgroundColor.</p>
     *
     * @param meterBackgroundColor a {@link java.awt.Color} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setMeterBackgroundColor(Color meterBackgroundColor) {
        getPlot().setMeterBackgroundColor(meterBackgroundColor);
        return this;
    }

    /**
     * <p>setNeedleColor.</p>
     *
     * @param needleColor a {@link java.awt.Color} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setNeedleColor(Color needleColor) {
        getPlot().setNeedleColor(needleColor);
        return this;
    }

    /**
     * <p>setTickColor.</p>
     *
     * @param tickColor a {@link java.awt.Color} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setTickColor(Color tickColor) {
        getPlot().setTickColor(tickColor);
        return this;
    }

    /**
     * <p>setTickLabelFont.</p>
     *
     * @param tickLabelFont a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.MeterChartBuilder} object.
     */
    public MeterChartBuilder setTickLabelFont(FontBuilder tickLabelFont) {
        Validate.notNull(tickLabelFont, "tickLabelFont must not be null");
        getPlot().setTickLabelFont(tickLabelFont.build());
        return this;
    }

    private DRValueDataset getDataset() {
        return (DRValueDataset) getObject().getDataset();
    }

    private DRMeterPlot getPlot() {
        return (DRMeterPlot) getObject().getPlot();
    }
}

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
import net.sf.dynamicreports.report.base.chart.plot.DRThermometerPlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ValueLocation;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

import java.awt.Color;

/**
 * <p>ThermometerChartBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class ThermometerChartBuilder extends AbstractChartBuilder<ThermometerChartBuilder> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for ThermometerChartBuilder.</p>
     */
    protected ThermometerChartBuilder() {
        super(ChartType.THERMOMETER);
    }

    /**
     * <p>setTheme.</p>
     *
     * @param theme a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setTheme(String theme) {
        getObject().setTheme(theme);
        return this;
    }

    // dataset

    /**
     * <p>setValue.</p>
     *
     * @param value a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setValue(Number value) {
        getDataset().setValueExpression(Expressions.number(value));
        return this;
    }

    /**
     * <p>setValue.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setValue(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setValueExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setValue.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setValue(String fieldName, Class<? extends Number> valueClass) {
        return setValue(DynamicReports.<Number>field(fieldName, valueClass));
    }

    /**
     * <p>setValue.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setValue(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setValueExpression(field.build());
        return this;
    }

    /**
     * <p>setValue.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setValue(DRIExpression<? extends Number> expression) {
        getDataset().setValueExpression(expression);
        return this;
    }

    // plot

    /**
     * <p>setDataRangeLowExpression.</p>
     *
     * @param dataRangeLowValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setDataRangeLowExpression(Number dataRangeLowValue) {
        getPlot().setDataRangeLowExpression(Expressions.number(dataRangeLowValue));
        return this;
    }

    /**
     * <p>setDataRangeLowExpression.</p>
     *
     * @param dataRangeLowExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setDataRangeLowExpression(DRIExpression<? extends Number> dataRangeLowExpression) {
        getPlot().setDataRangeLowExpression(dataRangeLowExpression);
        return this;
    }

    /**
     * <p>setDataRangeHighExpression.</p>
     *
     * @param dataRangeHighValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setDataRangeHighExpression(Number dataRangeHighValue) {
        getPlot().setDataRangeHighExpression(Expressions.number(dataRangeHighValue));
        return this;
    }

    /**
     * <p>setDataRangeHighExpression.</p>
     *
     * @param dataRangeHighExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setDataRangeHighExpression(DRIExpression<? extends Number> dataRangeHighExpression) {
        getPlot().setDataRangeHighExpression(dataRangeHighExpression);
        return this;
    }

    /**
     * <p>setValueColor.</p>
     *
     * @param valueColor a {@link java.awt.Color} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setValueColor(Color valueColor) {
        getPlot().setValueColor(valueColor);
        return this;
    }

    /**
     * <p>setValueMask.</p>
     *
     * @param valueMask a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setValueMask(String valueMask) {
        getPlot().setValueMask(valueMask);
        return this;
    }

    /**
     * <p>setValueFont.</p>
     *
     * @param valueFont a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setValueFont(FontBuilder valueFont) {
        Validate.notNull(valueFont, "valueFont must not be null");
        getPlot().setValueFont(valueFont.build());
        return this;
    }

    /**
     * <p>setValueLocation.</p>
     *
     * @param valueLocation a {@link net.sf.dynamicreports.report.constant.ValueLocation} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setValueLocation(ValueLocation valueLocation) {
        getPlot().setValueLocation(valueLocation);
        return this;
    }

    /**
     * <p>setMercuryColor.</p>
     *
     * @param mercuryColor a {@link java.awt.Color} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setMercuryColor(Color mercuryColor) {
        getPlot().setMercuryColor(mercuryColor);
        return this;
    }

    /**
     * <p>setLowDataRangeLowExpression.</p>
     *
     * @param lowDataRangeLowValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setLowDataRangeLowExpression(Number lowDataRangeLowValue) {
        getPlot().setLowDataRangeLowExpression(Expressions.number(lowDataRangeLowValue));
        return this;
    }

    /**
     * <p>setLowDataRangeLowExpression.</p>
     *
     * @param lowDataRangeLowExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setLowDataRangeLowExpression(DRIExpression<? extends Number> lowDataRangeLowExpression) {
        getPlot().setLowDataRangeLowExpression(lowDataRangeLowExpression);
        return this;
    }

    /**
     * <p>setLowDataRangeHighExpression.</p>
     *
     * @param lowDataRangeHighValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setLowDataRangeHighExpression(Number lowDataRangeHighValue) {
        getPlot().setLowDataRangeHighExpression(Expressions.number(lowDataRangeHighValue));
        return this;
    }

    /**
     * <p>setLowDataRangeHighExpression.</p>
     *
     * @param lowDataRangeHighExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setLowDataRangeHighExpression(DRIExpression<? extends Number> lowDataRangeHighExpression) {
        getPlot().setLowDataRangeHighExpression(lowDataRangeHighExpression);
        return this;
    }

    /**
     * <p>setMediumDataRangeLowExpression.</p>
     *
     * @param mediumDataRangeLowValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setMediumDataRangeLowExpression(Number mediumDataRangeLowValue) {
        getPlot().setMediumDataRangeLowExpression(Expressions.number(mediumDataRangeLowValue));
        return this;
    }

    /**
     * <p>setMediumDataRangeLowExpression.</p>
     *
     * @param mediumDataRangeLowExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setMediumDataRangeLowExpression(DRIExpression<? extends Number> mediumDataRangeLowExpression) {
        getPlot().setMediumDataRangeLowExpression(mediumDataRangeLowExpression);
        return this;
    }

    /**
     * <p>setMediumDataRangeHighExpression.</p>
     *
     * @param mediumDataRangeHighValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setMediumDataRangeHighExpression(Number mediumDataRangeHighValue) {
        getPlot().setMediumDataRangeHighExpression(Expressions.number(mediumDataRangeHighValue));
        return this;
    }

    /**
     * <p>setMediumDataRangeHighExpression.</p>
     *
     * @param mediumDataRangeHighExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setMediumDataRangeHighExpression(DRIExpression<? extends Number> mediumDataRangeHighExpression) {
        getPlot().setMediumDataRangeHighExpression(mediumDataRangeHighExpression);
        return this;
    }

    /**
     * <p>setHighDataRangeLowExpression.</p>
     *
     * @param highDataRangeLowValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setHighDataRangeLowExpression(Number highDataRangeLowValue) {
        getPlot().setHighDataRangeLowExpression(Expressions.number(highDataRangeLowValue));
        return this;
    }

    /**
     * <p>setHighDataRangeLowExpression.</p>
     *
     * @param highDataRangeLowExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setHighDataRangeLowExpression(DRIExpression<? extends Number> highDataRangeLowExpression) {
        getPlot().setHighDataRangeLowExpression(highDataRangeLowExpression);
        return this;
    }

    /**
     * <p>setHighDataRangeHighExpression.</p>
     *
     * @param highDataRangeHighValue a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setHighDataRangeHighExpression(Number highDataRangeHighValue) {
        getPlot().setHighDataRangeHighExpression(Expressions.number(highDataRangeHighValue));
        return this;
    }

    /**
     * <p>setHighDataRangeHighExpression.</p>
     *
     * @param highDataRangeHighExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.ThermometerChartBuilder} object.
     */
    public ThermometerChartBuilder setHighDataRangeHighExpression(DRIExpression<? extends Number> highDataRangeHighExpression) {
        getPlot().setHighDataRangeHighExpression(highDataRangeHighExpression);
        return this;
    }

    private DRValueDataset getDataset() {
        return (DRValueDataset) getObject().getDataset();
    }

    private DRThermometerPlot getPlot() {
        return (DRThermometerPlot) getObject().getPlot();
    }
}

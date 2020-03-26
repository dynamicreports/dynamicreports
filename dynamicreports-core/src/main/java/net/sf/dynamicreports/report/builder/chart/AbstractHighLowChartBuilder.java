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

import net.sf.dynamicreports.report.base.chart.dataset.DRHighLowDataset;
import net.sf.dynamicreports.report.base.chart.plot.DRAxisPlot;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

import java.util.Date;

/**
 * <p>Abstract AbstractHighLowChartBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
@SuppressWarnings("unchecked")
public abstract class AbstractHighLowChartBuilder<T extends AbstractHighLowChartBuilder<T, U>, U extends DRAxisPlot>
    extends AbstractBaseChartBuilder<AbstractHighLowChartBuilder<T, U>, U, DRHighLowDataset> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for AbstractHighLowChartBuilder.</p>
     *
     * @param chartType a {@link net.sf.dynamicreports.report.constant.ChartType} object.
     */
    protected AbstractHighLowChartBuilder(ChartType chartType) {
        super(chartType);
    }

    // series

    /**
     * <p>setSeries.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a T object.
     */
    public T setSeries(ValueColumnBuilder<?, String> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setSeriesExpression(column.getColumn());
        return (T) this;
    }

    /**
     * <p>setSeries.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a T object.
     */
    public T setSeries(FieldBuilder<String> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setSeriesExpression(field.build());
        return (T) this;
    }

    /**
     * <p>setSeries.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setSeries(DRIExpression<String> valueExpression) {
        getDataset().setSeriesExpression(valueExpression);
        return (T) this;
    }

    // date

    /**
     * <p>setDate.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a T object.
     */
    public T setDate(ValueColumnBuilder<?, Date> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setDateExpression(column.getColumn());
        return (T) this;
    }

    /**
     * <p>setDate.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a T object.
     */
    public T setDate(FieldBuilder<Date> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setDateExpression(field.build());
        return (T) this;
    }

    /**
     * <p>setDate.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setDate(DRIExpression<Date> valueExpression) {
        getDataset().setDateExpression(valueExpression);
        return (T) this;
    }

    // hight

    /**
     * <p>setHigh.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a T object.
     */
    public T setHigh(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setHighExpression(column.getColumn());
        return (T) this;
    }

    /**
     * <p>setHigh.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a T object.
     */
    public T setHigh(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setHighExpression(field.build());
        return (T) this;
    }

    /**
     * <p>setHigh.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setHigh(DRIExpression<? extends Number> valueExpression) {
        getDataset().setHighExpression(valueExpression);
        return (T) this;
    }

    /**
     * <p>setHigh.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a T object.
     */
    public T setHigh(VariableBuilder<? extends Number> variable) {
        Validate.notNull(variable, "variable must not be null");
        getDataset().setHighExpression(variable.build());
        return (T) this;
    }

    // low

    /**
     * <p>setLow.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a T object.
     */
    public T setLow(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setLowExpression(column.getColumn());
        return (T) this;
    }

    /**
     * <p>setLow.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a T object.
     */
    public T setLow(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setLowExpression(field.build());
        return (T) this;
    }

    /**
     * <p>setLow.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setLow(DRIExpression<? extends Number> valueExpression) {
        getDataset().setLowExpression(valueExpression);
        return (T) this;
    }

    /**
     * <p>setLow.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a T object.
     */
    public T setLow(VariableBuilder<? extends Number> variable) {
        Validate.notNull(variable, "variable must not be null");
        getDataset().setLowExpression(variable.build());
        return (T) this;
    }

    // open

    /**
     * <p>setOpen.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a T object.
     */
    public T setOpen(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setOpenExpression(column.getColumn());
        return (T) this;
    }

    /**
     * <p>setOpen.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a T object.
     */
    public T setOpen(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setOpenExpression(field.build());
        return (T) this;
    }

    /**
     * <p>setOpen.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setOpen(DRIExpression<? extends Number> valueExpression) {
        getDataset().setOpenExpression(valueExpression);
        return (T) this;
    }

    /**
     * <p>setOpen.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a T object.
     */
    public T setOpen(VariableBuilder<? extends Number> variable) {
        Validate.notNull(variable, "variable must not be null");
        getDataset().setOpenExpression(variable.build());
        return (T) this;
    }

    // close

    /**
     * <p>setClose.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a T object.
     */
    public T setClose(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setCloseExpression(column.getColumn());
        return (T) this;
    }

    /**
     * <p>setClose.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a T object.
     */
    public T setClose(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setCloseExpression(field.build());
        return (T) this;
    }

    /**
     * <p>setClose.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setClose(DRIExpression<? extends Number> valueExpression) {
        getDataset().setCloseExpression(valueExpression);
        return (T) this;
    }

    /**
     * <p>setClose.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a T object.
     */
    public T setClose(VariableBuilder<? extends Number> variable) {
        Validate.notNull(variable, "variable must not be null");
        getDataset().setCloseExpression(variable.build());
        return (T) this;
    }

    // volume

    /**
     * <p>setVolume.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a T object.
     */
    public T setVolume(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setVolumeExpression(column.getColumn());
        return (T) this;
    }

    /**
     * <p>setVolume.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a T object.
     */
    public T setVolume(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setVolumeExpression(field.build());
        return (T) this;
    }

    /**
     * <p>setVolume.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setVolume(DRIExpression<? extends Number> valueExpression) {
        getDataset().setVolumeExpression(valueExpression);
        return (T) this;
    }

    /**
     * <p>setVolume.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a T object.
     */
    public T setVolume(VariableBuilder<? extends Number> variable) {
        Validate.notNull(variable, "variable must not be null");
        getDataset().setVolumeExpression(variable.build());
        return (T) this;
    }

    /**
     * <p>setItemHyperLink.</p>
     *
     * @param itemHyperLink a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
     * @return a T object.
     */
    public T setItemHyperLink(HyperLinkBuilder itemHyperLink) {
        Validate.notNull(itemHyperLink, "itemHyperLink must not be null");
        getDataset().setItemHyperLink(itemHyperLink.build());
        return (T) this;
    }

    // plot

    /**
     * <p>setTimeAxisFormat.</p>
     *
     * @param timeAxisFormat a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     * @return a T object.
     */
    public T setTimeAxisFormat(AxisFormatBuilder timeAxisFormat) {
        Validate.notNull(timeAxisFormat, "timeAxisFormat must not be null");
        getPlot().setXAxisFormat(timeAxisFormat.build());
        return (T) this;
    }

    /**
     * <p>setValueAxisFormat.</p>
     *
     * @param valueAxisFormat a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     * @return a T object.
     */
    public T setValueAxisFormat(AxisFormatBuilder valueAxisFormat) {
        Validate.notNull(valueAxisFormat, "valueAxisFormat must not be null");
        getPlot().setYAxisFormat(valueAxisFormat.build());
        return (T) this;
    }
}

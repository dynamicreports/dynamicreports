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

import net.sf.dynamicreports.report.base.chart.dataset.DRGanttChartSerie;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

import java.util.Date;

/**
 * <p>GanttChartSerieBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class GanttChartSerieBuilder extends AbstractChartSerieBuilder<GanttChartSerieBuilder, DRGanttChartSerie> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for GanttChartSerieBuilder.</p>
     */
    protected GanttChartSerieBuilder() {
        super(new DRGanttChartSerie());
    }

    // start date

    /**
     * <p>setStartDate.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setStartDate(ValueColumnBuilder<?, Date> column) {
        Validate.notNull(column, "column must not be null");
        getObject().setStartDateExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setStartDate.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setStartDate(FieldBuilder<Date> field) {
        Validate.notNull(field, "field must not be null");
        getObject().setStartDateExpression(field.build());
        return this;
    }

    /**
     * <p>setStartDate.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setStartDate(DRIExpression<Date> expression) {
        getObject().setStartDateExpression(expression);
        return this;
    }

    // end date

    /**
     * <p>setEndDate.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setEndDate(ValueColumnBuilder<?, Date> column) {
        Validate.notNull(column, "column must not be null");
        getObject().setEndDateExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setEndDate.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setEndDate(FieldBuilder<Date> field) {
        Validate.notNull(field, "field must not be null");
        getObject().setEndDateExpression(field.build());
        return this;
    }

    /**
     * <p>setEndDate.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setEndDate(DRIExpression<Date> expression) {
        getObject().setEndDateExpression(expression);
        return this;
    }

    // percent

    /**
     * <p>setPercent.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setPercent(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getObject().setPercentExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setPercent.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setPercent(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getObject().setPercentExpression(field.build());
        return this;
    }

    /**
     * <p>setPercent.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setPercent(DRIExpression<? extends Number> expression) {
        getObject().setPercentExpression(expression);
        return this;
    }

    /**
     * <p>setPercent.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setPercent(VariableBuilder<? extends Number> variable) {
        Validate.notNull(variable, "variable must not be null");
        getObject().setPercentExpression(variable.build());
        return this;
    }

    // label

    /**
     * <p>setLabel.</p>
     *
     * @param label a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setLabel(String label) {
        getObject().setLabelExpression(Expressions.text(label));
        return this;
    }

    /**
     * <p>setLabel.</p>
     *
     * @param labelExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     */
    public GanttChartSerieBuilder setLabel(DRIExpression<String> labelExpression) {
        getObject().setLabelExpression(labelExpression);
        return this;
    }

    /**
     * <p>getChartSerie.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.chart.dataset.DRGanttChartSerie} object.
     */
    public DRGanttChartSerie getChartSerie() {
        return build();
    }
}

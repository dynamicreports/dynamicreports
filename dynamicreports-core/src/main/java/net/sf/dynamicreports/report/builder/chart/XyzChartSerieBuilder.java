/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.report.base.chart.dataset.DRXyzChartSerie;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>XyzChartSerieBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class XyzChartSerieBuilder extends AbstractChartSerieBuilder<XyzChartSerieBuilder, DRXyzChartSerie> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for XyzChartSerieBuilder.</p>
     */
    protected XyzChartSerieBuilder() {
        super(new DRXyzChartSerie());
    }

    // x

    /**
     * <p>setXValue.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setXValue(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getObject().setXValueExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setXValue.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setXValue(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getObject().setXValueExpression(field.build());
        return this;
    }

    /**
     * <p>setXValue.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setXValue(DRIExpression<? extends Number> valueExpression) {
        getObject().setXValueExpression(valueExpression);
        return this;
    }

    /**
     * <p>setXValue.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setXValue(VariableBuilder<? extends Number> variable) {
        Validate.notNull(variable, "variable must not be null");
        getObject().setXValueExpression(variable.build());
        return this;
    }

    // y

    /**
     * <p>setYValue.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setYValue(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getObject().setYValueExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setYValue.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setYValue(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getObject().setYValueExpression(field.build());
        return this;
    }

    /**
     * <p>setYValue.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setYValue(DRIExpression<? extends Number> valueExpression) {
        getObject().setYValueExpression(valueExpression);
        return this;
    }

    /**
     * <p>setYValue.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setYValue(VariableBuilder<? extends Number> variable) {
        Validate.notNull(variable, "variable must not be null");
        getObject().setYValueExpression(variable.build());
        return this;
    }

    // z

    /**
     * <p>setZValue.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setZValue(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getObject().setZValueExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setZValue.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setZValue(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getObject().setZValueExpression(field.build());
        return this;
    }

    /**
     * <p>setZValue.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setZValue(DRIExpression<? extends Number> valueExpression) {
        getObject().setZValueExpression(valueExpression);
        return this;
    }

    /**
     * <p>setZValue.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     */
    public XyzChartSerieBuilder setZValue(VariableBuilder<? extends Number> variable) {
        Validate.notNull(variable, "variable must not be null");
        getObject().setZValueExpression(variable.build());
        return this;
    }

    /**
     * <p>getChartSerie.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.chart.dataset.DRXyzChartSerie} object.
     */
    public DRXyzChartSerie getChartSerie() {
        return build();
    }
}

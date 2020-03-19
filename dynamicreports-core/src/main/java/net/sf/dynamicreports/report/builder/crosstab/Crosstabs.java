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
package net.sf.dynamicreports.report.builder.crosstab;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * A set of methods of creating and customizing crosstabs
 *
 * @author Ricardo Mariaca
 * 
 */
public class Crosstabs {

    /**
     * <p>crosstab.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public static CrosstabBuilder crosstab() {
        return new CrosstabBuilder();
    }

    // column group

    /**
     * <p>columnGroup.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @param <T>    a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder} object.
     */
    public static <T> CrosstabColumnGroupBuilder<T> columnGroup(ValueColumnBuilder<?, T> column) {
        return new CrosstabColumnGroupBuilder<T>(column);
    }

    /**
     * <p>columnGroup.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @param <T>   a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder} object.
     */
    public static <T> CrosstabColumnGroupBuilder<T> columnGroup(FieldBuilder<T> field) {
        return new CrosstabColumnGroupBuilder<T>(field);
    }

    /**
     * <p>columnGroup.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @param <T>        a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder} object.
     */
    public static <T> CrosstabColumnGroupBuilder<T> columnGroup(String fieldName, Class<T> valueClass) {
        return new CrosstabColumnGroupBuilder<T>(DynamicReports.<T>field(fieldName, valueClass));
    }

    /**
     * <p>columnGroup.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param <T>        a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder} object.
     */
    public static <T> CrosstabColumnGroupBuilder<T> columnGroup(DRIExpression<T> expression) {
        return new CrosstabColumnGroupBuilder<T>(expression);
    }

    // row group

    /**
     * <p>rowGroup.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @param <T>    a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder} object.
     */
    public static <T> CrosstabRowGroupBuilder<T> rowGroup(ValueColumnBuilder<?, T> column) {
        return new CrosstabRowGroupBuilder<T>(column);
    }

    /**
     * <p>rowGroup.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @param <T>   a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder} object.
     */
    public static <T> CrosstabRowGroupBuilder<T> rowGroup(FieldBuilder<T> field) {
        return new CrosstabRowGroupBuilder<T>(field);
    }

    /**
     * <p>rowGroup.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @param <T>        a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder} object.
     */
    public static <T> CrosstabRowGroupBuilder<T> rowGroup(String fieldName, Class<T> valueClass) {
        return new CrosstabRowGroupBuilder<T>(DynamicReports.<T>field(fieldName, valueClass));
    }

    /**
     * <p>rowGroup.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param <T>        a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder} object.
     */
    public static <T> CrosstabRowGroupBuilder<T> rowGroup(DRIExpression<T> expression) {
        return new CrosstabRowGroupBuilder<T>(expression);
    }

    // variable

    /**
     * <p>variable.</p>
     *
     * @param column      a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabVariableBuilder} object.
     */
    public static <T> CrosstabVariableBuilder<T> variable(ValueColumnBuilder<?, ?> column, Calculation calculation) {
        Validate.notNull(column, "column must not be null");
        return new CrosstabVariableBuilder<T>(column, calculation);
    }

    /**
     * <p>variable.</p>
     *
     * @param field       a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabVariableBuilder} object.
     */
    public static <T> CrosstabVariableBuilder<T> variable(FieldBuilder<T> field, Calculation calculation) {
        Validate.notNull(field, "field must not be null");
        return new CrosstabVariableBuilder<T>(field, calculation);
    }

    /**
     * <p>variable.</p>
     *
     * @param fieldName   a {@link java.lang.String} object.
     * @param valueClass  a {@link java.lang.Class} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabVariableBuilder} object.
     */
    public static <T> CrosstabVariableBuilder<T> variable(String fieldName, Class<?> valueClass, Calculation calculation) {
        return new CrosstabVariableBuilder<T>(DynamicReports.field(fieldName, valueClass), calculation);
    }

    /**
     * <p>variable.</p>
     *
     * @param expression  a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabVariableBuilder} object.
     */
    public static <T> CrosstabVariableBuilder<T> variable(DRIExpression<?> expression, Calculation calculation) {
        return new CrosstabVariableBuilder<T>(expression, calculation);
    }

    // measure

    /**
     * <p>measure.</p>
     *
     * @param column      a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     */
    public static <T> CrosstabMeasureBuilder<T> measure(ValueColumnBuilder<?, ?> column, Calculation calculation) {
        Validate.notNull(column, "column must not be null");
        return new CrosstabMeasureBuilder<T>(column, calculation);
    }

    /**
     * <p>measure.</p>
     *
     * @param title       a {@link java.lang.String} object.
     * @param column      a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     */
    public static <T> CrosstabMeasureBuilder<T> measure(String title, ValueColumnBuilder<?, ?> column, Calculation calculation) {
        CrosstabMeasureBuilder<T> measure = measure(column, calculation);
        return measure.setTitle(title);
    }

    /**
     * <p>measure.</p>
     *
     * @param field       a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     */
    public static <T> CrosstabMeasureBuilder<T> measure(FieldBuilder<T> field, Calculation calculation) {
        Validate.notNull(field, "field must not be null");
        return new CrosstabMeasureBuilder<T>(field, calculation);
    }

    /**
     * <p>measure.</p>
     *
     * @param title       a {@link java.lang.String} object.
     * @param field       a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     */
    public static <T> CrosstabMeasureBuilder<T> measure(String title, FieldBuilder<T> field, Calculation calculation) {
        return measure(field, calculation).setTitle(title);
    }

    /**
     * <p>measure.</p>
     *
     * @param fieldName   a {@link java.lang.String} object.
     * @param valueClass  a {@link java.lang.Class} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     */
    public static <T> CrosstabMeasureBuilder<T> measure(String fieldName, Class<?> valueClass, Calculation calculation) {
        return new CrosstabMeasureBuilder<T>(DynamicReports.field(fieldName, valueClass), calculation);
    }

    /**
     * <p>measure.</p>
     *
     * @param title       a {@link java.lang.String} object.
     * @param fieldName   a {@link java.lang.String} object.
     * @param valueClass  a {@link java.lang.Class} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     */
    public static <T> CrosstabMeasureBuilder<T> measure(String title, String fieldName, Class<?> valueClass, Calculation calculation) {
        CrosstabMeasureBuilder<T> measure = measure(fieldName, valueClass, calculation);
        return measure.setTitle(title);
    }

    /**
     * <p>measure.</p>
     *
     * @param expression  a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     */
    public static <T> CrosstabMeasureBuilder<T> measure(DRIExpression<?> expression, Calculation calculation) {
        return new CrosstabMeasureBuilder<T>(expression, calculation);
    }

    /**
     * <p>measure.</p>
     *
     * @param title       a {@link java.lang.String} object.
     * @param expression  a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     */
    public static <T> CrosstabMeasureBuilder<T> measure(String title, DRIExpression<?> expression, Calculation calculation) {
        CrosstabMeasureBuilder<T> measure = measure(expression, calculation);
        return measure.setTitle(title);
    }

    /**
     * <p>measure.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param <T>        a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     */
    public static <T> CrosstabMeasureBuilder<T> measure(DRIExpression<?> expression) {
        return new CrosstabMeasureBuilder<T>(expression);
    }

    /**
     * <p>measure.</p>
     *
     * @param title      a {@link java.lang.String} object.
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param <T>        a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     */
    public static <T> CrosstabMeasureBuilder<T> measure(String title, DRIExpression<?> expression) {
        CrosstabMeasureBuilder<T> measure = measure(expression);
        return measure.setTitle(title);
    }
}

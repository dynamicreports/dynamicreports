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
package net.sf.dynamicreports.report.builder.subtotal;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * A set of methods of creating column subtotals
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Subtotals {

    // calculation
    public static <T> AggregationSubtotalBuilder<T> aggregate(ValueColumnBuilder<?, ?> subtotalColumn, Calculation calculation) {
        Validate.notNull(subtotalColumn, "subtotalColumn must not be null");
        return new AggregationSubtotalBuilder<T>(subtotalColumn, calculation);
    }

    public static <T> AggregationSubtotalBuilder<T> aggregate(String fieldName, Class<?> valueClass, ColumnBuilder<?, ?> showInColumn, Calculation calculation) {
        return aggregate(DynamicReports.field(fieldName, valueClass), showInColumn, calculation);
    }

    public static <T> AggregationSubtotalBuilder<T> aggregate(FieldBuilder<?> field, ColumnBuilder<?, ?> showInColumn, Calculation calculation) {
        Validate.notNull(showInColumn, "showInColumn must not be null");
        return new AggregationSubtotalBuilder<T>(field, showInColumn, calculation);
    }

    public static <T> AggregationSubtotalBuilder<T> aggregate(DRIExpression<?> expression, ColumnBuilder<?, ?> showInColumn, Calculation calculation) {
        Validate.notNull(showInColumn, "showInColumn must not be null");
        return new AggregationSubtotalBuilder<T>(expression, showInColumn, calculation);
    }

    // sum
    public static <T extends Number> AggregationSubtotalBuilder<T> sum(ValueColumnBuilder<?, T> subtotalColumn) {
        return aggregate(subtotalColumn, Calculation.SUM);
    }

    public static <T extends Number> AggregationSubtotalBuilder<T> sum(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(fieldName, valueClass, showInColumn, Calculation.SUM);
    }

    public static <T extends Number> AggregationSubtotalBuilder<T> sum(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(field, showInColumn, Calculation.SUM);
    }

    public static <T extends Number> AggregationSubtotalBuilder<T> sum(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(expression, showInColumn, Calculation.SUM);
    }

    // average
    public static <T extends Number> AggregationSubtotalBuilder<Number> avg(ValueColumnBuilder<?, T> subtotalColumn) {
        return aggregate(subtotalColumn, Calculation.AVERAGE);
    }

    public static <T extends Number> AggregationSubtotalBuilder<Number> avg(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(fieldName, valueClass, showInColumn, Calculation.AVERAGE);
    }

    public static <T extends Number> AggregationSubtotalBuilder<Number> avg(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(field, showInColumn, Calculation.AVERAGE);
    }

    public static <T extends Number> AggregationSubtotalBuilder<Number> avg(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(expression, showInColumn, Calculation.AVERAGE);
    }

    // count
    public static AggregationSubtotalBuilder<Long> count(ValueColumnBuilder<?, ?> subtotalColumn) {
        return aggregate(subtotalColumn, Calculation.COUNT);
    }

    public static AggregationSubtotalBuilder<Long> count(String fieldName, Class<?> valueClass, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(fieldName, valueClass, showInColumn, Calculation.COUNT);
    }

    public static AggregationSubtotalBuilder<Long> count(FieldBuilder<?> field, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(field, showInColumn, Calculation.COUNT);
    }

    public static AggregationSubtotalBuilder<Long> count(DRIExpression<?> expression, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(expression, showInColumn, Calculation.COUNT);
    }

    // distinct count
    public static AggregationSubtotalBuilder<Long> distinctCount(ValueColumnBuilder<?, ?> subtotalColumn) {
        return aggregate(subtotalColumn, Calculation.DISTINCT_COUNT);
    }

    public static AggregationSubtotalBuilder<Long> distinctCount(String fieldName, Class<?> valueClass, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(fieldName, valueClass, showInColumn, Calculation.DISTINCT_COUNT);
    }

    public static AggregationSubtotalBuilder<Long> distinctCount(FieldBuilder<?> field, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(field, showInColumn, Calculation.DISTINCT_COUNT);
    }

    public static AggregationSubtotalBuilder<Long> distinctCount(DRIExpression<?> expression, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(expression, showInColumn, Calculation.DISTINCT_COUNT);
    }

    // first
    public static <T> AggregationSubtotalBuilder<T> first(ValueColumnBuilder<?, T> subtotalColumn) {
        return aggregate(subtotalColumn, Calculation.FIRST);
    }

    public static <T> AggregationSubtotalBuilder<T> first(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(fieldName, valueClass, showInColumn, Calculation.FIRST);
    }

    public static <T> AggregationSubtotalBuilder<T> first(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(field, showInColumn, Calculation.FIRST);
    }

    public static <T> AggregationSubtotalBuilder<T> first(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(expression, showInColumn, Calculation.FIRST);
    }

    // highest
    public static <T> AggregationSubtotalBuilder<T> max(ValueColumnBuilder<?, T> subtotalColumn) {
        return aggregate(subtotalColumn, Calculation.HIGHEST);
    }

    public static <T> AggregationSubtotalBuilder<T> max(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(fieldName, valueClass, showInColumn, Calculation.HIGHEST);
    }

    public static <T> AggregationSubtotalBuilder<T> max(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(field, showInColumn, Calculation.HIGHEST);
    }

    public static <T> AggregationSubtotalBuilder<T> max(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(expression, showInColumn, Calculation.HIGHEST);
    }

    // lowest
    public static <T> AggregationSubtotalBuilder<T> min(ValueColumnBuilder<?, T> subtotalColumn) {
        return aggregate(subtotalColumn, Calculation.LOWEST);
    }

    public static <T> AggregationSubtotalBuilder<T> min(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(fieldName, valueClass, showInColumn, Calculation.LOWEST);
    }

    public static <T> AggregationSubtotalBuilder<T> min(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(field, showInColumn, Calculation.LOWEST);
    }

    public static <T> AggregationSubtotalBuilder<T> min(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(expression, showInColumn, Calculation.LOWEST);
    }

    // standard deviation
    public static <T extends Number> AggregationSubtotalBuilder<Number> stdDev(ValueColumnBuilder<?, T> subtotalColumn) {
        return aggregate(subtotalColumn, Calculation.STANDARD_DEVIATION);
    }

    public static <T extends Number> AggregationSubtotalBuilder<Number> stdDev(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(fieldName, valueClass, showInColumn, Calculation.STANDARD_DEVIATION);
    }

    public static <T extends Number> AggregationSubtotalBuilder<Number> stdDev(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(field, showInColumn, Calculation.STANDARD_DEVIATION);
    }

    public static <T extends Number> AggregationSubtotalBuilder<Number> stdDev(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(expression, showInColumn, Calculation.STANDARD_DEVIATION);
    }

    // variance
    public static <T extends Number> AggregationSubtotalBuilder<Number> var(ValueColumnBuilder<?, T> subtotalColumn) {
        return aggregate(subtotalColumn, Calculation.VARIANCE);
    }

    public static <T extends Number> AggregationSubtotalBuilder<Number> var(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(fieldName, valueClass, showInColumn, Calculation.VARIANCE);
    }

    public static <T extends Number> AggregationSubtotalBuilder<Number> var(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(field, showInColumn, Calculation.VARIANCE);
    }

    public static <T extends Number> AggregationSubtotalBuilder<Number> var(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(expression, showInColumn, Calculation.VARIANCE);
    }

    // custom
    public static <T> CustomSubtotalBuilder<T> customValue(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
        Validate.notNull(showInColumn, "showInColumn must not be null");
        return new CustomSubtotalBuilder<T>(expression, showInColumn);
    }

    // percentage
    public static PercentageSubtotalBuilder percentage(ValueColumnBuilder<?, ? extends Number> subtotalColumn) {
        Validate.notNull(subtotalColumn, "subtotalColumn must not be null");
        return new PercentageSubtotalBuilder(subtotalColumn);
    }

    public static PercentageSubtotalBuilder percentage(String fieldName, Class<? extends Number> valueClass, ColumnBuilder<?, ?> showInColumn) {
        return percentage(DynamicReports.<Number>field(fieldName, valueClass), showInColumn);
    }

    public static PercentageSubtotalBuilder percentage(FieldBuilder<? extends Number> field, ColumnBuilder<?, ?> showInColumn) {
        Validate.notNull(showInColumn, "showInColumn must not be null");
        return new PercentageSubtotalBuilder(field, showInColumn);
    }

    /*public static PercentageSubtotalBuilder percentage(DRISimpleExpression<? extends Number> expression, ColumnBuilder<?, ?> showInColumn) {
        Validate.notNull(showInColumn, "showInColumn must not be null");
        return new PercentageSubtotalBuilder(expression, showInColumn);
    }*/

    // text
    public static AggregationSubtotalBuilder<String> text(String text, ColumnBuilder<?, ?> showInColumn) {
        return aggregate(Expressions.text(text), showInColumn, Calculation.NOTHING);
    }
}

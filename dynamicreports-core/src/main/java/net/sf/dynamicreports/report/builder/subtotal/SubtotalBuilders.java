/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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

import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * A set of methods of creating column subtotals
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class SubtotalBuilders {

	// calculation
	/**
	 * <p>aggregate.</p>
	 *
	 * @param subtotalColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> aggregate(ValueColumnBuilder<?, ?> subtotalColumn, Calculation calculation) {
		return Subtotals.aggregate(subtotalColumn, calculation);
	}

	/**
	 * <p>aggregate.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> aggregate(String fieldName, Class<?> valueClass, ColumnBuilder<?, ?> showInColumn, Calculation calculation) {
		return Subtotals.aggregate(fieldName, valueClass, showInColumn, calculation);
	}

	/**
	 * <p>aggregate.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> aggregate(FieldBuilder<?> field, ColumnBuilder<?, ?> showInColumn, Calculation calculation) {
		return Subtotals.aggregate(field, showInColumn, calculation);
	}

	/**
	 * <p>aggregate.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> aggregate(DRIExpression<?> expression, ColumnBuilder<?, ?> showInColumn, Calculation calculation) {
		return Subtotals.aggregate(expression, showInColumn, calculation);
	}

	// sum
	/**
	 * <p>sum.</p>
	 *
	 * @param subtotalColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<T> sum(ValueColumnBuilder<?, T> subtotalColumn) {
		return Subtotals.sum(subtotalColumn);
	}

	/**
	 * <p>sum.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<T> sum(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.sum(fieldName, valueClass, showInColumn);
	}

	/**
	 * <p>sum.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<T> sum(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.sum(field, showInColumn);
	}

	/**
	 * <p>sum.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<T> sum(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.sum(expression, showInColumn);
	}

	// average
	/**
	 * <p>avg.</p>
	 *
	 * @param subtotalColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> avg(ValueColumnBuilder<?, T> subtotalColumn) {
		return Subtotals.avg(subtotalColumn);
	}

	/**
	 * <p>avg.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> avg(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.avg(fieldName, valueClass, showInColumn);
	}

	/**
	 * <p>avg.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> avg(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.avg(field, showInColumn);
	}

	/**
	 * <p>avg.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> avg(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.avg(expression, showInColumn);
	}

	// count
	/**
	 * <p>count.</p>
	 *
	 * @param subtotalColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public AggregationSubtotalBuilder<Long> count(ValueColumnBuilder<?, ?> subtotalColumn) {
		return Subtotals.count(subtotalColumn);
	}

	/**
	 * <p>count.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public AggregationSubtotalBuilder<Long> count(String fieldName, Class<?> valueClass, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.count(fieldName, valueClass, showInColumn);
	}

	/**
	 * <p>count.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public AggregationSubtotalBuilder<Long> count(FieldBuilder<?> field, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.count(field, showInColumn);
	}

	/**
	 * <p>count.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public AggregationSubtotalBuilder<Long> count(DRIExpression<?> expression, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.count(expression, showInColumn);
	}

	// distinct count
	/**
	 * <p>distinctCount.</p>
	 *
	 * @param subtotalColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public AggregationSubtotalBuilder<Long> distinctCount(ValueColumnBuilder<?, ?> subtotalColumn) {
		return Subtotals.distinctCount(subtotalColumn);
	}

	/**
	 * <p>distinctCount.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public AggregationSubtotalBuilder<Long> distinctCount(String fieldName, Class<?> valueClass, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.distinctCount(fieldName, valueClass, showInColumn);
	}

	/**
	 * <p>distinctCount.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public AggregationSubtotalBuilder<Long> distinctCount(FieldBuilder<?> field, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.distinctCount(field, showInColumn);
	}

	/**
	 * <p>distinctCount.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public AggregationSubtotalBuilder<Long> distinctCount(DRIExpression<?> expression, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.distinctCount(expression, showInColumn);
	}

	// first
	/**
	 * <p>first.</p>
	 *
	 * @param subtotalColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> first(ValueColumnBuilder<?, T> subtotalColumn) {
		return Subtotals.first(subtotalColumn);
	}

	/**
	 * <p>first.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> first(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.first(fieldName, valueClass, showInColumn);
	}

	/**
	 * <p>first.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> first(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.first(field, showInColumn);
	}

	/**
	 * <p>first.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> first(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.first(expression, showInColumn);
	}

	// highest
	/**
	 * <p>max.</p>
	 *
	 * @param subtotalColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> max(ValueColumnBuilder<?, T> subtotalColumn) {
		return Subtotals.max(subtotalColumn);
	}

	/**
	 * <p>max.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> max(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.max(fieldName, valueClass, showInColumn);
	}

	/**
	 * <p>max.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> max(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.max(field, showInColumn);
	}

	/**
	 * <p>max.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> max(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.max(expression, showInColumn);
	}

	// lowest
	/**
	 * <p>min.</p>
	 *
	 * @param subtotalColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> min(ValueColumnBuilder<?, T> subtotalColumn) {
		return Subtotals.min(subtotalColumn);
	}

	/**
	 * <p>min.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> min(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.min(fieldName, valueClass, showInColumn);
	}

	/**
	 * <p>min.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> min(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.min(field, showInColumn);
	}

	/**
	 * <p>min.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T> AggregationSubtotalBuilder<T> min(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.min(expression, showInColumn);
	}

	// standard deviation
	/**
	 * <p>stdDev.</p>
	 *
	 * @param subtotalColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> stdDev(ValueColumnBuilder<?, T> subtotalColumn) {
		return Subtotals.stdDev(subtotalColumn);
	}

	/**
	 * <p>stdDev.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> stdDev(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.stdDev(fieldName, valueClass, showInColumn);
	}

	/**
	 * <p>stdDev.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> stdDev(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.stdDev(field, showInColumn);
	}

	/**
	 * <p>stdDev.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> stdDev(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.stdDev(expression, showInColumn);
	}

	// variance
	/**
	 * <p>var.</p>
	 *
	 * @param subtotalColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> var(ValueColumnBuilder<?, T> subtotalColumn) {
		return Subtotals.var(subtotalColumn);
	}

	/**
	 * <p>var.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> var(String fieldName, Class<T> valueClass, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.var(fieldName, valueClass, showInColumn);
	}

	/**
	 * <p>var.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> var(FieldBuilder<T> field, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.var(field, showInColumn);
	}

	/**
	 * <p>var.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public <T extends Number> AggregationSubtotalBuilder<Number> var(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.var(expression, showInColumn);
	}

	// custom
	/**
	 * <p>customValue.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.CustomSubtotalBuilder} object.
	 */
	public <T> CustomSubtotalBuilder<T> customValue(DRIExpression<T> expression, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.customValue(expression, showInColumn);
	}

	// percentage
	/**
	 * <p>percentage.</p>
	 *
	 * @param subtotalColumn a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.PercentageSubtotalBuilder} object.
	 */
	public PercentageSubtotalBuilder percentage(ValueColumnBuilder<?, ? extends Number> subtotalColumn) {
		return Subtotals.percentage(subtotalColumn);
	}

	/**
	 * <p>percentage.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.PercentageSubtotalBuilder} object.
	 */
	public PercentageSubtotalBuilder percentage(String fieldName, Class<? extends Number> valueClass, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.percentage(fieldName, valueClass, showInColumn);
	}

	/**
	 * <p>percentage.</p>
	 *
	 * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.PercentageSubtotalBuilder} object.
	 */
	public PercentageSubtotalBuilder percentage(FieldBuilder<? extends Number> field, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.percentage(field, showInColumn);
	}

	/*public PercentageSubtotalBuilder percentage(DRISimpleExpression<? extends Number> expression, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.percentage(expression, showInColumn);
	}*/

	// text
	/**
	 * <p>text.</p>
	 *
	 * @param text a {@link java.lang.String} object.
	 * @param showInColumn a {@link net.sf.dynamicreports.report.builder.column.ColumnBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder} object.
	 */
	public AggregationSubtotalBuilder<String> text(String text, ColumnBuilder<?, ?> showInColumn) {
		return Subtotals.text(text, showInColumn);
	}
}

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

package net.sf.dynamicreports.report.builder.expression;

import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.builder.group.GroupBuilder;
import net.sf.dynamicreports.report.definition.DRICrosstabValue;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * A set of build in expressions.<br/>
 * Expressions are used to define various calculations, conditions, text field content, specific report groups, etc.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ExpressionBuilders {

	public PrintInFirstPageExpression printInFirstPage() {
		return Expressions.printInFirstPage();
	}

	public PrintNotInFirstPageExpression printNotInFirstPage() {
		return Expressions.printNotInFirstPage();
	}

	public PrintWhenGroupHasMoreThanOneRowExpression printWhenGroupHasMoreThanOneRow(String groupName) {
		return Expressions.printWhenGroupHasMoreThanOneRow(groupName);
	}

	public PrintWhenGroupHasMoreThanOneRowExpression printWhenGroupHasMoreThanOneRow(GroupBuilder<?> group) {
		return Expressions.printWhenGroupHasMoreThanOneRow(group);
	}

	public ReportRowNumberExpression reportRowNumber() {
		return Expressions.reportRowNumber();
	}

	public PageRowNumberExpression pageRowNumber() {
		return Expressions.pageRowNumber();
	}

	public ColumnRowNumberExpression columnRowNumber() {
		return Expressions.columnRowNumber();
	}

	public PageNumberExpression pageNumber() {
		return Expressions.pageNumber();
	}

	public ColumnNumberExpression columnNumber() {
		return Expressions.columnNumber();
	}

	public GroupRowNumberExpression groupRowNumber(String groupName) {
		return Expressions.groupRowNumber(groupName);
	}

	public GroupRowNumberExpression groupRowNumber(GroupBuilder<?> group) {
		return Expressions.groupRowNumber(group);
	}

	public ValueExpression<Date> date(Date date) {
		return Expressions.date(date);
	}

	public ValueExpression<Number> number(Number number) {
		return Expressions.number(number);
	}

	public ValueExpression<Image> image(Image image) {
		return Expressions.image(image);
	}

	public ValueExpression<InputStream> inputStream(InputStream inputStream) {
		return Expressions.inputStream(inputStream);
	}

	public ValueExpression<URL> url(URL url) {
		return Expressions.url(url);
	}

	public <T> ValueExpression<T> value(T value) {
		return Expressions.value(value);
	}

	public <T> ValueExpression<T> value(T value, Class<? super T> valueClass) {
		return Expressions.value(value, valueClass);
	}

	public ValueExpression<String> text(String text) {
		return Expressions.text(text);
	}

	public DataSourceExpression dataSource(JRDataSource dataSource) {
		return Expressions.dataSource(dataSource);
	}

	public MessageExpression message(String key) {
		return Expressions.message(key);
	}

	public MessageExpression message(String key, Object[] arguments) {
		return Expressions.message(key, arguments);
	}

	// jasper
	/**
	 * Creates a new jasper string expression, useful only for showing a static text.<br/>
	 * This method escapes the characters in a {@code String} using Java String rules.
	 *
	 * @param text
	 *          text to be shown
	 * @return the expression
	 */
	public JasperExpression<String> jasperSyntaxText(String text) {
		return Expressions.jasperSyntaxText(text);
	}

	/**
	 * Creates a new jasper expression.<br/>
	 * This expression allows declaring an expression in a Jasper native syntax. Knowledge of the jasper syntax is also required for proper use.
	 *
	 * @param expression
	 *          the jasper expression
	 * @param valueClass
	 *          the expression class
	 * @return the expression
	 */
	public <T> JasperExpression<T> jasperSyntax(String expression, Class<? super T> valueClass) {
		return Expressions.jasperSyntax(expression, valueClass);
	}

	/**
	 * Creates a new jasper expression.<br/>
	 * This expression allows declaring an expression in a Jasper native syntax. Knowledge of the jasper syntax is also required for proper use.
	 *
	 * @param expression
	 *          the jasper expression
	 * @return the expression
	 */
	@SuppressWarnings("rawtypes")
	public JasperExpression jasperSyntax(String expression) {
		return Expressions.jasperSyntax(expression);
	}

	// property
	public PropertyExpression property(String name, DRISimpleExpression<String> valueExpression) {
		return Expressions.property(name, valueExpression);
	}

	public PropertyExpression property(String name, String value) {
		return Expressions.property(name, value);
	}

	// parameter
	public ParameterExpression parameter(String name, DRISimpleExpression<?> valueExpression) {
		return Expressions.parameter(name, valueExpression);
	}

	public ParameterExpression parameter(String name, Object value) {
		return Expressions.parameter(name, value);
	}

	public PrintInOddRowExpression printInOddRow() {
		return Expressions.printInOddRow();
	}

	public PrintInEvenRowExpression printInEvenRow() {
		return Expressions.printInEvenRow();
	}

	// subdatasource
	public BeanCollectionSubDatasourceExpression subDatasourceBeanCollection(String fieldName) {
		return Expressions.subDatasourceBeanCollection(fieldName);
	}

	public BeanCollectionSubDatasourceExpression subDatasourceBeanCollection(DRIExpression<? extends Collection<?>> expression) {
		return Expressions.subDatasourceBeanCollection(expression);
	}

	public BeanArraySubDatasourceExpression subDatasourceBeanArray(String fieldName) {
		return Expressions.subDatasourceBeanArray(fieldName);
	}

	public BeanArraySubDatasourceExpression subDatasourceBeanArray(DRIExpression<? extends Object[]> expression) {
		return Expressions.subDatasourceBeanArray(expression);
	}

	public MapCollectionSubDatasourceExpression subDatasourceMapCollection(String fieldName) {
		return Expressions.subDatasourceMapCollection(fieldName);
	}

	public MapCollectionSubDatasourceExpression subDatasourceMapCollection(DRIExpression<? extends Collection<Map<String, ?>>> expression) {
		return Expressions.subDatasourceMapCollection(expression);
	}

	public MapArraySubDatasourceExpression subDatasourceMapArray(String fieldName) {
		return Expressions.subDatasourceMapArray(fieldName);
	}

	public MapArraySubDatasourceExpression subDatasourceMapArray(DRIExpression<? extends Object[]> expression) {
		return Expressions.subDatasourceMapArray(expression);
	}

	// crosstab
	public OrderByExpression orderBy(CrosstabMeasureBuilder<? extends Comparable<?>> measure) {
		return Expressions.orderBy(measure);
	}

	public <T> CrosstabValueExpression<T> crosstabValue(AbstractCrosstabGroupBuilder<?, ?, ?> group) {
		return Expressions.crosstabValue(group);
	}

	public <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure) {
		return Expressions.crosstabValue(measure);
	}

	public <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure, AbstractCrosstabGroupBuilder<?, ?, ?> group) {
		return Expressions.crosstabValue(measure, group);
	}

	public <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure, CrosstabRowGroupBuilder<?> rowGroup,
			CrosstabColumnGroupBuilder<?> columnGroup) {
		return Expressions.crosstabValue(measure, rowGroup, columnGroup);
	}
}

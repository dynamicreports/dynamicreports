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
import net.sf.jasperreports.engine.JRDataSource;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.Validate;

/**
 * A set of build in expressions.<br/>
 * Expressions are used to define various calculations, conditions, text field content, specific report groups, etc.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class Expressions {
	private static final PrintInFirstPageExpression printInFirstPage = new PrintInFirstPageExpression();
	private static final PrintNotInFirstPageExpression printNotInFirstPage = new PrintNotInFirstPageExpression();
	private static final ReportRowNumberExpression reportRowNumber = new ReportRowNumberExpression();
	private static final PageRowNumberExpression pageRowNumber = new PageRowNumberExpression();
	private static final ColumnRowNumberExpression columnRowNumber = new ColumnRowNumberExpression();
	private static final PageNumberExpression pageNumber = new PageNumberExpression();
	private static final ColumnNumberExpression columnNumber = new ColumnNumberExpression();
	private static final PrintInOddRowExpression printInOddRow = new PrintInOddRowExpression();
	private static final PrintInEvenRowExpression printInEvenRow = new PrintInEvenRowExpression();

	/**
	 * <p>printInFirstPage.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintInFirstPageExpression} object.
	 */
	public static PrintInFirstPageExpression printInFirstPage() {
		return printInFirstPage;
	}

	/**
	 * <p>printNotInFirstPage.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintNotInFirstPageExpression} object.
	 */
	public static PrintNotInFirstPageExpression printNotInFirstPage() {
		return printNotInFirstPage;
	}

	/**
	 * <p>printWhenGroupHasMoreThanOneRow.</p>
	 *
	 * @param groupName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintWhenGroupHasMoreThanOneRowExpression} object.
	 */
	public static PrintWhenGroupHasMoreThanOneRowExpression printWhenGroupHasMoreThanOneRow(String groupName) {
		return new PrintWhenGroupHasMoreThanOneRowExpression(groupName);
	}

	/**
	 * <p>printWhenGroupHasMoreThanOneRow.</p>
	 *
	 * @param group a {@link net.sf.dynamicreports.report.builder.group.GroupBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintWhenGroupHasMoreThanOneRowExpression} object.
	 */
	public static PrintWhenGroupHasMoreThanOneRowExpression printWhenGroupHasMoreThanOneRow(GroupBuilder<?> group) {
		Validate.notNull(group, "group must not be null");
		return printWhenGroupHasMoreThanOneRow(group.getGroup().getName());
	}

	/**
	 * <p>reportRowNumber.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ReportRowNumberExpression} object.
	 */
	public static ReportRowNumberExpression reportRowNumber() {
		return reportRowNumber;
	}

	/**
	 * <p>pageRowNumber.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.PageRowNumberExpression} object.
	 */
	public static PageRowNumberExpression pageRowNumber() {
		return pageRowNumber;
	}

	/**
	 * <p>columnRowNumber.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ColumnRowNumberExpression} object.
	 */
	public static ColumnRowNumberExpression columnRowNumber() {
		return columnRowNumber;
	}

	/**
	 * <p>pageNumber.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.PageNumberExpression} object.
	 */
	public static PageNumberExpression pageNumber() {
		return pageNumber;
	}

	/**
	 * <p>columnNumber.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ColumnNumberExpression} object.
	 */
	public static ColumnNumberExpression columnNumber() {
		return columnNumber;
	}

	/**
	 * <p>groupRowNumber.</p>
	 *
	 * @param groupName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.GroupRowNumberExpression} object.
	 */
	public static GroupRowNumberExpression groupRowNumber(String groupName) {
		return new GroupRowNumberExpression(groupName);
	}

	/**
	 * <p>groupRowNumber.</p>
	 *
	 * @param group a {@link net.sf.dynamicreports.report.builder.group.GroupBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.GroupRowNumberExpression} object.
	 */
	public static GroupRowNumberExpression groupRowNumber(GroupBuilder<?> group) {
		Validate.notNull(group, "group must not be null");
		return groupRowNumber(group.getGroup().getName());
	}

	/**
	 * <p>date.</p>
	 *
	 * @param date a {@link java.util.Date} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
	 */
	public static ValueExpression<Date> date(Date date) {
		return value(date, Date.class);
	}

	/**
	 * <p>number.</p>
	 *
	 * @param number a {@link java.lang.Number} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
	 */
	public static ValueExpression<Number> number(Number number) {
		return value(number, Number.class);
	}

	/**
	 * <p>image.</p>
	 *
	 * @param image a {@link java.awt.Image} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
	 */
	public static ValueExpression<Image> image(Image image) {
		return value(image, Image.class);
	}

	/**
	 * <p>inputStream.</p>
	 *
	 * @param inputStream a {@link java.io.InputStream} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
	 */
	public static ValueExpression<InputStream> inputStream(InputStream inputStream) {
		return value(inputStream, InputStream.class);
	}

	/**
	 * <p>url.</p>
	 *
	 * @param url a {@link java.net.URL} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
	 */
	public static ValueExpression<URL> url(URL url) {
		return value(url, URL.class);
	}

	/**
	 * <p>value.</p>
	 *
	 * @param value a T object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
	 */
	public static <T> ValueExpression<T> value(T value) {
		return new ValueExpression<T>(value);
	}

	/**
	 * <p>value.</p>
	 *
	 * @param value a T object.
	 * @param valueClass a {@link java.lang.Class} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
	 */
	public static <T> ValueExpression<T> value(T value, Class<? super T> valueClass) {
		return new ValueExpression<T>(value, valueClass);
	}

	/**
	 * <p>text.</p>
	 *
	 * @param text a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
	 */
	public static ValueExpression<String> text(String text) {
		return value(text, String.class);
	}

	/**
	 * <p>dataSource.</p>
	 *
	 * @param dataSource a {@link net.sf.jasperreports.engine.JRDataSource} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.DataSourceExpression} object.
	 */
	public static DataSourceExpression dataSource(JRDataSource dataSource) {
		return new DataSourceExpression(dataSource);
	}

	/**
	 * <p>message.</p>
	 *
	 * @param key a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.MessageExpression} object.
	 */
	public static MessageExpression message(String key) {
		if (key != null) {
			return new MessageExpression(key);
		}
		return null;
	}

	/**
	 * <p>message.</p>
	 *
	 * @param key a {@link java.lang.String} object.
	 * @param arguments an array of {@link java.lang.Object} objects.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.MessageExpression} object.
	 */
	public static MessageExpression message(String key, Object[] arguments) {
		if (key != null) {
			return new MessageExpression(key, arguments);
		}
		return null;
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
	public static JasperExpression<String> jasperSyntaxText(String text) {
		return new JasperExpression<String>("\"" + StringEscapeUtils.escapeJava(text) + "\"", String.class);
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
	 * @param <T> a T object.
	 */
	public static <T> JasperExpression<T> jasperSyntax(String expression, Class<? super T> valueClass) {
		return new JasperExpression<T>(expression, valueClass);
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
	public static JasperExpression jasperSyntax(String expression) {
		return jasperSyntax(expression, Object.class);
	}

	// property
	/**
	 * <p>property.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.PropertyExpression} object.
	 */
	public static PropertyExpression property(String name, DRIExpression<String> valueExpression) {
		return new PropertyExpression(name, valueExpression);
	}

	/**
	 * <p>property.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param value a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.PropertyExpression} object.
	 */
	public static PropertyExpression property(String name, String value) {
		return new PropertyExpression(name, text(value));
	}

	// parameter
	/**
	 * <p>parameter.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ParameterExpression} object.
	 */
	public static ParameterExpression parameter(String name, DRIExpression<?> valueExpression) {
		return new ParameterExpression(name, valueExpression);
	}

	/**
	 * <p>parameter.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 * @param value a {@link java.lang.Object} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.ParameterExpression} object.
	 */
	public static ParameterExpression parameter(String name, Object value) {
		return new ParameterExpression(name, value(value));
	}

	/**
	 * <p>printInOddRow.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintInOddRowExpression} object.
	 */
	public static PrintInOddRowExpression printInOddRow() {
		return printInOddRow;
	}

	/**
	 * <p>printInEvenRow.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintInEvenRowExpression} object.
	 */
	public static PrintInEvenRowExpression printInEvenRow() {
		return printInEvenRow;
	}

	// subdatasource
	/**
	 * <p>subDatasourceBeanCollection.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.BeanCollectionSubDatasourceExpression} object.
	 */
	public static BeanCollectionSubDatasourceExpression subDatasourceBeanCollection(String fieldName) {
		return new BeanCollectionSubDatasourceExpression(fieldName);
	}

	/**
	 * <p>subDatasourceBeanCollection.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.BeanCollectionSubDatasourceExpression} object.
	 */
	public static BeanCollectionSubDatasourceExpression subDatasourceBeanCollection(DRIExpression<? extends Collection<?>> expression) {
		return new BeanCollectionSubDatasourceExpression(expression);
	}

	/**
	 * <p>subDatasourceBeanArray.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.BeanArraySubDatasourceExpression} object.
	 */
	public static BeanArraySubDatasourceExpression subDatasourceBeanArray(String fieldName) {
		return new BeanArraySubDatasourceExpression(fieldName);
	}

	/**
	 * <p>subDatasourceBeanArray.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.BeanArraySubDatasourceExpression} object.
	 */
	public static BeanArraySubDatasourceExpression subDatasourceBeanArray(DRIExpression<? extends Object[]> expression) {
		return new BeanArraySubDatasourceExpression(expression);
	}

	/**
	 * <p>subDatasourceMapCollection.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.MapCollectionSubDatasourceExpression} object.
	 */
	public static MapCollectionSubDatasourceExpression subDatasourceMapCollection(String fieldName) {
		return new MapCollectionSubDatasourceExpression(fieldName);
	}

	/**
	 * <p>subDatasourceMapCollection.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.MapCollectionSubDatasourceExpression} object.
	 */
	public static MapCollectionSubDatasourceExpression subDatasourceMapCollection(DRIExpression<? extends Collection<Map<String, ?>>> expression) {
		return new MapCollectionSubDatasourceExpression(expression);
	}

	/**
	 * <p>subDatasourceMapArray.</p>
	 *
	 * @param fieldName a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.MapArraySubDatasourceExpression} object.
	 */
	public static MapArraySubDatasourceExpression subDatasourceMapArray(String fieldName) {
		return new MapArraySubDatasourceExpression(fieldName);
	}

	/**
	 * <p>subDatasourceMapArray.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.MapArraySubDatasourceExpression} object.
	 */
	public static MapArraySubDatasourceExpression subDatasourceMapArray(DRIExpression<? extends Object[]> expression) {
		return new MapArraySubDatasourceExpression(expression);
	}

	// crosstab
	/**
	 * <p>orderBy.</p>
	 *
	 * @param measure a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.OrderByExpression} object.
	 */
	public static OrderByExpression orderBy(CrosstabMeasureBuilder<? extends Comparable<?>> measure) {
		return new OrderByExpression(measure);
	}

	/**
	 * <p>crosstabValue.</p>
	 *
	 * @param group a {@link net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.CrosstabValueExpression} object.
	 */
	public static <T> CrosstabValueExpression<T> crosstabValue(AbstractCrosstabGroupBuilder<?, ?, ?> group) {
		return new CrosstabValueExpression<T>(group);
	}

	/**
	 * <p>crosstabValue.</p>
	 *
	 * @param measure a {@link net.sf.dynamicreports.report.definition.DRICrosstabValue} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.CrosstabValueExpression} object.
	 */
	public static <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure) {
		return new CrosstabValueExpression<T>(measure);
	}

	/**
	 * <p>crosstabValue.</p>
	 *
	 * @param measure a {@link net.sf.dynamicreports.report.definition.DRICrosstabValue} object.
	 * @param group a {@link net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.CrosstabValueExpression} object.
	 */
	public static <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure, AbstractCrosstabGroupBuilder<?, ?, ?> group) {
		return new CrosstabValueExpression<T>(measure, group);
	}

	/**
	 * <p>crosstabValue.</p>
	 *
	 * @param measure a {@link net.sf.dynamicreports.report.definition.DRICrosstabValue} object.
	 * @param rowGroup a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder} object.
	 * @param columnGroup a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder} object.
	 * @param <T> a T object.
	 * @return a {@link net.sf.dynamicreports.report.builder.expression.CrosstabValueExpression} object.
	 */
	public static <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure, CrosstabRowGroupBuilder<?> rowGroup,
			CrosstabColumnGroupBuilder<?> columnGroup) {
		return new CrosstabValueExpression<T>(measure, rowGroup, columnGroup);
	}
}

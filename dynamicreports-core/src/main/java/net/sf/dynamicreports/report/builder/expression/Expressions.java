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

	public static PrintInFirstPageExpression printInFirstPage() {
		return printInFirstPage;
	}

	public static PrintNotInFirstPageExpression printNotInFirstPage() {
		return printNotInFirstPage;
	}

	public static PrintWhenGroupHasMoreThanOneRowExpression printWhenGroupHasMoreThanOneRow(String groupName) {
		return new PrintWhenGroupHasMoreThanOneRowExpression(groupName);
	}

	public static PrintWhenGroupHasMoreThanOneRowExpression printWhenGroupHasMoreThanOneRow(GroupBuilder<?> group) {
		Validate.notNull(group, "group must not be null");
		return printWhenGroupHasMoreThanOneRow(group.getGroup().getName());
	}

	public static ReportRowNumberExpression reportRowNumber() {
		return reportRowNumber;
	}

	public static PageRowNumberExpression pageRowNumber() {
		return pageRowNumber;
	}

	public static ColumnRowNumberExpression columnRowNumber() {
		return columnRowNumber;
	}

	public static PageNumberExpression pageNumber() {
		return pageNumber;
	}

	public static ColumnNumberExpression columnNumber() {
		return columnNumber;
	}

	public static GroupRowNumberExpression groupRowNumber(String groupName) {
		return new GroupRowNumberExpression(groupName);
	}

	public static GroupRowNumberExpression groupRowNumber(GroupBuilder<?> group) {
		Validate.notNull(group, "group must not be null");
		return groupRowNumber(group.getGroup().getName());
	}

	public static ValueExpression<Date> date(Date date) {
		return value(date, Date.class);
	}

	public static ValueExpression<Number> number(Number number) {
		return value(number, Number.class);
	}

	public static ValueExpression<Image> image(Image image) {
		return value(image, Image.class);
	}

	public static ValueExpression<InputStream> inputStream(InputStream inputStream) {
		return value(inputStream, InputStream.class);
	}

	public static ValueExpression<URL> url(URL url) {
		return value(url, URL.class);
	}

	public static <T> ValueExpression<T> value(T value) {
		return new ValueExpression<T>(value);
	}

	public static <T> ValueExpression<T> value(T value, Class<? super T> valueClass) {
		return new ValueExpression<T>(value, valueClass);
	}

	public static ValueExpression<String> text(String text) {
		return value(text, String.class);
	}

	public static DataSourceExpression dataSource(JRDataSource dataSource) {
		return new DataSourceExpression(dataSource);
	}

	public static MessageExpression message(String key) {
		if (key != null) {
			return new MessageExpression(key);
		}
		return null;
	}

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
	public static PropertyExpression property(String name, DRIExpression<String> valueExpression) {
		return new PropertyExpression(name, valueExpression);
	}

	public static PropertyExpression property(String name, String value) {
		return new PropertyExpression(name, text(value));
	}

	// parameter
	public static ParameterExpression parameter(String name, DRIExpression<?> valueExpression) {
		return new ParameterExpression(name, valueExpression);
	}

	public static ParameterExpression parameter(String name, Object value) {
		return new ParameterExpression(name, value(value));
	}

	public static PrintInOddRowExpression printInOddRow() {
		return printInOddRow;
	}

	public static PrintInEvenRowExpression printInEvenRow() {
		return printInEvenRow;
	}

	// subdatasource
	public static BeanCollectionSubDatasourceExpression subDatasourceBeanCollection(String fieldName) {
		return new BeanCollectionSubDatasourceExpression(fieldName);
	}

	public static BeanCollectionSubDatasourceExpression subDatasourceBeanCollection(DRIExpression<? extends Collection<?>> expression) {
		return new BeanCollectionSubDatasourceExpression(expression);
	}

	public static BeanArraySubDatasourceExpression subDatasourceBeanArray(String fieldName) {
		return new BeanArraySubDatasourceExpression(fieldName);
	}

	public static BeanArraySubDatasourceExpression subDatasourceBeanArray(DRIExpression<? extends Object[]> expression) {
		return new BeanArraySubDatasourceExpression(expression);
	}

	public static MapCollectionSubDatasourceExpression subDatasourceMapCollection(String fieldName) {
		return new MapCollectionSubDatasourceExpression(fieldName);
	}

	public static MapCollectionSubDatasourceExpression subDatasourceMapCollection(DRIExpression<? extends Collection<Map<String, ?>>> expression) {
		return new MapCollectionSubDatasourceExpression(expression);
	}

	public static MapArraySubDatasourceExpression subDatasourceMapArray(String fieldName) {
		return new MapArraySubDatasourceExpression(fieldName);
	}

	public static MapArraySubDatasourceExpression subDatasourceMapArray(DRIExpression<? extends Object[]> expression) {
		return new MapArraySubDatasourceExpression(expression);
	}

	// crosstab
	public static OrderByExpression orderBy(CrosstabMeasureBuilder<? extends Comparable<?>> measure) {
		return new OrderByExpression(measure);
	}

	public static <T> CrosstabValueExpression<T> crosstabValue(AbstractCrosstabGroupBuilder<?, ?, ?> group) {
		return new CrosstabValueExpression<T>(group);
	}

	public static <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure) {
		return new CrosstabValueExpression<T>(measure);
	}

	public static <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure, AbstractCrosstabGroupBuilder<?, ?, ?> group) {
		return new CrosstabValueExpression<T>(measure, group);
	}

	public static <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure, CrosstabRowGroupBuilder<?> rowGroup,
			CrosstabColumnGroupBuilder<?> columnGroup) {
		return new CrosstabValueExpression<T>(measure, rowGroup, columnGroup);
	}
}

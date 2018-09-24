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
package net.sf.dynamicreports.report.builder.expression;

import net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.builder.group.GroupBuilder;
import net.sf.dynamicreports.report.definition.DRICrosstabValue;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * A set of build in expressions.<br/> Expressions are used to define various calculations, conditions, text field content, specific report groups, etc.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ExpressionBuilders {

    /**
     * <p>printInFirstPage.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintInFirstPageExpression} object.
     */
    public PrintInFirstPageExpression printInFirstPage() {
        return Expressions.printInFirstPage();
    }

    /**
     * <p>printNotInFirstPage.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintNotInFirstPageExpression} object.
     */
    public PrintNotInFirstPageExpression printNotInFirstPage() {
        return Expressions.printNotInFirstPage();
    }

    /**
     * <p>printWhenGroupHasMoreThanOneRow.</p>
     *
     * @param groupName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintWhenGroupHasMoreThanOneRowExpression} object.
     */
    public PrintWhenGroupHasMoreThanOneRowExpression printWhenGroupHasMoreThanOneRow(String groupName) {
        return Expressions.printWhenGroupHasMoreThanOneRow(groupName);
    }

    /**
     * <p>printWhenGroupHasMoreThanOneRow.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.builder.group.GroupBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintWhenGroupHasMoreThanOneRowExpression} object.
     */
    public PrintWhenGroupHasMoreThanOneRowExpression printWhenGroupHasMoreThanOneRow(GroupBuilder<?> group) {
        return Expressions.printWhenGroupHasMoreThanOneRow(group);
    }

    /**
     * <p>reportRowNumber.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ReportRowNumberExpression} object.
     */
    public ReportRowNumberExpression reportRowNumber() {
        return Expressions.reportRowNumber();
    }

    /**
     * <p>pageRowNumber.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.expression.PageRowNumberExpression} object.
     */
    public PageRowNumberExpression pageRowNumber() {
        return Expressions.pageRowNumber();
    }

    /**
     * <p>columnRowNumber.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ColumnRowNumberExpression} object.
     */
    public ColumnRowNumberExpression columnRowNumber() {
        return Expressions.columnRowNumber();
    }

    /**
     * <p>pageNumber.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.expression.PageNumberExpression} object.
     */
    public PageNumberExpression pageNumber() {
        return Expressions.pageNumber();
    }

    /**
     * <p>columnNumber.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ColumnNumberExpression} object.
     */
    public ColumnNumberExpression columnNumber() {
        return Expressions.columnNumber();
    }

    /**
     * <p>groupRowNumber.</p>
     *
     * @param groupName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.GroupRowNumberExpression} object.
     */
    public GroupRowNumberExpression groupRowNumber(String groupName) {
        return Expressions.groupRowNumber(groupName);
    }

    /**
     * <p>groupRowNumber.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.builder.group.GroupBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.GroupRowNumberExpression} object.
     */
    public GroupRowNumberExpression groupRowNumber(GroupBuilder<?> group) {
        return Expressions.groupRowNumber(group);
    }

    /**
     * <p>date.</p>
     *
     * @param date a {@link java.util.Date} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
     */
    public ValueExpression<Date> date(Date date) {
        return Expressions.date(date);
    }

    /**
     * <p>number.</p>
     *
     * @param number a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
     */
    public ValueExpression<Number> number(Number number) {
        return Expressions.number(number);
    }

    /**
     * <p>image.</p>
     *
     * @param image a {@link java.awt.Image} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
     */
    public ValueExpression<Image> image(Image image) {
        return Expressions.image(image);
    }

    /**
     * <p>inputStream.</p>
     *
     * @param inputStream a {@link java.io.InputStream} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
     */
    public ValueExpression<InputStream> inputStream(InputStream inputStream) {
        return Expressions.inputStream(inputStream);
    }

    /**
     * <p>url.</p>
     *
     * @param url a {@link java.net.URL} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
     */
    public ValueExpression<URL> url(URL url) {
        return Expressions.url(url);
    }

    /**
     * <p>value.</p>
     *
     * @param value a T object.
     * @param <T>   a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
     */
    public <T> ValueExpression<T> value(T value) {
        return Expressions.value(value);
    }

    /**
     * <p>value.</p>
     *
     * @param value      a T object.
     * @param valueClass a {@link java.lang.Class} object.
     * @param <T>        a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
     */
    public <T> ValueExpression<T> value(T value, Class<? super T> valueClass) {
        return Expressions.value(value, valueClass);
    }

    /**
     * <p>text.</p>
     *
     * @param text a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ValueExpression} object.
     */
    public ValueExpression<String> text(String text) {
        return Expressions.text(text);
    }

    /**
     * <p>dataSource.</p>
     *
     * @param dataSource a {@link net.sf.jasperreports.engine.JRDataSource} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.DataSourceExpression} object.
     */
    public DataSourceExpression dataSource(JRDataSource dataSource) {
        return Expressions.dataSource(dataSource);
    }

    /**
     * <p>message.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.MessageExpression} object.
     */
    public MessageExpression message(String key) {
        return Expressions.message(key);
    }

    /**
     * <p>message.</p>
     *
     * @param key       a {@link java.lang.String} object.
     * @param arguments an array of {@link java.lang.Object} objects.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.MessageExpression} object.
     */
    public MessageExpression message(String key, Object[] arguments) {
        return Expressions.message(key, arguments);
    }

    // jasper

    /**
     * Creates a new jasper string expression, useful only for showing a static text.<br/> This method escapes the characters in a {@code String} using Java String rules.
     *
     * @param text text to be shown
     * @return the expression
     */
    public JasperExpression<String> jasperSyntaxText(String text) {
        return Expressions.jasperSyntaxText(text);
    }

    /**
     * Creates a new jasper expression.<br/> This expression allows declaring an expression in a Jasper native syntax. Knowledge of the jasper syntax is also required for proper use.
     *
     * @param expression the jasper expression
     * @param valueClass the expression class
     * @param <T>        a T object.
     * @return the expression
     */
    public <T> JasperExpression<T> jasperSyntax(String expression, Class<? super T> valueClass) {
        return Expressions.jasperSyntax(expression, valueClass);
    }

    /**
     * Creates a new jasper expression.<br/> This expression allows declaring an expression in a Jasper native syntax. Knowledge of the jasper syntax is also required for proper use.
     *
     * @param expression the jasper expression
     * @return the expression
     */
    @SuppressWarnings("rawtypes")
    public JasperExpression jasperSyntax(String expression) {
        return Expressions.jasperSyntax(expression);
    }

    // property

    /**
     * <p>property.</p>
     *
     * @param name            a {@link java.lang.String} object.
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRISimpleExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.PropertyExpression} object.
     */
    public PropertyExpression property(String name, DRISimpleExpression<String> valueExpression) {
        return Expressions.property(name, valueExpression);
    }

    /**
     * <p>property.</p>
     *
     * @param name  a {@link java.lang.String} object.
     * @param value a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.PropertyExpression} object.
     */
    public PropertyExpression property(String name, String value) {
        return Expressions.property(name, value);
    }

    // parameter

    /**
     * <p>parameter.</p>
     *
     * @param name            a {@link java.lang.String} object.
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRISimpleExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ParameterExpression} object.
     */
    public ParameterExpression parameter(String name, DRISimpleExpression<?> valueExpression) {
        return Expressions.parameter(name, valueExpression);
    }

    /**
     * <p>parameter.</p>
     *
     * @param name  a {@link java.lang.String} object.
     * @param value a {@link java.lang.Object} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.ParameterExpression} object.
     */
    public ParameterExpression parameter(String name, Object value) {
        return Expressions.parameter(name, value);
    }

    /**
     * <p>printInOddRow.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintInOddRowExpression} object.
     */
    public PrintInOddRowExpression printInOddRow() {
        return Expressions.printInOddRow();
    }

    /**
     * <p>printInEvenRow.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.expression.PrintInEvenRowExpression} object.
     */
    public PrintInEvenRowExpression printInEvenRow() {
        return Expressions.printInEvenRow();
    }

    // subdatasource

    /**
     * <p>subDatasourceBeanCollection.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.BeanCollectionSubDatasourceExpression} object.
     */
    public BeanCollectionSubDatasourceExpression subDatasourceBeanCollection(String fieldName) {
        return Expressions.subDatasourceBeanCollection(fieldName);
    }

    /**
     * <p>subDatasourceBeanCollection.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.BeanCollectionSubDatasourceExpression} object.
     */
    public BeanCollectionSubDatasourceExpression subDatasourceBeanCollection(DRIExpression<? extends Collection<?>> expression) {
        return Expressions.subDatasourceBeanCollection(expression);
    }

    /**
     * <p>subDatasourceBeanArray.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.BeanArraySubDatasourceExpression} object.
     */
    public BeanArraySubDatasourceExpression subDatasourceBeanArray(String fieldName) {
        return Expressions.subDatasourceBeanArray(fieldName);
    }

    /**
     * <p>subDatasourceBeanArray.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.BeanArraySubDatasourceExpression} object.
     */
    public BeanArraySubDatasourceExpression subDatasourceBeanArray(DRIExpression<? extends Object[]> expression) {
        return Expressions.subDatasourceBeanArray(expression);
    }

    /**
     * <p>subDatasourceMapCollection.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.MapCollectionSubDatasourceExpression} object.
     */
    public MapCollectionSubDatasourceExpression subDatasourceMapCollection(String fieldName) {
        return Expressions.subDatasourceMapCollection(fieldName);
    }

    /**
     * <p>subDatasourceMapCollection.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.MapCollectionSubDatasourceExpression} object.
     */
    public MapCollectionSubDatasourceExpression subDatasourceMapCollection(DRIExpression<? extends Collection<Map<String, ?>>> expression) {
        return Expressions.subDatasourceMapCollection(expression);
    }

    /**
     * <p>subDatasourceMapArray.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.MapArraySubDatasourceExpression} object.
     */
    public MapArraySubDatasourceExpression subDatasourceMapArray(String fieldName) {
        return Expressions.subDatasourceMapArray(fieldName);
    }

    /**
     * <p>subDatasourceMapArray.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.MapArraySubDatasourceExpression} object.
     */
    public MapArraySubDatasourceExpression subDatasourceMapArray(DRIExpression<? extends Object[]> expression) {
        return Expressions.subDatasourceMapArray(expression);
    }

    // crosstab

    /**
     * <p>orderBy.</p>
     *
     * @param measure a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.OrderByExpression} object.
     */
    public OrderByExpression orderBy(CrosstabMeasureBuilder<? extends Comparable<?>> measure) {
        return Expressions.orderBy(measure);
    }

    /**
     * <p>crosstabValue.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder} object.
     * @param <T>   a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.CrosstabValueExpression} object.
     */
    public <T> CrosstabValueExpression<T> crosstabValue(AbstractCrosstabGroupBuilder<?, ?, ?> group) {
        return Expressions.crosstabValue(group);
    }

    /**
     * <p>crosstabValue.</p>
     *
     * @param measure a {@link net.sf.dynamicreports.report.definition.DRICrosstabValue} object.
     * @param <T>     a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.CrosstabValueExpression} object.
     */
    public <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure) {
        return Expressions.crosstabValue(measure);
    }

    /**
     * <p>crosstabValue.</p>
     *
     * @param measure a {@link net.sf.dynamicreports.report.definition.DRICrosstabValue} object.
     * @param group   a {@link net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder} object.
     * @param <T>     a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.CrosstabValueExpression} object.
     */
    public <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure, AbstractCrosstabGroupBuilder<?, ?, ?> group) {
        return Expressions.crosstabValue(measure, group);
    }

    /**
     * <p>crosstabValue.</p>
     *
     * @param measure     a {@link net.sf.dynamicreports.report.definition.DRICrosstabValue} object.
     * @param rowGroup    a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder} object.
     * @param columnGroup a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder} object.
     * @param <T>         a T object.
     * @return a {@link net.sf.dynamicreports.report.builder.expression.CrosstabValueExpression} object.
     */
    public <T> CrosstabValueExpression<T> crosstabValue(DRICrosstabValue<T> measure, CrosstabRowGroupBuilder<?> rowGroup, CrosstabColumnGroupBuilder<?> columnGroup) {
        return Expressions.crosstabValue(measure, rowGroup, columnGroup);
    }
}

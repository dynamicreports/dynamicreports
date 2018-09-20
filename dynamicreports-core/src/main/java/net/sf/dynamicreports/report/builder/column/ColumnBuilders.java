/*
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
package net.sf.dynamicreports.report.builder.column;

import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * A set of methods of creating report columns.<br/>
 * It is used to display data in a multi-column layout.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ColumnBuilders {

    // text

    /**
     * Creates a new column.<br/>
     * It is used to show values from the data source.
     *
     * @param fieldName
     *          the name of the field
     * @param valueClass
     *          the field value class
     * @return a column builder
     * @param <T> a T object.
     */
    public <T> TextColumnBuilder<T> column(String fieldName, Class<T> valueClass) {
        return Columns.column(fieldName, valueClass);
    }

    /**
     * Creates a new column.<br/>
     * It is used to show values from the data source.
     *
     * @param title
     *          the column title
     * @param fieldName
     *          the name of the field
     * @param valueClass
     *          the field value class
     * @return a column builder
     * @param <T> a T object.
     */
    public <T> TextColumnBuilder<T> column(String title, String fieldName, Class<T> valueClass) {
        return Columns.column(title, fieldName, valueClass);
    }

    /**
     * Creates a new column.<br/>
     * It is used to show values from the data source.
     *
     * @param fieldName
     *          the name of the field
     * @param dataType
     *          the field data type
     * @return a column builder
     * @param <T> a T object.
     */
    public <T> TextColumnBuilder<T> column(String fieldName, DRIDataType<? super T, T> dataType) {
        return Columns.column(fieldName, dataType);
    }

    /**
     * Creates a new column.<br/>
     * It is used to show values from the data source.
     *
     * @param title
     *          the column title
     * @param fieldName
     *          the name of the field
     * @param dataType
     *          the field data type
     * @return a column builder
     * @param <T> a T object.
     */
    public <T> TextColumnBuilder<T> column(String title, String fieldName, DRIDataType<? super T, T> dataType) {
        return Columns.column(title, fieldName, dataType);
    }

    /**
     * Creates a new column.<br/>
     * It is used to show values from the data source.
     *
     * @param field
     *          the field definition
     * @return a column builder
     * @param <T> a T object.
     */
    public <T> TextColumnBuilder<T> column(FieldBuilder<T> field) {
        return Columns.column(field);
    }

    /**
     * Creates a new column.<br/>
     * It is used to show values from the data source.
     *
     * @param title
     *          the column title
     * @param field
     *          the field definition
     * @return a column builder
     * @param <T> a T object.
     */
    public <T> TextColumnBuilder<T> column(String title, FieldBuilder<T> field) {
        return Columns.column(title, field);
    }

    // expression

    /**
     * Creates a new expression column.<br/>
     * The column values are defined in an expression.
     *
     * @param expression
     *          the value expression
     * @return a column builder
     * @param <T> a T object.
     */
    public <T> TextColumnBuilder<T> column(DRIExpression<T> expression) {
        return Columns.column(expression);
    }

    /**
     * Creates a new expression column.<br/>
     * The column values are defined in an expression.
     *
     * @param title
     *          the column title
     * @param expression
     *          the value expression
     * @return a column builder
     * @param <T> a T object.
     */
    public <T> TextColumnBuilder<T> column(String title, DRIExpression<T> expression) {
        return Columns.column(title, expression);
    }

    // percentage

    /**
     * Creates a new percentage column.<br/>
     * It calculates percentage values from column values.
     *
     * @param column
     *          the column definition
     * @return a column builder
     */
    public PercentageColumnBuilder percentageColumn(ValueColumnBuilder<?, ? extends Number> column) {
        return Columns.percentageColumn(column);
    }

    /**
     * Creates a new percentage column.<br/>
     * It calculates percentage values from column values.
     *
     * @param title
     *          the column title
     * @param column
     *          the column definition
     * @return a column builder
     */
    public PercentageColumnBuilder percentageColumn(String title, ValueColumnBuilder<?, ? extends Number> column) {
        return Columns.percentageColumn(title, column);
    }

    /**
     * Creates a new percentage column.<br/>
     * It calculates percentage values from field values.
     *
     * @param fieldName
     *          the name of the field
     * @param valueClass
     *          the field value class
     * @return a column builder
     */
    public PercentageColumnBuilder percentageColumn(String fieldName, Class<? extends Number> valueClass) {
        return Columns.percentageColumn(fieldName, valueClass);
    }

    /**
     * Creates a new percentage column.<br/>
     * It calculates percentage values from field values.
     *
     * @param title
     *          the column title
     * @param fieldName
     *          the name of the field
     * @param valueClass
     *          the field value class
     * @return a column builder
     */
    public PercentageColumnBuilder percentageColumn(String title, String fieldName, Class<? extends Number> valueClass) {
        return Columns.percentageColumn(title, fieldName, valueClass);
    }

    /**
     * Creates a new percentage column.<br/>
     * It calculates percentage values from field values.
     *
     * @param field
     *          the field definition
     * @return a column builder
     */
    public PercentageColumnBuilder percentageColumn(FieldBuilder<? extends Number> field) {
        return Columns.percentageColumn(field);
    }

    /**
     * Creates a new percentage column.<br/>
     * It calculates percentage values from field values.
     *
     * @param title
     *          the column title
     * @param field
     *          the field definition
     * @return a column builder
     */
    public PercentageColumnBuilder percentageColumn(String title, FieldBuilder<? extends Number> field) {
        return Columns.percentageColumn(title, field);
    }

	/*public PercentageColumnBuilder percentageColumn(DRISimpleExpression<? extends Number> expression) {
		return Columns.percentageColumn(expression);
	}
	
	public PercentageColumnBuilder percentageColumn(String title, DRISimpleExpression<? extends Number> expression) {
		return Columns.percentageColumn(title, expression);
	}*/

    // column row number

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers, the row number is reset on each new column.
     *
     * @return a column builder
     */
    public TextColumnBuilder<Integer> columnRowNumberColumn() {
        return Columns.columnRowNumberColumn();
    }

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers, the row number is reset on each new column.
     *
     * @param title
     *          the column title
     * @return a column builder
     */
    public TextColumnBuilder<Integer> columnRowNumberColumn(String title) {
        return Columns.columnRowNumberColumn(title);
    }

    // page row number

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers, the row number is reset on each new page.
     *
     * @return a column builder
     */
    public TextColumnBuilder<Integer> pageRowNumberColumn() {
        return Columns.pageRowNumberColumn();
    }

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers, the row number is reset on each new page.
     *
     * @param title
     *          the column title
     * @return a column builder
     */
    public TextColumnBuilder<Integer> pageRowNumberColumn(String title) {
        return Columns.pageRowNumberColumn(title);
    }

    // report row number

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers.
     *
     * @return a column builder
     */
    public TextColumnBuilder<Integer> reportRowNumberColumn() {
        return Columns.reportRowNumberColumn();
    }

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers.
     *
     * @param title
     *          the column title
     * @return a column builder
     */
    public TextColumnBuilder<Integer> reportRowNumberColumn(String title) {
        return Columns.reportRowNumberColumn(title);
    }

    // component

    /**
     * Creates a new component column.<br/>
     * It is used to display custom components (e.g. images or complex content) in columns.
     *
     * @param component
     *          the component definition
     * @return a column builder
     */
    public ComponentColumnBuilder componentColumn(ComponentBuilder<?, ?> component) {
        return Columns.componentColumn(component);
    }

    /**
     * Creates a new component column.<br/>
     * It is used to display custom components (e.g. images or complex content) in columns.
     *
     * @param title
     *          the column title
     * @param component
     *          the component definition
     * @return a column builder
     */
    public ComponentColumnBuilder componentColumn(String title, ComponentBuilder<?, ?> component) {
        return Columns.componentColumn(title, component);
    }

    // boolean

    /**
     * Creates a new boolean column.<br/>
     * It shows a boolean value either as a text or as an image.
     *
     * @param fieldName
     *          the name of the field
     * @return a column builder
     */
    public BooleanColumnBuilder booleanColumn(String fieldName) {
        return Columns.booleanColumn(fieldName);
    }

    /**
     * Creates a new boolean column.<br/>
     * It shows a boolean value either as a text or as an image.
     *
     * @param title
     *          the column title
     * @param fieldName
     *          the name of the field
     * @return a column builder
     */
    public BooleanColumnBuilder booleanColumn(String title, String fieldName) {
        return Columns.booleanColumn(title, fieldName);
    }

    /**
     * Creates a new boolean column.<br/>
     * It shows a boolean value either as a text or as an image.
     *
     * @param field
     *          the field definition
     * @return a column builder
     */
    public BooleanColumnBuilder booleanColumn(FieldBuilder<Boolean> field) {
        return Columns.booleanColumn(field);
    }

    /**
     * Creates a new boolean column.<br/>
     * It shows a boolean value either as a text or as an image.
     *
     * @param title
     *          the column title
     * @param field
     *          the field definition
     * @return a column builder
     */
    public BooleanColumnBuilder booleanColumn(String title, FieldBuilder<Boolean> field) {
        return Columns.booleanColumn(title, field);
    }

    /**
     * Creates a new boolean column.<br/>
     * It shows a boolean value either as a text or as an image.
     *
     * @param expression
     *          the boolean value expression
     * @return a column builder
     */
    public BooleanColumnBuilder booleanColumn(DRIExpression<Boolean> expression) {
        return Columns.booleanColumn(expression);
    }

    /**
     * Creates a new boolean column.<br/>
     * It shows a boolean value either as a text or as an image.
     *
     * @param title
     *          the column title
     * @param expression
     *          the boolean value expression
     * @return a column builder
     */
    public BooleanColumnBuilder booleanColumn(String title, DRIExpression<Boolean> expression) {
        return Columns.booleanColumn(title, expression);
    }

    // empty column

    /**
     * Creates a new empty column.<br/>
     *
     * @return a column builder
     */
    public TextColumnBuilder<String> emptyColumn() {
        return Columns.emptyColumn();
    }

    /**
     * Creates a new empty column.<br/>
     *
     * @param showTitle
     *          show column title
     * @param showDetailRows
     *          show detail rows
     * @return a column builder
     */
    public TextColumnBuilder<String> emptyColumn(boolean showTitle, boolean showDetailRows) {
        return Columns.emptyColumn(showTitle, showDetailRows);
    }
}

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

package net.sf.dynamicreports.report.builder.column;

import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.definition.DRIField;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * A set of methods of creating report columns.<br/>
 * It is used to display data in a multi-column layout.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class Columns {

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
    public static <T> TextColumnBuilder<T> column(String fieldName, Class<T> valueClass) {
        return (TextColumnBuilder<T>) column(DynamicReports.field(fieldName, valueClass));
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
    public static <T> TextColumnBuilder<T> column(String title, String fieldName, Class<T> valueClass) {
        return (TextColumnBuilder<T>) column(title, DynamicReports.field(fieldName, valueClass));
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
    public static <T> TextColumnBuilder<T> column(String fieldName, DRIDataType<? super T, T> dataType) {
        Validate.notNull(dataType, "dataType must not be null");
        TextColumnBuilder<T> textColumnBuilder = new TextColumnBuilder<T>(DynamicReports.<T>field(fieldName, dataType.getValueClass()));
        textColumnBuilder.setDataType(dataType);
        return textColumnBuilder;
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
    public static <T> TextColumnBuilder<T> column(String title, String fieldName, DRIDataType<? super T, T> dataType) {
        TextColumnBuilder<T> textColumnBuilder = column(fieldName, dataType);
        textColumnBuilder.setTitle(title);
        return textColumnBuilder;
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
    public static <T> TextColumnBuilder<T> column(FieldBuilder<T> field) {
        TextColumnBuilder<T> textColumnBuilder = new TextColumnBuilder<T>(field);
        if (field.getField()
                 .getDataType() != null) {
            textColumnBuilder.setDataType(field.getField()
                                               .getDataType());
        }
        return textColumnBuilder;
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
    public static <T> TextColumnBuilder<T> column(String title, FieldBuilder<T> field) {
        return column(field).setTitle(title);
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
    public static <T> TextColumnBuilder<T> column(DRIExpression<T> expression) {
        TextColumnBuilder<T> textColumnBuilder = new TextColumnBuilder<T>(expression);
        if (expression instanceof DRIField && ((DRIField<T>) expression).getDataType() != null) {
            textColumnBuilder.setDataType(((DRIField<T>) expression).getDataType());
        }
        return textColumnBuilder;
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
    public static <T> TextColumnBuilder<T> column(String title, DRIExpression<T> expression) {
        return column(expression).setTitle(title);
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
    public static PercentageColumnBuilder percentageColumn(ValueColumnBuilder<?, ? extends Number> column) {
        return new PercentageColumnBuilder(column);
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
    public static PercentageColumnBuilder percentageColumn(String title, ValueColumnBuilder<?, ? extends Number> column) {
        return percentageColumn(column).setTitle(title);
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
    public static PercentageColumnBuilder percentageColumn(String fieldName, Class<? extends Number> valueClass) {
        return percentageColumn(DynamicReports.<Number>field(fieldName, valueClass));
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
    public static PercentageColumnBuilder percentageColumn(String title, String fieldName, Class<? extends Number> valueClass) {
        return percentageColumn(fieldName, valueClass).setTitle(title);
    }

    /**
     * Creates a new percentage column.<br/>
     * It calculates percentage values from field values.
     *
     * @param field
     *          the field definition
     * @return a column builder
     */
    public static PercentageColumnBuilder percentageColumn(FieldBuilder<? extends Number> field) {
        return new PercentageColumnBuilder(field);
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
    public static PercentageColumnBuilder percentageColumn(String title, FieldBuilder<? extends Number> field) {
        return percentageColumn(field).setTitle(title);
    }

	/*public static PercentageColumnBuilder percentageColumn(DRISimpleExpression<? extends Number> expression) {
		return new PercentageColumnBuilder(expression);
	}
	
	public static PercentageColumnBuilder percentageColumn(String title, DRISimpleExpression<? extends Number> expression) {
		return percentageColumn(expression).setTitle(title);
	}	*/

    // column row number

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers, the row number is reset on each new column.
     *
     * @return a column builder
     */
    public static TextColumnBuilder<Integer> columnRowNumberColumn() {
        return column(Expressions.columnRowNumber());
    }

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers, the row number is reset on each new column.
     *
     * @param title
     *          the column title
     * @return a column builder
     */
    public static TextColumnBuilder<Integer> columnRowNumberColumn(String title) {
        return columnRowNumberColumn().setTitle(title);
    }

    // page row number

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers, the row number is reset on each new page.
     *
     * @return a column builder
     */
    public static TextColumnBuilder<Integer> pageRowNumberColumn() {
        return column(Expressions.pageRowNumber());
    }

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers, the row number is reset on each new page.
     *
     * @param title
     *          the column title
     * @return a column builder
     */
    public static TextColumnBuilder<Integer> pageRowNumberColumn(String title) {
        return pageRowNumberColumn().setTitle(title);
    }

    // report row number

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers.
     *
     * @return a column builder
     */
    public static TextColumnBuilder<Integer> reportRowNumberColumn() {
        return column(Expressions.reportRowNumber());
    }

    /**
     * Creates a new row number column.<br/>
     * It displays row numbers.
     *
     * @param title
     *          the column title
     * @return a column builder
     */
    public static TextColumnBuilder<Integer> reportRowNumberColumn(String title) {
        return reportRowNumberColumn().setTitle(title);
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
    public static ComponentColumnBuilder componentColumn(ComponentBuilder<?, ?> component) {
        Validate.notNull(component, "component must not be null");
        return new ComponentColumnBuilder(component);
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
    public static ComponentColumnBuilder componentColumn(String title, ComponentBuilder<?, ?> component) {
        return componentColumn(component).setTitle(title);
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
    public static BooleanColumnBuilder booleanColumn(String fieldName) {
        return booleanColumn(DynamicReports.<Boolean>field(fieldName, Boolean.class));
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
    public static BooleanColumnBuilder booleanColumn(String title, String fieldName) {
        return booleanColumn(title, DynamicReports.<Boolean>field(fieldName, Boolean.class));
    }

    /**
     * Creates a new boolean column.<br/>
     * It shows a boolean value either as a text or as an image.
     *
     * @param field
     *          the field definition
     * @return a column builder
     */
    public static BooleanColumnBuilder booleanColumn(FieldBuilder<Boolean> field) {
        return new BooleanColumnBuilder(field);
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
    public static BooleanColumnBuilder booleanColumn(String title, FieldBuilder<Boolean> field) {
        return booleanColumn(field).setTitle(title);
    }

    /**
     * Creates a new boolean column.<br/>
     * It shows a boolean value either as a text or as an image.
     *
     * @param expression
     *          the boolean value expression
     * @return a column builder
     */
    public static BooleanColumnBuilder booleanColumn(DRIExpression<Boolean> expression) {
        return new BooleanColumnBuilder(expression);
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
    public static BooleanColumnBuilder booleanColumn(String title, DRIExpression<Boolean> expression) {
        return booleanColumn(expression).setTitle(title);
    }

    // empty column

    /**
     * Creates a new empty column.<br/>
     *
     * @return a column builder
     */
    public static TextColumnBuilder<String> emptyColumn() {
        return emptyColumn(false, false);
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
    public static TextColumnBuilder<String> emptyColumn(boolean showTitle, boolean showDetailRows) {
        TextColumnBuilder<String> column = column(Expressions.text(null));
        if (showTitle) {
            column.setTitle("");
        }
        if (!showDetailRows) {
            column.setPrintWhenExpression(Expressions.value(false));
        }
        return column;
    }
}

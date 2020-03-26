/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
import net.sf.dynamicreports.report.builder.expression.AddExpression;
import net.sf.dynamicreports.report.builder.expression.DivideExpression;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.expression.MultiplyExpression;
import net.sf.dynamicreports.report.builder.expression.SubtractExpression;
import net.sf.dynamicreports.report.builder.expression.ValueExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRIValue;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * It is used to show values from the data source.
 *
 * @author Ricardo Mariaca
 * 
 */
public class TextColumnBuilder<T> extends ValueColumnBuilder<TextColumnBuilder<T>, T> implements DRIValue<T> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for TextColumnBuilder.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     */
    protected TextColumnBuilder(FieldBuilder<T> field) {
        Validate.notNull(field, "field must not be null");
        setValueExpression(field.getField());
    }

    /**
     * <p>Constructor for TextColumnBuilder.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    protected TextColumnBuilder(DRIExpression<T> valueExpression) {
        setValueExpression(valueExpression);
    }

    // add

    /**
     * Creates a new column by adding a column value to this column instance.
     *
     * @param column the column builder
     * @return a column builder
     */
    @SuppressWarnings("unchecked")
    public TextColumnBuilder<BigDecimal> add(TextColumnBuilder<? extends Number> column) {
        Validate.isTrue(Number.class.isAssignableFrom(getObject().getValueClass()), "Only Number column can multiply");
        DRIExpression<? extends Number> value1Expression = (DRIExpression<? extends Number>) this.getComponent().getValueExpression();
        DRIExpression<? extends Number> value2Expression = column.getComponent().getValueExpression();
        AddExpression exp = new AddExpression(value1Expression, value2Expression);
        return new TextColumnBuilder<BigDecimal>(exp).setDataType(type.bigDecimalType());
    }

    /**
     * Creates a new column by adding a value to this column instance.
     *
     * @param number the value
     * @return a column builder
     */
    @SuppressWarnings("unchecked")
    public TextColumnBuilder<BigDecimal> add(Number number) {
        Validate.isTrue(Number.class.isAssignableFrom(getObject().getValueClass()), "Only Number column can multiply");
        DRIExpression<? extends Number> value1Expression = (DRIExpression<? extends Number>) this.getComponent().getValueExpression();
        ValueExpression<Number> value2Expression = Expressions.number(number);
        AddExpression exp = new AddExpression(value1Expression, value2Expression);
        return new TextColumnBuilder<BigDecimal>(exp).setDataType(type.bigDecimalType());
    }

    // subtract

    /**
     * Creates a new column by subtracting a column value from this column instance.
     *
     * @param column the column builder
     * @return a column builder
     */
    @SuppressWarnings("unchecked")
    public TextColumnBuilder<BigDecimal> subtract(TextColumnBuilder<? extends Number> column) {
        Validate.isTrue(Number.class.isAssignableFrom(getObject().getValueClass()), "Only Number column can subtract");
        DRIExpression<? extends Number> value1Expression = (DRIExpression<? extends Number>) this.getComponent().getValueExpression();
        DRIExpression<? extends Number> value2Expression = column.getComponent().getValueExpression();
        SubtractExpression exp = new SubtractExpression(value1Expression, value2Expression);
        return new TextColumnBuilder<BigDecimal>(exp).setDataType(type.bigDecimalType());
    }

    /**
     * Creates a new column by subtracting a value from this column instance.
     *
     * @param number the value
     * @return a column builder
     */
    @SuppressWarnings("unchecked")
    public TextColumnBuilder<BigDecimal> subtract(Number number) {
        Validate.isTrue(Number.class.isAssignableFrom(getObject().getValueClass()), "Only Number column can subtract");
        DRIExpression<? extends Number> value1Expression = (DRIExpression<? extends Number>) this.getComponent().getValueExpression();
        ValueExpression<Number> value2Expression = Expressions.number(number);
        SubtractExpression exp = new SubtractExpression(value1Expression, value2Expression);
        return new TextColumnBuilder<BigDecimal>(exp).setDataType(type.bigDecimalType());
    }

    // multiply

    /**
     * Creates a new column by multiplying this column instance with a column value.
     *
     * @param column the column builder
     * @return a column builder
     */
    @SuppressWarnings("unchecked")
    public TextColumnBuilder<BigDecimal> multiply(TextColumnBuilder<? extends Number> column) {
        Validate.isTrue(Number.class.isAssignableFrom(getObject().getValueClass()), "Only Number column can multiply");
        DRIExpression<? extends Number> value1Expression = (DRIExpression<? extends Number>) this.getComponent().getValueExpression();
        DRIExpression<? extends Number> value2Expression = column.getComponent().getValueExpression();
        MultiplyExpression exp = new MultiplyExpression(value1Expression, value2Expression);
        return new TextColumnBuilder<BigDecimal>(exp).setDataType(type.bigDecimalType());
    }

    /**
     * Creates a new column by multiplying this column instance with a value.
     *
     * @param number the value
     * @return a column builder
     */
    @SuppressWarnings("unchecked")
    public TextColumnBuilder<BigDecimal> multiply(Number number) {
        Validate.isTrue(Number.class.isAssignableFrom(getObject().getValueClass()), "Only Number column can multiply");
        DRIExpression<? extends Number> value1Expression = (DRIExpression<? extends Number>) this.getComponent().getValueExpression();
        ValueExpression<Number> value2Expression = Expressions.number(number);
        MultiplyExpression exp = new MultiplyExpression(value1Expression, value2Expression);
        return new TextColumnBuilder<BigDecimal>(exp).setDataType(type.bigDecimalType());
    }

    // divide

    /**
     * Creates a new column by dividing this column instance with a column value.
     *
     * @param column the column builder
     * @param scale  a int.
     * @return a column builder
     */
    @SuppressWarnings("unchecked")
    public TextColumnBuilder<BigDecimal> divide(int scale, TextColumnBuilder<? extends Number> column) {
        Validate.isTrue(Number.class.isAssignableFrom(getObject().getValueClass()), "Only Number column can divide");
        DRIExpression<? extends Number> value1Expression = (DRIExpression<? extends Number>) this.getComponent().getValueExpression();
        DRIExpression<? extends Number> value2Expression = column.getComponent().getValueExpression();
        DivideExpression exp = new DivideExpression(scale, value1Expression, value2Expression);
        return new TextColumnBuilder<BigDecimal>(exp).setDataType(type.bigDecimalType());
    }

    /**
     * Creates a new column by dividing this column instance with a value.
     *
     * @param number the value
     * @param scale  a int.
     * @return a column builder
     */
    @SuppressWarnings("unchecked")
    public TextColumnBuilder<BigDecimal> divide(int scale, Number number) {
        Validate.isTrue(Number.class.isAssignableFrom(getObject().getValueClass()), "Only Number column can divide");
        DRIExpression<? extends Number> value1Expression = (DRIExpression<? extends Number>) this.getComponent().getValueExpression();
        ValueExpression<Number> value2Expression = Expressions.number(number);
        DivideExpression exp = new DivideExpression(scale, value1Expression, value2Expression);
        return new TextColumnBuilder<BigDecimal>(exp).setDataType(type.bigDecimalType());
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return getObject().getName();
    }
}

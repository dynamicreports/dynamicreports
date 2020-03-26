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

import net.sf.dynamicreports.report.base.column.DRColumn;
import net.sf.dynamicreports.report.base.component.DRComponent;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.TextAdjust;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;

/**
 * <p>Abstract ColumnBuilder class.</p>
 *
 * @author Ricardo Mariaca, Jan Moxter
 * 
 */
@SuppressWarnings("unchecked")
public abstract class ColumnBuilder<T extends ColumnBuilder<T, U>, U extends DRColumn<?>> extends AbstractBuilder<T, U> implements ColumnGridComponentBuilder {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for ColumnBuilder.</p>
     *
     * @param column a U object.
     */
    protected ColumnBuilder(final U column) {
        super(column);
    }

    /**
     * Sets the column title.
     *
     * @param titleExpression the title expression
     * @return a column builder
     */
    public T setTitle(final DRIExpression<?> titleExpression) {
        getObject().setTitleExpression(titleExpression);
        return (T) this;
    }

    /**
     * Sets the column title.
     *
     * @param title the title
     * @return a column builder
     */
    public T setTitle(final String title) {
        getObject().setTitleExpression(Expressions.text(title));
        return (T) this;
    }

    /**
     * Sets the column title style.
     *
     * @param titleStyle the title style
     * @return a column builder
     */
    public T setTitleStyle(final ReportStyleBuilder titleStyle) {
        if (titleStyle != null) {
            getObject().setTitleStyle(titleStyle.getStyle());
        } else {
            getObject().setTitleStyle(null);
        }
        return (T) this;
    }

    /**
     * Sets the column value style.
     *
     * @param style the value style
     * @return a column builder
     */
    public T setStyle(final ReportStyleBuilder style) {
        if (style != null) {
            getComponent().setStyle(style.getStyle());
        } else {
            getComponent().setStyle(null);
        }
        return (T) this;
    }

    /**
     * Sets the print when expression. The expression must be a type of Boolean and it decides whether or not a column value will be printed.
     *
     * @param printWhenExpression the print expression
     * @return a column builder
     */
    public T setPrintWhenExpression(final DRIExpression<Boolean> printWhenExpression) {
        getComponent().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * This method is used to define the preferred height of a column title. The height is set to the <code>rows</code> multiplied by height of the font
     *
     * @param rows the number of preferred rows >= 0
     * @return a column builder
     * @throws java.lang.IllegalArgumentException if <code>rows</code> is < 0
     */
    public T setTitleRows(final Integer rows) {
        getObject().setTitleRows(rows);
        return (T) this;
    }

    /**
     * This method is used to define the fixed height of a column title. The height is set to the <code>rows</code> multiplied by height of the font
     *
     * @param rows the number of fixed rows >= 0
     * @return a column builder
     * @throws java.lang.IllegalArgumentException if <code>rows</code> is < 0
     */
    public T setTitleFixedRows(final Integer rows) {
        getObject().setTitleRows(rows);
        getObject().setTitleHeightType(ComponentDimensionType.FIXED);
        return (T) this;
    }

    /**
     * This method is used to define the minimum height of a column title. The height is set to the <code>rows</code> multiplied by height of the font
     *
     * @param rows the number of minimum rows >= 0
     * @return a column builder
     * @throws java.lang.IllegalArgumentException if <code>rows</code> is < 0
     */
    public T setTitleMinRows(final Integer rows) {
        getObject().setTitleRows(rows);
        getObject().setTitleHeightType(ComponentDimensionType.EXPAND);
        return (T) this;
    }

    /**
     * Sets the preferred height of a column title.
     *
     * @param height the column title preferred height >= 0
     * @return a column builder
     * @throws java.lang.IllegalArgumentException if <code>height</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public T setTitleHeight(final Integer height) {
        getObject().setTitleHeight(height);
        return (T) this;
    }

    /**
     * Sets the fixed height of a column title.
     *
     * @param height the column title fixed height >= 0
     * @return a column builder
     * @throws java.lang.IllegalArgumentException if <code>height</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public T setTitleFixedHeight(final Integer height) {
        getObject().setTitleHeight(height);
        getObject().setTitleHeightType(ComponentDimensionType.FIXED);
        return (T) this;
    }

    /**
     * Sets the minimum height of a column title.
     *
     * @param height the column title minimum height >= 0
     * @return a column builder
     * @throws java.lang.IllegalArgumentException if <code>height</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public T setTitleMinHeight(final Integer height) {
        getObject().setTitleHeight(height);
        getObject().setTitleHeightType(ComponentDimensionType.EXPAND);
        return (T) this;
    }

    /**
     * <p>setTitleStretchWithOverflow.</p>
     *
     * @param stretchWithOverflow a {@link java.lang.Boolean} object.
     * @return a T object.
     * @deprecated replaced by {@link #setTitleTextAdjust(TextAdjust)}
     */
    @Deprecated
    public T setTitleStretchWithOverflow(final Boolean stretchWithOverflow) {
        getObject().setTitleStretchWithOverflow(stretchWithOverflow);
        return (T) this;
    }

    /**
     * <p>setTitleTextAdjust.</p>
     *
     * @param textAdjust a {@link net.sf.dynamicreports.report.constant.TextAdjust} object.
     * @return a T object.
     */
    public T setTitleTextAdjust(final TextAdjust textAdjust) {
        getObject().setTitleTextAdjust(textAdjust);
        return (T) this;
    }

    /**
     * Adds a jasper property to the column title.
     *
     * @param propertyExpression the property expression
     * @return a column builder
     */
    public T addTitleProperty(final DRIPropertyExpression propertyExpression) {
        getObject().addTitlePropertyExpression(propertyExpression);
        return (T) this;
    }

    /**
     * Adds a jasper property to the column title.
     *
     * @param name            the property name
     * @param valueExpression the property value expression
     * @return a column builder
     */
    public T addTitleProperty(final String name, final DRIExpression<String> valueExpression) {
        getObject().addTitlePropertyExpression(Expressions.property(name, valueExpression));
        return (T) this;
    }

    /**
     * Adds a jasper property to the column title.
     *
     * @param name  the property name
     * @param value the property value
     * @return a column builder
     */
    public T addTitleProperty(final String name, final String value) {
        getObject().addTitlePropertyExpression(Expressions.property(name, value));
        return (T) this;
    }

    /**
     * <p>getComponent.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    protected DRComponent getComponent() {
        return (DRComponent) getObject().getComponent();
    }

    /**
     * <p>getColumn.</p>
     *
     * @return a U object.
     */
    public U getColumn() {
        return build();
    }
}

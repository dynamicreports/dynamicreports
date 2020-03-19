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
package net.sf.dynamicreports.report.builder.grid;

import net.sf.dynamicreports.report.base.grid.DRColumnTitleGroup;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>ColumnTitleGroupBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class ColumnTitleGroupBuilder extends AbstractBuilder<ColumnTitleGroupBuilder, DRColumnTitleGroup> implements ColumnGridComponentBuilder {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for ColumnTitleGroupBuilder.</p>
     */
    protected ColumnTitleGroupBuilder() {
        super(new DRColumnTitleGroup());
    }

    /**
     * <p>add.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     */
    public ColumnTitleGroupBuilder add(ColumnGridComponentBuilder... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ColumnGridComponentBuilder component : components) {
            getObject().addComponent(component.build());
        }
        return this;
    }

    /**
     * <p>setTitle.</p>
     *
     * @param titleExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     */
    public ColumnTitleGroupBuilder setTitle(DRIExpression<?> titleExpression) {
        getObject().setTitleExpression(titleExpression);
        return this;
    }

    /**
     * <p>setTitle.</p>
     *
     * @param title a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     */
    public ColumnTitleGroupBuilder setTitle(String title) {
        getObject().setTitleExpression(Expressions.text(title));
        return this;
    }

    /**
     * <p>setTitleStyle.</p>
     *
     * @param titleStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     */
    public ColumnTitleGroupBuilder setTitleStyle(ReportStyleBuilder titleStyle) {
        if (titleStyle != null) {
            getObject().setTitleStyle(titleStyle.getStyle());
        } else {
            getObject().setTitleStyle(null);
        }
        return this;
    }

    /**
     * This method is used to define the preferred width of a column title. The width is set to the <code>columns</code> multiplied by width of the font
     *
     * @param columns the number of preferred columns >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>columns</code> is < 0
     */
    public ColumnTitleGroupBuilder setTitleColumns(Integer columns) {
        getObject().setTitleColumns(columns);
        return this;
    }

    /**
     * This method is used to define the fixed width of a column title. The width is set to the <code>columns</code> multiplied by width of the font
     *
     * @param columns the number of fixed columns >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>columns</code> is < 0
     */
    public ColumnTitleGroupBuilder setTitleFixedColumns(Integer columns) {
        getObject().setTitleColumns(columns);
        getObject().setTitleWidthType(ComponentDimensionType.FIXED);
        return this;
    }

    /**
     * This method is used to define the minimum width of a column title. The width is set to the <code>columns</code> multiplied by width of the font
     *
     * @param columns the number of minimum columns >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>columns</code> is < 0
     */
    public ColumnTitleGroupBuilder setTitleMinColumns(Integer columns) {
        getObject().setTitleColumns(columns);
        getObject().setTitleWidthType(ComponentDimensionType.EXPAND);
        return this;
    }

    /**
     * Sets the preferred width of a column title.
     *
     * @param width the column title preferred width >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>width</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public ColumnTitleGroupBuilder setTitleWidth(Integer width) {
        getObject().setTitleWidth(width);
        return this;
    }

    /**
     * Sets the fixed width of a column title.
     *
     * @param width the column title fixed width >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>width</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public ColumnTitleGroupBuilder setTitleFixedWidth(Integer width) {
        getObject().setTitleWidth(width);
        getObject().setTitleWidthType(ComponentDimensionType.FIXED);
        return this;
    }

    /**
     * Sets the minimum width of a column title.
     *
     * @param width the column title minimum width >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>width</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public ColumnTitleGroupBuilder setTitleMinWidth(Integer width) {
        getObject().setTitleWidth(width);
        getObject().setTitleWidthType(ComponentDimensionType.EXPAND);
        return this;
    }

    /**
     * This method is used to define the preferred height of a column title. The height is set to the <code>rows</code> multiplied by height of the font
     *
     * @param rows the number of preferred rows >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>rows</code> is < 0
     */
    public ColumnTitleGroupBuilder setTitleRows(Integer rows) {
        getObject().setTitleRows(rows);
        return this;
    }

    /**
     * This method is used to define the fixed height of a column title. The height is set to the <code>rows</code> multiplied by height of the font
     *
     * @param rows the number of fixed rows >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>rows</code> is < 0
     */
    public ColumnTitleGroupBuilder setTitleFixedRows(Integer rows) {
        getObject().setTitleRows(rows);
        getObject().setTitleHeightType(ComponentDimensionType.FIXED);
        return this;
    }

    /**
     * This method is used to define the minimum height of a column title. The height is set to the <code>rows</code> multiplied by height of the font
     *
     * @param rows the number of minimum rows >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>rows</code> is < 0
     */
    public ColumnTitleGroupBuilder setTitleMinRows(Integer rows) {
        getObject().setTitleRows(rows);
        getObject().setTitleHeightType(ComponentDimensionType.EXPAND);
        return this;
    }

    /**
     * Sets the preferred height of a column title.
     *
     * @param height the column title preferred height >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>height</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public ColumnTitleGroupBuilder setTitleHeight(Integer height) {
        getObject().setTitleHeight(height);
        return this;
    }

    /**
     * Sets the fixed height of a column title.
     *
     * @param height the column title fixed height >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>height</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public ColumnTitleGroupBuilder setTitleFixedHeight(Integer height) {
        getObject().setTitleHeight(height);
        getObject().setTitleHeightType(ComponentDimensionType.FIXED);
        return this;
    }

    /**
     * Sets the minimum height of a column title.
     *
     * @param height the column title minimum height >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>height</code> is < 0
     * @see net.sf.dynamicreports.report.builder.Units
     */
    public ColumnTitleGroupBuilder setTitleMinHeight(Integer height) {
        getObject().setTitleHeight(height);
        getObject().setTitleHeightType(ComponentDimensionType.EXPAND);
        return this;
    }

    /**
     * <p>setTitleStretchWithOverflow.</p>
     *
     * @param stretchWithOverflow a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     */
    public ColumnTitleGroupBuilder setTitleStretchWithOverflow(Boolean stretchWithOverflow) {
        getObject().setTitleStretchWithOverflow(stretchWithOverflow);
        return this;
    }

    /**
     * Adds a jasper property to the column title group.
     *
     * @param propertyExpression the property expression
     * @return a column title group builder
     */
    public ColumnTitleGroupBuilder addTitleProperty(DRIPropertyExpression propertyExpression) {
        getObject().addTitlePropertyExpression(propertyExpression);
        return this;
    }

    /**
     * Adds a jasper property to the column title group.
     *
     * @param name            the property name
     * @param valueExpression the property value expression
     * @return a column title group builder
     */
    public ColumnTitleGroupBuilder addTitleProperty(String name, DRIExpression<String> valueExpression) {
        getObject().addTitlePropertyExpression(Expressions.property(name, valueExpression));
        return this;
    }

    /**
     * Adds a jasper property to the column title group.
     *
     * @param name  the property name
     * @param value the property value
     * @return a column title group builder
     */
    public ColumnTitleGroupBuilder addTitleProperty(String name, String value) {
        getObject().addTitlePropertyExpression(Expressions.property(name, value));
        return this;
    }

    /**
     * <p>getColumnGridTitleGroup.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.grid.DRColumnTitleGroup} object.
     */
    public DRColumnTitleGroup getColumnGridTitleGroup() {
        return build();
    }
}

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
package net.sf.dynamicreports.report.builder.component;

import net.sf.dynamicreports.report.base.component.DRDimensionComponent;
import net.sf.dynamicreports.report.builder.group.GroupBuilder;
import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.StretchType;
import org.apache.commons.lang3.Validate;

/**
 * <p>Abstract DimensionComponentBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
@SuppressWarnings("unchecked")
public abstract class DimensionComponentBuilder<T extends DimensionComponentBuilder<T, U>, U extends DRDimensionComponent> extends ComponentBuilder<T, U> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for DimensionComponentBuilder.</p>
     *
     * @param component a U object.
     */
    public DimensionComponentBuilder(U component) {
        super(component);
    }

    /**
     * Sets the component preferred dimension.
     *
     * @see net.sf.dynamicreports.report.builder.Units
     * @param width
     *          the component preferred width >= 0
     * @param height
     *          the component preferred height >= 0
     * @exception IllegalArgumentException
     *              if <code>width</code> is < 0
     * @exception IllegalArgumentException
     *              if <code>height</code> is < 0
     * @exception IllegalArgumentException
     *              if <code>width</code> is < 0
     * @exception IllegalArgumentException
     *              if <code>height</code> is < 0
     * @return a T object.
     */
    public T setDimension(Integer width, Integer height) {
        getObject().setWidth(width);
        getObject().setHeight(height);
        return (T) this;
    }

    /**
     * Sets the component fixed dimension.
     *
     * @see net.sf.dynamicreports.report.builder.Units
     * @param width
     *          the component fixed width >= 0
     * @param height
     *          the component fixed height >= 0
     * @exception IllegalArgumentException
     *              if <code>width</code> is < 0
     * @exception IllegalArgumentException
     *              if <code>height</code> is < 0
     * @exception IllegalArgumentException
     *              if <code>width</code> is < 0
     * @exception IllegalArgumentException
     *              if <code>height</code> is < 0
     * @return a T object.
     */
    public T setFixedDimension(Integer width, Integer height) {
        getObject().setWidth(width);
        getObject().setHeight(height);
        getObject().setWidthType(ComponentDimensionType.FIXED);
        getObject().setHeightType(ComponentDimensionType.FIXED);
        return (T) this;
    }

    /**
     * Sets the component minimum dimension.
     *
     * @see net.sf.dynamicreports.report.builder.Units
     * @param width
     *          the component minimum width >= 0
     * @param height
     *          the component minimum height >= 0
     * @exception IllegalArgumentException
     *              if <code>width</code> is < 0
     * @exception IllegalArgumentException
     *              if <code>height</code> is < 0
     * @exception IllegalArgumentException
     *              if <code>width</code> is < 0
     * @exception IllegalArgumentException
     *              if <code>height</code> is < 0
     * @return a T object.
     */
    public T setMinDimension(Integer width, Integer height) {
        getObject().setWidth(width);
        getObject().setHeight(height);
        getObject().setWidthType(ComponentDimensionType.EXPAND);
        getObject().setHeightType(ComponentDimensionType.EXPAND);
        return (T) this;
    }

    /**
     * Sets the component preferred width.
     *
     * @see net.sf.dynamicreports.report.builder.Units
     * @param width
     *          the component preferred width >= 0
     * @exception IllegalArgumentException
     *              if <code>width</code> is < 0
     * @return a T object.
     */
    public T setWidth(Integer width) {
        getObject().setWidth(width);
        return (T) this;
    }

    /**
     * Sets the component fixed width.
     *
     * @see net.sf.dynamicreports.report.builder.Units
     * @param width
     *          the component fixed width >= 0
     * @exception IllegalArgumentException
     *              if <code>width</code> is < 0
     * @return a T object.
     */
    public T setFixedWidth(Integer width) {
        getObject().setWidth(width);
        getObject().setWidthType(ComponentDimensionType.FIXED);
        return (T) this;
    }

    /**
     * Sets the component minimum width.
     *
     * @see net.sf.dynamicreports.report.builder.Units
     * @param width
     *          the component minimum width >= 0
     * @exception IllegalArgumentException
     *              if <code>width</code> is < 0
     * @return a T object.
     */
    public T setMinWidth(Integer width) {
        getObject().setWidth(width);
        getObject().setWidthType(ComponentDimensionType.EXPAND);
        return (T) this;
    }

    /**
     * Sets the component preferred height.
     *
     * @see net.sf.dynamicreports.report.builder.Units
     * @param height
     *          the component preferred height >= 0
     * @exception IllegalArgumentException
     *              if <code>height</code> is < 0
     * @return a T object.
     */
    public T setHeight(Integer height) {
        getObject().setHeight(height);
        return (T) this;
    }

    /**
     * Sets the component fixed height.
     *
     * @see net.sf.dynamicreports.report.builder.Units
     * @param height
     *          the component fixed height >= 0
     * @exception IllegalArgumentException
     *              if <code>height</code> is < 0
     * @return a T object.
     */
    public T setFixedHeight(Integer height) {
        getObject().setHeight(height);
        getObject().setHeightType(ComponentDimensionType.FIXED);
        return (T) this;
    }

    /**
     * Sets the component minimum height.
     *
     * @see net.sf.dynamicreports.report.builder.Units
     * @param height
     *          the component minimum height >= 0
     * @exception IllegalArgumentException
     *              if <code>height</code> is < 0
     * @return a T object.
     */
    public T setMinHeight(Integer height) {
        getObject().setHeight(height);
        getObject().setHeightType(ComponentDimensionType.EXPAND);
        return (T) this;
    }

    /**
     * <p>setPositionType.</p>
     *
     * @param positionType a {@link net.sf.dynamicreports.report.constant.ComponentPositionType} object.
     * @return a T object.
     */
    public T setPositionType(ComponentPositionType positionType) {
        getObject().setPositionType(positionType);
        return (T) this;
    }

    /**
     * <p>setStretchType.</p>
     *
     * @param stretchType a {@link net.sf.dynamicreports.report.constant.StretchType} object.
     * @return a T object.
     */
    public T setStretchType(StretchType stretchType) {
        getObject().setStretchType(stretchType);
        return (T) this;
    }

    /**
     * <p>setPrintInFirstWholeBand.</p>
     *
     * @param printInFirstWholeBand a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setPrintInFirstWholeBand(Boolean printInFirstWholeBand) {
        getObject().setPrintInFirstWholeBand(printInFirstWholeBand);
        return (T) this;
    }

    /**
     * <p>setPrintWhenDetailOverflows.</p>
     *
     * @param printWhenDetailOverflows a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setPrintWhenDetailOverflows(Boolean printWhenDetailOverflows) {
        getObject().setPrintWhenDetailOverflows(printWhenDetailOverflows);
        return (T) this;
    }

    /**
     * <p>setPrintWhenGroupChanges.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.builder.group.GroupBuilder} object.
     * @return a T object.
     */
    public T setPrintWhenGroupChanges(GroupBuilder<?> group) {
        Validate.notNull(group, "group must not be null");
        getObject().setPrintWhenGroupChanges(group.getGroup());
        return (T) this;
    }
}

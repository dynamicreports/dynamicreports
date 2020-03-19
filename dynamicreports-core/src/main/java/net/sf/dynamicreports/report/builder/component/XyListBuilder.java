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

import net.sf.dynamicreports.report.base.component.DRXyList;
import net.sf.dynamicreports.report.constant.Constants;
import org.apache.commons.lang3.Validate;

/**
 * <p>XyListBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class XyListBuilder extends DimensionComponentBuilder<XyListBuilder, DRXyList> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for XyListBuilder.</p>
     */
    protected XyListBuilder() {
        super(new DRXyList());
    }

    /**
     * <p>add.</p>
     *
     * @param x         a {@link java.lang.Integer} object.
     * @param y         a {@link java.lang.Integer} object.
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.XyListBuilder} object.
     */
    public XyListBuilder add(Integer x, Integer y, ComponentBuilder<?, ?> component) {
        Validate.notNull(x, "x must not be null");
        Validate.notNull(y, "y must not be null");
        Validate.notNull(component, "component must not be null");
        getObject().addComponent(x, y, component.getComponent());
        return this;
    }

    /**
     * <p>add.</p>
     *
     * @param x         a {@link java.lang.Integer} object.
     * @param y         a {@link java.lang.Integer} object.
     * @param width     a {@link java.lang.Integer} object.
     * @param height    a {@link java.lang.Integer} object.
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.XyListBuilder} object.
     */
    public XyListBuilder add(Integer x, Integer y, Integer width, Integer height, ComponentBuilder<?, ?> component) {
        Validate.notNull(x, "x must not be null");
        Validate.notNull(y, "y must not be null");
        Validate.notNull(component, "component must not be null");
        if (component instanceof DimensionComponentBuilder) {
            ((DimensionComponentBuilder<?, ?>) component).setWidth(width);
            ((DimensionComponentBuilder<?, ?>) component).setHeight(height);
        }
        getObject().addComponent(x, y, component.getComponent());
        return this;
    }

    /**
     * <p>add.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.component.XyListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.XyListBuilder} object.
     */
    public XyListBuilder add(XyListCellBuilder... cells) {
        Validate.notNull(cells, "cells must not be null");
        Validate.noNullElements(cells, "cells must not contains null cell");
        for (XyListCellBuilder cell : cells) {
            getObject().addCell(cell.build());
        }
        return this;
    }

    /**
     * <p>getXyList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.component.DRXyList} object.
     */
    public DRXyList getXyList() {
        return build();
    }
}

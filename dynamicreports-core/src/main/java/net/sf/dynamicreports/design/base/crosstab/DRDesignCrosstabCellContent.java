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

package net.sf.dynamicreports.design.base.crosstab;

import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabCellContent;
import net.sf.dynamicreports.design.definition.style.DRIDesignStyle;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignCrosstabCellContent class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignCrosstabCellContent implements DRIDesignCrosstabCellContent {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private int width;
    private int height;
    private DRDesignList list;
    private DRDesignComponent component;
    private DRIDesignStyle style;

    /** {@inheritDoc} */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * <p>Setter for the field <code>width</code>.</p>
     *
     * @param width a int.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /** {@inheritDoc} */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * <p>Setter for the field <code>height</code>.</p>
     *
     * @param height a int.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * <p>Getter for the field <code>list</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.component.DRDesignList} object.
     */
    public DRDesignList getList() {
        return list;
    }

    /**
     * <p>Setter for the field <code>list</code>.</p>
     *
     * @param list a {@link net.sf.dynamicreports.design.base.component.DRDesignList} object.
     */
    public void setList(DRDesignList list) {
        this.list = list;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignComponent getComponent() {
        return component;
    }

    /**
     * <p>Setter for the field <code>component</code>.</p>
     *
     * @param component a {@link net.sf.dynamicreports.design.base.component.DRDesignComponent} object.
     */
    public void setComponent(DRDesignComponent component) {
        this.component = component;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignStyle getStyle() {
        return style;
    }

    /**
     * <p>Setter for the field <code>style</code>.</p>
     *
     * @param style a {@link net.sf.dynamicreports.design.definition.style.DRIDesignStyle} object.
     */
    public void setStyle(DRIDesignStyle style) {
        this.style = style;
    }
}

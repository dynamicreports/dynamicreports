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
package net.sf.dynamicreports.design.base;

import net.sf.dynamicreports.design.definition.DRIDesignPage;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.PageOrientation;

/**
 * <p>DRDesignPage class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignPage implements DRIDesignPage {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private int width;
    private int height;
    private PageOrientation orientation;
    private DRDesignMargin margin;
    private int columnsPerPage;
    private int columnSpace;
    private int columnWidth;

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

    /** {@inheritDoc} */
    @Override
    public PageOrientation getOrientation() {
        return orientation;
    }

    /**
     * <p>Setter for the field <code>orientation</code>.</p>
     *
     * @param orientation a {@link net.sf.dynamicreports.report.constant.PageOrientation} object.
     */
    public void setOrientation(PageOrientation orientation) {
        this.orientation = orientation;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignMargin getMargin() {
        return margin;
    }

    /**
     * <p>Setter for the field <code>margin</code>.</p>
     *
     * @param margin a {@link net.sf.dynamicreports.design.base.DRDesignMargin} object.
     */
    public void setMargin(DRDesignMargin margin) {
        this.margin = margin;
    }

    /** {@inheritDoc} */
    @Override
    public int getColumnsPerPage() {
        return columnsPerPage;
    }

    /**
     * <p>Setter for the field <code>columnsPerPage</code>.</p>
     *
     * @param columnsPerPage a int.
     */
    public void setColumnsPerPage(int columnsPerPage) {
        this.columnsPerPage = columnsPerPage;
    }

    /** {@inheritDoc} */
    @Override
    public int getColumnSpace() {
        return columnSpace;
    }

    /**
     * <p>Setter for the field <code>columnSpace</code>.</p>
     *
     * @param columnSpace a int.
     */
    public void setColumnSpace(int columnSpace) {
        this.columnSpace = columnSpace;
    }

    /** {@inheritDoc} */
    @Override
    public int getColumnWidth() {
        return columnWidth;
    }

    /**
     * <p>Setter for the field <code>columnWidth</code>.</p>
     *
     * @param columnWidth a int.
     */
    public void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }
}

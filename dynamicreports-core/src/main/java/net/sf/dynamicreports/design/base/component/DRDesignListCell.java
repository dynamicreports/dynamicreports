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
package net.sf.dynamicreports.design.base.component;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;

import java.io.Serializable;

/**
 * <p>DRDesignListCell class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignListCell implements Serializable {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private HorizontalCellComponentAlignment horizontalAlignment;
    private VerticalCellComponentAlignment verticalAlignment;
    private DRDesignComponent component;
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;

    /**
     * <p>Constructor for DRDesignListCell.</p>
     *
     * @param component a {@link net.sf.dynamicreports.design.base.component.DRDesignComponent} object.
     */
    protected DRDesignListCell(DRDesignComponent component) {
        this(null, null, component);
    }

    /**
     * <p>Constructor for DRDesignListCell.</p>
     *
     * @param horizontalAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment} object.
     * @param verticalAlignment   a {@link net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment} object.
     * @param component           a {@link net.sf.dynamicreports.design.base.component.DRDesignComponent} object.
     */
    protected DRDesignListCell(HorizontalCellComponentAlignment horizontalAlignment, VerticalCellComponentAlignment verticalAlignment, DRDesignComponent component) {
        this.horizontalAlignment = horizontalAlignment;
        this.verticalAlignment = verticalAlignment;
        this.component = component;
    }

    /**
     * <p>Getter for the field <code>horizontalAlignment</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment} object.
     */
    public HorizontalCellComponentAlignment getHorizontalAlignment() {
        return horizontalAlignment;
    }

    /**
     * <p>Setter for the field <code>horizontalAlignment</code>.</p>
     *
     * @param horizontalAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment} object.
     */
    public void setHorizontalAlignment(HorizontalCellComponentAlignment horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    /**
     * <p>Getter for the field <code>verticalAlignment</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment} object.
     */
    public VerticalCellComponentAlignment getVerticalAlignment() {
        return verticalAlignment;
    }

    /**
     * <p>Setter for the field <code>verticalAlignment</code>.</p>
     *
     * @param verticalAlignment a {@link net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment} object.
     */
    public void setVerticalAlignment(VerticalCellComponentAlignment verticalAlignment) {
        this.verticalAlignment = verticalAlignment;
    }

    /**
     * <p>Getter for the field <code>component</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.component.DRDesignComponent} object.
     */
    public DRDesignComponent getComponent() {
        return component;
    }

    /**
     * <p>Getter for the field <code>x</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getX() {
        return x;
    }

    /**
     * <p>Setter for the field <code>x</code>.</p>
     *
     * @param x a {@link java.lang.Integer} object.
     */
    public void setX(Integer x) {
        this.x = x;
    }

    /**
     * <p>Getter for the field <code>y</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getY() {
        return y;
    }

    /**
     * <p>Setter for the field <code>y</code>.</p>
     *
     * @param y a {@link java.lang.Integer} object.
     */
    public void setY(Integer y) {
        this.y = y;
    }

    /**
     * <p>Getter for the field <code>width</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * <p>Setter for the field <code>width</code>.</p>
     *
     * @param width a {@link java.lang.Integer} object.
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * <p>Getter for the field <code>height</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * <p>Setter for the field <code>height</code>.</p>
     *
     * @param height a {@link java.lang.Integer} object.
     */
    public void setHeight(Integer height) {
        this.height = height;
    }
}

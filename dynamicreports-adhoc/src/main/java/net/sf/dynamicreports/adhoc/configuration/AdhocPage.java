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
package net.sf.dynamicreports.adhoc.configuration;

import java.io.Serializable;

/**
 * <p>AdhocPage class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class AdhocPage implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private Integer width;
    private Integer height;
    private AdhocPageOrientation orientation;
    private Integer topMargin;
    private Integer bottomMargin;
    private Integer leftMargin;
    private Integer rightMargin;
    private Boolean ignorePageWidth;

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

    /**
     * <p>Getter for the field <code>orientation</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPageOrientation} object.
     */
    public AdhocPageOrientation getOrientation() {
        return orientation;
    }

    /**
     * <p>Setter for the field <code>orientation</code>.</p>
     *
     * @param orientation a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPageOrientation} object.
     */
    public void setOrientation(AdhocPageOrientation orientation) {
        this.orientation = orientation;
    }

    /**
     * <p>Getter for the field <code>topMargin</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getTopMargin() {
        return topMargin;
    }

    /**
     * <p>Setter for the field <code>topMargin</code>.</p>
     *
     * @param topMargin a {@link java.lang.Integer} object.
     */
    public void setTopMargin(Integer topMargin) {
        this.topMargin = topMargin;
    }

    /**
     * <p>Getter for the field <code>bottomMargin</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getBottomMargin() {
        return bottomMargin;
    }

    /**
     * <p>Setter for the field <code>bottomMargin</code>.</p>
     *
     * @param bottomMargin a {@link java.lang.Integer} object.
     */
    public void setBottomMargin(Integer bottomMargin) {
        this.bottomMargin = bottomMargin;
    }

    /**
     * <p>Getter for the field <code>leftMargin</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getLeftMargin() {
        return leftMargin;
    }

    /**
     * <p>Setter for the field <code>leftMargin</code>.</p>
     *
     * @param leftMargin a {@link java.lang.Integer} object.
     */
    public void setLeftMargin(Integer leftMargin) {
        this.leftMargin = leftMargin;
    }

    /**
     * <p>Getter for the field <code>rightMargin</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getRightMargin() {
        return rightMargin;
    }

    /**
     * <p>Setter for the field <code>rightMargin</code>.</p>
     *
     * @param rightMargin a {@link java.lang.Integer} object.
     */
    public void setRightMargin(Integer rightMargin) {
        this.rightMargin = rightMargin;
    }

    /**
     * <p>Getter for the field <code>ignorePageWidth</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnorePageWidth() {
        return ignorePageWidth;
    }

    /**
     * <p>Setter for the field <code>ignorePageWidth</code>.</p>
     *
     * @param ignorePageWidth a {@link java.lang.Boolean} object.
     */
    public void setIgnorePageWidth(Boolean ignorePageWidth) {
        this.ignorePageWidth = ignorePageWidth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdhocPage)) {
            return false;
        }

        AdhocPage object = (AdhocPage) obj;
        if (!(width == null ? object.getWidth() == null : width.equals(object.getWidth()))) {
            return false;
        }
        if (!(height == null ? object.getHeight() == null : height.equals(object.getHeight()))) {
            return false;
        }
        if (!(orientation == null ? object.getOrientation() == null : orientation.equals(object.getOrientation()))) {
            return false;
        }
        if (!(topMargin == null ? object.getTopMargin() == null : topMargin.equals(object.getTopMargin()))) {
            return false;
        }
        if (!(bottomMargin == null ? object.getBottomMargin() == null : bottomMargin.equals(object.getBottomMargin()))) {
            return false;
        }
        if (!(leftMargin == null ? object.getLeftMargin() == null : leftMargin.equals(object.getLeftMargin()))) {
            return false;
        }
        if (!(rightMargin == null ? object.getRightMargin() == null : rightMargin.equals(object.getRightMargin()))) {
            return false;
        }
        if (!(ignorePageWidth == null ? object.getIgnorePageWidth() == null : ignorePageWidth.equals(object.getIgnorePageWidth()))) {
            return false;
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdhocPage clone() {
        AdhocPage clone;
        try {
            clone = (AdhocPage) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        return clone;
    }

}

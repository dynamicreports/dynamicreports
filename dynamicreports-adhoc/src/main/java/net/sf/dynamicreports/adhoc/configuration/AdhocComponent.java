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

package net.sf.dynamicreports.adhoc.configuration;

import java.io.Serializable;

/**
 * <p>AdhocComponent class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class AdhocComponent implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String key;
    private AdhocStyle style;
    private Integer width;
    private Integer height;
    private AdhocProperties properties;

    /**
     * <p>Constructor for AdhocComponent.</p>
     */
    public AdhocComponent() {
        properties = new AdhocProperties();
    }

    /**
     * <p>Getter for the field <code>key</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getKey() {
        return key;
    }

    /**
     * <p>Setter for the field <code>key</code>.</p>
     *
     * @param key a {@link java.lang.String} object.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * <p>Getter for the field <code>style</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public AdhocStyle getStyle() {
        return style;
    }

    /**
     * <p>Setter for the field <code>style</code>.</p>
     *
     * @param style a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public void setStyle(AdhocStyle style) {
        this.style = style;
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

    /**
     * <p>Getter for the field <code>properties</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocProperties} object.
     */
    public AdhocProperties getProperties() {
        return properties;
    }

    /**
     * <p>Setter for the field <code>properties</code>.</p>
     *
     * @param properties a {@link net.sf.dynamicreports.adhoc.configuration.AdhocProperties} object.
     */
    public void setProperties(AdhocProperties properties) {
        this.properties = properties;
    }

    /**
     * <p>getProperty.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @param <T> a T object.
     * @return a T object.
     */
    public <T> T getProperty(String key) {
        return this.properties.getProperty(key);
    }

    /**
     * <p>setProperty.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @param value a {@link java.lang.Object} object.
     */
    public void setProperty(String key, Object value) {
        this.properties.setProperty(key, value);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdhocComponent)) {
            return false;
        }

        AdhocComponent object = (AdhocComponent) obj;
        if (!(key == null ? object.getKey() == null : key.equals(object.getKey()))) {
            return false;
        }
        if (!(style == null ? object.getStyle() == null : style.equals(object.getStyle()))) {
            return false;
        }
        if (!(width == null ? object.getWidth() == null : width.equals(object.getWidth()))) {
            return false;
        }
        if (!(height == null ? object.getHeight() == null : height.equals(object.getHeight()))) {
            return false;
        }
        if (!(properties == null ? object.getProperties() == null : properties.equals(object.getProperties()))) {
            return false;
        }

        return true;
    }

    /** {@inheritDoc} */
    @Override
    public AdhocComponent clone() {
        AdhocComponent clone;
        try {
            clone = (AdhocComponent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        if (style != null) {
            clone.style = style.clone();
        }
        if (properties != null) {
            clone.properties = properties.clone();
        }

        return clone;
    }

}

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
package net.sf.dynamicreports.adhoc.configuration;

import java.io.Serializable;

/**
 * <p>AdhocGroup class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class AdhocGroup implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Boolean startInNewPage;
    private AdhocGroupHeaderLayout headerLayout;
    private AdhocStyle style;
    private AdhocStyle titleStyle;
    private AdhocProperties properties;

    /**
     * <p>Constructor for AdhocGroup.</p>
     */
    public AdhocGroup() {
        properties = new AdhocProperties();
    }

    /**
     * <p>Getter for the field <code>name</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Setter for the field <code>name</code>.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Getter for the field <code>startInNewPage</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getStartInNewPage() {
        return startInNewPage;
    }

    /**
     * <p>Setter for the field <code>startInNewPage</code>.</p>
     *
     * @param startInNewPage a {@link java.lang.Boolean} object.
     */
    public void setStartInNewPage(Boolean startInNewPage) {
        this.startInNewPage = startInNewPage;
    }

    /**
     * <p>Getter for the field <code>headerLayout</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocGroupHeaderLayout} object.
     */
    public AdhocGroupHeaderLayout getHeaderLayout() {
        return headerLayout;
    }

    /**
     * <p>Setter for the field <code>headerLayout</code>.</p>
     *
     * @param headerLayout a {@link net.sf.dynamicreports.adhoc.configuration.AdhocGroupHeaderLayout} object.
     */
    public void setHeaderLayout(AdhocGroupHeaderLayout headerLayout) {
        this.headerLayout = headerLayout;
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
     * <p>Getter for the field <code>titleStyle</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public AdhocStyle getTitleStyle() {
        return titleStyle;
    }

    /**
     * <p>Setter for the field <code>titleStyle</code>.</p>
     *
     * @param titleStyle a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public void setTitleStyle(AdhocStyle titleStyle) {
        this.titleStyle = titleStyle;
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
     * @param key   a {@link java.lang.String} object.
     * @param value a {@link java.lang.Object} object.
     */
    public void setProperty(String key, Object value) {
        this.properties.setProperty(key, value);
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
        if (!(obj instanceof AdhocGroup)) {
            return false;
        }

        AdhocGroup object = (AdhocGroup) obj;
        if (!(name == null ? object.getName() == null : name.equals(object.getName()))) {
            return false;
        }
        if (!(startInNewPage == null ? object.getStartInNewPage() == null : startInNewPage.equals(object.getStartInNewPage()))) {
            return false;
        }
        if (!(headerLayout == null ? object.getHeaderLayout() == null : headerLayout.equals(object.getHeaderLayout()))) {
            return false;
        }
        if (!(style == null ? object.getStyle() == null : style.equals(object.getStyle()))) {
            return false;
        }
        if (!(titleStyle == null ? object.getTitleStyle() == null : titleStyle.equals(object.getTitleStyle()))) {
            return false;
        }
        if (!(properties == null ? object.getProperties() == null : properties.equals(object.getProperties()))) {
            return false;
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdhocGroup clone() {
        AdhocGroup clone;
        try {
            clone = (AdhocGroup) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        if (style != null) {
            clone.style = style.clone();
        }
        if (titleStyle != null) {
            clone.titleStyle = titleStyle.clone();
        }
        if (properties != null) {
            clone.properties = properties.clone();
        }

        return clone;
    }

}

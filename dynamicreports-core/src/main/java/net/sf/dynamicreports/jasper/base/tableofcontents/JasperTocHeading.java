/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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
package net.sf.dynamicreports.jasper.base.tableofcontents;

import net.sf.dynamicreports.report.constant.Constants;

import java.io.Serializable;

/**
 * <p>JasperTocHeading class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class JasperTocHeading implements Serializable {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Integer level;
    private String text;
    private String reference;
    private Integer pageIndex;
    private Object customValue;

    /**
     * <p>Getter for the field <code>level</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * <p>Setter for the field <code>level</code>.</p>
     *
     * @param level a {@link java.lang.Integer} object.
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * <p>Getter for the field <code>text</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getText() {
        return text;
    }

    /**
     * <p>Setter for the field <code>text</code>.</p>
     *
     * @param text a {@link java.lang.String} object.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * <p>Getter for the field <code>reference</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getReference() {
        return reference;
    }

    /**
     * <p>Setter for the field <code>reference</code>.</p>
     *
     * @param reference a {@link java.lang.String} object.
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * <p>Getter for the field <code>pageIndex</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageIndex() {
        return pageIndex;
    }

    /**
     * <p>Setter for the field <code>pageIndex</code>.</p>
     *
     * @param pageIndex a {@link java.lang.Integer} object.
     */
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * <p>Getter for the field <code>customValue</code>.</p>
     *
     * @return a {@link java.lang.Object} object.
     */
    public Object getCustomValue() {
        return customValue;
    }

    /**
     * <p>Setter for the field <code>customValue</code>.</p>
     *
     * @param customValue a {@link java.lang.Object} object.
     */
    public void setCustomValue(Object customValue) {
        this.customValue = customValue;
    }

}

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
import java.util.ArrayList;
import java.util.List;

/**
 * <p>AdhocReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class AdhocReport implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private AdhocStyle textStyle;
    private AdhocStyle columnStyle;
    private AdhocStyle columnTitleStyle;
    private AdhocStyle groupStyle;
    private AdhocStyle groupTitleStyle;
    private AdhocStyle subtotalStyle;
    private AdhocStyle detailOddRowStyle;
    private Boolean highlightDetailOddRows;
    private AdhocStyle detailEvenRowStyle;
    private Boolean highlightDetailEvenRows;
    private Boolean ignorePagination;
    private Boolean tableOfContents;
    private AdhocPage page;
    private List<AdhocColumn> columns;
    private List<AdhocGroup> groups;
    private List<AdhocSort> sorts;
    private List<AdhocSubtotal> subtotals;
    private List<AdhocComponent> components;
    private AdhocProperties properties;

    /**
     * <p>Constructor for AdhocReport.</p>
     */
    public AdhocReport() {
        columns = new ArrayList<AdhocColumn>();
        groups = new ArrayList<AdhocGroup>();
        sorts = new ArrayList<AdhocSort>();
        subtotals = new ArrayList<AdhocSubtotal>();
        components = new ArrayList<AdhocComponent>();
        properties = new AdhocProperties();
    }

    /**
     * <p>Getter for the field <code>textStyle</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public AdhocStyle getTextStyle() {
        return textStyle;
    }

    /**
     * <p>Setter for the field <code>textStyle</code>.</p>
     *
     * @param textStyle a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public void setTextStyle(AdhocStyle textStyle) {
        this.textStyle = textStyle;
    }

    /**
     * <p>Getter for the field <code>columnStyle</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public AdhocStyle getColumnStyle() {
        return columnStyle;
    }

    /**
     * <p>Setter for the field <code>columnStyle</code>.</p>
     *
     * @param columnStyle a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public void setColumnStyle(AdhocStyle columnStyle) {
        this.columnStyle = columnStyle;
    }

    /**
     * <p>Getter for the field <code>columnTitleStyle</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public AdhocStyle getColumnTitleStyle() {
        return columnTitleStyle;
    }

    /**
     * <p>Setter for the field <code>columnTitleStyle</code>.</p>
     *
     * @param columnTitleStyle a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public void setColumnTitleStyle(AdhocStyle columnTitleStyle) {
        this.columnTitleStyle = columnTitleStyle;
    }

    /**
     * <p>Getter for the field <code>groupStyle</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public AdhocStyle getGroupStyle() {
        return groupStyle;
    }

    /**
     * <p>Setter for the field <code>groupStyle</code>.</p>
     *
     * @param groupStyle a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public void setGroupStyle(AdhocStyle groupStyle) {
        this.groupStyle = groupStyle;
    }

    /**
     * <p>Getter for the field <code>groupTitleStyle</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public AdhocStyle getGroupTitleStyle() {
        return groupTitleStyle;
    }

    /**
     * <p>Setter for the field <code>groupTitleStyle</code>.</p>
     *
     * @param groupTitleStyle a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public void setGroupTitleStyle(AdhocStyle groupTitleStyle) {
        this.groupTitleStyle = groupTitleStyle;
    }

    /**
     * <p>Getter for the field <code>subtotalStyle</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public AdhocStyle getSubtotalStyle() {
        return subtotalStyle;
    }

    /**
     * <p>Setter for the field <code>subtotalStyle</code>.</p>
     *
     * @param subtotalStyle a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public void setSubtotalStyle(AdhocStyle subtotalStyle) {
        this.subtotalStyle = subtotalStyle;
    }

    /**
     * <p>Getter for the field <code>detailOddRowStyle</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public AdhocStyle getDetailOddRowStyle() {
        return detailOddRowStyle;
    }

    /**
     * <p>Setter for the field <code>detailOddRowStyle</code>.</p>
     *
     * @param detailOddRowStyle a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public void setDetailOddRowStyle(AdhocStyle detailOddRowStyle) {
        this.detailOddRowStyle = detailOddRowStyle;
    }

    /**
     * <p>Getter for the field <code>highlightDetailOddRows</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getHighlightDetailOddRows() {
        return highlightDetailOddRows;
    }

    /**
     * <p>Setter for the field <code>highlightDetailOddRows</code>.</p>
     *
     * @param highlightDetailOddRows a {@link java.lang.Boolean} object.
     */
    public void setHighlightDetailOddRows(Boolean highlightDetailOddRows) {
        this.highlightDetailOddRows = highlightDetailOddRows;
    }

    /**
     * <p>Getter for the field <code>detailEvenRowStyle</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public AdhocStyle getDetailEvenRowStyle() {
        return detailEvenRowStyle;
    }

    /**
     * <p>Setter for the field <code>detailEvenRowStyle</code>.</p>
     *
     * @param detailEvenRowStyle a {@link net.sf.dynamicreports.adhoc.configuration.AdhocStyle} object.
     */
    public void setDetailEvenRowStyle(AdhocStyle detailEvenRowStyle) {
        this.detailEvenRowStyle = detailEvenRowStyle;
    }

    /**
     * <p>Getter for the field <code>highlightDetailEvenRows</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getHighlightDetailEvenRows() {
        return highlightDetailEvenRows;
    }

    /**
     * <p>Setter for the field <code>highlightDetailEvenRows</code>.</p>
     *
     * @param highlightDetailEvenRows a {@link java.lang.Boolean} object.
     */
    public void setHighlightDetailEvenRows(Boolean highlightDetailEvenRows) {
        this.highlightDetailEvenRows = highlightDetailEvenRows;
    }

    /**
     * <p>Getter for the field <code>ignorePagination</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnorePagination() {
        return ignorePagination;
    }

    /**
     * <p>Setter for the field <code>ignorePagination</code>.</p>
     *
     * @param ignorePagination a {@link java.lang.Boolean} object.
     */
    public void setIgnorePagination(Boolean ignorePagination) {
        this.ignorePagination = ignorePagination;
    }

    /**
     * <p>Getter for the field <code>tableOfContents</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getTableOfContents() {
        return tableOfContents;
    }

    /**
     * <p>Setter for the field <code>tableOfContents</code>.</p>
     *
     * @param tableOfContents a {@link java.lang.Boolean} object.
     */
    public void setTableOfContents(Boolean tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    /**
     * <p>Getter for the field <code>page</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPage} object.
     */
    public AdhocPage getPage() {
        return page;
    }

    /**
     * <p>Setter for the field <code>page</code>.</p>
     *
     * @param page a {@link net.sf.dynamicreports.adhoc.configuration.AdhocPage} object.
     */
    public void setPage(AdhocPage page) {
        this.page = page;
    }

    /**
     * <p>Getter for the field <code>columns</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<AdhocColumn> getColumns() {
        return columns;
    }

    /**
     * <p>Setter for the field <code>columns</code>.</p>
     *
     * @param columns a {@link java.util.List} object.
     */
    public void setColumns(List<AdhocColumn> columns) {
        this.columns = columns;
    }

    /**
     * <p>getColumn.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocColumn} object.
     */
    public AdhocColumn getColumn(String name) {
        if (columns == null) {
            return null;
        }

        for (AdhocColumn column : columns) {
            if (column.getName().equals(name)) {
                return column;
            }
        }
        return null;
    }

    /**
     * <p>addColumn.</p>
     *
     * @param column a {@link net.sf.dynamicreports.adhoc.configuration.AdhocColumn} object.
     */
    public void addColumn(AdhocColumn column) {
        this.columns.add(column);
    }

    /**
     * <p>Getter for the field <code>groups</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<AdhocGroup> getGroups() {
        return groups;
    }

    /**
     * <p>Setter for the field <code>groups</code>.</p>
     *
     * @param groups a {@link java.util.List} object.
     */
    public void setGroups(List<AdhocGroup> groups) {
        this.groups = groups;
    }

    /**
     * <p>addGroup.</p>
     *
     * @param group a {@link net.sf.dynamicreports.adhoc.configuration.AdhocGroup} object.
     */
    public void addGroup(AdhocGroup group) {
        this.groups.add(group);
    }

    /**
     * <p>Getter for the field <code>sorts</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<AdhocSort> getSorts() {
        return sorts;
    }

    /**
     * <p>Setter for the field <code>sorts</code>.</p>
     *
     * @param sorts a {@link java.util.List} object.
     */
    public void setSorts(List<AdhocSort> sorts) {
        this.sorts = sorts;
    }

    /**
     * <p>addSort.</p>
     *
     * @param sort a {@link net.sf.dynamicreports.adhoc.configuration.AdhocSort} object.
     */
    public void addSort(AdhocSort sort) {
        this.sorts.add(sort);
    }

    /**
     * <p>Getter for the field <code>subtotals</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<AdhocSubtotal> getSubtotals() {
        return subtotals;
    }

    /**
     * <p>Setter for the field <code>subtotals</code>.</p>
     *
     * @param subtotals a {@link java.util.List} object.
     */
    public void setSubtotals(List<AdhocSubtotal> subtotals) {
        this.subtotals = subtotals;
    }

    /**
     * <p>addSubtotal.</p>
     *
     * @param subtotal a {@link net.sf.dynamicreports.adhoc.configuration.AdhocSubtotal} object.
     */
    public void addSubtotal(AdhocSubtotal subtotal) {
        this.subtotals.add(subtotal);
    }

    /**
     * <p>Getter for the field <code>components</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<AdhocComponent> getComponents() {
        return components;
    }

    /**
     * <p>Setter for the field <code>components</code>.</p>
     *
     * @param components a {@link java.util.List} object.
     */
    public void setComponents(List<AdhocComponent> components) {
        this.components = components;
    }

    /**
     * <p>getComponent.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocComponent} object.
     */
    public AdhocComponent getComponent(String key) {
        if (components == null) {
            return null;
        }

        for (AdhocComponent component : components) {
            if (key.equals(component.getKey())) {
                return component;
            }
        }
        return null;
    }

    /**
     * <p>addComponent.</p>
     *
     * @param component a {@link net.sf.dynamicreports.adhoc.configuration.AdhocComponent} object.
     */
    public void addComponent(AdhocComponent component) {
        this.components.add(component);
    }

    /**
     * <p>setComponent.</p>
     *
     * @param key       a {@link java.lang.String} object.
     * @param component a {@link net.sf.dynamicreports.adhoc.configuration.AdhocComponent} object.
     */
    public void setComponent(String key, AdhocComponent component) {
        int index = -1;
        for (AdhocComponent cmp : components) {
            if (key.equals(cmp.getKey())) {
                index = components.indexOf(cmp);
                break;
            }
        }
        if (index != -1) {
            components.set(index, component);
        } else {
            addComponent(component);
        }
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
        if (!(obj instanceof AdhocReport)) {
            return false;
        }

        AdhocReport object = (AdhocReport) obj;
        if (!(textStyle == null ? object.getTextStyle() == null : textStyle.equals(object.getTextStyle()))) {
            return false;
        }
        if (!(columnStyle == null ? object.getColumnStyle() == null : columnStyle.equals(object.getColumnStyle()))) {
            return false;
        }
        if (!(columnTitleStyle == null ? object.getColumnTitleStyle() == null : columnTitleStyle.equals(object.getColumnTitleStyle()))) {
            return false;
        }
        if (!(groupStyle == null ? object.getGroupStyle() == null : groupStyle.equals(object.getGroupStyle()))) {
            return false;
        }
        if (!(groupTitleStyle == null ? object.getGroupTitleStyle() == null : groupTitleStyle.equals(object.getGroupTitleStyle()))) {
            return false;
        }
        if (!(subtotalStyle == null ? object.getSubtotalStyle() == null : subtotalStyle.equals(object.getSubtotalStyle()))) {
            return false;
        }
        if (!(detailOddRowStyle == null ? object.getDetailOddRowStyle() == null : detailOddRowStyle.equals(object.getDetailOddRowStyle()))) {
            return false;
        }
        if (!(highlightDetailOddRows == null ? object.getHighlightDetailOddRows() == null : highlightDetailOddRows.equals(object.getHighlightDetailOddRows()))) {
            return false;
        }
        if (!(detailEvenRowStyle == null ? object.getDetailEvenRowStyle() == null : detailEvenRowStyle.equals(object.getDetailEvenRowStyle()))) {
            return false;
        }
        if (!(highlightDetailEvenRows == null ? object.getHighlightDetailEvenRows() == null : highlightDetailEvenRows.equals(object.getHighlightDetailEvenRows()))) {
            return false;
        }
        if (!(ignorePagination == null ? object.getIgnorePagination() == null : ignorePagination.equals(object.getIgnorePagination()))) {
            return false;
        }
        if (!(tableOfContents == null ? object.getTableOfContents() == null : tableOfContents.equals(object.getTableOfContents()))) {
            return false;
        }
        if (!(page == null ? object.getPage() == null : page.equals(object.getPage()))) {
            return false;
        }
        if (!(columns == null ? object.getColumns() == null : columns.equals(object.getColumns()))) {
            return false;
        }
        if (!(groups == null ? object.getGroups() == null : groups.equals(object.getGroups()))) {
            return false;
        }
        if (!(sorts == null ? object.getSorts() == null : sorts.equals(object.getSorts()))) {
            return false;
        }
        if (!(subtotals == null ? object.getSubtotals() == null : subtotals.equals(object.getSubtotals()))) {
            return false;
        }
        if (!(components == null ? object.getComponents() == null : components.equals(object.getComponents()))) {
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
    public AdhocReport clone() {
        AdhocReport clone;
        try {
            clone = (AdhocReport) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        if (textStyle != null) {
            clone.textStyle = textStyle.clone();
        }
        if (columnStyle != null) {
            clone.columnStyle = columnStyle.clone();
        }
        if (columnTitleStyle != null) {
            clone.columnTitleStyle = columnTitleStyle.clone();
        }
        if (groupStyle != null) {
            clone.groupStyle = groupStyle.clone();
        }
        if (groupTitleStyle != null) {
            clone.groupTitleStyle = groupTitleStyle.clone();
        }
        if (subtotalStyle != null) {
            clone.subtotalStyle = subtotalStyle.clone();
        }
        if (detailOddRowStyle != null) {
            clone.detailOddRowStyle = detailOddRowStyle.clone();
        }
        if (detailEvenRowStyle != null) {
            clone.detailEvenRowStyle = detailEvenRowStyle.clone();
        }
        if (page != null) {
            clone.page = page.clone();
        }
        if (columns != null) {
            clone.columns = new ArrayList<AdhocColumn>();
            for (AdhocColumn adhocColumn : columns) {
                clone.addColumn(adhocColumn.clone());
            }
        }
        if (groups != null) {
            clone.groups = new ArrayList<AdhocGroup>();
            for (AdhocGroup adhocGroup : groups) {
                clone.addGroup(adhocGroup);
            }
        }
        if (sorts != null) {
            clone.sorts = new ArrayList<AdhocSort>();
            for (AdhocSort adhocSort : sorts) {
                clone.addSort(adhocSort);
            }
        }
        if (subtotals != null) {
            clone.subtotals = new ArrayList<AdhocSubtotal>();
            for (AdhocSubtotal adhocSubtotal : subtotals) {
                clone.addSubtotal(adhocSubtotal);
            }
        }
        if (components != null) {
            clone.components = new ArrayList<AdhocComponent>();
            for (AdhocComponent adhocComponent : components) {
                clone.addComponent(adhocComponent);
            }
        }
        if (properties != null) {
            clone.properties = properties.clone();
        }

        return clone;
    }

}

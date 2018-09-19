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

package net.sf.dynamicreports.examples.complex.dynamicreport;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>DynamicReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DynamicReport {
    private String title;
    private List<DynamicColumn> columns;
    private List<String> groups;
    private List<String> subtotals;
    private boolean showPageNumber;

    /**
     * <p>Constructor for DynamicReport.</p>
     */
    public DynamicReport() {
        columns = new ArrayList<DynamicColumn>();
        groups = new ArrayList<String>();
        subtotals = new ArrayList<String>();
    }

    /**
     * <p>Getter for the field <code>title</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTitle() {
        return title;
    }

    /**
     * <p>Setter for the field <code>title</code>.</p>
     *
     * @param title a {@link java.lang.String} object.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * <p>Getter for the field <code>columns</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DynamicColumn> getColumns() {
        return columns;
    }

    /**
     * <p>Setter for the field <code>columns</code>.</p>
     *
     * @param columns a {@link java.util.List} object.
     */
    public void setColumns(List<DynamicColumn> columns) {
        this.columns = columns;
    }

    /**
     * <p>addColumn.</p>
     *
     * @param column a {@link net.sf.dynamicreports.examples.complex.dynamicreport.DynamicColumn} object.
     */
    public void addColumn(DynamicColumn column) {
        this.columns.add(column);
    }

    /**
     * <p>Getter for the field <code>groups</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<String> getGroups() {
        return groups;
    }

    /**
     * <p>Setter for the field <code>groups</code>.</p>
     *
     * @param groups a {@link java.util.List} object.
     */
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * <p>addGroup.</p>
     *
     * @param column a {@link java.lang.String} object.
     */
    public void addGroup(String column) {
        this.groups.add(column);
    }

    /**
     * <p>Getter for the field <code>subtotals</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<String> getSubtotals() {
        return subtotals;
    }

    /**
     * <p>Setter for the field <code>subtotals</code>.</p>
     *
     * @param subtotals a {@link java.util.List} object.
     */
    public void setSubtotals(List<String> subtotals) {
        this.subtotals = subtotals;
    }

    /**
     * <p>addSubtotal.</p>
     *
     * @param column a {@link java.lang.String} object.
     */
    public void addSubtotal(String column) {
        this.subtotals.add(column);
    }

    /**
     * <p>isShowPageNumber.</p>
     *
     * @return a boolean.
     */
    public boolean isShowPageNumber() {
        return showPageNumber;
    }

    /**
     * <p>Setter for the field <code>showPageNumber</code>.</p>
     *
     * @param showPageNumber a boolean.
     */
    public void setShowPageNumber(boolean showPageNumber) {
        this.showPageNumber = showPageNumber;
    }

}

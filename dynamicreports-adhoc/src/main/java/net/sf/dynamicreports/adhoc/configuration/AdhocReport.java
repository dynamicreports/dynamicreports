/**
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

package net.sf.dynamicreports.adhoc.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
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

	public AdhocReport() {
		columns = new ArrayList<AdhocColumn>();
		groups = new ArrayList<AdhocGroup>();
		sorts = new ArrayList<AdhocSort>();
		subtotals = new ArrayList<AdhocSubtotal>();
		components = new ArrayList<AdhocComponent>();
		properties = new AdhocProperties();
	}

	public AdhocStyle getTextStyle() {
		return textStyle;
	}

	public void setTextStyle(AdhocStyle textStyle) {
		this.textStyle = textStyle;
	}

	public AdhocStyle getColumnStyle() {
		return columnStyle;
	}

	public void setColumnStyle(AdhocStyle columnStyle) {
		this.columnStyle = columnStyle;
	}

	public AdhocStyle getColumnTitleStyle() {
		return columnTitleStyle;
	}

	public void setColumnTitleStyle(AdhocStyle columnTitleStyle) {
		this.columnTitleStyle = columnTitleStyle;
	}

	public AdhocStyle getGroupStyle() {
		return groupStyle;
	}

	public void setGroupStyle(AdhocStyle groupStyle) {
		this.groupStyle = groupStyle;
	}

	public AdhocStyle getGroupTitleStyle() {
		return groupTitleStyle;
	}

	public void setGroupTitleStyle(AdhocStyle groupTitleStyle) {
		this.groupTitleStyle = groupTitleStyle;
	}

	public AdhocStyle getSubtotalStyle() {
		return subtotalStyle;
	}

	public void setSubtotalStyle(AdhocStyle subtotalStyle) {
		this.subtotalStyle = subtotalStyle;
	}

	public AdhocStyle getDetailOddRowStyle() {
		return detailOddRowStyle;
	}

	public void setDetailOddRowStyle(AdhocStyle detailOddRowStyle) {
		this.detailOddRowStyle = detailOddRowStyle;
	}

	public Boolean getHighlightDetailOddRows() {
		return highlightDetailOddRows;
	}

	public void setHighlightDetailOddRows(Boolean highlightDetailOddRows) {
		this.highlightDetailOddRows = highlightDetailOddRows;
	}

	public AdhocStyle getDetailEvenRowStyle() {
		return detailEvenRowStyle;
	}

	public void setDetailEvenRowStyle(AdhocStyle detailEvenRowStyle) {
		this.detailEvenRowStyle = detailEvenRowStyle;
	}

	public Boolean getHighlightDetailEvenRows() {
		return highlightDetailEvenRows;
	}

	public void setHighlightDetailEvenRows(Boolean highlightDetailEvenRows) {
		this.highlightDetailEvenRows = highlightDetailEvenRows;
	}

	public Boolean getIgnorePagination() {
		return ignorePagination;
	}

	public void setIgnorePagination(Boolean ignorePagination) {
		this.ignorePagination = ignorePagination;
	}

	public Boolean getTableOfContents() {
		return tableOfContents;
	}

	public void setTableOfContents(Boolean tableOfContents) {
		this.tableOfContents = tableOfContents;
	}

	public AdhocPage getPage() {
		return page;
	}

	public void setPage(AdhocPage page) {
		this.page = page;
	}

	public List<AdhocColumn> getColumns() {
		return columns;
	}

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

	public void addColumn(AdhocColumn column) {
		this.columns.add(column);
	}

	public void setColumns(List<AdhocColumn> columns) {
		this.columns = columns;
	}

	public List<AdhocGroup> getGroups() {
		return groups;
	}

	public void addGroup(AdhocGroup group) {
		this.groups.add(group);
	}

	public void setGroups(List<AdhocGroup> groups) {
		this.groups = groups;
	}

	public List<AdhocSort> getSorts() {
		return sorts;
	}

	public void addSort(AdhocSort sort) {
		this.sorts.add(sort);
	}

	public void setSorts(List<AdhocSort> sorts) {
		this.sorts = sorts;
	}

	public List<AdhocSubtotal> getSubtotals() {
		return subtotals;
	}

	public void addSubtotal(AdhocSubtotal subtotal) {
		this.subtotals.add(subtotal);
	}

	public void setSubtotals(List<AdhocSubtotal> subtotals) {
		this.subtotals = subtotals;
	}

	public List<AdhocComponent> getComponents() {
		return components;
	}

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

	public void addComponent(AdhocComponent component) {
		this.components.add(component);
	}

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

	public void setComponents(List<AdhocComponent> components) {
		this.components = components;
	}

	public AdhocProperties getProperties() {
		return properties;
	}

	public <T> T getProperty(String key) {
		return this.properties.getProperty(key);
	}

	public void setProperty(String key, Object value) {
		this.properties.setProperty(key, value);
	}

	public void setProperties(AdhocProperties properties) {
		this.properties = properties;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (!(obj instanceof AdhocReport))
			return false;

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
		if (!(highlightDetailEvenRows == null ? object.getHighlightDetailEvenRows() == null
				: highlightDetailEvenRows.equals(object.getHighlightDetailEvenRows()))) {
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

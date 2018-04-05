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

package net.sf.dynamicreports.design.transformation;

import java.util.HashMap;
import java.util.Map;

import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;
import net.sf.dynamicreports.report.definition.column.DRIColumn;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
class ColumnGrid {
	private DRDesignList list;
	private Map<DRIColumn<?>, DRDesignList> columnsLists;
	private boolean isEmpty;

	public ColumnGrid() {
		columnsLists = new HashMap<DRIColumn<?>, DRDesignList>();
		isEmpty = true;
	}

	public void addList(DRIColumn<?> column, DRDesignList list) {
		columnsLists.put(column, list);
	}

	public void addComponent(DRIColumn<?> column, DRDesignComponent component) {
		if (columnsLists.containsKey(column)) {
			columnsLists.get(column).addComponent(component);
		}
	}

	public void addComponent(DRIColumn<?> column, HorizontalCellComponentAlignment horizontalAlignment, VerticalCellComponentAlignment verticalAlignment,
			DRDesignComponent component) {
		if (columnsLists.containsKey(column)) {
			columnsLists.get(column).addComponent(horizontalAlignment, verticalAlignment, component);
		}
	}

	public void setList(DRDesignList list) {
		this.list = list;
	}

	public DRDesignList getList() {
		return list;
	}

	public boolean isEmpty() {
		for (DRDesignList list : columnsLists.values()) {
			if (!list.isEmpty()) {
				return false;
			}
		}
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
}

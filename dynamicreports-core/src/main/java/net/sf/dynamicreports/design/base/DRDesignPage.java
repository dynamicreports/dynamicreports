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

package net.sf.dynamicreports.design.base;

import net.sf.dynamicreports.design.definition.DRIDesignPage;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.PageOrientation;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
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

	@Override
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public PageOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(PageOrientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public DRDesignMargin getMargin() {
		return margin;
	}

	public void setMargin(DRDesignMargin margin) {
		this.margin = margin;
	}

	@Override
	public int getColumnsPerPage() {
		return columnsPerPage;
	}

	public void setColumnsPerPage(int columnsPerPage) {
		this.columnsPerPage = columnsPerPage;
	}

	@Override
	public int getColumnSpace() {
		return columnSpace;
	}

	public void setColumnSpace(int columnSpace) {
		this.columnSpace = columnSpace;
	}

	@Override
	public int getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(int columnWidth) {
		this.columnWidth = columnWidth;
	}
}

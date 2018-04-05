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

package net.sf.dynamicreports.report.base;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.definition.DRIPage;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRPage implements DRIPage {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Integer width;
	private Integer height;
	private PageOrientation orientation;
	private DRMargin margin;
	private Integer columnsPerPage;
	private Integer columnSpace;
	private Boolean ignorePageWidth;

	public void setPageFormat(PageType pageType, PageOrientation orientation) {
		Validate.notNull(pageType, "pageType must not be null");
		setPageFormat(pageType.getWidth(), pageType.getHeight(), orientation);
	}

	public void setPageFormat(Integer width, Integer height, PageOrientation orientation) {
		Validate.isTrue(width >= 0, "width must be >= 0");
		Validate.isTrue(height >= 0, "height must be >= 0");
		Validate.notNull(orientation, "orientation must not be null");
		if (orientation.equals(PageOrientation.PORTRAIT)) {
			setWidth(width);
			setHeight(height);
		} else {
			setWidth(height);
			setHeight(width);
		}
		setOrientation(orientation);
	}

	/**
	 * Returns the page width.
	 *
	 * @return the page width >= 0
	 */
	@Override
	public Integer getWidth() {
		return width;
	}

	/**
	 * Sets the page width.
	 * 
	 * @see net.sf.dynamicreports.report.builder.Units
	 *
	 * @param width
	 *          the page width >= 0
	 * @exception IllegalArgumentException
	 *              if <code>width</code> is < 0
	 */
	public void setWidth(Integer width) {
		if (width != null) {
			Validate.isTrue(width >= 0, "width must be >= 0");
		}
		this.width = width;
	}

	/**
	 * Returns the page height.
	 *
	 * @return the page height >= 0
	 */
	@Override
	public Integer getHeight() {
		return height;
	}

	/**
	 * Sets the page height.
	 * 
	 * @see net.sf.dynamicreports.report.builder.Units
	 *
	 * @param height
	 *          the page height >= 0
	 * @exception IllegalArgumentException
	 *              if <code>height</code> is < 0
	 */
	public void setHeight(Integer height) {
		if (height != null) {
			Validate.isTrue(height >= 0, "height must be >= 0");
		}
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
	public DRMargin getMargin() {
		return margin;
	}

	public void setMargin(DRMargin margin) {
		this.margin = margin;
	}

	@Override
	public Integer getColumnsPerPage() {
		return columnsPerPage;
	}

	public void setColumnsPerPage(Integer columnsPerPage) {
		if (columnsPerPage != null) {
			Validate.isTrue(columnsPerPage >= 1, "columnsPerPage must be >= 1");
		}
		this.columnsPerPage = columnsPerPage;
	}

	@Override
	public Integer getColumnSpace() {
		return columnSpace;
	}

	public void setColumnSpace(Integer columnSpace) {
		if (columnSpace != null) {
			Validate.isTrue(columnSpace >= 0, "columnSpace must be >= 0");
		}
		this.columnSpace = columnSpace;
	}

	@Override
	public Boolean getIgnorePageWidth() {
		return ignorePageWidth;
	}

	public void setIgnorePageWidth(Boolean ignorePageWidth) {
		this.ignorePageWidth = ignorePageWidth;
	}
}

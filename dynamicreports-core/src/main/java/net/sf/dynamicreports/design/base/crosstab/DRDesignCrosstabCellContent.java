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

package net.sf.dynamicreports.design.base.crosstab;

import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabCellContent;
import net.sf.dynamicreports.design.definition.style.DRIDesignStyle;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignCrosstabCellContent implements DRIDesignCrosstabCellContent {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private int width;
	private int height;
	private DRDesignList list;
	private DRDesignComponent component;
	private DRIDesignStyle style;

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

	public void setList(DRDesignList list) {
		this.list = list;
	}

	public DRDesignList getList() {
		return list;
	}

	@Override
	public DRDesignComponent getComponent() {
		return component;
	}

	public void setComponent(DRDesignComponent component) {
		this.component = component;
	}

	@Override
	public DRIDesignStyle getStyle() {
		return style;
	}

	public void setStyle(DRIDesignStyle style) {
		this.style = style;
	}
}

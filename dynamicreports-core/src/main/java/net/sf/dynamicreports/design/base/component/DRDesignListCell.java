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

package net.sf.dynamicreports.design.base.component;

import java.io.Serializable;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignListCell implements Serializable {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private HorizontalCellComponentAlignment horizontalAlignment;
	private VerticalCellComponentAlignment verticalAlignment;
	private DRDesignComponent component;
	private Integer x;
	private Integer y;
	private Integer width;
	private Integer height;

	protected DRDesignListCell(DRDesignComponent component) {
		this(null, null, component);
	}

	protected DRDesignListCell(HorizontalCellComponentAlignment horizontalAlignment, VerticalCellComponentAlignment verticalAlignment,
			DRDesignComponent component) {
		this.horizontalAlignment = horizontalAlignment;
		this.verticalAlignment = verticalAlignment;
		this.component = component;
	}

	public HorizontalCellComponentAlignment getHorizontalAlignment() {
		return horizontalAlignment;
	}

	public void setHorizontalAlignment(HorizontalCellComponentAlignment horizontalAlignment) {
		this.horizontalAlignment = horizontalAlignment;
	}

	public VerticalCellComponentAlignment getVerticalAlignment() {
		return verticalAlignment;
	}

	public void setVerticalAlignment(VerticalCellComponentAlignment verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}

	public DRDesignComponent getComponent() {
		return component;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
}

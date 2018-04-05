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

package net.sf.dynamicreports.report.base.component;

import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.component.DRIPageXofY;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRPageXofY extends DRFormatField implements DRIPageXofY {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Integer pageXWidth;
	private ComponentDimensionType pageXWidthType;
	private Integer pageYWidth;
	private ComponentDimensionType pageYWidthType;

	@Override
	public Integer getPageXWidth() {
		return pageXWidth;
	}

	public void setPageXWidth(Integer pageXWidth) {
		this.pageXWidth = pageXWidth;
	}

	@Override
	public ComponentDimensionType getPageXWidthType() {
		return pageXWidthType;
	}

	public void setPageXWidthType(ComponentDimensionType pageXWidthType) {
		this.pageXWidthType = pageXWidthType;
	}

	@Override
	public Integer getPageYWidth() {
		return pageYWidth;
	}

	public void setPageYWidth(Integer pageYWidth) {
		this.pageYWidth = pageYWidth;
	}

	@Override
	public ComponentDimensionType getPageYWidthType() {
		return pageYWidthType;
	}

	public void setPageYWidthType(ComponentDimensionType pageYWidthType) {
		this.pageYWidthType = pageYWidthType;
	}

}

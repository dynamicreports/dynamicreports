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
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.StretchType;
import net.sf.dynamicreports.report.definition.DRIGroup;
import net.sf.dynamicreports.report.definition.component.DRIDimensionComponent;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class DRDimensionComponent extends DRComponent implements DRIDimensionComponent {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Integer width;
	private Integer height;
	private ComponentDimensionType widthType;
	private ComponentDimensionType heightType;
	private ComponentPositionType positionType;
	private StretchType stretchType;
	private Boolean printInFirstWholeBand;
	private Boolean printWhenDetailOverflows;
	private DRIGroup printWhenGroupChanges;

	@Override
	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		if (width != null) {
			Validate.isTrue(width >= 0, "width must be >= 0");
		}
		this.width = width;
	}

	@Override
	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		if (height != null) {
			Validate.isTrue(height >= 0, "height must be >= 0");
		}
		this.height = height;
	}

	@Override
	public ComponentDimensionType getWidthType() {
		return widthType;
	}

	public void setWidthType(ComponentDimensionType widthType) {
		this.widthType = widthType;
	}

	@Override
	public ComponentDimensionType getHeightType() {
		return heightType;
	}

	public void setHeightType(ComponentDimensionType heightType) {
		this.heightType = heightType;
	}

	@Override
	public ComponentPositionType getPositionType() {
		return positionType;
	}

	public void setPositionType(ComponentPositionType positionType) {
		this.positionType = positionType;
	}

	@Override
	public StretchType getStretchType() {
		return stretchType;
	}

	public void setStretchType(StretchType stretchType) {
		this.stretchType = stretchType;
	}

	@Override
	public Boolean getPrintInFirstWholeBand() {
		return printInFirstWholeBand;
	}

	public void setPrintInFirstWholeBand(Boolean printInFirstWholeBand) {
		this.printInFirstWholeBand = printInFirstWholeBand;
	}

	@Override
	public Boolean getPrintWhenDetailOverflows() {
		return printWhenDetailOverflows;
	}

	public void setPrintWhenDetailOverflows(Boolean printWhenDetailOverflows) {
		this.printWhenDetailOverflows = printWhenDetailOverflows;
	}

	@Override
	public DRIGroup getPrintWhenGroupChanges() {
		return printWhenGroupChanges;
	}

	public void setPrintWhenGroupChanges(DRIGroup printWhenGroupChanges) {
		this.printWhenGroupChanges = printWhenGroupChanges;
	}
}

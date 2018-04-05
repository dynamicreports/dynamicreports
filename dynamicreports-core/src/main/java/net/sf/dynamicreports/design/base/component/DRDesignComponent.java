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

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.design.base.DRDesignTableOfContentsHeading;
import net.sf.dynamicreports.design.base.style.DRDesignStyle;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.component.DRIDesignComponent;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignPropertyExpression;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.StretchType;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class DRDesignComponent implements DRIDesignComponent {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private String uniqueName;
	private DRDesignStyle style;
	private Integer x;
	private Integer y;
	private Integer width;
	private Integer height;
	private DRIDesignExpression printWhenExpression;
	private boolean isRemoveLineWhenBlank;
	private List<DRIDesignPropertyExpression> propertyExpressions;
	private ComponentPositionType positionType;
	private StretchType stretchType;
	private boolean printInFirstWholeBand;
	private boolean printWhenDetailOverflows;
	private DRIDesignGroup printWhenGroupChanges;
	private DRDesignTableOfContentsHeading tableOfContentsHeading;

	protected DRDesignComponent(String name) {
		this.name = name;
		this.uniqueName = name;
		init();
	}

	protected void init() {
		propertyExpressions = new ArrayList<DRIDesignPropertyExpression>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	@Override
	public DRDesignStyle getStyle() {
		return style;
	}

	public void setStyle(DRDesignStyle style) {
		this.style = style;
	}

	@Override
	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	@Override
	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	@Override
	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	@Override
	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	@Override
	public DRIDesignExpression getPrintWhenExpression() {
		return printWhenExpression;
	}

	public void setPrintWhenExpression(DRIDesignExpression printWhenExpression) {
		this.printWhenExpression = printWhenExpression;
	}

	@Override
	public boolean isRemoveLineWhenBlank() {
		return isRemoveLineWhenBlank;
	}

	public void setRemoveLineWhenBlank(boolean isRemoveLineWhenBlank) {
		this.isRemoveLineWhenBlank = isRemoveLineWhenBlank;
	}

	@Override
	public List<DRIDesignPropertyExpression> getPropertyExpressions() {
		return propertyExpressions;
	}

	public void setPropertyExpressions(List<DRIDesignPropertyExpression> propertyExpressions) {
		this.propertyExpressions = propertyExpressions;
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
	public boolean isPrintInFirstWholeBand() {
		return printInFirstWholeBand;
	}

	public void setPrintInFirstWholeBand(boolean printInFirstWholeBand) {
		this.printInFirstWholeBand = printInFirstWholeBand;
	}

	@Override
	public boolean isPrintWhenDetailOverflows() {
		return printWhenDetailOverflows;
	}

	public void setPrintWhenDetailOverflows(boolean printWhenDetailOverflows) {
		this.printWhenDetailOverflows = printWhenDetailOverflows;
	}

	@Override
	public DRIDesignGroup getPrintWhenGroupChanges() {
		return printWhenGroupChanges;
	}

	public void setPrintWhenGroupChanges(DRIDesignGroup printWhenGroupChanges) {
		this.printWhenGroupChanges = printWhenGroupChanges;
	}

	@Override
	public DRDesignTableOfContentsHeading getTableOfContentsHeading() {
		return tableOfContentsHeading;
	}

	public void setTableOfContentsHeading(DRDesignTableOfContentsHeading tableOfContentsHeading) {
		this.tableOfContentsHeading = tableOfContentsHeading;
	}

}

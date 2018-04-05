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

package net.sf.dynamicreports.report.base.column;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.column.DRIColumn;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRColumn<T extends DRIComponent> implements DRIColumn<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private T component;

	private DRIExpression<?> titleExpression;
	private DRIReportStyle titleStyle;
	private Integer titleHeight;
	private ComponentDimensionType titleHeightType;
	private Integer titleRows;
	private Boolean titleStretchWithOverflow;
	private List<DRIPropertyExpression> titlePropertyExpressions;

	protected DRColumn() {
		this.name = ReportUtils.generateUniqueName("column");
		titlePropertyExpressions = new ArrayList<DRIPropertyExpression>();
	}

	public DRColumn(T component) {
		Validate.notNull(component, "component must not be null");
		this.name = ReportUtils.generateUniqueName("column");
		this.component = component;
		titlePropertyExpressions = new ArrayList<DRIPropertyExpression>();
	}

	@Override
	public T getComponent() {
		return component;
	}

	@Override
	public DRIExpression<?> getTitleExpression() {
		return titleExpression;
	}

	public void setTitleExpression(DRIExpression<?> titleExpression) {
		this.titleExpression = titleExpression;
	}

	@Override
	public DRIReportStyle getTitleStyle() {
		return titleStyle;
	}

	public void setTitleStyle(DRIReportStyle titleStyle) {
		this.titleStyle = titleStyle;
	}

	@Override
	public Integer getTitleHeight() {
		return titleHeight;
	}

	public void setTitleHeight(Integer titleHeight) {
		if (titleHeight != null) {
			Validate.isTrue(titleHeight >= 0, "titleHeight must be >= 0");
		}
		this.titleHeight = titleHeight;
	}

	@Override
	public ComponentDimensionType getTitleHeightType() {
		return titleHeightType;
	}

	public void setTitleHeightType(ComponentDimensionType titleHeightType) {
		this.titleHeightType = titleHeightType;
	}

	@Override
	public Integer getTitleRows() {
		return titleRows;
	}

	public void setTitleRows(Integer titleRows) {
		if (titleRows != null) {
			Validate.isTrue(titleRows >= 0, "titleRows must be >= 0");
		}
		this.titleRows = titleRows;
	}

	@Override
	public Boolean getTitleStretchWithOverflow() {
		return titleStretchWithOverflow;
	}

	public void setTitleStretchWithOverflow(Boolean titleStretchWithOverflow) {
		this.titleStretchWithOverflow = titleStretchWithOverflow;
	}

	@Override
	public List<DRIPropertyExpression> getTitlePropertyExpressions() {
		return titlePropertyExpressions;
	}

	public void addTitlePropertyExpression(DRIPropertyExpression propertyExpression) {
		Validate.notNull(propertyExpression, "propertyExpression must not be null");
		this.titlePropertyExpressions.add(propertyExpression);
	}

	public void setTitlePropertyExpressions(List<DRIPropertyExpression> titlePropertyExpressions) {
		this.titlePropertyExpressions = titlePropertyExpressions;
	}

	@Override
	public String getName() {
		return name;
	}
}

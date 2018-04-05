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

import net.sf.dynamicreports.report.base.column.DRColumn;
import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.constant.SubtotalPosition;
import net.sf.dynamicreports.report.definition.DRISubtotal;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRSubtotal<T> implements DRISubtotal<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRColumn<?> showInColumn;
	private DRTextField<T> valueField;
	private SubtotalPosition position;
	private DRGroup group;

	private DRIExpression<?> labelExpression;
	private DRIReportStyle labelStyle;
	private Position labelPosition;
	private Integer labelWidth;
	private ComponentDimensionType labelWidthType;

	public DRSubtotal(DRColumn<?> showInColumn) {
		setShowInColumn(showInColumn);
		init();
	}

	private void init() {
		valueField = new DRTextField<T>();
	}

	public void setShowInColumn(DRColumn<?> showInColumn) {
		Validate.notNull(showInColumn, "showInColumn must not be null");
		this.showInColumn = showInColumn;
	}

	@Override
	public DRColumn<?> getShowInColumn() {
		return showInColumn;
	}

	@Override
	public DRTextField<T> getValueField() {
		return valueField;
	}

	@Override
	public DRIExpression<?> getLabelExpression() {
		return labelExpression;
	}

	public void setLabelExpression(DRIExpression<?> labelExpression) {
		this.labelExpression = labelExpression;
	}

	@Override
	public DRIReportStyle getLabelStyle() {
		return labelStyle;
	}

	public void setLabelStyle(DRIReportStyle labelStyle) {
		this.labelStyle = labelStyle;
	}

	@Override
	public Position getLabelPosition() {
		return labelPosition;
	}

	public void setLabelPosition(Position labelPosition) {
		this.labelPosition = labelPosition;
	}

	@Override
	public Integer getLabelWidth() {
		return labelWidth;
	}

	public void setLabelWidth(Integer labelWidth) {
		this.labelWidth = labelWidth;
	}

	@Override
	public ComponentDimensionType getLabelWidthType() {
		return labelWidthType;
	}

	public void setLabelWidthType(ComponentDimensionType labelWidthType) {
		this.labelWidthType = labelWidthType;
	}

	@Override
	public SubtotalPosition getPosition() {
		return position;
	}

	public void setPosition(SubtotalPosition position) {
		Validate.notNull(position, "position must not be null");
		this.position = position;
	}

	@Override
	public DRGroup getGroup() {
		return group;
	}

	public void setGroup(DRGroup group) {
		this.group = group;
	}

	@Override
	public String getName() {
		return valueField.getValueExpression().getName();
	}

	@Override
	public Class<? super T> getValueClass() {
		return valueField.getValueExpression().getValueClass();
	}
}

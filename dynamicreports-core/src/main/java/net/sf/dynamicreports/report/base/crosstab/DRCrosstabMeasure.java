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

package net.sf.dynamicreports.report.base.crosstab;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.base.DRHyperLink;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabCellStyle;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabMeasure;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRCrosstabMeasure<T> implements DRICrosstabMeasure<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private DRIExpression<?> expression;
	private DRIDataType<? super T, T> dataType;
	private String pattern;
	private HorizontalTextAlignment horizontalTextAlignment;
	private DRIValueFormatter<?, ? super T> valueFormatter;
	private Boolean stretchWithOverflow;
	private DRHyperLink hyperLink;
	private List<DRIPropertyExpression> propertyExpressions;
	private List<DRICrosstabCellStyle> styles;
	private DRIExpression<?> titleExpression;
	private DRIReportStyle titleStyle;

	public DRCrosstabMeasure(DRIExpression<?> expression) {
		Validate.notNull(expression, "expression must not be null");
		this.expression = expression;
		this.name = ReportUtils.generateUniqueName("crosstabMeasure");
		this.styles = new ArrayList<DRICrosstabCellStyle>();
		propertyExpressions = new ArrayList<DRIPropertyExpression>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public DRIExpression<?> getExpression() {
		return expression;
	}

	@Override
	public DRIDataType<? super T, T> getDataType() {
		return dataType;
	}

	public void setDataType(DRIDataType<? super T, T> dataType) {
		this.dataType = dataType;
	}

	@Override
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public HorizontalTextAlignment getHorizontalTextAlignment() {
		return horizontalTextAlignment;
	}

	public void setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
		this.horizontalTextAlignment = horizontalTextAlignment;
	}

	@Override
	public DRIValueFormatter<?, ? super T> getValueFormatter() {
		return valueFormatter;
	}

	public void setValueFormatter(DRIValueFormatter<?, ? super T> valueFormatter) {
		this.valueFormatter = valueFormatter;
	}

	@Override
	public Boolean getStretchWithOverflow() {
		return stretchWithOverflow;
	}

	public void setStretchWithOverflow(Boolean stretchWithOverflow) {
		this.stretchWithOverflow = stretchWithOverflow;
	}

	@Override
	public DRHyperLink getHyperLink() {
		return hyperLink;
	}

	public void setHyperLink(DRHyperLink hyperLink) {
		this.hyperLink = hyperLink;
	}

	@Override
	public List<DRIPropertyExpression> getPropertyExpressions() {
		return propertyExpressions;
	}

	public void addPropertyExpression(DRIPropertyExpression propertyExpression) {
		Validate.notNull(propertyExpression, "propertyExpression must not be null");
		this.propertyExpressions.add(propertyExpression);
	}

	public void setPropertyExpressions(List<DRIPropertyExpression> propertyExpressions) {
		this.propertyExpressions = propertyExpressions;
	}

	@Override
	public List<DRICrosstabCellStyle> getStyles() {
		return styles;
	}

	public void setStyle(List<DRICrosstabCellStyle> styles) {
		this.styles = styles;
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
}

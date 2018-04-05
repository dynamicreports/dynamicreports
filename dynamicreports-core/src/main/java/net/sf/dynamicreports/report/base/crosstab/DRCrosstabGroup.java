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
import java.util.Comparator;
import java.util.List;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.base.DRHyperLink;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.CrosstabTotalPosition;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.OrderType;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabGroup;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class DRCrosstabGroup<T> implements DRICrosstabGroup<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private String headerPattern;
	private HorizontalTextAlignment headerHorizontalTextAlignment;
	private DRIValueFormatter<?, ? super T> headerValueFormatter;
	private Boolean headerStretchWithOverflow;
	private DRHyperLink headerHyperLink;
	private DRIReportStyle headerStyle;
	private List<DRIPropertyExpression> headerPropertyExpressions;
	private Boolean showTotal;
	private CrosstabTotalPosition totalPosition;
	private DRIExpression<?> totalHeaderExpression;
	private Boolean totalHeaderStretchWithOverflow;
	private DRIReportStyle totalHeaderStyle;
	private List<DRIPropertyExpression> totalHeaderPropertyExpressions;
	private DRIExpression<T> expression;
	private DRIDataType<? super T, T> dataType;
	private DRIExpression<? extends Comparable<?>> orderByExpression;
	private OrderType orderType;
	private DRIExpression<? extends Comparator<?>> comparatorExpression;

	public DRCrosstabGroup() {
		this.name = ReportUtils.generateUniqueName("crosstabGroup");
		headerPropertyExpressions = new ArrayList<DRIPropertyExpression>();
		totalHeaderPropertyExpressions = new ArrayList<DRIPropertyExpression>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getHeaderPattern() {
		return headerPattern;
	}

	public void setHeaderPattern(String headerPattern) {
		this.headerPattern = headerPattern;
	}

	@Override
	public HorizontalTextAlignment getHeaderHorizontalTextAlignment() {
		return headerHorizontalTextAlignment;
	}

	public void setHeaderHorizontalTextAlignment(HorizontalTextAlignment headerHorizontalTextAlignment) {
		this.headerHorizontalTextAlignment = headerHorizontalTextAlignment;
	}

	@Override
	public DRIValueFormatter<?, ? super T> getHeaderValueFormatter() {
		return headerValueFormatter;
	}

	public void setHeaderValueFormatter(DRIValueFormatter<?, ? super T> headerValueFormatter) {
		this.headerValueFormatter = headerValueFormatter;
	}

	@Override
	public Boolean getHeaderStretchWithOverflow() {
		return headerStretchWithOverflow;
	}

	public void setHeaderStretchWithOverflow(Boolean headerStretchWithOverflow) {
		this.headerStretchWithOverflow = headerStretchWithOverflow;
	}

	@Override
	public DRHyperLink getHeaderHyperLink() {
		return headerHyperLink;
	}

	public void setHeaderHyperLink(DRHyperLink headerHyperLink) {
		this.headerHyperLink = headerHyperLink;
	}

	@Override
	public DRIReportStyle getHeaderStyle() {
		return headerStyle;
	}

	public void setHeaderStyle(DRIReportStyle headerStyle) {
		this.headerStyle = headerStyle;
	}

	@Override
	public List<DRIPropertyExpression> getHeaderPropertyExpressions() {
		return headerPropertyExpressions;
	}

	public void addHeaderPropertyExpression(DRIPropertyExpression headerPropertyExpression) {
		Validate.notNull(headerPropertyExpression, "headerPropertyExpression must not be null");
		this.headerPropertyExpressions.add(headerPropertyExpression);
	}

	public void setHeaderPropertyExpressions(List<DRIPropertyExpression> headerPropertyExpressions) {
		this.headerPropertyExpressions = headerPropertyExpressions;
	}

	@Override
	public Boolean getShowTotal() {
		return showTotal;
	}

	public void setShowTotal(Boolean showTotal) {
		this.showTotal = showTotal;
	}

	@Override
	public CrosstabTotalPosition getTotalPosition() {
		return totalPosition;
	}

	public void setTotalPosition(CrosstabTotalPosition totalPosition) {
		this.totalPosition = totalPosition;
	}

	@Override
	public DRIExpression<?> getTotalHeaderExpression() {
		return totalHeaderExpression;
	}

	public void setTotalHeaderExpression(DRIExpression<?> totalHeaderExpression) {
		this.totalHeaderExpression = totalHeaderExpression;
	}

	@Override
	public Boolean getTotalHeaderStretchWithOverflow() {
		return totalHeaderStretchWithOverflow;
	}

	public void setTotalHeaderStretchWithOverflow(Boolean totalHeaderStretchWithOverflow) {
		this.totalHeaderStretchWithOverflow = totalHeaderStretchWithOverflow;
	}

	@Override
	public DRIReportStyle getTotalHeaderStyle() {
		return totalHeaderStyle;
	}

	public void setTotalHeaderStyle(DRIReportStyle totalHeaderStyle) {
		this.totalHeaderStyle = totalHeaderStyle;
	}

	@Override
	public List<DRIPropertyExpression> getTotalHeaderPropertyExpressions() {
		return totalHeaderPropertyExpressions;
	}

	public void addTotalHeaderPropertyExpression(DRIPropertyExpression totalHeaderPropertyExpression) {
		Validate.notNull(totalHeaderPropertyExpression, "totalHeaderPropertyExpression must not be null");
		this.totalHeaderPropertyExpressions.add(totalHeaderPropertyExpression);
	}

	public void setTotalHeaderPropertyExpressions(List<DRIPropertyExpression> totalHeaderPropertyExpressions) {
		this.totalHeaderPropertyExpressions = totalHeaderPropertyExpressions;
	}

	@Override
	public DRIExpression<T> getExpression() {
		return expression;
	}

	public void setExpression(DRIExpression<T> expression) {
		Validate.notNull(expression, "expression must not be null");
		this.expression = expression;
	}

	@Override
	public DRIDataType<? super T, T> getDataType() {
		return dataType;
	}

	public void setDataType(DRIDataType<? super T, T> dataType) {
		this.dataType = dataType;
	}

	@Override
	public DRIExpression<? extends Comparable<?>> getOrderByExpression() {
		return orderByExpression;
	}

	public void setOrderByExpression(DRIExpression<? extends Comparable<?>> orderByExpression) {
		this.orderByExpression = orderByExpression;
	}

	@Override
	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	@Override
	public DRIExpression<? extends Comparator<?>> getComparatorExpression() {
		return comparatorExpression;
	}

	public void setComparatorExpression(DRIExpression<? extends Comparator<?>> comparatorExpression) {
		this.comparatorExpression = comparatorExpression;
	}

	@Override
	public Class<? super T> getValueClass() {
		return getExpression().getValueClass();
	}
}

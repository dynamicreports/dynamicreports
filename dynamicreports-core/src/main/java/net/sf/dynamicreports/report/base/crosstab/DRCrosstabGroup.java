/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import org.apache.commons.lang3.Validate;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.base.DRHyperLink;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.CrosstabTotalPosition;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.OrderType;
import net.sf.dynamicreports.report.constant.TextAdjust;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabGroup;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;

/**
 * <p>Abstract DRCrosstabGroup class.</p>
 *
 * @author Ricardo Mariaca, Jan Moxter
 * 
 */
public abstract class DRCrosstabGroup<T> implements DRICrosstabGroup<T> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private final String name;
    private String headerPattern;
    private HorizontalTextAlignment headerHorizontalTextAlignment;
    private DRIValueFormatter<?, ? super T> headerValueFormatter;
    private Boolean headerStretchWithOverflow;
    private TextAdjust headerTextAdjust;
    private DRHyperLink headerHyperLink;
    private DRIReportStyle headerStyle;
    private List<DRIPropertyExpression> headerPropertyExpressions;
    private Boolean showTotal;
    private CrosstabTotalPosition totalPosition;
    private DRIExpression<?> totalHeaderExpression;
    private Boolean totalHeaderStretchWithOverflow;
    private TextAdjust totalHeaderTextAdjust;
    private DRIReportStyle totalHeaderStyle;
    private List<DRIPropertyExpression> totalHeaderPropertyExpressions;
    private DRIExpression<T> expression;
    private DRIDataType<? super T, T> dataType;
    private DRIExpression<? extends Comparable<?>> orderByExpression;
    private OrderType orderType;
    private DRIExpression<? extends Comparator<?>> comparatorExpression;

    /**
     * <p>Constructor for DRCrosstabGroup.</p>
     */
    public DRCrosstabGroup() {
        this.name = ReportUtils.generateUniqueName("crosstabGroup");
        headerPropertyExpressions = new ArrayList<>();
        totalHeaderPropertyExpressions = new ArrayList<>();
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return name;
    }

    /** {@inheritDoc} */
    @Override
    public String getHeaderPattern() {
        return headerPattern;
    }

    /**
     * <p>Setter for the field <code>headerPattern</code>.</p>
     *
     * @param headerPattern a {@link java.lang.String} object.
     */
    public void setHeaderPattern(final String headerPattern) {
        this.headerPattern = headerPattern;
    }

    /** {@inheritDoc} */
    @Override
    public HorizontalTextAlignment getHeaderHorizontalTextAlignment() {
        return headerHorizontalTextAlignment;
    }

    /**
     * <p>Setter for the field <code>headerHorizontalTextAlignment</code>.</p>
     *
     * @param headerHorizontalTextAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     */
    public void setHeaderHorizontalTextAlignment(final HorizontalTextAlignment headerHorizontalTextAlignment) {
        this.headerHorizontalTextAlignment = headerHorizontalTextAlignment;
    }

    /** {@inheritDoc} */
    @Override
    public DRIValueFormatter<?, ? super T> getHeaderValueFormatter() {
        return headerValueFormatter;
    }

    /**
     * <p>Setter for the field <code>headerValueFormatter</code>.</p>
     *
     * @param headerValueFormatter a {@link net.sf.dynamicreports.report.definition.expression.DRIValueFormatter} object.
     */
    public void setHeaderValueFormatter(final DRIValueFormatter<?, ? super T> headerValueFormatter) {
        this.headerValueFormatter = headerValueFormatter;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getHeaderStretchWithOverflow() {
        return headerStretchWithOverflow;
    }

    /**
     * <p>Setter for the field <code>headerStretchWithOverflow</code>.</p>
     *
     * @param headerStretchWithOverflow a {@link java.lang.Boolean} object.
     * @deprecated replaced by {@link #setHeaderTextAdjust(TextAdjust)}
     */
    @Deprecated
    public void setHeaderStretchWithOverflow(final Boolean headerStretchWithOverflow) {
        this.headerStretchWithOverflow = headerStretchWithOverflow;
    }

    /** {@inheritDoc} */
    @Override
    public TextAdjust getHeaderTextAdjust() {
        return this.headerTextAdjust;
    }

    /**
     * <p>Setter for the field <code>setHeaderTextAdjust</code>.</p>
     *
     * @param headerTextAdjust a {@link net.sf.dynamicreports.report.constant.TextAdjust} object.
     */
    public void setHeaderTextAdjust(final TextAdjust headerTextAdjust) {
        this.headerTextAdjust = headerTextAdjust;
    }

    /** {@inheritDoc} */
    @Override
    public DRHyperLink getHeaderHyperLink() {
        return headerHyperLink;
    }

    /**
     * <p>Setter for the field <code>headerHyperLink</code>.</p>
     *
     * @param headerHyperLink a {@link net.sf.dynamicreports.report.base.DRHyperLink} object.
     */
    public void setHeaderHyperLink(final DRHyperLink headerHyperLink) {
        this.headerHyperLink = headerHyperLink;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getHeaderStyle() {
        return headerStyle;
    }

    /**
     * <p>Setter for the field <code>headerStyle</code>.</p>
     *
     * @param headerStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setHeaderStyle(final DRIReportStyle headerStyle) {
        this.headerStyle = headerStyle;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIPropertyExpression> getHeaderPropertyExpressions() {
        return headerPropertyExpressions;
    }

    /**
     * <p>Setter for the field <code>headerPropertyExpressions</code>.</p>
     *
     * @param headerPropertyExpressions a {@link java.util.List} object.
     */
    public void setHeaderPropertyExpressions(final List<DRIPropertyExpression> headerPropertyExpressions) {
        this.headerPropertyExpressions = headerPropertyExpressions;
    }

    /**
     * <p>addHeaderPropertyExpression.</p>
     *
     * @param headerPropertyExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression} object.
     */
    public void addHeaderPropertyExpression(final DRIPropertyExpression headerPropertyExpression) {
        Validate.notNull(headerPropertyExpression, "headerPropertyExpression must not be null");
        this.headerPropertyExpressions.add(headerPropertyExpression);
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getShowTotal() {
        return showTotal;
    }

    /**
     * <p>Setter for the field <code>showTotal</code>.</p>
     *
     * @param showTotal a {@link java.lang.Boolean} object.
     */
    public void setShowTotal(final Boolean showTotal) {
        this.showTotal = showTotal;
    }

    /** {@inheritDoc} */
    @Override
    public CrosstabTotalPosition getTotalPosition() {
        return totalPosition;
    }

    /**
     * <p>Setter for the field <code>totalPosition</code>.</p>
     *
     * @param totalPosition a {@link net.sf.dynamicreports.report.constant.CrosstabTotalPosition} object.
     */
    public void setTotalPosition(final CrosstabTotalPosition totalPosition) {
        this.totalPosition = totalPosition;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getTotalHeaderExpression() {
        return totalHeaderExpression;
    }

    /**
     * <p>Setter for the field <code>totalHeaderExpression</code>.</p>
     *
     * @param totalHeaderExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setTotalHeaderExpression(final DRIExpression<?> totalHeaderExpression) {
        this.totalHeaderExpression = totalHeaderExpression;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getTotalHeaderStretchWithOverflow() {
        return totalHeaderStretchWithOverflow;
    }

    /**
     * <p>Setter for the field <code>totalHeaderStretchWithOverflow</code>.</p>
     *
     * @param totalHeaderStretchWithOverflow a {@link java.lang.Boolean} object.
     * @deprecated replaced by {@link #setTotalHeaderTextAdjust(TextAdjust)}
     */
    @Deprecated
    public void setTotalHeaderStretchWithOverflow(final Boolean totalHeaderStretchWithOverflow) {
        this.totalHeaderStretchWithOverflow = totalHeaderStretchWithOverflow;
    }

    /** {@inheritDoc} */
    @Override
    public TextAdjust getTotalHeaderTextAdjust() {
        return this.totalHeaderTextAdjust;
    }

    /**
     * <p>Setter for the field <code>totalHeaderTextAdjust</code>.</p>
     *
     * @param headerTextAdjust a {@link net.sf.dynamicreports.report.constant.TextAdjust} object.
     */
    public void setTotalHeaderTextAdjust(final TextAdjust headerTextAdjust) {
        this.totalHeaderTextAdjust = headerTextAdjust;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getTotalHeaderStyle() {
        return totalHeaderStyle;
    }

    /**
     * <p>Setter for the field <code>totalHeaderStyle</code>.</p>
     *
     * @param totalHeaderStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setTotalHeaderStyle(final DRIReportStyle totalHeaderStyle) {
        this.totalHeaderStyle = totalHeaderStyle;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIPropertyExpression> getTotalHeaderPropertyExpressions() {
        return totalHeaderPropertyExpressions;
    }

    /**
     * <p>Setter for the field <code>totalHeaderPropertyExpressions</code>.</p>
     *
     * @param totalHeaderPropertyExpressions a {@link java.util.List} object.
     */
    public void setTotalHeaderPropertyExpressions(final List<DRIPropertyExpression> totalHeaderPropertyExpressions) {
        this.totalHeaderPropertyExpressions = totalHeaderPropertyExpressions;
    }

    /**
     * <p>addTotalHeaderPropertyExpression.</p>
     *
     * @param totalHeaderPropertyExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression} object.
     */
    public void addTotalHeaderPropertyExpression(final DRIPropertyExpression totalHeaderPropertyExpression) {
        Validate.notNull(totalHeaderPropertyExpression, "totalHeaderPropertyExpression must not be null");
        this.totalHeaderPropertyExpressions.add(totalHeaderPropertyExpression);
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<T> getExpression() {
        return expression;
    }

    /**
     * <p>Setter for the field <code>expression</code>.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setExpression(final DRIExpression<T> expression) {
        Validate.notNull(expression, "expression must not be null");
        this.expression = expression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDataType<? super T, T> getDataType() {
        return dataType;
    }

    /**
     * <p>Setter for the field <code>dataType</code>.</p>
     *
     * @param dataType a {@link net.sf.dynamicreports.report.definition.datatype.DRIDataType} object.
     */
    public void setDataType(final DRIDataType<? super T, T> dataType) {
        this.dataType = dataType;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Comparable<?>> getOrderByExpression() {
        return orderByExpression;
    }

    /**
     * <p>Setter for the field <code>orderByExpression</code>.</p>
     *
     * @param orderByExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setOrderByExpression(final DRIExpression<? extends Comparable<?>> orderByExpression) {
        this.orderByExpression = orderByExpression;
    }

    /** {@inheritDoc} */
    @Override
    public OrderType getOrderType() {
        return orderType;
    }

    /**
     * <p>Setter for the field <code>orderType</code>.</p>
     *
     * @param orderType a {@link net.sf.dynamicreports.report.constant.OrderType} object.
     */
    public void setOrderType(final OrderType orderType) {
        this.orderType = orderType;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<? extends Comparator<?>> getComparatorExpression() {
        return comparatorExpression;
    }

    /**
     * <p>Setter for the field <code>comparatorExpression</code>.</p>
     *
     * @param comparatorExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setComparatorExpression(final DRIExpression<? extends Comparator<?>> comparatorExpression) {
        this.comparatorExpression = comparatorExpression;
    }

    /** {@inheritDoc} */
    @Override
    public Class<? super T> getValueClass() {
        return getExpression().getValueClass();
    }
}

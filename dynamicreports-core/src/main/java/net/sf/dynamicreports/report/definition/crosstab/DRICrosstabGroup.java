/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.report.definition.crosstab;

import net.sf.dynamicreports.report.constant.CrosstabTotalPosition;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.OrderType;
import net.sf.dynamicreports.report.definition.DRIHyperLink;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import net.sf.dynamicreports.report.definition.expression.DRISystemExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;

import java.util.Comparator;
import java.util.List;

/**
 * <p>DRICrosstabGroup interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRICrosstabGroup<T> extends DRISystemExpression<T> {

    /** {@inheritDoc} */
    @Override
    public String getName();

    /**
     * <p>getHeaderPattern.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getHeaderPattern();

    /**
     * <p>getHeaderHorizontalTextAlignment.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     */
    public HorizontalTextAlignment getHeaderHorizontalTextAlignment();

    /**
     * <p>getHeaderValueFormatter.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIValueFormatter} object.
     */
    public DRIValueFormatter<?, ? super T> getHeaderValueFormatter();

    /**
     * <p>getHeaderStretchWithOverflow.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getHeaderStretchWithOverflow();

    /**
     * <p>getHeaderHyperLink.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIHyperLink} object.
     */
    public DRIHyperLink getHeaderHyperLink();

    /**
     * <p>getHeaderStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public DRIReportStyle getHeaderStyle();

    /**
     * <p>getHeaderPropertyExpressions.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRIPropertyExpression> getHeaderPropertyExpressions();

    /**
     * <p>getShowTotal.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getShowTotal();

    /**
     * <p>getTotalPosition.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.CrosstabTotalPosition} object.
     */
    public CrosstabTotalPosition getTotalPosition();

    /**
     * <p>getTotalHeaderExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<?> getTotalHeaderExpression();

    /**
     * <p>getTotalHeaderStretchWithOverflow.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getTotalHeaderStretchWithOverflow();

    /**
     * <p>getTotalHeaderStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public DRIReportStyle getTotalHeaderStyle();

    /**
     * <p>getTotalHeaderPropertyExpressions.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRIPropertyExpression> getTotalHeaderPropertyExpressions();

    /**
     * <p>getExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<T> getExpression();

    /**
     * <p>getDataType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.datatype.DRIDataType} object.
     */
    public DRIDataType<? super T, T> getDataType();

    /**
     * <p>getOrderByExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<? extends Comparable<?>> getOrderByExpression();

    /**
     * <p>getOrderType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.OrderType} object.
     */
    public OrderType getOrderType();

    /**
     * <p>getComparatorExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<? extends Comparator<?>> getComparatorExpression();
}

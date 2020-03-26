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
package net.sf.dynamicreports.design.base.crosstab;

import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabGroup;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.CrosstabTotalPosition;
import net.sf.dynamicreports.report.constant.OrderType;

/**
 * <p>Abstract DRDesignCrosstabGroup class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public abstract class DRDesignCrosstabGroup implements DRIDesignCrosstabGroup {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private String name;
    private CrosstabTotalPosition totalPosition;
    private OrderType orderType;
    private DRIDesignExpression expression;
    private DRIDesignExpression orderByExpression;
    private DRIDesignExpression comparatorExpression;
    private DRDesignCrosstabCellContent header;
    private DRDesignCrosstabCellContent totalHeader;

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <p>Setter for the field <code>name</code>.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public void setName(String name) {
        this.name = name;
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
    public void setTotalPosition(CrosstabTotalPosition totalPosition) {
        this.totalPosition = totalPosition;
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
    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getExpression() {
        return expression;
    }

    /**
     * <p>Setter for the field <code>expression</code>.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setExpression(DRIDesignExpression expression) {
        this.expression = expression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getOrderByExpression() {
        return orderByExpression;
    }

    /**
     * <p>Setter for the field <code>orderByExpression</code>.</p>
     *
     * @param orderByExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setOrderByExpression(DRIDesignExpression orderByExpression) {
        this.orderByExpression = orderByExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getComparatorExpression() {
        return comparatorExpression;
    }

    /**
     * <p>Setter for the field <code>comparatorExpression</code>.</p>
     *
     * @param comparatorExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setComparatorExpression(DRIDesignExpression comparatorExpression) {
        this.comparatorExpression = comparatorExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignCrosstabCellContent getHeader() {
        return header;
    }

    /**
     * <p>Setter for the field <code>header</code>.</p>
     *
     * @param header a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCellContent} object.
     */
    public void setHeader(DRDesignCrosstabCellContent header) {
        this.header = header;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignCrosstabCellContent getTotalHeader() {
        return totalHeader;
    }

    /**
     * <p>Setter for the field <code>totalHeader</code>.</p>
     *
     * @param totalHeader a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCellContent} object.
     */
    public void setTotalHeader(DRDesignCrosstabCellContent totalHeader) {
        this.totalHeader = totalHeader;
    }
}

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

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.OrderType;
import net.sf.dynamicreports.report.definition.DRISort;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>DRSort class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRSort implements DRISort {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIExpression<?> expression;
	private OrderType orderType;

	/** {@inheritDoc} */
	@Override
	public DRIExpression<?> getExpression() {
		return expression;
	}

	/**
	 * <p>Setter for the field <code>expression</code>.</p>
	 *
	 * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 */
	public void setExpression(DRIExpression<?> expression) {
		this.expression = expression;
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

}

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

package net.sf.dynamicreports.design.transformation.expressions;

import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;

/**
 * <p>CrosstabRowCounter class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class CrosstabRowCounter extends AbstractSimpleExpression<CrosstabRowCounter> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private int rowNumber = 1;

	/** {@inheritDoc} */
	@Override
	public CrosstabRowCounter evaluate(ReportParameters reportParameters) {
		return this;
	}

	/**
	 * <p>increment.</p>
	 */
	public void increment() {
		rowNumber++;
	}

	/**
	 * <p>Getter for the field <code>rowNumber</code>.</p>
	 *
	 * @return a int.
	 */
	public int getRowNumber() {
		return rowNumber;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return ReportParameters.CROSSTAB_ROW_COUNTER;
	}
}

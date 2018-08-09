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

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.CrosstabPercentageType;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabVariable;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * <p>DRCrosstabVariable class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRCrosstabVariable<T> implements DRICrosstabVariable<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private DRIExpression<?> valueExpression;
	private Calculation calculation;
	private CrosstabPercentageType percentageType;

	/**
	 * <p>Constructor for DRCrosstabVariable.</p>
	 *
	 * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
	 * @param calculation a {@link net.sf.dynamicreports.report.constant.Calculation} object.
	 */
	public DRCrosstabVariable(DRIExpression<?> valueExpression, Calculation calculation) {
		Validate.notNull(valueExpression, "valueExpression must not be null");
		Validate.notNull(calculation, "calculation must not be null");
		this.valueExpression = valueExpression;
		this.calculation = calculation;
		this.name = ReportUtils.generateUniqueName("crosstabMeasure");
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return name;
	}

	/** {@inheritDoc} */
	@Override
	public DRIExpression<?> getValueExpression() {
		return valueExpression;
	}

	/** {@inheritDoc} */
	@Override
	public Calculation getCalculation() {
		return calculation;
	}

	/** {@inheritDoc} */
	@Override
	public CrosstabPercentageType getPercentageType() {
		return percentageType;
	}

	/**
	 * <p>Setter for the field <code>percentageType</code>.</p>
	 *
	 * @param percentageType a {@link net.sf.dynamicreports.report.constant.CrosstabPercentageType} object.
	 */
	public void setPercentageType(CrosstabPercentageType percentageType) {
		this.percentageType = percentageType;
	}

	/** {@inheritDoc} */
	@Override
	@SuppressWarnings("unchecked")
	public Class<? super T> getValueClass() {
		if (percentageType != null && percentageType.equals(CrosstabPercentageType.GRAND_TOTAL) &&
				!calculation.equals(Calculation.COUNT) && !calculation.equals(Calculation.DISTINCT_COUNT)) {
			return (Class<? super T>) Double.class;
		}
		return (Class<? super T>) ReportUtils.getVariableValueClass(getCalculation(), valueExpression.getValueClass());
	}
}

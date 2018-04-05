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

import java.util.List;

import net.sf.dynamicreports.report.builder.expression.AbstractComplexExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRICustomValues;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstab;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabMeasure;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabVariable;
import net.sf.dynamicreports.report.definition.expression.DRIComplexExpression;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class CrosstabExpression<T> extends AbstractComplexExpression<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIExpression<T> expression;

	public CrosstabExpression(DRICrosstab crosstab, DRIExpression<T> expression) throws DRException {
		this.expression = expression;
		if (expression instanceof DRIComplexExpression) {
			for (DRIExpression<?> express : ((DRIComplexExpression<?>) expression).getExpressions()) {
				addExpression(express);
			}
		}
		for (DRICrosstabVariable<?> variable : crosstab.getVariables()) {
			addExpression(variable);
		}
		for (DRICrosstabMeasure<?> measure : crosstab.getMeasures()) {
			if (measure.getExpression() instanceof DRICrosstabVariable<?>) {
				addExpression(measure.getExpression());
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T evaluate(List<?> values, ReportParameters reportParameters) {
		DRICustomValues customValues = (DRICustomValues) reportParameters.getParameterValue(DRICustomValues.NAME);
		for (int i = 0; i < getExpressions().size(); i++) {
			customValues.setSystemValue(getExpressions().get(i).getName(), values.get(i));
		}
		if (expression instanceof DRIComplexExpression) {
			DRIComplexExpression<?> express = (DRIComplexExpression<?>) expression;
			return (T) express.evaluate(values, reportParameters);
		} else {
			return reportParameters.getValue(expression.getName());
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Class getValueClass() {
		return expression.getValueClass();
	}
}

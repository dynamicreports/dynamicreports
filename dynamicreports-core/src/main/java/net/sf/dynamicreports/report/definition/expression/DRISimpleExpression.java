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

package net.sf.dynamicreports.report.definition.expression;

import net.sf.dynamicreports.report.definition.DRIValue;
import net.sf.dynamicreports.report.definition.ReportParameters;

/**
 * The basic and the simplest implementation of an expression.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public interface DRISimpleExpression<T> extends DRIValue<T>, DRIExpression<T> {

	/**
	 * Evaluates the expression.
	 *
	 * @param reportParameters
	 *          access to report fields, variables, parameters, expressions, and other report values
	 * @return the result of the expression evaluation
	 */
	public T evaluate(ReportParameters reportParameters);
}

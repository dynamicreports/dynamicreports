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

package net.sf.dynamicreports.report.builder.condition;

import net.sf.dynamicreports.report.definition.DRIValue;

/**
 * A set of build in condition expressions
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ConditionBuilders {

	@SuppressWarnings("unchecked")
	public <T> EqualExpression equal(DRIValue<T> value, T... values) {
		return Conditions.equal(value, values);
	}

	public <T extends Number> EqualValueExpression<T> equal(DRIValue<T> value, Number... number) {
		return Conditions.equal(value, number);
	}

	@SuppressWarnings("unchecked")
	public <T> UnEqualExpression unEqual(DRIValue<T> value, T... values) {
		return Conditions.unEqual(value, values);
	}

	public <T extends Number> UnEqualValueExpression<T> unEqual(DRIValue<T> value, Number... number) {
		return Conditions.unEqual(value, number);
	}

	public <T extends Number> SmallerValueExpression<T> smaller(DRIValue<T> value, Number number) {
		return Conditions.smaller(value, number);
	}

	public <T extends Number> SmallerOrEqualsValueExpression<T> smallerOrEquals(DRIValue<T> value, Number number) {
		return Conditions.smallerOrEquals(value, number);
	}

	public <T extends Number> GreaterValueExpression<T> greater(DRIValue<T> value, Number number) {
		return Conditions.greater(value, number);
	}

	public <T extends Number> GreaterOrEqualsValueExpression<T> greaterOrEquals(DRIValue<T> value, Number number) {
		return Conditions.greaterOrEquals(value, number);
	}

	public <T extends Number> BetweenValueExpression<T> between(DRIValue<T> value, Number min, Number max) {
		return Conditions.between(value, min, max);
	}

	public <T extends Number> NotBetweenValueExpression<T> notBetween(DRIValue<T> value, Number min, Number max) {
		return Conditions.notBetween(value, min, max);
	}
}

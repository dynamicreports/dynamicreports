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
public class Conditions {

	@SafeVarargs
	public static <T> EqualExpression equal(DRIValue<T> value, T... values) {
		return new EqualExpression(value, values);
	}

	public static <T extends Number> EqualValueExpression<T> equal(DRIValue<T> value, Number... number) {
		return new EqualValueExpression<T>(value, number);
	}

	@SafeVarargs
	public static <T> UnEqualExpression unEqual(DRIValue<T> value, T... values) {
		return new UnEqualExpression(value, values);
	}

	public static <T extends Number> UnEqualValueExpression<T> unEqual(DRIValue<T> value, Number... number) {
		return new UnEqualValueExpression<T>(value, number);
	}

	public static <T extends Number> SmallerValueExpression<T> smaller(DRIValue<T> value, Number number) {
		return new SmallerValueExpression<T>(value, number);
	}

	public static <T extends Number> SmallerOrEqualsValueExpression<T> smallerOrEquals(DRIValue<T> value, Number number) {
		return new SmallerOrEqualsValueExpression<T>(value, number);
	}

	public static <T extends Number> GreaterValueExpression<T> greater(DRIValue<T> value, Number number) {
		return new GreaterValueExpression<T>(value, number);
	}

	public static <T extends Number> GreaterOrEqualsValueExpression<T> greaterOrEquals(DRIValue<T> value, Number number) {
		return new GreaterOrEqualsValueExpression<T>(value, number);
	}

	public static <T extends Number> BetweenValueExpression<T> between(DRIValue<T> value, Number min, Number max) {
		return new BetweenValueExpression<T>(value, min, max);
	}

	public static <T extends Number> NotBetweenValueExpression<T> notBetween(DRIValue<T> value, Number min, Number max) {
		return new NotBetweenValueExpression<T>(value, min, max);
	}
}

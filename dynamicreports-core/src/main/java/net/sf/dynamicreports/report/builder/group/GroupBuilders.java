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

package net.sf.dynamicreports.report.builder.group;

import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * A set of methods of creating report groups
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GroupBuilders {

	// column
	public ColumnGroupBuilder group(ValueColumnBuilder<?, ?> groupColumn) {
		return Groups.group(groupColumn);
	}

	public ColumnGroupBuilder group(String name, ValueColumnBuilder<?, ?> groupColumn) {
		return Groups.group(name, groupColumn);
	}

	// custom
	public CustomGroupBuilder group(String fieldName, Class<?> valueClass) {
		return Groups.group(fieldName, valueClass);
	}

	public CustomGroupBuilder group(String name, String fieldName, Class<?> valueClass) {
		return Groups.group(name, fieldName, valueClass);
	}

	public CustomGroupBuilder group(FieldBuilder<?> field) {
		return Groups.group(field);
	}

	public CustomGroupBuilder group(String name, FieldBuilder<?> field) {
		return Groups.group(name, field);
	}

	public CustomGroupBuilder group(DRIExpression<?> expression) {
		return Groups.group(expression);
	}

	public CustomGroupBuilder group(String name, DRIExpression<?> expression) {
		return Groups.group(name, expression);
	}
}

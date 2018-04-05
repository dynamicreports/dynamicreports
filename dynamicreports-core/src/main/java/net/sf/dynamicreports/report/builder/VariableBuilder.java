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

package net.sf.dynamicreports.report.builder;

import net.sf.dynamicreports.report.base.DRVariable;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.group.GroupBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.definition.DRIValue;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIJasperExpression;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class VariableBuilder<T> extends AbstractBuilder<VariableBuilder<T>, DRVariable<T>> implements DRIValue<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	// column
	protected VariableBuilder(ValueColumnBuilder<?, ?> column, Calculation calculation) {
		super(new DRVariable<T>(column.build(), calculation));
	}

	protected VariableBuilder(String name, ValueColumnBuilder<?, ?> column, Calculation calculation) {
		super(new DRVariable<T>(name, column.build(), calculation));
	}

	// field
	protected VariableBuilder(FieldBuilder<?> field, Calculation calculation) {
		super(new DRVariable<T>(field.getField(), calculation));
	}

	protected VariableBuilder(String name, FieldBuilder<?> field, Calculation calculation) {
		super(new DRVariable<T>(name, field.getField(), calculation));
	}

	// simple expression
	protected VariableBuilder(DRIExpression<?> expression, Calculation calculation) {
		super(new DRVariable<T>(expression, calculation));
	}

	protected VariableBuilder(String name, DRIExpression<?> expression, Calculation calculation) {
		super(new DRVariable<T>(name, expression, calculation));
	}

	public VariableBuilder<T> setInitialValueExpression(DRIJasperExpression<?> initialValueExpression) {
		getObject().setInitialValueExpression(initialValueExpression);
		return this;
	}

	public VariableBuilder<T> setResetType(Evaluation resetType) {
		getObject().setResetType(resetType);
		return this;
	}

	public VariableBuilder<T> setResetGroup(GroupBuilder<?> resetGroup) {
		if (resetGroup != null) {
			getObject().setResetGroup(resetGroup.getGroup());
			setResetType(Evaluation.GROUP);
		} else {
			getObject().setResetGroup(null);
		}
		return this;
	}

	public DRVariable<T> getVariable() {
		return build();
	}

	@Override
	public String getName() {
		return getVariable().getName();
	}
}

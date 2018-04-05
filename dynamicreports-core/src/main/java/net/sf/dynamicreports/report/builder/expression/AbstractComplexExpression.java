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

package net.sf.dynamicreports.report.builder.expression;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.base.DRField;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.expression.DRIComplexExpression;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class AbstractComplexExpression<T> implements DRIComplexExpression<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String name;
	private List<DRIExpression<?>> expressions;

	protected AbstractComplexExpression() {
		this.name = ReportUtils.generateUniqueName("complexExpression");
		this.expressions = new ArrayList<DRIExpression<?>>();
	}

	@Override
	public String getName() {
		return name;
	}

	protected void addExpression(FieldBuilder<?> field) {
		Validate.notNull(field, "field must not be null");
		this.expressions.add(field.getField());
	}

	protected void addExpression(String fieldName, Class<?> valueClass) {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		DRField<?> field = new DRField(fieldName, valueClass);
		this.expressions.add(field);
	}

	protected void addExpression(TextColumnBuilder<?> column) {
		Validate.notNull(column, "column must not be null");
		this.expressions.add(column.build());
	}

	protected void addExpression(VariableBuilder<?> variable) {
		Validate.notNull(variable, "variable must not be null");
		this.expressions.add(variable.getVariable());
	}

	protected void addExpression(DRIExpression<?> expression) {
		Validate.notNull(expression, "expression must not be null");
		this.expressions.add(expression);
	}

	protected void addExpression(AbstractCrosstabGroupBuilder<?, ?, ?> crosstabGroup) {
		Validate.notNull(crosstabGroup, "crosstabGroup must not be null");
		this.expressions.add(Expressions.crosstabValue(crosstabGroup));
	}

	protected void addExpression(CrosstabMeasureBuilder<?> crosstabMeasure) {
		Validate.notNull(crosstabMeasure, "crosstabMeasure must not be null");
		this.expressions.add(Expressions.crosstabValue(crosstabMeasure));
	}

	@Override
	public List<DRIExpression<?>> getExpressions() {
		return expressions;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Class<? super T> getValueClass() {
		return (Class<? super T>) ReportUtils.getGenericClass(this, 0);
	}

	@Override
	public abstract T evaluate(List<?> values, ReportParameters reportParameters);
}

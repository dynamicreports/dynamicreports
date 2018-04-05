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

package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.report.base.chart.dataset.DRXyChartSerie;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class XyChartSerieBuilder extends AbstractChartSerieBuilder<XyChartSerieBuilder, DRXyChartSerie> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected XyChartSerieBuilder(ValueColumnBuilder<?, ? extends Number> column) {
		super(new DRXyChartSerie());
		setYValue(column);
		getObject().setLabelExpression(column.getColumn().getTitleExpression());
	}

	protected XyChartSerieBuilder(FieldBuilder<? extends Number> field) {
		super(new DRXyChartSerie());
		setYValue(field);
	}

	protected XyChartSerieBuilder(DRIExpression<? extends Number> valueExpression) {
		super(new DRXyChartSerie());
		setYValue(valueExpression);
	}

	protected XyChartSerieBuilder(VariableBuilder<? extends Number> variable) {
		super(new DRXyChartSerie());
		setYValue(variable);
	}

	// x
	public XyChartSerieBuilder setXValue(ValueColumnBuilder<?, ? extends Number> column) {
		Validate.notNull(column, "column must not be null");
		getObject().setXValueExpression(column.getColumn());
		return this;
	}

	public XyChartSerieBuilder setXValue(FieldBuilder<? extends Number> field) {
		Validate.notNull(field, "field must not be null");
		getObject().setXValueExpression(field.build());
		return this;
	}

	public XyChartSerieBuilder setXValue(DRIExpression<? extends Number> valueExpression) {
		getObject().setXValueExpression(valueExpression);
		return this;
	}

	public XyChartSerieBuilder setXValue(VariableBuilder<? extends Number> variable) {
		Validate.notNull(variable, "variable must not be null");
		getObject().setXValueExpression(variable.build());
		return this;
	}

	// y
	public XyChartSerieBuilder setYValue(ValueColumnBuilder<?, ? extends Number> column) {
		Validate.notNull(column, "column must not be null");
		getObject().setYValueExpression(column.getColumn());
		return this;
	}

	public XyChartSerieBuilder setYValue(FieldBuilder<? extends Number> field) {
		Validate.notNull(field, "field must not be null");
		getObject().setYValueExpression(field.build());
		return this;
	}

	public XyChartSerieBuilder setYValue(DRIExpression<? extends Number> valueExpression) {
		getObject().setYValueExpression(valueExpression);
		return this;
	}

	public XyChartSerieBuilder setYValue(VariableBuilder<? extends Number> variable) {
		Validate.notNull(variable, "variable must not be null");
		getObject().setYValueExpression(variable.build());
		return this;
	}

	// label
	public XyChartSerieBuilder setLabel(String label) {
		getObject().setLabelExpression(Expressions.text(label));
		return this;
	}

	public XyChartSerieBuilder setLabel(DRIExpression<String> labelExpression) {
		getObject().setLabelExpression(labelExpression);
		return this;
	}

	public DRXyChartSerie getChartSerie() {
		return build();
	}
}

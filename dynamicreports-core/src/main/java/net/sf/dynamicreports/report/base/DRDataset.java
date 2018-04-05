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

package net.sf.dynamicreports.report.base;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRIDataset;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDataset implements DRIDataset {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private List<DRField<?>> fields;
	private List<DRVariable<?>> variables;
	private List<DRSort> sorts;
	private DRQuery query;
	private DRIExpression<Connection> connectionExpression;
	private DRIExpression<?> dataSourceExpression;
	private DRIExpression<Boolean> filterExpression;

	public DRDataset() {
		init();
	}

	private void init() {
		this.fields = new ArrayList<DRField<?>>();
		this.variables = new ArrayList<DRVariable<?>>();
		this.sorts = new ArrayList<DRSort>();
	}

	@Override
	public List<DRField<?>> getFields() {
		return fields;
	}

	public void setFields(List<DRField<?>> fields) {
		Validate.notNull(fields, "fields must not be null");
		Validate.noNullElements(fields, "fields must not contains null field");
		this.fields = fields;
	}

	public void addField(DRField<?> field) {
		Validate.notNull(field, "field must not be null");
		this.fields.add(field);
	}

	@Override
	public List<DRVariable<?>> getVariables() {
		return variables;
	}

	public void setVariables(List<DRVariable<?>> variables) {
		Validate.notNull(variables, "variables must not be null");
		Validate.noNullElements(variables, "variables must not contains null variable");
		this.variables = variables;
	}

	public void addVariable(DRVariable<?> variable) {
		Validate.notNull(variable, "variable must not be null");
		this.variables.add(variable);
	}

	@Override
	public List<DRSort> getSorts() {
		return sorts;
	}

	public void setSorts(List<DRSort> sorts) {
		Validate.notNull(sorts, "sorts must not be null");
		Validate.noNullElements(sorts, "sorts must not contains null sort");
		this.sorts = sorts;
	}

	public void addSort(DRSort sort) {
		Validate.notNull(sort, "sort must not be null");
		this.sorts.add(sort);
	}

	@Override
	public DRQuery getQuery() {
		return query;
	}

	public void setQuery(DRQuery query) {
		this.query = query;
	}

	@Override
	public DRIExpression<Connection> getConnectionExpression() {
		return connectionExpression;
	}

	public void setConnectionExpression(DRIExpression<Connection> connectionExpression) {
		this.connectionExpression = connectionExpression;
	}

	@Override
	public DRIExpression<?> getDataSourceExpression() {
		return dataSourceExpression;
	}

	public void setDataSourceExpression(DRIExpression<?> dataSourceExpression) {
		this.dataSourceExpression = dataSourceExpression;
	}

	@Override
	public DRIExpression<Boolean> getFilterExpression() {
		return filterExpression;
	}

	public void setFilterExpression(DRIExpression<Boolean> filterExpression) {
		this.filterExpression = filterExpression;
	}
}

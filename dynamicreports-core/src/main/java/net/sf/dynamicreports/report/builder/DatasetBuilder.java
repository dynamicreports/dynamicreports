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

import java.sql.Connection;

import net.sf.dynamicreports.report.base.DRDataset;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.QueryLanguage;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JRDataSource;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DatasetBuilder extends AbstractBuilder<DatasetBuilder, DRDataset> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected DatasetBuilder() {
		super(new DRDataset());
	}

	// field
	public DatasetBuilder fields(FieldBuilder<?>... fields) {
		return addField(fields);
	}

	public DatasetBuilder addField(String name, Class<?> valueClass) {
		return addField(DynamicReports.field(name, valueClass));
	}

	public <U> DatasetBuilder addField(String name, DRIDataType<? super U, U> dataType) {
		return addField(DynamicReports.field(name, dataType));
	}

	public DatasetBuilder addField(FieldBuilder<?>... fields) {
		Validate.notNull(fields, "fields must not be null");
		Validate.noNullElements(fields, "fields must not contains null field");
		for (FieldBuilder<?> field : fields) {
			getObject().addField(field.build());
		}
		return this;
	}

	// variable
	public DatasetBuilder variables(VariableBuilder<?>... variables) {
		return addVariable(variables);
	}

	public DatasetBuilder addVariable(VariableBuilder<?>... variables) {
		Validate.notNull(variables, "variables must not be null");
		Validate.noNullElements(variables, "variables must not contains null variable");
		for (VariableBuilder<?> variable : variables) {
			getObject().addVariable(variable.getVariable());
		}
		return this;
	}

	// sort
	public DatasetBuilder sortBy(TextColumnBuilder<?>... sortColumns) {
		Validate.notNull(sortColumns, "sortColumns must not be null");
		Validate.noNullElements(sortColumns, "sortColumns must not contains null sortColumn");
		for (TextColumnBuilder<?> sortColumn : sortColumns) {
			sortBy(DynamicReports.asc(sortColumn));
		}
		return this;
	}

	public DatasetBuilder sortBy(SortBuilder... sorts) {
		return addSort(sorts);
	}

	public DatasetBuilder addSort(SortBuilder... sorts) {
		Validate.notNull(sorts, "sorts must not be null");
		Validate.noNullElements(sorts, "sorts must not contains null sort");
		for (SortBuilder sort : sorts) {
			getObject().addSort(sort.build());
		}
		return this;
	}

	// query
	public DatasetBuilder setQuery(String text, String language) {
		Validate.notNull(text, "text must not be null");
		Validate.notNull(language, "language must not be null");
		return setQuery(DynamicReports.query(text, language));
	}

	public DatasetBuilder setQuery(String sql) {
		Validate.notNull(sql, "sql must not be null");
		return setQuery(DynamicReports.query(sql, QueryLanguage.SQL));
	}

	public DatasetBuilder setQuery(QueryBuilder query) {
		Validate.notNull(query, "query must not be null");
		getObject().setQuery(query.build());
		return this;
	}

	// connection
	public DatasetBuilder setConnection(Connection connection) {
		getObject().setConnectionExpression(Expressions.value(connection));
		return this;
	}

	public DatasetBuilder setConnection(DRIExpression<Connection> connectionExpression) {
		getObject().setConnectionExpression(connectionExpression);
		return this;
	}

	// datasource
	public DatasetBuilder setDataSource(JRDataSource dataSource) {
		getObject().setDataSourceExpression(Expressions.dataSource(dataSource));
		return this;
	}

	public DatasetBuilder setDataSource(DRIExpression<JRDataSource> dataSourceExpression) {
		getObject().setDataSourceExpression(dataSourceExpression);
		return this;
	}

	// filter
	public DatasetBuilder setFilterExpression(DRIExpression<Boolean> filterExpression) {
		getObject().setFilterExpression(filterExpression);
		return this;
	}

	public DatasetBuilder setDataSource(String sql, Connection connection) {
		Validate.notNull(sql, "sql must not be null");
		return setDataSource(DynamicReports.query(sql, QueryLanguage.SQL), connection);
	}

	public DatasetBuilder setDataSource(QueryBuilder query, Connection connection) {
		Validate.notNull(query, "query must not be null");
		Validate.notNull(connection, "connection must not be null");
		setQuery(query);
		setConnection(connection);
		return this;
	}
}

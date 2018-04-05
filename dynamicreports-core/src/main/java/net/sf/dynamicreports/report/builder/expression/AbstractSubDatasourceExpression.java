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

import java.util.List;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JRDataSource;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class AbstractSubDatasourceExpression<T> extends AbstractComplexExpression<JRDataSource> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected AbstractSubDatasourceExpression(String fieldName) {
		Validate.notNull(fieldName, "fieldName must not be null");
		addExpression(fieldName, getSubDatasourceDataClass());
	}

	protected AbstractSubDatasourceExpression(DRIExpression<? extends T> expression) {
		addExpression(expression);
	}

	@SuppressWarnings("unchecked")
	@Override
	public JRDataSource evaluate(List<?> values, ReportParameters reportParameters) {
		return createSubDatasource((T) values.get(0));
	}

	@Override
	public Class<? super JRDataSource> getValueClass() {
		return JRDataSource.class;
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getSubDatasourceDataClass() {
		return (Class<T>) ReportUtils.getGenericClass(this, 0);
	}

	protected abstract JRDataSource createSubDatasource(T data);
}

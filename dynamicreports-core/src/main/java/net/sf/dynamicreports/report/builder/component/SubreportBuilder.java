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

package net.sf.dynamicreports.report.builder.component;

import java.sql.Connection;
import java.util.Map;

import net.sf.dynamicreports.report.base.component.DRSubreport;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperReport;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class SubreportBuilder extends DimensionComponentBuilder<SubreportBuilder, DRSubreport> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected SubreportBuilder() {
		super(new DRSubreport());
	}

	// report
	public SubreportBuilder setReport(ReportBuilder<?> reportBuilder) {
		getObject().setReportExpression(Expressions.value(reportBuilder));
		return this;
	}

	public SubreportBuilder setReport(JasperReport jasperReport) {
		getObject().setReportExpression(Expressions.value(jasperReport));
		return this;
	}

	public SubreportBuilder setReport(DRIExpression<?> reportExpression) {
		getObject().setReportExpression(reportExpression);
		return this;
	}

	// parameters
	public SubreportBuilder setParameters(Map<String, Object> parameters) {
		getObject().setParametersExpression(Expressions.value(parameters));
		return this;
	}

	public SubreportBuilder setParameters(DRIExpression<Map<String, Object>> parametersExpression) {
		getObject().setParametersExpression(parametersExpression);
		return this;
	}

	// connection
	public SubreportBuilder setConnection(Connection connection) {
		getObject().setConnectionExpression(Expressions.value(connection));
		return this;
	}

	public SubreportBuilder setConnection(DRIExpression<Connection> connectionExpression) {
		getObject().setConnectionExpression(connectionExpression);
		return this;
	}

	// datasource
	public SubreportBuilder setDataSource(JRDataSource dataSource) {
		getObject().setDataSourceExpression(Expressions.dataSource(dataSource));
		return this;
	}

	public SubreportBuilder setDataSource(DRIExpression<JRDataSource> dataSourceExpression) {
		getObject().setDataSourceExpression(dataSourceExpression);
		return this;
	}

	public SubreportBuilder setRunToBottom(Boolean runToBottom) {
		getObject().setRunToBottom(runToBottom);
		return this;
	}
}

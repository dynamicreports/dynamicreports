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

package net.sf.dynamicreports.report.base.component;

import java.sql.Connection;
import java.util.Map;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.component.DRISubreport;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRSubreport extends DRDimensionComponent implements DRISubreport {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIExpression<?> reportExpression;
	private DRIExpression<Map<String, Object>> parametersExpression;
	private DRIExpression<Connection> connectionExpression;
	private DRIExpression<?> dataSourceExpression;
	private Boolean runToBottom;

	@Override
	public DRIExpression<?> getReportExpression() {
		return reportExpression;
	}

	public void setReportExpression(DRIExpression<?> reportExpression) {
		Validate.notNull(reportExpression, "reportExpression must not be null");
		this.reportExpression = reportExpression;
	}

	@Override
	public DRIExpression<Map<String, Object>> getParametersExpression() {
		return parametersExpression;
	}

	public void setParametersExpression(DRIExpression<Map<String, Object>> parametersExpression) {
		this.parametersExpression = parametersExpression;
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
	public Boolean getRunToBottom() {
		return runToBottom;
	}

	public void setRunToBottom(Boolean runToBottom) {
		this.runToBottom = runToBottom;
	}
}

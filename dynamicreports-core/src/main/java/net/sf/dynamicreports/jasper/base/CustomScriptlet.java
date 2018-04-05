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

package net.sf.dynamicreports.jasper.base;

import net.sf.dynamicreports.report.definition.DRIScriptlet;
import net.sf.jasperreports.engine.JRAbstractScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class CustomScriptlet extends JRAbstractScriptlet {
	private DRIScriptlet scriptlet;
	private JasperReportParameters reportParameters;

	public CustomScriptlet(DRIScriptlet scriptlet) {
		this.scriptlet = scriptlet;
	}

	@Override
	public void afterColumnInit() throws JRScriptletException {
		scriptlet.afterColumnInit(getReportParameters());
	}

	@Override
	public void afterDetailEval() throws JRScriptletException {
		scriptlet.afterDetailEval(getReportParameters());
	}

	@Override
	public void afterGroupInit(String groupName) throws JRScriptletException {
		scriptlet.afterGroupInit(groupName, getReportParameters());
	}

	@Override
	public void afterPageInit() throws JRScriptletException {
		scriptlet.afterPageInit(getReportParameters());
	}

	@Override
	public void afterReportInit() throws JRScriptletException {
		scriptlet.afterReportInit(getReportParameters());
	}

	@Override
	public void beforeColumnInit() throws JRScriptletException {
		scriptlet.beforeColumnInit(getReportParameters());
	}

	@Override
	public void beforeDetailEval() throws JRScriptletException {
		scriptlet.beforeDetailEval(getReportParameters());
	}

	@Override
	public void beforeGroupInit(String groupName) throws JRScriptletException {
		scriptlet.beforeGroupInit(groupName, getReportParameters());
	}

	@Override
	public void beforePageInit() throws JRScriptletException {
		scriptlet.beforePageInit(getReportParameters());
	}

	@Override
	public void beforeReportInit() throws JRScriptletException {
		scriptlet.beforeReportInit(getReportParameters());
	}

	private JasperReportParameters getReportParameters() {
		if (reportParameters == null) {
			try {
				reportParameters = ((JasperScriptlet) getParameterValue(JasperScriptlet.SCRIPTLET_NAME)).getReportParameters();
			} catch (JRScriptletException e) {
			}
		}
		return reportParameters;
	}

	protected DRIScriptlet getScriptlet() {
		return scriptlet;
	}
}

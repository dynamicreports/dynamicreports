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

package net.sf.dynamicreports.report.definition;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public interface DRIScriptlet {

	public String getName();

	/**
	 * Called before the report is initialized.
	 */
	public void beforeReportInit(ReportParameters reportParameters);

	/**
	 * Called after the report is initialized.
	 */
	public void afterReportInit(ReportParameters reportParameters);

	/**
	 * Called before each page is initialized.
	 */
	public void beforePageInit(ReportParameters reportParameters);

	/**
	 * Called after each page is initialized.
	 */
	public void afterPageInit(ReportParameters reportParameters);

	/**
	 * Called before each column is initialized.
	 */
	public void beforeColumnInit(ReportParameters reportParameters);

	/**
	 * Called after each column is initialized.
	 */
	public void afterColumnInit(ReportParameters reportParameters);

	/**
	 * Called before a group is initialized.
	 * 
	 * @param groupName
	 *          the group name
	 */
	public void beforeGroupInit(String groupName, ReportParameters reportParameters);

	/**
	 * Called after a group is initialized.
	 * 
	 * @param groupName
	 *          the group name
	 */
	public void afterGroupInit(String groupName, ReportParameters reportParameters);

	/**
	 * Called before evaluating each detail.
	 */
	public void beforeDetailEval(ReportParameters reportParameters);

	/**
	 * Called after evaluating each detail.
	 */
	public void afterDetailEval(ReportParameters reportParameters);
}

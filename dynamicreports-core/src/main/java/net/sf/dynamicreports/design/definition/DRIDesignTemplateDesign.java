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

package net.sf.dynamicreports.design.definition;

import java.io.Serializable;

import net.sf.dynamicreports.report.exception.DRException;

/**
 * <p>DRIDesignTemplateDesign interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIDesignTemplateDesign extends Serializable {

	/**
	 * <p>getTitleComponentsCount.</p>
	 *
	 * @return a int.
	 */
	public int getTitleComponentsCount();

	/**
	 * <p>getPageHeaderComponentsCount.</p>
	 *
	 * @return a int.
	 */
	public int getPageHeaderComponentsCount();

	/**
	 * <p>getPageFooterComponentsCount.</p>
	 *
	 * @return a int.
	 */
	public int getPageFooterComponentsCount();

	/**
	 * <p>getColumnHeaderComponentsCount.</p>
	 *
	 * @return a int.
	 */
	public int getColumnHeaderComponentsCount();

	/**
	 * <p>getColumnFooterComponentsCount.</p>
	 *
	 * @return a int.
	 */
	public int getColumnFooterComponentsCount();

	/**
	 * <p>getLastPageFooterComponentsCount.</p>
	 *
	 * @return a int.
	 */
	public int getLastPageFooterComponentsCount();

	/**
	 * <p>getSummaryComponentsCount.</p>
	 *
	 * @return a int.
	 */
	public int getSummaryComponentsCount();

	/**
	 * <p>getNoDataComponentsCount.</p>
	 *
	 * @return a int.
	 */
	public int getNoDataComponentsCount();

	/**
	 * <p>getBackgroundComponentsCount.</p>
	 *
	 * @return a int.
	 */
	public int getBackgroundComponentsCount();

	/**
	 * <p>getDesign.</p>
	 *
	 * @return a {@link java.lang.Object} object.
	 * @throws net.sf.dynamicreports.report.exception.DRException if any.
	 */
	public Object getDesign() throws DRException;
}

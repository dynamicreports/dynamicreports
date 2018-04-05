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

import java.util.List;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.definition.DRIField;
import net.sf.dynamicreports.report.definition.DRIMargin;
import net.sf.dynamicreports.report.definition.DRITemplateDesign;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class AbstractTemplateDesign<T> implements DRITemplateDesign<T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	@Override
	public String getReportName() {
		return null;
	}

	@Override
	public List<DRIField<?>> getFields() {
		return null;
	}

	@Override
	public boolean isDefinedParameter(String name) {
		return false;
	}

	@Override
	public String getResourceBundleName() {
		return null;
	}

	@Override
	public Boolean getIgnorePagination() {
		return null;
	}

	@Override
	public WhenNoDataType getWhenNoDataType() {
		return null;
	}

	@Override
	public WhenResourceMissingType getWhenResourceMissingType() {
		return null;
	}

	@Override
	public Boolean getTitleOnANewPage() {
		return null;
	}

	@Override
	public Boolean getSummaryOnANewPage() {
		return null;
	}

	@Override
	public Boolean getSummaryWithPageHeaderAndFooter() {
		return null;
	}

	@Override
	public Boolean getFloatColumnFooter() {
		return null;
	}

	@Override
	public Integer getPageWidth() {
		return null;
	}

	@Override
	public Integer getPageHeight() {
		return null;
	}

	@Override
	public PageOrientation getPageOrientation() {
		return null;
	}

	@Override
	public DRIMargin getPageMargin() {
		return null;
	}

	@Override
	public Integer getPageColumnsPerPage() {
		return null;
	}

	@Override
	public Integer getPageColumnSpace() {
		return null;
	}

	@Override
	public Integer getPageColumnWidth() {
		return null;
	}

	@Override
	public int getTitleComponentsCount() {
		return 0;
	}

	@Override
	public int getPageHeaderComponentsCount() {
		return 0;
	}

	@Override
	public int getPageFooterComponentsCount() {
		return 0;
	}

	@Override
	public int getColumnHeaderComponentsCount() {
		return 0;
	}

	@Override
	public int getColumnFooterComponentsCount() {
		return 0;
	}

	@Override
	public int getLastPageFooterComponentsCount() {
		return 0;
	}

	@Override
	public int getSummaryComponentsCount() {
		return 0;
	}

	@Override
	public int getNoDataComponentsCount() {
		return 0;
	}

	@Override
	public int getBackgroundComponentsCount() {
		return 0;
	}

	@Override
	public T getDesign() throws DRException {
		return null;
	}
}

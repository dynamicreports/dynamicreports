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

package net.sf.dynamicreports.design.base;

import net.sf.dynamicreports.design.definition.DRIDesignTemplateDesign;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRITemplateDesign;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignTemplateDesign implements DRIDesignTemplateDesign {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRITemplateDesign<?> templateDesign;

	public DRDesignTemplateDesign(DRITemplateDesign<?> templateDesign) {
		this.templateDesign = templateDesign;
	}

	@Override
	public int getTitleComponentsCount() {
		return templateDesign.getTitleComponentsCount();
	}

	@Override
	public int getPageHeaderComponentsCount() {
		return templateDesign.getPageHeaderComponentsCount();
	}

	@Override
	public int getPageFooterComponentsCount() {
		return templateDesign.getPageFooterComponentsCount();
	}

	@Override
	public int getColumnHeaderComponentsCount() {
		return templateDesign.getColumnHeaderComponentsCount();
	}

	@Override
	public int getColumnFooterComponentsCount() {
		return templateDesign.getColumnFooterComponentsCount();
	}

	@Override
	public int getLastPageFooterComponentsCount() {
		return templateDesign.getLastPageFooterComponentsCount();
	}

	@Override
	public int getSummaryComponentsCount() {
		return templateDesign.getSummaryComponentsCount();
	}

	@Override
	public int getNoDataComponentsCount() {
		return templateDesign.getNoDataComponentsCount();
	}

	@Override
	public int getBackgroundComponentsCount() {
		return templateDesign.getBackgroundComponentsCount();
	}

	@Override
	public Object getDesign() throws DRException {
		return templateDesign.getDesign();
	}
}

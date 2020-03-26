/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.definition.DRIField;
import net.sf.dynamicreports.report.definition.DRIMargin;
import net.sf.dynamicreports.report.definition.DRITemplateDesign;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.List;

/**
 * <p>Abstract AbstractTemplateDesign class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public abstract class AbstractTemplateDesign<T> implements DRITemplateDesign<T> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /** {@inheritDoc} */
    @Override
    public String getReportName() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIField<?>> getFields() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isDefinedParameter(String name) {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public String getResourceBundleName() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getIgnorePagination() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public WhenNoDataType getWhenNoDataType() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public WhenResourceMissingType getWhenResourceMissingType() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getTitleOnANewPage() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getSummaryOnANewPage() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getSummaryWithPageHeaderAndFooter() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getFloatColumnFooter() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageWidth() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageHeight() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public PageOrientation getPageOrientation() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public DRIMargin getPageMargin() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageColumnsPerPage() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageColumnSpace() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageColumnWidth() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public int getTitleComponentsCount() {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public int getPageHeaderComponentsCount() {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public int getPageFooterComponentsCount() {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public int getColumnHeaderComponentsCount() {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public int getColumnFooterComponentsCount() {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public int getLastPageFooterComponentsCount() {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public int getSummaryComponentsCount() {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public int getNoDataComponentsCount() {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public int getBackgroundComponentsCount() {
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public T getDesign() throws DRException {
        return null;
    }
}

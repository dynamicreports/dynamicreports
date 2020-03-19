/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.exception.DRException;

import java.io.Serializable;
import java.util.List;

/**
 * <p>DRITemplateDesign interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRITemplateDesign<T> extends Serializable {

    /**
     * <p>getReportName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getReportName();

    /**
     * <p>getFields.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRIField<?>> getFields();

    /**
     * <p>isDefinedParameter.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a boolean.
     */
    public boolean isDefinedParameter(String name);

    /**
     * <p>getResourceBundleName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getResourceBundleName();

    /**
     * <p>getIgnorePagination.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnorePagination();

    /**
     * <p>getWhenNoDataType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.WhenNoDataType} object.
     */
    public WhenNoDataType getWhenNoDataType();

    /**
     * <p>getWhenResourceMissingType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.WhenResourceMissingType} object.
     */
    public WhenResourceMissingType getWhenResourceMissingType();

    /**
     * <p>getTitleOnANewPage.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getTitleOnANewPage();

    /**
     * <p>getSummaryOnANewPage.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getSummaryOnANewPage();

    /**
     * <p>getSummaryWithPageHeaderAndFooter.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getSummaryWithPageHeaderAndFooter();

    /**
     * <p>getFloatColumnFooter.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getFloatColumnFooter();

    /**
     * <p>getPageWidth.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageWidth();

    /**
     * <p>getPageHeight.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageHeight();

    /**
     * <p>getPageOrientation.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.PageOrientation} object.
     */
    public PageOrientation getPageOrientation();

    /**
     * <p>getPageMargin.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIMargin} object.
     */
    public DRIMargin getPageMargin();

    /**
     * <p>getPageColumnsPerPage.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageColumnsPerPage();

    /**
     * <p>getPageColumnSpace.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageColumnSpace();

    /**
     * <p>getPageColumnWidth.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageColumnWidth();

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
     * @return a T object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public T getDesign() throws DRException;
}

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

import net.sf.dynamicreports.report.constant.GroupFooterPosition;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.definition.component.DRITextField;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;

import java.io.Serializable;

/**
 * <p>DRIGroup interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRIGroup extends Serializable {

    /**
     * <p>getName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName();

    /**
     * <p>getValueField.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRITextField} object.
     */
    public DRITextField<?> getValueField();

    /**
     * <p>getTitleExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<?> getTitleExpression();

    /**
     * <p>getTitleStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public DRIReportStyle getTitleStyle();

    /**
     * <p>getTitleWidth.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getTitleWidth();

    /**
     * <p>getHeaderLayout.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.GroupHeaderLayout} object.
     */
    public GroupHeaderLayout getHeaderLayout();

    /**
     * <p>getHideColumn.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getHideColumn();

    /**
     * <p>getGroupByDataType.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getGroupByDataType();

    /**
     * <p>getShowColumnHeaderAndFooter.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getShowColumnHeaderAndFooter();

    /**
     * <p>getAddToTableOfContents.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getAddToTableOfContents();

    /**
     * <p>getPrintSubtotalsWhenExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<Boolean> getPrintSubtotalsWhenExpression();

    /**
     * <p>getPadding.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPadding();

    /**
     * <p>getStartInNewPage.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getStartInNewPage();

    /**
     * <p>getStartInNewColumn.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getStartInNewColumn();

    /**
     * <p>getReprintHeaderOnEachPage.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getReprintHeaderOnEachPage();

    /**
     * <p>getResetPageNumber.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getResetPageNumber();

    /**
     * <p>getMinHeightToStartNewPage.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getMinHeightToStartNewPage();

    /**
     * <p>getFooterPosition.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.GroupFooterPosition} object.
     */
    public GroupFooterPosition getFooterPosition();

    /**
     * <p>getKeepTogether.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getKeepTogether();

    /**
     * <p>getHeaderWithSubtotal.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getHeaderWithSubtotal();

    /**
     * <p>getHeaderBand.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     */
    public DRIBand getHeaderBand();

    /**
     * <p>getFooterBand.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     */
    public DRIBand getFooterBand();
}

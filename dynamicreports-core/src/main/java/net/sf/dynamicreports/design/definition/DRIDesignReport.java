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
package net.sf.dynamicreports.design.definition;

import net.sf.dynamicreports.design.definition.expression.DRIDesignComplexExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignJasperExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSystemExpression;
import net.sf.dynamicreports.design.definition.style.DRIDesignStyle;
import net.sf.dynamicreports.jasper.base.tableofcontents.JasperTocHeading;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.definition.DRIScriptlet;
import net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * <p>DRIDesignReport interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public interface DRIDesignReport extends Serializable {

    /**
     * <p>getTemplateDesign.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignTemplateDesign} object.
     */
    public DRIDesignTemplateDesign getTemplateDesign();

    /**
     * <p>getReportName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getReportName();

    /**
     * <p>getLocale.</p>
     *
     * @return a {@link java.util.Locale} object.
     */
    public Locale getLocale();

    /**
     * <p>getResourceBundle.</p>
     *
     * @return a {@link java.util.ResourceBundle} object.
     */
    public ResourceBundle getResourceBundle();

    /**
     * <p>getResourceBundleName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getResourceBundleName();

    /**
     * <p>isIgnorePagination.</p>
     *
     * @return a boolean.
     */
    public boolean isIgnorePagination();

    /**
     * <p>getProperties.</p>
     *
     * @return a {@link java.util.Properties} object.
     */
    public Properties getProperties();

    /**
     * <p>getQuery.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignQuery} object.
     */
    public DRIDesignQuery getQuery();

    /**
     * <p>getPage.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignPage} object.
     */
    public DRIDesignPage getPage();

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
     * <p>isTitleOnANewPage.</p>
     *
     * @return a boolean.
     */
    public boolean isTitleOnANewPage();

    /**
     * <p>isSummaryOnANewPage.</p>
     *
     * @return a boolean.
     */
    public boolean isSummaryOnANewPage();

    /**
     * <p>isSummaryWithPageHeaderAndFooter.</p>
     *
     * @return a boolean.
     */
    public boolean isSummaryWithPageHeaderAndFooter();

    /**
     * <p>isFloatColumnFooter.</p>
     *
     * @return a boolean.
     */
    public boolean isFloatColumnFooter();

    /**
     * <p>getPrintOrder.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.Orientation} object.
     */
    public Orientation getPrintOrder();

    /**
     * <p>getColumnDirection.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.RunDirection} object.
     */
    public RunDirection getColumnDirection();

    /**
     * <p>getLanguage.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLanguage();

    /**
     * <p>isTableOfContents.</p>
     *
     * @return a boolean.
     */
    public boolean isTableOfContents();

    /**
     * <p>getTableOfContentsHeadings.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, JasperTocHeading> getTableOfContentsHeadings();

    /**
     * <p>getTableOfContentsCustomizer.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer} object.
     */
    public DRITableOfContentsCustomizer getTableOfContentsCustomizer();

    /**
     * <p>getFilterExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public DRIDesignExpression getFilterExpression();

    /**
     * <p>getParameters.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignParameter> getParameters();

    /**
     * <p>getParameterValues.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, Object> getParameterValues();

    /**
     * <p>getScriptlets.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIScriptlet> getScriptlets();

    /**
     * <p>getFields.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignField> getFields();

    /**
     * <p>getSystemExpressions.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignSystemExpression> getSystemExpressions();

    /**
     * <p>getJasperExpressions.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignJasperExpression> getJasperExpressions();

    /**
     * <p>getSimpleExpressions.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignSimpleExpression> getSimpleExpressions();

    /**
     * <p>getStyles.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignStyle> getStyles();

    /**
     * <p>getGroups.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<? extends DRIDesignGroup> getGroups();

    /**
     * <p>getVariables.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignVariable> getVariables();

    /**
     * <p>getComplexExpressions.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignComplexExpression> getComplexExpressions();

    /**
     * <p>getSorts.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignSort> getSorts();

    /**
     * <p>getDatasets.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignDataset> getDatasets();

    /**
     * <p>getTitleBand.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignBand} object.
     */
    public DRIDesignBand getTitleBand();

    /**
     * <p>getPageHeaderBand.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignBand} object.
     */
    public DRIDesignBand getPageHeaderBand();

    /**
     * <p>getPageFooterBand.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignBand} object.
     */
    public DRIDesignBand getPageFooterBand();

    /**
     * <p>getColumnHeaderBand.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignBand} object.
     */
    public DRIDesignBand getColumnHeaderBand();

    /**
     * <p>getColumnFooterBand.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignBand} object.
     */
    public DRIDesignBand getColumnFooterBand();

    /**
     * <p>getDetailBands.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<? extends DRIDesignBand> getDetailBands();

    /**
     * <p>getLastPageFooterBand.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignBand} object.
     */
    public DRIDesignBand getLastPageFooterBand();

    /**
     * <p>getSummaryBand.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignBand} object.
     */
    public DRIDesignBand getSummaryBand();

    /**
     * <p>getNoDataBand.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignBand} object.
     */
    public DRIDesignBand getNoDataBand();

    /**
     * <p>getBackgroundBand.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignBand} object.
     */
    public DRIDesignBand getBackgroundBand();
}

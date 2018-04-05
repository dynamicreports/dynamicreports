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
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

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

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public interface DRIDesignReport extends Serializable {

	public DRIDesignTemplateDesign getTemplateDesign();

	public String getReportName();

	public Locale getLocale();

	public ResourceBundle getResourceBundle();

	public String getResourceBundleName();

	public boolean isIgnorePagination();

	public Properties getProperties();

	public DRIDesignQuery getQuery();

	public DRIDesignPage getPage();

	public WhenNoDataType getWhenNoDataType();

	public WhenResourceMissingType getWhenResourceMissingType();

	public boolean isTitleOnANewPage();

	public boolean isSummaryOnANewPage();

	public boolean isSummaryWithPageHeaderAndFooter();

	public boolean isFloatColumnFooter();

	public Orientation getPrintOrder();

	public RunDirection getColumnDirection();

	public String getLanguage();

	public boolean isTableOfContents();

	public Map<String, JasperTocHeading> getTableOfContentsHeadings();

	public DRITableOfContentsCustomizer getTableOfContentsCustomizer();

	public DRIDesignExpression getFilterExpression();

	public Collection<DRIDesignParameter> getParameters();

	public Map<String, Object> getParameterValues();

	public Collection<DRIScriptlet> getScriptlets();

	public Collection<DRIDesignField> getFields();

	public Collection<DRIDesignSystemExpression> getSystemExpressions();

	public Collection<DRIDesignJasperExpression> getJasperExpressions();

	public Collection<DRIDesignSimpleExpression> getSimpleExpressions();

	public Collection<DRIDesignStyle> getStyles();

	public Collection<? extends DRIDesignGroup> getGroups();

	public Collection<DRIDesignVariable> getVariables();

	public Collection<DRIDesignComplexExpression> getComplexExpressions();

	public Collection<DRIDesignSort> getSorts();

	public Collection<DRIDesignDataset> getDatasets();

	public DRIDesignBand getTitleBand();

	public DRIDesignBand getPageHeaderBand();

	public DRIDesignBand getPageFooterBand();

	public DRIDesignBand getColumnHeaderBand();

	public DRIDesignBand getColumnFooterBand();

	public List<? extends DRIDesignBand> getDetailBands();

	public DRIDesignBand getLastPageFooterBand();

	public DRIDesignBand getSummaryBand();

	public DRIDesignBand getNoDataBand();

	public DRIDesignBand getBackgroundBand();
}

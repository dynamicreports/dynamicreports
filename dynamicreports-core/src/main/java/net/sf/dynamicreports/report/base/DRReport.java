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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import net.sf.dynamicreports.report.base.column.DRColumn;
import net.sf.dynamicreports.report.base.grid.DRColumnGrid;
import net.sf.dynamicreports.report.base.style.DRConditionalStyle;
import net.sf.dynamicreports.report.base.style.DRSimpleStyle;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.definition.DRIReport;
import net.sf.dynamicreports.report.definition.DRIScriptlet;
import net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer;
import net.sf.dynamicreports.report.definition.DRITemplateDesign;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIFont;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import net.sf.dynamicreports.report.definition.style.DRIStyle;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRReport implements DRIReport {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRReportTemplate template;
	private List<DRIStyle> templateStyles;
	private DRITemplateDesign<?> templateDesign;
	private String reportName;
	private Locale locale;
	private ResourceBundle resourceBundle;
	private String resourceBundleName;
	private Boolean ignorePagination;
	private Boolean showColumnTitle;
	private Boolean showColumnValues;
	private List<DRColumn<?>> columns;
	private List<DRGroup> groups;
	private List<DRSubtotal<?>> subtotals;
	private List<DRField<?>> fields;
	private List<DRVariable<?>> variables;
	private List<DRSort> sorts;
	private List<DRParameter<?>> parameters;
	private Map<String, Object> parameterValues;
	private List<DRIScriptlet> scriptlets;
	private Properties properties;
	private DRQuery query;
	private DRPage page;
	private WhenNoDataType whenNoDataType;
	private WhenResourceMissingType whenResourceMissingType;
	private Boolean titleOnANewPage;
	private Boolean summaryOnANewPage;
	private Boolean summaryWithPageHeaderAndFooter;
	private Boolean floatColumnFooter;
	private Orientation printOrder;
	private RunDirection columnDirection;
	private String language;
	private Boolean useFieldNameAsDescription;
	private Boolean highlightDetailOddRows;
	private DRSimpleStyle detailOddRowStyle;
	private Boolean highlightDetailEvenRows;
	private DRSimpleStyle detailEvenRowStyle;
	private List<DRConditionalStyle> detailRowHighlighters;
	private DRColumnGrid columnGrid;
	private Boolean tableOfContents;
	private DRITableOfContentsCustomizer tableOfContentsCustomizer;
	private DRIExpression<Boolean> filterExpression;

	private DRIFont defaultFont;
	private DRIReportStyle textStyle;
	private DRIReportStyle columnTitleStyle;
	private DRIReportStyle columnStyle;
	private DRIReportStyle groupTitleStyle;
	private DRIReportStyle groupStyle;
	private DRIReportStyle subtotalStyle;
	private DRIReportStyle imageStyle;
	private DRIReportStyle chartStyle;
	private DRIReportStyle barcodeStyle;

	private DRBand titleBand;
	private DRBand pageHeaderBand;
	private DRBand pageFooterBand;
	private DRBand columnHeaderBand;
	private DRBand columnFooterBand;
	private DRBand detailBand;
	private DRBand detailHeaderBand;
	private DRBand detailFooterBand;
	private DRBand lastPageFooterBand;
	private DRBand summaryBand;
	private DRBand noDataBand;
	private DRBand backgroundBand;

	public DRReport() {
		init();
	}

	private void init() {
		this.template = new DRReportTemplate();
		this.templateStyles = new ArrayList<DRIStyle>();
		this.columns = new ArrayList<DRColumn<?>>();
		this.groups = new ArrayList<DRGroup>();
		this.subtotals = new ArrayList<DRSubtotal<?>>();
		this.fields = new ArrayList<DRField<?>>();
		this.variables = new ArrayList<DRVariable<?>>();
		this.sorts = new ArrayList<DRSort>();
		this.parameters = new ArrayList<DRParameter<?>>();
		this.scriptlets = new ArrayList<DRIScriptlet>();
		this.detailRowHighlighters = new ArrayList<DRConditionalStyle>();
		this.properties = new Properties();
		this.page = new DRPage();

		titleBand = new DRBand();
		pageHeaderBand = new DRBand();
		pageFooterBand = new DRBand();
		columnHeaderBand = new DRBand();
		columnFooterBand = new DRBand();
		detailBand = new DRBand();
		detailHeaderBand = new DRBand();
		detailFooterBand = new DRBand();
		lastPageFooterBand = new DRBand();
		summaryBand = new DRBand();
		noDataBand = new DRBand();
		backgroundBand = new DRBand();
	}

	@Override
	public DRReportTemplate getTemplate() {
		return template;
	}

	public void setTemplate(DRReportTemplate template) {
		Validate.notNull(template, "template must not be null");
		this.template = template;
	}

	@Override
	public List<DRIStyle> getTemplateStyles() {
		return templateStyles;
	}

	public void addTemplateStyle(DRIStyle templateStyle) {
		Validate.notNull(templateStyle, "templateStyle must not be null");
		Validate.notNull(templateStyle.getName(), "templateStyle name must not be null");
		this.templateStyles.add(templateStyle);
	}

	public void setTemplateStyles(List<DRIStyle> templateStyles) {
		this.templateStyles = templateStyles;
	}

	@Override
	public DRITemplateDesign<?> getTemplateDesign() {
		return templateDesign;
	}

	public void setTemplateDesign(DRITemplateDesign<?> templateDesign) {
		Validate.notNull(templateDesign, "templateDesign must not be null");
		this.templateDesign = templateDesign;
	}

	@Override
	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	@Override
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Override
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

	@Override
	public String getResourceBundleName() {
		return resourceBundleName;
	}

	public void setResourceBundleName(String resourceBundleName) {
		this.resourceBundleName = resourceBundleName;
	}

	@Override
	public Boolean getShowColumnTitle() {
		return showColumnTitle;
	}

	public void setShowColumnTitle(Boolean showColumnTitle) {
		this.showColumnTitle = showColumnTitle;
	}

	@Override
	public Boolean getShowColumnValues() {
		return showColumnValues;
	}

	public void setShowColumnValues(Boolean showColumnValues) {
		this.showColumnValues = showColumnValues;
	}

	@Override
	public List<DRColumn<?>> getColumns() {
		return columns;
	}

	public void setColumns(List<DRColumn<?>> columns) {
		Validate.notNull(columns, "columns must not be null");
		Validate.noNullElements(columns, "columns must not contains null column");
		this.columns = columns;
	}

	public void addColumn(DRColumn<?> column) {
		Validate.notNull(column, "column must not be null");
		this.columns.add(column);
	}

	@Override
	public List<DRGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<DRGroup> groups) {
		Validate.notNull(groups, "groups must not be null");
		Validate.noNullElements(groups, "groups must not contains null group");
		this.groups = groups;
	}

	public void addGroup(DRGroup group) {
		Validate.notNull(group, "group must not be null");
		this.groups.add(group);
	}

	@Override
	public List<DRField<?>> getFields() {
		return fields;
	}

	public void setFields(List<DRField<?>> fields) {
		Validate.notNull(fields, "fields must not be null");
		Validate.noNullElements(fields, "fields must not contains null field");
		this.fields = fields;
	}

	public void addField(DRField<?> field) {
		Validate.notNull(field, "field must not be null");
		this.fields.add(field);
	}

	@Override
	public List<DRVariable<?>> getVariables() {
		return variables;
	}

	public void setVariables(List<DRVariable<?>> variables) {
		Validate.notNull(variables, "variables must not be null");
		Validate.noNullElements(variables, "variables must not contains null variable");
		this.variables = variables;
	}

	public void addVariable(DRVariable<?> variable) {
		Validate.notNull(variable, "variable must not be null");
		this.variables.add(variable);
	}

	@Override
	public List<DRSort> getSorts() {
		return sorts;
	}

	public void setSorts(List<DRSort> sorts) {
		Validate.notNull(sorts, "sorts must not be null");
		Validate.noNullElements(sorts, "sorts must not contains null sort");
		this.sorts = sorts;
	}

	public void addSort(DRSort sort) {
		Validate.notNull(sort, "sort must not be null");
		this.sorts.add(sort);
	}

	@Override
	public List<DRSubtotal<?>> getSubtotals() {
		return subtotals;
	}

	public void setSubtotals(List<DRSubtotal<?>> subtotals) {
		Validate.notNull(subtotals, "subtotals must not be null");
		Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
		this.subtotals = subtotals;
	}

	public void addSubtotal(DRSubtotal<?> subtotal) {
		Validate.notNull(subtotal, "subtotal must not be null");
		this.subtotals.add(subtotal);
	}

	@Override
	public List<DRParameter<?>> getParameters() {
		return parameters;
	}

	public void setParameters(List<DRParameter<?>> parameters) {
		Validate.notNull(parameters, "parameters must not be null");
		Validate.noNullElements(parameters, "parameters must not contains null parameter");
		this.parameters = parameters;
	}

	public void addParameter(DRParameter<?> parameter) {
		Validate.notNull(parameter, "parameter must not be null");
		this.parameters.add(parameter);
	}

	@Override
	public Map<String, Object> getParameterValues() {
		return parameterValues;
	}

	public void addParameterValue(String name, Object value) {
		Validate.notNull(name, "parameter name must not be null");
		if (parameterValues == null) {
			parameterValues = new HashMap<String, Object>();
		}
		this.parameterValues.put(name, value);
	}

	public void setParameterValues(Map<String, Object> parameterValues) {
		this.parameterValues = parameterValues;
	}

	@Override
	public List<DRIScriptlet> getScriptlets() {
		return scriptlets;
	}

	public void setScriptlets(List<DRIScriptlet> scriptlets) {
		Validate.notNull(scriptlets, "scriptlets must not be null");
		Validate.noNullElements(scriptlets, "scriptlets must not contains null scriptlet");
		this.scriptlets = scriptlets;
	}

	public void addScriptlet(DRIScriptlet scriptlet) {
		Validate.notNull(scriptlet, "scriptlet must not be null");
		this.scriptlets.add(scriptlet);
	}

	@Override
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		Validate.notNull(properties, "properties must not be null");
		this.properties = properties;
	}

	public void addProperty(String key, String value) {
		Validate.notNull(key, "key must not be null");
		this.properties.setProperty(key, value);
	}

	@Override
	public DRQuery getQuery() {
		return query;
	}

	public void setQuery(DRQuery query) {
		this.query = query;
	}

	@Override
	public DRPage getPage() {
		return page;
	}

	public void setPage(DRPage page) {
		Validate.notNull(page, "page must not be null");
		this.page = page;
	}

	@Override
	public Boolean getIgnorePagination() {
		return ignorePagination;
	}

	public void setIgnorePagination(Boolean ignorePagination) {
		this.ignorePagination = ignorePagination;
	}

	@Override
	public WhenNoDataType getWhenNoDataType() {
		return whenNoDataType;
	}

	public void setWhenNoDataType(WhenNoDataType whenNoDataType) {
		this.whenNoDataType = whenNoDataType;
	}

	@Override
	public WhenResourceMissingType getWhenResourceMissingType() {
		return whenResourceMissingType;
	}

	public void setWhenResourceMissingType(WhenResourceMissingType whenResourceMissingType) {
		this.whenResourceMissingType = whenResourceMissingType;
	}

	@Override
	public Boolean getTitleOnANewPage() {
		return titleOnANewPage;
	}

	public void setTitleOnANewPage(Boolean titleOnANewPage) {
		this.titleOnANewPage = titleOnANewPage;
	}

	@Override
	public Boolean getSummaryOnANewPage() {
		return summaryOnANewPage;
	}

	public void setSummaryOnANewPage(Boolean summaryOnANewPage) {
		this.summaryOnANewPage = summaryOnANewPage;
	}

	@Override
	public Boolean getSummaryWithPageHeaderAndFooter() {
		return summaryWithPageHeaderAndFooter;
	}

	public void setSummaryWithPageHeaderAndFooter(Boolean summaryWithPageHeaderAndFooter) {
		this.summaryWithPageHeaderAndFooter = summaryWithPageHeaderAndFooter;
	}

	@Override
	public Boolean getFloatColumnFooter() {
		return floatColumnFooter;
	}

	public void setFloatColumnFooter(Boolean floatColumnFooter) {
		this.floatColumnFooter = floatColumnFooter;
	}

	@Override
	public Orientation getPrintOrder() {
		return printOrder;
	}

	public void setPrintOrder(Orientation printOrder) {
		this.printOrder = printOrder;
	}

	@Override
	public RunDirection getColumnDirection() {
		return columnDirection;
	}

	public void setColumnDirection(RunDirection columnDirection) {
		this.columnDirection = columnDirection;
	}

	@Override
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public Boolean getUseFieldNameAsDescription() {
		return useFieldNameAsDescription;
	}

	public void setUseFieldNameAsDescription(Boolean useFieldNameAsDescription) {
		this.useFieldNameAsDescription = useFieldNameAsDescription;
	}

	@Override
	public DRIFont getDefaultFont() {
		return defaultFont;
	}

	public void setDefaultFont(DRIFont defaultFont) {
		this.defaultFont = defaultFont;
	}

	@Override
	public DRIReportStyle getTextStyle() {
		return textStyle;
	}

	public void setTextStyle(DRIReportStyle textStyle) {
		this.textStyle = textStyle;
	}

	@Override
	public DRIReportStyle getColumnTitleStyle() {
		return columnTitleStyle;
	}

	public void setColumnTitleStyle(DRIReportStyle columnTitleStyle) {
		this.columnTitleStyle = columnTitleStyle;
	}

	@Override
	public DRIReportStyle getColumnStyle() {
		return columnStyle;
	}

	public void setColumnStyle(DRIReportStyle columnStyle) {
		this.columnStyle = columnStyle;
	}

	@Override
	public DRIReportStyle getGroupTitleStyle() {
		return groupTitleStyle;
	}

	public void setGroupTitleStyle(DRIReportStyle groupTitleStyle) {
		this.groupTitleStyle = groupTitleStyle;
	}

	@Override
	public DRIReportStyle getGroupStyle() {
		return groupStyle;
	}

	public void setGroupStyle(DRIReportStyle groupStyle) {
		this.groupStyle = groupStyle;
	}

	@Override
	public DRIReportStyle getSubtotalStyle() {
		return subtotalStyle;
	}

	public void setSubtotalStyle(DRIReportStyle subtotalStyle) {
		this.subtotalStyle = subtotalStyle;
	}

	@Override
	public DRIReportStyle getImageStyle() {
		return imageStyle;
	}

	public void setImageStyle(DRIReportStyle imageStyle) {
		this.imageStyle = imageStyle;
	}

	@Override
	public DRIReportStyle getChartStyle() {
		return chartStyle;
	}

	public void setChartStyle(DRIReportStyle chartStyle) {
		this.chartStyle = chartStyle;
	}

	@Override
	public DRIReportStyle getBarcodeStyle() {
		return barcodeStyle;
	}

	public void setBarcodeStyle(DRIReportStyle barcodeStyle) {
		this.barcodeStyle = barcodeStyle;
	}

	@Override
	public Boolean getHighlightDetailOddRows() {
		return highlightDetailOddRows;
	}

	public void setHighlightDetailOddRows(Boolean highlightDetailOddRows) {
		this.highlightDetailOddRows = highlightDetailOddRows;
	}

	@Override
	public DRSimpleStyle getDetailOddRowStyle() {
		return detailOddRowStyle;
	}

	public void setDetailOddRowStyle(DRSimpleStyle detailOddRowStyle) {
		this.detailOddRowStyle = detailOddRowStyle;
	}

	@Override
	public Boolean getHighlightDetailEvenRows() {
		return highlightDetailEvenRows;
	}

	public void setHighlightDetailEvenRows(Boolean highlightDetailEvenRows) {
		this.highlightDetailEvenRows = highlightDetailEvenRows;
	}

	@Override
	public DRSimpleStyle getDetailEvenRowStyle() {
		return detailEvenRowStyle;
	}

	public void setDetailEvenRowStyle(DRSimpleStyle detailEvenRowStyle) {
		this.detailEvenRowStyle = detailEvenRowStyle;
	}

	@Override
	public List<DRConditionalStyle> getDetailRowHighlighters() {
		return detailRowHighlighters;
	}

	public void setDetailRowHighlighters(List<DRConditionalStyle> detailRowHighlighters) {
		Validate.notNull(detailRowHighlighters, "detailRowHighlighters must not be null");
		Validate.noNullElements(detailRowHighlighters, "detailRowHighlighters must not contains null detailRowHighlighter");
		this.detailRowHighlighters = detailRowHighlighters;
	}

	public void addDetailRowHighlighter(DRConditionalStyle detailRowHighlighter) {
		Validate.notNull(detailRowHighlighter, "detailRowHighlighter must not be null");
		this.detailRowHighlighters.add(detailRowHighlighter);
	}

	@Override
	public DRColumnGrid getColumnGrid() {
		return columnGrid;
	}

	public void setColumnGrid(DRColumnGrid columnGrid) {
		this.columnGrid = columnGrid;
	}

	@Override
	public Boolean getTableOfContents() {
		return tableOfContents;
	}

	public void setTableOfContents(Boolean tableOfContents) {
		this.tableOfContents = tableOfContents;
	}

	@Override
	public DRITableOfContentsCustomizer getTableOfContentsCustomizer() {
		return tableOfContentsCustomizer;
	}

	public void setTableOfContentsCustomizer(DRITableOfContentsCustomizer tableOfContentsCustomizer) {
		this.tableOfContentsCustomizer = tableOfContentsCustomizer;
	}

	@Override
	public DRIExpression<Boolean> getFilterExpression() {
		return filterExpression;
	}

	public void setFilterExpression(DRIExpression<Boolean> filterExpression) {
		this.filterExpression = filterExpression;
	}

	@Override
	public DRBand getTitleBand() {
		return titleBand;
	}

	@Override
	public DRBand getPageHeaderBand() {
		return pageHeaderBand;
	}

	@Override
	public DRBand getPageFooterBand() {
		return pageFooterBand;
	}

	@Override
	public DRBand getColumnHeaderBand() {
		return columnHeaderBand;
	}

	@Override
	public DRBand getColumnFooterBand() {
		return columnFooterBand;
	}

	@Override
	public DRBand getDetailBand() {
		return detailBand;
	}

	@Override
	public DRBand getDetailHeaderBand() {
		return detailHeaderBand;
	}

	@Override
	public DRBand getDetailFooterBand() {
		return detailFooterBand;
	}

	@Override
	public DRBand getLastPageFooterBand() {
		return lastPageFooterBand;
	}

	@Override
	public DRBand getSummaryBand() {
		return summaryBand;
	}

	@Override
	public DRBand getNoDataBand() {
		return noDataBand;
	}

	@Override
	public DRBand getBackgroundBand() {
		return backgroundBand;
	}
}

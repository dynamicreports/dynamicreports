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
package net.sf.dynamicreports.report.builder;

import net.sf.dynamicreports.report.base.DRGroup;
import net.sf.dynamicreports.report.base.DRReport;
import net.sf.dynamicreports.report.base.grid.DRColumnGrid;
import net.sf.dynamicreports.report.builder.column.ColumnBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder;
import net.sf.dynamicreports.report.builder.group.GroupBuilder;
import net.sf.dynamicreports.report.builder.group.Groups;
import net.sf.dynamicreports.report.builder.style.ConditionalStyleBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder;
import net.sf.dynamicreports.report.builder.subtotal.PercentageSubtotalBuilder;
import net.sf.dynamicreports.report.builder.subtotal.SubtotalBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.QueryLanguage;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.constant.SubtotalPosition;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.definition.DRIScriptlet;
import net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * <p>ReportBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
@SuppressWarnings("unchecked")
public class ReportBuilder<T extends ReportBuilder<T>> extends AbstractBuilder<T, DRReport> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    public ReportBuilder() {
        super(new DRReport());
    }

    public T setReportName(String reportName) {
        getObject().setReportName(reportName);
        return (T) this;
    }

    public T setLocale(Locale locale) {
        getObject().setLocale(locale);
        return (T) this;
    }

    public T setResourceBundle(ResourceBundle resourceBundle) {
        getObject().setResourceBundle(resourceBundle);
        return (T) this;
    }

    public T setResourceBundle(String resourceBundleName) {
        getObject().setResourceBundleName(resourceBundleName);
        return (T) this;
    }

    public T setShowColumnTitle(Boolean showColumnTitle) {
        getObject().setShowColumnTitle(showColumnTitle);
        return (T) this;
    }

    public T setShowColumnValues(Boolean showColumnValues) {
        getObject().setShowColumnValues(showColumnValues);
        return (T) this;
    }

    public T setPageFormat(PageType pageType) {
        return setPageFormat(pageType, PageOrientation.PORTRAIT);
    }

    public T setPageFormat(PageType pageType, PageOrientation orientation) {
        getObject().getPage().setPageFormat(pageType, orientation);
        return (T) this;
    }

    public T setPageFormat(Integer width, Integer height, PageOrientation orientation) {
        getObject().getPage().setPageFormat(width, height, orientation);
        return (T) this;
    }

    public T setPageMargin(MarginBuilder margin) {
        Validate.notNull(margin, "margin must not be null");
        getObject().getPage().setMargin(margin.build());
        return (T) this;
    }

    public T setPageColumnsPerPage(Integer columnsPerPage) {
        getObject().getPage().setColumnsPerPage(columnsPerPage);
        return (T) this;
    }

    public T setPageColumnSpace(Integer columnSpace) {
        getObject().getPage().setColumnSpace(columnSpace);
        return (T) this;
    }

    public T ignorePageWidth() {
        return setIgnorePageWidth(true);
    }

    public T setIgnorePageWidth(Boolean ignorePageWidth) {
        getObject().getPage().setIgnorePageWidth(ignorePageWidth);
        return (T) this;
    }

    public T ignorePagination() {
        return setIgnorePagination(true);
    }

    public T setIgnorePagination(Boolean ignorePagination) {
        getObject().setIgnorePagination(ignorePagination);
        return (T) this;
    }

    public T setWhenNoDataType(WhenNoDataType whenNoDataType) {
        getObject().setWhenNoDataType(whenNoDataType);
        return (T) this;
    }

    public T setWhenResourceMissingType(WhenResourceMissingType whenResourceMissingType) {
        getObject().setWhenResourceMissingType(whenResourceMissingType);
        return (T) this;
    }

    /**
     * Prints the title band on a separate page.
     *
     * @return a report builder
     */
    public T titleOnANewPage() {
        return setTitleOnANewPage(true);
    }

    /**
     * Sets whether or not the title band is printed on a separate page.
     *
     * @param titleOnANewPage print the title band on a separate page
     * @return a report builder
     */
    public T setTitleOnANewPage(Boolean titleOnANewPage) {
        getObject().setTitleOnANewPage(titleOnANewPage);
        return (T) this;
    }

    /**
     * Prints the summary band on a separate page.
     *
     * @return a report builder
     */
    public T summaryOnANewPage() {
        return setSummaryOnANewPage(true);
    }

    /**
     * Sets whether or not the summary band is printed on a separate page.
     *
     * @param summaryOnANewPage print the summary band on a separate page
     * @return a report builder
     */
    public T setSummaryOnANewPage(Boolean summaryOnANewPage) {
        getObject().setSummaryOnANewPage(summaryOnANewPage);
        return (T) this;
    }

    /**
     * Prints the summary band with the page header and footer.
     *
     * @return a report builder
     */
    public T summaryWithPageHeaderAndFooter() {
        return setSummaryWithPageHeaderAndFooter(true);
    }

    /**
     * Sets whether or not the summary band is printed with the page header and footer.
     *
     * @param summaryWithPageHeaderAndFooter print the summary band with the page header and footer
     * @return a report builder
     */
    public T setSummaryWithPageHeaderAndFooter(Boolean summaryWithPageHeaderAndFooter) {
        getObject().setSummaryWithPageHeaderAndFooter(summaryWithPageHeaderAndFooter);
        return (T) this;
    }

    /**
     * Prints the column footer band at the bottom of the column.
     *
     * @return a report builder
     */
    public T floatColumnFooter() {
        return setFloatColumnFooter(true);
    }

    /**
     * Sets whether or not the column footer band is printed at the bottom of the column
     *
     * @param floatColumnFooter print the column footer at the bottom of the column
     * @return a report builder
     */
    public T setFloatColumnFooter(Boolean floatColumnFooter) {
        getObject().setFloatColumnFooter(floatColumnFooter);
        return (T) this;
    }

    public T setPrintOrder(Orientation printOrder) {
        getObject().setPrintOrder(printOrder);
        return (T) this;
    }

    public T setColumnDirection(RunDirection columnDirection) {
        getObject().setColumnDirection(columnDirection);
        return (T) this;
    }

    public T setLanguage(String language) {
        getObject().setLanguage(language);
        return (T) this;
    }

    public T setUseFieldNameAsDescription(Boolean useFieldNameAsDescription) {
        getObject().setUseFieldNameAsDescription(useFieldNameAsDescription);
        return (T) this;
    }

    public T scriptlets(DRIScriptlet... scriptlets) {
        return addScriptlet(scriptlets);
    }

    public T addScriptlet(DRIScriptlet... scriptlets) {
        Validate.notNull(scriptlets, "scriptlets must not be null");
        Validate.noNullElements(scriptlets, "scriptlets must not contains null scriptlet");
        for (DRIScriptlet scriptlet : scriptlets) {
            getObject().addScriptlet(scriptlet);
        }
        return (T) this;
    }

    public T setProperties(Properties properties) {
        getObject().setProperties(properties);
        return (T) this;
    }

    public T addProperty(String key, String value) {
        getObject().addProperty(key, value);
        return (T) this;
    }

    public T setQuery(String text, String language) {
        Validate.notNull(text, "text must not be null");
        Validate.notNull(language, "language must not be null");
        return setQuery(DynamicReports.query(text, language));
    }

    public T setQuery(String sql) {
        Validate.notNull(sql, "sql must not be null");
        return setQuery(DynamicReports.query(sql, QueryLanguage.SQL));
    }

    public T setQuery(QueryBuilder query) {
        Validate.notNull(query, "query must not be null");
        getObject().setQuery(query.build());
        return (T) this;
    }

    public T columnGrid(ListType type) {
        getObject().setColumnGrid(new DRColumnGrid(type));
        return (T) this;
    }

    public T columnGrid(ColumnGridComponentBuilder... components) {
        return columnGrid(ListType.HORIZONTAL, components);
    }

    public T columnGrid(ListType type, ColumnGridComponentBuilder... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        DRColumnGrid columnGrid = new DRColumnGrid(type);
        for (ColumnGridComponentBuilder component : components) {
            columnGrid.addComponent(component.build());
        }
        getObject().setColumnGrid(columnGrid);
        return (T) this;
    }

    // template
    public T setTemplate(ReportTemplateBuilder template) {
        Validate.notNull(template, "template must not be null");
        getObject().setTemplate(template.build());
        return (T) this;
    }

    // template style
    public T templateStyles(TemplateStylesBuilder... templateStyles) {
        return addTemplateStyle(templateStyles);
    }

    public T addTemplateStyle(TemplateStylesBuilder... templateStyles) {
        Validate.notNull(templateStyles, "templateStyles must not be null");
        Validate.noNullElements(templateStyles, "templateStyles must not contains null templateStyle");
        for (TemplateStylesBuilder templateStyle : templateStyles) {
            for (StyleBuilder style : templateStyle.getStyles()) {
                addTemplateStyle(style);
            }
        }
        return (T) this;
    }

    public T templateStyles(StyleBuilder... templateStyles) {
        return addTemplateStyle(templateStyles);
    }

    public T addTemplateStyle(StyleBuilder... templateStyles) {
        Validate.notNull(templateStyles, "templateStyles must not be null");
        Validate.noNullElements(templateStyles, "templateStyles must not contains null templateStyle");
        for (StyleBuilder templateStyle : templateStyles) {
            getObject().addTemplateStyle(templateStyle.build());
        }
        return (T) this;
    }

    // parameter
    public T parameters(ParameterBuilder<?>... parameters) {
        return addParameter(parameters);
    }

    public T addParameter(String name, Object value) {
        return addParameter(DynamicReports.parameter(name, value));
    }

    public T addParameter(String name, Class<?> valueClass) {
        return addParameter(DynamicReports.parameter(name, valueClass));
    }

    public T addParameter(ParameterBuilder<?>... parameters) {
        Validate.notNull(parameters, "parameters must not be null");
        Validate.noNullElements(parameters, "parameters must not contains null parameter");
        for (ParameterBuilder<?> parameter : parameters) {
            getObject().addParameter(parameter.build());
        }
        return (T) this;
    }

    public T setParameter(String name, Object value) {
        getObject().addParameterValue(name, value);
        return (T) this;
    }

    public T setParameters(Map<String, Object> parameters) {
        getObject().setParameterValues(parameters);
        return (T) this;
    }

    // field
    public T fields(FieldBuilder<?>... fields) {
        return addField(fields);
    }

    public T addField(String name, Class<?> valueClass) {
        return addField(DynamicReports.field(name, valueClass));
    }

    public <U> T addField(String name, DRIDataType<? super U, U> dataType) {
        return addField(DynamicReports.field(name, dataType));
    }

    public T addField(FieldBuilder<?>... fields) {
        Validate.notNull(fields, "fields must not be null");
        Validate.noNullElements(fields, "fields must not contains null field");
        for (FieldBuilder<?> field : fields) {
            getObject().addField(field.build());
        }
        return (T) this;
    }

    // variable
    public T variables(VariableBuilder<?>... variables) {
        return addVariable(variables);
    }

    public T addVariable(VariableBuilder<?>... variables) {
        Validate.notNull(variables, "variables must not be null");
        Validate.noNullElements(variables, "variables must not contains null variable");
        for (VariableBuilder<?> variable : variables) {
            getObject().addVariable(variable.getVariable());
        }
        return (T) this;
    }

    /**
     * Adds a sort field to the dataset
     *
     * @param sortColumns columns to be sorted
     * @return a report builder
     */
    public T sortBy(TextColumnBuilder<?>... sortColumns) {
        Validate.notNull(sortColumns, "sortColumns must not be null");
        Validate.noNullElements(sortColumns, "sortColumns must not contains null sortColumn");
        for (TextColumnBuilder<?> sortColumn : sortColumns) {
            sortBy(DynamicReports.asc(sortColumn));
        }
        return (T) this;
    }

    /**
     * Adds a sort field to the dataset
     *
     * @param sorts the sort definitions
     * @return a report builder
     */
    public T sortBy(SortBuilder... sorts) {
        return addSort(sorts);
    }

    /**
     * Adds a sort field to the dataset
     *
     * @param sorts the sort definitions
     * @return a report builder
     */
    public T addSort(SortBuilder... sorts) {
        Validate.notNull(sorts, "sorts must not be null");
        Validate.noNullElements(sorts, "sorts must not contains null sort");
        for (SortBuilder sort : sorts) {
            getObject().addSort(sort.build());
        }
        return (T) this;
    }

    // column
    public T columns(ColumnBuilder<?, ?>... columns) {
        return addColumn(columns);
    }

    public T addColumn(ColumnBuilder<?, ?>... columns) {
        Validate.notNull(columns, "columns must not be null");
        Validate.noNullElements(columns, "columns must not contains null column");
        for (ColumnBuilder<?, ?> column : columns) {
            getObject().addColumn(column.build());
        }
        return (T) this;
    }

    // style
    public T setDefaultFont(FontBuilder defaultFont) {
        if (defaultFont != null) {
            getObject().setDefaultFont(defaultFont.build());
        } else {
            getObject().setDefaultFont(null);
        }
        return (T) this;
    }

    public T setTextStyle(ReportStyleBuilder textStyle) {
        if (textStyle != null) {
            getObject().setTextStyle(textStyle.build());
        } else {
            getObject().setTextStyle(null);
        }
        return (T) this;
    }

    public T setColumnTitleStyle(ReportStyleBuilder columnTitleStyle) {
        if (columnTitleStyle != null) {
            getObject().setColumnTitleStyle(columnTitleStyle.build());
        } else {
            getObject().setColumnTitleStyle(null);
        }
        return (T) this;
    }

    public T setColumnStyle(ReportStyleBuilder columnStyle) {
        if (columnStyle != null) {
            getObject().setColumnStyle(columnStyle.build());
        } else {
            getObject().setColumnStyle(null);
        }
        return (T) this;
    }

    public T setGroupTitleStyle(ReportStyleBuilder groupTitleStyle) {
        if (groupTitleStyle != null) {
            getObject().setGroupTitleStyle(groupTitleStyle.build());
        } else {
            getObject().setGroupTitleStyle(null);
        }
        return (T) this;
    }

    public T setGroupStyle(ReportStyleBuilder groupStyle) {
        if (groupStyle != null) {
            getObject().setGroupStyle(groupStyle.build());
        } else {
            getObject().setGroupStyle(null);
        }
        return (T) this;
    }

    public T setSubtotalStyle(ReportStyleBuilder subtotalStyle) {
        if (subtotalStyle != null) {
            getObject().setSubtotalStyle(subtotalStyle.build());
        } else {
            getObject().setSubtotalStyle(null);
        }
        return (T) this;
    }

    public T setImageStyle(ReportStyleBuilder imageStyle) {
        if (imageStyle != null) {
            getObject().setImageStyle(imageStyle.build());
        } else {
            getObject().setImageStyle(null);
        }
        return (T) this;
    }

    public T setChartStyle(ReportStyleBuilder chartStyle) {
        if (chartStyle != null) {
            getObject().setChartStyle(chartStyle.build());
        } else {
            getObject().setChartStyle(null);
        }
        return (T) this;
    }

    public T setBarcodeStyle(ReportStyleBuilder barcodeStyle) {
        if (barcodeStyle != null) {
            getObject().setBarcodeStyle(barcodeStyle.build());
        } else {
            getObject().setBarcodeStyle(null);
        }
        return (T) this;
    }

    // row highlighter
    public T highlightDetailOddRows() {
        return setHighlightDetailOddRows(true);
    }

    public T setHighlightDetailOddRows(Boolean highlightDetailOddRows) {
        getObject().setHighlightDetailOddRows(highlightDetailOddRows);
        return (T) this;
    }

    public T setDetailOddRowStyle(SimpleStyleBuilder detailOddRowStyle) {
        if (detailOddRowStyle != null) {
            getObject().setDetailOddRowStyle(detailOddRowStyle.build());
        } else {
            getObject().setDetailOddRowStyle(null);
        }
        return (T) this;
    }

    public T highlightDetailEvenRows() {
        return setHighlightDetailEvenRows(true);
    }

    public T setHighlightDetailEvenRows(Boolean highlightDetailEvenRows) {
        getObject().setHighlightDetailEvenRows(highlightDetailEvenRows);
        return (T) this;
    }

    public T setDetailEvenRowStyle(SimpleStyleBuilder detailEvenRowStyle) {
        if (detailEvenRowStyle != null) {
            getObject().setDetailEvenRowStyle(detailEvenRowStyle.build());
        } else {
            getObject().setDetailEvenRowStyle(null);
        }
        return (T) this;
    }

    public T detailRowHighlighters(ConditionalStyleBuilder... detailRowHighlighters) {
        return addDetailRowHighlighter(detailRowHighlighters);
    }

    public T addDetailRowHighlighter(ConditionalStyleBuilder... detailRowHighlighters) {
        Validate.notNull(detailRowHighlighters, "detailRowHighlighters must not be null");
        Validate.noNullElements(detailRowHighlighters, "detailRowHighlighters must not contains null detailRowHighlighter");
        for (ConditionalStyleBuilder conditionalStyleBuilder : detailRowHighlighters) {
            getObject().addDetailRowHighlighter(conditionalStyleBuilder.build());
        }
        return (T) this;
    }

    // subtotal
    public T subtotalsAtTitle(SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtTitle(subtotals);
    }

    public T addSubtotalAtTitle(SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.TITLE).build());
        }
        return (T) this;
    }

    public T subtotalsAtPageHeader(SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtPageHeader(subtotals);
    }

    public T addSubtotalAtPageHeader(SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.PAGE_HEADER).build());
        }
        return (T) this;
    }

    public T subtotalsAtPageFooter(SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtPageFooter(subtotals);
    }

    public T addSubtotalAtPageFooter(SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.PAGE_FOOTER).build());
        }
        return (T) this;
    }

    public T subtotalsAtColumnHeader(SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtColumnHeader(subtotals);
    }

    public T addSubtotalAtColumnHeader(SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.COLUMN_HEADER).build());
        }
        return (T) this;
    }

    public T subtotalsAtColumnFooter(SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtColumnFooter(subtotals);
    }

    public T addSubtotalAtColumnFooter(SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.COLUMN_FOOTER).build());
        }
        return (T) this;
    }

    public T subtotalsAtGroupHeader(GroupBuilder<?> group, SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtGroupHeader(group, subtotals);
    }

    public T addSubtotalAtGroupHeader(GroupBuilder<?> group, SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(group, "group must not be null");
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.GROUP_HEADER).setGroup(group).build());
        }
        return (T) this;
    }

    public T subtotalsAtGroupFooter(GroupBuilder<?> group, SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtGroupFooter(group, subtotals);
    }

    public T addSubtotalAtGroupFooter(GroupBuilder<?> group, SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(group, "group must not be null");
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.GROUP_FOOTER).setGroup(group).build());
        }
        return (T) this;
    }

    public T subtotalsAtFirstGroupHeader(SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtFirstGroupHeader(subtotals);
    }

    public T addSubtotalAtFirstGroupHeader(SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.FIRST_GROUP_HEADER).build());
        }
        return (T) this;
    }

    public T subtotalsAtFirstGroupFooter(SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtFirstGroupFooter(subtotals);
    }

    public T addSubtotalAtFirstGroupFooter(SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.FIRST_GROUP_FOOTER).build());
        }
        return (T) this;
    }

    public T subtotalsAtLastGroupHeader(SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtLastGroupHeader(subtotals);
    }

    public T addSubtotalAtLastGroupHeader(SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.LAST_GROUP_HEADER).build());
        }
        return (T) this;
    }

    public T subtotalsAtLastGroupFooter(SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtLastGroupFooter(subtotals);
    }

    public T addSubtotalAtLastGroupFooter(SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.LAST_GROUP_FOOTER).build());
        }
        return (T) this;
    }

    public T subtotalsAtLastPageFooter(SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtLastPageFooter(subtotals);
    }

    public T addSubtotalAtLastPageFooter(SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.LAST_PAGE_FOOTER).build());
        }
        return (T) this;
    }

    public T subtotalsAtSummary(SubtotalBuilder<?, ?>... subtotals) {
        return addSubtotalAtSummary(subtotals);
    }

    public T addSubtotalAtSummary(SubtotalBuilder<?, ?>... subtotals) {
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (SubtotalBuilder<?, ?> subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.SUMMARY).build());
        }
        return (T) this;
    }

    public T subtotalsOfPercentageAtGroupHeader(GroupBuilder<?> group, PercentageSubtotalBuilder... subtotals) {
        return addSubtotalOfPercentageAtGroupHeader(group, subtotals);
    }

    public T addSubtotalOfPercentageAtGroupHeader(GroupBuilder<?> group, PercentageSubtotalBuilder... subtotals) {
        Validate.notNull(group, "group must not be null");
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (PercentageSubtotalBuilder subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.GROUP_HEADER).setGroup(group).build());
        }
        return (T) this;
    }

    public T subtotalsOfPercentageAtGroupFooter(GroupBuilder<?> group, PercentageSubtotalBuilder... subtotals) {
        return addSubtotalOfPercentageAtGroupFooter(group, subtotals);
    }

    public T addSubtotalOfPercentageAtGroupFooter(GroupBuilder<?> group, PercentageSubtotalBuilder... subtotals) {
        Validate.notNull(group, "group must not be null");
        Validate.notNull(subtotals, "subtotals must not be null");
        Validate.noNullElements(subtotals, "subtotals must not contains null subtotal");
        for (PercentageSubtotalBuilder subtotal : subtotals) {
            getObject().addSubtotal(subtotal.setPosition(SubtotalPosition.GROUP_FOOTER).setGroup(group).build());
        }
        return (T) this;
    }

    // group
    public T groupBy(ValueColumnBuilder<?, ?>... groupColumns) {
        Validate.notNull(groupColumns, "groupColumns must not be null");
        Validate.noNullElements(groupColumns, "groupColumns must not contains null groupColumn");
        for (ValueColumnBuilder<?, ?> groupColumn : groupColumns) {
            addGroup(Groups.group(groupColumn));
        }
        return (T) this;
    }

    public T groupBy(GroupBuilder<?>... groups) {
        return addGroup(groups);
    }

    public T addGroup(GroupBuilder<?>... groups) {
        Validate.notNull(groups, "groups must not be null");
        Validate.noNullElements(groups, "groups must not contains null group");
        for (GroupBuilder<?> group : groups) {
            getObject().addGroup(group.build());
        }
        return (T) this;
    }

    // table of contents
    public T tableOfContents() {
        return setTableOfContents(true);
    }

    public T tableOfContents(TableOfContentsCustomizerBuilder tableOfContentsCustomizer) {
        return setTableOfContents(tableOfContentsCustomizer);
    }

    public T tableOfContents(DRITableOfContentsCustomizer tableOfContentsCustomizer) {
        return setTableOfContents(tableOfContentsCustomizer);
    }

    public T setTableOfContents(Boolean tableOfContents) {
        getObject().setTableOfContents(tableOfContents);
        return (T) this;
    }

    public T setTableOfContents(TableOfContentsCustomizerBuilder tableOfContentsCustomizer) {
        getObject().setTableOfContentsCustomizer(tableOfContentsCustomizer.build());
        return setTableOfContents(true);
    }

    public T setTableOfContents(DRITableOfContentsCustomizer tableOfContentsCustomizer) {
        getObject().setTableOfContentsCustomizer(tableOfContentsCustomizer);
        return setTableOfContents(true);
    }

    /**
     * Sets a dataset filter expression.
     * The expression must be a type of Boolean
     *
     * @param filterExpression the filter expression
     * @return a report builder
     */
    public T setFilterExpression(DRIExpression<Boolean> filterExpression) {
        getObject().setFilterExpression(filterExpression);
        return (T) this;
    }

    // title

    /**
     * Sets the title band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the title split type
     * @return a report builder
     */
    public T setTitleSplitType(SplitType splitType) {
        getObject().getTitleBand().setSplitType(splitType);
        return (T) this;
    }

    public T setTitlePrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getTitleBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a title band style
     *
     * @param style the title band style
     * @return a report builder
     */
    public T setTitleStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getTitleBand().getList().setStyle(style.build());
        } else {
            getObject().getTitleBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setTitleBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getTitleBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the title band.
     * The band is printed on the first page and only once.
     *
     * @param components the title components
     * @return a report builder
     */
    public T title(ComponentBuilder<?, ?>... components) {
        return addTitle(components);
    }

    /**
     * Adds components to the title band.
     * The band is printed on the first page and only once.
     *
     * @param components the title components
     * @return a report builder
     */
    public T addTitle(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getTitleBand().addComponent(component.build());
        }
        return (T) this;
    }

    // page header band

    /**
     * Sets the page header band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the page header split type
     * @return a report builder
     */
    public T setPageHeaderSplitType(SplitType splitType) {
        getObject().getPageHeaderBand().setSplitType(splitType);
        return (T) this;
    }

    public T setPageHeaderPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getPageHeaderBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a page header band style
     *
     * @param style the page header band style
     * @return a report builder
     */
    public T setPageHeaderStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getPageHeaderBand().getList().setStyle(style.build());
        } else {
            getObject().getPageHeaderBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setPageHeaderBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getPageHeaderBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the page header band.
     * The band is printed on each page at the top of the page.
     *
     * @param components the page header components
     * @return a report builder
     */
    public T pageHeader(ComponentBuilder<?, ?>... components) {
        return addPageHeader(components);
    }

    /**
     * Adds components to the page header band.
     * The band is printed on each page at the top of the page.
     *
     * @param components the page header components
     * @return a report builder
     */
    public T addPageHeader(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getPageHeaderBand().addComponent(component.build());
        }
        return (T) this;
    }

    // page footer band

    /**
     * Sets the page footer band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the page footer split type
     * @return a report builder
     */
    public T setPageFooterSplitType(SplitType splitType) {
        getObject().getPageFooterBand().setSplitType(splitType);
        return (T) this;
    }

    public T setPageFooterPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getPageFooterBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a page footer band style
     *
     * @param style the page footer band style
     * @return a report builder
     */
    public T setPageFooterStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getPageFooterBand().getList().setStyle(style.build());
        } else {
            getObject().getPageFooterBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setPageFooterBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getPageFooterBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the page footer band.
     * The band is printed on each page at the bottom of the page.
     *
     * @param components the page footer components
     * @return a report builder
     */
    public T pageFooter(ComponentBuilder<?, ?>... components) {
        return addPageFooter(components);
    }

    /**
     * Adds components to the page footer band.
     * The band is printed on each page at the bottom of the page.
     *
     * @param components the page footer components
     * @return a report builder
     */
    public T addPageFooter(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getPageFooterBand().addComponent(component.build());
        }
        return (T) this;
    }

    // column header band

    /**
     * Sets the column header band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the column header split type
     * @return a report builder
     */
    public T setColumnHeaderSplitType(SplitType splitType) {
        getObject().getColumnHeaderBand().setSplitType(splitType);
        return (T) this;
    }

    public T setColumnHeaderPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getColumnHeaderBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a column header band style
     *
     * @param style the column header band style
     * @return a report builder
     */
    public T setColumnHeaderStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getColumnHeaderBand().getList().setStyle(style.build());
        } else {
            getObject().getColumnHeaderBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setColumnHeaderBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getColumnHeaderBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the column header band.
     * The band is printed on each page at the top of the page and it's placed below the page header band.
     *
     * @param components the column header components
     * @return a report builder
     */
    public T columnHeader(ComponentBuilder<?, ?>... components) {
        return addColumnHeader(components);
    }

    /**
     * Adds components to the column header band.
     * The band is printed on each page at the top of the page and it's placed below the page header band.
     *
     * @param components the column header components
     * @return a report builder
     */
    public T addColumnHeader(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getColumnHeaderBand().addComponent(component.build());
        }
        return (T) this;
    }

    // column footer band

    /**
     * Sets the column footer band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the column footer split type
     * @return a report builder
     */
    public T setColumnFooterSplitType(SplitType splitType) {
        getObject().getColumnFooterBand().setSplitType(splitType);
        return (T) this;
    }

    public T setColumnFooterPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getColumnFooterBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a column footer band style
     *
     * @param style the column footer band style
     * @return a report builder
     */
    public T setColumnFooterStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getColumnFooterBand().getList().setStyle(style.build());
        } else {
            getObject().getColumnFooterBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setColumnFooterBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getColumnFooterBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the column footer band.
     * The band is printed on each page at the bottom of the page and it's placed above the page footer band.
     *
     * @param components the column footer components
     * @return a report builder
     */
    public T columnFooter(ComponentBuilder<?, ?>... components) {
        return addColumnFooter(components);
    }

    /**
     * Adds components to the column footer band.
     * The band is printed on each page at the bottom of the page and it's placed above the page footer band.
     *
     * @param components the column footer components
     * @return a report builder
     */
    public T addColumnFooter(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getColumnFooterBand().addComponent(component.build());
        }
        return (T) this;
    }

    // group header band

    /**
     * Sets the group header band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param group     the group to which to apply the split type
     * @param splitType the group header split type
     * @return a report builder
     */
    public T setGroupHeaderSplitType(GroupBuilder<?> group, SplitType splitType) {
        Validate.notNull(group, "group must not be null");
        int index = getObject().getGroups().indexOf(group.getGroup());
        Validate.isTrue(index >= 0, "group must be registered");
        DRGroup drGroup = getObject().getGroups().get(index);
        drGroup.getHeaderBand().setSplitType(splitType);
        return (T) this;
    }

    public T setGroupHeaderPrintWhenExpression(GroupBuilder<?> group, DRIExpression<Boolean> printWhenExpression) {
        Validate.notNull(group, "group must not be null");
        int index = getObject().getGroups().indexOf(group.getGroup());
        Validate.isTrue(index >= 0, "group must be registered");
        DRGroup drGroup = getObject().getGroups().get(index);
        drGroup.getHeaderBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a group header band style
     *
     * @param group the group to which to apply the style
     * @param style the group header band style
     * @return a report builder
     */
    public T setGroupHeaderStyle(GroupBuilder<?> group, ReportStyleBuilder style) {
        Validate.notNull(group, "group must not be null");
        int index = getObject().getGroups().indexOf(group.getGroup());
        Validate.isTrue(index >= 0, "group must be registered");
        DRGroup drGroup = getObject().getGroups().get(index);
        if (style != null) {
            drGroup.getHeaderBand().getList().setStyle(style.build());
        } else {
            drGroup.getHeaderBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setGroupHeaderBackgroundComponent(GroupBuilder<?> group, ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        Validate.notNull(group, "group must not be null");
        int index = getObject().getGroups().indexOf(group.getGroup());
        Validate.isTrue(index >= 0, "group must be registered");
        DRGroup drGroup = getObject().getGroups().get(index);
        drGroup.getHeaderBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the group header band.
     * The band is printed for each data group. It's placed above the grouped data and between the column header and footer.
     *
     * @param group      the group to which to add the components
     * @param components the group header components
     * @return a report builder
     */
    public T groupHeader(GroupBuilder<?> group, ComponentBuilder<?, ?>... components) {
        return addGroupHeader(group, components);
    }

    /**
     * Adds components to the group header band.
     * The band is printed for each data group. It's placed above the grouped data and between the column header and footer.
     *
     * @param group      the group to which to add the components
     * @param components the group header components
     * @return a report builder
     */
    public T addGroupHeader(GroupBuilder<?> group, ComponentBuilder<?, ?>... components) {
        Validate.notNull(group, "group must not be null");
        int index = getObject().getGroups().indexOf(group.getGroup());
        Validate.isTrue(index >= 0, "group must be registered");
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        DRGroup drGroup = getObject().getGroups().get(index);
        for (ComponentBuilder<?, ?> component : components) {
            drGroup.getHeaderBand().addComponent(component.build());
        }
        return (T) this;
    }

    // group footer band

    /**
     * Sets the group footer band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param group     the group to which to apply the split type
     * @param splitType the group footer split type
     * @return a report builder
     */
    public T setGroupFooterSplitType(GroupBuilder<?> group, SplitType splitType) {
        Validate.notNull(group, "group must not be null");
        int index = getObject().getGroups().indexOf(group.getGroup());
        Validate.isTrue(index >= 0, "group must be registered");
        DRGroup drGroup = getObject().getGroups().get(index);
        drGroup.getFooterBand().setSplitType(splitType);
        return (T) this;
    }

    public T setGroupFooterPrintWhenExpression(GroupBuilder<?> group, DRIExpression<Boolean> printWhenExpression) {
        Validate.notNull(group, "group must not be null");
        int index = getObject().getGroups().indexOf(group.getGroup());
        Validate.isTrue(index >= 0, "group must be registered");
        DRGroup drGroup = getObject().getGroups().get(index);
        drGroup.getFooterBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a group footer band style
     *
     * @param group the group to which to apply the style
     * @param style the group footer band style
     * @return a report builder
     */
    public T setGroupFooterStyle(GroupBuilder<?> group, ReportStyleBuilder style) {
        Validate.notNull(group, "group must not be null");
        int index = getObject().getGroups().indexOf(group.getGroup());
        Validate.isTrue(index >= 0, "group must be registered");
        DRGroup drGroup = getObject().getGroups().get(index);
        if (style != null) {
            drGroup.getFooterBand().getList().setStyle(style.build());
        } else {
            drGroup.getFooterBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setGroupFooterBackgroundComponent(GroupBuilder<?> group, ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        Validate.notNull(group, "group must not be null");
        int index = getObject().getGroups().indexOf(group.getGroup());
        Validate.isTrue(index >= 0, "group must be registered");
        DRGroup drGroup = getObject().getGroups().get(index);
        drGroup.getFooterBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the group footer band.
     * The band is printed for each data group. It's placed below the grouped data and between the column header and footer.
     *
     * @param group      the group to which to add the components
     * @param components the group footer components
     * @return a report builder
     */
    public T groupFooter(GroupBuilder<?> group, ComponentBuilder<?, ?>... components) {
        return addGroupFooter(group, components);
    }

    /**
     * Adds components to the group footer band.
     * The band is printed for each data group. It's placed below the grouped data and between the column header and footer.
     *
     * @param group      the group to which to add the components
     * @param components the group footer components
     * @return a report builder
     */
    public T addGroupFooter(GroupBuilder<?> group, ComponentBuilder<?, ?>... components) {
        Validate.notNull(group, "group must not be null");
        int index = getObject().getGroups().indexOf(group.getGroup());
        Validate.isTrue(index >= 0, "group must be registered");
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        DRGroup drGroup = getObject().getGroups().get(index);
        for (ComponentBuilder<?, ?> component : components) {
            drGroup.getFooterBand().addComponent(component.build());
        }
        return (T) this;
    }

    // detail band

    /**
     * Sets the detail band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the detail split type
     * @return a report builder
     */
    public T setDetailSplitType(SplitType splitType) {
        getObject().getDetailBand().setSplitType(splitType);
        return (T) this;
    }

    public T setDetailPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getDetailBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a detail band style
     *
     * @param style the detail band style
     * @return a report builder
     */
    public T setDetailStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getDetailBand().getList().setStyle(style.build());
        } else {
            getObject().getDetailBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setDetailBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getDetailBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the detail band.
     * The band is printed for each record row in the data source and it's placed between the column header and footer band.
     *
     * @param components the detail components
     * @return a report builder
     */
    public T detail(ComponentBuilder<?, ?>... components) {
        return addDetail(components);
    }

    /**
     * Adds components to the detail band.
     * The band is printed for each record row in the data source and it's placed between the column header and footer band.
     *
     * @param components the detail components
     * @return a report builder
     */
    public T addDetail(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getDetailBand().addComponent(component.build());
        }
        return (T) this;
    }

    // detail header band

    /**
     * Sets the detail header band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the detail header split type
     * @return a report builder
     */
    public T setDetailHeaderSplitType(SplitType splitType) {
        getObject().getDetailHeaderBand().setSplitType(splitType);
        return (T) this;
    }

    public T setDetailHeaderPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getDetailHeaderBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a detail header band style
     *
     * @param style the detail header band style
     * @return a report builder
     */
    public T setDetailHeaderStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getDetailHeaderBand().getList().setStyle(style.build());
        } else {
            getObject().getDetailHeaderBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setDetailHeaderBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getDetailHeaderBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the detail header band.
     * The band is printed for each record row in the data source and it's placed above the detail band.
     *
     * @param components the detail header components
     * @return a report builder
     */
    public T detailHeader(ComponentBuilder<?, ?>... components) {
        return addDetailHeader(components);
    }

    /**
     * Adds components to the detail header band.
     * The band is printed for each record row in the data source and it's placed above the detail band.
     *
     * @param components the detail header components
     * @return a report builder
     */
    public T addDetailHeader(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getDetailHeaderBand().addComponent(component.build());
        }
        return (T) this;
    }

    // detail footer band

    /**
     * Sets the detail footer band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the detail footer split type
     * @return a report builder
     */
    public T setDetailFooterSplitType(SplitType splitType) {
        getObject().getDetailFooterBand().setSplitType(splitType);
        return (T) this;
    }

    public T setDetailFooterPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getDetailFooterBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a detail footer band style
     *
     * @param style the detail footer band style
     * @return a report builder
     */
    public T setDetailFooterStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getDetailFooterBand().getList().setStyle(style.build());
        } else {
            getObject().getDetailFooterBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setDetailFooterBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getDetailFooterBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the detail footer band.
     * The band is printed for each record row in the data source and it's placed below the detail band.
     *
     * @param components the detail footer components
     * @return a report builder
     */
    public T detailFooter(ComponentBuilder<?, ?>... components) {
        return addDetailFooter(components);
    }

    /**
     * Adds components to the detail footer band.
     * The band is printed for each record row in the data source and it's placed below the detail band.
     *
     * @param components the detail footer components
     * @return a report builder
     */
    public T addDetailFooter(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getDetailFooterBand().addComponent(component.build());
        }
        return (T) this;
    }

    // last page footer band

    /**
     * Sets the last page footer band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the last page footer split type
     * @return a report builder
     */
    public T setLastPageFooterSplitType(SplitType splitType) {
        getObject().getLastPageFooterBand().setSplitType(splitType);
        return (T) this;
    }

    public T setLastPageFooterPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getLastPageFooterBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a last page footer band style
     *
     * @param style the last page footer band style
     * @return a report builder
     */
    public T setLastPageFooterStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getLastPageFooterBand().getList().setStyle(style.build());
        } else {
            getObject().getLastPageFooterBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setLastPageFooterBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getLastPageFooterBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the last page footer band.
     * The band is printed only on the last page at the bottom of the page.
     *
     * @param components the last page footer components
     * @return a report builder
     */
    public T lastPageFooter(ComponentBuilder<?, ?>... components) {
        return addLastPageFooter(components);
    }

    /**
     * Adds components to the last page footer band.
     * The band is printed only on the last page at the bottom of the page.
     *
     * @param components the last page footer components
     * @return a report builder
     */
    public T addLastPageFooter(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getLastPageFooterBand().addComponent(component.build());
        }
        return (T) this;
    }

    // summary band

    /**
     * Sets the summary band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the summary split type
     * @return a report builder
     */
    public T setSummarySplitType(SplitType splitType) {
        getObject().getSummaryBand().setSplitType(splitType);
        return (T) this;
    }

    public T setSummaryPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getSummaryBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a summary band style
     *
     * @param style the summary band style
     * @return a report builder
     */
    public T setSummaryStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getSummaryBand().getList().setStyle(style.build());
        } else {
            getObject().getSummaryBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setSummaryBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getSummaryBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the summary band.
     * The band is printed on the last page and only once.
     *
     * @param components the summary components
     * @return a report builder
     */
    public T summary(ComponentBuilder<?, ?>... components) {
        return addSummary(components);
    }

    /**
     * Adds components to the summary band.
     * The band is printed on the last page and only once.
     *
     * @param components the summary components
     * @return a report builder
     */
    public T addSummary(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getSummaryBand().addComponent(component.build());
        }
        return (T) this;
    }

    // no data band

    /**
     * Sets the no data band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the no data split type
     * @return a report builder
     */
    public T setNoDataSplitType(SplitType splitType) {
        getObject().getNoDataBand().setSplitType(splitType);
        return (T) this;
    }

    public T setNoDataPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getNoDataBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a no data band style
     *
     * @param style the no data band style
     * @return a report builder
     */
    public T setNoDataStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getNoDataBand().getList().setStyle(style.build());
        } else {
            getObject().getNoDataBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setNoDataBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getNoDataBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the no data band.
     * The band is printed only when the data source is empty. It's used to show the information that there are not any data in the report.
     *
     * @param components the no data components
     * @return a report builder
     */
    public T noData(ComponentBuilder<?, ?>... components) {
        return addNoData(components);
    }

    /**
     * Adds components to the no data band.
     * The band is printed only when the data source is empty. It's used to show the information that there are not any data in the report.
     *
     * @param components the no data components
     * @return a report builder
     */
    public T addNoData(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getNoDataBand().addComponent(component.build());
        }
        return (T) this;
    }

    // background band

    /**
     * Sets the background band split type.<br/>
     * <i>SplitType.PREVENT</i> - prevents the band from splitting<br/>
     * <i>SplitType.STRETCH</i> - the band can be split, but never within its declared height<br/>
     * <i>SplitType.IMMEDIATE</i> - the band can be split
     *
     * @param splitType the background split type
     * @return a report builder
     */
    public T setBackgroundSplitType(SplitType splitType) {
        getObject().getBackgroundBand().setSplitType(splitType);
        return (T) this;
    }

    public T setBackgroundPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
        getObject().getBackgroundBand().setPrintWhenExpression(printWhenExpression);
        return (T) this;
    }

    /**
     * Sets a background band style
     *
     * @param style the background band style
     * @return a report builder
     */
    public T setBackgroundStyle(ReportStyleBuilder style) {
        if (style != null) {
            getObject().getBackgroundBand().getList().setStyle(style.build());
        } else {
            getObject().getBackgroundBand().getList().setStyle(null);
        }
        return (T) this;
    }

    public T setBackgroundBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
        Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
        getObject().getBackgroundBand().getList().setBackgroundComponent(backgroundComponent.build());
        return (T) this;
    }

    /**
     * Adds components to the background band.
     * The band is printed on each page. It's mostly used for adding watermarks to the report.
     *
     * @param components the background components
     * @return a report builder
     */
    public T background(ComponentBuilder<?, ?>... components) {
        return addBackground(components);
    }

    /**
     * Adds components to the background band.
     * The band is printed on each page. It's mostly used for adding watermarks to the report.
     *
     * @param components the background components
     * @return a report builder
     */
    public T addBackground(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getBackgroundBand().addComponent(component.build());
        }
        return (T) this;
    }

    public DRReport getReport() {
        return build();
    }
}

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
package net.sf.dynamicreports.report.base;

import net.sf.dynamicreports.report.base.component.DRComponent;
import net.sf.dynamicreports.report.base.style.DRSimpleStyle;
import net.sf.dynamicreports.report.constant.BooleanComponentType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.GroupFooterPosition;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.definition.DRIReportTemplate;
import net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer;
import net.sf.dynamicreports.report.definition.style.DRIFont;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import net.sf.dynamicreports.report.definition.style.DRIStyle;
import org.apache.commons.lang3.Validate;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * <p>DRReportTemplate class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class DRReportTemplate implements DRIReportTemplate {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
    // table of contents
    public Boolean tableOfContents;
    public DRITableOfContentsCustomizer tableOfContentsCustomizer;
    private List<DRIStyle> templateStyles;
    private Locale locale;
    private Boolean showColumnTitle;
    private Boolean showColumnValues;
    private Boolean ignorePagination;
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
    // style
    private Boolean highlightDetailOddRows;
    private DRSimpleStyle detailOddRowStyle;
    private Boolean highlightDetailEvenRows;
    private DRSimpleStyle detailEvenRowStyle;
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
    // page
    private Integer pageWidth;
    private Integer pageHeight;
    private PageOrientation pageOrientation;
    private DRMargin pageMargin;
    private Integer pageColumnsPerPage;
    private Integer pageColumnSpace;
    private Boolean ignorePageWidth;
    // column
    private Boolean columnPrintRepeatedDetailValues;
    private Integer columnWidth;
    // group
    private GroupHeaderLayout groupHeaderLayout;
    private Boolean groupHideColumn;
    private Boolean groupShowColumnHeaderAndFooter;
    private Integer groupPadding;
    private Boolean groupStartInNewPage;
    private Boolean groupStartInNewColumn;
    private Boolean groupReprintHeaderOnEachPage;
    private Boolean groupResetPageNumber;
    private GroupFooterPosition groupFooterPosition;
    private Boolean groupKeepTogether;
    private Boolean groupHeaderWithSubtotal;
    // subtotal
    private Position subtotalLabelPosition;
    // text field
    private Integer textFieldWidth;
    // image
    private Integer imageWidth;
    private Integer imageHeight;
    // list
    private Integer listgap;
    // multi page list
    private Integer multiPageListWidth;
    private Integer multiPageListHeight;
    // chart
    private Integer chartWidth;
    private Integer chartHeight;
    private List<Color> chartSeriesColors;
    private String chartValuePattern;
    private String chartPercentValuePattern;
    private String chartTheme;
    // barcode
    private Integer barcodeWidth;
    private Integer barcodeHeight;
    // subreport
    private Integer subreportWidth;
    private Integer subreportHeight;
    // crosstab
    private Integer crosstabWidth;
    private Integer crosstabHeight;
    private Boolean crosstabHighlightOddRows;
    private DRSimpleStyle crosstabOddRowStyle;
    private Boolean crosstabHighlightEvenRows;
    private DRSimpleStyle crosstabEvenRowStyle;
    private DRIReportStyle crosstabGroupStyle;
    private DRIReportStyle crosstabGroupTotalStyle;
    private DRIReportStyle crosstabGrandTotalStyle;
    private DRIReportStyle crosstabCellStyle;
    private DRIReportStyle crosstabMeasureTitleStyle;
    // boolean
    private BooleanComponentType booleanComponentType;
    private Boolean booleanEmptyWhenNullValue;
    private Integer booleanImageWidth;
    private Integer booleanImageHeight;
    private DRIReportStyle booleanColumnStyle;
    // split
    private SplitType defaultSplitType;
    private SplitType titleSplitType;
    private SplitType pageHeaderSplitType;
    private SplitType pageFooterSplitType;
    private SplitType columnHeaderSplitType;
    private SplitType columnFooterSplitType;
    private SplitType groupHeaderSplitType;
    private SplitType groupFooterSplitType;
    private SplitType detailHeaderSplitType;
    private SplitType detailSplitType;
    private SplitType detailFooterSplitType;
    private SplitType lastPageFooterSplitType;
    private SplitType summarySplitType;
    private SplitType noDataSplitType;
    private SplitType backgroundSplitType;
    // band style
    private DRIReportStyle titleStyle;
    private DRIReportStyle pageHeaderStyle;
    private DRIReportStyle pageFooterStyle;
    private DRIReportStyle columnHeaderStyle;
    private DRIReportStyle columnFooterStyle;
    private DRIReportStyle groupHeaderStyle;
    private DRIReportStyle groupFooterStyle;
    private DRIReportStyle detailHeaderStyle;
    private DRIReportStyle detailStyle;
    private DRIReportStyle detailFooterStyle;
    private DRIReportStyle lastPageFooterStyle;
    private DRIReportStyle summaryStyle;
    private DRIReportStyle noDataStyle;
    private DRIReportStyle backgroundStyle;
    // band background component
    private DRComponent titleBackgroundComponent;
    private DRComponent pageHeaderBackgroundComponent;
    private DRComponent pageFooterBackgroundComponent;
    private DRComponent columnHeaderBackgroundComponent;
    private DRComponent columnFooterBackgroundComponent;
    private DRComponent groupHeaderBackgroundComponent;
    private DRComponent groupFooterBackgroundComponent;
    private DRComponent detailHeaderBackgroundComponent;
    private DRComponent detailBackgroundComponent;
    private DRComponent detailFooterBackgroundComponent;
    private DRComponent lastPageFooterBackgroundComponent;
    private DRComponent summaryBackgroundComponent;
    private DRComponent noDataBackgroundComponent;
    private DRComponent backgroundBackgroundComponent;

    /**
     * <p>Constructor for DRReportTemplate.</p>
     */
    public DRReportTemplate() {
        this.templateStyles = new ArrayList<DRIStyle>();
        this.chartSeriesColors = new ArrayList<Color>();
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIStyle> getTemplateStyles() {
        return templateStyles;
    }

    /**
     * <p>Setter for the field <code>templateStyles</code>.</p>
     *
     * @param templateStyles a {@link java.util.List} object.
     */
    public void setTemplateStyles(List<DRIStyle> templateStyles) {
        this.templateStyles = templateStyles;
    }

    /**
     * <p>addTemplateStyle.</p>
     *
     * @param templateStyle a {@link net.sf.dynamicreports.report.definition.style.DRIStyle} object.
     */
    public void addTemplateStyle(DRIStyle templateStyle) {
        Validate.notNull(templateStyle, "templateStyle must not be null");
        Validate.notNull(templateStyle.getName(), "templateStyle name must not be null");
        this.templateStyles.add(templateStyle);
    }

    /** {@inheritDoc} */
    @Override
    public Locale getLocale() {
        return locale;
    }

    /**
     * <p>Setter for the field <code>locale</code>.</p>
     *
     * @param locale a {@link java.util.Locale} object.
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getShowColumnTitle() {
        return showColumnTitle;
    }

    /**
     * <p>Setter for the field <code>showColumnTitle</code>.</p>
     *
     * @param showColumnTitle a {@link java.lang.Boolean} object.
     */
    public void setShowColumnTitle(Boolean showColumnTitle) {
        this.showColumnTitle = showColumnTitle;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getShowColumnValues() {
        return showColumnValues;
    }

    /**
     * <p>Setter for the field <code>showColumnValues</code>.</p>
     *
     * @param showColumnValues a {@link java.lang.Boolean} object.
     */
    public void setShowColumnValues(Boolean showColumnValues) {
        this.showColumnValues = showColumnValues;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getIgnorePagination() {
        return ignorePagination;
    }

    /**
     * <p>Setter for the field <code>ignorePagination</code>.</p>
     *
     * @param ignorePagination a {@link java.lang.Boolean} object.
     */
    public void setIgnorePagination(Boolean ignorePagination) {
        this.ignorePagination = ignorePagination;
    }

    /** {@inheritDoc} */
    @Override
    public WhenNoDataType getWhenNoDataType() {
        return whenNoDataType;
    }

    /**
     * <p>Setter for the field <code>whenNoDataType</code>.</p>
     *
     * @param whenNoDataType a {@link net.sf.dynamicreports.report.constant.WhenNoDataType} object.
     */
    public void setWhenNoDataType(WhenNoDataType whenNoDataType) {
        this.whenNoDataType = whenNoDataType;
    }

    /** {@inheritDoc} */
    @Override
    public WhenResourceMissingType getWhenResourceMissingType() {
        return whenResourceMissingType;
    }

    /**
     * <p>Setter for the field <code>whenResourceMissingType</code>.</p>
     *
     * @param whenResourceMissingType a {@link net.sf.dynamicreports.report.constant.WhenResourceMissingType} object.
     */
    public void setWhenResourceMissingType(WhenResourceMissingType whenResourceMissingType) {
        this.whenResourceMissingType = whenResourceMissingType;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getTitleOnANewPage() {
        return titleOnANewPage;
    }

    /**
     * <p>Setter for the field <code>titleOnANewPage</code>.</p>
     *
     * @param titleOnANewPage a {@link java.lang.Boolean} object.
     */
    public void setTitleOnANewPage(Boolean titleOnANewPage) {
        this.titleOnANewPage = titleOnANewPage;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getSummaryOnANewPage() {
        return summaryOnANewPage;
    }

    /**
     * <p>Setter for the field <code>summaryOnANewPage</code>.</p>
     *
     * @param summaryOnANewPage a {@link java.lang.Boolean} object.
     */
    public void setSummaryOnANewPage(Boolean summaryOnANewPage) {
        this.summaryOnANewPage = summaryOnANewPage;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getSummaryWithPageHeaderAndFooter() {
        return summaryWithPageHeaderAndFooter;
    }

    /**
     * <p>Setter for the field <code>summaryWithPageHeaderAndFooter</code>.</p>
     *
     * @param summaryWithPageHeaderAndFooter a {@link java.lang.Boolean} object.
     */
    public void setSummaryWithPageHeaderAndFooter(Boolean summaryWithPageHeaderAndFooter) {
        this.summaryWithPageHeaderAndFooter = summaryWithPageHeaderAndFooter;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getFloatColumnFooter() {
        return floatColumnFooter;
    }

    /**
     * <p>Setter for the field <code>floatColumnFooter</code>.</p>
     *
     * @param floatColumnFooter a {@link java.lang.Boolean} object.
     */
    public void setFloatColumnFooter(Boolean floatColumnFooter) {
        this.floatColumnFooter = floatColumnFooter;
    }

    /** {@inheritDoc} */
    @Override
    public Orientation getPrintOrder() {
        return printOrder;
    }

    /**
     * <p>Setter for the field <code>printOrder</code>.</p>
     *
     * @param printOrder a {@link net.sf.dynamicreports.report.constant.Orientation} object.
     */
    public void setPrintOrder(Orientation printOrder) {
        this.printOrder = printOrder;
    }

    /** {@inheritDoc} */
    @Override
    public RunDirection getColumnDirection() {
        return columnDirection;
    }

    /**
     * <p>Setter for the field <code>columnDirection</code>.</p>
     *
     * @param columnDirection a {@link net.sf.dynamicreports.report.constant.RunDirection} object.
     */
    public void setColumnDirection(RunDirection columnDirection) {
        this.columnDirection = columnDirection;
    }

    /** {@inheritDoc} */
    @Override
    public String getLanguage() {
        return language;
    }

    /**
     * <p>Setter for the field <code>language</code>.</p>
     *
     * @param language a {@link java.lang.String} object.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getUseFieldNameAsDescription() {
        return useFieldNameAsDescription;
    }

    /**
     * <p>Setter for the field <code>useFieldNameAsDescription</code>.</p>
     *
     * @param useFieldNameAsDescription a {@link java.lang.Boolean} object.
     */
    public void setUseFieldNameAsDescription(Boolean useFieldNameAsDescription) {
        this.useFieldNameAsDescription = useFieldNameAsDescription;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getHighlightDetailOddRows() {
        return highlightDetailOddRows;
    }

    /**
     * <p>Setter for the field <code>highlightDetailOddRows</code>.</p>
     *
     * @param highlightDetailOddRows a {@link java.lang.Boolean} object.
     */
    public void setHighlightDetailOddRows(Boolean highlightDetailOddRows) {
        this.highlightDetailOddRows = highlightDetailOddRows;
    }

    /** {@inheritDoc} */
    @Override
    public DRSimpleStyle getDetailOddRowStyle() {
        return detailOddRowStyle;
    }

    /**
     * <p>Setter for the field <code>detailOddRowStyle</code>.</p>
     *
     * @param detailOddRowStyle a {@link net.sf.dynamicreports.report.base.style.DRSimpleStyle} object.
     */
    public void setDetailOddRowStyle(DRSimpleStyle detailOddRowStyle) {
        this.detailOddRowStyle = detailOddRowStyle;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getHighlightDetailEvenRows() {
        return highlightDetailEvenRows;
    }

    /**
     * <p>Setter for the field <code>highlightDetailEvenRows</code>.</p>
     *
     * @param highlightDetailEvenRows a {@link java.lang.Boolean} object.
     */
    public void setHighlightDetailEvenRows(Boolean highlightDetailEvenRows) {
        this.highlightDetailEvenRows = highlightDetailEvenRows;
    }

    /** {@inheritDoc} */
    @Override
    public DRSimpleStyle getDetailEvenRowStyle() {
        return detailEvenRowStyle;
    }

    /**
     * <p>Setter for the field <code>detailEvenRowStyle</code>.</p>
     *
     * @param detailEvenRowStyle a {@link net.sf.dynamicreports.report.base.style.DRSimpleStyle} object.
     */
    public void setDetailEvenRowStyle(DRSimpleStyle detailEvenRowStyle) {
        this.detailEvenRowStyle = detailEvenRowStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIFont getDefaultFont() {
        return defaultFont;
    }

    /**
     * <p>Setter for the field <code>defaultFont</code>.</p>
     *
     * @param defaultFont a {@link net.sf.dynamicreports.report.definition.style.DRIFont} object.
     */
    public void setDefaultFont(DRIFont defaultFont) {
        this.defaultFont = defaultFont;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getTextStyle() {
        return textStyle;
    }

    /**
     * <p>Setter for the field <code>textStyle</code>.</p>
     *
     * @param textStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setTextStyle(DRIReportStyle textStyle) {
        this.textStyle = textStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getColumnTitleStyle() {
        return columnTitleStyle;
    }

    /**
     * <p>Setter for the field <code>columnTitleStyle</code>.</p>
     *
     * @param columnTitleStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setColumnTitleStyle(DRIReportStyle columnTitleStyle) {
        this.columnTitleStyle = columnTitleStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getColumnStyle() {
        return columnStyle;
    }

    /**
     * <p>Setter for the field <code>columnStyle</code>.</p>
     *
     * @param columnStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setColumnStyle(DRIReportStyle columnStyle) {
        this.columnStyle = columnStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getGroupTitleStyle() {
        return groupTitleStyle;
    }

    /**
     * <p>Setter for the field <code>groupTitleStyle</code>.</p>
     *
     * @param groupTitleStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setGroupTitleStyle(DRIReportStyle groupTitleStyle) {
        this.groupTitleStyle = groupTitleStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getGroupStyle() {
        return groupStyle;
    }

    /**
     * <p>Setter for the field <code>groupStyle</code>.</p>
     *
     * @param groupStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setGroupStyle(DRIReportStyle groupStyle) {
        this.groupStyle = groupStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getSubtotalStyle() {
        return subtotalStyle;
    }

    /**
     * <p>Setter for the field <code>subtotalStyle</code>.</p>
     *
     * @param subtotalStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setSubtotalStyle(DRIReportStyle subtotalStyle) {
        this.subtotalStyle = subtotalStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getImageStyle() {
        return imageStyle;
    }

    /**
     * <p>Setter for the field <code>imageStyle</code>.</p>
     *
     * @param imageStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setImageStyle(DRIReportStyle imageStyle) {
        this.imageStyle = imageStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getChartStyle() {
        return chartStyle;
    }

    /**
     * <p>Setter for the field <code>chartStyle</code>.</p>
     *
     * @param chartStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setChartStyle(DRIReportStyle chartStyle) {
        this.chartStyle = chartStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getBarcodeStyle() {
        return barcodeStyle;
    }

    /**
     * <p>Setter for the field <code>barcodeStyle</code>.</p>
     *
     * @param barcodeStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setBarcodeStyle(DRIReportStyle barcodeStyle) {
        this.barcodeStyle = barcodeStyle;
    }

    /**
     * <p>setPageFormat.</p>
     *
     * @param pageType    a {@link net.sf.dynamicreports.report.constant.PageType} object.
     * @param orientation a {@link net.sf.dynamicreports.report.constant.PageOrientation} object.
     */
    public void setPageFormat(PageType pageType, PageOrientation orientation) {
        Validate.notNull(pageType, "pageType must not be null");
        Validate.notNull(orientation, "orientation must not be null");
        if (orientation.equals(PageOrientation.PORTRAIT)) {
            setPageWidth(pageType.getWidth());
            setPageHeight(pageType.getHeight());
        } else {
            setPageWidth(pageType.getHeight());
            setPageHeight(pageType.getWidth());
        }
        setPageOrientation(orientation);
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageWidth() {
        return pageWidth;
    }

    private void setPageWidth(Integer pageWidth) {
        if (pageWidth != null) {
            Validate.isTrue(pageWidth >= 0, "pageWidth must be >= 0");
        }
        this.pageWidth = pageWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageHeight() {
        return pageHeight;
    }

    private void setPageHeight(Integer pageHeight) {
        if (pageHeight != null) {
            Validate.isTrue(pageHeight >= 0, "pageHeight must be >= 0");
        }
        this.pageHeight = pageHeight;
    }

    /** {@inheritDoc} */
    @Override
    public PageOrientation getPageOrientation() {
        return pageOrientation;
    }

    private void setPageOrientation(PageOrientation pageOrientation) {
        this.pageOrientation = pageOrientation;
    }

    /** {@inheritDoc} */
    @Override
    public DRMargin getPageMargin() {
        return pageMargin;
    }

    /**
     * <p>Setter for the field <code>pageMargin</code>.</p>
     *
     * @param pageMargin a {@link net.sf.dynamicreports.report.base.DRMargin} object.
     */
    public void setPageMargin(DRMargin pageMargin) {
        this.pageMargin = pageMargin;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageColumnsPerPage() {
        return pageColumnsPerPage;
    }

    /**
     * <p>Setter for the field <code>pageColumnsPerPage</code>.</p>
     *
     * @param pageColumnsPerPage a {@link java.lang.Integer} object.
     */
    public void setPageColumnsPerPage(Integer pageColumnsPerPage) {
        if (pageColumnsPerPage != null) {
            Validate.isTrue(pageColumnsPerPage >= 1, "pageColumnsPerPage must be >= 1");
        }
        this.pageColumnsPerPage = pageColumnsPerPage;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageColumnSpace() {
        return pageColumnSpace;
    }

    /**
     * <p>Setter for the field <code>pageColumnSpace</code>.</p>
     *
     * @param pageColumnSpace a {@link java.lang.Integer} object.
     */
    public void setPageColumnSpace(Integer pageColumnSpace) {
        if (pageColumnSpace != null) {
            Validate.isTrue(pageColumnSpace >= 0, "pageColumnSpace must be >= 0");
        }
        this.pageColumnSpace = pageColumnSpace;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getIgnorePageWidth() {
        return ignorePageWidth;
    }

    /**
     * <p>Setter for the field <code>ignorePageWidth</code>.</p>
     *
     * @param ignorePageWidth a {@link java.lang.Boolean} object.
     */
    public void setIgnorePageWidth(Boolean ignorePageWidth) {
        this.ignorePageWidth = ignorePageWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getColumnPrintRepeatedDetailValues() {
        return columnPrintRepeatedDetailValues;
    }

    /**
     * <p>Setter for the field <code>columnPrintRepeatedDetailValues</code>.</p>
     *
     * @param columnPrintRepeatedDetailValues a {@link java.lang.Boolean} object.
     */
    public void setColumnPrintRepeatedDetailValues(Boolean columnPrintRepeatedDetailValues) {
        this.columnPrintRepeatedDetailValues = columnPrintRepeatedDetailValues;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getColumnWidth() {
        return columnWidth;
    }

    /**
     * <p>Setter for the field <code>columnWidth</code>.</p>
     *
     * @param columnWidth a {@link java.lang.Integer} object.
     */
    public void setColumnWidth(Integer columnWidth) {
        if (columnWidth != null) {
            Validate.isTrue(columnWidth >= 0, "columnWidth must be >= 0");
        }
        this.columnWidth = columnWidth;
    }

    /** {@inheritDoc} */
    @Override
    public GroupHeaderLayout getGroupHeaderLayout() {
        return groupHeaderLayout;
    }

    /**
     * <p>Setter for the field <code>groupHeaderLayout</code>.</p>
     *
     * @param groupHeaderLayout a {@link net.sf.dynamicreports.report.constant.GroupHeaderLayout} object.
     */
    public void setGroupHeaderLayout(GroupHeaderLayout groupHeaderLayout) {
        this.groupHeaderLayout = groupHeaderLayout;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getGroupHideColumn() {
        return groupHideColumn;
    }

    /**
     * <p>Setter for the field <code>groupHideColumn</code>.</p>
     *
     * @param groupHideColumn a {@link java.lang.Boolean} object.
     */
    public void setGroupHideColumn(Boolean groupHideColumn) {
        this.groupHideColumn = groupHideColumn;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getGroupShowColumnHeaderAndFooter() {
        return groupShowColumnHeaderAndFooter;
    }

    /**
     * <p>Setter for the field <code>groupShowColumnHeaderAndFooter</code>.</p>
     *
     * @param groupShowColumnHeaderAndFooter a {@link java.lang.Boolean} object.
     */
    public void setGroupShowColumnHeaderAndFooter(Boolean groupShowColumnHeaderAndFooter) {
        this.groupShowColumnHeaderAndFooter = groupShowColumnHeaderAndFooter;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getGroupPadding() {
        return groupPadding;
    }

    /**
     * <p>Setter for the field <code>groupPadding</code>.</p>
     *
     * @param groupPadding a {@link java.lang.Integer} object.
     */
    public void setGroupPadding(Integer groupPadding) {
        if (groupPadding != null) {
            Validate.isTrue(groupPadding >= 0, "groupPadding must be >= 0");
        }
        this.groupPadding = groupPadding;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getGroupStartInNewPage() {
        return groupStartInNewPage;
    }

    /**
     * <p>Setter for the field <code>groupStartInNewPage</code>.</p>
     *
     * @param groupStartInNewPage a {@link java.lang.Boolean} object.
     */
    public void setGroupStartInNewPage(Boolean groupStartInNewPage) {
        this.groupStartInNewPage = groupStartInNewPage;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getGroupStartInNewColumn() {
        return groupStartInNewColumn;
    }

    /**
     * <p>Setter for the field <code>groupStartInNewColumn</code>.</p>
     *
     * @param groupStartInNewColumn a {@link java.lang.Boolean} object.
     */
    public void setGroupStartInNewColumn(Boolean groupStartInNewColumn) {
        this.groupStartInNewColumn = groupStartInNewColumn;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getGroupReprintHeaderOnEachPage() {
        return groupReprintHeaderOnEachPage;
    }

    /**
     * <p>Setter for the field <code>groupReprintHeaderOnEachPage</code>.</p>
     *
     * @param groupReprintHeaderOnEachPage a {@link java.lang.Boolean} object.
     */
    public void setGroupReprintHeaderOnEachPage(Boolean groupReprintHeaderOnEachPage) {
        this.groupReprintHeaderOnEachPage = groupReprintHeaderOnEachPage;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getGroupResetPageNumber() {
        return groupResetPageNumber;
    }

    /**
     * <p>Setter for the field <code>groupResetPageNumber</code>.</p>
     *
     * @param groupResetPageNumber a {@link java.lang.Boolean} object.
     */
    public void setGroupResetPageNumber(Boolean groupResetPageNumber) {
        this.groupResetPageNumber = groupResetPageNumber;
    }

    /** {@inheritDoc} */
    @Override
    public GroupFooterPosition getGroupFooterPosition() {
        return groupFooterPosition;
    }

    /**
     * <p>Setter for the field <code>groupFooterPosition</code>.</p>
     *
     * @param groupFooterPosition a {@link net.sf.dynamicreports.report.constant.GroupFooterPosition} object.
     */
    public void setGroupFooterPosition(GroupFooterPosition groupFooterPosition) {
        this.groupFooterPosition = groupFooterPosition;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getGroupKeepTogether() {
        return groupKeepTogether;
    }

    /**
     * <p>Setter for the field <code>groupKeepTogether</code>.</p>
     *
     * @param groupKeepTogether a {@link java.lang.Boolean} object.
     */
    public void setGroupKeepTogether(Boolean groupKeepTogether) {
        this.groupKeepTogether = groupKeepTogether;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getGroupHeaderWithSubtotal() {
        return groupHeaderWithSubtotal;
    }

    /**
     * <p>Setter for the field <code>groupHeaderWithSubtotal</code>.</p>
     *
     * @param groupHeaderWithSubtotal a {@link java.lang.Boolean} object.
     */
    public void setGroupHeaderWithSubtotal(Boolean groupHeaderWithSubtotal) {
        this.groupHeaderWithSubtotal = groupHeaderWithSubtotal;
    }

    /** {@inheritDoc} */
    @Override
    public Position getSubtotalLabelPosition() {
        return subtotalLabelPosition;
    }

    /**
     * <p>Setter for the field <code>subtotalLabelPosition</code>.</p>
     *
     * @param subtotalLabelPosition a {@link net.sf.dynamicreports.report.constant.Position} object.
     */
    public void setSubtotalLabelPosition(Position subtotalLabelPosition) {
        this.subtotalLabelPosition = subtotalLabelPosition;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getTableOfContents() {
        return tableOfContents;
    }

    /**
     * <p>Setter for the field <code>tableOfContents</code>.</p>
     *
     * @param tableOfContents a {@link java.lang.Boolean} object.
     */
    public void setTableOfContents(Boolean tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    /** {@inheritDoc} */
    @Override
    public DRITableOfContentsCustomizer getTableOfContentsCustomizer() {
        return tableOfContentsCustomizer;
    }

    /**
     * <p>Setter for the field <code>tableOfContentsCustomizer</code>.</p>
     *
     * @param tableOfContentsCustomizer a {@link net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer} object.
     */
    public void setTableOfContentsCustomizer(DRITableOfContentsCustomizer tableOfContentsCustomizer) {
        this.tableOfContentsCustomizer = tableOfContentsCustomizer;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getTextFieldWidth() {
        return textFieldWidth;
    }

    /**
     * <p>Setter for the field <code>textFieldWidth</code>.</p>
     *
     * @param textFieldWidth a {@link java.lang.Integer} object.
     */
    public void setTextFieldWidth(Integer textFieldWidth) {
        if (textFieldWidth != null) {
            Validate.isTrue(textFieldWidth >= 0, "textFieldWidth must be >= 0");
        }
        this.textFieldWidth = textFieldWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getImageHeight() {
        return imageHeight;
    }

    /**
     * <p>Setter for the field <code>imageHeight</code>.</p>
     *
     * @param imageHeight a {@link java.lang.Integer} object.
     */
    public void setImageHeight(Integer imageHeight) {
        if (imageHeight != null) {
            Validate.isTrue(imageHeight >= 0, "imageHeight must be >= 0");
        }
        this.imageHeight = imageHeight;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getImageWidth() {
        return imageWidth;
    }

    /**
     * <p>Setter for the field <code>imageWidth</code>.</p>
     *
     * @param imageWidth a {@link java.lang.Integer} object.
     */
    public void setImageWidth(Integer imageWidth) {
        if (imageWidth != null) {
            Validate.isTrue(imageWidth >= 0, "imageWidth must be >= 0");
        }
        this.imageWidth = imageWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getListgap() {
        return listgap;
    }

    /**
     * <p>Setter for the field <code>listgap</code>.</p>
     *
     * @param listgap a {@link java.lang.Integer} object.
     */
    public void setListgap(Integer listgap) {
        if (listgap != null) {
            Validate.isTrue(listgap >= 0, "listgap must be >= 0");
        }
        this.listgap = listgap;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getMultiPageListWidth() {
        return multiPageListWidth;
    }

    /**
     * <p>Setter for the field <code>multiPageListWidth</code>.</p>
     *
     * @param multiPageListWidth a {@link java.lang.Integer} object.
     */
    public void setMultiPageListWidth(Integer multiPageListWidth) {
        this.multiPageListWidth = multiPageListWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getMultiPageListHeight() {
        return multiPageListHeight;
    }

    /**
     * <p>Setter for the field <code>multiPageListHeight</code>.</p>
     *
     * @param multiPageListHeight a {@link java.lang.Integer} object.
     */
    public void setMultiPageListHeight(Integer multiPageListHeight) {
        this.multiPageListHeight = multiPageListHeight;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getChartHeight() {
        return chartHeight;
    }

    /**
     * <p>Setter for the field <code>chartHeight</code>.</p>
     *
     * @param chartHeight a {@link java.lang.Integer} object.
     */
    public void setChartHeight(Integer chartHeight) {
        if (chartHeight != null) {
            Validate.isTrue(chartHeight >= 0, "chartHeight must be >= 0");
        }
        this.chartHeight = chartHeight;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getChartWidth() {
        return chartWidth;
    }

    /**
     * <p>Setter for the field <code>chartWidth</code>.</p>
     *
     * @param chartWidth a {@link java.lang.Integer} object.
     */
    public void setChartWidth(Integer chartWidth) {
        if (chartWidth != null) {
            Validate.isTrue(chartWidth >= 0, "chartWidth must be >= 0");
        }
        this.chartWidth = chartWidth;
    }

    /** {@inheritDoc} */
    @Override
    public List<Color> getChartSeriesColors() {
        return chartSeriesColors;
    }

    /**
     * <p>Setter for the field <code>chartSeriesColors</code>.</p>
     *
     * @param chartSeriesColors a {@link java.util.List} object.
     */
    public void setChartSeriesColors(List<Color> chartSeriesColors) {
        if (chartSeriesColors != null) {
            Validate.noNullElements(chartSeriesColors, "chartSeriesColors must not contains null chartSeriesColor");
        }
        this.chartSeriesColors = chartSeriesColors;
    }

    /**
     * <p>addChartSeriesColor.</p>
     *
     * @param color a {@link java.awt.Color} object.
     */
    public void addChartSeriesColor(Color color) {
        Validate.notNull(color, "color must not be null");
        this.chartSeriesColors.add(color);
    }

    /** {@inheritDoc} */
    @Override
    public String getChartValuePattern() {
        return chartValuePattern;
    }

    /**
     * <p>Setter for the field <code>chartValuePattern</code>.</p>
     *
     * @param chartValuePattern a {@link java.lang.String} object.
     */
    public void setChartValuePattern(String chartValuePattern) {
        this.chartValuePattern = chartValuePattern;
    }

    /** {@inheritDoc} */
    @Override
    public String getChartPercentValuePattern() {
        return chartPercentValuePattern;
    }

    /**
     * <p>Setter for the field <code>chartPercentValuePattern</code>.</p>
     *
     * @param chartPercentValuePattern a {@link java.lang.String} object.
     */
    public void setChartPercentValuePattern(String chartPercentValuePattern) {
        this.chartPercentValuePattern = chartPercentValuePattern;
    }

    /** {@inheritDoc} */
    @Override
    public String getChartTheme() {
        return chartTheme;
    }

    /**
     * <p>Setter for the field <code>chartTheme</code>.</p>
     *
     * @param chartTheme a {@link java.lang.String} object.
     */
    public void setChartTheme(String chartTheme) {
        this.chartTheme = chartTheme;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getBarcodeHeight() {
        return barcodeHeight;
    }

    /**
     * <p>Setter for the field <code>barcodeHeight</code>.</p>
     *
     * @param barcodeHeight a {@link java.lang.Integer} object.
     */
    public void setBarcodeHeight(Integer barcodeHeight) {
        if (barcodeHeight != null) {
            Validate.isTrue(barcodeHeight >= 0, "barcodeHeight must be >= 0");
        }
        this.barcodeHeight = barcodeHeight;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getBarcodeWidth() {
        return barcodeWidth;
    }

    /**
     * <p>Setter for the field <code>barcodeWidth</code>.</p>
     *
     * @param barcodeWidth a {@link java.lang.Integer} object.
     */
    public void setBarcodeWidth(Integer barcodeWidth) {
        if (barcodeWidth != null) {
            Validate.isTrue(barcodeWidth >= 0, "barcodeWidth must be >= 0");
        }
        this.barcodeWidth = barcodeWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getSubreportHeight() {
        return subreportHeight;
    }

    /**
     * <p>Setter for the field <code>subreportHeight</code>.</p>
     *
     * @param subreportHeight a {@link java.lang.Integer} object.
     */
    public void setSubreportHeight(Integer subreportHeight) {
        if (subreportHeight != null) {
            Validate.isTrue(subreportHeight >= 0, "subreportHeight must be >= 0");
        }
        this.subreportHeight = subreportHeight;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getSubreportWidth() {
        return subreportWidth;
    }

    /**
     * <p>Setter for the field <code>subreportWidth</code>.</p>
     *
     * @param subreportWidth a {@link java.lang.Integer} object.
     */
    public void setSubreportWidth(Integer subreportWidth) {
        if (subreportWidth != null) {
            Validate.isTrue(subreportWidth >= 0, "subreportWidth must be >= 0");
        }
        this.subreportWidth = subreportWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getCrosstabHeight() {
        return crosstabHeight;
    }

    /**
     * <p>Setter for the field <code>crosstabHeight</code>.</p>
     *
     * @param crosstabHeight a {@link java.lang.Integer} object.
     */
    public void setCrosstabHeight(Integer crosstabHeight) {
        if (crosstabHeight != null) {
            Validate.isTrue(crosstabHeight >= 0, "crosstabHeight must be >= 0");
        }
        this.crosstabHeight = crosstabHeight;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getCrosstabWidth() {
        return crosstabWidth;
    }

    /**
     * <p>Setter for the field <code>crosstabWidth</code>.</p>
     *
     * @param crosstabWidth a {@link java.lang.Integer} object.
     */
    public void setCrosstabWidth(Integer crosstabWidth) {
        if (crosstabWidth != null) {
            Validate.isTrue(crosstabWidth >= 0, "crosstabWidth must be >= 0");
        }
        this.crosstabWidth = crosstabWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getCrosstabHighlightOddRows() {
        return crosstabHighlightOddRows;
    }

    /**
     * <p>Setter for the field <code>crosstabHighlightOddRows</code>.</p>
     *
     * @param crosstabHighlightOddRows a {@link java.lang.Boolean} object.
     */
    public void setCrosstabHighlightOddRows(Boolean crosstabHighlightOddRows) {
        this.crosstabHighlightOddRows = crosstabHighlightOddRows;
    }

    /** {@inheritDoc} */
    @Override
    public DRSimpleStyle getCrosstabOddRowStyle() {
        return crosstabOddRowStyle;
    }

    /**
     * <p>Setter for the field <code>crosstabOddRowStyle</code>.</p>
     *
     * @param crosstabOddRowStyle a {@link net.sf.dynamicreports.report.base.style.DRSimpleStyle} object.
     */
    public void setCrosstabOddRowStyle(DRSimpleStyle crosstabOddRowStyle) {
        this.crosstabOddRowStyle = crosstabOddRowStyle;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getCrosstabHighlightEvenRows() {
        return crosstabHighlightEvenRows;
    }

    /**
     * <p>Setter for the field <code>crosstabHighlightEvenRows</code>.</p>
     *
     * @param crosstabHighlightEvenRows a {@link java.lang.Boolean} object.
     */
    public void setCrosstabHighlightEvenRows(Boolean crosstabHighlightEvenRows) {
        this.crosstabHighlightEvenRows = crosstabHighlightEvenRows;
    }

    /** {@inheritDoc} */
    @Override
    public DRSimpleStyle getCrosstabEvenRowStyle() {
        return crosstabEvenRowStyle;
    }

    /**
     * <p>Setter for the field <code>crosstabEvenRowStyle</code>.</p>
     *
     * @param crosstabEvenRowStyle a {@link net.sf.dynamicreports.report.base.style.DRSimpleStyle} object.
     */
    public void setCrosstabEvenRowStyle(DRSimpleStyle crosstabEvenRowStyle) {
        this.crosstabEvenRowStyle = crosstabEvenRowStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getCrosstabGroupStyle() {
        return crosstabGroupStyle;
    }

    /**
     * <p>Setter for the field <code>crosstabGroupStyle</code>.</p>
     *
     * @param crosstabGroupStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setCrosstabGroupStyle(DRIReportStyle crosstabGroupStyle) {
        this.crosstabGroupStyle = crosstabGroupStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getCrosstabGroupTotalStyle() {
        return crosstabGroupTotalStyle;
    }

    /**
     * <p>Setter for the field <code>crosstabGroupTotalStyle</code>.</p>
     *
     * @param crosstabGroupTotalStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setCrosstabGroupTotalStyle(DRIReportStyle crosstabGroupTotalStyle) {
        this.crosstabGroupTotalStyle = crosstabGroupTotalStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getCrosstabGrandTotalStyle() {
        return crosstabGrandTotalStyle;
    }

    /**
     * <p>Setter for the field <code>crosstabGrandTotalStyle</code>.</p>
     *
     * @param crosstabGrandTotalStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setCrosstabGrandTotalStyle(DRIReportStyle crosstabGrandTotalStyle) {
        this.crosstabGrandTotalStyle = crosstabGrandTotalStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getCrosstabCellStyle() {
        return crosstabCellStyle;
    }

    /**
     * <p>Setter for the field <code>crosstabCellStyle</code>.</p>
     *
     * @param crosstabCellStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setCrosstabCellStyle(DRIReportStyle crosstabCellStyle) {
        this.crosstabCellStyle = crosstabCellStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getCrosstabMeasureTitleStyle() {
        return crosstabMeasureTitleStyle;
    }

    /**
     * <p>Setter for the field <code>crosstabMeasureTitleStyle</code>.</p>
     *
     * @param crosstabMeasureTitleStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setCrosstabMeasureTitleStyle(DRIReportStyle crosstabMeasureTitleStyle) {
        this.crosstabMeasureTitleStyle = crosstabMeasureTitleStyle;
    }

    /** {@inheritDoc} */
    @Override
    public BooleanComponentType getBooleanComponentType() {
        return booleanComponentType;
    }

    /**
     * <p>Setter for the field <code>booleanComponentType</code>.</p>
     *
     * @param booleanComponentType a {@link net.sf.dynamicreports.report.constant.BooleanComponentType} object.
     */
    public void setBooleanComponentType(BooleanComponentType booleanComponentType) {
        this.booleanComponentType = booleanComponentType;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getBooleanEmptyWhenNullValue() {
        return booleanEmptyWhenNullValue;
    }

    /**
     * <p>Setter for the field <code>booleanEmptyWhenNullValue</code>.</p>
     *
     * @param booleanEmptyWhenNullValue a {@link java.lang.Boolean} object.
     */
    public void setBooleanEmptyWhenNullValue(Boolean booleanEmptyWhenNullValue) {
        this.booleanEmptyWhenNullValue = booleanEmptyWhenNullValue;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getBooleanImageWidth() {
        return booleanImageWidth;
    }

    /**
     * <p>Setter for the field <code>booleanImageWidth</code>.</p>
     *
     * @param booleanImageWidth a {@link java.lang.Integer} object.
     */
    public void setBooleanImageWidth(Integer booleanImageWidth) {
        this.booleanImageWidth = booleanImageWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getBooleanImageHeight() {
        return booleanImageHeight;
    }

    /**
     * <p>Setter for the field <code>booleanImageHeight</code>.</p>
     *
     * @param booleanImageHeight a {@link java.lang.Integer} object.
     */
    public void setBooleanImageHeight(Integer booleanImageHeight) {
        this.booleanImageHeight = booleanImageHeight;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getBooleanColumnStyle() {
        return booleanColumnStyle;
    }

    /**
     * <p>Setter for the field <code>booleanColumnStyle</code>.</p>
     *
     * @param booleanColumnStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setBooleanColumnStyle(DRIReportStyle booleanColumnStyle) {
        this.booleanColumnStyle = booleanColumnStyle;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getDefaultSplitType() {
        return defaultSplitType;
    }

    /**
     * <p>Setter for the field <code>defaultSplitType</code>.</p>
     *
     * @param defaultSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setDefaultSplitType(SplitType defaultSplitType) {
        this.defaultSplitType = defaultSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getTitleSplitType() {
        return titleSplitType;
    }

    /**
     * <p>Setter for the field <code>titleSplitType</code>.</p>
     *
     * @param titleSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setTitleSplitType(SplitType titleSplitType) {
        this.titleSplitType = titleSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getPageHeaderSplitType() {
        return pageHeaderSplitType;
    }

    /**
     * <p>Setter for the field <code>pageHeaderSplitType</code>.</p>
     *
     * @param pageHeaderSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setPageHeaderSplitType(SplitType pageHeaderSplitType) {
        this.pageHeaderSplitType = pageHeaderSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getPageFooterSplitType() {
        return pageFooterSplitType;
    }

    /**
     * <p>Setter for the field <code>pageFooterSplitType</code>.</p>
     *
     * @param pageFooterSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setPageFooterSplitType(SplitType pageFooterSplitType) {
        this.pageFooterSplitType = pageFooterSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getColumnHeaderSplitType() {
        return columnHeaderSplitType;
    }

    /**
     * <p>Setter for the field <code>columnHeaderSplitType</code>.</p>
     *
     * @param columnHeaderSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setColumnHeaderSplitType(SplitType columnHeaderSplitType) {
        this.columnHeaderSplitType = columnHeaderSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getColumnFooterSplitType() {
        return columnFooterSplitType;
    }

    /**
     * <p>Setter for the field <code>columnFooterSplitType</code>.</p>
     *
     * @param columnFooterSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setColumnFooterSplitType(SplitType columnFooterSplitType) {
        this.columnFooterSplitType = columnFooterSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getGroupHeaderSplitType() {
        return groupHeaderSplitType;
    }

    /**
     * <p>Setter for the field <code>groupHeaderSplitType</code>.</p>
     *
     * @param groupHeaderSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setGroupHeaderSplitType(SplitType groupHeaderSplitType) {
        this.groupHeaderSplitType = groupHeaderSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getGroupFooterSplitType() {
        return groupFooterSplitType;
    }

    /**
     * <p>Setter for the field <code>groupFooterSplitType</code>.</p>
     *
     * @param groupFooterSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setGroupFooterSplitType(SplitType groupFooterSplitType) {
        this.groupFooterSplitType = groupFooterSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getDetailHeaderSplitType() {
        return detailHeaderSplitType;
    }

    /**
     * <p>Setter for the field <code>detailHeaderSplitType</code>.</p>
     *
     * @param detailHeaderSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setDetailHeaderSplitType(SplitType detailHeaderSplitType) {
        this.detailHeaderSplitType = detailHeaderSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getDetailSplitType() {
        return detailSplitType;
    }

    /**
     * <p>Setter for the field <code>detailSplitType</code>.</p>
     *
     * @param detailSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setDetailSplitType(SplitType detailSplitType) {
        this.detailSplitType = detailSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getDetailFooterSplitType() {
        return detailFooterSplitType;
    }

    /**
     * <p>Setter for the field <code>detailFooterSplitType</code>.</p>
     *
     * @param detailFooterSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setDetailFooterSplitType(SplitType detailFooterSplitType) {
        this.detailFooterSplitType = detailFooterSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getLastPageFooterSplitType() {
        return lastPageFooterSplitType;
    }

    /**
     * <p>Setter for the field <code>lastPageFooterSplitType</code>.</p>
     *
     * @param lastPageFooterSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setLastPageFooterSplitType(SplitType lastPageFooterSplitType) {
        this.lastPageFooterSplitType = lastPageFooterSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getSummarySplitType() {
        return summarySplitType;
    }

    /**
     * <p>Setter for the field <code>summarySplitType</code>.</p>
     *
     * @param summarySplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setSummarySplitType(SplitType summarySplitType) {
        this.summarySplitType = summarySplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getNoDataSplitType() {
        return noDataSplitType;
    }

    /**
     * <p>Setter for the field <code>noDataSplitType</code>.</p>
     *
     * @param noDataSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setNoDataSplitType(SplitType noDataSplitType) {
        this.noDataSplitType = noDataSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public SplitType getBackgroundSplitType() {
        return backgroundSplitType;
    }

    /**
     * <p>Setter for the field <code>backgroundSplitType</code>.</p>
     *
     * @param backgroundSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    public void setBackgroundSplitType(SplitType backgroundSplitType) {
        this.backgroundSplitType = backgroundSplitType;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getTitleStyle() {
        return titleStyle;
    }

    /**
     * <p>Setter for the field <code>titleStyle</code>.</p>
     *
     * @param titleStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setTitleStyle(DRIReportStyle titleStyle) {
        this.titleStyle = titleStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getPageHeaderStyle() {
        return pageHeaderStyle;
    }

    /**
     * <p>Setter for the field <code>pageHeaderStyle</code>.</p>
     *
     * @param pageHeaderStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setPageHeaderStyle(DRIReportStyle pageHeaderStyle) {
        this.pageHeaderStyle = pageHeaderStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getPageFooterStyle() {
        return pageFooterStyle;
    }

    /**
     * <p>Setter for the field <code>pageFooterStyle</code>.</p>
     *
     * @param pageFooterStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setPageFooterStyle(DRIReportStyle pageFooterStyle) {
        this.pageFooterStyle = pageFooterStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getColumnHeaderStyle() {
        return columnHeaderStyle;
    }

    /**
     * <p>Setter for the field <code>columnHeaderStyle</code>.</p>
     *
     * @param columnHeaderStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setColumnHeaderStyle(DRIReportStyle columnHeaderStyle) {
        this.columnHeaderStyle = columnHeaderStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getColumnFooterStyle() {
        return columnFooterStyle;
    }

    /**
     * <p>Setter for the field <code>columnFooterStyle</code>.</p>
     *
     * @param columnFooterStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setColumnFooterStyle(DRIReportStyle columnFooterStyle) {
        this.columnFooterStyle = columnFooterStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getGroupHeaderStyle() {
        return groupHeaderStyle;
    }

    /**
     * <p>Setter for the field <code>groupHeaderStyle</code>.</p>
     *
     * @param groupHeaderStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setGroupHeaderStyle(DRIReportStyle groupHeaderStyle) {
        this.groupHeaderStyle = groupHeaderStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getGroupFooterStyle() {
        return groupFooterStyle;
    }

    /**
     * <p>Setter for the field <code>groupFooterStyle</code>.</p>
     *
     * @param groupFooterStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setGroupFooterStyle(DRIReportStyle groupFooterStyle) {
        this.groupFooterStyle = groupFooterStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getDetailHeaderStyle() {
        return detailHeaderStyle;
    }

    /**
     * <p>Setter for the field <code>detailHeaderStyle</code>.</p>
     *
     * @param detailHeaderStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setDetailHeaderStyle(DRIReportStyle detailHeaderStyle) {
        this.detailHeaderStyle = detailHeaderStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getDetailStyle() {
        return detailStyle;
    }

    /**
     * <p>Setter for the field <code>detailStyle</code>.</p>
     *
     * @param detailStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setDetailStyle(DRIReportStyle detailStyle) {
        this.detailStyle = detailStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getDetailFooterStyle() {
        return detailFooterStyle;
    }

    /**
     * <p>Setter for the field <code>detailFooterStyle</code>.</p>
     *
     * @param detailFooterStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setDetailFooterStyle(DRIReportStyle detailFooterStyle) {
        this.detailFooterStyle = detailFooterStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getLastPageFooterStyle() {
        return lastPageFooterStyle;
    }

    /**
     * <p>Setter for the field <code>lastPageFooterStyle</code>.</p>
     *
     * @param lastPageFooterStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setLastPageFooterStyle(DRIReportStyle lastPageFooterStyle) {
        this.lastPageFooterStyle = lastPageFooterStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getSummaryStyle() {
        return summaryStyle;
    }

    /**
     * <p>Setter for the field <code>summaryStyle</code>.</p>
     *
     * @param summaryStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setSummaryStyle(DRIReportStyle summaryStyle) {
        this.summaryStyle = summaryStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getNoDataStyle() {
        return noDataStyle;
    }

    /**
     * <p>Setter for the field <code>noDataStyle</code>.</p>
     *
     * @param noDataStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setNoDataStyle(DRIReportStyle noDataStyle) {
        this.noDataStyle = noDataStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getBackgroundStyle() {
        return backgroundStyle;
    }

    /**
     * <p>Setter for the field <code>backgroundStyle</code>.</p>
     *
     * @param backgroundStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setBackgroundStyle(DRIReportStyle backgroundStyle) {
        this.backgroundStyle = backgroundStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getTitleBackgroundComponent() {
        return titleBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>titleBackgroundComponent</code>.</p>
     *
     * @param titleBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setTitleBackgroundComponent(DRComponent titleBackgroundComponent) {
        this.titleBackgroundComponent = titleBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getPageHeaderBackgroundComponent() {
        return pageHeaderBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>pageHeaderBackgroundComponent</code>.</p>
     *
     * @param pageHeaderBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setPageHeaderBackgroundComponent(DRComponent pageHeaderBackgroundComponent) {
        this.pageHeaderBackgroundComponent = pageHeaderBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getPageFooterBackgroundComponent() {
        return pageFooterBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>pageFooterBackgroundComponent</code>.</p>
     *
     * @param pageFooterBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setPageFooterBackgroundComponent(DRComponent pageFooterBackgroundComponent) {
        this.pageFooterBackgroundComponent = pageFooterBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getColumnHeaderBackgroundComponent() {
        return columnHeaderBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>columnHeaderBackgroundComponent</code>.</p>
     *
     * @param columnHeaderBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setColumnHeaderBackgroundComponent(DRComponent columnHeaderBackgroundComponent) {
        this.columnHeaderBackgroundComponent = columnHeaderBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getColumnFooterBackgroundComponent() {
        return columnFooterBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>columnFooterBackgroundComponent</code>.</p>
     *
     * @param columnFooterBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setColumnFooterBackgroundComponent(DRComponent columnFooterBackgroundComponent) {
        this.columnFooterBackgroundComponent = columnFooterBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getGroupHeaderBackgroundComponent() {
        return groupHeaderBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>groupHeaderBackgroundComponent</code>.</p>
     *
     * @param groupHeaderBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setGroupHeaderBackgroundComponent(DRComponent groupHeaderBackgroundComponent) {
        this.groupHeaderBackgroundComponent = groupHeaderBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getGroupFooterBackgroundComponent() {
        return groupFooterBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>groupFooterBackgroundComponent</code>.</p>
     *
     * @param groupFooterBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setGroupFooterBackgroundComponent(DRComponent groupFooterBackgroundComponent) {
        this.groupFooterBackgroundComponent = groupFooterBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getDetailHeaderBackgroundComponent() {
        return detailHeaderBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>detailHeaderBackgroundComponent</code>.</p>
     *
     * @param detailHeaderBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setDetailHeaderBackgroundComponent(DRComponent detailHeaderBackgroundComponent) {
        this.detailHeaderBackgroundComponent = detailHeaderBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getDetailBackgroundComponent() {
        return detailBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>detailBackgroundComponent</code>.</p>
     *
     * @param detailBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setDetailBackgroundComponent(DRComponent detailBackgroundComponent) {
        this.detailBackgroundComponent = detailBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getDetailFooterBackgroundComponent() {
        return detailFooterBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>detailFooterBackgroundComponent</code>.</p>
     *
     * @param detailFooterBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setDetailFooterBackgroundComponent(DRComponent detailFooterBackgroundComponent) {
        this.detailFooterBackgroundComponent = detailFooterBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getLastPageFooterBackgroundComponent() {
        return lastPageFooterBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>lastPageFooterBackgroundComponent</code>.</p>
     *
     * @param lastPageFooterBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setLastPageFooterBackgroundComponent(DRComponent lastPageFooterBackgroundComponent) {
        this.lastPageFooterBackgroundComponent = lastPageFooterBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getSummaryBackgroundComponent() {
        return summaryBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>summaryBackgroundComponent</code>.</p>
     *
     * @param summaryBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setSummaryBackgroundComponent(DRComponent summaryBackgroundComponent) {
        this.summaryBackgroundComponent = summaryBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getNoDataBackgroundComponent() {
        return noDataBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>noDataBackgroundComponent</code>.</p>
     *
     * @param noDataBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setNoDataBackgroundComponent(DRComponent noDataBackgroundComponent) {
        this.noDataBackgroundComponent = noDataBackgroundComponent;
    }

    /** {@inheritDoc} */
    @Override
    public DRComponent getBackgroundBackgroundComponent() {
        return backgroundBackgroundComponent;
    }

    /**
     * <p>Setter for the field <code>backgroundBackgroundComponent</code>.</p>
     *
     * @param backgroundBackgroundComponent a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void setBackgroundBackgroundComponent(DRComponent backgroundBackgroundComponent) {
        this.backgroundBackgroundComponent = backgroundBackgroundComponent;
    }

}

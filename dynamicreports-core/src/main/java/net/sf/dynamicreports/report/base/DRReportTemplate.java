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

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRReportTemplate implements DRIReportTemplate {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

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
	// table of contents
	public Boolean tableOfContents;
	public DRITableOfContentsCustomizer tableOfContentsCustomizer;
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

	public DRReportTemplate() {
		this.templateStyles = new ArrayList<DRIStyle>();
		this.chartSeriesColors = new ArrayList<Color>();
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
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
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

	@Override
	public PageOrientation getPageOrientation() {
		return pageOrientation;
	}

	private void setPageOrientation(PageOrientation pageOrientation) {
		this.pageOrientation = pageOrientation;
	}

	@Override
	public DRMargin getPageMargin() {
		return pageMargin;
	}

	public void setPageMargin(DRMargin pageMargin) {
		this.pageMargin = pageMargin;
	}

	@Override
	public Integer getPageColumnsPerPage() {
		return pageColumnsPerPage;
	}

	public void setPageColumnsPerPage(Integer pageColumnsPerPage) {
		if (pageColumnsPerPage != null) {
			Validate.isTrue(pageColumnsPerPage >= 1, "pageColumnsPerPage must be >= 1");
		}
		this.pageColumnsPerPage = pageColumnsPerPage;
	}

	@Override
	public Integer getPageColumnSpace() {
		return pageColumnSpace;
	}

	public void setPageColumnSpace(Integer pageColumnSpace) {
		if (pageColumnSpace != null) {
			Validate.isTrue(pageColumnSpace >= 0, "pageColumnSpace must be >= 0");
		}
		this.pageColumnSpace = pageColumnSpace;
	}

	@Override
	public Boolean getIgnorePageWidth() {
		return ignorePageWidth;
	}

	public void setIgnorePageWidth(Boolean ignorePageWidth) {
		this.ignorePageWidth = ignorePageWidth;
	}

	@Override
	public Boolean getColumnPrintRepeatedDetailValues() {
		return columnPrintRepeatedDetailValues;
	}

	public void setColumnPrintRepeatedDetailValues(Boolean columnPrintRepeatedDetailValues) {
		this.columnPrintRepeatedDetailValues = columnPrintRepeatedDetailValues;
	}

	@Override
	public Integer getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(Integer columnWidth) {
		if (columnWidth != null) {
			Validate.isTrue(columnWidth >= 0, "columnWidth must be >= 0");
		}
		this.columnWidth = columnWidth;
	}

	@Override
	public GroupHeaderLayout getGroupHeaderLayout() {
		return groupHeaderLayout;
	}

	public void setGroupHeaderLayout(GroupHeaderLayout groupHeaderLayout) {
		this.groupHeaderLayout = groupHeaderLayout;
	}

	@Override
	public Boolean getGroupHideColumn() {
		return groupHideColumn;
	}

	public void setGroupHideColumn(Boolean groupHideColumn) {
		this.groupHideColumn = groupHideColumn;
	}

	@Override
	public Boolean getGroupShowColumnHeaderAndFooter() {
		return groupShowColumnHeaderAndFooter;
	}

	public void setGroupShowColumnHeaderAndFooter(Boolean groupShowColumnHeaderAndFooter) {
		this.groupShowColumnHeaderAndFooter = groupShowColumnHeaderAndFooter;
	}

	@Override
	public Integer getGroupPadding() {
		return groupPadding;
	}

	public void setGroupPadding(Integer groupPadding) {
		if (groupPadding != null) {
			Validate.isTrue(groupPadding >= 0, "groupPadding must be >= 0");
		}
		this.groupPadding = groupPadding;
	}

	@Override
	public Boolean getGroupStartInNewPage() {
		return groupStartInNewPage;
	}

	public void setGroupStartInNewPage(Boolean groupStartInNewPage) {
		this.groupStartInNewPage = groupStartInNewPage;
	}

	@Override
	public Boolean getGroupStartInNewColumn() {
		return groupStartInNewColumn;
	}

	public void setGroupStartInNewColumn(Boolean groupStartInNewColumn) {
		this.groupStartInNewColumn = groupStartInNewColumn;
	}

	@Override
	public Boolean getGroupReprintHeaderOnEachPage() {
		return groupReprintHeaderOnEachPage;
	}

	public void setGroupReprintHeaderOnEachPage(Boolean groupReprintHeaderOnEachPage) {
		this.groupReprintHeaderOnEachPage = groupReprintHeaderOnEachPage;
	}

	@Override
	public Boolean getGroupResetPageNumber() {
		return groupResetPageNumber;
	}

	public void setGroupResetPageNumber(Boolean groupResetPageNumber) {
		this.groupResetPageNumber = groupResetPageNumber;
	}

	@Override
	public GroupFooterPosition getGroupFooterPosition() {
		return groupFooterPosition;
	}

	public void setGroupFooterPosition(GroupFooterPosition groupFooterPosition) {
		this.groupFooterPosition = groupFooterPosition;
	}

	@Override
	public Boolean getGroupKeepTogether() {
		return groupKeepTogether;
	}

	public void setGroupKeepTogether(Boolean groupKeepTogether) {
		this.groupKeepTogether = groupKeepTogether;
	}

	@Override
	public Boolean getGroupHeaderWithSubtotal() {
		return groupHeaderWithSubtotal;
	}

	public void setGroupHeaderWithSubtotal(Boolean groupHeaderWithSubtotal) {
		this.groupHeaderWithSubtotal = groupHeaderWithSubtotal;
	}

	@Override
	public Position getSubtotalLabelPosition() {
		return subtotalLabelPosition;
	}

	public void setSubtotalLabelPosition(Position subtotalLabelPosition) {
		this.subtotalLabelPosition = subtotalLabelPosition;
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
	public Integer getTextFieldWidth() {
		return textFieldWidth;
	}

	public void setTextFieldWidth(Integer textFieldWidth) {
		if (textFieldWidth != null) {
			Validate.isTrue(textFieldWidth >= 0, "textFieldWidth must be >= 0");
		}
		this.textFieldWidth = textFieldWidth;
	}

	@Override
	public Integer getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(Integer imageHeight) {
		if (imageHeight != null) {
			Validate.isTrue(imageHeight >= 0, "imageHeight must be >= 0");
		}
		this.imageHeight = imageHeight;
	}

	@Override
	public Integer getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(Integer imageWidth) {
		if (imageWidth != null) {
			Validate.isTrue(imageWidth >= 0, "imageWidth must be >= 0");
		}
		this.imageWidth = imageWidth;
	}

	@Override
	public Integer getListgap() {
		return listgap;
	}

	public void setListgap(Integer listgap) {
		if (listgap != null) {
			Validate.isTrue(listgap >= 0, "listgap must be >= 0");
		}
		this.listgap = listgap;
	}

	@Override
	public Integer getMultiPageListWidth() {
		return multiPageListWidth;
	}

	public void setMultiPageListWidth(Integer multiPageListWidth) {
		this.multiPageListWidth = multiPageListWidth;
	}

	@Override
	public Integer getMultiPageListHeight() {
		return multiPageListHeight;
	}

	public void setMultiPageListHeight(Integer multiPageListHeight) {
		this.multiPageListHeight = multiPageListHeight;
	}

	@Override
	public Integer getChartHeight() {
		return chartHeight;
	}

	public void setChartHeight(Integer chartHeight) {
		if (chartHeight != null) {
			Validate.isTrue(chartHeight >= 0, "chartHeight must be >= 0");
		}
		this.chartHeight = chartHeight;
	}

	@Override
	public Integer getChartWidth() {
		return chartWidth;
	}

	public void setChartWidth(Integer chartWidth) {
		if (chartWidth != null) {
			Validate.isTrue(chartWidth >= 0, "chartWidth must be >= 0");
		}
		this.chartWidth = chartWidth;
	}

	@Override
	public List<Color> getChartSeriesColors() {
		return chartSeriesColors;
	}

	public void addChartSeriesColor(Color color) {
		Validate.notNull(color, "color must not be null");
		this.chartSeriesColors.add(color);
	}

	public void setChartSeriesColors(List<Color> chartSeriesColors) {
		if (chartSeriesColors != null) {
			Validate.noNullElements(chartSeriesColors, "chartSeriesColors must not contains null chartSeriesColor");
		}
		this.chartSeriesColors = chartSeriesColors;
	}

	@Override
	public String getChartValuePattern() {
		return chartValuePattern;
	}

	public void setChartValuePattern(String chartValuePattern) {
		this.chartValuePattern = chartValuePattern;
	}

	@Override
	public String getChartPercentValuePattern() {
		return chartPercentValuePattern;
	}

	public void setChartPercentValuePattern(String chartPercentValuePattern) {
		this.chartPercentValuePattern = chartPercentValuePattern;
	}

	@Override
	public String getChartTheme() {
		return chartTheme;
	}

	public void setChartTheme(String chartTheme) {
		this.chartTheme = chartTheme;
	}

	@Override
	public Integer getBarcodeHeight() {
		return barcodeHeight;
	}

	public void setBarcodeHeight(Integer barcodeHeight) {
		if (barcodeHeight != null) {
			Validate.isTrue(barcodeHeight >= 0, "barcodeHeight must be >= 0");
		}
		this.barcodeHeight = barcodeHeight;
	}

	@Override
	public Integer getBarcodeWidth() {
		return barcodeWidth;
	}

	public void setBarcodeWidth(Integer barcodeWidth) {
		if (barcodeWidth != null) {
			Validate.isTrue(barcodeWidth >= 0, "barcodeWidth must be >= 0");
		}
		this.barcodeWidth = barcodeWidth;
	}

	@Override
	public Integer getSubreportHeight() {
		return subreportHeight;
	}

	public void setSubreportHeight(Integer subreportHeight) {
		if (subreportHeight != null) {
			Validate.isTrue(subreportHeight >= 0, "subreportHeight must be >= 0");
		}
		this.subreportHeight = subreportHeight;
	}

	@Override
	public Integer getSubreportWidth() {
		return subreportWidth;
	}

	public void setSubreportWidth(Integer subreportWidth) {
		if (subreportWidth != null) {
			Validate.isTrue(subreportWidth >= 0, "subreportWidth must be >= 0");
		}
		this.subreportWidth = subreportWidth;
	}

	@Override
	public Integer getCrosstabHeight() {
		return crosstabHeight;
	}

	public void setCrosstabHeight(Integer crosstabHeight) {
		if (crosstabHeight != null) {
			Validate.isTrue(crosstabHeight >= 0, "crosstabHeight must be >= 0");
		}
		this.crosstabHeight = crosstabHeight;
	}

	@Override
	public Integer getCrosstabWidth() {
		return crosstabWidth;
	}

	public void setCrosstabWidth(Integer crosstabWidth) {
		if (crosstabWidth != null) {
			Validate.isTrue(crosstabWidth >= 0, "crosstabWidth must be >= 0");
		}
		this.crosstabWidth = crosstabWidth;
	}

	@Override
	public Boolean getCrosstabHighlightOddRows() {
		return crosstabHighlightOddRows;
	}

	public void setCrosstabHighlightOddRows(Boolean crosstabHighlightOddRows) {
		this.crosstabHighlightOddRows = crosstabHighlightOddRows;
	}

	@Override
	public DRSimpleStyle getCrosstabOddRowStyle() {
		return crosstabOddRowStyle;
	}

	public void setCrosstabOddRowStyle(DRSimpleStyle crosstabOddRowStyle) {
		this.crosstabOddRowStyle = crosstabOddRowStyle;
	}

	@Override
	public Boolean getCrosstabHighlightEvenRows() {
		return crosstabHighlightEvenRows;
	}

	public void setCrosstabHighlightEvenRows(Boolean crosstabHighlightEvenRows) {
		this.crosstabHighlightEvenRows = crosstabHighlightEvenRows;
	}

	@Override
	public DRSimpleStyle getCrosstabEvenRowStyle() {
		return crosstabEvenRowStyle;
	}

	public void setCrosstabEvenRowStyle(DRSimpleStyle crosstabEvenRowStyle) {
		this.crosstabEvenRowStyle = crosstabEvenRowStyle;
	}

	@Override
	public DRIReportStyle getCrosstabGroupStyle() {
		return crosstabGroupStyle;
	}

	public void setCrosstabGroupStyle(DRIReportStyle crosstabGroupStyle) {
		this.crosstabGroupStyle = crosstabGroupStyle;
	}

	@Override
	public DRIReportStyle getCrosstabGroupTotalStyle() {
		return crosstabGroupTotalStyle;
	}

	public void setCrosstabGroupTotalStyle(DRIReportStyle crosstabGroupTotalStyle) {
		this.crosstabGroupTotalStyle = crosstabGroupTotalStyle;
	}

	@Override
	public DRIReportStyle getCrosstabGrandTotalStyle() {
		return crosstabGrandTotalStyle;
	}

	public void setCrosstabGrandTotalStyle(DRIReportStyle crosstabGrandTotalStyle) {
		this.crosstabGrandTotalStyle = crosstabGrandTotalStyle;
	}

	@Override
	public DRIReportStyle getCrosstabCellStyle() {
		return crosstabCellStyle;
	}

	public void setCrosstabCellStyle(DRIReportStyle crosstabCellStyle) {
		this.crosstabCellStyle = crosstabCellStyle;
	}

	@Override
	public DRIReportStyle getCrosstabMeasureTitleStyle() {
		return crosstabMeasureTitleStyle;
	}

	public void setCrosstabMeasureTitleStyle(DRIReportStyle crosstabMeasureTitleStyle) {
		this.crosstabMeasureTitleStyle = crosstabMeasureTitleStyle;
	}

	@Override
	public BooleanComponentType getBooleanComponentType() {
		return booleanComponentType;
	}

	public void setBooleanComponentType(BooleanComponentType booleanComponentType) {
		this.booleanComponentType = booleanComponentType;
	}

	@Override
	public Boolean getBooleanEmptyWhenNullValue() {
		return booleanEmptyWhenNullValue;
	}

	public void setBooleanEmptyWhenNullValue(Boolean booleanEmptyWhenNullValue) {
		this.booleanEmptyWhenNullValue = booleanEmptyWhenNullValue;
	}

	@Override
	public Integer getBooleanImageWidth() {
		return booleanImageWidth;
	}

	public void setBooleanImageWidth(Integer booleanImageWidth) {
		this.booleanImageWidth = booleanImageWidth;
	}

	@Override
	public Integer getBooleanImageHeight() {
		return booleanImageHeight;
	}

	public void setBooleanImageHeight(Integer booleanImageHeight) {
		this.booleanImageHeight = booleanImageHeight;
	}

	@Override
	public DRIReportStyle getBooleanColumnStyle() {
		return booleanColumnStyle;
	}

	public void setBooleanColumnStyle(DRIReportStyle booleanColumnStyle) {
		this.booleanColumnStyle = booleanColumnStyle;
	}

	@Override
	public SplitType getDefaultSplitType() {
		return defaultSplitType;
	}

	public void setDefaultSplitType(SplitType defaultSplitType) {
		this.defaultSplitType = defaultSplitType;
	}

	@Override
	public SplitType getTitleSplitType() {
		return titleSplitType;
	}

	public void setTitleSplitType(SplitType titleSplitType) {
		this.titleSplitType = titleSplitType;
	}

	@Override
	public SplitType getPageHeaderSplitType() {
		return pageHeaderSplitType;
	}

	public void setPageHeaderSplitType(SplitType pageHeaderSplitType) {
		this.pageHeaderSplitType = pageHeaderSplitType;
	}

	@Override
	public SplitType getPageFooterSplitType() {
		return pageFooterSplitType;
	}

	public void setPageFooterSplitType(SplitType pageFooterSplitType) {
		this.pageFooterSplitType = pageFooterSplitType;
	}

	@Override
	public SplitType getColumnHeaderSplitType() {
		return columnHeaderSplitType;
	}

	public void setColumnHeaderSplitType(SplitType columnHeaderSplitType) {
		this.columnHeaderSplitType = columnHeaderSplitType;
	}

	@Override
	public SplitType getColumnFooterSplitType() {
		return columnFooterSplitType;
	}

	public void setColumnFooterSplitType(SplitType columnFooterSplitType) {
		this.columnFooterSplitType = columnFooterSplitType;
	}

	@Override
	public SplitType getGroupHeaderSplitType() {
		return groupHeaderSplitType;
	}

	public void setGroupHeaderSplitType(SplitType groupHeaderSplitType) {
		this.groupHeaderSplitType = groupHeaderSplitType;
	}

	@Override
	public SplitType getGroupFooterSplitType() {
		return groupFooterSplitType;
	}

	public void setGroupFooterSplitType(SplitType groupFooterSplitType) {
		this.groupFooterSplitType = groupFooterSplitType;
	}

	@Override
	public SplitType getDetailHeaderSplitType() {
		return detailHeaderSplitType;
	}

	public void setDetailHeaderSplitType(SplitType detailHeaderSplitType) {
		this.detailHeaderSplitType = detailHeaderSplitType;
	}

	@Override
	public SplitType getDetailSplitType() {
		return detailSplitType;
	}

	public void setDetailSplitType(SplitType detailSplitType) {
		this.detailSplitType = detailSplitType;
	}

	@Override
	public SplitType getDetailFooterSplitType() {
		return detailFooterSplitType;
	}

	public void setDetailFooterSplitType(SplitType detailFooterSplitType) {
		this.detailFooterSplitType = detailFooterSplitType;
	}

	@Override
	public SplitType getLastPageFooterSplitType() {
		return lastPageFooterSplitType;
	}

	public void setLastPageFooterSplitType(SplitType lastPageFooterSplitType) {
		this.lastPageFooterSplitType = lastPageFooterSplitType;
	}

	@Override
	public SplitType getSummarySplitType() {
		return summarySplitType;
	}

	public void setSummarySplitType(SplitType summarySplitType) {
		this.summarySplitType = summarySplitType;
	}

	@Override
	public SplitType getNoDataSplitType() {
		return noDataSplitType;
	}

	public void setNoDataSplitType(SplitType noDataSplitType) {
		this.noDataSplitType = noDataSplitType;
	}

	@Override
	public SplitType getBackgroundSplitType() {
		return backgroundSplitType;
	}

	public void setBackgroundSplitType(SplitType backgroundSplitType) {
		this.backgroundSplitType = backgroundSplitType;
	}

	@Override
	public DRIReportStyle getTitleStyle() {
		return titleStyle;
	}

	public void setTitleStyle(DRIReportStyle titleStyle) {
		this.titleStyle = titleStyle;
	}

	@Override
	public DRIReportStyle getPageHeaderStyle() {
		return pageHeaderStyle;
	}

	public void setPageHeaderStyle(DRIReportStyle pageHeaderStyle) {
		this.pageHeaderStyle = pageHeaderStyle;
	}

	@Override
	public DRIReportStyle getPageFooterStyle() {
		return pageFooterStyle;
	}

	public void setPageFooterStyle(DRIReportStyle pageFooterStyle) {
		this.pageFooterStyle = pageFooterStyle;
	}

	@Override
	public DRIReportStyle getColumnHeaderStyle() {
		return columnHeaderStyle;
	}

	public void setColumnHeaderStyle(DRIReportStyle columnHeaderStyle) {
		this.columnHeaderStyle = columnHeaderStyle;
	}

	@Override
	public DRIReportStyle getColumnFooterStyle() {
		return columnFooterStyle;
	}

	public void setColumnFooterStyle(DRIReportStyle columnFooterStyle) {
		this.columnFooterStyle = columnFooterStyle;
	}

	@Override
	public DRIReportStyle getGroupHeaderStyle() {
		return groupHeaderStyle;
	}

	public void setGroupHeaderStyle(DRIReportStyle groupHeaderStyle) {
		this.groupHeaderStyle = groupHeaderStyle;
	}

	@Override
	public DRIReportStyle getGroupFooterStyle() {
		return groupFooterStyle;
	}

	public void setGroupFooterStyle(DRIReportStyle groupFooterStyle) {
		this.groupFooterStyle = groupFooterStyle;
	}

	@Override
	public DRIReportStyle getDetailHeaderStyle() {
		return detailHeaderStyle;
	}

	public void setDetailHeaderStyle(DRIReportStyle detailHeaderStyle) {
		this.detailHeaderStyle = detailHeaderStyle;
	}

	@Override
	public DRIReportStyle getDetailStyle() {
		return detailStyle;
	}

	public void setDetailStyle(DRIReportStyle detailStyle) {
		this.detailStyle = detailStyle;
	}

	@Override
	public DRIReportStyle getDetailFooterStyle() {
		return detailFooterStyle;
	}

	public void setDetailFooterStyle(DRIReportStyle detailFooterStyle) {
		this.detailFooterStyle = detailFooterStyle;
	}

	@Override
	public DRIReportStyle getLastPageFooterStyle() {
		return lastPageFooterStyle;
	}

	public void setLastPageFooterStyle(DRIReportStyle lastPageFooterStyle) {
		this.lastPageFooterStyle = lastPageFooterStyle;
	}

	@Override
	public DRIReportStyle getSummaryStyle() {
		return summaryStyle;
	}

	public void setSummaryStyle(DRIReportStyle summaryStyle) {
		this.summaryStyle = summaryStyle;
	}

	@Override
	public DRIReportStyle getNoDataStyle() {
		return noDataStyle;
	}

	public void setNoDataStyle(DRIReportStyle noDataStyle) {
		this.noDataStyle = noDataStyle;
	}

	@Override
	public DRIReportStyle getBackgroundStyle() {
		return backgroundStyle;
	}

	public void setBackgroundStyle(DRIReportStyle backgroundStyle) {
		this.backgroundStyle = backgroundStyle;
	}

	@Override
	public DRComponent getTitleBackgroundComponent() {
		return titleBackgroundComponent;
	}

	public void setTitleBackgroundComponent(DRComponent titleBackgroundComponent) {
		this.titleBackgroundComponent = titleBackgroundComponent;
	}

	@Override
	public DRComponent getPageHeaderBackgroundComponent() {
		return pageHeaderBackgroundComponent;
	}

	public void setPageHeaderBackgroundComponent(DRComponent pageHeaderBackgroundComponent) {
		this.pageHeaderBackgroundComponent = pageHeaderBackgroundComponent;
	}

	@Override
	public DRComponent getPageFooterBackgroundComponent() {
		return pageFooterBackgroundComponent;
	}

	public void setPageFooterBackgroundComponent(DRComponent pageFooterBackgroundComponent) {
		this.pageFooterBackgroundComponent = pageFooterBackgroundComponent;
	}

	@Override
	public DRComponent getColumnHeaderBackgroundComponent() {
		return columnHeaderBackgroundComponent;
	}

	public void setColumnHeaderBackgroundComponent(DRComponent columnHeaderBackgroundComponent) {
		this.columnHeaderBackgroundComponent = columnHeaderBackgroundComponent;
	}

	@Override
	public DRComponent getColumnFooterBackgroundComponent() {
		return columnFooterBackgroundComponent;
	}

	public void setColumnFooterBackgroundComponent(DRComponent columnFooterBackgroundComponent) {
		this.columnFooterBackgroundComponent = columnFooterBackgroundComponent;
	}

	@Override
	public DRComponent getGroupHeaderBackgroundComponent() {
		return groupHeaderBackgroundComponent;
	}

	public void setGroupHeaderBackgroundComponent(DRComponent groupHeaderBackgroundComponent) {
		this.groupHeaderBackgroundComponent = groupHeaderBackgroundComponent;
	}

	@Override
	public DRComponent getGroupFooterBackgroundComponent() {
		return groupFooterBackgroundComponent;
	}

	public void setGroupFooterBackgroundComponent(DRComponent groupFooterBackgroundComponent) {
		this.groupFooterBackgroundComponent = groupFooterBackgroundComponent;
	}

	@Override
	public DRComponent getDetailHeaderBackgroundComponent() {
		return detailHeaderBackgroundComponent;
	}

	public void setDetailHeaderBackgroundComponent(DRComponent detailHeaderBackgroundComponent) {
		this.detailHeaderBackgroundComponent = detailHeaderBackgroundComponent;
	}

	@Override
	public DRComponent getDetailBackgroundComponent() {
		return detailBackgroundComponent;
	}

	public void setDetailBackgroundComponent(DRComponent detailBackgroundComponent) {
		this.detailBackgroundComponent = detailBackgroundComponent;
	}

	@Override
	public DRComponent getDetailFooterBackgroundComponent() {
		return detailFooterBackgroundComponent;
	}

	public void setDetailFooterBackgroundComponent(DRComponent detailFooterBackgroundComponent) {
		this.detailFooterBackgroundComponent = detailFooterBackgroundComponent;
	}

	@Override
	public DRComponent getLastPageFooterBackgroundComponent() {
		return lastPageFooterBackgroundComponent;
	}

	public void setLastPageFooterBackgroundComponent(DRComponent lastPageFooterBackgroundComponent) {
		this.lastPageFooterBackgroundComponent = lastPageFooterBackgroundComponent;
	}

	@Override
	public DRComponent getSummaryBackgroundComponent() {
		return summaryBackgroundComponent;
	}

	public void setSummaryBackgroundComponent(DRComponent summaryBackgroundComponent) {
		this.summaryBackgroundComponent = summaryBackgroundComponent;
	}

	@Override
	public DRComponent getNoDataBackgroundComponent() {
		return noDataBackgroundComponent;
	}

	public void setNoDataBackgroundComponent(DRComponent noDataBackgroundComponent) {
		this.noDataBackgroundComponent = noDataBackgroundComponent;
	}

	@Override
	public DRComponent getBackgroundBackgroundComponent() {
		return backgroundBackgroundComponent;
	}

	public void setBackgroundBackgroundComponent(DRComponent backgroundBackgroundComponent) {
		this.backgroundBackgroundComponent = backgroundBackgroundComponent;
	}

}

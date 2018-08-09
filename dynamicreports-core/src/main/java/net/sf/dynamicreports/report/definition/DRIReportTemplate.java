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

package net.sf.dynamicreports.report.definition;

import java.awt.Color;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import net.sf.dynamicreports.report.constant.BooleanComponentType;
import net.sf.dynamicreports.report.constant.GroupFooterPosition;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.style.DRIFont;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import net.sf.dynamicreports.report.definition.style.DRISimpleStyle;
import net.sf.dynamicreports.report.definition.style.DRIStyle;

/**
 * <p>DRIReportTemplate interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIReportTemplate extends Serializable {

	/**
	 * <p>getTemplateStyles.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<DRIStyle> getTemplateStyles();

	/**
	 * <p>getLocale.</p>
	 *
	 * @return a {@link java.util.Locale} object.
	 */
	public Locale getLocale();

	/**
	 * <p>getShowColumnTitle.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getShowColumnTitle();

	/**
	 * <p>getShowColumnValues.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getShowColumnValues();

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
	 * <p>getUseFieldNameAsDescription.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getUseFieldNameAsDescription();

	/**
	 * <p>getHighlightDetailOddRows.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getHighlightDetailOddRows();

	/**
	 * <p>getDetailOddRowStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRISimpleStyle} object.
	 */
	public DRISimpleStyle getDetailOddRowStyle();

	/**
	 * <p>getHighlightDetailEvenRows.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getHighlightDetailEvenRows();

	/**
	 * <p>getDetailEvenRowStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRISimpleStyle} object.
	 */
	public DRISimpleStyle getDetailEvenRowStyle();

	/**
	 * <p>getDefaultFont.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIFont} object.
	 */
	public DRIFont getDefaultFont();

	/**
	 * <p>getTextStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getTextStyle();

	/**
	 * <p>getColumnTitleStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getColumnTitleStyle();

	/**
	 * <p>getColumnStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getColumnStyle();

	/**
	 * <p>getGroupTitleStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getGroupTitleStyle();

	/**
	 * <p>getGroupStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getGroupStyle();

	/**
	 * <p>getSubtotalStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getSubtotalStyle();

	/**
	 * <p>getImageStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getImageStyle();

	/**
	 * <p>getChartStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getChartStyle();

	/**
	 * <p>getBarcodeStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getBarcodeStyle();

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
	 * <p>getIgnorePageWidth.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getIgnorePageWidth();

	/**
	 * <p>getColumnPrintRepeatedDetailValues.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getColumnPrintRepeatedDetailValues();

	/**
	 * <p>getColumnWidth.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getColumnWidth();

	/**
	 * <p>getGroupHeaderLayout.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.GroupHeaderLayout} object.
	 */
	public GroupHeaderLayout getGroupHeaderLayout();

	/**
	 * <p>getGroupHideColumn.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getGroupHideColumn();

	/**
	 * <p>getGroupShowColumnHeaderAndFooter.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getGroupShowColumnHeaderAndFooter();

	/**
	 * <p>getGroupPadding.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getGroupPadding();

	/**
	 * <p>getGroupStartInNewPage.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getGroupStartInNewPage();

	/**
	 * <p>getGroupStartInNewColumn.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getGroupStartInNewColumn();

	/**
	 * <p>getGroupReprintHeaderOnEachPage.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getGroupReprintHeaderOnEachPage();

	/**
	 * <p>getGroupResetPageNumber.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getGroupResetPageNumber();

	/**
	 * <p>getGroupFooterPosition.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.GroupFooterPosition} object.
	 */
	public GroupFooterPosition getGroupFooterPosition();

	/**
	 * <p>getGroupKeepTogether.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getGroupKeepTogether();

	/**
	 * <p>getGroupHeaderWithSubtotal.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getGroupHeaderWithSubtotal();

	/**
	 * <p>getSubtotalLabelPosition.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.Position} object.
	 */
	public Position getSubtotalLabelPosition();

	/**
	 * <p>getTableOfContents.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getTableOfContents();

	/**
	 * <p>getTableOfContentsCustomizer.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer} object.
	 */
	public DRITableOfContentsCustomizer getTableOfContentsCustomizer();

	/**
	 * <p>getTextFieldWidth.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getTextFieldWidth();

	/**
	 * <p>getImageHeight.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getImageHeight();

	/**
	 * <p>getImageWidth.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getImageWidth();

	/**
	 * <p>getListgap.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getListgap();

	/**
	 * <p>getMultiPageListHeight.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getMultiPageListHeight();

	/**
	 * <p>getMultiPageListWidth.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getMultiPageListWidth();

	/**
	 * <p>getChartHeight.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getChartHeight();

	/**
	 * <p>getChartWidth.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getChartWidth();

	/**
	 * <p>getBarcodeHeight.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getBarcodeHeight();

	/**
	 * <p>getBarcodeWidth.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getBarcodeWidth();

	/**
	 * <p>getSubreportHeight.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getSubreportHeight();

	/**
	 * <p>getSubreportWidth.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getSubreportWidth();

	/**
	 * <p>getCrosstabHeight.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getCrosstabHeight();

	/**
	 * <p>getCrosstabWidth.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getCrosstabWidth();

	/**
	 * <p>getCrosstabHighlightOddRows.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getCrosstabHighlightOddRows();

	/**
	 * <p>getCrosstabOddRowStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRISimpleStyle} object.
	 */
	public DRISimpleStyle getCrosstabOddRowStyle();

	/**
	 * <p>getCrosstabHighlightEvenRows.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getCrosstabHighlightEvenRows();

	/**
	 * <p>getCrosstabEvenRowStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRISimpleStyle} object.
	 */
	public DRISimpleStyle getCrosstabEvenRowStyle();

	/**
	 * <p>getCrosstabGroupStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getCrosstabGroupStyle();

	/**
	 * <p>getCrosstabGroupTotalStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getCrosstabGroupTotalStyle();

	/**
	 * <p>getCrosstabGrandTotalStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getCrosstabGrandTotalStyle();

	/**
	 * <p>getCrosstabCellStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getCrosstabCellStyle();

	/**
	 * <p>getCrosstabMeasureTitleStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getCrosstabMeasureTitleStyle();

	/**
	 * <p>getChartSeriesColors.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Color> getChartSeriesColors();

	/**
	 * <p>getChartValuePattern.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getChartValuePattern();

	/**
	 * <p>getChartPercentValuePattern.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getChartPercentValuePattern();

	/**
	 * <p>getChartTheme.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getChartTheme();

	/**
	 * <p>getBooleanComponentType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.BooleanComponentType} object.
	 */
	public BooleanComponentType getBooleanComponentType();

	/**
	 * <p>getBooleanEmptyWhenNullValue.</p>
	 *
	 * @return a {@link java.lang.Boolean} object.
	 */
	public Boolean getBooleanEmptyWhenNullValue();

	/**
	 * <p>getBooleanImageWidth.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getBooleanImageWidth();

	/**
	 * <p>getBooleanImageHeight.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getBooleanImageHeight();

	/**
	 * <p>getBooleanColumnStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getBooleanColumnStyle();

	/**
	 * <p>getDefaultSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getDefaultSplitType();

	/**
	 * <p>getTitleSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getTitleSplitType();

	/**
	 * <p>getPageHeaderSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getPageHeaderSplitType();

	/**
	 * <p>getPageFooterSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getPageFooterSplitType();

	/**
	 * <p>getColumnHeaderSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getColumnHeaderSplitType();

	/**
	 * <p>getColumnFooterSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getColumnFooterSplitType();

	/**
	 * <p>getGroupHeaderSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getGroupHeaderSplitType();

	/**
	 * <p>getGroupFooterSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getGroupFooterSplitType();

	/**
	 * <p>getDetailHeaderSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getDetailHeaderSplitType();

	/**
	 * <p>getDetailSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getDetailSplitType();

	/**
	 * <p>getDetailFooterSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getDetailFooterSplitType();

	/**
	 * <p>getLastPageFooterSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getLastPageFooterSplitType();

	/**
	 * <p>getSummarySplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getSummarySplitType();

	/**
	 * <p>getNoDataSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getNoDataSplitType();

	/**
	 * <p>getBackgroundSplitType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 */
	public SplitType getBackgroundSplitType();

	/**
	 * <p>getTitleStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getTitleStyle();

	/**
	 * <p>getPageHeaderStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getPageHeaderStyle();

	/**
	 * <p>getPageFooterStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getPageFooterStyle();

	/**
	 * <p>getColumnHeaderStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getColumnHeaderStyle();

	/**
	 * <p>getColumnFooterStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getColumnFooterStyle();

	/**
	 * <p>getGroupHeaderStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getGroupHeaderStyle();

	/**
	 * <p>getGroupFooterStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getGroupFooterStyle();

	/**
	 * <p>getDetailHeaderStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getDetailHeaderStyle();

	/**
	 * <p>getDetailStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getDetailStyle();

	/**
	 * <p>getDetailFooterStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getDetailFooterStyle();

	/**
	 * <p>getLastPageFooterStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getLastPageFooterStyle();

	/**
	 * <p>getSummaryStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getSummaryStyle();

	/**
	 * <p>getNoDataStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getNoDataStyle();

	/**
	 * <p>getBackgroundStyle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
	 */
	public DRIReportStyle getBackgroundStyle();

	/**
	 * <p>getTitleBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getTitleBackgroundComponent();

	/**
	 * <p>getPageHeaderBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getPageHeaderBackgroundComponent();

	/**
	 * <p>getPageFooterBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getPageFooterBackgroundComponent();

	/**
	 * <p>getColumnHeaderBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getColumnHeaderBackgroundComponent();

	/**
	 * <p>getColumnFooterBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getColumnFooterBackgroundComponent();

	/**
	 * <p>getGroupHeaderBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getGroupHeaderBackgroundComponent();

	/**
	 * <p>getGroupFooterBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getGroupFooterBackgroundComponent();

	/**
	 * <p>getDetailHeaderBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getDetailHeaderBackgroundComponent();

	/**
	 * <p>getDetailBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getDetailBackgroundComponent();

	/**
	 * <p>getDetailFooterBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getDetailFooterBackgroundComponent();

	/**
	 * <p>getLastPageFooterBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getLastPageFooterBackgroundComponent();

	/**
	 * <p>getSummaryBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getSummaryBackgroundComponent();

	/**
	 * <p>getNoDataBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getNoDataBackgroundComponent();

	/**
	 * <p>getBackgroundBackgroundComponent.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
	 */
	public DRIComponent getBackgroundBackgroundComponent();

}

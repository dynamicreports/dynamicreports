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
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public interface DRIReportTemplate extends Serializable {

	public List<DRIStyle> getTemplateStyles();

	public Locale getLocale();

	public Boolean getShowColumnTitle();

	public Boolean getShowColumnValues();

	public Boolean getIgnorePagination();

	public WhenNoDataType getWhenNoDataType();

	public WhenResourceMissingType getWhenResourceMissingType();

	public Boolean getTitleOnANewPage();

	public Boolean getSummaryOnANewPage();

	public Boolean getSummaryWithPageHeaderAndFooter();

	public Boolean getFloatColumnFooter();

	public Orientation getPrintOrder();

	public RunDirection getColumnDirection();

	public String getLanguage();

	public Boolean getUseFieldNameAsDescription();

	public Boolean getHighlightDetailOddRows();

	public DRISimpleStyle getDetailOddRowStyle();

	public Boolean getHighlightDetailEvenRows();

	public DRISimpleStyle getDetailEvenRowStyle();

	public DRIFont getDefaultFont();

	public DRIReportStyle getTextStyle();

	public DRIReportStyle getColumnTitleStyle();

	public DRIReportStyle getColumnStyle();

	public DRIReportStyle getGroupTitleStyle();

	public DRIReportStyle getGroupStyle();

	public DRIReportStyle getSubtotalStyle();

	public DRIReportStyle getImageStyle();

	public DRIReportStyle getChartStyle();

	public DRIReportStyle getBarcodeStyle();

	public Integer getPageWidth();

	public Integer getPageHeight();

	public PageOrientation getPageOrientation();

	public DRIMargin getPageMargin();

	public Integer getPageColumnsPerPage();

	public Integer getPageColumnSpace();

	public Boolean getIgnorePageWidth();

	public Boolean getColumnPrintRepeatedDetailValues();

	public Integer getColumnWidth();

	public GroupHeaderLayout getGroupHeaderLayout();

	public Boolean getGroupHideColumn();

	public Boolean getGroupShowColumnHeaderAndFooter();

	public Integer getGroupPadding();

	public Boolean getGroupStartInNewPage();

	public Boolean getGroupStartInNewColumn();

	public Boolean getGroupReprintHeaderOnEachPage();

	public Boolean getGroupResetPageNumber();

	public GroupFooterPosition getGroupFooterPosition();

	public Boolean getGroupKeepTogether();

	public Boolean getGroupHeaderWithSubtotal();

	public Position getSubtotalLabelPosition();

	public Boolean getTableOfContents();

	public DRITableOfContentsCustomizer getTableOfContentsCustomizer();

	public Integer getTextFieldWidth();

	public Integer getImageHeight();

	public Integer getImageWidth();

	public Integer getListgap();

	public Integer getMultiPageListHeight();

	public Integer getMultiPageListWidth();

	public Integer getChartHeight();

	public Integer getChartWidth();

	public Integer getBarcodeHeight();

	public Integer getBarcodeWidth();

	public Integer getSubreportHeight();

	public Integer getSubreportWidth();

	public Integer getCrosstabHeight();

	public Integer getCrosstabWidth();

	public Boolean getCrosstabHighlightOddRows();

	public DRISimpleStyle getCrosstabOddRowStyle();

	public Boolean getCrosstabHighlightEvenRows();

	public DRISimpleStyle getCrosstabEvenRowStyle();

	public DRIReportStyle getCrosstabGroupStyle();

	public DRIReportStyle getCrosstabGroupTotalStyle();

	public DRIReportStyle getCrosstabGrandTotalStyle();

	public DRIReportStyle getCrosstabCellStyle();

	public DRIReportStyle getCrosstabMeasureTitleStyle();

	public List<Color> getChartSeriesColors();

	public String getChartValuePattern();

	public String getChartPercentValuePattern();

	public String getChartTheme();

	public BooleanComponentType getBooleanComponentType();

	public Boolean getBooleanEmptyWhenNullValue();

	public Integer getBooleanImageWidth();

	public Integer getBooleanImageHeight();

	public DRIReportStyle getBooleanColumnStyle();

	public SplitType getDefaultSplitType();

	public SplitType getTitleSplitType();

	public SplitType getPageHeaderSplitType();

	public SplitType getPageFooterSplitType();

	public SplitType getColumnHeaderSplitType();

	public SplitType getColumnFooterSplitType();

	public SplitType getGroupHeaderSplitType();

	public SplitType getGroupFooterSplitType();

	public SplitType getDetailHeaderSplitType();

	public SplitType getDetailSplitType();

	public SplitType getDetailFooterSplitType();

	public SplitType getLastPageFooterSplitType();

	public SplitType getSummarySplitType();

	public SplitType getNoDataSplitType();

	public SplitType getBackgroundSplitType();

	public DRIReportStyle getTitleStyle();

	public DRIReportStyle getPageHeaderStyle();

	public DRIReportStyle getPageFooterStyle();

	public DRIReportStyle getColumnHeaderStyle();

	public DRIReportStyle getColumnFooterStyle();

	public DRIReportStyle getGroupHeaderStyle();

	public DRIReportStyle getGroupFooterStyle();

	public DRIReportStyle getDetailHeaderStyle();

	public DRIReportStyle getDetailStyle();

	public DRIReportStyle getDetailFooterStyle();

	public DRIReportStyle getLastPageFooterStyle();

	public DRIReportStyle getSummaryStyle();

	public DRIReportStyle getNoDataStyle();

	public DRIReportStyle getBackgroundStyle();

	public DRIComponent getTitleBackgroundComponent();

	public DRIComponent getPageHeaderBackgroundComponent();

	public DRIComponent getPageFooterBackgroundComponent();

	public DRIComponent getColumnHeaderBackgroundComponent();

	public DRIComponent getColumnFooterBackgroundComponent();

	public DRIComponent getGroupHeaderBackgroundComponent();

	public DRIComponent getGroupFooterBackgroundComponent();

	public DRIComponent getDetailHeaderBackgroundComponent();

	public DRIComponent getDetailBackgroundComponent();

	public DRIComponent getDetailFooterBackgroundComponent();

	public DRIComponent getLastPageFooterBackgroundComponent();

	public DRIComponent getSummaryBackgroundComponent();

	public DRIComponent getNoDataBackgroundComponent();

	public DRIComponent getBackgroundBackgroundComponent();

}

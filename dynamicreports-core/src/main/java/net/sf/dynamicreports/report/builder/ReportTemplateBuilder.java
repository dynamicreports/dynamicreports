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

package net.sf.dynamicreports.report.builder;

import java.awt.Color;
import java.util.Locale;

import net.sf.dynamicreports.report.base.DRReportTemplate;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
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
import net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer;

import org.apache.commons.lang3.Validate;

/**
 * <p>ReportTemplateBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ReportTemplateBuilder extends AbstractBuilder<ReportTemplateBuilder, DRReportTemplate> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	/**
	 * <p>Constructor for ReportTemplateBuilder.</p>
	 */
	protected ReportTemplateBuilder() {
		super(new DRReportTemplate());
	}

	// template style
	/**
	 * <p>templateStyles.</p>
	 *
	 * @param templateStyles a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder templateStyles(TemplateStylesBuilder... templateStyles) {
		return addTemplateStyle(templateStyles);
	}

	/**
	 * <p>addTemplateStyle.</p>
	 *
	 * @param templateStyles a {@link net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder addTemplateStyle(TemplateStylesBuilder... templateStyles) {
		Validate.notNull(templateStyles, "templateStyles must not be null");
		Validate.noNullElements(templateStyles, "templateStyles must not contains null templateStyle");
		for (TemplateStylesBuilder templateStyle : templateStyles) {
			for (StyleBuilder style : templateStyle.getStyles()) {
				addTemplateStyle(style);
			}
		}
		return this;
	}

	/**
	 * <p>templateStyles.</p>
	 *
	 * @param templateStyles a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder templateStyles(StyleBuilder... templateStyles) {
		return addTemplateStyle(templateStyles);
	}

	/**
	 * <p>addTemplateStyle.</p>
	 *
	 * @param templateStyles a {@link net.sf.dynamicreports.report.builder.style.StyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder addTemplateStyle(StyleBuilder... templateStyles) {
		Validate.notNull(templateStyles, "templateStyles must not be null");
		Validate.noNullElements(templateStyles, "templateStyles must not contains null templateStyle");
		for (StyleBuilder templateStyle : templateStyles) {
			getObject().addTemplateStyle(templateStyle.build());
		}
		return this;
	}

	/**
	 * <p>setLocale.</p>
	 *
	 * @param locale a {@link java.util.Locale} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setLocale(Locale locale) {
		getObject().setLocale(locale);
		return this;
	}

	/**
	 * <p>setShowColumnTitle.</p>
	 *
	 * @param showColumnTitle a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setShowColumnTitle(Boolean showColumnTitle) {
		getObject().setShowColumnTitle(showColumnTitle);
		return this;
	}

	/**
	 * <p>setShowColumnValues.</p>
	 *
	 * @param showColumnValues a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setShowColumnValues(Boolean showColumnValues) {
		getObject().setShowColumnValues(showColumnValues);
		return this;
	}

	/**
	 * <p>ignorePagination.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder ignorePagination() {
		return setIgnorePagination(true);
	}

	/**
	 * <p>setIgnorePagination.</p>
	 *
	 * @param ignorePagination a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setIgnorePagination(Boolean ignorePagination) {
		getObject().setIgnorePagination(ignorePagination);
		return this;
	}

	/**
	 * <p>setWhenNoDataType.</p>
	 *
	 * @param whenNoDataType a {@link net.sf.dynamicreports.report.constant.WhenNoDataType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setWhenNoDataType(WhenNoDataType whenNoDataType) {
		getObject().setWhenNoDataType(whenNoDataType);
		return this;
	}

	/**
	 * <p>setWhenResourceMissingType.</p>
	 *
	 * @param whenResourceMissingType a {@link net.sf.dynamicreports.report.constant.WhenResourceMissingType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setWhenResourceMissingType(WhenResourceMissingType whenResourceMissingType) {
		getObject().setWhenResourceMissingType(whenResourceMissingType);
		return this;
	}

	/**
	 * <p>titleOnANewPage.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder titleOnANewPage() {
		return setTitleOnANewPage(true);
	}

	/**
	 * <p>setTitleOnANewPage.</p>
	 *
	 * @param titleOnANewPage a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setTitleOnANewPage(Boolean titleOnANewPage) {
		getObject().setTitleOnANewPage(titleOnANewPage);
		return this;
	}

	/**
	 * <p>summaryOnANewPage.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder summaryOnANewPage() {
		return setSummaryOnANewPage(true);
	}

	/**
	 * <p>setSummaryOnANewPage.</p>
	 *
	 * @param summaryOnANewPage a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setSummaryOnANewPage(Boolean summaryOnANewPage) {
		getObject().setSummaryOnANewPage(summaryOnANewPage);
		return this;
	}

	/**
	 * <p>summaryWithPageHeaderAndFooter.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder summaryWithPageHeaderAndFooter() {
		return setSummaryWithPageHeaderAndFooter(true);
	}

	/**
	 * <p>setSummaryWithPageHeaderAndFooter.</p>
	 *
	 * @param summaryWithPageHeaderAndFooter a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setSummaryWithPageHeaderAndFooter(Boolean summaryWithPageHeaderAndFooter) {
		getObject().setSummaryWithPageHeaderAndFooter(summaryWithPageHeaderAndFooter);
		return this;
	}

	/**
	 * <p>floatColumnFooter.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder floatColumnFooter() {
		return setFloatColumnFooter(true);
	}

	/**
	 * <p>setFloatColumnFooter.</p>
	 *
	 * @param floatColumnFooter a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setFloatColumnFooter(Boolean floatColumnFooter) {
		getObject().setFloatColumnFooter(floatColumnFooter);
		return this;
	}

	/**
	 * <p>setPrintOrder.</p>
	 *
	 * @param printOrder a {@link net.sf.dynamicreports.report.constant.Orientation} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPrintOrder(Orientation printOrder) {
		getObject().setPrintOrder(printOrder);
		return this;
	}

	/**
	 * <p>setColumnDirection.</p>
	 *
	 * @param columnDirection a {@link net.sf.dynamicreports.report.constant.RunDirection} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setColumnDirection(RunDirection columnDirection) {
		getObject().setColumnDirection(columnDirection);
		return this;
	}

	/**
	 * <p>setLanguage.</p>
	 *
	 * @param language a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setLanguage(String language) {
		getObject().setLanguage(language);
		return this;
	}

	/**
	 * <p>setUseFieldNameAsDescription.</p>
	 *
	 * @param useFieldNameAsDescription a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setUseFieldNameAsDescription(Boolean useFieldNameAsDescription) {
		getObject().setUseFieldNameAsDescription(useFieldNameAsDescription);
		return this;
	}

	/**
	 * <p>highlightDetailOddRows.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder highlightDetailOddRows() {
		return setHighlightDetailOddRows(true);
	}

	/**
	 * <p>setHighlightDetailOddRows.</p>
	 *
	 * @param highlightDetailOddRows a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setHighlightDetailOddRows(Boolean highlightDetailOddRows) {
		getObject().setHighlightDetailOddRows(highlightDetailOddRows);
		return this;
	}

	/**
	 * <p>setDetailOddRowStyle.</p>
	 *
	 * @param detailOddRowStyle a {@link net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDetailOddRowStyle(SimpleStyleBuilder detailOddRowStyle) {
		if (detailOddRowStyle != null) {
			getObject().setDetailOddRowStyle(detailOddRowStyle.build());
		} else {
			getObject().setDetailOddRowStyle(null);
		}
		return this;
	}

	/**
	 * <p>highlightDetailEvenRows.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder highlightDetailEvenRows() {
		return setHighlightDetailEvenRows(true);
	}

	/**
	 * <p>setHighlightDetailEvenRows.</p>
	 *
	 * @param highlightDetailEvenRows a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setHighlightDetailEvenRows(Boolean highlightDetailEvenRows) {
		getObject().setHighlightDetailEvenRows(highlightDetailEvenRows);
		return this;
	}

	/**
	 * <p>setDetailEvenRowStyle.</p>
	 *
	 * @param detailEvenRowStyle a {@link net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDetailEvenRowStyle(SimpleStyleBuilder detailEvenRowStyle) {
		if (detailEvenRowStyle != null) {
			getObject().setDetailEvenRowStyle(detailEvenRowStyle.build());
		} else {
			getObject().setDetailEvenRowStyle(null);
		}
		return this;
	}

	/**
	 * <p>setDefaultFont.</p>
	 *
	 * @param defaultFont a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDefaultFont(FontBuilder defaultFont) {
		if (defaultFont != null) {
			getObject().setDefaultFont(defaultFont.build());
		} else {
			getObject().setDefaultFont(null);
		}
		return this;
	}

	/**
	 * <p>setTextStyle.</p>
	 *
	 * @param textStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setTextStyle(ReportStyleBuilder textStyle) {
		if (textStyle != null) {
			getObject().setTextStyle(textStyle.build());
		} else {
			getObject().setTextStyle(null);
		}
		return this;
	}

	/**
	 * <p>setColumnTitleStyle.</p>
	 *
	 * @param columnTitleStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setColumnTitleStyle(ReportStyleBuilder columnTitleStyle) {
		if (columnTitleStyle != null) {
			getObject().setColumnTitleStyle(columnTitleStyle.build());
		} else {
			getObject().setColumnTitleStyle(null);
		}
		return this;
	}

	/**
	 * <p>setColumnStyle.</p>
	 *
	 * @param columnStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setColumnStyle(ReportStyleBuilder columnStyle) {
		if (columnStyle != null) {
			getObject().setColumnStyle(columnStyle.build());
		} else {
			getObject().setColumnStyle(null);
		}
		return this;
	}

	/**
	 * <p>setGroupTitleStyle.</p>
	 *
	 * @param groupTitleStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupTitleStyle(ReportStyleBuilder groupTitleStyle) {
		if (groupTitleStyle != null) {
			getObject().setGroupTitleStyle(groupTitleStyle.build());
		} else {
			getObject().setGroupTitleStyle(null);
		}
		return this;
	}

	/**
	 * <p>setGroupStyle.</p>
	 *
	 * @param groupStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupStyle(ReportStyleBuilder groupStyle) {
		if (groupStyle != null) {
			getObject().setGroupStyle(groupStyle.build());
		} else {
			getObject().setGroupStyle(null);
		}
		return this;
	}

	/**
	 * <p>setSubtotalStyle.</p>
	 *
	 * @param subtotalStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setSubtotalStyle(ReportStyleBuilder subtotalStyle) {
		if (subtotalStyle != null) {
			getObject().setSubtotalStyle(subtotalStyle.build());
		} else {
			getObject().setSubtotalStyle(null);
		}
		return this;
	}

	/**
	 * <p>setImageStyle.</p>
	 *
	 * @param imageStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setImageStyle(ReportStyleBuilder imageStyle) {
		if (imageStyle != null) {
			getObject().setImageStyle(imageStyle.build());
		} else {
			getObject().setImageStyle(null);
		}
		return this;
	}

	/**
	 * <p>setChartStyle.</p>
	 *
	 * @param chartStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setChartStyle(ReportStyleBuilder chartStyle) {
		if (chartStyle != null) {
			getObject().setChartStyle(chartStyle.build());
		} else {
			getObject().setChartStyle(null);
		}
		return this;
	}

	/**
	 * <p>setBarcodeStyle.</p>
	 *
	 * @param barcodeStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setBarcodeStyle(ReportStyleBuilder barcodeStyle) {
		if (barcodeStyle != null) {
			getObject().setBarcodeStyle(barcodeStyle.build());
		} else {
			getObject().setBarcodeStyle(null);
		}
		return this;
	}

	/**
	 * <p>setPageFormat.</p>
	 *
	 * @param pageType a {@link net.sf.dynamicreports.report.constant.PageType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPageFormat(PageType pageType) {
		return setPageFormat(pageType, PageOrientation.PORTRAIT);
	}

	/**
	 * <p>setPageFormat.</p>
	 *
	 * @param pageType a {@link net.sf.dynamicreports.report.constant.PageType} object.
	 * @param orientation a {@link net.sf.dynamicreports.report.constant.PageOrientation} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPageFormat(PageType pageType, PageOrientation orientation) {
		getObject().setPageFormat(pageType, orientation);
		return this;
	}

	/**
	 * <p>setPageMargin.</p>
	 *
	 * @param pageMargin a {@link net.sf.dynamicreports.report.builder.MarginBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPageMargin(MarginBuilder pageMargin) {
		if (pageMargin != null) {
			getObject().setPageMargin(pageMargin.build());
		} else {
			getObject().setPageMargin(null);
		}
		return this;
	}

	/**
	 * <p>setPageColumnsPerPage.</p>
	 *
	 * @param pageColumnsPerPage a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPageColumnsPerPage(Integer pageColumnsPerPage) {
		getObject().setPageColumnsPerPage(pageColumnsPerPage);
		return this;
	}

	/**
	 * <p>setPageColumnSpace.</p>
	 *
	 * @param pageColumnSpace a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPageColumnSpace(Integer pageColumnSpace) {
		getObject().setPageColumnSpace(pageColumnSpace);
		return this;
	}

	/**
	 * <p>setIgnorePageWidth.</p>
	 *
	 * @param ignorePageWidth a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setIgnorePageWidth(Boolean ignorePageWidth) {
		getObject().setIgnorePageWidth(ignorePageWidth);
		return this;
	}

	/**
	 * <p>setColumnPrintRepeatedDetailValues.</p>
	 *
	 * @param columnPrintRepeatedDetailValues a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setColumnPrintRepeatedDetailValues(Boolean columnPrintRepeatedDetailValues) {
		getObject().setColumnPrintRepeatedDetailValues(columnPrintRepeatedDetailValues);
		return this;
	}

	/**
	 * <p>setColumnWidth.</p>
	 *
	 * @param columnWidth a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setColumnWidth(Integer columnWidth) {
		getObject().setColumnWidth(columnWidth);
		return this;
	}

	/**
	 * <p>setGroupHeaderLayout.</p>
	 *
	 * @param groupHeaderLayout a {@link net.sf.dynamicreports.report.constant.GroupHeaderLayout} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupHeaderLayout(GroupHeaderLayout groupHeaderLayout) {
		getObject().setGroupHeaderLayout(groupHeaderLayout);
		return this;
	}

	/**
	 * <p>setGroupHideColumn.</p>
	 *
	 * @param groupHideColumn a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupHideColumn(Boolean groupHideColumn) {
		getObject().setGroupHideColumn(groupHideColumn);
		return this;
	}

	/**
	 * <p>setGroupShowColumnHeaderAndFooter.</p>
	 *
	 * @param groupShowColumnHeaderAndFooter a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupShowColumnHeaderAndFooter(Boolean groupShowColumnHeaderAndFooter) {
		getObject().setGroupShowColumnHeaderAndFooter(groupShowColumnHeaderAndFooter);
		return this;
	}

	/**
	 * <p>setGroupPadding.</p>
	 *
	 * @param groupPadding a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupPadding(Integer groupPadding) {
		getObject().setGroupPadding(groupPadding);
		return this;
	}

	/**
	 * <p>setGroupStartInNewPage.</p>
	 *
	 * @param groupStartInNewPage a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupStartInNewPage(Boolean groupStartInNewPage) {
		getObject().setGroupStartInNewPage(groupStartInNewPage);
		return this;
	}

	/**
	 * <p>setGroupStartInNewColumn.</p>
	 *
	 * @param groupStartInNewColumn a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupStartInNewColumn(Boolean groupStartInNewColumn) {
		getObject().setGroupStartInNewColumn(groupStartInNewColumn);
		return this;
	}

	/**
	 * <p>setGroupReprintHeaderOnEachPage.</p>
	 *
	 * @param groupReprintHeaderOnEachPage a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupReprintHeaderOnEachPage(Boolean groupReprintHeaderOnEachPage) {
		getObject().setGroupReprintHeaderOnEachPage(groupReprintHeaderOnEachPage);
		return this;
	}

	/**
	 * <p>setGroupResetPageNumber.</p>
	 *
	 * @param groupResetPageNumber a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupResetPageNumber(Boolean groupResetPageNumber) {
		getObject().setGroupResetPageNumber(groupResetPageNumber);
		return this;
	}

	/**
	 * <p>setGroupFooterPosition.</p>
	 *
	 * @param groupFooterPosition a {@link net.sf.dynamicreports.report.constant.GroupFooterPosition} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupFooterPosition(GroupFooterPosition groupFooterPosition) {
		getObject().setGroupFooterPosition(groupFooterPosition);
		return this;
	}

	/**
	 * <p>setGroupKeepTogether.</p>
	 *
	 * @param groupKeepTogether a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupKeepTogether(Boolean groupKeepTogether) {
		getObject().setGroupKeepTogether(groupKeepTogether);
		return this;
	}

	/**
	 * <p>setGroupHeaderWithSubtotal.</p>
	 *
	 * @param groupHeaderWithSubtotal a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupHeaderWithSubtotal(Boolean groupHeaderWithSubtotal) {
		getObject().setGroupHeaderWithSubtotal(groupHeaderWithSubtotal);
		return this;
	}

	/**
	 * <p>setSubtotalLabelPosition.</p>
	 *
	 * @param subtotalLabelPosition a {@link net.sf.dynamicreports.report.constant.Position} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setSubtotalLabelPosition(Position subtotalLabelPosition) {
		getObject().setSubtotalLabelPosition(subtotalLabelPosition);
		return this;
	}

	/**
	 * <p>tableOfContents.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder tableOfContents() {
		return setTableOfContents(true);
	}

	/**
	 * <p>setTableOfContents.</p>
	 *
	 * @param tableOfContents a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setTableOfContents(Boolean tableOfContents) {
		getObject().setTableOfContents(tableOfContents);
		return this;
	}

	/**
	 * <p>setTableOfContentsCustomizer.</p>
	 *
	 * @param tableOfContentsCustomizer a {@link net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setTableOfContentsCustomizer(TableOfContentsCustomizerBuilder tableOfContentsCustomizer) {
		getObject().setTableOfContentsCustomizer(tableOfContentsCustomizer.build());
		return this;
	}

	/**
	 * <p>setTableOfContentsCustomizer.</p>
	 *
	 * @param tableOfContentsCustomizer a {@link net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setTableOfContentsCustomizer(DRITableOfContentsCustomizer tableOfContentsCustomizer) {
		getObject().setTableOfContentsCustomizer(tableOfContentsCustomizer);
		return this;
	}

	/**
	 * <p>setTextFieldWidth.</p>
	 *
	 * @param textFieldWidth a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setTextFieldWidth(Integer textFieldWidth) {
		getObject().setTextFieldWidth(textFieldWidth);
		return this;
	}

	/**
	 * <p>setImageHeight.</p>
	 *
	 * @param imageHeight a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setImageHeight(Integer imageHeight) {
		getObject().setImageHeight(imageHeight);
		return this;
	}

	/**
	 * <p>setImageWidth.</p>
	 *
	 * @param imageWidth a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setImageWidth(Integer imageWidth) {
		getObject().setImageWidth(imageWidth);
		return this;
	}

	/**
	 * <p>setListgap.</p>
	 *
	 * @param listgap a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setListgap(Integer listgap) {
		getObject().setListgap(listgap);
		return this;
	}

	/**
	 * <p>setMultiPageListHeight.</p>
	 *
	 * @param multiPageListHeight a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setMultiPageListHeight(Integer multiPageListHeight) {
		getObject().setMultiPageListHeight(multiPageListHeight);
		return this;
	}

	/**
	 * <p>setMultiPageListWidth.</p>
	 *
	 * @param multiPageListWidth a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setMultiPageListWidth(Integer multiPageListWidth) {
		getObject().setMultiPageListWidth(multiPageListWidth);
		return this;
	}

	/**
	 * <p>setChartHeight.</p>
	 *
	 * @param chartHeight a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setChartHeight(Integer chartHeight) {
		getObject().setChartHeight(chartHeight);
		return this;
	}

	/**
	 * <p>setChartWidth.</p>
	 *
	 * @param chartWidth a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setChartWidth(Integer chartWidth) {
		getObject().setChartWidth(chartWidth);
		return this;
	}

	/**
	 * <p>chartSeriesColors.</p>
	 *
	 * @param seriesColors a {@link java.awt.Color} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder chartSeriesColors(Color... seriesColors) {
		return addChartSeriesColor(seriesColors);
	}

	/**
	 * <p>addChartSeriesColor.</p>
	 *
	 * @param seriesColors a {@link java.awt.Color} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder addChartSeriesColor(Color... seriesColors) {
		Validate.notNull(seriesColors, "seriesColors must not be null");
		for (Color seriesColor : seriesColors) {
			getObject().addChartSeriesColor(seriesColor);
		}
		return this;
	}

	/**
	 * <p>setChartValuePattern.</p>
	 *
	 * @param chartValuePattern a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setChartValuePattern(String chartValuePattern) {
		getObject().setChartValuePattern(chartValuePattern);
		return this;
	}

	/**
	 * <p>setChartPercentValuePattern.</p>
	 *
	 * @param chartPercentValuePattern a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setChartPercentValuePattern(String chartPercentValuePattern) {
		getObject().setChartPercentValuePattern(chartPercentValuePattern);
		return this;
	}

	/**
	 * <p>setChartTheme.</p>
	 *
	 * @param chartTheme a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setChartTheme(String chartTheme) {
		getObject().setChartTheme(chartTheme);
		return this;
	}

	/**
	 * <p>setBarcodeHeight.</p>
	 *
	 * @param barcodeHeight a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setBarcodeHeight(Integer barcodeHeight) {
		getObject().setBarcodeHeight(barcodeHeight);
		return this;
	}

	/**
	 * <p>setBarcodeWidth.</p>
	 *
	 * @param barcodeWidth a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setBarcodeWidth(Integer barcodeWidth) {
		getObject().setBarcodeWidth(barcodeWidth);
		return this;
	}

	/**
	 * <p>setSubreportHeight.</p>
	 *
	 * @param subreportHeight a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setSubreportHeight(Integer subreportHeight) {
		getObject().setSubreportHeight(subreportHeight);
		return this;
	}

	/**
	 * <p>setSubreportWidth.</p>
	 *
	 * @param subreportWidth a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setSubreportWidth(Integer subreportWidth) {
		getObject().setSubreportWidth(subreportWidth);
		return this;
	}

	/**
	 * <p>setCrosstabHeight.</p>
	 *
	 * @param crosstabHeight a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setCrosstabHeight(Integer crosstabHeight) {
		getObject().setCrosstabHeight(crosstabHeight);
		return this;
	}

	/**
	 * <p>setCrosstabWidth.</p>
	 *
	 * @param crosstabWidth a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setCrosstabWidth(Integer crosstabWidth) {
		getObject().setCrosstabWidth(crosstabWidth);
		return this;
	}

	/**
	 * <p>crosstabHighlightOddRows.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder crosstabHighlightOddRows() {
		return setCrosstabHighlightOddRows(true);
	}

	/**
	 * <p>setCrosstabHighlightOddRows.</p>
	 *
	 * @param crosstabHighlightOddRows a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setCrosstabHighlightOddRows(Boolean crosstabHighlightOddRows) {
		getObject().setCrosstabHighlightOddRows(crosstabHighlightOddRows);
		return this;
	}

	/**
	 * <p>setCrosstabOddRowStyle.</p>
	 *
	 * @param crosstabOddRowStyle a {@link net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setCrosstabOddRowStyle(SimpleStyleBuilder crosstabOddRowStyle) {
		if (crosstabOddRowStyle != null) {
			getObject().setCrosstabOddRowStyle(crosstabOddRowStyle.build());
		} else {
			getObject().setCrosstabOddRowStyle(null);
		}
		return this;
	}

	/**
	 * <p>crosstabHighlightEvenRows.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder crosstabHighlightEvenRows() {
		return setCrosstabHighlightEvenRows(true);
	}

	/**
	 * <p>setCrosstabHighlightEvenRows.</p>
	 *
	 * @param crosstabHighlightEvenRows a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setCrosstabHighlightEvenRows(Boolean crosstabHighlightEvenRows) {
		getObject().setCrosstabHighlightEvenRows(crosstabHighlightEvenRows);
		return this;
	}

	/**
	 * <p>setCrosstabEvenRowStyle.</p>
	 *
	 * @param crosstabEvenRowStyle a {@link net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setCrosstabEvenRowStyle(SimpleStyleBuilder crosstabEvenRowStyle) {
		if (crosstabEvenRowStyle != null) {
			getObject().setCrosstabEvenRowStyle(crosstabEvenRowStyle.build());
		} else {
			getObject().setCrosstabEvenRowStyle(null);
		}
		return this;
	}

	/**
	 * <p>setCrosstabGroupStyle.</p>
	 *
	 * @param crosstabGroupStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setCrosstabGroupStyle(ReportStyleBuilder crosstabGroupStyle) {
		if (crosstabGroupStyle != null) {
			getObject().setCrosstabGroupStyle(crosstabGroupStyle.build());
		} else {
			getObject().setCrosstabGroupStyle(null);
		}
		return this;
	}

	/**
	 * <p>setCrosstabGroupTotalStyle.</p>
	 *
	 * @param crosstabGroupTotalStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setCrosstabGroupTotalStyle(ReportStyleBuilder crosstabGroupTotalStyle) {
		if (crosstabGroupTotalStyle != null) {
			getObject().setCrosstabGroupTotalStyle(crosstabGroupTotalStyle.build());
		} else {
			getObject().setCrosstabGroupTotalStyle(null);
		}
		return this;
	}

	/**
	 * <p>setCrosstabGrandTotalStyle.</p>
	 *
	 * @param crosstabGrandTotalStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setCrosstabGrandTotalStyle(ReportStyleBuilder crosstabGrandTotalStyle) {
		if (crosstabGrandTotalStyle != null) {
			getObject().setCrosstabGrandTotalStyle(crosstabGrandTotalStyle.build());
		} else {
			getObject().setCrosstabGrandTotalStyle(null);
		}
		return this;
	}

	/**
	 * <p>setCrosstabCellStyle.</p>
	 *
	 * @param crosstabCellStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setCrosstabCellStyle(ReportStyleBuilder crosstabCellStyle) {
		if (crosstabCellStyle != null) {
			getObject().setCrosstabCellStyle(crosstabCellStyle.build());
		} else {
			getObject().setCrosstabCellStyle(null);
		}
		return this;
	}

	/**
	 * <p>setCrosstabMeasureTitleStyle.</p>
	 *
	 * @param crosstabMeasureTitleStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setCrosstabMeasureTitleStyle(ReportStyleBuilder crosstabMeasureTitleStyle) {
		if (crosstabMeasureTitleStyle != null) {
			getObject().setCrosstabMeasureTitleStyle(crosstabMeasureTitleStyle.build());
		} else {
			getObject().setCrosstabMeasureTitleStyle(null);
		}
		return this;
	}

	/**
	 * <p>setBooleanComponentType.</p>
	 *
	 * @param booleanComponentType a {@link net.sf.dynamicreports.report.constant.BooleanComponentType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setBooleanComponentType(BooleanComponentType booleanComponentType) {
		getObject().setBooleanComponentType(booleanComponentType);
		return this;
	}

	/**
	 * <p>setBooleanEmptyWhenNullValue.</p>
	 *
	 * @param booleanEmptyWhenNullValue a {@link java.lang.Boolean} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setBooleanEmptyWhenNullValue(Boolean booleanEmptyWhenNullValue) {
		getObject().setBooleanEmptyWhenNullValue(booleanEmptyWhenNullValue);
		return this;
	}

	/**
	 * Use setBooleanImageWidth(Integer booleanImageWidth)
	 *
	 * @param booleanColumnImageWidth a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	@Deprecated
	public ReportTemplateBuilder setBooleanColumnImageWidth(Integer booleanColumnImageWidth) {
		return setBooleanImageWidth(booleanColumnImageWidth);
	}

	/**
	 * <p>setBooleanImageWidth.</p>
	 *
	 * @param booleanImageWidth a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setBooleanImageWidth(Integer booleanImageWidth) {
		getObject().setBooleanImageWidth(booleanImageWidth);
		return this;
	}

	/**
	 * Use setBooleanImageHeight(Integer booleanImageHeight)
	 *
	 * @param booleanColumnImageHeight a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	@Deprecated
	public ReportTemplateBuilder setBooleanColumnImageHeight(Integer booleanColumnImageHeight) {
		return setBooleanImageHeight(booleanColumnImageHeight);
	}

	/**
	 * <p>setBooleanImageHeight.</p>
	 *
	 * @param booleanImageHeight a {@link java.lang.Integer} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setBooleanImageHeight(Integer booleanImageHeight) {
		getObject().setBooleanImageHeight(booleanImageHeight);
		return this;
	}

	/**
	 * <p>setBooleanColumnStyle.</p>
	 *
	 * @param cooleanColumnStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setBooleanColumnStyle(ReportStyleBuilder cooleanColumnStyle) {
		if (cooleanColumnStyle != null) {
			getObject().setBooleanColumnStyle(cooleanColumnStyle.build());
		} else {
			getObject().setBooleanColumnStyle(null);
		}
		return this;
	}

	// band split type
	/**
	 * <p>setDefaultSplitType.</p>
	 *
	 * @param defaultSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDefaultSplitType(SplitType defaultSplitType) {
		getObject().setDefaultSplitType(defaultSplitType);
		return this;
	}

	/**
	 * <p>setTitleSplitType.</p>
	 *
	 * @param titleSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setTitleSplitType(SplitType titleSplitType) {
		getObject().setTitleSplitType(titleSplitType);
		return this;
	}

	/**
	 * <p>setPageHeaderSplitType.</p>
	 *
	 * @param pageHeaderSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPageHeaderSplitType(SplitType pageHeaderSplitType) {
		getObject().setPageHeaderSplitType(pageHeaderSplitType);
		return this;
	}

	/**
	 * <p>setPageFooterSplitType.</p>
	 *
	 * @param pageFooterSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPageFooterSplitType(SplitType pageFooterSplitType) {
		getObject().setPageFooterSplitType(pageFooterSplitType);
		return this;
	}

	/**
	 * <p>setColumnHeaderSplitType.</p>
	 *
	 * @param columnHeaderSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setColumnHeaderSplitType(SplitType columnHeaderSplitType) {
		getObject().setColumnHeaderSplitType(columnHeaderSplitType);
		return this;
	}

	/**
	 * <p>setColumnFooterSplitType.</p>
	 *
	 * @param columnFooterSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setColumnFooterSplitType(SplitType columnFooterSplitType) {
		getObject().setColumnFooterSplitType(columnFooterSplitType);
		return this;
	}

	/**
	 * <p>setGroupHeaderSplitType.</p>
	 *
	 * @param groupHeaderSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupHeaderSplitType(SplitType groupHeaderSplitType) {
		getObject().setGroupHeaderSplitType(groupHeaderSplitType);
		return this;
	}

	/**
	 * <p>setGroupFooterSplitType.</p>
	 *
	 * @param groupFooterSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupFooterSplitType(SplitType groupFooterSplitType) {
		getObject().setGroupFooterSplitType(groupFooterSplitType);
		return this;
	}

	/**
	 * <p>setDetailHeaderSplitType.</p>
	 *
	 * @param detailHeaderSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDetailHeaderSplitType(SplitType detailHeaderSplitType) {
		getObject().setDetailHeaderSplitType(detailHeaderSplitType);
		return this;
	}

	/**
	 * <p>setDetailSplitType.</p>
	 *
	 * @param detailSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDetailSplitType(SplitType detailSplitType) {
		getObject().setDetailSplitType(detailSplitType);
		return this;
	}

	/**
	 * <p>setDetailFooterSplitType.</p>
	 *
	 * @param detailFooterSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDetailFooterSplitType(SplitType detailFooterSplitType) {
		getObject().setDetailFooterSplitType(detailFooterSplitType);
		return this;
	}

	/**
	 * <p>setLastPageFooterSplitType.</p>
	 *
	 * @param lastPageFooterSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setLastPageFooterSplitType(SplitType lastPageFooterSplitType) {
		getObject().setLastPageFooterSplitType(lastPageFooterSplitType);
		return this;
	}

	/**
	 * <p>setSummarySplitType.</p>
	 *
	 * @param summarySplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setSummarySplitType(SplitType summarySplitType) {
		getObject().setSummarySplitType(summarySplitType);
		return this;
	}

	/**
	 * <p>setNoDataSplitType.</p>
	 *
	 * @param noDataSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setNoDataSplitType(SplitType noDataSplitType) {
		getObject().setNoDataSplitType(noDataSplitType);
		return this;
	}

	/**
	 * <p>setBackgroundSplitType.</p>
	 *
	 * @param backgroundSplitType a {@link net.sf.dynamicreports.report.constant.SplitType} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setBackgroundSplitType(SplitType backgroundSplitType) {
		getObject().setBackgroundSplitType(backgroundSplitType);
		return this;
	}

	// band style
	/**
	 * <p>setTitleStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setTitleStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setTitleStyle(style.build());
		} else {
			getObject().setTitleStyle(null);
		}
		return this;
	}

	/**
	 * <p>setPageHeaderStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPageHeaderStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setPageHeaderStyle(style.build());
		} else {
			getObject().setPageHeaderStyle(null);
		}
		return this;
	}

	/**
	 * <p>setPageFooterStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPageFooterStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setPageFooterStyle(style.build());
		} else {
			getObject().setPageFooterStyle(null);
		}
		return this;
	}

	/**
	 * <p>setColumnHeaderStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setColumnHeaderStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setColumnHeaderStyle(style.build());
		} else {
			getObject().setColumnHeaderStyle(null);
		}
		return this;
	}

	/**
	 * <p>setColumnFooterStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setColumnFooterStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setColumnFooterStyle(style.build());
		} else {
			getObject().setColumnFooterStyle(null);
		}
		return this;
	}

	/**
	 * <p>setGroupHeaderStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupHeaderStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setGroupHeaderStyle(style.build());
		} else {
			getObject().setGroupHeaderStyle(null);
		}
		return this;
	}

	/**
	 * <p>setGroupFooterStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupFooterStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setGroupFooterStyle(style.build());
		} else {
			getObject().setGroupFooterStyle(null);
		}
		return this;
	}

	/**
	 * <p>setDetailHeaderStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDetailHeaderStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setDetailHeaderStyle(style.build());
		} else {
			getObject().setDetailHeaderStyle(null);
		}
		return this;
	}

	/**
	 * <p>setDetailStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDetailStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setDetailStyle(style.build());
		} else {
			getObject().setDetailStyle(null);
		}
		return this;
	}

	/**
	 * <p>setDetailFooterStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDetailFooterStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setDetailFooterStyle(style.build());
		} else {
			getObject().setDetailFooterStyle(null);
		}
		return this;
	}

	/**
	 * <p>setLastPageFooterStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setLastPageFooterStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setLastPageFooterStyle(style.build());
		} else {
			getObject().setLastPageFooterStyle(null);
		}
		return this;
	}

	/**
	 * <p>setSummaryStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setSummaryStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setSummaryStyle(style.build());
		} else {
			getObject().setSummaryStyle(null);
		}
		return this;
	}

	/**
	 * <p>setNoDataStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setNoDataStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setNoDataStyle(style.build());
		} else {
			getObject().setNoDataStyle(null);
		}
		return this;
	}

	/**
	 * <p>setBackgroundStyle.</p>
	 *
	 * @param style a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setBackgroundStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setBackgroundStyle(style.build());
		} else {
			getObject().setBackgroundStyle(null);
		}
		return this;
	}

	/**
	 * <p>setTitleBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setTitleBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setTitleBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setPageHeaderBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPageHeaderBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setPageHeaderBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setPageFooterBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setPageFooterBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setPageFooterBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setColumnHeaderBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setColumnHeaderBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setColumnHeaderBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setColumnFooterBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setColumnFooterBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setColumnFooterBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setGroupHeaderBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupHeaderBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setGroupHeaderBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setGroupFooterBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setGroupFooterBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setGroupFooterBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setDetailHeaderBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDetailHeaderBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setDetailHeaderBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setDetailBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDetailBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setDetailBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setDetailFooterBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setDetailFooterBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setDetailFooterBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setLastPageFooterBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setLastPageFooterBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setLastPageFooterBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setSummaryBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setSummaryBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setSummaryBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setNoDataBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setNoDataBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setNoDataBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>setBackgroundBackgroundComponent.</p>
	 *
	 * @param backgroundComponent a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
	 * @return a {@link net.sf.dynamicreports.report.builder.ReportTemplateBuilder} object.
	 */
	public ReportTemplateBuilder setBackgroundBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setBackgroundBackgroundComponent(backgroundComponent.build());
		return this;
	}

	/**
	 * <p>getReportTemplate.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.base.DRReportTemplate} object.
	 */
	public DRReportTemplate getReportTemplate() {
		return build();
	}
}

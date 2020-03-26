/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.design.transformation;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCell;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCellContent;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabColumnGroup;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabRowGroup;
import net.sf.dynamicreports.design.base.style.DRDesignStyle;
import net.sf.dynamicreports.design.constant.DefaultStyleType;
import net.sf.dynamicreports.design.definition.DRIDesignBand;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.DRIDesignPage;
import net.sf.dynamicreports.design.exception.DRDesignReportException;
import net.sf.dynamicreports.jasper.base.tableofcontents.JasperTocHeading;
import net.sf.dynamicreports.report.constant.BooleanComponentType;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.CrosstabPercentageType;
import net.sf.dynamicreports.report.constant.CrosstabTotalPosition;
import net.sf.dynamicreports.report.constant.GroupFooterPosition;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.constant.StretchType;
import net.sf.dynamicreports.report.constant.TextAdjust;
import net.sf.dynamicreports.report.constant.TimePeriod;
import net.sf.dynamicreports.report.constant.ValueLocation;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.defaults.Defaults;
import net.sf.dynamicreports.report.definition.DRIBand;
import net.sf.dynamicreports.report.definition.DRIField;
import net.sf.dynamicreports.report.definition.DRIGroup;
import net.sf.dynamicreports.report.definition.DRIMargin;
import net.sf.dynamicreports.report.definition.DRIReport;
import net.sf.dynamicreports.report.definition.DRIReportTemplate;
import net.sf.dynamicreports.report.definition.DRISubtotal;
import net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer;
import net.sf.dynamicreports.report.definition.DRITemplateDesign;
import net.sf.dynamicreports.report.definition.barcode.DRIBarbecue;
import net.sf.dynamicreports.report.definition.barcode.DRIBarcode;
import net.sf.dynamicreports.report.definition.chart.DRIChart;
import net.sf.dynamicreports.report.definition.chart.dataset.DRICategoryDataset;
import net.sf.dynamicreports.report.definition.chart.dataset.DRITimeSeriesDataset;
import net.sf.dynamicreports.report.definition.chart.plot.DRIAxisPlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIBasePlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIPiePlot;
import net.sf.dynamicreports.report.definition.chart.plot.DRIThermometerPlot;
import net.sf.dynamicreports.report.definition.column.DRIBooleanColumn;
import net.sf.dynamicreports.report.definition.column.DRIColumn;
import net.sf.dynamicreports.report.definition.column.DRIValueColumn;
import net.sf.dynamicreports.report.definition.component.DRIBooleanField;
import net.sf.dynamicreports.report.definition.component.DRIBreak;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.component.DRIDimensionComponent;
import net.sf.dynamicreports.report.definition.component.DRIEllipse;
import net.sf.dynamicreports.report.definition.component.DRIFiller;
import net.sf.dynamicreports.report.definition.component.DRIGenericElement;
import net.sf.dynamicreports.report.definition.component.DRIImage;
import net.sf.dynamicreports.report.definition.component.DRILine;
import net.sf.dynamicreports.report.definition.component.DRIList;
import net.sf.dynamicreports.report.definition.component.DRIMap;
import net.sf.dynamicreports.report.definition.component.DRIMultiPageList;
import net.sf.dynamicreports.report.definition.component.DRIPageXofY;
import net.sf.dynamicreports.report.definition.component.DRIRectangle;
import net.sf.dynamicreports.report.definition.component.DRISubreport;
import net.sf.dynamicreports.report.definition.component.DRITextField;
import net.sf.dynamicreports.report.definition.component.DRIXyList;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstab;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabColumnGroup;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabMeasure;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabRowGroup;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabVariable;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import net.sf.dynamicreports.report.definition.style.DRISimpleStyle;
import net.sf.dynamicreports.report.definition.style.DRIStyle;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * <p>TemplateTransform class.</p>
 *
 * @author Ricardo Mariaca, Jan Moxter
 * 
 */
public class TemplateTransform {
    private final DRIReport report;
    private final DesignTransformAccessor accessor;
    private final DRIReportTemplate template;
    private final DRITemplateDesign<?> templateDesign;

    /**
     * <p>Constructor for TemplateTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
     */
    public TemplateTransform(final DesignTransformAccessor accessor) {
        this.accessor = accessor;
        this.report = accessor.getReport();
        this.template = report.getTemplate();
        this.templateDesign = report.getTemplateDesign();
    }

    /**
     * <p>getReportName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getReportName() {
        if (report.getReportName() != null) {
            return report.getReportName();
        }
        if (templateDesign.getReportName() != null) {
            return templateDesign.getReportName();
        }
        return Defaults.getDefaults().getReportName();
    }

    /**
     * <p>getLocale.</p>
     *
     * @return a {@link java.util.Locale} object.
     */
    public Locale getLocale() {
        if (report.getLocale() != null) {
            return report.getLocale();
        }
        if (template.getLocale() != null) {
            return template.getLocale();
        }
        return Defaults.getDefaults().getLocale();
    }

    /**
     * <p>isShowColumnTitle.</p>
     *
     * @return a boolean.
     */
    protected boolean isShowColumnTitle() {
        if (report.getShowColumnTitle() != null) {
            return report.getShowColumnTitle();
        }
        if (template.getShowColumnTitle() != null) {
            return template.getShowColumnTitle();
        }
        return Defaults.getDefaults().isShowColumnTitle();
    }

    /**
     * <p>isShowColumnValues.</p>
     *
     * @return a boolean.
     */
    protected boolean isShowColumnValues() {
        if (report.getShowColumnValues() != null) {
            return report.getShowColumnValues();
        }
        if (template.getShowColumnValues() != null) {
            return template.getShowColumnValues();
        }
        return Defaults.getDefaults().isShowColumnValues();
    }

    /**
     * <p>getResourceBundleName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getResourceBundleName() {
        if (report.getResourceBundleName() != null) {
            return report.getResourceBundleName();
        }
        if (templateDesign.getResourceBundleName() != null) {
            return templateDesign.getResourceBundleName();
        }
        return null;
    }

    /**
     * <p>isIgnorePagination.</p>
     *
     * @return a boolean.
     */
    public boolean isIgnorePagination() {
        if (report.getIgnorePagination() != null) {
            return report.getIgnorePagination();
        }
        if (templateDesign.getIgnorePagination() != null) {
            return templateDesign.getIgnorePagination();
        }
        if (template.getIgnorePagination() != null) {
            return template.getIgnorePagination();
        }
        return Defaults.getDefaults().isIgnorePagination();
    }

    /**
     * <p>getWhenNoDataType.</p>
     *
     * @param emptyDetail a boolean.
     * @param noDataBand  a {@link net.sf.dynamicreports.design.definition.DRIDesignBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.WhenNoDataType} object.
     */
    public WhenNoDataType getWhenNoDataType(final boolean emptyDetail, final DRIDesignBand noDataBand) {
        if (report.getWhenNoDataType() != null) {
            return report.getWhenNoDataType();
        }
        if (templateDesign.getWhenNoDataType() != null) {
            return templateDesign.getWhenNoDataType();
        }
        if (template.getWhenNoDataType() != null) {
            return template.getWhenNoDataType();
        }
        if (noDataBand != null) {
            return WhenNoDataType.NO_DATA_SECTION;
        }
        if (emptyDetail) {
            return WhenNoDataType.ALL_SECTIONS_NO_DETAIL;
        }
        return Defaults.getDefaults().getWhenNoDataType();
    }

    /**
     * <p>getWhenResourceMissingType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.WhenResourceMissingType} object.
     */
    public WhenResourceMissingType getWhenResourceMissingType() {
        if (report.getWhenResourceMissingType() != null) {
            return report.getWhenResourceMissingType();
        }
        if (templateDesign.getWhenResourceMissingType() != null) {
            return templateDesign.getWhenResourceMissingType();
        }
        if (template.getWhenResourceMissingType() != null) {
            return template.getWhenResourceMissingType();
        }
        return Defaults.getDefaults().getWhenResourceMissingType();
    }

    /**
     * <p>isTitleOnANewPage.</p>
     *
     * @return a boolean.
     */
    public boolean isTitleOnANewPage() {
        if (report.getTitleOnANewPage() != null) {
            return report.getTitleOnANewPage();
        }
        if (templateDesign.getTitleOnANewPage() != null) {
            return templateDesign.getTitleOnANewPage();
        }
        if (template.getTitleOnANewPage() != null) {
            return template.getTitleOnANewPage();
        }
        return Defaults.getDefaults().isTitleOnANewPage();
    }

    /**
     * <p>isSummaryOnANewPage.</p>
     *
     * @return a boolean.
     */
    public boolean isSummaryOnANewPage() {
        if (report.getSummaryOnANewPage() != null) {
            return report.getSummaryOnANewPage();
        }
        if (templateDesign.getSummaryOnANewPage() != null) {
            return templateDesign.getSummaryOnANewPage();
        }
        if (template.getSummaryOnANewPage() != null) {
            return template.getSummaryOnANewPage();
        }
        return Defaults.getDefaults().isSummaryOnANewPage();
    }

    /**
     * <p>isSummaryWithPageHeaderAndFooter.</p>
     *
     * @return a boolean.
     */
    public boolean isSummaryWithPageHeaderAndFooter() {
        if (report.getSummaryWithPageHeaderAndFooter() != null) {
            return report.getSummaryWithPageHeaderAndFooter();
        }
        if (templateDesign.getSummaryWithPageHeaderAndFooter() != null) {
            return templateDesign.getSummaryWithPageHeaderAndFooter();
        }
        if (template.getSummaryWithPageHeaderAndFooter() != null) {
            return template.getSummaryWithPageHeaderAndFooter();
        }
        return Defaults.getDefaults().isSummaryWithPageHeaderAndFooter();
    }

    /**
     * <p>isFloatColumnFooter.</p>
     *
     * @return a boolean.
     */
    public boolean isFloatColumnFooter() {
        if (report.getFloatColumnFooter() != null) {
            return report.getFloatColumnFooter();
        }
        if (templateDesign.getFloatColumnFooter() != null) {
            return templateDesign.getFloatColumnFooter();
        }
        if (template.getFloatColumnFooter() != null) {
            return template.getFloatColumnFooter();
        }
        return Defaults.getDefaults().isFloatColumnFooter();
    }

    /**
     * <p>getPrintOrder.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.Orientation} object.
     */
    public Orientation getPrintOrder() {
        if (report.getPrintOrder() != null) {
            return report.getPrintOrder();
        }
        if (template.getPrintOrder() != null) {
            return template.getPrintOrder();
        }
        return Defaults.getDefaults().getPrintOrder();
    }

    /**
     * <p>getColumnDirection.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.RunDirection} object.
     */
    public RunDirection getColumnDirection() {
        if (report.getColumnDirection() != null) {
            return report.getColumnDirection();
        }
        if (template.getColumnDirection() != null) {
            return template.getColumnDirection();
        }
        return Defaults.getDefaults().getColumnDirection();
    }

    /**
     * <p>getLanguage.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLanguage() {
        if (report.getLanguage() != null) {
            return report.getLanguage();
        }
        if (template.getLanguage() != null) {
            return template.getLanguage();
        }
        return Defaults.getDefaults().getLanguage();
    }

    /**
     * <p>getFieldDescription.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.definition.DRIField} object.
     * @return a {@link java.lang.String} object.
     */
    public String getFieldDescription(final DRIField<?> field) {
        if (field.getDescription() != null) {
            return field.getDescription();
        }
        if (isUseFieldNameAsDescription()) {
            return field.getName();
        }
        return null;
    }

    private boolean isUseFieldNameAsDescription() {
        if (report.getUseFieldNameAsDescription() != null) {
            return report.getUseFieldNameAsDescription();
        }
        if (template.getUseFieldNameAsDescription() != null) {
            return template.getUseFieldNameAsDescription();
        }
        return Defaults.getDefaults().isUseFieldNameAsDescription();
    }

    // table of contents

    /**
     * <p>isTableOfContents.</p>
     *
     * @param tocHeadings a {@link java.util.Map} object.
     * @return a boolean.
     */
    public boolean isTableOfContents(final Map<String, JasperTocHeading> tocHeadings) {
        if (tocHeadings != null) {
            return true;
        }
        if (report.getTableOfContents() != null) {
            return report.getTableOfContents();
        }
        if (template.getTableOfContents() != null) {
            return template.getTableOfContents();
        }
        return Defaults.getDefaults().isTableOfContents();
    }

    /**
     * <p>getTableOfContentsCustomizer.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer} object.
     */
    public DRITableOfContentsCustomizer getTableOfContentsCustomizer() {
        if (report.getTableOfContentsCustomizer() != null) {
            return report.getTableOfContentsCustomizer();
        }
        if (template.getTableOfContentsCustomizer() != null) {
            return template.getTableOfContentsCustomizer();
        }
        return Defaults.getDefaults().getTableOfContentsCustomizer();
    }

    /**
     * <p>isAddGroupToTableOfContents.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a boolean.
     */
    public boolean isAddGroupToTableOfContents(final DRIGroup group) {
        if (group.getAddToTableOfContents() != null) {
            return group.getAddToTableOfContents();
        }
        return Defaults.getDefaults().isAddGroupToTableOfContents();
    }

    // style

    /**
     * <p>getDetailOddRowStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRISimpleStyle} object.
     */
    protected DRISimpleStyle getDetailOddRowStyle() {
        if (isHighlightDetailOddRows()) {
            if (report.getDetailOddRowStyle() != null) {
                return report.getDetailOddRowStyle();
            }
            if (template.getDetailOddRowStyle() != null) {
                return template.getDetailOddRowStyle();
            }
            return Defaults.getDefaults().getDetailOddRowStyle();
        }
        return null;
    }

    /**
     * <p>getDetailEvenRowStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRISimpleStyle} object.
     */
    protected DRISimpleStyle getDetailEvenRowStyle() {
        if (isHighlightDetailEvenRows()) {
            if (report.getDetailEvenRowStyle() != null) {
                return report.getDetailEvenRowStyle();
            }
            if (template.getDetailEvenRowStyle() != null) {
                return template.getDetailEvenRowStyle();
            }
            return Defaults.getDefaults().getDetailEvenRowStyle();
        }
        return null;
    }

    private boolean isHighlightDetailOddRows() {
        if (report.getHighlightDetailOddRows() != null) {
            return report.getHighlightDetailOddRows();
        }
        if (template.getHighlightDetailOddRows() != null) {
            return template.getHighlightDetailOddRows();
        }
        return Defaults.getDefaults().isHighlightDetailOddRows();
    }

    private boolean isHighlightDetailEvenRows() {
        if (report.getHighlightDetailEvenRows() != null) {
            return report.getHighlightDetailEvenRows();
        }
        if (template.getHighlightDetailEvenRows() != null) {
            return template.getHighlightDetailEvenRows();
        }
        return Defaults.getDefaults().isHighlightDetailEvenRows();
    }

    /**
     * <p>getDefaultFontName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    protected String getDefaultFontName() {
        if (report.getDefaultFont() != null && report.getDefaultFont().getFontName() != null) {
            return report.getDefaultFont().getFontName();
        }
        if (template.getDefaultFont() != null && template.getDefaultFont().getFontName() != null) {
            return template.getDefaultFont().getFontName();
        }
        return Defaults.getDefaults().getFont().getFontName();
    }

    /**
     * <p>getDefaultFontSize.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    protected Integer getDefaultFontSize() {
        if (report.getDefaultFont() != null && report.getDefaultFont().getFontSize() != null) {
            return report.getDefaultFont().getFontSize();
        }
        if (template.getDefaultFont() != null && template.getDefaultFont().getFontSize() != null) {
            return template.getDefaultFont().getFontSize();
        }
        return Defaults.getDefaults().getFont().getFontSize();
    }

    /**
     * <p>getDefaultFontBold.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    protected Boolean getDefaultFontBold() {
        if (report.getDefaultFont() != null && report.getDefaultFont().getBold() != null) {
            return report.getDefaultFont().getBold();
        }
        if (template.getDefaultFont() != null && template.getDefaultFont().getBold() != null) {
            return template.getDefaultFont().getBold();
        }
        return Defaults.getDefaults().getFont().getBold();
    }

    /**
     * <p>getDefaultFontItalic.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    protected Boolean getDefaultFontItalic() {
        if (report.getDefaultFont() != null && report.getDefaultFont().getItalic() != null) {
            return report.getDefaultFont().getItalic();
        }
        if (template.getDefaultFont() != null && template.getDefaultFont().getItalic() != null) {
            return template.getDefaultFont().getItalic();
        }
        return Defaults.getDefaults().getFont().getItalic();
    }

    /**
     * <p>getDefaultFontUnderline.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    protected Boolean getDefaultFontUnderline() {
        if (report.getDefaultFont() != null && report.getDefaultFont().getUnderline() != null) {
            return report.getDefaultFont().getUnderline();
        }
        if (template.getDefaultFont() != null && template.getDefaultFont().getUnderline() != null) {
            return template.getDefaultFont().getUnderline();
        }
        return Defaults.getDefaults().getFont().getUnderline();
    }

    /**
     * <p>getDefaultFontStrikeThrough.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    protected Boolean getDefaultFontStrikeThrough() {
        if (report.getDefaultFont() != null && report.getDefaultFont().getStrikeThrough() != null) {
            return report.getDefaultFont().getStrikeThrough();
        }
        if (template.getDefaultFont() != null && template.getDefaultFont().getStrikeThrough() != null) {
            return template.getDefaultFont().getStrikeThrough();
        }
        return Defaults.getDefaults().getFont().getStrikeThrough();
    }

    /**
     * <p>getDefaultFontPdfFontName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    protected String getDefaultFontPdfFontName() {
        if (report.getDefaultFont() != null && report.getDefaultFont().getPdfFontName() != null) {
            return report.getDefaultFont().getPdfFontName();
        }
        if (template.getDefaultFont() != null && template.getDefaultFont().getPdfFontName() != null) {
            return template.getDefaultFont().getPdfFontName();
        }
        return Defaults.getDefaults().getFont().getPdfFontName();
    }

    /**
     * <p>getDefaultFontPdfEncoding.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    protected String getDefaultFontPdfEncoding() {
        if (report.getDefaultFont() != null && report.getDefaultFont().getPdfEncoding() != null) {
            return report.getDefaultFont().getPdfEncoding();
        }
        if (template.getDefaultFont() != null && template.getDefaultFont().getPdfEncoding() != null) {
            return template.getDefaultFont().getPdfEncoding();
        }
        return Defaults.getDefaults().getFont().getPdfEncoding();
    }

    /**
     * <p>getDefaultFontPdfEmbedded.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    protected Boolean getDefaultFontPdfEmbedded() {
        if (report.getDefaultFont() != null && report.getDefaultFont().getPdfEmbedded() != null) {
            return report.getDefaultFont().getPdfEmbedded();
        }
        if (template.getDefaultFont() != null && template.getDefaultFont().getPdfEmbedded() != null) {
            return template.getDefaultFont().getPdfEmbedded();
        }
        return Defaults.getDefaults().getFont().getPdfEmbedded();
    }

    /**
     * <p>getTextStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getTextStyle() {
        if (report.getTextStyle() != null) {
            return report.getTextStyle();
        }
        if (template.getTextStyle() != null) {
            return template.getTextStyle();
        }
        return Defaults.getDefaults().getTextStyle();
    }

    /**
     * <p>getColumnTitleStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getColumnTitleStyle() {
        if (report.getColumnTitleStyle() != null) {
            return report.getColumnTitleStyle();
        }
        if (template.getColumnTitleStyle() != null) {
            return template.getColumnTitleStyle();
        }
        if (Defaults.getDefaults().getColumnTitleStyle() != null) {
            return Defaults.getDefaults().getColumnTitleStyle();
        }
        return getTextStyle();
    }

    /**
     * <p>getColumnStyle.</p>
     *
     * @param textStyle a boolean.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getColumnStyle(final boolean textStyle) {
        if (report.getColumnStyle() != null) {
            return report.getColumnStyle();
        }
        if (template.getColumnStyle() != null) {
            return template.getColumnStyle();
        }
        if (Defaults.getDefaults().getColumnStyle() != null) {
            return Defaults.getDefaults().getColumnStyle();
        }
        if (textStyle) {
            return getTextStyle();
        }
        return null;
    }

    /**
     * <p>getGroupTitleStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getGroupTitleStyle() {
        if (report.getGroupTitleStyle() != null) {
            return report.getGroupTitleStyle();
        }
        if (template.getGroupTitleStyle() != null) {
            return template.getGroupTitleStyle();
        }
        if (Defaults.getDefaults().getGroupTitleStyle() != null) {
            return Defaults.getDefaults().getGroupTitleStyle();
        }
        return getTextStyle();
    }

    /**
     * <p>getGroupStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getGroupStyle() {
        if (report.getGroupStyle() != null) {
            return report.getGroupStyle();
        }
        if (template.getGroupStyle() != null) {
            return template.getGroupStyle();
        }
        if (Defaults.getDefaults().getGroupStyle() != null) {
            return Defaults.getDefaults().getGroupStyle();
        }
        return getTextStyle();
    }

    /**
     * <p>getSubtotalStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getSubtotalStyle() {
        if (report.getSubtotalStyle() != null) {
            return report.getSubtotalStyle();
        }
        if (template.getSubtotalStyle() != null) {
            return template.getSubtotalStyle();
        }
        if (Defaults.getDefaults().getSubtotalStyle() != null) {
            return Defaults.getDefaults().getSubtotalStyle();
        }
        return getTextStyle();
    }

    /**
     * <p>getImageStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getImageStyle() {
        if (report.getImageStyle() != null) {
            return report.getImageStyle();
        }
        if (template.getImageStyle() != null) {
            return template.getImageStyle();
        }
        return Defaults.getDefaults().getImageStyle();
    }

    /**
     * <p>getChartStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getChartStyle() {
        if (report.getChartStyle() != null) {
            return report.getChartStyle();
        }
        if (template.getChartStyle() != null) {
            return template.getChartStyle();
        }
        return Defaults.getDefaults().getChartStyle();
    }

    /**
     * <p>getBarcodeStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getBarcodeStyle() {
        if (report.getBarcodeStyle() != null) {
            return report.getBarcodeStyle();
        }
        if (template.getBarcodeStyle() != null) {
            return template.getBarcodeStyle();
        }
        return Defaults.getDefaults().getBarcodeStyle();
    }

    // page

    /**
     * <p>getPageWidth.</p>
     *
     * @return a int.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected int getPageWidth() throws DRException {
        if (isIgnorePageWidth()) {
            return getDynamicPageWidth();
        } else {
            return getStaticPageWidth();
        }
    }

    private boolean isIgnorePageWidth() {
        if (report.getPage().getIgnorePageWidth() != null) {
            return report.getPage().getIgnorePageWidth();
        }
        if (template.getIgnorePageWidth() != null) {
            return template.getIgnorePageWidth();
        }
        return Defaults.getDefaults().isIgnorePageWidth();
    }

    private int getDynamicPageWidth() throws DRException {
        int maxPageWidth = 0;
        maxPageWidth = getMaxBandWidth(accessor.getBandTransform().getTitleBand(), maxPageWidth);
        maxPageWidth = getMaxBandWidth(accessor.getBandTransform().getPageHeaderBand(), maxPageWidth);
        maxPageWidth = getMaxBandWidth(accessor.getBandTransform().getPageFooterBand(), maxPageWidth);
        maxPageWidth = getMaxBandWidth(accessor.getBandTransform().getColumnHeaderBand(), maxPageWidth);
        maxPageWidth = getMaxBandWidth(accessor.getBandTransform().getColumnFooterBand(), maxPageWidth);
        maxPageWidth = getMaxBandWidth(accessor.getBandTransform().getDetailBand(), maxPageWidth);
        maxPageWidth = getMaxBandWidth(accessor.getBandTransform().getLastPageFooterBand(), maxPageWidth);
        maxPageWidth = getMaxBandWidth(accessor.getBandTransform().getSummaryBand(), maxPageWidth);

        return maxPageWidth + getPageMargin().getLeft() + getPageMargin().getRight();
    }

    private int getMaxBandWidth(final DRIDesignBand band, final int maxWidth) throws DRException {
        if (band == null || band.getList() == null) {
            return maxWidth;
        }

        final int bandWidth = detectWidth(band.getList());
        if (bandWidth > maxWidth) {
            return bandWidth;
        }
        return maxWidth;
    }

    private int getStaticPageWidth() throws DRException {
        if (accessor.getPageWidth() != null) {
            return accessor.getPageWidth();
        }
        if (report.getPage().getWidth() != null) {
            return report.getPage().getWidth();
        }
        if (templateDesign.getPageWidth() != null) {
            return templateDesign.getPageWidth();
        }
        if (template.getPageWidth() != null) {
            return template.getPageWidth();
        }
        return Defaults.getDefaults().getPageWidth();
    }

    /**
     * <p>getPageHeight.</p>
     *
     * @return a int.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected int getPageHeight() throws DRException {
        if (report.getPage().getHeight() != null) {
            return report.getPage().getHeight();
        }
        if (templateDesign.getPageHeight() != null) {
            return templateDesign.getPageHeight();
        }
        if (template.getPageHeight() != null) {
            return template.getPageHeight();
        }
        return Defaults.getDefaults().getPageHeight();
    }

    /**
     * <p>getPageOrientation.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.PageOrientation} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected PageOrientation getPageOrientation() throws DRException {
        if (report.getPage().getOrientation() != null) {
            return report.getPage().getOrientation();
        }
        if (templateDesign.getPageOrientation() != null) {
            return templateDesign.getPageOrientation();
        }
        if (template.getPageOrientation() != null) {
            return template.getPageOrientation();
        }
        return Defaults.getDefaults().getPageOrientation();
    }

    /**
     * <p>getPageMargin.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIMargin} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRIMargin getPageMargin() throws DRException {
        if (report.getPage().getMargin() != null) {
            return report.getPage().getMargin();
        }
        if (templateDesign.getPageMargin() != null) {
            return templateDesign.getPageMargin();
        }
        if (accessor.getPageWidth() != null) {
            return Defaults.getDefaults().getSubreportPageMargin();
        }
        if (template.getPageMargin() != null) {
            return template.getPageMargin();
        }
        return Defaults.getDefaults().getPageMargin();
    }

    /**
     * <p>getPageColumnsPerPage.</p>
     *
     * @return a int.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected int getPageColumnsPerPage() throws DRException {
        if (report.getPage().getColumnsPerPage() != null) {
            return report.getPage().getColumnsPerPage();
        }
        if (templateDesign.getPageColumnsPerPage() != null) {
            return templateDesign.getPageColumnsPerPage();
        }
        if (template.getPageColumnsPerPage() != null) {
            return template.getPageColumnsPerPage();
        }
        return Defaults.getDefaults().getPageColumnsPerPage();
    }

    /**
     * <p>getPageColumnSpace.</p>
     *
     * @return a int.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected int getPageColumnSpace() throws DRException {
        if (report.getPage().getColumnSpace() != null) {
            return report.getPage().getColumnSpace();
        }
        if (templateDesign.getPageColumnSpace() != null) {
            return templateDesign.getPageColumnSpace();
        }
        if (template.getPageColumnSpace() != null) {
            return template.getPageColumnSpace();
        }
        return Defaults.getDefaults().getPageColumnSpace();
    }

    /**
     * <p>getPageColumnWidth.</p>
     *
     * @param page a {@link net.sf.dynamicreports.design.definition.DRIDesignPage} object.
     * @return a int.
     */
    protected int getPageColumnWidth(final DRIDesignPage page) {
        int columnWidth = page.getWidth() - page.getMargin().getLeft() - page.getMargin().getRight();
        columnWidth -= page.getColumnSpace() * (page.getColumnsPerPage() - 1);
        columnWidth = columnWidth / page.getColumnsPerPage();
        if (templateDesign.getPageColumnWidth() != null && templateDesign.getPageColumnWidth() > 0 && templateDesign.getPageColumnWidth() < columnWidth && !isIgnorePageWidth()) {
            return templateDesign.getPageColumnWidth();
        }
        return columnWidth;
    }

    // column

    /**
     * <p>isColumnPrintRepeatedDetailValues.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.definition.column.DRIValueColumn} object.
     * @return a boolean.
     */
    protected boolean isColumnPrintRepeatedDetailValues(final DRIValueColumn<?> column) {
        if (column.getPrintRepeatedDetailValues() != null) {
            return column.getPrintRepeatedDetailValues();
        }
        if (template.getColumnPrintRepeatedDetailValues() != null) {
            return template.getColumnPrintRepeatedDetailValues();
        }
        return Defaults.getDefaults().isColumnPrintRepeatedDetailValues();
    }

    /**
     * <p>getColumnWidth.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.definition.column.DRIColumn} object.
     * @param style  a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a int.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected int getColumnWidth(final DRIColumn<?> column, final DRDesignStyle style) throws DRException {
        final DRIComponent component = accessor.getColumnTransform().getColumnComponent(column);
        if (component != null) {
            if (component instanceof DRIList) {
                final DRDesignList list = accessor.getComponentTransform().list((DRIList) component, DefaultStyleType.COLUMN, null, null);
                return detectWidth(list);
            } else if (component instanceof DRIDimensionComponent) {
                if (((DRIDimensionComponent) component).getWidth() != null) {
                    return ((DRIDimensionComponent) component).getWidth();
                }
                if (component instanceof DRITextField<?>) {
                    if (((DRITextField<?>) component).getColumns() != null) {
                        return StyleResolver.getFontWidth(style, ((DRITextField<?>) component).getColumns());
                    }
                }
            } else {
                throw new DRDesignReportException("Component " + component.getClass().getName() + " not supported");
            }
        }
        return getColumnWidth();
    }

    /**
     * <p>getColumnWidth.</p>
     *
     * @return a int.
     */
    protected int getColumnWidth() {
        if (template.getColumnWidth() != null) {
            return template.getColumnWidth();
        }
        return Defaults.getDefaults().getColumnWidth();
    }

    // component

    /**
     * <p>getRemoveLineWhenBlank.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     * @return a boolean.
     */
    protected boolean getRemoveLineWhenBlank(final DRIComponent component) {
        if (component.getRemoveLineWhenBlank() != null) {
            return component.getRemoveLineWhenBlank();
        }
        return Defaults.getDefaults().isRemoveLineWhenBlank();
    }

    /**
     * <p>getPositionType.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     * @return a {@link net.sf.dynamicreports.report.constant.ComponentPositionType} object.
     */
    protected ComponentPositionType getPositionType(final DRIComponent component) {
        if (component instanceof DRIDimensionComponent && ((DRIDimensionComponent) component).getPositionType() != null) {
            return ((DRIDimensionComponent) component).getPositionType();
        }
        return null;
    }

    /**
     * <p>getStretchType.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     * @return a {@link net.sf.dynamicreports.report.constant.StretchType} object.
     */
    protected StretchType getStretchType(final DRIComponent component) {
        if (component instanceof DRIDimensionComponent && ((DRIDimensionComponent) component).getStretchType() != null) {
            return ((DRIDimensionComponent) component).getStretchType();
        }
        return null;
    }

    /**
     * <p>getPrintInFirstWholeBand.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     * @return a boolean.
     */
    protected boolean getPrintInFirstWholeBand(final DRIComponent component) {
        if (component instanceof DRIDimensionComponent && ((DRIDimensionComponent) component).getPrintInFirstWholeBand() != null) {
            return ((DRIDimensionComponent) component).getPrintInFirstWholeBand();
        }
        return Defaults.getDefaults().isPrintInFirstWholeBand();
    }

    /**
     * <p>getPrintWhenDetailOverflows.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     * @return a boolean.
     */
    protected boolean getPrintWhenDetailOverflows(final DRIComponent component) {
        if (component instanceof DRIDimensionComponent && ((DRIDimensionComponent) component).getPrintWhenDetailOverflows() != null) {
            return ((DRIDimensionComponent) component).getPrintWhenDetailOverflows();
        }
        return Defaults.getDefaults().isPrintWhenDetailOverflows();
    }

    /**
     * <p>getPrintWhenGroupChanges.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignGroup} object.
     */
    protected DRIDesignGroup getPrintWhenGroupChanges(final DRIComponent component) {
        if (component instanceof DRIDimensionComponent && ((DRIDimensionComponent) component).getPrintWhenGroupChanges() != null) {
            return accessor.getGroupTransform().getGroup(((DRIDimensionComponent) component).getPrintWhenGroupChanges());
        }
        return null;
    }

    // group

    /**
     * <p>getGroupHeaderLayout.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a {@link net.sf.dynamicreports.report.constant.GroupHeaderLayout} object.
     */
    protected GroupHeaderLayout getGroupHeaderLayout(final DRIGroup group) {
        if (group.getHeaderLayout() != null) {
            return group.getHeaderLayout();
        }
        if (template.getGroupHeaderLayout() != null) {
            return template.getGroupHeaderLayout();
        }
        return Defaults.getDefaults().getGroupHeaderLayout();
    }

    /**
     * <p>isGroupHideColumn.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a boolean.
     */
    protected boolean isGroupHideColumn(final DRIGroup group) {
        if (group.getHideColumn() != null) {
            return group.getHideColumn();
        }
        if (template.getGroupHideColumn() != null) {
            return template.getGroupHideColumn();
        }
        return Defaults.getDefaults().isGroupHideColumn();
    }

    /**
     * <p>isGroupShowColumnHeaderAndFooter.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a boolean.
     */
    protected boolean isGroupShowColumnHeaderAndFooter(final DRIGroup group) {
        if (group.getShowColumnHeaderAndFooter() != null) {
            return group.getShowColumnHeaderAndFooter();
        }
        if (template.getGroupShowColumnHeaderAndFooter() != null) {
            return template.getGroupShowColumnHeaderAndFooter();
        }
        return Defaults.getDefaults().isGroupShowColumnHeaderAndFooter();
    }

    /**
     * <p>getGroupPadding.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a int.
     */
    protected int getGroupPadding(final DRIGroup group) {
        if (group.getPadding() != null) {
            return group.getPadding();
        }
        if (template.getGroupPadding() != null) {
            return template.getGroupPadding();
        }
        return Defaults.getDefaults().getGroupPadding();
    }

    /**
     * <p>isGroupStartInNewPage.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a boolean.
     */
    protected boolean isGroupStartInNewPage(final DRIGroup group) {
        if (group.getStartInNewPage() != null) {
            return group.getStartInNewPage();
        }
        if (template.getGroupStartInNewPage() != null) {
            return template.getGroupStartInNewPage();
        }
        return Defaults.getDefaults().isGroupStartInNewPage();
    }

    /**
     * <p>isGroupStartInNewColumn.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a boolean.
     */
    protected boolean isGroupStartInNewColumn(final DRIGroup group) {
        if (group.getStartInNewColumn() != null) {
            return group.getStartInNewColumn();
        }
        if (template.getGroupStartInNewColumn() != null) {
            return template.getGroupStartInNewColumn();
        }
        return Defaults.getDefaults().isGroupStartInNewColumn();
    }

    /**
     * <p>isGroupReprintHeaderOnEachPage.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a boolean.
     */
    protected boolean isGroupReprintHeaderOnEachPage(final DRIGroup group) {
        if (group.getReprintHeaderOnEachPage() != null) {
            return group.getReprintHeaderOnEachPage();
        }
        if (template.getGroupReprintHeaderOnEachPage() != null) {
            return template.getGroupReprintHeaderOnEachPage();
        }
        return Defaults.getDefaults().isGroupReprintHeaderOnEachPage();
    }

    /**
     * <p>isGroupResetPageNumber.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a boolean.
     */
    protected boolean isGroupResetPageNumber(final DRIGroup group) {
        if (group.getResetPageNumber() != null) {
            return group.getResetPageNumber();
        }
        if (template.getGroupResetPageNumber() != null) {
            return template.getGroupResetPageNumber();
        }
        return Defaults.getDefaults().isGroupResetPageNumber();
    }

    /**
     * <p>getGroupMinHeightToStartNewPage.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a {@link java.lang.Integer} object.
     */
    protected Integer getGroupMinHeightToStartNewPage(final DRIGroup group) {
        if (group.getMinHeightToStartNewPage() != null) {
            return group.getMinHeightToStartNewPage();
        }
        return Defaults.getDefaults().getGroupMinHeightToStartNewPage();
    }

    /**
     * <p>getGroupFooterPosition.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a {@link net.sf.dynamicreports.report.constant.GroupFooterPosition} object.
     */
    protected GroupFooterPosition getGroupFooterPosition(final DRIGroup group) {
        if (group.getFooterPosition() != null) {
            return group.getFooterPosition();
        }
        if (template.getGroupFooterPosition() != null) {
            return template.getGroupFooterPosition();
        }
        return Defaults.getDefaults().getGroupFooterPosition();
    }

    /**
     * <p>isGroupKeepTogether.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a boolean.
     */
    protected boolean isGroupKeepTogether(final DRIGroup group) {
        if (group.getKeepTogether() != null) {
            return group.getKeepTogether();
        }
        if (template.getGroupKeepTogether() != null) {
            return template.getGroupKeepTogether();
        }
        return Defaults.getDefaults().isGroupKeepTogether();
    }

    /**
     * <p>isGroupHeaderWithSubtotal.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a boolean.
     */
    protected boolean isGroupHeaderWithSubtotal(final DRIGroup group) {
        if (group.getHeaderWithSubtotal() != null) {
            return group.getHeaderWithSubtotal();
        }
        if (template.getGroupHeaderWithSubtotal() != null) {
            return template.getGroupHeaderWithSubtotal();
        }
        return Defaults.getDefaults().isGroupHeaderWithSubtotal();
    }

    /**
     * <p>isGroupByDataType.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     * @return a boolean.
     */
    protected boolean isGroupByDataType(final DRIGroup group) {
        if (group.getGroupByDataType() != null) {
            return group.getGroupByDataType();
        }
        return Defaults.getDefaults().isGroupByDataType();
    }

    // subtotal

    /**
     * <p>getSubtotalLabelPosition.</p>
     *
     * @param subtotal a {@link net.sf.dynamicreports.report.definition.DRISubtotal} object.
     * @return a {@link net.sf.dynamicreports.report.constant.Position} object.
     */
    public Position getSubtotalLabelPosition(final DRISubtotal<?> subtotal) {
        if (subtotal.getLabelPosition() != null) {
            return subtotal.getLabelPosition();
        }
        if (template.getSubtotalLabelPosition() != null) {
            return template.getSubtotalLabelPosition();
        }
        return Defaults.getDefaults().getSubtotalLabelPosition();
    }

    // text field

    /**
     * <p>getTextFieldWidth.</p>
     *
     * @param textField a {@link net.sf.dynamicreports.report.definition.component.DRITextField} object.
     * @param style     a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a int.
     */
    protected int getTextFieldWidth(final DRITextField<?> textField, final DRDesignStyle style) {
        if (textField.getWidth() != null) {
            return textField.getWidth();
        }
        if (textField.getColumns() != null) {
            return StyleResolver.getFontWidth(style, textField.getColumns());
        }
        if (template.getTextFieldWidth() != null) {
            return template.getTextFieldWidth();
        }
        return Defaults.getDefaults().getTextFieldWidth();
    }

    /**
     * <p>getTextFieldHeight.</p>
     *
     * @param textField a {@link net.sf.dynamicreports.report.definition.component.DRITextField} object.
     * @param style     a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a int.
     */
    protected int getTextFieldHeight(final DRITextField<?> textField, final DRDesignStyle style) {
        if (textField.getHeight() != null) {
            return textField.getHeight();
        }
        if (textField.getRows() != null) {
            return StyleResolver.getFontHeight(style, textField.getRows());
        }
        return StyleResolver.getFontHeight(style, 1);
    }

    /**
     * <p>getTextFieldPattern.</p>
     *
     * @param textField a {@link net.sf.dynamicreports.report.definition.component.DRITextField} object.
     * @param style     a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a {@link java.lang.String} object.
     */
    protected String getTextFieldPattern(final DRITextField<?> textField, final DRDesignStyle style) {
        if (textField.getPattern() != null) {
            return textField.getPattern();
        }
        if (StyleResolver.getPattern(style) != null) {
            return null;// StyleResolver.getPattern(style);
        }
        if (textField.getDataType() != null) {
            return textField.getDataType().getPattern();
        }
        return null;
    }

    /**
     * <p>getTextFieldHorizontalTextAlignment.</p>
     *
     * @param textField a {@link net.sf.dynamicreports.report.definition.component.DRITextField} object.
     * @param style     a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     */
    protected HorizontalTextAlignment getTextFieldHorizontalTextAlignment(final DRITextField<?> textField, final DRDesignStyle style) {
        if (textField.getHorizontalTextAlignment() != null) {
            return textField.getHorizontalTextAlignment();
        }
        if (StyleResolver.getHorizontalTextAlignment(style) != null) {
            return null;// StyleResolver.getHorizontalTextAlignment(style);
        }
        if (textField.getDataType() != null) {
            return textField.getDataType().getHorizontalTextAlignment();
        }
        return null;
    }

    /**
     * <p>getTextFieldValueFormatter.</p>
     *
     * @param textField a {@link net.sf.dynamicreports.report.definition.component.DRITextField} object.
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIValueFormatter} object.
     */
    protected DRIValueFormatter<?, ?> getTextFieldValueFormatter(final DRITextField<?> textField) {
        if (textField.getValueFormatter() != null) {
            return textField.getValueFormatter();
        }
        if (textField.getDataType() != null) {
            return textField.getDataType().getValueFormatter();
        }
        return null;
    }

    /**
     * <p>getTextFieldStretchWithOverflow.</p>
     *
     * @param textField a {@link net.sf.dynamicreports.report.definition.component.DRITextField} object.
     * @return a boolean.
     * @deprecated replaced by {@link #getTextFieldTextAdjust(DRITextField)}
     */
    @Deprecated
    protected boolean getTextFieldStretchWithOverflow(final DRITextField<?> textField) {
        if (textField.getStretchWithOverflow() != null) {
            return textField.getStretchWithOverflow();
        }
        return Defaults.getDefaults().isTextFieldStretchWithOverflow();
    }

    /**
     * <p>getTextFieldTextAdjust.</p>
     *
     * @param textField a {@link net.sf.dynamicreports.report.definition.component.DRITextField} object.
     * @return a {@link net.sf.dynamicreports.report.constant.TextAdjust} object.
     */
    protected TextAdjust getTextFieldTextAdjust(final DRITextField<?> textField) {
        if (textField.getTextAdjust() != null) {
            return textField.getTextAdjust();
        }
        return Defaults.getDefaults().getTextFieldTextAdjust();
    }

    /**
     * <p>isTextFieldPrintRepeatedValues.</p>
     *
     * @param textField a {@link net.sf.dynamicreports.report.definition.component.DRITextField} object.
     * @return a boolean.
     */
    protected boolean isTextFieldPrintRepeatedValues(final DRITextField<?> textField) {
        if (textField.getPrintRepeatedValues() != null) {
            return textField.getPrintRepeatedValues();
        }
        return Defaults.getDefaults().isTextFieldPrintRepeatedValues();
    }

    // text field

    /**
     * <p>getBooleanFieldWidth.</p>
     *
     * @param booleanField a {@link net.sf.dynamicreports.report.definition.component.DRIBooleanField} object.
     * @param style        a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a int.
     */
    protected int getBooleanFieldWidth(final DRIBooleanField booleanField, final DRDesignStyle style) {
        if (booleanField.getWidth() != null) {
            return booleanField.getWidth();
        }
        if (template.getTextFieldWidth() != null) {
            return template.getTextFieldWidth();
        }
        return Defaults.getDefaults().getTextFieldWidth();
    }

    /**
     * <p>getBooleanFieldHeight.</p>
     *
     * @param booleanField a {@link net.sf.dynamicreports.report.definition.component.DRIBooleanField} object.
     * @param style        a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a int.
     */
    protected int getBooleanFieldHeight(final DRIBooleanField booleanField, final DRDesignStyle style) {
        if (booleanField.getHeight() != null) {
            return booleanField.getHeight();
        }
        return StyleResolver.getFontHeight(style, 1);
    }

    // page x of y

    /**
     * <p>getPageXofYWidth.</p>
     *
     * @param pageXofY a {@link net.sf.dynamicreports.report.definition.component.DRIPageXofY} object.
     * @return a int.
     */
    protected int getPageXofYWidth(final DRIPageXofY pageXofY) {
        if (pageXofY.getWidth() != null) {
            return pageXofY.getWidth();
        }
        if (template.getTextFieldWidth() != null) {
            return template.getTextFieldWidth();
        }
        return Defaults.getDefaults().getTextFieldWidth();
    }

    /**
     * <p>getPageXofYHeight.</p>
     *
     * @param pageXofY a {@link net.sf.dynamicreports.report.definition.component.DRIPageXofY} object.
     * @param style    a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a int.
     */
    protected int getPageXofYHeight(final DRIPageXofY pageXofY, final DRDesignStyle style) {
        if (pageXofY.getHeight() != null) {
            return pageXofY.getHeight();
        }
        return StyleResolver.getFontHeight(style, 1);
    }

    /**
     * <p>getPageXofYHorizontalTextAlignment.</p>
     *
     * @param pageXofY a {@link net.sf.dynamicreports.report.definition.component.DRIPageXofY} object.
     * @param style    a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     */
    protected HorizontalTextAlignment getPageXofYHorizontalTextAlignment(final DRIPageXofY pageXofY, final DRDesignStyle style) {
        if (pageXofY.getHorizontalTextAlignment() != null) {
            return pageXofY.getHorizontalTextAlignment();
        }
        if (StyleResolver.getHorizontalTextAlignment(style) != null) {
            return StyleResolver.getHorizontalTextAlignment(style);
        }
        return Defaults.getDefaults().getPageXofYHorizontalTextAlignment();
    }

    // image

    /**
     * <p>getImageWidth.</p>
     *
     * @param image a {@link net.sf.dynamicreports.report.definition.component.DRIImage} object.
     * @return a int.
     */
    protected int getImageWidth(final DRIImage image) {
        if (image.getWidth() != null) {
            return image.getWidth();
        }
        if (template.getImageWidth() != null) {
            return template.getImageWidth();
        }
        return Defaults.getDefaults().getImageWidth();
    }

    /**
     * <p>getImageHeight.</p>
     *
     * @param image       a {@link net.sf.dynamicreports.report.definition.component.DRIImage} object.
     * @param imageHeight a {@link java.lang.Integer} object.
     * @param imageHeight a {@link java.lang.Integer} object.
     * @param style       a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a int.
     */
    protected int getImageHeight(final DRIImage image, final Integer imageHeight, final DRDesignStyle style) {
        if (image.getHeight() != null) {
            return image.getHeight();
        }
        if (imageHeight != null) {
            return imageHeight + StyleResolver.getVerticalPadding(style);
        }
        if (template.getImageHeight() != null) {
            return template.getImageHeight();
        }
        return Defaults.getDefaults().getImageHeight();
    }

    // filler

    /**
     * <p>getFillerWidth.</p>
     *
     * @param filler a {@link net.sf.dynamicreports.report.definition.component.DRIFiller} object.
     * @return a int.
     */
    protected int getFillerWidth(final DRIFiller filler) {
        if (filler.getWidth() != null) {
            return filler.getWidth();
        }
        return Defaults.getDefaults().getFillerWidth();
    }

    /**
     * <p>getFillerHeight.</p>
     *
     * @param filler a {@link net.sf.dynamicreports.report.definition.component.DRIFiller} object.
     * @return a int.
     */
    protected int getFillerHeight(final DRIFiller filler) {
        if (filler.getHeight() != null) {
            return filler.getHeight();
        }
        return Defaults.getDefaults().getFillerHeight();
    }

    // line

    /**
     * <p>getLineWidth.</p>
     *
     * @param line a {@link net.sf.dynamicreports.report.definition.component.DRILine} object.
     * @return a int.
     */
    protected int getLineWidth(final DRILine line) {
        if (line.getWidth() != null) {
            return line.getWidth();
        }
        return Defaults.getDefaults().getLineWidth();
    }

    /**
     * <p>getLineHeight.</p>
     *
     * @param line a {@link net.sf.dynamicreports.report.definition.component.DRILine} object.
     * @return a int.
     */
    protected int getLineHeight(final DRILine line) {
        if (line.getHeight() != null) {
            return line.getHeight();
        }
        return Defaults.getDefaults().getLineHeight();
    }

    // ellipse

    /**
     * <p>getEllipseWidth.</p>
     *
     * @param ellipse a {@link net.sf.dynamicreports.report.definition.component.DRIEllipse} object.
     * @return a int.
     */
    protected int getEllipseWidth(final DRIEllipse ellipse) {
        if (ellipse.getWidth() != null) {
            return ellipse.getWidth();
        }
        return Defaults.getDefaults().getEllipseWidth();
    }

    /**
     * <p>getEllipseHeight.</p>
     *
     * @param ellipse a {@link net.sf.dynamicreports.report.definition.component.DRIEllipse} object.
     * @return a int.
     */
    protected int getEllipseHeight(final DRIEllipse ellipse) {
        if (ellipse.getHeight() != null) {
            return ellipse.getHeight();
        }
        return Defaults.getDefaults().getEllipseHeight();
    }

    // rectangle

    /**
     * <p>getRectangleRadius.</p>
     *
     * @param rectangle a {@link net.sf.dynamicreports.report.definition.component.DRIRectangle} object.
     * @return a {@link java.lang.Integer} object.
     */
    protected Integer getRectangleRadius(final DRIRectangle rectangle) {
        if (rectangle.getRadius() != null) {
            return rectangle.getRadius();
        }
        return Defaults.getDefaults().getRectangleRadius();
    }

    /**
     * <p>getRectangleWidth.</p>
     *
     * @param rectangle a {@link net.sf.dynamicreports.report.definition.component.DRIRectangle} object.
     * @return a int.
     */
    protected int getRectangleWidth(final DRIRectangle rectangle) {
        if (rectangle.getWidth() != null) {
            return rectangle.getWidth();
        }
        return Defaults.getDefaults().getRectangleWidth();
    }

    /**
     * <p>getRectangleHeight.</p>
     *
     * @param rectangle a {@link net.sf.dynamicreports.report.definition.component.DRIRectangle} object.
     * @return a int.
     */
    protected int getRectangleHeight(final DRIRectangle rectangle) {
        if (rectangle.getHeight() != null) {
            return rectangle.getHeight();
        }
        return Defaults.getDefaults().getRectangleHeight();
    }

    // map

    /**
     * <p>getMapWidth.</p>
     *
     * @param map a {@link net.sf.dynamicreports.report.definition.component.DRIMap} object.
     * @return a int.
     */
    protected int getMapWidth(final DRIMap map) {
        if (map.getWidth() != null) {
            return map.getWidth();
        }
        return Defaults.getDefaults().getMapWidth();
    }

    /**
     * <p>getMapHeight.</p>
     *
     * @param map a {@link net.sf.dynamicreports.report.definition.component.DRIMap} object.
     * @return a int.
     */
    protected int getMapHeight(final DRIMap map) {
        if (map.getHeight() != null) {
            return map.getHeight();
        }
        return Defaults.getDefaults().getMapHeight();
    }

    // custom component

    /**
     * <p>getCustomComponentWidth.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.definition.component.DRIDimensionComponent} object.
     * @return a int.
     */
    protected int getCustomComponentWidth(final DRIDimensionComponent component) {
        if (component.getWidth() != null) {
            return component.getWidth();
        }
        return Defaults.getDefaults().getCustomComponentWidth();
    }

    /**
     * <p>getCustomComponentHeight.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.definition.component.DRIDimensionComponent} object.
     * @return a int.
     */
    protected int getCustomComponentHeight(final DRIDimensionComponent component) {
        if (component.getHeight() != null) {
            return component.getHeight();
        }
        return Defaults.getDefaults().getCustomComponentHeight();
    }

    // break

    /**
     * <p>getBreakWidth.</p>
     *
     * @param breakComponent a {@link net.sf.dynamicreports.report.definition.component.DRIBreak} object.
     * @return a int.
     */
    protected int getBreakWidth(final DRIBreak breakComponent) {
        return Defaults.getDefaults().getBreakWidth();
    }

    /**
     * <p>getBreakHeight.</p>
     *
     * @param breakComponent a {@link net.sf.dynamicreports.report.definition.component.DRIBreak} object.
     * @return a int.
     */
    protected int getBreakHeight(final DRIBreak breakComponent) {
        return Defaults.getDefaults().getBreakHeight();
    }

    // generic element

    /**
     * <p>getGenericElementWidth.</p>
     *
     * @param genericElement a {@link net.sf.dynamicreports.report.definition.component.DRIGenericElement} object.
     * @return a {@link java.lang.Integer} object.
     */
    protected Integer getGenericElementWidth(final DRIGenericElement genericElement) {
        if (genericElement.getWidth() != null) {
            return genericElement.getWidth();
        }
        return Defaults.getDefaults().getGenericElementWidth();
    }

    /**
     * <p>getGenericElementHeight.</p>
     *
     * @param genericElement a {@link net.sf.dynamicreports.report.definition.component.DRIGenericElement} object.
     * @return a {@link java.lang.Integer} object.
     */
    protected Integer getGenericElementHeight(final DRIGenericElement genericElement) {
        if (genericElement.getHeight() != null) {
            return genericElement.getHeight();
        }
        return Defaults.getDefaults().getGenericElementHeight();
    }

    // list

    /**
     * <p>getListWidth.</p>
     *
     * @param list a {@link net.sf.dynamicreports.report.definition.component.DRIList} object.
     * @return a {@link java.lang.Integer} object.
     */
    protected Integer getListWidth(final DRIList list) {
        if (list.getWidth() != null) {
            return list.getWidth();
        }
        return Defaults.getDefaults().getListWidth();
    }

    /**
     * <p>getListHeight.</p>
     *
     * @param list a {@link net.sf.dynamicreports.report.definition.component.DRIList} object.
     * @return a {@link java.lang.Integer} object.
     */
    protected Integer getListHeight(final DRIList list) {
        if (list.getHeight() != null) {
            return list.getHeight();
        }
        return Defaults.getDefaults().getListHeight();
    }

    /**
     * <p>getListGap.</p>
     *
     * @param list a {@link net.sf.dynamicreports.report.definition.component.DRIList} object.
     * @return a int.
     */
    protected int getListGap(final DRIList list) {
        if (list.getGap() != null) {
            return list.getGap();
        }
        if (template.getListgap() != null) {
            return template.getListgap();
        }
        return Defaults.getDefaults().getListgap();
    }

    // xy list

    /**
     * <p>getXyListWidth.</p>
     *
     * @param xyList a {@link net.sf.dynamicreports.report.definition.component.DRIXyList} object.
     * @return a {@link java.lang.Integer} object.
     */
    protected Integer getXyListWidth(final DRIXyList xyList) {
        if (xyList.getWidth() != null) {
            return xyList.getWidth();
        }
        return Defaults.getDefaults().getListWidth();
    }

    /**
     * <p>getXyListHeight.</p>
     *
     * @param xyList a {@link net.sf.dynamicreports.report.definition.component.DRIXyList} object.
     * @return a {@link java.lang.Integer} object.
     */
    protected Integer getXyListHeight(final DRIXyList xyList) {
        if (xyList.getHeight() != null) {
            return xyList.getHeight();
        }
        return Defaults.getDefaults().getListHeight();
    }

    // multi page list

    /**
     * <p>getMultiPageListWidth.</p>
     *
     * @param multiPageList a {@link net.sf.dynamicreports.report.definition.component.DRIMultiPageList} object.
     * @return a int.
     */
    protected int getMultiPageListWidth(final DRIMultiPageList multiPageList) {
        if (multiPageList.getWidth() != null) {
            return multiPageList.getWidth();
        }
        if (template.getMultiPageListWidth() != null) {
            return template.getMultiPageListWidth();
        }
        return Defaults.getDefaults().getMultiPageListWidth();
    }

    /**
     * <p>getMultiPageListHeight.</p>
     *
     * @param multiPageList a {@link net.sf.dynamicreports.report.definition.component.DRIMultiPageList} object.
     * @return a int.
     */
    protected int getMultiPageListHeight(final DRIMultiPageList multiPageList) {
        if (multiPageList.getHeight() != null) {
            return multiPageList.getHeight();
        }
        if (template.getMultiPageListHeight() != null) {
            return template.getMultiPageListHeight();
        }
        return Defaults.getDefaults().getMultiPageListHeight();
    }

    // chart

    /**
     * <p>getChartWidth.</p>
     *
     * @param chart a {@link net.sf.dynamicreports.report.definition.chart.DRIChart} object.
     * @return a int.
     */
    protected int getChartWidth(final DRIChart chart) {
        if (chart.getWidth() != null) {
            return chart.getWidth();
        }
        if (template.getChartWidth() != null) {
            return template.getChartWidth();
        }
        return Defaults.getDefaults().getChartWidth();
    }

    /**
     * <p>getChartHeight.</p>
     *
     * @param chart a {@link net.sf.dynamicreports.report.definition.chart.DRIChart} object.
     * @return a int.
     */
    protected int getChartHeight(final DRIChart chart) {
        if (chart.getHeight() != null) {
            return chart.getHeight();
        }
        if (template.getChartHeight() != null) {
            return template.getChartHeight();
        }
        return Defaults.getDefaults().getChartHeight();
    }

    /**
     * <p>getChartSeriesColors.</p>
     *
     * @param plot a {@link net.sf.dynamicreports.report.definition.chart.plot.DRIBasePlot} object.
     * @return a {@link java.util.List} object.
     */
    protected List<Color> getChartSeriesColors(final DRIBasePlot plot) {
        if (plot.getSeriesColors() != null && !plot.getSeriesColors().isEmpty()) {
            return plot.getSeriesColors();
        }
        if (template.getChartSeriesColors() != null && !template.getChartSeriesColors().isEmpty()) {
            return template.getChartSeriesColors();
        }
        return Defaults.getDefaults().getChartSeriesColors();
    }

    /**
     * <p>getChartValuePattern.</p>
     *
     * @param axisPlot a {@link net.sf.dynamicreports.report.definition.chart.plot.DRIAxisPlot} object.
     * @return a {@link java.lang.String} object.
     */
    protected String getChartValuePattern(final DRIAxisPlot axisPlot) {
        if (axisPlot.getValuePattern() != null) {
            return axisPlot.getValuePattern();
        }
        if (template.getChartValuePattern() != null) {
            return template.getChartValuePattern();
        }
        return Defaults.getDefaults().getChartValuePattern();
    }

    /**
     * <p>getChartValuePattern.</p>
     *
     * @param piePlot a {@link net.sf.dynamicreports.report.definition.chart.plot.DRIPiePlot} object.
     * @return a {@link java.lang.String} object.
     */
    protected String getChartValuePattern(final DRIPiePlot piePlot) {
        if (piePlot.getValuePattern() != null) {
            return piePlot.getValuePattern();
        }
        if (template.getChartValuePattern() != null) {
            return template.getChartValuePattern();
        }
        return Defaults.getDefaults().getChartValuePattern();
    }

    /**
     * <p>getChartPercentValuePattern.</p>
     *
     * @param axisPlot a {@link net.sf.dynamicreports.report.definition.chart.plot.DRIAxisPlot} object.
     * @return a {@link java.lang.String} object.
     */
    protected String getChartPercentValuePattern(final DRIAxisPlot axisPlot) {
        if (axisPlot.getPercentValuePattern() != null) {
            return axisPlot.getPercentValuePattern();
        }
        if (template.getChartPercentValuePattern() != null) {
            return template.getChartPercentValuePattern();
        }
        return Defaults.getDefaults().getChartPercentValuePattern();
    }

    /**
     * <p>getChartPercentValuePattern.</p>
     *
     * @param piePlot a {@link net.sf.dynamicreports.report.definition.chart.plot.DRIPiePlot} object.
     * @return a {@link java.lang.String} object.
     */
    protected String getChartPercentValuePattern(final DRIPiePlot piePlot) {
        if (piePlot.getPercentValuePattern() != null) {
            return piePlot.getPercentValuePattern();
        }
        if (template.getChartPercentValuePattern() != null) {
            return template.getChartPercentValuePattern();
        }
        return Defaults.getDefaults().getChartPercentValuePattern();
    }

    /**
     * <p>isChartCategoryDatasetUseSeriesAsCategory.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.report.definition.chart.dataset.DRICategoryDataset} object.
     * @return a boolean.
     */
    protected boolean isChartCategoryDatasetUseSeriesAsCategory(final DRICategoryDataset dataset) {
        if (dataset.getUseSeriesAsCategory() != null) {
            return dataset.getUseSeriesAsCategory();
        }
        return Defaults.getDefaults().isChartCategoryDatasetUseSeriesAsCategory();
    }

    /**
     * <p>getChartTimeSeriesDatasetTimePeriodType.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.report.definition.chart.dataset.DRITimeSeriesDataset} object.
     * @return a {@link net.sf.dynamicreports.report.constant.TimePeriod} object.
     */
    protected TimePeriod getChartTimeSeriesDatasetTimePeriodType(final DRITimeSeriesDataset dataset) {
        if (dataset.getTimePeriodType() != null) {
            return dataset.getTimePeriodType();
        }
        return Defaults.getDefaults().getChartTimeSeriesDatasetTimePeriodType();
    }

    /**
     * <p>getChartThermometerPlotValueLocation.</p>
     *
     * @param plot a {@link net.sf.dynamicreports.report.definition.chart.plot.DRIThermometerPlot} object.
     * @return a {@link net.sf.dynamicreports.report.constant.ValueLocation} object.
     */
    protected ValueLocation getChartThermometerPlotValueLocation(final DRIThermometerPlot plot) {
        if (plot.getValueLocation() != null) {
            return plot.getValueLocation();
        }
        return Defaults.getDefaults().getChartThermometerPlotValueLocation();
    }

    /**
     * <p>getChartTheme.</p>
     *
     * @param chart a {@link net.sf.dynamicreports.report.definition.chart.DRIChart} object.
     * @return a {@link java.lang.String} object.
     */
    protected String getChartTheme(final DRIChart chart) {
        if (chart.getTheme() != null) {
            return chart.getTheme();
        }
        if (template.getChartTheme() != null) {
            return template.getChartTheme();
        }
        return Defaults.getDefaults().getChartTheme();
    }

    // barcode

    /**
     * <p>getBarcodeWidth.</p>
     *
     * @param barcode a {@link net.sf.dynamicreports.report.definition.barcode.DRIBarcode} object.
     * @return a int.
     */
    protected int getBarcodeWidth(final DRIBarcode barcode) {
        if (barcode.getWidth() != null) {
            return barcode.getWidth();
        }
        if (template.getBarcodeWidth() != null) {
            return template.getBarcodeWidth();
        }
        return Defaults.getDefaults().getBarcodeWidth();
    }

    /**
     * <p>getBarcodeHeight.</p>
     *
     * @param barcode a {@link net.sf.dynamicreports.report.definition.barcode.DRIBarcode} object.
     * @return a int.
     */
    protected int getBarcodeHeight(final DRIBarcode barcode) {
        if (barcode.getHeight() != null) {
            return barcode.getHeight();
        }
        if (template.getBarcodeHeight() != null) {
            return template.getBarcodeHeight();
        }
        return Defaults.getDefaults().getBarcodeHeight();
    }

    // barbecue

    /**
     * <p>getBarbecueWidth.</p>
     *
     * @param barbecue a {@link net.sf.dynamicreports.report.definition.barcode.DRIBarbecue} object.
     * @return a int.
     */
    protected int getBarbecueWidth(final DRIBarbecue barbecue) {
        if (barbecue.getWidth() != null) {
            return barbecue.getWidth();
        }
        if (template.getBarcodeWidth() != null) {
            return template.getBarcodeWidth();
        }
        return Defaults.getDefaults().getBarcodeWidth();
    }

    /**
     * <p>getBarbecueHeight.</p>
     *
     * @param barbecue a {@link net.sf.dynamicreports.report.definition.barcode.DRIBarbecue} object.
     * @return a int.
     */
    protected int getBarbecueHeight(final DRIBarbecue barbecue) {
        if (barbecue.getHeight() != null) {
            return barbecue.getHeight();
        }
        if (template.getBarcodeHeight() != null) {
            return template.getBarcodeHeight();
        }
        return Defaults.getDefaults().getBarcodeHeight();
    }

    // subreport

    /**
     * <p>getSubreportWidth.</p>
     *
     * @param subreport a {@link net.sf.dynamicreports.report.definition.component.DRISubreport} object.
     * @return a int.
     */
    protected int getSubreportWidth(final DRISubreport subreport) {
        if (subreport.getWidth() != null) {
            return subreport.getWidth();
        }
        if (template.getSubreportWidth() != null) {
            return template.getSubreportWidth();
        }
        return Defaults.getDefaults().getSubreportWidth();
    }

    /**
     * <p>getSubreportHeight.</p>
     *
     * @param subreport a {@link net.sf.dynamicreports.report.definition.component.DRISubreport} object.
     * @return a int.
     */
    protected int getSubreportHeight(final DRISubreport subreport) {
        if (subreport.getHeight() != null) {
            return subreport.getHeight();
        }
        if (template.getSubreportHeight() != null) {
            return template.getSubreportHeight();
        }
        return Defaults.getDefaults().getSubreportHeight();
    }

    // crosstab

    /**
     * <p>getCrosstabWidth.</p>
     *
     * @param crosstab a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @return a int.
     */
    protected int getCrosstabWidth(final DRICrosstab crosstab) {
        if (crosstab.getWidth() != null) {
            return crosstab.getWidth();
        }
        if (template.getCrosstabWidth() != null) {
            return template.getCrosstabWidth();
        }
        return Defaults.getDefaults().getCrosstabWidth();
    }

    /**
     * <p>getCrosstabHeight.</p>
     *
     * @param crosstab       a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @param whenNoDataCell a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCellContent} object.
     * @return a int.
     */
    protected int getCrosstabHeight(final DRICrosstab crosstab, final DRDesignCrosstabCellContent whenNoDataCell) {
        int height;
        if (crosstab.getHeight() != null) {
            height = crosstab.getHeight();
        } else if (template.getCrosstabHeight() != null) {
            height = template.getCrosstabHeight();
        } else {
            height = Defaults.getDefaults().getCrosstabHeight();
        }
        final int whenNoDataCellHeight = getCrosstabWhenNoDataCellHeight(whenNoDataCell);
        if (height == 0 && whenNoDataCellHeight > 0) {
            return whenNoDataCellHeight;
        }
        return height;
    }

    /**
     * <p>getCrosstabColumnGroupTotalPosition.</p>
     *
     * @param columnGroup a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabColumnGroup} object.
     * @return a {@link net.sf.dynamicreports.report.constant.CrosstabTotalPosition} object.
     */
    public CrosstabTotalPosition getCrosstabColumnGroupTotalPosition(final DRICrosstabColumnGroup<?> columnGroup) {
        if (!isCrosstabColumnGroupShowTotal(columnGroup)) {
            return null;
        }
        if (columnGroup.getTotalPosition() != null) {
            return columnGroup.getTotalPosition();
        }
        return Defaults.getDefaults().getCrosstabColumnGroupTotalPosition();
    }

    /**
     * <p>getCrosstabRowGroupTotalPosition.</p>
     *
     * @param rowGroup a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabRowGroup} object.
     * @return a {@link net.sf.dynamicreports.report.constant.CrosstabTotalPosition} object.
     */
    public CrosstabTotalPosition getCrosstabRowGroupTotalPosition(final DRICrosstabRowGroup<?> rowGroup) {
        if (!isCrosstabRowGroupShowTotal(rowGroup)) {
            return null;
        }
        if (rowGroup.getTotalPosition() != null) {
            return rowGroup.getTotalPosition();
        }
        return Defaults.getDefaults().getCrosstabRowGroupTotalPosition();
    }

    /**
     * <p>isCrosstabColumnGroupShowTotal.</p>
     *
     * @param columnGroup a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabColumnGroup} object.
     * @return a boolean.
     */
    public boolean isCrosstabColumnGroupShowTotal(final DRICrosstabColumnGroup<?> columnGroup) {
        if (columnGroup.getShowTotal() != null) {
            return columnGroup.getShowTotal();
        }
        return Defaults.getDefaults().isCrosstabColumnGroupShowTotal();
    }

    /**
     * <p>isCrosstabRowGroupShowTotal.</p>
     *
     * @param rowGroup a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabRowGroup} object.
     * @return a boolean.
     */
    public boolean isCrosstabRowGroupShowTotal(final DRICrosstabRowGroup<?> rowGroup) {
        if (rowGroup.getShowTotal() != null) {
            return rowGroup.getShowTotal();
        }
        return Defaults.getDefaults().isCrosstabRowGroupShowTotal();
    }

    /**
     * <p>getCrosstabColumnGroupHeaderHeight.</p>
     *
     * @param columnGroup     a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabColumnGroup} object.
     * @param designCrosstab  a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab} object.
     * @param availableHeight a int.
     * @return a int.
     */
    public int getCrosstabColumnGroupHeaderHeight(final DRICrosstabColumnGroup<?> columnGroup, final DRDesignCrosstab designCrosstab, final int availableHeight) {
        if (columnGroup.getHeaderHeight() != null) {
            return columnGroup.getHeaderHeight();
        }
        int maxHeight = 0;
        for (final DRDesignCrosstabColumnGroup designColumnGroup : designCrosstab.getColumnGroups()) {
            if (designColumnGroup.getName().equals(columnGroup.getName())) {
                int height = detectHeight(designColumnGroup.getHeader().getList());
                if (maxHeight < height) {
                    maxHeight = height;
                }
                if (designColumnGroup.getTotalHeader() != null) {
                    height = detectHeight(designColumnGroup.getTotalHeader().getList());
                    if (maxHeight < height && height > availableHeight) {
                        maxHeight = height;
                    }
                }
                break;
            }
        }
        return maxHeight;
    }

    /**
     * <p>getCrosstabColumnGroupTotalHeaderWidth.</p>
     *
     * @param columnGroup    a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabColumnGroup} object.
     * @param cellWidth      a {@link java.lang.Integer} object.
     * @param designCrosstab a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab} object.
     * @return a int.
     */
    public int getCrosstabColumnGroupTotalHeaderWidth(final DRICrosstabColumnGroup<?> columnGroup, final Integer cellWidth, final DRDesignCrosstab designCrosstab) {
        if (columnGroup.getTotalHeaderWidth() != null) {
            return columnGroup.getTotalHeaderWidth();
        }
        if (cellWidth != null) {
            return cellWidth;
        }
        int maxWidth = 0;
        for (final DRDesignCrosstabColumnGroup designColumnGroup : designCrosstab.getColumnGroups()) {
            if (designColumnGroup.getName().equals(columnGroup.getName())) {
                if (designColumnGroup.getTotalHeader() != null) {
                    final int height = detectWidth(designColumnGroup.getTotalHeader().getList());
                    if (maxWidth < height) {
                        maxWidth = height;
                    }
                }
                break;
            }
        }
        for (final DRDesignCrosstabCell designCell : designCrosstab.getCells()) {
            if (designCell.getColumnTotalGroup() == columnGroup.getName()) {
                final int height = detectWidth(designCell.getContent().getList());
                if (maxWidth < height) {
                    maxWidth = height;
                }
            }
        }
        if (maxWidth > Defaults.getDefaults().getCrosstabColumnGroupTotalHeaderMaxWidth()) {
            return Defaults.getDefaults().getCrosstabColumnGroupTotalHeaderMaxWidth();
        }
        return maxWidth;
    }

    /**
     * <p>getCrosstabRowGroupHeaderWidth.</p>
     *
     * @param rowGroup       a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabRowGroup} object.
     * @param designCrosstab a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab} object.
     * @return a int.
     */
    public int getCrosstabRowGroupHeaderWidth(final DRICrosstabRowGroup<?> rowGroup, final DRDesignCrosstab designCrosstab) {
        if (rowGroup.getHeaderWidth() != null) {
            return rowGroup.getHeaderWidth();
        }
        int maxWidth = 0;
        for (final DRDesignCrosstabRowGroup designRowGroup : designCrosstab.getRowGroups()) {
            if (designRowGroup.getName().equals(rowGroup.getName())) {
                int width = detectWidth(designRowGroup.getHeader().getList());
                if (maxWidth < width) {
                    maxWidth = width;
                }
                if (designRowGroup.getTotalHeader() != null) {
                    width = detectWidth(designRowGroup.getTotalHeader().getList());
                    if (maxWidth < width) {
                        maxWidth = width;
                    }
                }
                break;
            }
        }
        if (maxWidth > Defaults.getDefaults().getCrosstabRowGroupHeaderMaxWidth()) {
            return Defaults.getDefaults().getCrosstabRowGroupHeaderMaxWidth();
        }
        return maxWidth;
    }

    /**
     * <p>getCrosstabRowGroupTotalHeaderHeight.</p>
     *
     * @param rowGroup       a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabRowGroup} object.
     * @param cellHeight     a {@link java.lang.Integer} object.
     * @param designCrosstab a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab} object.
     * @return a int.
     */
    public int getCrosstabRowGroupTotalHeaderHeight(final DRICrosstabRowGroup<?> rowGroup, final Integer cellHeight, final DRDesignCrosstab designCrosstab) {
        if (rowGroup.getTotalHeaderHeight() != null) {
            return rowGroup.getTotalHeaderHeight();
        }
        if (cellHeight != null) {
            return cellHeight;
        }
        int maxHeight = 0;
        for (final DRDesignCrosstabRowGroup designRowGroup : designCrosstab.getRowGroups()) {
            if (designRowGroup.getName().equals(rowGroup.getName())) {
                if (designRowGroup.getTotalHeader() != null) {
                    final int height = detectHeight(designRowGroup.getTotalHeader().getList());
                    if (maxHeight < height) {
                        maxHeight = height;
                    }
                }
                break;
            }
        }
        for (final DRDesignCrosstabCell designCell : designCrosstab.getCells()) {
            if (designCell.getRowTotalGroup() == rowGroup.getName()) {
                final int height = detectHeight(designCell.getContent().getList());
                if (maxHeight < height) {
                    maxHeight = height;
                }
            }
        }
        return maxHeight;
    }

    /**
     * <p>getCrosstabCellWidth.</p>
     *
     * @param crosstab       a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @param designCrosstab a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab} object.
     * @return a int.
     */
    public int getCrosstabCellWidth(final DRICrosstab crosstab, final DRDesignCrosstab designCrosstab) {
        if (crosstab.getCellWidth() != null) {
            return crosstab.getCellWidth();
        }
        int maxWidth = 0;
        for (final DRDesignCrosstabCell designCell : designCrosstab.getCells()) {
            if (designCell.getColumnTotalGroup() == null) {
                final int width = detectWidth(designCell.getContent().getList());
                if (maxWidth < width) {
                    maxWidth = width;
                }
            }
        }
        for (final DRDesignCrosstabColumnGroup designColumnGroup : designCrosstab.getColumnGroups()) {
            final int width = detectWidth(designColumnGroup.getHeader().getList());
            if (maxWidth < width) {
                maxWidth = width;
            }
        }
        if (maxWidth > Defaults.getDefaults().getCrosstabCellMaxWidth()) {
            return Defaults.getDefaults().getCrosstabCellMaxWidth();
        }
        return maxWidth;
    }

    /**
     * <p>getCrosstabCellHeight.</p>
     *
     * @param crosstab       a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @param designCrosstab a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab} object.
     * @return a int.
     */
    public int getCrosstabCellHeight(final DRICrosstab crosstab, final DRDesignCrosstab designCrosstab) {
        if (crosstab.getCellHeight() != null) {
            return crosstab.getCellHeight();
        }
        int maxHeight = 0;
        for (final DRDesignCrosstabCell designCell : designCrosstab.getCells()) {
            if (designCell.getRowTotalGroup() == null) {
                final int height = detectHeight(designCell.getContent().getList());
                if (maxHeight < height) {
                    maxHeight = height;
                }
            }
        }
        for (final DRDesignCrosstabRowGroup designRowGroup : designCrosstab.getRowGroups()) {
            final int height = detectHeight(designRowGroup.getHeader().getList());
            if (maxHeight < height) {
                maxHeight = height;
            }
        }
        return maxHeight;
    }

    /**
     * <p>getCrosstabWhenNoDataCellHeight.</p>
     *
     * @param whenNoDataCell a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCellContent} object.
     * @return a int.
     */
    public int getCrosstabWhenNoDataCellHeight(final DRDesignCrosstabCellContent whenNoDataCell) {
        return detectHeight(whenNoDataCell.getList());
    }

    /**
     * <p>getCrosstabOddRowStyle.</p>
     *
     * @param crosstab a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRISimpleStyle} object.
     */
    protected DRISimpleStyle getCrosstabOddRowStyle(final DRICrosstab crosstab) {
        if (isCrosstabHighlightOddRows(crosstab)) {
            if (crosstab.getOddRowStyle() != null) {
                return crosstab.getOddRowStyle();
            }
            if (template.getCrosstabOddRowStyle() != null) {
                return template.getCrosstabOddRowStyle();
            }
            return Defaults.getDefaults().getCrosstabOddRowStyle();
        }
        return null;
    }

    /**
     * <p>getCrosstabEvenRowStyle.</p>
     *
     * @param crosstab a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRISimpleStyle} object.
     */
    protected DRISimpleStyle getCrosstabEvenRowStyle(final DRICrosstab crosstab) {
        if (isCrosstabHighlightEvenRows(crosstab)) {
            if (crosstab.getEvenRowStyle() != null) {
                return crosstab.getEvenRowStyle();
            }
            if (template.getCrosstabEvenRowStyle() != null) {
                return template.getCrosstabEvenRowStyle();
            }
            return Defaults.getDefaults().getCrosstabEvenRowStyle();
        }
        return null;
    }

    private boolean isCrosstabHighlightOddRows(final DRICrosstab crosstab) {
        if (crosstab.getHighlightOddRows() != null) {
            return crosstab.getHighlightOddRows();
        }
        if (template.getCrosstabHighlightOddRows() != null) {
            return template.getCrosstabHighlightOddRows();
        }
        return Defaults.getDefaults().isCrosstabHighlightOddRows();
    }

    private boolean isCrosstabHighlightEvenRows(final DRICrosstab crosstab) {
        if (crosstab.getHighlightEvenRows() != null) {
            return crosstab.getHighlightEvenRows();
        }
        if (template.getCrosstabHighlightEvenRows() != null) {
            return template.getCrosstabHighlightEvenRows();
        }
        return Defaults.getDefaults().isCrosstabHighlightEvenRows();
    }

    /**
     * <p>getCrosstabGroupStyle.</p>
     *
     * @param crosstab a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getCrosstabGroupStyle(final DRICrosstab crosstab) {
        if (crosstab.getGroupStyle() != null) {
            return crosstab.getGroupStyle();
        }
        if (template.getCrosstabGroupStyle() != null) {
            return template.getCrosstabGroupStyle();
        }
        if (Defaults.getDefaults().getCrosstabGroupStyle() != null) {
            return Defaults.getDefaults().getCrosstabGroupStyle();
        }
        return getTextStyle();
    }

    /**
     * <p>getCrosstabGroupTotalStyle.</p>
     *
     * @param crosstab a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getCrosstabGroupTotalStyle(final DRICrosstab crosstab) {
        if (crosstab.getGroupTotalStyle() != null) {
            return crosstab.getGroupTotalStyle();
        }
        if (template.getCrosstabGroupTotalStyle() != null) {
            return template.getCrosstabGroupTotalStyle();
        }
        if (Defaults.getDefaults().getCrosstabGroupTotalStyle() != null) {
            return Defaults.getDefaults().getCrosstabGroupTotalStyle();
        }
        return getTextStyle();
    }

    /**
     * <p>getCrosstabGrandTotalStyle.</p>
     *
     * @param crosstab a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getCrosstabGrandTotalStyle(final DRICrosstab crosstab) {
        if (crosstab.getGrandTotalStyle() != null) {
            return crosstab.getGrandTotalStyle();
        }
        if (template.getCrosstabGrandTotalStyle() != null) {
            return template.getCrosstabGrandTotalStyle();
        }
        if (Defaults.getDefaults().getCrosstabGrandTotalStyle() != null) {
            return Defaults.getDefaults().getCrosstabGrandTotalStyle();
        }
        return getTextStyle();
    }

    /**
     * <p>getCrosstabCellStyle.</p>
     *
     * @param crosstab a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getCrosstabCellStyle(final DRICrosstab crosstab) {
        if (crosstab.getCellStyle() != null) {
            return crosstab.getCellStyle();
        }
        if (template.getCrosstabCellStyle() != null) {
            return template.getCrosstabCellStyle();
        }
        if (Defaults.getDefaults().getCrosstabCellStyle() != null) {
            return Defaults.getDefaults().getCrosstabCellStyle();
        }
        return getTextStyle();
    }

    /**
     * <p>getCrosstabMeasureTitleStyle.</p>
     *
     * @param crosstab a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstab} object.
     * @param measure  a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabMeasure} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public DRIReportStyle getCrosstabMeasureTitleStyle(final DRICrosstab crosstab, final DRICrosstabMeasure<?> measure) {
        if (measure.getTitleStyle() != null) {
            return measure.getTitleStyle();
        }
        if (crosstab.getMeasureTitleStyle() != null) {
            return crosstab.getMeasureTitleStyle();
        }
        if (template.getCrosstabMeasureTitleStyle() != null) {
            return template.getCrosstabMeasureTitleStyle();
        }
        return Defaults.getDefaults().getCrosstabMeasureTitleStyle();
    }

    /**
     * <p>getCrosstabPercentageType.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabVariable} object.
     * @return a {@link net.sf.dynamicreports.report.constant.CrosstabPercentageType} object.
     */
    protected CrosstabPercentageType getCrosstabPercentageType(final DRICrosstabVariable<?> variable) {
        if (variable.getPercentageType() != null) {
            return variable.getPercentageType();
        }
        return Defaults.getDefaults().getCrosstabPercentageType();
    }

    /**
     * <p>getBooleanComponentType.</p>
     *
     * @param booleanField a {@link net.sf.dynamicreports.report.definition.component.DRIBooleanField} object.
     * @return a {@link net.sf.dynamicreports.report.constant.BooleanComponentType} object.
     */
    public BooleanComponentType getBooleanComponentType(final DRIBooleanField booleanField) {
        if (booleanField.getComponentType() != null) {
            return booleanField.getComponentType();
        }
        if (template.getBooleanComponentType() != null) {
            return template.getBooleanComponentType();
        }
        return Defaults.getDefaults().getBooleanComponentType();
    }

    /**
     * <p>getBooleanEmptyWhenNullValue.</p>
     *
     * @param booleanField a {@link net.sf.dynamicreports.report.definition.component.DRIBooleanField} object.
     * @return a boolean.
     */
    public boolean getBooleanEmptyWhenNullValue(final DRIBooleanField booleanField) {
        if (booleanField.getEmptyWhenNullValue() != null) {
            return booleanField.getEmptyWhenNullValue();
        }
        if (template.getBooleanEmptyWhenNullValue() != null) {
            return template.getBooleanEmptyWhenNullValue();
        }
        return Defaults.getDefaults().isBooleanEmptyWhenNullValue();
    }

    /**
     * <p>getBooleanImageWidth.</p>
     *
     * @param booleanField a {@link net.sf.dynamicreports.report.definition.component.DRIBooleanField} object.
     * @return a int.
     */
    public int getBooleanImageWidth(final DRIBooleanField booleanField) {
        if (booleanField.getImageWidth() != null) {
            return booleanField.getImageWidth();
        }
        if (template.getBooleanImageWidth() != null) {
            return template.getBooleanImageWidth();
        }
        return Defaults.getDefaults().getBooleanImageWidth();
    }

    /**
     * <p>getBooleanImageHeight.</p>
     *
     * @param booleanField a {@link net.sf.dynamicreports.report.definition.component.DRIBooleanField} object.
     * @return a int.
     */
    public int getBooleanImageHeight(final DRIBooleanField booleanField) {
        if (booleanField.getImageHeight() != null) {
            return booleanField.getImageHeight();
        }
        if (template.getBooleanImageHeight() != null) {
            return template.getBooleanImageHeight();
        }
        return Defaults.getDefaults().getBooleanImageHeight();
    }

    /**
     * <p>getBooleanHorizontalImageAlignment.</p>
     *
     * @param booleanField a {@link net.sf.dynamicreports.report.definition.component.DRIBooleanField} object.
     * @param style        a {@link net.sf.dynamicreports.design.base.style.DRDesignStyle} object.
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalImageAlignment} object.
     */
    protected HorizontalImageAlignment getBooleanHorizontalImageAlignment(final DRIBooleanField booleanField, final DRDesignStyle style) {
        if (booleanField.getHorizontalImageAlignment() != null) {
            return booleanField.getHorizontalImageAlignment();
        }
        if (StyleResolver.getHorizontalImageAlignment(style) != null) {
            return null;// StyleResolver.getHorizontalAlignment(style);
        }
        return Defaults.getDefaults().getBooleanHorizontalImageAlignment();
    }

    /**
     * <p>getBooleanColumnStyle.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.definition.column.DRIBooleanColumn} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public DRIReportStyle getBooleanColumnStyle(final DRIBooleanColumn column) {
        if (column.getComponent().getStyle() != null) {
            return column.getComponent().getStyle();
        }
        if (template.getBooleanColumnStyle() != null) {
            return template.getBooleanColumnStyle();
        }
        return Defaults.getDefaults().getBooleanColumnStyle();
    }

    /**
     * <p>getTemplateStyles.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, DRIStyle> getTemplateStyles() {
        final Map<String, DRIStyle> templateStyles = new HashMap<>();
        for (final DRIStyle style : template.getTemplateStyles()) {
            templateStyles.put(style.getName(), style);
        }
        for (final DRIStyle style : report.getTemplateStyles()) {
            templateStyles.put(style.getName(), style);
        }
        return templateStyles;
    }

    // split

    /**
     * <p>getTitleSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getTitleSplitType(final DRIBand band) {
        return getSplitType(band, template.getTitleSplitType(), Defaults.getDefaults().getTitleSplitType());
    }

    /**
     * <p>getPageHeaderSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getPageHeaderSplitType(final DRIBand band) {
        return getSplitType(band, template.getPageHeaderSplitType(), Defaults.getDefaults().getPageHeaderSplitType());
    }

    /**
     * <p>getPageFooterSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getPageFooterSplitType(final DRIBand band) {
        return getSplitType(band, template.getPageFooterSplitType(), Defaults.getDefaults().getPageFooterSplitType());
    }

    /**
     * <p>getColumnHeaderSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getColumnHeaderSplitType(final DRIBand band) {
        return getSplitType(band, template.getColumnHeaderSplitType(), Defaults.getDefaults().getColumnHeaderSplitType());
    }

    /**
     * <p>getColumnFooterSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getColumnFooterSplitType(final DRIBand band) {
        return getSplitType(band, template.getColumnFooterSplitType(), Defaults.getDefaults().getColumnFooterSplitType());
    }

    /**
     * <p>getGroupHeaderSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getGroupHeaderSplitType(final DRIBand band) {
        return getSplitType(band, template.getGroupHeaderSplitType(), Defaults.getDefaults().getGroupHeaderSplitType());
    }

    /**
     * <p>getGroupFooterSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getGroupFooterSplitType(final DRIBand band) {
        return getSplitType(band, template.getGroupFooterSplitType(), Defaults.getDefaults().getGroupFooterSplitType());
    }

    /**
     * <p>getDetailHeaderSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getDetailHeaderSplitType(final DRIBand band) {
        return getSplitType(band, template.getDetailHeaderSplitType(), Defaults.getDefaults().getDetailHeaderSplitType());
    }

    /**
     * <p>getDetailSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getDetailSplitType(final DRIBand band) {
        return getSplitType(band, template.getDetailSplitType(), Defaults.getDefaults().getDetailSplitType());
    }

    /**
     * <p>getDetailFooterSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getDetailFooterSplitType(final DRIBand band) {
        return getSplitType(band, template.getDetailFooterSplitType(), Defaults.getDefaults().getDetailFooterSplitType());
    }

    /**
     * <p>getLastPageFooterSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getLastPageFooterSplitType(final DRIBand band) {
        return getSplitType(band, template.getLastPageFooterSplitType(), Defaults.getDefaults().getLastPageFooterSplitType());
    }

    /**
     * <p>getSummarySplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getSummarySplitType(final DRIBand band) {
        return getSplitType(band, template.getSummarySplitType(), Defaults.getDefaults().getSummarySplitType());
    }

    /**
     * <p>getNoDataSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getNoDataSplitType(final DRIBand band) {
        return getSplitType(band, template.getNoDataSplitType(), Defaults.getDefaults().getNoDataSplitType());
    }

    /**
     * <p>getBackgroundSplitType.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     */
    protected SplitType getBackgroundSplitType(final DRIBand band) {
        return getSplitType(band, template.getBackgroundSplitType(), Defaults.getDefaults().getBackgroundSplitType());
    }

    private SplitType getSplitType(final DRIBand band, final SplitType templateSplitType, final SplitType splitType) {
        if (band.getSplitType() != null) {
            return band.getSplitType();
        }
        if (templateSplitType != null) {
            return templateSplitType;
        }
        if (splitType != null) {
            return splitType;
        }
        if (template.getDefaultSplitType() != null) {
            return template.getDefaultSplitType();
        }
        return Defaults.getDefaults().getDefaultSplitType();
    }

    // band style

    /**
     * <p>getTitleStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getTitleStyle(final DRIBand band) {
        return getBandStyle(band, template.getTitleStyle());
    }

    /**
     * <p>getPageHeaderStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getPageHeaderStyle(final DRIBand band) {
        return getBandStyle(band, template.getPageHeaderStyle());
    }

    /**
     * <p>getPageFooterStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getPageFooterStyle(final DRIBand band) {
        return getBandStyle(band, template.getPageFooterStyle());
    }

    /**
     * <p>getColumnHeaderStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getColumnHeaderStyle(final DRIBand band) {
        return getBandStyle(band, template.getColumnHeaderStyle());
    }

    /**
     * <p>getColumnFooterStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getColumnFooterStyle(final DRIBand band) {
        return getBandStyle(band, template.getColumnFooterStyle());
    }

    /**
     * <p>getGroupHeaderStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getGroupHeaderStyle(final DRIBand band) {
        return getBandStyle(band, template.getGroupHeaderStyle());
    }

    /**
     * <p>getGroupFooterStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getGroupFooterStyle(final DRIBand band) {
        return getBandStyle(band, template.getGroupFooterStyle());
    }

    /**
     * <p>getDetailHeaderStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getDetailHeaderStyle(final DRIBand band) {
        return getBandStyle(band, template.getDetailHeaderStyle());
    }

    /**
     * <p>getDetailStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getDetailStyle(final DRIBand band) {
        return getBandStyle(band, template.getDetailStyle());
    }

    /**
     * <p>getDetailFooterStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getDetailFooterStyle(final DRIBand band) {
        return getBandStyle(band, template.getDetailFooterStyle());
    }

    /**
     * <p>getLastPageFooterStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getLastPageFooterStyle(final DRIBand band) {
        return getBandStyle(band, template.getLastPageFooterStyle());
    }

    /**
     * <p>getSummaryStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getSummaryStyle(final DRIBand band) {
        return getBandStyle(band, template.getSummaryStyle());
    }

    /**
     * <p>getNoDataStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getNoDataStyle(final DRIBand band) {
        return getBandStyle(band, template.getNoDataStyle());
    }

    /**
     * <p>getBackgroundStyle.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    protected DRIReportStyle getBackgroundStyle(final DRIBand band) {
        return getBandStyle(band, template.getBackgroundStyle());
    }

    private DRIReportStyle getBandStyle(final DRIBand band, final DRIReportStyle templateStyle) {
        if (band.getList().getStyle() != null) {
            return band.getList().getStyle();
        }
        if (templateStyle != null) {
            return templateStyle;
        }
        return Defaults.getDefaults().getBandStyle();
    }

    // band background component

    /**
     * <p>getTitleBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getTitleBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getTitleBackgroundComponent());
    }

    /**
     * <p>getPageHeaderBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getPageHeaderBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getPageHeaderBackgroundComponent());
    }

    /**
     * <p>getPageFooterBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getPageFooterBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getPageFooterBackgroundComponent());
    }

    /**
     * <p>getColumnHeaderBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getColumnHeaderBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getColumnHeaderBackgroundComponent());
    }

    /**
     * <p>getColumnFooterBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getColumnFooterBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getColumnFooterBackgroundComponent());
    }

    /**
     * <p>getGroupHeaderBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getGroupHeaderBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getGroupHeaderBackgroundComponent());
    }

    /**
     * <p>getGroupFooterBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getGroupFooterBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getGroupFooterBackgroundComponent());
    }

    /**
     * <p>getDetailHeaderBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getDetailHeaderBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getDetailHeaderBackgroundComponent());
    }

    /**
     * <p>getDetailBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getDetailBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getDetailBackgroundComponent());
    }

    /**
     * <p>getDetailFooterBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getDetailFooterBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getDetailFooterBackgroundComponent());
    }

    /**
     * <p>getLastPageFooterBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getLastPageFooterBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getLastPageFooterBackgroundComponent());
    }

    /**
     * <p>getSummaryBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getSummaryBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getSummaryBackgroundComponent());
    }

    /**
     * <p>getNoDataBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getNoDataBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getNoDataBackgroundComponent());
    }

    /**
     * <p>getBackgroundBackgroundComponent.</p>
     *
     * @param band a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    protected DRIComponent getBackgroundBackgroundComponent(final DRIBand band) {
        return getBandBackgroundComponent(band, template.getBackgroundBackgroundComponent());
    }

    private DRIComponent getBandBackgroundComponent(final DRIBand band, final DRIComponent templateBackgroundComponent) {
        if (band.getList().getBackgroundComponent() != null) {
            return band.getList().getBackgroundComponent();
        }
        if (templateBackgroundComponent != null) {
            return templateBackgroundComponent;
        }
        return Defaults.getDefaults().getBandBackgroundComponent();
    }

    private int detectWidth(final DRDesignList designList) {
        ComponentPosition.width(designList);
        return designList.getWidth();
    }

    private int detectHeight(final DRDesignList designList) {
        ComponentPosition.height(designList);
        return designList.getHeight();
    }

}

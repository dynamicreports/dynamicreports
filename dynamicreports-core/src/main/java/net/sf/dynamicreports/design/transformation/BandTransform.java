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
package net.sf.dynamicreports.design.transformation;

import net.sf.dynamicreports.design.base.DRDesignBand;
import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.component.DRDesignFiller;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.constant.DefaultStyleType;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.DRIDesignPage;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.definition.DRIBand;
import net.sf.dynamicreports.report.definition.DRIGroup;
import net.sf.dynamicreports.report.definition.DRIReport;
import net.sf.dynamicreports.report.definition.DRITemplateDesign;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>BandTransform class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class BandTransform {
    private DesignTransformAccessor accessor;

    private DRDesignBand titleBand;
    private DRDesignBand pageHeaderBand;
    private DRDesignBand pageFooterBand;
    private DRDesignBand columnHeaderBand;
    private DRDesignBand columnHeaderForGroupBand;
    private DRDesignBand columnFooterBand;
    private List<DRDesignBand> detailBands;
    private DRDesignBand detailBand;
    private DRDesignBand lastPageFooterBand;
    private DRDesignBand summaryBand;
    private DRDesignBand noDataBand;
    private DRDesignBand backgroundBand;

    /**
     * <p>Constructor for BandTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
     */
    public BandTransform(DesignTransformAccessor accessor) {
        this.accessor = accessor;
        this.detailBands = new ArrayList<DRDesignBand>();
    }

    /**
     * <p>transform.</p>
     *
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public void transform() throws DRException {
        TemplateTransform templateTransform = accessor.getTemplateTransform();

        DRIReport report = accessor.getReport();

        DRIBand band = report.getTitleBand();
        titleBand = band("title", band, templateTransform.getTitleSplitType(band), templateTransform.getTitleStyle(band), templateTransform.getTitleBackgroundComponent(band), ResetType.REPORT, null);

        band = report.getPageHeaderBand();
        pageHeaderBand = band("pageHeader", band, templateTransform.getPageHeaderSplitType(band), templateTransform.getPageHeaderStyle(band), templateTransform.getPageHeaderBackgroundComponent(band),
                              ResetType.PAGE, null);

        band = report.getPageFooterBand();
        pageFooterBand = band("pageFooter", band, templateTransform.getPageFooterSplitType(band), templateTransform.getPageFooterStyle(band), templateTransform.getPageFooterBackgroundComponent(band),
                              ResetType.PAGE, null);

        band = report.getColumnHeaderBand();
        columnHeaderBand =
            band("columnHeader", band, templateTransform.getColumnHeaderSplitType(band), templateTransform.getColumnHeaderStyle(band), templateTransform.getColumnHeaderBackgroundComponent(band),
                 ResetType.COLUMN, null);

        for (DRIGroup group : report.getGroups()) {
            if (templateTransform.isGroupShowColumnHeaderAndFooter(group)) {
                band = report.getColumnHeaderBand();
                columnHeaderForGroupBand = band("columnHeaderForGroup", band, templateTransform.getColumnHeaderSplitType(band), templateTransform.getColumnHeaderStyle(band),
                                                templateTransform.getColumnHeaderBackgroundComponent(band), ResetType.COLUMN, null);
                break;
            }
        }

        band = report.getColumnFooterBand();
        columnFooterBand =
            band("columnFooter", band, templateTransform.getColumnFooterSplitType(band), templateTransform.getColumnFooterStyle(band), templateTransform.getColumnFooterBackgroundComponent(band),
                 ResetType.COLUMN, null);

        band = report.getDetailHeaderBand();
        detailBands.add(
            band("detailHeader", band, templateTransform.getDetailHeaderSplitType(band), templateTransform.getDetailHeaderStyle(band), templateTransform.getDetailHeaderBackgroundComponent(band),
                 ResetType.REPORT, null));

        band = report.getDetailBand();
        detailBand =
            band("detail", band, templateTransform.getDetailSplitType(band), templateTransform.getDetailStyle(band), templateTransform.getDetailBackgroundComponent(band), ResetType.REPORT, null);
        detailBands.add(detailBand);

        band = report.getDetailFooterBand();
        detailBands.add(
            band("detailFooter", band, templateTransform.getDetailFooterSplitType(band), templateTransform.getDetailFooterStyle(band), templateTransform.getDetailFooterBackgroundComponent(band),
                 ResetType.REPORT, null));

        band = report.getLastPageFooterBand();
        lastPageFooterBand = band("lastPageFooter", band, templateTransform.getLastPageFooterSplitType(band), templateTransform.getLastPageFooterStyle(band),
                                  templateTransform.getLastPageFooterBackgroundComponent(band), ResetType.PAGE, null);

        band = report.getSummaryBand();
        summaryBand =
            band("summary", band, templateTransform.getSummarySplitType(band), templateTransform.getSummaryStyle(band), templateTransform.getSummaryBackgroundComponent(band), ResetType.NONE, null);

        band = report.getNoDataBand();
        noDataBand =
            band("noData", band, templateTransform.getNoDataSplitType(band), templateTransform.getNoDataStyle(band), templateTransform.getNoDataBackgroundComponent(band), ResetType.NONE, null);

        band = report.getBackgroundBand();
        backgroundBand = band("background", band, templateTransform.getBackgroundSplitType(band), templateTransform.getBackgroundStyle(band), templateTransform.getBackgroundBackgroundComponent(band),
                              ResetType.NONE, null);
    }

    /**
     * <p>prepareBands.</p>
     *
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public void prepareBands() throws DRException {
        BandComponentsTransform bandComponents = new BandComponentsTransform(accessor);
        DRITemplateDesign<?> templateDesign = accessor.getReport().getTemplateDesign();
        int maxWidth = accessor.getPageTransform().getMaxBandWidth();
        int maxColumnWidth = accessor.getPageTransform().getPage().getColumnWidth();

        titleBand = bandComponents.prepareBand(titleBand, maxWidth, templateDesign.getTitleComponentsCount());
        pageHeaderBand = bandComponents.prepareBand(pageHeaderBand, maxWidth, templateDesign.getPageHeaderComponentsCount());
        pageFooterBand = bandComponents.prepareBand(pageFooterBand, maxWidth, templateDesign.getPageFooterComponentsCount());
        columnHeaderBand = bandComponents.prepareBand(columnHeaderBand, maxColumnWidth, templateDesign.getColumnHeaderComponentsCount());
        columnFooterBand = bandComponents.prepareBand(columnFooterBand, maxColumnWidth, templateDesign.getColumnFooterComponentsCount());
        List<DRDesignBand> removeDetailBands = new ArrayList<DRDesignBand>();
        for (DRDesignBand detailBand : detailBands) {
            if (bandComponents.prepareBand(detailBand, maxColumnWidth, 0) == null) {
                removeDetailBands.add(detailBand);
            }
        }
        detailBands.removeAll(removeDetailBands);
        lastPageFooterBand = bandComponents.prepareBand(lastPageFooterBand, maxWidth, templateDesign.getLastPageFooterComponentsCount());
        summaryBand = bandComponents.prepareBand(summaryBand, maxWidth, templateDesign.getSummaryComponentsCount());
        noDataBand = bandComponents.prepareBand(noDataBand, maxWidth, templateDesign.getNoDataComponentsCount());

        if (backgroundBand.getList() != null && backgroundBand.getList().isEmpty() && (backgroundBand.getList().getStyle() != null || backgroundBand.getList().getBackgroundComponent() != null)) {
            DRDesignFiller component = new DRDesignFiller();
            component.setWidth(1);
            component.setHeight(1);
            backgroundBand.getList().addComponent(component);
        }
        backgroundBand = bandComponents.prepareBand(backgroundBand, maxWidth, templateDesign.getBackgroundComponentsCount());
        if (backgroundBand != null && backgroundBand.getBandComponent() != null && backgroundBand.getList() != null &&
            (backgroundBand.getList().getStyle() != null || backgroundBand.getList().getBackgroundComponent() != null)) {
            DRIDesignPage page = accessor.getPage();
            int height = page.getHeight() - page.getMargin().getTop() - page.getMargin().getBottom();
            backgroundBand.getList().setHeight(height);
            if (backgroundBand.getList().getBackgroundComponent() != null) {
                backgroundBand.getList().getBackgroundComponent().setHeight(height);
            }
            backgroundBand.setHeight(height);
        }

        for (DRDesignGroup group : accessor.getGroupTransform().getGroups()) {
            List<DRDesignBand> bands = new ArrayList<DRDesignBand>();
            for (DRDesignBand band : group.getHeaderBands()) {
                DRDesignBand newBand = bandComponents.prepareBand(band, maxColumnWidth, 0);
                if (newBand != null) {
                    bands.add(newBand);
                }
            }
            group.setHeaderBands(bands);
            bands = new ArrayList<DRDesignBand>();
            for (DRDesignBand band : group.getFooterBands()) {
                DRDesignBand newBand = bandComponents.prepareBand(band, maxColumnWidth, 0);
                if (newBand != null) {
                    bands.add(newBand);
                }
            }
            group.setFooterBands(bands);
        }
    }

    // band

    /**
     * <p>band.</p>
     *
     * @param bandName                   a {@link java.lang.String} object.
     * @param bandName                   a {@link java.lang.String} object.
     * @param band                       a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @param splitType                  a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     * @param defaultStyle               a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     * @param defaultBackgroundComponent a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     * @param resetType                  a {@link net.sf.dynamicreports.design.constant.ResetType} object.
     * @param resetGroup                 a {@link net.sf.dynamicreports.design.base.DRDesignGroup} object.
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRDesignBand band(String bandName, DRIBand band, SplitType splitType, DRIReportStyle defaultStyle, DRIComponent defaultBackgroundComponent, ResetType resetType, DRDesignGroup resetGroup)
        throws DRException {
        DRDesignBand designBand = new DRDesignBand(bandName);
        designBand.setSplitType(splitType);
        designBand.setList(accessor.getComponentTransform().list(band.getList(), DefaultStyleType.TEXT, resetType, resetGroup));
        designBand.setPrintWhenExpression(accessor.getExpressionTransform().transformExpression(band.getPrintWhenExpression()));

        if (designBand.getList().getStyle() == null && defaultStyle != null) {
            designBand.getList().setStyle(accessor.getStyleTransform().transformStyle(defaultStyle, false, DefaultStyleType.NONE));
        }
        if (designBand.getList().getBackgroundComponent() == null && defaultBackgroundComponent != null) {
            designBand.getList().setBackgroundComponent(accessor.getComponentTransform().listBackgroundComponent(defaultBackgroundComponent, DefaultStyleType.TEXT, resetType, resetGroup));
        }

        return designBand;
    }

    /**
     * <p>band.</p>
     *
     * @param bandName                   a {@link java.lang.String} object.
     * @param bandName                   a {@link java.lang.String} object.
     * @param band                       a {@link net.sf.dynamicreports.report.definition.DRIBand} object.
     * @param splitType                  a {@link net.sf.dynamicreports.report.constant.SplitType} object.
     * @param defaultStyle               a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     * @param defaultBackgroundComponent a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRDesignBand band(String bandName, DRIBand band, SplitType splitType, DRIReportStyle defaultStyle, DRIComponent defaultBackgroundComponent) throws DRException {
        DRDesignBand designBand = new DRDesignBand(bandName);
        designBand.setSplitType(splitType);
        DRDesignList list = new DRDesignList();
        list.setType(band.getList().getType());
        list.setGap(accessor.getTemplateTransform().getListGap(band.getList()));
        list.setStretchType(accessor.getTemplateTransform().getStretchType(band.getList()));
        list.setPrintWhenExpression(accessor.getExpressionTransform().transformExpression(band.getList().getPrintWhenExpression()));
        list.setStyle(accessor.getStyleTransform().transformStyle(band.getList().getStyle(), false, DefaultStyleType.NONE));
        designBand.setList(list);

        if (list.getStyle() == null && defaultStyle != null) {
            list.setStyle(accessor.getStyleTransform().transformStyle(defaultStyle, false, DefaultStyleType.NONE));
        }
        if (designBand.getList().getBackgroundComponent() == null && defaultBackgroundComponent != null) {
            designBand.getList().setBackgroundComponent(accessor.getComponentTransform().listBackgroundComponent(defaultBackgroundComponent, DefaultStyleType.TEXT, ResetType.NONE, null));
        }

        return designBand;
    }

    /**
     * <p>Getter for the field <code>titleBand</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     */
    public DRDesignBand getTitleBand() {
        return titleBand;
    }

    /**
     * <p>Getter for the field <code>pageHeaderBand</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     */
    public DRDesignBand getPageHeaderBand() {
        return pageHeaderBand;
    }

    /**
     * <p>Getter for the field <code>pageFooterBand</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     */
    public DRDesignBand getPageFooterBand() {
        return pageFooterBand;
    }

    /**
     * <p>Getter for the field <code>columnHeaderBand</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     */
    public DRDesignBand getColumnHeaderBand() {
        return columnHeaderBand;
    }

    /**
     * <p>Getter for the field <code>columnHeaderForGroupBand</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     */
    public DRDesignBand getColumnHeaderForGroupBand() {
        return columnHeaderForGroupBand;
    }

    /**
     * <p>Getter for the field <code>columnFooterBand</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     */
    public DRDesignBand getColumnFooterBand() {
        return columnFooterBand;
    }

    /**
     * <p>Getter for the field <code>detailBands</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRDesignBand> getDetailBands() {
        return detailBands;
    }

    /**
     * <p>Getter for the field <code>detailBand</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     */
    public DRDesignBand getDetailBand() {
        return detailBand;
    }

    /**
     * <p>Getter for the field <code>lastPageFooterBand</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     */
    public DRDesignBand getLastPageFooterBand() {
        return lastPageFooterBand;
    }

    /**
     * <p>Getter for the field <code>summaryBand</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     */
    public DRDesignBand getSummaryBand() {
        return summaryBand;
    }

    /**
     * <p>Getter for the field <code>noDataBand</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     */
    public DRDesignBand getNoDataBand() {
        return noDataBand;
    }

    /**
     * <p>Getter for the field <code>backgroundBand</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignBand} object.
     */
    public DRDesignBand getBackgroundBand() {
        return backgroundBand;
    }
}

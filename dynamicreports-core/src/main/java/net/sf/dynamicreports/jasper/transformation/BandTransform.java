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
package net.sf.dynamicreports.jasper.transformation;

import net.sf.dynamicreports.design.definition.DRIDesignBand;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.DRIDesignReport;
import net.sf.dynamicreports.design.definition.DRIDesignTemplateDesign;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.jasperreports.engine.JRElement;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignElement;
import net.sf.jasperreports.engine.design.JRDesignSection;
import net.sf.jasperreports.engine.design.JasperDesign;

/**
 * <p>BandTransform class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class BandTransform {
    private JasperTransformAccessor accessor;

    /**
     * <p>Constructor for BandTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.jasper.transformation.JasperTransformAccessor} object.
     */
    public BandTransform(JasperTransformAccessor accessor) {
        this.accessor = accessor;
    }

    /**
     * <p>transform.</p>
     */
    public void transform() {
        DRIDesignReport report = accessor.getReport();
        JasperDesign design = accessor.getDesign();
        DRIDesignTemplateDesign templateDesign = report.getTemplateDesign();

        if (templateDesign.getTitleComponentsCount() == 0 && report.getTitleBand() != null) {
            design.setTitle(band(report.getTitleBand()));
        }
        if (templateDesign.getPageHeaderComponentsCount() == 0 && report.getPageHeaderBand() != null) {
            design.setPageHeader(band(report.getPageHeaderBand()));
        }
        if (templateDesign.getPageFooterComponentsCount() == 0 && report.getPageFooterBand() != null) {
            design.setPageFooter(band(report.getPageFooterBand()));
        }
        if (templateDesign.getColumnHeaderComponentsCount() == 0 && report.getColumnHeaderBand() != null) {
            design.setColumnHeader(band(report.getColumnHeaderBand()));
        }
        if (templateDesign.getColumnFooterComponentsCount() == 0 && report.getColumnFooterBand() != null) {
            design.setColumnFooter(band(report.getColumnFooterBand()));
        }
        for (DRIDesignGroup group : report.getGroups()) {
            if (group.getHeaderBands() != null) {
                JRDesignBand jrTitleAndValueBand = null;
                for (DRIDesignBand band : group.getHeaderBands()) {
                    JRDesignBand jrBand = band(band);
                    if (band.getName() != null && band.getName().equals("groupHeaderTitleAndValue")) {
                        jrTitleAndValueBand = jrBand;
                    }
                    if (jrBand != null) {
                        if (band.getName() != null && band.getName().equals("subtotalGroupHeader") && jrTitleAndValueBand != null && group.isHeaderWithSubtotal()) {
                            if (jrTitleAndValueBand.getHeight() < jrBand.getHeight()) {
                                jrTitleAndValueBand.setHeight(jrBand.getHeight());
                            }
                            for (JRElement jrElement : jrBand.getElements()) {
                                jrTitleAndValueBand.addElement(jrElement);
                            }
                            continue;
                        }
                        ((JRDesignSection) accessor.getGroupTransform().getGroup(group).getGroupHeaderSection()).addBand(jrBand);
                    }
                }
            }
            if (group.getFooterBands() != null) {
                for (DRIDesignBand band : group.getFooterBands()) {
                    JRDesignBand jrBand = band(band);
                    if (jrBand != null) {
                        ((JRDesignSection) accessor.getGroupTransform().getGroup(group).getGroupFooterSection()).addBand(jrBand);
                    }
                }
            }
        }
        for (DRIDesignBand band : report.getDetailBands()) {
            JRDesignBand jrBand = band(band);
            if (jrBand != null) {
                ((JRDesignSection) design.getDetailSection()).addBand(jrBand);
            }
        }
        if (templateDesign.getLastPageFooterComponentsCount() == 0 && report.getLastPageFooterBand() != null) {
            design.setLastPageFooter(band(report.getLastPageFooterBand()));
        }
        if (templateDesign.getSummaryComponentsCount() == 0 && report.getSummaryBand() != null) {
            design.setSummary(band(report.getSummaryBand()));
        }
        if (templateDesign.getNoDataComponentsCount() == 0 && report.getNoDataBand() != null) {
            design.setNoData(band(report.getNoDataBand()));
        }
        if (templateDesign.getBackgroundComponentsCount() == 0 && report.getBackgroundBand() != null) {
            design.setBackground(band(report.getBackgroundBand()));
        }
    }

    // band
    private JRDesignBand band(DRIDesignBand band) {
        if (band == null) {
            return null;
        }
        JRDesignBand jrBand = new JRDesignBand();
        if (band.getBandComponent() != null) {
            if (band.getPrintWhenExpression() != null) {
                jrBand.setPrintWhenExpression(accessor.getExpressionTransform().getExpression(band.getPrintWhenExpression()));
            } else {
                jrBand.setPrintWhenExpression(accessor.getExpressionTransform().getExpression(band.getBandComponent().getPrintWhenExpression()));
            }
            jrBand.setSplitType(ConstantTransform.splitType(band.getSplitType()));
            JRDesignElement[] jrElements = accessor.getComponentTransform().component(band.getBandComponent(), ListType.VERTICAL);
            for (JRDesignElement jrElement : jrElements) {
                jrBand.addElement(jrElement);
            }
        }
        jrBand.setHeight(band.getHeight());
        return jrBand;
    }
}

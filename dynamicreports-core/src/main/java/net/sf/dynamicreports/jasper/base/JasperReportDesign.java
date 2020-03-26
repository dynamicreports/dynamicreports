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
package net.sf.dynamicreports.jasper.base;

import net.sf.dynamicreports.design.definition.DRIDesignReport;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.design.JasperDesign;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>JasperReportDesign class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class JasperReportDesign implements Serializable {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private JasperCustomValues customValues;
    private JasperDesign design;
    private Map<String, Object> parameters;
    private ReportParameters masterReportParameters;
    private Integer startPageNumber;
    private boolean tableOfContents;
    private DRITableOfContentsCustomizer tableOfContentsCustomizer;

    /**
     * <p>Constructor for JasperReportDesign.</p>
     *
     * @param report          a {@link net.sf.dynamicreports.design.definition.DRIDesignReport} object.
     * @param startPageNumber a {@link java.lang.Integer} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public JasperReportDesign(DRIDesignReport report, Integer startPageNumber) throws DRException {
        this(report, null, startPageNumber);
    }

    /**
     * <p>Constructor for JasperReportDesign.</p>
     *
     * @param report                 a {@link net.sf.dynamicreports.design.definition.DRIDesignReport} object.
     * @param masterReportParameters a {@link net.sf.dynamicreports.report.definition.ReportParameters} object.
     * @param startPageNumber        a {@link java.lang.Integer} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public JasperReportDesign(DRIDesignReport report, ReportParameters masterReportParameters, Integer startPageNumber) throws DRException {
        this.masterReportParameters = masterReportParameters;
        this.startPageNumber = startPageNumber;
        init(report);
    }

    private void init(DRIDesignReport report) throws DRException {
        this.design = (JasperDesign) report.getTemplateDesign().getDesign();
        this.tableOfContents = report.isTableOfContents();
        this.tableOfContentsCustomizer = report.getTableOfContentsCustomizer();
        this.customValues = new JasperCustomValues(report.getProperties());
        this.parameters = new HashMap<String, Object>();
    }

    /**
     * <p>Getter for the field <code>customValues</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.base.JasperCustomValues} object.
     */
    public JasperCustomValues getCustomValues() {
        return customValues;
    }

    /**
     * <p>Getter for the field <code>design</code>.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.design.JasperDesign} object.
     */
    public JasperDesign getDesign() {
        return design;
    }

    /**
     * <p>Getter for the field <code>parameters</code>.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, Object> getParameters() {
        return parameters;
    }

    /**
     * <p>Getter for the field <code>startPageNumber</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getStartPageNumber() {
        return startPageNumber;
    }

    /**
     * <p>Getter for the field <code>masterReportParameters</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.ReportParameters} object.
     */
    public ReportParameters getMasterReportParameters() {
        return masterReportParameters;
    }

    /**
     * <p>isTableOfContents.</p>
     *
     * @return a boolean.
     */
    public boolean isTableOfContents() {
        return tableOfContents;
    }

    /**
     * <p>Getter for the field <code>tableOfContentsCustomizer</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer} object.
     */
    public DRITableOfContentsCustomizer getTableOfContentsCustomizer() {
        return tableOfContentsCustomizer;
    }
}

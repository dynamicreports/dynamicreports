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
package net.sf.dynamicreports.jasper.transformation.expression;

import net.sf.dynamicreports.design.base.DRDesignReport;
import net.sf.dynamicreports.design.base.expression.AbstractDesignComplexExpression;
import net.sf.dynamicreports.design.definition.DRIDesignReport;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.jasper.base.JasperReportDesign;
import net.sf.dynamicreports.jasper.transformation.JasperTransform;
import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRICustomValues;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>SubreportExpression class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class SubreportExpression extends AbstractDesignComplexExpression {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
    private static final Log log = LogFactory.getLog(SubreportExpression.class);

    private String name;
    private Integer pageWidth;
    private ReportBuilder<?> reportBuilder;
    private Map<ReportBuilder<?>, JasperReportDesign> reportDesigns;
    private Map<ReportBuilder<?>, JasperReport> jasperReports;

    /**
     * <p>Constructor for SubreportExpression.</p>
     *
     * @param pageWidthExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     * @param reportExpression    a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     * @param pageWidth           a {@link java.lang.Integer} object.
     */
    public SubreportExpression(DRIDesignExpression pageWidthExpression, DRIDesignExpression reportExpression, Integer pageWidth) {
        addExpression(pageWidthExpression);
        addExpression(reportExpression);
        this.pageWidth = pageWidth;
        this.name = ReportUtils.generateUniqueName("subreportExpression");
        reportDesigns = new HashMap<ReportBuilder<?>, JasperReportDesign>();
        jasperReports = new HashMap<ReportBuilder<?>, JasperReport>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object evaluate(List<?> values, ReportParameters reportParameters) {
        reportBuilder = (ReportBuilder<?>) values.get(1);
        if (jasperReports.containsKey(reportBuilder)) {
            return jasperReports.get(reportBuilder);
        }
        try {
            DRICustomValues customValues = (DRICustomValues) reportParameters.getParameterValue(DRICustomValues.NAME);
            DRIDesignReport report = new DRDesignReport(reportBuilder.build(), pageWidth, customValues.getTocHeadings());
            JasperReportDesign reportDesign = new JasperReportDesign(report, reportParameters, null);
            JasperTransform jasperTransform = new JasperTransform(report, reportDesign);
            jasperTransform.transform();
            JasperReport jasperReport = JasperCompileManager.compileReport(reportDesign.getDesign());
            reportDesigns.put(reportBuilder, reportDesign);
            jasperReports.put(reportBuilder, jasperReport);
            return jasperReport;
        } catch (JRException e) {
            if (log.isErrorEnabled()) {
                log.error("Error encountered while creating subreport design", e);
            }
        } catch (DRException e) {
            if (log.isErrorEnabled()) {
                log.error("Error encountered while creating subreport design", e);
            }
        }
        return null;
    }

    /**
     * <p>getReportDesign.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.base.JasperReportDesign} object.
     */
    public JasperReportDesign getReportDesign() {
        return reportDesigns.get(reportBuilder);
    }

    /**
     * <p>Getter for the field <code>reportBuilder</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.ReportBuilder} object.
     */
    public ReportBuilder<?> getReportBuilder() {
        return reportBuilder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?> getValueClass() {
        return JasperReport.class;
    }
}

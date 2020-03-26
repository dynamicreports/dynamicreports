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

import net.sf.dynamicreports.design.definition.DRIDesignHyperLink;
import net.sf.dynamicreports.design.definition.DRIDesignMargin;
import net.sf.dynamicreports.design.definition.DRIDesignPage;
import net.sf.dynamicreports.design.definition.DRIDesignParameter;
import net.sf.dynamicreports.design.definition.DRIDesignQuery;
import net.sf.dynamicreports.design.definition.DRIDesignReport;
import net.sf.dynamicreports.jasper.base.CustomScriptlet;
import net.sf.dynamicreports.jasper.base.JasperCustomValues;
import net.sf.dynamicreports.jasper.base.JasperReportParameters;
import net.sf.dynamicreports.jasper.base.JasperScriptlet;
import net.sf.dynamicreports.jasper.base.StartPageNumberScriptlet;
import net.sf.dynamicreports.jasper.base.tableofcontents.JasperTocHeading;
import net.sf.dynamicreports.jasper.constant.ValueType;
import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.dynamicreports.report.definition.DRIScriptlet;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.jasperreports.engine.JRAbstractScriptlet;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRScriptlet;
import net.sf.jasperreports.engine.design.JRDesignHyperlink;
import net.sf.jasperreports.engine.design.JRDesignParameter;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JRDesignScriptlet;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.HyperlinkTargetEnum;
import net.sf.jasperreports.engine.type.HyperlinkTypeEnum;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>ReportTransform class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class ReportTransform {
    private JasperTransformAccessor accessor;

    /**
     * <p>Constructor for ReportTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.jasper.transformation.JasperTransformAccessor} object.
     */
    public ReportTransform(JasperTransformAccessor accessor) {
        this.accessor = accessor;
    }

    /**
     * <p>transform.</p>
     */
    public void transform() {
        DRIDesignReport report = accessor.getReport();
        JasperDesign design = accessor.getDesign();
        Map<String, Object> parameters = accessor.getParameters();

        if (report.isTableOfContents()) {
            Map<String, JasperTocHeading> tocHeadings = report.getTableOfContentsHeadings();
            if (tocHeadings == null) {
                tocHeadings = new LinkedHashMap<String, JasperTocHeading>();
            }
            accessor.getCustomValues().setTocHeadings(tocHeadings);
        }

        design.setName(report.getReportName());
        parameters.put(JRParameter.REPORT_LOCALE, report.getLocale());
        parameters.put(JRParameter.REPORT_RESOURCE_BUNDLE, report.getResourceBundle());
        design.setResourceBundle(report.getResourceBundleName());
        design.setIgnorePagination(report.isIgnorePagination());
        setProperties(report.getProperties());
        if (report.getQuery() != null) {
            design.setQuery(query(report.getQuery()));
        }
        page();
        design.setWhenNoDataType(ConstantTransform.whenNoDataType(report.getWhenNoDataType()));
        design.setWhenResourceMissingType(ConstantTransform.whenResourceMissingType(report.getWhenResourceMissingType()));
        design.setTitleNewPage(report.isTitleOnANewPage());
        design.setSummaryNewPage(report.isSummaryOnANewPage());
        design.setSummaryWithPageHeaderAndFooter(report.isSummaryWithPageHeaderAndFooter());
        design.setFloatColumnFooter(report.isFloatColumnFooter());
        design.setPrintOrder(ConstantTransform.printOrder(report.getPrintOrder()));
        design.setColumnDirection(ConstantTransform.runDirection(report.getColumnDirection()));
        design.setLanguage(report.getLanguage());

        for (DRIDesignParameter parameter : report.getParameters()) {
            addParameter(parameter);
        }

        if (accessor.getStartPageNumber() != null) {
            addScriptlet("startPageNumber", StartPageNumberScriptlet.class);
            accessor.getCustomValues().setStartPageNumber(accessor.getStartPageNumber());
        }

        for (DRIScriptlet scriptlet : report.getScriptlets()) {
            addScriptlet(scriptlet);
        }
    }

    /**
     * <p>transformExpressions.</p>
     */
    public void transformExpressions() {
        accessor.getDesign().setFilterExpression(accessor.getExpressionTransform().getExpression(accessor.getReport().getFilterExpression()));
    }

    /**
     * <p>addDependencies.</p>
     */
    public void addDependencies() {
        DRIDesignReport report = accessor.getReport();
        if (!accessor.getCustomValues().isEmpty() || !report.getScriptlets().isEmpty() || accessor.getCustomValues().getStartPageNumber() != null || report.isTableOfContents()) {
            addParameter(JasperCustomValues.NAME, JasperCustomValues.class, accessor.getCustomValues());
        }
        if (accessor.getMasterReportParameters() != null) {
            addParameter(JasperReportParameters.MASTER_REPORT_PARAMETERS, ReportParameters.class, accessor.getMasterReportParameters());
        }
        if (!accessor.getCustomValues().isEmpty() || !report.getScriptlets().isEmpty()) {
            addScriptlet(JasperScriptlet.NAME, JasperScriptlet.class);
        }
    }

    private <T> void addParameter(String name, Class<T> parameterClass, T value) {
        if (!accessor.getDesign().getParametersMap().containsKey(name)) {
            try {
                JRDesignParameter jrParameter = new JRDesignParameter();
                jrParameter.setName(name);
                jrParameter.setValueClass(parameterClass);
                accessor.getDesign().addParameter(jrParameter);
            } catch (JRException e) {
                throw new JasperDesignException("Registration failed for parameter \"" + name + "\"", e);
            }
        } else {
            JRParameter jrParameter = accessor.getDesign().getParametersMap().get(name);
            if (!parameterClass.isAssignableFrom(jrParameter.getValueClass())) {
                throw new JasperDesignException("Registration failed for parameter \"" + name + "\", parameter is not instance of " + parameterClass.getName());
            }
        }
        if (value != null) {
            accessor.getParameters().put(name, value);
        }
    }

    private void addParameter(DRIDesignParameter parameter) {
        try {
            if (!parameter.isExternal()) {
                accessor.getDesign().addParameter(parameter(parameter));
            }
            accessor.getCustomValues().addValueType(parameter.getName(), ValueType.PARAMETER);
            if (parameter.getValue() != null) {
                accessor.getParameters().put(parameter.getName(), parameter.getValue());
            }
        } catch (JRException e) {
            throw new JasperDesignException("Registration failed for parameter \"" + parameter.getName() + "\"", e);
        }
    }

    private void setProperties(Properties properties) {
        for (
            Iterator<Object> iterator = properties.keySet().iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            accessor.getDesign().setProperty(key, properties.getProperty(key));
        }
    }

    private void addScriptlet(DRIScriptlet scriptlet) {
        CustomScriptlet customScriptlet = new CustomScriptlet(scriptlet);
        addScriptlet(scriptlet.getName(), customScriptlet.getClass());
        accessor.getParameters().put(scriptlet.getName() + JRScriptlet.SCRIPTLET_PARAMETER_NAME_SUFFIX, customScriptlet);
    }

    private void addScriptlet(String name, Class<? extends JRAbstractScriptlet> scriptletClass) {
        try {
            accessor.getDesign().addScriptlet(scriptlet(name, scriptletClass));
        } catch (JRException e) {
            throw new JasperDesignException("Registration failed for scriptlet \"" + name + "\"", e);
        }
    }

    /**
     * <p>hyperLink.</p>
     *
     * @param hyperLink a {@link net.sf.dynamicreports.design.definition.DRIDesignHyperLink} object.
     * @return a {@link net.sf.jasperreports.engine.design.JRDesignHyperlink} object.
     */
    public JRDesignHyperlink hyperLink(DRIDesignHyperLink hyperLink) {
        if (hyperLink == null) {
            return null;
        }

        JRDesignHyperlink jrHyperLink = new JRDesignHyperlink();
        jrHyperLink.setHyperlinkAnchorExpression(accessor.getExpressionTransform().getExpression(hyperLink.getAnchorExpression()));
        jrHyperLink.setHyperlinkPageExpression(accessor.getExpressionTransform().getExpression(hyperLink.getPageExpression()));
        jrHyperLink.setHyperlinkReferenceExpression(accessor.getExpressionTransform().getExpression(hyperLink.getReferenceExpression()));
        jrHyperLink.setHyperlinkTooltipExpression(accessor.getExpressionTransform().getExpression(hyperLink.getTooltipExpression()));
        if (hyperLink.getType() != null) {
            HyperlinkTypeEnum hyperLinkType = ConstantTransform.hyperLinkType(hyperLink.getType());
            if (hyperLinkType != null) {
                jrHyperLink.setHyperlinkType(hyperLinkType);
            } else {
                jrHyperLink.setLinkType(hyperLink.getType());
            }
        }
        if (hyperLink.getTarget() != null) {
            HyperlinkTargetEnum hyperLinkTarget = ConstantTransform.hyperLinkTarget(hyperLink.getTarget());
            if (hyperLinkTarget != null) {
                jrHyperLink.setHyperlinkTarget(hyperLinkTarget);
            } else {
                jrHyperLink.setLinkTarget(hyperLink.getTarget());
            }
        }

        return jrHyperLink;
    }

    // page
    private void page() {
        DRIDesignPage page = accessor.getReport().getPage();
        DRIDesignMargin margin = page.getMargin();
        JasperDesign design = accessor.getDesign();

        design.setPageWidth(page.getWidth());
        design.setPageHeight(page.getHeight());
        design.setOrientation(ConstantTransform.pageOrientation(page.getOrientation()));
        design.setLeftMargin(margin.getLeft());
        design.setRightMargin(margin.getRight());
        design.setTopMargin(margin.getTop());
        design.setBottomMargin(margin.getBottom());
        design.setColumnCount(page.getColumnsPerPage());
        design.setColumnSpacing(page.getColumnSpace());
        design.setColumnWidth(page.getColumnWidth());
    }

    // parameter
    private JRDesignParameter parameter(DRIDesignParameter parameter) {
        JRDesignParameter jrParameter = new JRDesignParameter();
        jrParameter.setName(parameter.getName());
        jrParameter.setValueClass(parameter.getValueClass());
        return jrParameter;
    }

    // scriptlet

    /**
     * <p>scriptlet.</p>
     *
     * @param name           a {@link java.lang.String} object.
     * @param scriptletClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.jasperreports.engine.design.JRDesignScriptlet} object.
     */
    protected JRDesignScriptlet scriptlet(String name, Class<? extends JRAbstractScriptlet> scriptletClass) {
        JRDesignScriptlet jrScriptlet = new JRDesignScriptlet();
        jrScriptlet.setName(name);
        jrScriptlet.setValueClass(scriptletClass);
        return jrScriptlet;
    }

    // query

    /**
     * <p>query.</p>
     *
     * @param query a {@link net.sf.dynamicreports.design.definition.DRIDesignQuery} object.
     * @return a {@link net.sf.jasperreports.engine.design.JRDesignQuery} object.
     */
    protected JRDesignQuery query(DRIDesignQuery query) {
        JRDesignQuery jrQuery = new JRDesignQuery();
        jrQuery.setText(query.getText());
        jrQuery.setLanguage(query.getLanguage());
        return jrQuery;
    }

}

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
package net.sf.dynamicreports.jasper.base;

import net.sf.dynamicreports.design.definition.expression.DRIDesignComplexExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression;
import net.sf.dynamicreports.jasper.constant.ValueType;
import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;
import net.sf.jasperreports.engine.fill.JRFillField;
import net.sf.jasperreports.engine.fill.JRFillGroup;
import net.sf.jasperreports.engine.fill.JRFillParameter;
import net.sf.jasperreports.engine.fill.JRFillVariable;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>JasperScriptlet class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class JasperScriptlet extends JRDefaultScriptlet {
    /**
     * Constant <code>NAME="DYNAMICREPORTS"</code>
     */
    public static final String NAME = "DYNAMICREPORTS";
    /**
     * Constant <code>SCRIPTLET_NAME="NAME + JRScriptlet.SCRIPTLET_PARAMETER_"{trunked}</code>
     */
    public static final String SCRIPTLET_NAME = NAME + JRScriptlet.SCRIPTLET_PARAMETER_NAME_SUFFIX;

    private JasperReportParameters reportParameters;

    /**
     * <p>getValue.</p>
     *
     * @param valueName a {@link java.lang.String} object.
     * @return a {@link java.lang.Object} object.
     */
    public Object getValue(String valueName) {
        return reportParameters.getValue(valueName);
    }

    /**
     * <p>getValue.</p>
     *
     * @param name   a {@link java.lang.String} object.
     * @param values an array of {@link java.lang.Object} objects.
     * @return a {@link java.lang.Object} object.
     */
    public Object getValue(String name, Object[] values) {
        return getComplexExpression(name).evaluate(Arrays.asList(values), reportParameters);
    }

    /**
     * <p>Getter for the field <code>reportParameters</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.base.JasperReportParameters} object.
     */
    public JasperReportParameters getReportParameters() {
        return reportParameters;
    }

    private JasperCustomValues getCustomValues() {
        try {
            return (JasperCustomValues) getParameterValue(JasperCustomValues.NAME, false);
        } catch (JRScriptletException e) {
            throw new JasperDesignException("Custom values not found", e);
        }
    }

    /**
     * <p>getValueType.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.constant.ValueType} object.
     */
    protected ValueType getValueType(String name) {
        return getCustomValues().getValueType(name);
    }

    /**
     * <p>getSimpleExpression.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression} object.
     */
    protected DRIDesignSimpleExpression getSimpleExpression(String name) {
        return getCustomValues().getSimpleExpression(name);
    }

    /**
     * <p>getComplexExpression.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignComplexExpression} object.
     */
    protected DRIDesignComplexExpression getComplexExpression(String name) {
        return getCustomValues().getComplexExpression(name);
    }

    /**
     * <p>getChartCustomizers.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link java.util.List} object.
     */
    protected List<DRIChartCustomizer> getChartCustomizers(String name) {
        return getCustomValues().getChartCustomizers(name);
    }

    /**
     * <p>getSystemValue.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link java.lang.Object} object.
     */
    protected Object getSystemValue(String name) {
        return getCustomValues().getSystemValue(name);
    }

    /**
     * <p>getFields.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    protected Collection<String> getFields() {
        return fieldsMap.keySet();
    }

    /**
     * <p>getVariables.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    protected Collection<String> getVariables() {
        return variablesMap.keySet();
    }

    /**
     * <p>getParameters.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    protected Collection<String> getParameters() {
        return parametersMap.keySet();
    }

    /**
     * <p>getSubreportWidth.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    protected Integer getSubreportWidth() {
        return getCustomValues().getSubreportWidth();
    }

    /** {@inheritDoc} */
    @Override
    public void setData(Map<String, JRFillParameter> parsm, Map<String, JRFillField> fldsm, Map<String, JRFillVariable> varsm, JRFillGroup[] grps) {
        super.setData(parsm, fldsm, varsm, grps);
        reportParameters = new JasperReportParameters(this);
    }

    /** {@inheritDoc} */
    @Override
    public void afterReportInit() throws JRScriptletException {
        super.afterReportInit();
        JasperCustomValues customValues = getCustomValues();
        if (customValues != null) {
            customValues.setJasperScriptlet(this);
        }
    }
}

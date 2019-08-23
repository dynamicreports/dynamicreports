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
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.transformation.expressions.CrosstabRowCounter;
import net.sf.dynamicreports.jasper.constant.ValueType;
import net.sf.dynamicreports.report.definition.DRIScriptlet;
import net.sf.dynamicreports.report.definition.DRIValue;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRReportException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;
import net.sf.jasperreports.engine.JRVariable;

import java.sql.Connection;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * <p>JasperReportParameters class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class JasperReportParameters implements ReportParameters {
    /**
     * Constant <code>MASTER_REPORT_PARAMETERS="MASTER_REPORT_PARAMETERS"</code>
     */
    public static final String MASTER_REPORT_PARAMETERS = "MASTER_REPORT_PARAMETERS";

    private JasperScriptlet jasperScriptlet;

    /**
     * <p>Constructor for JasperReportParameters.</p>
     *
     * @param jasperScriptlet a {@link net.sf.dynamicreports.jasper.base.JasperScriptlet} object.
     */
    protected JasperReportParameters(JasperScriptlet jasperScriptlet) {
        this.jasperScriptlet = jasperScriptlet;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getValue(String name) {
        ValueType type = jasperScriptlet.getValueType(name);
        if (type != null) {
            switch (type) {
                case FIELD:
                    return (T) getFieldValue(name);
                case VARIABLE:
                    return (T) getVariableValue(name);
                case PARAMETER:
                    return (T) getParameterValue(name);
                case SIMPLE_EXPRESSION:
                    return (T) getSimpleExpressionValue(name);
                case COMPLEX_EXPRESSION:
                    return (T) getComplexExpressionValue(name);
                case SYSTEM_EXPRESSION:
                    return (T) getSystemExpressionValue(name);
                default:
                    break;
            }
        }

        throw new DRReportException("Value " + name + " not found");
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getValue(DRIValue<T> value) {
        return (T) getValue(value.getName());
    }

    // field

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getFieldValue(String name) {
        try {
            return (T) jasperScriptlet.getFieldValue(name);
        } catch (JRScriptletException e) {
            throw new DRReportException(e);
        }
    }

    // variable

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getVariableValue(String name) {
        try {
            return (T) jasperScriptlet.getVariableValue(name);
        } catch (JRScriptletException e) {
            throw new DRReportException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageNumber() {
        return (Integer) getVariableValue(JRVariable.PAGE_NUMBER);
    }

    /** {@inheritDoc} */
    @Override
    public Integer getColumnNumber() {
        return (Integer) getVariableValue(JRVariable.COLUMN_NUMBER);
    }

    /** {@inheritDoc} */
    @Override
    public Integer getReportRowNumber() {
        return (Integer) getVariableValue(JRVariable.REPORT_COUNT);
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageRowNumber() {
        return (Integer) getVariableValue(JRVariable.PAGE_COUNT);
    }

    /** {@inheritDoc} */
    @Override
    public Integer getColumnRowNumber() {
        return (Integer) getVariableValue(JRVariable.COLUMN_COUNT);
    }

    /** {@inheritDoc} */
    @Override
    public Integer getCrosstabRowNumber() {
        CrosstabRowCounter counter = (CrosstabRowCounter) getValue(CROSSTAB_ROW_COUNTER);
        if (counter != null) {
            return counter.getRowNumber();
        }
        return 0;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getGroupCount(String groupName) {
        return (Integer) getVariableValue(groupName + "_COUNT");
    }

    // parameter

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public <T> T getParameterValue(String name) {
        try {
            return (T) ((Map<?, ?>) jasperScriptlet.getParameterValue(JRParameter.REPORT_PARAMETERS_MAP)).get(name);
        } catch (JRScriptletException e) {
            throw new DRReportException(e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public Connection getConnection() {
        return (Connection) getParameterValue(JRParameter.REPORT_CONNECTION);
    }

    /** {@inheritDoc} */
    @Override
    public Locale getLocale() {
        return (Locale) getParameterValue(JRParameter.REPORT_LOCALE);
    }

    /** {@inheritDoc} */
    @Override
    public DRIScriptlet getScriptlet(String name) {
        return ((CustomScriptlet) getParameterValue(name + JRScriptlet.SCRIPTLET_PARAMETER_NAME_SUFFIX)).getScriptlet();
    }

    /** {@inheritDoc} */
    @Override
    public String getMessage(String key) {
        return ((ResourceBundle) getParameterValue(JRParameter.REPORT_RESOURCE_BUNDLE)).getString(key);
    }

    /** {@inheritDoc} */
    @Override
    public String getMessage(String key, Object[] arguments) {
        String message = getMessage(key);
        if (arguments != null) {
            MessageFormat format = new MessageFormat(message, getLocale());
            message = format.format(arguments);
        }
        return message;
    }

    // simple expression
    private Object getSimpleExpressionValue(String name) {
        return jasperScriptlet.getSimpleExpression(name).evaluate(this);
    }

    // complex expression
    private Object getComplexExpressionValue(String name) {
        List<Object> values = new ArrayList<Object>();
        DRIDesignComplexExpression complexExpression = jasperScriptlet.getComplexExpression(name);
        for (DRIDesignExpression valueExpression : complexExpression.getExpressions()) {
            values.add(getValue(valueExpression.getName()));
        }
        return complexExpression.evaluate(values, this);
    }

    // system expression
    private Object getSystemExpressionValue(String name) {
        return jasperScriptlet.getSystemValue(name);
    }

    /** {@inheritDoc} */
    @Override
    public ReportParameters getMasterParameters() {
        return (ReportParameters) getParameterValue(MASTER_REPORT_PARAMETERS);
    }

    /** {@inheritDoc} */
    @Override
    public Integer getSubreportWidth() {
        return jasperScriptlet.getSubreportWidth();
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("FIELDS:\n");
        Collection<String> names = jasperScriptlet.getFields();
        for (String name : names) {
            result.append(name + " = " + getFieldValue(name));
            result.append("\n");
        }

        result.append("VARIABLES:\n");
        names = jasperScriptlet.getVariables();
        for (String name : names) {
            result.append(name + " = " + getVariableValue(name));
            result.append("\n");
        }

        result.append("PARAMETERS:\n");
        names = jasperScriptlet.getParameters();
        for (String name : names) {
            result.append(name + " = " + getParameterValue(name));
            result.append("\n");
        }

        return result.toString();
    }

}

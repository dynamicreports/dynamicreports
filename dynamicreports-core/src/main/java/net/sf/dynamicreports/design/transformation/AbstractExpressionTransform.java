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

import net.sf.dynamicreports.design.base.DRDesignField;
import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.DRDesignSort;
import net.sf.dynamicreports.design.base.DRDesignVariable;
import net.sf.dynamicreports.design.base.expression.DRDesignComplexExpression;
import net.sf.dynamicreports.design.base.expression.DRDesignJasperExpression;
import net.sf.dynamicreports.design.base.expression.DRDesignParameterExpression;
import net.sf.dynamicreports.design.base.expression.DRDesignPropertyExpression;
import net.sf.dynamicreports.design.base.expression.DRDesignSimpleExpression;
import net.sf.dynamicreports.design.base.expression.DRDesignSystemExpression;
import net.sf.dynamicreports.design.base.expression.DRDesignValueFormatter;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.DRIDesignDataset;
import net.sf.dynamicreports.design.definition.DRIDesignField;
import net.sf.dynamicreports.design.definition.DRIDesignSort;
import net.sf.dynamicreports.design.definition.DRIDesignVariable;
import net.sf.dynamicreports.design.definition.expression.DRIDesignComplexExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignJasperExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignParameterExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignPropertyExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSystemExpression;
import net.sf.dynamicreports.design.exception.DRDesignReportException;
import net.sf.dynamicreports.report.base.DRVariable;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.definition.DRIField;
import net.sf.dynamicreports.report.definition.DRISort;
import net.sf.dynamicreports.report.definition.DRISubtotal;
import net.sf.dynamicreports.report.definition.DRIVariable;
import net.sf.dynamicreports.report.definition.column.DRIBooleanColumn;
import net.sf.dynamicreports.report.definition.column.DRIValueColumn;
import net.sf.dynamicreports.report.definition.expression.DRIComplexExpression;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIJasperExpression;
import net.sf.dynamicreports.report.definition.expression.DRIParameterExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import net.sf.dynamicreports.report.definition.expression.DRISimpleExpression;
import net.sf.dynamicreports.report.definition.expression.DRISystemExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Abstract AbstractExpressionTransform class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public abstract class AbstractExpressionTransform {
    protected DesignTransformAccessor accessor;
    private Map<String, DRIDesignField> fields;
    private Map<String, DRIDesignVariable> variables;
    private Map<String, DRIDesignSystemExpression> systemExpressions;
    private Map<String, DRIDesignJasperExpression> jasperExpressions;
    private Map<String, DRIDesignSimpleExpression> simpleExpressions;
    private Map<String, DRIDesignComplexExpression> complexExpressions;
    private Map<DRIExpression<?>, DRIDesignExpression> expressions;
    private List<DRIDesignSort> sorts;

    /**
     * <p>Constructor for AbstractExpressionTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.design.transformation.DesignTransformAccessor} object.
     */
    public AbstractExpressionTransform(DesignTransformAccessor accessor) {
        this.accessor = accessor;
        init();
    }

    private void init() {
        fields = new LinkedHashMap<String, DRIDesignField>();
        variables = new LinkedHashMap<String, DRIDesignVariable>();
        systemExpressions = new HashMap<String, DRIDesignSystemExpression>();
        jasperExpressions = new HashMap<String, DRIDesignJasperExpression>();
        simpleExpressions = new HashMap<String, DRIDesignSimpleExpression>();
        complexExpressions = new HashMap<String, DRIDesignComplexExpression>();
        expressions = new HashMap<DRIExpression<?>, DRIDesignExpression>();
        sorts = new ArrayList<DRIDesignSort>();
    }

    /**
     * <p>transform.</p>
     *
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public void transform() throws DRException {
        for (DRIField<?> field : transformFields()) {
            transformExpression(field);
        }
        for (DRIVariable<?> variable : transformVariables()) {
            transformExpression(variable);
        }
        for (DRISort sort : transformSorts()) {
            transformSort(sort);
        }
    }

    /**
     * <p>transformExpression.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public DRIDesignExpression transformExpression(DRIExpression<?> expression) throws DRException {
        return transformExpression(expression, null, null);
    }

    /**
     * <p>transformExpression.</p>
     *
     * @param expression    a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param parameterName a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRIDesignExpression transformExpression(DRIExpression<?> expression, String parameterName) throws DRException {
        return transformExpression(expression, null, parameterName);
    }

    /**
     * <p>transformExpression.</p>
     *
     * @param expression     a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param valueFormatter a {@link net.sf.dynamicreports.report.definition.expression.DRIValueFormatter} object.
     * @param parameterName  a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRIDesignExpression transformExpression(DRIExpression<?> expression, DRIValueFormatter<?, ?> valueFormatter, String parameterName) throws DRException {
        if (expression == null) {
            return null;
        }

        if (valueFormatter != null) {
            return addExpression(new DRDesignValueFormatter(valueFormatter, transformExpression(expression)));
        }
        if (expressions.containsKey(expression)) {
            return expressions.get(expression);
        }

        DRIDesignExpression express;
        if (expression instanceof DRISystemExpression<?>) {
            express = new DRDesignSystemExpression((DRISystemExpression<?>) expression);
        } else if (expression instanceof DRIJasperExpression<?>) {
            express = new DRDesignJasperExpression((DRIJasperExpression<?>) expression);
        } else if (expression instanceof DRISimpleExpression<?>) {
            express = new DRDesignSimpleExpression((DRISimpleExpression<?>) expression, parameterName);
        } else if (expression instanceof DRIComplexExpression<?>) {
            express = transformComplexExpression((DRIComplexExpression<?>) expression, parameterName);
        } else if (expression instanceof DRIField<?>) {
            express = transformField((DRIField<?>) expression);
        } else if (expression instanceof DRIVariable<?>) {
            express = transformVariable((DRIVariable<?>) expression);
        } else if (expression instanceof DRIValueColumn<?>) {
            express = transformExpression(((DRIValueColumn<?>) expression).getComponent().getValueExpression());
        } else if (expression instanceof DRIBooleanColumn) {
            express = transformExpression(((DRIBooleanColumn) expression).getComponent().getValueExpression());
        } else if (expression instanceof DRISubtotal<?>) {
            express = transformExpression(((DRISubtotal<?>) expression).getValueField().getValueExpression());
        } else {
            throw new DRDesignReportException("Expression " + expression.getClass().getName() + " not supported");
        }
        express = addExpression(express);
        if (valueFormatter == null) {
            expressions.put(expression, express);
        }
        return express;
    }

    private DRDesignField transformField(DRIField<?> field) {
        DRDesignField designField = new DRDesignField();
        designField.setName(field.getName());
        designField.setValueClass(field.getValueClass());
        designField.setDescription(accessor.getTemplateTransform().getFieldDescription(field));
        return designField;
    }

    private DRIDesignExpression transformComplexExpression(DRIComplexExpression<?> complexExpression, String parameterName) throws DRException {
        DRDesignComplexExpression designComplexExpression = new DRDesignComplexExpression(complexExpression, parameterName);
        for (DRIExpression<?> expression : complexExpression.getExpressions()) {
            designComplexExpression.addExpression(transformExpression(expression));
        }
        return designComplexExpression;
    }

    private DRIDesignExpression transformVariable(DRIVariable<?> variable) throws DRException {
        DRDesignVariable designVariable = new DRDesignVariable(variable.getName());
        designVariable.setValueExpression(transformExpression(variable.getValueExpression()));
        designVariable.setInitialValueExpression(transformExpression(variable.getInitialValueExpression()));
        designVariable.setCalculation(variable.getCalculation());
        designVariable.setResetType(getVariableResetType(variable));
        designVariable.setResetGroup(getVariableResetGroup(variable));
        return designVariable;
    }

    /**
     * <p>getVariableResetType.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.definition.DRIVariable} object.
     * @return a {@link net.sf.dynamicreports.design.constant.ResetType} object.
     */
    protected ResetType getVariableResetType(DRIVariable<?> variable) {
        return null;
    }

    /**
     * <p>getVariableResetGroup.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.definition.DRIVariable} object.
     * @return a {@link net.sf.dynamicreports.design.base.DRDesignGroup} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRDesignGroup getVariableResetGroup(DRIVariable<?> variable) throws DRException {
        return null;
    }

    private void transformSort(DRISort sort) throws DRException {
        DRIDesignExpression expression = transformExpression(sort.getExpression());
        DRIDesignExpression sortExpression;
        if (expression instanceof DRIDesignField || expression instanceof DRIDesignVariable) {
            sortExpression = expression;
        } else {
            @SuppressWarnings( {"rawtypes", "unchecked"}) DRVariable variable = new DRVariable(sort.getExpression(), Calculation.NOTHING);
            variable.setResetType(Evaluation.NONE);
            sortExpression = transformExpression(variable);
        }

        DRDesignSort designSort = new DRDesignSort();
        designSort.setExpression(sortExpression);
        designSort.setOrderType(sort.getOrderType());

        sorts.add(designSort);
    }

    /**
     * <p>transformPropertyExpression.</p>
     *
     * @param propertyExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression} object.
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignPropertyExpression} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRIDesignPropertyExpression transformPropertyExpression(DRIPropertyExpression propertyExpression) throws DRException {
        DRDesignPropertyExpression designPropertyExpression = new DRDesignPropertyExpression();
        designPropertyExpression.setName(propertyExpression.getName());
        designPropertyExpression.setValueExpression(transformExpression(propertyExpression.getValueExpression()));
        return designPropertyExpression;
    }

    /**
     * <p>transformParameterExpression.</p>
     *
     * @param parameterExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIParameterExpression} object.
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignParameterExpression} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    protected DRIDesignParameterExpression transformParameterExpression(DRIParameterExpression parameterExpression) throws DRException {
        DRDesignParameterExpression designParameterExpression = new DRDesignParameterExpression();
        designParameterExpression.setName(parameterExpression.getName());
        designParameterExpression.setValueExpression(transformExpression(parameterExpression.getValueExpression()));
        return designParameterExpression;
    }

    private DRIDesignExpression addExpression(DRIDesignExpression expression) {
        if (expression == null) {
            return null;
        }
        if (expression instanceof DRIDesignField) {
            return addField((DRIDesignField) expression);
        } else if (expression instanceof DRIDesignVariable) {
            addVariable((DRDesignVariable) expression);
        } else if (expression instanceof DRIDesignSystemExpression) {
            addSystemExpression((DRIDesignSystemExpression) expression);
        } else if (expression instanceof DRIDesignJasperExpression) {
            addJasperExpression((DRIDesignJasperExpression) expression);
        } else if (expression instanceof DRIDesignSimpleExpression) {
            addSimpleExpression((DRIDesignSimpleExpression) expression);
        } else if (expression instanceof DRIDesignComplexExpression) {
            addComplexExpression((DRIDesignComplexExpression) expression);
        } else {
            throw new DRDesignReportException("Expression " + expression.getClass().getName() + " not supported");
        }
        return expression;
    }

    private void addVariable(DRDesignVariable variable) {
        if (variables.containsKey(variable.getName())) {
            if (!variables.get(variable.getName()).equals(variable)) {
                throw new DRDesignReportException("Duplicate declaration of variable \"" + variable.getName() + "\"");
            }
            return;
        }
        variables.put(variable.getName(), variable);
    }

    private DRIDesignField addField(DRIDesignField field) {
        if (fields.containsKey(field.getName())) {
            DRIDesignField fld = fields.get(field.getName());
            if (!fld.getValueClass().equals(field.getValueClass())) {
                throw new DRDesignReportException("Duplicate declaration of field \"" + field.getName() + "\"");
            }
            return fld;
        }
        fields.put(field.getName(), field);
        return field;
    }

    private void addSystemExpression(DRIDesignSystemExpression systemExpression) {
        if (systemExpressions.containsKey(systemExpression.getName())) {
            return;
        }
        systemExpressions.put(systemExpression.getName(), systemExpression);
    }

    private void addJasperExpression(DRIDesignJasperExpression jasperExpression) {
        if (jasperExpressions.containsKey(jasperExpression.getName())) {
            return;
        }
        jasperExpressions.put(jasperExpression.getName(), jasperExpression);
    }

    private void addSimpleExpression(DRIDesignSimpleExpression simpleExpression) {
        if (simpleExpressions.containsKey(simpleExpression.getName())) {
            if (!simpleExpressions.get(simpleExpression.getName()).equals(simpleExpression)) {
                throw new DRDesignReportException("Duplicate declaration of simple expression \"" + simpleExpression.getName() + "\"");
            }
            return;
        }
        simpleExpressions.put(simpleExpression.getName(), simpleExpression);
    }

    private void addComplexExpression(DRIDesignComplexExpression complexExpression) {
        if (complexExpressions.containsKey(complexExpression.getName())) {
            if (!complexExpressions.get(complexExpression.getName()).equals(complexExpression)) {
                throw new DRDesignReportException("Duplicate declaration of complex expression \"" + complexExpression.getName() + "\"");
            }
            return;
        }
        complexExpressions.put(complexExpression.getName(), complexExpression);
    }

    /**
     * <p>Getter for the field <code>fields</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignField> getFields() {
        return fields.values();
    }

    /**
     * <p>Getter for the field <code>variables</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignVariable> getVariables() {
        return variables.values();
    }

    /**
     * <p>Getter for the field <code>systemExpressions</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignSystemExpression> getSystemExpressions() {
        return systemExpressions.values();
    }

    /**
     * <p>Getter for the field <code>jasperExpressions</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignJasperExpression> getJasperExpressions() {
        return jasperExpressions.values();
    }

    /**
     * <p>Getter for the field <code>simpleExpressions</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignSimpleExpression> getSimpleExpressions() {
        return simpleExpressions.values();
    }

    /**
     * <p>Getter for the field <code>complexExpressions</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignComplexExpression> getComplexExpressions() {
        return complexExpressions.values();
    }

    /**
     * <p>Getter for the field <code>sorts</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<DRIDesignSort> getSorts() {
        return sorts;
    }

    /**
     * <p>transformFields.</p>
     *
     * @return a {@link java.util.List} object.
     */
    protected abstract List<? extends DRIField<?>> transformFields();

    /**
     * <p>transformVariables.</p>
     *
     * @return a {@link java.util.List} object.
     */
    protected abstract List<? extends DRIVariable<?>> transformVariables();

    /**
     * <p>transformSorts.</p>
     *
     * @return a {@link java.util.List} object.
     */
    protected abstract List<? extends DRISort> transformSorts();

    /**
     * <p>getDataset.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignDataset} object.
     */
    protected abstract DRIDesignDataset getDataset();
}

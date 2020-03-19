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
package net.sf.dynamicreports.report.base;

import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.definition.DRIVariable;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>DRVariable class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRVariable<T> implements DRIVariable<T> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private String name;
    private DRIExpression<?> valueExpression;
    private DRIExpression<?> initialValueExpression;
    private Calculation calculation;
    private Evaluation resetType;
    private DRGroup resetGroup;

    /**
     * <p>Constructor for DRVariable.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param calculation     a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     */
    public DRVariable(DRIExpression<?> valueExpression, Calculation calculation) {
        this(ReportUtils.generateUniqueName("variable"), valueExpression, calculation);
    }

    /**
     * <p>Constructor for DRVariable.</p>
     *
     * @param name            a {@link java.lang.String} object.
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param calculation     a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     */
    public DRVariable(String name, DRIExpression<?> valueExpression, Calculation calculation) {
        Validate.notEmpty(name, "name must not be empty");
        Validate.notNull(valueExpression, "valueExpression must not be null");
        Validate.notNull(calculation, "calculation must not be null");
        this.name = name;
        this.valueExpression = valueExpression;
        this.calculation = calculation;
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return name;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getInitialValueExpression() {
        return initialValueExpression;
    }

    /**
     * <p>Setter for the field <code>initialValueExpression</code>.</p>
     *
     * @param initialValueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setInitialValueExpression(DRIExpression<?> initialValueExpression) {
        this.initialValueExpression = initialValueExpression;
    }

    /** {@inheritDoc} */
    @Override
    public Calculation getCalculation() {
        return calculation;
    }

    /** {@inheritDoc} */
    @Override
    public Evaluation getResetType() {
        return resetType;
    }

    /**
     * <p>Setter for the field <code>resetType</code>.</p>
     *
     * @param resetType a {@link net.sf.dynamicreports.report.constant.Evaluation} object.
     */
    public void setResetType(Evaluation resetType) {
        this.resetType = resetType;
    }

    /** {@inheritDoc} */
    @Override
    public DRGroup getResetGroup() {
        return resetGroup;
    }

    /**
     * <p>Setter for the field <code>resetGroup</code>.</p>
     *
     * @param resetGroup a {@link net.sf.dynamicreports.report.base.DRGroup} object.
     */
    public void setResetGroup(DRGroup resetGroup) {
        this.resetGroup = resetGroup;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getValueExpression() {
        return valueExpression;
    }

    /** {@inheritDoc} */
    @Override
    @SuppressWarnings("unchecked")
    public Class<? super T> getValueClass() {
        return (Class<? super T>) ReportUtils.getVariableValueClass(getCalculation(), valueExpression.getValueClass());
    }
}

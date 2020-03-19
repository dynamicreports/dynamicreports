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
package net.sf.dynamicreports.report.builder.component;

import net.sf.dynamicreports.report.base.component.DRGenericElement;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIParameterExpression;

/**
 * <p>GenericElementBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class GenericElementBuilder extends DimensionComponentBuilder<GenericElementBuilder, DRGenericElement> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for GenericElementBuilder.</p>
     *
     * @param namespace a {@link java.lang.String} object.
     * @param namespace a {@link java.lang.String} object.
     * @param name      a {@link java.lang.String} object.
     */
    protected GenericElementBuilder(String namespace, String name) {
        super(new DRGenericElement(namespace, name));
    }

    /**
     * <p>addParameter.</p>
     *
     * @param parameterExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIParameterExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.GenericElementBuilder} object.
     */
    public GenericElementBuilder addParameter(DRIParameterExpression parameterExpression) {
        getComponent().addParameterExpression(parameterExpression);
        return this;
    }

    /**
     * <p>addParameter.</p>
     *
     * @param name            a {@link java.lang.String} object.
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.GenericElementBuilder} object.
     */
    public GenericElementBuilder addParameter(String name, DRIExpression<?> valueExpression) {
        getComponent().addParameterExpression(Expressions.parameter(name, valueExpression));
        return this;
    }

    /**
     * <p>addParameter.</p>
     *
     * @param name  a {@link java.lang.String} object.
     * @param value a {@link java.lang.Object} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.GenericElementBuilder} object.
     */
    public GenericElementBuilder addParameter(String name, Object value) {
        getComponent().addParameterExpression(Expressions.parameter(name, value));
        return this;
    }
}

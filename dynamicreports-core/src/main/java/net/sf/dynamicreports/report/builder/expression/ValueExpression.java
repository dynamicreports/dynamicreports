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
package net.sf.dynamicreports.report.builder.expression;

import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import org.apache.commons.lang3.Validate;

/**
 * <p>ValueExpression class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ValueExpression<T> extends AbstractSimpleExpression<T> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private T value;
    private Class<? super T> valueClass;

    @SuppressWarnings("unchecked")
    /**
     * <p>Constructor for ValueExpression.</p>
     *
     * @param value a T object.
     */ public ValueExpression(T value) {
        Validate.notNull(value, "value must not be null");
        this.value = value;
        this.valueClass = (Class<? super T>) value.getClass();
    }

    /**
     * <p>Constructor for ValueExpression.</p>
     *
     * @param value a T object.
     * @param valueClass a {@link java.lang.Class} object.
     */
    public ValueExpression(T value, Class<? super T> valueClass) {
        Validate.notNull(valueClass, "valueClass must not be null");
        this.value = value;
        this.valueClass = valueClass;
    }

    /** {@inheritDoc} */
    @Override
    public T evaluate(ReportParameters reportParameters) {
        return value;
    }

    /** {@inheritDoc} */
    @Override
    public Class<? super T> getValueClass() {
        return valueClass;
    }
}

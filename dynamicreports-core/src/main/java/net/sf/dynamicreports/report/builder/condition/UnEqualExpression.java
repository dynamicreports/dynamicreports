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
package net.sf.dynamicreports.report.builder.condition;

import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRIValue;
import net.sf.dynamicreports.report.definition.ReportParameters;
import org.apache.commons.lang3.Validate;

/**
 * <p>UnEqualExpression class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class UnEqualExpression extends AbstractSimpleExpression<Boolean> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIValue<?> value;
    private Object[] values;

    @SafeVarargs
    /**
     * <p>Constructor for UnEqualExpression.</p>
     *
     * @param value a {@link net.sf.dynamicreports.report.definition.DRIValue} object.
     * @param values a T object.
     * @param <T> a T object.
     */ public <T> UnEqualExpression(DRIValue<T> value, T... values) {
        Validate.notNull(value, "value must not be null");
        Validate.noNullElements(values, "values must not contains null value");
        this.value = value;
        this.values = values;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean evaluate(ReportParameters reportParameters) {
        Object actualValue = reportParameters.getValue(value);
        for (Object value : values) {
            if (value.equals(actualValue)) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<Boolean> getValueClass() {
        return Boolean.class;
    }
}

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
 * <p>Abstract AbstractBetweenValueExpression class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public abstract class AbstractBetweenValueExpression<T extends Number> extends AbstractSimpleExpression<Boolean> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIValue<T> value;
    private Number min;
    private Number max;

    /**
     * <p>Constructor for AbstractBetweenValueExpression.</p>
     *
     * @param value a {@link net.sf.dynamicreports.report.definition.DRIValue} object.
     * @param min a {@link java.lang.Number} object.
     * @param max a {@link java.lang.Number} object.
     */
    public AbstractBetweenValueExpression(DRIValue<T> value, Number min, Number max) {
        Validate.notNull(value, "value must not be null");
        Validate.notNull(min, "min must not be null");
        Validate.notNull(max, "min must not be null");
        Validate.isTrue(min.doubleValue() < max.doubleValue(), "min < max");
        this.value = value;
        this.min = min;
        this.max = max;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean evaluate(ReportParameters reportParameters) {
        Number actualValue = reportParameters.getValue(value);
        if (actualValue != null) {
            return compare(actualValue, min, max);
        }
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public Class<Boolean> getValueClass() {
        return Boolean.class;
    }

    /**
     * <p>compare.</p>
     *
     * @param actualValue a {@link java.lang.Number} object.
     * @param min a {@link java.lang.Number} object.
     * @param max a {@link java.lang.Number} object.
     * @return a {@link java.lang.Boolean} object.
     */
    protected abstract Boolean compare(Number actualValue, Number min, Number max);
}

/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.report.builder.condition;

import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRIValue;
import net.sf.dynamicreports.report.definition.ReportParameters;
import org.apache.commons.lang3.Validate;

/**
 * <p>Abstract AbstractValueExpression class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public abstract class AbstractValueExpression<T extends Number> extends AbstractSimpleExpression<Boolean> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIValue<T> value;
    private Number number;

    /**
     * <p>Constructor for AbstractValueExpression.</p>
     *
     * @param value a {@link net.sf.dynamicreports.report.definition.DRIValue} object.
     * @param number a {@link java.lang.Number} object.
     */
    public AbstractValueExpression(DRIValue<T> value, Number number) {
        Validate.notNull(value, "value must not be null");
        Validate.notNull(number, "number must not be null");
        this.value = value;
        this.number = number;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean evaluate(ReportParameters reportParameters) {
        Number actualValue = reportParameters.getValue(value);
        if (actualValue != null) {
            return compare(actualValue, number);
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
     * @param number a {@link java.lang.Number} object.
     * @return a {@link java.lang.Boolean} object.
     */
    protected abstract Boolean compare(Number actualValue, Number number);
}

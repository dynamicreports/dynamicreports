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

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIParameterExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>ParameterExpression class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ParameterExpression implements DRIParameterExpression {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private String name;
    private DRIExpression<?> valueExpression;

    /**
     * <p>Constructor for ParameterExpression.</p>
     *
     * @param name            a {@link java.lang.String} object.
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public ParameterExpression(String name, DRIExpression<?> valueExpression) {
        Validate.notNull(name, "name must not be null");
        Validate.notNull(valueExpression, "valueExpression must not be null");
        this.name = name;
        this.valueExpression = valueExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <p>Setter for the field <code>name</code>.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIExpression<?> getValueExpression() {
        return valueExpression;
    }

    /**
     * <p>Setter for the field <code>valueExpression</code>.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setValueExpression(DRIExpression<?> valueExpression) {
        this.valueExpression = valueExpression;
    }
}

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
package net.sf.dynamicreports.report.definition.expression;

import net.sf.dynamicreports.report.definition.ReportParameters;

import java.io.Serializable;

/**
 * The purpose of this expression is to format a value only.<br/>
 * For instance, when it is necessary to display a currency next to the value or just show a value in another format.<br/>
 * It can be applied in any report column, group, subtotal, or text field component.
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIValueFormatter<T, U> extends Serializable {

    /**
     * Evaluates the format expression.
     *
     * @param value
     *          the value to be formatted
     * @param reportParameters
     *          access to report fields, variables, parameters, expressions, and other report values
     * @return the formatted value
     */
    public T format(U value, ReportParameters reportParameters);

    /**
     * <p>getValueClass.</p>
     *
     * @return a {@link java.lang.Class} object.
     */
    public Class<T> getValueClass();
}

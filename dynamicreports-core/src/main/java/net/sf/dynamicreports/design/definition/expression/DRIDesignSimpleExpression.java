/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.design.definition.expression;

import net.sf.dynamicreports.report.definition.ReportParameters;

/**
 * <p>DRIDesignSimpleExpression interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRIDesignSimpleExpression extends DRIDesignExpression {

    /**
     * <p>evaluate.</p>
     *
     * @param reportParameters a {@link net.sf.dynamicreports.report.definition.ReportParameters} object.
     * @return a {@link java.lang.Object} object.
     */
    public Object evaluate(ReportParameters reportParameters);

    /**
     * <p>getParameterName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getParameterName();
}

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
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import java.util.List;

/**
 * <p>PercentageExpression class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class PercentageExpression extends AbstractComplexExpression<Double> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for PercentageExpression.</p>
     *
     * @param actualExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param totalExpression  a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public PercentageExpression(DRIExpression<? extends Number> actualExpression, DRIExpression<? extends Number> totalExpression) {
        addExpression(actualExpression);
        addExpression(totalExpression);
    }

    /** {@inheritDoc} */
    @Override
    public Double evaluate(List<?> values, ReportParameters reportParameters) {
        return ((Number) values.get(0)).doubleValue() / ((Number) values.get(1)).doubleValue();
    }
}

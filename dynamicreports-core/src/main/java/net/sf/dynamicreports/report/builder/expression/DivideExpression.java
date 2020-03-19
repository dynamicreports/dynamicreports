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
package net.sf.dynamicreports.report.builder.expression;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import java.math.BigDecimal;

/**
 * <p>DivideExpression class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DivideExpression extends CalculationExpression {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private int scale;

    @SafeVarargs
    /**
     * <p>Constructor for DivideExpression.</p>
     *
     * @param scale a int.
     * @param expressions a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DivideExpression(int scale, DRIExpression<? extends Number>... expressions) {
        super(expressions);
        this.scale = scale;
    }

    /** {@inheritDoc} */
    @Override
    protected BigDecimal calculate(BigDecimal value1, BigDecimal value2) {
        return value1.divide(value2, scale, BigDecimal.ROUND_HALF_UP);
    }
}

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
package net.sf.dynamicreports.report.definition.crosstab;

import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.CrosstabPercentageType;
import net.sf.dynamicreports.report.definition.DRIValue;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRISystemExpression;

/**
 * <p>DRICrosstabVariable interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRICrosstabVariable<T> extends DRISystemExpression<T>, DRIValue<T> {

    /** {@inheritDoc} */
    @Override
    public Class<? super T> getValueClass();

    /**
     * <p>getValueExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<?> getValueExpression();

    /**
     * <p>getCalculation.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.Calculation} object.
     */
    public Calculation getCalculation();

    /**
     * <p>getPercentageType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.CrosstabPercentageType} object.
     */
    public CrosstabPercentageType getPercentageType();
}

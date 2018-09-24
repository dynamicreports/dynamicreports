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
package net.sf.dynamicreports.design.definition.crosstab;

import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.CrosstabPercentageType;

import java.io.Serializable;

/**
 * <p>DRIDesignCrosstabMeasure interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIDesignCrosstabMeasure extends Serializable {

    /**
     * <p>getName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName();

    /**
     * <p>getValueClass.</p>
     *
     * @return a {@link java.lang.Class} object.
     */
    public Class<?> getValueClass();

    /**
     * <p>getValueExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public DRIDesignExpression getValueExpression();

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

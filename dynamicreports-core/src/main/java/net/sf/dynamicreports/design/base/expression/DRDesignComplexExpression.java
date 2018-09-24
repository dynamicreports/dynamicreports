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
package net.sf.dynamicreports.design.base.expression;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.expression.DRIComplexExpression;

import java.util.List;

/**
 * <p>DRDesignComplexExpression class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignComplexExpression extends AbstractDesignComplexExpression {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIComplexExpression<?> complexExpression;
    private String parameterName;

    /**
     * <p>Constructor for DRDesignComplexExpression.</p>
     *
     * @param complexExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIComplexExpression} object.
     * @param parameterName     a {@link java.lang.String} object.
     */
    public DRDesignComplexExpression(DRIComplexExpression<?> complexExpression, String parameterName) {
        this.complexExpression = complexExpression;
        this.parameterName = parameterName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object evaluate(List<?> values, ReportParameters reportParameters) {
        return complexExpression.evaluate(values, reportParameters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?> getValueClass() {
        return complexExpression.getValueClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return complexExpression.getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getParameterName() {
        return parameterName;
    }
}

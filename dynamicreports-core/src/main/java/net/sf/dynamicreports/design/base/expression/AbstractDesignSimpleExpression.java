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

import net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression;
import net.sf.dynamicreports.report.ReportUtils;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>Abstract AbstractDesignSimpleExpression class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public abstract class AbstractDesignSimpleExpression implements DRIDesignSimpleExpression {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private String name;

    /**
     * <p>Constructor for AbstractDesignSimpleExpression.</p>
     */
    protected AbstractDesignSimpleExpression() {
        this(ReportUtils.generateUniqueName("simpleExpression"));
    }

    /**
     * <p>Constructor for AbstractDesignSimpleExpression.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    protected AbstractDesignSimpleExpression(String name) {
        this.name = name;
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return name;
    }

    /** {@inheritDoc} */
    @Override
    public String getParameterName() {
        return null;
    }
}

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

import net.sf.dynamicreports.design.definition.expression.DRIDesignSystemExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRISystemExpression;

/**
 * <p>DRDesignSystemExpression class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignSystemExpression implements DRIDesignSystemExpression {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRISystemExpression<?> systemExpression;

    /**
     * <p>Constructor for DRDesignSystemExpression.</p>
     *
     * @param systemExpression a {@link net.sf.dynamicreports.report.definition.expression.DRISystemExpression} object.
     */
    public DRDesignSystemExpression(DRISystemExpression<?> systemExpression) {
        this.systemExpression = systemExpression;
    }

    /** {@inheritDoc} */
    @Override
    public Class<?> getValueClass() {
        return systemExpression.getValueClass();
    }

    /** {@inheritDoc} */
    @Override
    public String getName() {
        return systemExpression.getName();
    }
}

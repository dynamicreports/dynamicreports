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

import net.sf.dynamicreports.report.base.expression.AbstractSystemExpression;
import net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRICrosstabValue;

/**
 * <p>CrosstabValueExpression class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public final class CrosstabValueExpression<T> extends AbstractSystemExpression<T> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for CrosstabValueExpression.</p>
     *
     * @param group a {@link net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder} object.
     */
    protected CrosstabValueExpression(AbstractCrosstabGroupBuilder<?, ?, ?> group) {
        super(group.getName());
    }

    /**
     * <p>Constructor for CrosstabValueExpression.</p>
     *
     * @param measure a {@link net.sf.dynamicreports.report.definition.DRICrosstabValue} object.
     */
    protected CrosstabValueExpression(DRICrosstabValue<T> measure) {
        super(measure.getName());
    }

    /**
     * <p>Constructor for CrosstabValueExpression.</p>
     *
     * @param measure a {@link net.sf.dynamicreports.report.definition.DRICrosstabValue} object.
     * @param group a {@link net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder} object.
     */
    protected CrosstabValueExpression(DRICrosstabValue<T> measure, AbstractCrosstabGroupBuilder<?, ?, ?> group) {
        super(measure.getName() + "_" + group.getName() + "_ALL");
    }

    /**
     * <p>Constructor for CrosstabValueExpression.</p>
     *
     * @param measure a {@link net.sf.dynamicreports.report.definition.DRICrosstabValue} object.
     * @param rowGroup a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder} object.
     * @param columnGroup a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder} object.
     */
    protected CrosstabValueExpression(DRICrosstabValue<T> measure, CrosstabRowGroupBuilder<?> rowGroup, CrosstabColumnGroupBuilder<?> columnGroup) {
        super(measure.getName() + "_" + rowGroup.getName() + "_" + columnGroup.getName() + "_ALL");
    }
}

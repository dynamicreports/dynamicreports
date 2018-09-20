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
package net.sf.dynamicreports.report.base.chart.dataset;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIGroupedCategoryChartSerie;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>DRGroupedCategoryChartSerie class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRGroupedCategoryChartSerie extends DRCategoryChartSerie implements DRIGroupedCategoryChartSerie {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<?> groupExpression;

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getGroupExpression() {
        return groupExpression;
    }

    /**
     * <p>Setter for the field <code>groupExpression</code>.</p>
     *
     * @param groupExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setGroupExpression(DRIExpression<?> groupExpression) {
        Validate.notNull(groupExpression, "groupExpression must not be null");
        this.groupExpression = groupExpression;
    }
}

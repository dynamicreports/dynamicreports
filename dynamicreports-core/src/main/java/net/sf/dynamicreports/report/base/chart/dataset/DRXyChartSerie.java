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
import net.sf.dynamicreports.report.definition.chart.dataset.DRIXyChartSerie;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>DRXyChartSerie class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class DRXyChartSerie extends DRChartSerie implements DRIXyChartSerie {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<?> xValueExpression;
    private DRIExpression<?> yValueExpression;
    private DRIExpression<?> labelExpression;

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getXValueExpression() {
        return xValueExpression;
    }

    /**
     * <p>Setter for the field <code>xValueExpression</code>.</p>
     *
     * @param xValueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setXValueExpression(DRIExpression<?> xValueExpression) {
        Validate.notNull(xValueExpression, "xValueExpression must not be null");
        this.xValueExpression = xValueExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getYValueExpression() {
        return yValueExpression;
    }

    /**
     * <p>Setter for the field <code>yValueExpression</code>.</p>
     *
     * @param yValueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setYValueExpression(DRIExpression<?> yValueExpression) {
        Validate.notNull(yValueExpression, "yValueExpression must not be null");
        this.yValueExpression = yValueExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getLabelExpression() {
        return labelExpression;
    }

    /**
     * <p>Setter for the field <code>labelExpression</code>.</p>
     *
     * @param labelExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setLabelExpression(DRIExpression<?> labelExpression) {
        this.labelExpression = labelExpression;
    }
}

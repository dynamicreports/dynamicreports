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
package net.sf.dynamicreports.report.base.chart.plot;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.chart.plot.DRIPaintScale;
import org.apache.commons.lang3.Validate;

import java.awt.Paint;

/**
 * <p>DRPaintScale class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRPaintScale implements DRIPaintScale {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private String label;
    private double value;
    private Paint paint;

    /** {@inheritDoc} */
    @Override
    public String getLabel() {
        return label;
    }

    /**
     * <p>Setter for the field <code>label</code>.</p>
     *
     * @param label a {@link java.lang.String} object.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /** {@inheritDoc} */
    @Override
    public double getValue() {
        return value;
    }

    /**
     * <p>Setter for the field <code>value</code>.</p>
     *
     * @param value a double.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /** {@inheritDoc} */
    @Override
    public Paint getPaint() {
        return paint;
    }

    /**
     * <p>Setter for the field <code>paint</code>.</p>
     *
     * @param paint a {@link java.awt.Paint} object.
     */
    public void setPaint(Paint paint) {
        Validate.notNull(paint, "paint must not be null");
        this.paint = paint;
    }

}

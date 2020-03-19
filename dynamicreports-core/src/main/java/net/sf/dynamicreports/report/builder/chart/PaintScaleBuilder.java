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
package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.report.base.chart.plot.DRPaintScale;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.constant.Constants;

import java.awt.Paint;

/**
 * <p>PaintScaleBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class PaintScaleBuilder extends AbstractBuilder<PaintScaleBuilder, DRPaintScale> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for PaintScaleBuilder.</p>
     *
     * @param label a {@link java.lang.String} object.
     * @param value a double.
     * @param paint a {@link java.awt.Paint} object.
     */
    protected PaintScaleBuilder(String label, double value, Paint paint) {
        super(new DRPaintScale());
        getObject().setLabel(label);
        getObject().setValue(value);
        getObject().setPaint(paint);
    }

    /**
     * <p>getPaintScale.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.chart.plot.DRPaintScale} object.
     */
    public DRPaintScale getPaintScale() {
        return build();
    }
}

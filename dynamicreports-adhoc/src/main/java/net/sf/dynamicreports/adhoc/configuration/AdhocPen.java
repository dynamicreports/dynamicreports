/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.adhoc.configuration;

import java.awt.Color;
import java.io.Serializable;

/**
 * <p>AdhocPen class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class AdhocPen implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private Float lineWidth;
    private Color lineColor;

    /**
     * <p>Getter for the field <code>lineWidth</code>.</p>
     *
     * @return a {@link java.lang.Float} object.
     */
    public Float getLineWidth() {
        return lineWidth;
    }

    /**
     * <p>Setter for the field <code>lineWidth</code>.</p>
     *
     * @param lineWidth a {@link java.lang.Float} object.
     */
    public void setLineWidth(Float lineWidth) {
        this.lineWidth = lineWidth;
    }

    /**
     * <p>Getter for the field <code>lineColor</code>.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
    public Color getLineColor() {
        return lineColor;
    }

    /**
     * <p>Setter for the field <code>lineColor</code>.</p>
     *
     * @param lineColor a {@link java.awt.Color} object.
     */
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdhocPen)) {
            return false;
        }

        AdhocPen object = (AdhocPen) obj;
        if (!(lineWidth == null ? object.getLineWidth() == null : lineWidth.equals(object.getLineWidth()))) {
            return false;
        }
        if (!(lineColor == null ? object.getLineColor() == null : lineColor.equals(object.getLineColor()))) {
            return false;
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdhocPen clone() {
        AdhocPen clone;
        try {
            clone = (AdhocPen) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        return clone;
    }

}

/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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
package net.sf.dynamicreports.design.base.chart;

import net.sf.dynamicreports.design.base.style.DRDesignFont;
import net.sf.dynamicreports.design.definition.chart.DRIDesignChartLegend;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Position;

import java.awt.Color;

/**
 * <p>DRDesignChartLegend class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignChartLegend implements DRIDesignChartLegend {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Color color;
    private Color backgroundColor;
    private Boolean showLegend;
    private DRDesignFont font;
    private Position position;

    /**
     * <p>Constructor for DRDesignChartLegend.</p>
     */
    public DRDesignChartLegend() {
    }

    /** {@inheritDoc} */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * <p>Setter for the field <code>color</code>.</p>
     *
     * @param color a {@link java.awt.Color} object.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /** {@inheritDoc} */
    @Override
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * <p>Setter for the field <code>backgroundColor</code>.</p>
     *
     * @param backgroundColor a {@link java.awt.Color} object.
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getShowLegend() {
        return showLegend;
    }

    /**
     * <p>Setter for the field <code>showLegend</code>.</p>
     *
     * @param showLegend a {@link java.lang.Boolean} object.
     */
    public void setShowLegend(Boolean showLegend) {
        this.showLegend = showLegend;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignFont getFont() {
        return font;
    }

    /**
     * <p>Setter for the field <code>font</code>.</p>
     *
     * @param font a {@link net.sf.dynamicreports.design.base.style.DRDesignFont} object.
     */
    public void setFont(DRDesignFont font) {
        this.font = font;
    }

    /** {@inheritDoc} */
    @Override
    public Position getPosition() {
        return position;
    }

    /**
     * <p>Setter for the field <code>position</code>.</p>
     *
     * @param position a {@link net.sf.dynamicreports.report.constant.Position} object.
     */
    public void setPosition(Position position) {
        this.position = position;
    }
}

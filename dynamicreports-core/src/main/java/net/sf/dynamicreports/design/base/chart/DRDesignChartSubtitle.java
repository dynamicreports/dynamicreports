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
package net.sf.dynamicreports.design.base.chart;

import net.sf.dynamicreports.design.base.style.DRDesignFont;
import net.sf.dynamicreports.design.definition.chart.DRIDesignChartSubtitle;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

import java.awt.Color;

/**
 * <p>DRDesignChartSubtitle class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignChartSubtitle implements DRIDesignChartSubtitle {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Color color;
    private DRDesignFont font;
    private DRIDesignExpression title;

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
    public DRIDesignExpression getTitle() {
        return title;
    }

    /**
     * <p>Setter for the field <code>title</code>.</p>
     *
     * @param title a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setTitle(DRIDesignExpression title) {
        this.title = title;
    }
}

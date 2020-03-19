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
package net.sf.dynamicreports.design.base.chart.plot;

import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignMeterInterval;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

import java.awt.Color;

/**
 * <p>DRDesignMeterInterval class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignMeterInterval implements DRIDesignMeterInterval {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private String label;
    private Color backgroundColor;
    private Double alpha;
    private DRIDesignExpression dataRangeLowExpression;
    private DRIDesignExpression dataRangeHighExpression;

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
    public Double getAlpha() {
        return alpha;
    }

    /**
     * <p>Setter for the field <code>alpha</code>.</p>
     *
     * @param alpha a {@link java.lang.Double} object.
     */
    public void setAlpha(Double alpha) {
        this.alpha = alpha;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getDataRangeLowExpression() {
        return dataRangeLowExpression;
    }

    /**
     * <p>Setter for the field <code>dataRangeLowExpression</code>.</p>
     *
     * @param dataRangeLowExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setDataRangeLowExpression(DRIDesignExpression dataRangeLowExpression) {
        this.dataRangeLowExpression = dataRangeLowExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getDataRangeHighExpression() {
        return dataRangeHighExpression;
    }

    /**
     * <p>Setter for the field <code>dataRangeHighExpression</code>.</p>
     *
     * @param dataRangeHighExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setDataRangeHighExpression(DRIDesignExpression dataRangeHighExpression) {
        this.dataRangeHighExpression = dataRangeHighExpression;
    }

}

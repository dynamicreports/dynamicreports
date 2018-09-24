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
package net.sf.dynamicreports.design.base.component;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.component.DRIDesignMap;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignMap class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignMap extends DRDesignComponent implements DRIDesignMap {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private EvaluationTime evaluationTime;
    private DRDesignGroup evaluationGroup;
    private DRIDesignExpression latitudeExpression;
    private DRIDesignExpression longitudeExpression;
    private DRIDesignExpression zoomExpression;

    /**
     * <p>Constructor for DRDesignMap.</p>
     */
    public DRDesignMap() {
        super("map");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EvaluationTime getEvaluationTime() {
        return evaluationTime;
    }

    /**
     * <p>Setter for the field <code>evaluationTime</code>.</p>
     *
     * @param evaluationTime a {@link net.sf.dynamicreports.design.constant.EvaluationTime} object.
     */
    public void setEvaluationTime(EvaluationTime evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRDesignGroup getEvaluationGroup() {
        return evaluationGroup;
    }

    /**
     * <p>Setter for the field <code>evaluationGroup</code>.</p>
     *
     * @param evaluationGroup a {@link net.sf.dynamicreports.design.base.DRDesignGroup} object.
     */
    public void setEvaluationGroup(DRDesignGroup evaluationGroup) {
        this.evaluationGroup = evaluationGroup;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getLatitudeExpression() {
        return latitudeExpression;
    }

    /**
     * <p>Setter for the field <code>latitudeExpression</code>.</p>
     *
     * @param latitudeExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setLatitudeExpression(DRIDesignExpression latitudeExpression) {
        this.latitudeExpression = latitudeExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getLongitudeExpression() {
        return longitudeExpression;
    }

    /**
     * <p>Setter for the field <code>longitudeExpression</code>.</p>
     *
     * @param longitudeExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setLongitudeExpression(DRIDesignExpression longitudeExpression) {
        this.longitudeExpression = longitudeExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getZoomExpression() {
        return zoomExpression;
    }

    /**
     * <p>Setter for the field <code>zoomExpression</code>.</p>
     *
     * @param zoomExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setZoomExpression(DRIDesignExpression zoomExpression) {
        this.zoomExpression = zoomExpression;
    }
}

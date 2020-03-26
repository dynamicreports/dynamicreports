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
package net.sf.dynamicreports.googlecharts.jasper.geomap;

import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.base.JRBaseObjectFactory;
import net.sf.jasperreports.engine.design.JRDesignElementDataset;
import net.sf.jasperreports.engine.util.JRCloneUtils;

/**
 * <p>StandardGeoMapDataset class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class StandardGeoMapDataset extends JRDesignElementDataset implements GeoMapDataset {
    /**
     * Constant <code>PROPERTY_LOCATION_EXPRESSION="locationExpression"</code>
     */
    public static final String PROPERTY_LOCATION_EXPRESSION = "locationExpression";
    /**
     * Constant <code>PROPERTY_VALUE_EXPRESSION="valueExpression"</code>
     */
    public static final String PROPERTY_VALUE_EXPRESSION = "valueExpression";
    /**
     * Constant <code>PROPERTY_LABEL_EXPRESSION="labelExpression"</code>
     */
    public static final String PROPERTY_LABEL_EXPRESSION = "labelExpression";
    private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;
    private JRExpression locationExpression;
    private JRExpression valueExpression;
    private JRExpression labelExpression;

    /**
     * <p>Constructor for StandardGeoMapDataset.</p>
     */
    public StandardGeoMapDataset() {
    }

    /**
     * <p>Constructor for StandardGeoMapDataset.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapDataset} object.
     * @param factory a {@link net.sf.jasperreports.engine.base.JRBaseObjectFactory} object.
     */
    public StandardGeoMapDataset(GeoMapDataset dataset, JRBaseObjectFactory factory) {
        super(dataset, factory);
        this.locationExpression = factory.getExpression(dataset.getLocationExpression());
        this.valueExpression = factory.getExpression(dataset.getValueExpression());
        this.labelExpression = factory.getExpression(dataset.getLabelExpression());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void collectExpressions(JRExpressionCollector collector) {
        GeoMapCompiler.collectExpressions(this, collector);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JRExpression getLocationExpression() {
        return locationExpression;
    }

    /**
     * <p>Setter for the field <code>locationExpression</code>.</p>
     *
     * @param locationExpression a {@link net.sf.jasperreports.engine.JRExpression} object.
     */
    public void setLocationExpression(JRExpression locationExpression) {
        Object old = this.locationExpression;
        this.locationExpression = locationExpression;
        getEventSupport().firePropertyChange(PROPERTY_LOCATION_EXPRESSION, old, this.locationExpression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JRExpression getValueExpression() {
        return valueExpression;
    }

    /**
     * <p>Setter for the field <code>valueExpression</code>.</p>
     *
     * @param valueExpression a {@link net.sf.jasperreports.engine.JRExpression} object.
     */
    public void setValueExpression(JRExpression valueExpression) {
        Object old = this.valueExpression;
        this.valueExpression = valueExpression;
        getEventSupport().firePropertyChange(PROPERTY_VALUE_EXPRESSION, old, this.valueExpression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JRExpression getLabelExpression() {
        return labelExpression;
    }

    /**
     * <p>Setter for the field <code>labelExpression</code>.</p>
     *
     * @param labelExpression a {@link net.sf.jasperreports.engine.JRExpression} object.
     */
    public void setLabelExpression(JRExpression labelExpression) {
        this.labelExpression = labelExpression;

        Object old = this.labelExpression;
        this.labelExpression = labelExpression;
        getEventSupport().firePropertyChange(PROPERTY_LABEL_EXPRESSION, old, this.labelExpression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object clone() {
        StandardGeoMapDataset clone = (StandardGeoMapDataset) super.clone();
        clone.locationExpression = JRCloneUtils.nullSafeClone(locationExpression);
        clone.valueExpression = JRCloneUtils.nullSafeClone(valueExpression);
        clone.labelExpression = JRCloneUtils.nullSafeClone(labelExpression);
        return clone;
    }
}

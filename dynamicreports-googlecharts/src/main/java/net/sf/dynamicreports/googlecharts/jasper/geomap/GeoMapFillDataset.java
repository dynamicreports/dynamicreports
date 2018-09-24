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
package net.sf.dynamicreports.googlecharts.jasper.geomap;

import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRElementDataset;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.fill.JRCalculator;
import net.sf.jasperreports.engine.fill.JRExpressionEvalException;
import net.sf.jasperreports.engine.fill.JRFillElementDataset;
import net.sf.jasperreports.engine.fill.JRFillObjectFactory;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>GeoMapFillDataset class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GeoMapFillDataset extends JRFillElementDataset implements GeoMapDataset {
    private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

    private Set<GeoMapData> dataset;
    private String location;
    private Number value;
    private String label;

    /**
     * <p>Constructor for GeoMapFillDataset.</p>
     *
     * @param dataset a {@link net.sf.jasperreports.engine.JRElementDataset} object.
     * @param factory a {@link net.sf.jasperreports.engine.fill.JRFillObjectFactory} object.
     */
    public GeoMapFillDataset(JRElementDataset dataset, JRFillObjectFactory factory) {
        super(dataset, factory);
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
    protected void customInitialize() {
        dataset = new LinkedHashSet<GeoMapData>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customEvaluate(JRCalculator calculator) throws JRExpressionEvalException {
        location = (String) calculator.evaluate(getLocationExpression());
        value = (Number) calculator.evaluate(getValueExpression());
        label = (String) calculator.evaluate(getLabelExpression());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customIncrement() {
        GeoMapData data = new GeoMapData();
        data.setLocation(location);
        data.setValue(value);
        data.setLabel(label);
        dataset.add(data);
    }

    /**
     * <p>getCustomDataset.</p>
     *
     * @return a {@link java.util.Set} object.
     */
    public Set<GeoMapData> getCustomDataset() {
        return dataset;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JRExpression getLocationExpression() {
        return ((GeoMapDataset) parent).getLocationExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JRExpression getValueExpression() {
        return ((GeoMapDataset) parent).getValueExpression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JRExpression getLabelExpression() {
        return ((GeoMapDataset) parent).getLabelExpression();
    }

    /**
     * <p>finishDataset.</p>
     */
    public void finishDataset() {
        increment();
    }
}

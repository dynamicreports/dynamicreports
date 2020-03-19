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
package net.sf.dynamicreports.googlecharts.report.geomap;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapPrintElement;
import net.sf.dynamicreports.report.constant.Constants;

import java.awt.Color;
import java.util.List;

/**
 * <p>DRDesignGeoMap class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignGeoMap extends DRDesignComponent implements DRIDesignGeoMap {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private EvaluationTime evaluationTime;
    private DRDesignGroup evaluationGroup;
    private Boolean showLegend;
    private GeoMapDataMode dataMode;
    private DRIDesignExpression regionExpression;
    private DRIDesignExpression valueLabelExpression;
    private List<Color> colors;
    private DRDesignGeoMapDataset dataset;

    /**
     * <p>Constructor for DRDesignGeoMap.</p>
     */
    public DRDesignGeoMap() {
        super(GeoMapPrintElement.GEOMAP_ELEMENT_NAME);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public GeoMapDataMode getDataMode() {
        return dataMode;
    }

    /**
     * <p>Setter for the field <code>dataMode</code>.</p>
     *
     * @param dataMode a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapDataMode} object.
     */
    public void setDataMode(GeoMapDataMode dataMode) {
        this.dataMode = dataMode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getRegionExpression() {
        return regionExpression;
    }

    /**
     * <p>Setter for the field <code>regionExpression</code>.</p>
     *
     * @param regionExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setRegionExpression(DRIDesignExpression regionExpression) {
        this.regionExpression = regionExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getValueLabelExpression() {
        return valueLabelExpression;
    }

    /**
     * <p>Setter for the field <code>valueLabelExpression</code>.</p>
     *
     * @param valueLabelExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setValueLabelExpression(DRIDesignExpression valueLabelExpression) {
        this.valueLabelExpression = valueLabelExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Color> getColors() {
        return colors;
    }

    /**
     * <p>Setter for the field <code>colors</code>.</p>
     *
     * @param colors a {@link java.util.List} object.
     */
    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRDesignGeoMapDataset getDataset() {
        return dataset;
    }

    /**
     * <p>Setter for the field <code>dataset</code>.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.googlecharts.report.geomap.DRDesignGeoMapDataset} object.
     */
    public void setDataset(DRDesignGeoMapDataset dataset) {
        this.dataset = dataset;
    }
}

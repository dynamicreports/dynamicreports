/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.googlecharts.report.geomap;

import net.sf.dynamicreports.report.base.component.DRDimensionComponent;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRGeoMap class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRGeoMap extends DRDimensionComponent implements DRIGeoMap {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Boolean showLegend;
    private GeoMapDataMode dataMode;
    private DRIExpression<String> regionExpression;
    private DRIExpression<String> valueLabelExpression;
    private List<Color> colors;
    private DRGeoMapDataset dataset;

    /**
     * <p>Constructor for DRGeoMap.</p>
     */
    public DRGeoMap() {
        dataset = new DRGeoMapDataset();
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
    public DRIExpression<String> getRegionExpression() {
        return regionExpression;
    }

    /**
     * <p>Setter for the field <code>regionExpression</code>.</p>
     *
     * @param regionExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setRegionExpression(DRIExpression<String> regionExpression) {
        this.regionExpression = regionExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIExpression<String> getValueLabelExpression() {
        return valueLabelExpression;
    }

    /**
     * <p>Setter for the field <code>valueLabelExpression</code>.</p>
     *
     * @param valueLabelExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setValueLabelExpression(DRIExpression<String> valueLabelExpression) {
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
     * <p>addColor.</p>
     *
     * @param color a {@link java.awt.Color} object.
     */
    public void addColor(Color color) {
        if (colors == null) {
            colors = new ArrayList<Color>();
        }
        colors.add(color);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRGeoMapDataset getDataset() {
        return dataset;
    }

    /**
     * <p>Setter for the field <code>dataset</code>.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.googlecharts.report.geomap.DRGeoMapDataset} object.
     */
    public void setDataset(DRGeoMapDataset dataset) {
        this.dataset = dataset;
    }
}

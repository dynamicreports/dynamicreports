/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General License for more details.
 *
 * You should have received a copy of the GNU Lesser General License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.dynamicreports.googlecharts.report.geomap;

import net.sf.dynamicreports.report.component.DRICustomComponent;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import java.awt.Color;
import java.util.List;

/**
 * <p>DRIGeoMap interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRIGeoMap extends DRICustomComponent {

    /**
     * <p>getShowLegend.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    Boolean getShowLegend();

    /**
     * <p>getDataMode.</p>
     *
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapDataMode} object.
     */
    GeoMapDataMode getDataMode();

    /**
     * <p>getRegionExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    DRIExpression<String> getRegionExpression();

    /**
     * <p>getValueLabelExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    DRIExpression<String> getValueLabelExpression();

    /**
     * <p>getColors.</p>
     *
     * @return a {@link java.util.List} object.
     */
    List<Color> getColors();

    /**
     * <p>getDataset.</p>
     *
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.DRIGeoMapDataset} object.
     */
    DRIGeoMapDataset getDataset();
}

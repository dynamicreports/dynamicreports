/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
 * http://www.dynamicreports.org
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
package net.sf.dynamicreports.googlecharts.jasper.geomap;

import net.sf.dynamicreports.googlecharts.report.geomap.GeoMapDataMode;
import net.sf.jasperreports.engine.JRCloneable;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.component.Component;
import net.sf.jasperreports.engine.type.EvaluationTimeEnum;

import java.awt.Color;
import java.util.List;

/**
 * <p>GeoMapComponent interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public interface GeoMapComponent extends Component, JRCloneable {

    /**
     * <p>getEvaluationTime.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.type.EvaluationTimeEnum} object.
     */
    EvaluationTimeEnum getEvaluationTime();

    /**
     * <p>getEvaluationGroup.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    String getEvaluationGroup();

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
     * @return a {@link net.sf.jasperreports.engine.JRExpression} object.
     */
    JRExpression getRegionExpression();

    /**
     * <p>getValueLabelExpression.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.JRExpression} object.
     */
    JRExpression getValueLabelExpression();

    /**
     * <p>getColors.</p>
     *
     * @return a {@link java.util.List} object.
     */
    List<Color> getColors();

    /**
     * <p>getDataset.</p>
     *
     * @return a {@link net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapDataset} object.
     */
    GeoMapDataset getDataset();
}

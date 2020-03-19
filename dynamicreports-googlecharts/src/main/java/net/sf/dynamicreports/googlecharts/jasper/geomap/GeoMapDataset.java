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
package net.sf.dynamicreports.googlecharts.jasper.geomap;

import net.sf.jasperreports.engine.JRElementDataset;
import net.sf.jasperreports.engine.JRExpression;

import java.io.Serializable;

/**
 * <p>GeoMapDataset interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface GeoMapDataset extends JRElementDataset, Serializable {

    /**
     * <p>getLocationExpression.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.JRExpression} object.
     */
    JRExpression getLocationExpression();

    /**
     * <p>getValueExpression.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.JRExpression} object.
     */
    JRExpression getValueExpression();

    /**
     * <p>getLabelExpression.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.JRExpression} object.
     */
    JRExpression getLabelExpression();

}

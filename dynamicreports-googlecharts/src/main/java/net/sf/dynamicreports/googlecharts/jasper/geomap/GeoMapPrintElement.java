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

import net.sf.dynamicreports.googlecharts.jasper.GoogleChartsExtensionsRegistryFactory;
import net.sf.jasperreports.engine.JRGenericElementType;

/**
 * <p>GeoMapPrintElement class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class GeoMapPrintElement {
    /**
     * Constant <code>GEOMAP_ELEMENT_NAME="geoMap"</code>
     */
    public static final String GEOMAP_ELEMENT_NAME = "geoMap";
    /**
     * Constant <code>GEOMAP_ELEMENT_TYPE</code>
     */
    public static final JRGenericElementType GEOMAP_ELEMENT_TYPE = new JRGenericElementType(GoogleChartsExtensionsRegistryFactory.NAMESPACE, GEOMAP_ELEMENT_NAME);

    /**
     * Constant <code>PARAMETER_SHOW_LEGEND="showLegend"</code>
     */
    public static final String PARAMETER_SHOW_LEGEND = "showLegend";
    /**
     * Constant <code>PARAMETER_DATA_MODE="dataMode"</code>
     */
    public static final String PARAMETER_DATA_MODE = "dataMode";
    /**
     * Constant <code>PARAMETER_REGION="region"</code>
     */
    public static final String PARAMETER_REGION = "region";
    /**
     * Constant <code>PARAMETER_VALUE_LABEL="valueLabel"</code>
     */
    public static final String PARAMETER_VALUE_LABEL = "valueLabel";
    /**
     * Constant <code>PARAMETER_COLORS="colors"</code>
     */
    public static final String PARAMETER_COLORS = "colors";
    /**
     * Constant <code>PARAMETER_DATASET="dataset"</code>
     */
    public static final String PARAMETER_DATASET = "dataset";
}

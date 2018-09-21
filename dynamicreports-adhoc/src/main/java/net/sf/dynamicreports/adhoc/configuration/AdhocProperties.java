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
package net.sf.dynamicreports.adhoc.configuration;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>AdhocProperties class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class AdhocProperties implements Cloneable, Serializable {
    /** Constant <code>PROPERTY_PREFIX="net.sf.dynamicreports."</code> */
    public static final String PROPERTY_PREFIX = "net.sf.dynamicreports.";
    /** Constant <code>CHART_USE_SERIES_AS_CATEGORY="PROPERTY_PREFIX + chart.useseriesascate"{trunked}</code> */
    public static final String CHART_USE_SERIES_AS_CATEGORY = PROPERTY_PREFIX + "chart.useseriesascategory";
    /** Constant <code>CHART_SHOW_VALUES="PROPERTY_PREFIX + chart.showvalues"</code> */
    public static final String CHART_SHOW_VALUES = PROPERTY_PREFIX + "chart.showvalues";
    /** Constant <code>CHART_SHOW_PERCENTAGES="PROPERTY_PREFIX + chart.showpercentages"</code> */
    public static final String CHART_SHOW_PERCENTAGES = PROPERTY_PREFIX + "chart.showpercentages";
    /** Constant <code>CHART_TIME_PERIOD="PROPERTY_PREFIX + chart.timeperiod"</code> */
    public static final String CHART_TIME_PERIOD = PROPERTY_PREFIX + "chart.timeperiod";
    /** Constant <code>CHART_SERIES_GROUP="PROPERTY_PREFIX + chart.seriesgroup"</code> */
    public static final String CHART_SERIES_GROUP = PROPERTY_PREFIX + "chart.seriesgroup";
    private static final long serialVersionUID = 1L;
    private Map<String, Object> properties;

    /**
     * <p>Constructor for AdhocProperties.</p>
     */
    public AdhocProperties() {
        properties = new HashMap<String, Object>();
    }

    /**
     * <p>Getter for the field <code>properties</code>.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, Object> getProperties() {
        return properties;
    }

    /**
     * <p>Setter for the field <code>properties</code>.</p>
     *
     * @param properties a {@link java.util.Map} object.
     */
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    /**
     * <p>getProperty.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @param <T> a T object.
     * @return a T object.
     */
    @SuppressWarnings("unchecked")
    public <T> T getProperty(String key) {
        return (T) this.properties.get(key);
    }

    /**
     * <p>setProperty.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @param value a {@link java.lang.Object} object.
     */
    public void setProperty(String key, Object value) {
        this.properties.put(key, value);
    }

    /**
     * <p>isEmpty.</p>
     *
     * @return a boolean.
     */
    public boolean isEmpty() {
        return properties.isEmpty();
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdhocProperties)) {
            return false;
        }

        AdhocProperties object = (AdhocProperties) obj;
        if (!(properties == null ? object.getProperties() == null : properties.equals(object.getProperties()))) {
            return false;
        }

        return true;
    }

    /** {@inheritDoc} */
    @Override
    public AdhocProperties clone() {
        AdhocProperties clone;
        try {
            clone = (AdhocProperties) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        if (properties != null) {
            clone.properties = new HashMap<String, Object>();
            for (String key : properties.keySet()) {
                clone.setProperty(key, properties.get(key));
            }
        }

        return clone;
    }

}

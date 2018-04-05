/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class AdhocProperties implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	public static final String PROPERTY_PREFIX = "net.sf.dynamicreports.";
	public static final String CHART_USE_SERIES_AS_CATEGORY = PROPERTY_PREFIX + "chart.useseriesascategory";
	public static final String CHART_SHOW_VALUES = PROPERTY_PREFIX + "chart.showvalues";
	public static final String CHART_SHOW_PERCENTAGES = PROPERTY_PREFIX + "chart.showpercentages";
	public static final String CHART_TIME_PERIOD = PROPERTY_PREFIX + "chart.timeperiod";
	public static final String CHART_SERIES_GROUP = PROPERTY_PREFIX + "chart.seriesgroup";

	private Map<String, Object> properties;

	public AdhocProperties() {
		properties = new HashMap<String, Object>();
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	@SuppressWarnings("unchecked")
	public <T> T getProperty(String key) {
		return (T) this.properties.get(key);
	}

	public void setProperty(String key, Object value) {
		this.properties.put(key, value);
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public boolean isEmpty() {
		return properties.isEmpty();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (!(obj instanceof AdhocProperties))
			return false;

		AdhocProperties object = (AdhocProperties) obj;
		if (!(properties == null ? object.getProperties() == null : properties.equals(object.getProperties()))) {
			return false;
		}

		return true;
	}

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

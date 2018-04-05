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

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class AdhocChartSerie implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private String series;
	private String xValue;
	private String yValue;
	private String zValue;
	private String label;
	private AdhocProperties properties;

	public AdhocChartSerie() {
		properties = new AdhocProperties();
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getXValue() {
		return xValue;
	}

	public void setXValue(String xValue) {
		this.xValue = xValue;
	}

	public String getYValue() {
		return yValue;
	}

	public void setYValue(String yValue) {
		this.yValue = yValue;
	}

	public String getZValue() {
		return zValue;
	}

	public void setZValue(String zValue) {
		this.zValue = zValue;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public AdhocProperties getProperties() {
		return properties;
	}

	public <T> T getProperty(String key) {
		return this.properties.getProperty(key);
	}

	public void setProperty(String key, Object value) {
		this.properties.setProperty(key, value);
	}

	public void setProperties(AdhocProperties properties) {
		this.properties = properties;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null)
			return false;
		if (!(obj instanceof AdhocChartSerie))
			return false;

		AdhocChartSerie object = (AdhocChartSerie) obj;
		if (!(series == null ? object.getSeries() == null : series.equals(object.getSeries()))) {
			return false;
		}
		if (!(xValue == null ? object.getXValue() == null : xValue.equals(object.getXValue()))) {
			return false;
		}
		if (!(yValue == null ? object.getYValue() == null : yValue.equals(object.getYValue()))) {
			return false;
		}
		if (!(zValue == null ? object.getZValue() == null : zValue.equals(object.getZValue()))) {
			return false;
		}
		if (!(label == null ? object.getLabel() == null : label.equals(object.getLabel()))) {
			return false;
		}
		if (!(properties == null ? object.getProperties() == null : properties.equals(object.getProperties()))) {
			return false;
		}

		return true;
	}

	@Override
	public AdhocChartSerie clone() {
		AdhocChartSerie clone;
		try {
			clone = (AdhocChartSerie) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

		if (properties != null) {
			clone.properties = properties.clone();
		}

		return clone;
	}

}

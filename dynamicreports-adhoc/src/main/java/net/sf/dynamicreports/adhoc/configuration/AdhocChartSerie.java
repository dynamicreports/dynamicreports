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
 * <p>AdhocChartSerie class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class AdhocChartSerie implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private String series;
	private String xValue;
	private String yValue;
	private String zValue;
	private String label;
	private AdhocProperties properties;

	/**
	 * <p>Constructor for AdhocChartSerie.</p>
	 */
	public AdhocChartSerie() {
		properties = new AdhocProperties();
	}

	/**
	 * <p>Getter for the field <code>series</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * <p>Setter for the field <code>series</code>.</p>
	 *
	 * @param series a {@link java.lang.String} object.
	 */
	public void setSeries(String series) {
		this.series = series;
	}

	/**
	 * <p>Getter for the field <code>xValue</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getXValue() {
		return xValue;
	}

	/**
	 * <p>Setter for the field <code>xValue</code>.</p>
	 *
	 * @param xValue a {@link java.lang.String} object.
	 */
	public void setXValue(String xValue) {
		this.xValue = xValue;
	}

	/**
	 * <p>Getter for the field <code>yValue</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getYValue() {
		return yValue;
	}

	/**
	 * <p>Setter for the field <code>yValue</code>.</p>
	 *
	 * @param yValue a {@link java.lang.String} object.
	 */
	public void setYValue(String yValue) {
		this.yValue = yValue;
	}

	/**
	 * <p>Getter for the field <code>zValue</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getZValue() {
		return zValue;
	}

	/**
	 * <p>Setter for the field <code>zValue</code>.</p>
	 *
	 * @param zValue a {@link java.lang.String} object.
	 */
	public void setZValue(String zValue) {
		this.zValue = zValue;
	}

	/**
	 * <p>Getter for the field <code>label</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <p>Setter for the field <code>label</code>.</p>
	 *
	 * @param label a {@link java.lang.String} object.
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * <p>Getter for the field <code>properties</code>.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocProperties} object.
	 */
	public AdhocProperties getProperties() {
		return properties;
	}

	/**
	 * <p>getProperty.</p>
	 *
	 * @param key a {@link java.lang.String} object.
	 * @param <T> a T object.
	 * @return a T object.
	 */
	public <T> T getProperty(String key) {
		return this.properties.getProperty(key);
	}

	/**
	 * <p>setProperty.</p>
	 *
	 * @param key a {@link java.lang.String} object.
	 * @param value a {@link java.lang.Object} object.
	 */
	public void setProperty(String key, Object value) {
		this.properties.setProperty(key, value);
	}

	/**
	 * <p>Setter for the field <code>properties</code>.</p>
	 *
	 * @param properties a {@link net.sf.dynamicreports.adhoc.configuration.AdhocProperties} object.
	 */
	public void setProperties(AdhocProperties properties) {
		this.properties = properties;
	}

	/** {@inheritDoc} */
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

	/** {@inheritDoc} */
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

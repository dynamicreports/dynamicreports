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
public class AdhocRestriction implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	private String key;
	private AdhocProperties properties;

	public AdhocRestriction() {
		properties = new AdhocProperties();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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
		if (!(obj instanceof AdhocRestriction))
			return false;

		AdhocRestriction object = (AdhocRestriction) obj;
		if (!(key == null ? object.getKey() == null : key.equals(object.getKey()))) {
			return false;
		}
		if (!(properties == null ? object.getProperties() == null : properties.equals(object.getProperties()))) {
			return false;
		}

		return true;
	}

	@Override
	public AdhocRestriction clone() {
		AdhocRestriction clone;
		try {
			clone = (AdhocRestriction) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}

		if (properties != null) {
			clone.properties = properties.clone();
		}

		return clone;
	}

}

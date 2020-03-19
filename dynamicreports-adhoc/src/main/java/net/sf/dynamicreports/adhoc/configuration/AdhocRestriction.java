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

/**
 * <p>AdhocRestriction class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class AdhocRestriction implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String key;
    private AdhocProperties properties;

    /**
     * <p>Constructor for AdhocRestriction.</p>
     */
    public AdhocRestriction() {
        properties = new AdhocProperties();
    }

    /**
     * <p>Getter for the field <code>key</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getKey() {
        return key;
    }

    /**
     * <p>Setter for the field <code>key</code>.</p>
     *
     * @param key a {@link java.lang.String} object.
     */
    public void setKey(String key) {
        this.key = key;
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
     * <p>Setter for the field <code>properties</code>.</p>
     *
     * @param properties a {@link net.sf.dynamicreports.adhoc.configuration.AdhocProperties} object.
     */
    public void setProperties(AdhocProperties properties) {
        this.properties = properties;
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
     * @param key   a {@link java.lang.String} object.
     * @param value a {@link java.lang.Object} object.
     */
    public void setProperty(String key, Object value) {
        this.properties.setProperty(key, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdhocRestriction)) {
            return false;
        }

        AdhocRestriction object = (AdhocRestriction) obj;
        if (!(key == null ? object.getKey() == null : key.equals(object.getKey()))) {
            return false;
        }
        if (!(properties == null ? object.getProperties() == null : properties.equals(object.getProperties()))) {
            return false;
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
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

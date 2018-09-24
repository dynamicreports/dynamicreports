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
package net.sf.dynamicreports.design.base;

import net.sf.dynamicreports.design.definition.DRIDesignParameter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignParameter class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignParameter implements DRIDesignParameter {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private String name;
    private Class<?> valueClass;
    private Object value;
    private boolean external;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <p>Setter for the field <code>name</code>.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?> getValueClass() {
        return valueClass;
    }

    /**
     * <p>Setter for the field <code>valueClass</code>.</p>
     *
     * @param valueClass a {@link java.lang.Class} object.
     */
    public void setValueClass(Class<?> valueClass) {
        this.valueClass = valueClass;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getValue() {
        return value;
    }

    /**
     * <p>Setter for the field <code>value</code>.</p>
     *
     * @param value a {@link java.lang.Object} object.
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExternal() {
        return external;
    }

    /**
     * <p>Setter for the field <code>external</code>.</p>
     *
     * @param external a boolean.
     */
    public void setExternal(boolean external) {
        this.external = external;
    }
}

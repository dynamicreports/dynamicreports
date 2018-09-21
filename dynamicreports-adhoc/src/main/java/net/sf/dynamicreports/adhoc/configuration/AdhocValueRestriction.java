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

import java.util.ArrayList;
import java.util.List;

/**
 * <p>AdhocValueRestriction class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class AdhocValueRestriction extends AdhocRestriction {
    private static final long serialVersionUID = 1L;

    private String name;
    private AdhocValueOperator operator;
    private List<String> values;

    /**
     * <p>Constructor for AdhocValueRestriction.</p>
     */
    public AdhocValueRestriction() {
        values = new ArrayList<String>();
    }

    /**
     * <p>Getter for the field <code>name</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
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
     * <p>Getter for the field <code>operator</code>.</p>
     *
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocValueOperator} object.
     */
    public AdhocValueOperator getOperator() {
        return operator;
    }

    /**
     * <p>Setter for the field <code>operator</code>.</p>
     *
     * @param operator a {@link net.sf.dynamicreports.adhoc.configuration.AdhocValueOperator} object.
     */
    public void setOperator(AdhocValueOperator operator) {
        this.operator = operator;
    }

    /**
     * <p>Getter for the field <code>values</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<String> getValues() {
        return values;
    }

    /**
     * <p>Setter for the field <code>values</code>.</p>
     *
     * @param values a {@link java.util.List} object.
     */
    public void setValues(List<String> values) {
        this.values = values;
    }

    /**
     * <p>addValue.</p>
     *
     * @param value a {@link java.lang.String} object.
     */
    public void addValue(String value) {
        this.values.add(value);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        boolean equals = super.equals(obj);
        if (!equals) {
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdhocValueRestriction)) {
            return false;
        }

        AdhocValueRestriction object = (AdhocValueRestriction) obj;
        if (!(name == null ? object.getName() == null : name.equals(object.getName()))) {
            return false;
        }
        if (!(operator == null ? object.getOperator() == null : operator.equals(object.getOperator()))) {
            return false;
        }
        if (!(values == null ? object.getValues() == null : values.equals(object.getValues()))) {
            return false;
        }

        return true;
    }

    /** {@inheritDoc} */
    @Override
    public AdhocValueRestriction clone() {
        AdhocValueRestriction clone = (AdhocValueRestriction) super.clone();

        if (values != null) {
            clone.values = new ArrayList<String>();
            for (String value : values) {
                clone.addValue(value);
            }
        }

        return clone;
    }

}

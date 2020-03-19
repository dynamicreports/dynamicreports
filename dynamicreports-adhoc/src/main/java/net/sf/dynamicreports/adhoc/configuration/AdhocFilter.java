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
import java.util.ArrayList;
import java.util.List;

/**
 * <p>AdhocFilter class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class AdhocFilter implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private List<AdhocRestriction> restrictions;

    /**
     * <p>Constructor for AdhocFilter.</p>
     */
    public AdhocFilter() {
        restrictions = new ArrayList<AdhocRestriction>();
    }

    /**
     * <p>Getter for the field <code>restrictions</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<AdhocRestriction> getRestrictions() {
        return restrictions;
    }

    /**
     * <p>Setter for the field <code>restrictions</code>.</p>
     *
     * @param restrictions a {@link java.util.List} object.
     */
    public void setRestrictions(List<AdhocRestriction> restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * <p>getRestriction.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.adhoc.configuration.AdhocRestriction} object.
     */
    public AdhocRestriction getRestriction(String key) {
        if (restrictions == null) {
            return null;
        }

        for (AdhocRestriction restriction : restrictions) {
            if (key.equals(restriction.getKey())) {
                return restriction;
            }
        }
        return null;
    }

    /**
     * <p>addRestriction.</p>
     *
     * @param restriction a {@link net.sf.dynamicreports.adhoc.configuration.AdhocRestriction} object.
     */
    public void addRestriction(AdhocRestriction restriction) {
        this.restrictions.add(restriction);
    }

    /**
     * <p>setRestriction.</p>
     *
     * @param key         a {@link java.lang.String} object.
     * @param restriction a {@link net.sf.dynamicreports.adhoc.configuration.AdhocRestriction} object.
     */
    public void setRestriction(String key, AdhocRestriction restriction) {
        int index = -1;
        for (AdhocRestriction cmp : restrictions) {
            if (key.equals(cmp.getKey())) {
                index = restrictions.indexOf(cmp);
                break;
            }
        }
        if (index != -1) {
            restrictions.set(index, restriction);
        } else {
            addRestriction(restriction);
        }
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
        if (!(obj instanceof AdhocFilter)) {
            return false;
        }

        AdhocFilter object = (AdhocFilter) obj;
        if (!(restrictions == null ? object.getRestrictions() == null : restrictions.equals(object.getRestrictions()))) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return getRestrictions() != null ? getRestrictions().hashCode() : 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdhocFilter clone() {
        AdhocFilter clone;
        try {
            clone = (AdhocFilter) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        if (restrictions != null) {
            clone.restrictions = new ArrayList<AdhocRestriction>();
            for (AdhocRestriction adhocRestriction : restrictions) {
                clone.addRestriction(adhocRestriction.clone());
            }
        }

        return clone;
    }

}

/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.adhoc.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>AdhocFilter class.</p>
 *
 * This class manages a collection of AdhocRestriction objects which can then be added dynamically at runtime.
 * The methods enable you to
 * <br> a) fetch the whole collection of AdhocRestriction as a list
 * <br> b) add an AdhocRestriction
 * <br> c) add a restriction with a key
 * <br> d) add a collection of restrictions
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
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
     * @param key a {@link java.lang.String} object.
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
     * <p>Setter for the field <code>restrictions</code>.</p>
     *
     * @param restrictions a {@link java.util.List} object.
     */
    public void setRestrictions(List<AdhocRestriction> restrictions) {
        this.restrictions = restrictions;
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
        if (!(obj instanceof AdhocFilter)) {
            return false;
        }

        AdhocFilter object = (AdhocFilter) obj;
        if (!(restrictions == null ? object.getRestrictions() == null : restrictions.equals(object.getRestrictions()))) {
            return false;
        }

        return true;
    }

    /** {@inheritDoc} */
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

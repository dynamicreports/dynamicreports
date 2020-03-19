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
package net.sf.dynamicreports.report.builder;

import net.sf.dynamicreports.report.constant.Constants;

import java.io.Serializable;

/**
 * <p>Abstract AbstractBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public abstract class AbstractBuilder<T extends AbstractBuilder<T, U>, U> implements Serializable {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
    protected boolean builded;
    private U object;

    /**
     * <p>Constructor for AbstractBuilder.</p>
     *
     * @param object a U object.
     */
    protected AbstractBuilder(U object) {
        this.object = object;
        this.builded = false;
    }

    /**
     * <p>build.</p>
     *
     * @return a U object.
     */
    public U build() {
        if (!builded) {
            configure();
            builded = true;
        }
        return object;
    }

    /**
     * <p>Getter for the field <code>object</code>.</p>
     *
     * @return a U object.
     */
    protected U getObject() {
        return object;
    }

    /**
     * <p>configure.</p>
     */
    protected void configure() {
    }
}

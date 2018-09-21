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

import net.sf.dynamicreports.report.base.DRParameter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>ParameterBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ParameterBuilder<T> extends AbstractBuilder<ParameterBuilder<T>, DRParameter<T>> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for ParameterBuilder.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param value a T object.
     */
    protected ParameterBuilder(String name, T value) {
        super(new DRParameter<T>(name, value));
    }

    /**
     * <p>Constructor for ParameterBuilder.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     */
    protected ParameterBuilder(String name, Class<T> valueClass) {
        super(new DRParameter<T>(name, valueClass));
    }

    /**
     * <p>getParameter.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.DRParameter} object.
     */
    public DRParameter<T> getParameter() {
        return build();
    }
}

/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.jasper.base;

/**
 * Interface for managers of {@link JasperScriptlet} used in {@link JasperCustomValues}.
 */
public interface JasperScriptletManager {

    /**
     * Property key used for selecting thread safe implementation.
     */
    public static final String USE_THREAD_SAFE_SCRIPLET_MANAGER_PROPERTY_KEY = "net.sf.dynamicreports.useThreadSafeScriptletManager";

    /**
     * Getter for the {@link JasperScriptlet} instance.
     *
     * @return the set {@link JasperScriptlet} instance
     */
    JasperScriptlet getJasperScriptlet();

    /**
     * Setter for the {@link JasperScriptlet} instance.
     *
     * @param jasperScriptlet the {@link JasperScriptlet} instance to set
     */
    void setJasperScriptlet(JasperScriptlet jasperScriptlet);
}

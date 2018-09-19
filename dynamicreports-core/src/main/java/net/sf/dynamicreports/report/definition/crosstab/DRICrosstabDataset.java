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

package net.sf.dynamicreports.report.definition.crosstab;

import net.sf.dynamicreports.report.definition.DRIDataset;

import java.io.Serializable;

/**
 * <p>DRICrosstabDataset interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRICrosstabDataset extends Serializable {

    /**
     * <p>getSubDataset.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIDataset} object.
     */
    public DRIDataset getSubDataset();

    /**
     * <p>getDataPreSorted.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getDataPreSorted();
}

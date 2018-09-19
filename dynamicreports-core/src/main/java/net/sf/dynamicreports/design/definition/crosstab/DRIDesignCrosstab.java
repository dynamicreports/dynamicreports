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

package net.sf.dynamicreports.design.definition.crosstab;

import net.sf.dynamicreports.design.definition.component.DRIDesignComponent;
import net.sf.dynamicreports.report.constant.RunDirection;

import java.util.List;

/**
 * <p>DRIDesignCrosstab interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIDesignCrosstab extends DRIDesignComponent {

    /**
     * <p>getDataset.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabDataset} object.
     */
    public DRIDesignCrosstabDataset getDataset();

    /**
     * <p>isRepeatColumnHeaders.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean isRepeatColumnHeaders();

    /**
     * <p>isRepeatRowHeaders.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean isRepeatRowHeaders();

    /**
     * <p>getColumnBreakOffset.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getColumnBreakOffset();

    /**
     * <p>getIgnoreWidth.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnoreWidth();

    /**
     * <p>getRunDirection.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.RunDirection} object.
     */
    public RunDirection getRunDirection();

    /**
     * <p>getWhenNoDataCell.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabCellContent} object.
     */
    public DRIDesignCrosstabCellContent getWhenNoDataCell();

    /**
     * <p>getHeaderCell.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabCellContent} object.
     */
    public DRIDesignCrosstabCellContent getHeaderCell();

    /**
     * <p>getColumnGroups.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<? extends DRIDesignCrosstabColumnGroup> getColumnGroups();

    /**
     * <p>getRowGroups.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<? extends DRIDesignCrosstabRowGroup> getRowGroups();

    /**
     * <p>getCells.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<? extends DRIDesignCrosstabCell> getCells();

    /**
     * <p>getMeasures.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRIDesignCrosstabMeasure> getMeasures();
}

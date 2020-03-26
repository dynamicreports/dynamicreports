/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.report.definition.component;

import net.sf.dynamicreports.report.constant.ListType;

import java.util.List;

/**
 * <p>DRIList interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRIList extends DRIDimensionComponent {

    /**
     * <p>getListCells.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<? extends DRIListCell> getListCells();

    /**
     * <p>getType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.ListType} object.
     */
    public ListType getType();

    /**
     * <p>getGap.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getGap();

    /**
     * <p>getBackgroundComponent.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRIComponent} object.
     */
    public DRIComponent getBackgroundComponent();
}

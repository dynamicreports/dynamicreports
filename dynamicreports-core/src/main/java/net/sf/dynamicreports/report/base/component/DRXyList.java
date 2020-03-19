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
package net.sf.dynamicreports.report.base.component;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.component.DRIXyList;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRXyList class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRXyList extends DRDimensionComponent implements DRIXyList {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private List<DRXyListCell> xyListCells;

    /** {@inheritDoc} */
    @Override
    protected void init() {
        super.init();
        this.xyListCells = new ArrayList<DRXyListCell>();
    }

    /** {@inheritDoc} */
    @Override
    public List<DRXyListCell> getXyListCells() {
        return xyListCells;
    }

    /**
     * <p>addCell.</p>
     *
     * @param cell a {@link net.sf.dynamicreports.report.base.component.DRXyListCell} object.
     */
    public void addCell(DRXyListCell cell) {
        Validate.notNull(cell, "cell must not be null");
        xyListCells.add(cell);
    }

    /**
     * <p>addComponent.</p>
     *
     * @param x         a {@link java.lang.Integer} object.
     * @param y         a {@link java.lang.Integer} object.
     * @param component a {@link net.sf.dynamicreports.report.base.component.DRComponent} object.
     */
    public void addComponent(Integer x, Integer y, DRComponent component) {
        xyListCells.add(new DRXyListCell(x, y, component));
    }

}

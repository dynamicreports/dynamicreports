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
package net.sf.dynamicreports.report.base.grid;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;
import net.sf.dynamicreports.report.definition.grid.DRIColumnGridComponent;
import net.sf.dynamicreports.report.definition.grid.DRIColumnGridList;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRColumnGridList class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRColumnGridList implements DRIColumnGridList {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private List<DRColumnGridListCell> listCells;
    private ListType type;
    private int gap;

    /**
     * <p>Constructor for DRColumnGridList.</p>
     */
    public DRColumnGridList() {
        this(ListType.HORIZONTAL);
    }

    /**
     * <p>Constructor for DRColumnGridList.</p>
     *
     * @param type a {@link net.sf.dynamicreports.report.constant.ListType} object.
     */
    public DRColumnGridList(ListType type) {
        setType(type);
        this.listCells = new ArrayList<DRColumnGridListCell>();
    }

    /** {@inheritDoc} */
    @Override
    public List<DRColumnGridListCell> getListCells() {
        return listCells;
    }

    /**
     * <p>addComponent.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.definition.grid.DRIColumnGridComponent} object.
     */
    public void addComponent(DRIColumnGridComponent component) {
        listCells.add(new DRColumnGridListCell(component));
    }

    /**
     * <p>addCell.</p>
     *
     * @param cell a {@link net.sf.dynamicreports.report.base.grid.DRColumnGridListCell} object.
     */
    public void addCell(DRColumnGridListCell cell) {
        Validate.notNull(cell, "cell must not be null");
        listCells.add(cell);
    }

    /**
     * <p>addComponent.</p>
     *
     * @param horizontalAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment} object.
     * @param verticalAlignment a {@link net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment} object.
     * @param component a {@link net.sf.dynamicreports.report.definition.grid.DRIColumnGridComponent} object.
     */
    public void addComponent(HorizontalCellComponentAlignment horizontalAlignment, VerticalCellComponentAlignment verticalAlignment, DRIColumnGridComponent component) {
        listCells.add(new DRColumnGridListCell(horizontalAlignment, verticalAlignment, component));
    }

    /** {@inheritDoc} */
    @Override
    public ListType getType() {
        return type;
    }

    /**
     * <p>Setter for the field <code>type</code>.</p>
     *
     * @param type a {@link net.sf.dynamicreports.report.constant.ListType} object.
     */
    public void setType(ListType type) {
        Validate.notNull(type, "type must not be null");
        this.type = type;
    }

    /** {@inheritDoc} */
    @Override
    public int getGap() {
        return gap;
    }

    /**
     * <p>Setter for the field <code>gap</code>.</p>
     *
     * @param gap a int.
     */
    public void setGap(int gap) {
        Validate.notNull(gap < 0, "gap must be >= 0");
        this.gap = gap;
    }
}

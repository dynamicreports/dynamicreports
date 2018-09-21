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
package net.sf.dynamicreports.report.builder.grid;

import net.sf.dynamicreports.report.base.grid.DRColumnGridListCell;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;

/**
 * <p>HorizontalColumnGridListCellBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class HorizontalColumnGridListCellBuilder extends AbstractBuilder<HorizontalColumnGridListCellBuilder, DRColumnGridListCell> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for HorizontalColumnGridListCellBuilder.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder} object.
     */
    protected HorizontalColumnGridListCellBuilder(ColumnGridComponentBuilder component) {
        super(new DRColumnGridListCell(component.build()));
    }

    // width

    /**
     * <p>widthFixed.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListCellBuilder} object.
     */
    public HorizontalColumnGridListCellBuilder widthFixed() {
        getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.LEFT);
        return this;
    }

    /**
     * <p>widthFloat.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListCellBuilder} object.
     */
    public HorizontalColumnGridListCellBuilder widthFloat() {
        getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.FLOAT);
        return this;
    }

    /**
     * <p>widthExpand.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListCellBuilder} object.
     */
    public HorizontalColumnGridListCellBuilder widthExpand() {
        getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.EXPAND);
        return this;
    }

    // height

    /**
     * <p>heightFixedOnTop.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListCellBuilder} object.
     */
    public HorizontalColumnGridListCellBuilder heightFixedOnTop() {
        getObject().setVerticalAlignment(VerticalCellComponentAlignment.TOP);
        return this;
    }

    /**
     * <p>heightFixedOnMiddle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListCellBuilder} object.
     */
    public HorizontalColumnGridListCellBuilder heightFixedOnMiddle() {
        getObject().setVerticalAlignment(VerticalCellComponentAlignment.MIDDLE);
        return this;
    }

    /**
     * <p>heightFixedOnBottom.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListCellBuilder} object.
     */
    public HorizontalColumnGridListCellBuilder heightFixedOnBottom() {
        getObject().setVerticalAlignment(VerticalCellComponentAlignment.BOTTOM);
        return this;
    }

    /**
     * <p>heightExpand.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListCellBuilder} object.
     */
    public HorizontalColumnGridListCellBuilder heightExpand() {
        getObject().setVerticalAlignment(VerticalCellComponentAlignment.EXPAND);
        return this;
    }

    /**
     * <p>getColumnGridListCell.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.grid.DRColumnGridListCell} object.
     */
    public DRColumnGridListCell getColumnGridListCell() {
        return build();
    }
}

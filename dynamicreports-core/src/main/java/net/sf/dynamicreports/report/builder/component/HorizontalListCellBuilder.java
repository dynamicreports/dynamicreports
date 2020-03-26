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
package net.sf.dynamicreports.report.builder.component;

import net.sf.dynamicreports.report.base.component.DRListCell;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;

/**
 * <p>HorizontalListCellBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class HorizontalListCellBuilder extends AbstractBuilder<HorizontalListCellBuilder, DRListCell> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for HorizontalListCellBuilder.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     */
    protected HorizontalListCellBuilder(ComponentBuilder<?, ?> component) {
        super(new DRListCell(component.build()));
    }

    // width

    /**
     * <p>widthFixed.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     */
    public HorizontalListCellBuilder widthFixed() {
        getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.LEFT);
        return this;
    }

    /**
     * <p>widthFloat.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     */
    public HorizontalListCellBuilder widthFloat() {
        getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.FLOAT);
        return this;
    }

    /**
     * <p>widthExpand.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     */
    public HorizontalListCellBuilder widthExpand() {
        getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.EXPAND);
        return this;
    }

    // height

    /**
     * <p>heightFixedOnTop.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     */
    public HorizontalListCellBuilder heightFixedOnTop() {
        getObject().setVerticalAlignment(VerticalCellComponentAlignment.TOP);
        return this;
    }

    /**
     * <p>heightFixedOnMiddle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     */
    public HorizontalListCellBuilder heightFixedOnMiddle() {
        getObject().setVerticalAlignment(VerticalCellComponentAlignment.MIDDLE);
        return this;
    }

    /**
     * <p>heightFixedOnBottom.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     */
    public HorizontalListCellBuilder heightFixedOnBottom() {
        getObject().setVerticalAlignment(VerticalCellComponentAlignment.BOTTOM);
        return this;
    }

    /**
     * <p>heightExpand.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.HorizontalListCellBuilder} object.
     */
    public HorizontalListCellBuilder heightExpand() {
        getObject().setVerticalAlignment(VerticalCellComponentAlignment.EXPAND);
        return this;
    }

    /**
     * <p>getListCell.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.component.DRListCell} object.
     */
    public DRListCell getListCell() {
        return build();
    }
}

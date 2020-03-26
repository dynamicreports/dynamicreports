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
 * <p>VerticalListCellBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class VerticalListCellBuilder extends AbstractBuilder<VerticalListCellBuilder, DRListCell> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for VerticalListCellBuilder.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     */
    protected VerticalListCellBuilder(ComponentBuilder<?, ?> component) {
        super(new DRListCell(component.build()));
    }

    // width

    /**
     * <p>widthFixedOnLeft.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListCellBuilder} object.
     */
    public VerticalListCellBuilder widthFixedOnLeft() {
        getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.LEFT);
        return this;
    }

    /**
     * <p>widthFixedOnCenter.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListCellBuilder} object.
     */
    public VerticalListCellBuilder widthFixedOnCenter() {
        getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.CENTER);
        return this;
    }

    /**
     * <p>widthFixedOnRight.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListCellBuilder} object.
     */
    public VerticalListCellBuilder widthFixedOnRight() {
        getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.RIGHT);
        return this;
    }

    /**
     * <p>widthFloat.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListCellBuilder} object.
     */
    public VerticalListCellBuilder widthFloat() {
        getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.FLOAT);
        return this;
    }

    /**
     * <p>widthExpand.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListCellBuilder} object.
     */
    public VerticalListCellBuilder widthExpand() {
        getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.EXPAND);
        return this;
    }

    // height

    /**
     * <p>heightFixed.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListCellBuilder} object.
     */
    public VerticalListCellBuilder heightFixed() {
        getObject().setVerticalAlignment(VerticalCellComponentAlignment.TOP);
        return this;
    }

    /**
     * <p>heightExpand.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.component.VerticalListCellBuilder} object.
     */
    public VerticalListCellBuilder heightExpand() {
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

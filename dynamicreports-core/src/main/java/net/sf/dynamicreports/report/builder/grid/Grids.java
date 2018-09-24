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

import org.apache.commons.lang3.Validate;

/**
 * A set of methods of customizing columns layout
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class Grids {

    // horizontal

    /**
     * <p>horizontalColumnGridList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListBuilder} object.
     */
    public static HorizontalColumnGridListBuilder horizontalColumnGridList() {
        return new HorizontalColumnGridListBuilder();
    }

    /**
     * <p>horizontalColumnGridList.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListBuilder} object.
     */
    public static HorizontalColumnGridListBuilder horizontalColumnGridList(ColumnGridComponentBuilder... components) {
        return new HorizontalColumnGridListBuilder().add(components);
    }

    /**
     * <p>horizontalColumnGridList.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListBuilder} object.
     */
    public static HorizontalColumnGridListBuilder horizontalColumnGridList(HorizontalColumnGridListCellBuilder... cells) {
        return new HorizontalColumnGridListBuilder().add(cells);
    }

    /**
     * <p>hColumnGridListCell.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListCellBuilder} object.
     */
    public static HorizontalColumnGridListCellBuilder hColumnGridListCell(ColumnGridComponentBuilder component) {
        Validate.notNull(component, "component must not be null");
        return new HorizontalColumnGridListCellBuilder(component);
    }

    // horizontal flow

    /**
     * <p>horizontalFlowColumnGridList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListBuilder} object.
     */
    public static HorizontalColumnGridListBuilder horizontalFlowColumnGridList() {
        return new HorizontalFlowColumnGridListBuilder();
    }

    /**
     * <p>horizontalFlowColumnGridList.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListBuilder} object.
     */
    public static HorizontalColumnGridListBuilder horizontalFlowColumnGridList(ColumnGridComponentBuilder... components) {
        return new HorizontalFlowColumnGridListBuilder().add(components);
    }

    /**
     * <p>horizontalFlowColumnGridList.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.HorizontalColumnGridListBuilder} object.
     */
    public static HorizontalColumnGridListBuilder horizontalFlowColumnGridList(HorizontalColumnGridListCellBuilder... cells) {
        return new HorizontalFlowColumnGridListBuilder().add(cells);
    }

    // vertical

    /**
     * <p>verticalColumnGridList.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.grid.VerticalColumnGridListBuilder} object.
     */
    public static VerticalColumnGridListBuilder verticalColumnGridList() {
        return new VerticalColumnGridListBuilder();
    }

    /**
     * <p>verticalColumnGridList.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.VerticalColumnGridListBuilder} object.
     */
    public static VerticalColumnGridListBuilder verticalColumnGridList(ColumnGridComponentBuilder... components) {
        return new VerticalColumnGridListBuilder().add(components);
    }

    /**
     * <p>verticalColumnGridList.</p>
     *
     * @param cells a {@link net.sf.dynamicreports.report.builder.grid.VerticalColumnGridListCellBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.VerticalColumnGridListBuilder} object.
     */
    public static VerticalColumnGridListBuilder verticalColumnGridList(VerticalColumnGridListCellBuilder... cells) {
        return new VerticalColumnGridListBuilder().add(cells);
    }

    /**
     * <p>vColumnGridListCell.</p>
     *
     * @param component a {@link net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.VerticalColumnGridListCellBuilder} object.
     */
    public static VerticalColumnGridListCellBuilder vColumnGridListCell(ColumnGridComponentBuilder component) {
        Validate.notNull(component, "component must not be null");
        return new VerticalColumnGridListCellBuilder(component);
    }

    // title group

    /**
     * <p>titleGroup.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     */
    public static ColumnTitleGroupBuilder titleGroup() {
        return new ColumnTitleGroupBuilder();
    }

    /**
     * <p>titleGroup.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     */
    public static ColumnTitleGroupBuilder titleGroup(ColumnGridComponentBuilder... components) {
        return new ColumnTitleGroupBuilder().add(components);
    }

    /**
     * <p>titleGroup.</p>
     *
     * @param title      a {@link java.lang.String} object.
     * @param components a {@link net.sf.dynamicreports.report.builder.grid.ColumnGridComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder} object.
     */
    public static ColumnTitleGroupBuilder titleGroup(String title, ColumnGridComponentBuilder... components) {
        return titleGroup(components).setTitle(title);
    }
}

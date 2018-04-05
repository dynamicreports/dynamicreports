/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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

/**
 * A set of methods of customizing columns layout
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GridBuilders {

	// horizontal
	public HorizontalColumnGridListBuilder horizontalColumnGridList() {
		return Grids.horizontalColumnGridList();
	}

	public HorizontalColumnGridListBuilder horizontalColumnGridList(ColumnGridComponentBuilder... components) {
		return Grids.horizontalColumnGridList(components);
	}

	public HorizontalColumnGridListBuilder horizontalColumnGridList(HorizontalColumnGridListCellBuilder... cells) {
		return Grids.horizontalColumnGridList(cells);
	}

	public HorizontalColumnGridListCellBuilder hColumnGridListCell(ColumnGridComponentBuilder component) {
		return Grids.hColumnGridListCell(component);
	}

	// horizontal flow
	public HorizontalColumnGridListBuilder horizontalFlowColumnGridList() {
		return Grids.horizontalFlowColumnGridList();
	}

	public HorizontalColumnGridListBuilder horizontalFlowColumnGridList(ColumnGridComponentBuilder... components) {
		return Grids.horizontalFlowColumnGridList(components);
	}

	public HorizontalColumnGridListBuilder horizontalFlowColumnGridList(HorizontalColumnGridListCellBuilder... cells) {
		return Grids.horizontalFlowColumnGridList(cells);
	}

	// vertical
	public VerticalColumnGridListBuilder verticalColumnGridList() {
		return Grids.verticalColumnGridList();
	}

	public VerticalColumnGridListBuilder verticalColumnGridList(ColumnGridComponentBuilder... components) {
		return Grids.verticalColumnGridList(components);
	}

	public VerticalColumnGridListBuilder verticalColumnGridList(VerticalColumnGridListCellBuilder... cells) {
		return Grids.verticalColumnGridList(cells);
	}

	public VerticalColumnGridListCellBuilder vColumnGridListCell(ColumnGridComponentBuilder component) {
		return Grids.vColumnGridListCell(component);
	}

	// title group
	public ColumnTitleGroupBuilder titleGroup() {
		return Grids.titleGroup();
	}

	public ColumnTitleGroupBuilder titleGroup(ColumnGridComponentBuilder... components) {
		return Grids.titleGroup(components);
	}

	public ColumnTitleGroupBuilder titleGroup(String title, ColumnGridComponentBuilder... components) {
		return Grids.titleGroup(title, components);
	}
}

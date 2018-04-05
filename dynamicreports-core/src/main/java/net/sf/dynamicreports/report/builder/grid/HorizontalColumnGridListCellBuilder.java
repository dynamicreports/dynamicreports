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

import net.sf.dynamicreports.report.base.grid.DRColumnGridListCell;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class HorizontalColumnGridListCellBuilder extends AbstractBuilder<HorizontalColumnGridListCellBuilder, DRColumnGridListCell> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected HorizontalColumnGridListCellBuilder(ColumnGridComponentBuilder component) {
		super(new DRColumnGridListCell(component.build()));
	}

	// width
	public HorizontalColumnGridListCellBuilder widthFixed() {
		getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.LEFT);
		return this;
	}

	public HorizontalColumnGridListCellBuilder widthFloat() {
		getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.FLOAT);
		return this;
	}

	public HorizontalColumnGridListCellBuilder widthExpand() {
		getObject().setHorizontalAlignment(HorizontalCellComponentAlignment.EXPAND);
		return this;
	}

	// height
	public HorizontalColumnGridListCellBuilder heightFixedOnTop() {
		getObject().setVerticalAlignment(VerticalCellComponentAlignment.TOP);
		return this;
	}

	public HorizontalColumnGridListCellBuilder heightFixedOnMiddle() {
		getObject().setVerticalAlignment(VerticalCellComponentAlignment.MIDDLE);
		return this;
	}

	public HorizontalColumnGridListCellBuilder heightFixedOnBottom() {
		getObject().setVerticalAlignment(VerticalCellComponentAlignment.BOTTOM);
		return this;
	}

	public HorizontalColumnGridListCellBuilder heightExpand() {
		getObject().setVerticalAlignment(VerticalCellComponentAlignment.EXPAND);
		return this;
	}

	public DRColumnGridListCell getColumnGridListCell() {
		return build();
	}
}

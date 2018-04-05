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

package net.sf.dynamicreports.report.builder.component;

import net.sf.dynamicreports.report.base.component.DRList;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.constant.StretchType;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class HorizontalListBuilder extends DimensionComponentBuilder<HorizontalListBuilder, DRList> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRList row;

	protected HorizontalListBuilder() {
		super(new DRList(ListType.VERTICAL));
		init();
	}

	protected void init() {
		newRow();
	}

	public HorizontalListBuilder add(ComponentBuilder<?, ?>... components) {
		Validate.notNull(components, "components must not be null");
		Validate.noNullElements(components, "components must not contains null component");
		for (ComponentBuilder<?, ?> component : components) {
			row.addComponent(component.getComponent());
		}
		return this;
	}

	public HorizontalListBuilder add(int gap, ComponentBuilder<?, ?>... components) {
		Validate.notNull(components, "components must not be null");
		for (ComponentBuilder<?, ?> component : components) {
			add(Components.hListCell(Components.filler().setWidth(gap)).widthFixed());
			add(component);
		}
		return this;
	}

	public HorizontalListBuilder add(HorizontalListCellBuilder... cells) {
		Validate.notNull(cells, "cells must not be null");
		Validate.noNullElements(cells, "cells must not contains null cell");
		for (HorizontalListCellBuilder cell : cells) {
			row.addCell(cell.build());
		}
		return this;
	}

	public HorizontalListBuilder add(int gap, HorizontalListCellBuilder... cells) {
		Validate.notNull(cells, "cells must not be null");
		for (HorizontalListCellBuilder cell : cells) {
			add(Components.hListCell(Components.filler().setWidth(gap)).widthFixed(), cell);
		}
		return this;
	}

	public HorizontalListBuilder newRow() {
		return newRow(0);
	}

	public HorizontalListBuilder newRow(Integer verticalGap) {
		return newRow(verticalGap, ListType.HORIZONTAL);
	}

	public HorizontalListBuilder newFlowRow() {
		return newFlowRow(0);
	}

	public HorizontalListBuilder newFlowRow(Integer verticalGap) {
		return newRow(verticalGap, ListType.HORIZONTAL_FLOW);
	}

	private HorizontalListBuilder newRow(Integer verticalGap, ListType listType) {
		if (verticalGap != null) {
			Validate.isTrue(verticalGap >= 0, "verticalGap must be >= 0");
		}
		if (verticalGap != null && verticalGap > 0) {
			getObject().addComponent(HorizontalCellComponentAlignment.CENTER, VerticalCellComponentAlignment.TOP, Components.filler().setHeight(verticalGap).build());
		}
		row = new DRList(listType);
		getObject().addComponent(row);
		return this;
	}

	public HorizontalListBuilder setGap(Integer gap) {
		row.setGap(gap);
		return this;
	}

	@Override
	public HorizontalListBuilder setStyle(ReportStyleBuilder style) {
		if (style != null) {
			row.setStyle(style.build());
		} else {
			row.setStyle(null);
		}
		return this;
	}

	public HorizontalListBuilder setBaseStretchType(StretchType stretchType) {
		row.setStretchType(stretchType);
		return this;
	}

	public HorizontalListBuilder setBaseGap(Integer gap) {
		getObject().setGap(gap);
		return this;
	}

	public HorizontalListBuilder setBaseStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setStyle(style.build());
		} else {
			getObject().setStyle(null);
		}
		return this;
	}

	public HorizontalListBuilder setBaseBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		getObject().setBackgroundComponent(backgroundComponent.build());
		return this;
	}

	public HorizontalListBuilder setBackgroundComponent(ComponentBuilder<?, ?> backgroundComponent) {
		Validate.notNull(backgroundComponent, "backgroundComponent must not be null");
		row.setBackgroundComponent(backgroundComponent.build());
		return this;
	}

	public DRList getList() {
		return build();
	}
}

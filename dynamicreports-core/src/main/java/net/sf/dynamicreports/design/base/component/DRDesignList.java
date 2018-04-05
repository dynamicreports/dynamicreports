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

package net.sf.dynamicreports.design.base.component;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.design.constant.ComponentGroupType;
import net.sf.dynamicreports.design.definition.component.DRIDesignList;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalCellComponentAlignment;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.constant.VerticalCellComponentAlignment;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignList extends DRDesignComponent implements DRIDesignList {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private List<DRDesignListCell> listCells;
	private List<DRDesignComponent> components;
	private ListType type;
	private ComponentGroupType componentGroupType;
	private int gap;
	private boolean calculateComponents;
	private Boolean removable;
	private DRDesignComponent backgroundComponent;

	public DRDesignList() {
		this(ListType.HORIZONTAL);
	}

	public DRDesignList(ListType type) {
		super("list");
		this.type = type;
		this.calculateComponents = true;
	}

	@Override
	protected void init() {
		super.init();
		this.listCells = new ArrayList<DRDesignListCell>();
		this.components = new ArrayList<DRDesignComponent>();
	}

	@Override
	public List<DRDesignComponent> getComponents() {
		return components;
	}

	public void addComponent(DRDesignComponent component) {
		components.add(component);
		listCells.add(new DRDesignListCell(component));
	}

	public void addComponent(int index, DRDesignComponent component) {
		components.add(index, component);
		listCells.add(index, new DRDesignListCell(component));
	}

	public void addComponent(int index, HorizontalCellComponentAlignment horizontalAlignment, VerticalCellComponentAlignment verticalAlignment,
			DRDesignComponent component) {
		components.add(index, component);
		listCells.add(index, new DRDesignListCell(horizontalAlignment, verticalAlignment, component));
	}

	public void addComponent(HorizontalCellComponentAlignment horizontalAlignment, VerticalCellComponentAlignment verticalAlignment,
			DRDesignComponent component) {
		components.add(component);
		listCells.add(new DRDesignListCell(horizontalAlignment, verticalAlignment, component));
	}

	public List<DRDesignListCell> getListCells() {
		return listCells;
	}

	public boolean isEmpty() {
		return components.isEmpty();
	}

	public void setType(ListType type) {
		this.type = type;
	}

	@Override
	public ListType getType() {
		return type;
	}

	public void setComponentGroupType(ComponentGroupType componentGroupType) {
		this.componentGroupType = componentGroupType;
	}

	@Override
	public ComponentGroupType getComponentGroupType() {
		return componentGroupType;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}

	public boolean isCalculateComponents() {
		return calculateComponents;
	}

	public void setCalculateComponents(boolean calculateComponents) {
		this.calculateComponents = calculateComponents;
	}

	public boolean isRemovable() {
		if (removable != null) {
			return removable;
		} else {
			return ListType.VERTICAL.equals(type);
		}
	}

	public void setRemovable(Boolean removable) {
		this.removable = removable;
	}

	@Override
	public DRDesignComponent getBackgroundComponent() {
		return backgroundComponent;
	}

	public void setBackgroundComponent(DRDesignComponent backgroundComponent) {
		this.backgroundComponent = backgroundComponent;
	}

}

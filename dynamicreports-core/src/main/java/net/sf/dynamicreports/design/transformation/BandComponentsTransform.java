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

package net.sf.dynamicreports.design.transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.dynamicreports.design.base.DRDesignBand;
import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignFiller;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCell;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCellContent;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabColumnGroup;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabRowGroup;
import net.sf.dynamicreports.design.constant.ComponentGroupType;
import net.sf.dynamicreports.report.constant.StretchType;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstab;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabColumnGroup;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabRowGroup;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
class BandComponentsTransform {
	private DesignTransformAccessor accessor;
	private Map<String, Integer> componentNames;

	public BandComponentsTransform(DesignTransformAccessor accessor) {
		this.accessor = accessor;
		componentNames = new HashMap<String, Integer>();
	}

	public DRDesignBand prepareBand(DRDesignBand band, int maxWidth, int templateDesignComponents) throws DRException {
		if (band == null) {
			return null;
		}
		if (band.getBandComponent() != null) {
			return band;
		}

		DRDesignComponent component = prepareList(band.getName(), band.getList(), maxWidth);
		if (component == null) {
			if (band.getList() == null || band.getList().getHeight() == null || band.getList().getHeight() == 0) {
				return null;
			}
		}
		band.setHeight(band.getList().getHeight());
		band.setBandComponent(component);

		if (band.getBandComponent() != null && templateDesignComponents > 0) {
			throw new DRException("Band " + band.getName() + " must not be defined at once in jrxml template design and in dynamic design");
		}

		prepareListBackgroundComponents(component);
		prepareCrosstabs(component);

		return band;
	}

	private DRDesignComponent prepareList(String name, DRDesignList list, int maxWidth) throws DRException {
		return prepareList(name, list, maxWidth, -1);
	}

	private DRDesignComponent prepareList(String name, DRDesignList list, int maxWidth, int maxHeight) throws DRException {
		if (list == null) {
			return null;
		}
		if (list.isEmpty()) {
			return null;
		}

		ComponentPosition.component(name, list, maxWidth, maxHeight);

		DRDesignComponent component = removeEmptyComponents(list);
		if (component == null) {
			return null;
		}
		componentGroupType(component);

		generateComponentNames(component, name);

		return component;
	}

	private void generateComponentNames(DRDesignComponent component, String bandName) {
		String componentName = bandName + "." + component.getUniqueName();
		if (!componentNames.containsKey(componentName)) {
			componentNames.put(componentName, new Integer(1));
		} else {
			componentNames.put(componentName, componentNames.get(componentName) + 1);
		}
		component.setUniqueName(componentName + componentNames.get(componentName));
		if (component instanceof DRDesignList) {
			DRDesignList list = (DRDesignList) component;
			for (DRDesignComponent lComponent : list.getComponents()) {
				generateComponentNames(lComponent, bandName);
			}
			if (list.getBackgroundComponent() != null) {
				list.getBackgroundComponent().setUniqueName(component.getUniqueName() + ".background");
			}
		}
	}

	private DRDesignComponent removeEmptyComponents(DRDesignComponent component) {
		if (component instanceof DRDesignList) {
			DRDesignList list = (DRDesignList) component;
			if (list.getComponents().isEmpty()) {
				return null;
			} else if (list.getComponents().size() == 1) {
				DRDesignComponent lComponent = list.getComponents().get(0);
				DRDesignComponent elm = removeEmptyComponents(lComponent);
				if (elm == null) {
					if (list.getWidth() > 0 && list.getHeight() > 0 &&
							(list.getStyle() != null || list.getBackgroundComponent() != null)) {
						list.getComponents().clear();
						return list;
					}
					return null;
				}
				if (lComponent != elm &&
						(!(lComponent instanceof DRDesignList) ||
								lComponent instanceof DRDesignList && !(lComponent.getStyle() == null && lComponent.getPrintWhenExpression() == null
										&& ((DRDesignList) lComponent).getBackgroundComponent() == null))) {
					elm.setX(lComponent.getX() + elm.getX());
					elm.setY(lComponent.getY() + elm.getY());
				}

				if (list.getStyle() == null && list.getPrintWhenExpression() == null && list.getBackgroundComponent() == null) {
					elm.setX(list.getX() + elm.getX());
					elm.setY(list.getY() + elm.getY());
					return elm;
				} else {
					list.getComponents().clear();
					list.getComponents().add(elm);
					return list;
				}
			} else {
				List<DRDesignComponent> components = new ArrayList<DRDesignComponent>();
				for (DRDesignComponent listComponent : list.getComponents()) {
					DRDesignComponent comp = removeEmptyComponents(listComponent);
					if (comp != null) {
						components.add(comp);
					}
				}
				if (components.isEmpty()) {
					if (list.getWidth() > 0 && list.getHeight() > 0 &&
							(list.getStyle() != null || list.getBackgroundComponent() != null)) {
						list.getComponents().clear();
						return list;
					}
					return null;
				}
				list.getComponents().clear();
				list.getComponents().addAll(components);
				return list;
			}
		} else if (component instanceof DRDesignFiller && component.getStyle() == null && component.getPrintWhenExpression() == null) {
			return null;
		}
		return component;
	}

	private void componentGroupType(DRDesignComponent component) {
		if (component instanceof DRDesignList) {
			DRDesignList list = (DRDesignList) component;
			if (list.isRemovable() && list.getStyle() == null && list.getPrintWhenExpression() == null && list.getBackgroundComponent() == null) {
				list.setComponentGroupType(ComponentGroupType.NONE);
				for (DRDesignComponent listComponent : list.getComponents()) {
					listComponent.setX(list.getX() + listComponent.getX());
					listComponent.setY(list.getY() + listComponent.getY());
				}
			} else {
				list.setComponentGroupType(ComponentGroupType.FRAME);
			}

			for (DRDesignComponent listComponent : list.getComponents()) {
				componentGroupType(listComponent);
			}
		}
	}

	private void prepareListBackgroundComponents(DRDesignComponent component) throws DRException {
		if (component instanceof DRDesignList) {
			DRDesignList list = (DRDesignList) component;
			if (list.getBackgroundComponent() != null) {
				DRDesignComponent backgroundComponent = list.getBackgroundComponent();
				backgroundComponent.setX(0);
				backgroundComponent.setY(0);
				backgroundComponent.setWidth(list.getWidth() - StyleResolver.getHorizontalPadding(list.getStyle()));
				backgroundComponent.setHeight(list.getHeight() - StyleResolver.getVerticalPadding(list.getStyle()));
				backgroundComponent.setStretchType(StretchType.ELEMENT_GROUP_HEIGHT);
				list.setBackgroundComponent(backgroundComponent);
			}
			for (DRDesignComponent listComponent : list.getComponents()) {
				prepareListBackgroundComponents(listComponent);
			}
		}
	}

	private void prepareCrosstabs(DRDesignComponent component) throws DRException {
		if (component instanceof DRDesignList) {
			DRDesignList list = (DRDesignList) component;
			for (DRDesignComponent listComponent : list.getComponents()) {
				prepareCrosstabs(listComponent);
			}
		} else if (component instanceof DRDesignCrosstab) {
			prepareCrosstab((DRDesignCrosstab) component);
		}
	}

	private void prepareCrosstab(DRDesignCrosstab crosstab) throws DRException {
		calculateCellDimensions(crosstab);

		DRDesignCrosstabCellContent whenNoDataCell = crosstab.getWhenNoDataCell();

		for (DRDesignCrosstabColumnGroup columnGroup : crosstab.getColumnGroups()) {
			DRDesignCrosstabCellContent header = columnGroup.getHeader();
			if (header != null) {
				header.setComponent(prepareCrosstabCell(crosstab.getUniqueName(), header));
			}
			DRDesignCrosstabCellContent totalHeader = columnGroup.getTotalHeader();
			if (totalHeader != null) {
				totalHeader.setComponent(prepareCrosstabCell(crosstab.getUniqueName(), totalHeader));
			}
		}

		for (DRDesignCrosstabRowGroup rowGroup : crosstab.getRowGroups()) {
			DRDesignCrosstabCellContent header = rowGroup.getHeader();
			if (header != null) {
				header.setComponent(prepareCrosstabCell(crosstab.getUniqueName(), header));
			}
			DRDesignCrosstabCellContent totalHeader = rowGroup.getTotalHeader();
			if (totalHeader != null) {
				totalHeader.setComponent(prepareCrosstabCell(crosstab.getUniqueName(), totalHeader));
			}
		}

		if (whenNoDataCell != null) {
			whenNoDataCell.setComponent(prepareCrosstabCell(crosstab.getUniqueName() + ".whennodatacell", whenNoDataCell));
		}

		DRDesignCrosstabCellContent headerCell = crosstab.getHeaderCell();
		if (headerCell != null) {
			crosstab.getHeaderCell().setComponent(prepareCrosstabCell(crosstab.getUniqueName() + ".headercell", headerCell));
		}

		for (DRDesignCrosstabCell cell : crosstab.getCells()) {
			DRDesignCrosstabCellContent content = cell.getContent();
			if (content != null) {
				content.setComponent(prepareCrosstabCell(crosstab.getUniqueName(), content));
			}
		}
	}

	private DRDesignComponent prepareCrosstabCell(String name, DRDesignCrosstabCellContent cell) throws DRException {
		return prepareList(name, cell.getList(), cell.getWidth(), cell.getHeight());
	}

	private void calculateCellDimensions(DRDesignCrosstab designCrosstab) {
		DRICrosstab crosstab = accessor.getCrosstabTransform().getCrosstab(designCrosstab);
		int cellWidth = accessor.getTemplateTransform().getCrosstabCellWidth(crosstab, designCrosstab);
		int cellHeight = accessor.getTemplateTransform().getCrosstabCellHeight(crosstab, designCrosstab);
		Map<String, GroupCellDimension> columnGroups = new HashMap<String, GroupCellDimension>();
		Map<String, GroupCellDimension> rowGroups = new HashMap<String, GroupCellDimension>();
		int groupWidth = 0;
		int groupHeight = 0;

		GroupCellDimension previousCellDimension = null;
		for (int i = crosstab.getColumnGroups().size() - 1; i >= 0; i--) {
			DRICrosstabColumnGroup<?> columnGroup = crosstab.getColumnGroups().get(i);
			int headerWidth = 0;
			int headerHeight = 0;
			int totalHeaderWidth = 0;
			int totalHeaderHeight = 0;

			if (previousCellDimension == null) {
				headerWidth = cellWidth;
			} else {
				headerWidth = previousCellDimension.getHeaderWidth() + previousCellDimension.getTotalHeaderWidth();
			}
			headerHeight = accessor.getTemplateTransform().getCrosstabColumnGroupHeaderHeight(columnGroup, designCrosstab, groupHeight);

			if (accessor.getTemplateTransform().isCrosstabColumnGroupShowTotal(columnGroup)) {
				totalHeaderWidth = accessor.getTemplateTransform().getCrosstabColumnGroupTotalHeaderWidth(columnGroup, crosstab.getCellWidth(), designCrosstab);
			}
			totalHeaderHeight = headerHeight;
			if (previousCellDimension != null) {
				totalHeaderHeight += previousCellDimension.getTotalHeaderHeight();
			}

			GroupCellDimension groupCellDimension = new GroupCellDimension();
			groupCellDimension.setHeaderWidth(headerWidth);
			groupCellDimension.setHeaderHeight(headerHeight);
			groupCellDimension.setTotalHeaderWidth(totalHeaderWidth);
			groupCellDimension.setTotalHeaderHeight(totalHeaderHeight);
			columnGroups.put(columnGroup.getName(), groupCellDimension);
			previousCellDimension = groupCellDimension;

			groupHeight += groupCellDimension.getHeaderHeight();
		}

		previousCellDimension = null;
		for (int i = crosstab.getRowGroups().size() - 1; i >= 0; i--) {
			DRICrosstabRowGroup<?> rowGroup = crosstab.getRowGroups().get(i);
			int headerWidth = 0;
			int headerHeight = 0;
			int totalHeaderWidth = 0;
			int totalHeaderHeight = 0;

			headerWidth = accessor.getTemplateTransform().getCrosstabRowGroupHeaderWidth(rowGroup, designCrosstab);
			if (previousCellDimension == null) {
				headerHeight = cellHeight;
			} else {
				headerHeight = previousCellDimension.getHeaderHeight() + previousCellDimension.getTotalHeaderHeight();
			}

			totalHeaderWidth = headerWidth;
			if (previousCellDimension != null) {
				totalHeaderWidth += previousCellDimension.getTotalHeaderWidth();
			}
			if (accessor.getTemplateTransform().isCrosstabRowGroupShowTotal(rowGroup)) {
				totalHeaderHeight = accessor.getTemplateTransform().getCrosstabRowGroupTotalHeaderHeight(rowGroup, crosstab.getCellHeight(), designCrosstab);
			}

			GroupCellDimension groupCellDimension = new GroupCellDimension();
			groupCellDimension.setHeaderWidth(headerWidth);
			groupCellDimension.setHeaderHeight(headerHeight);
			groupCellDimension.setTotalHeaderWidth(totalHeaderWidth);
			groupCellDimension.setTotalHeaderHeight(totalHeaderHeight);
			rowGroups.put(rowGroup.getName(), groupCellDimension);
			previousCellDimension = groupCellDimension;

			groupWidth += groupCellDimension.getHeaderWidth();
		}

		designCrosstab.getWhenNoDataCell().setWidth(designCrosstab.getWidth());
		designCrosstab.getWhenNoDataCell().setHeight(designCrosstab.getHeight());
		designCrosstab.getHeaderCell().setWidth(groupWidth);
		designCrosstab.getHeaderCell().setHeight(groupHeight);

		for (DRDesignCrosstabColumnGroup designColumnGroup : designCrosstab.getColumnGroups()) {
			GroupCellDimension groupCellDimension = columnGroups.get(designColumnGroup.getName());
			designColumnGroup.setHeight(groupCellDimension.getHeaderHeight());
			designColumnGroup.getHeader().setWidth(groupCellDimension.getHeaderWidth());
			designColumnGroup.getHeader().setHeight(groupCellDimension.getHeaderHeight());
			if (designColumnGroup.getTotalHeader() != null) {
				designColumnGroup.getTotalHeader().setWidth(groupCellDimension.getTotalHeaderWidth());
				designColumnGroup.getTotalHeader().setHeight(groupCellDimension.getTotalHeaderHeight());
			}
		}

		for (DRDesignCrosstabRowGroup designRowGroup : designCrosstab.getRowGroups()) {
			GroupCellDimension groupCellDimension = rowGroups.get(designRowGroup.getName());
			designRowGroup.setWidth(groupCellDimension.getHeaderWidth());
			designRowGroup.getHeader().setWidth(groupCellDimension.getHeaderWidth());
			designRowGroup.getHeader().setHeight(groupCellDimension.getHeaderHeight());
			if (designRowGroup.getTotalHeader() != null) {
				designRowGroup.getTotalHeader().setWidth(groupCellDimension.getTotalHeaderWidth());
				designRowGroup.getTotalHeader().setHeight(groupCellDimension.getTotalHeaderHeight());
			}
		}

		for (DRDesignCrosstabCell designCell : designCrosstab.getCells()) {
			if (designCell.getColumnTotalGroup() == null && designCell.getRowTotalGroup() == null) {
				designCell.getContent().setWidth(cellWidth);
				designCell.getContent().setHeight(cellHeight);
			} else if (designCell.getColumnTotalGroup() != null && designCell.getRowTotalGroup() == null) {
				GroupCellDimension groupCellDimension = columnGroups.get(designCell.getColumnTotalGroup());
				designCell.getContent().setWidth(groupCellDimension.getTotalHeaderWidth());
				designCell.getContent().setHeight(cellHeight);
			} else if (designCell.getColumnTotalGroup() == null && designCell.getRowTotalGroup() != null) {
				GroupCellDimension groupCellDimension = rowGroups.get(designCell.getRowTotalGroup());
				designCell.getContent().setWidth(cellWidth);
				designCell.getContent().setHeight(groupCellDimension.getTotalHeaderHeight());
			} else {
				GroupCellDimension groupCellDimension = columnGroups.get(designCell.getColumnTotalGroup());
				designCell.getContent().setWidth(groupCellDimension.getTotalHeaderWidth());
				groupCellDimension = rowGroups.get(designCell.getRowTotalGroup());
				designCell.getContent().setHeight(groupCellDimension.getTotalHeaderHeight());
			}
		}
	}

	private class GroupCellDimension {
		private int headerWidth;
		private int headerHeight;
		private int totalHeaderWidth;
		private int totalHeaderHeight;

		public int getHeaderWidth() {
			return headerWidth;
		}

		public void setHeaderWidth(int headerWidth) {
			this.headerWidth = headerWidth;
		}

		public int getHeaderHeight() {
			return headerHeight;
		}

		public void setHeaderHeight(int headerHeight) {
			this.headerHeight = headerHeight;
		}

		public int getTotalHeaderWidth() {
			return totalHeaderWidth;
		}

		public void setTotalHeaderWidth(int totalHeaderWidth) {
			this.totalHeaderWidth = totalHeaderWidth;
		}

		public int getTotalHeaderHeight() {
			return totalHeaderHeight;
		}

		public void setTotalHeaderHeight(int totalHeaderHeight) {
			this.totalHeaderHeight = totalHeaderHeight;
		}
	}
}

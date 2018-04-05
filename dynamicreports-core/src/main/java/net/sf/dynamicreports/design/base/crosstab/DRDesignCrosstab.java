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

package net.sf.dynamicreports.design.base.crosstab;

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstab;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabMeasure;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.RunDirection;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignCrosstab extends DRDesignComponent implements DRIDesignCrosstab {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRDesignCrosstabDataset dataset;
	private Boolean repeatColumnHeaders;
	private Boolean repeatRowHeaders;
	private Integer columnBreakOffset;
	private Boolean ignoreWidth;
	private RunDirection runDirection;
	private DRDesignCrosstabCellContent whenNoDataCell;
	private DRDesignCrosstabCellContent headerCell;
	private List<DRDesignCrosstabColumnGroup> columnGroups;
	private List<DRDesignCrosstabRowGroup> rowGroups;
	private List<DRDesignCrosstabCell> cells;
	private List<DRIDesignCrosstabMeasure> measures;

	public DRDesignCrosstab() {
		super("crosstab");
	}

	@Override
	protected void init() {
		super.init();
		columnGroups = new ArrayList<DRDesignCrosstabColumnGroup>();
		rowGroups = new ArrayList<DRDesignCrosstabRowGroup>();
		cells = new ArrayList<DRDesignCrosstabCell>();
		measures = new ArrayList<DRIDesignCrosstabMeasure>();
	}

	@Override
	public DRDesignCrosstabDataset getDataset() {
		return dataset;
	}

	public void setDataset(DRDesignCrosstabDataset dataset) {
		this.dataset = dataset;
	}

	@Override
	public Boolean isRepeatColumnHeaders() {
		return repeatColumnHeaders;
	}

	public void setRepeatColumnHeaders(Boolean repeatColumnHeaders) {
		this.repeatColumnHeaders = repeatColumnHeaders;
	}

	@Override
	public Boolean isRepeatRowHeaders() {
		return repeatRowHeaders;
	}

	public void setRepeatRowHeaders(Boolean repeatRowHeaders) {
		this.repeatRowHeaders = repeatRowHeaders;
	}

	@Override
	public Integer getColumnBreakOffset() {
		return columnBreakOffset;
	}

	public void setColumnBreakOffset(Integer columnBreakOffset) {
		this.columnBreakOffset = columnBreakOffset;
	}

	@Override
	public Boolean getIgnoreWidth() {
		return ignoreWidth;
	}

	public void setIgnoreWidth(Boolean ignoreWidth) {
		this.ignoreWidth = ignoreWidth;
	}

	@Override
	public RunDirection getRunDirection() {
		return runDirection;
	}

	public void setRunDirection(RunDirection runDirection) {
		this.runDirection = runDirection;
	}

	@Override
	public DRDesignCrosstabCellContent getWhenNoDataCell() {
		return whenNoDataCell;
	}

	public void setWhenNoDataCell(DRDesignCrosstabCellContent whenNoDataCell) {
		this.whenNoDataCell = whenNoDataCell;
	}

	@Override
	public DRDesignCrosstabCellContent getHeaderCell() {
		return headerCell;
	}

	public void setHeaderCell(DRDesignCrosstabCellContent headerCell) {
		this.headerCell = headerCell;
	}

	@Override
	public List<DRDesignCrosstabColumnGroup> getColumnGroups() {
		return columnGroups;
	}

	public void setColumnGroups(List<DRDesignCrosstabColumnGroup> columnGroups) {
		this.columnGroups = columnGroups;
	}

	@Override
	public List<DRDesignCrosstabRowGroup> getRowGroups() {
		return rowGroups;
	}

	public void setRowGroups(List<DRDesignCrosstabRowGroup> rowGroups) {
		this.rowGroups = rowGroups;
	}

	@Override
	public List<DRDesignCrosstabCell> getCells() {
		return cells;
	}

	public void setCells(List<DRDesignCrosstabCell> cells) {
		this.cells = cells;
	}

	@Override
	public List<DRIDesignCrosstabMeasure> getMeasures() {
		return measures;
	}

	public void setMeasures(List<DRIDesignCrosstabMeasure> measures) {
		this.measures = measures;
	}
}

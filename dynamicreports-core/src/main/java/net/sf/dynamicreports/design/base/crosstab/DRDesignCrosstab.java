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
package net.sf.dynamicreports.design.base.crosstab;

import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstab;
import net.sf.dynamicreports.design.definition.crosstab.DRIDesignCrosstabMeasure;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.RunDirection;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRDesignCrosstab class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
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

    /**
     * <p>Constructor for DRDesignCrosstab.</p>
     */
    public DRDesignCrosstab() {
        super("crosstab");
    }

    /** {@inheritDoc} */
    @Override
    protected void init() {
        super.init();
        columnGroups = new ArrayList<DRDesignCrosstabColumnGroup>();
        rowGroups = new ArrayList<DRDesignCrosstabRowGroup>();
        cells = new ArrayList<DRDesignCrosstabCell>();
        measures = new ArrayList<DRIDesignCrosstabMeasure>();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignCrosstabDataset getDataset() {
        return dataset;
    }

    /**
     * <p>Setter for the field <code>dataset</code>.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabDataset} object.
     */
    public void setDataset(DRDesignCrosstabDataset dataset) {
        this.dataset = dataset;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean isRepeatColumnHeaders() {
        return repeatColumnHeaders;
    }

    /**
     * <p>Setter for the field <code>repeatColumnHeaders</code>.</p>
     *
     * @param repeatColumnHeaders a {@link java.lang.Boolean} object.
     */
    public void setRepeatColumnHeaders(Boolean repeatColumnHeaders) {
        this.repeatColumnHeaders = repeatColumnHeaders;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean isRepeatRowHeaders() {
        return repeatRowHeaders;
    }

    /**
     * <p>Setter for the field <code>repeatRowHeaders</code>.</p>
     *
     * @param repeatRowHeaders a {@link java.lang.Boolean} object.
     */
    public void setRepeatRowHeaders(Boolean repeatRowHeaders) {
        this.repeatRowHeaders = repeatRowHeaders;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getColumnBreakOffset() {
        return columnBreakOffset;
    }

    /**
     * <p>Setter for the field <code>columnBreakOffset</code>.</p>
     *
     * @param columnBreakOffset a {@link java.lang.Integer} object.
     */
    public void setColumnBreakOffset(Integer columnBreakOffset) {
        this.columnBreakOffset = columnBreakOffset;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getIgnoreWidth() {
        return ignoreWidth;
    }

    /**
     * <p>Setter for the field <code>ignoreWidth</code>.</p>
     *
     * @param ignoreWidth a {@link java.lang.Boolean} object.
     */
    public void setIgnoreWidth(Boolean ignoreWidth) {
        this.ignoreWidth = ignoreWidth;
    }

    /** {@inheritDoc} */
    @Override
    public RunDirection getRunDirection() {
        return runDirection;
    }

    /**
     * <p>Setter for the field <code>runDirection</code>.</p>
     *
     * @param runDirection a {@link net.sf.dynamicreports.report.constant.RunDirection} object.
     */
    public void setRunDirection(RunDirection runDirection) {
        this.runDirection = runDirection;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignCrosstabCellContent getWhenNoDataCell() {
        return whenNoDataCell;
    }

    /**
     * <p>Setter for the field <code>whenNoDataCell</code>.</p>
     *
     * @param whenNoDataCell a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCellContent} object.
     */
    public void setWhenNoDataCell(DRDesignCrosstabCellContent whenNoDataCell) {
        this.whenNoDataCell = whenNoDataCell;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignCrosstabCellContent getHeaderCell() {
        return headerCell;
    }

    /**
     * <p>Setter for the field <code>headerCell</code>.</p>
     *
     * @param headerCell a {@link net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstabCellContent} object.
     */
    public void setHeaderCell(DRDesignCrosstabCellContent headerCell) {
        this.headerCell = headerCell;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRDesignCrosstabColumnGroup> getColumnGroups() {
        return columnGroups;
    }

    /**
     * <p>Setter for the field <code>columnGroups</code>.</p>
     *
     * @param columnGroups a {@link java.util.List} object.
     */
    public void setColumnGroups(List<DRDesignCrosstabColumnGroup> columnGroups) {
        this.columnGroups = columnGroups;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRDesignCrosstabRowGroup> getRowGroups() {
        return rowGroups;
    }

    /**
     * <p>Setter for the field <code>rowGroups</code>.</p>
     *
     * @param rowGroups a {@link java.util.List} object.
     */
    public void setRowGroups(List<DRDesignCrosstabRowGroup> rowGroups) {
        this.rowGroups = rowGroups;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRDesignCrosstabCell> getCells() {
        return cells;
    }

    /**
     * <p>Setter for the field <code>cells</code>.</p>
     *
     * @param cells a {@link java.util.List} object.
     */
    public void setCells(List<DRDesignCrosstabCell> cells) {
        this.cells = cells;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIDesignCrosstabMeasure> getMeasures() {
        return measures;
    }

    /**
     * <p>Setter for the field <code>measures</code>.</p>
     *
     * @param measures a {@link java.util.List} object.
     */
    public void setMeasures(List<DRIDesignCrosstabMeasure> measures) {
        this.measures = measures;
    }
}

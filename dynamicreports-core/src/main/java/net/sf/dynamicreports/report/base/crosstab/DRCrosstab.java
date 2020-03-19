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
package net.sf.dynamicreports.report.base.crosstab;

import net.sf.dynamicreports.report.base.component.DRDimensionComponent;
import net.sf.dynamicreports.report.base.style.DRSimpleStyle;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstab;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabColumnGroup;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabMeasure;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabRowGroup;
import net.sf.dynamicreports.report.definition.crosstab.DRICrosstabVariable;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRCrosstab class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class DRCrosstab extends DRDimensionComponent implements DRICrosstab {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRCrosstabDataset dataset;
    private Boolean repeatColumnHeaders;
    private Boolean repeatRowHeaders;
    private Integer columnBreakOffset;
    private Boolean ignoreWidth;
    private RunDirection runDirection;
    private Integer cellWidth;
    private Integer cellHeight;
    private Boolean highlightOddRows;
    private DRSimpleStyle oddRowStyle;
    private Boolean highlightEvenRows;
    private DRSimpleStyle evenRowStyle;
    private DRIReportStyle groupStyle;
    private DRIReportStyle groupTotalStyle;
    private DRIReportStyle grandTotalStyle;
    private DRIReportStyle cellStyle;
    private DRIReportStyle measureTitleStyle;
    private DRCrosstabCellContent whenNoDataCell;
    private DRCrosstabCellContent headerCell;
    private List<DRICrosstabColumnGroup<?>> columnGroups;
    private List<DRICrosstabRowGroup<?>> rowGroups;
    private List<DRICrosstabVariable<?>> variables;
    private List<DRICrosstabMeasure<?>> measures;

    /** {@inheritDoc} */
    @Override
    protected void init() {
        super.init();
        dataset = new DRCrosstabDataset();
        columnGroups = new ArrayList<DRICrosstabColumnGroup<?>>();
        rowGroups = new ArrayList<DRICrosstabRowGroup<?>>();
        variables = new ArrayList<DRICrosstabVariable<?>>();
        measures = new ArrayList<DRICrosstabMeasure<?>>();

        whenNoDataCell = new DRCrosstabCellContent();
        headerCell = new DRCrosstabCellContent();
    }

    /** {@inheritDoc} */
    @Override
    public DRCrosstabDataset getDataset() {
        return dataset;
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
    public DRCrosstabCellContent getWhenNoDataCell() {
        return whenNoDataCell;
    }

    /** {@inheritDoc} */
    @Override
    public DRCrosstabCellContent getHeaderCell() {
        return headerCell;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRICrosstabColumnGroup<?>> getColumnGroups() {
        return columnGroups;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getCellWidth() {
        return cellWidth;
    }

    /**
     * <p>Setter for the field <code>cellWidth</code>.</p>
     *
     * @param cellWidth a {@link java.lang.Integer} object.
     */
    public void setCellWidth(Integer cellWidth) {
        this.cellWidth = cellWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getCellHeight() {
        return cellHeight;
    }

    /**
     * <p>Setter for the field <code>cellHeight</code>.</p>
     *
     * @param cellHeight a {@link java.lang.Integer} object.
     */
    public void setCellHeight(Integer cellHeight) {
        this.cellHeight = cellHeight;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getHighlightOddRows() {
        return highlightOddRows;
    }

    /**
     * <p>Setter for the field <code>highlightOddRows</code>.</p>
     *
     * @param highlightOddRows a {@link java.lang.Boolean} object.
     */
    public void setHighlightOddRows(Boolean highlightOddRows) {
        this.highlightOddRows = highlightOddRows;
    }

    /** {@inheritDoc} */
    @Override
    public DRSimpleStyle getOddRowStyle() {
        return oddRowStyle;
    }

    /**
     * <p>Setter for the field <code>oddRowStyle</code>.</p>
     *
     * @param oddRowStyle a {@link net.sf.dynamicreports.report.base.style.DRSimpleStyle} object.
     */
    public void setOddRowStyle(DRSimpleStyle oddRowStyle) {
        this.oddRowStyle = oddRowStyle;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getHighlightEvenRows() {
        return highlightEvenRows;
    }

    /**
     * <p>Setter for the field <code>highlightEvenRows</code>.</p>
     *
     * @param highlightEvenRows a {@link java.lang.Boolean} object.
     */
    public void setHighlightEvenRows(Boolean highlightEvenRows) {
        this.highlightEvenRows = highlightEvenRows;
    }

    /** {@inheritDoc} */
    @Override
    public DRSimpleStyle getEvenRowStyle() {
        return evenRowStyle;
    }

    /**
     * <p>Setter for the field <code>evenRowStyle</code>.</p>
     *
     * @param evenRowStyle a {@link net.sf.dynamicreports.report.base.style.DRSimpleStyle} object.
     */
    public void setEvenRowStyle(DRSimpleStyle evenRowStyle) {
        this.evenRowStyle = evenRowStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getGroupStyle() {
        return groupStyle;
    }

    /**
     * <p>Setter for the field <code>groupStyle</code>.</p>
     *
     * @param groupStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setGroupStyle(DRIReportStyle groupStyle) {
        this.groupStyle = groupStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getGroupTotalStyle() {
        return groupTotalStyle;
    }

    /**
     * <p>Setter for the field <code>groupTotalStyle</code>.</p>
     *
     * @param groupTotalStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setGroupTotalStyle(DRIReportStyle groupTotalStyle) {
        this.groupTotalStyle = groupTotalStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getGrandTotalStyle() {
        return grandTotalStyle;
    }

    /**
     * <p>Setter for the field <code>grandTotalStyle</code>.</p>
     *
     * @param grandTotalStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setGrandTotalStyle(DRIReportStyle grandTotalStyle) {
        this.grandTotalStyle = grandTotalStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getCellStyle() {
        return cellStyle;
    }

    /**
     * <p>Setter for the field <code>cellStyle</code>.</p>
     *
     * @param cellStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setCellStyle(DRIReportStyle cellStyle) {
        this.cellStyle = cellStyle;
    }

    /** {@inheritDoc} */
    @Override
    public DRIReportStyle getMeasureTitleStyle() {
        return measureTitleStyle;
    }

    /**
     * <p>Setter for the field <code>measureTitleStyle</code>.</p>
     *
     * @param measureTitleStyle a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public void setMeasureTitleStyle(DRIReportStyle measureTitleStyle) {
        this.measureTitleStyle = measureTitleStyle;
    }

    /**
     * <p>addColumnGroup.</p>
     *
     * @param columnGroup a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabColumnGroup} object.
     */
    public void addColumnGroup(DRICrosstabColumnGroup<?> columnGroup) {
        Validate.notNull(columnGroup, "columnGroup must not be null");
        this.columnGroups.add(columnGroup);
    }

    /** {@inheritDoc} */
    @Override
    public List<DRICrosstabRowGroup<?>> getRowGroups() {
        return rowGroups;
    }

    /**
     * <p>addRowGroup.</p>
     *
     * @param rowGroup a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabRowGroup} object.
     */
    public void addRowGroup(DRICrosstabRowGroup<?> rowGroup) {
        Validate.notNull(rowGroup, "rowGroup must not be null");
        this.rowGroups.add(rowGroup);
    }

    /** {@inheritDoc} */
    @Override
    public List<DRICrosstabVariable<?>> getVariables() {
        return variables;
    }

    /**
     * <p>addVariable.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabVariable} object.
     */
    public void addVariable(DRICrosstabVariable<?> variable) {
        Validate.notNull(variable, "variable must not be null");
        this.variables.add(variable);
    }

    /** {@inheritDoc} */
    @Override
    public List<DRICrosstabMeasure<?>> getMeasures() {
        return measures;
    }

    /**
     * <p>addMeasure.</p>
     *
     * @param measure a {@link net.sf.dynamicreports.report.definition.crosstab.DRICrosstabMeasure} object.
     */
    public void addMeasure(DRICrosstabMeasure<?> measure) {
        Validate.notNull(measure, "measure must not be null");
        this.measures.add(measure);
    }
}

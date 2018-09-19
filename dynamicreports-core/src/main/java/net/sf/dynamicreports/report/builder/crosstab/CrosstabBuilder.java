/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.report.builder.crosstab;

import net.sf.dynamicreports.report.base.crosstab.DRCrosstab;
import net.sf.dynamicreports.report.builder.DatasetBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.DimensionComponentBuilder;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.commons.lang3.Validate;

import java.sql.Connection;

/**
 * <p>CrosstabBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class CrosstabBuilder extends DimensionComponentBuilder<CrosstabBuilder, DRCrosstab> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for CrosstabBuilder.</p>
     */
    protected CrosstabBuilder() {
        super(new DRCrosstab());
    }

    /**
     * <p>setRepeatColumnHeaders.</p>
     *
     * @param repeatColumnHeaders a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setRepeatColumnHeaders(Boolean repeatColumnHeaders) {
        getObject().setRepeatColumnHeaders(repeatColumnHeaders);
        return this;
    }

    /**
     * <p>setRepeatRowHeaders.</p>
     *
     * @param repeatRowHeaders a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setRepeatRowHeaders(Boolean repeatRowHeaders) {
        getObject().setRepeatRowHeaders(repeatRowHeaders);
        return this;
    }

    /**
     * <p>setColumnBreakOffset.</p>
     *
     * @param columnBreakOffset a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setColumnBreakOffset(Integer columnBreakOffset) {
        getObject().setColumnBreakOffset(columnBreakOffset);
        return this;
    }

    /**
     * <p>setIgnoreWidth.</p>
     *
     * @param ignoreWidth a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setIgnoreWidth(Boolean ignoreWidth) {
        getObject().setIgnoreWidth(ignoreWidth);
        return this;
    }

    /**
     * <p>setRunDirection.</p>
     *
     * @param runDirection a {@link net.sf.dynamicreports.report.constant.RunDirection} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setRunDirection(RunDirection runDirection) {
        getObject().setRunDirection(runDirection);
        return this;
    }

    /**
     * <p>setCellWidth.</p>
     *
     * @param cellWidth a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setCellWidth(Integer cellWidth) {
        getObject().setCellWidth(cellWidth);
        return this;
    }

    /**
     * <p>setCellHeight.</p>
     *
     * @param cellHeight a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setCellHeight(Integer cellHeight) {
        getObject().setCellHeight(cellHeight);
        return this;
    }

    /**
     * <p>highlightOddRows.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder highlightOddRows() {
        return setHighlightOddRows(true);
    }

    /**
     * <p>setHighlightOddRows.</p>
     *
     * @param highlightOddRows a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setHighlightOddRows(Boolean highlightOddRows) {
        getObject().setHighlightOddRows(highlightOddRows);
        return this;
    }

    /**
     * <p>setOddRowStyle.</p>
     *
     * @param oddRowStyle a {@link net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setOddRowStyle(SimpleStyleBuilder oddRowStyle) {
        if (oddRowStyle != null) {
            getObject().setOddRowStyle(oddRowStyle.build());
        } else {
            getObject().setOddRowStyle(null);
        }
        return this;
    }

    /**
     * <p>setGroupStyle.</p>
     *
     * @param groupStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setGroupStyle(ReportStyleBuilder groupStyle) {
        if (groupStyle != null) {
            getObject().setGroupStyle(groupStyle.build());
        } else {
            getObject().setGroupStyle(null);
        }
        return this;
    }

    /**
     * <p>setGroupTotalStyle.</p>
     *
     * @param groupTotalStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setGroupTotalStyle(ReportStyleBuilder groupTotalStyle) {
        if (groupTotalStyle != null) {
            getObject().setGroupTotalStyle(groupTotalStyle.build());
        } else {
            getObject().setGroupTotalStyle(null);
        }
        return this;
    }

    /**
     * <p>setGrandTotalStyle.</p>
     *
     * @param grandTotalStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setGrandTotalStyle(ReportStyleBuilder grandTotalStyle) {
        if (grandTotalStyle != null) {
            getObject().setGrandTotalStyle(grandTotalStyle.build());
        } else {
            getObject().setGrandTotalStyle(null);
        }
        return this;
    }

    /**
     * <p>setCellStyle.</p>
     *
     * @param cellStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setCellStyle(ReportStyleBuilder cellStyle) {
        if (cellStyle != null) {
            getObject().setCellStyle(cellStyle.build());
        } else {
            getObject().setCellStyle(null);
        }
        return this;
    }

    /**
     * <p>setMeasureTitleStyle.</p>
     *
     * @param measureTitleStyle a {@link net.sf.dynamicreports.report.builder.style.ReportStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setMeasureTitleStyle(ReportStyleBuilder measureTitleStyle) {
        if (measureTitleStyle != null) {
            getObject().setMeasureTitleStyle(measureTitleStyle.build());
        } else {
            getObject().setMeasureTitleStyle(null);
        }
        return this;
    }

    /**
     * <p>highlightEvenRows.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder highlightEvenRows() {
        return setHighlightEvenRows(true);
    }

    /**
     * <p>setHighlightEvenRows.</p>
     *
     * @param highlightEvenRows a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setHighlightEvenRows(Boolean highlightEvenRows) {
        getObject().setHighlightEvenRows(highlightEvenRows);
        return this;
    }

    /**
     * <p>setEvenRowStyle.</p>
     *
     * @param evenRowStyle a {@link net.sf.dynamicreports.report.builder.style.SimpleStyleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setEvenRowStyle(SimpleStyleBuilder evenRowStyle) {
        if (evenRowStyle != null) {
            getObject().setEvenRowStyle(evenRowStyle.build());
        } else {
            getObject().setEvenRowStyle(null);
        }
        return this;
    }

    /**
     * <p>whenNoDataCell.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder whenNoDataCell(ComponentBuilder<?, ?>... components) {
        return addWhenNoDataCell(components);
    }

    /**
     * <p>addWhenNoDataCell.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder addWhenNoDataCell(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getWhenNoDataCell()
                       .addComponent(component.build());
        }
        return this;
    }

    /**
     * <p>headerCell.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder headerCell(ComponentBuilder<?, ?>... components) {
        return addHeaderCell(components);
    }

    /**
     * <p>addHeaderCell.</p>
     *
     * @param components a {@link net.sf.dynamicreports.report.builder.component.ComponentBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder addHeaderCell(ComponentBuilder<?, ?>... components) {
        Validate.notNull(components, "components must not be null");
        Validate.noNullElements(components, "components must not contains null component");
        for (ComponentBuilder<?, ?> component : components) {
            getObject().getHeaderCell()
                       .addComponent(component.build());
        }
        return this;
    }

    /**
     * <p>columnGroups.</p>
     *
     * @param columnGroups a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder columnGroups(CrosstabColumnGroupBuilder<?>... columnGroups) {
        return addColumnGroup(columnGroups);
    }

    /**
     * <p>addColumnGroup.</p>
     *
     * @param columnGroups a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder addColumnGroup(CrosstabColumnGroupBuilder<?>... columnGroups) {
        Validate.notNull(columnGroups, "columnGroups must not be null");
        Validate.noNullElements(columnGroups, "columnGroups must not contains null columnGroup");
        for (CrosstabColumnGroupBuilder<?> columnGroup : columnGroups) {
            getObject().addColumnGroup(columnGroup.build());
        }
        return this;
    }

    /**
     * <p>rowGroups.</p>
     *
     * @param rowGroups a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder rowGroups(CrosstabRowGroupBuilder<?>... rowGroups) {
        return addRowGroup(rowGroups);
    }

    /**
     * <p>addRowGroup.</p>
     *
     * @param rowGroups a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder addRowGroup(CrosstabRowGroupBuilder<?>... rowGroups) {
        Validate.notNull(rowGroups, "rowGroups must not be null");
        Validate.noNullElements(rowGroups, "rowGroups must not contains null rowGroup");
        for (CrosstabRowGroupBuilder<?> rowGroup : rowGroups) {
            getObject().addRowGroup(rowGroup.build());
        }
        return this;
    }

    /**
     * <p>variables.</p>
     *
     * @param variables a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabVariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder variables(CrosstabVariableBuilder<?>... variables) {
        return addVariable(variables);
    }

    /**
     * <p>addVariable.</p>
     *
     * @param variables a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabVariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder addVariable(CrosstabVariableBuilder<?>... variables) {
        Validate.notNull(variables, "variables must not be null");
        Validate.noNullElements(variables, "variables must not contains null measure");
        for (CrosstabVariableBuilder<?> variable : variables) {
            getObject().addVariable(variable.build());
        }
        return this;
    }

    /**
     * <p>measures.</p>
     *
     * @param measures a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder measures(CrosstabMeasureBuilder<?>... measures) {
        return addMeasure(measures);
    }

    /**
     * <p>addMeasure.</p>
     *
     * @param measures a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder addMeasure(CrosstabMeasureBuilder<?>... measures) {
        Validate.notNull(measures, "measures must not be null");
        Validate.noNullElements(measures, "measures must not contains null measure");
        for (CrosstabMeasureBuilder<?> measure : measures) {
            getObject().addMeasure(measure.build());
        }
        return this;
    }

    // subdataset

    /**
     * <p>setSubDataset.</p>
     *
     * @param subDataset a {@link net.sf.dynamicreports.report.builder.DatasetBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setSubDataset(DatasetBuilder subDataset) {
        Validate.notNull(subDataset, "subDataset must not be null");
        getObject().getDataset()
                   .setSubDataset(subDataset.build());
        return this;
    }

    /**
     * <p>setDataSource.</p>
     *
     * @param dataSource a {@link net.sf.jasperreports.engine.JRDataSource} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setDataSource(JRDataSource dataSource) {
        DatasetBuilder dataset = DynamicReports.dataset();
        dataset.setDataSource(dataSource);
        return setSubDataset(dataset);
    }

    /**
     * <p>setDataSource.</p>
     *
     * @param sql a {@link java.lang.String} object.
     * @param connection a {@link java.sql.Connection} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setDataSource(String sql, Connection connection) {
        DatasetBuilder dataset = DynamicReports.dataset();
        dataset.setDataSource(sql, connection);
        return setSubDataset(dataset);
    }

    /**
     * <p>setDataPreSorted.</p>
     *
     * @param dataPreSorted a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder} object.
     */
    public CrosstabBuilder setDataPreSorted(Boolean dataPreSorted) {
        getObject().getDataset()
                   .setDataPreSorted(dataPreSorted);
        return this;
    }
}

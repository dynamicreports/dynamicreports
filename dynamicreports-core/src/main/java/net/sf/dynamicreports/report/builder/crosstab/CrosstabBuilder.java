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

package net.sf.dynamicreports.report.builder.crosstab;

import java.sql.Connection;

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

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class CrosstabBuilder extends DimensionComponentBuilder<CrosstabBuilder, DRCrosstab> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected CrosstabBuilder() {
		super(new DRCrosstab());
	}

	public CrosstabBuilder setRepeatColumnHeaders(Boolean repeatColumnHeaders) {
		getObject().setRepeatColumnHeaders(repeatColumnHeaders);
		return this;
	}

	public CrosstabBuilder setRepeatRowHeaders(Boolean repeatRowHeaders) {
		getObject().setRepeatRowHeaders(repeatRowHeaders);
		return this;
	}

	public CrosstabBuilder setColumnBreakOffset(Integer columnBreakOffset) {
		getObject().setColumnBreakOffset(columnBreakOffset);
		return this;
	}

	public CrosstabBuilder setIgnoreWidth(Boolean ignoreWidth) {
		getObject().setIgnoreWidth(ignoreWidth);
		return this;
	}

	public CrosstabBuilder setRunDirection(RunDirection runDirection) {
		getObject().setRunDirection(runDirection);
		return this;
	}

	public CrosstabBuilder setCellWidth(Integer cellWidth) {
		getObject().setCellWidth(cellWidth);
		return this;
	}

	public CrosstabBuilder setCellHeight(Integer cellHeight) {
		getObject().setCellHeight(cellHeight);
		return this;
	}

	public CrosstabBuilder highlightOddRows() {
		return setHighlightOddRows(true);
	}

	public CrosstabBuilder setHighlightOddRows(Boolean highlightOddRows) {
		getObject().setHighlightOddRows(highlightOddRows);
		return this;
	}

	public CrosstabBuilder setOddRowStyle(SimpleStyleBuilder oddRowStyle) {
		if (oddRowStyle != null) {
			getObject().setOddRowStyle(oddRowStyle.build());
		} else {
			getObject().setOddRowStyle(null);
		}
		return this;
	}

	public CrosstabBuilder setGroupStyle(ReportStyleBuilder groupStyle) {
		if (groupStyle != null) {
			getObject().setGroupStyle(groupStyle.build());
		} else {
			getObject().setGroupStyle(null);
		}
		return this;
	}

	public CrosstabBuilder setGroupTotalStyle(ReportStyleBuilder groupTotalStyle) {
		if (groupTotalStyle != null) {
			getObject().setGroupTotalStyle(groupTotalStyle.build());
		} else {
			getObject().setGroupTotalStyle(null);
		}
		return this;
	}

	public CrosstabBuilder setGrandTotalStyle(ReportStyleBuilder grandTotalStyle) {
		if (grandTotalStyle != null) {
			getObject().setGrandTotalStyle(grandTotalStyle.build());
		} else {
			getObject().setGrandTotalStyle(null);
		}
		return this;
	}

	public CrosstabBuilder setCellStyle(ReportStyleBuilder cellStyle) {
		if (cellStyle != null) {
			getObject().setCellStyle(cellStyle.build());
		} else {
			getObject().setCellStyle(null);
		}
		return this;
	}

	public CrosstabBuilder setMeasureTitleStyle(ReportStyleBuilder measureTitleStyle) {
		if (measureTitleStyle != null) {
			getObject().setMeasureTitleStyle(measureTitleStyle.build());
		} else {
			getObject().setMeasureTitleStyle(null);
		}
		return this;
	}

	public CrosstabBuilder highlightEvenRows() {
		return setHighlightEvenRows(true);
	}

	public CrosstabBuilder setHighlightEvenRows(Boolean highlightEvenRows) {
		getObject().setHighlightEvenRows(highlightEvenRows);
		return this;
	}

	public CrosstabBuilder setEvenRowStyle(SimpleStyleBuilder evenRowStyle) {
		if (evenRowStyle != null) {
			getObject().setEvenRowStyle(evenRowStyle.build());
		} else {
			getObject().setEvenRowStyle(null);
		}
		return this;
	}

	public CrosstabBuilder whenNoDataCell(ComponentBuilder<?, ?>... components) {
		return addWhenNoDataCell(components);
	}

	public CrosstabBuilder addWhenNoDataCell(ComponentBuilder<?, ?>... components) {
		Validate.notNull(components, "components must not be null");
		Validate.noNullElements(components, "components must not contains null component");
		for (ComponentBuilder<?, ?> component : components) {
			getObject().getWhenNoDataCell().addComponent(component.build());
		}
		return this;
	}

	public CrosstabBuilder headerCell(ComponentBuilder<?, ?>... components) {
		return addHeaderCell(components);
	}

	public CrosstabBuilder addHeaderCell(ComponentBuilder<?, ?>... components) {
		Validate.notNull(components, "components must not be null");
		Validate.noNullElements(components, "components must not contains null component");
		for (ComponentBuilder<?, ?> component : components) {
			getObject().getHeaderCell().addComponent(component.build());
		}
		return this;
	}

	public CrosstabBuilder columnGroups(CrosstabColumnGroupBuilder<?>... columnGroups) {
		return addColumnGroup(columnGroups);
	}

	public CrosstabBuilder addColumnGroup(CrosstabColumnGroupBuilder<?>... columnGroups) {
		Validate.notNull(columnGroups, "columnGroups must not be null");
		Validate.noNullElements(columnGroups, "columnGroups must not contains null columnGroup");
		for (CrosstabColumnGroupBuilder<?> columnGroup : columnGroups) {
			getObject().addColumnGroup(columnGroup.build());
		}
		return this;
	}

	public CrosstabBuilder rowGroups(CrosstabRowGroupBuilder<?>... rowGroups) {
		return addRowGroup(rowGroups);
	}

	public CrosstabBuilder addRowGroup(CrosstabRowGroupBuilder<?>... rowGroups) {
		Validate.notNull(rowGroups, "rowGroups must not be null");
		Validate.noNullElements(rowGroups, "rowGroups must not contains null rowGroup");
		for (CrosstabRowGroupBuilder<?> rowGroup : rowGroups) {
			getObject().addRowGroup(rowGroup.build());
		}
		return this;
	}

	public CrosstabBuilder variables(CrosstabVariableBuilder<?>... variables) {
		return addVariable(variables);
	}

	public CrosstabBuilder addVariable(CrosstabVariableBuilder<?>... variables) {
		Validate.notNull(variables, "variables must not be null");
		Validate.noNullElements(variables, "variables must not contains null measure");
		for (CrosstabVariableBuilder<?> variable : variables) {
			getObject().addVariable(variable.build());
		}
		return this;
	}

	public CrosstabBuilder measures(CrosstabMeasureBuilder<?>... measures) {
		return addMeasure(measures);
	}

	public CrosstabBuilder addMeasure(CrosstabMeasureBuilder<?>... measures) {
		Validate.notNull(measures, "measures must not be null");
		Validate.noNullElements(measures, "measures must not contains null measure");
		for (CrosstabMeasureBuilder<?> measure : measures) {
			getObject().addMeasure(measure.build());
		}
		return this;
	}

	// subdataset
	public CrosstabBuilder setSubDataset(DatasetBuilder subDataset) {
		Validate.notNull(subDataset, "subDataset must not be null");
		getObject().getDataset().setSubDataset(subDataset.build());
		return this;
	}

	public CrosstabBuilder setDataSource(JRDataSource dataSource) {
		DatasetBuilder dataset = DynamicReports.dataset();
		dataset.setDataSource(dataSource);
		return setSubDataset(dataset);
	}

	public CrosstabBuilder setDataSource(String sql, Connection connection) {
		DatasetBuilder dataset = DynamicReports.dataset();
		dataset.setDataSource(sql, connection);
		return setSubDataset(dataset);
	}

	public CrosstabBuilder setDataPreSorted(Boolean dataPreSorted) {
		getObject().getDataset().setDataPreSorted(dataPreSorted);
		return this;
	}
}

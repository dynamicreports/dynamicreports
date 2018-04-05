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

package net.sf.dynamicreports.report.builder.chart;

import java.util.Date;

import net.sf.dynamicreports.report.base.chart.dataset.DRTimeSeriesDataset;
import net.sf.dynamicreports.report.base.chart.plot.DRAxisPlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.TimePeriod;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings("unchecked")
public abstract class AbstractTimeSeriesChartBuilder<T extends AbstractTimeSeriesChartBuilder<T, U>, U extends DRAxisPlot>
		extends AbstractBaseChartBuilder<T, U, DRTimeSeriesDataset> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected AbstractTimeSeriesChartBuilder(ChartType chartType) {
		super(chartType);
	}

	// dataset
	public T setTimePeriod(ValueColumnBuilder<?, ? extends Date> column) {
		Validate.notNull(column, "column must not be null");
		getDataset().setValueExpression(column.getColumn());
		return (T) this;
	}

	public T setTimePeriod(String fieldName, Class<? extends Date> valueClass) {
		return setTimePeriod(DynamicReports.field(fieldName, valueClass));
	}

	public T setTimePeriod(FieldBuilder<? extends Date> field) {
		Validate.notNull(field, "field must not be null");
		getDataset().setValueExpression(field.build());
		return (T) this;
	}

	public T setTimePeriod(DRIExpression<? extends Date> expression) {
		getDataset().setValueExpression(expression);
		return (T) this;
	}

	public T series(CategoryChartSerieBuilder... chartSeries) {
		return addSerie(chartSeries);
	}

	public T addSerie(CategoryChartSerieBuilder... chartSeries) {
		Validate.notNull(chartSeries, "chartSeries must not be null");
		Validate.noNullElements(chartSeries, "chartSeries must not contains null chartSerie");
		for (CategoryChartSerieBuilder chartSerie : chartSeries) {
			getDataset().addSerie(chartSerie.build());
		}
		return (T) this;
	}

	public T setTimePeriodType(TimePeriod timePeriodType) {
		getDataset().setTimePeriodType(timePeriodType);
		return (T) this;
	}

	public T setItemHyperLink(HyperLinkBuilder itemHyperLink) {
		Validate.notNull(itemHyperLink, "itemHyperLink must not be null");
		getDataset().setItemHyperLink(itemHyperLink.build());
		return (T) this;
	}

	// plot
	public T setTimeAxisFormat(AxisFormatBuilder timeAxisFormat) {
		Validate.notNull(timeAxisFormat, "timeAxisFormat must not be null");
		getPlot().setXAxisFormat(timeAxisFormat.build());
		return (T) this;
	}

	public T setValueAxisFormat(AxisFormatBuilder valueAxisFormat) {
		Validate.notNull(valueAxisFormat, "valueAxisFormat must not be null");
		getPlot().setYAxisFormat(valueAxisFormat.build());
		return (T) this;
	}

	public T setShowValues(Boolean showValues) {
		getPlot().setShowValues(showValues);
		return (T) this;
	}

	public T setValuePattern(String valuePattern) {
		getPlot().setValuePattern(valuePattern);
		return (T) this;
	}

	public T setPercentValuePattern(String percentValuePattern) {
		getPlot().setPercentValuePattern(percentValuePattern);
		return (T) this;
	}
}

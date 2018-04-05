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

import java.awt.Color;

import net.sf.dynamicreports.report.base.chart.dataset.DRValueDataset;
import net.sf.dynamicreports.report.base.chart.plot.DRThermometerPlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ValueLocation;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ThermometerChartBuilder extends AbstractChartBuilder<ThermometerChartBuilder> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected ThermometerChartBuilder() {
		super(ChartType.THERMOMETER);
	}

	public ThermometerChartBuilder setTheme(String theme) {
		getObject().setTheme(theme);
		return this;
	}

	// dataset
	public ThermometerChartBuilder setValue(Number value) {
		getDataset().setValueExpression(Expressions.number(value));
		return this;
	}

	public ThermometerChartBuilder setValue(ValueColumnBuilder<?, ? extends Number> column) {
		Validate.notNull(column, "column must not be null");
		getDataset().setValueExpression(column.getColumn());
		return this;
	}

	public ThermometerChartBuilder setValue(String fieldName, Class<? extends Number> valueClass) {
		return setValue(DynamicReports.field(fieldName, valueClass));
	}

	public ThermometerChartBuilder setValue(FieldBuilder<? extends Number> field) {
		Validate.notNull(field, "field must not be null");
		getDataset().setValueExpression(field.build());
		return this;
	}

	public ThermometerChartBuilder setValue(DRIExpression<? extends Number> expression) {
		getDataset().setValueExpression(expression);
		return this;
	}

	// plot
	public ThermometerChartBuilder setDataRangeLowExpression(Number dataRangeLowValue) {
		getPlot().setDataRangeLowExpression(Expressions.number(dataRangeLowValue));
		return this;
	}

	public ThermometerChartBuilder setDataRangeLowExpression(DRIExpression<? extends Number> dataRangeLowExpression) {
		getPlot().setDataRangeLowExpression(dataRangeLowExpression);
		return this;
	}

	public ThermometerChartBuilder setDataRangeHighExpression(Number dataRangeHighValue) {
		getPlot().setDataRangeHighExpression(Expressions.number(dataRangeHighValue));
		return this;
	}

	public ThermometerChartBuilder setDataRangeHighExpression(DRIExpression<? extends Number> dataRangeHighExpression) {
		getPlot().setDataRangeHighExpression(dataRangeHighExpression);
		return this;
	}

	public ThermometerChartBuilder setValueColor(Color valueColor) {
		getPlot().setValueColor(valueColor);
		return this;
	}

	public ThermometerChartBuilder setValueMask(String valueMask) {
		getPlot().setValueMask(valueMask);
		return this;
	}

	public ThermometerChartBuilder setValueFont(FontBuilder valueFont) {
		Validate.notNull(valueFont, "valueFont must not be null");
		getPlot().setValueFont(valueFont.build());
		return this;
	}

	public ThermometerChartBuilder setValueLocation(ValueLocation valueLocation) {
		getPlot().setValueLocation(valueLocation);
		return this;
	}

	public ThermometerChartBuilder setMercuryColor(Color mercuryColor) {
		getPlot().setMercuryColor(mercuryColor);
		return this;
	}

	public ThermometerChartBuilder setLowDataRangeLowExpression(Number lowDataRangeLowValue) {
		getPlot().setLowDataRangeLowExpression(Expressions.number(lowDataRangeLowValue));
		return this;
	}

	public ThermometerChartBuilder setLowDataRangeLowExpression(DRIExpression<? extends Number> lowDataRangeLowExpression) {
		getPlot().setLowDataRangeLowExpression(lowDataRangeLowExpression);
		return this;
	}

	public ThermometerChartBuilder setLowDataRangeHighExpression(Number lowDataRangeHighValue) {
		getPlot().setLowDataRangeHighExpression(Expressions.number(lowDataRangeHighValue));
		return this;
	}

	public ThermometerChartBuilder setLowDataRangeHighExpression(DRIExpression<? extends Number> lowDataRangeHighExpression) {
		getPlot().setLowDataRangeHighExpression(lowDataRangeHighExpression);
		return this;
	}

	public ThermometerChartBuilder setMediumDataRangeLowExpression(Number mediumDataRangeLowValue) {
		getPlot().setMediumDataRangeLowExpression(Expressions.number(mediumDataRangeLowValue));
		return this;
	}

	public ThermometerChartBuilder setMediumDataRangeLowExpression(DRIExpression<? extends Number> mediumDataRangeLowExpression) {
		getPlot().setMediumDataRangeLowExpression(mediumDataRangeLowExpression);
		return this;
	}

	public ThermometerChartBuilder setMediumDataRangeHighExpression(Number mediumDataRangeHighValue) {
		getPlot().setMediumDataRangeHighExpression(Expressions.number(mediumDataRangeHighValue));
		return this;
	}

	public ThermometerChartBuilder setMediumDataRangeHighExpression(DRIExpression<? extends Number> mediumDataRangeHighExpression) {
		getPlot().setMediumDataRangeHighExpression(mediumDataRangeHighExpression);
		return this;
	}

	public ThermometerChartBuilder setHighDataRangeLowExpression(Number highDataRangeLowValue) {
		getPlot().setHighDataRangeLowExpression(Expressions.number(highDataRangeLowValue));
		return this;
	}

	public ThermometerChartBuilder setHighDataRangeLowExpression(DRIExpression<? extends Number> highDataRangeLowExpression) {
		getPlot().setHighDataRangeLowExpression(highDataRangeLowExpression);
		return this;
	}

	public ThermometerChartBuilder setHighDataRangeHighExpression(Number highDataRangeHighValue) {
		getPlot().setHighDataRangeHighExpression(Expressions.number(highDataRangeHighValue));
		return this;
	}

	public ThermometerChartBuilder setHighDataRangeHighExpression(DRIExpression<? extends Number> highDataRangeHighExpression) {
		getPlot().setHighDataRangeHighExpression(highDataRangeHighExpression);
		return this;
	}

	private DRValueDataset getDataset() {
		return (DRValueDataset) getObject().getDataset();
	}

	private DRThermometerPlot getPlot() {
		return (DRThermometerPlot) getObject().getPlot();
	}
}

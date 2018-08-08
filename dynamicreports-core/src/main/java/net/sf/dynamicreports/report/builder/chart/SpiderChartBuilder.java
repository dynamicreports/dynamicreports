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

import net.sf.dynamicreports.report.base.chart.dataset.DRCategoryDataset;
import net.sf.dynamicreports.report.base.chart.plot.DRSpiderPlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.SpiderRotation;
import net.sf.dynamicreports.report.constant.TableOrder;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class SpiderChartBuilder extends AbstractChartBuilder<SpiderChartBuilder> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected SpiderChartBuilder() {
		super(ChartType.SPIDER);
	}

	// dataset
	public SpiderChartBuilder setCategory(ValueColumnBuilder<?, String> column) {
		Validate.notNull(column, "column must not be null");
		getDataset().setValueExpression(column.getColumn());
		return this;
	}

	public SpiderChartBuilder setCategory(String fieldName, Class<String> valueClass) {
		return setCategory(DynamicReports.<String>field(fieldName, valueClass));
	}

	public SpiderChartBuilder setCategory(FieldBuilder<String> field) {
		Validate.notNull(field, "field must not be null");
		getDataset().setValueExpression(field.build());
		return this;
	}

	public SpiderChartBuilder setCategory(DRIExpression<String> expression) {
		getDataset().setValueExpression(expression);
		return this;
	}

	public SpiderChartBuilder series(CategoryChartSerieBuilder... chartSeries) {
		return addSerie(chartSeries);
	}

	public SpiderChartBuilder addSerie(CategoryChartSerieBuilder... chartSeries) {
		Validate.notNull(chartSeries, "chartSeries must not be null");
		Validate.noNullElements(chartSeries, "chartSeries must not contains null chartSerie");
		for (CategoryChartSerieBuilder chartSerie : chartSeries) {
			getDataset().addSerie(chartSerie.build());
		}
		return this;
	}

	public SpiderChartBuilder setItemHyperLink(HyperLinkBuilder itemHyperLink) {
		Validate.notNull(itemHyperLink, "itemHyperLink must not be null");
		getDataset().setItemHyperLink(itemHyperLink.build());
		return this;
	}

	// plot
	public SpiderChartBuilder setMaxValue(Double maxValue) {
		getPlot().setMaxValueExpression(Expressions.value(maxValue));
		return this;
	}

	public SpiderChartBuilder setMaxValue(DRIExpression<Double> maxValueExpression) {
		getPlot().setMaxValueExpression(maxValueExpression);
		return this;
	}

	public SpiderChartBuilder setRotation(SpiderRotation rotation) {
		getPlot().setRotation(rotation);
		return this;
	}

	public SpiderChartBuilder setTableOrder(TableOrder tableOrder) {
		getPlot().setTableOrder(tableOrder);
		return this;
	}

	public SpiderChartBuilder setWebFilled(Boolean webFilled) {
		getPlot().setWebFilled(webFilled);
		return this;
	}

	public SpiderChartBuilder setStartAngle(Double startAngle) {
		getPlot().setStartAngle(startAngle);
		return this;
	}

	public SpiderChartBuilder setHeadPercent(Double headPercent) {
		getPlot().setHeadPercent(headPercent);
		return this;
	}

	public SpiderChartBuilder setInteriorGap(Double interiorGap) {
		getPlot().setInteriorGap(interiorGap);
		return this;
	}

	public SpiderChartBuilder setAxisLineColor(Color axisLineColor) {
		getPlot().setAxisLineColor(axisLineColor);
		return this;
	}

	public SpiderChartBuilder setAxisLineWidth(Float axisLineWidth) {
		getPlot().setAxisLineWidth(axisLineWidth);
		return this;
	}

	public SpiderChartBuilder setLabelFont(FontBuilder labelFont) {
		Validate.notNull(labelFont, "labelFont must not be null");
		getPlot().setLabelFont(labelFont.build());
		return this;
	}

	public SpiderChartBuilder setLabelGap(Double labelGap) {
		getPlot().setLabelGap(labelGap);
		return this;
	}

	public SpiderChartBuilder setLabelColor(Color labelColor) {
		getPlot().setLabelColor(labelColor);
		return this;
	}

	private DRCategoryDataset getDataset() {
		return (DRCategoryDataset) getObject().getDataset();
	}

	private DRSpiderPlot getPlot() {
		return (DRSpiderPlot) getObject().getPlot();
	}
}

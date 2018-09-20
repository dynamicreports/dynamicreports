/*
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

import java.awt.Color;

/**
 * <p>SpiderChartBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class SpiderChartBuilder extends AbstractChartBuilder<SpiderChartBuilder> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for SpiderChartBuilder.</p>
     */
    protected SpiderChartBuilder() {
        super(ChartType.SPIDER);
    }

    // dataset

    /**
     * <p>setCategory.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setCategory(ValueColumnBuilder<?, String> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setValueExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setCategory.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setCategory(String fieldName, Class<String> valueClass) {
        return setCategory(DynamicReports.<String>field(fieldName, valueClass));
    }

    /**
     * <p>setCategory.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setCategory(FieldBuilder<String> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setValueExpression(field.build());
        return this;
    }

    /**
     * <p>setCategory.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setCategory(DRIExpression<String> expression) {
        getDataset().setValueExpression(expression);
        return this;
    }

    /**
     * <p>series.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder series(CategoryChartSerieBuilder... chartSeries) {
        return addSerie(chartSeries);
    }

    /**
     * <p>addSerie.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder addSerie(CategoryChartSerieBuilder... chartSeries) {
        Validate.notNull(chartSeries, "chartSeries must not be null");
        Validate.noNullElements(chartSeries, "chartSeries must not contains null chartSerie");
        for (CategoryChartSerieBuilder chartSerie : chartSeries) {
            getDataset().addSerie(chartSerie.build());
        }
        return this;
    }

    /**
     * <p>setItemHyperLink.</p>
     *
     * @param itemHyperLink a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setItemHyperLink(HyperLinkBuilder itemHyperLink) {
        Validate.notNull(itemHyperLink, "itemHyperLink must not be null");
        getDataset().setItemHyperLink(itemHyperLink.build());
        return this;
    }

    // plot

    /**
     * <p>setMaxValue.</p>
     *
     * @param maxValue a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setMaxValue(Double maxValue) {
        getPlot().setMaxValueExpression(Expressions.value(maxValue));
        return this;
    }

    /**
     * <p>setMaxValue.</p>
     *
     * @param maxValueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setMaxValue(DRIExpression<Double> maxValueExpression) {
        getPlot().setMaxValueExpression(maxValueExpression);
        return this;
    }

    /**
     * <p>setRotation.</p>
     *
     * @param rotation a {@link net.sf.dynamicreports.report.constant.SpiderRotation} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setRotation(SpiderRotation rotation) {
        getPlot().setRotation(rotation);
        return this;
    }

    /**
     * <p>setTableOrder.</p>
     *
     * @param tableOrder a {@link net.sf.dynamicreports.report.constant.TableOrder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setTableOrder(TableOrder tableOrder) {
        getPlot().setTableOrder(tableOrder);
        return this;
    }

    /**
     * <p>setWebFilled.</p>
     *
     * @param webFilled a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setWebFilled(Boolean webFilled) {
        getPlot().setWebFilled(webFilled);
        return this;
    }

    /**
     * <p>setStartAngle.</p>
     *
     * @param startAngle a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setStartAngle(Double startAngle) {
        getPlot().setStartAngle(startAngle);
        return this;
    }

    /**
     * <p>setHeadPercent.</p>
     *
     * @param headPercent a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setHeadPercent(Double headPercent) {
        getPlot().setHeadPercent(headPercent);
        return this;
    }

    /**
     * <p>setInteriorGap.</p>
     *
     * @param interiorGap a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setInteriorGap(Double interiorGap) {
        getPlot().setInteriorGap(interiorGap);
        return this;
    }

    /**
     * <p>setAxisLineColor.</p>
     *
     * @param axisLineColor a {@link java.awt.Color} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setAxisLineColor(Color axisLineColor) {
        getPlot().setAxisLineColor(axisLineColor);
        return this;
    }

    /**
     * <p>setAxisLineWidth.</p>
     *
     * @param axisLineWidth a {@link java.lang.Float} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setAxisLineWidth(Float axisLineWidth) {
        getPlot().setAxisLineWidth(axisLineWidth);
        return this;
    }

    /**
     * <p>setLabelFont.</p>
     *
     * @param labelFont a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setLabelFont(FontBuilder labelFont) {
        Validate.notNull(labelFont, "labelFont must not be null");
        getPlot().setLabelFont(labelFont.build());
        return this;
    }

    /**
     * <p>setLabelGap.</p>
     *
     * @param labelGap a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
    public SpiderChartBuilder setLabelGap(Double labelGap) {
        getPlot().setLabelGap(labelGap);
        return this;
    }

    /**
     * <p>setLabelColor.</p>
     *
     * @param labelColor a {@link java.awt.Color} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.SpiderChartBuilder} object.
     */
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

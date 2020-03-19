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
package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.report.base.chart.dataset.DRSeriesDataset;
import net.sf.dynamicreports.report.base.chart.plot.DRPiePlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>Abstract AbstractPieChartBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
@SuppressWarnings("unchecked")
public abstract class AbstractPieChartBuilder<T extends AbstractPieChartBuilder<T, U>, U extends DRPiePlot> extends AbstractBaseChartBuilder<T, U, DRSeriesDataset> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for AbstractPieChartBuilder.</p>
     *
     * @param chartType a {@link net.sf.dynamicreports.report.constant.ChartType} object.
     */
    protected AbstractPieChartBuilder(ChartType chartType) {
        super(chartType);
    }

    // dataset

    /**
     * <p>setKey.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a T object.
     */
    public T setKey(ValueColumnBuilder<?, String> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setValueExpression(column.getColumn());
        return (T) this;
    }

    /**
     * <p>setKey.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a T object.
     */
    public T setKey(String fieldName, Class<String> valueClass) {
        return setKey(DynamicReports.<String>field(fieldName, valueClass));
    }

    /**
     * <p>setKey.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a T object.
     */
    public T setKey(FieldBuilder<String> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setValueExpression(field.build());
        return (T) this;
    }

    /**
     * <p>setKey.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setKey(DRIExpression<String> expression) {
        getDataset().setValueExpression(expression);
        return (T) this;
    }

    /**
     * <p>series.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     * @return a T object.
     */
    public T series(CategoryChartSerieBuilder... chartSeries) {
        return addSerie(chartSeries);
    }

    /**
     * <p>addSerie.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.CategoryChartSerieBuilder} object.
     * @return a T object.
     */
    public T addSerie(CategoryChartSerieBuilder... chartSeries) {
        Validate.notNull(chartSeries, "chartSeries must not be null");
        Validate.noNullElements(chartSeries, "chartSeries must not contains null chartSerie");
        for (CategoryChartSerieBuilder chartSerie : chartSeries) {
            getDataset().addSerie(chartSerie.build());
        }
        return (T) this;
    }

    /**
     * <p>setItemHyperLink.</p>
     *
     * @param itemHyperLink a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
     * @return a T object.
     */
    public T setItemHyperLink(HyperLinkBuilder itemHyperLink) {
        Validate.notNull(itemHyperLink, "itemHyperLink must not be null");
        getDataset().setItemHyperLink(itemHyperLink.build());
        return (T) this;
    }

    // plot

    /**
     * <p>setCircular.</p>
     *
     * @param circular a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setCircular(Boolean circular) {
        getPlot().setCircular(circular);
        return (T) this;
    }

    /**
     * <p>setShowLabels.</p>
     *
     * @param showLabels a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setShowLabels(Boolean showLabels) {
        getPlot().setShowLabels(showLabels);
        return (T) this;
    }

    /**
     * <p>setShowValues.</p>
     *
     * @param showValues a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setShowValues(Boolean showValues) {
        getPlot().setShowValues(showValues);
        return (T) this;
    }

    /**
     * <p>setValuePattern.</p>
     *
     * @param valuePattern a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setValuePattern(String valuePattern) {
        getPlot().setValuePattern(valuePattern);
        return (T) this;
    }

    /**
     * <p>setShowPercentages.</p>
     *
     * @param showPercentages a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setShowPercentages(Boolean showPercentages) {
        getPlot().setShowPercentages(showPercentages);
        return (T) this;
    }

    /**
     * <p>setPercentValuePattern.</p>
     *
     * @param percentValuePattern a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setPercentValuePattern(String percentValuePattern) {
        getPlot().setPercentValuePattern(percentValuePattern);
        return (T) this;
    }

    /**
     * <p>setLabelFormat.</p>
     *
     * @param labelFormat a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setLabelFormat(String labelFormat) {
        getPlot().setLabelFormat(labelFormat);
        return (T) this;
    }

    /**
     * <p>setLegendLabelFormat.</p>
     *
     * @param legendLabelFormat a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setLegendLabelFormat(String legendLabelFormat) {
        getPlot().setLegendLabelFormat(legendLabelFormat);
        return (T) this;
    }
}

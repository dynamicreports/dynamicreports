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

import net.sf.dynamicreports.report.base.chart.dataset.DRCategoryDataset;
import net.sf.dynamicreports.report.base.chart.plot.DRAxisPlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.OrderType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Abstract AbstractCategoryChartBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
@SuppressWarnings("unchecked")
public abstract class AbstractCategoryChartBuilder<T extends AbstractCategoryChartBuilder<T, U>, U extends DRAxisPlot> extends AbstractBaseChartBuilder<T, U, DRCategoryDataset> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for AbstractCategoryChartBuilder.</p>
     *
     * @param chartType a {@link net.sf.dynamicreports.report.constant.ChartType} object.
     */
    protected AbstractCategoryChartBuilder(ChartType chartType) {
        super(chartType);
    }

    // dataset

    /**
     * <p>setCategory.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a T object.
     */
    public T setCategory(ValueColumnBuilder<?, String> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setValueExpression(column.getColumn());
        return (T) this;
    }

    /**
     * <p>setCategory.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a T object.
     */
    public T setCategory(String fieldName, Class<String> valueClass) {
        return setCategory(DynamicReports.<String>field(fieldName, valueClass));
    }

    /**
     * <p>setCategory.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a T object.
     */
    public T setCategory(FieldBuilder<String> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setValueExpression(field.build());
        return (T) this;
    }

    /**
     * <p>setCategory.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setCategory(DRIExpression<String> expression) {
        getDataset().setValueExpression(expression);
        return (T) this;
    }

    /**
     * <p>series.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.AbstractCategoryChartSerieBuilder} object.
     * @return a T object.
     */
    public T series(AbstractCategoryChartSerieBuilder<?, ?>... chartSeries) {
        return addSerie(chartSeries);
    }

    /**
     * <p>addSerie.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.AbstractCategoryChartSerieBuilder} object.
     * @return a T object.
     */
    public T addSerie(AbstractCategoryChartSerieBuilder<?, ?>... chartSeries) {
        Validate.notNull(chartSeries, "chartSeries must not be null");
        Validate.noNullElements(chartSeries, "chartSeries must not contains null chartSerie");
        for (AbstractCategoryChartSerieBuilder<?, ?> chartSerie : chartSeries) {
            getDataset().addSerie(chartSerie.build());
        }
        return (T) this;
    }

    /**
     * <p>setUseSeriesAsCategory.</p>
     *
     * @param useSeriesAsCategory a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setUseSeriesAsCategory(Boolean useSeriesAsCategory) {
        getDataset().setUseSeriesAsCategory(useSeriesAsCategory);
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
     * <p>setCategoryAxisFormat.</p>
     *
     * @param categoryAxisFormat a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     * @return a T object.
     */
    public T setCategoryAxisFormat(AxisFormatBuilder categoryAxisFormat) {
        Validate.notNull(categoryAxisFormat, "categoryAxisFormat must not be null");
        getPlot().setXAxisFormat(categoryAxisFormat.build());
        return (T) this;
    }

    /**
     * <p>setValueAxisFormat.</p>
     *
     * @param valueAxisFormat a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     * @return a T object.
     */
    public T setValueAxisFormat(AxisFormatBuilder valueAxisFormat) {
        Validate.notNull(valueAxisFormat, "valueAxisFormat must not be null");
        getPlot().setYAxisFormat(valueAxisFormat.build());
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
     * <p>setSeriesOrderBy.</p>
     *
     * @param seriesOrderBy a {@link java.util.Comparator} object.
     * @return a T object.
     */
    public T setSeriesOrderBy(Comparator<String> seriesOrderBy) {
        getPlot().setSeriesOrderBy(seriesOrderBy);
        return (T) this;
    }

    /**
     * <p>setSeriesOrderBy.</p>
     *
     * @param seriesOrderByNames a {@link java.util.List} object.
     * @return a T object.
     */
    public T setSeriesOrderBy(List<String> seriesOrderByNames) {
        getPlot().setSeriesOrderBy(new SeriesOrderByNamesComparator(seriesOrderByNames));
        return (T) this;
    }

    /**
     * <p>seriesOrderBy.</p>
     *
     * @param seriesOrderByNames a {@link java.lang.String} object.
     * @return a T object.
     */
    public T seriesOrderBy(String... seriesOrderByNames) {
        return setSeriesOrderBy(Arrays.asList(seriesOrderByNames));
    }

    /**
     * <p>setSeriesOrderType.</p>
     *
     * @param seriesOrderType a {@link net.sf.dynamicreports.report.constant.OrderType} object.
     * @return a T object.
     */
    public T setSeriesOrderType(OrderType seriesOrderType) {
        getPlot().setSeriesOrderType(seriesOrderType);
        return (T) this;
    }
}

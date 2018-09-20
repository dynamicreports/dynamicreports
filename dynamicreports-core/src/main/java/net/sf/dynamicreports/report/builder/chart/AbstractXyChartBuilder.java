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
import net.sf.dynamicreports.report.base.chart.plot.DRAxisPlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>Abstract AbstractXyChartBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
@SuppressWarnings("unchecked")
public abstract class AbstractXyChartBuilder<T extends AbstractXyChartBuilder<T, U>, U extends DRAxisPlot> extends AbstractBaseChartBuilder<T, U, DRSeriesDataset> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for AbstractXyChartBuilder.</p>
     *
     * @param chartType a {@link net.sf.dynamicreports.report.constant.ChartType} object.
     */
    protected AbstractXyChartBuilder(ChartType chartType) {
        super(chartType);
    }

    // dataset

    /**
     * <p>setXValue.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a T object.
     */
    public T setXValue(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setValueExpression(column.getColumn());
        return (T) this;
    }

    /**
     * <p>setXValue.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a T object.
     */
    public T setXValue(String fieldName, Class<? extends Number> valueClass) {
        return setXValue(DynamicReports.<Number>field(fieldName, valueClass));
    }

    /**
     * <p>setXValue.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a T object.
     */
    public T setXValue(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setValueExpression(field.build());
        return (T) this;
    }

    /**
     * <p>setXValue.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setXValue(DRIExpression<? extends Number> expression) {
        getDataset().setValueExpression(expression);
        return (T) this;
    }

    /**
     * <p>series.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     * @return a T object.
     */
    public T series(XyChartSerieBuilder... chartSeries) {
        return addSerie(chartSeries);
    }

    /**
     * <p>addSerie.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.XyChartSerieBuilder} object.
     * @return a T object.
     */
    public T addSerie(XyChartSerieBuilder... chartSeries) {
        Validate.notNull(chartSeries, "chartSeries must not be null");
        Validate.noNullElements(chartSeries, "chartSeries must not contains null chartSerie");
        for (XyChartSerieBuilder chartSerie : chartSeries) {
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
     * <p>setXAxisFormat.</p>
     *
     * @param xAxisFormat a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     * @return a T object.
     */
    public T setXAxisFormat(AxisFormatBuilder xAxisFormat) {
        Validate.notNull(xAxisFormat, "xAxisFormat must not be null");
        getPlot().setXAxisFormat(xAxisFormat.build());
        return (T) this;
    }

    /**
     * <p>setYAxisFormat.</p>
     *
     * @param yAxisFormat a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     * @return a T object.
     */
    public T setYAxisFormat(AxisFormatBuilder yAxisFormat) {
        Validate.notNull(yAxisFormat, "yAxisFormat must not be null");
        getPlot().setYAxisFormat(yAxisFormat.build());
        return (T) this;
    }

}

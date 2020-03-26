/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
import net.sf.dynamicreports.report.base.chart.plot.DRBarPlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

/**
 * <p>GanttChartBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class GanttChartBuilder extends AbstractBaseChartBuilder<GanttChartBuilder, DRBarPlot, DRSeriesDataset> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for GanttChartBuilder.</p>
     */
    protected GanttChartBuilder() {
        super(ChartType.GANTT);
    }

    // dataset

    /**
     * <p>setTask.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder setTask(ValueColumnBuilder<?, String> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setValueExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setTask.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder setTask(String fieldName, Class<String> valueClass) {
        return setTask(DynamicReports.<String>field(fieldName, valueClass));
    }

    /**
     * <p>setTask.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder setTask(FieldBuilder<String> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setValueExpression(field.build());
        return this;
    }

    /**
     * <p>setTask.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder setTask(DRIExpression<String> expression) {
        getDataset().setValueExpression(expression);
        return this;
    }

    /**
     * <p>series.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder series(GanttChartSerieBuilder... chartSeries) {
        return addSerie(chartSeries);
    }

    /**
     * <p>addSerie.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.GanttChartSerieBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder addSerie(GanttChartSerieBuilder... chartSeries) {
        Validate.notNull(chartSeries, "chartSeries must not be null");
        Validate.noNullElements(chartSeries, "chartSeries must not contains null chartSerie");
        for (GanttChartSerieBuilder chartSerie : chartSeries) {
            getDataset().addSerie(chartSerie.build());
        }
        return this;
    }

    /**
     * <p>setItemHyperLink.</p>
     *
     * @param itemHyperLink a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder setItemHyperLink(HyperLinkBuilder itemHyperLink) {
        Validate.notNull(itemHyperLink, "itemHyperLink must not be null");
        getDataset().setItemHyperLink(itemHyperLink.build());
        return this;
    }

    // plot

    /**
     * <p>setTimeAxisFormat.</p>
     *
     * @param timeAxisFormat a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder setTimeAxisFormat(AxisFormatBuilder timeAxisFormat) {
        Validate.notNull(timeAxisFormat, "timeAxisFormat must not be null");
        getPlot().setYAxisFormat(timeAxisFormat.build());
        return this;
    }

    /**
     * <p>setTaskAxisFormat.</p>
     *
     * @param taskAxisFormat a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder setTaskAxisFormat(AxisFormatBuilder taskAxisFormat) {
        Validate.notNull(taskAxisFormat, "taskAxisFormat must not be null");
        getPlot().setXAxisFormat(taskAxisFormat.build());
        return this;
    }

    /**
     * <p>setShowLabels.</p>
     *
     * @param showLabels a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder setShowLabels(Boolean showLabels) {
        getPlot().setShowLabels(showLabels);
        return this;
    }

    /**
     * <p>setShowTickLabels.</p>
     *
     * @param showTickLabels a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder setShowTickLabels(Boolean showTickLabels) {
        getPlot().setShowTickLabels(showTickLabels);
        return this;
    }

    /**
     * <p>setShowTickMarks.</p>
     *
     * @param showTickMarks a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.GanttChartBuilder} object.
     */
    public GanttChartBuilder setShowTickMarks(Boolean showTickMarks) {
        getPlot().setShowTickMarks(showTickMarks);
        return this;
    }
}

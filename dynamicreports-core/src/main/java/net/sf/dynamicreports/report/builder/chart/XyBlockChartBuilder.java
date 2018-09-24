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
import net.sf.dynamicreports.report.base.chart.plot.DRXyBlockPlot;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.RectangleAnchor;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

import java.awt.Paint;

/**
 * <p>XyBlockChartBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class XyBlockChartBuilder extends AbstractBaseChartBuilder<XyBlockChartBuilder, DRXyBlockPlot, DRSeriesDataset> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for XyBlockChartBuilder.</p>
     *
     * @param defaultLowerBound a double.
     * @param defaultUpperBound a double.
     * @param defaultPaint      a {@link java.awt.Paint} object.
     */
    protected XyBlockChartBuilder(double defaultLowerBound, double defaultUpperBound, Paint defaultPaint) {
        super(ChartType.XYBLOCK);
        Validate.isTrue(defaultLowerBound <= defaultUpperBound, "defaultLowerBound must be smaller than defaultUpperBound");
        getPlot().setDefaultLowerBound(defaultLowerBound);
        getPlot().setDefaultUpperBound(defaultUpperBound);
        getPlot().setDefaultPaint(defaultPaint);
    }

    // dataset

    /**
     * <p>setXValue.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder setXValue(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setValueExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setXValue.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder setXValue(String fieldName, Class<? extends Number> valueClass) {
        return setXValue(DynamicReports.<Number>field(fieldName, valueClass));
    }

    /**
     * <p>setXValue.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder setXValue(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setValueExpression(field.build());
        return this;
    }

    /**
     * <p>setXValue.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder setXValue(DRIExpression<? extends Number> expression) {
        getDataset().setValueExpression(expression);
        return this;
    }

    /**
     * <p>series.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder series(XyzChartSerieBuilder... chartSeries) {
        return addSerie(chartSeries);
    }

    /**
     * <p>addSerie.</p>
     *
     * @param chartSeries a {@link net.sf.dynamicreports.report.builder.chart.XyzChartSerieBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder addSerie(XyzChartSerieBuilder... chartSeries) {
        Validate.notNull(chartSeries, "chartSeries must not be null");
        Validate.noNullElements(chartSeries, "chartSeries must not contains null chartSerie");
        for (XyzChartSerieBuilder chartSerie : chartSeries) {
            getDataset().addSerie(chartSerie.build());
        }
        return this;
    }

    /**
     * <p>setItemHyperLink.</p>
     *
     * @param itemHyperLink a {@link net.sf.dynamicreports.report.builder.HyperLinkBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder setItemHyperLink(HyperLinkBuilder itemHyperLink) {
        Validate.notNull(itemHyperLink, "itemHyperLink must not be null");
        getDataset().setItemHyperLink(itemHyperLink.build());
        return this;
    }

    // plot

    /**
     * <p>setXAxisFormat.</p>
     *
     * @param xAxisFormat a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder setXAxisFormat(AxisFormatBuilder xAxisFormat) {
        Validate.notNull(xAxisFormat, "xAxisFormat must not be null");
        getPlot().setXAxisFormat(xAxisFormat.build());
        return this;
    }

    /**
     * <p>setYAxisFormat.</p>
     *
     * @param yAxisFormat a {@link net.sf.dynamicreports.report.builder.chart.AxisFormatBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder setYAxisFormat(AxisFormatBuilder yAxisFormat) {
        Validate.notNull(yAxisFormat, "yAxisFormat must not be null");
        getPlot().setYAxisFormat(yAxisFormat.build());
        return this;
    }

    /**
     * <p>setBlockWidth.</p>
     *
     * @param blockWidth a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder setBlockWidth(Double blockWidth) {
        getPlot().setBlockWidth(blockWidth);
        return this;
    }

    /**
     * <p>setBlockHeight.</p>
     *
     * @param blockHeight a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder setBlockHeight(Double blockHeight) {
        getPlot().setBlockHeight(blockHeight);
        return this;
    }

    /**
     * <p>setBlockAnchor.</p>
     *
     * @param blockAnchor a {@link net.sf.dynamicreports.report.constant.RectangleAnchor} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder setBlockAnchor(RectangleAnchor blockAnchor) {
        getPlot().setBlockAnchor(blockAnchor);
        return this;
    }

    /**
     * <p>paintScales.</p>
     *
     * @param paintScales a {@link net.sf.dynamicreports.report.builder.chart.PaintScaleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder paintScales(PaintScaleBuilder... paintScales) {
        return addPaintScale(paintScales);
    }

    /**
     * <p>addPaintScale.</p>
     *
     * @param paintScales a {@link net.sf.dynamicreports.report.builder.chart.PaintScaleBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.chart.XyBlockChartBuilder} object.
     */
    public XyBlockChartBuilder addPaintScale(PaintScaleBuilder... paintScales) {
        Validate.notNull(paintScales, "paintScales must not be null");
        Validate.noNullElements(paintScales, "paintScales must not contains null paintScale");
        for (PaintScaleBuilder paintScale : paintScales) {
            getPlot().addPaintScale(paintScale.build());
        }
        return this;
    }

}

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
package net.sf.dynamicreports.design.transformation.chartcustomizer;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
import net.sf.dynamicreports.report.definition.chart.plot.DRIDifferencePlot;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYDifferenceRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import java.awt.Color;
import java.io.Serializable;

/**
 * <p>DifferenceRendererCustomizer class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DifferenceRendererCustomizer implements DRIChartCustomizer, Serializable {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Color positiveColor;
    private Color negativeColor;
    private Boolean showShapes;

    /**
     * <p>Constructor for DifferenceRendererCustomizer.</p>
     *
     * @param differencePlot a {@link net.sf.dynamicreports.report.definition.chart.plot.DRIDifferencePlot} object.
     */
    public DifferenceRendererCustomizer(DRIDifferencePlot differencePlot) {
        this.positiveColor = differencePlot.getPositiveColor();
        this.negativeColor = differencePlot.getNegativeColor();
        this.showShapes = differencePlot.getShowShapes();
    }

    /** {@inheritDoc} */
    @Override
    public void customize(JFreeChart chart, ReportParameters reportParameters) {
        XYLineAndShapeRenderer lineRenderer = (XYLineAndShapeRenderer) chart.getXYPlot().getRenderer();
        XYDifferenceRenderer renderer = new XYDifferenceRenderer();

        renderer.setBaseItemLabelsVisible(lineRenderer.getBaseItemLabelsVisible());
        renderer.setBaseItemLabelFont(lineRenderer.getBaseItemLabelFont());
        renderer.setBaseItemLabelPaint(lineRenderer.getBaseItemLabelPaint());
        renderer.setBaseItemLabelGenerator(lineRenderer.getBaseItemLabelGenerator());

        if (positiveColor != null) {
            renderer.setPositivePaint(positiveColor);
        }
        if (negativeColor != null) {
            renderer.setNegativePaint(negativeColor);
        }
        if (showShapes != null) {
            renderer.setShapesVisible(showShapes);
        }
        chart.getXYPlot().setRenderer(renderer);
    }
}

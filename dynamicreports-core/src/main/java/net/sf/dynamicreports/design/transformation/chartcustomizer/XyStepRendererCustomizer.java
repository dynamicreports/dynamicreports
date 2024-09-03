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

import java.io.Serializable;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;

/**
 * <p>XyStepRendererCustomizer class.</p>
 *
 * @author Ricardo Mariaca
 *
 */
public class XyStepRendererCustomizer implements DRIChartCustomizer, Serializable {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private final Double stepPoint;

    /**
     * <p>Constructor for XyStepRendererCustomizer.</p>
     *
     * @param stepPoint a {@link java.lang.Double} object.
     */
    public XyStepRendererCustomizer(Double stepPoint) {
        this.stepPoint = stepPoint;
    }

    /** {@inheritDoc} */
    @Override
    public void customize(JFreeChart chart, ReportParameters reportParameters) {
        final XYLineAndShapeRenderer lineRenderer = (XYLineAndShapeRenderer) chart.getXYPlot().getRenderer();
        final XYStepRenderer renderer = new XYStepRenderer();

        renderer.setDefaultItemLabelsVisible(lineRenderer.getDefaultItemLabelsVisible());
        renderer.setDefaultItemLabelFont(lineRenderer.getDefaultItemLabelFont());
        renderer.setDefaultItemLabelPaint(lineRenderer.getDefaultItemLabelPaint());
        renderer.setDefaultItemLabelGenerator(lineRenderer.getDefaultItemLabelGenerator());
        renderer.setDefaultShapesVisible(lineRenderer.getDefaultShapesVisible());
        renderer.setDefaultLinesVisible(lineRenderer.getDefaultLinesVisible());

        if (stepPoint != null) {
            renderer.setStepPoint(stepPoint);
        }
        chart.getXYPlot().setRenderer(renderer);
    }
}

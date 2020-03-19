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
package net.sf.dynamicreports.design.transformation.chartcustomizer;

import net.sf.dynamicreports.jasper.transformation.ConstantTransform;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
import net.sf.dynamicreports.report.definition.chart.plot.DRIPaintScale;
import net.sf.dynamicreports.report.definition.chart.plot.DRIXyBlockPlot;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;

import java.io.Serializable;

/**
 * <p>XyBlockRendererCustomizer class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class XyBlockRendererCustomizer implements DRIChartCustomizer, Serializable {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIXyBlockPlot xyBlockPlot;

    /**
     * <p>Constructor for XyBlockRendererCustomizer.</p>
     *
     * @param xyBlockPlot a {@link net.sf.dynamicreports.report.definition.chart.plot.DRIXyBlockPlot} object.
     */
    public XyBlockRendererCustomizer(DRIXyBlockPlot xyBlockPlot) {
        this.xyBlockPlot = xyBlockPlot;
    }

    /** {@inheritDoc} */
    @Override
    public void customize(JFreeChart chart, ReportParameters reportParameters) {
        chart.getXYPlot().getDomainAxis().setUpperMargin(0);
        chart.getXYPlot().getRangeAxis().setUpperMargin(0);

        XYBlockRenderer renderer = new XYBlockRenderer();
        if (xyBlockPlot.getBlockWidth() != null) {
            renderer.setBlockWidth(xyBlockPlot.getBlockWidth());
        }
        if (xyBlockPlot.getBlockHeight() != null) {
            renderer.setBlockHeight(xyBlockPlot.getBlockHeight());
        }
        if (xyBlockPlot.getBlockAnchor() != null) {
            renderer.setBlockAnchor(ConstantTransform.rectangleAnchor(xyBlockPlot.getBlockAnchor()));
        }
        LookupPaintScale paintScale = new LookupPaintScale(xyBlockPlot.getDefaultLowerBound(), xyBlockPlot.getDefaultUpperBound(), xyBlockPlot.getDefaultPaint());
        for (DRIPaintScale scale : xyBlockPlot.getPaintScales()) {
            paintScale.add(scale.getValue(), scale.getPaint());
        }
        renderer.setPaintScale(paintScale);

        chart.getXYPlot().setRenderer(renderer);

        LegendItemCollection legendItems = new LegendItemCollection();
        for (DRIPaintScale scale : xyBlockPlot.getPaintScales()) {
            legendItems.add(new LegendItem(scale.getLabel(), scale.getPaint()));
        }
        chart.getXYPlot().setFixedLegendItems(legendItems);
    }
}

/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.test.jasper.chart;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.RectangleAnchor;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;

import java.awt.Color;
import java.awt.Font;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class XyBlockChartTest extends AbstractJasperChartTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<Integer> column1;
        TextColumnBuilder<Integer> column2;
        TextColumnBuilder<Integer> column3;

        rb.setLocale(Locale.ENGLISH)
          .columns(column1 = col.column("Column1", "field1", Integer.class), column2 = col.column("Column2", "field2", Integer.class), column3 = col.column("Column3", "field3", Integer.class))
          .summary(cht.xyBlockChart(0.1, 5, Color.WHITE)
                      .setXValue(column1)
                      .series(cht.xyzSerie()
                                 .setYValue(column2)
                                 .setZValue(column3))
                      .setBlockWidth(1.1)
                      .setBlockHeight(0.9)
                      .setBlockAnchor(RectangleAnchor.BOTTOM_LEFT)
                      .paintScales(cht.paintScale("1", 1, Color.RED), cht.paintScale("2", 2, Color.GREEN), cht.paintScale("3", 3, Color.BLUE)), cht.xyBlockChart(0, 5, Color.WHITE)
                                                                                                                                                   .setXValue(column1)
                                                                                                                                                   .series(cht.xyzSerie()
                                                                                                                                                              .setYValue(column2)
                                                                                                                                                              .setZValue(column3))
                                                                                                                                                   .setXAxisFormat(cht.axisFormat()
                                                                                                                                                                      .setLabel("category")
                                                                                                                                                                      .setLabelColor(Color.BLUE)
                                                                                                                                                                      .setLabelFont(stl.fontArialBold())
                                                                                                                                                                      .setTickLabelFont(stl.fontArial()
                                                                                                                                                                                           .setItalic(
                                                                                                                                                                                               true))
                                                                                                                                                                      .setTickLabelColor(Color.CYAN)
                                                                                                                                                                      .setLineColor(Color.LIGHT_GRAY)),
                   cht.xyBlockChart(0, 5, Color.WHITE)
                      .setXValue(column1)
                      .series(cht.xyzSerie()
                                 .setYValue(column2)
                                 .setZValue(column3))
                      .setYAxisFormat(cht.axisFormat()
                                         .setLabel("value")
                                         .setLabelColor(Color.BLUE)
                                         .setLabelFont(stl.fontArialBold())
                                         .setTickLabelFont(stl.fontArial()
                                                              .setItalic(true))
                                         .setTickLabelColor(Color.CYAN)
                                         .setTickLabelMask("#,##0.00")
                                         .setLineColor(Color.LIGHT_GRAY)));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        JFreeChart chart = getChart("summary.chart1", 0);
        XYItemRenderer renderer = chart.getXYPlot()
                                       .getRenderer();
        Assert.assertEquals("renderer", XYBlockRenderer.class, renderer.getClass());
        Assert.assertEquals("block width", 1.1, ((XYBlockRenderer) renderer).getBlockWidth());
        Assert.assertEquals("block height", 0.9, ((XYBlockRenderer) renderer).getBlockHeight());
        Assert.assertEquals("block anchor", org.jfree.ui.RectangleAnchor.BOTTOM_LEFT, ((XYBlockRenderer) renderer).getBlockAnchor());

        Assert.assertEquals("paintScale", LookupPaintScale.class, ((XYBlockRenderer) renderer).getPaintScale()
                                                                                              .getClass());
        LookupPaintScale paintScale = (LookupPaintScale) ((XYBlockRenderer) renderer).getPaintScale();
        Assert.assertEquals("paintScale default lower bound", 0.1, paintScale.getLowerBound());
        Assert.assertEquals("paintScale default upper bound", 5d, paintScale.getUpperBound());
        Assert.assertEquals("paintScale default paint", Color.WHITE, paintScale.getDefaultPaint());
        Assert.assertEquals("paintScale paint 1", Color.RED, paintScale.getPaint(1));
        Assert.assertEquals("paintScale paint 2", Color.GREEN, paintScale.getPaint(2));
        Assert.assertEquals("paintScale paint 3", Color.BLUE, paintScale.getPaint(3));

        LegendItemCollection legendItems = chart.getXYPlot()
                                                .getLegendItems();
        Assert.assertEquals("legend item 1 label", "1", legendItems.get(0)
                                                                   .getLabel());
        Assert.assertEquals("legend item 1 paint", Color.RED, legendItems.get(0)
                                                                         .getFillPaint());
        Assert.assertEquals("legend item 2 label", "2", legendItems.get(1)
                                                                   .getLabel());
        Assert.assertEquals("legend item 2 paint", Color.GREEN, legendItems.get(1)
                                                                           .getFillPaint());
        Assert.assertEquals("legend item 3 label", "3", legendItems.get(2)
                                                                   .getLabel());
        Assert.assertEquals("legend item 3 paint", Color.BLUE, legendItems.get(2)
                                                                          .getFillPaint());

        xyzChartDataTest(chart, 0, "serie0", new Number[][] {{1d, 2d, 0d}, {2d, 3d, 1d}, {3d, 4d, 2d}, {4d, 5d, 3d}});

        chart = getChart("summary.chart2", 0);
        Axis axis = chart.getXYPlot()
                         .getDomainAxis();
        Assert.assertEquals("category label", "category", axis.getLabel());
        Assert.assertEquals("category label color", Color.BLUE, axis.getLabelPaint());
        Assert.assertEquals("category label font", new Font("Arial", Font.BOLD, 10), axis.getLabelFont());
        Assert.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
        Assert.assertEquals("tick label font", new Font("Arial", Font.ITALIC, 10), axis.getTickLabelFont());
        Assert.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());

        chart = getChart("summary.chart3", 0);
        axis = chart.getXYPlot()
                    .getRangeAxis();
        Assert.assertEquals("value label", "value", axis.getLabel());
        Assert.assertEquals("value label color", Color.BLUE, axis.getLabelPaint());
        Assert.assertEquals("value label font", new Font("Arial", Font.BOLD, 10), axis.getLabelFont());
        Assert.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
        Assert.assertEquals("tick label font", new Font("Arial", Font.ITALIC, 10), axis.getTickLabelFont());
        Assert.assertEquals("tick label mask", "10.00", ((NumberAxis) axis).getNumberFormatOverride()
                                                                           .format(10));
        Assert.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        for (int i = 0; i < 4; i++) {
            dataSource.add(i + 1, i + 2, i);
        }
        return dataSource;
    }
}

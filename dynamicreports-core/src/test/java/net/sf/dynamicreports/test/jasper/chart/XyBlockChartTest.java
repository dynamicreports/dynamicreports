/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.test.jasper.chart;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;

import java.awt.Color;
import java.util.Locale;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.RectangleAnchor;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * XY Block chart tests.
 *
 * @author Ricardo Mariaca
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class XyBlockChartTest extends AbstractJasperChartTest {

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    TextColumnBuilder<Integer> column1;
    TextColumnBuilder<Integer> column2;
    TextColumnBuilder<Integer> column3;

    rb.setLocale(Locale.ENGLISH)
        .columns(column1 = col.column("Column1", "field1", Integer.class),
            column2 = col.column("Column2", "field2", Integer.class),
            column3 = col.column("Column3", "field3", Integer.class))
        .summary(
            cht.xyBlockChart(0.1, 5, Color.WHITE).setXValue(column1)
                .series(cht.xyzSerie().setYValue(column2).setZValue(column3)).setBlockWidth(1.1)
                .setBlockHeight(0.9).setBlockAnchor(RectangleAnchor.BOTTOM_LEFT)
                .paintScales(cht.paintScale("1", 1, Color.RED), cht.paintScale("2", 2, Color.GREEN),
                    cht.paintScale("3", 3, Color.BLUE)),
            cht.xyBlockChart(0, 5, Color.WHITE).setXValue(column1)
                .series(cht.xyzSerie().setYValue(column2).setZValue(column3))
                .setXAxisFormat(cht.axisFormat().setLabel("category").setLabelColor(Color.BLUE)
                    .setLabelFont(ARIMO_BOLD).setTickLabelFont(ARIMO_ITALIC)
                    .setTickLabelColor(Color.CYAN).setLineColor(Color.LIGHT_GRAY)),
            cht.xyBlockChart(0, 5, Color.WHITE).setXValue(column1)
                .series(cht.xyzSerie().setYValue(column2).setZValue(column3))
                .setYAxisFormat(cht.axisFormat().setLabel("value").setLabelColor(Color.BLUE)
                    .setLabelFont(ARIMO_BOLD).setTickLabelFont(ARIMO_ITALIC)
                    .setTickLabelColor(Color.CYAN).setTickLabelMask("#,##0.00")
                    .setLineColor(Color.LIGHT_GRAY)));
  }

  @Override
  @Test
  public void test() {
    super.test();

    numberOfPagesTest(1);

    JFreeChart chart = getChart("summary.chart1", 0);
    final XYItemRenderer renderer = chart.getXYPlot().getRenderer();
     Assertions.assertEquals( XYBlockRenderer.class, renderer.getClass(),"renderer");
     Assertions.assertEquals( 1.1, ((XYBlockRenderer) renderer).getBlockWidth(), 0,"block width");
     Assertions.assertEquals( 0.9, ((XYBlockRenderer) renderer).getBlockHeight(), 0,"block height");
     Assertions.assertEquals( org.jfree.chart.ui.RectangleAnchor.BOTTOM_LEFT,        ((XYBlockRenderer) renderer).getBlockAnchor(),"block anchor");

     Assertions.assertEquals( LookupPaintScale.class,        ((XYBlockRenderer) renderer).getPaintScale().getClass(),"paintScale");
    final LookupPaintScale paintScale = (LookupPaintScale) ((XYBlockRenderer) renderer).getPaintScale();
     Assertions.assertEquals( 0.1, paintScale.getLowerBound(), 0,"paintScale default lower bound");
     Assertions.assertEquals( 5d, paintScale.getUpperBound(), 0,"paintScale default upper bound");
     Assertions.assertEquals( Color.WHITE, paintScale.getDefaultPaint(),"paintScale default paint");
     Assertions.assertEquals( Color.RED, paintScale.getPaint(1),"paintScale paint 1");
     Assertions.assertEquals( Color.GREEN, paintScale.getPaint(2),"paintScale paint 2");
     Assertions.assertEquals( Color.BLUE, paintScale.getPaint(3),"paintScale paint 3");

    final LegendItemCollection legendItems = chart.getXYPlot().getLegendItems();
     Assertions.assertEquals( "1", legendItems.get(0).getLabel(),"legend item 1 label");
     Assertions.assertEquals( Color.RED, legendItems.get(0).getFillPaint(),"legend item 1 paint");
     Assertions.assertEquals( "2", legendItems.get(1).getLabel(),"legend item 2 label");
     Assertions.assertEquals( Color.GREEN, legendItems.get(1).getFillPaint(),"legend item 2 paint");
     Assertions.assertEquals( "3", legendItems.get(2).getLabel(),"legend item 3 label");
     Assertions.assertEquals( Color.BLUE, legendItems.get(2).getFillPaint(),"legend item 3 paint");

    xyzChartDataTest(chart, 0, "serie0",
        new Number[][] {{1d, 2d, 0d}, {2d, 3d, 1d}, {3d, 4d, 2d}, {4d, 5d, 3d}});

    chart = getChart("summary.chart2", 0);
    Axis axis = chart.getXYPlot().getDomainAxis();
     Assertions.assertEquals( "category", axis.getLabel(),"category label");
     Assertions.assertEquals( Color.BLUE, axis.getLabelPaint(),"category label color");
     Assertions.assertEquals( ARIMO_BOLD_AWT, axis.getLabelFont(),"category label font");
     Assertions.assertEquals( Color.CYAN, axis.getTickLabelPaint(),"tick label color");
     Assertions.assertEquals( ARIMO_ITALIC_AWT, axis.getTickLabelFont(),"tick label font");
     Assertions.assertEquals( Color.LIGHT_GRAY, axis.getAxisLinePaint(),"line color");

    chart = getChart("summary.chart3", 0);
    axis = chart.getXYPlot().getRangeAxis();
     Assertions.assertEquals( "value", axis.getLabel(),"value label");
     Assertions.assertEquals( Color.BLUE, axis.getLabelPaint(),"value label color");
     Assertions.assertEquals( ARIMO_BOLD_AWT, axis.getLabelFont(),"value label font");
     Assertions.assertEquals( Color.CYAN, axis.getTickLabelPaint(),"tick label color");
     Assertions.assertEquals( ARIMO_ITALIC_AWT, axis.getTickLabelFont(),"tick label font");
     Assertions.assertEquals( "10.00",        ((NumberAxis) axis).getNumberFormatOverride().format(10),"tick label mask");
     Assertions.assertEquals( Color.LIGHT_GRAY, axis.getAxisLinePaint(),"line color");
  }

  @Override
  protected JRDataSource createDataSource() {
    final DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
    for (int i = 0; i < 4; i++) {
      dataSource.add(i + 1, i + 2, i);
    }
    return dataSource;
  }
}

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
import java.io.Serializable;
import java.util.Locale;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.StackedBarRenderer3D;
import org.jfree.ui.RectangleEdge;
import org.junit.Assert;

/**
 * Stacked bar 3D chart tests.
 * 
 * @author Ricardo Mariaca
 */
public class StackedBar3DChartTest extends AbstractJasperChartTest implements Serializable {
  private static final long serialVersionUID = 1L;

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    TextColumnBuilder<String> column1;
    TextColumnBuilder<Integer> column2;

    rb.setLocale(Locale.ENGLISH)
        .columns(column1 = col.column("Column1", "field1", String.class),
            column2 = col.column("Column2", "field2", Integer.class))
        .summary(
            cht.stackedBar3DChart().setCategory(column1).series(cht.serie(column2))
                .setShowLabels(true).setXOffset(2d).setYOffset(3d),
            cht.stackedBar3DChart().setCategory(column1).series(cht.serie(column2))
                .setCategoryAxisFormat(cht.axisFormat().setLabel("category")
                    .setLabelColor(Color.BLUE).setLabelFont(ARIMO_BOLD)
                    .setTickLabelFont(ARIMO_ITALIC).setTickLabelColor(Color.CYAN)
                    .setTickLabelRotation(45d).setLineColor(Color.LIGHT_GRAY)),
            cht.stackedBar3DChart().setCategory(column1).series(cht.serie(column2))
                .setValueAxisFormat(cht.axisFormat().setLabel("value").setLabelColor(Color.BLUE)
                    .setLabelFont(ARIMO_BOLD).setTickLabelFont(ARIMO_ITALIC)
                    .setTickLabelColor(Color.CYAN).setTickLabelMask("#,##0.00")
                    .setLineColor(Color.LIGHT_GRAY).setRangeMinValueExpression(1)
                    .setRangeMaxValueExpression(15)));
  }

  @Override
  public void test() {
    super.test();

    numberOfPagesTest(1);

    JFreeChart chart = getChart("summary.chart1", 0);
    CategoryPlot categoryPlot = chart.getCategoryPlot();
    Assert.assertEquals("renderer", StackedBarRenderer3D.class,
        categoryPlot.getRenderer().getClass());
    BarRenderer3D renderer = (BarRenderer3D) categoryPlot.getRenderer();
    Assert.assertTrue("show labels", renderer.getBaseItemLabelsVisible());
    Assert.assertEquals("x offset", 2d, renderer.getXOffset(), 0);
    Assert.assertEquals("y offset", 3d, renderer.getYOffset(), 0);

    chart = getChart("summary.chart2", 0);
    Axis axis = chart.getCategoryPlot().getDomainAxis();
    Assert.assertEquals("category label", "category", axis.getLabel());
    Assert.assertEquals("category label color", Color.BLUE, axis.getLabelPaint());
    Assert.assertEquals("category label font", ARIMO_BOLD_AWT, axis.getLabelFont());
    Assert.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
    Assert.assertEquals("tick label font", ARIMO_ITALIC_AWT, axis.getTickLabelFont());
    CategoryLabelPosition labelPosition = chart.getCategoryPlot().getDomainAxis()
        .getCategoryLabelPositions().getLabelPosition(RectangleEdge.LEFT);
    Assert.assertEquals("plot label rotation", (45d / 180) * Math.PI, labelPosition.getAngle(), 0);
    Assert.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());

    chart = getChart("summary.chart3", 0);
    axis = chart.getCategoryPlot().getRangeAxis();
    Assert.assertEquals("value label", "value", axis.getLabel());
    Assert.assertEquals("value label color", Color.BLUE, axis.getLabelPaint());
    Assert.assertEquals("value label font", ARIMO_BOLD_AWT, axis.getLabelFont());
    Assert.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
    Assert.assertEquals("tick label font", ARIMO_ITALIC_AWT, axis.getTickLabelFont());
    Assert.assertEquals("tick label mask", "10.00",
        ((NumberAxis) axis).getNumberFormatOverride().format(10));
    Assert.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());
    Assert.assertEquals("range min value", 1d, ((ValueAxis) axis).getLowerBound(), 0);
    Assert.assertEquals("range max value", 15d, ((ValueAxis) axis).getUpperBound(), 0);
  }

  @Override
  protected JRDataSource createDataSource() {
    DRDataSource dataSource = new DRDataSource("field1", "field2");
    for (int i = 0; i < 4; i++) {
      dataSource.add("value" + (i + 1), i + 1);
      dataSource.add("value" + (i + 1), i + 1);
    }
    return dataSource;
  }
}

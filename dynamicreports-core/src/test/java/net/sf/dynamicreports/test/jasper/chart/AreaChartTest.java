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

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.ui.RectangleEdge;
import org.junit.jupiter.api.Assertions;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * Area chart tests.
 *
 * @author Ricardo Mariaca
 */
public class AreaChartTest extends AbstractJasperChartTest implements Serializable {
  private static final long serialVersionUID = 1L;

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    TextColumnBuilder<String> column1;
    TextColumnBuilder<Integer> column2;

    rb.setLocale(Locale.ENGLISH)
        .columns(column1 = col.column("Column1", "field1", String.class),
            column2 = col.column("Column2", "field2", Integer.class))
        .summary(
            cht.areaChart().setCategory(column1).series(cht.serie(column2))
                .setCategoryAxisFormat(cht.axisFormat().setLabel("category")
                    .setLabelColor(Color.BLUE).setLabelFont(ARIMO_BOLD)
                    .setTickLabelFont(ARIMO_ITALIC).setTickLabelColor(Color.CYAN)
                    .setTickLabelRotation(45d).setLineColor(Color.LIGHT_GRAY)),
            cht.areaChart().setCategory(column1).series(cht.serie(column2))
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
    Axis axis = chart.getCategoryPlot().getDomainAxis();
    final CategoryPlot categoryPlot = chart.getCategoryPlot();
    Assertions.assertEquals("renderer", AreaRenderer.class, categoryPlot.getRenderer().getClass());
    Assertions.assertEquals("category label", "category", axis.getLabel());
    Assertions.assertEquals("category label color", Color.BLUE, axis.getLabelPaint());
    Assertions.assertEquals("category label font", ARIMO_BOLD_AWT, axis.getLabelFont());
    Assertions.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
    Assertions.assertEquals("tick label font", ARIMO_ITALIC_AWT, axis.getTickLabelFont());
    final CategoryLabelPosition labelPosition = chart.getCategoryPlot().getDomainAxis()
        .getCategoryLabelPositions().getLabelPosition(RectangleEdge.LEFT);
    Assertions.assertEquals("plot label rotation", 45d / 180 * Math.PI, labelPosition.getAngle(), 0);
    Assertions.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());

    chart = getChart("summary.chart2", 0);
    axis = chart.getCategoryPlot().getRangeAxis();
    Assertions.assertEquals("value label", "value", axis.getLabel());
    Assertions.assertEquals("value label color", Color.BLUE, axis.getLabelPaint());
    Assertions.assertEquals("value label font", ARIMO_BOLD_AWT, axis.getLabelFont());
    Assertions.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
    Assertions.assertEquals("tick label font", ARIMO_ITALIC_AWT, axis.getTickLabelFont());
    Assertions.assertEquals("tick label mask", "10.00",
        ((NumberAxis) axis).getNumberFormatOverride().format(10));
    Assertions.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());
    Assertions.assertEquals("range min value", 1d, ((ValueAxis) axis).getLowerBound(), 0);
    Assertions.assertEquals("range max value", 15d, ((ValueAxis) axis).getUpperBound(), 0);
  }

  @Override
  protected JRDataSource createDataSource() {
    final DRDataSource dataSource = new DRDataSource("field1", "field2");
    for (int i = 0; i < 4; i++) {
      dataSource.add("value" + (i + 1), i + 1);
      dataSource.add("value" + (i + 1), i + 1);
    }
    return dataSource;
  }
}

/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
 * http://www.dynamicreports.org
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
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.TimePeriod;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.junit.Assert;

/**
 * Time series chart tests.
 * 
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class TimeSeriesChartTest extends AbstractJasperChartTest implements Serializable {
  private static final long serialVersionUID = 1L;

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    TextColumnBuilder<Date> column1;
    TextColumnBuilder<Timestamp> column2;
    TextColumnBuilder<Integer> column3;

    rb.setLocale(Locale.ENGLISH)
        .columns(column1 = col.column("Column1", "field1", Date.class),
            column2 = col.column("Column2", "field2", Timestamp.class),
            column3 = col.column("Column3", "field3", Integer.class))
        .summary(
            cht.timeSeriesChart().setTimePeriod(column1).series(cht.serie(column3))
                .setTimePeriodType(TimePeriod.DAY).setShowShapes(false).setShowLines(false),
            cht.timeSeriesChart().setTimePeriod(column1).series(cht.serie(column3))
                .setTimeAxisFormat(cht.axisFormat().setLabel("time").setLabelColor(Color.BLUE)
                    .setLabelFont(ARIMO_BOLD).setTickLabelFont(ARIMO_ITALIC)
                    .setTickLabelColor(Color.CYAN).setLineColor(Color.LIGHT_GRAY)
                    .setVerticalTickLabels(true)),
            cht.timeSeriesChart().setTimePeriod(column2).series(cht.serie(column3))
                .setValueAxisFormat(cht.axisFormat().setLabel("value").setLabelColor(Color.BLUE)
                    .setLabelFont(ARIMO_BOLD).setTickLabelFont(ARIMO_ITALIC)
                    .setTickLabelColor(Color.CYAN).setTickLabelMask("#,##0.00")
                    .setLineColor(Color.LIGHT_GRAY).setRangeMinValueExpression(1)
                    .setRangeMaxValueExpression(15).setVerticalTickLabels(true)));
  }

  @Override
  public void test() {
    super.test();

    numberOfPagesTest(1);

    JFreeChart chart = getChart("summary.chart1", 0);
    XYItemRenderer renderer = chart.getXYPlot().getRenderer();
    Assert.assertEquals("renderer", XYLineAndShapeRenderer.class, renderer.getClass());
    Assert.assertFalse("show shapes", ((XYLineAndShapeRenderer) renderer).getBaseShapesVisible());
    Assert.assertFalse("show lines", ((XYLineAndShapeRenderer) renderer).getBaseLinesVisible());

    chart = getChart("summary.chart2", 0);
    Axis axis = chart.getXYPlot().getDomainAxis();
    Assert.assertEquals("category label", "time", axis.getLabel());
    Assert.assertEquals("category label color", Color.BLUE, axis.getLabelPaint());
    Assert.assertEquals("category label font", ARIMO_BOLD_AWT, axis.getLabelFont());
    Assert.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
    Assert.assertEquals("tick label font", ARIMO_ITALIC_AWT, axis.getTickLabelFont());
    Assert.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());
    Assert.assertTrue("vertical tick labels", ((ValueAxis) axis).isVerticalTickLabels());

    chart = getChart("summary.chart3", 0);
    axis = chart.getXYPlot().getRangeAxis();
    Assert.assertEquals("value label", "value", axis.getLabel());
    Assert.assertEquals("value label color", Color.BLUE, axis.getLabelPaint());
    Assert.assertEquals("value label font", ARIMO_BOLD_AWT, axis.getLabelFont());
    Assert.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
    Assert.assertEquals("tick label font", ARIMO_ITALIC_AWT, axis.getTickLabelFont());
    Assert.assertEquals("tick label mask", "10.00",
        ((NumberAxis) axis).getNumberFormatOverride().format(10));
    // Assert.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());
    Assert.assertEquals("range min value", 1d, ((ValueAxis) axis).getLowerBound(), 0);
    Assert.assertEquals("range max value", 15d, ((ValueAxis) axis).getUpperBound(), 0);
    Assert.assertTrue("vertical tick labels", ((ValueAxis) axis).isVerticalTickLabels());
  }

  @Override
  protected JRDataSource createDataSource() {
    DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    for (int i = 0; i < 4; i++) {
      dataSource.add(c.getTime(), new Timestamp(c.getTimeInMillis()), i + 1);
      dataSource.add(c.getTime(), new Timestamp(c.getTimeInMillis()), i + 1);
      c.add(Calendar.DAY_OF_MONTH, 1);
    }
    return dataSource;
  }
}

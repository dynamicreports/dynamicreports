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
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.junit.Assert;

/**
 * High low chart tests.
 * 
 * @author Ricardo Mariaca
 */
public class HighLowChartTest extends AbstractJasperChartTest {
  private Date date1;
  private Date date2;
  private Date date3;

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    TextColumnBuilder<String> column1;
    TextColumnBuilder<Date> column2;
    TextColumnBuilder<Double> column3;
    TextColumnBuilder<Double> column4;
    TextColumnBuilder<Double> column5;
    TextColumnBuilder<Double> column6;
    TextColumnBuilder<Double> column7;

    rb.setLocale(Locale.ENGLISH)
        .columns(column1 = col.column("Column1", "field1", String.class),
            column2 = col.column("Column2", "field2", Date.class),
            column3 = col.column("Column3", "field3", Double.class),
            column4 = col.column("Column4", "field4", Double.class),
            column5 = col.column("Column5", "field5", Double.class),
            column6 = col.column("Column6", "field6", Double.class),
            column7 = col.column("Column7", "field7", Double.class))
        .summary(
            cht.highLowChart().setSeries(column1).setDate(column2).setHigh(column3).setLow(column4)
                .setOpen(column5).setClose(column6).setVolume(column7).setShowOpenTicks(true)
                .setShowCloseTicks(true),
            cht.highLowChart().setSeries(column1).setDate(column2).setHigh(column3).setLow(column4)
                .setOpen(column5).setClose(column6).setVolume(column7)
                .setTimeAxisFormat(cht.axisFormat().setLabel("time").setLabelColor(Color.BLUE)
                    .setLabelFont(ARIMO_BOLD).setTickLabelFont(ARIMO_ITALIC)
                    .setTickLabelColor(Color.CYAN).setLineColor(Color.LIGHT_GRAY)
                    .setVerticalTickLabels(true)),
            cht.highLowChart().setSeries(column1).setDate(column2).setHigh(column3).setLow(column4)
                .setOpen(column5).setClose(column6).setVolume(column7)
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
    Assert.assertEquals("renderer", HighLowRenderer.class, renderer.getClass());
    Assert.assertEquals("show open ticks", true, ((HighLowRenderer) renderer).getDrawOpenTicks());
    Assert.assertEquals("show close ticks", true, ((HighLowRenderer) renderer).getDrawCloseTicks());
    highLowChartDataTest(chart, 0, new Object[][] {{"serie", date1, 50d, 35d, 40d, 47d, 70d},
        {"serie", date2, 55d, 40d, 50d, 45d, 120d}, {"serie", date3, 48d, 41d, 42d, 47d, 90d}});

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
    DRDataSource dataSource =
        new DRDataSource("field1", "field2", "field3", "field4", "field5", "field6", "field7");
    Calendar c = Calendar.getInstance();
    c.add(Calendar.DAY_OF_MONTH, -3);
    dataSource.add("serie", date1 = c.getTime(), 50d, 35d, 40d, 47d, 70d);
    c.add(Calendar.DAY_OF_MONTH, 1);
    dataSource.add("serie", date2 = c.getTime(), 55d, 40d, 50d, 45d, 120d);
    c.add(Calendar.DAY_OF_MONTH, 1);
    dataSource.add("serie", date3 = c.getTime(), 48d, 41d, 42d, 47d, 90d);
    return dataSource;
  }
}

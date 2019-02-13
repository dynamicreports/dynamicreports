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

import java.awt.Color;
import java.util.Locale;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.constant.MeterShape;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.chart.plot.Plot;
import org.junit.Assert;

/**
 * Meter chart tests.
 * 
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class MeterChartTest extends AbstractJasperChartTest {

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    rb.setLocale(Locale.ENGLISH).summary(
        cht.meterChart().setValue(DynamicReports.field("field1", Integer.class))
            .setDataRangeLowExpression(3).setDataRangeHighExpression(30).setValueColor(Color.BLUE)
            .setValueMask("#,###.0").setValueFont(ARIMO).setShape(MeterShape.CIRCLE)
            .setMeterAngle(270).setUnits("units").setTickInterval(3d)
            .setMeterBackgroundColor(Color.LIGHT_GRAY).setNeedleColor(Color.CYAN)
            .setTickColor(Color.MAGENTA).setTickLabelFont(ARIMO_ITALIC).intervals(
                cht.meterInterval().setLabel("red").setAlpha(0.8).setBackgroundColor(Color.RED)
                    .setDataRangeLowExpression(25).setDataRangeHighExpression(30),
                cht.meterInterval().setLabel("yellow").setAlpha(0.5)
                    .setBackgroundColor(Color.YELLOW).setDataRangeLowExpression(20)
                    .setDataRangeHighExpression(25)),
        cht.meterChart().setValue(5).setShape(MeterShape.DIAL));
  }

  @Override
  public void test() {
    super.test();

    numberOfPagesTest(1);

    JFreeChart chart = getChart("summary.chart1", 0);
    Plot plot = chart.getPlot();
    Assert.assertEquals("renderer", MeterPlot.class, plot.getClass());
    MeterPlot meterPlot = (MeterPlot) plot;
    Assert.assertEquals("value", 15, meterPlot.getDataset().getValue());
    Assert.assertEquals("data range low", 3d, meterPlot.getRange().getLowerBound(), 0);
    Assert.assertEquals("data range high", 30d, meterPlot.getRange().getUpperBound(), 0);
    Assert.assertEquals("value color", Color.BLUE, meterPlot.getValuePaint());
    Assert.assertEquals("value mask", "15.0", meterPlot.getTickLabelFormat().format(15));
    Assert.assertEquals("value font", ARIMO_AWT, meterPlot.getValueFont());
    Assert.assertEquals("shape", DialShape.CIRCLE, meterPlot.getDialShape());
    Assert.assertEquals("meter angle", 270, meterPlot.getMeterAngle());
    Assert.assertEquals("units", "units", meterPlot.getUnits());
    Assert.assertEquals("tick interval", 3d, meterPlot.getTickSize(), 0);
    Assert.assertEquals("background color", Color.LIGHT_GRAY, meterPlot.getDialBackgroundPaint());
    Assert.assertEquals("needle color", Color.CYAN, meterPlot.getNeedlePaint());
    Assert.assertEquals("tick color", Color.MAGENTA, meterPlot.getTickPaint());
    Assert.assertEquals("tick label font", ARIMO_ITALIC_AWT, meterPlot.getTickLabelFont());
    Assert.assertEquals("intervals size", 2, meterPlot.getIntervals().size());
    intervalTest((MeterInterval) meterPlot.getIntervals().get(0), "red",
        new Color(1f, 0f, 0f, 0.8f), 25d, 30d);
    intervalTest((MeterInterval) meterPlot.getIntervals().get(1), "yellow",
        new Color(1f, 1f, 0f, 0.5f), 20d, 25d);
  }

  private void intervalTest(MeterInterval interval, String label, Color backgroundColor,
      double rangeLow, double rangeHigh) {
    Assert.assertEquals("interval label", label, interval.getLabel());
    Assert.assertEquals("interval background color", backgroundColor,
        interval.getBackgroundPaint());
    Assert.assertEquals("interval data range low", rangeLow, interval.getRange().getLowerBound(),
        0);
    Assert.assertEquals("interval data range high", rangeHigh, interval.getRange().getUpperBound(),
        0);
  }

  @Override
  protected JRDataSource createDataSource() {
    DRDataSource dataSource = new DRDataSource("field1");
    dataSource.add(15);
    return dataSource;
  }
}

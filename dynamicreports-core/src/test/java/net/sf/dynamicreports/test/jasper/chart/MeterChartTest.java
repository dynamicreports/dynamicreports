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

import java.awt.Color;
import java.util.Locale;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.chart.plot.Plot;
import org.junit.jupiter.api.Assertions;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.constant.MeterShape;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * Meter chart tests.
 *
 * @author Ricardo Mariaca
 */
public class MeterChartTest extends AbstractJasperChartTest {

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    rb.setLocale(Locale.ENGLISH).summary(
        cht.meterChart().setValue(DynamicReports.<Number>field("field1", Integer.class))
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

    final JFreeChart chart = getChart("summary.chart1", 0);
    final Plot plot = chart.getPlot();
    Assertions.assertEquals("renderer", MeterPlot.class, plot.getClass());
    final MeterPlot meterPlot = (MeterPlot) plot;
    Assertions.assertEquals("value", 15, meterPlot.getDataset().getValue());
    Assertions.assertEquals("data range low", 3d, meterPlot.getRange().getLowerBound(), 0);
    Assertions.assertEquals("data range high", 30d, meterPlot.getRange().getUpperBound(), 0);
    Assertions.assertEquals("value color", Color.BLUE, meterPlot.getValuePaint());
    Assertions.assertEquals("value mask", "15.0", meterPlot.getTickLabelFormat().format(15));
    Assertions.assertEquals("value font", ARIMO_AWT, meterPlot.getValueFont());
    Assertions.assertEquals("shape", DialShape.CIRCLE, meterPlot.getDialShape());
    Assertions.assertEquals("meter angle", 270, meterPlot.getMeterAngle());
    Assertions.assertEquals("units", "units", meterPlot.getUnits());
    Assertions.assertEquals("tick interval", 3d, meterPlot.getTickSize(), 0);
    Assertions.assertEquals("background color", Color.LIGHT_GRAY, meterPlot.getDialBackgroundPaint());
    Assertions.assertEquals("needle color", Color.CYAN, meterPlot.getNeedlePaint());
    Assertions.assertEquals("tick color", Color.MAGENTA, meterPlot.getTickPaint());
    Assertions.assertEquals("tick label font", ARIMO_ITALIC_AWT, meterPlot.getTickLabelFont());
    Assertions.assertEquals("intervals size", 2, meterPlot.getIntervals().size());
    intervalTest(meterPlot.getIntervals().get(0), "red",
        new Color(1f, 0f, 0f, 0.8f), 25d, 30d);
    intervalTest(meterPlot.getIntervals().get(1), "yellow",
        new Color(1f, 1f, 0f, 0.5f), 20d, 25d);
  }

  private void intervalTest(MeterInterval interval, String label, Color backgroundColor,
      double rangeLow, double rangeHigh) {
    Assertions.assertEquals("interval label", label, interval.getLabel());
    Assertions.assertEquals("interval background color", backgroundColor,
        interval.getBackgroundPaint());
    Assertions.assertEquals("interval data range low", rangeLow, interval.getRange().getLowerBound(),
        0);
    Assertions.assertEquals("interval data range high", rangeHigh, interval.getRange().getUpperBound(),
        0);
  }

  @Override
  protected JRDataSource createDataSource() {
    final DRDataSource dataSource = new DRDataSource("field1");
    dataSource.add(15);
    return dataSource;
  }
}

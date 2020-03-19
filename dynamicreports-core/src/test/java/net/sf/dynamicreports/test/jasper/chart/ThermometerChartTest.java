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
import java.lang.reflect.Field;
import java.text.NumberFormat;
import java.util.Locale;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.constant.ValueLocation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.ThermometerPlot;
import org.junit.Assert;

/**
 * Thermometer chart tests.
 * 
 * @author Ricardo Mariaca
 */
public class ThermometerChartTest extends AbstractJasperChartTest {

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    rb.setLocale(Locale.ENGLISH).summary(
        cht.thermometerChart().setValue(DynamicReports.<Number>field("field1", Integer.class))
            .setDataRangeLowExpression(3).setDataRangeHighExpression(30).setValueColor(Color.BLUE)
            .setValueMask("#,###.0").setValueFont(ARIMO).setValueLocation(ValueLocation.BULB)
            .setMercuryColor(Color.LIGHT_GRAY).setLowDataRangeLowExpression(8)
            .setLowDataRangeHighExpression(10).setMediumDataRangeLowExpression(18)
            .setMediumDataRangeHighExpression(20).setHighDataRangeLowExpression(28)
            .setHighDataRangeHighExpression(30),
        cht.thermometerChart().setValue(DynamicReports.<Number>field("field1", Integer.class)));
  }

  @Override
  public void test() {
    super.test();

    numberOfPagesTest(1);

    JFreeChart chart = getChart("summary.chart1", 0);
    Plot plot = chart.getPlot();
    Assert.assertEquals("renderer", ThermometerPlot.class, plot.getClass());
    ThermometerPlot thermometerPlot = (ThermometerPlot) plot;
    Assert.assertEquals("value", 15, thermometerPlot.getDataset().getValue());
    Assert.assertEquals("data range low", 3d, thermometerPlot.getLowerBound(), 0);
    Assert.assertEquals("data range high", 30d, thermometerPlot.getUpperBound(), 0);
    Assert.assertEquals("value color", Color.BLUE, thermometerPlot.getValuePaint());
    try {
      Field field = thermometerPlot.getClass().getDeclaredField("valueFormat");
      field.setAccessible(true);
      Assert.assertEquals("value mask", "15.0",
          ((NumberFormat) field.get(thermometerPlot)).format(15));
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail(e.getMessage());
    }
    Assert.assertEquals("value font", ARIMO_AWT, thermometerPlot.getValueFont());
    Assert.assertEquals("value location", ThermometerPlot.BULB, thermometerPlot.getValueLocation());
    Assert.assertEquals("mercury color", Color.LIGHT_GRAY, thermometerPlot.getMercuryPaint());
    try {
      Field field = thermometerPlot.getClass().getDeclaredField("subrangeInfo");
      field.setAccessible(true);
      double[][] subrangeInfo = (double[][]) field.get(thermometerPlot);
      Assert.assertEquals("low data range low", 8d, subrangeInfo[2][0], 0);
      Assert.assertEquals("low data range high", 10d, subrangeInfo[2][1], 0);
      Assert.assertEquals("medium data range low", 18d, subrangeInfo[1][0], 0);
      Assert.assertEquals("medium data range high", 20d, subrangeInfo[1][1], 0);
      Assert.assertEquals("high data range low", 28d, subrangeInfo[0][0], 0);
      Assert.assertEquals("high data range high", 30d, subrangeInfo[0][1], 0);
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail(e.getMessage());
    }
  }

  @Override
  protected JRDataSource createDataSource() {
    DRDataSource dataSource = new DRDataSource("field1");
    dataSource.add(15);
    return dataSource;
  }
}

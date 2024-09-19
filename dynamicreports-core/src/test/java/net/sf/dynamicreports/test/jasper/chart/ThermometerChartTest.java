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

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.ThermometerPlot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.constant.ValueLocation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * Thermometer chart tests.
 *
 * @author Ricardo Mariaca
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
  @Test
  public void test() {
    super.test();

    numberOfPagesTest(1);

    final JFreeChart chart = getChart("summary.chart1", 0);
    final Plot plot = chart.getPlot();
     Assertions.assertEquals( ThermometerPlot.class, plot.getClass(),"renderer");
    final ThermometerPlot thermometerPlot = (ThermometerPlot) plot;
     Assertions.assertEquals( 15, thermometerPlot.getDataset().getValue(),"value");
     Assertions.assertEquals( 3d, thermometerPlot.getLowerBound(), 0,"data range low");
     Assertions.assertEquals( 30d, thermometerPlot.getUpperBound(), 0,"data range high");
     Assertions.assertEquals( Color.BLUE, thermometerPlot.getValuePaint(),"value color");
    try {
      final Field field = thermometerPlot.getClass().getDeclaredField("valueFormat");
      field.setAccessible(true);
      Assertions.assertEquals( "15.0",
          ((NumberFormat) field.get(thermometerPlot)).format(15), "value mask");
    } catch (final Exception e) {
      e.printStackTrace();
      Assertions.fail(e.getMessage());
    }
     Assertions.assertEquals( ARIMO_AWT, thermometerPlot.getValueFont(),"value font");
     Assertions.assertEquals( ThermometerPlot.BULB, thermometerPlot.getValueLocation(),"value location");
     Assertions.assertEquals( Color.LIGHT_GRAY, thermometerPlot.getMercuryPaint(),"mercury color");
    try {
      final Field field = thermometerPlot.getClass().getDeclaredField("subrangeInfo");
      field.setAccessible(true);
      final double[][] subrangeInfo = (double[][]) field.get(thermometerPlot);
       Assertions.assertEquals( 8d, subrangeInfo[2][0], 0,"low data range low");
       Assertions.assertEquals( 10d, subrangeInfo[2][1], 0,"low data range high");
       Assertions.assertEquals( 18d, subrangeInfo[1][0], 0,"medium data range low");
       Assertions.assertEquals( 20d, subrangeInfo[1][1], 0,"medium data range high");
       Assertions.assertEquals( 28d, subrangeInfo[0][0], 0,"high data range low");
       Assertions.assertEquals( 30d, subrangeInfo[0][1], 0,"high data range high");
    } catch (final Exception e) {
      e.printStackTrace();
      Assertions.fail(e.getMessage());
    }
  }

  @Override
  protected JRDataSource createDataSource() {
    final DRDataSource dataSource = new DRDataSource("field1");
    dataSource.add(15);
    return dataSource;
  }
}

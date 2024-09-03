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

package net.sf.dynamicreports.test.jasper;

import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

import java.awt.Font;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.gantt.GanttCategoryDataset;
import org.jfree.data.xy.DefaultHighLowDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;
import org.junit.jupiter.api.Assertions;

import net.sf.dynamicreports.report.base.style.DRFont;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.jasperreports.charts.util.DrawChartRendererImpl;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRPrintImage;
import net.sf.jasperreports.engine.fonts.FontUtil;

/**
 * Base class for chart builder tests.
 */
public abstract class AbstractJasperChartTest extends AbstractJasperValueTest {

  private static final String FONT_NAME = "Arimo";
  private static final int FONT_SIZE = 10;
  protected static final FontBuilder ARIMO = stl.font(FONT_NAME, false, false, FONT_SIZE);
  protected static final Font ARIMO_AWT = getAwtFont(ARIMO);
  protected static final FontBuilder ARIMO_BOLD = stl.font(FONT_NAME, true, false, FONT_SIZE);
  protected static final Font ARIMO_BOLD_AWT = getAwtFont(ARIMO_BOLD);
  protected static final FontBuilder ARIMO_ITALIC = stl.font(FONT_NAME, false, true, FONT_SIZE);
  protected static final Font ARIMO_ITALIC_AWT = getAwtFont(ARIMO_ITALIC);


  protected void chartCountTest(String name, int expectedNumberOfCharts) {
    Assertions.assertEquals("chart count " + name, expectedNumberOfCharts, findElement(name).size());
  }

  protected void chartCategoryCountTest(String name, int index, int expectedNumberOfCategories) {
    Assertions.assertEquals("chart category count " + name, expectedNumberOfCategories,
        getChart(name, index).getCategoryPlot().getDataset().getColumnCount());
  }

  protected void chartSeriesCountTest(String name, int index, int expectedNumberOfSeries) {
    Assertions.assertEquals("chart series count " + name, expectedNumberOfSeries,
        getChart(name, index).getCategoryPlot().getDataset().getRowCount());
  }

  protected void chartTitleTest(String name, int index, String title) {
    final TextTitle chartTitle = getChart(name, index).getTitle();
    if (title != null) {
      Assertions.assertEquals("chart title", title, chartTitle.getText());
    } else {
      Assertions.assertNull("chart title", chartTitle);
    }
  }

  protected void chartDataTest(String name, int index, String[] categories, String[] series,
      Number[][] values) {
    final CategoryDataset dataset = getChart(name, index).getCategoryPlot().getDataset();
    for (int i = 0; i < categories.length; i++) {
      for (int j = 0; j < series.length; j++) {
        Assertions.assertEquals("chart data", values[i][j], dataset.getValue(series[j], categories[i]));
      }
    }
  }

  protected void xyChartDataTest(JFreeChart chart, int series, String seriesName,
      Number[][] values) {
    final XYDataset dataset = chart.getXYPlot().getDataset();
    int index = 0;
    for (final Number[] numbers : values) {
      Assertions.assertEquals("chart data series name", seriesName, dataset.getSeriesKey(series));
      Assertions.assertEquals("chart data x", numbers[0], dataset.getXValue(series, index));
      Assertions.assertEquals("chart data y", numbers[1], dataset.getYValue(series, index));
      index++;
    }
  }

  protected void xyzChartDataTest(JFreeChart chart, int series, String seriesName,
      Number[][] values) {
    final XYZDataset dataset = (XYZDataset) chart.getXYPlot().getDataset();
    int index = 0;
    for (final Number[] numbers : values) {
      Assertions.assertEquals("chart data series name", seriesName, dataset.getSeriesKey(series));
      Assertions.assertEquals("chart data x", numbers[0], dataset.getXValue(series, index));
      Assertions.assertEquals("chart data y", numbers[1], dataset.getYValue(series, index));
      Assertions.assertEquals("chart data z", numbers[2], dataset.getZValue(series, index));
      index++;
    }
  }

  protected void highLowChartDataTest(JFreeChart chart, int series, Object[][] values) {
    final DefaultHighLowDataset dataset = (DefaultHighLowDataset) chart.getXYPlot().getDataset();
    int index = 0;
    for (final Object[] value : values) {
      Assertions.assertEquals("chart data series", value[0], dataset.getSeriesKey(series));
      Assertions.assertEquals("chart data date", value[1], dataset.getXDate(series, index));
      Assertions.assertEquals("chart data high value", value[2], dataset.getHigh(series, index));
      Assertions.assertEquals("chart data low value", value[3], dataset.getLow(series, index));
      Assertions.assertEquals("chart data open value", value[4], dataset.getOpenValue(series, index));
      Assertions.assertEquals("chart data close value", value[5], dataset.getClose(series, index));
      Assertions.assertEquals("chart data volume value", value[6], dataset.getVolume(series, index));
      index++;
    }
  }

  protected void ganttChartDataTest(JFreeChart chart, String serie, String[] tasks,
      Object[][] values) {
    final GanttCategoryDataset dataset = (GanttCategoryDataset) chart.getCategoryPlot().getDataset();
    for (int i = 0; i < tasks.length; i++) {
      Assertions.assertEquals("chart data start value", ((Date) values[i][0]).getTime(),
          dataset.getStartValue(serie, tasks[i]));
      Assertions.assertEquals("chart data end value", ((Date) values[i][1]).getTime(),
          dataset.getEndValue(serie, tasks[i]));
      Assertions.assertEquals("chart data percent value", values[i][2],
          dataset.getPercentComplete(serie, tasks[i], 0));
    }
  }

  protected JFreeChart getChart(String key, int index) {
    final JRPrintImage image = (JRPrintImage) getElementAt(key, index);
    return getChart(image);
  }

  protected JFreeChart getChart(JRPrintImage image) {
    final DrawChartRendererImpl renderer = (DrawChartRendererImpl) image.getRenderer();
    try {
      final Field field = renderer.getClass().getDeclaredField("chart");
      field.setAccessible(true);
      return (JFreeChart) field.get(renderer);
    } catch (final Exception e) {
      e.printStackTrace();
      Assertions.fail(e.getMessage());
    }
    return null;
  }

  private static Font getAwtFont(FontBuilder fontBuilder) {
    final DRFont drFont = fontBuilder.getFont();
    final boolean bold = Optional.ofNullable(drFont.getBold()).orElse(false);
    final boolean italic = Optional.ofNullable(drFont.getItalic()).orElse(false);
    int fontStyle;
    if (bold && italic) {
      fontStyle = Font.BOLD | Font.ITALIC;
    } else if (bold) {
      fontStyle = Font.BOLD;
    } else if (italic) {
      fontStyle = Font.ITALIC;
    } else {
      fontStyle = Font.PLAIN;
    }
    final String fontName = drFont.getFontName();
    final int fontSize = drFont.getFontSize();
    final FontUtil fontUtil = FontUtil.getInstance(DefaultJasperReportsContext.getInstance());
    return fontUtil.getAwtFontFromBundles(fontName, fontStyle, fontSize,
        Locale.getDefault(), true);
  }
}

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
import static net.sf.dynamicreports.report.builder.DynamicReports.field;

import java.awt.Color;
import java.util.Date;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.CategoryLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.ui.RectangleEdge;
import org.junit.Assert;

/**
 * Gant chart tests.
 * 
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GanttChartTest extends AbstractJasperChartTest {

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    FieldBuilder<String> field1 = field("field1", String.class);
    FieldBuilder<Date> field2 = field("field2", Date.class);
    FieldBuilder<Date> field3 = field("field3", Date.class);
    FieldBuilder<Double> field4 = field("field4", Double.class);
    rb.summary(
        cht.ganttChart().setTask(field1)
            .series(
                cht.ganttSerie().setStartDate(field2).setEndDate(field3).setPercent(field4)
                    .setLabel("label"),
                cht.ganttSerie().setStartDate(DynamicReports.<Date>field("field5", Date.class))
                    .setEndDate(DynamicReports.<Date>field("field6", Date.class)))
            .setShowLabels(true).setShowTickLabels(false).setShowTickMarks(false),
        cht.ganttChart().setTask(field1)
            .series(cht.ganttSerie().setStartDate(field2).setEndDate(field3)).setTaskAxisFormat(
                cht.axisFormat().setLabel("task").setLabelColor(Color.BLUE).setLabelFont(ARIMO_BOLD)
                    .setTickLabelFont(ARIMO_ITALIC).setTickLabelColor(Color.CYAN)
                    .setTickLabelRotation(45d).setLineColor(Color.LIGHT_GRAY)),
        cht.ganttChart().setTask(field1)
            .series(cht.ganttSerie().setStartDate(field2).setEndDate(field3))
            .setTimeAxisFormat(cht.axisFormat().setLabel("time").setLabelColor(Color.BLUE)
                .setLabelFont(ARIMO_BOLD).setTickLabelFont(ARIMO_ITALIC)
                .setTickLabelColor(Color.CYAN).setLineColor(Color.LIGHT_GRAY)));
  }

  @Override
  public void test() {
    super.test();

    numberOfPagesTest(1);

    JFreeChart chart = getChart("summary.chart1", 0);
    CategoryPlot categoryPlot = chart.getCategoryPlot();
    Assert.assertEquals("renderer", GanttRenderer.class, categoryPlot.getRenderer().getClass());
    Assert.assertTrue("show labels", categoryPlot.getRenderer().getBaseItemLabelsVisible());
    Assert.assertFalse("show tick labels", categoryPlot.getDomainAxis().isTickMarksVisible());
    Assert.assertFalse("show tick marks", categoryPlot.getDomainAxis().isTickLabelsVisible());
    ganttChartDataTest(chart, "label", new String[] {"task1", "task2", "task3"},
        new Object[][] {{toDate(2011, 1, 1), toDate(2011, 1, 8), 1d},
            {toDate(2011, 1, 10), toDate(2011, 1, 15), 0.5d},
            {toDate(2011, 1, 15), toDate(2011, 1, 25), 0.8d}});
    ganttChartDataTest(chart, "serie1", new String[] {"task1", "task2", "task3"},
        new Object[][] {{toDate(2011, 1, 2), toDate(2011, 1, 9), null},
            {toDate(2011, 1, 8), toDate(2011, 1, 14), null},
            {toDate(2011, 1, 16), toDate(2011, 1, 20), null}});

    chart = getChart("summary.chart2", 0);
    Axis axis = chart.getCategoryPlot().getDomainAxis();
    Assert.assertEquals("task label", "task", axis.getLabel());
    Assert.assertEquals("task label color", Color.BLUE, axis.getLabelPaint());
    Assert.assertEquals("task label font", ARIMO_BOLD_AWT, axis.getLabelFont());
    Assert.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
    Assert.assertEquals("tick label font", ARIMO_ITALIC_AWT, axis.getTickLabelFont());
    CategoryLabelPosition labelPosition = chart.getCategoryPlot().getDomainAxis()
        .getCategoryLabelPositions().getLabelPosition(RectangleEdge.LEFT);
    Assert.assertEquals("plot label rotation", (45d / 180) * Math.PI, labelPosition.getAngle(), 0);
    Assert.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());

    chart = getChart("summary.chart3", 0);
    axis = chart.getCategoryPlot().getRangeAxis();
    Assert.assertEquals("time label", "time", axis.getLabel());
    Assert.assertEquals("time label color", Color.BLUE, axis.getLabelPaint());
    Assert.assertEquals("time label font", ARIMO_BOLD_AWT, axis.getLabelFont());
    Assert.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
    Assert.assertEquals("tick label font", ARIMO_ITALIC_AWT, axis.getTickLabelFont());
    Assert.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());
  }

  @Override
  protected JRDataSource createDataSource() {
    DRDataSource dataSource =
        new DRDataSource("field1", "field2", "field3", "field4", "field5", "field6");
    dataSource.add("task1", toDate(2011, 1, 1), toDate(2011, 1, 5), 1d, toDate(2011, 1, 2),
        toDate(2011, 1, 6));
    dataSource.add("task1", toDate(2011, 1, 6), toDate(2011, 1, 8), 1d, toDate(2011, 1, 8),
        toDate(2011, 1, 9));
    dataSource.add("task2", toDate(2011, 1, 10), toDate(2011, 1, 15), 0.5d, toDate(2011, 1, 8),
        toDate(2011, 1, 14));
    dataSource.add("task3", toDate(2011, 1, 15), toDate(2011, 1, 25), 0.8d, toDate(2011, 1, 16),
        toDate(2011, 1, 20));
    return dataSource;
  }
}

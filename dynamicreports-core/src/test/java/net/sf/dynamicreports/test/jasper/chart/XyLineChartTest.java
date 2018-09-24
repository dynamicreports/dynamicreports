/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.dynamicreports.test.jasper.chart;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class XyLineChartTest extends AbstractJasperChartTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<Integer> column1;
        TextColumnBuilder<Integer> column2;

        rb.setLocale(Locale.ENGLISH)
          .columns(column1 = col.column("Column1", "field1", Integer.class), column2 = col.column("Column2", "field2", Integer.class))
          .summary(cht.xyLineChart().setXValue(column1).series(cht.xySerie(column2)).setShowShapes(false).setShowLines(false), cht.xyLineChart()
                                                                                                                                  .setXValue(column1)
                                                                                                                                  .series(cht.xySerie(column2))
                                                                                                                                  .setXAxisFormat(cht.axisFormat()
                                                                                                                                                     .setLabel("category")
                                                                                                                                                     .setLabelColor(Color.BLUE)
                                                                                                                                                     .setLabelFont(stl.fontArialBold())
                                                                                                                                                     .setTickLabelFont(stl.fontArial().setItalic(true))
                                                                                                                                                     .setTickLabelColor(Color.CYAN)
                                                                                                                                                     .setLineColor(Color.LIGHT_GRAY)), cht.xyLineChart()
                                                                                                                                                                                          .setXValue(
                                                                                                                                                                                              column1)
                                                                                                                                                                                          .series(
                                                                                                                                                                                              cht.xySerie(
                                                                                                                                                                                                  column2))
                                                                                                                                                                                          .setYAxisFormat(
                                                                                                                                                                                              cht.axisFormat()
                                                                                                                                                                                                 .setLabel(
                                                                                                                                                                                                     "value")
                                                                                                                                                                                                 .setLabelColor(
                                                                                                                                                                                                     Color.BLUE)
                                                                                                                                                                                                 .setLabelFont(
                                                                                                                                                                                                     stl.fontArialBold())
                                                                                                                                                                                                 .setTickLabelFont(
                                                                                                                                                                                                     stl.fontArial()
                                                                                                                                                                                                        .setItalic(
                                                                                                                                                                                                            true))
                                                                                                                                                                                                 .setTickLabelColor(
                                                                                                                                                                                                     Color.CYAN)
                                                                                                                                                                                                 .setTickLabelMask(
                                                                                                                                                                                                     "#,##0.00")
                                                                                                                                                                                                 .setLineColor(
                                                                                                                                                                                                     Color.LIGHT_GRAY)
                                                                                                                                                                                                 .setRangeMinValueExpression(
                                                                                                                                                                                                     1)
                                                                                                                                                                                                 .setRangeMaxValueExpression(
                                                                                                                                                                                                     15)));
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
        Assert.assertEquals("category label", "category", axis.getLabel());
        Assert.assertEquals("category label color", Color.BLUE, axis.getLabelPaint());
        Assert.assertEquals("category label font", new Font("Arial", Font.BOLD, 10), axis.getLabelFont());
        Assert.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
        Assert.assertEquals("tick label font", new Font("Arial", Font.ITALIC, 10), axis.getTickLabelFont());
        Assert.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());

        chart = getChart("summary.chart3", 0);
        axis = chart.getXYPlot().getRangeAxis();
        Assert.assertEquals("value label", "value", axis.getLabel());
        Assert.assertEquals("value label color", Color.BLUE, axis.getLabelPaint());
        Assert.assertEquals("value label font", new Font("Arial", Font.BOLD, 10), axis.getLabelFont());
        Assert.assertEquals("tick label color", Color.CYAN, axis.getTickLabelPaint());
        Assert.assertEquals("tick label font", new Font("Arial", Font.ITALIC, 10), axis.getTickLabelFont());
        Assert.assertEquals("tick label mask", "10.00", ((NumberAxis) axis).getNumberFormatOverride().format(10));
        Assert.assertEquals("line color", Color.LIGHT_GRAY, axis.getAxisLinePaint());
        Assert.assertEquals("range min value", 1d, ((ValueAxis) axis).getLowerBound());
        Assert.assertEquals("range max value", 15d, ((ValueAxis) axis).getUpperBound());
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 4; i++) {
            dataSource.add((i + 1), i + 1);
        }
        return dataSource;
    }
}

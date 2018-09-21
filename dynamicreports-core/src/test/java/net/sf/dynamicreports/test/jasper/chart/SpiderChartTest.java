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
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.SpiderRotation;
import net.sf.dynamicreports.report.constant.TableOrder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRPrintFrame;
import net.sf.jasperreports.engine.JRPrintImage;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.util.Rotation;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class SpiderChartTest extends AbstractJasperChartTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        FieldBuilder<String> column1 = field("field1", String.class);
        TextColumnBuilder<Integer> column2 = col.column("Column2", "field2", Integer.class);

        rb.summary(cmp.horizontalList(cht.spiderChart()
                                         .setCategory(column1)
                                         .series(cht.serie(column2))
                                         .setMaxValue(10d)
                                         .setRotation(SpiderRotation.ANTICLOCKWISE)
                                         .setTableOrder(TableOrder.BY_COLUMN)
                                         .setWebFilled(false)
                                         .setStartAngle(20d)
                                         .setHeadPercent(30d)
                                         .setInteriorGap(0.15d)
                                         .setAxisLineColor(Color.RED)
                                         .setAxisLineWidth(2f)
                                         .setLabelColor(Color.BLUE)
                                         .setLabelGap(2d)
                                         .setLabelFont(stl.font()
                                                          .bold()), cht.spiderChart()
                                                                       .setCategory(column1)
                                                                       .series(cht.serie(column2))
                                                                       .setTitle("title")
                                                                       .setSubtitle("subtitle")));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        JRPrintFrame printFrame = (JRPrintFrame) getElementAt("summary.list1", 0);

        JRPrintImage image = (JRPrintImage) printFrame.getElements()
                                                      .get(0);
        JFreeChart chart = getChart(image);
        SpiderWebPlot plot = (SpiderWebPlot) chart.getPlot();
        Assert.assertEquals("max value", 10d, plot.getMaxValue());
        Assert.assertEquals("rotation", Rotation.ANTICLOCKWISE, plot.getDirection());
        Assert.assertEquals("table order", org.jfree.util.TableOrder.BY_COLUMN, plot.getDataExtractOrder());
        Assert.assertFalse("web filled", plot.isWebFilled());
        Assert.assertEquals("start angle", 20d, plot.getStartAngle());
        Assert.assertEquals("head percent", 30d, plot.getHeadPercent());
        Assert.assertEquals("interior gap", 0.15d, plot.getInteriorGap());
        Assert.assertEquals("axis line color", Color.RED, plot.getAxisLinePaint());
        Assert.assertEquals("interior gap", 2f, ((BasicStroke) plot.getAxisLineStroke()).getLineWidth());
        Assert.assertEquals("label color", Color.BLUE, plot.getLabelPaint());
        Assert.assertEquals("label gap", 2d, plot.getAxisLabelGap());
        Assert.assertTrue("label font", plot.getLabelFont()
                                            .isBold());

        image = (JRPrintImage) printFrame.getElements()
                                         .get(1);
        chart = getChart(image);
        plot = (SpiderWebPlot) chart.getPlot();
        Assert.assertEquals("title", "title", chart.getTitle()
                                                   .getText());
        Assert.assertEquals("subtitle", "subtitle", ((TextTitle) chart.getSubtitle(1)).getText());
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 4; i++) {
            dataSource.add("value" + (i + 1), i + 1);
            dataSource.add("value" + (i + 1), i + 1);
        }
        return dataSource;
    }
}

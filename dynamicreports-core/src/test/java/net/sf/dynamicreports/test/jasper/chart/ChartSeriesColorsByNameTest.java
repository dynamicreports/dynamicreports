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

import org.junit.Assert;
import net.sf.dynamicreports.design.transformation.chartcustomizer.GroupedStackedBarRendererCustomizer;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;

import java.awt.Color;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ChartSeriesColorsByNameTest extends AbstractJasperChartTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Map<String, Color> colors;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1;
        TextColumnBuilder<String> column2;
        TextColumnBuilder<Integer> column3;
        TextColumnBuilder<String> column4;
        TextColumnBuilder<Integer> column5;

        colors = new HashMap<String, Color>();
        colors.put("a", Color.BLUE);
        colors.put("b", Color.YELLOW);
        colors.put("c", Color.GREEN);
        colors.put("d", Color.MAGENTA);

        rb.addProperty("net.sf.jasperreports.chart.pie.ignore.duplicated.key", "true")
          .columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", String.class), column3 = col.column("Column3", "field3", Integer.class),
                   column4 = col.column("Column4", "field4", String.class), column5 = col.column("Column5", "field5", Integer.class))
          .summary(cmp.horizontalList(cht.barChart().seriesColorsByName(colors).setCategory(column1).series(cht.serie(column3).setSeries(column2)),
                                      cht.groupedStackedBarChart().seriesColorsByName(colors).setCategory(column1).series(cht.groupedSerie(column3).setSeries(column2).setGroup(column4))),
                   cmp.horizontalList(cht.pieChart().seriesColorsByName(colors).setKey(column2).series(cht.serie(column3)),
                                      cht.xyBarChart().seriesColorsByName(colors).setXValue(column5).series(cht.xySerie(column3).setSeries(column2))), cmp.horizontalList(cht.barChart()
                                                                                                                                                                             .setDataSource(
                                                                                                                                                                                 new DRDataSource(
                                                                                                                                                                                     "field1", "field2",
                                                                                                                                                                                     "field3", "field4",
                                                                                                                                                                                     "field5"))
                                                                                                                                                                             .seriesColorsByName(colors)
                                                                                                                                                                             .setCategory(column1)
                                                                                                                                                                             .series(cht.serie(column3)
                                                                                                                                                                                        .setSeries(
                                                                                                                                                                                            column2)),
                                                                                                                                                                          cht.pieChart()
                                                                                                                                                                             .setDataSource(
                                                                                                                                                                                 new DRDataSource(
                                                                                                                                                                                     "field1", "field2",
                                                                                                                                                                                     "field3", "field4",
                                                                                                                                                                                     "field5"))
                                                                                                                                                                             .seriesColorsByName(colors)
                                                                                                                                                                             .setKey(column2)
                                                                                                                                                                             .series(
                                                                                                                                                                                 cht.serie(column3)),
                                                                                                                                                                          cht.xyBarChart()
                                                                                                                                                                             .setDataSource(
                                                                                                                                                                                 new DRDataSource(
                                                                                                                                                                                     "field1", "field2",
                                                                                                                                                                                     "field3", "field4",
                                                                                                                                                                                     "field5"))
                                                                                                                                                                             .seriesColorsByName(colors)
                                                                                                                                                                             .setXValue(column5)
                                                                                                                                                                             .series(
                                                                                                                                                                                 cht.xySerie(column3)
                                                                                                                                                                                    .setSeries(
                                                                                                                                                                                        column2))));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        chartCountTest("summary.chart1", 1);
        JFreeChart chart = getChart("summary.chart1", 0);
        CategoryItemRenderer renderer1 = chart.getCategoryPlot().getRenderer();
        CategoryDataset dataset1 = chart.getCategoryPlot().getDataset();
        for (int i = 0; i < dataset1.getRowCount(); i++) {
            String key = (String) dataset1.getRowKey(i);
            Assert.assertNotNull("null series color", colors.get(key));
            Assert.assertEquals("series color", colors.get(key), renderer1.getSeriesPaint(i));
        }

        chartCountTest("summary.chart2", 1);
        chart = getChart("summary.chart2", 0);
        CategoryItemRenderer renderer2 = chart.getCategoryPlot().getRenderer();
        CategoryDataset dataset2 = chart.getCategoryPlot().getDataset();
        for (int i = 0; i < dataset2.getRowCount(); i++) {
            String key = (String) dataset2.getRowKey(i);
            key = StringUtils.substringAfter(key, GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY);
            Assert.assertNotNull("null series color", colors.get(key));
            Assert.assertEquals("series color", colors.get(key), renderer2.getSeriesPaint(i));
        }
        for (
            int i = 0; i < chart.getCategoryPlot().getFixedLegendItems().getItemCount(); i++) {
            LegendItem legendItem = chart.getCategoryPlot().getFixedLegendItems().get(i);
            Assert.assertNotNull("null series color", colors.get(legendItem.getLabel()));
            Assert.assertEquals("series color", colors.get(legendItem.getLabel()), legendItem.getFillPaint());
        }

        chartCountTest("summary.chart3", 1);
        chart = getChart("summary.chart3", 0);
        PiePlot plot3 = (PiePlot) chart.getPlot();
        PieDataset dataset3 = plot3.getDataset();
        for (int i = 0; i < dataset3.getItemCount(); i++) {
            String key = (String) dataset3.getKey(i);
            Assert.assertNotNull("null series color", colors.get(key));
            Assert.assertEquals("series color", colors.get(key), plot3.getSectionPaint(key));
        }

        chartCountTest("summary.chart4", 1);
        chart = getChart("summary.chart4", 0);
        XYItemRenderer renderer4 = chart.getXYPlot().getRenderer();
        XYDataset dataset4 = chart.getXYPlot().getDataset();
        for (int i = 0; i < dataset4.getSeriesCount(); i++) {
            String key = (String) dataset4.getSeriesKey(i);
            Assert.assertNotNull("null series color", colors.get(key));
            Assert.assertEquals("series color", colors.get(key), renderer4.getSeriesPaint(i));
        }
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5");
        dataSource.add("value1", "a", 1, "1", 1);
        dataSource.add("value1", "b", 2, "1", 1);
        dataSource.add("value1", "c", 3, "1", 1);
        dataSource.add("value2", "c", 2, "2", 2);
        dataSource.add("value2", "d", 4, "2", 2);
        dataSource.add("value2", "a", 3, "2", 2);
        return dataSource;
    }
}

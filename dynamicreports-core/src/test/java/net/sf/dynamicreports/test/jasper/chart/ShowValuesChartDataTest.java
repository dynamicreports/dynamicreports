/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.TimePeriod;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.junit.Assert;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;

/**
 * @author Ricardo Mariaca
 */
public class ShowValuesChartDataTest extends AbstractJasperChartTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1;
        TextColumnBuilder<Integer> column2;
        TextColumnBuilder<Integer> column3;
        TextColumnBuilder<Date> column4;

        Locale.setDefault(Locale.ENGLISH);

        rb.setPageFormat(PageType.A2, PageOrientation.PORTRAIT)
          .columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class), column3 = col.column("Column3", "field3", Integer.class),
                   column4 = col.column("Column4", "field4", Date.class))
          .summary(cmp.horizontalList(cht.barChart().setShowValues(true).setCategory(column1).series(cht.serie(column2), cht.serie(column3)), cht.bar3DChart()
                                                                                                                                                 .setShowValues(true)
                                                                                                                                                 .setValuePattern("#,##0.#")
                                                                                                                                                 .setCategory(column1)
                                                                                                                                                 .series(cht.serie(column2), cht.serie(column3))
                                                                                                                                                 .setValueAxisFormat(
                                                                                                                                                     cht.axisFormat().setRangeMaxValueExpression(6)),
                                      cht.stackedBarChart().setShowValues(true).setCategory(column1).series(cht.serie(column2), cht.serie(column3)),
                                      cht.stackedBar3DChart().setShowValues(true).setCategory(column1).series(cht.serie(column2), cht.serie(column3))),
                   cmp.horizontalList(cht.areaChart().setShowValues(true).setCategory(column1).series(cht.serie(column3), cht.serie(column2)),
                                      cht.lineChart().setShowValues(true).setCategory(column1).series(cht.serie(column2), cht.serie(column3)),
                                      cht.groupedStackedBarChart().setShowValues(true).setCategory(column1).series(cht.groupedSerie(column2).setGroup(column1).setSeries(column1))),
                   cmp.horizontalList(cht.pieChart().setShowValues(true).setKey(column1).series(cht.serie(column2)),
                                      cht.pie3DChart().setShowValues(true).setValuePattern("#,##0.#").setKey(column1).series(cht.serie(column2))),
                   cmp.horizontalList(cht.xyBarChart().setShowValues(true).setXValue(column2).series(cht.xySerie(column3)),
                                      cht.xyLineChart().setShowValues(true).setValuePattern("#,##0.#").setXValue(column2).series(cht.xySerie(column3)),
                                      cht.scatterChart().setShowValues(true).setXValue(column2).series(cht.xySerie(column3))),
                   cmp.horizontalList(cht.timeSeriesChart().setShowValues(true).setTimePeriod(column4).series(cht.serie(column2), cht.serie(column3)).setTimePeriodType(TimePeriod.DAY),
                                      cht.differenceChart().setShowValues(true).setTimePeriod(column4).series(cht.serie(column2), cht.serie(column3)).setTimePeriodType(TimePeriod.DAY),
                                      cht.xyStepChart().setShowValues(true).setValuePattern("#,##0.#").setXValue(column2).series(cht.xySerie(column3)),
                                      cht.waterfallBarChart().setShowValues(true).setValuePattern("#,##0.#").setCategory(column1).series(cht.serie(column2))));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
        categoryDataset.addValue(1.191, "row", "column");

        JFreeChart chart = getChart("summary.chart1", 0);
        CategoryItemRenderer renderer1 = chart.getCategoryPlot().getRenderer();
        Assert.assertNotNull(renderer1.getBaseItemLabelGenerator());
        Assert.assertEquals("1.19", renderer1.getBaseItemLabelGenerator().generateLabel(categoryDataset, 0, 0));
        Assert.assertEquals(5.775d, chart.getCategoryPlot().getRangeAxis().getRange().getUpperBound(), 0);
        Assert.assertTrue(renderer1.getBaseItemLabelsVisible());

        chart = getChart("summary.chart2", 0);
        renderer1 = chart.getCategoryPlot().getRenderer();
        Assert.assertNotNull(renderer1.getBaseItemLabelGenerator());
        Assert.assertEquals("1.2", renderer1.getBaseItemLabelGenerator().generateLabel(categoryDataset, 0, 0));
        Assert.assertEquals(6d, chart.getCategoryPlot().getRangeAxis().getRange().getUpperBound(), 0);
        Assert.assertTrue(renderer1.getBaseItemLabelsVisible());

        chart = getChart("summary.chart3", 0);
        renderer1 = chart.getCategoryPlot().getRenderer();
        Assert.assertNotNull(renderer1.getBaseItemLabelGenerator());
        Assert.assertTrue(renderer1.getBaseItemLabelsVisible());

        chart = getChart("summary.chart4", 0);
        renderer1 = chart.getCategoryPlot().getRenderer();
        Assert.assertNotNull(renderer1.getBaseItemLabelGenerator());
        Assert.assertTrue(renderer1.getBaseItemLabelsVisible());

        chart = getChart("summary.chart5", 0);
        renderer1 = chart.getCategoryPlot().getRenderer();
        Assert.assertNotNull(renderer1.getBaseItemLabelGenerator());
        Assert.assertTrue(renderer1.getBaseItemLabelsVisible());

        chart = getChart("summary.chart6", 0);
        renderer1 = chart.getCategoryPlot().getRenderer();
        Assert.assertNotNull(renderer1.getBaseItemLabelGenerator());
        Assert.assertTrue(renderer1.getBaseItemLabelsVisible());

        chart = getChart("summary.chart7", 0);
        renderer1 = chart.getCategoryPlot().getRenderer();
        Assert.assertNotNull(renderer1.getBaseItemLabelGenerator());
        Assert.assertTrue(renderer1.getBaseItemLabelsVisible());

        chart = getChart("summary.chart8", 0);
        String labelFormat = ((StandardPieSectionLabelGenerator) ((PiePlot) chart.getPlot()).getLabelGenerator()).getLabelFormat();
        Assert.assertEquals("Label format", "{0} = {1}", labelFormat);

        chart = getChart("summary.chart9", 0);
        StandardPieSectionLabelGenerator labelGenerator = (StandardPieSectionLabelGenerator) ((PiePlot) chart.getPlot()).getLabelGenerator();
        labelFormat = labelGenerator.getLabelFormat();
        Assert.assertEquals("Label format", "{0} = {1}", labelFormat);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("key1", 1.192);
        Assert.assertEquals("key1 = 1.2", labelGenerator.generateSectionLabel(dataset, "key1"));

        DefaultXYDataset xyDataset = new DefaultXYDataset();
        xyDataset.addSeries("key", new double[][] {new double[] {1d}, new double[] {1.191d}});

        chart = getChart("summary.chart10", 0);
        XYItemRenderer renderer2 = chart.getXYPlot().getRenderer();
        Assert.assertNotNull(renderer2.getBaseItemLabelGenerator());
        Assert.assertEquals("1.19", renderer2.getBaseItemLabelGenerator().generateLabel(xyDataset, 0, 0));
        Assert.assertTrue(renderer2.getBaseItemLabelsVisible());

        chart = getChart("summary.chart11", 0);
        renderer2 = chart.getXYPlot().getRenderer();
        Assert.assertNotNull(renderer2.getBaseItemLabelGenerator());
        Assert.assertEquals("1.2", renderer2.getBaseItemLabelGenerator().generateLabel(xyDataset, 0, 0));
        Assert.assertTrue(renderer2.getBaseItemLabelsVisible());

        chart = getChart("summary.chart12", 0);
        renderer2 = chart.getXYPlot().getRenderer();
        Assert.assertNotNull(renderer2.getBaseItemLabelGenerator());
        Assert.assertTrue(renderer2.getBaseItemLabelsVisible());

        chart = getChart("summary.chart13", 0);
        renderer2 = chart.getXYPlot().getRenderer();
        Assert.assertNotNull(renderer2.getBaseItemLabelGenerator());
        Assert.assertTrue(renderer2.getBaseItemLabelsVisible());

        chart = getChart("summary.chart14", 0);
        renderer2 = chart.getXYPlot().getRenderer();
        Assert.assertNotNull(renderer2.getBaseItemLabelGenerator());
        Assert.assertTrue(renderer2.getBaseItemLabelsVisible());

        chart = getChart("summary.chart15", 0);
        renderer2 = chart.getXYPlot().getRenderer();
        Assert.assertNotNull(renderer2.getBaseItemLabelGenerator());
        Assert.assertEquals("1.2", renderer2.getBaseItemLabelGenerator().generateLabel(xyDataset, 0, 0));
        Assert.assertTrue(renderer2.getBaseItemLabelsVisible());

        chart = getChart("summary.chart16", 0);
        renderer1 = chart.getCategoryPlot().getRenderer();
        Assert.assertNotNull(renderer1.getBaseItemLabelGenerator());
        Assert.assertEquals("1.2", renderer1.getBaseItemLabelGenerator().generateLabel(categoryDataset, 0, 0));
        Assert.assertTrue(renderer1.getBaseItemLabelsVisible());
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        for (int i = 0; i < 4; i++) {
            dataSource.add("value" + (i + 1), i + 1, i + 2, c.getTime());
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dataSource;
    }
}

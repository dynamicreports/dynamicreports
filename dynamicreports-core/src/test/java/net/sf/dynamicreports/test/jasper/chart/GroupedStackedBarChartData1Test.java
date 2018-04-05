/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import junit.framework.Assert;
import net.sf.dynamicreports.design.transformation.chartcustomizer.GroupedStackedBarRendererCustomizer;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GroupedStackedBarChartData1Test extends AbstractJasperChartTest {

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		TextColumnBuilder<String> column1;
		TextColumnBuilder<String> column2;
		TextColumnBuilder<String> column3;
		TextColumnBuilder<Integer> column4;
		TextColumnBuilder<Integer> column5;

		rb.columns(
				column1 = col.column("Column1", "field1", String.class),
				column2 = col.column("Column2", "field2", String.class),
				column3 = col.column("Column3", "field3", String.class),
				column4 = col.column("Column4", "field4", Integer.class),
				column5 = col.column("Column5", "field5", Integer.class))
				.summary(
						cmp.horizontalList(
								cht.groupedStackedBarChart()
										.setCategory(column1)
										.series(cht.groupedSerie(column4).setSeries(column2).setGroup(column3)),
								cht.groupedStackedBarChart()
										.setCategory(column1)
										.series(cht.groupedSerie(column4).setGroup(column3), cht.groupedSerie(column5).setGroup(column3))),
						cmp.horizontalList(
								cht.groupedStackedBarChart()
										.setShowPercentages(true)
										.setCategory(column1)
										.series(cht.groupedSerie(column4).setSeries(column2).setGroup(column3)),
								cht.groupedStackedBarChart()
										.setShowPercentages(true)
										.setCategory(column1)
										.series(cht.groupedSerie(column4).setGroup(column3), cht.groupedSerie(column5).setGroup(column3))),
						cht.groupedStackedBarChart()
								.setDataSource(createDataSource1())
								.setCategory(column1)
								.series(cht.groupedSerie(column4).setSeries(column2).setGroup(column3)));
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);

		String[] categories = new String[] { "value1", "value2" };
		String[] series = new String[] {
				"group1" + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + "series1",
				"group1" + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + "series2",
				"group2" + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + "series1",
				"group2" + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + "series2" };
		Number[][] values = new Number[][] { { 1d, 3d, 5d, 7d }, { 7d, 5d, 3d, 1d } };
		chartCountTest("summary.chart1", 1);
		chartCategoryCountTest("summary.chart1", 0, 2);
		chartSeriesCountTest("summary.chart1", 0, 4);
		chartDataTest("summary.chart1", 0, categories, series, values);

		values = new Number[][] { { 1d / 4 * 100, 3d / 4 * 100, 5d / 12 * 100, 7d / 12 * 100 }, { 7d / 12 * 100, 5d / 12 * 100, 3d / 4 * 100, 1d / 4 * 100 } };
		chartCountTest("summary.chart3", 1);
		chartCategoryCountTest("summary.chart3", 0, 2);
		chartSeriesCountTest("summary.chart3", 0, 4);
		chartDataTest("summary.chart3", 0, categories, series, values);

		values = new Number[][] { { null, 3d, 5d, 7d }, { 7d, 5d, 3d, 1d } };
		chartCountTest("summary.chart5", 1);
		chartCategoryCountTest("summary.chart5", 0, 2);
		chartSeriesCountTest("summary.chart5", 0, 4);
		chartDataTest("summary.chart5", 0, categories, series, values);
		JFreeChart chart = getChart("summary.chart5", 0);
		CategoryDataset dataset = chart.getCategoryPlot().getDataset();
		Assert.assertEquals("row key", "group1" + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + "series2", dataset.getRowKey(0));
		Assert.assertEquals("row key", "group1" + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + "series1", dataset.getRowKey(1));
		Assert.assertEquals("row key", "group2" + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + "series2", dataset.getRowKey(2));

		series = new String[] {
				"group1" + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + "Column4",
				"group1" + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + "Column5",
				"group2" + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + "Column4",
				"group2" + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + "Column5" };
		values = new Number[][] { { 4d, 6d, 12d, 14d }, { 12d, 14d, 4d, 6d } };
		chartCountTest("summary.chart2", 1);
		chartCategoryCountTest("summary.chart2", 0, 2);
		chartSeriesCountTest("summary.chart2", 0, 4);
		chartDataTest("summary.chart2", 0, categories, series, values);

		values = new Number[][] { { 4d / 10 * 100, 6d / 10 * 100, 12d / 26 * 100, 14d / 26 * 100 },
				{ 12d / 26 * 100, 14d / 26 * 100, 4d / 10 * 100, 6d / 10 * 100 } };
		chartCountTest("summary.chart4", 1);
		chartCategoryCountTest("summary.chart4", 0, 2);
		chartSeriesCountTest("summary.chart4", 0, 4);
		chartDataTest("summary.chart4", 0, categories, series, values);
	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5");
		dataSource.add("value1", "series1", "group1", 1, 2);
		dataSource.add("value1", "series2", "group1", 3, 4);
		dataSource.add("value1", "series1", "group2", 5, 6);
		dataSource.add("value1", "series2", "group2", 7, 8);
		dataSource.add("value2", "series1", "group1", 7, 8);
		dataSource.add("value2", "series2", "group1", 5, 6);
		dataSource.add("value2", "series1", "group2", 3, 4);
		dataSource.add("value2", "series2", "group2", 1, 2);
		dataSource.add("value2", "series2", "group2", null, null);
		return dataSource;
	}

	private JRDataSource createDataSource1() {
		DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5");
		dataSource.add("value1", "series2", "group1", 3, 4);
		dataSource.add("value1", "series1", "group2", 5, 6);
		dataSource.add("value1", "series2", "group2", 7, 8);
		dataSource.add("value2", "series1", "group1", 7, 8);
		dataSource.add("value2", "series2", "group1", 5, 6);
		dataSource.add("value2", "series1", "group2", 3, 4);
		dataSource.add("value2", "series2", "group2", 1, 2);
		return dataSource;
	}
}

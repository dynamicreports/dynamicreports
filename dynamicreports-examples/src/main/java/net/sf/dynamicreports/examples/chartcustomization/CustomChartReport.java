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

package net.sf.dynamicreports.examples.chartcustomization;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.base.AbstractScriptlet;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.charts.util.DrawChartRendererImpl;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.renderers.Renderable;

/**
 * <p>CustomChartReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class CustomChartReport {
	private DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();

	/**
	 * <p>Constructor for CustomChartReport.</p>
	 */
	public CustomChartReport() {
		build();
	}

	private void build() {
		TextColumnBuilder<String> seriesColumn = col.column("Series", "series", type.stringType());
		TextColumnBuilder<String> categoryColumn = col.column("Category", "category", type.stringType());
		TextColumnBuilder<Double> meanColumn = col.column("Mean", "mean", type.doubleType());
		TextColumnBuilder<Double> medianColumn = col.column("Median", "median", type.doubleType());
		TextColumnBuilder<Double> q1Column = col.column("Q1", "q1", type.doubleType());
		TextColumnBuilder<Double> q3Column = col.column("Q3", "q3", type.doubleType());
		TextColumnBuilder<Double> minRegularValueColumn = col.column("Min regular value", "minregularvalue", type.doubleType());
		TextColumnBuilder<Double> maxRegularValueColumn = col.column("Max regular value", "maxregularvalue", type.doubleType());
		TextColumnBuilder<Double> minOutlierColumn = col.column("Min outlier", "minoutlier", type.doubleType());
		TextColumnBuilder<Double> maxOutlierColumn = col.column("Max outlier", "maxoutlier", type.doubleType());

		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.scriptlets(new ReportScriptlet())
					.columns(seriesColumn, categoryColumn, meanColumn, medianColumn, q1Column, q3Column, minRegularValueColumn, maxRegularValueColumn, minOutlierColumn,
							maxOutlierColumn)
					.title(Templates.createTitleComponent("CustomChart"))
					.summary(
							cmp.image(new ChartExpression()).setFixedHeight(300))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("series", "category", "mean", "median", "q1", "q3", "minregularvalue", "maxregularvalue", "minoutlier",
				"maxoutlier");
		dataSource.add("Series 0", "Category 0", 10.55d, 10.75d, 6.05d, 14.76d, 1.93d, 18.51d, 1.93d, 18.51d);
		dataSource.add("Series 0", "Category 1", 8.92d, 7.78d, 4.32d, 13.07d, 1.01d, 19.89d, 1.01d, 19.89d);
		dataSource.add("Series 0", "Category 2", 12.88d, 14.19d, 8.72d, 17.23d, 2.48d, 19.74d, 2.48d, 19.74d);
		dataSource.add("Series 0", "Category 3", 8.87d, 8.68d, 3.55d, 14.26d, 0.13d, 16.87d, 0.13d, 16.87d);
		dataSource.add("Series 0", "Category 4", 9.05d, 8.33d, 3.61d, 14.28d, 0.46d, 19.86d, 0.46d, 19.86d);
		dataSource.add("Series 1", "Category 0", 10.11d, 10.69d, 3.96d, 13.93d, 0.58d, 19.9d, 0.58d, 19.9d);
		dataSource.add("Series 1", "Category 1", 10.43d, 9.13d, 5.72d, 14.46d, 2.25d, 19.79d, 2.25d, 19.79d);
		dataSource.add("Series 1", "Category 2", 10.04d, 8.71d, 6.32d, 15.15d, 0.04d, 19.15d, 0.04d, 19.15d);
		dataSource.add("Series 1", "Category 3", 10.67d, 10.56d, 7.14d, 14.76d, 0.27d, 16.99d, 0.27d, 16.99d);
		dataSource.add("Series 1", "Category 4", 10.91d, 10.63d, 7.18d, 15.51d, 2.3d, 19.53d, 2.3d, 19.53d);
		return dataSource;
	}

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		new CustomChartReport();
	}

	private class ReportScriptlet extends AbstractScriptlet {

		@Override
		public void afterDetailEval(ReportParameters reportParameters) {
			super.afterDetailEval(reportParameters);
			String series = reportParameters.getValue("series");
			String category = reportParameters.getValue("category");
			Double mean = reportParameters.getValue("mean");
			Double median = reportParameters.getValue("median");
			Double q1 = reportParameters.getValue("q1");
			Double q3 = reportParameters.getValue("q3");
			Double minRegularValue = reportParameters.getValue("minregularvalue");
			Double maxRegularValue = reportParameters.getValue("maxregularvalue");
			Double minOutlier = reportParameters.getValue("minoutlier");
			Double maxOutlier = reportParameters.getValue("maxoutlier");
			BoxAndWhiskerItem item = new BoxAndWhiskerItem(mean, median, q1, q3, minRegularValue, maxRegularValue, minOutlier, maxOutlier, null);
			dataset.add(item, series, category);
		}
	}

	private class ChartExpression extends AbstractSimpleExpression<Renderable> {
		private static final long serialVersionUID = 1L;

		@Override
		public Renderable evaluate(ReportParameters reportParameters) {
			JFreeChart chart = ChartFactory.createBoxAndWhiskerChart("Box and Whisker chart", "Category", "Value", dataset, true);
			return new DrawChartRendererImpl(chart, null);
		}
	}

}

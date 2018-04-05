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

import java.io.Serializable;
import java.math.BigDecimal;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.chart.BarChartBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.renderer.category.BarRenderer;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ChartLayoutReport {

	public ChartLayoutReport() {
		build();
	}

	private void build() {
		FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

		TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
		TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
		TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());

		JasperReportBuilder subreport = report();
		subreport
				.setTemplate(Templates.reportTemplate)
				.columns(itemColumn, quantityColumn, unitPriceColumn)
				.setDataSource(createDataSource());

		BarChartBuilder chart = cht.barChart()
				.customizers(new ChartCustomizer())
				.setTitle("Bar chart")
				.setTitleFont(boldFont)
				.setCategory(itemColumn)
				.series(
						cht.serie(quantityColumn), cht.serie(unitPriceColumn))
				.setValueAxisFormat(
						cht.axisFormat().setRangeMaxValueExpression(500))
				.setCategoryAxisFormat(
						cht.axisFormat().setLabel("Item"));

		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.title(Templates.createTitleComponent("ChartLayout"))
					.summary(
							cmp.horizontalList(chart, cmp.subreport(subreport)))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private class ChartCustomizer implements DRIChartCustomizer, Serializable {
		private static final long serialVersionUID = 1L;

		@Override
		public void customize(JFreeChart chart, ReportParameters reportParameters) {
			BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
			renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer.setBaseItemLabelsVisible(true);
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
		dataSource.add("Tablet", 350, new BigDecimal(300));
		dataSource.add("Laptop", 300, new BigDecimal(500));
		dataSource.add("Smartphone", 450, new BigDecimal(250));
		return dataSource;
	}

	public static void main(String[] args) {
		new ChartLayoutReport();
	}
}

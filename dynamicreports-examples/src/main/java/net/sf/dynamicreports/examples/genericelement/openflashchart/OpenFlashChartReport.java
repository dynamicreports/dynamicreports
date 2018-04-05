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

package net.sf.dynamicreports.examples.genericelement.openflashchart;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder;
import net.sf.dynamicreports.report.base.AbstractScriptlet;
import net.sf.dynamicreports.report.builder.component.GenericElementBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class OpenFlashChartReport {
	private PieChart pieChart1;
	private PieChart pieChart2;

	public OpenFlashChartReport() {
		build();
	}

	private void build() {
		pieChart1 = new PieChart();
		pieChart1.setTitle("Quantity");
		GenericElementBuilder chart1 = cmp.genericElement("http://www.dynamicreports.org/openflashchart", "openflashchart")
				.setHeight(200)
				.addParameter(PieChart.PARAMETER_CHART_GENERATOR, pieChart1);

		pieChart2 = new PieChart();
		pieChart2.setTitle("Unit price");
		GenericElementBuilder chart2 = cmp.genericElement("http://www.dynamicreports.org/openflashchart", "openflashchart")
				.setHeight(200)
				.addParameter(PieChart.PARAMETER_CHART_GENERATOR, pieChart2);

		try {
			JasperHtmlExporterBuilder htmlExporter = export.htmlExporter("c:/report.html")
					.setImagesDirName("c:/images")
					.setOutputImagesToDir(true);

			report()
					.setTemplate(Templates.reportTemplate)
					.scriptlets(new ReportScriptlet())
					.columns(
							col.column("Item", "item", type.stringType()),
							col.column("Quantity", "quantity", type.integerType()),
							col.column("Unit price", "unitprice", type.bigDecimalType()))
					.title(Templates.createTitleComponent("OpenFlashChart"))
					.summary(
							cmp.horizontalList(chart1, chart2))
					.setDataSource(createDataSource())
					.toHtml(htmlExporter);
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
		dataSource.add("Book", 60, new BigDecimal(150));
		dataSource.add("Camera", 40, new BigDecimal(400));
		dataSource.add("PDA", 50, new BigDecimal(250));
		return dataSource;
	}

	private class ReportScriptlet extends AbstractScriptlet {

		@Override
		public void afterDetailEval(ReportParameters reportParameters) {
			super.afterDetailEval(reportParameters);
			String item = reportParameters.getValue("item");
			Integer quantity = reportParameters.getValue("quantity");
			BigDecimal unitPrice = reportParameters.getValue("unitprice");
			pieChart1.addValue(item, quantity);
			pieChart2.addValue(item, unitPrice);
		}
	}

	public static void main(String[] args) {
		new OpenFlashChartReport();
	}
}

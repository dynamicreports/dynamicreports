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

import java.math.BigDecimal;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.chart.Bar3DChartBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GroupChartReport {

	public GroupChartReport() {
		build();
	}

	private void build() {
		TextColumnBuilder<String> countryColumn = col.column("Country", "country", type.stringType());
		TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
		TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
		TextColumnBuilder<BigDecimal> salesColumn = col.column("Sales", "sales", type.bigDecimalType());

		Bar3DChartBuilder chart = cht.bar3DChart()
				.setFixedHeight(180)
				.setCategory(itemColumn)
				.series(cht.serie(quantityColumn), cht.serie(salesColumn))
				.setCategoryAxisFormat(
						cht.axisFormat().setLabel("Item"));

		ColumnGroupBuilder countryGroup = grp.group(countryColumn)
				.footer(chart);

		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.columns(countryColumn, itemColumn, quantityColumn, salesColumn)
					.title(Templates.createTitleComponent("GroupChart"))
					.groupBy(countryGroup)
					.summary(
							cmp.text("All countries").setStyle(Templates.bold12CenteredStyle),
							chart)
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("country", "item", "quantity", "sales");
		dataSource.add("USA", "Tablet", 170, new BigDecimal(100));
		dataSource.add("USA", "Laptop", 90, new BigDecimal(280));
		dataSource.add("USA", "Smartphone", 120, new BigDecimal(250));
		dataSource.add("Canada", "Tablet", 120, new BigDecimal(80));
		dataSource.add("Canada", "Laptop", 150, new BigDecimal(310));
		dataSource.add("Canada", "Smartphone", 100, new BigDecimal(180));
		return dataSource;
	}

	public static void main(String[] args) {
		new GroupChartReport();
	}
}

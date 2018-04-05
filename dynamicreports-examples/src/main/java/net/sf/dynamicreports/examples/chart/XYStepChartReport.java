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

package net.sf.dynamicreports.examples.chart;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class XYStepChartReport {

	public XYStepChartReport() {
		build();
	}

	private void build() {
		FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

		TextColumnBuilder<Integer> xColumn = col.column("X", "x", type.integerType());
		TextColumnBuilder<Integer> y1Column = col.column("Y1", "y1", type.integerType());
		TextColumnBuilder<Integer> y2Column = col.column("Y2", "y2", type.integerType());

		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.columns(xColumn, y1Column, y2Column)
					.title(Templates.createTitleComponent("XYStepChart"))
					.summary(
							cht.xyStepChart()
									.setTitle("XY step chart")
									.setTitleFont(boldFont)
									.setXValue(xColumn)
									.series(
											cht.xySerie(y1Column), cht.xySerie(y2Column))
									.setXAxisFormat(
											cht.axisFormat().setLabel("X"))
									.setYAxisFormat(
											cht.axisFormat().setLabel("Y")))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("x", "y1", "y2");
		for (int i = 0; i < 15; i++) {
			dataSource.add(i, (int) (Math.random() * 10), (int) (Math.random() * 10));
		}
		return dataSource;
	}

	public static void main(String[] args) {
		new XYStepChartReport();
	}
}

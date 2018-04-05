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

import java.util.Calendar;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.TimePeriod;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DifferenceChartReport {

	public DifferenceChartReport() {
		build();
	}

	private void build() {
		FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.title(Templates.createTitleComponent("DifferenceChart"))
					.summary(
							cht.differenceChart()
									.setTitle("Difference chart")
									.setTitleFont(boldFont)
									.setTimePeriod(field("date", type.dateType()))
									.setTimePeriodType(TimePeriod.DAY)
									.series(
											cht.serie(field("value1", type.doubleType())).setLabel("Value1"),
											cht.serie(field("value2", type.doubleType())).setLabel("Value2"))
									.setTimeAxisFormat(
											cht.axisFormat().setLabel("Date")))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("date", "value1", "value2");
		double value1 = 0;
		double value2 = 0;
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < 300; i++) {
			c.add(Calendar.DAY_OF_MONTH, -1);
			value1 += Math.random() - 0.5;
			value2 += Math.random() - 0.5;
			dataSource.add(c.getTime(), value1, value2);
		}
		return dataSource;
	}

	public static void main(String[] args) {
		new DifferenceChartReport();
	}
}

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

package net.sf.dynamicreports.examples.gettingstarted;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Rotation;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class BandReport {
	private StyleBuilder boldCenteredStyle;

	public BandReport() {
		build();
	}

	private void build() {
		boldCenteredStyle = stl.style()
				.bold()
				.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
		StyleBuilder backgroundStyle = stl.style(boldCenteredStyle)
				.setVerticalTextAlignment(VerticalTextAlignment.MIDDLE)
				.setRotation(Rotation.LEFT);

		TextColumnBuilder<String> column1 = col.column("Column1", "column1", type.stringType());
		TextColumnBuilder<String> column2 = col.column("Column2", "column2", type.stringType());
		ColumnGroupBuilder columnGroup = grp.group(column1);

		try {
			report()// create new report design
					.setPageColumnsPerPage(2)
					.columns(column1, column2)
					.groupBy(columnGroup)

					// bands
					.title(createTextField("This is a title band"))
					.pageHeader(createTextField("This is a page header band"))
					.pageFooter(createTextField("This is a page footer band"))
					.columnHeader(createTextField("This is a column header band"))
					.columnFooter(createTextField("This is a column footer band"))
					.lastPageFooter(createTextField("This is a last page footer band"))
					.summary(createTextField("This is a summary band"))
					// .detailHeader(createTextField("This is a detail header band"))
					// .detailFooter(createTextField("This is a detail footer band"))
					.groupHeader(columnGroup, createTextField("This is a group header band"))
					.groupFooter(columnGroup, createTextField("This is a group footer band"))
					.background(createTextField("This is a background band").setHeight(800).setStyle(backgroundStyle))

					.setDataSource(createDataSource())// set datasource
					.show();// create and show report
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private TextFieldBuilder<String> createTextField(String label) {
		return cmp.text(label).setStyle(boldCenteredStyle);
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("column1", "column2");
		int row = 1;
		for (int i = 1; i <= 2; i++) {
			for (int j = 0; j < 50; j++) {
				dataSource.add("group" + i, "row " + row++);
			}
		}
		return dataSource;
	}

	public static void main(String[] args) {
		new BandReport();
	}
}

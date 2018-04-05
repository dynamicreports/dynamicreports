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

package net.sf.dynamicreports.test.jasper.crosstab;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.util.Locale;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabValueTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Crosstab2Test extends AbstractJasperCrosstabValueTest {
	private CrosstabRowGroupBuilder<String> rowGroup1;
	private CrosstabRowGroupBuilder<String> rowGroup2;
	private CrosstabColumnGroupBuilder<String> columnGroup1;
	private CrosstabColumnGroupBuilder<String> columnGroup2;
	private CrosstabMeasureBuilder<Integer> measure1;
	private CrosstabMeasureBuilder<Integer> measure2;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		TextColumnBuilder<String> column1 = col.column("Column1", "field1", String.class);
		TextColumnBuilder<String> column2 = col.column("Column2", "field2", String.class);
		TextColumnBuilder<String> column3 = col.column("Column3", "field3", String.class);
		TextColumnBuilder<String> column4 = col.column("Column4", "field4", String.class);
		TextColumnBuilder<Integer> column5 = col.column("Column5", "field5", Integer.class);

		measure1 = ctab.measure("measure1", column5, Calculation.SUM);
		measure2 = ctab.measure("measure2", column5, Calculation.SUM);

		CrosstabBuilder crosstab = ctab.crosstab()
				.headerCell(cmp.text("Header"))
				.setCellWidth(20)
				.rowGroups(
						rowGroup1 = ctab.rowGroup(column1), rowGroup2 = ctab.rowGroup(column2))
				.columnGroups(
						columnGroup1 = ctab.columnGroup(column3), columnGroup2 = ctab.columnGroup(column4))
				.measures(
						measure1, measure2);

		rb.setLocale(Locale.ENGLISH)
				.setPageFormat(PageType.A3, PageOrientation.LANDSCAPE)
				.columns(column1, column2, column3, column4, column5)
				.summary(crosstab);
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);

		setCrosstabBand("summary");

		crosstabHeaderElementCountTest("textField1", 1);
		crosstabHeaderElementValueTest("textField1", "Header");

		// column group
		crosstabGroupHeaderCountTest(columnGroup1, 2);
		crosstabGroupHeaderValueTest(columnGroup1, "g", "h");
		crosstabGroupTotalHeaderCountTest(columnGroup1, 1);
		crosstabGroupTotalHeaderValueTest(columnGroup1, "Total");
		crosstabGroupHeaderCountTest(columnGroup2, 4);
		crosstabGroupHeaderValueTest(columnGroup2, "i", "j", "k", "l");
		crosstabGroupTotalHeaderCountTest(columnGroup2, 2);
		crosstabGroupTotalHeaderValueTest(columnGroup2, "Total", "Total");

		// column group title
		crosstabGroupTitleHeaderCountTest(columnGroup1, measure1, 0);
		crosstabGroupTitleTotalHeaderCountTest(columnGroup1, measure1, 1);
		crosstabGroupTitleTotalHeaderValueTest(columnGroup1, measure1, "measure1");
		crosstabGroupTitleHeaderCountTest(columnGroup2, measure1, 4);
		crosstabGroupTitleHeaderValueTest(columnGroup2, measure1, "measure1", "measure1", "measure1", "measure1");
		crosstabGroupTitleTotalHeaderCountTest(columnGroup2, measure1, 2);
		crosstabGroupTitleTotalHeaderValueTest(columnGroup2, measure1, "measure1", "measure1");

		crosstabGroupTitleHeaderCountTest(columnGroup1, measure2, 0);
		crosstabGroupTitleTotalHeaderCountTest(columnGroup1, measure2, 1);
		crosstabGroupTitleTotalHeaderValueTest(columnGroup1, measure2, "measure2");
		crosstabGroupTitleHeaderCountTest(columnGroup2, measure2, 4);
		crosstabGroupTitleHeaderValueTest(columnGroup2, measure2, "measure2", "measure2", "measure2", "measure2");
		crosstabGroupTitleTotalHeaderCountTest(columnGroup2, measure2, 2);
		crosstabGroupTitleTotalHeaderValueTest(columnGroup2, measure2, "measure2", "measure2");

		// row group
		crosstabGroupHeaderCountTest(rowGroup1, 2);
		crosstabGroupHeaderValueTest(rowGroup1, "a", "b");
		crosstabGroupTotalHeaderCountTest(rowGroup1, 1);
		crosstabGroupTotalHeaderValueTest(rowGroup1, "Total");
		crosstabGroupHeaderCountTest(rowGroup2, 4);
		crosstabGroupHeaderValueTest(rowGroup2, "c", "d", "e", "f");
		crosstabGroupTotalHeaderCountTest(rowGroup2, 2);
		crosstabGroupTotalHeaderValueTest(rowGroup2, "Total", "Total");

		// measure1
		crosstabCellCountTest(measure1, null, null, 16);
		crosstabCellValueTest(measure1, null, null, "1", "2", "0", "0", "3", "4", "0", "0", "0", "0", "5", "6", "0", "0", "7", "8");
		crosstabCellCountTest(measure1, null, columnGroup1, 4);
		crosstabCellValueTest(measure1, null, columnGroup1, "3", "7", "11", "15");
		crosstabCellCountTest(measure1, null, columnGroup2, 8);
		crosstabCellValueTest(measure1, null, columnGroup2, "3", "0", "7", "0", "0", "11", "0", "15");
		crosstabCellCountTest(measure1, rowGroup1, null, 4);
		crosstabCellValueTest(measure1, rowGroup1, null, "4", "6", "12", "14");
		crosstabCellCountTest(measure1, rowGroup2, null, 8);
		crosstabCellValueTest(measure1, rowGroup2, null, "4", "6", "0", "0", "0", "0", "12", "14");
		crosstabCellCountTest(measure1, rowGroup1, columnGroup1, 1);
		crosstabCellValueTest(measure1, rowGroup1, columnGroup1, "36");
		crosstabCellCountTest(measure1, rowGroup2, columnGroup2, 4);
		crosstabCellValueTest(measure1, rowGroup2, columnGroup2, "10", "0", "0", "26");
		crosstabCellCountTest(measure1, rowGroup1, columnGroup2, 2);
		crosstabCellValueTest(measure1, rowGroup1, columnGroup2, "10", "26");
		crosstabCellCountTest(measure1, rowGroup2, columnGroup1, 2);
		crosstabCellValueTest(measure1, rowGroup2, columnGroup1, "10", "26");
	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5");
		dataSource.add("a", "c", "g", "i", 1);
		dataSource.add("a", "c", "g", "j", 2);
		dataSource.add("a", "d", "g", "i", 3);
		dataSource.add("a", "d", "g", "j", 4);
		dataSource.add("b", "e", "h", "k", 5);
		dataSource.add("b", "e", "h", "l", 6);
		dataSource.add("b", "f", "h", "k", 7);
		dataSource.add("b", "f", "h", "l", 8);
		return dataSource;
	}
}

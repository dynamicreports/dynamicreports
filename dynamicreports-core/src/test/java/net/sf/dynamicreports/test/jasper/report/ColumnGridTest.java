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

package net.sf.dynamicreports.test.jasper.report;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.io.Serializable;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ColumnGridTest extends AbstractJasperPositionTest implements Serializable {
	private static final long serialVersionUID = 1L;

	private TextColumnBuilder<Integer> column1;
	private TextColumnBuilder<Integer> column2;
	private TextColumnBuilder<Integer> column3;
	private TextColumnBuilder<Integer> column4;
	private TextColumnBuilder<Integer> column5;
	private TextColumnBuilder<Integer> column6;
	private TextColumnBuilder<Integer> column7;
	private TextColumnBuilder<Integer> column8;
	private AggregationSubtotalBuilder<Integer> subtotal1;
	private AggregationSubtotalBuilder<Integer> subtotal2;
	private AggregationSubtotalBuilder<Double> subtotal3;
	private AggregationSubtotalBuilder<Integer> subtotal4;
	private AggregationSubtotalBuilder<Double> subtotal5;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		rb.setTextStyle(
				stl.style()
						.setPadding(1))
				.columnGrid(ListType.HORIZONTAL_FLOW)
				.columns(
						column1 = col.column("Column1", "field1", Integer.class),
						column2 = col.column("Column2", "field2", Integer.class),
						column3 = col.column("Column3", "field3", Integer.class),
						column4 = col.column("Column4", "field4", Integer.class),
						column5 = col.column("Column5", "field5", Integer.class),
						column6 = col.column("Column6", "field6", Integer.class),
						column7 = col.column("Column7", "field7", Integer.class),
						column8 = col.column("Column8", "field8", Integer.class))
				.subtotalsAtSummary(
						subtotal1 = sbt.sum(column1),
						subtotal2 = sbt.sum(column5),
						subtotal3 = sbt.aggregate(column5, Calculation.AVERAGE),
						subtotal4 = sbt.sum(column7),
						subtotal5 = sbt.aggregate(column7, Calculation.AVERAGE));
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);
		// column header
		// elementPositionTest("columnHeader.list1", 0, 10, 10, 575, 28);

		elementPositionTest("columnHeader.list2", 0, 10, 10, 575, 14);
		columnTitlePositionTest(column1, 0, 0, 0, 115, 14);
		columnTitlePositionTest(column2, 0, 115, 0, 115, 14);
		columnTitlePositionTest(column3, 0, 230, 0, 115, 14);
		columnTitlePositionTest(column4, 0, 345, 0, 115, 14);
		columnTitlePositionTest(column5, 0, 460, 0, 115, 14);

		elementPositionTest("columnHeader.list3", 0, 10, 24, 575, 14);
		columnTitlePositionTest(column6, 0, 0, 0, 191, 14);
		columnTitlePositionTest(column7, 0, 191, 0, 192, 14);
		columnTitlePositionTest(column8, 0, 383, 0, 192, 14);

		// detail
		// elementPositionTest("detail.list1", 0, 10, 38, 575, 28);

		elementPositionTest("detail.list2", 0, 10, 38, 575, 14);
		columnDetailPositionTest(column1, 0, 0, 0, 115, 14);
		columnDetailPositionTest(column2, 0, 115, 0, 115, 14);
		columnDetailPositionTest(column3, 0, 230, 0, 115, 14);
		columnDetailPositionTest(column4, 0, 345, 0, 115, 14);
		columnDetailPositionTest(column5, 0, 460, 0, 115, 14);

		elementPositionTest("detail.list3", 0, 10, 52, 575, 14);
		columnDetailPositionTest(column6, 0, 0, 0, 191, 14);
		columnDetailPositionTest(column7, 0, 191, 0, 192, 14);
		columnDetailPositionTest(column8, 0, 383, 0, 192, 14);

		// subtotal
		// elementPositionTest("summary.list1", 0, 10, 318, 575, 56);

		elementPositionTest("summary.list2", 0, 10, 318, 575, 28);
		subtotalPositionTest(subtotal1, 0, 0, 0, 115, 14);
		// elementPositionTest("summary.list3", 0, 460, 0, 115, 28);
		subtotalPositionTest(subtotal2, 0, 460, 0, 115, 14);
		subtotalIndexPositionTest(subtotal3, 2, 0, 460, 14, 115, 14);

		elementPositionTest("summary.list4", 0, 10, 346, 575, 28);
		// elementPositionTest("summary.list5", 0, 191, 0, 192, 28);
		subtotalPositionTest(subtotal4, 0, 191, 0, 192, 14);
		subtotalIndexPositionTest(subtotal5, 2, 0, 191, 14, 192, 14);
	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5", "field6", "field7", "field8");
		for (int i = 0; i < 10; i++) {
			dataSource.add(1, 1, 1, 1, 1, 1, 1, 1);
		}
		return dataSource;
	}
}

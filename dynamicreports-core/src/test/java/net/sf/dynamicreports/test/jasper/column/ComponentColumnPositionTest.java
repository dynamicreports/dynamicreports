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

package net.sf.dynamicreports.test.jasper.column;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.io.Serializable;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.ComponentColumnBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.subtotal.CustomSubtotalBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ComponentColumnPositionTest extends AbstractJasperPositionTest implements Serializable {
	private static final long serialVersionUID = 1L;

	private TextColumnBuilder<String> column1;
	private ComponentColumnBuilder column3;
	private CustomSubtotalBuilder<String> subtotal1;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		rb.columns(
				column1 = col.column("Column1", "field1", type.stringType()),
				col.componentColumn(cmp.filler().setFixedWidth(5)),
				col.componentColumn(cmp.filler()).setFixedWidth(5),
				column3 = col.componentColumn("Column3",
						cmp.verticalList(cmp.horizontalList(cmp.text("aa"), cmp.text("cc")), cmp.text("aa"))))
				.subtotalsAtSummary(
						subtotal1 = sbt.customValue(exp.text("subtotal"), column3));
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);
		elementPositionTest("columnHeader.list1", 0, 10, 10, 575, 16);
		elementPositionTest("detail.list1", 0, 10, 26, 575, 32);
		elementPositionTest("detail.list1", 1, 10, 58, 575, 32);

		// column1
		columnTitlePositionTest(column1, 0, 0, 0, 188, 16);
		columnDetailPositionTest(column1, 0, 0, 0, 188, 32);
		columnDetailPositionTest(column1, 1, 0, 0, 188, 32);

		// column3
		columnTitlePositionTest(column3, 0, 198, 0, 377, 16);
		// columnDetailPositionTest(column3, 0, 198, 0, 377, 32);
		// columnDetailPositionTest(column3, 1, 198, 0, 377, 32);

		elementPositionTest("detail.list2", 0, 198, 0, 377, 16);
		elementPositionTest("detail.list2", 1, 198, 0, 377, 16);

		elementPositionTest("detail.textField1", 0, 0, 0, 188, 16);
		elementPositionTest("detail.textField1", 1, 0, 0, 188, 16);

		elementPositionTest("detail.textField2", 0, 188, 0, 189, 16);
		elementPositionTest("detail.textField2", 1, 188, 0, 189, 16);

		elementPositionTest("detail.textField3", 0, 198, 16, 377, 16);
		elementPositionTest("detail.textField3", 1, 198, 16, 377, 16);

		// summary
		elementPositionTest("summary.list1", 0, 10, 90, 575, 16);
		subtotalPositionTest(subtotal1, 0, 198, 0, 377, 16);
	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1");
		for (int i = 0; i < 2; i++) {
			dataSource.add("test");
		}
		return dataSource;
	}
}

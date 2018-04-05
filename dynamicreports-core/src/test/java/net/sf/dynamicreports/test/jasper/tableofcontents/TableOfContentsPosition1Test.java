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

package net.sf.dynamicreports.test.jasper.tableofcontents;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class TableOfContentsPosition1Test extends AbstractJasperPositionTest {
	private TextColumnBuilder<String> column1;
	private TextColumnBuilder<String> column2;
	private ColumnGroupBuilder group1;
	private ColumnGroupBuilder group2;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		rb.tableOfContents()
				.columns(
						column1 = col.column("Column1", "field1", type.stringType()),
						column2 = col.column("Column2", "field2", type.stringType()),
						col.column("Column3", "field3", type.stringType()))
				.groupBy(
						group1 = grp.group(column1),
						group2 = grp.group(column2));
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(3);

		elementPositionTest("title.textField1", 0, 10, 10, 575, 19);

		for (int i = 0; i < 3; i++) {
			elementPositionTest("detail.list3", i, 10, 49 + 64 * i, 575, 16);
			elementPositionTest("detail.textField1", i, 0, 0, 276, 16);
			elementPositionTest("detail.textField2", i, 276, 0, 277, 16);
			elementPositionTest("detail.textField3", i, 553, 0, 22, 16);
		}

		for (int i = 0; i < 9; i++) {
			elementPositionTest("detail.textField4", i, 10, 0, 266, 16);
			elementPositionTest("detail.textField5", i, 286, 0, 267, 16);
			elementPositionTest("detail.textField6", i, 553, 0, 22, 16);
		}

		for (int i = 0; i < 3; i++) {
			elementPositionTest("detail.list5", i, 10, 65 + 16 * i, 575, 16);
		}
		int index = 0;
		for (int i = 3; i < 6; i++) {
			elementPositionTest("detail.list5", i, 10, 129 + 16 * index++, 575, 16);
		}
		index = 0;
		for (int i = 6; i < 9; i++) {
			elementPositionTest("detail.list5", i, 10, 193 + 16 * index++, 575, 16);
		}

		String name = "groupHeaderTitleAndValue.group_" + group1.getGroup().getName() + ".tocReference1";
		for (int i = 0; i < 3; i++) {
			elementPositionTest(name, i, 0, 0, 0, 16);
			groupHeaderPositionTest(group1, i, 0, 0, 575, 16);
		}
		name = "groupHeaderTitleAndValue.list1";
		elementPositionTest(name, 0, 10, 26, 575, 16);
		elementPositionTest(name, 1, 10, 474, 575, 16);
		elementPositionTest(name, 2, 10, 122, 575, 16);

		name = "groupHeaderTitleAndValue.group_" + group2.getGroup().getName() + ".tocReference1";
		for (int i = 0; i < 9; i++) {
			elementPositionTest(name, i, 0, 0, 0, 16);
			groupHeaderPositionTest(group2, i, 10, 0, 565, 16);
		}
		name = "groupHeaderTitleAndValue.list2";
		elementPositionTest(name, 0, 10, 42, 575, 16);
		elementPositionTest(name, 1, 10, 186, 575, 16);
		elementPositionTest(name, 2, 10, 330, 575, 16);
		elementPositionTest(name, 3, 10, 490, 575, 16);
		elementPositionTest(name, 4, 10, 634, 575, 16);
		elementPositionTest(name, 5, 10, 778, 575, 16);
		elementPositionTest(name, 6, 10, 138, 575, 16);
		elementPositionTest(name, 7, 10, 282, 575, 16);
		elementPositionTest(name, 8, 10, 426, 575, 16);
	}

	@Override
	protected JRDataSource createDataSource() {
		String[] values = new String[] { "value1", "value2", "value3" };
		DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
		for (String field1 : values) {
			for (String field2 : values) {
				for (int i = 0; i < 8; i++) {
					dataSource.add(field1, field2, "text");
				}
			}
		}
		return dataSource;
	}
}

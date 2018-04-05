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
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ColumnTitleGroup1Test extends AbstractJasperValueTest {
	private TextColumnBuilder<String> column1;
	private TextColumnBuilder<String> column2;
	private TextColumnBuilder<String> column3;
	private TextColumnBuilder<String> column4;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		column1 = col.column("Column1", "field1", String.class);
		column2 = col.column("Column2", "field2", String.class);
		column3 = col.column("Column3", "field3", String.class);
		column4 = col.column("Column4", "field4", String.class);

		rb.columnGrid(column1, grid.titleGroup("Group1", column2, grid.titleGroup("Group2", column3, column4)))
				.columns(column1, column2, column3, column4);
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);

		elementValueTest("columnHeader.columngroup.title1", 0, "Group1");
		elementValueTest("columnHeader.columngroup.title2", 0, "Group2");
		// column1
		columnTitleValueTest(column1, 0, "Column1");
		columnDetailValueTest(column1, 0, "text");
		// column2
		columnTitleValueTest(column2, 0, "Column2");
		columnDetailValueTest(column2, 0, "text");
		// column3
		columnTitleValueTest(column3, 0, "Column3");
		columnDetailValueTest(column3, 0, "text");
		// column4
		columnTitleValueTest(column4, 0, "Column4");
		columnDetailValueTest(column4, 0, "text");
	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4");
		dataSource.add("text", "text", "text", "text");
		return dataSource;
	}
}

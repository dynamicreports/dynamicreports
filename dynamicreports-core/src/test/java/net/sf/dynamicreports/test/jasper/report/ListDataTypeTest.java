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

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ListDataTypeTest extends AbstractJasperValueTest {
	private TextColumnBuilder<String> column1;
	@SuppressWarnings("rawtypes")
	private TextColumnBuilder<List> column2;
	@SuppressWarnings("rawtypes")
	private TextColumnBuilder<List> column3;

	@Override
	protected void configureReport(JasperReportBuilder rb) {

		rb.columns(
				column1 = col.column("Column1", "field1", String.class),
				column2 = col.column("Column2", "field2", List.class),
				column3 = col.column("Column3", "field2", type.listType()));
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);

		columnDetailValueTest(column1, "row1", "row2");
		columnDetailValueTest(column2, "comment1\ncomment2\ncomment3", "comment1\ncomment2");
		columnDetailValueTest(column3, "comment1\ncomment2\ncomment3", "comment1\ncomment2");
	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1", "field2");
		List<String> comments = new ArrayList<String>();
		comments.add("comment1");
		comments.add("comment2");
		comments.add("comment3");
		dataSource.add("row1", comments);
		comments = new ArrayList<String>();
		comments.add("comment1");
		comments.add("comment2");
		dataSource.add("row2", comments);
		return dataSource;
	}
}

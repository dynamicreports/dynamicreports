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
import net.sf.dynamicreports.report.constant.BooleanComponentType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class BooleanColumnPosition2Test extends AbstractJasperPositionTest {

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		rb.columns(
				col.booleanColumn("field1").setComponentType(BooleanComponentType.TEXT_TRUE_FALSE),
				col.booleanColumn("field1").setComponentType(BooleanComponentType.IMAGE_STYLE_1),
				col.column("field2", String.class).setFixedWidth(20).setRows(3));
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);
		elementPositionTest("detail.column_field11", 0, 0, 0, 277, 49);
		elementPositionTest("detail.column_field12", 0, 277, 0, 278, 49);

		elementPositionTest("detail.column_field11", 1, 0, 0, 277, 39);
		elementPositionTest("detail.column_field12", 1, 277, 0, 278, 39);
	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1", "field2");
		dataSource.add(true, "1111111");
		dataSource.add(false, "");
		return dataSource;
	}
}

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
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsCustomizerBuilder;
import net.sf.dynamicreports.report.constant.TableOfContentsPosition;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class TableOfContentsPosition4Test extends AbstractJasperPositionTest {
	private TextColumnBuilder<String> column1;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		TableOfContentsCustomizerBuilder tableOfContentsCustomizer = tableOfContentsCustomizer()
				.setPosition(TableOfContentsPosition.BOTTOM)
				.setTextFixedWidth(100)
				.setPageIndexFixedWidth(30);

		ReportTemplateBuilder template = template()
				.setTableOfContents(true)
				.setTableOfContentsCustomizer(tableOfContentsCustomizer);

		rb.setTemplate(template)
				.columns(
						column1 = col.column("Column1", "field1", type.stringType()),
						col.column("Column2", "field2", type.stringType()))
				.groupBy(column1);
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(2);

		elementPositionTest("title.textField1", 0, 10, 10, 575, 19);

		for (int i = 0; i < 10; i++) {
			elementPositionTest("detail.list2", i, 10, 49 + 16 * i, 575, 16);
			elementPositionTest("detail.textField1", i, 0, 0, 100, 16);
			elementPositionTest("detail.textField2", i, 100, 0, 445, 16);
			elementPositionTest("detail.textField3", i, 545, 0, 30, 16);
		}

		containsElement("title.textField1", 1);
	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1", "field2");
		for (int i = 0; i < 10; i++) {
			dataSource.add("value" + i, "text");
		}
		return dataSource;
	}
}

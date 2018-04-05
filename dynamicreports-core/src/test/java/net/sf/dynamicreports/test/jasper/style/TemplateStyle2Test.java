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

package net.sf.dynamicreports.test.jasper.style;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.io.Serializable;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperStyleTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.type.LineStyleEnum;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class TemplateStyle2Test extends AbstractJasperStyleTest implements Serializable {
	private static final long serialVersionUID = 1L;

	private TextColumnBuilder<Integer> column1;
	private TextColumnBuilder<String> column2;
	private ColumnGroupBuilder group1;
	private AggregationSubtotalBuilder<Integer> subtotal1;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		StyleBuilder textStyle = stl.style().setName("textStyle").setPadding(2);
		StyleBuilder titleStyle = stl.style(textStyle).setName("titleStyle").bold();
		StyleBuilder subtotalStyle = stl.style(2).setName("subtotalStyle").setTopBorder(stl.pen1Point()).bold();
		StyleBuilder boldStyle = stl.style().setName("boldStyle").bold();

		ReportTemplateBuilder template = template()
				.templateStyles(textStyle, titleStyle, subtotalStyle, boldStyle);

		rb.setTemplate(template)
				.setTextStyle(stl.templateStyle("textStyle"))
				.setColumnTitleStyle(stl.templateStyle("titleStyle"))
				.setSubtotalStyle(stl.templateStyle("subtotalStyle"))
				.columns(
						column1 = col.column("Column1", "field1", type.integerType()),
						column2 = col.column("Column2", "field2", type.stringType()).setStyle(stl.templateStyle("boldStyle")))
				.groupBy(group1 = grp.group(column2))
				.subtotalsAtSummary(subtotal1 = sbt.sum(column1).setLabel("total").setLabelStyle(stl.templateStyle("boldStyle")));
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);

		// column1
		columnTitleStyleTest(column1, 0, null, null, "Arial", 10f, true, null);
		columnTitlePaddingTest(column1, 0, 2, 2, 2, 2);

		columnDetailStyleTest(column1, 0, null, null, "Arial", 10f, null, null);
		columnDetailPaddingTest(column1, 0, 2, 2, 2, 2);

		// column2
		groupHeaderStyleTest(group1, 0, null, null, "Arial", 10f, true, null);

		// subtotal
		subtotalLabelStyleTest(subtotal1, 0, null, null, "Arial", 10f, true, null);
		subtotalLabelBorderTest(subtotal1, 0, null, LineStyleEnum.SOLID, 0, null, LineStyleEnum.SOLID, 0, null, LineStyleEnum.SOLID, 0, null, LineStyleEnum.SOLID,
				0);
	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1", "field2");
		dataSource.add(1, "1");
		return dataSource;
	}
}

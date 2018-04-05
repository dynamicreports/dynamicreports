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

package net.sf.dynamicreports.test.jasper.subtotal;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Locale;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Subtotal1Test extends AbstractJasperValueTest implements Serializable {
	private static final long serialVersionUID = 1L;

	private AggregationSubtotalBuilder<BigDecimal> subtotal1;
	private AggregationSubtotalBuilder<BigDecimal> subtotal2;
	private AggregationSubtotalBuilder<BigDecimal> subtotal3;
	private AggregationSubtotalBuilder<BigDecimal> subtotal4;
	private AggregationSubtotalBuilder<BigDecimal> subtotal5;
	private AggregationSubtotalBuilder<BigDecimal> subtotal6;
	private AggregationSubtotalBuilder<BigDecimal> subtotal7;
	private AggregationSubtotalBuilder<BigDecimal> subtotal8;
	private AggregationSubtotalBuilder<Integer> subtotal9;
	private AggregationSubtotalBuilder<Integer> subtotal10;
	private AggregationSubtotalBuilder<Integer> subtotal11;
	private AggregationSubtotalBuilder<String> subtotal12;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		TextColumnBuilder<BigDecimal> column1;
		TextColumnBuilder<String> column2;

		rb.setLocale(Locale.ENGLISH)
				.setPageColumnsPerPage(2)
				.columns(
						column1 = col.column("Column1", "field1", type.bigDecimalType()),
						column2 = col.column("Column2", "field2", String.class)
								.setValueFormatter(new ColumnValueFormatter()))
				.subtotalsAtTitle(
						subtotal1 = sbt.sum(column1).setLabel("title sum"))
				.subtotalsAtPageHeader(
						subtotal2 = sbt.sum(column1).setLabel("page header sum"))
				.subtotalsAtPageFooter(
						subtotal3 = sbt.sum(column1).setLabel("page footer sum"))
				.subtotalsAtColumnHeader(
						subtotal4 = sbt.sum(column1).setLabel("column header sum"))
				.subtotalsAtColumnFooter(
						subtotal5 = sbt.sum(column1).setLabel("column footer sum"))
				.subtotalsAtLastPageFooter(
						subtotal6 = sbt.sum(column1).setLabel("last page footer sum"))
				.subtotalsAtSummary(
						subtotal7 = sbt.sum(column1).setLabel("summary sum"),
						(subtotal8 = sbt.aggregate(column1, Calculation.LOWEST)).setLabel("summary lowest"),
						subtotal9 = sbt.sum(new ColumnCalculationExpression(), column2).setLabel("summary sum").setValueFormatter(new ColumnValueFormatter2()),
						subtotal10 = sbt.aggregate(column1, Calculation.COUNT),
						subtotal11 = sbt.aggregate(column2, Calculation.COUNT),
						subtotal12 = sbt.text("total", column1));
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(2);
		// title
		subtotalLabelCountTest(subtotal1, 1);
		subtotalLabelValueTest(subtotal1, "title sum");
		subtotalCountTest(subtotal1, 1);
		subtotalValueTest(subtotal1, "101.00");
		// pageHeader
		subtotalLabelCountTest(subtotal2, 2);
		subtotalLabelValueTest(subtotal2, "page header sum", "page header sum");
		subtotalCountTest(subtotal2, 2);
		subtotalValueTest(subtotal2, "80.80", "20.20");
		// pageFooter
		subtotalLabelCountTest(subtotal3, 1);
		subtotalLabelValueTest(subtotal3, "page footer sum");
		subtotalCountTest(subtotal3, 1);
		subtotalValueTest(subtotal3, "80.80");
		// columnHeader
		subtotalLabelCountTest(subtotal4, 3);
		subtotalLabelValueTest(subtotal4, "column header sum", "column header sum", "column header sum");
		subtotalCountTest(subtotal4, 3);
		subtotalValueTest(subtotal4, "40.40", "40.40", "20.20");
		// columnFooter
		subtotalLabelCountTest(subtotal5, 3);
		subtotalLabelValueTest(subtotal5, "column footer sum", "column footer sum", "column footer sum");
		subtotalCountTest(subtotal5, 3);
		subtotalValueTest(subtotal5, "40.40", "40.40", "20.20");
		// lastPageFooter
		subtotalLabelCountTest(subtotal6, 1);
		subtotalLabelValueTest(subtotal6, "last page footer sum");
		subtotalCountTest(subtotal6, 1);
		subtotalValueTest(subtotal6, "101.00");
		// summary
		subtotalLabelCountTest(subtotal7, 1);
		subtotalLabelValueTest(subtotal7, "summary sum");
		subtotalCountTest(subtotal7, 1);
		subtotalValueTest(subtotal7, "101.00");

		subtotalLabelIndexCountTest(subtotal8, 2, 1);
		subtotalLabelIndexValueTest(subtotal8, 2, "summary lowest");
		subtotalIndexCountTest(subtotal8, 2, 1);
		subtotalIndexValueTest(subtotal8, 2, "1.01");

		subtotalIndexCountTest(subtotal10, 3, 1);
		subtotalIndexValueTest(subtotal10, 3, "100");

		subtotalLabelCountTest(subtotal9, 1);
		subtotalLabelValueTest(subtotal9, "summary sum");
		subtotalCountTest(subtotal9, 1);
		subtotalValueTest(subtotal9, "value = 200");

		subtotalIndexCountTest(subtotal11, 2, 1);
		subtotalIndexValueTest(subtotal11, 2, "100");

		subtotalIndexCountTest(subtotal12, 4, 1);
		subtotalIndexValueTest(subtotal12, 4, "total");
	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1", "field2");
		for (int i = 0; i < 100; i++) {
			dataSource.add(new BigDecimal(1.01), "v2");
		}
		return dataSource;
	}

	private class ColumnValueFormatter extends AbstractValueFormatter<String, String> {
		private static final long serialVersionUID = 1L;

		@Override
		public String format(String value, ReportParameters reportParameters) {
			return "value = " + value;
		}
	}

	private class ColumnValueFormatter2 extends AbstractValueFormatter<String, Integer> {
		private static final long serialVersionUID = 1L;

		@Override
		public String format(Integer value, ReportParameters reportParameters) {
			return "value = " + value;
		}
	}

	private class ColumnCalculationExpression extends AbstractSimpleExpression<Integer> {
		private static final long serialVersionUID = 1L;

		@Override
		public Integer evaluate(ReportParameters reportParameters) {
			return new Integer(((String) reportParameters.getValue("field2")).substring(1));
		}
	}
}

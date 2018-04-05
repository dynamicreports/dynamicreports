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
import java.math.BigDecimal;
import java.util.Locale;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ExpressionColumnTest extends AbstractJasperValueTest implements Serializable {
	private static final long serialVersionUID = 1L;

	private FieldBuilder<Double> field1;
	private TextColumnBuilder<Double> column2;
	private TextColumnBuilder<Double> expression1;
	private TextColumnBuilder<BigDecimal> calcExpression1;
	private TextColumnBuilder<BigDecimal> calcExpression2;
	private TextColumnBuilder<BigDecimal> calcExpression3;
	private TextColumnBuilder<BigDecimal> calcExpression4;
	private TextColumnBuilder<BigDecimal> calcExpression5;
	private TextColumnBuilder<BigDecimal> calcExpression6;
	private TextColumnBuilder<BigDecimal> calcExpression7;
	private TextColumnBuilder<BigDecimal> calcExpression8;
	private TextColumnBuilder<Double> expression2;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		rb.setLocale(Locale.ENGLISH)
				.fields(
						field1 = field("field1", Double.class))
				.columns(
						column2 = col.column("Column2", "field2", Double.class).setValueFormatter(new ColumnValueFormatter()),
						expression1 = col.column("Expression", new ValueExpression1()),
						calcExpression1 = expression1.multiply(column2),
						calcExpression2 = calcExpression1.multiply(5),
						calcExpression3 = calcExpression2.subtract(calcExpression1),
						calcExpression4 = calcExpression3.subtract(5),
						calcExpression5 = calcExpression4.add(calcExpression1),
						calcExpression6 = calcExpression5.add(5),
						calcExpression7 = calcExpression6.divide(2, expression1),
						calcExpression8 = calcExpression7.divide(2, 3),
						expression2 = col.column("Expression", new ValueExpression2()));
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);
		// column2
		columnDetailCountTest(column2, 3);
		columnDetailValueTest(column2, "value = 4.0", "value = 5.0", "value = 6.0");
		// expression
		columnDetailCountTest(expression1, 3);
		columnDetailValueTest(expression1, "5.0", "7.0", "9.0");
		columnDetailCountTest(expression2, 3);
		columnDetailValueTest(expression2, "11.67", "15.33", "19.0");
		// calcExpression
		columnDetailCountTest(calcExpression1, 3);
		columnDetailValueTest(calcExpression1, "20.00", "35.00", "54.00");
		columnDetailCountTest(calcExpression2, 3);
		columnDetailValueTest(calcExpression2, "100.00", "175.00", "270.00");
		columnDetailCountTest(calcExpression3, 3);
		columnDetailValueTest(calcExpression3, "80.00", "140.00", "216.00");
		columnDetailCountTest(calcExpression4, 3);
		columnDetailValueTest(calcExpression4, "75.00", "135.00", "211.00");
		columnDetailCountTest(calcExpression5, 3);
		columnDetailValueTest(calcExpression5, "95.00", "170.00", "265.00");
		columnDetailCountTest(calcExpression6, 3);
		columnDetailValueTest(calcExpression6, "100.00", "175.00", "270.00");
		columnDetailCountTest(calcExpression7, 3);
		columnDetailValueTest(calcExpression7, "20.00", "25.00", "30.00");
		columnDetailCountTest(calcExpression8, 3);
		columnDetailValueTest(calcExpression8, "6.67", "8.33", "10.00");
	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1", "field2");
		dataSource.add(1d, 4d);
		dataSource.add(2d, 5d);
		dataSource.add(3d, 6d);
		return dataSource;
	}

	private class ValueExpression1 extends AbstractSimpleExpression<Double> {
		private static final long serialVersionUID = 1L;

		@Override
		public Double evaluate(ReportParameters reportParameters) {
			double f1 = reportParameters.getValue(field1);
			double f2 = reportParameters.getValue(column2);
			return f1 + f2;
		}
	}

	private class ValueExpression2 extends AbstractSimpleExpression<Double> {
		private static final long serialVersionUID = 1L;

		@Override
		public Double evaluate(ReportParameters reportParameters) {
			double f1 = reportParameters.getValue(expression1);
			double f2 = reportParameters.getValue(calcExpression8).doubleValue();
			return f1 + f2;
		}
	}

	private class ColumnValueFormatter extends AbstractValueFormatter<String, Double> {
		private static final long serialVersionUID = 1L;

		@Override
		public String format(Double value, ReportParameters reportParameters) {
			return "value = " + value;
		}
	}
}

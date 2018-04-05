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

package net.sf.dynamicreports.examples.expression;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class SimpleExpressionReport {

	public SimpleExpressionReport() {
		build();
	}

	private void build() {
		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.fields(
							field("quantity", Integer.class),
							field("unitprice", BigDecimal.class))
					.columns(
							col.column("Item", "item", type.stringType()),
							col.column("Price", new SimpleExpression()))
					.title(Templates.createTitleComponent("SimpleExpression"))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
		dataSource.add("Book", 20, new BigDecimal(10));
		return dataSource;
	}

	public static void main(String[] args) {
		new SimpleExpressionReport();
	}

	private class SimpleExpression extends AbstractSimpleExpression<BigDecimal> {
		private static final long serialVersionUID = 1L;

		@Override
		public BigDecimal evaluate(ReportParameters reportParameters) {
			Integer quantity = reportParameters.getValue("quantity");
			BigDecimal unitPrice = reportParameters.getValue("unitprice");
			return new BigDecimal(quantity).multiply(unitPrice);
		}
	}
}

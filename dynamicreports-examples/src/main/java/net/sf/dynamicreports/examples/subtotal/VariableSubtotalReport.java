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

package net.sf.dynamicreports.examples.subtotal;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.subtotal.CustomSubtotalBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class VariableSubtotalReport {
	private VariableBuilder<Integer> quantitySum;
	private VariableBuilder<BigDecimal> priceSum;

	public VariableSubtotalReport() {
		build();
	}

	private void build() {
		quantitySum = variable("quantity", Integer.class, Calculation.SUM);
		priceSum = variable("price", BigDecimal.class, Calculation.SUM);

		TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());

		CustomSubtotalBuilder<BigDecimal> unitPriceSbt = sbt.customValue(new UnitPriceSubtotal(), itemColumn)
				.setLabel("sum(price) / sum(quantity)")
				.setDataType(type.bigDecimalType());

		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.variables(
							quantitySum, priceSum)
					.columns(
							itemColumn)
					.subtotalsAtSummary(
							unitPriceSbt)
					.title(Templates.createTitleComponent("VariableSubtotal"))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private class UnitPriceSubtotal extends AbstractSimpleExpression<BigDecimal> {
		private static final long serialVersionUID = 1L;

		@Override
		public BigDecimal evaluate(ReportParameters reportParameters) {
			Integer quantitySumValue = reportParameters.getValue(quantitySum);
			BigDecimal priceSumValue = reportParameters.getValue(priceSum);
			return priceSumValue.divide(new BigDecimal(quantitySumValue), 2, BigDecimal.ROUND_HALF_UP);
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "quantity", "price");
		dataSource.add("Tablet", 3, new BigDecimal(330));
		dataSource.add("Tablet", 1, new BigDecimal(150));
		dataSource.add("Laptop", 3, new BigDecimal(900));
		dataSource.add("Smartphone", 8, new BigDecimal(720));
		dataSource.add("Smartphone", 6, new BigDecimal(720));
		return dataSource;
	}

	public static void main(String[] args) {
		new VariableSubtotalReport();
	}
}

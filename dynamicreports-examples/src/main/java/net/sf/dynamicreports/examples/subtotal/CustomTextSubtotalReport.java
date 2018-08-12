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
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * <p>CustomTextSubtotalReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class CustomTextSubtotalReport {

	/**
	 * <p>Constructor for CustomTextSubtotalReport.</p>
	 */
	public CustomTextSubtotalReport() {
		build();
	}

	private void build() {
		TextColumnBuilder<String> countryColumn = col.column("Country", "country", type.stringType());
		TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
		TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
		TextColumnBuilder<BigDecimal> priceColumn = col.column("Price", "price", type.bigDecimalType());

		ColumnGroupBuilder countryGroup = grp.group(countryColumn);

		VariableBuilder<Integer> quantitySum = variable(quantityColumn, Calculation.SUM);
		VariableBuilder<BigDecimal> priceSum = variable(priceColumn, Calculation.SUM);

		VariableBuilder<Integer> quantityGrpSum = variable(quantityColumn, Calculation.SUM);
		quantityGrpSum.setResetGroup(countryGroup);
		VariableBuilder<BigDecimal> priceGrpSum = variable(priceColumn, Calculation.SUM);
		priceGrpSum.setResetType(Evaluation.FIRST_GROUP);

		StyleBuilder subtotalStyle = stl.style()
				.bold()
				.setTopBorder(stl.pen1Point())
				.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);

		TextFieldBuilder<String> summarySbt = cmp.text(new CustomTextSubtotal(quantitySum, priceSum))
				.setStyle(subtotalStyle);

		TextFieldBuilder<String> groupSbt = cmp.text(new CustomTextSubtotal(quantityGrpSum, priceGrpSum))
				.setStyle(subtotalStyle);

		countryGroup.footer(groupSbt);

		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.variables(
							quantitySum, priceSum, quantityGrpSum, priceGrpSum)
					.columns(
							countryColumn, itemColumn, quantityColumn, priceColumn)
					.groupBy(
							countryGroup)
					.summary(
							summarySbt)
					.title(Templates.createTitleComponent("CustomTextSubtotal"))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private class CustomTextSubtotal extends AbstractSimpleExpression<String> {
		private static final long serialVersionUID = 1L;

		private VariableBuilder<Integer> quantitySum;
		private VariableBuilder<BigDecimal> priceSum;

		public CustomTextSubtotal(VariableBuilder<Integer> quantitySum, VariableBuilder<BigDecimal> priceSum) {
			this.quantitySum = quantitySum;
			this.priceSum = priceSum;
		}

		@Override
		public String evaluate(ReportParameters reportParameters) {
			Integer quantitySumValue = reportParameters.getValue(quantitySum);
			BigDecimal priceSumValue = reportParameters.getValue(priceSum);
			BigDecimal unitPriceSbt = priceSumValue.divide(new BigDecimal(quantitySumValue), 2, BigDecimal.ROUND_HALF_UP);
			return "sum(quantity) = " + type.integerType().valueToString(quantitySum, reportParameters) + ", " +
					"sum(price) = " + type.bigDecimalType().valueToString(priceSum, reportParameters) + ", " +
					"sum(price) / sum(quantity) = " + type.bigDecimalType().valueToString(unitPriceSbt, reportParameters.getLocale());
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("country", "item", "quantity", "price");
		dataSource.add("USA", "Tablet", 4, new BigDecimal(600));
		dataSource.add("USA", "Tablet", 3, new BigDecimal(570));
		dataSource.add("USA", "Laptop", 2, new BigDecimal(500));
		dataSource.add("USA", "Laptop", 1, new BigDecimal(420));
		dataSource.add("Canada", "Tablet", 6, new BigDecimal(720));
		dataSource.add("Canada", "Tablet", 2, new BigDecimal(360));
		dataSource.add("Canada", "Laptop", 3, new BigDecimal(900));
		dataSource.add("Canada", "Laptop", 2, new BigDecimal(780));
		return dataSource;
	}

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		new CustomTextSubtotalReport();
	}
}

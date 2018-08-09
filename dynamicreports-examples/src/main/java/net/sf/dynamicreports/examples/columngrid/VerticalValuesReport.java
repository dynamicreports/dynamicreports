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

package net.sf.dynamicreports.examples.columngrid;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;
import java.util.Date;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.ComponentColumnBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * <p>VerticalValuesReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class VerticalValuesReport {

	/**
	 * <p>Constructor for VerticalValuesReport.</p>
	 */
	public VerticalValuesReport() {
		build();
	}

	private void build() {
		StyleBuilder nameStyle = stl.style().bold();
		StyleBuilder valueStyle = stl.style().setHorizontalTextAlignment(HorizontalTextAlignment.LEFT);

		FieldBuilder<String> itemField = field("item", type.stringType());
		FieldBuilder<Integer> quantityField = field("quantity", type.integerType());
		FieldBuilder<BigDecimal> unitPriceField = field("unitprice", type.bigDecimalType());
		FieldBuilder<Date> orderDateField = field("orderdate", type.dateType());

		VerticalListBuilder nameList = cmp.verticalList(
				cmp.text("Item:").setStyle(nameStyle),
				cmp.text("Quantity:").setStyle(nameStyle),
				cmp.text("Unit price:").setStyle(nameStyle),
				cmp.text("Order date:").setStyle(nameStyle));
		VerticalListBuilder valueList = cmp.verticalList(
				cmp.text(itemField).setStyle(valueStyle),
				cmp.text(quantityField).setStyle(valueStyle),
				cmp.text(unitPriceField).setStyle(valueStyle),
				cmp.text(orderDateField).setStyle(valueStyle));

		ComponentColumnBuilder nameColumn = col.componentColumn("Name", nameList);
		ComponentColumnBuilder valueColumn = col.componentColumn("Value", valueList);

		AggregationSubtotalBuilder<BigDecimal> unitPriceSum = sbt.sum(unitPriceField, valueColumn)
				.setLabel("Unit price sum =");

		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.setPageFormat(PageType.A5)
					.fields(itemField, quantityField, unitPriceField, orderDateField)
					.columns(nameColumn, valueColumn)
					.subtotalsAtSummary(unitPriceSum)
					.title(Templates.createTitleComponent("VerticalValues"))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
		dataSource.add("Notebook", new Date(), 1, new BigDecimal(500));
		dataSource.add("Book", new Date(), 4, new BigDecimal(25));
		dataSource.add("PDA", new Date(), 2, new BigDecimal(120));
		return dataSource;
	}

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		new VerticalValuesReport();
	}
}

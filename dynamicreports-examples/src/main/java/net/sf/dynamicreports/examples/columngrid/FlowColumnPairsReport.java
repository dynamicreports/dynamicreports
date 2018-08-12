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
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * <p>FlowColumnPairsReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class FlowColumnPairsReport {

	/**
	 * <p>Constructor for FlowColumnPairsReport.</p>
	 */
	public FlowColumnPairsReport() {
		build();
	}

	private void build() {
		StyleBuilder textStyle = stl.style(Templates.columnStyle)
				.setBorder(stl.pen1Point());

		FieldBuilder<Integer> idField = field("id", type.integerType());
		FieldBuilder<String> itemField = field("item", type.stringType());
		FieldBuilder<Integer> quantityField = field("quantity", type.integerType());
		FieldBuilder<BigDecimal> unitPriceField = field("unitprice", type.bigDecimalType());
		FieldBuilder<Date> orderDateField = field("orderdate", type.dateType());
		FieldBuilder<Date> orderYearField = field("orderdate", type.dateYearType());
		FieldBuilder<Date> orderMonthField = field("orderdate", type.dateMonthType());
		FieldBuilder<Date> orderDayField = field("orderdate", type.dateDayType());

		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.setColumnStyle(textStyle)
					.columnGrid(ListType.HORIZONTAL_FLOW)
					.fields(idField, itemField, quantityField, unitPriceField, orderDateField, orderYearField, orderMonthField, orderDayField)
					.columns(
							col.componentColumn(columnPair("Id", idField)),
							col.componentColumn(columnPair("Item", itemField).setFixedWidth(200)),
							col.componentColumn(columnPair("Quantity", quantityField)),
							col.componentColumn(columnPair("Unit price", unitPriceField)),
							col.componentColumn(columnPair("Order date", orderDateField)),
							col.componentColumn(columnPair("Order year", orderYearField)),
							col.componentColumn(columnPair("Order month", orderMonthField)),
							col.componentColumn(columnPair("Order day", orderDayField)))
					.title(Templates.createTitleComponent("FlowColumnPairs"))
					.detailFooter(cmp.verticalGap(20))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private VerticalListBuilder columnPair(String title, FieldBuilder<?> value) {
		TextFieldBuilder<String> titleCmp = cmp.text(title)
				.setStyle(Templates.columnTitleStyle);
		TextFieldBuilder<?> valueCmp = cmp.text(value);
		return cmp.verticalList(titleCmp, valueCmp);
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("id", "item", "orderdate", "quantity", "unitprice");
		dataSource.add(5, "Notebook", new Date(), 1, new BigDecimal(500));
		dataSource.add(8, "Book", new Date(), 7, new BigDecimal(300));
		dataSource.add(15, "PDA", new Date(), 2, new BigDecimal(250));
		return dataSource;
	}

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		new FlowColumnPairsReport();
	}
}

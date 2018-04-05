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

package net.sf.dynamicreports.examples.column;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.PercentageColumnBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class PercentageColumnsReport {
	private FieldBuilder<BigDecimal> unitPriceField;

	public PercentageColumnsReport() {
		build();
	}

	private void build() {
		try {
			unitPriceField = field("unitprice", BigDecimal.class);

			TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
			TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
			PercentageColumnBuilder quantityPercColumn = col.percentageColumn("Quantity [%]", quantityColumn);
			PercentageColumnBuilder unitPricePercColumn = col.percentageColumn("Unit price [%]", unitPriceField);

			report()
					.setTemplate(Templates.reportTemplate)
					.fields(
							unitPriceField)
					.columns(
							itemColumn, quantityColumn, quantityPercColumn, unitPricePercColumn)
					.title(Templates.createTitleComponent("PercentageColumns"))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
		dataSource.add("Book", 3, new BigDecimal(11));
		dataSource.add("Book", 1, new BigDecimal(15));
		dataSource.add("Book", 5, new BigDecimal(10));
		dataSource.add("Book", 8, new BigDecimal(9));
		return dataSource;
	}

	public static void main(String[] args) {
		new PercentageColumnsReport();
	}
}

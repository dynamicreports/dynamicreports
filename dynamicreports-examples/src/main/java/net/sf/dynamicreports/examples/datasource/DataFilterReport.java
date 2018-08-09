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

package net.sf.dynamicreports.examples.datasource;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * <p>DataFilterReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DataFilterReport {

	/**
	 * <p>Constructor for DataFilterReport.</p>
	 */
	public DataFilterReport() {
		build();
	}

	private void build() {
		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.columns(
							col.column("Item", "item", type.stringType()),
							col.column("Quantity", "quantity", type.integerType()),
							col.column("Unit price", "unitprice", type.bigDecimalType()))
					.title(Templates.createTitleComponent("DataFilter"))
					.pageFooter(Templates.footerComponent)
					.setFilterExpression(new FilterExpression())
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
		dataSource.add("DVD", 5, new BigDecimal(30));
		dataSource.add("DVD", 1, new BigDecimal(28));
		dataSource.add("DVD", 5, new BigDecimal(32));
		dataSource.add("Book", 3, new BigDecimal(11));
		dataSource.add("Book", 1, new BigDecimal(15));
		dataSource.add("Book", 5, new BigDecimal(10));
		dataSource.add("Book", 8, new BigDecimal(9));
		return dataSource;
	}

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		new DataFilterReport();
	}

	private class FilterExpression extends AbstractSimpleExpression<Boolean> {
		private static final long serialVersionUID = 1L;

		@Override
		public Boolean evaluate(ReportParameters reportParameters) {
			return reportParameters.getValue("item").equals("Book");
		}
	}
}

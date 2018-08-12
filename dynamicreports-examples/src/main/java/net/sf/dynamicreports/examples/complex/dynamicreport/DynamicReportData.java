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

package net.sf.dynamicreports.examples.complex.dynamicreport;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * <p>DynamicReportData class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DynamicReportData {

	/**
	 * <p>createDataSource.</p>
	 *
	 * @return a {@link net.sf.jasperreports.engine.JRDataSource} object.
	 */
	public JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("state", "item", "orderdate", "quantity", "unitprice");
		dataSource.add("New York", "DVD", toDate(2010, 1, 1), 5, new BigDecimal(30));
		dataSource.add("New York", "DVD", toDate(2010, 1, 3), 2, new BigDecimal(45));
		dataSource.add("New York", "DVD", toDate(2010, 1, 5), 4, new BigDecimal(36));
		dataSource.add("New York", "DVD", toDate(2010, 1, 18), 5, new BigDecimal(41));
		dataSource.add("New York", "Book", toDate(2010, 1, 8), 2, new BigDecimal(11));
		dataSource.add("New York", "Book", toDate(2010, 1, 15), 8, new BigDecimal(9));
		dataSource.add("New York", "Book", toDate(2010, 1, 21), 6, new BigDecimal(14));
		dataSource.add("New York", "Phone", toDate(2010, 1, 16), 1, new BigDecimal(200));
		dataSource.add("New York", "Phone", toDate(2010, 1, 22), 2, new BigDecimal(520));

		dataSource.add("Washington", "DVD", toDate(2010, 1, 8), 4, new BigDecimal(40));
		dataSource.add("Washington", "DVD", toDate(2010, 1, 16), 6, new BigDecimal(35));
		dataSource.add("Washington", "DVD", toDate(2010, 1, 23), 3, new BigDecimal(46));
		dataSource.add("Washington", "DVD", toDate(2010, 1, 28), 2, new BigDecimal(42));
		dataSource.add("Washington", "Book", toDate(2010, 1, 11), 3, new BigDecimal(12));
		dataSource.add("Washington", "Book", toDate(2010, 1, 17), 9, new BigDecimal(8));
		dataSource.add("Washington", "Book", toDate(2010, 1, 26), 4, new BigDecimal(14));
		dataSource.add("Washington", "Book", toDate(2010, 1, 29), 5, new BigDecimal(10));
		dataSource.add("Washington", "Phone", toDate(2010, 1, 12), 2, new BigDecimal(210));
		dataSource.add("Washington", "Phone", toDate(2010, 1, 29), 1, new BigDecimal(380));

		dataSource.add("Florida", "DVD", toDate(2010, 1, 1), 3, new BigDecimal(49));
		dataSource.add("Florida", "DVD", toDate(2010, 1, 8), 4, new BigDecimal(32));
		dataSource.add("Florida", "DVD", toDate(2010, 1, 17), 2, new BigDecimal(47));
		dataSource.add("Florida", "Book", toDate(2010, 1, 5), 4, new BigDecimal(11));
		dataSource.add("Florida", "Book", toDate(2010, 1, 16), 8, new BigDecimal(6));
		dataSource.add("Florida", "Book", toDate(2010, 1, 23), 6, new BigDecimal(16));
		dataSource.add("Florida", "Book", toDate(2010, 1, 28), 3, new BigDecimal(18));
		dataSource.add("Florida", "Phone", toDate(2010, 1, 12), 2, new BigDecimal(190));
		dataSource.add("Florida", "Phone", toDate(2010, 1, 18), 1, new BigDecimal(250));
		dataSource.add("Florida", "Phone", toDate(2010, 1, 26), 1, new BigDecimal(201));
		return dataSource;
	}

	private Date toDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, day);
		return c.getTime();
	}

	/**
	 * <p>getDynamicReport.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.examples.complex.dynamicreport.DynamicReport} object.
	 */
	public DynamicReport getDynamicReport() {
		DynamicReport report = new DynamicReport();

		report.setTitle("Sales");

		report.addColumn(new DynamicColumn("State", "state", "string"));
		report.addColumn(new DynamicColumn("Item", "item", "string"));
		DynamicColumn column = new DynamicColumn("Order date", "orderdate", "date");
		column.setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
		report.addColumn(column);
		report.addColumn(new DynamicColumn("Quantity", "quantity", "integer"));
		column = new DynamicColumn("Unit price", "unitprice", "bigDecimal");
		column.setPattern("#,###.0");
		report.addColumn(column);

		report.addGroup("state");

		report.addSubtotal("quantity");
		report.addSubtotal("unitprice");

		report.setShowPageNumber(true);

		return report;
	}

}

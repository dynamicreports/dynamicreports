/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.examples.complex.sales;

import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>SalesData class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class SalesData {

    /**
     * <p>createDataSource.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.JRDataSource} object.
     */
    public JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("state", "item", "orderdate", "quantity", "unitprice");
        dataSource.add("New York", "Notebook", toDate(2010, 1, 1), 1, BigDecimal.valueOf(500));
        dataSource.add("New York", "DVD", toDate(2010, 1, 1), 5, BigDecimal.valueOf(30));
        dataSource.add("New York", "DVD", toDate(2010, 1, 3), 2, BigDecimal.valueOf(45));
        dataSource.add("New York", "DVD", toDate(2010, 1, 5), 4, BigDecimal.valueOf(36));
        dataSource.add("New York", "DVD", toDate(2010, 1, 18), 5, BigDecimal.valueOf(41));
        dataSource.add("New York", "Book", toDate(2010, 1, 8), 2, BigDecimal.valueOf(11));
        dataSource.add("New York", "Book", toDate(2010, 1, 15), 8, BigDecimal.valueOf(9));
        dataSource.add("New York", "Book", toDate(2010, 1, 21), 6, BigDecimal.valueOf(14));
        dataSource.add("New York", "Phone", toDate(2010, 1, 16), 1, BigDecimal.valueOf(200));
        dataSource.add("New York", "Phone", toDate(2010, 1, 22), 2, BigDecimal.valueOf(520));

        dataSource.add("Washington", "Notebook", toDate(2010, 1, 15), 1, BigDecimal.valueOf(610));
        dataSource.add("Washington", "DVD", toDate(2010, 1, 8), 4, BigDecimal.valueOf(40));
        dataSource.add("Washington", "DVD", toDate(2010, 1, 16), 6, BigDecimal.valueOf(35));
        dataSource.add("Washington", "DVD", toDate(2010, 1, 23), 3, BigDecimal.valueOf(46));
        dataSource.add("Washington", "DVD", toDate(2010, 1, 28), 2, BigDecimal.valueOf(42));
        dataSource.add("Washington", "Book", toDate(2010, 1, 11), 3, BigDecimal.valueOf(12));
        dataSource.add("Washington", "Book", toDate(2010, 1, 17), 9, BigDecimal.valueOf(8));
        dataSource.add("Washington", "Book", toDate(2010, 1, 26), 4, BigDecimal.valueOf(14));
        dataSource.add("Washington", "Book", toDate(2010, 1, 29), 5, BigDecimal.valueOf(10));
        dataSource.add("Washington", "Phone", toDate(2010, 1, 12), 2, BigDecimal.valueOf(210));
        dataSource.add("Washington", "Phone", toDate(2010, 1, 29), 1, BigDecimal.valueOf(380));

        dataSource.add("Florida", "Notebook", toDate(2010, 1, 3), 1, BigDecimal.valueOf(460));
        dataSource.add("Florida", "DVD", toDate(2010, 1, 1), 3, BigDecimal.valueOf(49));
        dataSource.add("Florida", "DVD", toDate(2010, 1, 8), 4, BigDecimal.valueOf(32));
        dataSource.add("Florida", "DVD", toDate(2010, 1, 17), 2, BigDecimal.valueOf(47));
        dataSource.add("Florida", "Book", toDate(2010, 1, 5), 4, BigDecimal.valueOf(11));
        dataSource.add("Florida", "Book", toDate(2010, 1, 16), 8, BigDecimal.valueOf(6));
        dataSource.add("Florida", "Book", toDate(2010, 1, 23), 6, BigDecimal.valueOf(16));
        dataSource.add("Florida", "Book", toDate(2010, 1, 28), 3, BigDecimal.valueOf(18));
        dataSource.add("Florida", "Phone", toDate(2010, 1, 12), 2, BigDecimal.valueOf(190));
        dataSource.add("Florida", "Phone", toDate(2010, 1, 18), 1, BigDecimal.valueOf(250));
        dataSource.add("Florida", "Phone", toDate(2010, 1, 26), 1, BigDecimal.valueOf(201));
        return dataSource;
    }

    private Date toDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }
}

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
package net.sf.dynamicreports.examples.group;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>DateGroupReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DateGroupReport {

    /**
     * <p>Constructor for DateGroupReport.</p>
     */
    public DateGroupReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new DateGroupReport();
    }

    private void build() {
        TextColumnBuilder<Date> yearColumn = col.column("Order year", "orderdate", type.dateYearType());
        TextColumnBuilder<Date> monthColumn = col.column("Order month", "orderdate", type.dateMonthType());

        ColumnGroupBuilder yearGroup = grp.group(yearColumn).groupByDataType();
        ColumnGroupBuilder monthGroup = grp.group(monthColumn).groupByDataType();

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(yearColumn, monthColumn, col.column("Order date", "orderdate", type.dateType()), col.column("Item", "item", type.stringType()),
                             col.column("Quantity", "quantity", type.integerType()), col.column("Unit price", "unitprice", type.bigDecimalType()))
                    .groupBy(yearGroup, monthGroup)
                    .title(Templates.createTitleComponent("DateGroup"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("orderdate", "item", "quantity", "unitprice");
        dataSource.add(toDate(2009, 11, 1), "Tablet", 5, BigDecimal.valueOf(250));
        dataSource.add(toDate(2009, 11, 1), "Laptop", 3, BigDecimal.valueOf(480));
        dataSource.add(toDate(2009, 12, 1), "Smartphone", 1, BigDecimal.valueOf(280));
        dataSource.add(toDate(2009, 12, 1), "Tablet", 1, BigDecimal.valueOf(190));
        dataSource.add(toDate(2010, 1, 1), "Tablet", 4, BigDecimal.valueOf(230));
        dataSource.add(toDate(2010, 1, 1), "Laptop", 2, BigDecimal.valueOf(650));
        dataSource.add(toDate(2010, 2, 1), "Laptop", 3, BigDecimal.valueOf(550));
        dataSource.add(toDate(2010, 2, 1), "Smartphone", 5, BigDecimal.valueOf(210));
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

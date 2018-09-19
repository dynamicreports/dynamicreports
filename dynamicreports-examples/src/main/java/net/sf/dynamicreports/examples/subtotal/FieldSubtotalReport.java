/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.examples.subtotal;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>FieldSubtotalReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class FieldSubtotalReport {

    /**
     * <p>Constructor for FieldSubtotalReport.</p>
     */
    public FieldSubtotalReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new FieldSubtotalReport();
    }

    private void build() {
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Date> orderDateColumn = col.column("Order Date", "orderdate", type.dateType());

        AggregationSubtotalBuilder<Integer> quantitySum = sbt.sum("quantity", Integer.class, itemColumn)
                                                             .setLabel("quantity sum");
        AggregationSubtotalBuilder<BigDecimal> unitPriceSum = sbt.sum("unitprice", BigDecimal.class, itemColumn)
                                                                 .setLabel("unitPrice sum");

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(itemColumn, orderDateColumn)
                    .subtotalsAtSummary(quantitySum, unitPriceSum)
                    .title(Templates.createTitleComponent("FieldSubtotal"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
        dataSource.add("Tablet", toDate(2010, 1, 1), 3, new BigDecimal(110));
        dataSource.add("Tablet", toDate(2010, 2, 1), 1, new BigDecimal(150));
        dataSource.add("Laptop", toDate(2010, 2, 1), 3, new BigDecimal(300));
        dataSource.add("Smartphone", toDate(2010, 4, 1), 8, new BigDecimal(90));
        dataSource.add("Smartphone", toDate(2010, 5, 1), 6, new BigDecimal(120));
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

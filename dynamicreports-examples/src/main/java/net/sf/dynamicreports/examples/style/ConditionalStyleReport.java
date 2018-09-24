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
package net.sf.dynamicreports.examples.style;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.ConditionalStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.cnd;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>ConditionalStyleReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ConditionalStyleReport {

    /**
     * <p>Constructor for ConditionalStyleReport.</p>
     */
    public ConditionalStyleReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new ConditionalStyleReport();
    }

    private void build() {
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Date> orderDateColumn = col.column("Order date", "orderdate", type.dateType());
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
        TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());

        ConditionalStyleBuilder condition1 = stl.conditionalStyle(new OrderDateConditionExpression()).setBackgroundColor(new Color(255, 210, 210));
        ConditionalStyleBuilder condition2 = stl.conditionalStyle(cnd.greater(unitPriceColumn, 20)).setBackgroundColor(new Color(210, 255, 210));

        StyleBuilder orderDateStyle = stl.style().conditionalStyles(condition1);
        orderDateColumn.setStyle(orderDateStyle);

        StyleBuilder unitPriceStyle = stl.style().conditionalStyles(condition2);
        unitPriceColumn.setStyle(unitPriceStyle);

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(itemColumn, orderDateColumn, quantityColumn, unitPriceColumn)
                    .title(Templates.createTitleComponent("ConditionalStyle"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
        dataSource.add("DVD", toDate(2010, 1, 1), 5, new BigDecimal(30));
        dataSource.add("DVD", toDate(2010, 1, 3), 1, new BigDecimal(28));
        dataSource.add("DVD", toDate(2010, 1, 19), 5, new BigDecimal(32));
        dataSource.add("Book", toDate(2010, 1, 5), 3, new BigDecimal(11));
        dataSource.add("Book", toDate(2010, 1, 11), 1, new BigDecimal(15));
        dataSource.add("Book", toDate(2010, 1, 15), 5, new BigDecimal(10));
        dataSource.add("Book", toDate(2010, 1, 20), 8, new BigDecimal(9));
        return dataSource;
    }

    private Date toDate(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }

    private class OrderDateConditionExpression extends AbstractSimpleExpression<Boolean> {
        private static final long serialVersionUID = 1L;

        @Override
        public Boolean evaluate(ReportParameters reportParameters) {
            Date orderDate = reportParameters.getValue("orderdate");
            Integer quantity = reportParameters.getValue("quantity");
            return orderDate.after(toDate(2010, 1, 10)) && quantity > 1;
        }
    }
}

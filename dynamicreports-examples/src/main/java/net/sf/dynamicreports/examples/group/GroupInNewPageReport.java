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
 * <p>GroupInNewPageReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GroupInNewPageReport {

    /**
     * <p>Constructor for GroupInNewPageReport.</p>
     */
    public GroupInNewPageReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new GroupInNewPageReport();
    }

    private void build() {
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType()).setWidth(30);

        ColumnGroupBuilder itemGroup = grp.group(itemColumn).startInNewPage();

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(itemColumn, col.column("Order date", "orderdate", type.dateType()), col.column("Quantity", "quantity", type.integerType()),
                             col.column("Unit price", "unitprice", type.bigDecimalType()))
                    .groupBy(itemGroup)
                    .title(Templates.createTitleComponent("GroupInNewPage"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
        dataSource.add("Tablet", toDate(2010, 1, 1), 5, new BigDecimal(300));
        dataSource.add("Tablet", toDate(2010, 1, 3), 1, new BigDecimal(280));
        dataSource.add("Tablet", toDate(2010, 1, 19), 5, new BigDecimal(320));
        dataSource.add("Laptop", toDate(2010, 1, 5), 3, new BigDecimal(580));
        dataSource.add("Laptop", toDate(2010, 1, 8), 1, new BigDecimal(620));
        dataSource.add("Laptop", toDate(2010, 1, 15), 5, new BigDecimal(600));
        dataSource.add("Smartphone", toDate(2010, 1, 18), 8, new BigDecimal(150));
        dataSource.add("Smartphone", toDate(2010, 1, 20), 8, new BigDecimal(310));
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

/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.examples.tableofcontents;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>TableOfContentsReport1 class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class TableOfContentsReport1 {

    /**
     * <p>Constructor for TableOfContentsReport1.</p>
     */
    public TableOfContentsReport1() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new TableOfContentsReport1();
    }

    private void build() {
        TextColumnBuilder<String> countryColumn = col.column("Country", "country", type.stringType());
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());

        try {
            report().setTemplate(Templates.reportTemplate)
                    .tableOfContents()
                    .columns(countryColumn, itemColumn, col.column("Order date", "orderdate", type.dateType()), col.column("Quantity", "quantity", type.integerType()),
                             col.column("Unit price", "unitprice", type.bigDecimalType()))
                    .groupBy(countryColumn, itemColumn)
                    .title(Templates.createTitleComponent("TableOfContents1"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        String[] countries = new String[] {"USA", "Canada", "Mexico"};
        String[] items = new String[] {"Book", "Notebook", "PDA"};
        DRDataSource dataSource = new DRDataSource("country", "item", "orderdate", "quantity", "unitprice");
        for (String country : countries) {
            for (String item : items) {
                for (int i = 0; i < 8; i++) {
                    dataSource.add(country, item, toDate(2010, 1, (int) (Math.random() * 10) + 1), (int) (Math.random() * 10) + 1, BigDecimal.valueOf(Math.random() * 100 + 1));
                }
            }
        }
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

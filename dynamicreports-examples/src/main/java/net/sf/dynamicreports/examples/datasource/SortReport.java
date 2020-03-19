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
package net.sf.dynamicreports.examples.datasource;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.asc;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.desc;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>SortReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class SortReport {

    /**
     * <p>Constructor for SortReport.</p>
     */
    public SortReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new SortReport();
    }

    private void build() {
        try {
            TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
            TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
            TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());
            report().setTemplate(Templates.reportTemplate)
                    .columns(itemColumn, quantityColumn, unitPriceColumn)
                    .title(Templates.createTitleComponent("Sort"))
                    .pageFooter(Templates.footerComponent)
                    .sortBy(asc(itemColumn), desc(unitPriceColumn))
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        dataSource.add("Book", 1, BigDecimal.valueOf(15));
        dataSource.add("DVD", 5, BigDecimal.valueOf(30));
        dataSource.add("DVD", 1, BigDecimal.valueOf(28));
        dataSource.add("Book", 5, BigDecimal.valueOf(10));
        dataSource.add("DVD", 5, BigDecimal.valueOf(32));
        dataSource.add("Book", 3, BigDecimal.valueOf(11));
        dataSource.add("Book", 8, BigDecimal.valueOf(9));
        return dataSource;
    }
}

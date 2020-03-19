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
package net.sf.dynamicreports.examples.column;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>PercentageColumnWidthReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class PercentageColumnWidthReport {

    /**
     * <p>Constructor for PercentageColumnWidthReport.</p>
     */
    public PercentageColumnWidthReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new PercentageColumnWidthReport();
    }

    private void build() {
        try {
            report().setTemplate(Templates.reportTemplate).columns(col.column("Item", "item", type.stringType()).setWidth(50), // 50%
                                                                   col.column("Quantity", "quantity", type.integerType()).setWidth(10), // 10%
                                                                   col.column("Unit price", "unitprice", type.bigDecimalType()).setWidth(15), // 15%
                                                                   col.column("Order date", "orderdate", type.dateType()).setWidth(25)) // 25%
                    .title(Templates.createTitleComponent("PercentageColumnWidth")).pageFooter(Templates.footerComponent).setDataSource(createDataSource()).show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
        dataSource.add("Book", Date.from(Instant.now()), 10, BigDecimal.valueOf (200));
        return dataSource;
    }
}

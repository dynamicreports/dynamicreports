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
package net.sf.dynamicreports.examples.columngrid;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.grid.ColumnTitleGroupBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grid;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>ColumnTitleGroupReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class ColumnTitleGroupReport {

    /**
     * <p>Constructor for ColumnTitleGroupReport.</p>
     */
    public ColumnTitleGroupReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new ColumnTitleGroupReport();
    }

    private void build() {
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Date> orderDateColumn = col.column("Order date", "orderdate", type.dateType());
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType()).setFixedWidth(50);
        TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());

        ColumnTitleGroupBuilder titleGroup2 = grid.titleGroup("Group 2", quantityColumn, unitPriceColumn);
        ColumnTitleGroupBuilder titleGroup1 = grid.titleGroup("Group 1", orderDateColumn, titleGroup2).setTitleFixedWidth(450);

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columnGrid(itemColumn, titleGroup1)
                    .columns(itemColumn, orderDateColumn, quantityColumn, unitPriceColumn)
                    .title(Templates.createTitleComponent("ColumnTitleGroup"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
        dataSource.add("Notebook", Date.from(Instant.now()), 1, BigDecimal.valueOf(500));
        return dataSource;
    }
}

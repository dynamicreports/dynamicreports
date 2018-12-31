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
package net.sf.dynamicreports.examples.subtotal;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>GroupSubtotalReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GroupSubtotalReport {

    /**
     * <p>Constructor for GroupSubtotalReport.</p>
     */
    public GroupSubtotalReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new GroupSubtotalReport();
    }

    private void build() {
        TextColumnBuilder<String> countryColumn = col.column("Country", "country", type.stringType());
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
        TextColumnBuilder<BigDecimal> priceColumn = col.column("Price", "price", type.bigDecimalType());

        ColumnGroupBuilder countryGroup = grp.group(countryColumn);

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(countryColumn, itemColumn, quantityColumn, priceColumn)
                    .groupBy(countryGroup)
                    .subtotalsAtFirstGroupFooter(sbt.sum(quantityColumn))
                    .subtotalsAtGroupFooter(countryGroup, sbt.sum(priceColumn))
                    .subtotalsAtSummary(sbt.text("Total", itemColumn), sbt.sum(quantityColumn), sbt.sum(priceColumn))
                    .title(Templates.createTitleComponent("GroupSubtotal"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("country", "item", "quantity", "price");
        dataSource.add("USA", "Tablet", 4, BigDecimal.valueOf(150));
        dataSource.add("USA", "Tablet", 3, BigDecimal.valueOf(190));
        dataSource.add("USA", "Laptop", 2, BigDecimal.valueOf(250));
        dataSource.add("USA", "Laptop", 1, BigDecimal.valueOf(420));
        dataSource.add("Canada", "Tablet", 6, BigDecimal.valueOf(120));
        dataSource.add("Canada", "Tablet", 2, BigDecimal.valueOf(180));
        dataSource.add("Canada", "Laptop", 3, BigDecimal.valueOf(300));
        dataSource.add("Canada", "Laptop", 2, BigDecimal.valueOf(390));
        return dataSource;
    }
}

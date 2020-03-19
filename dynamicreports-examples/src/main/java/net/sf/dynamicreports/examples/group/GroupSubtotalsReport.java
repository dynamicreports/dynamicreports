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
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>GroupSubtotalsReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class GroupSubtotalsReport {

    /**
     * <p>Constructor for GroupSubtotalsReport.</p>
     */
    public GroupSubtotalsReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new GroupSubtotalsReport();
    }

    private void build() {
        TextColumnBuilder<Date> yearColumn = col.column("Order year", "orderdate", type.dateYearType());
        TextColumnBuilder<Date> monthColumn = col.column("Order month", "orderdate", type.dateMonthType());
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
        TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());

        ColumnGroupBuilder yearGroup = grp.group(yearColumn).groupByDataType();
        ColumnGroupBuilder monthGroup = grp.group(monthColumn).groupByDataType().setHeaderLayout(GroupHeaderLayout.EMPTY).setHideColumn(false);

        try {
            report().setTemplate(Templates.reportTemplate)
                    .setSubtotalStyle(Templates.columnStyle)
                    .setShowColumnValues(false)
                    .columns(yearColumn, monthColumn, quantityColumn, unitPriceColumn)
                    .groupBy(yearGroup, monthGroup)
                    .subtotalsAtGroupFooter(monthGroup, sbt.first(monthColumn), sbt.sum(quantityColumn), sbt.sum(unitPriceColumn))
                    .title(Templates.createTitleComponent("GroupSubtotals"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("orderdate", "quantity", "unitprice");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);
        for (int i = 0; i < 200; i++) {
            Date date = c.getTime();
            dataSource.add(date, (int) (Math.random() * 10) + 1, BigDecimal.valueOf(Math.random() * 100 + 1));
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dataSource;
    }
}

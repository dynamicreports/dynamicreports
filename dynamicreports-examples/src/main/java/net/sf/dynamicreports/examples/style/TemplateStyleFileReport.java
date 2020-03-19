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
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>TemplateStyleFileReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class TemplateStyleFileReport {

    /**
     * <p>Constructor for TemplateStyleFileReport.</p>
     */
    public TemplateStyleFileReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new TemplateStyleFileReport();
    }

    private void build() {
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType()).setStyle(stl.templateStyle("style1"));
        TextColumnBuilder<Date> orderDateColumn = col.column("Order date", "orderdate", type.dateType()).setStyle(stl.templateStyle("style2"));
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
        TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());

        try {
            report().templateStyles(stl.loadStyles(TemplateStyleFileReport.class.getResource("TemplateStyles.jrtx")))
                    .setColumnStyle(stl.templateStyle("columnStyle"))
                    .setColumnTitleStyle(stl.templateStyle("columnTitleStyle"))
                    .columns(itemColumn, orderDateColumn, quantityColumn, unitPriceColumn)
                    .title(Templates.createTitleComponent("TemplateStyleFile"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
        dataSource.add("DVD", toDate(2010, 1, 1), 5, BigDecimal.valueOf(30));
        dataSource.add("DVD", toDate(2010, 1, 3), 1, BigDecimal.valueOf(28));
        dataSource.add("DVD", toDate(2010, 1, 19), 5, BigDecimal.valueOf(32));
        dataSource.add("Book", toDate(2010, 1, 5), 3, BigDecimal.valueOf(11));
        dataSource.add("Book", toDate(2010, 1, 11), 1, BigDecimal.valueOf(15));
        dataSource.add("Book", toDate(2010, 1, 15), 5, BigDecimal.valueOf(10));
        dataSource.add("Book", toDate(2010, 1, 20), 8, BigDecimal.valueOf(9));
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

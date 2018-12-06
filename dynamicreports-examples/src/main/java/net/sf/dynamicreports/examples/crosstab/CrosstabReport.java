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
package net.sf.dynamicreports.examples.crosstab;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;

/**
 * <p>CrosstabReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class CrosstabReport {

    /**
     * <p>Constructor for CrosstabReport.</p>
     */
    public CrosstabReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new CrosstabReport();
    }

    private void build() {
        CrosstabRowGroupBuilder<String> rowGroup = ctab.rowGroup("state", String.class).setTotalHeader("Total for state");

        CrosstabColumnGroupBuilder<String> columnGroup = ctab.columnGroup("item", String.class);

        CrosstabBuilder crosstab = ctab.crosstab()
                                       .headerCell(cmp.text("State / Item").setStyle(Templates.boldCenteredStyle))
                                       .rowGroups(rowGroup)
                                       .columnGroups(columnGroup)
                                       .measures(ctab.measure("Quantity", "quantity", Integer.class, Calculation.SUM), ctab.measure("Unit price", "unitprice", BigDecimal.class, Calculation.SUM));

        try {
            report().setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
                    .setTemplate(Templates.reportTemplate)
                    .title(Templates.createTitleComponent("Crosstab"))
                    .summary(crosstab)
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("state", "item", "quantity", "unitprice");
        dataSource.add("New York", "Notebook", 1, BigDecimal.valueOf(500));
        dataSource.add("New York", "DVD", 5, BigDecimal.valueOf(30));
        dataSource.add("New York", "DVD", 2, BigDecimal.valueOf(45));
        dataSource.add("New York", "DVD", 4, BigDecimal.valueOf(36));
        dataSource.add("New York", "DVD", 5, BigDecimal.valueOf(41));
        dataSource.add("New York", "Book", 2, BigDecimal.valueOf(11));
        dataSource.add("New York", "Book", 8, BigDecimal.valueOf(9));
        dataSource.add("New York", "Book", 6, BigDecimal.valueOf(14));

        dataSource.add("Washington", "Notebook", 1, BigDecimal.valueOf(610));
        dataSource.add("Washington", "DVD", 4, BigDecimal.valueOf(40));
        dataSource.add("Washington", "DVD", 6, BigDecimal.valueOf(35));
        dataSource.add("Washington", "DVD", 3, BigDecimal.valueOf(46));
        dataSource.add("Washington", "DVD", 2, BigDecimal.valueOf(42));
        dataSource.add("Washington", "Book", 3, BigDecimal.valueOf(12));
        dataSource.add("Washington", "Book", 9, BigDecimal.valueOf(8));
        dataSource.add("Washington", "Book", 4, BigDecimal.valueOf(14));
        dataSource.add("Washington", "Book", 5, BigDecimal.valueOf(10));

        dataSource.add("Florida", "Notebook", 1, BigDecimal.valueOf(460));
        dataSource.add("Florida", "DVD", 3, BigDecimal.valueOf(49));
        dataSource.add("Florida", "DVD", 4, BigDecimal.valueOf(32));
        dataSource.add("Florida", "DVD", 2, BigDecimal.valueOf(47));
        dataSource.add("Florida", "Book", 4, BigDecimal.valueOf(11));
        dataSource.add("Florida", "Book", 8, BigDecimal.valueOf(6));
        dataSource.add("Florida", "Book", 6, BigDecimal.valueOf(16));
        dataSource.add("Florida", "Book", 3, BigDecimal.valueOf(18));
        return dataSource;
    }
}

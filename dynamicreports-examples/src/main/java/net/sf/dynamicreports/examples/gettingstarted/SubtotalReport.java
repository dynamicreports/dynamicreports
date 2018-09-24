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
package net.sf.dynamicreports.examples.gettingstarted;

import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.builder.subtotal.PercentageSubtotalBuilder;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>SubtotalReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class SubtotalReport {
    private StyleBuilder boldStyle;
    private TextColumnBuilder<Integer> column2;

    /**
     * <p>Constructor for SubtotalReport.</p>
     */
    public SubtotalReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new SubtotalReport();
    }

    private void build() {
        boldStyle = stl.style().bold().setHorizontalTextAlignment(HorizontalTextAlignment.RIGHT);

        TextColumnBuilder<String> column1 = col.column("Column1", "column1", type.stringType());
        column2 = col.column("Column2", "column2", type.integerType());
        ColumnGroupBuilder columnGroup = grp.group(column1);

        try {
            report()// create new report design
                    .setPageColumnsPerPage(2)
                    .setSubtotalStyle(boldStyle)
                    .columns(column1, column2)
                    .groupBy(columnGroup)

                    // subtotals
                    .subtotalsAtTitle(createSubtotal("This is a title sum"))
                    .subtotalsAtPageHeader(createSubtotal("This is a page header sum"))
                    .subtotalsAtPageFooter(createSubtotal("This is a page footer sum"))
                    .subtotalsAtColumnHeader(createSubtotal("This is a column header sum"))
                    .subtotalsAtColumnFooter(createSubtotal("This is a column footer sum"))
                    .subtotalsAtLastPageFooter(createSubtotal("This is a last page footer sum"))
                    .subtotalsAtSummary(createSubtotal("This is a summary sum"))
                    .subtotalsAtGroupHeader(columnGroup, createSubtotal("This is a group header sum"))
                    .subtotalsAtGroupFooter(columnGroup, createSubtotal("This is a group footer sum"))
                    .subtotalsOfPercentageAtGroupHeader(columnGroup, createPercSubtotal("This is a group header perc."))
                    .subtotalsOfPercentageAtGroupFooter(columnGroup, createPercSubtotal("This is a group footer perc."))

                    .setDataSource(createDataSource())// set datasource
                    .show();// create and show report
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private AggregationSubtotalBuilder<Integer> createSubtotal(String label) {
        return sbt.sum(column2).setLabel(label).setLabelStyle(boldStyle);
    }

    private PercentageSubtotalBuilder createPercSubtotal(String label) {
        return sbt.percentage(column2).setLabel(label).setLabelStyle(boldStyle);
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("column1", "column2");
        int row = 1;
        for (int i = 1; i <= 2; i++) {
            for (int j = 0; j < 50; j++) {
                dataSource.add("group" + i, row++);
            }
        }
        return dataSource;
    }
}

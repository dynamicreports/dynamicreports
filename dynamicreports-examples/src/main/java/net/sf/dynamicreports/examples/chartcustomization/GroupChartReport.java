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
package net.sf.dynamicreports.examples.chartcustomization;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.chart.Bar3DChartBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>GroupChartReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GroupChartReport {

    /**
     * <p>Constructor for GroupChartReport.</p>
     */
    public GroupChartReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new GroupChartReport();
    }

    private void build() {
        TextColumnBuilder<String> countryColumn = col.column("Country", "country", type.stringType());
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
        TextColumnBuilder<BigDecimal> salesColumn = col.column("Sales", "sales", type.bigDecimalType());

        Bar3DChartBuilder chart =
            cht.bar3DChart().setFixedHeight(180).setCategory(itemColumn).series(cht.serie(quantityColumn), cht.serie(salesColumn)).setCategoryAxisFormat(cht.axisFormat().setLabel("Item"));

        ColumnGroupBuilder countryGroup = grp.group(countryColumn).footer(chart);

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(countryColumn, itemColumn, quantityColumn, salesColumn)
                    .title(Templates.createTitleComponent("GroupChart"))
                    .groupBy(countryGroup)
                    .summary(cmp.text("All countries").setStyle(Templates.bold12CenteredStyle), chart)
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("country", "item", "quantity", "sales");
        dataSource.add("USA", "Tablet", 170, BigDecimal.valueOf(100));
        dataSource.add("USA", "Laptop", 90, BigDecimal.valueOf(280));
        dataSource.add("USA", "Smartphone", 120, BigDecimal.valueOf(250));
        dataSource.add("Canada", "Tablet", 120, BigDecimal.valueOf(80));
        dataSource.add("Canada", "Laptop", 150, BigDecimal.valueOf(310));
        dataSource.add("Canada", "Smartphone", 100, BigDecimal.valueOf(180));
        return dataSource;
    }
}

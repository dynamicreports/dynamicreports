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
package net.sf.dynamicreports.examples.tableofcontents;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.chart.BarChartBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsHeadingBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.tableOfContentsHeading;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>TableOfContentsReport2 class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class TableOfContentsReport2 {

    /**
     * <p>Constructor for TableOfContentsReport2.</p>
     */
    public TableOfContentsReport2() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new TableOfContentsReport2();
    }

    private void build() {
        FieldBuilder<String> itemField = field("item", type.stringType());
        FieldBuilder<Integer> quantityField = field("quantity", type.integerType());
        FieldBuilder<BigDecimal> unitPriceField = field("unitprice", type.bigDecimalType());

        TableOfContentsHeadingBuilder tocHeading1 = tableOfContentsHeading();
        TextFieldBuilder<String> title1 = cmp.text("Title1").setTableOfContentsHeading(tocHeading1);

        TableOfContentsHeadingBuilder tocHeading2 = tableOfContentsHeading().setParentHeading(tocHeading1);
        TextFieldBuilder<String> title2 = cmp.text("Title2").setTableOfContentsHeading(tocHeading2);

        BarChartBuilder chart = cht.barChart()
                                   .setDataSource(createChartDataSource())
                                   .setCategory(itemField)
                                   .series(cht.serie(quantityField).setLabel("Quantity"), cht.serie(unitPriceField).setLabel("Unit price"))
                                   .setTableOfContentsHeading("Chart");

        try {
            report().setTemplate(Templates.reportTemplate)
                    .tableOfContents()
                    .title(Templates.createTitleComponent("TableOfContents2"), title1, title2, cmp.subreport(createSubreport(1)), cmp.subreport(createSubreport(2)), chart)
                    .pageFooter(Templates.footerComponent)
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JasperReportBuilder createSubreport(int index) {
        TextFieldBuilder<String> title = cmp.text("Subreport" + index).setStyle(Templates.bold12CenteredStyle).setTableOfContentsHeading(tableOfContentsHeading());

        JasperReportBuilder report = report();
        report.setTemplate(Templates.reportTemplate)
              .title(title)
              .columns(col.column("Item", "item", type.stringType()), col.column("Quantity", "quantity", type.integerType()), col.column("Unit price", "unitprice", type.bigDecimalType()))
              .setDataSource(createSubreportDataSource());

        return report;
    }

    private JRDataSource createSubreportDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        for (int i = 0; i < 30; i++) {
            dataSource.add("Book", (int) (Math.random() * 10) + 1, BigDecimal.valueOf(Math.random() * 100 + 1));
        }
        return dataSource;
    }

    private JRDataSource createChartDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        dataSource.add("Book", 170, BigDecimal.valueOf(100));
        dataSource.add("Notebook", 90, BigDecimal.valueOf(450));
        dataSource.add("PDA", 120, BigDecimal.valueOf(250));
        return dataSource;
    }
}

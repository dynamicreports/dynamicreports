/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.examples.miscellaneous;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.cm;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.inch;
import static net.sf.dynamicreports.report.builder.DynamicReports.mm;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>UnitsReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class UnitsReport {

    /**
     * <p>Constructor for UnitsReport.</p>
     */
    public UnitsReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new UnitsReport();
    }

    private void build() {
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType())
                                                  .setFixedWidth(cm(10));
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
        TextColumnBuilder<BigDecimal> priceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());

        StyleBuilder style = stl.style(Templates.bold12CenteredStyle)
                                .setBorder(stl.pen1Point());
        TextFieldBuilder<String> text1 = cmp.text("width = 120 pixels")
                                            .setFixedWidth(120)
                                            .setStyle(style);
        TextFieldBuilder<String> text2 = cmp.text("width = 10cm")
                                            .setFixedWidth(cm(10))
                                            .setStyle(style);
        TextFieldBuilder<String> text3 = cmp.text("width = 5 inches")
                                            .setFixedWidth(inch(5))
                                            .setStyle(style);
        TextFieldBuilder<String> text4 = cmp.text("width = 150mm")
                                            .setFixedWidth(mm(150))
                                            .setStyle(style);

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(itemColumn, quantityColumn, priceColumn)
                    .title(Templates.createTitleComponent("Units"), text1, text2, text3, text4, cmp.verticalGap(cm(1)))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        for (int i = 0; i < 20; i++) {
            dataSource.add("Book", (int) (Math.random() * 10) + 1, new BigDecimal(Math.random() * 100 + 1));
        }
        return dataSource;
    }
}

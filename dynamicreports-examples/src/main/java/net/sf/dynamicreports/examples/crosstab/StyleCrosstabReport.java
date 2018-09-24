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
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.builder.style.ConditionalStyleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.Color;
import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.cnd;
import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * <p>StyleCrosstabReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class StyleCrosstabReport {

    /**
     * <p>Constructor for StyleCrosstabReport.</p>
     */
    public StyleCrosstabReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new StyleCrosstabReport();
    }

    private void build() {
        CrosstabRowGroupBuilder<String> rowGroup = ctab.rowGroup("state", String.class).setTotalHeader("Total for state");

        CrosstabColumnGroupBuilder<String> columnGroup = ctab.columnGroup("item", String.class);

        CrosstabMeasureBuilder<Integer> quantityMeasure = ctab.measure("Quantity", "quantity", Integer.class, Calculation.SUM);
        CrosstabMeasureBuilder<BigDecimal> unitPriceMeasure = ctab.measure("Unit price", "unitprice", BigDecimal.class, Calculation.SUM);

        ConditionalStyleBuilder condition1 = stl.conditionalStyle(cnd.greater(unitPriceMeasure, 600)).setBackgroundColor(new Color(210, 255, 210)).setBorder(stl.pen1Point());
        ConditionalStyleBuilder condition2 = stl.conditionalStyle(cnd.smaller(unitPriceMeasure, 150)).setBackgroundColor(new Color(255, 210, 210)).setBorder(stl.pen1Point());

        StyleBuilder unitPriceStyle = stl.style().conditionalStyles(condition1, condition2).setBorder(stl.pen1Point());
        StyleBuilder totalCellStyle = stl.style().setBackgroundColor(new Color(200, 200, 255)).setBorder(stl.pen1Point());

        unitPriceMeasure.setStyle(unitPriceStyle).setStyle(totalCellStyle, rowGroup).setStyle(totalCellStyle, rowGroup, columnGroup);
        quantityMeasure.setStyle(totalCellStyle, rowGroup).setStyle(totalCellStyle, rowGroup, columnGroup);

        CrosstabBuilder crosstab =
            ctab.crosstab().headerCell(cmp.text("State / Item").setStyle(Templates.boldCenteredStyle)).rowGroups(rowGroup).columnGroups(columnGroup).measures(quantityMeasure, unitPriceMeasure);

        try {
            report().setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
                    .setTemplate(Templates.reportTemplate)
                    .title(Templates.createTitleComponent("StyleCrosstab"))
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
        dataSource.add("New York", "Notebook", 1, new BigDecimal(500));
        dataSource.add("New York", "DVD", 5, new BigDecimal(30));
        dataSource.add("New York", "DVD", 2, new BigDecimal(45));
        dataSource.add("New York", "DVD", 4, new BigDecimal(36));
        dataSource.add("New York", "DVD", 5, new BigDecimal(41));
        dataSource.add("New York", "Book", 2, new BigDecimal(11));
        dataSource.add("New York", "Book", 8, new BigDecimal(9));
        dataSource.add("New York", "Book", 6, new BigDecimal(14));

        dataSource.add("Washington", "Notebook", 1, new BigDecimal(610));
        dataSource.add("Washington", "DVD", 4, new BigDecimal(40));
        dataSource.add("Washington", "DVD", 6, new BigDecimal(35));
        dataSource.add("Washington", "DVD", 3, new BigDecimal(46));
        dataSource.add("Washington", "DVD", 2, new BigDecimal(42));
        dataSource.add("Washington", "Book", 3, new BigDecimal(12));
        dataSource.add("Washington", "Book", 9, new BigDecimal(8));
        dataSource.add("Washington", "Book", 4, new BigDecimal(14));
        dataSource.add("Washington", "Book", 5, new BigDecimal(10));

        dataSource.add("Florida", "Notebook", 1, new BigDecimal(460));
        dataSource.add("Florida", "DVD", 3, new BigDecimal(49));
        dataSource.add("Florida", "DVD", 4, new BigDecimal(32));
        dataSource.add("Florida", "DVD", 2, new BigDecimal(47));
        dataSource.add("Florida", "Book", 4, new BigDecimal(11));
        dataSource.add("Florida", "Book", 8, new BigDecimal(6));
        dataSource.add("Florida", "Book", 6, new BigDecimal(16));
        dataSource.add("Florida", "Book", 3, new BigDecimal(18));
        return dataSource;
    }
}

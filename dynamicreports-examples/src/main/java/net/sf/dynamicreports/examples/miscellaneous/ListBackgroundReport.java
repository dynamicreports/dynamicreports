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
package net.sf.dynamicreports.examples.miscellaneous;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.builder.component.RectangleBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.Color;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.stream.IntStream;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>ListBackgroundReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class ListBackgroundReport {

    /**
     * <p>Constructor for ListBackgroundReport.</p>
     */
    public ListBackgroundReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new ListBackgroundReport();
    }

    private void build() {
        StyleBuilder style1 = stl.style().setRadius(10).setBackgroundColor(new Color(230, 230, 230)).setLinePen(stl.pen().setLineColor(Color.LIGHT_GRAY));
        StyleBuilder style2 = stl.style().setRadius(5);

        ImageBuilder background1 = cmp.image(Templates.class.getResource("images/background.gif")).setImageScale(ImageScale.CLIP).setStyle(style1);
        RectangleBuilder background2 = cmp.rectangle().setStyle(style2);
        RectangleBuilder background3 = cmp.rectangle().setStyle(style1).setPrintWhenExpression(exp.printInOddRow());

        HorizontalListBuilder title1 = cmp.horizontalList().add(cmp.text("title1")).setBackgroundComponent(background2);
        HorizontalListBuilder title2 = cmp.horizontalList().add(cmp.text("title2")).setBackgroundComponent(background2);
        HorizontalListBuilder title = cmp.horizontalList().add(title1, cmp.horizontalGap(20), title2).setStyle(stl.style(10));

        try {
            report().setColumnStyle(Templates.columnStyle)
                    .setColumnTitleStyle(Templates.boldCenteredStyle)
                    .setTitleBackgroundComponent(background1)
                    .setColumnHeaderBackgroundComponent(background2)
                    .setPageFooterBackgroundComponent(background1)
                    .setDetailBackgroundComponent(background3)
                    .columns(col.column("Item", "item", type.stringType()), col.column("Quantity", "quantity", type.integerType()), col.column("Unit price", "unitprice", type.bigDecimalType()),
                             col.column("Order date", "orderdate", type.dateType()))
                    .title(Templates.createTitleComponent("ListBackground"), title)
                    .pageFooter(cmp.pageXofY().setStyle(Templates.boldCenteredStyle))
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
        IntStream.range(0, 30).forEach(i -> dataSource.add("Book", Date.from(Instant.now()), (int) (Math.random() * 10) + 1, BigDecimal.valueOf(Math.random() * 100 + 1)));
        return dataSource;
    }
}

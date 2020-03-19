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
package net.sf.dynamicreports.examples.chart;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.RectangleAnchor;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.Color;
import java.util.stream.IntStream;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>XyBlockChartReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class XyBlockChartReport {

    /**
     * <p>Constructor for XyBlockChartReport.</p>
     */
    public XyBlockChartReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new XyBlockChartReport();
    }

    private void build() {
        FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

        TextColumnBuilder<Integer> xColumn = col.column("X", "x", type.integerType());
        TextColumnBuilder<Integer> yColumn = col.column("Y", "y", type.integerType());
        TextColumnBuilder<Integer> zColumn = col.column("Z", "z", type.integerType());

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(xColumn, yColumn, zColumn)
                    .title(Templates.createTitleComponent("XYBlockChart"))
                    .summary(cht.xyBlockChart(0, 5, Color.WHITE)
                                .setTitle("XY block chart")
                                .setTitleFont(boldFont)
                                .setBlockAnchor(RectangleAnchor.BOTTOM_LEFT)
                                .paintScales(cht.paintScale("Value 1", 1, Color.RED), cht.paintScale("Value 2", 2, Color.GREEN), cht.paintScale("Value 3", 3, Color.BLUE))
                                .setXValue(xColumn)
                                .series(cht.xyzSerie().setYValue(yColumn).setZValue(zColumn))
                                .setXAxisFormat(cht.axisFormat().setLabel("X"))
                                .setYAxisFormat(cht.axisFormat().setLabel("Y")))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("x", "y", "z");
        IntStream.range(0, 10).forEachOrdered(i -> {
            dataSource.add(i, 0, (int) (Math.random() * 4));
            dataSource.add(i, 1, (int) (Math.random() * 4));
        });
        return dataSource;
    }
}

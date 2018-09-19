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

package net.sf.dynamicreports.examples.chart;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>XYAreaChartReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class XYAreaChartReport {

    /**
     * <p>Constructor for XYAreaChartReport.</p>
     */
    public XYAreaChartReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new XYAreaChartReport();
    }

    private void build() {
        FontBuilder boldFont = stl.fontArialBold()
                                  .setFontSize(12);

        TextColumnBuilder<Integer> xColumn = col.column("X", "x", type.integerType());
        TextColumnBuilder<Integer> y1Column = col.column("Y1", "y1", type.integerType());
        TextColumnBuilder<Integer> y2Column = col.column("Y2", "y2", type.integerType());

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(xColumn, y1Column, y2Column)
                    .title(Templates.createTitleComponent("XYAreaChart"))
                    .summary(cht.xyAreaChart()
                                .setTitle("XY area chart")
                                .setTitleFont(boldFont)
                                .setXValue(xColumn)
                                .series(cht.xySerie(y1Column), cht.xySerie(y2Column))
                                .setXAxisFormat(cht.axisFormat()
                                                   .setLabel("X"))
                                .setYAxisFormat(cht.axisFormat()
                                                   .setLabel("Y")))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("x", "y1", "y2");
        for (int i = 0; i < 20; i++) {
            dataSource.add(i, (int) (Math.random() * 10), (int) (Math.random() * 10));
        }
        return dataSource;
    }
}

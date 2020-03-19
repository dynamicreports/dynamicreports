/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.util.Calendar;
import java.util.Date;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>HighLowChartReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class HighLowChartReport {

    /**
     * <p>Constructor for HighLowChartReport.</p>
     */
    public HighLowChartReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new HighLowChartReport();
    }

    private void build() {
        FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

        TextColumnBuilder<String> seriesColumn = col.column("Series", "series", type.stringType());
        TextColumnBuilder<Date> dateColumn = col.column("Date", "date", type.dateType());
        TextColumnBuilder<Double> highColumn = col.column("High", "high", type.doubleType());
        TextColumnBuilder<Double> lowColumn = col.column("Low", "low", type.doubleType());
        TextColumnBuilder<Double> openColumn = col.column("Open", "open", type.doubleType());
        TextColumnBuilder<Double> closeColumn = col.column("Close", "close", type.doubleType());
        TextColumnBuilder<Double> volumeColumn = col.column("Volume", "volume", type.doubleType());

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(seriesColumn, dateColumn, highColumn, lowColumn, openColumn, closeColumn, volumeColumn)
                    .title(Templates.createTitleComponent("HighLowChart"))
                    .summary(cht.highLowChart()
                                .setTitle("HighLow chart")
                                .setTitleFont(boldFont)
                                .setSeries(seriesColumn)
                                .setDate(dateColumn)
                                .setHigh(highColumn)
                                .setLow(lowColumn)
                                .setOpen(openColumn)
                                .setClose(closeColumn)
                                .setVolume(volumeColumn)
                                .setShowOpenTicks(true)
                                .setShowCloseTicks(true)
                                .setTimeAxisFormat(cht.axisFormat().setLabel("Date"))
                                .setValueAxisFormat(cht.axisFormat().setLabel("Value")))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("series", "date", "high", "low", "open", "close", "volume");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -20);
        for (int i = 0; i < 20; i++) {
            dataSource.add("series", c.getTime(), 150 + Math.random() * 50, 20 + Math.random() * 30, 50 + Math.random() * 90, 50 + Math.random() * 110, 50 + Math.random() * 100);
            c.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dataSource;
    }
}

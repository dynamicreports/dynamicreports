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
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.chart.MeterChartBuilder;
import net.sf.dynamicreports.report.constant.MeterShape;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.Color;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>MeterChartReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class MeterChartReport {

    /**
     * <p>Constructor for MeterChartReport.</p>
     */
    public MeterChartReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new MeterChartReport();
    }

    private void build() {
        MeterChartBuilder chart1 = cht.meterChart().setValue(DynamicReports.<Number>field("value", type.integerType())).setShape(MeterShape.DIAL);

        MeterChartBuilder chart2 = cht.meterChart()
                                      .setValue(18)
                                      .setDataRangeHighExpression(30)
                                      .setTickInterval(5d)
                                      .setTickColor(Color.BLACK)
                                      .setNeedleColor(Color.BLACK)
                                      .setValueColor(Color.BLACK)
                                      .setMeterBackgroundColor(Color.LIGHT_GRAY)
                                      .intervals(cht.meterInterval().setLabel("Normal").setBackgroundColor(new Color(150, 255, 150)).setDataRangeLowExpression(0).setDataRangeHighExpression(20),
                                                 cht.meterInterval().setLabel("Warning").setBackgroundColor(new Color(255, 255, 150)).setDataRangeLowExpression(20).setDataRangeHighExpression(25),
                                                 cht.meterInterval().setLabel("Critical").setBackgroundColor(new Color(255, 150, 150)).setDataRangeLowExpression(25).setDataRangeHighExpression(30));

        try {
            report().setTemplate(Templates.reportTemplate)
                    .title(Templates.createTitleComponent("MeterChart"))
                    .summary(cmp.horizontalList(chart1, chart2))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("value");
        dataSource.add(40);
        return dataSource;
    }
}

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
package net.sf.dynamicreports.test.jasper.chart;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.variable;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ChartVariableTest extends AbstractJasperChartTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1 = col.column("Column1", "field1", String.class);
        TextColumnBuilder<Integer> column2 = col.column("Column2", "field2", Integer.class);

        VariableBuilder<Integer> variable = variable(column2, Calculation.SUM);
        rb.columns(column1, column2)
          .summary(cht.barChart()
                      .setCategory(exp.text("category"))
                      .series(cht.serie(column2), cht.serie(variable), cht.serie(variable)), cht.barChart()
                                                                                                .setCategory(exp.text("category"))
                                                                                                .setUseSeriesAsCategory(true)
                                                                                                .series(cht.serie(column2), cht.serie(variable), cht.serie(variable)));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        String[] categories = new String[] {"category"};
        String[] series = new String[] {"Column2", "serie1", "serie2"};

        chartCountTest("summary.chart1", 1);
        chartCategoryCountTest("summary.chart1", 0, 1);
        chartSeriesCountTest("summary.chart1", 0, 3);
        chartDataTest("summary.chart1", 0, categories, series, new Number[][] {{10d, 10, 10}});

        chartCountTest("summary.chart2", 1);
        chartCategoryCountTest("summary.chart2", 0, 3);
        chartSeriesCountTest("summary.chart2", 0, 1);
        chartDataTest("summary.chart2", 0, series, categories, new Number[][] {{10d}, {10}, {10}});
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 4; i++) {
            dataSource.add("value" + (i + 1), i + 1);
        }
        return dataSource;
    }
}

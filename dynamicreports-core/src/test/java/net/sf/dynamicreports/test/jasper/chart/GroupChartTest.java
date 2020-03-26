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
package net.sf.dynamicreports.test.jasper.chart;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.variable;

/**
 * @author Ricardo Mariaca
 */
public class GroupChartTest extends AbstractJasperChartTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1 = col.column("Column1", "field1", String.class);
        TextColumnBuilder<String> column2 = col.column("Column2", "field2", String.class);
        TextColumnBuilder<Integer> column3 = col.column("Column3", "field3", Integer.class);

        VariableBuilder<Integer> column2Variable = variable(column2, Calculation.DISTINCT_COUNT);
        column2Variable.setResetType(Evaluation.FIRST_GROUP);

        rb.columns(column1, column2, column3)
          .groupBy(column1)
          .summary(cht.barChart().setCategory(column1).series(cht.serie(exp.number(1)).setLabel("")), cht.barChart().setCategory(column1).series(cht.serie(column2Variable).setLabel("")));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        String[] categories = new String[] {"value1", "value2"};
        String[] series = new String[] {""};

        chartCountTest("summary.chart1", 1);
        chartCategoryCountTest("summary.chart1", 0, 2);
        chartSeriesCountTest("summary.chart1", 0, 1);
        chartDataTest("summary.chart1", 0, categories, series, new Number[][] {{3d}, {2d}});

        chartCountTest("summary.chart2", 1);
        chartCategoryCountTest("summary.chart2", 0, 2);
        chartSeriesCountTest("summary.chart2", 0, 1);
        chartDataTest("summary.chart2", 0, categories, series, new Number[][] {{2l}, {2l}});
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        dataSource.add("value1", "value1_1", 5);
        dataSource.add("value1", "value1_1", 6);
        dataSource.add("value1", "value1_2", 7);
        dataSource.add("value2", "value2_1", 8);
        dataSource.add("value2", "value2_2", 9);
        return dataSource;
    }
}

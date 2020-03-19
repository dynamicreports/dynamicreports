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
package net.sf.dynamicreports.test.jasper.group;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.PercentageColumnBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.subtotal.PercentageSubtotalBuilder;
import net.sf.dynamicreports.report.constant.PercentageTotalType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;

/**
 * @author Ricardo Mariaca
 */
public class PercentageGroup2Test extends AbstractJasperValueTest {
    private PercentageColumnBuilder percentage1;
    private PercentageColumnBuilder percentage2;
    private PercentageColumnBuilder percentage3;
    private PercentageColumnBuilder percentage4;
    private PercentageSubtotalBuilder subtotal1;
    private PercentageSubtotalBuilder subtotal2;
    private PercentageSubtotalBuilder subtotal3;
    private PercentageSubtotalBuilder subtotal4;
    private PercentageSubtotalBuilder subtotal5;
    private PercentageSubtotalBuilder subtotal6;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1 = col.column("Column1", "field1", String.class);
        TextColumnBuilder<String> column2 = col.column("Column2", "field2", String.class);
        TextColumnBuilder<String> column3 = col.column("Column3", "field3", String.class);
        TextColumnBuilder<Integer> column4 = col.column("Column4", "field4", Integer.class);
        ColumnGroupBuilder group1 = grp.group(column1);
        ColumnGroupBuilder group2 = grp.group(column2);
        ColumnGroupBuilder group3 = grp.group(column3);

        rb.setLocale(Locale.ENGLISH)
          .columns(column1, column2, column3, column4, percentage1 = col.percentageColumn(column4), percentage2 = col.percentageColumn(column4).setTotalGroup(group2),
                   percentage3 = col.percentageColumn(column4).setTotalGroup(group1), percentage4 = col.percentageColumn(column4).setTotalType(PercentageTotalType.REPORT))
          .groupBy(group1, group2, group3)
          .subtotalsOfPercentageAtGroupFooter(group3, subtotal1 = sbt.percentage(column4), subtotal2 = sbt.percentage(column4).setTotalGroup(group1),
                                              subtotal3 = sbt.percentage(column4).setTotalType(PercentageTotalType.REPORT))
          .subtotalsOfPercentageAtGroupFooter(group2, subtotal4 = sbt.percentage(column4), subtotal5 = sbt.percentage(column4).setTotalType(PercentageTotalType.REPORT))
          .subtotalsOfPercentageAtGroupFooter(group1, subtotal6 = sbt.percentage(column4));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(2);
        // percentage1
        columnDetailCountTest(percentage1, 24);
        columnDetailValueTest(percentage1, "16.67%", "33.33%", "50.00%", "26.67%", "33.33%", "40.00%", "29.17%", "33.33%", "37.50%", "30.30%", "33.33%", "36.36%", "30.95%", "33.33%", "35.71%",
                              "31.37%", "33.33%", "35.29%", "31.67%", "33.33%", "35.00%", "31.88%", "33.33%", "34.78%");
        // percentage2
        columnDetailCountTest(percentage2, 24);
        columnDetailValueTest(percentage2, "4.76%", "9.52%", "14.29%", "19.05%", "23.81%", "28.57%", "12.28%", "14.04%", "15.79%", "17.54%", "19.30%", "21.05%", "13.98%", "15.05%", "16.13%", "17.20%",
                              "18.28%", "19.35%", "14.73%", "15.50%", "16.28%", "17.05%", "17.83%", "18.60%");
        // percentage3
        columnDetailCountTest(percentage3, 24);
        columnDetailValueTest(percentage3, "1.28%", "2.56%", "3.85%", "5.13%", "6.41%", "7.69%", "8.97%", "10.26%", "11.54%", "12.82%", "14.10%", "15.38%", "5.86%", "6.31%", "6.76%", "7.21%", "7.66%",
                              "8.11%", "8.56%", "9.01%", "9.46%", "9.91%", "10.36%", "10.81%");
        // percentage4
        columnDetailCountTest(percentage4, 24);
        columnDetailValueTest(percentage4, "0.33%", "0.67%", "1.00%", "1.33%", "1.67%", "2.00%", "2.33%", "2.67%", "3.00%", "3.33%", "3.67%", "4.00%", "4.33%", "4.67%", "5.00%", "5.33%", "5.67%",
                              "6.00%", "6.33%", "6.67%", "7.00%", "7.33%", "7.67%", "8.00%");

        // subtotal1
        subtotalIndexCountTest(subtotal1, 4, 8);
        subtotalIndexValueTest(subtotal1, 4, "28.57%", "71.43%", "42.11%", "57.89%", "45.16%", "54.84%", "46.51%", "53.49%");

        // subtotal2
        subtotalIndexCountTest(subtotal2, 5, 8);
        subtotalIndexValueTest(subtotal2, 5, "7.69%", "19.23%", "30.77%", "42.31%", "18.92%", "22.97%", "27.03%", "31.08%");

        // subtotal3
        subtotalIndexCountTest(subtotal3, 6, 8);
        subtotalIndexValueTest(subtotal3, 6, "2.00%", "5.00%", "8.00%", "11.00%", "14.00%", "17.00%", "20.00%", "23.00%");

        // subtotal4
        subtotalIndexCountTest(subtotal4, 2, 4);
        subtotalIndexValueTest(subtotal4, 2, "26.92%", "73.08%", "41.89%", "58.11%");

        // subtotal5
        subtotalIndexCountTest(subtotal5, 3, 4);
        subtotalIndexValueTest(subtotal5, 3, "7.00%", "19.00%", "31.00%", "43.00%");

        // subtotal6
        subtotalCountTest(subtotal6, 2);
        subtotalValueTest(subtotal6, "26.00%", "74.00%");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4");
        int count = 1;
        for (int i = 1; i <= 3; i++) {
            dataSource.add("group1", "group1_1", "group1_1_1", count++);
        }
        for (int i = 1; i <= 3; i++) {
            dataSource.add("group1", "group1_1", "group1_1_2", count++);
        }
        for (int i = 1; i <= 3; i++) {
            dataSource.add("group1", "group1_2", "group1_2_1", count++);
        }
        for (int i = 1; i <= 3; i++) {
            dataSource.add("group1", "group1_2", "group1_2_2", count++);
        }

        for (int i = 1; i <= 3; i++) {
            dataSource.add("group2", "group2_1", "group2_1_1", count++);
        }
        for (int i = 1; i <= 3; i++) {
            dataSource.add("group2", "group2_1", "group2_1_2", count++);
        }
        for (int i = 1; i <= 3; i++) {
            dataSource.add("group2", "group2_2", "group2_2_1", count++);
        }
        for (int i = 1; i <= 3; i++) {
            dataSource.add("group2", "group2_2", "group2_2_2", count++);
        }
        return dataSource;
    }
}

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
package net.sf.dynamicreports.test.jasper.column;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.builder.column.PercentageColumnBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;

/**
 * @author Ricardo Mariaca
 */
public class PercentageColumnTest extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private PercentageColumnBuilder percentage1;
    private PercentageColumnBuilder percentage2;
    private PercentageColumnBuilder percentage3;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<Integer> column2;

        rb.setLocale(Locale.ENGLISH)
          .fields(field("field1", Integer.class))
          .columns(column2 = col.column("field2", Integer.class), percentage1 = col.percentageColumn("field1", Integer.class), percentage2 = col.percentageColumn(column2),
                   percentage3 = col.percentageColumn("field3", Integer.class).setValueFormatter(new ColumnValueFormatter()));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);
        // percentage1
        columnDetailCountTest(percentage1, 3);
        columnDetailValueTest(percentage1, "16.67%", "33.33%", "50.00%");
        // percentage2
        columnDetailCountTest(percentage2, 3);
        columnDetailValueTest(percentage2, "26.67%", "33.33%", "40.00%");
        // percentage3
        columnDetailCountTest(percentage3, 3);
        columnDetailValueTest(percentage3, "value = 29.17%", "value = 33.33%", "value = 37.50%");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        dataSource.add(1, 4, 7);
        dataSource.add(2, 5, 8);
        dataSource.add(3, 6, 9);
        return dataSource;
    }

    private class ColumnValueFormatter extends AbstractValueFormatter<String, Double> {
        private static final long serialVersionUID = 1L;

        @Override
        public String format(Double value, ReportParameters reportParameters) {
            return "value = " + new DecimalFormat("#,##0.00%", new DecimalFormatSymbols(Locale.ENGLISH)).format(value);
        }
    }
}

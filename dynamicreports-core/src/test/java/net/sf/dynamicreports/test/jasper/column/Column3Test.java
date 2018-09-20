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
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.datatype.DoubleType;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Column3Test extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<Date> column2;
    private TextColumnBuilder<Date> column3;
    private TextColumnBuilder<Double> column4;
    private TextColumnBuilder<BigDecimal> column5;
    private TextColumnBuilder<Double> column6;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.setLocale(Locale.ENGLISH)
          .columnGrid(ListType.HORIZONTAL_FLOW)
          .columns(column1 = col.column("Column1", "field1", type.stringType()), column2 = col.column("Column2", "field2", type.dateType()),
                   column3 = col.column("Column3", "field3", type.dateYearToMinuteType()), column4 = col.column("Column4", "field4", type.doubleType()),
                   column5 = col.column("Column5", "field5", type.bigDecimalType()), column6 = col.column("Column6", "field6", new CustomType()));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);
        // column2
        columnDetailCountTest(column1, 10);
        columnDetailValueTest(column1, 1, "test");
        columnTitleCountTest(column1, 1);
        columnTitleValueTest(column1, "Column1");
        // column2
        columnDetailCountTest(column2, 10);
        columnDetailValueTest(column2, 1, new SimpleDateFormat(type.dateType()
                                                                   .getPattern()).format(new Date()));
        columnTitleCountTest(column2, 1);
        columnTitleValueTest(column2, "Column2");
        // column3
        columnDetailCountTest(column3, 10);
        columnDetailValueTest(column3, 1, new SimpleDateFormat(type.dateYearToMinuteType()
                                                                   .getPattern()).format(new Date()));
        columnTitleCountTest(column3, 1);
        columnTitleValueTest(column3, "Column3");
        // column4
        columnDetailCountTest(column4, 10);
        columnDetailValueTest(column4, 1, "1,000.1");
        columnTitleCountTest(column4, 1);
        columnTitleValueTest(column4, "Column4");
        // column5
        columnDetailCountTest(column5, 10);
        columnDetailValueTest(column5, 1, "10.00");
        columnTitleCountTest(column5, 1);
        columnTitleValueTest(column5, "Column5");
        // column6
        columnDetailCountTest(column6, 10);
        columnDetailValueTest(column6, 1, "value = 1.0");
        columnTitleCountTest(column6, 1);
        columnTitleValueTest(column6, "Column6");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5", "field6");
        for (int i = 0; i < 10; i++) {
            dataSource.add("test", new Date(), new Date(), 1000.1d, new BigDecimal(10), 1d);
        }
        return dataSource;
    }

    private class CustomType extends DoubleType {
        private static final long serialVersionUID = 1L;

        @Override
        public DRIValueFormatter<String, Double> getValueFormatter() {
            return new ColumnValueFormatter();
        }

    }

    private class ColumnValueFormatter extends AbstractValueFormatter<String, Double> {
        private static final long serialVersionUID = 1L;

        @Override
        public String format(Double value, ReportParameters reportParameters) {
            return "value = " + value;
        }
    }
}

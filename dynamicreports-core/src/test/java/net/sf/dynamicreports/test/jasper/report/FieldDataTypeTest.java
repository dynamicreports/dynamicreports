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
package net.sf.dynamicreports.test.jasper.report;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca
 */
public class FieldDataTypeTest extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<BigDecimal> column1;
    private TextColumnBuilder<Integer> column2;
    private TextColumnBuilder<String> column3;
    private TextColumnBuilder<Date> column4;

    private AggregationSubtotalBuilder<BigDecimal> subtotal1;
    private AggregationSubtotalBuilder<Number> subtotal2;
    private AggregationSubtotalBuilder<Long> subtotal3;
    private AggregationSubtotalBuilder<Long> subtotal4;
    private AggregationSubtotalBuilder<BigDecimal> subtotal5;
    private AggregationSubtotalBuilder<BigDecimal> subtotal6;
    private AggregationSubtotalBuilder<BigDecimal> subtotal7;
    private AggregationSubtotalBuilder<Number> subtotal8;
    private AggregationSubtotalBuilder<Number> subtotal9;

    private AggregationSubtotalBuilder<Integer> subtotal10;
    private AggregationSubtotalBuilder<Number> subtotal11;
    private AggregationSubtotalBuilder<Long> subtotal12;
    private AggregationSubtotalBuilder<Long> subtotal13;
    private AggregationSubtotalBuilder<Integer> subtotal14;
    private AggregationSubtotalBuilder<Integer> subtotal15;
    private AggregationSubtotalBuilder<Integer> subtotal16;
    private AggregationSubtotalBuilder<Number> subtotal17;
    private AggregationSubtotalBuilder<Number> subtotal18;

    private AggregationSubtotalBuilder<Long> subtotal19;
    private AggregationSubtotalBuilder<Long> subtotal20;
    private AggregationSubtotalBuilder<String> subtotal21;
    private AggregationSubtotalBuilder<String> subtotal22;
    private AggregationSubtotalBuilder<String> subtotal23;

    private AggregationSubtotalBuilder<Long> subtotal24;
    private AggregationSubtotalBuilder<Long> subtotal25;
    private AggregationSubtotalBuilder<Date> subtotal26;
    private AggregationSubtotalBuilder<Date> subtotal27;
    private AggregationSubtotalBuilder<Date> subtotal28;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        FieldBuilder<BigDecimal> field1;
        FieldBuilder<Integer> field2;
        FieldBuilder<String> field3;
        FieldBuilder<Date> field4;

        rb.setLocale(Locale.ENGLISH)
          .fields(field1 = field("field1", type.bigDecimalType()), field2 = field("field2", type.integerType()), field3 = field("field3", type.stringType()), field4 = field("field4", type.dateType()))
          .columns(column1 = col.column("Column1", field1), column2 = col.column("Column2", field2), column3 = col.column("Column2", field3), column4 = col.column("Column3", field4))
          .subtotalsAtSummary(subtotal1 = sbt.sum(field1, column1), subtotal2 = sbt.avg(field1, column1), subtotal3 = sbt.count(field1, column1), subtotal4 = sbt.distinctCount(field1, column1),
                              subtotal5 = sbt.first(field1, column1), subtotal6 = sbt.min(field1, column1), subtotal7 = sbt.max(field1, column1), subtotal8 = sbt.stdDev(field1, column1),
                              subtotal9 = sbt.var(field1, column1),

                              subtotal10 = sbt.sum(field2, column2), subtotal11 = sbt.avg(field2, column2), subtotal12 = sbt.count(field2, column2), subtotal13 = sbt.distinctCount(field2, column2),
                              subtotal14 = sbt.first(field2, column2), subtotal15 = sbt.min(field2, column2), subtotal16 = sbt.max(field2, column2), subtotal17 = sbt.stdDev(field2, column2),
                              subtotal18 = sbt.var(field2, column2),

                              subtotal19 = sbt.count(field3, column3), subtotal20 = sbt.distinctCount(field3, column3), subtotal21 = sbt.first(field3, column3), subtotal22 = sbt.min(field3, column3),
                              subtotal23 = sbt.max(field3, column3),

                              subtotal24 = sbt.count(field4, column4), subtotal25 = sbt.distinctCount(field4, column4), subtotal26 = sbt.first(field4, column4), subtotal27 = sbt.min(field4, column4),
                              subtotal28 = sbt.max(field4, column4));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // column
        columnDetailCountTest(column1, 5);
        columnDetailValueTest(column1, "1.01", "2.01", "9.01", "11.01", "2.01");
        columnDetailCountTest(column2, 5);
        columnDetailValueTest(column2, "5", "5", "8", "12", "6");
        columnDetailCountTest(column3, 5);
        columnDetailValueTest(column3, "value8", "value2", "value3", "value3", "value1");
        columnDetailCountTest(column4, 5);
        columnDetailValueTest(column4, "01/01/2010", "02/01/2010", "02/01/2010", "03/01/2010", "04/01/2010");

        // summary
        subtotalIndexCountTest(subtotal1, 1, 1);
        subtotalIndexValueTest(subtotal1, 1, "25.05");
        subtotalIndexCountTest(subtotal2, 2, 1);
        subtotalIndexValueTest(subtotal2, 2, "5");
        subtotalIndexCountTest(subtotal3, 3, 1);
        subtotalIndexValueTest(subtotal3, 3, "5");
        subtotalIndexCountTest(subtotal4, 4, 1);
        subtotalIndexValueTest(subtotal4, 4, "4");
        subtotalIndexCountTest(subtotal5, 5, 1);
        subtotalIndexValueTest(subtotal5, 5, "1.01");
        subtotalIndexCountTest(subtotal6, 6, 1);
        subtotalIndexValueTest(subtotal6, 6, "1.01");
        subtotalIndexCountTest(subtotal7, 7, 1);
        subtotalIndexValueTest(subtotal7, 7, "11.01");
        subtotalIndexCountTest(subtotal8, 8, 1);
        subtotalIndexValueTest(subtotal8, 8, "4.1");
        subtotalIndexCountTest(subtotal9, 9, 1);
        subtotalIndexValueTest(subtotal9, 9, "17.2");

        subtotalIndexCountTest(subtotal10, 1, 1);
        subtotalIndexValueTest(subtotal10, 1, "36");
        subtotalIndexCountTest(subtotal11, 2, 1);
        subtotalIndexValueTest(subtotal11, 2, "7.2");
        subtotalIndexCountTest(subtotal12, 3, 1);
        subtotalIndexValueTest(subtotal12, 3, "5");
        subtotalIndexCountTest(subtotal13, 4, 1);
        subtotalIndexValueTest(subtotal13, 4, "4");
        subtotalIndexCountTest(subtotal14, 5, 1);
        subtotalIndexValueTest(subtotal14, 5, "5");
        subtotalIndexCountTest(subtotal15, 6, 1);
        subtotalIndexValueTest(subtotal15, 6, "5");
        subtotalIndexCountTest(subtotal16, 7, 1);
        subtotalIndexValueTest(subtotal16, 7, "12");
        subtotalIndexCountTest(subtotal17, 8, 1);
        subtotalIndexValueTest(subtotal17, 8, "2.6");
        subtotalIndexCountTest(subtotal18, 9, 1);
        subtotalIndexValueTest(subtotal18, 9, "7");

        subtotalIndexCountTest(subtotal19, 1, 1);
        subtotalIndexValueTest(subtotal19, 1, "5");
        subtotalIndexCountTest(subtotal20, 2, 1);
        subtotalIndexValueTest(subtotal20, 2, "4");
        subtotalIndexCountTest(subtotal21, 3, 1);
        subtotalIndexValueTest(subtotal21, 3, "value8");
        subtotalIndexCountTest(subtotal22, 4, 1);
        subtotalIndexValueTest(subtotal22, 4, "value1");
        subtotalIndexCountTest(subtotal23, 5, 1);
        subtotalIndexValueTest(subtotal23, 5, "value8");

        subtotalIndexCountTest(subtotal24, 1, 1);
        subtotalIndexValueTest(subtotal24, 1, "5");
        subtotalIndexCountTest(subtotal25, 2, 1);
        subtotalIndexValueTest(subtotal25, 2, "4");
        subtotalIndexCountTest(subtotal26, 3, 1);
        subtotalIndexValueTest(subtotal26, 3, "01/01/2010");
        subtotalIndexCountTest(subtotal27, 4, 1);
        subtotalIndexValueTest(subtotal27, 4, "01/01/2010");
        subtotalIndexCountTest(subtotal28, 5, 1);
        subtotalIndexValueTest(subtotal28, 5, "04/01/2010");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4");
        dataSource.add(new BigDecimal(1.01), 5, "value8", toDate(2010, 1, 1));
        dataSource.add(new BigDecimal(2.01), 5, "value2", toDate(2010, 2, 1));
        dataSource.add(new BigDecimal(9.01), 8, "value3", toDate(2010, 2, 1));
        dataSource.add(new BigDecimal(11.01), 12, "value3", toDate(2010, 3, 1));
        dataSource.add(new BigDecimal(2.01), 6, "value1", toDate(2010, 4, 1));
        return dataSource;
    }
}

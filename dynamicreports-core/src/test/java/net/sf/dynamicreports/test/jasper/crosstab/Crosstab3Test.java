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
package net.sf.dynamicreports.test.jasper.crosstab;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;

/**
 * @author Ricardo Mariaca
 */
public class Crosstab3Test extends AbstractJasperCrosstabValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private CrosstabRowGroupBuilder<String> rowGroup;
    private CrosstabColumnGroupBuilder<String> columnGroup;
    private CrosstabMeasureBuilder<Integer> measure1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        measure1 = ctab.measure("field3", Integer.class, Calculation.SUM);
        measure1.setValueFormatter(new ValueFormatter1());

        CrosstabBuilder crosstab = ctab.crosstab()
                                       .rowGroups(rowGroup = ctab.rowGroup("field1", String.class).setHeaderValueFormatter(new ValueFormatter2()))
                                       .columnGroups(columnGroup = ctab.columnGroup("field2", String.class).setHeaderValueFormatter(new ValueFormatter2()))
                                       .measures(measure1);

        rb.setLocale(Locale.ENGLISH).summary(crosstab);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        setCrosstabBand("summary");

        // column group
        crosstabGroupHeaderCountTest(columnGroup, 2);
        crosstabGroupHeaderValueTest(columnGroup, "value = c", "value = d");
        crosstabGroupTotalHeaderCountTest(columnGroup, 1);
        crosstabGroupTotalHeaderValueTest(columnGroup, "Total");

        // row group
        crosstabGroupHeaderCountTest(rowGroup, 2);
        crosstabGroupHeaderValueTest(rowGroup, "value = a", "value = b");
        crosstabGroupTotalHeaderCountTest(rowGroup, 1);
        crosstabGroupTotalHeaderValueTest(rowGroup, "Total");

        // measure1
        crosstabCellCountTest(measure1, null, null, 4);
        crosstabCellValueTest(measure1, null, null, "value = 3", "value = 7", "value = 11", "value = 15");
        crosstabCellCountTest(measure1, null, columnGroup, 2);
        crosstabCellValueTest(measure1, null, columnGroup, "value = 10", "value = 26");
        crosstabCellCountTest(measure1, rowGroup, null, 2);
        crosstabCellValueTest(measure1, rowGroup, null, "value = 14", "value = 22");
        crosstabCellCountTest(measure1, rowGroup, columnGroup, 1);
        crosstabCellValueTest(measure1, rowGroup, columnGroup, "value = 36");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        dataSource.add("a", "c", 1);
        dataSource.add("a", "c", 2);
        dataSource.add("a", "d", 3);
        dataSource.add("a", "d", 4);
        dataSource.add("b", "c", 5);
        dataSource.add("b", "c", 6);
        dataSource.add("b", "d", 7);
        dataSource.add("b", "d", 8);
        return dataSource;
    }

    private class ValueFormatter1 extends AbstractValueFormatter<String, Integer> {
        private static final long serialVersionUID = 1L;

        @Override
        public String format(Integer value, ReportParameters reportParameters) {
            return "value = " + value;
        }
    }

    private class ValueFormatter2 extends AbstractValueFormatter<String, String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String format(String value, ReportParameters reportParameters) {
            return "value = " + value;
        }
    }
}

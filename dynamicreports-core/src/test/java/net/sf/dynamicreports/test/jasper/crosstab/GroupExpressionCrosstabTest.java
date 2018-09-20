/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GroupExpressionCrosstabTest extends AbstractJasperCrosstabValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private CrosstabRowGroupBuilder<String> rowGroup;
    private CrosstabColumnGroupBuilder<Integer> columnGroup1;
    private CrosstabColumnGroupBuilder<String> columnGroup2;
    private CrosstabMeasureBuilder<Integer> measure1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        measure1 = ctab.measure("field3", Integer.class, Calculation.SUM);

        CrosstabBuilder crosstab = ctab.crosstab()
                                       .setCellWidth(50)
                                       .rowGroups(rowGroup = ctab.rowGroup("field1", String.class))
                                       .columnGroups(columnGroup1 = ctab.columnGroup(new GroupExpression1()), columnGroup2 = ctab.columnGroup(new GroupExpression2()))
                                       .measures(measure1);

        rb.setLocale(Locale.ENGLISH)
          .setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
          .fields(field("field2", Date.class))
          .summary(crosstab);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        setCrosstabBand("summary");

        // column group 1
        crosstabGroupHeaderCountTest(columnGroup1, 2);
        crosstabGroupHeaderValueTest(columnGroup1, "2010", "2011");
        crosstabGroupTotalHeaderCountTest(columnGroup1, 1);
        crosstabGroupTotalHeaderValueTest(columnGroup1, "Total");

        // column group 2
        crosstabGroupHeaderCountTest(columnGroup2, 5);
        crosstabGroupHeaderValueTest(columnGroup2, "Q1", "Q2", "Q3", "Q4", "Q1");
        crosstabGroupTotalHeaderCountTest(columnGroup2, 2);
        crosstabGroupTotalHeaderValueTest(columnGroup2, "Total", "Total");

        // row group
        crosstabGroupHeaderCountTest(rowGroup, 2);
        crosstabGroupHeaderValueTest(rowGroup, "a", "b");
        crosstabGroupTotalHeaderCountTest(rowGroup, 1);
        crosstabGroupTotalHeaderValueTest(rowGroup, "Total");

        // measure1
        crosstabCellCountTest(measure1, null, null, 10);
        crosstabCellValueTest(measure1, null, null, "6", "15", "24", "33", "27", "39", "30", "21", "12", "3");
        crosstabCellCountTest(measure1, null, columnGroup1, 2);
        crosstabCellValueTest(measure1, null, columnGroup1, "105", "105");
        crosstabCellCountTest(measure1, null, columnGroup2, 4);
        crosstabCellValueTest(measure1, null, columnGroup2, "78", "27", "102", "3");
        crosstabCellCountTest(measure1, rowGroup, null, 5);
        crosstabCellValueTest(measure1, rowGroup, null, "45", "45", "45", "45", "30");
        crosstabCellCountTest(measure1, rowGroup, columnGroup1, 1);
        crosstabCellValueTest(measure1, rowGroup, columnGroup1, "210");
        crosstabCellCountTest(measure1, rowGroup, columnGroup2, 2);
        crosstabCellValueTest(measure1, rowGroup, columnGroup2, "180", "30");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        dataSource.add("a", toDate(2010, 1, 1), 1);
        dataSource.add("a", toDate(2010, 2, 1), 2);
        dataSource.add("a", toDate(2010, 3, 1), 3);
        dataSource.add("a", toDate(2010, 4, 1), 4);
        dataSource.add("a", toDate(2010, 5, 1), 5);
        dataSource.add("a", toDate(2010, 6, 1), 6);
        dataSource.add("a", toDate(2010, 7, 1), 7);
        dataSource.add("a", toDate(2010, 8, 1), 8);
        dataSource.add("a", toDate(2010, 9, 1), 9);
        dataSource.add("a", toDate(2010, 10, 1), 10);
        dataSource.add("a", toDate(2010, 11, 1), 11);
        dataSource.add("a", toDate(2010, 12, 1), 12);
        dataSource.add("a", toDate(2011, 1, 1), 13);
        dataSource.add("a", toDate(2011, 2, 1), 14);

        dataSource.add("b", toDate(2010, 1, 1), 14);
        dataSource.add("b", toDate(2010, 2, 1), 13);
        dataSource.add("b", toDate(2010, 3, 1), 12);
        dataSource.add("b", toDate(2010, 4, 1), 11);
        dataSource.add("b", toDate(2010, 5, 1), 10);
        dataSource.add("b", toDate(2010, 6, 1), 9);
        dataSource.add("b", toDate(2010, 7, 1), 8);
        dataSource.add("b", toDate(2010, 8, 1), 7);
        dataSource.add("b", toDate(2010, 9, 1), 6);
        dataSource.add("b", toDate(2010, 10, 1), 5);
        dataSource.add("b", toDate(2010, 11, 1), 4);
        dataSource.add("b", toDate(2010, 12, 1), 3);
        dataSource.add("b", toDate(2011, 1, 1), 2);
        dataSource.add("b", toDate(2011, 2, 1), 1);
        return dataSource;
    }

    private class GroupExpression1 extends AbstractSimpleExpression<Integer> {
        private static final long serialVersionUID = 1L;

        @Override
        public Integer evaluate(ReportParameters reportParameters) {
            Date date = reportParameters.getValue("field2");
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            return c.get(Calendar.YEAR);
        }
    }

    private class GroupExpression2 extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            Date date = reportParameters.getValue("field2");
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            switch (c.get(Calendar.MONTH)) {
                case 0:
                case 1:
                case 2:
                    return "Q1";
                case 3:
                case 4:
                case 5:
                    return "Q2";
                case 6:
                case 7:
                case 8:
                    return "Q3";
                case 9:
                case 10:
                case 11:
                    return "Q4";
            }
            return null;
        }
    }
}

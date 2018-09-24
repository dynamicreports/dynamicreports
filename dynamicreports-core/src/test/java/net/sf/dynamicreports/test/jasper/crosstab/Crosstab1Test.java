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
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.CrosstabPercentageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Crosstab1Test extends AbstractJasperCrosstabValueTest {
    private CrosstabRowGroupBuilder<String> rowGroup;
    private CrosstabColumnGroupBuilder<String> columnGroup;
    private CrosstabMeasureBuilder<Integer> measure1;
    private CrosstabMeasureBuilder<Double> measure2;
    private CrosstabMeasureBuilder<Double> measure3;
    private CrosstabMeasureBuilder<Double> measure4;
    private CrosstabMeasureBuilder<Integer> measure5;
    private CrosstabMeasureBuilder<Double> measure6;
    private CrosstabMeasureBuilder<Double> measure7;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1 = col.column("Column1", "field1", String.class);
        TextColumnBuilder<String> column2 = col.column("Column2", "field2", String.class);
        TextColumnBuilder<Integer> column3 = col.column("Column3", "field3", Integer.class);
        TextColumnBuilder<Double> column4 = col.column("Column4", "field4", Double.class);
        TextColumnBuilder<String> column5 = col.column("Column5", "field5", String.class);

        measure1 = ctab.measure(column3, Calculation.SUM);
        measure2 = ctab.measure(column3, Calculation.SUM);
        measure2.setPercentageType(CrosstabPercentageType.GRAND_TOTAL);
        measure3 = ctab.measure(column4, Calculation.SUM);
        measure4 = ctab.measure(column4, Calculation.SUM);
        measure4.setPercentageType(CrosstabPercentageType.GRAND_TOTAL);
        measure5 = ctab.measure(column5, Calculation.COUNT);
        measure6 = ctab.measure(column5, Calculation.COUNT);
        measure6.setPercentageType(CrosstabPercentageType.GRAND_TOTAL);
        measure7 = ctab.measure(column4, Calculation.AVERAGE);

        CrosstabBuilder crosstab = ctab.crosstab()
                                       .headerCell(cmp.text("Header"))
                                       .rowGroups(rowGroup = ctab.rowGroup(column1).setTotalHeader("Total for rowgroup"))
                                       .columnGroups(columnGroup = ctab.columnGroup(column2))
                                       .measures(measure1, measure2, measure3, measure4, measure5, measure6, measure7);

        rb.setLocale(Locale.ENGLISH).columns(column1, column2, column3, column4, column5).summary(crosstab);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        setCrosstabBand("summary");

        crosstabHeaderElementCountTest("textField1", 1);
        crosstabHeaderElementValueTest("textField1", "Header");

        // column group
        crosstabGroupHeaderCountTest(columnGroup, 2);
        crosstabGroupHeaderValueTest(columnGroup, "c", "d");
        crosstabGroupTotalHeaderCountTest(columnGroup, 1);
        crosstabGroupTotalHeaderValueTest(columnGroup, "Total");

        // row group
        crosstabGroupHeaderCountTest(rowGroup, 3);
        crosstabGroupHeaderValueTest(rowGroup, "a", "b", "c");
        crosstabGroupTotalHeaderCountTest(rowGroup, 1);
        crosstabGroupTotalHeaderValueTest(rowGroup, "Total for rowgroup");

        // measure1
        crosstabCellCountTest(measure1, null, null, 6);
        crosstabCellValueTest(measure1, null, null, "358", "768", "1,193", "1,602", "1,193", "1,602");
        crosstabCellCountTest(measure1, null, columnGroup, 3);
        crosstabCellValueTest(measure1, null, columnGroup, "1,126", "2,795", "2,795");
        crosstabCellCountTest(measure1, rowGroup, null, 2);
        crosstabCellValueTest(measure1, rowGroup, null, "2,744", "3,972");
        crosstabCellCountTest(measure1, rowGroup, columnGroup, 1);
        crosstabCellValueTest(measure1, rowGroup, columnGroup, "6,716");

        // measure2
        crosstabCellCountTest(measure2, null, null, 6);
        crosstabCellValueTest(measure2, null, null, "5.3", "11.4", "17.8", "23.9", "17.8", "23.9");
        crosstabCellCountTest(measure2, null, columnGroup, 3);
        crosstabCellValueTest(measure2, null, columnGroup, "16.8", "41.6", "41.6");
        crosstabCellCountTest(measure2, rowGroup, null, 2);
        crosstabCellValueTest(measure2, rowGroup, null, "40.9", "59.1");
        crosstabCellCountTest(measure2, rowGroup, columnGroup, 1);
        crosstabCellValueTest(measure2, rowGroup, columnGroup, "100");

        // measure3
        crosstabCellCountTest(measure3, null, null, 6);
        crosstabCellValueTest(measure3, null, null, "5", "9", "13", "17", "13", "17");
        crosstabCellCountTest(measure3, null, columnGroup, 3);
        crosstabCellValueTest(measure3, null, columnGroup, "14", "30", "30");
        crosstabCellCountTest(measure3, rowGroup, null, 2);
        crosstabCellValueTest(measure3, rowGroup, null, "31", "43");
        crosstabCellCountTest(measure3, rowGroup, columnGroup, 1);
        crosstabCellValueTest(measure3, rowGroup, columnGroup, "74");

        // measure4
        crosstabCellCountTest(measure4, null, null, 6);
        crosstabCellValueTest(measure4, null, null, "6.8", "12.2", "17.6", "23", "17.6", "23");
        crosstabCellCountTest(measure4, null, columnGroup, 3);
        crosstabCellValueTest(measure4, null, columnGroup, "18.9", "40.5", "40.5");
        crosstabCellCountTest(measure4, rowGroup, null, 2);
        crosstabCellValueTest(measure4, rowGroup, null, "41.9", "58.1");
        crosstabCellCountTest(measure4, rowGroup, columnGroup, 1);
        crosstabCellValueTest(measure4, rowGroup, columnGroup, "100");

        // measure5
        crosstabCellCountTest(measure5, null, null, 6);
        crosstabCellValueTest(measure5, null, null, "2", "2", "2", "2", "2", "2");
        crosstabCellCountTest(measure5, null, columnGroup, 3);
        crosstabCellValueTest(measure5, null, columnGroup, "4", "4", "4");
        crosstabCellCountTest(measure5, rowGroup, null, 2);
        crosstabCellValueTest(measure5, rowGroup, null, "6", "6");
        crosstabCellCountTest(measure5, rowGroup, columnGroup, 1);
        crosstabCellValueTest(measure5, rowGroup, columnGroup, "12");

        // measure6
        crosstabCellCountTest(measure6, null, null, 6);
        crosstabCellValueTest(measure6, null, null, "16", "16", "16", "16", "16", "16");
        crosstabCellCountTest(measure6, null, columnGroup, 3);
        crosstabCellValueTest(measure6, null, columnGroup, "33", "33", "33");
        crosstabCellCountTest(measure6, rowGroup, null, 2);
        crosstabCellValueTest(measure6, rowGroup, null, "50", "50");
        crosstabCellCountTest(measure6, rowGroup, columnGroup, 1);
        crosstabCellValueTest(measure6, rowGroup, columnGroup, "100");

        // measure7
        crosstabCellCountTest(measure7, null, null, 6);
        crosstabCellValueTest(measure7, null, null, "2.5", "4.5", "6.5", "8.5", "6.5", "8.5");
        crosstabCellCountTest(measure7, null, columnGroup, 3);
        crosstabCellValueTest(measure7, null, columnGroup, "3.5", "7.5", "7.5");
        crosstabCellCountTest(measure7, rowGroup, null, 2);
        crosstabCellValueTest(measure7, rowGroup, null, "5.2", "7.2");
        crosstabCellCountTest(measure7, rowGroup, columnGroup, 1);
        crosstabCellValueTest(measure7, rowGroup, columnGroup, "6.2");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5");
        dataSource.add("a", "c", 106, 2d, "1");
        dataSource.add("a", "c", 252, 3d, "1");
        dataSource.add("a", "d", 312, 4d, "1");
        dataSource.add("a", "d", 456, 5d, "4");
        dataSource.add("b", "c", 515, 6d, "5");
        dataSource.add("b", "c", 678, 7d, "6");
        dataSource.add("b", "d", 779, 8d, "7");
        dataSource.add("b", "d", 823, 9d, "8");
        dataSource.add("c", "c", 515, 6d, "5");
        dataSource.add("c", "c", 678, 7d, "6");
        dataSource.add("c", "d", 779, 8d, "7");
        dataSource.add("c", "d", 823, 9d, "8");
        return dataSource;
    }
}

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
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabPositionTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;

/**
 * @author Ricardo Mariaca
 */
public class CrosstabPosition5Test extends AbstractJasperCrosstabPositionTest {
    private CrosstabRowGroupBuilder<String> rowGroup;
    private CrosstabColumnGroupBuilder<String> columnGroup1;
    private CrosstabColumnGroupBuilder<String> columnGroup2;
    private CrosstabMeasureBuilder<Integer> measure1;
    private CrosstabMeasureBuilder<Double> measure2;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1 = col.column("Column1", "field1", String.class);
        TextColumnBuilder<String> column2 = col.column("Column2", "field1", String.class);
        TextColumnBuilder<String> column3 = col.column("Column3", "field2", String.class);
        TextColumnBuilder<Integer> column4 = col.column("Column4", "field3", Integer.class);
        TextColumnBuilder<Double> column5 = col.column("Column5", "field4", Double.class);

        measure1 = ctab.measure("measure1", column4, Calculation.SUM);
        measure2 = ctab.measure("measure2", column5, Calculation.SUM);

        CrosstabBuilder crosstab = ctab.crosstab()
                                       .headerCell(cmp.text("Header"))
                                       .setCellWidth(100)
                                       .rowGroups(rowGroup = ctab.rowGroup(column1).setHeaderWidth(50))
                                       .columnGroups(columnGroup1 = ctab.columnGroup(column2), columnGroup2 = ctab.columnGroup(column3))
                                       .measures(measure1, measure2);

        rb.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE).summary(crosstab);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        setCrosstabBand("summary");

        crosstabHeaderElementPositionTest("textField1", 0, 0, 0, 50, 48);

        // column group 1
        crosstabGroupHeaderPositionTest(columnGroup1, 0, 0, 0, 300, 16);
        crosstabGroupTotalHeaderPositionTest(columnGroup1, 0, 0, 0, 100, 24);

        crosstabGroupTitleTotalHeaderPositionTest(columnGroup1, measure1, 0, 0, 0, 50, 24);
        crosstabGroupTitleTotalHeaderPositionTest(columnGroup1, measure2, 0, 50, 0, 50, 24);

        // column group 2
        crosstabGroupHeaderPositionTest(columnGroup2, 0, 0, 0, 100, 16);
        crosstabGroupHeaderPositionTest(columnGroup2, 1, 0, 0, 100, 16);
        crosstabGroupTotalHeaderPositionTest(columnGroup2, 0, 0, 0, 100, 16);

        crosstabGroupTitleHeaderPositionTest(columnGroup2, measure1, 0, 0, 0, 50, 16);
        crosstabGroupTitleHeaderPositionTest(columnGroup2, measure2, 0, 50, 0, 50, 16);
        crosstabGroupTitleHeaderPositionTest(columnGroup2, measure1, 1, 0, 0, 50, 16);
        crosstabGroupTitleHeaderPositionTest(columnGroup2, measure2, 1, 50, 0, 50, 16);
        crosstabGroupTitleTotalHeaderPositionTest(columnGroup2, measure1, 0, 0, 0, 50, 16);
        crosstabGroupTitleTotalHeaderPositionTest(columnGroup2, measure2, 0, 50, 0, 50, 16);

        // row group
        crosstabGroupHeaderPositionTest(rowGroup, 0, 0, 0, 50, 16);
        crosstabGroupTotalHeaderPositionTest(rowGroup, 0, 0, 0, 50, 16);

        // measures
        for (int i = 0; i < 2; i++) {
            crosstabCellPositionTest(measure1, null, null, i, 0, 0, 50, 16);
            crosstabCellPositionTest(measure2, null, null, i, 50, 0, 50, 16);
        }
        crosstabCellPositionTest(measure1, null, columnGroup1, 0, 0, 0, 50, 16);
        crosstabCellPositionTest(measure2, null, columnGroup1, 0, 50, 0, 50, 16);
        crosstabCellPositionTest(measure1, null, columnGroup2, 0, 0, 0, 50, 16);
        crosstabCellPositionTest(measure2, null, columnGroup2, 0, 50, 0, 50, 16);
        crosstabCellPositionTest(measure1, rowGroup, null, 0, 0, 0, 50, 16);
        crosstabCellPositionTest(measure2, rowGroup, null, 0, 50, 0, 50, 16);
        crosstabCellPositionTest(measure1, rowGroup, columnGroup1, 0, 0, 0, 50, 16);
        crosstabCellPositionTest(measure2, rowGroup, columnGroup1, 0, 50, 0, 50, 16);
        crosstabCellPositionTest(measure1, rowGroup, columnGroup2, 0, 0, 0, 50, 16);
        crosstabCellPositionTest(measure2, rowGroup, columnGroup2, 0, 50, 0, 50, 16);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4");
        dataSource.add("a", "c", 1, 2d);
        dataSource.add("a", "c", 2, 3d);
        dataSource.add("a", "d", 3, 4d);
        dataSource.add("a", "d", 4, 5d);
        return dataSource;
    }
}

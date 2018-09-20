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
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class CrosstabPosition2Test extends AbstractJasperCrosstabPositionTest {
    private CrosstabRowGroupBuilder<String> rowGroup;
    private CrosstabColumnGroupBuilder<String> columnGroup;
    private CrosstabMeasureBuilder<Integer> measure1;
    private CrosstabMeasureBuilder<Double> measure2;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1 = col.column("Column1", "field1", String.class);
        TextColumnBuilder<String> column2 = col.column("Column2", "field2", String.class);
        TextColumnBuilder<Integer> column3 = col.column("Column3", "field3", Integer.class);
        TextColumnBuilder<Double> column4 = col.column("Column4", "field4", Double.class);

        measure1 = ctab.measure(column3, Calculation.SUM);
        measure2 = ctab.measure(column4, Calculation.SUM);

        CrosstabBuilder crosstab = ctab.crosstab()
                                       .headerCell(cmp.text("Header"))
                                       .rowGroups(rowGroup = ctab.rowGroup(column1))
                                       .columnGroups(columnGroup = ctab.columnGroup(column2))
                                       .measures(measure1, measure2);

        rb.setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
          .columns(column1, column2, column3, column4)
          .summary(crosstab);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        setCrosstabBand("summary");

        crosstabHeaderElementPositionTest("textField1", 0, 0, 0, 100, 16);

        // column group
        crosstabGroupHeaderPositionTest(columnGroup, 0, 0, 0, 150, 16);
        crosstabGroupHeaderPositionTest(columnGroup, 1, 0, 0, 150, 16);
        crosstabGroupTotalHeaderPositionTest(columnGroup, 0, 0, 0, 150, 16);

        // row group
        crosstabGroupHeaderPositionTest(rowGroup, 0, 0, 0, 100, 16);
        crosstabGroupHeaderPositionTest(rowGroup, 1, 0, 0, 100, 16);
        crosstabGroupHeaderPositionTest(rowGroup, 2, 0, 0, 100, 16);
        crosstabGroupTotalHeaderPositionTest(rowGroup, 0, 0, 0, 100, 16);

        // measures
        for (int i = 0; i < 6; i++) {
            crosstabCellPositionTest(measure1, null, null, i, 0, 0, 75, 16);
            crosstabCellPositionTest(measure2, null, null, i, 75, 0, 75, 16);
        }
        for (int i = 0; i < 3; i++) {
            crosstabCellPositionTest(measure1, null, columnGroup, i, 0, 0, 75, 16);
            crosstabCellPositionTest(measure2, null, columnGroup, i, 75, 0, 75, 16);
        }
        for (int i = 0; i < 2; i++) {
            crosstabCellPositionTest(measure1, rowGroup, null, i, 0, 0, 75, 16);
            crosstabCellPositionTest(measure2, rowGroup, null, i, 75, 0, 75, 16);
        }
        crosstabCellPositionTest(measure1, rowGroup, columnGroup, 0, 0, 0, 75, 16);
        crosstabCellPositionTest(measure2, rowGroup, columnGroup, 0, 75, 0, 75, 16);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4");
        dataSource.add("a", "c", 106, 2d);
        dataSource.add("a", "c", 252, 3d);
        dataSource.add("a", "d", 312, 4d);
        dataSource.add("a", "d", 456, 5d);
        dataSource.add("b", "c", 515, 6d);
        dataSource.add("b", "c", 678, 7d);
        dataSource.add("b", "d", 779, 8d);
        dataSource.add("b", "d", 823, 9d);
        dataSource.add("c", "c", 515, 6d);
        dataSource.add("c", "c", 678, 7d);
        dataSource.add("c", "d", 779, 8d);
        dataSource.add("c", "d", 823, 9d);
        return dataSource;
    }
}

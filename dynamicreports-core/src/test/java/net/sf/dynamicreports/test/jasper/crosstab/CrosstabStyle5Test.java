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
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabStyleTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.Color;

import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class CrosstabStyle5Test extends AbstractJasperCrosstabStyleTest {
    private CrosstabRowGroupBuilder<String> rowGroup;
    private CrosstabColumnGroupBuilder<String> columnGroup1;
    private CrosstabColumnGroupBuilder<String> columnGroup2;
    private CrosstabMeasureBuilder<Integer> measure1;
    private CrosstabMeasureBuilder<Integer> measure2;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        FieldBuilder<String> field1 = field("field1", String.class);
        FieldBuilder<String> field2 = field("field2", String.class);

        StyleBuilder headerStyle = stl.style()
                                      .setBackgroundColor(Color.LIGHT_GRAY);
        StyleBuilder cellStyle = stl.style()
                                    .bold();
        StyleBuilder titleStyle = stl.style(cellStyle)
                                     .setBackgroundColor(Color.BLUE);

        rowGroup = ctab.rowGroup(field1)
                       .setHeaderStyle(headerStyle)
                       .setTotalHeaderStyle(headerStyle);
        columnGroup1 = ctab.columnGroup(field1)
                           .setHeaderStyle(headerStyle)
                           .setTotalHeaderStyle(headerStyle);
        columnGroup2 = ctab.columnGroup(field2)
                           .setHeaderStyle(headerStyle)
                           .setTotalHeaderStyle(headerStyle);

        measure1 = ctab.measure("m1", "field3", Integer.class, Calculation.SUM);
        measure1.setTitleStyle(titleStyle);
        measure2 = ctab.measure("m2", "field3", Integer.class, Calculation.SUM);

        CrosstabBuilder crosstab = ctab.crosstab()
                                       .setCellWidth(50)
                                       .highlightEvenRows()
                                       .setGroupTotalStyle(stl.style()
                                                              .setBackgroundColor(Color.RED))
                                       .rowGroups(rowGroup)
                                       .columnGroups(columnGroup1, columnGroup2)
                                       .measures(measure1, measure2);

        rb.summary(crosstab);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        setCrosstabBand("summary");

        crosstabGroupTitleTotalHeaderStyleTest(columnGroup1, measure1, 0, null, Color.BLUE, "Arial", 10f, true, null);
        crosstabGroupTitleTotalHeaderStyleTest(columnGroup1, measure2, 0, null, Color.LIGHT_GRAY, "Arial", 10f, null, null);

        crosstabGroupTitleHeaderStyleTest(columnGroup2, measure1, 0, null, Color.BLUE, "Arial", 10f, true, null);
        crosstabGroupTitleTotalHeaderStyleTest(columnGroup2, measure1, 0, null, Color.BLUE, "Arial", 10f, true, null);
        crosstabGroupTitleHeaderStyleTest(columnGroup2, measure2, 0, null, Color.LIGHT_GRAY, "Arial", 10f, null, null);
        crosstabGroupTitleTotalHeaderStyleTest(columnGroup2, measure2, 0, null, Color.LIGHT_GRAY, "Arial", 10f, null, null);

        crosstabCellStyleTest(measure1, rowGroup, null, 0, null, Color.RED, "Arial", 10f, null, null);
        crosstabCellStyleTest(measure1, rowGroup, null, 1, null, Color.RED, "Arial", 10f, null, null);
        crosstabCellStyleTest(measure1, rowGroup, columnGroup1, 0, null, Color.RED, "Arial", 10f, null, null);
        crosstabCellStyleTest(measure1, rowGroup, columnGroup2, 0, null, Color.RED, "Arial", 10f, null, null);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        dataSource.add("a", "c", 1);
        dataSource.add("a", "c", 2);
        dataSource.add("a", "d", 3);
        dataSource.add("a", "d", 4);
        return dataSource;
    }
}

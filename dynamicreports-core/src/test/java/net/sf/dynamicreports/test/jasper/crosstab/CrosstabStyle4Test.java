/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.test.jasper.crosstab;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
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
public class CrosstabStyle4Test extends AbstractJasperCrosstabStyleTest {
    private CrosstabRowGroupBuilder<String> rowGroup1;
    private CrosstabRowGroupBuilder<String> rowGroup2;
    private CrosstabColumnGroupBuilder<String> columnGroup1;
    private CrosstabColumnGroupBuilder<String> columnGroup2;
    private CrosstabMeasureBuilder<Integer> measure1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        FieldBuilder<String> field1 = field("field1", String.class);
        FieldBuilder<String> field2 = field("field2", String.class);
        FieldBuilder<String> field3 = field("field3", String.class);
        FieldBuilder<String> field4 = field("field4", String.class);

        rowGroup1 = ctab.rowGroup(field1);
        rowGroup2 = ctab.rowGroup(field2);
        columnGroup1 = ctab.columnGroup(field3);
        columnGroup2 = ctab.columnGroup(field4);

        measure1 = ctab.measure("field5", Integer.class, Calculation.SUM);

        CrosstabBuilder crosstab = ctab.crosstab()
                                       .highlightEvenRows()
                                       .setCellWidth(50)
                                       .setEvenRowStyle(stl.simpleStyle()
                                                           .setBackgroundColor(Color.LIGHT_GRAY)
                                                           .bold())
                                       .setGroupStyle(stl.style(1)
                                                         .setBackgroundColor(Color.BLUE)
                                                         .bold())
                                       .setGroupTotalStyle(stl.style(1)
                                                              .setBackgroundColor(Color.RED))
                                       .setGrandTotalStyle(stl.style(1)
                                                              .setBackgroundColor(Color.MAGENTA)
                                                              .bold())
                                       .setCellStyle(stl.style()
                                                        .setBackgroundColor(Color.YELLOW)
                                                        .italic())
                                       .rowGroups(rowGroup1, rowGroup2)
                                       .columnGroups(columnGroup1, columnGroup2)
                                       .measures(measure1);

        rb.summary(crosstab);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        setCrosstabBand("summary");

        Color color1 = new Color(239, 239, 48);
        Color color2 = new Color(239, 48, 239);
        Color color3 = new Color(239, 48, 48);

        crosstabGroupHeaderStyleTest(rowGroup1, 0, null, Color.BLUE, "Arial", 10f, true, null);
        crosstabGroupTotalHeaderStyleTest(rowGroup1, 0, null, Color.MAGENTA, "Arial", 10f, true, null);

        crosstabGroupHeaderStyleTest(rowGroup2, 0, null, Color.BLUE, "Arial", 10f, true, null);
        crosstabGroupTotalHeaderStyleTest(rowGroup2, 0, null, Color.RED, "Arial", 10f, null, null);

        crosstabGroupHeaderStyleTest(columnGroup1, 0, null, Color.BLUE, "Arial", 10f, true, null);
        crosstabGroupTotalHeaderStyleTest(columnGroup1, 0, null, Color.MAGENTA, "Arial", 10f, true, null);

        crosstabGroupHeaderStyleTest(columnGroup2, 0, null, Color.BLUE, "Arial", 10f, true, null);
        crosstabGroupTotalHeaderStyleTest(columnGroup2, 0, null, Color.RED, "Arial", 10f, null, null);

        crosstabCellStyleTest(measure1, null, null, 0, null, Color.YELLOW, "Arial", 10f, null, true);
        crosstabCellStyleTest(measure1, null, null, 1, null, Color.YELLOW, "Arial", 10f, null, true);
        crosstabCellStyleTest(measure1, null, null, 2, null, color1, "Arial", 10f, true, true);
        crosstabCellStyleTest(measure1, null, null, 3, null, color1, "Arial", 10f, true, true);
        crosstabCellStyleTest(measure1, null, null, 4, null, Color.YELLOW, "Arial", 10f, null, true);
        crosstabCellStyleTest(measure1, null, null, 5, null, Color.YELLOW, "Arial", 10f, null, true);
        crosstabCellStyleTest(measure1, null, null, 6, null, color1, "Arial", 10f, true, true);
        crosstabCellStyleTest(measure1, null, null, 7, null, color1, "Arial", 10f, true, true);

        crosstabCellStyleTest(measure1, rowGroup1, null, 0, null, Color.MAGENTA, "Arial", 10f, true, null);
        crosstabCellStyleTest(measure1, rowGroup1, null, 1, null, Color.MAGENTA, "Arial", 10f, true, null);

        crosstabCellStyleTest(measure1, rowGroup2, null, 0, null, Color.RED, "Arial", 10f, null, null);
        crosstabCellStyleTest(measure1, rowGroup2, null, 1, null, Color.RED, "Arial", 10f, null, null);
        crosstabCellStyleTest(measure1, rowGroup2, null, 2, null, Color.RED, "Arial", 10f, null, null);
        crosstabCellStyleTest(measure1, rowGroup2, null, 3, null, Color.RED, "Arial", 10f, null, null);

        crosstabCellStyleTest(measure1, null, columnGroup1, 0, null, Color.MAGENTA, "Arial", 10f, true, null);
        crosstabCellStyleTest(measure1, null, columnGroup1, 1, null, color2, "Arial", 10f, true, null);
        crosstabCellStyleTest(measure1, null, columnGroup1, 2, null, Color.MAGENTA, "Arial", 10f, true, null);
        crosstabCellStyleTest(measure1, null, columnGroup1, 3, null, color2, "Arial", 10f, true, null);

        crosstabCellStyleTest(measure1, null, columnGroup2, 0, null, Color.RED, "Arial", 10f, null, null);
        crosstabCellStyleTest(measure1, null, columnGroup2, 1, null, color3, "Arial", 10f, true, null);
        crosstabCellStyleTest(measure1, null, columnGroup2, 2, null, Color.RED, "Arial", 10f, null, null);
        crosstabCellStyleTest(measure1, null, columnGroup2, 3, null, color3, "Arial", 10f, true, null);

        crosstabCellStyleTest(measure1, rowGroup1, columnGroup1, 0, null, Color.MAGENTA, "Arial", 10f, true, null);
        crosstabCellStyleTest(measure1, rowGroup1, columnGroup2, 0, null, Color.MAGENTA, "Arial", 10f, true, null);

        crosstabCellStyleTest(measure1, rowGroup2, columnGroup1, 0, null, Color.MAGENTA, "Arial", 10f, true, null);
        crosstabCellStyleTest(measure1, rowGroup2, columnGroup2, 0, null, Color.RED, "Arial", 10f, null, null);
        crosstabCellStyleTest(measure1, rowGroup2, columnGroup1, 1, null, Color.MAGENTA, "Arial", 10f, true, null);
        crosstabCellStyleTest(measure1, rowGroup2, columnGroup2, 1, null, Color.RED, "Arial", 10f, null, null);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5");
        dataSource.add("a", "a", "a", "a", 1);
        dataSource.add("a", "b", "a", "b", 1);
        dataSource.add("b", "a", "a", "a", 1);
        dataSource.add("b", "b", "a", "b", 1);
        return dataSource;
    }
}

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
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabPositionTest;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class CrosstabWhenNoDataTest extends AbstractJasperCrosstabPositionTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1 = col.column("Column1", "field1", String.class);
        TextColumnBuilder<String> column2 = col.column("Column2", "field2", String.class);
        TextColumnBuilder<Integer> column3 = col.column("Column3", "field3", Integer.class);
        TextColumnBuilder<Double> column4 = col.column("Column4", "field4", Double.class);

        CrosstabBuilder crosstab = ctab.crosstab()
                                       .whenNoDataCell(cmp.text("text"), cmp.text("text"))
                                       .rowGroups(ctab.rowGroup(column1))
                                       .columnGroups(ctab.columnGroup(column2))
                                       .measures(ctab.measure(column3, Calculation.SUM), ctab.measure(column4, Calculation.SUM));

        rb.setWhenNoDataType(WhenNoDataType.ALL_SECTIONS_NO_DETAIL).columns(column1, column2, column3, column4).summary(crosstab);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        setCrosstabBand("summary");

        crosstabWhenNoDataElementPositionTest("textField1", 0, 0, 0, 575, 16);
        crosstabWhenNoDataElementPositionTest("textField2", 0, 0, 16, 575, 16);
    }
}

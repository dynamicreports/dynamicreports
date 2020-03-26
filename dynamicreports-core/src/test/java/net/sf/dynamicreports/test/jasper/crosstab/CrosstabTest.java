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
package net.sf.dynamicreports.test.jasper.crosstab;

import org.junit.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.test.jasper.AbstractJasperTest;
import net.sf.jasperreports.crosstabs.base.JRBaseCrosstab;
import net.sf.jasperreports.crosstabs.type.CrosstabColumnPositionEnum;
import net.sf.jasperreports.crosstabs.type.CrosstabRowPositionEnum;
import net.sf.jasperreports.engine.type.RunDirectionEnum;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;

/**
 * @author Ricardo Mariaca
 */
public class CrosstabTest extends AbstractJasperTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1 = col.column("Column1", "field1", String.class);
        TextColumnBuilder<String> column2 = col.column("Column2", "field2", String.class);
        TextColumnBuilder<Integer> column3 = col.column("Column3", "field3", Integer.class);

        CrosstabBuilder crosstab = ctab.crosstab()
                                       .setRepeatColumnHeaders(false)
                                       .setRepeatRowHeaders(false)
                                       .setColumnBreakOffset(100)
                                       .setIgnoreWidth(true)
                                       .setRunDirection(RunDirection.RIGHT_TO_LEFT)
                                       .rowGroups(ctab.rowGroup(column1))
                                       .columnGroups(ctab.columnGroup(column2))
                                       .measures(ctab.measure(column3, Calculation.SUM));

        rb.columns(column1, column2, column3).summary(crosstab);
    }

    @Override
    public void test() {
        super.test();

        JRBaseCrosstab crosstab = (JRBaseCrosstab) getJasperReport().getSummary().getElementByKey("summary.crosstab1");
        Assert.assertFalse("Crosstab repeatColumnHeaders", crosstab.isRepeatColumnHeaders());
        Assert.assertFalse("Crosstab repeatRowHeaders", crosstab.isRepeatRowHeaders());
        Assert.assertEquals("Crosstab columnBreakOffset", 100, crosstab.getColumnBreakOffset());
        Assert.assertTrue("Crosstab ignoreWidth", crosstab.getIgnoreWidth());
        Assert.assertEquals("Crosstab runDirection", RunDirectionEnum.RTL, crosstab.getRunDirectionValue());
        Assert.assertEquals("Crosstab row group position", CrosstabRowPositionEnum.STRETCH, crosstab.getRowGroups()[0].getPositionValue());
        Assert.assertEquals("Crosstab column group position", CrosstabColumnPositionEnum.STRETCH, crosstab.getColumnGroups()[0].getPositionValue());
    }
}

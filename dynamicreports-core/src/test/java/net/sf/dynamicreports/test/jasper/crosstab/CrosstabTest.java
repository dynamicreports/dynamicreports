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

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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

/**
 * @author Ricardo Mariaca
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CrosstabTest extends AbstractJasperTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        final TextColumnBuilder<String> column1 = col.column("Column1", "field1", String.class);
        final TextColumnBuilder<String> column2 = col.column("Column2", "field2", String.class);
        final TextColumnBuilder<Integer> column3 = col.column("Column3", "field3", Integer.class);

        final CrosstabBuilder crosstab = ctab.crosstab()
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
    @Test
    public void test() {
        super.test();

        final JRBaseCrosstab crosstab = (JRBaseCrosstab) getJasperReport().getSummary().getElementByKey("summary.crosstab1");
        Assertions.assertFalse(crosstab.isRepeatColumnHeaders(), "Crosstab repeatColumnHeaders");
        Assertions.assertFalse(crosstab.isRepeatRowHeaders(),"Crosstab repeatRowHeaders");
        Assertions.assertEquals(Integer.valueOf(100), crosstab.getColumnBreakOffset(),"Crosstab columnBreakOffset");
        Assertions.assertTrue(crosstab.getIgnoreWidth(),"Crosstab ignoreWidth");
        Assertions.assertEquals(RunDirectionEnum.RTL, crosstab.getRunDirection(),"Crosstab runDirection");
        Assertions.assertEquals(CrosstabRowPositionEnum.STRETCH, crosstab.getRowGroups()[0].getPosition(),"Crosstab row group position");
        Assertions.assertEquals(CrosstabColumnPositionEnum.STRETCH, crosstab.getColumnGroups()[0].getPosition(),"Crosstab column group position");
    }
}

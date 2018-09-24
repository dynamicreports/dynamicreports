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
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabStyleTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.Color;
import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class CrosstabStyle3Test extends AbstractJasperCrosstabStyleTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private CrosstabRowGroupBuilder<String> rowGroup;
    private CrosstabColumnGroupBuilder<String> columnGroup;
    private CrosstabMeasureBuilder<Integer> measure1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        FieldBuilder<String> field1 = field("field1", String.class);
        FieldBuilder<String> field2 = field("field2", String.class);

        rowGroup = ctab.rowGroup(field1).setShowTotal(false);
        columnGroup = ctab.columnGroup(field2).setShowTotal(false);

        measure1 = ctab.measure("field3", Integer.class, Calculation.SUM);

        CrosstabBuilder crosstab = ctab.crosstab().highlightEvenRows().highlightOddRows().rowGroups(rowGroup).columnGroups(columnGroup).measures(measure1);

        rb.summary(crosstab);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        setCrosstabBand("summary");

        Color color1 = new Color(240, 240, 240);
        Color color2 = new Color(200, 200, 200);

        crosstabCellStyleTest(measure1, null, null, 0, Color.BLACK, color2, "Arial", 10f, null, null);
        crosstabCellStyleTest(measure1, null, null, 1, Color.BLACK, color1, "Arial", 10f, null, null);
        crosstabCellStyleTest(measure1, null, null, 2, Color.BLACK, color2, "Arial", 10f, null, null);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        dataSource.add("a", "c", 1);
        dataSource.add("b", "c", 1);
        dataSource.add("c", "c", 1);
        return dataSource;
    }
}

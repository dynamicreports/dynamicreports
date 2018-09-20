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
package net.sf.dynamicreports.test.jasper.datasource;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DatasetBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.desc;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class SortTest extends AbstractJasperChartTest {
    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<String> column2;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        DatasetBuilder dataset = DynamicReports.dataset();
        dataset.setDataSource(createDataSource2());
        FieldBuilder<String> field1 = field("field1", String.class);
        dataset.sortBy(desc(field1));

        rb.columns(column1 = col.column("Column1", "field1", type.stringType()), column2 = col.column("Column2", "field2", type.stringType()))
          .summary(cht.barChart()
                      .setSubDataset(dataset)
                      .setCategory(field1)
                      .series(cht.serie("field2", Integer.class)
                                 .setLabel("f2")))
          .sortBy(column1, column2);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // column1
        columnTitleCountTest(column1, 1);
        columnTitleValueTest(column1, "Column1");
        columnDetailCountTest(column1, 4);
        columnDetailValueTest(column1, "1", "2", "3", "3");
        // column2
        columnTitleCountTest(column2, 1);
        columnTitleValueTest(column2, "Column2");
        columnDetailCountTest(column2, 4);
        columnDetailValueTest(column2, "text1", "text2", "text3", "text4");

        String[] categories = new String[] {"text4", "text3", "text2", "text1"};
        String[] series = new String[] {"f2"};
        Number[][] values = new Number[][] {{6d}, {10d}, {1d}, {3d}};
        chartDataTest("summary.chart1", 0, categories, series, values);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        dataSource.add("3", "text4");
        dataSource.add("1", "text1");
        dataSource.add("3", "text3");
        dataSource.add("2", "text2");
        return dataSource;
    }

    protected JRDataSource createDataSource2() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        dataSource.add("text4", 6);
        dataSource.add("text1", 3);
        dataSource.add("text3", 8);
        dataSource.add("text2", 1);
        dataSource.add("text3", 2);
        return dataSource;
    }
}

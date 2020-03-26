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
package net.sf.dynamicreports.test.jasper.group;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.group.CustomGroupBuilder;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;

/**
 * @author Ricardo Mariaca
 */
public class Group1Test extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private ColumnGroupBuilder group1;
    private ColumnGroupBuilder group2;
    private ColumnGroupBuilder group3;
    private CustomGroupBuilder group4;
    private CustomGroupBuilder group5;
    private ColumnGroupBuilder group6;
    private FieldBuilder<String> field3;
    private TextColumnBuilder<Integer> column2;
    private TextColumnBuilder<String> column3;
    private TextColumnBuilder<Integer> column4;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1;

        rb.setLocale(Locale.ENGLISH)
          .columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class), column3 = col.column("Column3", "field4", String.class),
                   column4 = col.column("Column4", "field5", Integer.class).setPattern("#,###.00"))
          .groupBy(group1 = grp.group(column1), group2 = grp.group(column3).setHeaderLayout(GroupHeaderLayout.EMPTY).setHideColumn(false),
                   group3 = grp.group(column1).setHeaderLayout(GroupHeaderLayout.TITLE_AND_VALUE), group4 = grp.group(field3 = field("field3", String.class)),
                   group5 = grp.group(new ValueExpression()).setTitle("Expression"), group6 = grp.group(column4));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);
        // group1
        groupHeaderTitleCountTest(group1, 0);
        groupHeaderCountTest(group1, 2);
        groupHeaderValueTest(group1, "group1", "group2");
        // group2
        groupHeaderTitleCountTest(group1, 0);
        groupHeaderCountTest(group2, 0);
        // group3
        groupHeaderTitleCountTest(group3, 2);
        groupHeaderTitleValueTest(group3, "Column1", "Column1");
        groupHeaderCountTest(group3, 2);
        groupHeaderValueTest(group3, "group1", "group2");
        // group4
        groupHeaderCountTest(group4, 2);
        groupHeaderValueTest(group4, "group1_1", "group2_1");
        // group5
        groupHeaderTitleCountTest(group5, 2);
        groupHeaderTitleValueTest(group5, "Expression", "Expression");
        groupHeaderCountTest(group5, 2);
        groupHeaderValueTest(group5, "group1_1_1", "group2_1_1");
        // group6
        groupHeaderTitleCountTest(group6, 0);
        groupHeaderCountTest(group6, 2);
        groupHeaderValueTest(group6, "1.00", "2.00");
        // column2
        columnDetailCountTest(column2, 20);
        columnDetailValueTest(column2, "0", "1");
        // column3
        columnDetailCountTest(column3, 20);
        columnDetailValueTest(column3, "group1", "group1");
        columnDetailValueTest(column3, 10, "group2");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3", "field4", "field5");
        for (int i = 0; i < 10; i++) {
            dataSource.add("group1", i, "group1_1", "group1", 1);
        }
        for (int i = 0; i < 10; i++) {
            dataSource.add("group2", i, "group2_1", "group2", 2);
        }
        return dataSource;
    }

    private class ValueExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return reportParameters.getValue(field3) + "_1";
        }
    }
}

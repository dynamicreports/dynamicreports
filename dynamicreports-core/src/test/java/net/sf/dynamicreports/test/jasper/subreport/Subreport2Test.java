/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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
package net.sf.dynamicreports.test.jasper.subreport;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Subreport2Test extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<String> column2;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        SubreportBuilder detailSubreport = cmp.subreport(detailSubreport())
                                              .setDataSource(new SubreportDataSourceExpression());

        rb.title(cmp.subreport(titleSubreport()))
          .detail(detailSubreport);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // title subreport
        columnDetailCountTest(column1, 3);
        columnDetailValueTest(column1, "value1", "value2", "value3");

        // detail subreport
        elementCountTest("title.textField1", 3);
        elementValueTest("title.textField1", "Subreport1", "Subreport2", "Subreport3");

        columnDetailCountTest(column2, 6);
        columnDetailValueTest(column2, "1_1", "1_2", "2_1", "2_2", "3_1", "3_2");
    }

    @Override
    protected JRDataSource createDataSource() {
        return new JREmptyDataSource(3);
    }

    private JasperReportBuilder titleSubreport() {
        JasperReportBuilder report = report();
        column1 = col.column("Column1", "field1", type.stringType());
        report.columns(column1)
              .setDataSource(titleSubreportDataSource());
        return report;
    }

    private JasperReportBuilder detailSubreport() {
        JasperReportBuilder report = report();
        column2 = col.column(new ValueExpression());
        report.columns(column2)
              .title(cmp.text(new SubreportTitleExpression()));
        return report;
    }

    private JRDataSource titleSubreportDataSource() {
        DRDataSource dataSource = new DRDataSource("field1");
        dataSource.add("value1");
        dataSource.add("value2");
        dataSource.add("value3");
        return dataSource;
    }

    private class SubreportDataSourceExpression extends AbstractSimpleExpression<JRDataSource> {
        private static final long serialVersionUID = 1L;

        @Override
        public JRDataSource evaluate(ReportParameters reportParameters) {
            return new JREmptyDataSource(2);
        }
    }

    private class SubreportTitleExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return "Subreport" + reportParameters.getMasterParameters()
                                                 .getReportRowNumber();
        }
    }

    private class ValueExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return reportParameters.getMasterParameters()
                                   .getReportRowNumber() + "_" + reportParameters.getReportRowNumber();
        }
    }
}

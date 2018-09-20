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
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.margin;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Subreport3Test extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        SubreportBuilder subreport1 = cmp.subreport(subreport1());
        subreport1.setDataSource(createSubreport1DataSource());

        rb.fields(field("f1", Integer.class))
          .detail(subreport1);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementCountTest("title.textField1", 6);
        elementValueTest("title.textField1", "1 3", "1 4", "1 5", "2 3", "2 4", "2 5");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("f1");
        dataSource.add(1);
        dataSource.add(2);
        return dataSource;
    }

    private JasperReportBuilder subreport1() {
        SubreportBuilder subreport2 = cmp.subreport(subreport2());

        JasperReportBuilder report = report();
        report.fields(field("f2", Integer.class))
              .setPageMargin(margin(0))
              .detail(subreport2);
        return report;
    }

    public JRDataSource createSubreport1DataSource() {
        DRDataSource dataSource = new DRDataSource("f2");
        dataSource.add(3);
        dataSource.add(4);
        dataSource.add(5);
        return dataSource;
    }

    private JasperReportBuilder subreport2() {
        JasperReportBuilder report = report();
        report.setPageMargin(margin(0))
              .title(cmp.text(new SubreportTitle()));
        return report;
    }

    private class SubreportTitle extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            String result = "";
            result += reportParameters.getMasterParameters()
                                      .getMasterParameters()
                                      .getValue("f1");
            result += " ";
            result += reportParameters.getMasterParameters()
                                      .getValue("f2");
            return result;
        }

    }
}

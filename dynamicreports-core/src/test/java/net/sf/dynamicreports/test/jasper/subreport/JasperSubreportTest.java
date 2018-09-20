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
package net.sf.dynamicreports.test.jasper.subreport;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

import java.io.InputStream;
import java.io.Serializable;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperSubreportTest extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        SubreportBuilder subreport = Components.subreport(new SubreportExpression())
                                               .setDataSource(new SubreportDataSourceExpression());

        rb.detail(subreport);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // title
        elementCountTest("title.textField1", 3);
        elementValueTest("title.textField1", "Subreport1", "Subreport2", "Subreport3");

        // column title
        elementCountTest("columnHeader.column_column1.title1", 3);
        elementValueTest("columnHeader.column_column1.title1", "Column1", "Column1", "Column1");

        elementCountTest("columnHeader.column_column2.title1", 2);
        elementValueTest("columnHeader.column_column2.title1", "Column2", "Column2");

        elementCountTest("columnHeader.column_column3.title1", 1);
        elementValueTest("columnHeader.column_column3.title1", "Column3");

        // column detail
        elementCountTest("detail.column_column11", 6);
        elementValueTest("detail.column_column11", "row1_column1", "row1_column1", "row2_column1", "row1_column1", "row2_column1", "row3_column1");

        elementCountTest("detail.column_column21", 5);
        elementValueTest("detail.column_column21", "row1_column2", "row2_column2", "row1_column2", "row2_column2", "row3_column2");

        elementCountTest("detail.column_column31", 3);
        elementValueTest("detail.column_column31", "row1_column3", "row2_column3", "row3_column3");
    }

    @Override
    protected JRDataSource createDataSource() {
        return new JREmptyDataSource(3);
    }

    private class SubreportExpression extends AbstractSimpleExpression<JasperReport> {
        private static final long serialVersionUID = 1L;

        @Override
        public JasperReport evaluate(ReportParameters reportParameters) {
            try {
                InputStream is = JasperSubreportTest.class.getResourceAsStream("subreport" + reportParameters.getReportRowNumber() + ".jrxml");
                return JasperCompileManager.compileReport(is);
            } catch (JRException e) {
                e.printStackTrace();
                Assert.fail(e.getMessage());
                return null;
            }
        }
    }

    private class SubreportDataSourceExpression extends AbstractSimpleExpression<JRDataSource> {
        private static final long serialVersionUID = 1L;

        @Override
        public JRDataSource evaluate(ReportParameters reportParameters) {
            int masterRowNumber = reportParameters.getReportRowNumber();
            String[] columns = new String[masterRowNumber];
            for (int i = 1; i <= masterRowNumber; i++) {
                columns[i - 1] = "column" + i;
            }
            DRDataSource dataSource = new DRDataSource(columns);

            for (int i = 1; i <= masterRowNumber; i++) {
                Object[] values = new Object[masterRowNumber];
                for (int j = 1; j <= masterRowNumber; j++) {
                    values[j - 1] = "row" + i + "_column" + j;
                }
                dataSource.add(values);
            }

            return dataSource;
        }
    }
}

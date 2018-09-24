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
package net.sf.dynamicreports.test.jasper.component;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperHtmlExporterBuilder;
import net.sf.dynamicreports.report.base.AbstractScriptlet;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.GenericElementBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.jasperreports.engine.JRDataSource;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.export;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GenericElementTest {
    private String data = "";
    private String output;

    @Before
    public void init() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperHtmlExporterBuilder htmlExporter = export.htmlExporter(outputStream);

            JasperReportBuilder reportBuilder = DynamicReports.report();
            configureReport(reportBuilder);
            reportBuilder.setDataSource(createDataSource()).toHtml(htmlExporter);

            output = outputStream.toString();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    protected void configureReport(JasperReportBuilder rb) {
        GenericElementBuilder genericElement = cmp.genericElement("http://www.dynamicreports.org/custom", "custom").addParameter("id", "10").addParameter("data", new ParameterExpression());

        rb.scriptlets(new ReportScriptlet()).fields(field("field1", type.stringType())).summary(genericElement);
    }

    @Test
    public void test() {
        Assert.assertTrue("generic element output", output.indexOf("<div id=\"10\">ABCD</div>") != -1);
    }

    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1");
        dataSource.add("A");
        dataSource.add("B");
        dataSource.add("C");
        dataSource.add("D");
        return dataSource;
    }

    private class ParameterExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return data;
        }
    }

    private class ReportScriptlet extends AbstractScriptlet {

        @Override
        public void afterDetailEval(ReportParameters reportParameters) {
            super.afterDetailEval(reportParameters);
            String name = reportParameters.getValue("field1");
            data += name;
        }
    }
}

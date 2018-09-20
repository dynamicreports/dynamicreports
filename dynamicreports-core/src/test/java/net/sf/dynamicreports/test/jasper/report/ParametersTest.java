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
package net.sf.dynamicreports.test.jasper.report;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ParametersTest extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.title(cmp.text(new TitleExpression()))
          .addParameter("title", String.class);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementValueTest("title.textField1", "");

        try {
            JasperReport jasperReport = getJasperReport();
            JasperPrint jasperPrint = getJasperPrint();
            getReportBuilder().setParameter("title", "1");
            build();
            elementValueTest("title.textField1", "1");
            Assert.assertSame(jasperReport, getJasperReport());
            Assert.assertNotSame(jasperPrint, getJasperPrint());

            jasperReport = getJasperReport();
            jasperPrint = getJasperPrint();
            getReportBuilder().setParameter("title", "2");
            build();
            elementValueTest("title.textField1", "2");
            Assert.assertSame(jasperReport, getJasperReport());
            Assert.assertNotSame(jasperPrint, getJasperPrint());

            jasperReport = getJasperReport();
            jasperPrint = getJasperPrint();
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("title", "3");
            getReportBuilder().setParameters(parameters);
            build();
            elementValueTest("title.textField1", "3");
            Assert.assertSame(jasperReport, getJasperReport());
            Assert.assertNotSame(jasperPrint, getJasperPrint());
        } catch (DRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    private class TitleExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return reportParameters.getValue("title");
        }

    }
}

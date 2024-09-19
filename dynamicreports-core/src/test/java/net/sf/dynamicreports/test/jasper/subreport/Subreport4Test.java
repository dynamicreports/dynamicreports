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
package net.sf.dynamicreports.test.jasper.subreport;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

/**
 * @author Ricardo Mariaca
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Subreport4Test extends AbstractJasperValueTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) throws DRException {
        final Map<String, Object> parameters1 = new HashMap<>();
        parameters1.put("parameter5", "value5");
        parameters1.put("parameter6", "value6");
        final Map<String, Object> parameters2 = new HashMap<>();
        parameters2.put("parameter5", "value7");

        final SubreportBuilder subreport1 = cmp.subreport(subreport1()).setParameters(parameters1);
        final SubreportBuilder subreport2 = cmp.subreport(subreport2()).setParameters(parameters2);

        rb.addParameter("parameter4", "value4").title(subreport1, subreport2);
    }

    @Override
    @Test
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementCountTest("title.textField1", 1);
        elementValueTest("title.textField1", "value1");
        elementCountTest("title.textField2", 1);
        elementValueTest("title.textField2", "value2");
        elementCountTest("title.textField3", 1);
        elementValueTest("title.textField3", "value6");
        elementCountTest("summary.textField1", 2);
        elementValueTest("summary.textField1", "value3", "");
        elementCountTest("summary.textField2", 2);
        elementValueTest("summary.textField2", "value4", "value4");
        elementCountTest("summary.textField3", 2);
        elementValueTest("summary.textField3", "value5", "value7");
    }

    private JasperReportBuilder subreport1() throws DRException {
        final JasperReportBuilder report = report();
        report.addParameter("parameter1", "value1")
              .addParameter("parameter2", String.class)
              .addParameter("parameter6", String.class)
              .setParameter("parameter2", "value2")
              .setParameter("parameter3", "value3")
              .setTemplateDesign(Subreport4Test.class.getResourceAsStream("subreport4.jrxml"))
              .title(cmp.text(exp.jasperSyntax("$P{parameter1}", String.class)), cmp.text(exp.jasperSyntax("$P{parameter2}", String.class)),
                     cmp.text(exp.jasperSyntax("$P{parameter6}", String.class)));
        return report;
    }

    private JasperReport subreport2() {
        try {
            final InputStream is = Subreport4Test.class.getResourceAsStream("subreport4.jrxml");
            return JasperCompileManager.compileReport(is);
        } catch (final JRException e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
            return null;
        }
    }
}

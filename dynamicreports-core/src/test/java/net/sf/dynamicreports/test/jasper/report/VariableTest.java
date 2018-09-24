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
package net.sf.dynamicreports.test.jasper.report;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.variable;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class VariableTest extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        VariableBuilder<Integer> variable1 = variable("field1", Integer.class, Calculation.SUM);
        VariableBuilder<Integer> variable2 = variable(exp.number(5), Calculation.SUM);
        variable2.setInitialValueExpression(exp.jasperSyntax("new Integer(10)"));

        rb.summary(cmp.text(variable1), cmp.text(variable2));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // summary
        elementCountTest("summary.textField1", 1);
        elementValueTest("summary.textField1", "");
        elementCountTest("summary.textField2", 1);
        elementValueTest("summary.textField2", "10");
    }
}

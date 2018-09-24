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
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class NoDetailSectionTest extends AbstractJasperValueTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.title(cmp.text("Empty data"));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);
        elementCountTest("title.textField1", 1);
        elementValueTest("title.textField1", "Empty data");
    }
}

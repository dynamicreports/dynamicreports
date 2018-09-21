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

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class VerticalListTest extends AbstractJasperPositionTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.setPageFormat(PageType.A8)
          .setWhenNoDataType(WhenNoDataType.ALL_SECTIONS_NO_DETAIL)
          .title(cmp.text("text"), cmp.text("text text text text text text text"),
                 cmp.horizontalList(cmp.verticalList(cmp.text("text"), cmp.text("text text text text text text"), cmp.text("text")), cmp.text("text")), cmp.text("text"));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // elementPositionTest("title.list1", 0, 10, 10, 128, 116);
        elementPositionTest("title.list2", 0, 10, 52, 128, 58);
        // elementPositionTest("title.list3", 0, 0, 0, 64, 58);

        elementPositionTest("title.textField1", 0, 10, 10, 128, 16);
        elementPositionTest("title.textField2", 0, 10, 26, 128, 26);
        elementPositionTest("title.textField3", 0, 0, 0, 64, 16);
        elementPositionTest("title.textField4", 0, 0, 16, 64, 26);
        elementPositionTest("title.textField5", 0, 0, 42, 64, 16);
        elementPositionTest("title.textField6", 0, 64, 0, 64, 58);
        elementPositionTest("title.textField7", 0, 10, 110, 128, 16);
    }
}

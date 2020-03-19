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
package net.sf.dynamicreports.test.jasper.component;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Ricardo Mariaca
 */
public class List2Test extends AbstractJasperPositionTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        VerticalListBuilder list1 = cmp.verticalList();
        list1.add(cmp.text(""));

        VerticalListBuilder list2 = cmp.verticalList();
        list2.add(cmp.text(""));
        list2.add(cmp.filler().setFixedWidth(500));

        VerticalListBuilder list3 = cmp.verticalList();
        list3.add(cmp.text(""));

        VerticalListBuilder list4 = cmp.verticalList();
        list4.add(cmp.text(""));
        list4.add(cmp.filler().setFixedWidth(50));

        VerticalListBuilder list5 = cmp.verticalList();
        list5.add(cmp.text(""));

        VerticalListBuilder list6 = cmp.verticalList();
        list6.add(cmp.text(""));
        list6.add(cmp.filler().setFixedWidth(200));
        list6.add(cmp.text(""));
        list6.add(cmp.filler().setFixedWidth(500));

        rb.title(cmp.horizontalList(list1, list2), cmp.horizontalList(list3, list4), cmp.horizontalList(list5, list6));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementPositionTest("title.textField1", 0, 0, 0, 75, 16);
        elementPositionTest("title.textField2", 0, 75, 0, 500, 16);

        elementPositionTest("title.textField3", 0, 0, 0, 287, 16);
        elementPositionTest("title.textField4", 0, 287, 0, 288, 16);

        elementPositionTest("title.textField5", 0, 0, 0, 75, 32);
        elementPositionTest("title.textField6", 0, 75, 0, 500, 16);
        elementPositionTest("title.textField7", 0, 75, 16, 500, 16);
    }
}

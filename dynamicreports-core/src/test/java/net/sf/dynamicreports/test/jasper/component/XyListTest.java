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
import net.sf.dynamicreports.report.builder.component.XyListBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca
 */
public class XyListTest extends AbstractJasperPositionTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        StyleBuilder style = stl.style(stl.pen1Point());

        XyListBuilder list1 = cmp.xyList();
        list1.add(10, 10, cmp.text(""));
        list1.add(50, 15, cmp.text(""));

        XyListBuilder list2 = cmp.xyList().setStyle(style);
        list2.add(10, 10, cmp.text(""));
        list2.add(50, 15, cmp.text(""));
        list2.add(200, 5, cmp.horizontalList(cmp.text(""), cmp.text("")).setWidth(100));
        list2.add(350, 5, cmp.verticalList(cmp.text(""), cmp.text("")).setWidth(150));

        XyListBuilder list3 = cmp.xyList();
        list3.add(10, 10, cmp.horizontalList(cmp.text("").setWidth(50), cmp.text("")).newRow().add(cmp.text("")));
        list3.add(200, 10, cmp.xyList().add(5, 5, cmp.horizontalList(cmp.text(""), cmp.text(""))));

        XyListBuilder list4 = cmp.xyList().setStyle(style).setFixedWidth(250);
        list4.add(100, 10, cmp.xyList().setStyle(style).add(5, 5, cmp.verticalList(cmp.text(""), cmp.text(""))));

        rb.title(list1, list2, list3, list4);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementPositionTest("title.textField1", 0, 20, 20, 100, 16);
        elementPositionTest("title.textField2", 0, 60, 25, 100, 16);

        elementPositionTest("title.list3", 0, 10, 41, 575, 37);
        elementPositionTest("title.textField3", 0, 10, 10, 100, 16);
        elementPositionTest("title.textField4", 0, 50, 15, 100, 16);
        elementPositionTest("title.list4", 0, 200, 5, 100, 16);
        elementPositionTest("title.textField5", 0, 0, 0, 50, 16);
        elementPositionTest("title.textField6", 0, 50, 0, 50, 16);
        elementPositionTest("title.textField7", 0, 350, 5, 150, 16);
        elementPositionTest("title.textField8", 0, 350, 21, 150, 16);

        elementPositionTest("title.list8", 0, 20, 88, 150, 16);
        elementPositionTest("title.textField9", 0, 0, 0, 50, 16);
        elementPositionTest("title.textField10", 0, 50, 0, 100, 16);
        elementPositionTest("title.textField11", 0, 20, 104, 150, 16);
        elementPositionTest("title.list9", 0, 215, 93, 200, 16);
        elementPositionTest("title.textField12", 0, 0, 0, 100, 16);
        elementPositionTest("title.textField13", 0, 100, 0, 100, 16);

        elementPositionTest("title.list10", 0, 10, 120, 250, 47);
        elementPositionTest("title.list11", 0, 100, 10, 105, 37);
        elementPositionTest("title.textField14", 0, 5, 5, 100, 16);
        elementPositionTest("title.textField15", 0, 5, 21, 100, 16);
    }
}

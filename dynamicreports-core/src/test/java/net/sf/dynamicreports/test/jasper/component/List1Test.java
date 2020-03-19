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
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca
 */
public class List1Test extends AbstractJasperPositionTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        StyleBuilder style = stl.style().setPadding(10);

        rb.setWhenNoDataType(WhenNoDataType.ALL_SECTIONS_NO_DETAIL)
          .setTextStyle(stl.style().setPadding(1))
          .title(cmp.horizontalList()
                    .setBaseStyle(style)
                    .setBaseGap(2)
                    .setGap(5)
                    .add(cmp.verticalList()
                            .setStyle(style)
                            .add(cmp.vListCell(cmp.text("").setWidth(50)).heightFixed())
                            .add(10, cmp.vListCell(cmp.text("").setWidth(50)).heightFixed(), cmp.vListCell(cmp.text("").setWidth(50)).heightFixed())
                            .add(cmp.vListCell(cmp.text("").setWidth(50)).heightFixed())
                            .add(cmp.filler())
                            .add(cmp.vListCell(cmp.text("").setWidth(50)).heightFixed()))
                    .add(cmp.hListCell(cmp.verticalList()
                                          .setStyle(stl.style().setPadding(stl.padding().setLeft(2).setRight(4).setTop(6).setBottom(8)))
                                          .setGap(5)
                                          .add(cmp.vListCell(cmp.text("").setWidth(10)).widthFixedOnCenter().heightFixed())
                                          .add(cmp.text(""), cmp.horizontalList().setStyle(style).add(cmp.text(""), cmp.text("")).add(5, cmp.text("").setWidth(50)), cmp.text(""))
                                          .add(cmp.vListCell(cmp.horizontalList(cmp.text(""), cmp.text("")).setStyle(style)).widthFixedOnCenter().heightFixed())).widthFixed().heightFixedOnMiddle())
                    .add(cmp.verticalList()
                            .setStyle(style)
                            .add(cmp.text(""))
                            .add(cmp.vListCell(cmp.text("").setHeight(30).setWidth(50)), cmp.vListCell(cmp.text("").setWidth(50)).heightFixed(),
                                 cmp.vListCell(cmp.text("").setWidth(50)).widthFixedOnLeft().heightFixed(), cmp.vListCell(cmp.text("").setWidth(50)).widthFixedOnLeft(),
                                 cmp.vListCell(cmp.text("").setWidth(50)).widthFixedOnCenter().heightFixed(), cmp.vListCell(cmp.text("").setWidth(50)).widthFixedOnCenter(),
                                 cmp.vListCell(cmp.text("").setWidth(50)).widthFixedOnRight().heightFixed(), cmp.vListCell(cmp.text("").setWidth(50)).widthFixedOnRight()))
                    .add(cmp.text("").setWidth(20).setHeight(200))

                    .newRow(10)
                    .add(cmp.text(""))

                    .newRow()
                    .add(cmp.hListCell(cmp.text("")).widthFixed().heightFixedOnMiddle())
                    .add(cmp.filler())
                    .add(cmp.filler())
                    .add(cmp.hListCell(cmp.text("")).widthFixed().heightFixedOnMiddle())

                    .newRow()
                    .add(cmp.text("").setWidth(50).setHeight(50))
                    .add(cmp.text("").setWidth(50))
                    .add(cmp.hListCell(cmp.text("").setWidth(50)).widthFixed())
                    .add(cmp.hListCell(cmp.text("").setWidth(50)).widthFixed().heightFixedOnTop())
                    .add(cmp.hListCell(cmp.text("").setWidth(50)).heightFixedOnTop())
                    .add(cmp.hListCell(cmp.verticalList(cmp.text("").setWidth(50), cmp.text("").setWidth(50)).setStyle(style)).widthFixed().heightFixedOnMiddle())
                    .add(cmp.hListCell(cmp.text("").setWidth(50)).heightFixedOnMiddle())
                    .add(cmp.hListCell(cmp.text("").setWidth(50)).widthFixed().heightFixedOnBottom())
                    .add(cmp.hListCell(cmp.text("").setWidth(50)).heightFixedOnBottom())

                    .newFlowRow()
                    .setGap(5)
                    .setStyle(style)
                    .add(cmp.text(""), cmp.text(""), cmp.text(""), cmp.text(""), cmp.text(""), cmp.text("").setWidth(500), cmp.text(""), cmp.text(""))
                    .newRow()
                    .add(cmp.text(""), cmp.text(""), cmp.text(""))
                    .add(cmp.hListCell(cmp.text("")).widthFixed())
                    .add(cmp.hListCell(cmp.text("")).widthExpand())
                    .add(cmp.text(""), cmp.text(""), cmp.text(""))
                    .newRow()
                    .add(cmp.text(""))
                    .add(cmp.verticalList().add(cmp.vListCell(cmp.text("")).widthFixedOnCenter(), cmp.vListCell(cmp.text("")).widthFixedOnCenter()))
                    .add(cmp.text("")));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);
        elementPositionTest("title.list1", 0, 10, 10, 575, 426);

        elementPositionTest("title.list2", 0, 0, 0, 555, 200);
        elementPositionTest("title.list3", 0, 0, 0, 86, 200);
        elementPositionTest("title.textField1", 0, 0, 0, 66, 14);
        elementPositionTest("title.textField2", 0, 0, 24, 66, 14);
        elementPositionTest("title.textField3", 0, 0, 48, 66, 14);
        elementPositionTest("title.textField4", 0, 0, 62, 66, 14);
        elementPositionTest("title.textField5", 0, 0, 166, 66, 14);

        elementPositionTest("title.list4", 0, 91, 28, 281, 144);
        elementPositionTest("title.textField6", 0, 132, 0, 10, 14);
        elementPositionTest("title.textField7", 0, 0, 19, 275, 14);

        elementPositionTest("title.list5", 0, 0, 38, 275, 34);
        elementPositionTest("title.textField8", 0, 0, 0, 100, 14);
        elementPositionTest("title.textField9", 0, 100, 0, 100, 14);
        elementPositionTest("title.textField10", 0, 205, 0, 50, 14);

        elementPositionTest("title.textField11", 0, 0, 77, 275, 14);

        elementPositionTest("title.list6", 0, 27, 96, 220, 34);
        elementPositionTest("title.textField12", 0, 0, 0, 100, 14);
        elementPositionTest("title.textField13", 0, 100, 0, 100, 14);

        elementPositionTest("title.list7", 0, 377, 0, 148, 200);
        elementPositionTest("title.textField14", 0, 0, 0, 128, 20);
        elementPositionTest("title.textField15", 0, 0, 20, 128, 43);
        elementPositionTest("title.textField16", 0, 0, 63, 128, 14);
        elementPositionTest("title.textField17", 0, 0, 77, 50, 14);
        elementPositionTest("title.textField18", 0, 0, 91, 50, 20);
        elementPositionTest("title.textField19", 0, 39, 111, 50, 14);
        elementPositionTest("title.textField20", 0, 39, 125, 50, 20);
        elementPositionTest("title.textField21", 0, 78, 145, 50, 14);
        elementPositionTest("title.textField22", 0, 78, 159, 50, 21);

        elementPositionTest("title.textField23", 0, 530, 0, 25, 200);
        elementPositionTest("title.textField24", 0, 0, 214, 555, 14);

        elementPositionTest("title.list8", 0, 0, 230, 555, 14);
        elementPositionTest("title.textField25", 0, 0, 0, 100, 14);
        elementPositionTest("title.textField26", 0, 455, 0, 100, 14);

        elementPositionTest("title.list9", 0, 0, 246, 555, 50);
        elementPositionTest("title.textField27", 0, 0, 0, 67, 50);
        elementPositionTest("title.textField28", 0, 67, 0, 67, 50);
        elementPositionTest("title.textField29", 0, 134, 0, 50, 50);
        elementPositionTest("title.textField30", 0, 184, 0, 50, 14);
        elementPositionTest("title.textField31", 0, 234, 0, 67, 14);

        elementPositionTest("title.list10", 0, 301, 1, 70, 48);
        elementPositionTest("title.textField32", 0, 0, 0, 50, 14);
        elementPositionTest("title.textField33", 0, 0, 14, 50, 14);

        elementPositionTest("title.textField34", 0, 371, 18, 67, 14);
        elementPositionTest("title.textField35", 0, 438, 36, 50, 14);
        elementPositionTest("title.textField36", 0, 488, 36, 67, 14);

        elementPositionTest("title.list11", 0, 0, 298, 555, 62);
        // elementPositionTest("title.list12", 0, 0, 0, 535, 42);
        elementPositionTest("title.list13", 0, 0, 0, 535, 14);
        elementPositionTest("title.textField37", 0, 0, 0, 103, 14);
        elementPositionTest("title.textField38", 0, 108, 0, 103, 14);
        elementPositionTest("title.textField39", 0, 216, 0, 103, 14);
        elementPositionTest("title.textField40", 0, 324, 0, 103, 14);
        elementPositionTest("title.textField41", 0, 432, 0, 103, 14);

        elementPositionTest("title.textField42", 0, 0, 14, 535, 14);

        elementPositionTest("title.list14", 0, 0, 28, 535, 14);
        elementPositionTest("title.textField43", 0, 0, 0, 265, 14);
        elementPositionTest("title.textField44", 0, 270, 0, 265, 14);

        elementPositionTest("title.list15", 0, 0, 362, 555, 14);
        elementPositionTest("title.textField45", 0, 0, 0, 59, 14);
        elementPositionTest("title.textField46", 0, 59, 0, 59, 14);
        elementPositionTest("title.textField47", 0, 118, 0, 59, 14);
        elementPositionTest("title.textField48", 0, 177, 0, 100, 14);
        elementPositionTest("title.textField49", 0, 277, 0, 100, 14);
        elementPositionTest("title.textField50", 0, 377, 0, 59, 14);
        elementPositionTest("title.textField51", 0, 436, 0, 59, 14);
        elementPositionTest("title.textField52", 0, 495, 0, 60, 14);

        elementPositionTest("title.list16", 0, 0, 378, 555, 28);
        elementPositionTest("title.textField53", 0, 0, 0, 227, 28);
        // elementPositionTest("title.list17", 0, 227, 0, 100, 28);
        elementPositionTest("title.textField54", 0, 227, 0, 100, 14);
        elementPositionTest("title.textField55", 0, 227, 14, 100, 14);
        elementPositionTest("title.textField56", 0, 327, 0, 228, 28);
    }
}

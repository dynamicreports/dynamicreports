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

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.constant.LineDirection;
import net.sf.dynamicreports.test.jasper.AbstractJasperPositionTest;
import net.sf.jasperreports.engine.JRPrintLine;
import net.sf.jasperreports.engine.JRPrintRectangle;
import net.sf.jasperreports.engine.type.LineDirectionEnum;

/**
 * @author Ricardo Mariaca
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Component2Test extends AbstractJasperPositionTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.title(cmp.horizontalList(cmp.line(), cmp.filler().setFixedWidth(10), cmp.line()),
                 cmp.horizontalList(cmp.line().setFixedDimension(1, 50), cmp.line().setDirection(LineDirection.TOP_DOWN), cmp.line().setDirection(LineDirection.BOTTOM_UP)), cmp.ellipse(),
                 cmp.rectangle(), cmp.roundRectangle(), cmp.roundRectangle(20), cmp.verticalGap(30), cmp.horizontalList(cmp.text(""), cmp.horizontalGap(10), cmp.text("")),
                 cmp.centerHorizontal(cmp.text("").setFixedWidth(50)), cmp.centerHorizontal(cmp.text("").setFixedWidth(50)).setFixedWidth(250),
                 cmp.horizontalList(cmp.centerVertical(cmp.text("").setFixedRows(1)), cmp.text("").setFixedRows(3)), cmp.centerVertical(cmp.text("").setFixedRows(1)).setFixedHeight(50));
    }

    @Override
    @Test
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementPositionTest("title.line1", 0, 0, 0, 282, 1);
        elementPositionTest("title.line2", 0, 292, 0, 283, 1);
        elementPositionTest("title.line3", 0, 0, 0, 1, 50);
        elementPositionTest("title.line4", 0, 1, 0, 287, 50);
        elementPositionTest("title.line5", 0, 288, 0, 287, 50);

        JRPrintLine line = (JRPrintLine) getElementAt("title.line4", 0);
        Assertions.assertEquals(LineDirectionEnum.TOP_DOWN, line.getDirection(),"Line direction");
        line = (JRPrintLine) getElementAt("title.line5", 0);
        Assertions.assertEquals(LineDirectionEnum.BOTTOM_UP, line.getDirection(),"Line direction");

        elementPositionTest("title.ellipse1", 0, 10, 61, 575, 100);
        elementPositionTest("title.rectangle1", 0, 10, 161, 575, 100);
        elementPositionTest("title.rectangle2", 0, 10, 261, 575, 100);
        elementPositionTest("title.rectangle3", 0, 10, 361, 575, 100);

        JRPrintRectangle rectangle = (JRPrintRectangle) getElementAt("title.rectangle1", 0);
        Assertions.assertEquals(0, rectangle.getRadius(),"Rectangle radius");
        rectangle = (JRPrintRectangle) getElementAt("title.rectangle2", 0);
        Assertions.assertEquals(10, rectangle.getRadius(),"Rectangle radius");
        rectangle = (JRPrintRectangle) getElementAt("title.rectangle3", 0);
        Assertions.assertEquals(20, rectangle.getRadius(),"Rectangle radius");

        elementPositionTest("title.list4", 0, 10, 491, 575, 16);
        elementPositionTest("title.textField1", 0, 0, 0, 282, 16);
        elementPositionTest("title.textField2", 0, 292, 0, 283, 16);

        elementPositionTest("title.textField3", 0, 262, 0, 50, 16);
        elementPositionTest("title.textField4", 0, 100, 0, 50, 16);

        elementPositionTest("title.textField5", 0, 0, 11, 287, 16);
        elementPositionTest("title.textField6", 0, 287, 0, 288, 39);
        elementPositionTest("title.textField7", 0, 10, 595, 575, 16);
    }
}

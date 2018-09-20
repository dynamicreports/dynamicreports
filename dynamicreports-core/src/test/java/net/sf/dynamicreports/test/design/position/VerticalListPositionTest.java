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
package net.sf.dynamicreports.test.design.position;

import junit.framework.Assert;
import net.sf.dynamicreports.design.base.DRDesignBand;
import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.base.component.DRDesignTextField;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.test.design.AbstractBandTest;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class VerticalListPositionTest extends AbstractBandTest {

    @Override
    public void configureReport(ReportBuilder<?> rb) {
        rb.title(cmp.horizontalList(cmp.verticalList(cmp.vListCell(cmp.text("")), cmp.vListCell(cmp.text(""))
                                                                                     .heightFixed(), cmp.vListCell(cmp.text(""))
                                                                                                        .widthFixedOnLeft()
                                                                                                        .heightFixed(), cmp.vListCell(cmp.text(""))
                                                                                                                           .widthFixedOnLeft(), cmp.vListCell(cmp.text(""))
                                                                                                                                                   .widthFixedOnCenter()
                                                                                                                                                   .heightFixed(), cmp.vListCell(cmp.text(""))
                                                                                                                                                                      .widthFixedOnCenter(),
                                                     cmp.vListCell(cmp.text(""))
                                                        .widthFixedOnRight()
                                                        .heightFixed(), cmp.vListCell(cmp.text(""))
                                                                           .widthFixedOnRight()), cmp.filler()
                                                                                                     .setHeight(200)));
    }

    @Override
    protected void titleBandTest(DRDesignBand band) {
        DRDesignComponent component = band.getBandComponent();
        Assert.assertTrue(component instanceof DRDesignList);
        DRDesignList list = (DRDesignList) component;
        Assert.assertEquals(ListType.HORIZONTAL, list.getType());
        Assert.assertEquals(1, list.getComponents()
                                   .size());
        componentPositionTest(list, 0, 0, 575, 200);
        Assert.assertTrue(list.getComponents()
                              .get(0) instanceof DRDesignList);

        list = (DRDesignList) list.getComponents()
                                  .get(0);
        Assert.assertEquals(ListType.VERTICAL, list.getType());
        Assert.assertEquals(8, list.getComponents()
                                   .size());
        componentPositionTest(list, 0, 0, 575, 200);
        for (int i = 0; i < 8; i++) {
            Assert.assertTrue(list.getComponents()
                                  .get(i) instanceof DRDesignTextField);
        }

        componentPositionTest(list.getComponents()
                                  .get(0), 0, 0, 575, 34);
        componentPositionTest(list.getComponents()
                                  .get(1), 0, 34, 575, 16);
        componentPositionTest(list.getComponents()
                                  .get(2), 0, 50, 100, 16);
        componentPositionTest(list.getComponents()
                                  .get(3), 0, 66, 100, 34);
        componentPositionTest(list.getComponents()
                                  .get(4), 237, 100, 100, 16);
        componentPositionTest(list.getComponents()
                                  .get(5), 237, 116, 100, 34);
        componentPositionTest(list.getComponents()
                                  .get(6), 475, 150, 100, 16);
        componentPositionTest(list.getComponents()
                                  .get(7), 475, 166, 100, 34);
    }
}

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

import org.junit.Assert;
import net.sf.dynamicreports.design.base.DRDesignBand;
import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.base.component.DRDesignTextField;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.test.design.AbstractBandTest;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class HorizontalListPositionTest extends AbstractBandTest {

    @Override
    public void configureReport(ReportBuilder<?> rb) {
        rb.setPageFormat(PageType.A2)
          .title(cmp.horizontalList(cmp.hListCell(cmp.text("").setHeight(23)), cmp.hListCell(cmp.text("")), cmp.hListCell(cmp.text("")).widthFixed(),
                                    cmp.hListCell(cmp.text("")).widthFixed().heightFixedOnTop(), cmp.hListCell(cmp.text("")).heightFixedOnTop(),
                                    cmp.hListCell(cmp.text("")).widthFixed().heightFixedOnMiddle(), cmp.hListCell(cmp.text("")).heightFixedOnMiddle(),
                                    cmp.hListCell(cmp.text("")).widthFixed().heightFixedOnBottom(), cmp.hListCell(cmp.text("")).heightFixedOnBottom()));
    }

    @Override
    protected void titleBandTest(DRDesignBand band) {
        DRDesignComponent component = band.getBandComponent();
        Assert.assertTrue(component instanceof DRDesignList);
        DRDesignList list = (DRDesignList) component;
        Assert.assertEquals(ListType.HORIZONTAL, list.getType());
        Assert.assertEquals(9, list.getComponents().size());
        componentPositionTest(list, 0, 0, 1170, 23);
        for (int i = 0; i < 9; i++) {
            Assert.assertTrue(list.getComponents().get(i) instanceof DRDesignTextField);
        }

        componentPositionTest(list.getComponents().get(0), 0, 0, 154, 23);
        componentPositionTest(list.getComponents().get(1), 154, 0, 154, 23);
        componentPositionTest(list.getComponents().get(2), 308, 0, 100, 23);
        componentPositionTest(list.getComponents().get(3), 408, 0, 100, 16);
        componentPositionTest(list.getComponents().get(4), 508, 0, 154, 16);
        componentPositionTest(list.getComponents().get(5), 662, 3, 100, 16);
        componentPositionTest(list.getComponents().get(6), 762, 3, 154, 16);
        componentPositionTest(list.getComponents().get(7), 916, 7, 100, 16);
        componentPositionTest(list.getComponents().get(8), 1016, 7, 154, 16);
    }
}

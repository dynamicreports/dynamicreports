/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.test.design.position;

import junit.framework.Assert;
import net.sf.dynamicreports.design.base.DRDesignBand;
import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.base.component.DRDesignTextField;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.ListType;
import net.sf.dynamicreports.test.design.AbstractBandTest;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class SubtotalPositionTest extends AbstractBandTest {

    @Override
    public void configureReport(ReportBuilder<?> rb) {
        TextColumnBuilder<Integer> column3;

        rb.setShowColumnTitle(false)
          .columns(col.column("Column1", "field1", Integer.class), col.column("Column2", "field2", Integer.class), column3 = col.column("Column3", "field3", Integer.class))
          .subtotalsAtTitle(sbt.sum(column3))
          .subtotalsAtPageHeader(sbt.sum(column3))
          .subtotalsAtPageFooter(sbt.sum(column3))
          .subtotalsAtColumnHeader(sbt.sum(column3))
          .subtotalsAtColumnFooter(sbt.sum(column3))
          .subtotalsAtLastPageFooter(sbt.sum(column3))
          .subtotalsAtSummary(sbt.sum(column3), sbt.aggregate(column3, Calculation.AVERAGE));
    }

    @Override
    protected void titleBandTest(DRDesignBand band) {
        testBand(band);
    }

    @Override
    protected void pageHeaderBandTest(DRDesignBand band) {
        testBand(band);
    }

    @Override
    protected void pageFooterBandTest(DRDesignBand band) {
        testBand(band);
    }

    @Override
    protected void columnHeaderBandTest(DRDesignBand band) {
        testBand(band);
    }

    @Override
    protected void columnFooterBandTest(DRDesignBand band) {
        testBand(band);
    }

    @Override
    protected void detailBandTest(DRDesignBand band) {
        Assert.assertNotNull(band);
    }

    @Override
    protected void lastPageFooterBandTest(DRDesignBand band) {
        testBand(band);
    }

    @Override
    protected void summaryBandTest(DRDesignBand band) {
        DRDesignComponent component = band.getBandComponent();
        Assert.assertTrue(component instanceof DRDesignList);
        DRDesignList list = (DRDesignList) component;
        Assert.assertEquals(ListType.HORIZONTAL, list.getType());
        Assert.assertEquals(1, list.getComponents()
                                   .size());
        componentPositionTest(list, 0, 0, 575, 32);
        Assert.assertTrue(list.getComponents()
                              .get(0) instanceof DRDesignList);

        list = (DRDesignList) list.getComponents()
                                  .get(0);
        Assert.assertEquals(ListType.VERTICAL, list.getType());
        Assert.assertEquals(2, list.getComponents()
                                   .size());
        componentPositionTest(list, 383, 0, 192, 32);
        Assert.assertTrue(list.getComponents()
                              .get(0) instanceof DRDesignTextField);
        Assert.assertTrue(list.getComponents()
                              .get(1) instanceof DRDesignTextField);

        // column3
        componentPositionTest(list.getComponents()
                                  .get(0), 383, 0, 192, 16);
        componentPositionTest(list.getComponents()
                                  .get(1), 383, 16, 192, 16);
    }

    protected void testBand(DRDesignBand band) {
        DRDesignComponent component = band.getBandComponent();
        Assert.assertTrue(component instanceof DRDesignList);
        DRDesignList list = (DRDesignList) component;
        Assert.assertEquals(ListType.HORIZONTAL, list.getType());
        Assert.assertEquals(1, list.getComponents()
                                   .size());
        componentPositionTest(list, 0, 0, 575, 16);
        Assert.assertTrue(list.getComponents()
                              .get(0) instanceof DRDesignTextField);

        // column3
        componentPositionTest(list.getComponents()
                                  .get(0), 383, 0, 192, 16);
    }
}

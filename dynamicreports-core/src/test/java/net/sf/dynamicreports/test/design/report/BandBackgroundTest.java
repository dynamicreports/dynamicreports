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
package net.sf.dynamicreports.test.design.report;

import org.junit.Assert;
import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.DRDesignReport;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.base.component.DRDesignRectangle;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.dynamicreports.test.design.DesignReportBuilder;
import org.junit.Test;

import java.util.ArrayList;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

/**
 * @author Ricardo Mariaca
 */
public class BandBackgroundTest {

    @Test
    public void styleTest() {
        ReportBuilder<?> rb = new DesignReportBuilder();
        TextColumnBuilder<String> column1;
        TextColumnBuilder<Integer> column2;
        ColumnGroupBuilder group1;

        ReportTemplateBuilder template = template().setTitleBackgroundComponent(cmp.roundRectangle(1))
                                                   .setPageHeaderBackgroundComponent(cmp.roundRectangle(2))
                                                   .setPageFooterBackgroundComponent(cmp.roundRectangle(3))
                                                   .setColumnHeaderBackgroundComponent(cmp.roundRectangle(4))
                                                   .setColumnFooterBackgroundComponent(cmp.roundRectangle(5))
                                                   .setGroupHeaderBackgroundComponent(cmp.roundRectangle(6))
                                                   .setGroupFooterBackgroundComponent(cmp.roundRectangle(7))
                                                   .setDetailHeaderBackgroundComponent(cmp.roundRectangle(8))
                                                   .setDetailBackgroundComponent(cmp.roundRectangle(9))
                                                   .setDetailFooterBackgroundComponent(cmp.roundRectangle(10))
                                                   .setLastPageFooterBackgroundComponent(cmp.roundRectangle(11))
                                                   .setSummaryBackgroundComponent(cmp.roundRectangle(12))
                                                   .setBackgroundBackgroundComponent(cmp.roundRectangle(13));

        rb.setTemplate(template)
          .setPageColumnsPerPage(2)
          .columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class))
          .groupBy(group1 = grp.group(column1).setHeaderLayout(GroupHeaderLayout.TITLE_AND_VALUE))
          .subtotalsAtGroupHeader(group1, sbt.sum(column2))
          .subtotalsAtGroupFooter(group1, sbt.sum(column2))
          .title(cmp.verticalGap(10))
          .pageHeader(cmp.verticalGap(10))
          .pageFooter(cmp.verticalGap(10))
          .columnHeader(cmp.verticalGap(10))
          .columnFooter(cmp.verticalGap(10))
          .groupHeader(group1, cmp.verticalGap(10))
          .groupFooter(group1, cmp.verticalGap(10))
          .detailHeader(cmp.verticalGap(10))
          .detail(cmp.verticalGap(10))
          .detailFooter(cmp.verticalGap(10))
          .lastPageFooter(cmp.verticalGap(10))
          .summary(cmp.verticalGap(10))
          .background(cmp.verticalGap(10));

        testBackgroundComponents(rb, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

        rb.setTitleBackgroundComponent(cmp.roundRectangle(14))
          .setPageHeaderBackgroundComponent(cmp.roundRectangle(15))
          .setPageFooterBackgroundComponent(cmp.roundRectangle(16))
          .setColumnHeaderBackgroundComponent(cmp.roundRectangle(17))
          .setColumnFooterBackgroundComponent(cmp.roundRectangle(18))
          .setGroupHeaderBackgroundComponent(group1, cmp.roundRectangle(19))
          .setGroupFooterBackgroundComponent(group1, cmp.roundRectangle(20))
          .setDetailHeaderBackgroundComponent(cmp.roundRectangle(21))
          .setDetailBackgroundComponent(cmp.roundRectangle(22))
          .setDetailFooterBackgroundComponent(cmp.roundRectangle(23))
          .setLastPageFooterBackgroundComponent(cmp.roundRectangle(24))
          .setSummaryBackgroundComponent(cmp.roundRectangle(25))
          .setBackgroundBackgroundComponent(cmp.roundRectangle(26));

        testBackgroundComponents(rb, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26);
    }

    private void testBackgroundComponents(ReportBuilder<?> rb, Integer... radius) {
        try {
            DRDesignReport report = new DRDesignReport(rb.getReport());

            DRDesignRectangle rectangle = (DRDesignRectangle) ((DRDesignList) report.getTitleBand().getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("title background component", radius[0], rectangle.getRadius());
            rectangle = (DRDesignRectangle) ((DRDesignList) report.getPageHeaderBand().getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("pageHeader background component", radius[1], rectangle.getRadius());
            rectangle = (DRDesignRectangle) ((DRDesignList) report.getPageFooterBand().getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("pageFooter background component", radius[2], rectangle.getRadius());
            rectangle = (DRDesignRectangle) ((DRDesignList) report.getColumnHeaderBand().getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("columnHeader background component", radius[3], rectangle.getRadius());
            rectangle = (DRDesignRectangle) ((DRDesignList) report.getColumnFooterBand().getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("columnFooter background component", radius[4], rectangle.getRadius());
            DRDesignGroup group = new ArrayList<DRDesignGroup>(report.getGroups()).get(0);
            rectangle = (DRDesignRectangle) ((DRDesignList) group.getHeaderBands().get(0).getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("groupHeader background component", radius[5], rectangle.getRadius());
            rectangle = (DRDesignRectangle) ((DRDesignList) group.getFooterBands().get(0).getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("groupFooter background component", radius[6], rectangle.getRadius());
            rectangle = (DRDesignRectangle) ((DRDesignList) report.getDetailBands().get(0).getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("detailHeader background component", radius[7], rectangle.getRadius());
            rectangle = (DRDesignRectangle) ((DRDesignList) report.getDetailBands().get(1).getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("detail background component", radius[8], rectangle.getRadius());
            rectangle = (DRDesignRectangle) ((DRDesignList) report.getDetailBands().get(2).getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("detailFooter background component", radius[9], rectangle.getRadius());
            rectangle = (DRDesignRectangle) ((DRDesignList) report.getLastPageFooterBand().getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("lastPageFooter background component", radius[10], rectangle.getRadius());
            rectangle = (DRDesignRectangle) ((DRDesignList) report.getSummaryBand().getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("summary background component", radius[11], rectangle.getRadius());
            rectangle = (DRDesignRectangle) ((DRDesignList) report.getBackgroundBand().getBandComponent()).getBackgroundComponent();
            Assert.assertEquals("background background component", radius[12], rectangle.getRadius());
        } catch (DRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}

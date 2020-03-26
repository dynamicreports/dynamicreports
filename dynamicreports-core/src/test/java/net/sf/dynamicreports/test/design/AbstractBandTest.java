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
package net.sf.dynamicreports.test.design;

import org.junit.Assert;
import net.sf.dynamicreports.design.base.DRDesignBand;
import net.sf.dynamicreports.design.base.DRDesignReport;
import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.exception.DRException;
import org.junit.Test;

/**
 * @author Ricardo Mariaca
 */
public abstract class AbstractBandTest {

    @Test
    public void test() {
        ReportBuilder<?> rb = new DesignReportBuilder();
        configureReport(rb);
        try {
            DRDesignReport report = new DRDesignReport(rb.getReport());
            titleBandTest(report.getTitleBand());
            pageHeaderBandTest(report.getPageHeaderBand());
            pageFooterBandTest(report.getPageFooterBand());
            columnHeaderBandTest(report.getColumnHeaderBand());
            columnFooterBandTest(report.getColumnFooterBand());
            for (DRDesignBand designBand : report.getDetailBands()) {
                detailBandTest(designBand);
            }
            lastPageFooterBandTest(report.getLastPageFooterBand());
            summaryBandTest(report.getSummaryBand());
            noDataBandTest(report.getNoDataBand());
            backgroundBandTest(report.getBackgroundBand());
        } catch (DRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    protected void titleBandTest(DRDesignBand band) {
        Assert.assertNull(band);
    }

    protected void pageHeaderBandTest(DRDesignBand band) {
        Assert.assertNull(band);
    }

    protected void pageFooterBandTest(DRDesignBand band) {
        Assert.assertNull(band);
    }

    protected void columnHeaderBandTest(DRDesignBand band) {
        Assert.assertNull(band);
    }

    protected void columnFooterBandTest(DRDesignBand band) {
        Assert.assertNull(band);
    }

    protected void detailBandTest(DRDesignBand band) {
        Assert.assertNull(band);
    }

    protected void lastPageFooterBandTest(DRDesignBand band) {
        Assert.assertNull(band);
    }

    protected void summaryBandTest(DRDesignBand band) {
        Assert.assertNull(band);
    }

    protected void noDataBandTest(DRDesignBand band) {
        Assert.assertNull(band);
    }

    protected void backgroundBandTest(DRDesignBand band) {
        Assert.assertNull(band);
    }

    protected void componentPositionTest(DRDesignComponent component, int x, int y, int width, int height) {
        Assert.assertNotNull("width", component.getWidth());
        Assert.assertEquals("width", Integer.valueOf(width), component.getWidth());
        Assert.assertNotNull("height", component.getHeight());
        Assert.assertEquals("height", Integer.valueOf(height), component.getHeight());
        Assert.assertNotNull("x", component.getX());
        Assert.assertEquals("x", Integer.valueOf(x), component.getX());
        Assert.assertNotNull("y", component.getY());
        Assert.assertEquals("y", Integer.valueOf(y), component.getY());
    }

    public abstract void configureReport(ReportBuilder<?> rb);
}

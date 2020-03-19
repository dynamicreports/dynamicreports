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

import org.junit.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.test.jasper.AbstractJasperTest;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintImage;
import net.sf.jasperreports.engine.type.HorizontalImageAlignEnum;
import net.sf.jasperreports.renderers.SimpleDataRenderer;

import java.util.Arrays;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;

/**
 * @author Ricardo Mariaca
 */
public class Image2Test extends AbstractJasperTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        ImageBuilder image = cmp.image(Image2Test.class.getResourceAsStream("dynamicreports.png")).setHorizontalImageAlignment(HorizontalImageAlignment.CENTER);
        rb.pageHeader(image).detail(cmp.filler().setFixedHeight(20));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(2);

        try {
            JRPrintImage jrImage = (JRPrintImage) getElementAt("pageHeader.image1", 0);
            byte[] imageData1 = ((SimpleDataRenderer) jrImage.getRenderer()).getData(DefaultJasperReportsContext.getInstance());
            jrImage = (JRPrintImage) getElementAt("pageHeader.image1", 1);
            byte[] imageData2 = ((SimpleDataRenderer) jrImage.getRenderer()).getData(DefaultJasperReportsContext.getInstance());
            Assert.assertTrue("image data", Arrays.equals(imageData1, imageData2));
            Assert.assertEquals("image horizontal alignment", HorizontalImageAlignEnum.CENTER, jrImage.getHorizontalImageAlign());
        } catch (JRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Override
    protected boolean serializableTest() {
        return false;
    }

    @Override
    protected JRDataSource createDataSource() {
        return new JREmptyDataSource(50);
    }
}

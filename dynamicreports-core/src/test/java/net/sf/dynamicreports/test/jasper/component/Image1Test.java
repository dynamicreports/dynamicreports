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

import org.junit.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.test.jasper.AbstractJasperTest;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintImage;
import net.sf.jasperreports.engine.type.ImageTypeEnum;
import net.sf.jasperreports.engine.type.ScaleImageEnum;
import net.sf.jasperreports.engine.util.JRImageLoader;
import net.sf.jasperreports.renderers.SimpleDataRenderer;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Arrays;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca
 */
public class Image1Test extends AbstractJasperTest {
    private Image image;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.setWhenNoDataType(WhenNoDataType.ALL_SECTIONS_NO_DETAIL)
          .setImageStyle(stl.style().setImageScale(ImageScale.CLIP))
          .title(cmp.image(image = new TestImage()), cmp.image(Image1Test.class.getResource("noimage")));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        try {
            byte[] imageData = JRImageLoader.getInstance(DefaultJasperReportsContext.getInstance()).loadBytesFromAwtImage(image, ImageTypeEnum.JPEG);
            JRPrintImage jrImage = (JRPrintImage) getElementAt("title.image1", 0);
            Assert.assertTrue("image data", Arrays.equals(imageData, ((SimpleDataRenderer) jrImage.getRenderer()).getData(DefaultJasperReportsContext.getInstance())));
            Assert.assertEquals("scale image", ScaleImageEnum.CLIP, jrImage.getScaleImageValue());
        } catch (JRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Override
    protected boolean serializableTest() {
        return false;
    }

    private class TestImage extends BufferedImage implements Serializable {
        private static final long serialVersionUID = 1L;

        public TestImage() {
            super(100, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = createGraphics();
            g2d.setColor(Color.BLUE);
            g2d.setComposite(AlphaComposite.Src);
            g2d.fill(new Rectangle2D.Float(5, 5, 90, 90));
        }
    }
}

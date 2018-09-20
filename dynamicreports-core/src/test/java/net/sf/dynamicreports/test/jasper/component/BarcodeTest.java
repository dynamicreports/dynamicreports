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

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.constant.BarcodeBaselinePosition;
import net.sf.dynamicreports.report.constant.BarcodeChecksumMode;
import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.BarcodeShape;
import net.sf.dynamicreports.report.constant.BarcodeTextPosition;
import net.sf.dynamicreports.report.constant.QrCodeErrorCorrectionLevel;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.test.jasper.AbstractJasperTest;
import net.sf.jasperreports.components.barcode4j.Barcode4jComponent;
import net.sf.jasperreports.components.barcode4j.CodabarComponent;
import net.sf.jasperreports.components.barcode4j.Code128Component;
import net.sf.jasperreports.components.barcode4j.Code39Component;
import net.sf.jasperreports.components.barcode4j.DataMatrixComponent;
import net.sf.jasperreports.components.barcode4j.EAN128Component;
import net.sf.jasperreports.components.barcode4j.EAN13Component;
import net.sf.jasperreports.components.barcode4j.EAN8Component;
import net.sf.jasperreports.components.barcode4j.ErrorCorrectionLevelEnum;
import net.sf.jasperreports.components.barcode4j.Interleaved2Of5Component;
import net.sf.jasperreports.components.barcode4j.OrientationEnum;
import net.sf.jasperreports.components.barcode4j.PDF417Component;
import net.sf.jasperreports.components.barcode4j.POSTNETComponent;
import net.sf.jasperreports.components.barcode4j.QRCodeComponent;
import net.sf.jasperreports.components.barcode4j.RoyalMailCustomerComponent;
import net.sf.jasperreports.components.barcode4j.TextPositionEnum;
import net.sf.jasperreports.components.barcode4j.UPCAComponent;
import net.sf.jasperreports.components.barcode4j.UPCEComponent;
import net.sf.jasperreports.components.barcode4j.USPSIntelligentMailComponent;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintFrame;
import net.sf.jasperreports.engine.JRPrintImage;
import net.sf.jasperreports.engine.base.JRBaseComponentElement;
import net.sf.jasperreports.engine.component.Component;
import net.sf.jasperreports.renderers.SimpleRenderToImageAwareDataRenderer;
import org.krysalis.barcode4j.BaselineAlignment;
import org.krysalis.barcode4j.ChecksumMode;
import org.krysalis.barcode4j.impl.datamatrix.SymbolShapeHint;

import static net.sf.dynamicreports.report.builder.DynamicReports.bcode;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class BarcodeTest extends AbstractJasperTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.setWhenNoDataType(WhenNoDataType.ALL_SECTIONS_NO_DETAIL)
          .setTemplate(template().setBarcodeHeight(20))
          .title(
              // codabar
              cmp.horizontalList(bcode.codabar("12345678"), bcode.codabar("12345678")
                                                                 .setPattern("1")
                                                                 .setModuleWidth(2d)
                                                                 .setOrientation(BarcodeOrientation.LEFT)
                                                                 .setTextPosition(BarcodeTextPosition.TOP)
                                                                 .setQuietZone(100d)
                                                                 .setVerticalQuietZone(50d)
                                                                 .setWideFactor(2.5)),

              // code128
              cmp.horizontalList(bcode.code128("12345678"), bcode.code128("12345678")
                                                                 .setPattern("1")
                                                                 .setModuleWidth(2d)
                                                                 .setOrientation(BarcodeOrientation.LEFT)
                                                                 .setTextPosition(BarcodeTextPosition.TOP)
                                                                 .setQuietZone(100d)
                                                                 .setVerticalQuietZone(50d)),

              // ean128
              cmp.horizontalList(bcode.ean128("12345678"), bcode.ean128("12345678")
                                                                .setPattern("1")
                                                                .setModuleWidth(2d)
                                                                .setOrientation(BarcodeOrientation.LEFT)
                                                                .setTextPosition(BarcodeTextPosition.TOP)
                                                                .setQuietZone(100d)
                                                                .setVerticalQuietZone(50d)
                                                                .setChecksumMode(BarcodeChecksumMode.AUTO)),

              // dataMatrix
              cmp.horizontalList(bcode.dataMatrix("12345678"), bcode.dataMatrix("12345678")
                                                                    .setPattern("1")
                                                                    .setModuleWidth(2d)
                                                                    .setOrientation(BarcodeOrientation.LEFT)
                                                                    .setTextPosition(BarcodeTextPosition.TOP)
                                                                    .setQuietZone(100d)
                                                                    .setVerticalQuietZone(50d)
                                                                    .setShape(BarcodeShape.RECTANGLE)),

              // code39
              cmp.horizontalList(bcode.code39("12345678"), bcode.code39("12345678")
                                                                .setPattern("1")
                                                                .setModuleWidth(2d)
                                                                .setOrientation(BarcodeOrientation.LEFT)
                                                                .setTextPosition(BarcodeTextPosition.TOP)
                                                                .setQuietZone(100d)
                                                                .setVerticalQuietZone(50d)
                                                                .setChecksumMode(BarcodeChecksumMode.AUTO)
                                                                .setDisplayChecksum(true)
                                                                .setDisplayStartStop(true)
                                                                .setExtendedCharSetEnabled(true)
                                                                .setIntercharGapWidth(1.5)
                                                                .setWideFactor(2.5)),

              // interleaved2Of5
              cmp.horizontalList(bcode.interleaved2Of5("12345678"), bcode.interleaved2Of5("12345678")
                                                                         .setPattern("1")
                                                                         .setModuleWidth(2d)
                                                                         .setOrientation(BarcodeOrientation.LEFT)
                                                                         .setTextPosition(BarcodeTextPosition.TOP)
                                                                         .setQuietZone(100d)
                                                                         .setVerticalQuietZone(50d)
                                                                         .setChecksumMode(BarcodeChecksumMode.AUTO)
                                                                         .setDisplayChecksum(true)
                                                                         .setWideFactor(2.5)),

              // upca
              cmp.horizontalList(bcode.upca("11000000000"), bcode.upca("11000000000")
                                                                 .setPattern("1")
                                                                 .setModuleWidth(2d)
                                                                 .setOrientation(BarcodeOrientation.LEFT)
                                                                 .setTextPosition(BarcodeTextPosition.TOP)
                                                                 .setQuietZone(100d)
                                                                 .setVerticalQuietZone(50d)
                                                                 .setChecksumMode(BarcodeChecksumMode.AUTO)),

              // upce
              cmp.horizontalList(bcode.upce("1100000"), bcode.upce("1100000")
                                                             .setPattern("1")
                                                             .setModuleWidth(2d)
                                                             .setOrientation(BarcodeOrientation.LEFT)
                                                             .setTextPosition(BarcodeTextPosition.TOP)
                                                             .setQuietZone(100d)
                                                             .setVerticalQuietZone(50d)
                                                             .setChecksumMode(BarcodeChecksumMode.AUTO)),

              // ean13
              cmp.horizontalList(bcode.ean13("110000000000"), bcode.ean13("110000000000")
                                                                   .setPattern("1")
                                                                   .setModuleWidth(2d)
                                                                   .setOrientation(BarcodeOrientation.LEFT)
                                                                   .setTextPosition(BarcodeTextPosition.TOP)
                                                                   .setQuietZone(100d)
                                                                   .setVerticalQuietZone(50d)
                                                                   .setChecksumMode(BarcodeChecksumMode.AUTO)),

              // ean8
              cmp.horizontalList(bcode.ean8("1100000"), bcode.ean8("1100000")
                                                             .setPattern("1")
                                                             .setModuleWidth(2d)
                                                             .setOrientation(BarcodeOrientation.LEFT)
                                                             .setTextPosition(BarcodeTextPosition.TOP)
                                                             .setQuietZone(100d)
                                                             .setVerticalQuietZone(50d)
                                                             .setChecksumMode(BarcodeChecksumMode.AUTO)),

              // uspsIntelligentMail
              cmp.horizontalList(bcode.uspsIntelligentMail("34160265194042788110"), bcode.uspsIntelligentMail("34160265194042788110")
                                                                                         .setPattern("1")
                                                                                         .setModuleWidth(2d)
                                                                                         .setOrientation(BarcodeOrientation.LEFT)
                                                                                         .setTextPosition(BarcodeTextPosition.TOP)
                                                                                         .setQuietZone(100d)
                                                                                         .setVerticalQuietZone(50d)
                                                                                         .setChecksumMode(BarcodeChecksumMode.AUTO)
                                                                                         .setAscenderHeight(2.6)
                                                                                         .setIntercharGapWidth(1.8)
                                                                                         .setTrackHeight(20.1)),

              // royalMailCustomer
              cmp.horizontalList(bcode.royalMailCustomer("34160265194042788110"), bcode.royalMailCustomer("34160265194042788110")
                                                                                       .setPattern("1")
                                                                                       .setModuleWidth(2d)
                                                                                       .setOrientation(BarcodeOrientation.LEFT)
                                                                                       .setQuietZone(100d)
                                                                                       .setVerticalQuietZone(50d)
                                                                                       .setChecksumMode(BarcodeChecksumMode.AUTO)
                                                                                       .setAscenderHeight(2.6)
                                                                                       .setIntercharGapWidth(1.8)
                                                                                       .setTrackHeight(20.1)),

              // postnet
              cmp.horizontalList(bcode.postnet("12345678"), bcode.postnet("12345678")
                                                                 .setPattern("1")
                                                                 .setModuleWidth(2d)
                                                                 .setOrientation(BarcodeOrientation.LEFT)
                                                                 .setTextPosition(BarcodeTextPosition.BOTTOM)
                                                                 .setQuietZone(100d)
                                                                 .setVerticalQuietZone(50d)
                                                                 .setChecksumMode(BarcodeChecksumMode.AUTO)
                                                                 .setDisplayChecksum(true)
                                                                 .setShortBarHeight(2.5)
                                                                 .setBaselinePosition(BarcodeBaselinePosition.TOP)
                                                                 .setIntercharGapWidth(1.5)),

              // pdf417
              cmp.horizontalList(bcode.pdf417("12345678"), bcode.pdf417("12345678")
                                                                .setPattern("1")
                                                                .setModuleWidth(2d)
                                                                .setOrientation(BarcodeOrientation.LEFT)
                                                                .setTextPosition(BarcodeTextPosition.NONE)
                                                                .setQuietZone(100d)
                                                                .setVerticalQuietZone(50d)
                                                                .setMinColumns(2)
                                                                .setMaxColumns(30)
                                                                .setMinRows(3)
                                                                .setMaxRows(29)
                                                                .setWidthToHeightRatio(2.6)
                                                                .setErrorCorrectionLevel(8)),

              // qrcode
              bcode.qrCode("123456")
                   .setMargin(2)
                   .setErrorCorrectionLevel(QrCodeErrorCorrectionLevel.H));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // codabar
        CodabarComponent codabar = testBarcode("Codabar", CodabarComponent.class, TextPositionEnum.TOP);
        Assert.assertEquals("Codabar wide factor", 2.5, codabar.getWideFactor());
        testBarcode("Codabar", 2, 0, "12345678");
        testBarcode("Codabar", 2, 1, "112345678");

        // code128
        testBarcode("Code128", Code128Component.class, TextPositionEnum.TOP);
        testBarcode("Code128", 3, 0, "12345678");
        testBarcode("Code128", 3, 1, "112345678");

        // ean128
        EAN128Component ean128 = testBarcode("EAN128", EAN128Component.class, TextPositionEnum.TOP);
        Assert.assertEquals("EAN128 checksum mode", ChecksumMode.CP_AUTO.getName(), ean128.getChecksumMode());
        testBarcode("EAN128", 4, 0, "(12)345678");
        testBarcode("EAN128", 4, 1, "1(12)345678");

        // dataMatrix
        DataMatrixComponent dataMatrix = testBarcode("DataMatrix", DataMatrixComponent.class, TextPositionEnum.TOP);
        Assert.assertEquals("DataMatrix shape", SymbolShapeHint.FORCE_RECTANGLE.getName(), dataMatrix.getShape());

        // code39
        Code39Component code39 = testBarcode("Code39", Code39Component.class, TextPositionEnum.TOP);
        Assert.assertEquals("Code39 checksum mode", ChecksumMode.CP_AUTO.getName(), code39.getChecksumMode());
        Assert.assertEquals("Code39 display checksum", Boolean.TRUE, code39.isDisplayChecksum());
        Assert.assertEquals("Code39 display start stop", Boolean.TRUE, code39.isDisplayStartStop());
        Assert.assertEquals("Code39 extended charSet enabled", Boolean.TRUE, code39.isExtendedCharSetEnabled());
        Assert.assertEquals("Code39 interchar gap width", 1.5, code39.getIntercharGapWidth());
        Assert.assertEquals("Code39 wide factor", 2.5, code39.getWideFactor());
        testBarcode("Code39", 6, 0, "12345678");
        testBarcode("Code39", 6, 1, "112345678");

        // interleaved2Of5
        Interleaved2Of5Component interleaved2Of5 = testBarcode("Interleaved2Of5", Interleaved2Of5Component.class, TextPositionEnum.TOP);
        Assert.assertEquals("Interleaved2Of5 checksum mode", ChecksumMode.CP_AUTO.getName(), interleaved2Of5.getChecksumMode());
        Assert.assertEquals("Interleaved2Of5 display checksum", Boolean.TRUE, interleaved2Of5.isDisplayChecksum());
        Assert.assertEquals("Interleaved2Of5 wide factor", 2.5, interleaved2Of5.getWideFactor());
        testBarcode("Interleaved2Of5", 7, 0, "12345678");
        testBarcode("Interleaved2Of5", 7, 1, "112345678");

        // upca
        UPCAComponent upca = testBarcode("UPCA", UPCAComponent.class, TextPositionEnum.TOP);
        Assert.assertEquals("UPCA checksum mode", ChecksumMode.CP_AUTO.getName(), upca.getChecksumMode());
        testBarcode("UPCA", 8, 0, "1<.*>10000<.*>00000");
        testBarcode("UPCA", 8, 1, "1<.*>10000<.*>00000");

        // upce
        UPCEComponent upce = testBarcode("UPCE", UPCEComponent.class, TextPositionEnum.TOP);
        Assert.assertEquals("UPCE checksum mode", ChecksumMode.CP_AUTO.getName(), upce.getChecksumMode());
        testBarcode("UPCE", 9, 0, "1<.*>100000");
        testBarcode("UPCE", 9, 1, "1<.*>100000");

        // ean13
        EAN13Component ean13 = testBarcode("EAN13", EAN13Component.class, TextPositionEnum.TOP);
        Assert.assertEquals("EAN13 checksum mode", ChecksumMode.CP_AUTO.getName(), ean13.getChecksumMode());
        testBarcode("EAN13", 10, 0, "1<.*>100000<.*>000006");
        testBarcode("EAN13", 10, 1, "1<.*>100000<.*>000006");

        // ean8
        EAN8Component ean8 = testBarcode("EAN8", EAN8Component.class, TextPositionEnum.TOP);
        Assert.assertEquals("EAN8 checksum mode", ChecksumMode.CP_AUTO.getName(), ean8.getChecksumMode());
        testBarcode("EAN8", 11, 0, "1100<.*>0006");
        testBarcode("EAN8", 11, 1, "1100<.*>0006");

        // uspsIntelligentMail
        USPSIntelligentMailComponent uspsIntelligentMail = testBarcode("USPSIntelligentMail", USPSIntelligentMailComponent.class, TextPositionEnum.TOP);
        Assert.assertEquals("USPSIntelligentMail checksum mode", ChecksumMode.CP_AUTO.getName(), uspsIntelligentMail.getChecksumMode());
        Assert.assertEquals("USPSIntelligentMail ascender height", 2.6, uspsIntelligentMail.getAscenderHeight());
        Assert.assertEquals("USPSIntelligentMail interchar gap width", 1.8, uspsIntelligentMail.getIntercharGapWidth());
        Assert.assertEquals("USPSIntelligentMail track height", 20.1, uspsIntelligentMail.getTrackHeight());

        // royalMailCustomer
        RoyalMailCustomerComponent royalMailCustomer = testBarcode("RoyalMailCustomer", RoyalMailCustomerComponent.class, null);
        Assert.assertEquals("RoyalMailCustomer checksum mode", ChecksumMode.CP_AUTO.getName(), royalMailCustomer.getChecksumMode());
        Assert.assertEquals("RoyalMailCustomer ascender height", 2.6, royalMailCustomer.getAscenderHeight());
        Assert.assertEquals("RoyalMailCustomer interchar gap width", 1.8, royalMailCustomer.getIntercharGapWidth());
        Assert.assertEquals("RoyalMailCustomer track height", 20.1, royalMailCustomer.getTrackHeight());

        // postnet
        POSTNETComponent postnet = testBarcode("POSTNET", POSTNETComponent.class, TextPositionEnum.BOTTOM);
        Assert.assertEquals("POSTNET checksum mode", ChecksumMode.CP_AUTO.getName(), postnet.getChecksumMode());
        Assert.assertEquals("POSTNET display checksum", Boolean.TRUE, postnet.getDisplayChecksum());
        Assert.assertEquals("POSTNET interchar gap width", 1.5, postnet.getIntercharGapWidth());
        Assert.assertEquals("POSTNET short bar height", 2.5, postnet.getShortBarHeight());
        Assert.assertEquals("POSTNET baseline position", BaselineAlignment.ALIGN_TOP.getName(), postnet.getBaselinePosition());
        Assert.assertEquals("POSTNET interchar gap width", 1.5, postnet.getIntercharGapWidth());

        // pdf417
        PDF417Component pdf417 = testBarcode("PDF417", PDF417Component.class, TextPositionEnum.NONE);
        Assert.assertEquals("PDF417 min columns", new Integer(2), pdf417.getMinColumns());
        Assert.assertEquals("PDF417 max columns", new Integer(30), pdf417.getMaxColumns());
        Assert.assertEquals("PDF417 min rows", new Integer(3), pdf417.getMinRows());
        Assert.assertEquals("PDF417 max rows", new Integer(29), pdf417.getMaxRows());
        Assert.assertEquals("PDF417 width to height ratio", 2.6, pdf417.getWidthToHeightRatio());
        Assert.assertEquals("PDF417 error correction level", new Integer(8), pdf417.getErrorCorrectionLevel());

        // qrCode
        testQrCode();
    }

    private <T extends Barcode4jComponent> T testBarcode(String name, Class<T> componentClass, TextPositionEnum textPosition) {
        JRBaseComponentElement barcode = (JRBaseComponentElement) getJasperReport().getTitle()
                                                                                   .getElementByKey("title." + name + "2");
        Component component = barcode.getComponent();
        Assert.assertTrue("Barcode is not instance of " + componentClass.getName(), component.getClass()
                                                                                             .equals(componentClass));
        @SuppressWarnings("unchecked") T barcodeComponent = (T) component;

        Assert.assertEquals(name + " module width", 2d, barcodeComponent.getModuleWidth());
        Assert.assertEquals(name + " orientation", OrientationEnum.LEFT, barcodeComponent.getOrientationValue());
        Assert.assertEquals(name + " text position", textPosition, barcodeComponent.getTextPositionValue());
        Assert.assertEquals(name + " quiet zone", 100d, barcodeComponent.getQuietZone());
        Assert.assertEquals(name + " vertical quiet zone", 50d, barcodeComponent.getVerticalQuietZone());
        return barcodeComponent;
    }

    private void testBarcode(String name, int groupIndex, int index, String code) {
        JRPrintFrame printFrame = (JRPrintFrame) getElementAt("title.list" + groupIndex, 0);
        JRPrintImage image = (JRPrintImage) printFrame.getElements()
                                                      .get(index);
        SimpleRenderToImageAwareDataRenderer renderer = (SimpleRenderToImageAwareDataRenderer) image.getRenderer();
        try {
            String barcode = new String(renderer.getData(DefaultJasperReportsContext.getInstance()));
            Assert.assertTrue(name + " code", barcode.matches(".*>" + code.replaceAll("\\(", "\\\\(")
                                                                          .replaceAll("\\)", "\\\\)") + "<.*"));
        } catch (JRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    private void testQrCode() {
        JRBaseComponentElement barcode = (JRBaseComponentElement) getJasperReport().getTitle()
                                                                                   .getElementByKey("title.QRCode1");
        Component component = barcode.getComponent();
        Assert.assertTrue("QRCode is not instance of " + QRCodeComponent.class.getName(), component.getClass()
                                                                                                   .equals(QRCodeComponent.class));
        QRCodeComponent qrComponentComponent = (QRCodeComponent) component;

        Assert.assertEquals("QRCode margin", new Integer(2), qrComponentComponent.getMargin());
        Assert.assertEquals("QRCode error correction level", ErrorCorrectionLevelEnum.H, qrComponentComponent.getErrorCorrectionLevel());
    }
}

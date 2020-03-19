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
import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.test.jasper.AbstractJasperTest;
import net.sf.jasperreports.components.barbecue.BarbecueComponent;
import net.sf.jasperreports.engine.base.JRBaseComponentElement;
import net.sf.jasperreports.engine.type.RotationEnum;

import static net.sf.dynamicreports.report.builder.DynamicReports.bcode;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

/**
 * @author Ricardo Mariaca
 */
public class BarbecueTest extends AbstractJasperTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.setTemplate(template().setBarcodeHeight(20).setBarcodeStyle(stl.style(2)))
          .title(bcode.barbecue_2of7(exp.jasperSyntaxText("12345678")), bcode.barbecue_3of9(exp.jasperSyntaxText("12345678")), bcode.barbecue_bookland(exp.jasperSyntaxText("1234567890")),
                 bcode.barbecue_codabar(exp.jasperSyntaxText("12345678")), bcode.barbecue_code128(exp.jasperSyntaxText("12345678")), bcode.barbecue_code128A(exp.jasperSyntaxText("12345678")),
                 bcode.barbecue_code128B(exp.jasperSyntaxText("12345678")), bcode.barbecue_code128C(exp.jasperSyntaxText("12345678")), bcode.barbecue_code39(exp.jasperSyntaxText("12345678")),
                 bcode.barbecue_code39Extended(exp.jasperSyntaxText("12345678")), bcode.barbecue_ean128(exp.jasperSyntaxText("12345678")), bcode.barbecue_ean13(exp.jasperSyntaxText("123456789012")),
                 bcode.barbecue_globalTradeItemNumber(exp.jasperSyntaxText("12345678")), bcode.barbecue_int2of5(exp.jasperSyntaxText("12345678")),
                 bcode.barbecue_monarch(exp.jasperSyntaxText("12345678")), bcode.barbecue_nw7(exp.jasperSyntaxText("12345678")), bcode.barbecue_pdf417(exp.jasperSyntaxText("12345678")),
                 bcode.barbecue_postnet(exp.jasperSyntaxText("12345678")), bcode.barbecue_randomWeightUpca(exp.jasperSyntaxText("12345678901")),
                 bcode.barbecue_scc14ShippingCode(exp.jasperSyntaxText("12345678")), bcode.barbecue_shipmentIdentificationNumber(exp.jasperSyntaxText("12345678")),
                 bcode.barbecue_sscc18(exp.jasperSyntaxText("12345678")), bcode.barbecue_std2of5(exp.jasperSyntaxText("12345678")),
                 bcode.barbecue_ucc128(exp.jasperSyntaxText("12345678")).setApplicationIdentifierExpression("1"), bcode.barbecue_upca(exp.jasperSyntaxText("12345678901")),
                 bcode.barbecue_usd3(exp.jasperSyntaxText("12345678")), bcode.barbecue_usd4(exp.jasperSyntaxText("12345678")), bcode.barbecue_usps(exp.jasperSyntaxText("12345678")),

                 bcode.barbecue_ucc128("12345678")
                      .setFixedHeight(50)
                      .setApplicationIdentifierExpression(exp.jasperSyntaxText("1"))
                      .setDrawText(true)
                      .setChecksumRequired(true)
                      .setBarWidth(2)
                      .setBarHeight(5)
                      .setOrientation(BarcodeOrientation.RIGHT));
    }

    @Override
    protected boolean serializableJrPrintTest() {
        return false;
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        testBarbecue(1, "2of7");
        testBarbecue(2, "3of9");
        testBarbecue(3, "Bookland");
        testBarbecue(4, "Codabar");
        testBarbecue(5, "Code128");
        testBarbecue(6, "Code128A");
        testBarbecue(7, "Code128B");
        testBarbecue(8, "Code128C");
        testBarbecue(9, "Code39");
        testBarbecue(10, "Code39 (Extended)");
        testBarbecue(11, "EAN128");
        testBarbecue(12, "EAN13");
        testBarbecue(13, "GlobalTradeItemNumber");
        testBarbecue(14, "Int2of5");
        testBarbecue(15, "Monarch");
        testBarbecue(16, "NW7");
        testBarbecue(17, "PDF417");
        testBarbecue(18, "PostNet");
        testBarbecue(19, "RandomWeightUPCA");
        testBarbecue(20, "SCC14ShippingCode");
        testBarbecue(21, "ShipmentIdentificationNumber");
        testBarbecue(22, "SSCC18");
        testBarbecue(23, "Std2of5");
        testBarbecue(24, "UCC128");
        testBarbecue(25, "UPCA");
        testBarbecue(26, "USD3");
        testBarbecue(27, "USD4");
        testBarbecue(28, "USPS");

        JRBaseComponentElement barcode = (JRBaseComponentElement) getJasperReport().getTitle().getElementByKey("title.barbecue29");
        BarbecueComponent component = (BarbecueComponent) barcode.getComponent();
        Assert.assertEquals("Barbecue application identifier", "\"1\"", component.getApplicationIdentifierExpression().getText());
        Assert.assertTrue("Barbecue draw text", component.isDrawText());
        Assert.assertTrue("Barbecue checksum required", component.isChecksumRequired());
        Assert.assertEquals("Barbecue bar width", Integer.valueOf(2), component.getBarWidth());
        Assert.assertEquals("Barbecue bar height", Integer.valueOf(5), component.getBarHeight());
        Assert.assertEquals("Barbecue orientation", RotationEnum.RIGHT, component.getRotation());
    }

    private void testBarbecue(int index, String type) {
        JRBaseComponentElement barcode = (JRBaseComponentElement) getJasperReport().getTitle().getElementByKey("title.barbecue" + index);
        BarbecueComponent component = (BarbecueComponent) barcode.getComponent();
        Assert.assertEquals("Barbecue type ", type, component.getType());
        Assert.assertTrue("Barbecue code ", component.getCodeExpression().getText().contains("12345678"));
    }
}

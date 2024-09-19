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
package net.sf.dynamicreports.test.jasper.report;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.hyperLink;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.constant.HyperLinkTarget;
import net.sf.dynamicreports.report.constant.HyperLinkType;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.type.HyperlinkTargetEnum;
import net.sf.jasperreports.engine.type.HyperlinkTypeEnum;

/**
 * @author Ricardo Mariaca
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HyperLinkTest extends AbstractJasperValueTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        final HyperLinkBuilder hyperLink1 = hyperLink().setReference("reference").setTooltip("tooltip").setAnchor("anchor").setPage(1).setType(HyperLinkType.LOCAL_ANCHOR).setTarget(HyperLinkTarget.TOP);
        final HyperLinkBuilder hyperLink2 = hyperLink().setType("customType").setTarget("customTarget");

        rb.title(cmp.text("title 1").setHyperLink(hyperLink1).setAnchorName("anchorName").setBookmarkLevel(1), cmp.text("title 2").setHyperLink(hyperLink2));
    }

    @Override
    @Test
    public void test() {
        super.test();

        numberOfPagesTest(1);

        JRPrintText textField = (JRPrintText) getElementAt("title.textField1", 0);
        Assertions.assertEquals("reference", textField.getHyperlinkReference(), "hyperlink reference");
        Assertions.assertEquals( "tooltip", textField.getHyperlinkTooltip(), "hyperlink tooltip");
        Assertions.assertEquals( "anchor", textField.getHyperlinkAnchor(), "hyperlink anchor");
        Assertions.assertEquals( "anchorName", textField.getAnchorName(), "hyperlink anchorName");
        Assertions.assertEquals(1, textField.getBookmarkLevel(),"hyperlink bookmark level");
        Assertions.assertEquals(Integer.valueOf(1), textField.getHyperlinkPage(), "hyperlink page");
        Assertions.assertEquals(HyperlinkTypeEnum.LOCAL_ANCHOR, textField.getHyperlinkType(),"hyperlink type reference");
        Assertions.assertEquals(HyperlinkTypeEnum.LOCAL_ANCHOR.getName(), textField.getLinkType(),"hyperlink type reference");
        Assertions.assertEquals(HyperlinkTargetEnum.TOP, textField.getHyperlinkTarget(), "hyperlink target");
        Assertions.assertEquals(HyperlinkTargetEnum.TOP.getName(), textField.getLinkTarget(), "hyperlink target");

        textField = (JRPrintText) getElementAt("title.textField2", 0);
        Assertions.assertEquals(HyperlinkTypeEnum.CUSTOM, textField.getHyperlinkType(), "hyperlink type reference");
        Assertions.assertEquals( "customType", textField.getLinkType(), "hyperlink type reference");
        Assertions.assertEquals(HyperlinkTargetEnum.CUSTOM, textField.getHyperlinkTarget(), "hyperlink target");
        Assertions.assertEquals( "customTarget", textField.getLinkTarget(), "hyperlink target");
    }
}

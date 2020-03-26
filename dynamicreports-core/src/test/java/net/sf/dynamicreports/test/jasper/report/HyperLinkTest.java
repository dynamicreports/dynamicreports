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

import org.junit.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.constant.HyperLinkTarget;
import net.sf.dynamicreports.report.constant.HyperLinkType;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.type.HyperlinkTargetEnum;
import net.sf.jasperreports.engine.type.HyperlinkTypeEnum;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.hyperLink;

/**
 * @author Ricardo Mariaca
 */
public class HyperLinkTest extends AbstractJasperValueTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        HyperLinkBuilder hyperLink1 = hyperLink().setReference("reference").setTooltip("tooltip").setAnchor("anchor").setPage(1).setType(HyperLinkType.LOCAL_ANCHOR).setTarget(HyperLinkTarget.TOP);
        HyperLinkBuilder hyperLink2 = hyperLink().setType("customType").setTarget("customTarget");

        rb.title(cmp.text("title 1").setHyperLink(hyperLink1).setAnchorName("anchorName").setBookmarkLevel(1), cmp.text("title 2").setHyperLink(hyperLink2));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        JRPrintText textField = (JRPrintText) getElementAt("title.textField1", 0);
        Assert.assertEquals("hyperlink reference", "reference", textField.getHyperlinkReference());
        Assert.assertEquals("hyperlink tooltip", "tooltip", textField.getHyperlinkTooltip());
        Assert.assertEquals("hyperlink anchor", "anchor", textField.getHyperlinkAnchor());
        Assert.assertEquals("hyperlink anchorName", "anchorName", textField.getAnchorName());
        Assert.assertEquals("hyperlink bookmark level", 1, textField.getBookmarkLevel());
        Assert.assertEquals("hyperlink page", Integer.valueOf(1), textField.getHyperlinkPage());
        Assert.assertEquals("hyperlink type reference", HyperlinkTypeEnum.LOCAL_ANCHOR, textField.getHyperlinkTypeValue());
        Assert.assertEquals("hyperlink type reference", HyperlinkTypeEnum.LOCAL_ANCHOR.getName(), textField.getLinkType());
        Assert.assertEquals("hyperlink target", HyperlinkTargetEnum.TOP, textField.getHyperlinkTargetValue());
        Assert.assertEquals("hyperlink target", HyperlinkTargetEnum.TOP.getName(), textField.getLinkTarget());

        textField = (JRPrintText) getElementAt("title.textField2", 0);
        Assert.assertEquals("hyperlink type reference", HyperlinkTypeEnum.CUSTOM, textField.getHyperlinkTypeValue());
        Assert.assertEquals("hyperlink type reference", "customType", textField.getLinkType());
        Assert.assertEquals("hyperlink target", HyperlinkTargetEnum.CUSTOM, textField.getHyperlinkTargetValue());
        Assert.assertEquals("hyperlink target", "customTarget", textField.getLinkTarget());
    }
}

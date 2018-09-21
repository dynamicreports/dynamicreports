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
package net.sf.dynamicreports.test.jasper.style;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.LineSpacing;
import net.sf.dynamicreports.report.constant.TabStopAlignment;
import net.sf.dynamicreports.test.jasper.AbstractJasperStyleTest;
import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.TabStop;
import net.sf.jasperreports.engine.type.LineSpacingEnum;
import net.sf.jasperreports.engine.type.TabStopAlignEnum;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Style7Test extends AbstractJasperStyleTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        StyleBuilder style = stl.style()
                                .setLineSpacing(LineSpacing.DOUBLE)
                                .setLineSpacingSize(2f)
                                .setFirstLineIndent(10)
                                .setLeftIndent(15)
                                .setRightIndent(20)
                                .setSpacingBefore(5)
                                .setSpacingAfter(6)
                                .setTabStopWidth(9)
                                .addTabStop(12, TabStopAlignment.CENTER);

        rb.setTextStyle(style)
          .title(cmp.text(""));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        JRStyle style = getElementAt("title.textField1", 0).getStyle();
        Assert.assertEquals("line spacing", LineSpacingEnum.DOUBLE, style.getParagraph()
                                                                         .getLineSpacing());
        Assert.assertEquals("line spacing size", new Float(2), style.getParagraph()
                                                                    .getLineSpacingSize());
        Assert.assertEquals("first line indent", new Integer(10), style.getParagraph()
                                                                       .getFirstLineIndent());
        Assert.assertEquals("left indent", new Integer(15), style.getParagraph()
                                                                 .getLeftIndent());
        Assert.assertEquals("right indent", new Integer(20), style.getParagraph()
                                                                  .getRightIndent());
        Assert.assertEquals("spacing before", new Integer(5), style.getParagraph()
                                                                   .getSpacingBefore());
        Assert.assertEquals("spacing after", new Integer(6), style.getParagraph()
                                                                  .getSpacingAfter());
        Assert.assertEquals("tab stop width", new Integer(9), style.getParagraph()
                                                                   .getTabStopWidth());
        TabStop[] tabStops = style.getParagraph()
                                  .getTabStops();
        Assert.assertNotNull("tab stops", tabStops);
        Assert.assertEquals("tab stop position", 12, tabStops[0].getPosition());
        Assert.assertEquals("tab stop alignment", TabStopAlignEnum.CENTER, tabStops[0].getAlignment());
    }
}

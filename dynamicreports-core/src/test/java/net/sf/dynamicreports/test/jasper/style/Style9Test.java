/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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
import net.sf.dynamicreports.test.jasper.AbstractJasperStyleTest;
import net.sf.jasperreports.engine.JRStyle;

import java.awt.Color;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Style9Test extends AbstractJasperStyleTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        StyleBuilder style = stl.style()
                                .bold()
                                .setForegroundColor(Color.BLUE);

        rb.title(cmp.rectangle()
                    .setStyle(style), cmp.text("text")
                                         .setStyle(style));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        JRStyle style = getElementAt("title.rectangle1", 0).getStyle();
        Assert.assertEquals("foreColor", Color.BLUE, style.getForecolor());
        styleTest("title.textField1", 0, Color.BLUE, null, "Arial", 10f, true, null);
    }
}

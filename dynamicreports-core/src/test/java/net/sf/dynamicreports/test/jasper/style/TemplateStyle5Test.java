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

import org.junit.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.style.TemplateStylesBuilder;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.dynamicreports.test.jasper.AbstractJasperStyleTest;
import net.sf.dynamicreports.test.jasper.templatedesign.TemplateDesign1Test;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.type.LineStyleEnum;

import java.awt.Color;
import java.io.InputStream;
import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

/**
 * @author Ricardo Mariaca
 */
public class TemplateStyle5Test extends AbstractJasperStyleTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) throws DRException {
        TemplateStylesBuilder templateStyles =
            stl.templateStyles().loadStyles(TemplateStyle4Test.class.getResource("StyleTemplate1.jrtx")).styles(stl.style().setName("style1").setBackgroundColor(Color.RED));
        templateStyles.getStyle("columnTitleStyle3").setBackgroundColor(Color.LIGHT_GRAY);
        InputStream is = TemplateDesign1Test.class.getResourceAsStream("templatedesign6.jrxml");
        rb.setTemplateDesign(is).setWhenNoDataType(WhenNoDataType.ALL_SECTIONS_NO_DETAIL).addTemplateStyle(templateStyles);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        JasperPrint jasperPrint = getJasperPrint();
        Assert.assertEquals("templatedesign6", jasperPrint.getName());

        styleTest("templateDesign.title1", 0, Color.BLACK, Color.LIGHT_GRAY, "SansSerif", null, true, null);
        borderTest("templateDesign.title1", 0, Color.BLACK, LineStyleEnum.SOLID, 2, Color.BLACK, LineStyleEnum.SOLID, 2, Color.BLACK, LineStyleEnum.SOLID, 2, Color.BLACK, LineStyleEnum.SOLID, 2);
        styleTest("templateDesign.title2", 0, null, Color.RED, "SansSerif", null, null, null);
    }
}

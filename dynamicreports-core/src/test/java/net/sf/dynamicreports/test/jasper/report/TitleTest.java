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
package net.sf.dynamicreports.test.jasper.report;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.type.HyperlinkTypeEnum;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.hyperLink;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class TitleTest extends AbstractJasperValueTest {

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.setResourceBundle("net.sf.dynamicreports.test.jasper.report.test")
          .columns(col.column("Column1", "field1", Integer.class))
          .title(cmp.text("title 1").setHyperLink(hyperLink("link").setTooltip("tooltip")), cmp.text("title 2"), cmp.text("title 3"), cmp.text(exp.message("title")),
                 cmp.multiPageList(cmp.text(exp.message("title"))));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(2);
        elementCountTest("title.textField1", 2);
        elementValueTest("title.textField1", "title 1", "test title");

        JRPrintText textField = (JRPrintText) getElementAt("title.textField1", 0);
        Assert.assertEquals("hyperlink reference", "link", textField.getHyperlinkReference());
        Assert.assertEquals("hyperlink tooltip", "tooltip", textField.getHyperlinkTooltip());
        Assert.assertEquals("hyperlink type reference", HyperlinkTypeEnum.REFERENCE, textField.getHyperlinkTypeValue());

        elementCountTest("title.textField2", 1);
        elementValueTest("title.textField2", "title 2");

        elementCountTest("title.textField3", 1);
        elementValueTest("title.textField3", "title 3");

        elementCountTest("title.textField4", 1);
        elementValueTest("title.textField4", "test title");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1");
        for (int i = 0; i < 50; i++) {
            dataSource.add(i);
        }
        return dataSource;
    }
}

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
package net.sf.dynamicreports.test.jasper.tableofcontents;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.tableOfContentsHeading;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.util.JRStyledTextUtil;

/**
 * @author Ricardo Mariaca
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TableOfContents3Test extends AbstractJasperValueTest {
    private DRIExpression<String> labelExpression1;
    private DRIExpression<String> labelExpression2;
    private DRIExpression<String> labelExpression3;
    private DRIExpression<String> labelExpression4;
    private DRIExpression<String> labelExpression5;
    private DRIExpression<String> labelExpression6;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        final TextFieldBuilder<String> textField1 = cmp.text("text1");
        labelExpression1 = textField1.getComponent().getValueExpression();
        final TextFieldBuilder<String> textField6 = cmp.text("text6");
        labelExpression6 = textField6.getComponent().getValueExpression();

        rb.tableOfContents()
          .title(textField1.setTableOfContentsHeading(tableOfContentsHeading()), cmp.subreport(createSubreport1()))
          .summary(cmp.subreport(createSubreport3()), textField6.setTableOfContentsHeading(tableOfContentsHeading()));
    }

    private JasperReportBuilder createSubreport1() {
        final TextFieldBuilder<String> textField2 = cmp.text("text2");
        labelExpression2 = textField2.getComponent().getValueExpression();
        final TextFieldBuilder<String> textField4 = cmp.text("text4");
        labelExpression4 = textField4.getComponent().getValueExpression();

        final JasperReportBuilder report = report();
        report.title(textField2.setTableOfContentsHeading(tableOfContentsHeading()));
        report.title(cmp.subreport(createSubreport2()));
        report.title(textField4.setTableOfContentsHeading(tableOfContentsHeading()));
        report.detailHeader(cmp.verticalGap(10));
        report.setDataSource(new JREmptyDataSource(50));
        return report;
    }

    private JasperReportBuilder createSubreport2() {
        final TextFieldBuilder<String> textField3 = cmp.text("text3");
        labelExpression3 = textField3.getComponent().getValueExpression();

        final JasperReportBuilder report = report();
        report.title(textField3.setTableOfContentsHeading(tableOfContentsHeading()));
        report.detailHeader(cmp.verticalGap(10));
        report.setDataSource(new JREmptyDataSource(80));
        return report;
    }

    private JasperReportBuilder createSubreport3() {
        final TextFieldBuilder<String> textField5 = cmp.text("text5");
        labelExpression5 = textField5.getComponent().getValueExpression();

        final JasperReportBuilder report = report();
        report.title(textField5.setTableOfContentsHeading(tableOfContentsHeading()));
        report.detailHeader(cmp.verticalGap(10));
        report.setDataSource(new JREmptyDataSource(50));
        return report;
    }

    @Override
    protected boolean serializableTest() {
        return false;
    }

    @Override
    @Test
    public void test() {
        super.test();

        numberOfPagesTest(4);

        elementValueTest("title.textField1", "Table of contents");

        elementCountTest("detail.textField1", 6);

        String anchorName = labelExpression1.getName() + "_0";
        elementValueTest("detail.textField1", 0, "text1");
        JRPrintText text = (JRPrintText) getElementAt("detail.textField1", 0);
        Assertions.assertEquals(anchorName, text.getHyperlinkAnchor(), "text anchor");
        JRPrintText dots = (JRPrintText) getElementAt("detail.textField2", 0);
        String value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."), "dots");
        Assertions.assertEquals(anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        JRPrintText pageIndex = (JRPrintText) getElementAt("detail.textField3", 0);
        Assertions.assertEquals(anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        anchorName = labelExpression2.getName() + "_0";
        elementValueTest("detail.textField1", 1, "text2");
        text = (JRPrintText) getElementAt("detail.textField1", 1);
        Assertions.assertEquals(anchorName, text.getHyperlinkAnchor(), "text anchor");
        dots = (JRPrintText) getElementAt("detail.textField2", 1);
        value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."), "dots");
        Assertions.assertEquals(anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        pageIndex = (JRPrintText) getElementAt("detail.textField3", 1);
        Assertions.assertEquals(anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        anchorName = labelExpression3.getName() + "_0";
        elementValueTest("detail.textField1", 2, "text3");
        text = (JRPrintText) getElementAt("detail.textField1", 2);
        Assertions.assertEquals(anchorName, text.getHyperlinkAnchor(), "text anchor");
        dots = (JRPrintText) getElementAt("detail.textField2", 2);
        value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."), "dots");
        Assertions.assertEquals(anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        pageIndex = (JRPrintText) getElementAt("detail.textField3", 2);
        Assertions.assertEquals(anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        anchorName = labelExpression4.getName() + "_0";
        elementValueTest("detail.textField1", 3, "text4");
        text = (JRPrintText) getElementAt("detail.textField1", 3);
        Assertions.assertEquals(anchorName, text.getHyperlinkAnchor(), "text anchor");
        dots = (JRPrintText) getElementAt("detail.textField2", 3);
        value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."),"dots");
        Assertions.assertEquals(anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        pageIndex = (JRPrintText) getElementAt("detail.textField3", 3);
        Assertions.assertEquals(anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        anchorName = labelExpression5.getName() + "_0";
        elementValueTest("detail.textField1", 4, "text5");
        text = (JRPrintText) getElementAt("detail.textField1", 4);
        Assertions.assertEquals(anchorName, text.getHyperlinkAnchor(), "text anchor");
        dots = (JRPrintText) getElementAt("detail.textField2", 4);
        value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."), "dots");
        Assertions.assertEquals(anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        pageIndex = (JRPrintText) getElementAt("detail.textField3", 4);
        Assertions.assertEquals(anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        anchorName = labelExpression6.getName() + "_0";
        elementValueTest("detail.textField1", 5, "text6");
        text = (JRPrintText) getElementAt("detail.textField1", 5);
        Assertions.assertEquals(anchorName, text.getHyperlinkAnchor(), "text anchor");
        dots = (JRPrintText) getElementAt("detail.textField2", 5);
        value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."), "dots");
        Assertions.assertEquals( anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        pageIndex = (JRPrintText) getElementAt("detail.textField3", 5);
        Assertions.assertEquals(anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        elementValueTest("detail.textField3", "1", "1", "1", "2", "2", "3");

        String name1 = labelExpression1.getName() + ".tocReference";
        String name2 = "title.textField1";
        elementCountTest(name1, 1);
        anchorName = labelExpression1.getName() + "_0";
        elementValueTest(name1, 0, "");
        JRPrintText reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals(anchorName, reference.getAnchorName(),"reference anchorName " + name1);
        elementValueTest(name2, 1, "text1");
        reference = (JRPrintText) getElementAt(name2, 1);
        Assertions.assertEquals(anchorName, reference.getAnchorName(),"reference anchorName " + name2);

        name1 = labelExpression2.getName() + ".tocReference";
        name2 = "title.textField1";
        elementCountTest(name1, 1);
        anchorName = labelExpression2.getName() + "_0";
        elementValueTest(name1, 0, "");
        reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals(anchorName, reference.getAnchorName(),"reference anchorName " + name1);
        elementValueTest(name2, 2, "text2");
        reference = (JRPrintText) getElementAt(name2, 2);
        Assertions.assertEquals(anchorName, reference.getAnchorName(),"reference anchorName " + name2);

        name1 = labelExpression3.getName() + ".tocReference";
        name2 = "title.textField1";
        elementCountTest(name1, 1);
        anchorName = labelExpression3.getName() + "_0";
        elementValueTest(name1, 0, "");
        reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals(anchorName, reference.getAnchorName(),"reference anchorName " + name1);
        elementValueTest(name2, 3, "text3");
        reference = (JRPrintText) getElementAt(name2, 3);
        Assertions.assertEquals(anchorName, reference.getAnchorName(),"reference anchorName " + name2);

        name1 = labelExpression4.getName() + ".tocReference";
        name2 = "title.textField2";
        elementCountTest(name1, 1);
        anchorName = labelExpression4.getName() + "_0";
        elementValueTest(name1, 0, "");
        reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals(anchorName, reference.getAnchorName(),"reference anchorName " + name1);
        elementValueTest(name2, 0, "text4");
        reference = (JRPrintText) getElementAt(name2, 0);
        Assertions.assertEquals(anchorName, reference.getAnchorName(),"reference anchorName " + name2);

        name1 = labelExpression5.getName() + ".tocReference";
        name2 = "title.textField1";
        elementCountTest(name1, 1);
        anchorName = labelExpression5.getName() + "_0";
        elementValueTest(name1, 0, "");
        reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals(anchorName, reference.getAnchorName(),"reference anchorName " + name1);
        elementValueTest(name2, 4, "text5");
        reference = (JRPrintText) getElementAt(name2, 4);
        Assertions.assertEquals( anchorName, reference.getAnchorName(),"reference anchorName " + name2);

        name1 = labelExpression6.getName() + ".tocReference";
        name2 = "summary.textField1";
        elementCountTest(name1, 1);
        anchorName = labelExpression6.getName() + "_0";
        elementValueTest(name1, 0, "");
        reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals( anchorName, reference.getAnchorName(),"reference anchorName " + name1);
        elementValueTest(name2, 0, "text6");
        reference = (JRPrintText) getElementAt(name2, 0);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name2);
    }
}

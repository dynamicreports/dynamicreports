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
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.tableOfContentsHeading;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRPrintText;
import net.sf.jasperreports.engine.util.JRStyledTextUtil;

/**
 * @author Ricardo Mariaca
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TableOfContents2Test extends AbstractJasperValueTest {
    private TextColumnBuilder<String> column1;
    private DRIExpression<String> labelExpression1;
    private DRIExpression<String> labelExpression2;
    private DRIExpression<String> labelExpression3;
    private DRIExpression<String> labelExpression4;
    private DRIExpression<String> labelExpression5;
    private DRIExpression<String> labelExpression6;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        labelExpression1 = exp.text("title");
        labelExpression2 = exp.text("summary");
        final TextFieldBuilder<String> textField = cmp.text("text2");
        labelExpression3 = textField.getComponent().getValueExpression();
        final TextFieldBuilder<String> textField3 = cmp.text("text3");
        labelExpression6 = textField3.getComponent().getValueExpression();

        rb.tableOfContents()
          .title(cmp.text("text").setTableOfContentsHeading(tableOfContentsHeading().setLabel(labelExpression1)))
          .columns(column1 = col.column("Column1", "field1", type.stringType()))
          .summary(cmp.text("text").setTableOfContentsHeading(tableOfContentsHeading().setLabel(labelExpression2)), textField.setTableOfContentsHeading(tableOfContentsHeading()),
                   cmp.line().setTableOfContentsHeading(tableOfContentsHeading()), cmp.subreport(createSubreport1()),
                   textField3.setTableOfContentsHeading(tableOfContentsHeading()).setAnchorName("Custom anchor text"));
    }

    private JasperReportBuilder createSubreport1() {
        final TextFieldBuilder<String> textField = cmp.text("text3");
        labelExpression4 = textField.getComponent().getValueExpression();

        final JasperReportBuilder report = report();
        report.title(textField.setTableOfContentsHeading(tableOfContentsHeading()));
        report.title(cmp.subreport(createSubreport2()));
        return report;
    }

    private JasperReportBuilder createSubreport2() {
        final TextFieldBuilder<String> textField = cmp.text("text4");
        labelExpression5 = textField.getComponent().getValueExpression();

        final JasperReportBuilder report = report();
        report.title(textField.setTableOfContentsHeading(tableOfContentsHeading()));
        return report;
    }

    @Override
    @Test
    public void test() {
        super.test();

        numberOfPagesTest(2);

        elementValueTest("title.textField1", "Table of contents");

        elementCountTest("detail.textField1", 7);

        String anchorName = labelExpression1.getName() + "_0";
        elementValueTest("detail.textField1", 0, "title");
        JRPrintText text = (JRPrintText) getElementAt("detail.textField1", 0);
        Assertions.assertEquals( anchorName, text.getHyperlinkAnchor(), "text anchor");
        JRPrintText dots = (JRPrintText) getElementAt("detail.textField2", 0);
        String value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."), "dots");
        Assertions.assertEquals( anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        JRPrintText pageIndex = (JRPrintText) getElementAt("detail.textField3", 0);
        Assertions.assertEquals( anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        anchorName = labelExpression2.getName() + "_8";
        elementValueTest("detail.textField1", 1, "summary");
        text = (JRPrintText) getElementAt("detail.textField1", 1);
        Assertions.assertEquals( anchorName, text.getHyperlinkAnchor(), "text anchor");
        dots = (JRPrintText) getElementAt("detail.textField2", 1);
        value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."), "dots");
        Assertions.assertEquals( anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        pageIndex = (JRPrintText) getElementAt("detail.textField3", 1);
        Assertions.assertEquals( anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        anchorName = labelExpression3.getName() + "_8";
        elementValueTest("detail.textField1", 2, "text2");
        text = (JRPrintText) getElementAt("detail.textField1", 2);
        Assertions.assertEquals( anchorName, text.getHyperlinkAnchor(), "text anchor");
        dots = (JRPrintText) getElementAt("detail.textField2", 2);
        value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."), "dots");
        Assertions.assertEquals( anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        pageIndex = (JRPrintText) getElementAt("detail.textField3", 2);
        Assertions.assertEquals( anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        anchorName = labelExpression4.getName() + "_0";
        elementValueTest("detail.textField1", 4, "text3");
        text = (JRPrintText) getElementAt("detail.textField1", 4);
        Assertions.assertEquals( anchorName, text.getHyperlinkAnchor(), "text anchor");
        dots = (JRPrintText) getElementAt("detail.textField2", 4);
        value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."), "dots");
        Assertions.assertEquals( anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        pageIndex = (JRPrintText) getElementAt("detail.textField3", 4);
        Assertions.assertEquals( anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        anchorName = labelExpression5.getName() + "_0";
        elementValueTest("detail.textField1", 5, "text4");
        text = (JRPrintText) getElementAt("detail.textField1", 5);
        Assertions.assertEquals( anchorName, text.getHyperlinkAnchor(), "text anchor");
        dots = (JRPrintText) getElementAt("detail.textField2", 5);
        value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."), "dots");
        Assertions.assertEquals( anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        pageIndex = (JRPrintText) getElementAt("detail.textField3", 5);
        Assertions.assertEquals( anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        anchorName = "Custom anchor text";
        elementValueTest("detail.textField1", 6, "text3");
        text = (JRPrintText) getElementAt("detail.textField1", 6);
        Assertions.assertEquals( anchorName, text.getHyperlinkAnchor(), "text anchor");
        dots = (JRPrintText) getElementAt("detail.textField2", 6);
        value = JRStyledTextUtil.getInstance(DefaultJasperReportsContext.getInstance()).getTruncatedText(dots);
        Assertions.assertTrue(StringUtils.containsOnly(value, "."), "dots");
        Assertions.assertEquals( anchorName, dots.getHyperlinkAnchor(), "dots anchor");
        pageIndex = (JRPrintText) getElementAt("detail.textField3", 6);
        Assertions.assertEquals( anchorName, pageIndex.getHyperlinkAnchor(), "pageIndex anchor");

        elementValueTest("detail.textField3", "1", "1", "1", "1", "1", "1", "1");

        String name1 = labelExpression1.getName() + ".tocReference";
        String name2 = "title.textField1";
        elementCountTest(name1, 1);
        anchorName = labelExpression1.getName() + "_0";
        elementValueTest(name1, 0, "");
        JRPrintText reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name1);
        elementValueTest(name2, 1, "text");
        reference = (JRPrintText) getElementAt(name2, 1);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name2);

        name1 = labelExpression2.getName() + ".tocReference";
        name2 = "summary.textField1";
        elementCountTest(name1, 1);
        anchorName = labelExpression2.getName() + "_8";
        elementValueTest(name1, 0, "");
        reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name1);
        elementValueTest(name2, 0, "text");
        reference = (JRPrintText) getElementAt(name2, 0);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name2);

        name1 = labelExpression3.getName() + ".tocReference";
        name2 = "summary.textField2";
        elementCountTest(name1, 1);
        anchorName = labelExpression3.getName() + "_8";
        elementValueTest(name1, 0, "");
        reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name1);
        elementValueTest(name2, 0, "text2");
        reference = (JRPrintText) getElementAt(name2, 0);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name2);

        name1 = labelExpression4.getName() + ".tocReference";
        name2 = "title.textField1";
        elementCountTest(name1, 1);
        anchorName = labelExpression4.getName() + "_0";
        elementValueTest(name1, 0, "");
        reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name1);
        elementValueTest(name2, 2, "text3");
        reference = (JRPrintText) getElementAt(name2, 2);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name2);

        name1 = labelExpression5.getName() + ".tocReference";
        name2 = "title.textField1";
        elementCountTest(name1, 1);
        anchorName = labelExpression5.getName() + "_0";
        elementValueTest(name1, 0, "");
        reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name1);
        elementValueTest(name2, 3, "text4");
        reference = (JRPrintText) getElementAt(name2, 3);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name2);

        name1 = labelExpression6.getName() + ".tocReference";
        name2 = "summary.textField3";
        elementCountTest(name1, 1);
        anchorName = "Custom anchor text";
        elementValueTest(name1, 0, "");
        reference = (JRPrintText) getElementAt(name1, 0);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name1);
        elementValueTest(name2, 0, "text3");
        reference = (JRPrintText) getElementAt(name2, 0);
        Assertions.assertEquals( anchorName, reference.getAnchorName(), "reference anchorName " + name2);

        columnTitleCountTest(column1, 1);
        columnTitleValueTest(column1, "Column1");
        columnDetailCountTest(column1, 8);
        columnDetailValueTest(column1, 7, "text");
    }

    @Override
    protected JRDataSource createDataSource() {
        final DRDataSource dataSource = new DRDataSource("field1");
        for (int i = 0; i < 8; i++) {
            dataSource.add("text");
        }
        return dataSource;
    }
}

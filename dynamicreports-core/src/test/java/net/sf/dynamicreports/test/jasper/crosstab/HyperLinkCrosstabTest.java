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
package net.sf.dynamicreports.test.jasper.crosstab;

import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;
import static net.sf.dynamicreports.report.builder.DynamicReports.hyperLink;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.crosstab.AbstractCrosstabGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.builder.expression.AbstractComplexExpression;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabValueTest;
import net.sf.dynamicreports.test.jasper.JasperTestUtils;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRPrintElement;
import net.sf.jasperreports.engine.JRPrintText;

/**
 * @author Ricardo Mariaca
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HyperLinkCrosstabTest extends AbstractJasperCrosstabValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private CrosstabRowGroupBuilder<String> rowGroup;
    private CrosstabColumnGroupBuilder<String> columnGroup;
    private CrosstabMeasureBuilder<Integer> measure;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rowGroup = ctab.rowGroup("field1", String.class);
        rowGroup.setHeaderHyperLink(hyperLink(new HyperLinkExpression1(rowGroup)));
        columnGroup = ctab.columnGroup("field2", String.class);
        columnGroup.setHeaderHyperLink(hyperLink(new HyperLinkExpression1(columnGroup)));
        measure = ctab.measure("field3", Integer.class, Calculation.SUM);
        measure.setHyperLink(hyperLink(new HyperLinkExpression2(rowGroup, columnGroup, measure)));

        final CrosstabBuilder crosstab = ctab.crosstab().rowGroups(rowGroup).columnGroups(columnGroup).measures(measure);

        rb.setLocale(Locale.ENGLISH).summary(crosstab);
    }

    @Override
    @Test
    public void test() {
        super.test();

        numberOfPagesTest(1);

        setCrosstabBand("summary");

        List<JRPrintElement> elements = findElement(getPrefix(1) + JasperTestUtils.getCrosstabGroupHeaderName(rowGroup));
        Assertions.assertEquals(2, elements.size(),"Row group size");
        JRPrintText element = (JRPrintText) elements.get(0);
        Assertions.assertEquals( "a", element.getHyperlinkReference(), "Row group link");
        element = (JRPrintText) elements.get(1);
        Assertions.assertEquals( "b", element.getHyperlinkReference(), "Row group link");

        elements = findElement(getPrefix(1) + JasperTestUtils.getCrosstabGroupHeaderName(columnGroup));
        Assertions.assertEquals(2, elements.size(),"Column group size");
        element = (JRPrintText) elements.get(0);
        Assertions.assertEquals( "c", element.getHyperlinkReference(), "Column group link");
        element = (JRPrintText) elements.get(1);
        Assertions.assertEquals( "d", element.getHyperlinkReference(),"Column group link");

        elements = findElement(getPrefix(1) + JasperTestUtils.getCrosstabCellName(measure, null, null));
        Assertions.assertEquals(4, elements.size(),"Column group size");
        element = (JRPrintText) elements.get(0);
        Assertions.assertEquals( "a c 3", element.getHyperlinkReference(), "Column group link");
        element = (JRPrintText) elements.get(1);
        Assertions.assertEquals( "a d 7", element.getHyperlinkReference(), "Column group link");
        element = (JRPrintText) elements.get(2);
        Assertions.assertEquals( "b c 11", element.getHyperlinkReference(), "Column group link");
        element = (JRPrintText) elements.get(3);
        Assertions.assertEquals( "b d 15", element.getHyperlinkReference(),"Column group link");
    }

    @Override
    protected JRDataSource createDataSource() {
        final DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        dataSource.add("a", "c", 1);
        dataSource.add("a", "c", 2);
        dataSource.add("a", "d", 3);
        dataSource.add("a", "d", 4);
        dataSource.add("b", "c", 5);
        dataSource.add("b", "c", 6);
        dataSource.add("b", "d", 7);
        dataSource.add("b", "d", 8);
        return dataSource;
    }

    private class HyperLinkExpression1 extends AbstractComplexExpression<String> {
        private static final long serialVersionUID = 1L;

        public HyperLinkExpression1(AbstractCrosstabGroupBuilder<?, ?, ?> group) {
            addExpression(group);
        }

        @Override
        public String evaluate(List<?> values, ReportParameters reportParameters) {
            return (String) values.get(0);
        }

    }

    private class HyperLinkExpression2 extends AbstractComplexExpression<String> {
        private static final long serialVersionUID = 1L;

        public HyperLinkExpression2(AbstractCrosstabGroupBuilder<?, ?, ?> group1, AbstractCrosstabGroupBuilder<?, ?, ?> group2, CrosstabMeasureBuilder<?> measure) {
            addExpression(group1);
            addExpression(group2);
            addExpression(measure);
        }

        @Override
        public String evaluate(List<?> values, ReportParameters reportParameters) {
            return values.get(0) + " " + values.get(1) + " " + values.get(2);
        }

    }
}

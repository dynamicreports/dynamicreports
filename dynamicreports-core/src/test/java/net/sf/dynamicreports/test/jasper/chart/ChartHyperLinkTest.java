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
package net.sf.dynamicreports.test.jasper.chart;

import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.hyperLink;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperChartTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintImage;
import net.sf.jasperreports.engine.JRPrintImageAreaHyperlink;
import net.sf.jasperreports.renderers.AreaHyperlinksRenderable;

/**
 * @author Ricardo Mariaca
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ChartHyperLinkTest extends AbstractJasperChartTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1;
        TextColumnBuilder<Integer> column2;

        rb.columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class))
          .summary(cht.barChart().setCategory(column1).setItemHyperLink(hyperLink().setTooltip(new TooltipExpression("1"))).series(cht.serie(column2)), cht.barChart()
                                                                                                                                                           .setCategory(column1)
                                                                                                                                                           .series(cht.serie(column2)
                                                                                                                                                                      .setLabel("1")
                                                                                                                                                                      .setItemHyperLink(
                                                                                                                                                                          hyperLink().setTooltip(
                                                                                                                                                                              new TooltipExpression(
                                                                                                                                                                                  "2"))),
                                                                                                                                                                   cht.serie(column2).setLabel("2"))
                                                                                                                                                           .setItemHyperLink(hyperLink().setTooltip(
                                                                                                                                                               new TooltipExpression("3"))));
    }

    @Override
    protected boolean serializableTest() {
        return false;
    }

    @Override
    @Test
    public void test() {
        super.test();

        numberOfPagesTest(1);

        JRPrintImage image = (JRPrintImage) getElementAt("summary.chart1", 0);
        AreaHyperlinksRenderable renderer = (AreaHyperlinksRenderable) image.getRenderer();
        Rectangle renderingArea = new Rectangle(0, 0, image.getWidth(), image.getHeight());
        try {
            final List<JRPrintImageAreaHyperlink> imageAreaHyperlinks = renderer.getImageAreaHyperlinks(renderingArea);
            Assertions.assertEquals("1_value1_1", imageAreaHyperlinks.get(0).getHyperlink().getHyperlinkTooltip());
            Assertions.assertEquals("1_value2_2", imageAreaHyperlinks.get(1).getHyperlink().getHyperlinkTooltip());
            Assertions.assertEquals("1_value3_3", imageAreaHyperlinks.get(2).getHyperlink().getHyperlinkTooltip());
            Assertions.assertEquals("1_value4_4", imageAreaHyperlinks.get(3).getHyperlink().getHyperlinkTooltip());
        } catch (final JRException e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }

        image = (JRPrintImage) getElementAt("summary.chart2", 0);
        renderer = (AreaHyperlinksRenderable) image.getRenderer();
        renderingArea = new Rectangle(0, 0, image.getWidth(), image.getHeight());
        try {
            final List<JRPrintImageAreaHyperlink> imageAreaHyperlinks = renderer.getImageAreaHyperlinks(renderingArea);
            Assertions.assertEquals("2_value1_1", imageAreaHyperlinks.get(0).getHyperlink().getHyperlinkTooltip());
            Assertions.assertEquals("3_value1_1", imageAreaHyperlinks.get(1).getHyperlink().getHyperlinkTooltip());
            Assertions.assertEquals("2_value2_2", imageAreaHyperlinks.get(2).getHyperlink().getHyperlinkTooltip());
            Assertions.assertEquals("3_value2_2", imageAreaHyperlinks.get(3).getHyperlink().getHyperlinkTooltip());
            Assertions.assertEquals("2_value3_3", imageAreaHyperlinks.get(4).getHyperlink().getHyperlinkTooltip());
            Assertions.assertEquals("3_value3_3", imageAreaHyperlinks.get(5).getHyperlink().getHyperlinkTooltip());
            Assertions.assertEquals("2_value4_4", imageAreaHyperlinks.get(6).getHyperlink().getHyperlinkTooltip());
            Assertions.assertEquals("3_value4_4", imageAreaHyperlinks.get(7).getHyperlink().getHyperlinkTooltip());
        } catch (final JRException e) {
            e.printStackTrace();
            Assertions.fail(e.getMessage());
        }
    }

    @Override
    protected JRDataSource createDataSource() {
        final DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 4; i++) {
            dataSource.add("value" + (i + 1), i + 1);
        }
        return dataSource;
    }

    private class TooltipExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;
        private final String name;

        public TooltipExpression(String name) {
            this.name = name;
        }

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return name + "_" + reportParameters.getValue("field1") + "_" + reportParameters.getValue("field2");
        }
    }
}

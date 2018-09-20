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
package net.sf.dynamicreports.test.design.report;

import junit.framework.Assert;
import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.DRDesignReport;
import net.sf.dynamicreports.design.base.barcode.DRDesignBarcode;
import net.sf.dynamicreports.design.base.chart.DRDesignChart;
import net.sf.dynamicreports.design.base.chart.plot.AbstractDesignBasePlot;
import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.base.component.DRDesignImage;
import net.sf.dynamicreports.design.base.component.DRDesignList;
import net.sf.dynamicreports.design.base.component.DRDesignTextField;
import net.sf.dynamicreports.design.base.crosstab.DRDesignCrosstab;
import net.sf.dynamicreports.design.definition.component.DRIDesignList;
import net.sf.dynamicreports.design.definition.style.DRIDesignStyle;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.constant.Language;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.constant.SplitType;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.dynamicreports.test.design.DesignReportBuilder;
import org.junit.Test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.bcode;
import static net.sf.dynamicreports.report.builder.DynamicReports.cht;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.margin;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ReportTemplateTest {

    private void configureReport(ReportBuilder<?> rb) {
        TextColumnBuilder<Integer> column1;

        rb.columns(column1 = col.column("Column1", "field1", Integer.class), col.booleanColumn("Column2", "field2"))
          .groupBy(grp.group(column1)
                      .header(cmp.horizontalList(cmp.hListCell(cmp.text(""))
                                                    .widthFixed())))
          .title(cmp.horizontalList(cmp.hListCell(cmp.image(""))
                                       .widthFixed()
                                       .heightFixedOnTop(), cmp.hListCell(cht.barChart())
                                                               .widthFixed()
                                                               .heightFixedOnTop(), cmp.hListCell(bcode.ean128("12345678"))
                                                                                       .widthFixed()
                                                                                       .heightFixedOnTop(), cmp.hListCell(ctab.crosstab()
                                                                                                                              .rowGroups(ctab.rowGroup("f1", String.class))
                                                                                                                              .columnGroups(ctab.columnGroup("f2", String.class),
                                                                                                                                            ctab.columnGroup("f3", String.class))
                                                                                                                              .measures(ctab.measure("f4", "f4", Integer.class, Calculation.SUM)))
                                                                                                               .widthFixed()
                                                                                                               .heightFixedOnTop()))
          .setTemplate(template().setLocale(Locale.ENGLISH)
                                 .setShowColumnTitle(false)
                                 .setIgnorePagination(true)
                                 .setWhenNoDataType(WhenNoDataType.ALL_SECTIONS_NO_DETAIL)
                                 .setWhenResourceMissingType(WhenResourceMissingType.KEY)
                                 .setTitleOnANewPage(true)
                                 .setSummaryOnANewPage(true)
                                 .setSummaryWithPageHeaderAndFooter(true)
                                 .setFloatColumnFooter(true)
                                 .setPrintOrder(Orientation.HORIZONTAL)
                                 .setColumnDirection(RunDirection.RIGHT_TO_LEFT)
                                 .setLanguage(Language.GROOVY)

                                 .setHighlightDetailOddRows(true)
                                 .setDetailOddRowStyle(stl.simpleStyle()
                                                          .setBackgroundColor(Color.BLUE))
                                 .setHighlightDetailEvenRows(true)
                                 .setDetailEvenRowStyle(stl.simpleStyle()
                                                           .setBackgroundColor(Color.CYAN))
                                 .setDefaultFont(stl.font()
                                                    .setFontSize(12))
                                 .setTextStyle(stl.style()
                                                  .bold())

                                 .setPageFormat(PageType.A3, PageOrientation.LANDSCAPE)
                                 .setPageMargin(margin(3))
                                 .setPageColumnsPerPage(3)
                                 .setPageColumnSpace(20)

                                 .setColumnPrintRepeatedDetailValues(false)
                                 .setColumnWidth(250)

                                 .setGroupHeaderLayout(GroupHeaderLayout.TITLE_AND_VALUE)
                                 .setGroupHideColumn(false)
                                 .setGroupShowColumnHeaderAndFooter(true)
                                 .setGroupPadding(20)
                                 .setGroupStartInNewPage(true)
                                 .setGroupStartInNewColumn(true)
                                 .setGroupReprintHeaderOnEachPage(true)
                                 .setGroupHeaderWithSubtotal(true)

                                 .setTextFieldWidth(150)

                                 .setImageWidth(110)
                                 .setImageHeight(120)

                                 .setListgap(10)

                                 .setChartWidth(210)
                                 .setChartHeight(220)
                                 .chartSeriesColors(Color.BLUE)
                                 .setChartTheme("customTheme")

                                 .setBarcodeWidth(110)
                                 .setBarcodeHeight(120)

                                 .setCrosstabWidth(90)
                                 .setCrosstabHeight(101)
                                 .setCrosstabHighlightOddRows(true)
                                 .setCrosstabOddRowStyle(stl.simpleStyle()
                                                            .setBackgroundColor(Color.ORANGE))
                                 .setCrosstabHighlightEvenRows(true)
                                 .setCrosstabEvenRowStyle(stl.simpleStyle()
                                                             .setBackgroundColor(Color.MAGENTA))
                                 .setCrosstabGroupStyle(stl.style()
                                                           .setBackgroundColor(Color.RED))
                                 .setCrosstabGroupTotalStyle(stl.style()
                                                                .setBackgroundColor(Color.ORANGE))
                                 .setCrosstabGrandTotalStyle(stl.style()
                                                                .setBackgroundColor(Color.BLUE))
                                 .setCrosstabCellStyle(stl.style()
                                                          .setBackgroundColor(Color.CYAN))
                                 .setCrosstabMeasureTitleStyle(stl.style()
                                                                  .setBackgroundColor(Color.YELLOW))

                                 .setBooleanColumnStyle(stl.style(stl.pen1Point()))

                                 .setDetailSplitType(SplitType.IMMEDIATE));
    }

    @Test
    public void test() {
        @SuppressWarnings("rawtypes") ReportBuilder rb = new DesignReportBuilder();
        configureReport(rb);
        try {
            DRDesignReport report = new DRDesignReport(rb.getReport());
            Assert.assertEquals("locale", Locale.ENGLISH, report.getLocale());
            Assert.assertNull("show column title", report.getColumnHeaderBand());
            Assert.assertTrue("ignore pagination", report.isIgnorePagination());
            Assert.assertEquals("when no data type", WhenNoDataType.ALL_SECTIONS_NO_DETAIL, report.getWhenNoDataType());
            Assert.assertEquals("when resource missing type", WhenResourceMissingType.KEY, report.getWhenResourceMissingType());
            Assert.assertTrue("title on a new page", report.isTitleOnANewPage());
            Assert.assertTrue("summary on a new page", report.isSummaryOnANewPage());
            Assert.assertTrue("summary with page header and footer", report.isSummaryWithPageHeaderAndFooter());
            Assert.assertTrue("float column footer", report.isFloatColumnFooter());
            Assert.assertEquals("print order", Orientation.HORIZONTAL, report.getPrintOrder());
            Assert.assertEquals("column direction", RunDirection.RIGHT_TO_LEFT, report.getColumnDirection());
            Assert.assertEquals("language", Language.GROOVY, report.getLanguage());

            DRDesignTextField columnTextField1 = (DRDesignTextField) ((DRDesignList) report.getDetailBands()
                                                                                           .get(0)
                                                                                           .getBandComponent()).getComponents()
                                                                                                               .get(0);
            DRIDesignStyle style = columnTextField1.getStyle();
            Assert.assertEquals("detail odd row style", Color.BLUE, style.getConditionalStyles()
                                                                         .get(0)
                                                                         .getBackgroundColor());
            Assert.assertEquals("detail even row style", Color.CYAN, style.getConditionalStyles()
                                                                          .get(1)
                                                                          .getBackgroundColor());
            Assert.assertEquals("default font", new Integer(12), style.getParentStyle()
                                                                      .getFont()
                                                                      .getFontSize());
            Assert.assertTrue("text style bold", style.getParentStyle()
                                                      .getFont()
                                                      .getBold());

            Assert.assertEquals("page width", 1190, report.getPage()
                                                          .getWidth());
            Assert.assertEquals("page height", 842, report.getPage()
                                                          .getHeight());
            Assert.assertEquals("page orientation", PageOrientation.LANDSCAPE, report.getPage()
                                                                                     .getOrientation());
            Assert.assertEquals("page margin", 3, report.getPage()
                                                        .getMargin()
                                                        .getLeft());
            Assert.assertEquals("page columns per page", 3, report.getPage()
                                                                  .getColumnsPerPage());
            Assert.assertEquals("page columns spac", 20, report.getPage()
                                                               .getColumnSpace());

            Assert.assertFalse("column print repeated detail values", columnTextField1.isPrintRepeatedValues());
            Assert.assertEquals("column width", new Integer(180), columnTextField1.getWidth());

            DRDesignTextField columnTextField2 = (DRDesignTextField) ((DRDesignList) report.getDetailBands()
                                                                                           .get(0)
                                                                                           .getBandComponent()).getComponents()
                                                                                                               .get(1);
            style = columnTextField2.getStyle();
            Assert.assertEquals("detail odd row style", Color.BLUE, style.getConditionalStyles()
                                                                         .get(0)
                                                                         .getBackgroundColor());
            Assert.assertEquals("detail even row style", Color.CYAN, style.getConditionalStyles()
                                                                          .get(1)
                                                                          .getBackgroundColor());
            Assert.assertEquals("boolean border", 1f, style.getParentStyle()
                                                           .getBorder()
                                                           .getTopPen()
                                                           .getLineWidth());
            Assert.assertEquals("column width", new Integer(181), columnTextField2.getWidth());

            DRDesignGroup group = (DRDesignGroup) report.getGroups()
                                                        .toArray()[0];
            DRDesignComponent textField = group.getHeaderBands()
                                               .get(1)
                                               .getBandComponent();
            Assert.assertEquals("group header layout", 2, ((DRDesignList) group.getHeaderBands()
                                                                               .get(0)
                                                                               .getBandComponent()).getComponents()
                                                                                                   .size());
            Assert.assertEquals("group header layout", "groupHeader.textField1", textField.getUniqueName());
            Assert.assertEquals("group padding", new Integer(20), columnTextField1.getX());
            Assert.assertTrue("group start in new page", group.isStartInNewPage());
            Assert.assertTrue("group start in new column", group.isStartInNewColumn());
            Assert.assertTrue("group reprint header on each page", group.isReprintHeaderOnEachPage());
            Assert.assertTrue("group header with subtotal", group.isHeaderWithSubtotal());

            Assert.assertEquals("text field width", new Integer(150), textField.getWidth());

            DRDesignList titleList = (DRDesignList) report.getTitleBand()
                                                          .getBandComponent();
            Assert.assertEquals("list gap", 10, titleList.getGap());

            DRDesignComponent image = titleList.getComponents()
                                               .get(0);
            Assert.assertEquals("image width", new Integer(110), image.getWidth());
            Assert.assertEquals("image height", new Integer(120), image.getHeight());

            DRDesignComponent chart = titleList.getComponents()
                                               .get(1);
            Assert.assertEquals("chart width", new Integer(210), chart.getWidth());
            Assert.assertEquals("chart height", new Integer(220), chart.getHeight());
            Assert.assertEquals("chart colors", Color.BLUE, ((AbstractDesignBasePlot) ((DRDesignChart) chart).getPlot()).getSeriesColors()
                                                                                                                        .get(0));
            Assert.assertEquals("chart theme", "customTheme", ((DRDesignChart) chart).getTheme());

            DRDesignComponent barcode = titleList.getComponents()
                                                 .get(2);
            Assert.assertEquals("barcode width", new Integer(110), barcode.getWidth());
            Assert.assertEquals("barcode height", new Integer(120), barcode.getHeight());

            DRDesignCrosstab crosstab = (DRDesignCrosstab) titleList.getComponents()
                                                                    .get(3);
            Assert.assertEquals("crosstab width", new Integer(90), crosstab.getWidth());
            Assert.assertEquals("crosstab height", new Integer(101), crosstab.getHeight());
            style = crosstab.getCells()
                            .get(0)
                            .getContent()
                            .getComponent()
                            .getStyle();
            Assert.assertEquals("crosstab odd row style", new Color(63, 241, 191), style.getConditionalStyles()
                                                                                        .get(0)
                                                                                        .getBackgroundColor());
            Assert.assertEquals("crosstab even row style", new Color(63, 191, 255), style.getConditionalStyles()
                                                                                         .get(1)
                                                                                         .getBackgroundColor());
            Assert.assertEquals("crosstab cell style", Color.CYAN, style.getParentStyle()
                                                                        .getBackgroundColor());
            style = crosstab.getColumnGroups()
                            .get(0)
                            .getHeader()
                            .getComponent()
                            .getStyle();
            Assert.assertEquals("crosstab column header style", Color.RED, style.getBackgroundColor());
            style = ((DRIDesignList) crosstab.getColumnGroups()
                                             .get(0)
                                             .getTotalHeader()
                                             .getComponent()).getComponents()
                                                             .get(0)
                                                             .getStyle();
            Assert.assertEquals("crosstab column total header style", Color.BLUE, style.getBackgroundColor());
            style = ((DRIDesignList) crosstab.getColumnGroups()
                                             .get(1)
                                             .getHeader()
                                             .getComponent()).getComponents()
                                                             .get(0)
                                                             .getStyle();
            Assert.assertEquals("crosstab column header style", Color.RED, style.getBackgroundColor());
            style = ((DRIDesignList) crosstab.getColumnGroups()
                                             .get(1)
                                             .getTotalHeader()
                                             .getComponent()).getComponents()
                                                             .get(0)
                                                             .getStyle();
            Assert.assertEquals("crosstab column total header style", Color.ORANGE, style.getBackgroundColor());
            style = ((DRIDesignList) crosstab.getRowGroups()
                                             .get(0)
                                             .getHeader()
                                             .getComponent()).getComponents()
                                                             .get(0)
                                                             .getStyle();
            Assert.assertEquals("crosstab row header style", Color.RED, style.getBackgroundColor());
            style = crosstab.getRowGroups()
                            .get(0)
                            .getTotalHeader()
                            .getComponent()
                            .getStyle();
            Assert.assertEquals("crosstab row total header style", Color.BLUE, style.getBackgroundColor());

            style = crosstab.getColumnGroups()
                            .get(0)
                            .getHeader()
                            .getStyle();
            Assert.assertEquals("crosstab column header style", Color.RED, style.getBackgroundColor());
            style = crosstab.getColumnGroups()
                            .get(0)
                            .getTotalHeader()
                            .getStyle();
            Assert.assertEquals("crosstab column total header style", Color.BLUE, style.getBackgroundColor());
            style = crosstab.getColumnGroups()
                            .get(1)
                            .getHeader()
                            .getStyle();
            Assert.assertEquals("crosstab column header style", Color.RED, style.getBackgroundColor());
            style = crosstab.getColumnGroups()
                            .get(1)
                            .getTotalHeader()
                            .getStyle();
            Assert.assertEquals("crosstab column total header style", Color.ORANGE, style.getBackgroundColor());
            style = crosstab.getRowGroups()
                            .get(0)
                            .getHeader()
                            .getStyle();
            Assert.assertEquals("crosstab row header style", Color.RED, style.getBackgroundColor());
            style = crosstab.getRowGroups()
                            .get(0)
                            .getTotalHeader()
                            .getStyle();
            Assert.assertEquals("crosstab row total header style", Color.BLUE, style.getBackgroundColor());

            style = ((DRIDesignList) crosstab.getColumnGroups()
                                             .get(0)
                                             .getTotalHeader()
                                             .getComponent()).getComponents()
                                                             .get(1)
                                                             .getStyle();
            Assert.assertEquals("crosstab measure title header style", Color.YELLOW, style.getBackgroundColor());
            style = ((DRIDesignList) crosstab.getColumnGroups()
                                             .get(1)
                                             .getHeader()
                                             .getComponent()).getComponents()
                                                             .get(1)
                                                             .getStyle();
            Assert.assertEquals("crosstab measure title header style", Color.YELLOW, style.getBackgroundColor());
            style = ((DRIDesignList) crosstab.getColumnGroups()
                                             .get(1)
                                             .getTotalHeader()
                                             .getComponent()).getComponents()
                                                             .get(1)
                                                             .getStyle();
            Assert.assertEquals("crosstab measure title header style", Color.YELLOW, style.getBackgroundColor());

            Assert.assertEquals("detail split type", SplitType.IMMEDIATE, report.getDetailBands()
                                                                                .get(0)
                                                                                .getSplitType());
        } catch (DRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void styleTest() {
        ReportBuilder<?> rb = new DesignReportBuilder();
        TextColumnBuilder<Integer> column1;

        rb.columns(column1 = col.column("Column1", "field1", Integer.class))
          .groupBy(grp.group(column1)
                      .setHeaderLayout(GroupHeaderLayout.TITLE_AND_VALUE)
                      .setHideColumn(false))
          .subtotalsAtSummary(sbt.sum(column1))
          .title(cmp.image(""), cht.areaChart()
                                   .setCategory("field2", String.class), bcode.ean128("12345678"))
          .setTemplate(template().setColumnStyle(stl.style()
                                                    .setFontSize(1))
                                 .setColumnTitleStyle(stl.style()
                                                         .setFontSize(2))
                                 .setGroupStyle(stl.style()
                                                   .setFontSize(3))
                                 .setGroupTitleStyle(stl.style()
                                                        .setFontSize(4))
                                 .setSubtotalStyle(stl.style()
                                                      .setFontSize(5))
                                 .setImageStyle(stl.style()
                                                   .setBorder(stl.pen1Point()))
                                 .setChartStyle(stl.style()
                                                   .setBorder(stl.pen2Point()))
                                 .setBarcodeStyle(stl.style()
                                                     .setBorder(stl.pen()
                                                                   .setLineWidth(3f))));
        try {
            DRDesignReport report = new DRDesignReport(rb.getReport());

            DRDesignTextField textField = (DRDesignTextField) ((DRDesignList) report.getDetailBands()
                                                                                    .get(0)
                                                                                    .getBandComponent()).getComponents()
                                                                                                        .get(0);
            Assert.assertEquals("column style", new Integer(1), textField.getStyle()
                                                                         .getFont()
                                                                         .getFontSize());

            textField = (DRDesignTextField) ((DRDesignList) report.getColumnHeaderBand()
                                                                  .getBandComponent()).getComponents()
                                                                                      .get(1);
            Assert.assertEquals("column title style", new Integer(2), textField.getStyle()
                                                                               .getFont()
                                                                               .getFontSize());

            DRDesignList groupHeaderComponent = (DRDesignList) new ArrayList<DRDesignGroup>(report.getGroups()).get(0)
                                                                                                               .getHeaderBands()
                                                                                                               .get(0)
                                                                                                               .getBandComponent();
            textField = (DRDesignTextField) groupHeaderComponent.getComponents()
                                                                .get(1);
            Assert.assertEquals("group style", new Integer(3), textField.getStyle()
                                                                        .getFont()
                                                                        .getFontSize());

            textField = (DRDesignTextField) groupHeaderComponent.getComponents()
                                                                .get(0);
            Assert.assertEquals("group title style", new Integer(4), textField.getStyle()
                                                                              .getFont()
                                                                              .getFontSize());

            textField = (DRDesignTextField) ((DRDesignList) report.getSummaryBand()
                                                                  .getBandComponent()).getComponents()
                                                                                      .get(0);
            Assert.assertEquals("subtotal style", new Integer(5), textField.getStyle()
                                                                           .getFont()
                                                                           .getFontSize());

            DRDesignImage image = (DRDesignImage) ((DRDesignList) report.getTitleBand()
                                                                        .getBandComponent()).getComponents()
                                                                                            .get(0);
            Assert.assertEquals("image style", new Float(1), image.getStyle()
                                                                  .getBorder()
                                                                  .getTopPen()
                                                                  .getLineWidth());

            DRDesignChart chart = (DRDesignChart) ((DRDesignList) report.getTitleBand()
                                                                        .getBandComponent()).getComponents()
                                                                                            .get(1);
            Assert.assertEquals("chart style", new Float(2), chart.getStyle()
                                                                  .getBorder()
                                                                  .getTopPen()
                                                                  .getLineWidth());

            DRDesignBarcode barcode = (DRDesignBarcode) ((DRDesignList) report.getTitleBand()
                                                                              .getBandComponent()).getComponents()
                                                                                                  .get(2);
            Assert.assertEquals("barcode style", new Float(3), barcode.getStyle()
                                                                      .getBorder()
                                                                      .getTopPen()
                                                                      .getLineWidth());
        } catch (DRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}

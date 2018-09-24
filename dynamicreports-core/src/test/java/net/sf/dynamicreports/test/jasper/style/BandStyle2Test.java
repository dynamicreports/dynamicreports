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

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.ReportTemplateBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperStyleTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.awt.Color;
import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.template;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class BandStyle2Test extends AbstractJasperStyleTest implements Serializable {
    private static final long serialVersionUID = 1L;

    Color color1 = new Color(240, 240, 240);
    Color color2 = new Color(230, 230, 230);
    Color color3 = new Color(220, 220, 220);
    Color color4 = new Color(210, 210, 210);
    Color color5 = new Color(190, 190, 190);
    Color color6 = new Color(180, 180, 180);
    Color color7 = new Color(170, 170, 170);
    Color color8 = new Color(160, 160, 160);
    Color color9 = new Color(150, 150, 150);
    Color color10 = new Color(140, 140, 140);
    Color color11 = new Color(130, 130, 130);
    Color color12 = new Color(120, 120, 120);
    Color color13 = new Color(110, 110, 110);

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1;
        TextColumnBuilder<Integer> column2;
        ColumnGroupBuilder group1;

        ReportTemplateBuilder template = template().setTitleStyle(stl.style().setBackgroundColor(color1))
                                                   .setPageHeaderStyle(stl.style().setBackgroundColor(color2))
                                                   .setPageFooterStyle(stl.style().setBackgroundColor(color3))
                                                   .setColumnHeaderStyle(stl.style().setBackgroundColor(color4))
                                                   .setColumnFooterStyle(stl.style().setBackgroundColor(color5))
                                                   .setGroupHeaderStyle(stl.style().setBackgroundColor(color6))
                                                   .setGroupFooterStyle(stl.style().setBackgroundColor(color7))
                                                   .setDetailHeaderStyle(stl.style().setBackgroundColor(color8))
                                                   .setDetailStyle(stl.style().setBackgroundColor(color9))
                                                   .setDetailFooterStyle(stl.style().setBackgroundColor(color10))
                                                   .setLastPageFooterStyle(stl.style().setBackgroundColor(color11))
                                                   .setSummaryStyle(stl.style().setBackgroundColor(color12))
                                                   .setBackgroundStyle(stl.style().setBackgroundColor(color13));

        rb.setPageColumnsPerPage(2)
          .setTemplate(template)
          .columns(column1 = col.column("Column1", "field1", String.class), column2 = col.column("Column2", "field2", Integer.class))
          .groupBy(group1 = grp.group(column1).setHeaderLayout(GroupHeaderLayout.TITLE_AND_VALUE))

          .subtotalsAtTitle(sbt.sum(column2))
          .subtotalsAtPageHeader(sbt.sum(column2))
          .subtotalsAtPageFooter(sbt.sum(column2))
          .subtotalsAtColumnHeader(sbt.sum(column2))
          .subtotalsAtColumnFooter(sbt.sum(column2))
          .subtotalsAtGroupHeader(group1, sbt.sum(column2))
          .subtotalsAtGroupFooter(group1, sbt.sum(column2))
          .subtotalsAtLastPageFooter(sbt.sum(column2))
          .subtotalsAtSummary(sbt.sum(column2))
          .title(cmp.text("title"))
          .pageHeader(cmp.text("pageHeader"))
          .pageFooter(cmp.text("pageFooter"))
          .columnHeader(cmp.text("columnHeader"))
          .columnFooter(cmp.text("columnFooter"))
          .groupHeader(group1, cmp.text("groupHeader"))
          .groupFooter(group1, cmp.text("groupFooter"))
          .detailHeader(cmp.text("detailHeader"))
          .detail(cmp.text("detail"))
          .detailFooter(cmp.text("detailFooter"))
          .lastPageFooter(cmp.text("lastPageFooter"))
          .summary(cmp.text("summary"))
          .background(cmp.text("background"));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(2);

        styleTest("title.list1", 0, null, color1, "SansSerif", null, null, null);
        styleTest("pageHeader.list1", 0, null, color2, "SansSerif", null, null, null);
        styleTest("pageFooter.list1", 0, null, color3, "SansSerif", null, null, null);
        styleTest("columnHeader.list1", 0, null, color4, "SansSerif", null, null, null);
        styleTest("columnFooter.list1", 0, null, color5, "SansSerif", null, null, null);
        styleTest("groupHeaderTitleAndValue.list1", 0, null, color6, "SansSerif", null, null, null);
        styleTest("groupHeader.list1", 0, null, color6, "SansSerif", null, null, null);
        styleTest("subtotalGroupHeader.list1", 0, null, color6, "SansSerif", null, null, null);
        styleTest("groupFooter.list1", 0, null, color7, "SansSerif", null, null, null);
        styleTest("subtotalGroupFooter.list1", 0, null, color7, "SansSerif", null, null, null);
        styleTest("detailHeader.list1", 0, null, color8, "SansSerif", null, null, null);
        styleTest("detail.list1", 0, null, color9, "SansSerif", null, null, null);
        styleTest("detailFooter.list1", 0, null, color10, "SansSerif", null, null, null);
        styleTest("lastPageFooter.list1", 0, null, color11, "SansSerif", null, null, null);
        styleTest("summary.list1", 0, null, color12, "SansSerif", null, null, null);
        styleTest("background.list1", 0, null, color13, "SansSerif", null, null, null);
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 10; i++) {
            dataSource.add("group1", i);
        }
        for (int i = 0; i < 10; i++) {
            dataSource.add("group2", i);
        }
        return dataSource;
    }
}

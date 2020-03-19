/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
 * http://www.dynamicreports.org
 *
 * This file is part of DynamicReports.
 *
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.test.jasper.crosstab;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

import java.awt.Color;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabStyleTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.type.HorizontalTextAlignEnum;

/**
 * Crosstab style tests.
 * 
 * @author Ricardo Mariaca
 */
public class CrosstabStyle1Test extends AbstractJasperCrosstabStyleTest {
  private CrosstabRowGroupBuilder<String> rowGroup;
  private CrosstabColumnGroupBuilder<String> columnGroup;
  private CrosstabMeasureBuilder<Integer> measure1;

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    FieldBuilder<String> field1 = field("field1", String.class);
    FieldBuilder<String> field2 = field("field2", String.class);

    StyleBuilder titleStyle1 = stl.style().setFontSize(12).bold();
    StyleBuilder titleStyle2 = stl.style(titleStyle1).setBackgroundColor(Color.LIGHT_GRAY);
    StyleBuilder titleStyle3 = stl.style(titleStyle2).setBorder(stl.pen1Point())
        .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);
    StyleBuilder cellStyle = stl.style().bold();
    final StyleBuilder rowGroupCellStyle = stl.style(cellStyle).setBackgroundColor(Color.BLUE);
    final StyleBuilder columnGroupCellStyle = stl.style(cellStyle).setBackgroundColor(Color.ORANGE);
    final StyleBuilder rowColumnGroupCellStyle = stl.style(cellStyle).setBackgroundColor(Color.RED);

    rowGroup = ctab.rowGroup(field1).setHeaderStyle(titleStyle2).setTotalHeaderStyle(titleStyle3);
    columnGroup =
        ctab.columnGroup(field2).setHeaderStyle(titleStyle2).setTotalHeaderStyle(titleStyle3);

    measure1 = ctab.measure("field3", Integer.class, Calculation.SUM);
    measure1.setStyle(cellStyle);
    measure1.setStyle(rowGroupCellStyle, rowGroup);
    measure1.setStyle(columnGroupCellStyle, columnGroup);
    measure1.setStyle(rowColumnGroupCellStyle, rowGroup, columnGroup);

    CrosstabBuilder crosstab = ctab.crosstab().headerCell(cmp.text("Header").setStyle(titleStyle1))
        .rowGroups(rowGroup).columnGroups(columnGroup).measures(measure1);

    rb.summary(crosstab);
  }

  @Override
  public void test() {
    super.test();

    numberOfPagesTest(1);

    setCrosstabBand("summary");

    crosstabHeaderElementStyleTest("textField1", 0, null, null, TEST_FONT_NAME, 12f, true, null);

    crosstabGroupHeaderStyleTest(rowGroup, 0, null, Color.LIGHT_GRAY, TEST_FONT_NAME, 12f, true,
        null);
    crosstabGroupTotalHeaderStyleTest(rowGroup, 0, null, Color.LIGHT_GRAY, TEST_FONT_NAME, 12f,
        true, null);
    crosstabGroupTotalHeaderHorizontalAlignmentTest(rowGroup, 0, HorizontalTextAlignEnum.CENTER);

    crosstabGroupHeaderStyleTest(columnGroup, 0, null, Color.LIGHT_GRAY, TEST_FONT_NAME, 12f, true,
        null);
    crosstabGroupTotalHeaderStyleTest(columnGroup, 0, null, Color.LIGHT_GRAY, TEST_FONT_NAME, 12f,
        true, null);
    crosstabGroupTotalHeaderHorizontalAlignmentTest(columnGroup, 0, HorizontalTextAlignEnum.CENTER);

    for (int i = 0; i < 4; i++) {
      crosstabCellStyleTest(measure1, null, null, i, null, null, TEST_FONT_NAME, 10f, true, null);
    }
    for (int i = 0; i < 2; i++) {
      crosstabCellStyleTest(measure1, rowGroup, null, i, null, Color.BLUE, TEST_FONT_NAME, 10f,
          true, null);
      crosstabCellStyleTest(measure1, null, columnGroup, i, null, Color.ORANGE, TEST_FONT_NAME, 10f,
          true, null);
    }
    crosstabCellStyleTest(measure1, rowGroup, columnGroup, 0, null, Color.RED, TEST_FONT_NAME, 10f,
        true, null);

  }

  @Override
  protected JRDataSource createDataSource() {
    DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
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
}

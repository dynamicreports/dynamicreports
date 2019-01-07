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

package net.sf.dynamicreports.test.jasper.style;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

import java.io.Serializable;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperStyleTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.type.LineStyleEnum;

/**
 * Style tests.
 * 
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Style2Test extends AbstractJasperStyleTest implements Serializable {
  private static final long serialVersionUID = 1L;

  private TextColumnBuilder<Integer> column1;
  private TextColumnBuilder<String> column2;
  private ColumnGroupBuilder group1;
  private AggregationSubtotalBuilder<Integer> subtotal1;

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    StyleBuilder textStyle = stl.style().setPadding(2);
    StyleBuilder titleStyle = stl.style(textStyle).bold();
    StyleBuilder subtotalStyle = stl.style(2).setTopBorder(stl.pen1Point()).bold();

    rb.setTextStyle(textStyle).setColumnTitleStyle(titleStyle).setSubtotalStyle(subtotalStyle)
        .columns(column1 = col.column("Column1", "field1", type.integerType()),
            column2 =
                col.column("Column2", "field2", type.stringType()).setStyle(stl.style().bold()))
        .groupBy(group1 = grp.group(column2)).subtotalsAtSummary(
            subtotal1 = sbt.sum(column1).setLabel("total").setLabelStyle(stl.style().bold()));
  }

  @Override
  public void test() {
    super.test();

    numberOfPagesTest(1);

    // column1
    columnTitleStyleTest(column1, 0, null, null, TEST_FONT_NAME, 10f, true, null);
    columnTitlePaddingTest(column1, 0, 2, 2, 2, 2);

    columnDetailStyleTest(column1, 0, null, null, TEST_FONT_NAME, 10f, null, null);
    columnDetailPaddingTest(column1, 0, 2, 2, 2, 2);

    // column2
    groupHeaderStyleTest(group1, 0, null, null, TEST_FONT_NAME, 10f, true, null);

    // subtotal
    subtotalLabelStyleTest(subtotal1, 0, null, null, TEST_FONT_NAME, 10f, true, null);
    subtotalLabelBorderTest(subtotal1, 0, null, LineStyleEnum.SOLID, 0, null, LineStyleEnum.SOLID,
        0, null, LineStyleEnum.SOLID, 0, null, LineStyleEnum.SOLID, 0);
  }

  @Override
  protected JRDataSource createDataSource() {
    DRDataSource dataSource = new DRDataSource("field1", "field2");
    dataSource.add(1, "1");
    return dataSource;
  }
}

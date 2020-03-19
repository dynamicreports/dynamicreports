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

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;

import java.awt.Color;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.builder.subtotal.AggregationSubtotalBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperStyleTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.type.LineStyleEnum;

/**
 * Template style tests.
 * 
 * @author Ricardo Mariaca
 */
public class TemplateStyle3Test extends AbstractJasperStyleTest implements Serializable {
  private static final long serialVersionUID = 1L;

  private TextColumnBuilder<Integer> column1;
  private TextColumnBuilder<Integer> column2;
  private TextColumnBuilder<Integer> column3;
  private AggregationSubtotalBuilder<Integer> subtotal1;

  @Override
  protected void configureReport(JasperReportBuilder rb) {
    StyleBuilder columnStyle1 = stl.style(stl.templateStyle("columnStyle")).conditionalStyles(
        stl.conditionalStyle(new ConditionExpression(2, 5, 6, 7)).bold(),
        stl.conditionalStyle(new ConditionExpression(16)).setBackgroundColor(Color.ORANGE));
    StyleBuilder columnStyle2 = stl.style(stl.templateStyle("columnStyle")).bold();

    rb.addTemplateStyle(stl.loadStyles(TemplateStyle4Test.class.getResource("StyleTemplate1.jrtx")))
        .columns(column1 = col.column("Column1", "field1", Integer.class).setStyle(columnStyle1),
            column2 = col.column("Column2", "field2", Integer.class).setStyle(columnStyle2),
            column3 = col.column("Column3", "field3", Integer.class)
                .setTitleStyle(stl.templateStyle("columnTitleStyle3")))
        .setTextStyle(stl.templateStyle("textStyle"))
        .setColumnTitleStyle(stl.templateStyle("titleStyle"))
        .setColumnStyle(stl.templateStyle("columnStyle"))
        .setSubtotalStyle(stl.templateStyle("subtotalStyle")).setHighlightDetailOddRows(true)
        .setHighlightDetailEvenRows(true).subtotalsAtSummary(subtotal1 = sbt.sum(column1))
        .detailRowHighlighters(
            stl.conditionalStyle(new ConditionExpression(5, 16)).setBackgroundColor(Color.RED),
            stl.conditionalStyle(new ConditionExpression(2, 9)).setForegroundColor(Color.RED))
        .title(cmp.horizontalList().setStyle(stl.style(stl.pen1Point()))
            .add(cmp.text("text").setStyle(stl.templateStyle("textFieldStyle")))
            .add(cmp.text("text")));
  }

  @Override
  public void test() {
    super.test();

    numberOfPagesTest(1);

    final Color color1 = new Color(240, 240, 240);
    final Color color2 = new Color(200, 200, 200);

    // column1
    columnTitleStyleTest(column1, 0, Color.BLACK, null, TEST_FONT_NAME, 10f, true, null);
    columnTitleBorderTest(column1, 0, Color.BLACK, LineStyleEnum.SOLID, 0, Color.BLACK,
        LineStyleEnum.SOLID, 2, Color.BLACK, LineStyleEnum.SOLID, 0, Color.BLACK,
        LineStyleEnum.SOLID, 0);
    columnTitlePaddingTest(column1, 0, 2, 2, 2, 2);

    columnDetailPaddingTest(column1, 0, 2, 2, 2, 2);
    columnDetailStyleTest(column1, 0, Color.BLACK, color1, TEST_FONT_NAME, 10f, null, true);
    columnDetailStyleTest(column1, 1, Color.BLACK, color2, TEST_FONT_NAME, 10f, null, true);
    columnDetailStyleTest(column1, 2, Color.RED, color1, TEST_FONT_NAME, 10f, true, true);
    columnDetailStyleTest(column1, 5, Color.BLACK, Color.RED, TEST_FONT_NAME, 10f, true, true);
    columnDetailStyleTest(column1, 6, Color.BLACK, color1, TEST_FONT_NAME, 10f, true, true);
    columnDetailStyleTest(column1, 9, Color.RED, color2, TEST_FONT_NAME, 10f, null, true);
    columnDetailStyleTest(column1, 16, Color.BLACK, Color.ORANGE, TEST_FONT_NAME, 10f, null, true);

    // column2
    columnTitleStyleTest(column2, 0, Color.BLACK, null, TEST_FONT_NAME, 10f, true, null);
    columnTitleBorderTest(column2, 0, Color.BLACK, LineStyleEnum.SOLID, 0, Color.BLACK,
        LineStyleEnum.SOLID, 2, Color.BLACK, LineStyleEnum.SOLID, 0, Color.BLACK,
        LineStyleEnum.SOLID, 0);
    columnTitlePaddingTest(column2, 0, 2, 2, 2, 2);

    columnDetailPaddingTest(column2, 0, 2, 2, 2, 2);
    columnDetailStyleTest(column2, 0, Color.BLACK, color1, TEST_FONT_NAME, 10f, true, true);
    columnDetailStyleTest(column2, 1, Color.BLACK, color2, TEST_FONT_NAME, 10f, true, true);
    columnDetailStyleTest(column2, 2, Color.RED, color1, TEST_FONT_NAME, 10f, true, true);
    columnDetailStyleTest(column2, 5, Color.BLACK, Color.RED, TEST_FONT_NAME, 10f, true, true);
    columnDetailStyleTest(column2, 6, Color.BLACK, color1, TEST_FONT_NAME, 10f, true, true);
    columnDetailStyleTest(column2, 9, Color.RED, color2, TEST_FONT_NAME, 10f, true, true);
    columnDetailStyleTest(column2, 16, Color.BLACK, Color.RED, TEST_FONT_NAME, 10f, true, true);

    // column3
    columnTitleStyleTest(column3, 0, Color.BLACK, null, TEST_FONT_NAME, 10f, true, null);
    columnTitleBorderTest(column3, 0, Color.BLACK, LineStyleEnum.SOLID, 2, Color.BLACK,
        LineStyleEnum.SOLID, 2, Color.BLACK, LineStyleEnum.SOLID, 2, Color.BLACK,
        LineStyleEnum.SOLID, 2);
    columnTitlePaddingTest(column3, 0, 2, 2, 2, 2);

    columnDetailPaddingTest(column3, 0, 2, 2, 2, 2);
    columnDetailStyleTest(column3, 0, Color.BLACK, color1, TEST_FONT_NAME, 10f, null, true);
    columnDetailStyleTest(column3, 1, Color.BLACK, color2, TEST_FONT_NAME, 10f, null, true);
    columnDetailStyleTest(column3, 2, Color.RED, color1, TEST_FONT_NAME, 10f, null, true);
    columnDetailStyleTest(column3, 5, Color.BLACK, Color.RED, TEST_FONT_NAME, 10f, null, true);
    columnDetailStyleTest(column3, 6, Color.BLACK, color1, TEST_FONT_NAME, 10f, null, true);
    columnDetailStyleTest(column3, 9, Color.RED, color2, TEST_FONT_NAME, 10f, null, true);
    columnDetailStyleTest(column3, 16, Color.BLACK, Color.RED, TEST_FONT_NAME, 10f, null, true);

    // subtotal1
    subtotalStyleTest(subtotal1, 0, Color.BLACK, Color.YELLOW, TEST_FONT_NAME, 10f, true, null);
    subtotalBorderTest(subtotal1, 0, Color.BLACK, LineStyleEnum.SOLID, 1, Color.BLACK,
        LineStyleEnum.SOLID, 0, Color.BLACK, LineStyleEnum.SOLID, 0, Color.BLACK,
        LineStyleEnum.SOLID, 0);
    subtotalPaddingTest(subtotal1, 0, 2, 2, 2, 2);

    // title
    styleTest("title.list1", 0, null, null, "SansSerif", null, null, null);
    borderTest("title.list1", 0, null, LineStyleEnum.SOLID, 1, null, LineStyleEnum.SOLID, 1, null,
        LineStyleEnum.SOLID, 1, null, LineStyleEnum.SOLID, 1);
    paddingTest("title.list1", 0, 0, 0, 0, 0);
    styleTest("title.textField1", 0, Color.BLACK, null, TEST_FONT_NAME, 15f, true, null);
  }

  @Override
  protected JRDataSource createDataSource() {
    DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
    for (int i = 0; i < 20; i++) {
      dataSource.add(i, i + 1, i + 2);
    }
    return dataSource;
  }

  private class ConditionExpression extends AbstractSimpleExpression<Boolean> {
    private static final long serialVersionUID = 1L;

    private List<Integer> values;

    private ConditionExpression(Integer... values) {
      this.values = Arrays.asList(values);
    }

    @Override
    public Boolean evaluate(ReportParameters reportParameters) {
      Integer value = (Integer) reportParameters.getValue("field1");
      return values.contains(value);
    }
  }
}

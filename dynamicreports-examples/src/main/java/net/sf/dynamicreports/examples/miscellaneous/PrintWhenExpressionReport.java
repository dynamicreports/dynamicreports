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
package net.sf.dynamicreports.examples.miscellaneous;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.component.VerticalListBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>PrintWhenExpressionReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class PrintWhenExpressionReport {

    /**
     * <p>Constructor for PrintWhenExpressionReport.</p>
     */
    public PrintWhenExpressionReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new PrintWhenExpressionReport();
    }

    private void build() {
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());

        ColumnGroupBuilder itemGroup = grp.group("itemGroup", itemColumn)
                                          .setHeaderLayout(GroupHeaderLayout.EMPTY);

        TextFieldBuilder<String> groupHeader = cmp.text(new GroupHeaderExpression())
                                                  .setStyle(Templates.groupStyle)
                                                  .setPrintWhenExpression(new PrintGroupHeaderExpression())
                                                  .removeLineWhenBlank();

        VerticalListBuilder oddPageHeader = cmp.verticalList()
                                               .add(cmp.text("Odd page header")
                                                       .setStyle(Templates.bold12CenteredStyle), cmp.line())
                                               .setPrintWhenExpression(new PrintInOddPageExpression())
                                               .removeLineWhenBlank();

        VerticalListBuilder evenPageHeader = cmp.verticalList()
                                                .add(cmp.line(), cmp.text("Even page header")
                                                                    .setStyle(Templates.bold12CenteredStyle), cmp.line())
                                                .setPrintWhenExpression(new PrintInEvenPageExpression())
                                                .removeLineWhenBlank();

        try {
            report().setTemplate(Templates.reportTemplate)
                    .setPageColumnsPerPage(2)
                    .setPageColumnSpace(5)
                    .columns(itemColumn, col.column("Quantity", "quantity", type.integerType()), col.column("Unit price", "unitprice", type.bigDecimalType()))
                    .groupBy(itemGroup)
                    .title(Templates.createTitleComponent("PrintWhenExpression"))
                    .detailHeader(cmp.columnBreak()
                                     .setPrintWhenExpression(new PrintGroupHeaderColumnBreakExpression()), groupHeader)
                    .pageHeader(oddPageHeader, evenPageHeader, cmp.verticalGap(10))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        for (int i = 0; i < 50; i++) {
            dataSource.add("DVD", (int) (Math.random() * 10) + 1, new BigDecimal(Math.random() * 100 + 1));
        }
        for (int i = 0; i < 50; i++) {
            dataSource.add("Book", (int) (Math.random() * 10) + 1, new BigDecimal(Math.random() * 100 + 1));
        }
        return dataSource;
    }

    public class GroupHeaderExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            return reportParameters.getValue("item");
        }
    }

    public class PrintGroupHeaderExpression extends AbstractSimpleExpression<Boolean> {
        private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

        @Override
        public Boolean evaluate(ReportParameters reportParameters) {
            return reportParameters.getColumnRowNumber() == 1 || reportParameters.getGroupCount("itemGroup") == 1;
        }
    }

    public class PrintGroupHeaderColumnBreakExpression extends AbstractSimpleExpression<Boolean> {
        private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

        @Override
        public Boolean evaluate(ReportParameters reportParameters) {
            return reportParameters.getColumnRowNumber() == 1 && reportParameters.getGroupCount("itemGroup") != 1;
        }
    }

    public class PrintInOddPageExpression extends AbstractSimpleExpression<Boolean> {
        private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

        @Override
        public Boolean evaluate(ReportParameters reportParameters) {
            return reportParameters.getPageNumber()
                                   .doubleValue() % 2 != 0;
        }
    }

    public class PrintInEvenPageExpression extends AbstractSimpleExpression<Boolean> {
        private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

        @Override
        public Boolean evaluate(ReportParameters reportParameters) {
            return reportParameters.getPageNumber()
                                   .doubleValue() % 2 == 0;
        }
    }
}

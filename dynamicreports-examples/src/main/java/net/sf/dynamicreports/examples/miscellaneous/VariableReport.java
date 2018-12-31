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
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.expression.AbstractComplexExpression;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;
import java.util.List;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import static net.sf.dynamicreports.report.builder.DynamicReports.variable;

/**
 * <p>VariableReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class VariableReport {

    /**
     * <p>Constructor for VariableReport.</p>
     */
    public VariableReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new VariableReport();
    }

    private void build() {
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
        TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());

        VariableBuilder<Integer> itemCount = variable(itemColumn, Calculation.COUNT);
        VariableBuilder<Integer> quantitySum = variable("quantitySum", quantityColumn, Calculation.SUM);
        VariableBuilder<Integer> priceSum = variable(new PriceExpression(quantityColumn, unitPriceColumn), Calculation.SUM);

        try {
            report().setTemplate(Templates.reportTemplate)
                    .variables(quantitySum)
                    .columns(itemColumn, quantityColumn, unitPriceColumn)
                    .title(Templates.createTitleComponent("Variable"), cmp.horizontalList(cmp.text("Item count =").setFixedWidth(80), cmp.text(itemCount)),
                           cmp.text(new QuantitySumTextExpression()).setEvaluationTime(Evaluation.REPORT), cmp.text(new UnitPriceSumTextExpression(unitPriceColumn)),
                           cmp.horizontalList(cmp.text("SUM(quantity * unit price) =").setFixedWidth(150), cmp.text(priceSum).setPattern("#,###.00")))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        for (int i = 0; i < 30; i++) {
            dataSource.add("Book", (int) (Math.random() * 10) + 1, BigDecimal.valueOf(Math.random() * 100 + 1));
        }
        return dataSource;
    }

    private class QuantitySumTextExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            Integer quantitySum = reportParameters.getValue("quantitySum");
            return "Quantity sum = " + quantitySum;
        }
    }

    private class UnitPriceSumTextExpression extends AbstractComplexExpression<String> {
        private static final long serialVersionUID = 1L;

        public UnitPriceSumTextExpression(TextColumnBuilder<BigDecimal> unitPriceColumn) {
            addExpression(variable(unitPriceColumn, Calculation.SUM));
        }

        @Override
        public String evaluate(List<?> values, ReportParameters reportParameters) {
            BigDecimal unitPriceSum = (BigDecimal) values.get(0);
            return "Unit price sum = " + type.bigDecimalType().valueToString(unitPriceSum, reportParameters.getLocale());
        }
    }

    private class PriceExpression extends AbstractSimpleExpression<BigDecimal> {
        private static final long serialVersionUID = 1L;

        private TextColumnBuilder<Integer> quantityColumn;
        private TextColumnBuilder<BigDecimal> unitPriceColumn;

        public PriceExpression(TextColumnBuilder<Integer> quantityColumn, TextColumnBuilder<BigDecimal> unitPriceColumn) {
            this.quantityColumn = quantityColumn;
            this.unitPriceColumn = unitPriceColumn;
        }

        @Override
        public BigDecimal evaluate(ReportParameters reportParameters) {
            Integer quantity = reportParameters.getValue(quantityColumn);
            BigDecimal unitPrice = reportParameters.getValue(unitPriceColumn);
            return unitPrice.multiply(BigDecimal.valueOf(quantity));
        }
    }
}

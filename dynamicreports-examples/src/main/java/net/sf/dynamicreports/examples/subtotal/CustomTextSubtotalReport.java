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
package net.sf.dynamicreports.examples.subtotal;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import static net.sf.dynamicreports.report.builder.DynamicReports.variable;

/**
 * <p>CustomTextSubtotalReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class CustomTextSubtotalReport {

    /**
     * <p>Constructor for CustomTextSubtotalReport.</p>
     */
    public CustomTextSubtotalReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new CustomTextSubtotalReport();
    }

    private void build() {
        TextColumnBuilder<String> countryColumn = col.column("Country", "country", type.stringType());
        TextColumnBuilder<String> itemColumn = col.column("Item", "item", type.stringType());
        TextColumnBuilder<Integer> quantityColumn = col.column("Quantity", "quantity", type.integerType());
        TextColumnBuilder<BigDecimal> priceColumn = col.column("Price", "price", type.bigDecimalType());

        ColumnGroupBuilder countryGroup = grp.group(countryColumn);

        VariableBuilder<Integer> quantitySum = variable(quantityColumn, Calculation.SUM);
        VariableBuilder<BigDecimal> priceSum = variable(priceColumn, Calculation.SUM);

        VariableBuilder<Integer> quantityGrpSum = variable(quantityColumn, Calculation.SUM);
        quantityGrpSum.setResetGroup(countryGroup);
        VariableBuilder<BigDecimal> priceGrpSum = variable(priceColumn, Calculation.SUM);
        priceGrpSum.setResetType(Evaluation.FIRST_GROUP);

        StyleBuilder subtotalStyle = stl.style().bold().setTopBorder(stl.pen1Point()).setHorizontalTextAlignment(HorizontalTextAlignment.CENTER);

        TextFieldBuilder<String> summarySbt = cmp.text(new CustomTextSubtotal(quantitySum, priceSum)).setStyle(subtotalStyle);

        TextFieldBuilder<String> groupSbt = cmp.text(new CustomTextSubtotal(quantityGrpSum, priceGrpSum)).setStyle(subtotalStyle);

        countryGroup.footer(groupSbt);

        try {
            report().setTemplate(Templates.reportTemplate)
                    .variables(quantitySum, priceSum, quantityGrpSum, priceGrpSum)
                    .columns(countryColumn, itemColumn, quantityColumn, priceColumn)
                    .groupBy(countryGroup)
                    .summary(summarySbt)
                    .title(Templates.createTitleComponent("CustomTextSubtotal"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("country", "item", "quantity", "price");
        dataSource.add("USA", "Tablet", 4, BigDecimal.valueOf(600));
        dataSource.add("USA", "Tablet", 3, BigDecimal.valueOf(570));
        dataSource.add("USA", "Laptop", 2, BigDecimal.valueOf(500));
        dataSource.add("USA", "Laptop", 1, BigDecimal.valueOf(420));
        dataSource.add("Canada", "Tablet", 6, BigDecimal.valueOf(720));
        dataSource.add("Canada", "Tablet", 2, BigDecimal.valueOf(360));
        dataSource.add("Canada", "Laptop", 3, BigDecimal.valueOf(900));
        dataSource.add("Canada", "Laptop", 2, BigDecimal.valueOf(780));
        return dataSource;
    }

    private class CustomTextSubtotal extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        private VariableBuilder<Integer> quantitySum;
        private VariableBuilder<BigDecimal> priceSum;

        public CustomTextSubtotal(VariableBuilder<Integer> quantitySum, VariableBuilder<BigDecimal> priceSum) {
            this.quantitySum = quantitySum;
            this.priceSum = priceSum;
        }

        @Override
        public String evaluate(ReportParameters reportParameters) {
            Integer quantitySumValue = reportParameters.getValue(quantitySum);
            BigDecimal priceSumValue = reportParameters.getValue(priceSum);
            BigDecimal unitPriceSbt = priceSumValue.divide(BigDecimal.valueOf(quantitySumValue), 2, BigDecimal.ROUND_HALF_UP);
            return "sum(quantity) = " + type.integerType().valueToString(quantitySum, reportParameters) + ", " + "sum(price) = " + type.bigDecimalType().valueToString(priceSum, reportParameters) +
                ", " + "sum(price) / sum(quantity) = " + type.bigDecimalType().valueToString(unitPriceSbt, reportParameters.getLocale());
        }
    }
}

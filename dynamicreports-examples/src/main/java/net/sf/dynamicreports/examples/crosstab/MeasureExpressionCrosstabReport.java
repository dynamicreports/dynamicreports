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
package net.sf.dynamicreports.examples.crosstab;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabVariableBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.ctab;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>MeasureExpressionCrosstabReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class MeasureExpressionCrosstabReport {
    private CrosstabMeasureBuilder<Integer> quantityMeasure;
    private CrosstabVariableBuilder<BigDecimal> unitPriceVariable;
    private CrosstabVariableBuilder<BigDecimal> priceVariable;

    /**
     * <p>Constructor for MeasureExpressionCrosstabReport.</p>
     */
    public MeasureExpressionCrosstabReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new MeasureExpressionCrosstabReport();
    }

    private void build() {
        CrosstabRowGroupBuilder<String> rowGroup = ctab.rowGroup("state", String.class).setTotalHeader("Total for state");

        CrosstabColumnGroupBuilder<String> columnGroup = ctab.columnGroup("item", String.class);

        unitPriceVariable = ctab.variable("unitprice", BigDecimal.class, Calculation.SUM);
        priceVariable = ctab.variable(new PriceExpression(), Calculation.SUM);
        quantityMeasure = ctab.measure("Quantity", "quantity", Integer.class, Calculation.SUM);
        // price1 = sum(unitprice) * sum(quantity)
        CrosstabMeasureBuilder<BigDecimal> priceMeasure1 = ctab.measure("Price1", new PriceMeasure1Expression());
        priceMeasure1.setDataType(type.bigDecimalType());
        // price2 = sum(unitprice * quantity)
        CrosstabMeasureBuilder<BigDecimal> priceMeasure2 = ctab.measure("Price2", new PriceMeasure2Expression());
        priceMeasure2.setDataType(type.bigDecimalType());

        CrosstabBuilder crosstab = ctab.crosstab()
                                       .headerCell(cmp.text("State / Item").setStyle(Templates.boldCenteredStyle))
                                       .setCellWidth(180)
                                       .rowGroups(rowGroup)
                                       .columnGroups(columnGroup)
                                       .variables(unitPriceVariable, priceVariable)
                                       .measures(quantityMeasure, priceMeasure1, priceMeasure2);

        try {
            report().setPageFormat(PageType.A4, PageOrientation.LANDSCAPE)
                    .setTemplate(Templates.reportTemplate)
                    .title(Templates.createTitleComponent("MeasureExpressionCrosstab"), cmp.text("Price1 = SUM(quantity) * SUM(unitPrice)").setStyle(Templates.boldStyle),
                           cmp.text("Price2 = SUM(quantity * unitPrice)").setStyle(Templates.boldStyle))
                    .summary(crosstab)
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("state", "item", "quantity", "unitprice");
        dataSource.add("New York", "Notebook", 1, new BigDecimal(500));
        dataSource.add("New York", "DVD", 5, new BigDecimal(30));
        dataSource.add("New York", "DVD", 2, new BigDecimal(45));
        dataSource.add("New York", "DVD", 4, new BigDecimal(36));
        dataSource.add("New York", "DVD", 5, new BigDecimal(41));
        dataSource.add("New York", "Book", 2, new BigDecimal(11));
        dataSource.add("New York", "Book", 8, new BigDecimal(9));
        dataSource.add("New York", "Book", 6, new BigDecimal(14));

        dataSource.add("Washington", "Notebook", 1, new BigDecimal(610));
        dataSource.add("Washington", "DVD", 4, new BigDecimal(40));
        dataSource.add("Washington", "DVD", 6, new BigDecimal(35));
        dataSource.add("Washington", "DVD", 3, new BigDecimal(46));
        dataSource.add("Washington", "DVD", 2, new BigDecimal(42));
        dataSource.add("Washington", "Book", 3, new BigDecimal(12));
        dataSource.add("Washington", "Book", 9, new BigDecimal(8));
        dataSource.add("Washington", "Book", 4, new BigDecimal(14));
        dataSource.add("Washington", "Book", 5, new BigDecimal(10));

        dataSource.add("Florida", "Notebook", 1, new BigDecimal(460));
        dataSource.add("Florida", "DVD", 3, new BigDecimal(49));
        dataSource.add("Florida", "DVD", 4, new BigDecimal(32));
        dataSource.add("Florida", "DVD", 2, new BigDecimal(47));
        dataSource.add("Florida", "Book", 4, new BigDecimal(11));
        dataSource.add("Florida", "Book", 8, new BigDecimal(6));
        dataSource.add("Florida", "Book", 6, new BigDecimal(16));
        dataSource.add("Florida", "Book", 3, new BigDecimal(18));
        return dataSource;
    }

    private class PriceExpression extends AbstractSimpleExpression<BigDecimal> {
        private static final long serialVersionUID = 1L;

        @Override
        public BigDecimal evaluate(ReportParameters reportParameters) {
            Integer quantity = reportParameters.getValue("quantity");
            BigDecimal unitPrice = reportParameters.getValue("unitprice");
            return unitPrice.multiply(new BigDecimal(quantity));
        }
    }

    private class PriceMeasure1Expression extends AbstractSimpleExpression<BigDecimal> {
        private static final long serialVersionUID = 1L;

        @Override
        public BigDecimal evaluate(ReportParameters reportParameters) {
            Integer quantity = reportParameters.getValue(quantityMeasure);
            BigDecimal unitPrice = reportParameters.getValue(unitPriceVariable);
            return unitPrice.multiply(new BigDecimal(quantity));
        }
    }

    private class PriceMeasure2Expression extends AbstractSimpleExpression<BigDecimal> {
        private static final long serialVersionUID = 1L;

        @Override
        public BigDecimal evaluate(ReportParameters reportParameters) {
            return reportParameters.getValue(priceVariable);
        }
    }
}

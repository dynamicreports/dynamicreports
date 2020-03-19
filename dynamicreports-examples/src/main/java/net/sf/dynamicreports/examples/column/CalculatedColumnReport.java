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
package net.sf.dynamicreports.examples.column;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>CalculatedColumnReport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class CalculatedColumnReport {

    /**
     * <p>Constructor for CalculatedColumnReport.</p>
     */
    public CalculatedColumnReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new CalculatedColumnReport();
    }

    private void build() {
        TextColumnBuilder<Integer> column1 = col.column("A", "field1", type.integerType());
        TextColumnBuilder<Integer> column2 = col.column("B", "field2", type.integerType());
        TextColumnBuilder<BigDecimal> column3 = column1.multiply(column2).setTitle("A * B");
        TextColumnBuilder<BigDecimal> column4 = column1.divide(2, column2).setTitle("A / B");
        TextColumnBuilder<BigDecimal> column5 = column1.add(column2).setTitle("A + B");
        TextColumnBuilder<BigDecimal> column6 = column1.subtract(column2).setTitle("A - B");
        TextColumnBuilder<BigDecimal> column7 = column3.add(6).setTitle("A * B + 6");
        TextColumnBuilder<BigDecimal> column8 = column7.divide(2, 5).add(1).setTitle("(A*B+6) / 5 + 1");

        try {
            report().setTemplate(Templates.reportTemplate)
                    .columns(column1, column2, column3, column4, column5, column6, column7, column8)
                    .title(Templates.createTitleComponent("CalculatedColumn"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        dataSource.add(10, 5);
        return dataSource;
    }
}

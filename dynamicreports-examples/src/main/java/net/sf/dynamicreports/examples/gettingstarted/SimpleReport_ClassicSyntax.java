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
package net.sf.dynamicreports.examples.gettingstarted;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;

/**
 * <p>SimpleReport_ClassicSyntax class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class SimpleReport_ClassicSyntax {

    /**
     * <p>Constructor for SimpleReport_ClassicSyntax.</p>
     */
    public SimpleReport_ClassicSyntax() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new SimpleReport_ClassicSyntax();
    }

    private void build() {
        try {
            JasperReportBuilder report = DynamicReports.report();
            report.addColumn(Columns.column("Item", "item", DataTypes.stringType()));
            report.addColumn(Columns.column("Quantity", "quantity", DataTypes.integerType()));
            report.addColumn(Columns.column("Unit price", "unitprice", DataTypes.bigDecimalType()));
            report.addTitle(Components.text("Getting started"));
            report.addPageFooter(Components.pageXofY());
            report.setDataSource(createDataSource());
            report.show();
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        dataSource.add("Notebook", 1, new BigDecimal(500));
        dataSource.add("DVD", 5, new BigDecimal(30));
        dataSource.add("DVD", 1, new BigDecimal(28));
        dataSource.add("DVD", 5, new BigDecimal(32));
        dataSource.add("Book", 3, new BigDecimal(11));
        dataSource.add("Book", 1, new BigDecimal(15));
        dataSource.add("Book", 5, new BigDecimal(10));
        dataSource.add("Book", 8, new BigDecimal(9));
        return dataSource;
    }
}

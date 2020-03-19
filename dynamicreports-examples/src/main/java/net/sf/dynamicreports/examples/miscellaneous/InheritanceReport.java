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
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.Exporters;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.concatenatedReport;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.sbt;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>InheritanceReport class.</p>
 *
 * Please ensure you have write access on local disc c:\ before running this example
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class InheritanceReport {

    /**
     * <p>Constructor for InheritanceReport.</p>
     */
    public InheritanceReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new InheritanceReport();
    }

    private void build() {
        try {
            concatenatedReport().concatenate(new ReportA().report, new ReportB().report).toPdf(Exporters.pdfExporter("c:/report.pdf"));
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        IntStream.range(0, 10).forEach(i -> dataSource.add("Book", (int) (Math.random() * 10) + 1, BigDecimal.valueOf(Math.random() * 100 + 1)));
        return dataSource;
    }

    /**
     * Illustration purposes. This class remains non-final to illustrate the impact an inheritance-type report
     * and as you can see it will be extended by ReportB. It is however expected that the user will have the
     * wisdom to avoid creating non-final private classes.
     */
    private class ReportA {
        protected JasperReportBuilder report = report();

        private ReportA() {
            configure();
        }

        protected void configure() {
            report.setTemplate(Templates.reportTemplate)
                  .setPageFormat(PageType.A5)
                  .columns(col.column("Item", "item", type.stringType()), col.column("Quantity", "quantity", type.integerType()))
                  .title(Templates.createTitleComponent(getTitle()))
                  .pageFooter(Templates.footerComponent)
                  .setDataSource(createDataSource());
        }

        protected String getTitle() {
            return "Report A";
        }
    }

    private class ReportB extends ReportA {

        @Override
        protected void configure() {
            super.configure();
            TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());
            report.setPageFormat(PageType.A5, PageOrientation.LANDSCAPE).addColumn(unitPriceColumn).subtotalsAtSummary(sbt.sum(unitPriceColumn));
        }

        @Override
        protected String getTitle() {
            return "Report B extends A";
        }
    }
}

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
package net.sf.dynamicreports.examples.exporter;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.export;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>EncryptedPdfReport class.</p>
 * 
 * Please ensure you have write-access to local disc C:\ before running this example
 *
 * @author Ricardo Mariaca
 * 
 */
public class EncryptedPdfReport {

    /**
     * <p>Constructor for EncryptedPdfReport.</p>
     */
    public EncryptedPdfReport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new EncryptedPdfReport();
    }

    private void build() {
        try {
            JasperPdfExporterBuilder pdfExporter = export.pdfExporter("c:/report.pdf").setEncrypted(true).setUserPassword("1234");

            report().setTemplate(Templates.reportTemplate)
                    .columns(col.column("Item", "item", type.stringType()), col.column("Quantity", "quantity", type.integerType()), col.column("Unit price", "unitprice", type.bigDecimalType()))
                    .title(Templates.createTitleComponent("EncryptedPdfReport"))
                    .pageFooter(Templates.footerComponent)
                    .setDataSource(createDataSource())
                    .toPdf(pdfExporter);
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        IntStream.range(0, 20).forEach(i -> dataSource.add("Book", (int) (Math.random() * 10) + 1, BigDecimal.valueOf(Math.random() * 100 + 1)));
        return dataSource;
    }
}

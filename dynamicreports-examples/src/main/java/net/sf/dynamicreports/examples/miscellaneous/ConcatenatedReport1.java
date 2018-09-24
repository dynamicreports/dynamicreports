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

import net.sf.dynamicreports.examples.complex.invoice.InvoiceDesign;
import net.sf.dynamicreports.examples.complex.sales.SalesDesign;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.Exporters;
import net.sf.dynamicreports.report.exception.DRException;

import static net.sf.dynamicreports.report.builder.DynamicReports.concatenatedReport;

/**
 * <p>ConcatenatedReport1 class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ConcatenatedReport1 {

    /**
     * <p>Constructor for ConcatenatedReport1.</p>
     */
    public ConcatenatedReport1() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new ConcatenatedReport1();
    }

    private void build() {
        try {
            concatenatedReport().concatenate(invoiceReport(), salesReport()).toPdf(Exporters.pdfExporter("c:/report.pdf"));
        } catch (DRException e) {
            e.printStackTrace();
        }
    }

    private JasperReportBuilder invoiceReport() throws DRException {
        return new InvoiceDesign().build();
    }

    private JasperReportBuilder salesReport() throws DRException {
        return new SalesDesign().build();
    }
}

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
package net.sf.dynamicreports.examples.subreport;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.stream.IntStream;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>JasperSubreport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class JasperSubreport {

    /**
     * <p>Constructor for JasperSubreport.</p>
     */
    public JasperSubreport() {
        build();
    }

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {
        new JasperSubreport();
    }

    private void build() {
        try {
            report().setTemplate(Templates.reportTemplate)
                    .title(Templates.createTitleComponent("JasperSubreport"), cmp.subreport(getJasperTitleSubreport()))
                    .columns(col.column("Item", "item", type.stringType()), col.column("Quantity", "quantity", type.integerType()), col.column("Unit price", "unitprice", type.bigDecimalType()))
                    .pageFooter(Templates.footerComponent)
                    .summary(cmp.subreport(getJasperSummarySubreport()))
                    .setDataSource(createDataSource())
                    .show();
        } catch (DRException | JRException e) {
            e.printStackTrace();
        }
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        IntStream.range(0, 10).forEach(i -> dataSource.add("Book", (int) (Math.random() * 10) + 1, BigDecimal.valueOf(Math.random() * 100 + 1)));
        return dataSource;
    }

    private JasperReport getJasperTitleSubreport() throws JRException {
        InputStream is = JasperSubreport.class.getResourceAsStream("titlesubreport.jrxml");
        return JasperCompileManager.compileReport(is);
    }

    private JasperReport getJasperSummarySubreport() throws JRException {
        InputStream is = JasperSubreport.class.getResourceAsStream("summarysubreport.jasper");
        return (JasperReport) JRLoader.loadObject(is);
    }
}

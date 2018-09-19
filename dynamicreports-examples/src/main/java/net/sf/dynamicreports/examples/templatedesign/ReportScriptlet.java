/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.examples.templatedesign;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.PageType;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;
import net.sf.jasperreports.engine.JasperReport;

import java.util.Map;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.margin;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * <p>ReportScriptlet class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ReportScriptlet extends JRDefaultScriptlet {
    private JasperReportBuilder dynamicSubreport;

    /** {@inheritDoc} */
    @Override
    public void beforeDetailEval() throws JRScriptletException {
        super.beforeDetailEval();
        dynamicSubreport = report();
        dynamicSubreport.setTemplate(Templates.reportTemplate)
                        .setPageFormat(515, PageType.A4.getHeight(), PageOrientation.PORTRAIT)
                        .setPageMargin(margin(0))
                        .columns(col.column("Item", "item", type.stringType()), col.column("Quantity", "quantity", type.integerType()), col.column("Unit price", "unitprice", type.integerType()))
                        .title(cmp.text("Dynamic subreport")
                                  .setStyle(Templates.bold12CenteredStyle));
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        for (int i = 0; i < 5; i++) {
            dataSource.add("Book", (int) (Math.random() * 10) + 1, (int) (Math.random() * 100) + 1);
        }
        return dataSource;
    }

    /**
     * <p>Getter for the field <code>dynamicSubreport</code>.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.JasperReport} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public JasperReport getDynamicSubreport() throws DRException {
        return dynamicSubreport.toJasperReport();
    }

    /**
     * <p>getDynamicSubreportParameters.</p>
     *
     * @return a {@link java.util.Map} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public Map<String, Object> getDynamicSubreportParameters() throws DRException {
        return dynamicSubreport.getJasperParameters();
    }

    /**
     * <p>getDynamicSubreportDataSource.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.JRDataSource} object.
     */
    public JRDataSource getDynamicSubreportDataSource() {
        return createDataSource();
    }
}

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
package net.sf.dynamicreports.test.jasper.templatedesign;

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
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class ReportScriptlet extends JRDefaultScriptlet {
    private JasperReportBuilder dynamicSubreport;

    @Override
    public void beforeDetailEval() throws JRScriptletException {
        super.beforeDetailEval();
        dynamicSubreport = report();
        dynamicSubreport.setPageFormat(515, PageType.A4.getHeight(), PageOrientation.PORTRAIT)
                        .setPageMargin(margin(0))
                        .columns(col.column("Column1", "field1", type.stringType()), col.column("Column2", "field2", type.integerType()))
                        .title(cmp.text("dynamic subreport"));
    }

    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        dataSource.add("value1", 1);
        dataSource.add("value2", 5);
        return dataSource;
    }

    public JasperReport getDynamicSubreport() throws DRException {
        return dynamicSubreport.toJasperReport();
    }

    public Map<String, Object> getDynamicSubreportParameters() throws DRException {
        return dynamicSubreport.getJasperParameters();
    }

    public JRDataSource getDynamicSubreportDataSource() {
        return createDataSource();
    }
}

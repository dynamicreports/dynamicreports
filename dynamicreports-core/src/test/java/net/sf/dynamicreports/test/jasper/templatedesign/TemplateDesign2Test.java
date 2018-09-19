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

package net.sf.dynamicreports.test.jasper.templatedesign;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.InputStream;
import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class TemplateDesign2Test extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<String> column2;

    @Override
    protected void configureReport(JasperReportBuilder rb) throws DRException {
        SubreportBuilder titleSubreport = cmp.subreport(titleSubreport())
                                             .setDataSource(titleSubreportDataSource());

        InputStream is = TemplateDesign2Test.class.getResourceAsStream("templatedesign2.jrxml");
        rb.setTemplateDesign(is)
          .title(titleSubreport)
          .columns(column1 = col.column("Column1", "field1", String.class));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        columnTitleValueTest(column1, "Column1");
        columnDetailValueTest(column1, "row0", "row1");
        columnTitleValueTest(column2, "Column2");
        columnDetailValueTest(column2, "value1", "value2", "value3");
        elementValueTest("title.textField1", "subreport");
        elementValueTest("templateDesign.pageHeader", "pageHeader");
        elementValueTest("templateDesign.pageFooter", "pageFooter");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (int i = 0; i < 2; i++) {
            dataSource.add("row" + i, i);
        }
        return dataSource;
    }

    private JasperReportBuilder titleSubreport() throws DRException {
        InputStream is = TemplateDesign2Test.class.getResourceAsStream("templatedesign3.jrxml");
        JasperReportBuilder report = report();
        report.setTemplateDesign(is)
              .title(cmp.text("subreport"))
              .columns(column2 = col.column("Column2", "field2", String.class));
        return report;
    }

    private JRDataSource titleSubreportDataSource() {
        DRDataSource dataSource = new DRDataSource("field2");
        dataSource.add("value1");
        dataSource.add("value2");
        dataSource.add("value3");
        return dataSource;
    }
}

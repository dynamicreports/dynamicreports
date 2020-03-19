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
package net.sf.dynamicreports.test.jasper.tableofcontents;

import net.sf.dynamicreports.jasper.base.tableofcontents.JasperTocHeading;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.DRICustomValues;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca
 */
public class TableOfContents4Test extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        TextColumnBuilder<String> column1;

        rb.tableOfContents()
          .pageHeader(cmp.text(new PageHeaderExpression()))
          .columns(column1 = col.column("Column1", "field1", type.stringType()), col.column("Column2", "field2", type.stringType()))
          .groupBy(column1);
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(4);

        elementCountTest("pageHeader.textField1", 3);
        elementValueTest("pageHeader.textField1", "value1", "value3", "value5");
    }

    @Override
    protected JRDataSource createDataSource() {
        String[] values = new String[] {"value1", "value2", "value3", "value4", "value5", "value6"};
        DRDataSource dataSource = new DRDataSource("field1", "field2");
        for (String value : values) {
            for (int i = 0; i < 20; i++) {
                dataSource.add(value, "text");
            }
        }
        return dataSource;
    }

    private class PageHeaderExpression extends AbstractSimpleExpression<String> {
        private static final long serialVersionUID = 1L;

        @Override
        public String evaluate(ReportParameters reportParameters) {
            DRICustomValues customValues = (DRICustomValues) reportParameters.getParameterValue(DRICustomValues.NAME);
            Map<String, JasperTocHeading> tocHeadings = customValues.getTocHeadings();
            if (tocHeadings.isEmpty()) {
                return reportParameters.getValue("field1");
            }
            List<JasperTocHeading> headings = new ArrayList<JasperTocHeading>(tocHeadings.values());
            JasperTocHeading jasperTocHeading = headings.get(headings.size() - 1);
            return jasperTocHeading.getText();
        }
    }
}

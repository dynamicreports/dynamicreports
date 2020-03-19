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
package net.sf.dynamicreports.test.jasper.report;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;

/**
 * @author Ricardo Mariaca
 */
public class DetailBand1Test extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<String> column1;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.columns(column1 = col.column("Column1", "field1", String.class)).detailHeader(cmp.text("detailHeader")).detailFooter(cmp.text("detailFooter"));

    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        elementCountTest("detailHeader.textField1", 2);
        elementValueTest("detailHeader.textField1", "detailHeader", "detailHeader");

        columnDetailCountTest(column1, 2);
        columnDetailValueTest(column1, "detail", "detail");

        elementCountTest("detailFooter.textField1", 2);
        elementValueTest("detailFooter.textField1", "detailFooter", "detailFooter");
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1");
        for (int i = 0; i < 2; i++) {
            dataSource.add("detail");
        }
        return dataSource;
    }
}

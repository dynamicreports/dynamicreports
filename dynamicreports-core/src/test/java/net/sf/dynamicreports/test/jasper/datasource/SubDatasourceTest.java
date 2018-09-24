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
package net.sf.dynamicreports.test.jasper.datasource;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;

import java.io.Serializable;
import java.util.Arrays;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.exp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class SubDatasourceTest extends AbstractJasperValueTest implements Serializable {
    private static final long serialVersionUID = 1L;

    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<String> column2;
    private TextColumnBuilder<String> column3;
    private TextColumnBuilder<String> column4;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        rb.columns(column1 = col.column("Column1", "field1", type.stringType()), column2 = col.column("Column2", "field2", type.stringType()))
          .detailFooter(cmp.subreport(createSubreport()).setDataSource(exp.subDatasourceBeanCollection("field3")));
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // column1
        columnTitleCountTest(column1, 1);
        columnTitleValueTest(column1, "Column1");
        columnDetailCountTest(column1, 2);
        columnDetailValueTest(column1, "1", "2");
        // column2
        columnTitleCountTest(column2, 1);
        columnTitleValueTest(column2, "Column2");
        columnDetailCountTest(column2, 2);
        columnDetailValueTest(column2, "text1", "text2");

        // column3
        columnTitleCountTest(column3, 2);
        columnTitleValueTest(column3, "Column3", "Column3");
        columnDetailCountTest(column3, 3);
        columnDetailValueTest(column3, "texta1", "texta3", "textb1");
        // column4
        columnTitleCountTest(column4, 2);
        columnTitleValueTest(column4, "Column4", "Column4");
        columnDetailCountTest(column4, 3);
        columnDetailValueTest(column4, "texta2", "texta4", "textb2");

    }

    private JasperReportBuilder createSubreport() {
        JasperReportBuilder report = report();
        report.columns(column3 = col.column("Column3", "field3", type.stringType()), column4 = col.column("Column4", "field4", type.stringType()));
        return report;
    }

    @Override
    protected JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
        dataSource.add("1", "text1", Arrays.asList(new SubData("texta1", "texta2"), new SubData("texta3", "texta4")));
        dataSource.add("2", "text2", Arrays.asList(new SubData("textb1", "textb2")));
        return dataSource;
    }

    public class SubData {
        private String field3;
        private String field4;

        private SubData(String field3, String field4) {
            this.field3 = field3;
            this.field4 = field4;

        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }

        public String getField4() {
            return field4;
        }

        public void setField4(String field4) {
            this.field4 = field4;
        }
    }
}

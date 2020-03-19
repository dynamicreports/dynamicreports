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
import net.sf.dynamicreports.report.constant.QueryLanguage;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRXmlUtils;
import org.junit.Assert;

import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca
 */
public class XmlReportTest extends AbstractJasperValueTest {
    private TextColumnBuilder<Object> column1;
    private TextColumnBuilder<Object> column2;
    private TextColumnBuilder<Object> column3;
    private TextColumnBuilder<Object> column4;
    private TextColumnBuilder<Object> column5;
    private TextColumnBuilder<Object> column6;

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        try {
            rb.setLocale(Locale.ENGLISH)
              .columns(column1 = col.column("Column1", field("field1", type.stringType()).setDescription("@field1")), column2 = col.column("Column2", field("field2", type.integerType())),
                       column3 = col.column("Column3", field("field3", type.bigDecimalType())))
              .setQuery("/data/row1", QueryLanguage.XPATH)
              .setParameter(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, JRXmlUtils.parse(XmlReportTest.class.getResourceAsStream("data.xml")))
              .summary(cmp.subreport(createSubreport()));
        } catch (JRException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    private JasperReportBuilder createSubreport() throws JRException {
        JasperReportBuilder report = report();
        report.setLocale(Locale.ENGLISH)
              .columns(column4 = col.column("Column4", field("field4", type.stringType()).setDescription("@field4")),
                       column5 = col.column("Column5", field("field5", type.integerType()).setDescription("field5")), column6 = col.column("Column6", field("field6", type.bigDecimalType())))
              .setUseFieldNameAsDescription(false)
              .setDataSource(new JRXmlDataSource(XmlReportTest.class.getResourceAsStream("data.xml"), "/data/row2"));
        return report;
    }

    @Override
    protected boolean serializableTest() {
        return false;
    }

    @Override
    public void test() {
        super.test();

        numberOfPagesTest(1);

        // column1
        columnTitleCountTest(column1, 1);
        columnTitleValueTest(column1, "Column1");
        columnDetailCountTest(column1, 1);
        columnDetailValueTest(column1, 0, "text1");
        // column2
        columnTitleCountTest(column2, 1);
        columnTitleValueTest(column2, "Column2");
        columnDetailCountTest(column2, 1);
        columnDetailValueTest(column2, 0, "5");
        // column3
        columnTitleCountTest(column3, 1);
        columnTitleValueTest(column3, "Column3");
        columnDetailCountTest(column3, 1);
        columnDetailValueTest(column3, 0, "100.00");

        // column4
        columnTitleCountTest(column4, 1);
        columnTitleValueTest(column4, "Column4");
        columnDetailCountTest(column4, 1);
        columnDetailValueTest(column4, 0, "text2");
        // column5
        columnTitleCountTest(column5, 1);
        columnTitleValueTest(column5, "Column5");
        columnDetailCountTest(column5, 1);
        columnDetailValueTest(column5, 0, "1");
        // column6
        columnTitleCountTest(column6, 1);
        columnTitleValueTest(column6, "Column6");
        columnDetailCountTest(column6, 1);
        columnDetailValueTest(column6, 0, "10.00");
    }
}

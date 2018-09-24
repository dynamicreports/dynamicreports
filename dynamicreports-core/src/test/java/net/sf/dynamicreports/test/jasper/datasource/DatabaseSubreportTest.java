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

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.builder.expression.AbstractComplexExpression;
import net.sf.dynamicreports.report.builder.group.CustomGroupBuilder;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.field;
import static net.sf.dynamicreports.report.builder.DynamicReports.grp;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DatabaseSubreportTest extends AbstractJasperValueTest {
    private Connection connection;
    private TextColumnBuilder<String> column1;
    private TextColumnBuilder<Integer> column2;
    private TextColumnBuilder<BigDecimal> column3;

    @Override
    public void init() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:mem:test");
            createTable();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        super.init();
    }

    @Override
    protected void configureReport(JasperReportBuilder rb) {
        SubreportBuilder subreport = cmp.subreport(new SubreportExpression());
        subreport.setConnection(connection);

        CustomGroupBuilder group = grp.group(field("field4", Integer.class));
        group.footer(subreport);

        rb.groupBy(group).setDataSource("SELECT * FROM test_table2", connection);
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
        columnTitleCountTest(column1, 2);
        columnTitleValueTest(column1, "Column1", "Column1");
        columnDetailCountTest(column1, 3);
        columnDetailValueTest(column1, "text", "text", "text");
        // column2
        columnTitleCountTest(column2, 2);
        columnTitleValueTest(column2, "Column2", "Column2");
        columnDetailCountTest(column2, 3);
        columnDetailValueTest(column2, "5", "6", "7");
        // column3
        columnTitleCountTest(column3, 2);
        columnTitleValueTest(column3, "Column3", "Column3");
        columnDetailCountTest(column3, 3);
        columnDetailValueTest(column3, "100.00", "200.00", "300.00");
    }

    private void createTable() throws SQLException {
        Statement st = connection.createStatement();
        st.execute("CREATE TABLE test_table2 (field1 VARCHAR(50), field2 INTEGER, field3 DECIMAL, field4 INTEGER)");
        st.execute("INSERT INTO test_table2 VALUES ('text', 5, 100, 1)");
        st.execute("INSERT INTO test_table2 VALUES ('text', 6, 200, 1)");
        st.execute("INSERT INTO test_table2 VALUES ('text', 7, 300, 2)");
    }

    private class SubreportExpression extends AbstractComplexExpression<JasperReportBuilder> {
        private static final long serialVersionUID = 1L;

        public SubreportExpression() {
            addExpression(field("field4", Integer.class));
        }

        @Override
        public JasperReportBuilder evaluate(List<?> values, ReportParameters reportParameters) {
            JasperReportBuilder report = report();
            report.setLocale(Locale.ENGLISH)
                  .columns(column1 = col.column("Column1", "field1", type.stringType()), column2 = col.column("Column2", "field2", type.integerType()),
                           column3 = col.column("Column3", "field3", type.bigDecimalType()))
                  .setQuery("SELECT * FROM test_table2 WHERE field4 = " + values.get(0));
            return report;
        }
    }
}

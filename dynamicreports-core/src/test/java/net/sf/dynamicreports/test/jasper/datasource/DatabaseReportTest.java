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

package net.sf.dynamicreports.test.jasper.datasource;

import junit.framework.Assert;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DatabaseReportTest extends AbstractJasperValueTest {
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
        rb.setLocale(Locale.ENGLISH)
          .columns(column1 = col.column("Column1", "field1", type.stringType()), column2 = col.column("Column2", "field2", type.integerType()),
                   column3 = col.column("Column3", "field3", type.bigDecimalType()))
          .setDataSource("SELECT * FROM test_table1", connection);
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
        columnDetailValueTest(column1, 0, "text");
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
    }

    private void createTable() throws SQLException {
        Statement st = connection.createStatement();
        st.execute("CREATE TABLE test_table1 (field1 VARCHAR(50), field2 INTEGER, field3 DECIMAL)");
        st.execute("INSERT INTO test_table1 VALUES ('text', 5, 100)");
    }
}

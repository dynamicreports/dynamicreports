/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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

package net.sf.dynamicreports.examples.datasource;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * <p>DatabaseDatasourceReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DatabaseDatasourceReport {
	private Connection connection;

	/**
	 * <p>Constructor for DatabaseDatasourceReport.</p>
	 */
	public DatabaseDatasourceReport() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:mem:test");
			createTable();
			build();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void build() {
		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.columns(
							col.column("Item", "item", type.stringType()),
							col.column("Quantity", "quantity", type.integerType()),
							col.column("Unit price", "unitprice", type.bigDecimalType()))
					.title(Templates.createTitleComponent("DatabaseDatasource"))
					.pageFooter(Templates.footerComponent)
					.setDataSource("SELECT * FROM sales", connection)
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private void createTable() throws SQLException {
		Statement st = connection.createStatement();
		st.execute("CREATE TABLE sales (item VARCHAR(50), quantity INTEGER, unitprice DECIMAL)");
		st.execute("INSERT INTO sales VALUES ('Book', 5, 100)");
	}

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		new DatabaseDatasourceReport();
	}
}

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

package net.sf.dynamicreports.examples.column;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * <p>ColumnDetectDataTypeReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ColumnDetectDataTypeReport {

	/**
	 * <p>Constructor for ColumnDetectDataTypeReport.</p>
	 */
	public ColumnDetectDataTypeReport() {
		build();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void build() {
		try {
			JasperReportBuilder report = report();
			for (Column column : createColumns()) {
				report.addColumn(col.column(column.title, column.field, (DRIDataType) type.detectType(column.dataType)));
			}
			report
					.setTemplate(Templates.reportTemplate)
					.title(Templates.createTitleComponent("ColumnDetectDataTypes"))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "orderdate", "quantity", "unitprice");
		dataSource.add("Notebook", new Date(), 1, new BigDecimal(500));
		return dataSource;
	}

	private List<Column> createColumns() {
		List<Column> columns = new ArrayList<Column>();
		columns.add(new Column("Item", "item", "string"));// dataType = "String", "STRING", "java.lang.String", "text"
		columns.add(new Column("Quantity", "quantity", "integer"));// dataType = "Integer", "INTEGER", "java.lang.Integer"
		columns.add(new Column("Unit price", "unitprice", "bigDecimal"));// dataType = "bigdecimal", "BIGDECIMAL", "java.math.BigDecimal"
		columns.add(new Column("Order date", "orderdate", "date"));// dataType = "Date", "DATE", "java.util.Date"
		columns.add(new Column("Order date", "orderdate", "dateYearToFraction"));// dataType = "dateyeartofraction", "DATEYEARTOFRACTION"
		columns.add(new Column("Order year", "orderdate", "dateYear"));// dataType = "DateYear", "dateyear", "DATEYEAR"
		columns.add(new Column("Order month", "orderdate", "dateMonth"));// dataType = "DateMonth", "datemonth", "DATEMONTH"
		columns.add(new Column("Order day", "orderdate", "dateDay"));// dataType = "DateDay", "dateday", "DATEDAY"
		return columns;
	}

	private class Column {
		private String title;
		private String field;
		private String dataType;

		private Column(String title, String field, String dataType) {
			this.title = title;
			this.field = field;
			this.dataType = dataType;
		}
	}

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		new ColumnDetectDataTypeReport();
	}
}

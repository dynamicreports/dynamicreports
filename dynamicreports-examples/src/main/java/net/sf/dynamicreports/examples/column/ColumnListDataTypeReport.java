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

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * <p>ColumnListDataTypeReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ColumnListDataTypeReport {

	/**
	 * <p>Constructor for ColumnListDataTypeReport.</p>
	 */
	public ColumnListDataTypeReport() {
		build();
	}

	private void build() {
		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.columns(
							col.column("Item", "item", type.stringType()),
							col.column("Quantity", "quantity", type.integerType()),
							col.column("Comments", "comments", type.listType()))
					.title(Templates.createTitleComponent("ColumnListDataType"))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		List<ReportData> datasource = new ArrayList<ReportData>();

		ReportData data = new ReportData();
		List<String> comments = new ArrayList<String>();
		comments.add("comment1");
		comments.add("comment2");
		comments.add("comment3");
		data.setItem("Book");
		data.setQuantity(new Integer(10));
		data.setComments(comments);
		datasource.add(data);

		data = new ReportData();
		comments = new ArrayList<String>();
		comments.add("comment1");
		comments.add("comment2");
		data.setItem("Notebook");
		data.setQuantity(new Integer(20));
		data.setComments(comments);
		datasource.add(data);

		return new JRBeanCollectionDataSource(datasource);
	}

	public class ReportData {
		private String item;
		private Integer quantity;
		private List<String> comments;

		public String getItem() {
			return item;
		}

		public void setItem(String item) {
			this.item = item;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public List<String> getComments() {
			return comments;
		}

		public void setComments(List<String> comments) {
			this.comments = comments;
		}
	}

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		new ColumnListDataTypeReport();
	}
}

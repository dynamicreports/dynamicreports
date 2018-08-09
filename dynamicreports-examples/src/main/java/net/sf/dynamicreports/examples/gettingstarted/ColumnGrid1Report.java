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

package net.sf.dynamicreports.examples.gettingstarted;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * <p>ColumnGrid1Report class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ColumnGrid1Report {
	private final int columns_count = 12;

	/**
	 * <p>Constructor for ColumnGrid1Report.</p>
	 */
	public ColumnGrid1Report() {
		build();
	}

	private void build() {
		@SuppressWarnings("unchecked")
		TextColumnBuilder<String>[] columns = new TextColumnBuilder[columns_count];
		for (int i = 1; i <= columns_count; i++) {
			columns[i - 1] = col.column("Column" + i, "column" + i, type.stringType());
		}
		columns[columns_count / 2].setFixedWidth(300);

		try {
			report()
					.setTextStyle(stl.style(stl.pen1Point()))
					.columns(columns)
					.columnGrid(grid.horizontalFlowColumnGridList(columns))
					.detail(cmp.verticalGap(10))
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		String[] columns = new String[columns_count];
		for (int i = 1; i <= columns_count; i++) {
			columns[i - 1] = "column" + i;
		}
		DRDataSource dataSource = new DRDataSource(columns);
		for (int i = 1; i <= 5; i++) {
			Object[] row = new Object[columns_count];
			for (int j = 0; j < columns_count; j++) {
				row[j] = "row " + i;
			}
			dataSource.add(row);
		}
		return dataSource;
	}

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		new ColumnGrid1Report();
	}
}

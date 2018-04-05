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

package net.sf.dynamicreports.test.jasper.crosstab;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.awt.Color;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabMeasureBuilder;
import net.sf.dynamicreports.report.builder.crosstab.CrosstabRowGroupBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.Calculation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperCrosstabStyleTest;
import net.sf.jasperreports.engine.JRDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class CrosstabStyle2Test extends AbstractJasperCrosstabStyleTest implements Serializable {
	private static final long serialVersionUID = 1L;

	private CrosstabRowGroupBuilder<String> rowGroup;
	private CrosstabColumnGroupBuilder<String> columnGroup;
	private CrosstabMeasureBuilder<Integer> measure1;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		FieldBuilder<String> field1 = field("field1", String.class);
		FieldBuilder<String> field2 = field("field2", String.class);

		StyleBuilder cellStyle = stl.style()
				.conditionalStyles(
						stl.conditionalStyle(new ConditionExpression(10, 15, 14, 36)).setBackgroundColor(Color.ORANGE));

		rowGroup = ctab.rowGroup(field1);
		columnGroup = ctab.columnGroup(field2);

		measure1 = ctab.measure("field3", Integer.class, Calculation.SUM);
		measure1.setStyle(cellStyle);

		CrosstabBuilder crosstab = ctab.crosstab()
				.rowGroups(
						rowGroup)
				.columnGroups(
						columnGroup)
				.measures(
						measure1);

		rb.summary(crosstab);
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);

		setCrosstabBand("summary");

		crosstabCellStyleTest(measure1, null, null, 0, null, null, "Arial", 10f, null, null);
		crosstabCellStyleTest(measure1, null, null, 1, null, null, "Arial", 10f, null, null);
		crosstabCellStyleTest(measure1, null, null, 2, null, null, "Arial", 10f, null, null);
		crosstabCellStyleTest(measure1, null, null, 3, null, Color.ORANGE, "Arial", 10f, null, null);

		crosstabCellStyleTest(measure1, rowGroup, null, 0, null, Color.ORANGE, "Arial", 10f, null, null);
		crosstabCellStyleTest(measure1, rowGroup, null, 1, null, null, "Arial", 10f, null, null);

		crosstabCellStyleTest(measure1, null, columnGroup, 0, null, Color.ORANGE, "Arial", 10f, null, null);
		crosstabCellStyleTest(measure1, null, columnGroup, 1, null, null, "Arial", 10f, null, null);

		crosstabCellStyleTest(measure1, rowGroup, columnGroup, 0, null, Color.ORANGE, "Arial", 10f, null, null);

	}

	@Override
	protected JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("field1", "field2", "field3");
		dataSource.add("a", "c", 1);
		dataSource.add("a", "c", 2);
		dataSource.add("a", "d", 3);
		dataSource.add("a", "d", 4);
		dataSource.add("b", "c", 5);
		dataSource.add("b", "c", 6);
		dataSource.add("b", "d", 7);
		dataSource.add("b", "d", 8);
		return dataSource;
	}

	private class ConditionExpression extends AbstractSimpleExpression<Boolean> {
		private static final long serialVersionUID = 1L;

		private List<Integer> values;

		private ConditionExpression(Integer... values) {
			this.values = Arrays.asList(values);
		}

		@Override
		public Boolean evaluate(ReportParameters reportParameters) {
			Integer value = reportParameters.getValue(measure1);
			return values.contains(value);
		}
	}
}

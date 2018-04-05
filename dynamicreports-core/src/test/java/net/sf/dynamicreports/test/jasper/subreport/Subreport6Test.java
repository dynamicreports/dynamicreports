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

package net.sf.dynamicreports.test.jasper.subreport;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.io.Serializable;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.component.SubreportBuilder;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.test.jasper.AbstractJasperValueTest;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class Subreport6Test extends AbstractJasperValueTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void configureReport(JasperReportBuilder rb) {
		SubreportBuilder subreport = Components.subreport(new Subreport1Expression());

		rb.detail(subreport);
	}

	@Override
	public void test() {
		super.test();

		numberOfPagesTest(1);

		elementCountTest("title.textField1", 10);
		elementValueTest("title.textField1", "575", "565", "575", "555", "575", "545", "575", "535", "575", "525");
	}

	@Override
	protected JRDataSource createDataSource() {
		return new JREmptyDataSource(5);
	}

	private class Subreport1Expression extends AbstractSimpleExpression<JasperReportBuilder> {
		private static final long serialVersionUID = 1L;

		@Override
		public JasperReportBuilder evaluate(ReportParameters reportParameters) {
			SubreportBuilder subreport = Components.subreport(new Subreport2Expression());

			JasperReportBuilder report = report();
			report
					.title(
							cmp.text(reportParameters.getSubreportWidth()),
							cmp.horizontalList(cmp.horizontalGap(10 * reportParameters.getReportRowNumber()), subreport));

			return report;
		}
	}

	private class Subreport2Expression extends AbstractSimpleExpression<JasperReportBuilder> {
		private static final long serialVersionUID = 1L;

		@Override
		public JasperReportBuilder evaluate(ReportParameters reportParameters) {
			JasperReportBuilder report = report();
			report
					.title(cmp.text(reportParameters.getSubreportWidth()));

			return report;
		}
	}
}

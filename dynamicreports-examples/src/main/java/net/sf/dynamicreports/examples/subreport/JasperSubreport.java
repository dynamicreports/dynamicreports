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

package net.sf.dynamicreports.examples.subreport;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.io.InputStream;
import java.math.BigDecimal;

import net.sf.dynamicreports.examples.Templates;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperSubreport {

	public JasperSubreport() {
		build();
	}

	private void build() {
		try {
			report()
					.setTemplate(Templates.reportTemplate)
					.title(
							Templates.createTitleComponent("JasperSubreport"),
							cmp.subreport(getJasperTitleSubreport()))
					.columns(
							col.column("Item", "item", type.stringType()),
							col.column("Quantity", "quantity", type.integerType()),
							col.column("Unit price", "unitprice", type.bigDecimalType()))
					.pageFooter(Templates.footerComponent)
					.summary(cmp.subreport(getJasperSummarySubreport()))
					.setDataSource(createDataSource())
					.show();
		} catch (DRException e) {
			e.printStackTrace();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	private JRDataSource createDataSource() {
		DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
		for (int i = 0; i < 10; i++) {
			dataSource.add("Book", (int) (Math.random() * 10) + 1, new BigDecimal(Math.random() * 100 + 1));
		}
		return dataSource;
	}

	private JasperReport getJasperTitleSubreport() throws JRException {
		InputStream is = JasperSubreport.class.getResourceAsStream("titlesubreport.jrxml");
		return JasperCompileManager.compileReport(is);
	}

	private JasperReport getJasperSummarySubreport() throws JRException {
		InputStream is = JasperSubreport.class.getResourceAsStream("summarysubreport.jasper");
		return (JasperReport) JRLoader.loadObject(is);
	}

	public static void main(String[] args) {
		new JasperSubreport();
	}
}

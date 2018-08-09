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

package net.sf.dynamicreports.jasper.builder.export;

import net.sf.dynamicreports.jasper.base.export.JasperXlsxExporter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>JasperXlsxExporterBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class JasperXlsxExporterBuilder extends AbstractJasperExcelExporterBuilder<JasperXlsxExporterBuilder, JasperXlsxExporter> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	/**
	 * <p>Constructor for JasperXlsxExporterBuilder.</p>
	 */
	protected JasperXlsxExporterBuilder() {
		super(new JasperXlsxExporter());
	}

	/**
	 * <p>setMacroTemplate.</p>
	 *
	 * @param macroTemplate a {@link java.lang.String} object.
	 * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperXlsxExporterBuilder} object.
	 */
	public JasperXlsxExporterBuilder setMacroTemplate(String macroTemplate) {
		getObject().setMacroTemplate(macroTemplate);
		return this;
	}

}

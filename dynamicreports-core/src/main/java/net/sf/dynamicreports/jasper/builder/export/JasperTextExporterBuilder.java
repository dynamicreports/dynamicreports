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

import net.sf.dynamicreports.jasper.base.export.JasperTextExporter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperTextExporterBuilder extends AbstractJasperExporterBuilder<JasperTextExporterBuilder, JasperTextExporter> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected JasperTextExporterBuilder() {
		super(new JasperTextExporter());
	}

	/**
	 * @deprecated To be removed. Use setCharacterWidth(Float characterWidth) instead.
	 */
	@Deprecated
	public JasperTextExporterBuilder setCharacterWidth(Integer characterWidth) {
		return setCharacterWidth(characterWidth != null ? characterWidth.floatValue() : null);
	}

	public JasperTextExporterBuilder setCharacterWidth(Float characterWidth) {
		this.getObject().setCharacterWidth(characterWidth);
		return this;
	}

	/**
	 * @deprecated To be removed. Use setCharacterHeight(Float characterHeight) instead.
	 */
	@Deprecated
	public JasperTextExporterBuilder setCharacterHeight(Integer characterHeight) {
		return setCharacterHeight(characterHeight != null ? characterHeight.floatValue() : null);
	}

	public JasperTextExporterBuilder setCharacterHeight(Float characterHeight) {
		this.getObject().setCharacterHeight(characterHeight);
		return this;
	}

	/**
	 * @deprecated To be removed. Use setPageWidthInChars instead.
	 */
	@Deprecated
	public JasperTextExporterBuilder setPageWidth(Integer pageWidth) {
		return setPageWidthInChars(pageWidth);
	}

	public JasperTextExporterBuilder setPageWidthInChars(Integer pageWidth) {
		this.getObject().setPageWidthInChars(pageWidth);
		return this;
	}

	/**
	 * @deprecated To be removed. Use setPageHeightInChars instead.
	 */
	@Deprecated
	public JasperTextExporterBuilder setPageHeight(Integer pageHeight) {
		return setPageHeightInChars(pageHeight);
	}

	public JasperTextExporterBuilder setPageHeightInChars(Integer pageHeight) {
		this.getObject().setPageHeightInChars(pageHeight);
		return this;
	}

	/**
	 * @deprecated To be removed. Use setPageSeparator instead.
	 */
	@Deprecated
	public JasperTextExporterBuilder setBetweenPagesText(String betweenPagesText) {
		return setPageSeparator(betweenPagesText);
	}

	public JasperTextExporterBuilder setPageSeparator(String pageSeparator) {
		this.getObject().setPageSeparator(pageSeparator);
		return this;
	}

	public JasperTextExporterBuilder setLineSeparator(String lineSeparator) {
		this.getObject().setLineSeparator(lineSeparator);
		return this;
	}
}

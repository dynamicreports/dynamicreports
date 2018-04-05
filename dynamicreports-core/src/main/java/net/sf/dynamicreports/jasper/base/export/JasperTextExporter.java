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

package net.sf.dynamicreports.jasper.base.export;

import net.sf.dynamicreports.jasper.definition.export.JasperITextExporter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperTextExporter extends AbstractJasperExporter implements JasperITextExporter {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Float characterWidth;
	private Float characterHeight;
	private Integer pageWidthInChars;
	private Integer pageHeightInChars;
	private String pageSeparator;
	private String lineSeparator;
	private Boolean trimLineRight;

	@Override
	public Float getCharacterWidth() {
		return characterWidth;
	}

	public void setCharacterWidth(Float characterWidth) {
		this.characterWidth = characterWidth;
	}

	@Override
	public Float getCharacterHeight() {
		return characterHeight;
	}

	public void setCharacterHeight(Float characterHeight) {
		this.characterHeight = characterHeight;
	}

	@Override
	public Integer getPageWidthInChars() {
		return pageWidthInChars;
	}

	public void setPageWidthInChars(Integer pageWidthInChars) {
		this.pageWidthInChars = pageWidthInChars;
	}

	@Override
	public Integer getPageHeightInChars() {
		return pageHeightInChars;
	}

	public void setPageHeightInChars(Integer pageHeightInChars) {
		this.pageHeightInChars = pageHeightInChars;
	}

	@Override
	public String getPageSeparator() {
		return pageSeparator;
	}

	public void setPageSeparator(String pageSeparator) {
		this.pageSeparator = pageSeparator;
	}

	@Override
	public String getLineSeparator() {
		return lineSeparator;
	}

	public void setLineSeparator(String lineSeparator) {
		this.lineSeparator = lineSeparator;
	}

	@Override
	public Boolean getTrimLineRight() {
		return trimLineRight;
	}

	public void setTrimLineRight(Boolean trimLineRight) {
		this.trimLineRight = trimLineRight;
	}

}

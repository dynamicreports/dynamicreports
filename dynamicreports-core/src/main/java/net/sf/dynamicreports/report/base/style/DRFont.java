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

package net.sf.dynamicreports.report.base.style;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.style.DRIFont;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRFont implements DRIFont {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String fontName;
	private Integer fontSize;
	private Boolean bold;
	private Boolean italic;
	private Boolean underline;
	private Boolean strikeThrough;
	private String pdfFontName;
	private String pdfEncoding;
	private Boolean pdfEmbedded;

	public DRFont() {
	}

	public DRFont(String fontName, int fontSize) {
		this.fontName = fontName;
		this.setFontSize(fontSize);
	}

	public DRFont(String fontName, boolean bold, boolean italic, int fontSize) {
		this.fontName = fontName;
		this.bold = bold;
		this.italic = italic;
		this.setFontSize(fontSize);
	}

	@Override
	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	@Override
	public Boolean getBold() {
		return bold;
	}

	public void setBold(Boolean bold) {
		this.bold = bold;
	}

	@Override
	public Boolean getItalic() {
		return italic;
	}

	public void setItalic(Boolean italic) {
		this.italic = italic;
	}

	@Override
	public Boolean getUnderline() {
		return underline;
	}

	public void setUnderline(Boolean underline) {
		this.underline = underline;
	}

	@Override
	public Boolean getStrikeThrough() {
		return strikeThrough;
	}

	public void setStrikeThrough(Boolean strikeThrough) {
		this.strikeThrough = strikeThrough;
	}

	@Override
	public Integer getFontSize() {
		return fontSize;
	}

	public void setFontSize(Integer fontSize) {
		if (fontSize != null) {
			Validate.isTrue(fontSize >= 0, "fontSize must be >= 0");
		}
		this.fontSize = fontSize;
	}

	@Override
	public String getPdfFontName() {
		return pdfFontName;
	}

	@Deprecated
	public void setPdfFontName(String pdfFontName) {
		this.pdfFontName = pdfFontName;
	}

	@Override
	public String getPdfEncoding() {
		return pdfEncoding;
	}

	@Deprecated
	public void setPdfEncoding(String pdfEncoding) {
		this.pdfEncoding = pdfEncoding;
	}

	@Override
	public Boolean getPdfEmbedded() {
		return pdfEmbedded;
	}

	@Deprecated
	public void setPdfEmbedded(Boolean pdfEmbedded) {
		this.pdfEmbedded = pdfEmbedded;
	}
}

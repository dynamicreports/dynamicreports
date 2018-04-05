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

package net.sf.dynamicreports.report.builder.style;

import net.sf.dynamicreports.report.base.style.DRFont;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class FontBuilder extends AbstractBuilder<FontBuilder, DRFont> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected FontBuilder() {
		super(new DRFont());
	}

	protected FontBuilder(String fontName, Boolean bold, Boolean italic, Integer fontSize) {
		super(new DRFont(fontName, bold, italic, fontSize));
	}

	public FontBuilder setFontName(String fontName) {
		getObject().setFontName(fontName);
		return this;
	}

	public FontBuilder setFontSize(Integer fontSize) {
		getObject().setFontSize(fontSize);
		return this;
	}

	public FontBuilder bold() {
		return setBold(true);
	}

	public FontBuilder setBold(Boolean bold) {
		getObject().setBold(bold);
		return this;
	}

	public FontBuilder italic() {
		return setItalic(true);
	}

	public FontBuilder setItalic(Boolean italic) {
		getObject().setItalic(italic);
		return this;
	}

	public FontBuilder boldItalic() {
		setBold(true);
		return setItalic(true);
	}

	@Deprecated
	/**
	 * You should configure the fonts.xml file
	 */
	public FontBuilder setPdfEmbedded(Boolean pdfEmbedded) {
		getObject().setPdfEmbedded(pdfEmbedded);
		return this;
	}

	@Deprecated
	/**
	 * You should configure the fonts.xml file
	 */
	public FontBuilder setPdfEncoding(String pdfEncoding) {
		getObject().setPdfEncoding(pdfEncoding);
		return this;
	}

	@Deprecated
	/**
	 * You should configure the fonts.xml file
	 */
	public FontBuilder setPdfFontName(String pdfFontName) {
		getObject().setPdfFontName(pdfFontName);
		return this;
	}

	public FontBuilder strikeThrough() {
		return setStrikeThrough(true);
	}

	public FontBuilder setStrikeThrough(Boolean strikeThrough) {
		getObject().setStrikeThrough(strikeThrough);
		return this;
	}

	public FontBuilder underline() {
		return setUnderline(true);
	}

	public FontBuilder setUnderline(Boolean underline) {
		getObject().setUnderline(underline);
		return this;
	}

	public DRFont getFont() {
		return build();
	}
}

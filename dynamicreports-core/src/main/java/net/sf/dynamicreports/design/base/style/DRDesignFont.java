/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.design.base.style;

import net.sf.dynamicreports.design.definition.style.DRIDesignFont;
import net.sf.dynamicreports.report.constant.Constants;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * <p>DRDesignFont class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignFont implements DRIDesignFont {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFontName() {
        return fontName;
    }

    /**
     * <p>Setter for the field <code>fontName</code>.</p>
     *
     * @param fontName a {@link java.lang.String} object.
     */
    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getBold() {
        return bold;
    }

    /**
     * <p>Setter for the field <code>bold</code>.</p>
     *
     * @param bold a {@link java.lang.Boolean} object.
     */
    public void setBold(Boolean bold) {
        this.bold = bold;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getItalic() {
        return italic;
    }

    /**
     * <p>Setter for the field <code>italic</code>.</p>
     *
     * @param italic a {@link java.lang.Boolean} object.
     */
    public void setItalic(Boolean italic) {
        this.italic = italic;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getUnderline() {
        return underline;
    }

    /**
     * <p>Setter for the field <code>underline</code>.</p>
     *
     * @param underline a {@link java.lang.Boolean} object.
     */
    public void setUnderline(Boolean underline) {
        this.underline = underline;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getStrikeThrough() {
        return strikeThrough;
    }

    /**
     * <p>Setter for the field <code>strikeThrough</code>.</p>
     *
     * @param strikeThrough a {@link java.lang.Boolean} object.
     */
    public void setStrikeThrough(Boolean strikeThrough) {
        this.strikeThrough = strikeThrough;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * <p>Setter for the field <code>fontSize</code>.</p>
     *
     * @param fontSize a {@link java.lang.Integer} object.
     */
    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPdfFontName() {
        return pdfFontName;
    }

    /**
     * <p>Setter for the field <code>pdfFontName</code>.</p>
     *
     * @param pdfFontName a {@link java.lang.String} object.
     */
    public void setPdfFontName(String pdfFontName) {
        this.pdfFontName = pdfFontName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPdfEncoding() {
        return pdfEncoding;
    }

    /**
     * <p>Setter for the field <code>pdfEncoding</code>.</p>
     *
     * @param pdfEncoding a {@link java.lang.String} object.
     */
    public void setPdfEncoding(String pdfEncoding) {
        this.pdfEncoding = pdfEncoding;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getPdfEmbedded() {
        return pdfEmbedded;
    }

    /**
     * <p>Setter for the field <code>pdfEmbedded</code>.</p>
     *
     * @param pdfEmbedded a {@link java.lang.Boolean} object.
     */
    public void setPdfEmbedded(Boolean pdfEmbedded) {
        this.pdfEmbedded = pdfEmbedded;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }

        DRDesignFont o = (DRDesignFont) obj;
        EqualsBuilder equalsBuilder = new EqualsBuilder().append(fontName, o.fontName)
                                                         .append(fontSize, o.fontSize)
                                                         .append(bold, o.bold)
                                                         .append(italic, o.italic)
                                                         .append(underline, o.underline)
                                                         .append(strikeThrough, o.strikeThrough)
                                                         .append(pdfFontName, o.pdfFontName)
                                                         .append(pdfEncoding, o.pdfEncoding)
                                                         .append(pdfEmbedded, o.pdfEmbedded);
        return equalsBuilder.isEquals();
    }
}

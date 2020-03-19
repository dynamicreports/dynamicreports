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
package net.sf.dynamicreports.adhoc.configuration;

import java.io.Serializable;

/**
 * <p>AdhocFont class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class AdhocFont implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String fontName;
    private Integer fontSize;
    private Boolean bold;
    private Boolean italic;
    private Boolean underline;
    private Boolean strikeThrough;

    /**
     * <p>Getter for the field <code>fontName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
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
     * <p>Getter for the field <code>fontSize</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
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
     * <p>Getter for the field <code>bold</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
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
     * <p>Getter for the field <code>italic</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
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
     * <p>Getter for the field <code>underline</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
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
     * <p>Getter for the field <code>strikeThrough</code>.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AdhocFont)) {
            return false;
        }

        AdhocFont object = (AdhocFont) obj;
        if (!(fontName == null ? object.getFontName() == null : fontName.equals(object.getFontName()))) {
            return false;
        }
        if (!(fontSize == null ? object.getFontSize() == null : fontSize.equals(object.getFontSize()))) {
            return false;
        }
        if (!(bold == null ? object.getBold() == null : bold.equals(object.getBold()))) {
            return false;
        }
        if (!(italic == null ? object.getItalic() == null : italic.equals(object.getItalic()))) {
            return false;
        }
        if (!(underline == null ? object.getUnderline() == null : underline.equals(object.getUnderline()))) {
            return false;
        }
        if (!(strikeThrough == null ? object.getStrikeThrough() == null : strikeThrough.equals(object.getStrikeThrough()))) {
            return false;
        }

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AdhocFont clone() {
        AdhocFont clone;
        try {
            clone = (AdhocFont) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        return clone;
    }

}

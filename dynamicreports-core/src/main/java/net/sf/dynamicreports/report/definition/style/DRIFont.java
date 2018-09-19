/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.report.definition.style;

import java.io.Serializable;

/**
 * <p>DRIFont interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIFont extends Serializable {

    /**
     * <p>getFontName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFontName();

    /**
     * <p>getBold.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getBold();

    /**
     * <p>getItalic.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getItalic();

    /**
     * <p>getUnderline.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getUnderline();

    /**
     * <p>getStrikeThrough.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getStrikeThrough();

    /**
     * <p>getFontSize.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getFontSize();

    /**
     * <p>getPdfFontName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPdfFontName();

    /**
     * <p>getPdfEncoding.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPdfEncoding();

    /**
     * <p>getPdfEmbedded.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getPdfEmbedded();
}

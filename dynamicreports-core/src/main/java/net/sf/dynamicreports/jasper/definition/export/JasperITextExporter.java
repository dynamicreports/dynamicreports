/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.jasper.definition.export;

/**
 * <p>JasperITextExporter interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface JasperITextExporter extends JasperIExporter {

    /**
     * <p>getCharacterWidth.</p>
     *
     * @return a {@link java.lang.Float} object.
     */
    public Float getCharacterWidth();

    /**
     * <p>getCharacterHeight.</p>
     *
     * @return a {@link java.lang.Float} object.
     */
    public Float getCharacterHeight();

    /**
     * <p>getPageWidthInChars.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageWidthInChars();

    /**
     * <p>getPageHeightInChars.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageHeightInChars();

    /**
     * <p>getPageSeparator.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPageSeparator();

    /**
     * <p>getLineSeparator.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLineSeparator();

    /**
     * <p>getTrimLineRight.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getTrimLineRight();
}

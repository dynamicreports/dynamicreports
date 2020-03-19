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
package net.sf.dynamicreports.jasper.base.export;

import net.sf.dynamicreports.jasper.definition.export.JasperITextExporter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>JasperTextExporter class.</p>
 *
 * @author Ricardo Mariaca
 * 
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

    /** {@inheritDoc} */
    @Override
    public Float getCharacterWidth() {
        return characterWidth;
    }

    /**
     * <p>Setter for the field <code>characterWidth</code>.</p>
     *
     * @param characterWidth a {@link java.lang.Float} object.
     */
    public void setCharacterWidth(Float characterWidth) {
        this.characterWidth = characterWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Float getCharacterHeight() {
        return characterHeight;
    }

    /**
     * <p>Setter for the field <code>characterHeight</code>.</p>
     *
     * @param characterHeight a {@link java.lang.Float} object.
     */
    public void setCharacterHeight(Float characterHeight) {
        this.characterHeight = characterHeight;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageWidthInChars() {
        return pageWidthInChars;
    }

    /**
     * <p>Setter for the field <code>pageWidthInChars</code>.</p>
     *
     * @param pageWidthInChars a {@link java.lang.Integer} object.
     */
    public void setPageWidthInChars(Integer pageWidthInChars) {
        this.pageWidthInChars = pageWidthInChars;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageHeightInChars() {
        return pageHeightInChars;
    }

    /**
     * <p>Setter for the field <code>pageHeightInChars</code>.</p>
     *
     * @param pageHeightInChars a {@link java.lang.Integer} object.
     */
    public void setPageHeightInChars(Integer pageHeightInChars) {
        this.pageHeightInChars = pageHeightInChars;
    }

    /** {@inheritDoc} */
    @Override
    public String getPageSeparator() {
        return pageSeparator;
    }

    /**
     * <p>Setter for the field <code>pageSeparator</code>.</p>
     *
     * @param pageSeparator a {@link java.lang.String} object.
     */
    public void setPageSeparator(String pageSeparator) {
        this.pageSeparator = pageSeparator;
    }

    /** {@inheritDoc} */
    @Override
    public String getLineSeparator() {
        return lineSeparator;
    }

    /**
     * <p>Setter for the field <code>lineSeparator</code>.</p>
     *
     * @param lineSeparator a {@link java.lang.String} object.
     */
    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getTrimLineRight() {
        return trimLineRight;
    }

    /**
     * <p>Setter for the field <code>trimLineRight</code>.</p>
     *
     * @param trimLineRight a {@link java.lang.Boolean} object.
     */
    public void setTrimLineRight(Boolean trimLineRight) {
        this.trimLineRight = trimLineRight;
    }

}

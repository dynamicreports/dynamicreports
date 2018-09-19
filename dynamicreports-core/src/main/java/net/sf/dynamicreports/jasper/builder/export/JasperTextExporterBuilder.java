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

package net.sf.dynamicreports.jasper.builder.export;

import net.sf.dynamicreports.jasper.base.export.JasperTextExporter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>JasperTextExporterBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class JasperTextExporterBuilder extends AbstractJasperExporterBuilder<JasperTextExporterBuilder, JasperTextExporter> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for JasperTextExporterBuilder.</p>
     */
    protected JasperTextExporterBuilder() {
        super(new JasperTextExporter());
    }

    /**
     * <p>setCharacterWidth.</p>
     *
     * @deprecated To be removed. Use setCharacterWidth(Float characterWidth) instead.
     * @param characterWidth a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    @Deprecated
    public JasperTextExporterBuilder setCharacterWidth(Integer characterWidth) {
        return setCharacterWidth(characterWidth != null ? characterWidth.floatValue() : null);
    }

    /**
     * <p>setCharacterWidth.</p>
     *
     * @param characterWidth a {@link java.lang.Float} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    public JasperTextExporterBuilder setCharacterWidth(Float characterWidth) {
        this.getObject()
            .setCharacterWidth(characterWidth);
        return this;
    }

    /**
     * <p>setCharacterHeight.</p>
     *
     * @deprecated To be removed. Use setCharacterHeight(Float characterHeight) instead.
     * @param characterHeight a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    @Deprecated
    public JasperTextExporterBuilder setCharacterHeight(Integer characterHeight) {
        return setCharacterHeight(characterHeight != null ? characterHeight.floatValue() : null);
    }

    /**
     * <p>setCharacterHeight.</p>
     *
     * @param characterHeight a {@link java.lang.Float} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    public JasperTextExporterBuilder setCharacterHeight(Float characterHeight) {
        this.getObject()
            .setCharacterHeight(characterHeight);
        return this;
    }

    /**
     * <p>setPageWidth.</p>
     *
     * @deprecated To be removed. Use setPageWidthInChars instead.
     * @param pageWidth a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    @Deprecated
    public JasperTextExporterBuilder setPageWidth(Integer pageWidth) {
        return setPageWidthInChars(pageWidth);
    }

    /**
     * <p>setPageWidthInChars.</p>
     *
     * @param pageWidth a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    public JasperTextExporterBuilder setPageWidthInChars(Integer pageWidth) {
        this.getObject()
            .setPageWidthInChars(pageWidth);
        return this;
    }

    /**
     * <p>setPageHeight.</p>
     *
     * @deprecated To be removed. Use setPageHeightInChars instead.
     * @param pageHeight a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    @Deprecated
    public JasperTextExporterBuilder setPageHeight(Integer pageHeight) {
        return setPageHeightInChars(pageHeight);
    }

    /**
     * <p>setPageHeightInChars.</p>
     *
     * @param pageHeight a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    public JasperTextExporterBuilder setPageHeightInChars(Integer pageHeight) {
        this.getObject()
            .setPageHeightInChars(pageHeight);
        return this;
    }

    /**
     * <p>setBetweenPagesText.</p>
     *
     * @deprecated To be removed. Use setPageSeparator instead.
     * @param betweenPagesText a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    @Deprecated
    public JasperTextExporterBuilder setBetweenPagesText(String betweenPagesText) {
        return setPageSeparator(betweenPagesText);
    }

    /**
     * <p>setPageSeparator.</p>
     *
     * @param pageSeparator a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    public JasperTextExporterBuilder setPageSeparator(String pageSeparator) {
        this.getObject()
            .setPageSeparator(pageSeparator);
        return this;
    }

    /**
     * <p>setLineSeparator.</p>
     *
     * @param lineSeparator a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperTextExporterBuilder} object.
     */
    public JasperTextExporterBuilder setLineSeparator(String lineSeparator) {
        this.getObject()
            .setLineSeparator(lineSeparator);
        return this;
    }
}

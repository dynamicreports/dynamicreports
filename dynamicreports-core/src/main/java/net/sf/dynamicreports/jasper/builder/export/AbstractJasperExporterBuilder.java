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
package net.sf.dynamicreports.jasper.builder.export;

import net.sf.dynamicreports.jasper.base.export.AbstractJasperExporter;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.constant.Constants;

import java.io.File;
import java.io.OutputStream;
import java.io.Writer;

/**
 * <p>Abstract AbstractJasperExporterBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
@SuppressWarnings("unchecked")
public abstract class AbstractJasperExporterBuilder<T extends AbstractJasperExporterBuilder<T, U>, U extends AbstractJasperExporter> extends AbstractBuilder<T, U> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for AbstractJasperExporterBuilder.</p>
     *
     * @param jasperExporter a U object.
     */
    protected AbstractJasperExporterBuilder(U jasperExporter) {
        super(jasperExporter);
    }

    /**
     * <p>setOutputWriter.</p>
     *
     * @param outputWriter a {@link java.io.Writer} object.
     * @return a T object.
     */
    protected T setOutputWriter(Writer outputWriter) {
        getObject().setOutputWriter(outputWriter);
        return (T) this;
    }

    /**
     * <p>setOutputStream.</p>
     *
     * @param outputStream a {@link java.io.OutputStream} object.
     * @return a T object.
     */
    protected T setOutputStream(OutputStream outputStream) {
        getObject().setOutputStream(outputStream);
        return (T) this;
    }

    /**
     * <p>setOutputFile.</p>
     *
     * @param outputFile a {@link java.io.File} object.
     * @return a T object.
     */
    protected T setOutputFile(File outputFile) {
        getObject().setOutputFile(outputFile);
        return (T) this;
    }

    /**
     * <p>setOutputFileName.</p>
     *
     * @param outputFileName a {@link java.lang.String} object.
     * @return a T object.
     */
    protected T setOutputFileName(String outputFileName) {
        getObject().setOutputFileName(outputFileName);
        return (T) this;
    }

    /**
     * <p>setPageIndex.</p>
     *
     * @param pageIndex a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setPageIndex(Integer pageIndex) {
        getObject().setPageIndex(pageIndex);
        return (T) this;
    }

    /**
     * <p>setStartPageIndex.</p>
     *
     * @param startPageIndex a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setStartPageIndex(Integer startPageIndex) {
        getObject().setStartPageIndex(startPageIndex);
        return (T) this;
    }

    /**
     * <p>setEndPageIndex.</p>
     *
     * @param endPageIndex a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setEndPageIndex(Integer endPageIndex) {
        getObject().setEndPageIndex(endPageIndex);
        return (T) this;
    }

    /**
     * <p>setCharacterEncoding.</p>
     *
     * @param characterEncoding a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setCharacterEncoding(String characterEncoding) {
        getObject().setCharacterEncoding(characterEncoding);
        return (T) this;
    }

    /**
     * <p>setOffsetX.</p>
     *
     * @param offsetX a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setOffsetX(Integer offsetX) {
        getObject().setOffsetX(offsetX);
        return (T) this;
    }

    /**
     * <p>setOffsetY.</p>
     *
     * @param offsetY a {@link java.lang.Integer} object.
     * @return a T object.
     */
    public T setOffsetY(Integer offsetY) {
        getObject().setOffsetY(offsetY);
        return (T) this;
    }

    /**
     * <p>getExporter.</p>
     *
     * @return a U object.
     */
    public U getExporter() {
        return build();
    }
}

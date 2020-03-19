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
package net.sf.dynamicreports.jasper.builder.export;

import net.sf.dynamicreports.jasper.base.export.JasperCsvExporter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>JasperCsvExporterBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class JasperCsvExporterBuilder extends AbstractJasperExporterBuilder<JasperCsvExporterBuilder, JasperCsvExporter> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for JasperCsvExporterBuilder.</p>
     */
    protected JasperCsvExporterBuilder() {
        super(new JasperCsvExporter());
    }

    /**
     * <p>setFieldDelimiter.</p>
     *
     * @param fieldDelimiter a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder} object.
     */
    public JasperCsvExporterBuilder setFieldDelimiter(String fieldDelimiter) {
        this.getObject().setFieldDelimiter(fieldDelimiter);
        return this;
    }

    /**
     * <p>setRecordDelimiter.</p>
     *
     * @param recordDelimiter a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperCsvExporterBuilder} object.
     */
    public JasperCsvExporterBuilder setRecordDelimiter(String recordDelimiter) {
        this.getObject().setRecordDelimiter(recordDelimiter);
        return this;
    }
}

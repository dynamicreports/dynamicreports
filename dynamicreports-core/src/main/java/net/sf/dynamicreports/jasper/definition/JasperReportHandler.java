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
package net.sf.dynamicreports.jasper.definition;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.util.List;

/**
 * <p>JasperReportHandler interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface JasperReportHandler {

    /**
     * <p>concatenate.</p>
     *
     * @param jasperReportBuilders a {@link net.sf.dynamicreports.jasper.builder.JasperReportBuilder} object.
     */
    public void concatenate(JasperReportBuilder... jasperReportBuilders);

    /**
     * <p>setContinuousPageNumbering.</p>
     *
     * @param continuousPageNumbering a boolean.
     */
    public void setContinuousPageNumbering(boolean continuousPageNumbering);

    /**
     * <p>getPrintList.</p>
     *
     * @return a {@link java.util.List} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public List<JasperPrint> getPrintList() throws DRException;
}

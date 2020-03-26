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
package net.sf.dynamicreports.adhoc.report;

import net.sf.dynamicreports.adhoc.configuration.AdhocReport;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.exception.DRException;

/**
 * <p>AdhocReportCustomizer interface.</p>
 * <p>
 * Enables runtime-provided report configurations to be added to the library, with out using xml like one would with JasperReports library.
 *
 * @author Ricardo Mariaca
 * 
 */
public interface AdhocReportCustomizer {

    /**
     * <p>customize.</p>
     *
     * @param report      a {@link net.sf.dynamicreports.report.builder.ReportBuilder} object.
     * @param adhocReport a {@link net.sf.dynamicreports.adhoc.configuration.AdhocReport} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public void customize(ReportBuilder<?> report, AdhocReport adhocReport) throws DRException;

}

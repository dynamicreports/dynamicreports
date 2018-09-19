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

package net.sf.dynamicreports.report.definition.chart;

import net.sf.dynamicreports.report.definition.ReportParameters;
import org.jfree.chart.JFreeChart;

import java.io.Serializable;

/**
 * <p>DRIChartCustomizer interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIChartCustomizer extends Serializable {

    /**
     * <p>customize.</p>
     *
     * @param chart a {@link org.jfree.chart.JFreeChart} object.
     * @param reportParameters a {@link net.sf.dynamicreports.report.definition.ReportParameters} object.
     */
    public void customize(JFreeChart chart, ReportParameters reportParameters);
}

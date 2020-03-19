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
package net.sf.dynamicreports.jasper.base;

import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
import net.sf.jasperreports.engine.JRAbstractChartCustomizer;
import net.sf.jasperreports.engine.JRChart;
import org.jfree.chart.JFreeChart;

import java.util.List;

/**
 * <p>JasperChartCustomizer class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class JasperChartCustomizer extends JRAbstractChartCustomizer {

    /** {@inheritDoc} */
    @Override
    public void customize(JFreeChart chart, JRChart jasperChart) {
        String key = jasperChart.getKey();
        JasperScriptlet scriptlet = (JasperScriptlet) getParameterValue(JasperScriptlet.SCRIPTLET_NAME);
        List<DRIChartCustomizer> chartCustomizers = scriptlet.getChartCustomizers(key);
        for (DRIChartCustomizer chartCustomizer : chartCustomizers) {
            chartCustomizer.customize(chart, scriptlet.getReportParameters());
        }
    }

}

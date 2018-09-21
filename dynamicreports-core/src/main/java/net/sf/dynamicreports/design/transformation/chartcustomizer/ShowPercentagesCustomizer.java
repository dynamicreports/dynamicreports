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
package net.sf.dynamicreports.design.transformation.chartcustomizer;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.category.CategoryDataset;

import java.io.Serializable;

/**
 * <p>ShowPercentagesCustomizer class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class ShowPercentagesCustomizer implements DRIChartCustomizer, Serializable {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /** {@inheritDoc} */
    @Override
    public void customize(JFreeChart chart, ReportParameters reportParameters) {
        if (chart.getPlot() instanceof CategoryPlot) {
            if (chart.getCategoryPlot()
                     .getDataset() != null) {
                CategoryDataset dataset;
                if (!(chart.getCategoryPlot()
                           .getRenderer() instanceof GroupedStackedBarRenderer)) {
                    dataset = new PercentageCategoryDataset(chart.getCategoryPlot()
                                                                 .getDataset());
                } else {
                    dataset = new PercentageGroupedCategoryDataset(chart.getCategoryPlot()
                                                                        .getDataset());
                }
                chart.getCategoryPlot()
                     .setDataset(dataset);
            }
            if (StringUtils.isBlank(chart.getCategoryPlot()
                                         .getRangeAxis()
                                         .getLabel())) {
                chart.getCategoryPlot()
                     .getRangeAxis()
                     .setLabel("%");
            }
        }
    }
}

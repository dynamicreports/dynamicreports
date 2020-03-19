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
package net.sf.dynamicreports.design.definition.chart;

import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignChartDataset;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignPlot;
import net.sf.dynamicreports.design.definition.component.DRIDesignHyperLinkComponent;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;

import java.util.List;

/**
 * <p>DRIDesignChart interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public interface DRIDesignChart extends DRIDesignHyperLinkComponent {

    /**
     * <p>getChartType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.ChartType} object.
     */
    public ChartType getChartType();

    /**
     * <p>getDataset.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignChartDataset} object.
     */
    public DRIDesignChartDataset getDataset();

    /**
     * <p>getPlot.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.chart.plot.DRIDesignPlot} object.
     */
    public DRIDesignPlot getPlot();

    /**
     * <p>getCustomizers.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRIChartCustomizer> getCustomizers();

    /**
     * <p>getTitle.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.chart.DRIDesignChartTitle} object.
     */
    public DRIDesignChartTitle getTitle();

    /**
     * <p>getSubtitle.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.chart.DRIDesignChartSubtitle} object.
     */
    public DRIDesignChartSubtitle getSubtitle();

    /**
     * <p>getLegend.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.chart.DRIDesignChartLegend} object.
     */
    public DRIDesignChartLegend getLegend();

    /**
     * <p>getEvaluationTime.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.constant.EvaluationTime} object.
     */
    public EvaluationTime getEvaluationTime();

    /**
     * <p>getEvaluationGroup.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignGroup} object.
     */
    public DRIDesignGroup getEvaluationGroup();

    /**
     * <p>getTheme.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTheme();
}

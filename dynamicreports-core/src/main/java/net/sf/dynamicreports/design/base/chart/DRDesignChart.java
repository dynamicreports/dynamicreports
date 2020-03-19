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
package net.sf.dynamicreports.design.base.chart;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignChartDataset;
import net.sf.dynamicreports.design.base.component.DRDesignHyperlinkComponent;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.chart.DRIDesignChart;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignPlot;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRDesignChart class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class DRDesignChart extends DRDesignHyperlinkComponent implements DRIDesignChart {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private ChartType chartType;
    private DRDesignChartDataset dataset;
    private DRIDesignPlot plot;
    private List<DRIChartCustomizer> customizers;
    private DRDesignChartTitle title;
    private DRDesignChartSubtitle subtitle;
    private DRDesignChartLegend legend;
    private EvaluationTime evaluationTime;
    private DRDesignGroup evaluationGroup;
    private String theme;

    /**
     * <p>Constructor for DRDesignChart.</p>
     */
    public DRDesignChart() {
        super("chart");
        customizers = new ArrayList<DRIChartCustomizer>();
    }

    /** {@inheritDoc} */
    @Override
    public ChartType getChartType() {
        return chartType;
    }

    /**
     * <p>Setter for the field <code>chartType</code>.</p>
     *
     * @param chartType a {@link net.sf.dynamicreports.report.constant.ChartType} object.
     */
    public void setChartType(ChartType chartType) {
        this.chartType = chartType;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignChartDataset getDataset() {
        return dataset;
    }

    /**
     * <p>Setter for the field <code>dataset</code>.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.design.base.chart.dataset.DRDesignChartDataset} object.
     */
    public void setDataset(DRDesignChartDataset dataset) {
        this.dataset = dataset;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignPlot getPlot() {
        return plot;
    }

    /**
     * <p>Setter for the field <code>plot</code>.</p>
     *
     * @param plot a {@link net.sf.dynamicreports.design.definition.chart.plot.DRIDesignPlot} object.
     */
    public void setPlot(DRIDesignPlot plot) {
        this.plot = plot;
    }

    /** {@inheritDoc} */
    @Override
    public List<DRIChartCustomizer> getCustomizers() {
        return customizers;
    }

    /**
     * <p>Setter for the field <code>customizers</code>.</p>
     *
     * @param customizers a {@link java.util.List} object.
     */
    public void setCustomizers(List<DRIChartCustomizer> customizers) {
        this.customizers = customizers;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignChartTitle getTitle() {
        return title;
    }

    /**
     * <p>Setter for the field <code>title</code>.</p>
     *
     * @param title a {@link net.sf.dynamicreports.design.base.chart.DRDesignChartTitle} object.
     */
    public void setTitle(DRDesignChartTitle title) {
        this.title = title;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignChartSubtitle getSubtitle() {
        return subtitle;
    }

    /**
     * <p>Setter for the field <code>subtitle</code>.</p>
     *
     * @param subtitle a {@link net.sf.dynamicreports.design.base.chart.DRDesignChartSubtitle} object.
     */
    public void setSubtitle(DRDesignChartSubtitle subtitle) {
        this.subtitle = subtitle;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignChartLegend getLegend() {
        return legend;
    }

    /**
     * <p>Setter for the field <code>legend</code>.</p>
     *
     * @param legend a {@link net.sf.dynamicreports.design.base.chart.DRDesignChartLegend} object.
     */
    public void setLegend(DRDesignChartLegend legend) {
        this.legend = legend;
    }

    /** {@inheritDoc} */
    @Override
    public EvaluationTime getEvaluationTime() {
        return evaluationTime;
    }

    /**
     * <p>Setter for the field <code>evaluationTime</code>.</p>
     *
     * @param evaluationTime a {@link net.sf.dynamicreports.design.constant.EvaluationTime} object.
     */
    public void setEvaluationTime(EvaluationTime evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignGroup getEvaluationGroup() {
        return evaluationGroup;
    }

    /**
     * <p>Setter for the field <code>evaluationGroup</code>.</p>
     *
     * @param evaluationGroup a {@link net.sf.dynamicreports.design.base.DRDesignGroup} object.
     */
    public void setEvaluationGroup(DRDesignGroup evaluationGroup) {
        this.evaluationGroup = evaluationGroup;
    }

    /** {@inheritDoc} */
    @Override
    public String getTheme() {
        return theme;
    }

    /**
     * <p>Setter for the field <code>theme</code>.</p>
     *
     * @param theme a {@link java.lang.String} object.
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }
}

/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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

import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.chart.dataset.DRDesignChartDataset;
import net.sf.dynamicreports.design.base.component.DRDesignHyperlinkComponent;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.chart.DRIDesignChart;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignPlot;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
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

	public DRDesignChart() {
		super("chart");
		customizers = new ArrayList<DRIChartCustomizer>();
	}

	@Override
	public ChartType getChartType() {
		return chartType;
	}

	public void setChartType(ChartType chartType) {
		this.chartType = chartType;
	}

	@Override
	public DRDesignChartDataset getDataset() {
		return dataset;
	}

	public void setDataset(DRDesignChartDataset dataset) {
		this.dataset = dataset;
	}

	@Override
	public DRIDesignPlot getPlot() {
		return plot;
	}

	public void setPlot(DRIDesignPlot plot) {
		this.plot = plot;
	}

	@Override
	public List<DRIChartCustomizer> getCustomizers() {
		return customizers;
	}

	public void setCustomizers(List<DRIChartCustomizer> customizers) {
		this.customizers = customizers;
	}

	@Override
	public DRDesignChartTitle getTitle() {
		return title;
	}

	public void setTitle(DRDesignChartTitle title) {
		this.title = title;
	}

	@Override
	public DRDesignChartSubtitle getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(DRDesignChartSubtitle subtitle) {
		this.subtitle = subtitle;
	}

	@Override
	public DRDesignChartLegend getLegend() {
		return legend;
	}

	public void setLegend(DRDesignChartLegend legend) {
		this.legend = legend;
	}

	@Override
	public EvaluationTime getEvaluationTime() {
		return evaluationTime;
	}

	public void setEvaluationTime(EvaluationTime evaluationTime) {
		this.evaluationTime = evaluationTime;
	}

	@Override
	public DRDesignGroup getEvaluationGroup() {
		return evaluationGroup;
	}

	public void setEvaluationGroup(DRDesignGroup evaluationGroup) {
		this.evaluationGroup = evaluationGroup;
	}

	@Override
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
}

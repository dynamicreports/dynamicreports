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

package net.sf.dynamicreports.report.definition.chart;

import java.util.List;

import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.definition.chart.dataset.DRIChartDataset;
import net.sf.dynamicreports.report.definition.chart.plot.DRIPlot;
import net.sf.dynamicreports.report.definition.component.DRIHyperLinkComponent;

/**
 * <p>DRIChart interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIChart extends DRIHyperLinkComponent {

	/**
	 * <p>getChartType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.ChartType} object.
	 */
	public ChartType getChartType();

	/**
	 * <p>getDataset.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.chart.dataset.DRIChartDataset} object.
	 */
	public DRIChartDataset getDataset();

	/**
	 * <p>getPlot.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.chart.plot.DRIPlot} object.
	 */
	public DRIPlot getPlot();

	/**
	 * <p>getCustomizers.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<DRIChartCustomizer> getCustomizers();

	/**
	 * <p>getTitle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.chart.DRIChartTitle} object.
	 */
	public DRIChartTitle getTitle();

	/**
	 * <p>getSubtitle.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.chart.DRIChartSubtitle} object.
	 */
	public DRIChartSubtitle getSubtitle();

	/**
	 * <p>getLegend.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.chart.DRIChartLegend} object.
	 */
	public DRIChartLegend getLegend();

	/**
	 * <p>getTheme.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTheme();
}

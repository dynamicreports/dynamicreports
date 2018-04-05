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

package net.sf.dynamicreports.report.base.chart.plot;

import java.util.Comparator;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.OrderType;
import net.sf.dynamicreports.report.definition.chart.plot.DRIAxisPlot;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRAxisPlot extends AbstractBasePlot implements DRIAxisPlot {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRAxisFormat xAxisFormat;
	private DRAxisFormat yAxisFormat;
	private Boolean showValues;
	private String valuePattern;
	private Boolean showPercentages;
	private String percentValuePattern;
	private Comparator<String> seriesOrderBy;
	private OrderType seriesOrderType;

	@Override
	protected void init() {
		super.init();
		this.xAxisFormat = new DRAxisFormat();
		this.yAxisFormat = new DRAxisFormat();
	}

	@Override
	public DRAxisFormat getXAxisFormat() {
		return xAxisFormat;
	}

	public void setXAxisFormat(DRAxisFormat xAxisFormat) {
		Validate.notNull(xAxisFormat, "xAxisFormat must not be null");
		this.xAxisFormat = xAxisFormat;
	}

	@Override
	public DRAxisFormat getYAxisFormat() {
		return yAxisFormat;
	}

	public void setYAxisFormat(DRAxisFormat yAxisFormat) {
		Validate.notNull(yAxisFormat, "yAxisFormat must not be null");
		this.yAxisFormat = yAxisFormat;
	}

	@Override
	public Boolean getShowValues() {
		return showValues;
	}

	public void setShowValues(Boolean showValues) {
		this.showValues = showValues;
	}

	@Override
	public String getValuePattern() {
		return valuePattern;
	}

	public void setValuePattern(String valuePattern) {
		this.valuePattern = valuePattern;
	}

	@Override
	public Boolean getShowPercentages() {
		return showPercentages;
	}

	public void setShowPercentages(Boolean showPercentages) {
		this.showPercentages = showPercentages;
	}

	@Override
	public String getPercentValuePattern() {
		return percentValuePattern;
	}

	public void setPercentValuePattern(String percentValuePattern) {
		this.percentValuePattern = percentValuePattern;
	}

	@Override
	public Comparator<String> getSeriesOrderBy() {
		return seriesOrderBy;
	}

	public void setSeriesOrderBy(Comparator<String> seriesOrderBy) {
		this.seriesOrderBy = seriesOrderBy;
	}

	@Override
	public OrderType getSeriesOrderType() {
		return seriesOrderType;
	}

	public void setSeriesOrderType(OrderType seriesOrderType) {
		this.seriesOrderType = seriesOrderType;
	}

}

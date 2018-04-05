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

package net.sf.dynamicreports.adhoc.configuration;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class AdhocChart extends AdhocComponent {
	private static final long serialVersionUID = 1L;

	private AdhocChartType type;
	private String title;
	private AdhocFont titleFont;
	private Color titleColor;
	private Boolean showLegend;
	private String xValue;
	private List<AdhocChartSerie> series;
	private List<Color> seriesColors;
	private AdhocAxisFormat xAxisFormat;
	private AdhocAxisFormat yAxisFormat;
	private AdhocOrientation orientation;

	public AdhocChart() {
		series = new ArrayList<AdhocChartSerie>();
		seriesColors = new ArrayList<Color>();
	}

	public AdhocChartType getType() {
		return type;
	}

	public void setType(AdhocChartType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AdhocFont getTitleFont() {
		return titleFont;
	}

	public void setTitleFont(AdhocFont titleFont) {
		this.titleFont = titleFont;
	}

	public Color getTitleColor() {
		return titleColor;
	}

	public void setTitleColor(Color titleColor) {
		this.titleColor = titleColor;
	}

	public Boolean getShowLegend() {
		return showLegend;
	}

	public void setShowLegend(Boolean showLegend) {
		this.showLegend = showLegend;
	}

	public String getXValue() {
		return xValue;
	}

	public void setXValue(String xValue) {
		this.xValue = xValue;
	}

	public List<AdhocChartSerie> getSeries() {
		return series;
	}

	public void addSerie(AdhocChartSerie serie) {
		this.series.add(serie);
	}

	public void setSeries(List<AdhocChartSerie> series) {
		this.series = series;
	}

	public List<Color> getSeriesColors() {
		return seriesColors;
	}

	public void addSeriesColor(Color seriesColor) {
		this.seriesColors.add(seriesColor);
	}

	public void setSeriesColors(List<Color> seriesColors) {
		this.seriesColors = seriesColors;
	}

	public AdhocAxisFormat getXAxisFormat() {
		return xAxisFormat;
	}

	public void setXAxisFormat(AdhocAxisFormat xAxisFormat) {
		this.xAxisFormat = xAxisFormat;
	}

	public AdhocAxisFormat getYAxisFormat() {
		return yAxisFormat;
	}

	public void setYAxisFormat(AdhocAxisFormat yAxisFormat) {
		this.yAxisFormat = yAxisFormat;
	}

	public AdhocOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(AdhocOrientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equals = super.equals(obj);
		if (!equals) {
			return false;
		}
		if (obj == null)
			return false;
		if (!(obj instanceof AdhocChart))
			return false;

		AdhocChart object = (AdhocChart) obj;
		if (!(type == null ? object.getType() == null : type.equals(object.getType()))) {
			return false;
		}
		if (!(title == null ? object.getTitle() == null : title.equals(object.getTitle()))) {
			return false;
		}
		if (!(titleFont == null ? object.getTitleFont() == null : titleFont.equals(object.getTitleFont()))) {
			return false;
		}
		if (!(titleColor == null ? object.getTitleColor() == null : titleColor.equals(object.getTitleColor()))) {
			return false;
		}
		if (!(showLegend == null ? object.getShowLegend() == null : showLegend.equals(object.getShowLegend()))) {
			return false;
		}
		if (!(xValue == null ? object.getXValue() == null : xValue.equals(object.getXValue()))) {
			return false;
		}
		if (!(series == null ? object.getSeries() == null : series.equals(object.getSeries()))) {
			return false;
		}
		if (!(seriesColors == null ? object.getSeriesColors() == null : seriesColors.equals(object.getSeriesColors()))) {
			return false;
		}
		if (!(xAxisFormat == null ? object.getXAxisFormat() == null : xAxisFormat.equals(object.getXAxisFormat()))) {
			return false;
		}
		if (!(yAxisFormat == null ? object.getYAxisFormat() == null : yAxisFormat.equals(object.getYAxisFormat()))) {
			return false;
		}
		if (!(orientation == null ? object.getOrientation() == null : orientation.equals(object.getOrientation()))) {
			return false;
		}

		return true;
	}

	@Override
	public AdhocChart clone() {
		AdhocChart clone = (AdhocChart) super.clone();

		if (titleFont != null) {
			clone.titleFont = titleFont.clone();
		}
		if (series != null) {
			clone.series = new ArrayList<AdhocChartSerie>();
			for (AdhocChartSerie adhocCategoryChartSerie : series) {
				clone.addSerie(adhocCategoryChartSerie.clone());
			}
		}
		if (seriesColors != null) {
			clone.seriesColors = new ArrayList<Color>();
			for (Color adhocSeriesColor : seriesColors) {
				clone.addSeriesColor(adhocSeriesColor);
			}
		}
		if (xAxisFormat != null) {
			clone.xAxisFormat = xAxisFormat.clone();
		}
		if (yAxisFormat != null) {
			clone.yAxisFormat = yAxisFormat.clone();
		}

		return clone;
	}

}

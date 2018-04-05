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

package net.sf.dynamicreports.googlecharts.report.geomap;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.report.base.component.DRDimensionComponent;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRGeoMap extends DRDimensionComponent implements DRIGeoMap {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Boolean showLegend;
	private GeoMapDataMode dataMode;
	private DRIExpression<String> regionExpression;
	private DRIExpression<String> valueLabelExpression;
	private List<Color> colors;
	private DRGeoMapDataset dataset;

	public DRGeoMap() {
		dataset = new DRGeoMapDataset();
	}

	@Override
	public Boolean getShowLegend() {
		return showLegend;
	}

	public void setShowLegend(Boolean showLegend) {
		this.showLegend = showLegend;
	}

	@Override
	public GeoMapDataMode getDataMode() {
		return dataMode;
	}

	public void setDataMode(GeoMapDataMode dataMode) {
		this.dataMode = dataMode;
	}

	@Override
	public DRIExpression<String> getRegionExpression() {
		return regionExpression;
	}

	public void setRegionExpression(DRIExpression<String> regionExpression) {
		this.regionExpression = regionExpression;
	}

	@Override
	public DRIExpression<String> getValueLabelExpression() {
		return valueLabelExpression;
	}

	public void setValueLabelExpression(DRIExpression<String> valueLabelExpression) {
		this.valueLabelExpression = valueLabelExpression;
	}

	@Override
	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	public void addColor(Color color) {
		if (colors == null) {
			colors = new ArrayList<Color>();
		}
		colors.add(color);
	}

	@Override
	public DRGeoMapDataset getDataset() {
		return dataset;
	}

	public void setDataset(DRGeoMapDataset dataset) {
		this.dataset = dataset;
	}
}

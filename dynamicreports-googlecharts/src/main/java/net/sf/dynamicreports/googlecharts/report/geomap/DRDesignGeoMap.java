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
import java.util.List;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.base.component.DRDesignComponent;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapPrintElement;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignGeoMap extends DRDesignComponent implements DRIDesignGeoMap {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private EvaluationTime evaluationTime;
	private DRDesignGroup evaluationGroup;
	private Boolean showLegend;
	private GeoMapDataMode dataMode;
	private DRIDesignExpression regionExpression;
	private DRIDesignExpression valueLabelExpression;
	private List<Color> colors;
	private DRDesignGeoMapDataset dataset;

	public DRDesignGeoMap() {
		super(GeoMapPrintElement.GEOMAP_ELEMENT_NAME);
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
	public DRIDesignExpression getRegionExpression() {
		return regionExpression;
	}

	public void setRegionExpression(DRIDesignExpression regionExpression) {
		this.regionExpression = regionExpression;
	}

	@Override
	public DRIDesignExpression getValueLabelExpression() {
		return valueLabelExpression;
	}

	public void setValueLabelExpression(DRIDesignExpression valueLabelExpression) {
		this.valueLabelExpression = valueLabelExpression;
	}

	@Override
	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}

	@Override
	public DRDesignGeoMapDataset getDataset() {
		return dataset;
	}

	public void setDataset(DRDesignGeoMapDataset dataset) {
		this.dataset = dataset;
	}
}

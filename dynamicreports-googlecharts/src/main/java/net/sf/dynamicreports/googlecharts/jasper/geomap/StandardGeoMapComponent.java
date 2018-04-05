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

package net.sf.dynamicreports.googlecharts.jasper.geomap;

import java.awt.Color;
import java.io.Serializable;
import java.util.List;

import net.sf.dynamicreports.googlecharts.report.geomap.GeoMapDataMode;
import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.base.JRBaseObjectFactory;
import net.sf.jasperreports.engine.design.events.JRChangeEventsSupport;
import net.sf.jasperreports.engine.design.events.JRPropertyChangeSupport;
import net.sf.jasperreports.engine.type.EvaluationTimeEnum;
import net.sf.jasperreports.engine.util.JRCloneUtils;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class StandardGeoMapComponent implements GeoMapComponent, Serializable, JRChangeEventsSupport {
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	public static final String PROPERTY_EVALUATION_TIME = "evaluationTime";
	public static final String PROPERTY_EVALUATION_GROUP = "evaluationGroup";
	public static final String PROPERTY_SHOW_LEGEND = "showLegend";
	public static final String PROPERTY_DATA_MODE = "dataMode";
	public static final String PROPERTY_REGION_EXPRESSION = "regionExpression";
	public static final String PROPERTY_VALUE_LABEL_EXPRESSION = "valueLabelExpression";
	public static final String PROPERTY_COLORS = "colors";
	public static final String PROPERTY_DATASET = "dataset";

	private EvaluationTimeEnum evaluationTime = EvaluationTimeEnum.NOW;
	private String evaluationGroup;
	private Boolean showLegend;
	private GeoMapDataMode dataMode;
	private JRExpression regionExpression;
	private JRExpression valueLabelExpression;
	private List<Color> colors;
	private GeoMapDataset dataset;

	private transient JRPropertyChangeSupport eventSupport;

	public StandardGeoMapComponent() {
	}

	public StandardGeoMapComponent(GeoMapComponent component, JRBaseObjectFactory factory) {
		this.evaluationTime = component.getEvaluationTime();
		this.evaluationGroup = component.getEvaluationGroup();
		this.showLegend = component.getShowLegend();
		this.dataMode = component.getDataMode();
		this.regionExpression = factory.getExpression(component.getRegionExpression());
		this.valueLabelExpression = factory.getExpression(component.getValueLabelExpression());
		this.colors = component.getColors();
		this.dataset = new StandardGeoMapDataset(component.getDataset(), factory);
	}

	@Override
	public EvaluationTimeEnum getEvaluationTime() {
		return evaluationTime;
	}

	public void setEvaluationTime(EvaluationTimeEnum evaluationTimeValue) {
		Object old = this.evaluationTime;
		this.evaluationTime = evaluationTimeValue;
		getEventSupport().firePropertyChange(PROPERTY_EVALUATION_TIME, old, this.evaluationTime);
	}

	@Override
	public String getEvaluationGroup() {
		return evaluationGroup;
	}

	public void setEvaluationGroup(String evaluationGroup) {
		Object old = this.evaluationGroup;
		this.evaluationGroup = evaluationGroup;
		getEventSupport().firePropertyChange(PROPERTY_EVALUATION_GROUP, old, this.evaluationGroup);
	}

	@Override
	public Boolean getShowLegend() {
		return showLegend;
	}

	public void setShowLegend(Boolean showLegend) {
		Object old = this.showLegend;
		this.showLegend = showLegend;
		getEventSupport().firePropertyChange(PROPERTY_SHOW_LEGEND, old, this.showLegend);
	}

	@Override
	public GeoMapDataMode getDataMode() {
		return dataMode;
	}

	public void setDataMode(GeoMapDataMode dataMode) {
		Object old = this.dataMode;
		this.dataMode = dataMode;
		getEventSupport().firePropertyChange(PROPERTY_DATA_MODE, old, this.dataMode);
	}

	@Override
	public JRExpression getRegionExpression() {
		return regionExpression;
	}

	public void setRegionExpression(JRExpression regionExpression) {
		Object old = this.regionExpression;
		this.regionExpression = regionExpression;
		getEventSupport().firePropertyChange(PROPERTY_REGION_EXPRESSION, old, this.regionExpression);
	}

	@Override
	public JRExpression getValueLabelExpression() {
		return valueLabelExpression;
	}

	public void setValueLabelExpression(JRExpression valueLabelExpression) {
		Object old = this.valueLabelExpression;
		this.valueLabelExpression = valueLabelExpression;
		getEventSupport().firePropertyChange(PROPERTY_VALUE_LABEL_EXPRESSION, old, this.valueLabelExpression);
	}

	@Override
	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		Object old = this.colors;
		this.colors = colors;
		getEventSupport().firePropertyChange(PROPERTY_COLORS, old, this.colors);
	}

	@Override
	public GeoMapDataset getDataset() {
		return dataset;
	}

	public void setDataset(GeoMapDataset dataset) {
		Object old = this.dataset;
		this.dataset = dataset;
		getEventSupport().firePropertyChange(PROPERTY_DATASET, old, this.dataset);
	}

	@Override
	public JRPropertyChangeSupport getEventSupport() {
		synchronized (this) {
			if (eventSupport == null) {
				eventSupport = new JRPropertyChangeSupport(this);
			}
		}

		return eventSupport;
	}

	@Override
	public Object clone() {
		StandardGeoMapComponent clone = null;
		try {
			clone = (StandardGeoMapComponent) super.clone();
		} catch (CloneNotSupportedException e) {
			// never
			throw new JRRuntimeException(e);
		}
		clone.regionExpression = JRCloneUtils.nullSafeClone(regionExpression);
		clone.valueLabelExpression = JRCloneUtils.nullSafeClone(valueLabelExpression);
		clone.dataset = JRCloneUtils.nullSafeClone(dataset);
		clone.eventSupport = null;
		return clone;
	}
}

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
 * <p>StandardGeoMapComponent class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class StandardGeoMapComponent implements GeoMapComponent, Serializable, JRChangeEventsSupport {
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	/** Constant <code>PROPERTY_EVALUATION_TIME="evaluationTime"</code> */
	public static final String PROPERTY_EVALUATION_TIME = "evaluationTime";
	/** Constant <code>PROPERTY_EVALUATION_GROUP="evaluationGroup"</code> */
	public static final String PROPERTY_EVALUATION_GROUP = "evaluationGroup";
	/** Constant <code>PROPERTY_SHOW_LEGEND="showLegend"</code> */
	public static final String PROPERTY_SHOW_LEGEND = "showLegend";
	/** Constant <code>PROPERTY_DATA_MODE="dataMode"</code> */
	public static final String PROPERTY_DATA_MODE = "dataMode";
	/** Constant <code>PROPERTY_REGION_EXPRESSION="regionExpression"</code> */
	public static final String PROPERTY_REGION_EXPRESSION = "regionExpression";
	/** Constant <code>PROPERTY_VALUE_LABEL_EXPRESSION="valueLabelExpression"</code> */
	public static final String PROPERTY_VALUE_LABEL_EXPRESSION = "valueLabelExpression";
	/** Constant <code>PROPERTY_COLORS="colors"</code> */
	public static final String PROPERTY_COLORS = "colors";
	/** Constant <code>PROPERTY_DATASET="dataset"</code> */
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

	/**
	 * <p>Constructor for StandardGeoMapComponent.</p>
	 */
	public StandardGeoMapComponent() {
	}

	/**
	 * <p>Constructor for StandardGeoMapComponent.</p>
	 *
	 * @param component a {@link net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapComponent} object.
	 * @param factory a {@link net.sf.jasperreports.engine.base.JRBaseObjectFactory} object.
	 */
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

	/** {@inheritDoc} */
	@Override
	public EvaluationTimeEnum getEvaluationTime() {
		return evaluationTime;
	}

	/**
	 * <p>Setter for the field <code>evaluationTime</code>.</p>
	 *
	 * @param evaluationTimeValue a {@link net.sf.jasperreports.engine.type.EvaluationTimeEnum} object.
	 */
	public void setEvaluationTime(EvaluationTimeEnum evaluationTimeValue) {
		Object old = this.evaluationTime;
		this.evaluationTime = evaluationTimeValue;
		getEventSupport().firePropertyChange(PROPERTY_EVALUATION_TIME, old, this.evaluationTime);
	}

	/** {@inheritDoc} */
	@Override
	public String getEvaluationGroup() {
		return evaluationGroup;
	}

	/**
	 * <p>Setter for the field <code>evaluationGroup</code>.</p>
	 *
	 * @param evaluationGroup a {@link java.lang.String} object.
	 */
	public void setEvaluationGroup(String evaluationGroup) {
		Object old = this.evaluationGroup;
		this.evaluationGroup = evaluationGroup;
		getEventSupport().firePropertyChange(PROPERTY_EVALUATION_GROUP, old, this.evaluationGroup);
	}

	/** {@inheritDoc} */
	@Override
	public Boolean getShowLegend() {
		return showLegend;
	}

	/**
	 * <p>Setter for the field <code>showLegend</code>.</p>
	 *
	 * @param showLegend a {@link java.lang.Boolean} object.
	 */
	public void setShowLegend(Boolean showLegend) {
		Object old = this.showLegend;
		this.showLegend = showLegend;
		getEventSupport().firePropertyChange(PROPERTY_SHOW_LEGEND, old, this.showLegend);
	}

	/** {@inheritDoc} */
	@Override
	public GeoMapDataMode getDataMode() {
		return dataMode;
	}

	/**
	 * <p>Setter for the field <code>dataMode</code>.</p>
	 *
	 * @param dataMode a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapDataMode} object.
	 */
	public void setDataMode(GeoMapDataMode dataMode) {
		Object old = this.dataMode;
		this.dataMode = dataMode;
		getEventSupport().firePropertyChange(PROPERTY_DATA_MODE, old, this.dataMode);
	}

	/** {@inheritDoc} */
	@Override
	public JRExpression getRegionExpression() {
		return regionExpression;
	}

	/**
	 * <p>Setter for the field <code>regionExpression</code>.</p>
	 *
	 * @param regionExpression a {@link net.sf.jasperreports.engine.JRExpression} object.
	 */
	public void setRegionExpression(JRExpression regionExpression) {
		Object old = this.regionExpression;
		this.regionExpression = regionExpression;
		getEventSupport().firePropertyChange(PROPERTY_REGION_EXPRESSION, old, this.regionExpression);
	}

	/** {@inheritDoc} */
	@Override
	public JRExpression getValueLabelExpression() {
		return valueLabelExpression;
	}

	/**
	 * <p>Setter for the field <code>valueLabelExpression</code>.</p>
	 *
	 * @param valueLabelExpression a {@link net.sf.jasperreports.engine.JRExpression} object.
	 */
	public void setValueLabelExpression(JRExpression valueLabelExpression) {
		Object old = this.valueLabelExpression;
		this.valueLabelExpression = valueLabelExpression;
		getEventSupport().firePropertyChange(PROPERTY_VALUE_LABEL_EXPRESSION, old, this.valueLabelExpression);
	}

	/** {@inheritDoc} */
	@Override
	public List<Color> getColors() {
		return colors;
	}

	/**
	 * <p>Setter for the field <code>colors</code>.</p>
	 *
	 * @param colors a {@link java.util.List} object.
	 */
	public void setColors(List<Color> colors) {
		Object old = this.colors;
		this.colors = colors;
		getEventSupport().firePropertyChange(PROPERTY_COLORS, old, this.colors);
	}

	/** {@inheritDoc} */
	@Override
	public GeoMapDataset getDataset() {
		return dataset;
	}

	/**
	 * <p>Setter for the field <code>dataset</code>.</p>
	 *
	 * @param dataset a {@link net.sf.dynamicreports.googlecharts.jasper.geomap.GeoMapDataset} object.
	 */
	public void setDataset(GeoMapDataset dataset) {
		Object old = this.dataset;
		this.dataset = dataset;
		getEventSupport().firePropertyChange(PROPERTY_DATASET, old, this.dataset);
	}

	/** {@inheritDoc} */
	@Override
	public JRPropertyChangeSupport getEventSupport() {
		synchronized (this) {
			if (eventSupport == null) {
				eventSupport = new JRPropertyChangeSupport(this);
			}
		}

		return eventSupport;
	}

	/** {@inheritDoc} */
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

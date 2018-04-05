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

import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.base.JRBaseObjectFactory;
import net.sf.jasperreports.engine.design.JRDesignElementDataset;
import net.sf.jasperreports.engine.util.JRCloneUtils;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class StandardGeoMapDataset extends JRDesignElementDataset implements GeoMapDataset {
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	public static final String PROPERTY_LOCATION_EXPRESSION = "locationExpression";
	public static final String PROPERTY_VALUE_EXPRESSION = "valueExpression";
	public static final String PROPERTY_LABEL_EXPRESSION = "labelExpression";

	private JRExpression locationExpression;
	private JRExpression valueExpression;
	private JRExpression labelExpression;

	public StandardGeoMapDataset() {
	}

	public StandardGeoMapDataset(GeoMapDataset dataset, JRBaseObjectFactory factory) {
		super(dataset, factory);
		this.locationExpression = factory.getExpression(dataset.getLocationExpression());
		this.valueExpression = factory.getExpression(dataset.getValueExpression());
		this.labelExpression = factory.getExpression(dataset.getLabelExpression());
	}

	@Override
	public void collectExpressions(JRExpressionCollector collector) {
		GeoMapCompiler.collectExpressions(this, collector);
	}

	@Override
	public JRExpression getLocationExpression() {
		return locationExpression;
	}

	public void setLocationExpression(JRExpression locationExpression) {
		Object old = this.locationExpression;
		this.locationExpression = locationExpression;
		getEventSupport().firePropertyChange(PROPERTY_LOCATION_EXPRESSION, old, this.locationExpression);
	}

	@Override
	public JRExpression getValueExpression() {
		return valueExpression;
	}

	public void setValueExpression(JRExpression valueExpression) {
		Object old = this.valueExpression;
		this.valueExpression = valueExpression;
		getEventSupport().firePropertyChange(PROPERTY_VALUE_EXPRESSION, old, this.valueExpression);
	}

	@Override
	public JRExpression getLabelExpression() {
		return labelExpression;
	}

	public void setLabelExpression(JRExpression labelExpression) {
		this.labelExpression = labelExpression;

		Object old = this.labelExpression;
		this.labelExpression = labelExpression;
		getEventSupport().firePropertyChange(PROPERTY_LABEL_EXPRESSION, old, this.labelExpression);
	}

	@Override
	public Object clone() {
		StandardGeoMapDataset clone = (StandardGeoMapDataset) super.clone();
		clone.locationExpression = JRCloneUtils.nullSafeClone(locationExpression);
		clone.valueExpression = JRCloneUtils.nullSafeClone(valueExpression);
		clone.labelExpression = JRCloneUtils.nullSafeClone(labelExpression);
		return clone;
	}
}

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

import java.util.LinkedHashSet;
import java.util.Set;

import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRElementDataset;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.fill.JRCalculator;
import net.sf.jasperreports.engine.fill.JRExpressionEvalException;
import net.sf.jasperreports.engine.fill.JRFillElementDataset;
import net.sf.jasperreports.engine.fill.JRFillObjectFactory;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GeoMapFillDataset extends JRFillElementDataset implements GeoMapDataset {
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	private Set<GeoMapData> dataset;
	private String location;
	private Number value;
	private String label;

	public GeoMapFillDataset(JRElementDataset dataset, JRFillObjectFactory factory) {
		super(dataset, factory);
	}

	@Override
	public void collectExpressions(JRExpressionCollector collector) {
		GeoMapCompiler.collectExpressions(this, collector);
	}

	@Override
	protected void customInitialize() {
		dataset = new LinkedHashSet<GeoMapData>();
	}

	@Override
	protected void customEvaluate(JRCalculator calculator) throws JRExpressionEvalException {
		location = (String) calculator.evaluate(getLocationExpression());
		value = (Number) calculator.evaluate(getValueExpression());
		label = (String) calculator.evaluate(getLabelExpression());
	}

	@Override
	protected void customIncrement() {
		GeoMapData data = new GeoMapData();
		data.setLocation(location);
		data.setValue(value);
		data.setLabel(label);
		dataset.add(data);
	}

	public Set<GeoMapData> getCustomDataset() {
		return dataset;
	}

	@Override
	public JRExpression getLocationExpression() {
		return ((GeoMapDataset) parent).getLocationExpression();
	}

	@Override
	public JRExpression getValueExpression() {
		return ((GeoMapDataset) parent).getValueExpression();
	}

	@Override
	public JRExpression getLabelExpression() {
		return ((GeoMapDataset) parent).getLabelExpression();
	}

	public void finishDataset() {
		increment();
	}
}

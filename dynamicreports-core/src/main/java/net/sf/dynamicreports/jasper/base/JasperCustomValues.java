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

package net.sf.dynamicreports.jasper.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.sf.dynamicreports.design.definition.expression.DRIDesignComplexExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression;
import net.sf.dynamicreports.jasper.base.tableofcontents.JasperTocHeading;
import net.sf.dynamicreports.jasper.constant.ValueType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRICustomValues;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;

public class JasperCustomValues implements DRICustomValues {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Map<String, ValueType> valueTypes;
	private Map<String, DRIDesignSimpleExpression> simpleExpressions;
	private Map<String, DRIDesignComplexExpression> complexExpressions;
	private Map<String, List<DRIChartCustomizer>> chartCustomizers;
	private Map<String, Object> systemValues;
	private JasperScriptlet jasperScriptlet;
	private Integer startPageNumber;
	private Map<String, JasperTocHeading> tocHeadings;
	private Integer subreportWidth;

	public JasperCustomValues() {
		init();
	}

	private void init() {
		valueTypes = new HashMap<>();
		simpleExpressions = new HashMap<>();
		complexExpressions = new HashMap<>();
		chartCustomizers = new HashMap<>();
		systemValues = new HashMap<>();
	}

	public void addSimpleExpression(DRIDesignSimpleExpression simpleExpression) {
		simpleExpressions.put(simpleExpression.getName(), simpleExpression);
		addValueType(simpleExpression.getName(), ValueType.SIMPLE_EXPRESSION);
	}

	public void addComplexExpression(DRIDesignComplexExpression complexExpression) {
		complexExpressions.put(complexExpression.getName(), complexExpression);
		addValueType(complexExpression.getName(), ValueType.COMPLEX_EXPRESSION);
	}

	public void addChartCustomizers(String name, List<DRIChartCustomizer> chartCustomizers) {
		this.chartCustomizers.put(name, chartCustomizers);
	}

	public void addValueType(String name, ValueType valueType) {
		/*if (valueTypes.containsKey(name)) {
			throw new JasperDesignException("Duplicate value name \"" + name + "\"");
		}*/
		valueTypes.put(name, valueType);
	}

	protected ValueType getValueType(String name) {
		return valueTypes.get(name);
	}

	protected DRIDesignSimpleExpression getSimpleExpression(String name) {
		return simpleExpressions.get(name);
	}

	protected DRIDesignComplexExpression getComplexExpression(String name) {
		return complexExpressions.get(name);
	}

	protected List<DRIChartCustomizer> getChartCustomizers(String name) {
		return chartCustomizers.get(name);
	}

	public boolean isEmpty() {
		if (!simpleExpressions.isEmpty()) {
			return false;
		}
		if (!complexExpressions.isEmpty()) {
			return false;
		}
		if (!chartCustomizers.isEmpty()) {
			return false;
		}
		return true;
	}

	public Object getValue(String valueName) {
		return jasperScriptlet.getValue(valueName);
	}

	public Object getValue(String name, Object[] values) {
		return jasperScriptlet.getValue(name, values);
	}

	@Override
	public void setSystemValue(String name, Object value) {
		systemValues.put(name, value);
	}

	protected Object getSystemValue(String name) {
		return systemValues.get(name);
	}

	protected JasperScriptlet getJasperScriptlet() {
		return jasperScriptlet;
	}

	protected void setJasperScriptlet(JasperScriptlet jasperScriptlet) {
		this.jasperScriptlet = jasperScriptlet;
	}

	public Integer getStartPageNumber() {
		return startPageNumber;
	}

	public void setStartPageNumber(Integer startPageNumber) {
		this.startPageNumber = startPageNumber;
	}

	@Override
	public void addTocHeading(int level, String id, String text, Object customValue) {
		JasperTocHeading heading = new JasperTocHeading();
		heading.setLevel(level);
		heading.setText(text);
		heading.setReference(id);
		heading.setCustomValue(customValue);
		tocHeadings.put(id, heading);
	}

	@Override
	public Map<String, JasperTocHeading> getTocHeadings() {
		return tocHeadings;
	}

	@Override
	public void setTocHeadings(Map<String, JasperTocHeading> tocHeadings) {
		this.tocHeadings = tocHeadings;
	}

	public Integer getSubreportWidth() {
		return subreportWidth;
	}

	@Override
	public void setSubreportWidth(Integer subreportWidth) {
		this.subreportWidth = subreportWidth;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (String name : valueTypes.keySet()) {
			result.append(valueTypes.get(name).name() + ":" + name);
			result.append(", ");
		}
		return "{" + StringUtils.removeEnd(result.toString(), ", ") + "}";
	}
}

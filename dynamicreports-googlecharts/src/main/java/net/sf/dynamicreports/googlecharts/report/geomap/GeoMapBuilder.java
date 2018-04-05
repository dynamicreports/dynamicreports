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
import java.sql.Connection;

import net.sf.dynamicreports.report.builder.DatasetBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.builder.component.DimensionComponentBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JRDataSource;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GeoMapBuilder extends DimensionComponentBuilder<GeoMapBuilder, DRGeoMap> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	public GeoMapBuilder() {
		super(new DRGeoMap());
	}

	public GeoMapBuilder setShowLegend(Boolean showLegend) {
		getObject().setShowLegend(showLegend);
		return this;
	}

	public GeoMapBuilder setDataMode(GeoMapDataMode dataMode) {
		getObject().setDataMode(dataMode);
		return this;
	}

	public GeoMapBuilder colors(Color... colors) {
		return addColor(colors);
	}

	public GeoMapBuilder addColor(Color... colors) {
		Validate.notNull(colors, "colors must not be null");
		Validate.noNullElements(colors, "colors must not contains null color");
		for (Color color : colors) {
			getObject().addColor(color);
		}
		return this;
	}

	// region
	public GeoMapBuilder setRegion(String region) {
		getObject().setRegionExpression(Expressions.text(region));
		return this;
	}

	public GeoMapBuilder setRegion(DRIExpression<String> regionExpression) {
		getObject().setRegionExpression(regionExpression);
		return this;
	}

	// value label
	public GeoMapBuilder setValueLabel(String valueLabel) {
		getObject().setValueLabelExpression(Expressions.text(valueLabel));
		return this;
	}

	public GeoMapBuilder setValueLabel(DRIExpression<String> valueLabelExpression) {
		getObject().setValueLabelExpression(valueLabelExpression);
		return this;
	}

	// location
	public GeoMapBuilder setLocation(ValueColumnBuilder<?, String> column) {
		Validate.notNull(column, "column must not be null");
		getDataset().setLocationExpression(column.getColumn());
		return this;
	}

	public GeoMapBuilder setLocation(String fieldName, Class<String> valueClass) {
		return setLocation(DynamicReports.field(fieldName, valueClass));
	}

	public GeoMapBuilder setLocation(FieldBuilder<String> field) {
		Validate.notNull(field, "field must not be null");
		getDataset().setLocationExpression(field.build());
		return this;
	}

	public GeoMapBuilder setLocation(DRIExpression<String> expression) {
		getDataset().setLocationExpression(expression);
		return this;
	}

	// value
	public GeoMapBuilder setValue(ValueColumnBuilder<?, ? extends Number> column) {
		Validate.notNull(column, "column must not be null");
		getDataset().setValueExpression(column.getColumn());
		return this;
	}

	public GeoMapBuilder setValue(String fieldName, Class<? extends Number> valueClass) {
		return setValue(DynamicReports.field(fieldName, valueClass));
	}

	public GeoMapBuilder setValue(FieldBuilder<? extends Number> field) {
		Validate.notNull(field, "field must not be null");
		getDataset().setValueExpression(field.build());
		return this;
	}

	public GeoMapBuilder setValue(DRIExpression<? extends Number> valueExpression) {
		getDataset().setValueExpression(valueExpression);
		return this;
	}

	public GeoMapBuilder setValue(VariableBuilder<? extends Number> variable) {
		Validate.notNull(variable, "variable must not be null");
		getDataset().setValueExpression(variable.build());
		return this;
	}

	// label
	public GeoMapBuilder setLabel(ValueColumnBuilder<?, String> column) {
		Validate.notNull(column, "column must not be null");
		getDataset().setLabelExpression(column.getColumn());
		return this;
	}

	public GeoMapBuilder setLabel(String fieldName, Class<String> valueClass) {
		return setLabel(DynamicReports.field(fieldName, valueClass));
	}

	public GeoMapBuilder setLabel(FieldBuilder<String> field) {
		Validate.notNull(field, "field must not be null");
		getDataset().setLabelExpression(field.build());
		return this;
	}

	public GeoMapBuilder setLabel(DRIExpression<String> expression) {
		getDataset().setLabelExpression(expression);
		return this;
	}

	// subdataset
	public GeoMapBuilder setSubDataset(DatasetBuilder subDataset) {
		Validate.notNull(subDataset, "subDataset must not be null");
		getObject().getDataset().setSubDataset(subDataset.build());
		return this;
	}

	public GeoMapBuilder setDataSource(JRDataSource dataSource) {
		DatasetBuilder dataset = DynamicReports.dataset();
		dataset.setDataSource(dataSource);
		return setSubDataset(dataset);
	}

	public GeoMapBuilder setDataSource(String sql, Connection connection) {
		DatasetBuilder dataset = DynamicReports.dataset();
		dataset.setDataSource(sql, connection);
		return setSubDataset(dataset);
	}

	private DRGeoMapDataset getDataset() {
		return getObject().getDataset();
	}
}

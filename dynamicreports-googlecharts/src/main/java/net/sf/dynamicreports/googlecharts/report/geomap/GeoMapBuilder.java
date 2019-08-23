/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import java.awt.Color;
import java.sql.Connection;
import java.util.Arrays;

/**
 * <p>GeoMapBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GeoMapBuilder extends DimensionComponentBuilder<GeoMapBuilder, DRGeoMap> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for GeoMapBuilder.</p>
     */
    public GeoMapBuilder() {
        super(new DRGeoMap());
    }

    /**
     * <p>setShowLegend.</p>
     *
     * @param showLegend a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setShowLegend(Boolean showLegend) {
        getObject().setShowLegend(showLegend);
        return this;
    }

    /**
     * <p>setDataMode.</p>
     *
     * @param dataMode a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapDataMode} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setDataMode(GeoMapDataMode dataMode) {
        getObject().setDataMode(dataMode);
        return this;
    }

    /**
     * <p>colors.</p>
     *
     * @param colors a {@link java.awt.Color} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder colors(Color... colors) {
        return addColor(colors);
    }

    /**
     * <p>addColor.</p>
     *
     * @param colors a {@link java.awt.Color} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder addColor(Color... colors) {
        Validate.notNull(colors, "colors must not be null");
        Validate.noNullElements(colors, "colors must not contains null color");
        Arrays.stream(colors).forEach(color -> getObject().addColor(color));
        return this;
    }

    // region

    /**
     * <p>setRegion.</p>
     *
     * @param region a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setRegion(String region) {
        getObject().setRegionExpression(Expressions.text(region));
        return this;
    }

    /**
     * <p>setRegion.</p>
     *
     * @param regionExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setRegion(DRIExpression<String> regionExpression) {
        getObject().setRegionExpression(regionExpression);
        return this;
    }

    // value label

    /**
     * <p>setValueLabel.</p>
     *
     * @param valueLabel a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setValueLabel(String valueLabel) {
        getObject().setValueLabelExpression(Expressions.text(valueLabel));
        return this;
    }

    /**
     * <p>setValueLabel.</p>
     *
     * @param valueLabelExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setValueLabel(DRIExpression<String> valueLabelExpression) {
        getObject().setValueLabelExpression(valueLabelExpression);
        return this;
    }

    // location

    /**
     * <p>setLocation.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setLocation(ValueColumnBuilder<?, String> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setLocationExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setLocation.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setLocation(String fieldName, Class<String> valueClass) {
        return setLocation(DynamicReports.<String>field(fieldName, valueClass));
    }

    /**
     * <p>setLocation.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setLocation(FieldBuilder<String> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setLocationExpression(field.build());
        return this;
    }

    /**
     * <p>setLocation.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setLocation(DRIExpression<String> expression) {
        getDataset().setLocationExpression(expression);
        return this;
    }

    // value

    /**
     * <p>setValue.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setValue(ValueColumnBuilder<?, ? extends Number> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setValueExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setValue.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setValue(String fieldName, Class<? extends Number> valueClass) {
        return setValue(DynamicReports.<Number>field(fieldName, valueClass));
    }

    /**
     * <p>setValue.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setValue(FieldBuilder<? extends Number> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setValueExpression(field.build());
        return this;
    }

    /**
     * <p>setValue.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setValue(DRIExpression<? extends Number> valueExpression) {
        getDataset().setValueExpression(valueExpression);
        return this;
    }

    /**
     * <p>setValue.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setValue(VariableBuilder<? extends Number> variable) {
        Validate.notNull(variable, "variable must not be null");
        getDataset().setValueExpression(variable.build());
        return this;
    }

    // label

    /**
     * <p>setLabel.</p>
     *
     * @param column a {@link net.sf.dynamicreports.report.builder.column.ValueColumnBuilder} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setLabel(ValueColumnBuilder<?, String> column) {
        Validate.notNull(column, "column must not be null");
        getDataset().setLabelExpression(column.getColumn());
        return this;
    }

    /**
     * <p>setLabel.</p>
     *
     * @param fieldName  a {@link java.lang.String} object.
     * @param valueClass a {@link java.lang.Class} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setLabel(String fieldName, Class<String> valueClass) {
        return setLabel(DynamicReports.<String>field(fieldName, valueClass));
    }

    /**
     * <p>setLabel.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setLabel(FieldBuilder<String> field) {
        Validate.notNull(field, "field must not be null");
        getDataset().setLabelExpression(field.build());
        return this;
    }

    /**
     * <p>setLabel.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setLabel(DRIExpression<String> expression) {
        getDataset().setLabelExpression(expression);
        return this;
    }

    // subdataset

    /**
     * <p>setSubDataset.</p>
     *
     * @param subDataset a {@link net.sf.dynamicreports.report.builder.DatasetBuilder} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setSubDataset(DatasetBuilder subDataset) {
        Validate.notNull(subDataset, "subDataset must not be null");
        getObject().getDataset().setSubDataset(subDataset.build());
        return this;
    }

    /**
     * <p>setDataSource.</p>
     *
     * @param dataSource a {@link net.sf.jasperreports.engine.JRDataSource} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setDataSource(JRDataSource dataSource) {
        DatasetBuilder dataset = DynamicReports.dataset();
        dataset.setDataSource(dataSource);
        return setSubDataset(dataset);
    }

    /**
     * <p>setDataSource.</p>
     *
     * @param sql        a {@link java.lang.String} object.
     * @param connection a {@link java.sql.Connection} object.
     * @return a {@link net.sf.dynamicreports.googlecharts.report.geomap.GeoMapBuilder} object.
     */
    public GeoMapBuilder setDataSource(String sql, Connection connection) {
        DatasetBuilder dataset = DynamicReports.dataset();
        dataset.setDataSource(sql, connection);
        return setSubDataset(dataset);
    }

    private DRGeoMapDataset getDataset() {
        return getObject().getDataset();
    }
}

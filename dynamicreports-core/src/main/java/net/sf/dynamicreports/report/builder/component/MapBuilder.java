/*
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
package net.sf.dynamicreports.report.builder.component;

import net.sf.dynamicreports.report.base.component.DRMap;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>MapBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class MapBuilder extends DimensionComponentBuilder<MapBuilder, DRMap> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for MapBuilder.</p>
     */
    protected MapBuilder() {
        super(new DRMap());
    }

    /**
     * <p>setLatitude.</p>
     *
     * @param latitude a {@link java.lang.Float} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.MapBuilder} object.
     */
    public MapBuilder setLatitude(Float latitude) {
        getObject().setLatitudeExpression(Expressions.value(latitude));
        return this;
    }

    /**
     * <p>setLatitude.</p>
     *
     * @param latitudeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.MapBuilder} object.
     */
    public MapBuilder setLatitude(DRIExpression<Float> latitudeExpression) {
        getObject().setLatitudeExpression(latitudeExpression);
        return this;
    }

    /**
     * <p>setLongitude.</p>
     *
     * @param longitude a {@link java.lang.Float} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.MapBuilder} object.
     */
    public MapBuilder setLongitude(Float longitude) {
        getObject().setLongitudeExpression(Expressions.value(longitude));
        return this;
    }

    /**
     * <p>setLongitude.</p>
     *
     * @param longitudeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.MapBuilder} object.
     */
    public MapBuilder setLongitude(DRIExpression<Float> longitudeExpression) {
        getObject().setLongitudeExpression(longitudeExpression);
        return this;
    }

    /**
     * <p>setZoom.</p>
     *
     * @param zoom a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.MapBuilder} object.
     */
    public MapBuilder setZoom(Integer zoom) {
        getObject().setZoomExpression(Expressions.value(zoom));
        return this;
    }

    /**
     * <p>setZoom.</p>
     *
     * @param zoomExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.MapBuilder} object.
     */
    public MapBuilder setZoom(DRIExpression<Integer> zoomExpression) {
        getObject().setZoomExpression(zoomExpression);
        return this;
    }
}

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
package net.sf.dynamicreports.report.builder.expression;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;

/**
 * <p>MapArraySubDatasourceExpression class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class MapArraySubDatasourceExpression extends AbstractSubDatasourceExpression<Object[]> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for MapArraySubDatasourceExpression.</p>
     *
     * @param fieldName a {@link java.lang.String} object.
     */
    public MapArraySubDatasourceExpression(String fieldName) {
        super(fieldName);
    }

    /**
     * <p>Constructor for MapArraySubDatasourceExpression.</p>
     *
     * @param expression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public MapArraySubDatasourceExpression(DRIExpression<? extends Object[]> expression) {
        super(expression);
    }

    /** {@inheritDoc} */
    @Override
    protected JRDataSource createSubDatasource(Object[] data) {
        return new JRMapArrayDataSource(data);
    }
}

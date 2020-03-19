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

import net.sf.dynamicreports.report.base.expression.AbstractSimpleExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRewindableDataSource;

/**
 * <p>DataSourceExpression class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DataSourceExpression extends AbstractSimpleExpression<JRDataSource> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private JRDataSource dataSource;
    private boolean moveFirst = false;

    /**
     * <p>Constructor for DataSourceExpression.</p>
     *
     * @param dataSource a {@link net.sf.jasperreports.engine.JRDataSource} object.
     */
    public DataSourceExpression(JRDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /** {@inheritDoc} */
    @Override
    public JRDataSource evaluate(ReportParameters reportParameters) {
        if (moveFirst && dataSource != null && dataSource instanceof JRRewindableDataSource) {
            try {
                ((JRRewindableDataSource) dataSource).moveFirst();
            } catch (JRException e) {
            }
        }
        moveFirst = true;
        return dataSource;
    }

    /** {@inheritDoc} */
    @Override
    public Class<JRDataSource> getValueClass() {
        return JRDataSource.class;
    }
}

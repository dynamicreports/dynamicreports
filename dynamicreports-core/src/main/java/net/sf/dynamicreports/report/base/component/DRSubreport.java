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
package net.sf.dynamicreports.report.base.component;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.component.DRISubreport;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

import java.sql.Connection;
import java.util.Map;

/**
 * <p>DRSubreport class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRSubreport extends DRDimensionComponent implements DRISubreport {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<?> reportExpression;
    private DRIExpression<Map<String, Object>> parametersExpression;
    private DRIExpression<Connection> connectionExpression;
    private DRIExpression<?> dataSourceExpression;
    private Boolean runToBottom;

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getReportExpression() {
        return reportExpression;
    }

    /**
     * <p>Setter for the field <code>reportExpression</code>.</p>
     *
     * @param reportExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setReportExpression(DRIExpression<?> reportExpression) {
        Validate.notNull(reportExpression, "reportExpression must not be null");
        this.reportExpression = reportExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<Map<String, Object>> getParametersExpression() {
        return parametersExpression;
    }

    /**
     * <p>Setter for the field <code>parametersExpression</code>.</p>
     *
     * @param parametersExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setParametersExpression(DRIExpression<Map<String, Object>> parametersExpression) {
        this.parametersExpression = parametersExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<Connection> getConnectionExpression() {
        return connectionExpression;
    }

    /**
     * <p>Setter for the field <code>connectionExpression</code>.</p>
     *
     * @param connectionExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setConnectionExpression(DRIExpression<Connection> connectionExpression) {
        this.connectionExpression = connectionExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<?> getDataSourceExpression() {
        return dataSourceExpression;
    }

    /**
     * <p>Setter for the field <code>dataSourceExpression</code>.</p>
     *
     * @param dataSourceExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setDataSourceExpression(DRIExpression<?> dataSourceExpression) {
        this.dataSourceExpression = dataSourceExpression;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getRunToBottom() {
        return runToBottom;
    }

    /**
     * <p>Setter for the field <code>runToBottom</code>.</p>
     *
     * @param runToBottom a {@link java.lang.Boolean} object.
     */
    public void setRunToBottom(Boolean runToBottom) {
        this.runToBottom = runToBottom;
    }
}

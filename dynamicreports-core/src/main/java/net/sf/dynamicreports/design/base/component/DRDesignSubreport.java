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
package net.sf.dynamicreports.design.base.component;

import net.sf.dynamicreports.design.definition.component.DRIDesignSubreport;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignSubreport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignSubreport extends DRDesignComponent implements DRIDesignSubreport {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIDesignExpression reportExpression;
    private DRIDesignExpression parametersExpression;
    private DRIDesignExpression connectionExpression;
    private DRIDesignExpression dataSourceExpression;
    private Boolean runToBottom;

    /**
     * <p>Constructor for DRDesignSubreport.</p>
     */
    public DRDesignSubreport() {
        super("subreport");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getReportExpression() {
        return reportExpression;
    }

    /**
     * <p>Setter for the field <code>reportExpression</code>.</p>
     *
     * @param reportExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setReportExpression(DRIDesignExpression reportExpression) {
        this.reportExpression = reportExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getParametersExpression() {
        return parametersExpression;
    }

    /**
     * <p>Setter for the field <code>parametersExpression</code>.</p>
     *
     * @param parametersExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setParametersExpression(DRIDesignExpression parametersExpression) {
        this.parametersExpression = parametersExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getConnectionExpression() {
        return connectionExpression;
    }

    /**
     * <p>Setter for the field <code>connectionExpression</code>.</p>
     *
     * @param connectionExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setConnectionExpression(DRIDesignExpression connectionExpression) {
        this.connectionExpression = connectionExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIDesignExpression getDataSourceExpression() {
        return dataSourceExpression;
    }

    /**
     * <p>Setter for the field <code>dataSourceExpression</code>.</p>
     *
     * @param dataSourceExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setDataSourceExpression(DRIDesignExpression dataSourceExpression) {
        this.dataSourceExpression = dataSourceExpression;
    }

    /**
     * {@inheritDoc}
     */
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

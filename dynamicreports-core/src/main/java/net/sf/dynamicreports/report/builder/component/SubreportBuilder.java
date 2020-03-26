/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import net.sf.dynamicreports.report.base.component.DRSubreport;
import net.sf.dynamicreports.report.builder.ReportBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperReport;

import java.sql.Connection;
import java.util.Map;

/**
 * <p>SubreportBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class SubreportBuilder extends DimensionComponentBuilder<SubreportBuilder, DRSubreport> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for SubreportBuilder.</p>
     */
    protected SubreportBuilder() {
        super(new DRSubreport());
    }

    // report

    /**
     * <p>setReport.</p>
     *
     * @param reportBuilder a {@link net.sf.dynamicreports.report.builder.ReportBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder setReport(ReportBuilder<?> reportBuilder) {
        getObject().setReportExpression(Expressions.value(reportBuilder));
        return this;
    }

    /**
     * <p>setReport.</p>
     *
     * @param jasperReport a {@link net.sf.jasperreports.engine.JasperReport} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder setReport(JasperReport jasperReport) {
        getObject().setReportExpression(Expressions.value(jasperReport));
        return this;
    }

    /**
     * <p>setReport.</p>
     *
     * @param reportExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder setReport(DRIExpression<?> reportExpression) {
        getObject().setReportExpression(reportExpression);
        return this;
    }

    // parameters

    /**
     * <p>setParameters.</p>
     *
     * @param parameters a {@link java.util.Map} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder setParameters(Map<String, Object> parameters) {
        getObject().setParametersExpression(Expressions.value(parameters));
        return this;
    }

    /**
     * <p>setParameters.</p>
     *
     * @param parametersExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder setParameters(DRIExpression<Map<String, Object>> parametersExpression) {
        getObject().setParametersExpression(parametersExpression);
        return this;
    }

    // connection

    /**
     * <p>setConnection.</p>
     *
     * @param connection a {@link java.sql.Connection} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder setConnection(Connection connection) {
        getObject().setConnectionExpression(Expressions.value(connection));
        return this;
    }

    /**
     * <p>setConnection.</p>
     *
     * @param connectionExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder setConnection(DRIExpression<Connection> connectionExpression) {
        getObject().setConnectionExpression(connectionExpression);
        return this;
    }

    // datasource

    /**
     * <p>setDataSource.</p>
     *
     * @param dataSource a {@link net.sf.jasperreports.engine.JRDataSource} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder setDataSource(JRDataSource dataSource) {
        getObject().setDataSourceExpression(Expressions.dataSource(dataSource));
        return this;
    }

    /**
     * <p>setDataSource.</p>
     *
     * @param dataSourceExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder setDataSource(DRIExpression<JRDataSource> dataSourceExpression) {
        getObject().setDataSourceExpression(dataSourceExpression);
        return this;
    }

    /**
     * <p>setRunToBottom.</p>
     *
     * @param runToBottom a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.SubreportBuilder} object.
     */
    public SubreportBuilder setRunToBottom(Boolean runToBottom) {
        getObject().setRunToBottom(runToBottom);
        return this;
    }
}

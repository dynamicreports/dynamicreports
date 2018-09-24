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
package net.sf.dynamicreports.report.definition;

import java.sql.Connection;
import java.util.Locale;

/**
 * <p>ReportParameters interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface ReportParameters {
    /**
     * Constant <code>CROSSTAB_ROW_COUNTER="CROSSTAB_ROW_NUMBER"</code>
     */
    public static final String CROSSTAB_ROW_COUNTER = "CROSSTAB_ROW_NUMBER";

    /**
     * <p>getValue.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param <T>  a T object.
     * @return a T object.
     */
    public <T> T getValue(String name);

    /**
     * <p>getValue.</p>
     *
     * @param value a {@link net.sf.dynamicreports.report.definition.DRIValue} object.
     * @param <T>   a T object.
     * @return a T object.
     */
    public <T> T getValue(DRIValue<T> value);

    /**
     * <p>getFieldValue.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param <T>  a T object.
     * @return a T object.
     */
    public <T> T getFieldValue(String name);

    /**
     * <p>getVariableValue.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param <T>  a T object.
     * @return a T object.
     */
    public <T> T getVariableValue(String name);

    /**
     * <p>getParameterValue.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param <T>  a T object.
     * @return a T object.
     */
    public <T> T getParameterValue(String name);

    /**
     * <p>getPageNumber.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageNumber();

    /**
     * <p>getColumnNumber.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getColumnNumber();

    /**
     * <p>getReportRowNumber.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getReportRowNumber();

    /**
     * <p>getPageRowNumber.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageRowNumber();

    /**
     * <p>getColumnRowNumber.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getColumnRowNumber();

    /**
     * <p>getCrosstabRowNumber.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getCrosstabRowNumber();

    /**
     * <p>getGroupCount.</p>
     *
     * @param groupName a {@link java.lang.String} object.
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getGroupCount(String groupName);

    /**
     * <p>getConnection.</p>
     *
     * @return a {@link java.sql.Connection} object.
     */
    public Connection getConnection();

    /**
     * <p>getLocale.</p>
     *
     * @return a {@link java.util.Locale} object.
     */
    public Locale getLocale();

    /**
     * <p>getScriptlet.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.definition.DRIScriptlet} object.
     */
    public DRIScriptlet getScriptlet(String name);

    /**
     * <p>getMessage.</p>
     *
     * @param key a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public String getMessage(String key);

    /**
     * <p>getMessage.</p>
     *
     * @param key       a {@link java.lang.String} object.
     * @param arguments an array of {@link java.lang.Object} objects.
     * @return a {@link java.lang.String} object.
     */
    public String getMessage(String key, Object[] arguments);

    /**
     * <p>getMasterParameters.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.ReportParameters} object.
     */
    public ReportParameters getMasterParameters();

    /**
     * <p>getSubreportWidth.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getSubreportWidth();
}

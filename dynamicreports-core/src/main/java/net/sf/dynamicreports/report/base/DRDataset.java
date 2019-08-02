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
package net.sf.dynamicreports.report.base;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.DRIDataset;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import org.apache.commons.lang3.Validate;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>DRDataset class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDataset implements DRIDataset {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private List<DRField<?>> fields;
    private List<DRVariable<?>> variables;
    private List<DRSort> sorts;
    private DRQuery query;
    private DRIExpression<Connection> connectionExpression;
    private DRIExpression<?> dataSourceExpression;
    private DRIExpression<Boolean> filterExpression;

    /**
     * <p>Constructor for DRDataset.</p>
     */
    public DRDataset() {
        init();
    }

    private void init() {
        this.fields = new ArrayList<DRField<?>>();
        this.variables = new ArrayList<DRVariable<?>>();
        this.sorts = new ArrayList<DRSort>();
    }

    /** {@inheritDoc} */
    @Override
    public List<DRField<?>> getFields() {
        return fields;
    }

    /**
     * <p>Setter for the field <code>fields</code>.</p>
     *
     * @param fields a {@link java.util.List} object.
     */
    public void setFields(List<DRField<?>> fields) {
        Validate.notNull(fields, "fields must not be null");
        Validate.noNullElements(fields, "fields must not contains null field");
        this.fields = fields;
    }

    /**
     * <p>addField.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.base.DRField} object.
     */
    public void addField(DRField<?> field) {
        Validate.notNull(field, "field must not be null");
        this.fields.add(field);
    }

    /** {@inheritDoc} */
    @Override
    public List<DRVariable<?>> getVariables() {
        return variables;
    }

    /**
     * <p>Setter for the field <code>variables</code>.</p>
     *
     * @param variables a {@link java.util.List} object.
     */
    public void setVariables(List<DRVariable<?>> variables) {
        Validate.notNull(variables, "variables must not be null");
        Validate.noNullElements(variables, "variables must not contains null variable");
        this.variables = variables;
    }

    /**
     * <p>addVariable.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.base.DRVariable} object.
     */
    public void addVariable(DRVariable<?> variable) {
        Validate.notNull(variable, "variable must not be null");
        this.variables.add(variable);
    }

    /** {@inheritDoc} */
    @Override
    public List<DRSort> getSorts() {
        return sorts;
    }

    /**
     * <p>Setter for the field <code>sorts</code>.</p>
     *
     * @param sorts a {@link java.util.List} object.
     */
    public void setSorts(List<DRSort> sorts) {
        Validate.notNull(sorts, "sorts must not be null");
        Validate.noNullElements(sorts, "sorts must not contains null sort");
        this.sorts = sorts;
    }

    /**
     * <p>addSort.</p>
     *
     * @param sort a {@link net.sf.dynamicreports.report.base.DRSort} object.
     */
    public void addSort(DRSort sort) {
        Validate.notNull(sort, "sort must not be null");
        this.sorts.add(sort);
    }

    /** {@inheritDoc} */
    @Override
    public DRQuery getQuery() {
        return query;
    }

    /**
     * <p>Setter for the field <code>query</code>.</p>
     *
     * @param query a {@link net.sf.dynamicreports.report.base.DRQuery} object.
     */
    public void setQuery(DRQuery query) {
        this.query = query;
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
    public DRIExpression<Boolean> getFilterExpression() {
        return filterExpression;
    }

    /**
     * <p>Setter for the field <code>filterExpression</code>.</p>
     *
     * @param filterExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setFilterExpression(DRIExpression<Boolean> filterExpression) {
        this.filterExpression = filterExpression;
    }
}

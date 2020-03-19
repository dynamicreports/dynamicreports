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
package net.sf.dynamicreports.jasper.transformation;

import net.sf.dynamicreports.design.definition.DRIDesignDataset;
import net.sf.dynamicreports.jasper.base.JasperCustomValues;
import net.sf.dynamicreports.jasper.base.JasperScriptlet;
import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.dynamicreports.jasper.transformation.expression.DatasetParametersExpression;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignDataset;
import net.sf.jasperreports.engine.design.JRDesignDatasetRun;
import net.sf.jasperreports.engine.design.JRDesignParameter;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>DatasetTransform class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DatasetTransform {
    private JasperTransformAccessor accessor;
    private Map<DRIDesignDataset, Map<String, Object>> datasetParameters;
    private Map<DRIDesignDataset, DatasetExpressionTransform> datasetExpressions;

    /**
     * <p>Constructor for DatasetTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.jasper.transformation.JasperTransformAccessor} object.
     */
    public DatasetTransform(JasperTransformAccessor accessor) {
        this.accessor = accessor;
        datasetParameters = new HashMap<DRIDesignDataset, Map<String, Object>>();
        datasetExpressions = new HashMap<DRIDesignDataset, DatasetExpressionTransform>();
    }

    /**
     * <p>transform.</p>
     */
    public void transform() {
        for (DRIDesignDataset dataset : accessor.getReport().getDatasets()) {
            addDataset(dataset);
        }
    }

    private void addDataset(DRIDesignDataset dataset) {
        try {
            accessor.getDesign().addDataset(dataset(dataset));
        } catch (JRException e) {
            throw new JasperDesignException("Registration failed for dataset \"" + dataset.getName() + "\"", e);
        }
    }

    // dataset
    private JRDesignDataset dataset(DRIDesignDataset dataset) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        datasetParameters.put(dataset, parameters);
        JRDesignDataset jrDataset = new JRDesignDataset(false);
        jrDataset.setName(dataset.getName());
        if (dataset.getQuery() != null) {
            jrDataset.setQuery(accessor.getReportTransform().query(dataset.getQuery()));
        }
        JasperCustomValues customValues = new JasperCustomValues(accessor.getReport().getProperties());
        DatasetExpressionTransform datasetExpressionTransform = new DatasetExpressionTransform(dataset, jrDataset, customValues);
        datasetExpressionTransform.transform();
        datasetExpressions.put(dataset, datasetExpressionTransform);
        if (!customValues.isEmpty()) {
            addParameter(jrDataset, parameters, JasperCustomValues.NAME, JasperCustomValues.class, customValues);
            addScriptlet(jrDataset, parameters, JasperScriptlet.NAME);
        }
        jrDataset.setFilterExpression(datasetExpressionTransform.getExpression(dataset.getFilterExpression()));
        return jrDataset;
    }

    private <T> void addParameter(JRDesignDataset jrDataset, Map<String, Object> parameters, String name, Class<T> parameterClass, T value) {
        JRDesignParameter jrParameter = new JRDesignParameter();
        jrParameter.setName(name);
        jrParameter.setValueClass(parameterClass);
        try {
            jrDataset.addParameter(jrParameter);
        } catch (JRException e) {
            throw new JasperDesignException("Registration failed for parameter \"" + name + "\"", e);
        }
        parameters.put(jrParameter.getName(), value);
    }

    private void addScriptlet(JRDesignDataset jrDataset, Map<String, Object> parameters, String name) {
        try {
            jrDataset.addScriptlet(accessor.getReportTransform().scriptlet(name, JasperScriptlet.class));
        } catch (JRException e) {
            throw new JasperDesignException("Registration failed for scriptlet \"" + name + "\"", e);
        }
    }

    /**
     * <p>datasetRun.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.design.definition.DRIDesignDataset} object.
     * @return a {@link net.sf.jasperreports.engine.design.JRDesignDatasetRun} object.
     */
    public JRDesignDatasetRun datasetRun(DRIDesignDataset dataset) {
        if (dataset == null) {
            return null;
        }

        JRDesignDatasetRun jrDatasetRun = new JRDesignDatasetRun();
        jrDatasetRun.setDatasetName(dataset.getName());
        jrDatasetRun.setConnectionExpression(accessor.getExpressionTransform().getExpression(dataset.getConnectionExpression()));
        jrDatasetRun.setDataSourceExpression(accessor.getExpressionTransform().getExpression(dataset.getDataSourceExpression()));
        DatasetParametersExpression parametersExpression = new DatasetParametersExpression(datasetParameters.get(dataset));
        accessor.getExpressionTransform().addSimpleExpression(parametersExpression);
        jrDatasetRun.setParametersMapExpression(accessor.getExpressionTransform().getExpression(parametersExpression));
        return jrDatasetRun;
    }

    /**
     * <p>Getter for the field <code>datasetParameters</code>.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.design.definition.DRIDesignDataset} object.
     * @return a {@link java.util.Map} object.
     */
    protected Map<String, Object> getDatasetParameters(DRIDesignDataset dataset) {
        return datasetParameters.get(dataset);
    }

    /**
     * <p>getDatasetExpressionTransform.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.design.definition.DRIDesignDataset} object.
     * @return a {@link net.sf.dynamicreports.jasper.transformation.DatasetExpressionTransform} object.
     */
    public DatasetExpressionTransform getDatasetExpressionTransform(DRIDesignDataset dataset) {
        return datasetExpressions.get(dataset);
    }

}

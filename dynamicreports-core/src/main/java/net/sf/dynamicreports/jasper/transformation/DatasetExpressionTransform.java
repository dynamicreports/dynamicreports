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
package net.sf.dynamicreports.jasper.transformation;

import net.sf.dynamicreports.design.definition.DRIDesignDataset;
import net.sf.dynamicreports.design.definition.DRIDesignField;
import net.sf.dynamicreports.design.definition.DRIDesignSort;
import net.sf.dynamicreports.design.definition.DRIDesignVariable;
import net.sf.dynamicreports.design.definition.expression.DRIDesignComplexExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignJasperExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSystemExpression;
import net.sf.dynamicreports.jasper.base.JasperCustomValues;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignDataset;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignSortField;
import net.sf.jasperreports.engine.design.JRDesignVariable;

import java.util.Collection;

/**
 * <p>DatasetExpressionTransform class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class DatasetExpressionTransform extends AbstractExpressionTransform {
    private DRIDesignDataset dataset;
    private JRDesignDataset jrDataset;
    private JasperCustomValues customValues;

    /**
     * <p>Constructor for DatasetExpressionTransform.</p>
     *
     * @param dataset      a {@link net.sf.dynamicreports.design.definition.DRIDesignDataset} object.
     * @param jrDataset    a {@link net.sf.jasperreports.engine.design.JRDesignDataset} object.
     * @param customValues a {@link net.sf.dynamicreports.jasper.base.JasperCustomValues} object.
     */
    public DatasetExpressionTransform(DRIDesignDataset dataset, JRDesignDataset jrDataset, JasperCustomValues customValues) {
        this.dataset = dataset;
        this.jrDataset = jrDataset;
        this.customValues = customValues;
    }

    /** {@inheritDoc} */
    @Override
    protected JasperCustomValues getCustomValues() {
        return customValues;
    }

    /** {@inheritDoc} */
    @Override
    protected Collection<DRIDesignField> getFields() {
        return dataset.getFields();
    }

    /** {@inheritDoc} */
    @Override
    protected Collection<DRIDesignVariable> getVariables() {
        return dataset.getVariables();
    }

    /** {@inheritDoc} */
    @Override
    protected Collection<DRIDesignSystemExpression> getSystemExpressions() {
        return dataset.getSystemExpressions();
    }

    /** {@inheritDoc} */
    @Override
    protected Collection<DRIDesignJasperExpression> getJasperExpressions() {
        return dataset.getJasperExpressions();
    }

    /** {@inheritDoc} */
    @Override
    protected Collection<DRIDesignSimpleExpression> getSimpleExpressions() {
        return dataset.getSimpleExpressions();
    }

    /** {@inheritDoc} */
    @Override
    protected Collection<DRIDesignComplexExpression> getComplexExpressions() {
        return dataset.getComplexExpressions();
    }

    /** {@inheritDoc} */
    @Override
    protected Collection<DRIDesignSort> getSorts() {
        return dataset.getSorts();
    }

    /** {@inheritDoc} */
    @Override
    protected void addField(JRDesignField field) throws JRException {
        jrDataset.addField(field);
    }

    /** {@inheritDoc} */
    @Override
    protected void addVariable(JRDesignVariable variable) throws JRException {
        jrDataset.addVariable(variable);
    }

    /** {@inheritDoc} */
    @Override
    protected void addSort(JRDesignSortField sort) throws JRException {
        jrDataset.addSortField(sort);
    }
}

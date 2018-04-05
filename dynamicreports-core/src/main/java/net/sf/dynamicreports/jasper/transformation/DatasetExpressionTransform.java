/**
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

package net.sf.dynamicreports.jasper.transformation;

import java.util.Collection;

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

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DatasetExpressionTransform extends AbstractExpressionTransform {
	private DRIDesignDataset dataset;
	private JRDesignDataset jrDataset;
	private JasperCustomValues customValues;

	public DatasetExpressionTransform(DRIDesignDataset dataset, JRDesignDataset jrDataset, JasperCustomValues customValues) {
		this.dataset = dataset;
		this.jrDataset = jrDataset;
		this.customValues = customValues;
	}

	@Override
	protected JasperCustomValues getCustomValues() {
		return customValues;
	}

	@Override
	protected Collection<DRIDesignField> getFields() {
		return dataset.getFields();
	}

	@Override
	protected Collection<DRIDesignVariable> getVariables() {
		return dataset.getVariables();
	}

	@Override
	protected Collection<DRIDesignSystemExpression> getSystemExpressions() {
		return dataset.getSystemExpressions();
	}

	@Override
	protected Collection<DRIDesignJasperExpression> getJasperExpressions() {
		return dataset.getJasperExpressions();
	}

	@Override
	protected Collection<DRIDesignSimpleExpression> getSimpleExpressions() {
		return dataset.getSimpleExpressions();
	}

	@Override
	protected Collection<DRIDesignComplexExpression> getComplexExpressions() {
		return dataset.getComplexExpressions();
	}

	@Override
	protected Collection<DRIDesignSort> getSorts() {
		return dataset.getSorts();
	}

	@Override
	protected void addField(JRDesignField field) throws JRException {
		jrDataset.addField(field);
	}

	@Override
	protected void addVariable(JRDesignVariable variable) throws JRException {
		jrDataset.addVariable(variable);
	}

	@Override
	protected void addSort(JRDesignSortField sort) throws JRException {
		jrDataset.addSortField(sort);
	}
}

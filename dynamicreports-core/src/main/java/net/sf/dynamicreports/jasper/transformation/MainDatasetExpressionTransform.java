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

import net.sf.dynamicreports.design.definition.DRIDesignField;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.DRIDesignSort;
import net.sf.dynamicreports.design.definition.DRIDesignVariable;
import net.sf.dynamicreports.design.definition.expression.DRIDesignComplexExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignJasperExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSystemExpression;
import net.sf.dynamicreports.jasper.base.JasperCustomValues;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRGroup;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignSortField;
import net.sf.jasperreports.engine.design.JRDesignVariable;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class MainDatasetExpressionTransform extends AbstractExpressionTransform {
	private JasperTransformAccessor accessor;

	public MainDatasetExpressionTransform(JasperTransformAccessor accessor) {
		this.accessor = accessor;
	}

	@Override
	protected JasperCustomValues getCustomValues() {
		return accessor.getCustomValues();
	}

	@Override
	protected JRGroup getGroup(DRIDesignGroup group) {
		return accessor.getGroupTransform().getGroup(group);
	}

	@Override
	protected Collection<DRIDesignField> getFields() {
		return accessor.getReport().getFields();
	}

	@Override
	protected Collection<DRIDesignVariable> getVariables() {
		return accessor.getReport().getVariables();
	}

	@Override
	protected Collection<DRIDesignSystemExpression> getSystemExpressions() {
		return accessor.getReport().getSystemExpressions();
	}

	@Override
	protected Collection<DRIDesignJasperExpression> getJasperExpressions() {
		return accessor.getReport().getJasperExpressions();
	}

	@Override
	protected Collection<DRIDesignSimpleExpression> getSimpleExpressions() {
		return accessor.getReport().getSimpleExpressions();
	}

	@Override
	protected Collection<DRIDesignComplexExpression> getComplexExpressions() {
		return accessor.getReport().getComplexExpressions();
	}

	@Override
	protected Collection<DRIDesignSort> getSorts() {
		return accessor.getReport().getSorts();
	}

	@Override
	protected void addField(JRDesignField field) throws JRException {
		accessor.getDesign().addField(field);
	}

	@Override
	protected void addVariable(JRDesignVariable variable) throws JRException {
		accessor.getDesign().addVariable(variable);
	}

	@Override
	protected void addSort(JRDesignSortField sort) throws JRException {
		accessor.getDesign().addSortField(sort);
	}
}

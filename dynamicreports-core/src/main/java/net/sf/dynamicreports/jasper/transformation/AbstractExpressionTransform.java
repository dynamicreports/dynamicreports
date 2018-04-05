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

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.DRIDesignField;
import net.sf.dynamicreports.design.definition.DRIDesignGroup;
import net.sf.dynamicreports.design.definition.DRIDesignSort;
import net.sf.dynamicreports.design.definition.DRIDesignVariable;
import net.sf.dynamicreports.design.definition.expression.DRIDesignComplexExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignJasperExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignParameterExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignPropertyExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSystemExpression;
import net.sf.dynamicreports.jasper.base.JasperCustomValues;
import net.sf.dynamicreports.jasper.constant.ValueType;
import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.dynamicreports.report.constant.SystemExpression;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRGenericElementParameter;
import net.sf.jasperreports.engine.JRGroup;
import net.sf.jasperreports.engine.JRPropertyExpression;
import net.sf.jasperreports.engine.JRVariable;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignGenericElementParameter;
import net.sf.jasperreports.engine.design.JRDesignPropertyExpression;
import net.sf.jasperreports.engine.design.JRDesignSortField;
import net.sf.jasperreports.engine.design.JRDesignVariable;
import net.sf.jasperreports.engine.type.SortFieldTypeEnum;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class AbstractExpressionTransform {
	private static final String VALUE = "$P'{'{0}'}'.getValue(\"{1}\")";
	private static final String FIELD_VALUE = "$F'{'{0}'}'";
	private static final String VARIABLE_VALUE = "$V'{'{0}'}'";
	private static final String PARAMETER_VALUE = "$P'{'{0}'}'";
	private static final String COMPLEX_VALUE = "$P'{'{0}'}'.getValue(\"{1}\", new Object[]'{'{2}'}')";

	private Map<String, JRDesignExpression> expressions;

	public AbstractExpressionTransform() {
		this.expressions = new HashMap<String, JRDesignExpression>();
	}

	public void transform() {
		for (DRIDesignField field : getFields()) {
			addField(field);
		}
		for (DRIDesignSystemExpression expression : getSystemExpressions()) {
			addSystemExpression(expression);
		}
		for (DRIDesignJasperExpression expression : getJasperExpressions()) {
			addJasperExpression(expression);
		}
		for (DRIDesignSimpleExpression expression : getSimpleExpressions()) {
			addSimpleExpression(expression);
		}
		for (DRIDesignComplexExpression complexExpression : getComplexExpressions()) {
			addComplexExpression(complexExpression);
		}
		for (DRIDesignVariable variable : getVariables()) {
			addVariable(variable);
		}
		for (DRIDesignSort sort : getSorts()) {
			addSort(sort);
		}
	}

	private void addSystemExpression(DRIDesignSystemExpression systemExpression) {
		if (systemExpression == null)
			return;
		getCustomValues().addValueType(systemExpression.getName(), ValueType.SYSTEM_EXPRESSION);
		addExpression(systemExpression);
	}

	private void addJasperExpression(DRIDesignJasperExpression jasperExpression) {
		if (jasperExpression == null)
			return;
		addExpression(jasperExpression);
	}

	protected void addSimpleExpression(DRIDesignSimpleExpression simpleExpression) {
		if (simpleExpression == null)
			return;
		getCustomValues().addSimpleExpression(simpleExpression);
		addExpression(simpleExpression);
	}

	private void addField(DRIDesignField field) {
		try {
			if (!field.isExternal()) {
				addField(field(field));
			}
			getCustomValues().addValueType(field.getName(), ValueType.FIELD);
			addExpression(field);
		} catch (JRException e) {
			throw new JasperDesignException("Registration failed for field \"" + field.getName() + "\"", e);
		}
	}

	private void addVariable(DRIDesignVariable variable) {
		try {
			addVariable(variable(variable));
			getCustomValues().addValueType(variable.getName(), ValueType.VARIABLE);
			addExpression(variable);
		} catch (JRException e) {
			throw new JasperDesignException("Registration failed for variable \"" + variable.getName() + "\"", e);
		}
	}

	protected void addComplexExpression(DRIDesignComplexExpression complexExpression) {
		if (complexExpression == null)
			return;
		getCustomValues().addComplexExpression(complexExpression);
		addExpression(complexExpression);
	}

	private void addExpression(DRIDesignExpression expression) {
		if (expressions.containsKey(expression.getName())) {
			throw new JasperDesignException("Duplicate declaration of expression \"" + expression.getName() + "\"");
		}
		expressions.put(expression.getName(), expression(expression));
	}

	private void addSort(DRIDesignSort sort) {
		try {
			addSort(sort(sort));
		} catch (JRException e) {
			throw new JasperDesignException("Registration failed for sort \"" + sort.getExpression().getName() + "\"", e);
		}
	}

	// field
	private JRDesignField field(DRIDesignField field) {
		JRDesignField jrField = new JRDesignField();
		jrField.setName(field.getName());
		jrField.setValueClass(field.getValueClass());
		jrField.setDescription(field.getDescription());
		return jrField;
	}

	// variable
	private JRDesignVariable variable(DRIDesignVariable variable) {
		JRDesignExpression expression = getExpression(variable.getValueExpression());
		JRDesignExpression initialValueExpression = getExpression(variable.getInitialValueExpression());

		JRDesignVariable jrVariable = new JRDesignVariable();
		jrVariable.setName(variable.getName());
		jrVariable.setExpression(expression);
		jrVariable.setInitialValueExpression(initialValueExpression);
		jrVariable.setValueClass(variable.getValueClass());
		jrVariable.setCalculation(ConstantTransform.calculation(variable.getCalculation()));
		ResetType resetType = variable.getResetType();
		jrVariable.setResetType(ConstantTransform.variableResetType(resetType));
		if (resetType.equals(ResetType.GROUP) && variable.getResetGroup() != null) {
			jrVariable.setResetGroup(getGroup(variable.getResetGroup()));
		}
		return jrVariable;
	}

	protected JRGroup getGroup(DRIDesignGroup group) {
		return null;
	}

	// simple expression
	private JRDesignExpression expression(DRIDesignExpression simpleExpression) {
		JRDesignExpression expression = new JRDesignExpression();
		expression.setText(getExpressionText(simpleExpression));
		return expression;
	}

	private String getExpressionText(DRIDesignExpression expression) {
		if (expression instanceof DRIDesignField) {
			return toFieldValue(expression.getName());
		} else if (expression instanceof DRIDesignVariable) {
			return toVariableValue(expression.getName());
		} else if (expression instanceof DRIDesignComplexExpression) {
			DRIDesignComplexExpression complexExpression = (DRIDesignComplexExpression) expression;
			String values = "";
			for (DRIDesignExpression valueExpression : complexExpression.getExpressions()) {
				values += ", " + getExpressionText(valueExpression);
			}
			if (values.length() > 0) {
				values = values.substring(2);
			}
			String parameterName = getExpressionParameterName(complexExpression.getParameterName());
			return MessageFormat.format(COMPLEX_VALUE, parameterName, expression.getName(), values);
		} else if (expression instanceof DRIDesignSimpleExpression) {
			String parameterName = getExpressionParameterName(((DRIDesignSimpleExpression) expression).getParameterName());
			return MessageFormat.format(VALUE, parameterName, expression.getName());
		} else if (expression instanceof DRIDesignSystemExpression) {
			String name = ((DRIDesignSystemExpression) expression).getName();
			if (name.equals(SystemExpression.PAGE_NUMBER.name())) {
				return toVariableValue(JRVariable.PAGE_NUMBER);
			} else {
				return toVariableValue(name);
			}
			// throw new JasperDesignException("System expression \"" + name + "\" not supported");
		} else if (expression instanceof DRIDesignJasperExpression) {
			return ((DRIDesignJasperExpression) expression).getExpression();
		} else {
			throw new JasperDesignException("Expression " + expression.getClass().getName() + " not supported");
		}
	}

	private String getExpressionParameterName(String parameterName) {
		if (parameterName == null) {
			return JasperCustomValues.NAME;
		} else {
			return parameterName;
		}
	}

	private String toFieldValue(String expression) {
		return MessageFormat.format(FIELD_VALUE, expression);
	}

	private String toVariableValue(String expression) {
		return MessageFormat.format(VARIABLE_VALUE, expression);
	}

	protected String toParameterValue(String expression) {
		return MessageFormat.format(PARAMETER_VALUE, expression);
	}

	public JRDesignExpression getExpression(DRIDesignExpression expression) {
		if (expression == null)
			return null;
		if (!expressions.containsKey(expression.getName())) {
			throw new JasperDesignException("Expression \"" + expression.getName() + "\" is not registered");
		}
		return expressions.get(expression.getName());
	}

	// sort
	private JRDesignSortField sort(DRIDesignSort sort) {
		DRIDesignExpression expression = sort.getExpression();
		String name;
		SortFieldTypeEnum type;
		if (expression instanceof DRIDesignField) {
			name = expression.getName();
			type = SortFieldTypeEnum.FIELD;
		} else if (expression instanceof DRIDesignVariable) {
			name = expression.getName();
			type = SortFieldTypeEnum.VARIABLE;
		} else {
			throw new JasperDesignException("Sort expression \"" + expression.getName() + "\" not supported");
		}

		JRDesignSortField jrSort = new JRDesignSortField();
		jrSort.setName(name);
		jrSort.setOrder(ConstantTransform.orderType(sort.getOrderType()));
		jrSort.setType(type);
		return jrSort;
	}

	protected JRPropertyExpression getPropertyExpression(DRIDesignPropertyExpression propertyExpression) {
		JRDesignPropertyExpression jrPropertyExpression = new JRDesignPropertyExpression();
		jrPropertyExpression.setName(propertyExpression.getName());
		jrPropertyExpression.setValueExpression(getExpression(propertyExpression.getValueExpression()));
		return jrPropertyExpression;
	}

	protected JRGenericElementParameter getGenericElementParameterExpression(DRIDesignParameterExpression parameterExpression) {
		JRDesignGenericElementParameter jrParameterExpression = new JRDesignGenericElementParameter();
		jrParameterExpression.setName(parameterExpression.getName());
		jrParameterExpression.setValueExpression(getExpression(parameterExpression.getValueExpression()));
		return jrParameterExpression;
	}

	protected abstract JasperCustomValues getCustomValues();

	protected abstract Collection<DRIDesignField> getFields();

	protected abstract Collection<DRIDesignVariable> getVariables();

	protected abstract Collection<DRIDesignSystemExpression> getSystemExpressions();

	protected abstract Collection<DRIDesignJasperExpression> getJasperExpressions();

	protected abstract Collection<DRIDesignSimpleExpression> getSimpleExpressions();

	protected abstract Collection<DRIDesignComplexExpression> getComplexExpressions();

	protected abstract Collection<DRIDesignSort> getSorts();

	protected abstract void addField(JRDesignField field) throws JRException;

	protected abstract void addVariable(JRDesignVariable variable) throws JRException;

	protected abstract void addSort(JRDesignSortField sort) throws JRException;
}

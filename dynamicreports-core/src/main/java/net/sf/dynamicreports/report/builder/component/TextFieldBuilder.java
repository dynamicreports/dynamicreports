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

package net.sf.dynamicreports.report.builder.component;

import java.util.Date;

import org.apache.commons.lang3.Validate;

import net.sf.dynamicreports.report.base.component.DRTextField;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.VariableBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.group.GroupBuilder;
import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.definition.DRIField;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings("deprecation")
public class TextFieldBuilder<T> extends HyperLinkComponentBuilder<TextFieldBuilder<T>, DRTextField<T>> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected TextFieldBuilder() {
		super(new DRTextField<T>());
	}

	public TextFieldBuilder<T> setText(VariableBuilder<T> variable) {
		Validate.notNull(variable, "variable must not be null");
		getObject().setValueExpression(variable.getVariable());
		return this;
	}

	public TextFieldBuilder<T> setText(FieldBuilder<T> field) {
		Validate.notNull(field, "field must not be null");
		getObject().setValueExpression(field.getField());
		if (getObject().getDataType() == null) {
			getObject().setDataType(field.getField().getDataType());
		}
		return this;
	}

	public TextFieldBuilder<T> setText(DRIExpression<T> textExpression) {
		getObject().setValueExpression(textExpression);
		if (textExpression instanceof DRIField && getObject().getDataType() == null) {
			getObject().setDataType(((DRIField<T>) textExpression).getDataType());
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public TextFieldBuilder<T> setText(String text) {
		getObject().setValueExpression((DRIExpression<T>) Expressions.text(text));
		return this;
	}

	@SuppressWarnings("unchecked")
	public TextFieldBuilder<T> setText(Number number) {
		getObject().setValueExpression((DRIExpression<T>) Expressions.number(number));
		return this;
	}

	@SuppressWarnings("unchecked")
	public TextFieldBuilder<T> setText(Date date) {
		getObject().setValueExpression((DRIExpression<T>) Expressions.date(date));
		return this;
	}

	public TextFieldBuilder<T> setPattern(String pattern) {
		getObject().setPattern(pattern);
		return this;
	}

	public TextFieldBuilder<T> setPattern(DRIExpression<String> patternExpression) {
		getObject().setPatternExpression(patternExpression);
		return this;
	}

	/**
	 * @deprecated use setHorizontalTextAlignment instead
	 */
	@Deprecated
	public TextFieldBuilder<T> setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
		if (horizontalAlignment != null) {
			getObject().setHorizontalTextAlignment(HorizontalTextAlignment.valueOf(horizontalAlignment.name()));
		} else {
			getObject().setHorizontalTextAlignment(null);
		}
		return this;
	}

	public TextFieldBuilder<T> setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
		getObject().setHorizontalTextAlignment(horizontalTextAlignment);
		return this;
	}

	public TextFieldBuilder<T> setValueFormatter(DRIValueFormatter<?, ? super T> valueFormatter) {
		getObject().setValueFormatter(valueFormatter);
		return this;
	}

	public TextFieldBuilder<T> setDataType(DRIDataType<? super T, T> dataType) {
		getObject().setDataType(dataType);
		return this;
	}

	/**
	 * This method is used to define the preferred width of a textField.
	 * The width is set to the <code>columns</code> multiplied by width of the
	 * character <em>m</em> for the font used
	 *
	 * @param columns
	 *          the number of preferred columns >= 0
	 * @exception IllegalArgumentException
	 *              if <code>columns</code> is < 0
	 */
	public TextFieldBuilder<T> setColumns(Integer columns) {
		getObject().setColumns(columns);
		return this;
	}

	/**
	 * This method is used to define the fixed width of a textField.
	 * The width is set to the <code>columns</code> multiplied by width of the
	 * character <em>m</em> for the font used
	 *
	 * @param columns
	 *          the number of fixed columns >= 0
	 * @exception IllegalArgumentException
	 *              if <code>columns</code> is < 0
	 */
	public TextFieldBuilder<T> setFixedColumns(Integer columns) {
		getObject().setColumns(columns);
		getObject().setWidthType(ComponentDimensionType.FIXED);
		return this;
	}

	/**
	 * This method is used to define the minimum width of a textField.
	 * The width is set to the <code>columns</code> multiplied by width of the
	 * character <em>m</em> for the font used
	 *
	 * @param columns
	 *          the number of minimum columns >= 0
	 * @exception IllegalArgumentException
	 *              if <code>columns</code> is < 0
	 */
	public TextFieldBuilder<T> setMinColumns(Integer columns) {
		getObject().setColumns(columns);
		getObject().setWidthType(ComponentDimensionType.EXPAND);
		return this;
	}

	/**
	 * This method is used to define the preferred height of a textField.
	 * The height is set to the <code>rows</code> multiplied by height of the font
	 *
	 * @param rows
	 *          the number of preferred rows >= 0
	 * @exception IllegalArgumentException
	 *              if <code>rows</code> is < 0
	 */
	public TextFieldBuilder<T> setRows(Integer rows) {
		getObject().setRows(rows);
		return this;
	}

	/**
	 * This method is used to define the fixed height of a textField.
	 * The height is set to the <code>rows</code> multiplied by height of the font
	 *
	 * @param rows
	 *          the number of fixed rows >= 0
	 * @exception IllegalArgumentException
	 *              if <code>rows</code> is < 0
	 */
	public TextFieldBuilder<T> setFixedRows(Integer rows) {
		getObject().setRows(rows);
		getObject().setHeightType(ComponentDimensionType.FIXED);
		return this;
	}

	/**
	 * This method is used to define the minimum height of a textField.
	 * The height is set to the <code>rows</code> multiplied by height of the font
	 *
	 * @param rows
	 *          the number of minimum rows >= 0
	 * @exception IllegalArgumentException
	 *              if <code>rows</code> is < 0
	 */
	public TextFieldBuilder<T> setMinRows(Integer rows) {
		getObject().setRows(rows);
		getObject().setHeightType(ComponentDimensionType.EXPAND);
		return this;
	}

	public TextFieldBuilder<T> setEvaluationTime(Evaluation evaluationTime) {
		getObject().setEvaluationTime(evaluationTime);
		return this;
	}

	public TextFieldBuilder<T> setEvaluationGroup(GroupBuilder<?> evaluationGroup) {
		Validate.notNull(evaluationGroup, "evaluationGroup must not be null");
		getObject().setEvaluationGroup(evaluationGroup.build());
		getObject().setEvaluationTime(Evaluation.GROUP);
		return this;
	}

	public TextFieldBuilder<T> setMarkup(Markup markup) {
		getObject().setMarkup(markup);
		return this;
	}

	public TextFieldBuilder<T> setStretchWithOverflow(Boolean stretchWithOverflow) {
		getObject().setStretchWithOverflow(stretchWithOverflow);
		return this;
	}

	public TextFieldBuilder<T> setPrintRepeatedValues(Boolean printRepeatedValues) {
		getObject().setPrintRepeatedValues(printRepeatedValues);
		return this;
	}
}

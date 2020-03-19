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
import net.sf.dynamicreports.report.constant.TextAdjust;
import net.sf.dynamicreports.report.definition.DRIField;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;

/**
 * <p>TextFieldBuilder class.</p>
 *
 * @author Ricardo Mariaca, Jan Moxter
 * 
 */
@SuppressWarnings("deprecation")
public class TextFieldBuilder<T> extends HyperLinkComponentBuilder<TextFieldBuilder<T>, DRTextField<T>> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for TextFieldBuilder.</p>
     */
    protected TextFieldBuilder() {
        super(new DRTextField<T>());
    }

    /**
     * <p>setText.</p>
     *
     * @param variable a {@link net.sf.dynamicreports.report.builder.VariableBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setText(final VariableBuilder<T> variable) {
        Validate.notNull(variable, "variable must not be null");
        getObject().setValueExpression(variable.getVariable());
        return this;
    }

    /**
     * <p>setText.</p>
     *
     * @param field a {@link net.sf.dynamicreports.report.builder.FieldBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setText(final FieldBuilder<T> field) {
        Validate.notNull(field, "field must not be null");
        getObject().setValueExpression(field.getField());
        if (getObject().getDataType() == null) {
            getObject().setDataType(field.getField().getDataType());
        }
        return this;
    }

    /**
     * <p>setText.</p>
     *
     * @param textExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setText(final DRIExpression<T> textExpression) {
        getObject().setValueExpression(textExpression);
        if (textExpression instanceof DRIField && getObject().getDataType() == null) {
            getObject().setDataType(((DRIField<T>) textExpression).getDataType());
        }
        return this;
    }

    /**
     * <p>setText.</p>
     *
     * @param text a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    @SuppressWarnings("unchecked")
    public TextFieldBuilder<T> setText(final String text) {
        getObject().setValueExpression((DRIExpression<T>) Expressions.text(text));
        return this;
    }

    /**
     * <p>setText.</p>
     *
     * @param number a {@link java.lang.Number} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    @SuppressWarnings("unchecked")
    public TextFieldBuilder<T> setText(final Number number) {
        getObject().setValueExpression((DRIExpression<T>) Expressions.number(number));
        return this;
    }

    /**
     * <p>setText.</p>
     *
     * @param date a {@link java.util.Date} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    @SuppressWarnings("unchecked")
    public TextFieldBuilder<T> setText(final Date date) {
        getObject().setValueExpression((DRIExpression<T>) Expressions.date(date));
        return this;
    }

    /**
     * <p>setPattern.</p>
     *
     * @param pattern a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setPattern(final String pattern) {
        getObject().setPattern(pattern);
        return this;
    }

    /**
     * <p>setPattern.</p>
     *
     * @param patternExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setPattern(final DRIExpression<String> patternExpression) {
        getObject().setPatternExpression(patternExpression);
        return this;
    }

    /**
     * <p>setHorizontalAlignment.</p>
     *
     * @param horizontalAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalAlignment} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     * @deprecated use setHorizontalTextAlignment instead
     */
    @Deprecated
    public TextFieldBuilder<T> setHorizontalAlignment(final HorizontalAlignment horizontalAlignment) {
        if (horizontalAlignment != null) {
            getObject().setHorizontalTextAlignment(HorizontalTextAlignment.valueOf(horizontalAlignment.name()));
        } else {
            getObject().setHorizontalTextAlignment(null);
        }
        return this;
    }

    /**
     * <p>setHorizontalTextAlignment.</p>
     *
     * @param horizontalTextAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setHorizontalTextAlignment(final HorizontalTextAlignment horizontalTextAlignment) {
        getObject().setHorizontalTextAlignment(horizontalTextAlignment);
        return this;
    }

    /**
     * <p>setValueFormatter.</p>
     *
     * @param valueFormatter a {@link net.sf.dynamicreports.report.definition.expression.DRIValueFormatter} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setValueFormatter(final DRIValueFormatter<?, ? super T> valueFormatter) {
        getObject().setValueFormatter(valueFormatter);
        return this;
    }

    /**
     * <p>setDataType.</p>
     *
     * @param dataType a {@link net.sf.dynamicreports.report.definition.datatype.DRIDataType} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setDataType(final DRIDataType<? super T, T> dataType) {
        getObject().setDataType(dataType);
        return this;
    }

    /**
     * This method is used to define the preferred width of a textField. The width is set to the <code>columns</code> multiplied by width of the character <em>m</em> for the font used
     *
     * @param columns the number of preferred columns >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>columns</code> is < 0
     */
    public TextFieldBuilder<T> setColumns(final Integer columns) {
        getObject().setColumns(columns);
        return this;
    }

    /**
     * This method is used to define the fixed width of a textField. The width is set to the <code>columns</code> multiplied by width of the character <em>m</em> for the font used
     *
     * @param columns the number of fixed columns >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>columns</code> is < 0
     */
    public TextFieldBuilder<T> setFixedColumns(final Integer columns) {
        getObject().setColumns(columns);
        getObject().setWidthType(ComponentDimensionType.FIXED);
        return this;
    }

    /**
     * This method is used to define the minimum width of a textField. The width is set to the <code>columns</code> multiplied by width of the character <em>m</em> for the font used
     *
     * @param columns the number of minimum columns >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>columns</code> is < 0
     */
    public TextFieldBuilder<T> setMinColumns(final Integer columns) {
        getObject().setColumns(columns);
        getObject().setWidthType(ComponentDimensionType.EXPAND);
        return this;
    }

    /**
     * This method is used to define the preferred height of a textField. The height is set to the <code>rows</code> multiplied by height of the font
     *
     * @param rows the number of preferred rows >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>rows</code> is < 0
     */
    public TextFieldBuilder<T> setRows(final Integer rows) {
        getObject().setRows(rows);
        return this;
    }

    /**
     * This method is used to define the fixed height of a textField. The height is set to the <code>rows</code> multiplied by height of the font
     *
     * @param rows the number of fixed rows >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>rows</code> is < 0
     */
    public TextFieldBuilder<T> setFixedRows(final Integer rows) {
        getObject().setRows(rows);
        getObject().setHeightType(ComponentDimensionType.FIXED);
        return this;
    }

    /**
     * This method is used to define the minimum height of a textField. The height is set to the <code>rows</code> multiplied by height of the font
     *
     * @param rows the number of minimum rows >= 0
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     * @throws java.lang.IllegalArgumentException if <code>rows</code> is < 0
     */
    public TextFieldBuilder<T> setMinRows(final Integer rows) {
        getObject().setRows(rows);
        getObject().setHeightType(ComponentDimensionType.EXPAND);
        return this;
    }

    /**
     * <p>setEvaluationTime.</p>
     *
     * @param evaluationTime a {@link net.sf.dynamicreports.report.constant.Evaluation} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setEvaluationTime(final Evaluation evaluationTime) {
        getObject().setEvaluationTime(evaluationTime);
        return this;
    }

    /**
     * <p>setEvaluationGroup.</p>
     *
     * @param evaluationGroup a {@link net.sf.dynamicreports.report.builder.group.GroupBuilder} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setEvaluationGroup(final GroupBuilder<?> evaluationGroup) {
        Validate.notNull(evaluationGroup, "evaluationGroup must not be null");
        getObject().setEvaluationGroup(evaluationGroup.build());
        getObject().setEvaluationTime(Evaluation.GROUP);
        return this;
    }

    /**
     * <p>setMarkup.</p>
     *
     * @param markup a {@link net.sf.dynamicreports.report.constant.Markup} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setMarkup(final Markup markup) {
        getObject().setMarkup(markup);
        return this;
    }

    /**
     * <p>setStretchWithOverflow.</p>
     *
     * @param stretchWithOverflow a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     * @deprecated replaced by {@link #setTextAdjust(TextAdjust)}
     */
    @Deprecated
    public TextFieldBuilder<T> setStretchWithOverflow(final Boolean stretchWithOverflow) {
        getObject().setStretchWithOverflow(stretchWithOverflow);
        return this;
    }

    /**
     * <p>setTextAdjust.</p>
     *
     * @param textAdjust a {@link net.sf.dynamicreports.report.constant.TextAdjust} object.
     * @return a T object.
     */
    public TextFieldBuilder<T> setTextAdjust(final TextAdjust textAdjust) {
        getObject().setTextAdjust(textAdjust);
        return this;
    }

    /**
     * <p>setPrintRepeatedValues.</p>
     *
     * @param printRepeatedValues a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.component.TextFieldBuilder} object.
     */
    public TextFieldBuilder<T> setPrintRepeatedValues(final Boolean printRepeatedValues) {
        getObject().setPrintRepeatedValues(printRepeatedValues);
        return this;
    }
}

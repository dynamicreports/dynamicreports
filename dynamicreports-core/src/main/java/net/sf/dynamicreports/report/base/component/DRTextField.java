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
package net.sf.dynamicreports.report.base.component;

import net.sf.dynamicreports.report.base.DRGroup;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.definition.component.DRITextField;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import org.apache.commons.lang3.Validate;

/**
 * <p>DRTextField class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class DRTextField<T> extends DRHyperLinkComponent implements DRITextField<T> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<T> valueExpression;
    private String pattern;
    private DRIExpression<String> patternExpression;
    private HorizontalTextAlignment horizontalTextAlignment;
    private DRIValueFormatter<?, ? super T> valueFormatter;
    private DRIDataType<? super T, T> dataType;
    private Integer columns;
    private Integer rows;
    private Evaluation evaluationTime;
    private DRGroup evaluationGroup;
    private Markup markup;
    private Boolean stretchWithOverflow;
    private Boolean printRepeatedValues;

    /** {@inheritDoc} */
    @Override
    public DRIExpression<T> getValueExpression() {
        return valueExpression;
    }

    /**
     * <p>Setter for the field <code>valueExpression</code>.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setValueExpression(DRIExpression<T> valueExpression) {
        Validate.notNull(valueExpression, "valueExpression must not be null");
        this.valueExpression = valueExpression;
    }

    /** {@inheritDoc} */
    @Override
    public String getPattern() {
        return pattern;
    }

    /**
     * <p>Setter for the field <code>pattern</code>.</p>
     *
     * @param pattern a {@link java.lang.String} object.
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<String> getPatternExpression() {
        return patternExpression;
    }

    /**
     * <p>Setter for the field <code>patternExpression</code>.</p>
     *
     * @param patternExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setPatternExpression(DRIExpression<String> patternExpression) {
        this.patternExpression = patternExpression;
    }

    /** {@inheritDoc} */
    @Override
    public HorizontalTextAlignment getHorizontalTextAlignment() {
        return horizontalTextAlignment;
    }

    /**
     * <p>Setter for the field <code>horizontalTextAlignment</code>.</p>
     *
     * @param horizontalTextAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     */
    public void setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
        this.horizontalTextAlignment = horizontalTextAlignment;
    }

    /** {@inheritDoc} */
    @Override
    public DRIValueFormatter<?, ? super T> getValueFormatter() {
        return valueFormatter;
    }

    /**
     * <p>Setter for the field <code>valueFormatter</code>.</p>
     *
     * @param valueFormatter a {@link net.sf.dynamicreports.report.definition.expression.DRIValueFormatter} object.
     */
    public void setValueFormatter(DRIValueFormatter<?, ? super T> valueFormatter) {
        this.valueFormatter = valueFormatter;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDataType<? super T, T> getDataType() {
        return dataType;
    }

    /**
     * <p>Setter for the field <code>dataType</code>.</p>
     *
     * @param dataType a {@link net.sf.dynamicreports.report.definition.datatype.DRIDataType} object.
     */
    public void setDataType(DRIDataType<? super T, T> dataType) {
        this.dataType = dataType;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Returns the number of columns.
     */
    @Override
    public Integer getColumns() {
        return columns;
    }

    /**
     * This method is used to define the width of a column. The width is set to the <code>columns</code> multiplied by width of the character <em>m</em> for the font used
     *
     * @param columns the number of columns >= 0
     * @throws java.lang.IllegalArgumentException if <code>columns</code> is < 0
     */
    public void setColumns(Integer columns) {
        if (columns != null) {
            Validate.isTrue(columns >= 0, "columns must be >= 0");
        }
        this.columns = columns;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Returns the number of rows.
     */
    @Override
    public Integer getRows() {
        return rows;
    }

    /**
     * This method is used to define the height of a column. The height is set to the <code>rows</code> multiplied by height of the font
     *
     * @param rows the number of rows >= 0
     * @throws java.lang.IllegalArgumentException if <code>rows</code> is < 0
     */
    public void setRows(Integer rows) {
        if (rows != null) {
            Validate.isTrue(rows >= 0, "rows must be >= 0");
        }
        this.rows = rows;
    }

    /** {@inheritDoc} */
    @Override
    public Evaluation getEvaluationTime() {
        return evaluationTime;
    }

    /**
     * <p>Setter for the field <code>evaluationTime</code>.</p>
     *
     * @param evaluationTime a {@link net.sf.dynamicreports.report.constant.Evaluation} object.
     */
    public void setEvaluationTime(Evaluation evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    /** {@inheritDoc} */
    @Override
    public DRGroup getEvaluationGroup() {
        return evaluationGroup;
    }

    /**
     * <p>Setter for the field <code>evaluationGroup</code>.</p>
     *
     * @param evaluationGroup a {@link net.sf.dynamicreports.report.base.DRGroup} object.
     */
    public void setEvaluationGroup(DRGroup evaluationGroup) {
        this.evaluationGroup = evaluationGroup;
    }

    /** {@inheritDoc} */
    @Override
    public Markup getMarkup() {
        return markup;
    }

    /**
     * <p>Setter for the field <code>markup</code>.</p>
     *
     * @param markup a {@link net.sf.dynamicreports.report.constant.Markup} object.
     */
    public void setMarkup(Markup markup) {
        this.markup = markup;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getStretchWithOverflow() {
        return stretchWithOverflow;
    }

    /**
     * <p>Setter for the field <code>stretchWithOverflow</code>.</p>
     *
     * @param stretchWithOverflow a {@link java.lang.Boolean} object.
     */
    public void setStretchWithOverflow(Boolean stretchWithOverflow) {
        this.stretchWithOverflow = stretchWithOverflow;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getPrintRepeatedValues() {
        return printRepeatedValues;
    }

    /**
     * <p>Setter for the field <code>printRepeatedValues</code>.</p>
     *
     * @param printRepeatedValues a {@link java.lang.Boolean} object.
     */
    public void setPrintRepeatedValues(Boolean printRepeatedValues) {
        this.printRepeatedValues = printRepeatedValues;
    }
}

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
package net.sf.dynamicreports.design.base.component;

import net.sf.dynamicreports.design.base.DRDesignGroup;
import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.definition.component.DRIDesignTextField;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.constant.TextAdjust;

/**
 * <p>DRDesignTextField class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignTextField extends DRDesignHyperlinkComponent implements DRIDesignTextField {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private String pattern;
    private DRIDesignExpression patternExpression;
    private HorizontalTextAlignment horizontalTextAlignment;
    private DRIDesignExpression valueExpression;
    private boolean printRepeatedValues;
    private EvaluationTime evaluationTime;
    private DRDesignGroup evaluationGroup;
    private Markup markup;
    private boolean stretchWithOverflow;
    private TextAdjust textAdjust;


    /**
     * <p>Constructor for DRDesignTextField.</p>
     */
    public DRDesignTextField() {
        super("textField");
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
    public void setPattern(final String pattern) {
        this.pattern = pattern;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getPatternExpression() {
        return patternExpression;
    }

    /**
     * <p>Setter for the field <code>patternExpression</code>.</p>
     *
     * @param patternExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setPatternExpression(final DRIDesignExpression patternExpression) {
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
    public void setHorizontalTextAlignment(final HorizontalTextAlignment horizontalTextAlignment) {
        this.horizontalTextAlignment = horizontalTextAlignment;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getValueExpression() {
        return valueExpression;
    }

    /**
     * <p>Setter for the field <code>valueExpression</code>.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.design.definition.expression.DRIDesignExpression} object.
     */
    public void setValueExpression(final DRIDesignExpression valueExpression) {
        this.valueExpression = valueExpression;
    }

    /** {@inheritDoc} */
    @Override
    public boolean isPrintRepeatedValues() {
        return printRepeatedValues;
    }

    /**
     * <p>Setter for the field <code>printRepeatedValues</code>.</p>
     *
     * @param printRepeatedValues a boolean.
     */
    public void setPrintRepeatedValues(final boolean printRepeatedValues) {
        this.printRepeatedValues = printRepeatedValues;
    }

    /** {@inheritDoc} */
    @Override
    public EvaluationTime getEvaluationTime() {
        return evaluationTime;
    }

    /**
     * <p>Setter for the field <code>evaluationTime</code>.</p>
     *
     * @param evaluationTime a {@link net.sf.dynamicreports.design.constant.EvaluationTime} object.
     */
    public void setEvaluationTime(final EvaluationTime evaluationTime) {
        this.evaluationTime = evaluationTime;
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignGroup getEvaluationGroup() {
        return evaluationGroup;
    }

    /**
     * <p>Setter for the field <code>evaluationGroup</code>.</p>
     *
     * @param evaluationGroup a {@link net.sf.dynamicreports.design.base.DRDesignGroup} object.
     */
    public void setEvaluationGroup(final DRDesignGroup evaluationGroup) {
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
    public void setMarkup(final Markup markup) {
        this.markup = markup;
    }

    /** {@inheritDoc} */
    @Override
    @Deprecated
    public boolean isStretchWithOverflow() {
        return stretchWithOverflow;
    }

    /**
     * <p>Setter for the field <code>stretchWithOverflow</code>.</p>
     *
     * @param stretchWithOverflow a boolean.
     * @deprecated Replaced by {@link #setTextAdjust(TextAdjust)}.
     */
    @Deprecated
    public void setStretchWithOverflow(final boolean stretchWithOverflow) {
        this.stretchWithOverflow = stretchWithOverflow;
    }

    /** {@inheritDoc} */
    @Override
    public TextAdjust getTextAdjust()
    {
        return textAdjust;
    }

    /**
     * <p>Setter for the field <code>textAdjust</code>.</p>
     *
     * @param textAdjust a {@link net.sf.dynamicreports.report.constant.TextAdjust} object.
     */
    public void setTextAdjust(final TextAdjust textAdjust)
    {
        this.textAdjust = textAdjust;
    }
}

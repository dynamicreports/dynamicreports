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
package net.sf.dynamicreports.report.definition.component;

import net.sf.dynamicreports.report.constant.Evaluation;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.definition.DRIGroup;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;

/**
 * <p>DRITextField interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRITextField<T> extends DRIHyperLinkComponent {

    /**
     * <p>getValueExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<T> getValueExpression();

    /**
     * <p>getPattern.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPattern();

    /**
     * <p>getPatternExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<String> getPatternExpression();

    /**
     * <p>getHorizontalTextAlignment.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     */
    public HorizontalTextAlignment getHorizontalTextAlignment();

    /**
     * <p>getValueFormatter.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIValueFormatter} object.
     */
    public DRIValueFormatter<?, ? super T> getValueFormatter();

    /**
     * <p>getDataType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.datatype.DRIDataType} object.
     */
    public DRIDataType<? super T, T> getDataType();

    /**
     * <p>getColumns.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getColumns();

    /**
     * <p>getRows.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getRows();

    /**
     * <p>getEvaluationTime.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.Evaluation} object.
     */
    public Evaluation getEvaluationTime();

    /**
     * <p>getEvaluationGroup.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     */
    public DRIGroup getEvaluationGroup();

    /**
     * <p>getMarkup.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.Markup} object.
     */
    public Markup getMarkup();

    /**
     * <p>getStretchWithOverflow.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getStretchWithOverflow();

    /**
     * <p>getPrintRepeatedValues.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getPrintRepeatedValues();
}

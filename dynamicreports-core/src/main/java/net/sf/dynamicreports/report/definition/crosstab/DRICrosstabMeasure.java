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
package net.sf.dynamicreports.report.definition.crosstab;

import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.definition.DRIHyperLink;
import net.sf.dynamicreports.report.definition.datatype.DRIDataType;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;

import java.io.Serializable;
import java.util.List;

/**
 * <p>DRICrosstabMeasure interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRICrosstabMeasure<T> extends Serializable {

    /**
     * <p>getName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName();

    /**
     * <p>getDataType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.datatype.DRIDataType} object.
     */
    public DRIDataType<? super T, T> getDataType();

    /**
     * <p>getExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<?> getExpression();

    /**
     * <p>getPattern.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPattern();

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
     * <p>getStretchWithOverflow.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getStretchWithOverflow();

    /**
     * <p>getHyperLink.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIHyperLink} object.
     */
    public DRIHyperLink getHyperLink();

    /**
     * <p>getPropertyExpressions.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRIPropertyExpression> getPropertyExpressions();

    /**
     * <p>getStyles.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRICrosstabCellStyle> getStyles();

    /**
     * <p>getTitleExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<?> getTitleExpression();

    /**
     * <p>getTitleStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public DRIReportStyle getTitleStyle();
}

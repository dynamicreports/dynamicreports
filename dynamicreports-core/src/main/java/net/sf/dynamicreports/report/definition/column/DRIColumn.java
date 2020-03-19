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
package net.sf.dynamicreports.report.definition.column;

import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.definition.component.DRIComponent;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;
import net.sf.dynamicreports.report.definition.grid.DRIColumnGridComponent;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;

import java.util.List;

/**
 * <p>DRIColumn interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRIColumn<T extends DRIComponent> extends DRIColumnGridComponent {

    /**
     * <p>getComponent.</p>
     *
     * @return a T object.
     */
    public T getComponent();

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

    /**
     * <p>getTitleHeight.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getTitleHeight();

    /**
     * <p>getTitleHeightType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.ComponentDimensionType} object.
     */
    public ComponentDimensionType getTitleHeightType();

    /**
     * <p>getTitleRows.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getTitleRows();

    /**
     * <p>getTitleStretchWithOverflow.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getTitleStretchWithOverflow();

    /**
     * <p>getTitlePropertyExpressions.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<DRIPropertyExpression> getTitlePropertyExpressions();

    /**
     * <p>getName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName();
}

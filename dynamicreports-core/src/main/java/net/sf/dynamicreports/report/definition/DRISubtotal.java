/**
 * DynamicReports - Free Java reporting library for creating reports dynamically
 * <p>
 * Copyright (C) 2010 - 2018 Ricardo Mariaca http://www.dynamicreports.org
 * <p>
 * This file is part of DynamicReports.
 * <p>
 * DynamicReports is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p>
 * DynamicReports is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 * <p>
 * You should have received a copy of the GNU Lesser General Public License along with DynamicReports. If not, see <http://www.gnu.org/licenses/>.
 */

package net.sf.dynamicreports.report.definition;

import net.sf.dynamicreports.report.constant.ComponentDimensionType;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.constant.SubtotalPosition;
import net.sf.dynamicreports.report.definition.column.DRIColumn;
import net.sf.dynamicreports.report.definition.component.DRITextField;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.style.DRIReportStyle;

/**
 * <p>DRISubtotal interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRISubtotal<T> extends DRIExpression<T>, DRIValue<T> {

    /**
     * <p>getShowInColumn.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.column.DRIColumn} object.
     */
    public DRIColumn<?> getShowInColumn();

    /**
     * <p>getValueField.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.component.DRITextField} object.
     */
    public DRITextField<T> getValueField();

    /**
     * <p>getLabelExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<?> getLabelExpression();

    /**
     * <p>getLabelStyle.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIReportStyle} object.
     */
    public DRIReportStyle getLabelStyle();

    /**
     * <p>getLabelPosition.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.Position} object.
     */
    public Position getLabelPosition();

    /**
     * <p>getLabelWidth.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getLabelWidth();

    /**
     * <p>getLabelWidthType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.ComponentDimensionType} object.
     */
    public ComponentDimensionType getLabelWidthType();

    /**
     * <p>getPosition.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.SubtotalPosition} object.
     */
    public SubtotalPosition getPosition();

    /**
     * <p>getGroup.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIGroup} object.
     */
    public DRIGroup getGroup();
}

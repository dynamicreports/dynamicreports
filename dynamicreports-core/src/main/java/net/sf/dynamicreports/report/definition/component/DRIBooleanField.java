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

import net.sf.dynamicreports.report.constant.BooleanComponentType;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>DRIBooleanField interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public interface DRIBooleanField extends DRIHyperLinkComponent {

    /**
     * <p>getValueExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<Boolean> getValueExpression();

    /**
     * <p>getComponentType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.BooleanComponentType} object.
     */
    public BooleanComponentType getComponentType();

    /**
     * <p>getEmptyWhenNullValue.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getEmptyWhenNullValue();

    /**
     * <p>getImageWidth.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getImageWidth();

    /**
     * <p>getImageHeight.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getImageHeight();

    /**
     * <p>getHorizontalImageAlignment.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalImageAlignment} object.
     */
    public HorizontalImageAlignment getHorizontalImageAlignment();

    /**
     * <p>getHorizontalTextAlignment.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     */
    public HorizontalTextAlignment getHorizontalTextAlignment();
}

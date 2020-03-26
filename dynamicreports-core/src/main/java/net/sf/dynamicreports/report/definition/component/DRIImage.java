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
package net.sf.dynamicreports.report.definition.component;

import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>DRIImage interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRIImage extends DRIHyperLinkComponent {

    /**
     * <p>getImageExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<?> getImageExpression();

    /**
     * <p>getImageScale.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.ImageScale} object.
     */
    public ImageScale getImageScale();

    /**
     * <p>getUsingCache.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getUsingCache();

    /**
     * <p>getLazy.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getLazy();

    /**
     * <p>getHorizontalImageAlignment.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalImageAlignment} object.
     */
    public HorizontalImageAlignment getHorizontalImageAlignment();
}

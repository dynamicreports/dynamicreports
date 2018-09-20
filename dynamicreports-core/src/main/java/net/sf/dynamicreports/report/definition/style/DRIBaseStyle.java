/*
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
package net.sf.dynamicreports.report.definition.style;

import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.constant.Markup;
import net.sf.dynamicreports.report.constant.Rotation;
import net.sf.dynamicreports.report.constant.VerticalImageAlignment;
import net.sf.dynamicreports.report.constant.VerticalTextAlignment;

import java.awt.Color;
import java.io.Serializable;

/**
 * <p>DRIBaseStyle interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIBaseStyle extends Serializable {

    /**
     * <p>getForegroundColor.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
    public Color getForegroundColor();

    /**
     * <p>getBackgroundColor.</p>
     *
     * @return a {@link java.awt.Color} object.
     */
    public Color getBackgroundColor();

    /**
     * <p>getRadius.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getRadius();

    /**
     * <p>getImageScale.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.ImageScale} object.
     */
    public ImageScale getImageScale();

    /**
     * <p>getHorizontalImageAlignment.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalImageAlignment} object.
     */
    public HorizontalImageAlignment getHorizontalImageAlignment();

    /**
     * <p>getVerticalImageAlignment.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.VerticalImageAlignment} object.
     */
    public VerticalImageAlignment getVerticalImageAlignment();

    /**
     * <p>getHorizontalTextAlignment.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     */
    public HorizontalTextAlignment getHorizontalTextAlignment();

    /**
     * <p>getVerticalTextAlignment.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.VerticalTextAlignment} object.
     */
    public VerticalTextAlignment getVerticalTextAlignment();

    /**
     * <p>getBorder.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIBorder} object.
     */
    public DRIBorder getBorder();

    /**
     * <p>getPadding.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIPadding} object.
     */
    public DRIPadding getPadding();

    /**
     * <p>getFont.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIFont} object.
     */
    public DRIFont getFont();

    /**
     * <p>getRotation.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.Rotation} object.
     */
    public Rotation getRotation();

    /**
     * <p>getPattern.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPattern();

    /**
     * <p>getMarkup.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.Markup} object.
     */
    public Markup getMarkup();

    /**
     * <p>getParagraph.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIParagraph} object.
     */
    public DRIParagraph getParagraph();

    /**
     * <p>getLinePen.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.style.DRIPen} object.
     */
    public DRIPen getLinePen();

}

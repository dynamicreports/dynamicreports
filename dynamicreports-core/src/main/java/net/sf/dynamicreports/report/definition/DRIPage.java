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

import net.sf.dynamicreports.report.constant.PageOrientation;

import java.io.Serializable;

/**
 * <p>DRIPage interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DRIPage extends Serializable {

    /**
     * <p>getWidth.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getWidth();

    /**
     * <p>getHeight.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getHeight();

    /**
     * <p>getOrientation.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.PageOrientation} object.
     */
    public PageOrientation getOrientation();

    /**
     * <p>getMargin.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.DRIMargin} object.
     */
    public DRIMargin getMargin();

    /**
     * <p>getColumnsPerPage.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getColumnsPerPage();

    /**
     * <p>getColumnSpace.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getColumnSpace();

    /**
     * <p>getIgnorePageWidth.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnorePageWidth();
}

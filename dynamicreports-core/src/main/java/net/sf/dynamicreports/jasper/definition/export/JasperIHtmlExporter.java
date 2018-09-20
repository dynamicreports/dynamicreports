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
package net.sf.dynamicreports.jasper.definition.export;

import net.sf.dynamicreports.jasper.constant.SizeUnit;

/**
 * <p>JasperIHtmlExporter interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface JasperIHtmlExporter extends JasperIExporter {

    /**
     * <p>getOutputImagesToDir.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getOutputImagesToDir();

    /**
     * <p>getImagesDirName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getImagesDirName();

    /**
     * <p>getImagesURI.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getImagesURI();

    /**
     * <p>getHtmlHeader.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getHtmlHeader();

    /**
     * <p>getBetweenPagesHtml.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBetweenPagesHtml();

    /**
     * <p>getHtmlFooter.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getHtmlFooter();

    /**
     * <p>getRemoveEmptySpaceBetweenRows.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getRemoveEmptySpaceBetweenRows();

    /**
     * <p>getWhitePageBackground.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getWhitePageBackground();

    /**
     * <p>getUsingImagesToAlign.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getUsingImagesToAlign();

    /**
     * <p>getWrapBreakWord.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getWrapBreakWord();

    /**
     * <p>getSizeUnit.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.constant.SizeUnit} object.
     */
    public SizeUnit getSizeUnit();

    /**
     * <p>getFramesAsNestedTables.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getFramesAsNestedTables();

    /**
     * <p>getIgnorePageMargins.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnorePageMargins();

    /**
     * <p>getBorderCollapse.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getBorderCollapse();

    /**
     * <p>getAccessibleHtml.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getAccessibleHtml();

    /**
     * <p>getZoomRatio.</p>
     *
     * @return a {@link java.lang.Float} object.
     */
    public Float getZoomRatio();

    /**
     * <p>getIgnoreHyperLink.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnoreHyperLink();

    /**
     * <p>getFlushOutput.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getFlushOutput();
}

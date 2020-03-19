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
package net.sf.dynamicreports.jasper.definition.export;

import net.sf.dynamicreports.report.constant.ImageAnchorType;
import net.sf.dynamicreports.report.constant.RunDirection;

import java.util.List;
import java.util.Map;

/**
 * <p>JasperIExcelExporter interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface JasperIExcelExporter extends JasperIExporter {

    /**
     * <p>getOnePagePerSheet.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getOnePagePerSheet();

    /**
     * <p>getRemoveEmptySpaceBetweenRows.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getRemoveEmptySpaceBetweenRows();

    /**
     * <p>getRemoveEmptySpaceBetweenColumns.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getRemoveEmptySpaceBetweenColumns();

    /**
     * <p>getWhitePageBackground.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getWhitePageBackground();

    /**
     * <p>getDetectCellType.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getDetectCellType();

    /**
     * <p>getSheetNames.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<String> getSheetNames();

    /**
     * <p>getFontSizeFixEnabled.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getFontSizeFixEnabled();

    /**
     * <p>getImageBorderFixEnabled.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getImageBorderFixEnabled();

    /**
     * <p>getMaxRowsPerSheet.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getMaxRowsPerSheet();

    /**
     * <p>getIgnoreGraphics.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnoreGraphics();

    /**
     * <p>getCollapseRowSpan.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getCollapseRowSpan();

    /**
     * <p>getIgnoreCellBorder.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnoreCellBorder();

    /**
     * <p>getIgnoreCellBackground.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnoreCellBackground();

    /**
     * <p>getPassword.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPassword();

    /**
     * <p>getIgnorePageMargins.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnorePageMargins();

    /**
     * <p>getWrapText.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getWrapText();

    /**
     * <p>getCellLocked.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getCellLocked();

    /**
     * <p>getCellHidden.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getCellHidden();

    /**
     * <p>getSheetHeaderLeft.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSheetHeaderLeft();

    /**
     * <p>getSheetHeaderCenter.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSheetHeaderCenter();

    /**
     * <p>getSheetHeaderRight.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSheetHeaderRight();

    /**
     * <p>getSheetFooterLeft.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSheetFooterLeft();

    /**
     * <p>getSheetFooterCenter.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSheetFooterCenter();

    /**
     * <p>getSheetFooterRight.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSheetFooterRight();

    /**
     * <p>getFormatPatternsMap.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, String> getFormatPatternsMap();

    /**
     * <p>getIgnoreHyperLink.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnoreHyperLink();

    /**
     * <p>getIgnoreAnchors.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnoreAnchors();

    /**
     * <p>getFitWidth.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getFitWidth();

    /**
     * <p>getFitHeight.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getFitHeight();

    /**
     * <p>getPageScale.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getPageScale();

    /**
     * <p>getSheetDirection.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.RunDirection} object.
     */
    public RunDirection getSheetDirection();

    /**
     * <p>getColumnWidthRatio.</p>
     *
     * @return a {@link java.lang.Float} object.
     */
    public Float getColumnWidthRatio();

    /**
     * <p>getUseTimeZone.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getUseTimeZone();

    /**
     * <p>getFirstPageNumber.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getFirstPageNumber();

    /**
     * <p>getShowGridLines.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getShowGridLines();

    /**
     * <p>getImageAnchorType.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.ImageAnchorType} object.
     */
    public ImageAnchorType getImageAnchorType();

    /**
     * <p>getCreateCustomPalette.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getCreateCustomPalette();

    /**
     * <p>getWorkbookTemplate.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getWorkbookTemplate();

    /**
     * <p>getKeepWorkbookTemplateSheets.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getKeepWorkbookTemplateSheets();
}

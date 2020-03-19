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
package net.sf.dynamicreports.jasper.base.export;

import net.sf.dynamicreports.jasper.definition.export.JasperIExcelExporter;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ImageAnchorType;
import net.sf.dynamicreports.report.constant.RunDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Abstract AbstractJasperExcelExporter class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public abstract class AbstractJasperExcelExporter extends AbstractJasperExporter implements JasperIExcelExporter {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Boolean onePagePerSheet;
    private Boolean removeEmptySpaceBetweenRows;
    private Boolean removeEmptySpaceBetweenColumns;
    private Boolean whitePageBackground;
    private Boolean detectCellType;
    private List<String> sheetNames;
    private Boolean fontSizeFixEnabled;
    private Boolean imageBorderFixEnabled;
    private Integer maxRowsPerSheet;
    private Boolean ignoreGraphics;
    private Boolean collapseRowSpan;
    private Boolean ignoreCellBorder;
    private Boolean ignoreCellBackground;
    private String password;
    private Boolean ignorePageMargins;
    private Boolean wrapText;
    private Boolean cellLocked;
    private Boolean cellHidden;
    private String sheetHeaderLeft;
    private String sheetHeaderCenter;
    private String sheetHeaderRight;
    private String sheetFooterLeft;
    private String sheetFooterCenter;
    private String sheetFooterRight;
    private Map<String, String> formatPatternsMap;
    private Boolean ignoreHyperLink;
    private Boolean ignoreAnchors;
    private Integer fitWidth;
    private Integer fitHeight;
    private Integer pageScale;
    private RunDirection sheetDirection;
    private Float columnWidthRatio;
    private Boolean useTimeZone;
    private Integer firstPageNumber;
    private Boolean showGridLines;
    private ImageAnchorType imageAnchorType;
    private Boolean createCustomPalette;
    private String workbookTemplate;
    private Boolean keepWorkbookTemplateSheets;

    /**
     * <p>Constructor for AbstractJasperExcelExporter.</p>
     */
    public AbstractJasperExcelExporter() {
        this.sheetNames = new ArrayList<String>();
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getOnePagePerSheet() {
        return onePagePerSheet;
    }

    /**
     * <p>Setter for the field <code>onePagePerSheet</code>.</p>
     *
     * @param onePagePerSheet a {@link java.lang.Boolean} object.
     */
    public void setOnePagePerSheet(Boolean onePagePerSheet) {
        this.onePagePerSheet = onePagePerSheet;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getRemoveEmptySpaceBetweenRows() {
        return removeEmptySpaceBetweenRows;
    }

    /**
     * <p>Setter for the field <code>removeEmptySpaceBetweenRows</code>.</p>
     *
     * @param removeEmptySpaceBetweenRows a {@link java.lang.Boolean} object.
     */
    public void setRemoveEmptySpaceBetweenRows(Boolean removeEmptySpaceBetweenRows) {
        this.removeEmptySpaceBetweenRows = removeEmptySpaceBetweenRows;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getRemoveEmptySpaceBetweenColumns() {
        return removeEmptySpaceBetweenColumns;
    }

    /**
     * <p>Setter for the field <code>removeEmptySpaceBetweenColumns</code>.</p>
     *
     * @param removeEmptySpaceBetweenColumns a {@link java.lang.Boolean} object.
     */
    public void setRemoveEmptySpaceBetweenColumns(Boolean removeEmptySpaceBetweenColumns) {
        this.removeEmptySpaceBetweenColumns = removeEmptySpaceBetweenColumns;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getWhitePageBackground() {
        return whitePageBackground;
    }

    /**
     * <p>Setter for the field <code>whitePageBackground</code>.</p>
     *
     * @param whitePageBackground a {@link java.lang.Boolean} object.
     */
    public void setWhitePageBackground(Boolean whitePageBackground) {
        this.whitePageBackground = whitePageBackground;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getDetectCellType() {
        return detectCellType;
    }

    /**
     * <p>Setter for the field <code>detectCellType</code>.</p>
     *
     * @param detectCellType a {@link java.lang.Boolean} object.
     */
    public void setDetectCellType(Boolean detectCellType) {
        this.detectCellType = detectCellType;
    }

    /** {@inheritDoc} */
    @Override
    public List<String> getSheetNames() {
        return sheetNames;
    }

    /**
     * <p>Setter for the field <code>sheetNames</code>.</p>
     *
     * @param sheetNames a {@link java.util.List} object.
     */
    public void setSheetNames(List<String> sheetNames) {
        this.sheetNames = sheetNames;
    }

    /**
     * <p>addSheetName.</p>
     *
     * @param sheetName a {@link java.lang.String} object.
     */
    public void addSheetName(String sheetName) {
        this.sheetNames.add(sheetName);
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getFontSizeFixEnabled() {
        return fontSizeFixEnabled;
    }

    /**
     * <p>Setter for the field <code>fontSizeFixEnabled</code>.</p>
     *
     * @param fontSizeFixEnabled a {@link java.lang.Boolean} object.
     */
    public void setFontSizeFixEnabled(Boolean fontSizeFixEnabled) {
        this.fontSizeFixEnabled = fontSizeFixEnabled;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getImageBorderFixEnabled() {
        return imageBorderFixEnabled;
    }

    /**
     * <p>Setter for the field <code>imageBorderFixEnabled</code>.</p>
     *
     * @param imageBorderFixEnabled a {@link java.lang.Boolean} object.
     */
    public void setImageBorderFixEnabled(Boolean imageBorderFixEnabled) {
        this.imageBorderFixEnabled = imageBorderFixEnabled;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getMaxRowsPerSheet() {
        return maxRowsPerSheet;
    }

    /**
     * <p>Setter for the field <code>maxRowsPerSheet</code>.</p>
     *
     * @param maxRowsPerSheet a {@link java.lang.Integer} object.
     */
    public void setMaxRowsPerSheet(Integer maxRowsPerSheet) {
        this.maxRowsPerSheet = maxRowsPerSheet;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getIgnoreGraphics() {
        return ignoreGraphics;
    }

    /**
     * <p>Setter for the field <code>ignoreGraphics</code>.</p>
     *
     * @param ignoreGraphics a {@link java.lang.Boolean} object.
     */
    public void setIgnoreGraphics(Boolean ignoreGraphics) {
        this.ignoreGraphics = ignoreGraphics;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getCollapseRowSpan() {
        return collapseRowSpan;
    }

    /**
     * <p>Setter for the field <code>collapseRowSpan</code>.</p>
     *
     * @param collapseRowSpan a {@link java.lang.Boolean} object.
     */
    public void setCollapseRowSpan(Boolean collapseRowSpan) {
        this.collapseRowSpan = collapseRowSpan;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getIgnoreCellBorder() {
        return ignoreCellBorder;
    }

    /**
     * <p>Setter for the field <code>ignoreCellBorder</code>.</p>
     *
     * @param ignoreCellBorder a {@link java.lang.Boolean} object.
     */
    public void setIgnoreCellBorder(Boolean ignoreCellBorder) {
        this.ignoreCellBorder = ignoreCellBorder;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getIgnoreCellBackground() {
        return ignoreCellBackground;
    }

    /**
     * <p>Setter for the field <code>ignoreCellBackground</code>.</p>
     *
     * @param ignoreCellBackground a {@link java.lang.Boolean} object.
     */
    public void setIgnoreCellBackground(Boolean ignoreCellBackground) {
        this.ignoreCellBackground = ignoreCellBackground;
    }

    /** {@inheritDoc} */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * <p>Setter for the field <code>password</code>.</p>
     *
     * @param password a {@link java.lang.String} object.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getIgnorePageMargins() {
        return ignorePageMargins;
    }

    /**
     * <p>Setter for the field <code>ignorePageMargins</code>.</p>
     *
     * @param ignorePageMargins a {@link java.lang.Boolean} object.
     */
    public void setIgnorePageMargins(Boolean ignorePageMargins) {
        this.ignorePageMargins = ignorePageMargins;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getWrapText() {
        return wrapText;
    }

    /**
     * <p>Setter for the field <code>wrapText</code>.</p>
     *
     * @param wrapText a {@link java.lang.Boolean} object.
     */
    public void setWrapText(Boolean wrapText) {
        this.wrapText = wrapText;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getCellLocked() {
        return cellLocked;
    }

    /**
     * <p>Setter for the field <code>cellLocked</code>.</p>
     *
     * @param cellLocked a {@link java.lang.Boolean} object.
     */
    public void setCellLocked(Boolean cellLocked) {
        this.cellLocked = cellLocked;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getCellHidden() {
        return cellHidden;
    }

    /**
     * <p>Setter for the field <code>cellHidden</code>.</p>
     *
     * @param cellHidden a {@link java.lang.Boolean} object.
     */
    public void setCellHidden(Boolean cellHidden) {
        this.cellHidden = cellHidden;
    }

    /** {@inheritDoc} */
    @Override
    public String getSheetHeaderLeft() {
        return sheetHeaderLeft;
    }

    /**
     * <p>Setter for the field <code>sheetHeaderLeft</code>.</p>
     *
     * @param sheetHeaderLeft a {@link java.lang.String} object.
     */
    public void setSheetHeaderLeft(String sheetHeaderLeft) {
        this.sheetHeaderLeft = sheetHeaderLeft;
    }

    /** {@inheritDoc} */
    @Override
    public String getSheetHeaderCenter() {
        return sheetHeaderCenter;
    }

    /**
     * <p>Setter for the field <code>sheetHeaderCenter</code>.</p>
     *
     * @param sheetHeaderCenter a {@link java.lang.String} object.
     */
    public void setSheetHeaderCenter(String sheetHeaderCenter) {
        this.sheetHeaderCenter = sheetHeaderCenter;
    }

    /** {@inheritDoc} */
    @Override
    public String getSheetHeaderRight() {
        return sheetHeaderRight;
    }

    /**
     * <p>Setter for the field <code>sheetHeaderRight</code>.</p>
     *
     * @param sheetHeaderRight a {@link java.lang.String} object.
     */
    public void setSheetHeaderRight(String sheetHeaderRight) {
        this.sheetHeaderRight = sheetHeaderRight;
    }

    /** {@inheritDoc} */
    @Override
    public String getSheetFooterLeft() {
        return sheetFooterLeft;
    }

    /**
     * <p>Setter for the field <code>sheetFooterLeft</code>.</p>
     *
     * @param sheetFooterLeft a {@link java.lang.String} object.
     */
    public void setSheetFooterLeft(String sheetFooterLeft) {
        this.sheetFooterLeft = sheetFooterLeft;
    }

    /** {@inheritDoc} */
    @Override
    public String getSheetFooterCenter() {
        return sheetFooterCenter;
    }

    /**
     * <p>Setter for the field <code>sheetFooterCenter</code>.</p>
     *
     * @param sheetFooterCenter a {@link java.lang.String} object.
     */
    public void setSheetFooterCenter(String sheetFooterCenter) {
        this.sheetFooterCenter = sheetFooterCenter;
    }

    /** {@inheritDoc} */
    @Override
    public String getSheetFooterRight() {
        return sheetFooterRight;
    }

    /**
     * <p>Setter for the field <code>sheetFooterRight</code>.</p>
     *
     * @param sheetFooterRight a {@link java.lang.String} object.
     */
    public void setSheetFooterRight(String sheetFooterRight) {
        this.sheetFooterRight = sheetFooterRight;
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, String> getFormatPatternsMap() {
        return formatPatternsMap;
    }

    /**
     * <p>Setter for the field <code>formatPatternsMap</code>.</p>
     *
     * @param formatPatternsMap a {@link java.util.Map} object.
     */
    public void setFormatPatternsMap(Map<String, String> formatPatternsMap) {
        this.formatPatternsMap = formatPatternsMap;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getIgnoreHyperLink() {
        return ignoreHyperLink;
    }

    /**
     * <p>Setter for the field <code>ignoreHyperLink</code>.</p>
     *
     * @param ignoreHyperLink a {@link java.lang.Boolean} object.
     */
    public void setIgnoreHyperLink(Boolean ignoreHyperLink) {
        this.ignoreHyperLink = ignoreHyperLink;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getIgnoreAnchors() {
        return ignoreAnchors;
    }

    /**
     * <p>Setter for the field <code>ignoreAnchors</code>.</p>
     *
     * @param ignoreAnchors a {@link java.lang.Boolean} object.
     */
    public void setIgnoreAnchors(Boolean ignoreAnchors) {
        this.ignoreAnchors = ignoreAnchors;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getFitWidth() {
        return fitWidth;
    }

    /**
     * <p>Setter for the field <code>fitWidth</code>.</p>
     *
     * @param fitWidth a {@link java.lang.Integer} object.
     */
    public void setFitWidth(Integer fitWidth) {
        this.fitWidth = fitWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getFitHeight() {
        return fitHeight;
    }

    /**
     * <p>Setter for the field <code>fitHeight</code>.</p>
     *
     * @param fitHeight a {@link java.lang.Integer} object.
     */
    public void setFitHeight(Integer fitHeight) {
        this.fitHeight = fitHeight;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageScale() {
        return pageScale;
    }

    /**
     * <p>Setter for the field <code>pageScale</code>.</p>
     *
     * @param pageScale a {@link java.lang.Integer} object.
     */
    public void setPageScale(Integer pageScale) {
        this.pageScale = pageScale;
    }

    /** {@inheritDoc} */
    @Override
    public RunDirection getSheetDirection() {
        return sheetDirection;
    }

    /**
     * <p>Setter for the field <code>sheetDirection</code>.</p>
     *
     * @param sheetDirection a {@link net.sf.dynamicreports.report.constant.RunDirection} object.
     */
    public void setSheetDirection(RunDirection sheetDirection) {
        this.sheetDirection = sheetDirection;
    }

    /** {@inheritDoc} */
    @Override
    public Float getColumnWidthRatio() {
        return columnWidthRatio;
    }

    /**
     * <p>Setter for the field <code>columnWidthRatio</code>.</p>
     *
     * @param columnWidthRatio a {@link java.lang.Float} object.
     */
    public void setColumnWidthRatio(Float columnWidthRatio) {
        this.columnWidthRatio = columnWidthRatio;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getUseTimeZone() {
        return useTimeZone;
    }

    /**
     * <p>Setter for the field <code>useTimeZone</code>.</p>
     *
     * @param useTimeZone a {@link java.lang.Boolean} object.
     */
    public void setUseTimeZone(Boolean useTimeZone) {
        this.useTimeZone = useTimeZone;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getFirstPageNumber() {
        return firstPageNumber;
    }

    /**
     * <p>Setter for the field <code>firstPageNumber</code>.</p>
     *
     * @param firstPageNumber a {@link java.lang.Integer} object.
     */
    public void setFirstPageNumber(Integer firstPageNumber) {
        this.firstPageNumber = firstPageNumber;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getShowGridLines() {
        return showGridLines;
    }

    /**
     * <p>Setter for the field <code>showGridLines</code>.</p>
     *
     * @param showGridLines a {@link java.lang.Boolean} object.
     */
    public void setShowGridLines(Boolean showGridLines) {
        this.showGridLines = showGridLines;
    }

    /** {@inheritDoc} */
    @Override
    public ImageAnchorType getImageAnchorType() {
        return imageAnchorType;
    }

    /**
     * <p>Setter for the field <code>imageAnchorType</code>.</p>
     *
     * @param imageAnchorType a {@link net.sf.dynamicreports.report.constant.ImageAnchorType} object.
     */
    public void setImageAnchorType(ImageAnchorType imageAnchorType) {
        this.imageAnchorType = imageAnchorType;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getCreateCustomPalette() {
        return createCustomPalette;
    }

    /**
     * <p>Setter for the field <code>createCustomPalette</code>.</p>
     *
     * @param createCustomPalette a {@link java.lang.Boolean} object.
     */
    public void setCreateCustomPalette(Boolean createCustomPalette) {
        this.createCustomPalette = createCustomPalette;
    }

    /** {@inheritDoc} */
    @Override
    public String getWorkbookTemplate() {
        return workbookTemplate;
    }

    /**
     * <p>Setter for the field <code>workbookTemplate</code>.</p>
     *
     * @param workbookTemplate a {@link java.lang.String} object.
     */
    public void setWorkbookTemplate(String workbookTemplate) {
        this.workbookTemplate = workbookTemplate;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getKeepWorkbookTemplateSheets() {
        return keepWorkbookTemplateSheets;
    }

    /**
     * <p>Setter for the field <code>keepWorkbookTemplateSheets</code>.</p>
     *
     * @param keepWorkbookTemplateSheets a {@link java.lang.Boolean} object.
     */
    public void setKeepWorkbookTemplateSheets(Boolean keepWorkbookTemplateSheets) {
        this.keepWorkbookTemplateSheets = keepWorkbookTemplateSheets;
    }

}

/**
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

package net.sf.dynamicreports.jasper.base.export;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.dynamicreports.jasper.definition.export.JasperIExcelExporter;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ImageAnchorType;
import net.sf.dynamicreports.report.constant.RunDirection;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
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

	public AbstractJasperExcelExporter() {
		this.sheetNames = new ArrayList<String>();
	}

	@Override
	public Boolean getOnePagePerSheet() {
		return onePagePerSheet;
	}

	public void setOnePagePerSheet(Boolean onePagePerSheet) {
		this.onePagePerSheet = onePagePerSheet;
	}

	@Override
	public Boolean getRemoveEmptySpaceBetweenRows() {
		return removeEmptySpaceBetweenRows;
	}

	public void setRemoveEmptySpaceBetweenRows(Boolean removeEmptySpaceBetweenRows) {
		this.removeEmptySpaceBetweenRows = removeEmptySpaceBetweenRows;
	}

	@Override
	public Boolean getRemoveEmptySpaceBetweenColumns() {
		return removeEmptySpaceBetweenColumns;
	}

	public void setRemoveEmptySpaceBetweenColumns(Boolean removeEmptySpaceBetweenColumns) {
		this.removeEmptySpaceBetweenColumns = removeEmptySpaceBetweenColumns;
	}

	@Override
	public Boolean getWhitePageBackground() {
		return whitePageBackground;
	}

	public void setWhitePageBackground(Boolean whitePageBackground) {
		this.whitePageBackground = whitePageBackground;
	}

	@Override
	public Boolean getDetectCellType() {
		return detectCellType;
	}

	public void setDetectCellType(Boolean detectCellType) {
		this.detectCellType = detectCellType;
	}

	@Override
	public List<String> getSheetNames() {
		return sheetNames;
	}

	public void setSheetNames(List<String> sheetNames) {
		this.sheetNames = sheetNames;
	}

	public void addSheetName(String sheetName) {
		this.sheetNames.add(sheetName);
	}

	@Override
	public Boolean getFontSizeFixEnabled() {
		return fontSizeFixEnabled;
	}

	public void setFontSizeFixEnabled(Boolean fontSizeFixEnabled) {
		this.fontSizeFixEnabled = fontSizeFixEnabled;
	}

	@Override
	public Boolean getImageBorderFixEnabled() {
		return imageBorderFixEnabled;
	}

	public void setImageBorderFixEnabled(Boolean imageBorderFixEnabled) {
		this.imageBorderFixEnabled = imageBorderFixEnabled;
	}

	@Override
	public Integer getMaxRowsPerSheet() {
		return maxRowsPerSheet;
	}

	public void setMaxRowsPerSheet(Integer maxRowsPerSheet) {
		this.maxRowsPerSheet = maxRowsPerSheet;
	}

	@Override
	public Boolean getIgnoreGraphics() {
		return ignoreGraphics;
	}

	public void setIgnoreGraphics(Boolean ignoreGraphics) {
		this.ignoreGraphics = ignoreGraphics;
	}

	@Override
	public Boolean getCollapseRowSpan() {
		return collapseRowSpan;
	}

	public void setCollapseRowSpan(Boolean collapseRowSpan) {
		this.collapseRowSpan = collapseRowSpan;
	}

	@Override
	public Boolean getIgnoreCellBorder() {
		return ignoreCellBorder;
	}

	public void setIgnoreCellBorder(Boolean ignoreCellBorder) {
		this.ignoreCellBorder = ignoreCellBorder;
	}

	@Override
	public Boolean getIgnoreCellBackground() {
		return ignoreCellBackground;
	}

	public void setIgnoreCellBackground(Boolean ignoreCellBackground) {
		this.ignoreCellBackground = ignoreCellBackground;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Boolean getIgnorePageMargins() {
		return ignorePageMargins;
	}

	public void setIgnorePageMargins(Boolean ignorePageMargins) {
		this.ignorePageMargins = ignorePageMargins;
	}

	@Override
	public Boolean getWrapText() {
		return wrapText;
	}

	public void setWrapText(Boolean wrapText) {
		this.wrapText = wrapText;
	}

	@Override
	public Boolean getCellLocked() {
		return cellLocked;
	}

	public void setCellLocked(Boolean cellLocked) {
		this.cellLocked = cellLocked;
	}

	@Override
	public Boolean getCellHidden() {
		return cellHidden;
	}

	public void setCellHidden(Boolean cellHidden) {
		this.cellHidden = cellHidden;
	}

	@Override
	public String getSheetHeaderLeft() {
		return sheetHeaderLeft;
	}

	public void setSheetHeaderLeft(String sheetHeaderLeft) {
		this.sheetHeaderLeft = sheetHeaderLeft;
	}

	@Override
	public String getSheetHeaderCenter() {
		return sheetHeaderCenter;
	}

	public void setSheetHeaderCenter(String sheetHeaderCenter) {
		this.sheetHeaderCenter = sheetHeaderCenter;
	}

	@Override
	public String getSheetHeaderRight() {
		return sheetHeaderRight;
	}

	public void setSheetHeaderRight(String sheetHeaderRight) {
		this.sheetHeaderRight = sheetHeaderRight;
	}

	@Override
	public String getSheetFooterLeft() {
		return sheetFooterLeft;
	}

	public void setSheetFooterLeft(String sheetFooterLeft) {
		this.sheetFooterLeft = sheetFooterLeft;
	}

	@Override
	public String getSheetFooterCenter() {
		return sheetFooterCenter;
	}

	public void setSheetFooterCenter(String sheetFooterCenter) {
		this.sheetFooterCenter = sheetFooterCenter;
	}

	@Override
	public String getSheetFooterRight() {
		return sheetFooterRight;
	}

	public void setSheetFooterRight(String sheetFooterRight) {
		this.sheetFooterRight = sheetFooterRight;
	}

	@Override
	public Map<String, String> getFormatPatternsMap() {
		return formatPatternsMap;
	}

	public void setFormatPatternsMap(Map<String, String> formatPatternsMap) {
		this.formatPatternsMap = formatPatternsMap;
	}

	@Override
	public Boolean getIgnoreHyperLink() {
		return ignoreHyperLink;
	}

	public void setIgnoreHyperLink(Boolean ignoreHyperLink) {
		this.ignoreHyperLink = ignoreHyperLink;
	}

	@Override
	public Boolean getIgnoreAnchors() {
		return ignoreAnchors;
	}

	public void setIgnoreAnchors(Boolean ignoreAnchors) {
		this.ignoreAnchors = ignoreAnchors;
	}

	@Override
	public Integer getFitWidth() {
		return fitWidth;
	}

	public void setFitWidth(Integer fitWidth) {
		this.fitWidth = fitWidth;
	}

	@Override
	public Integer getFitHeight() {
		return fitHeight;
	}

	public void setFitHeight(Integer fitHeight) {
		this.fitHeight = fitHeight;
	}

	@Override
	public Integer getPageScale() {
		return pageScale;
	}

	public void setPageScale(Integer pageScale) {
		this.pageScale = pageScale;
	}

	@Override
	public RunDirection getSheetDirection() {
		return sheetDirection;
	}

	public void setSheetDirection(RunDirection sheetDirection) {
		this.sheetDirection = sheetDirection;
	}

	@Override
	public Float getColumnWidthRatio() {
		return columnWidthRatio;
	}

	public void setColumnWidthRatio(Float columnWidthRatio) {
		this.columnWidthRatio = columnWidthRatio;
	}

	@Override
	public Boolean getUseTimeZone() {
		return useTimeZone;
	}

	public void setUseTimeZone(Boolean useTimeZone) {
		this.useTimeZone = useTimeZone;
	}

	@Override
	public Integer getFirstPageNumber() {
		return firstPageNumber;
	}

	public void setFirstPageNumber(Integer firstPageNumber) {
		this.firstPageNumber = firstPageNumber;
	}

	@Override
	public Boolean getShowGridLines() {
		return showGridLines;
	}

	public void setShowGridLines(Boolean showGridLines) {
		this.showGridLines = showGridLines;
	}

	@Override
	public ImageAnchorType getImageAnchorType() {
		return imageAnchorType;
	}

	public void setImageAnchorType(ImageAnchorType imageAnchorType) {
		this.imageAnchorType = imageAnchorType;
	}

	@Override
	public Boolean getCreateCustomPalette() {
		return createCustomPalette;
	}

	public void setCreateCustomPalette(Boolean createCustomPalette) {
		this.createCustomPalette = createCustomPalette;
	}

	@Override
	public String getWorkbookTemplate() {
		return workbookTemplate;
	}

	public void setWorkbookTemplate(String workbookTemplate) {
		this.workbookTemplate = workbookTemplate;
	}

	@Override
	public Boolean getKeepWorkbookTemplateSheets() {
		return keepWorkbookTemplateSheets;
	}

	public void setKeepWorkbookTemplateSheets(Boolean keepWorkbookTemplateSheets) {
		this.keepWorkbookTemplateSheets = keepWorkbookTemplateSheets;
	}

}

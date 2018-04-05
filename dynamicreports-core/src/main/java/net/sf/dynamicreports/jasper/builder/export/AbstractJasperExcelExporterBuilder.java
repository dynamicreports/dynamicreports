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

package net.sf.dynamicreports.jasper.builder.export;

import java.util.Map;

import net.sf.dynamicreports.jasper.base.export.AbstractJasperExcelExporter;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.ImageAnchorType;
import net.sf.dynamicreports.report.constant.RunDirection;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings("unchecked")
public abstract class AbstractJasperExcelExporterBuilder<T extends AbstractJasperExcelExporterBuilder<T, U>, U extends AbstractJasperExcelExporter>
		extends AbstractJasperExporterBuilder<T, U> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected AbstractJasperExcelExporterBuilder(U exporter) {
		super(exporter);
	}

	public T setOnePagePerSheet(Boolean onePagePerSheet) {
		this.getObject().setOnePagePerSheet(onePagePerSheet);
		return (T) this;
	}

	public T setRemoveEmptySpaceBetweenRows(Boolean removeEmptySpaceBetweenRows) {
		this.getObject().setRemoveEmptySpaceBetweenRows(removeEmptySpaceBetweenRows);
		return (T) this;
	}

	public T setRemoveEmptySpaceBetweenColumns(Boolean removeEmptySpaceBetweenColumns) {
		this.getObject().setRemoveEmptySpaceBetweenColumns(removeEmptySpaceBetweenColumns);
		return (T) this;
	}

	public T setWhitePageBackground(Boolean whitePageBackground) {
		this.getObject().setWhitePageBackground(whitePageBackground);
		return (T) this;
	}

	public T setDetectCellType(Boolean detectCellType) {
		this.getObject().setDetectCellType(detectCellType);
		return (T) this;
	}

	public T sheetNames(String... sheetNames) {
		return addSheetName(sheetNames);
	}

	public T addSheetName(String... sheetNames) {
		Validate.notNull(sheetNames, "sheetNames must not be null");
		Validate.noNullElements(sheetNames, "sheetNames must not contains null sheetName");
		for (String sheetName : sheetNames) {
			this.getObject().addSheetName(sheetName);
		}
		return (T) this;
	}

	public T setFontSizeFixEnabled(Boolean fontSizeFixEnabled) {
		this.getObject().setFontSizeFixEnabled(fontSizeFixEnabled);
		return (T) this;
	}

	public T setImageBorderFixEnabled(Boolean imageBorderFixEnabled) {
		this.getObject().setImageBorderFixEnabled(imageBorderFixEnabled);
		return (T) this;
	}

	public T setMaxRowsPerSheet(Integer maxRowsPerSheet) {
		this.getObject().setMaxRowsPerSheet(maxRowsPerSheet);
		return (T) this;
	}

	public T setIgnoreGraphics(Boolean ignoreGraphics) {
		this.getObject().setIgnoreGraphics(ignoreGraphics);
		return (T) this;
	}

	public T setCollapseRowSpan(Boolean collapseRowSpan) {
		this.getObject().setCollapseRowSpan(collapseRowSpan);
		return (T) this;
	}

	public T setIgnoreCellBorder(Boolean ignoreCellBorder) {
		this.getObject().setIgnoreCellBorder(ignoreCellBorder);
		return (T) this;
	}

	public T setIgnoreCellBackground(Boolean ignoreCellBackground) {
		this.getObject().setIgnoreCellBackground(ignoreCellBackground);
		return (T) this;
	}

	public T setPassword(String password) {
		this.getObject().setPassword(password);
		return (T) this;
	}

	public T setIgnorePageMargins(Boolean ignorePageMargins) {
		this.getObject().setIgnorePageMargins(ignorePageMargins);
		return (T) this;
	}

	public T setWrapText(Boolean wrapText) {
		this.getObject().setWrapText(wrapText);
		return (T) this;
	}

	public T setCellLocked(Boolean cellLocked) {
		this.getObject().setCellLocked(cellLocked);
		return (T) this;
	}

	public T setCellHidden(Boolean cellHidden) {
		this.getObject().setCellHidden(cellHidden);
		return (T) this;
	}

	public T setSheetHeaderLeft(String sheetHeaderLeft) {
		this.getObject().setSheetHeaderLeft(sheetHeaderLeft);
		return (T) this;
	}

	public T setSheetHeaderCenter(String sheetHeaderCenter) {
		this.getObject().setSheetHeaderCenter(sheetHeaderCenter);
		return (T) this;
	}

	public T setSheetHeaderRight(String sheetHeaderRight) {
		this.getObject().setSheetHeaderRight(sheetHeaderRight);
		return (T) this;
	}

	public T setSheetFooterLeft(String sheetFooterLeft) {
		this.getObject().setSheetFooterLeft(sheetFooterLeft);
		return (T) this;
	}

	public T setSheetFooterCenter(String sheetFooterCenter) {
		this.getObject().setSheetFooterCenter(sheetFooterCenter);
		return (T) this;
	}

	public T setSheetFooterRight(String sheetFooterRight) {
		this.getObject().setSheetFooterRight(sheetFooterRight);
		return (T) this;
	}

	public T setFormatPatternsMap(Map<String, String> formatPatternsMap) {
		this.getObject().setFormatPatternsMap(formatPatternsMap);
		return (T) this;
	}

	public T setIgnoreHyperLink(Boolean ignoreHyperLink) {
		this.getObject().setIgnoreHyperLink(ignoreHyperLink);
		return (T) this;
	}

	public T setIgnoreAnchors(Boolean ignoreAnchors) {
		this.getObject().setIgnoreAnchors(ignoreAnchors);
		return (T) this;
	}

	public T setFitWidth(Integer fitWidth) {
		this.getObject().setFitWidth(fitWidth);
		return (T) this;
	}

	public T setFitHeight(Integer fitHeight) {
		this.getObject().setFitHeight(fitHeight);
		return (T) this;
	}

	public T setPageScale(Integer pageScale) {
		this.getObject().setPageScale(pageScale);
		return (T) this;
	}

	public T setSheetDirection(RunDirection sheetDirection) {
		this.getObject().setSheetDirection(sheetDirection);
		return (T) this;
	}

	public T setColumnWidthRatio(Float columnWidthRatio) {
		this.getObject().setColumnWidthRatio(columnWidthRatio);
		return (T) this;
	}

	public T setUseTimeZone(Boolean useTimeZone) {
		this.getObject().setUseTimeZone(useTimeZone);
		return (T) this;
	}

	public T setFirstPageNumber(Integer firstPageNumber) {
		this.getObject().setFirstPageNumber(firstPageNumber);
		return (T) this;
	}

	public T setShowGridLines(Boolean showGridLines) {
		this.getObject().setShowGridLines(showGridLines);
		return (T) this;
	}

	public T setImageAnchorType(ImageAnchorType imageAnchorType) {
		this.getObject().setImageAnchorType(imageAnchorType);
		return (T) this;
	}

	public T setCreateCustomPalette(Boolean createCustomPalette) {
		this.getObject().setCreateCustomPalette(createCustomPalette);
		return (T) this;
	}

	public T setWorkbookTemplate(String workbookTemplate) {
		this.getObject().setWorkbookTemplate(workbookTemplate);
		return (T) this;
	}

	public T setKeepWorkbookTemplateSheets(Boolean keepWorkbookTemplateSheets) {
		this.getObject().setKeepWorkbookTemplateSheets(keepWorkbookTemplateSheets);
		return (T) this;
	}
}

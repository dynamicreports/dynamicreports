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
 * <p>Abstract AbstractJasperExcelExporterBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
@SuppressWarnings("unchecked")
public abstract class AbstractJasperExcelExporterBuilder<T extends AbstractJasperExcelExporterBuilder<T, U>, U extends AbstractJasperExcelExporter>
		extends AbstractJasperExporterBuilder<T, U> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	/**
	 * <p>Constructor for AbstractJasperExcelExporterBuilder.</p>
	 *
	 * @param exporter a U object.
	 */
	protected AbstractJasperExcelExporterBuilder(U exporter) {
		super(exporter);
	}

	/**
	 * <p>setOnePagePerSheet.</p>
	 *
	 * @param onePagePerSheet a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setOnePagePerSheet(Boolean onePagePerSheet) {
		this.getObject().setOnePagePerSheet(onePagePerSheet);
		return (T) this;
	}

	/**
	 * <p>setRemoveEmptySpaceBetweenRows.</p>
	 *
	 * @param removeEmptySpaceBetweenRows a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setRemoveEmptySpaceBetweenRows(Boolean removeEmptySpaceBetweenRows) {
		this.getObject().setRemoveEmptySpaceBetweenRows(removeEmptySpaceBetweenRows);
		return (T) this;
	}

	/**
	 * <p>setRemoveEmptySpaceBetweenColumns.</p>
	 *
	 * @param removeEmptySpaceBetweenColumns a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setRemoveEmptySpaceBetweenColumns(Boolean removeEmptySpaceBetweenColumns) {
		this.getObject().setRemoveEmptySpaceBetweenColumns(removeEmptySpaceBetweenColumns);
		return (T) this;
	}

	/**
	 * <p>setWhitePageBackground.</p>
	 *
	 * @param whitePageBackground a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setWhitePageBackground(Boolean whitePageBackground) {
		this.getObject().setWhitePageBackground(whitePageBackground);
		return (T) this;
	}

	/**
	 * <p>setDetectCellType.</p>
	 *
	 * @param detectCellType a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setDetectCellType(Boolean detectCellType) {
		this.getObject().setDetectCellType(detectCellType);
		return (T) this;
	}

	/**
	 * <p>sheetNames.</p>
	 *
	 * @param sheetNames a {@link java.lang.String} object.
	 * @return a T object.
	 */
	public T sheetNames(String... sheetNames) {
		return addSheetName(sheetNames);
	}

	/**
	 * <p>addSheetName.</p>
	 *
	 * @param sheetNames a {@link java.lang.String} object.
	 * @return a T object.
	 */
	public T addSheetName(String... sheetNames) {
		Validate.notNull(sheetNames, "sheetNames must not be null");
		Validate.noNullElements(sheetNames, "sheetNames must not contains null sheetName");
		for (String sheetName : sheetNames) {
			this.getObject().addSheetName(sheetName);
		}
		return (T) this;
	}

	/**
	 * <p>setFontSizeFixEnabled.</p>
	 *
	 * @param fontSizeFixEnabled a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setFontSizeFixEnabled(Boolean fontSizeFixEnabled) {
		this.getObject().setFontSizeFixEnabled(fontSizeFixEnabled);
		return (T) this;
	}

	/**
	 * <p>setImageBorderFixEnabled.</p>
	 *
	 * @param imageBorderFixEnabled a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setImageBorderFixEnabled(Boolean imageBorderFixEnabled) {
		this.getObject().setImageBorderFixEnabled(imageBorderFixEnabled);
		return (T) this;
	}

	/**
	 * <p>setMaxRowsPerSheet.</p>
	 *
	 * @param maxRowsPerSheet a {@link java.lang.Integer} object.
	 * @return a T object.
	 */
	public T setMaxRowsPerSheet(Integer maxRowsPerSheet) {
		this.getObject().setMaxRowsPerSheet(maxRowsPerSheet);
		return (T) this;
	}

	/**
	 * <p>setIgnoreGraphics.</p>
	 *
	 * @param ignoreGraphics a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setIgnoreGraphics(Boolean ignoreGraphics) {
		this.getObject().setIgnoreGraphics(ignoreGraphics);
		return (T) this;
	}

	/**
	 * <p>setCollapseRowSpan.</p>
	 *
	 * @param collapseRowSpan a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setCollapseRowSpan(Boolean collapseRowSpan) {
		this.getObject().setCollapseRowSpan(collapseRowSpan);
		return (T) this;
	}

	/**
	 * <p>setIgnoreCellBorder.</p>
	 *
	 * @param ignoreCellBorder a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setIgnoreCellBorder(Boolean ignoreCellBorder) {
		this.getObject().setIgnoreCellBorder(ignoreCellBorder);
		return (T) this;
	}

	/**
	 * <p>setIgnoreCellBackground.</p>
	 *
	 * @param ignoreCellBackground a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setIgnoreCellBackground(Boolean ignoreCellBackground) {
		this.getObject().setIgnoreCellBackground(ignoreCellBackground);
		return (T) this;
	}

	/**
	 * <p>setPassword.</p>
	 *
	 * @param password a {@link java.lang.String} object.
	 * @return a T object.
	 */
	public T setPassword(String password) {
		this.getObject().setPassword(password);
		return (T) this;
	}

	/**
	 * <p>setIgnorePageMargins.</p>
	 *
	 * @param ignorePageMargins a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setIgnorePageMargins(Boolean ignorePageMargins) {
		this.getObject().setIgnorePageMargins(ignorePageMargins);
		return (T) this;
	}

	/**
	 * <p>setWrapText.</p>
	 *
	 * @param wrapText a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setWrapText(Boolean wrapText) {
		this.getObject().setWrapText(wrapText);
		return (T) this;
	}

	/**
	 * <p>setCellLocked.</p>
	 *
	 * @param cellLocked a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setCellLocked(Boolean cellLocked) {
		this.getObject().setCellLocked(cellLocked);
		return (T) this;
	}

	/**
	 * <p>setCellHidden.</p>
	 *
	 * @param cellHidden a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setCellHidden(Boolean cellHidden) {
		this.getObject().setCellHidden(cellHidden);
		return (T) this;
	}

	/**
	 * <p>setSheetHeaderLeft.</p>
	 *
	 * @param sheetHeaderLeft a {@link java.lang.String} object.
	 * @return a T object.
	 */
	public T setSheetHeaderLeft(String sheetHeaderLeft) {
		this.getObject().setSheetHeaderLeft(sheetHeaderLeft);
		return (T) this;
	}

	/**
	 * <p>setSheetHeaderCenter.</p>
	 *
	 * @param sheetHeaderCenter a {@link java.lang.String} object.
	 * @return a T object.
	 */
	public T setSheetHeaderCenter(String sheetHeaderCenter) {
		this.getObject().setSheetHeaderCenter(sheetHeaderCenter);
		return (T) this;
	}

	/**
	 * <p>setSheetHeaderRight.</p>
	 *
	 * @param sheetHeaderRight a {@link java.lang.String} object.
	 * @return a T object.
	 */
	public T setSheetHeaderRight(String sheetHeaderRight) {
		this.getObject().setSheetHeaderRight(sheetHeaderRight);
		return (T) this;
	}

	/**
	 * <p>setSheetFooterLeft.</p>
	 *
	 * @param sheetFooterLeft a {@link java.lang.String} object.
	 * @return a T object.
	 */
	public T setSheetFooterLeft(String sheetFooterLeft) {
		this.getObject().setSheetFooterLeft(sheetFooterLeft);
		return (T) this;
	}

	/**
	 * <p>setSheetFooterCenter.</p>
	 *
	 * @param sheetFooterCenter a {@link java.lang.String} object.
	 * @return a T object.
	 */
	public T setSheetFooterCenter(String sheetFooterCenter) {
		this.getObject().setSheetFooterCenter(sheetFooterCenter);
		return (T) this;
	}

	/**
	 * <p>setSheetFooterRight.</p>
	 *
	 * @param sheetFooterRight a {@link java.lang.String} object.
	 * @return a T object.
	 */
	public T setSheetFooterRight(String sheetFooterRight) {
		this.getObject().setSheetFooterRight(sheetFooterRight);
		return (T) this;
	}

	/**
	 * <p>setFormatPatternsMap.</p>
	 *
	 * @param formatPatternsMap a {@link java.util.Map} object.
	 * @return a T object.
	 */
	public T setFormatPatternsMap(Map<String, String> formatPatternsMap) {
		this.getObject().setFormatPatternsMap(formatPatternsMap);
		return (T) this;
	}

	/**
	 * <p>setIgnoreHyperLink.</p>
	 *
	 * @param ignoreHyperLink a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setIgnoreHyperLink(Boolean ignoreHyperLink) {
		this.getObject().setIgnoreHyperLink(ignoreHyperLink);
		return (T) this;
	}

	/**
	 * <p>setIgnoreAnchors.</p>
	 *
	 * @param ignoreAnchors a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setIgnoreAnchors(Boolean ignoreAnchors) {
		this.getObject().setIgnoreAnchors(ignoreAnchors);
		return (T) this;
	}

	/**
	 * <p>setFitWidth.</p>
	 *
	 * @param fitWidth a {@link java.lang.Integer} object.
	 * @return a T object.
	 */
	public T setFitWidth(Integer fitWidth) {
		this.getObject().setFitWidth(fitWidth);
		return (T) this;
	}

	/**
	 * <p>setFitHeight.</p>
	 *
	 * @param fitHeight a {@link java.lang.Integer} object.
	 * @return a T object.
	 */
	public T setFitHeight(Integer fitHeight) {
		this.getObject().setFitHeight(fitHeight);
		return (T) this;
	}

	/**
	 * <p>setPageScale.</p>
	 *
	 * @param pageScale a {@link java.lang.Integer} object.
	 * @return a T object.
	 */
	public T setPageScale(Integer pageScale) {
		this.getObject().setPageScale(pageScale);
		return (T) this;
	}

	/**
	 * <p>setSheetDirection.</p>
	 *
	 * @param sheetDirection a {@link net.sf.dynamicreports.report.constant.RunDirection} object.
	 * @return a T object.
	 */
	public T setSheetDirection(RunDirection sheetDirection) {
		this.getObject().setSheetDirection(sheetDirection);
		return (T) this;
	}

	/**
	 * <p>setColumnWidthRatio.</p>
	 *
	 * @param columnWidthRatio a {@link java.lang.Float} object.
	 * @return a T object.
	 */
	public T setColumnWidthRatio(Float columnWidthRatio) {
		this.getObject().setColumnWidthRatio(columnWidthRatio);
		return (T) this;
	}

	/**
	 * <p>setUseTimeZone.</p>
	 *
	 * @param useTimeZone a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setUseTimeZone(Boolean useTimeZone) {
		this.getObject().setUseTimeZone(useTimeZone);
		return (T) this;
	}

	/**
	 * <p>setFirstPageNumber.</p>
	 *
	 * @param firstPageNumber a {@link java.lang.Integer} object.
	 * @return a T object.
	 */
	public T setFirstPageNumber(Integer firstPageNumber) {
		this.getObject().setFirstPageNumber(firstPageNumber);
		return (T) this;
	}

	/**
	 * <p>setShowGridLines.</p>
	 *
	 * @param showGridLines a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setShowGridLines(Boolean showGridLines) {
		this.getObject().setShowGridLines(showGridLines);
		return (T) this;
	}

	/**
	 * <p>setImageAnchorType.</p>
	 *
	 * @param imageAnchorType a {@link net.sf.dynamicreports.report.constant.ImageAnchorType} object.
	 * @return a T object.
	 */
	public T setImageAnchorType(ImageAnchorType imageAnchorType) {
		this.getObject().setImageAnchorType(imageAnchorType);
		return (T) this;
	}

	/**
	 * <p>setCreateCustomPalette.</p>
	 *
	 * @param createCustomPalette a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setCreateCustomPalette(Boolean createCustomPalette) {
		this.getObject().setCreateCustomPalette(createCustomPalette);
		return (T) this;
	}

	/**
	 * <p>setWorkbookTemplate.</p>
	 *
	 * @param workbookTemplate a {@link java.lang.String} object.
	 * @return a T object.
	 */
	public T setWorkbookTemplate(String workbookTemplate) {
		this.getObject().setWorkbookTemplate(workbookTemplate);
		return (T) this;
	}

	/**
	 * <p>setKeepWorkbookTemplateSheets.</p>
	 *
	 * @param keepWorkbookTemplateSheets a {@link java.lang.Boolean} object.
	 * @return a T object.
	 */
	public T setKeepWorkbookTemplateSheets(Boolean keepWorkbookTemplateSheets) {
		this.getObject().setKeepWorkbookTemplateSheets(keepWorkbookTemplateSheets);
		return (T) this;
	}
}

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

import net.sf.dynamicreports.jasper.constant.SizeUnit;
import net.sf.dynamicreports.jasper.definition.export.JasperIHtmlExporter;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperHtmlExporter extends AbstractJasperExporter implements JasperIHtmlExporter {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Boolean outputImagesToDir;
	private String imagesDirName;
	private String imagesURI;
	private String htmlHeader;
	private String betweenPagesHtml;
	private String htmlFooter;
	private Boolean removeEmptySpaceBetweenRows;
	private Boolean whitePageBackground;
	private Boolean usingImagesToAlign;
	private Boolean wrapBreakWord;
	private SizeUnit sizeUnit;
	private Boolean framesAsNestedTables;
	private Boolean ignorePageMargins;
	private String borderCollapse;
	private Boolean accessibleHtml;
	private Float zoomRatio;
	private Boolean ignoreHyperLink;
	private Boolean flushOutput;

	@Override
	public Boolean getOutputImagesToDir() {
		return outputImagesToDir;
	}

	public void setOutputImagesToDir(Boolean outputImagesToDir) {
		this.outputImagesToDir = outputImagesToDir;
	}

	@Override
	public String getImagesDirName() {
		return imagesDirName;
	}

	public void setImagesDirName(String imagesDirName) {
		this.imagesDirName = imagesDirName;
	}

	public void setImagesURI(String imagesURI) {
		this.imagesURI = imagesURI;
	}

	@Override
	public String getImagesURI() {
		return imagesURI;
	}

	@Override
	public String getHtmlHeader() {
		return htmlHeader;
	}

	public void setHtmlHeader(String htmlHeader) {
		this.htmlHeader = htmlHeader;
	}

	@Override
	public String getBetweenPagesHtml() {
		return betweenPagesHtml;
	}

	public void setBetweenPagesHtml(String betweenPagesHtml) {
		this.betweenPagesHtml = betweenPagesHtml;
	}

	@Override
	public String getHtmlFooter() {
		return htmlFooter;
	}

	public void setHtmlFooter(String htmlFooter) {
		this.htmlFooter = htmlFooter;
	}

	@Override
	public Boolean getRemoveEmptySpaceBetweenRows() {
		return removeEmptySpaceBetweenRows;
	}

	public void setRemoveEmptySpaceBetweenRows(Boolean removeEmptySpaceBetweenRows) {
		this.removeEmptySpaceBetweenRows = removeEmptySpaceBetweenRows;
	}

	@Override
	public Boolean getWhitePageBackground() {
		return whitePageBackground;
	}

	public void setWhitePageBackground(Boolean whitePageBackground) {
		this.whitePageBackground = whitePageBackground;
	}

	@Override
	public Boolean getUsingImagesToAlign() {
		return usingImagesToAlign;
	}

	public void setUsingImagesToAlign(Boolean usingImagesToAlign) {
		this.usingImagesToAlign = usingImagesToAlign;
	}

	@Override
	public Boolean getWrapBreakWord() {
		return wrapBreakWord;
	}

	public void setWrapBreakWord(Boolean wrapBreakWord) {
		this.wrapBreakWord = wrapBreakWord;
	}

	@Override
	public SizeUnit getSizeUnit() {
		return sizeUnit;
	}

	public void setSizeUnit(SizeUnit sizeUnit) {
		this.sizeUnit = sizeUnit;
	}

	@Override
	public Boolean getFramesAsNestedTables() {
		return framesAsNestedTables;
	}

	public void setFramesAsNestedTables(Boolean framesAsNestedTables) {
		this.framesAsNestedTables = framesAsNestedTables;
	}

	@Override
	public Boolean getIgnorePageMargins() {
		return ignorePageMargins;
	}

	public void setIgnorePageMargins(Boolean ignorePageMargins) {
		this.ignorePageMargins = ignorePageMargins;
	}

	@Override
	public String getBorderCollapse() {
		return borderCollapse;
	}

	public void setBorderCollapse(String borderCollapse) {
		this.borderCollapse = borderCollapse;
	}

	@Override
	public Boolean getAccessibleHtml() {
		return accessibleHtml;
	}

	public void setAccessibleHtml(Boolean accessibleHtml) {
		this.accessibleHtml = accessibleHtml;
	}

	@Override
	public Float getZoomRatio() {
		return zoomRatio;
	}

	public void setZoomRatio(Float zoomRatio) {
		this.zoomRatio = zoomRatio;
	}

	@Override
	public Boolean getIgnoreHyperLink() {
		return ignoreHyperLink;
	}

	public void setIgnoreHyperLink(Boolean ignoreHyperLink) {
		this.ignoreHyperLink = ignoreHyperLink;
	}

	@Override
	public Boolean getFlushOutput() {
		return flushOutput;
	}

	public void setFlushOutput(Boolean flushOutput) {
		this.flushOutput = flushOutput;
	}

}

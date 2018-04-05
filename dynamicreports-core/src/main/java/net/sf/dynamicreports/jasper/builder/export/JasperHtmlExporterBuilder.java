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

import net.sf.dynamicreports.jasper.base.export.JasperHtmlExporter;
import net.sf.dynamicreports.jasper.constant.SizeUnit;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperHtmlExporterBuilder extends AbstractJasperExporterBuilder<JasperHtmlExporterBuilder, JasperHtmlExporter> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected JasperHtmlExporterBuilder() {
		super(new JasperHtmlExporter());
	}

	public JasperHtmlExporterBuilder setOutputImagesToDir(Boolean outputImagesToDir) {
		this.getObject().setOutputImagesToDir(outputImagesToDir);
		return this;
	}

	public JasperHtmlExporterBuilder setImagesDirName(String imagesDirName) {
		this.getObject().setImagesDirName(imagesDirName);
		return this;
	}

	public JasperHtmlExporterBuilder setImagesURI(String imagesURI) {
		this.getObject().setImagesURI(imagesURI);
		return this;
	}

	public JasperHtmlExporterBuilder setHtmlHeader(String htmlHeader) {
		this.getObject().setHtmlHeader(htmlHeader);
		return this;
	}

	public JasperHtmlExporterBuilder setBetweenPagesHtml(String betweenPagesHtml) {
		this.getObject().setBetweenPagesHtml(betweenPagesHtml);
		return this;
	}

	public JasperHtmlExporterBuilder setHtmlFooter(String htmlFooter) {
		this.getObject().setHtmlFooter(htmlFooter);
		return this;
	}

	public JasperHtmlExporterBuilder setRemoveEmptySpaceBetweenRows(Boolean removeEmptySpaceBetweenRows) {
		this.getObject().setRemoveEmptySpaceBetweenRows(removeEmptySpaceBetweenRows);
		return this;
	}

	public JasperHtmlExporterBuilder setWhitePageBackground(Boolean whitePageBackground) {
		this.getObject().setWhitePageBackground(whitePageBackground);
		return this;
	}

	/**
	 * @deprecated To be removed.
	 */
	@Deprecated
	public JasperHtmlExporterBuilder setUsingImagesToAlign(Boolean usingImagesToAlign) {
		this.getObject().setUsingImagesToAlign(usingImagesToAlign);
		return this;
	}

	public JasperHtmlExporterBuilder setWrapBreakWord(Boolean wrapBreakWord) {
		this.getObject().setWrapBreakWord(wrapBreakWord);
		return this;
	}

	public JasperHtmlExporterBuilder setSizeUnit(SizeUnit sizeUnit) {
		this.getObject().setSizeUnit(sizeUnit);
		return this;
	}

	/**
	 * @deprecated To be removed.
	 */
	@Deprecated
	public JasperHtmlExporterBuilder setFramesAsNestedTables(Boolean framesAsNestedTables) {
		this.getObject().setFramesAsNestedTables(framesAsNestedTables);
		return this;
	}

	public JasperHtmlExporterBuilder setIgnorePageMargins(Boolean ignorePageMargins) {
		this.getObject().setIgnorePageMargins(ignorePageMargins);
		return this;
	}

	public JasperHtmlExporterBuilder setBorderCollapse(String borderCollapse) {
		this.getObject().setBorderCollapse(borderCollapse);
		return this;
	}

	public JasperHtmlExporterBuilder setAccessibleHtml(Boolean accessibleHtml) {
		this.getObject().setAccessibleHtml(accessibleHtml);
		return this;
	}

	public JasperHtmlExporterBuilder setZoomRatio(Float zoomRatio) {
		this.getObject().setZoomRatio(zoomRatio);
		return this;
	}

	public JasperHtmlExporterBuilder setIgnoreHyperLink(Boolean ignoreHyperLink) {
		this.getObject().setIgnoreHyperLink(ignoreHyperLink);
		return this;
	}

	public JasperHtmlExporterBuilder setFlushOutput(Boolean flushOutput) {
		this.getObject().setFlushOutput(flushOutput);
		return this;
	}
}

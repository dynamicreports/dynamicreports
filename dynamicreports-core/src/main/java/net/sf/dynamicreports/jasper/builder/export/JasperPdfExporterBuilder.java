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

import net.sf.dynamicreports.jasper.base.export.JasperPdfExporter;
import net.sf.dynamicreports.jasper.constant.PdfPermission;
import net.sf.dynamicreports.jasper.constant.PdfVersion;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.PdfPrintScaling;
import net.sf.dynamicreports.report.constant.PdfaConformance;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperPdfExporterBuilder extends AbstractJasperExporterBuilder<JasperPdfExporterBuilder, JasperPdfExporter> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected JasperPdfExporterBuilder() {
		super(new JasperPdfExporter());
	}

	public JasperPdfExporterBuilder setCreatingBatchModeBookmarks(Boolean creatingBatchModeBookmarks) {
		this.getObject().setCreatingBatchModeBookmarks(creatingBatchModeBookmarks);
		return this;
	}

	public JasperPdfExporterBuilder setCompressed(Boolean compressed) {
		this.getObject().setCompressed(compressed);
		return this;
	}

	public JasperPdfExporterBuilder setEncrypted(Boolean encrypted) {
		this.getObject().setEncrypted(encrypted);
		return this;
	}

	public JasperPdfExporterBuilder setBitKey128(Boolean bitKey128) {
		this.getObject().setBitKey128(bitKey128);
		return this;
	}

	public JasperPdfExporterBuilder setUserPassword(String userPassword) {
		this.getObject().setUserPassword(userPassword);
		return this;
	}

	public JasperPdfExporterBuilder setOwnerPassword(String ownerPassword) {
		this.getObject().setOwnerPassword(ownerPassword);
		return this;
	}

	public JasperPdfExporterBuilder permissions(PdfPermission... permissions) {
		return addPermission(permissions);
	}

	public JasperPdfExporterBuilder addPermission(PdfPermission... permissions) {
		Validate.notNull(permissions, "permissions must not be null");
		Validate.noNullElements(permissions, "permissions must not contains null permission");
		for (PdfPermission permission : permissions) {
			this.getObject().addPermission(permission);
		}
		return this;
	}

	public JasperPdfExporterBuilder setPdfVersion(PdfVersion pdfVersion) {
		this.getObject().setPdfVersion(pdfVersion);
		return this;
	}

	public JasperPdfExporterBuilder setMetadataTitle(String metadataTitle) {
		this.getObject().setMetadataTitle(metadataTitle);
		return this;
	}

	public JasperPdfExporterBuilder setMetadataAuthor(String metadataAuthor) {
		this.getObject().setMetadataAuthor(metadataAuthor);
		return this;
	}

	public JasperPdfExporterBuilder setMetadataSubject(String metadataSubject) {
		this.getObject().setMetadataSubject(metadataSubject);
		return this;
	}

	public JasperPdfExporterBuilder setMetadataKeyWords(String metadataKeyWords) {
		this.getObject().setMetadataKeyWords(metadataKeyWords);
		return this;
	}

	public JasperPdfExporterBuilder setMetadataCreator(String metadataCreator) {
		this.getObject().setMetadataCreator(metadataCreator);
		return this;
	}

	public JasperPdfExporterBuilder setForceSvgShapes(Boolean forceSvgShapes) {
		this.getObject().setForceSvgShapes(forceSvgShapes);
		return this;
	}

	public JasperPdfExporterBuilder setPdfJavaScript(String pdfJavaScript) {
		this.getObject().setPdfJavaScript(pdfJavaScript);
		return this;
	}

	public JasperPdfExporterBuilder setTagged(Boolean tagged) {
		this.getObject().setTagged(tagged);
		return this;
	}

	public JasperPdfExporterBuilder setTagLanguage(String tagLanguage) {
		this.getObject().setTagLanguage(tagLanguage);
		return this;
	}

	public JasperPdfExporterBuilder setCollapseMissingBookmarkLevels(Boolean collapseMissingBookmarkLevels) {
		this.getObject().setCollapseMissingBookmarkLevels(collapseMissingBookmarkLevels);
		return this;
	}

	public JasperPdfExporterBuilder setSizePageToContent(Boolean sizePageToContent) {
		this.getObject().setSizePageToContent(sizePageToContent);
		return this;
	}

	public JasperPdfExporterBuilder setIgnoreHyperLink(Boolean ignoreHyperLink) {
		this.getObject().setIgnoreHyperLink(ignoreHyperLink);
		return this;
	}

	public JasperPdfExporterBuilder setForceLineBreakPolicy(Boolean forceLineBreakPolicy) {
		this.getObject().setForceLineBreakPolicy(forceLineBreakPolicy);
		return this;
	}

	public JasperPdfExporterBuilder setPrintScaling(PdfPrintScaling printScaling) {
		this.getObject().setPrintScaling(printScaling);
		return this;
	}

	public JasperPdfExporterBuilder setPdfaConformance(PdfaConformance pdfaConformance) {
		this.getObject().setPdfaConformance(pdfaConformance);
		return this;
	}

	public JasperPdfExporterBuilder setIccProfilePath(String iccProfilePath) {
		this.getObject().setIccProfilePath(iccProfilePath);
		return this;
	}

	public JasperPdfExporterBuilder setAllowedPermissionsHint(String allowedPermissionsHint) {
		this.getObject().setAllowedPermissionsHint(allowedPermissionsHint);
		return this;
	}

	public JasperPdfExporterBuilder setDeniedPermissionsHint(String deniedPermissionsHint) {
		this.getObject().setDeniedPermissionsHint(deniedPermissionsHint);
		return this;
	}

	public JasperPdfExporterBuilder setDisplayMetadataTitle(Boolean displayMetadataTitle) {
		this.getObject().setDisplayMetadataTitle(displayMetadataTitle);
		return this;
	}
}

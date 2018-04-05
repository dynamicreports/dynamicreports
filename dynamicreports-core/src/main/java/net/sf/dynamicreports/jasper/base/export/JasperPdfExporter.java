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

import net.sf.dynamicreports.jasper.constant.PdfPermission;
import net.sf.dynamicreports.jasper.constant.PdfVersion;
import net.sf.dynamicreports.jasper.definition.export.JasperIPdfExporter;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.PdfPrintScaling;
import net.sf.dynamicreports.report.constant.PdfaConformance;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class JasperPdfExporter extends AbstractJasperExporter implements JasperIPdfExporter {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Boolean creatingBatchModeBookmarks;
	private Boolean compressed;
	private Boolean encrypted;
	private Boolean bitKey128;
	private String userPassword;
	private String ownerPassword;
	private List<PdfPermission> permissions;
	private PdfVersion pdfVersion;
	private String metadataTitle;
	private String metadataAuthor;
	private String metadataSubject;
	private String metadataKeyWords;
	private String metadataCreator;
	private Boolean forceSvgShapes;
	private String pdfJavaScript;
	private Boolean tagged;
	private String tagLanguage;
	private Boolean collapseMissingBookmarkLevels;
	private Boolean sizePageToContent;
	private Boolean ignoreHyperLink;
	private Boolean forceLineBreakPolicy;
	private PdfPrintScaling printScaling;
	private PdfaConformance pdfaConformance;
	private String iccProfilePath;
	private String allowedPermissionsHint;
	private String deniedPermissionsHint;
	private Boolean displayMetadataTitle;

	public JasperPdfExporter() {
		permissions = new ArrayList<PdfPermission>();
	}

	@Override
	public Boolean getCreatingBatchModeBookmarks() {
		return creatingBatchModeBookmarks;
	}

	public void setCreatingBatchModeBookmarks(Boolean creatingBatchModeBookmarks) {
		this.creatingBatchModeBookmarks = creatingBatchModeBookmarks;
	}

	@Override
	public Boolean getCompressed() {
		return compressed;
	}

	public void setCompressed(Boolean compressed) {
		this.compressed = compressed;
	}

	@Override
	public Boolean getEncrypted() {
		return encrypted;
	}

	public void setEncrypted(Boolean encrypted) {
		this.encrypted = encrypted;
	}

	@Override
	public Boolean getBitKey128() {
		return bitKey128;
	}

	public void setBitKey128(Boolean bitKey128) {
		this.bitKey128 = bitKey128;
	}

	@Override
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String getOwnerPassword() {
		return ownerPassword;
	}

	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}

	@Override
	public List<PdfPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PdfPermission> permissions) {
		this.permissions = permissions;
	}

	public void addPermission(PdfPermission permission) {
		this.permissions.add(permission);
	}

	@Override
	public PdfVersion getPdfVersion() {
		return pdfVersion;
	}

	public void setPdfVersion(PdfVersion pdfVersion) {
		this.pdfVersion = pdfVersion;
	}

	@Override
	public String getMetadataTitle() {
		return metadataTitle;
	}

	public void setMetadataTitle(String metadataTitle) {
		this.metadataTitle = metadataTitle;
	}

	@Override
	public String getMetadataAuthor() {
		return metadataAuthor;
	}

	public void setMetadataAuthor(String metadataAuthor) {
		this.metadataAuthor = metadataAuthor;
	}

	@Override
	public String getMetadataSubject() {
		return metadataSubject;
	}

	public void setMetadataSubject(String metadataSubject) {
		this.metadataSubject = metadataSubject;
	}

	@Override
	public String getMetadataKeyWords() {
		return metadataKeyWords;
	}

	public void setMetadataKeyWords(String metadataKeyWords) {
		this.metadataKeyWords = metadataKeyWords;
	}

	@Override
	public String getMetadataCreator() {
		return metadataCreator;
	}

	public void setMetadataCreator(String metadataCreator) {
		this.metadataCreator = metadataCreator;
	}

	@Override
	public Boolean getForceSvgShapes() {
		return forceSvgShapes;
	}

	public void setForceSvgShapes(Boolean forceSvgShapes) {
		this.forceSvgShapes = forceSvgShapes;
	}

	@Override
	public String getPdfJavaScript() {
		return pdfJavaScript;
	}

	public void setPdfJavaScript(String pdfJavaScript) {
		this.pdfJavaScript = pdfJavaScript;
	}

	@Override
	public Boolean getTagged() {
		return tagged;
	}

	public void setTagged(Boolean tagged) {
		this.tagged = tagged;
	}

	@Override
	public String getTagLanguage() {
		return tagLanguage;
	}

	public void setTagLanguage(String tagLanguage) {
		this.tagLanguage = tagLanguage;
	}

	@Override
	public Boolean getCollapseMissingBookmarkLevels() {
		return collapseMissingBookmarkLevels;
	}

	public void setCollapseMissingBookmarkLevels(Boolean collapseMissingBookmarkLevels) {
		this.collapseMissingBookmarkLevels = collapseMissingBookmarkLevels;
	}

	@Override
	public Boolean getSizePageToContent() {
		return sizePageToContent;
	}

	public void setSizePageToContent(Boolean sizePageToContent) {
		this.sizePageToContent = sizePageToContent;
	}

	@Override
	public Boolean getIgnoreHyperLink() {
		return ignoreHyperLink;
	}

	public void setIgnoreHyperLink(Boolean ignoreHyperLink) {
		this.ignoreHyperLink = ignoreHyperLink;
	}

	@Override
	public Boolean getForceLineBreakPolicy() {
		return forceLineBreakPolicy;
	}

	public void setForceLineBreakPolicy(Boolean forceLineBreakPolicy) {
		this.forceLineBreakPolicy = forceLineBreakPolicy;
	}

	@Override
	public PdfPrintScaling getPrintScaling() {
		return printScaling;
	}

	public void setPrintScaling(PdfPrintScaling printScaling) {
		this.printScaling = printScaling;
	}

	@Override
	public PdfaConformance getPdfaConformance() {
		return pdfaConformance;
	}

	public void setPdfaConformance(PdfaConformance pdfaConformance) {
		this.pdfaConformance = pdfaConformance;
	}

	@Override
	public String getIccProfilePath() {
		return iccProfilePath;
	}

	public void setIccProfilePath(String iccProfilePath) {
		this.iccProfilePath = iccProfilePath;
	}

	@Override
	public String getAllowedPermissionsHint() {
		return allowedPermissionsHint;
	}

	public void setAllowedPermissionsHint(String allowedPermissionsHint) {
		this.allowedPermissionsHint = allowedPermissionsHint;
	}

	@Override
	public String getDeniedPermissionsHint() {
		return deniedPermissionsHint;
	}

	public void setDeniedPermissionsHint(String deniedPermissionsHint) {
		this.deniedPermissionsHint = deniedPermissionsHint;
	}

	@Override
	public Boolean getDisplayMetadataTitle() {
		return displayMetadataTitle;
	}

	public void setDisplayMetadataTitle(Boolean displayMetadataTitle) {
		this.displayMetadataTitle = displayMetadataTitle;
	}

}

/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import net.sf.dynamicreports.jasper.constant.PdfPermission;
import net.sf.dynamicreports.jasper.constant.PdfVersion;
import net.sf.dynamicreports.jasper.definition.export.JasperIPdfExporter;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.PdfPrintScaling;
import net.sf.dynamicreports.report.constant.PdfaConformance;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>JasperPdfExporter class.</p>
 *
 * @author Ricardo Mariaca
 * 
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

    /**
     * <p>Constructor for JasperPdfExporter.</p>
     */
    public JasperPdfExporter() {
        permissions = new ArrayList<PdfPermission>();
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getCreatingBatchModeBookmarks() {
        return creatingBatchModeBookmarks;
    }

    /**
     * <p>Setter for the field <code>creatingBatchModeBookmarks</code>.</p>
     *
     * @param creatingBatchModeBookmarks a {@link java.lang.Boolean} object.
     */
    public void setCreatingBatchModeBookmarks(Boolean creatingBatchModeBookmarks) {
        this.creatingBatchModeBookmarks = creatingBatchModeBookmarks;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getCompressed() {
        return compressed;
    }

    /**
     * <p>Setter for the field <code>compressed</code>.</p>
     *
     * @param compressed a {@link java.lang.Boolean} object.
     */
    public void setCompressed(Boolean compressed) {
        this.compressed = compressed;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getEncrypted() {
        return encrypted;
    }

    /**
     * <p>Setter for the field <code>encrypted</code>.</p>
     *
     * @param encrypted a {@link java.lang.Boolean} object.
     */
    public void setEncrypted(Boolean encrypted) {
        this.encrypted = encrypted;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getBitKey128() {
        return bitKey128;
    }

    /**
     * <p>Setter for the field <code>bitKey128</code>.</p>
     *
     * @param bitKey128 a {@link java.lang.Boolean} object.
     */
    public void setBitKey128(Boolean bitKey128) {
        this.bitKey128 = bitKey128;
    }

    /** {@inheritDoc} */
    @Override
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * <p>Setter for the field <code>userPassword</code>.</p>
     *
     * @param userPassword a {@link java.lang.String} object.
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /** {@inheritDoc} */
    @Override
    public String getOwnerPassword() {
        return ownerPassword;
    }

    /**
     * <p>Setter for the field <code>ownerPassword</code>.</p>
     *
     * @param ownerPassword a {@link java.lang.String} object.
     */
    public void setOwnerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
    }

    /** {@inheritDoc} */
    @Override
    public List<PdfPermission> getPermissions() {
        return permissions;
    }

    /**
     * <p>Setter for the field <code>permissions</code>.</p>
     *
     * @param permissions a {@link java.util.List} object.
     */
    public void setPermissions(List<PdfPermission> permissions) {
        this.permissions = permissions;
    }

    /**
     * <p>addPermission.</p>
     *
     * @param permission a {@link net.sf.dynamicreports.jasper.constant.PdfPermission} object.
     */
    public void addPermission(PdfPermission permission) {
        this.permissions.add(permission);
    }

    /** {@inheritDoc} */
    @Override
    public PdfVersion getPdfVersion() {
        return pdfVersion;
    }

    /**
     * <p>Setter for the field <code>pdfVersion</code>.</p>
     *
     * @param pdfVersion a {@link net.sf.dynamicreports.jasper.constant.PdfVersion} object.
     */
    public void setPdfVersion(PdfVersion pdfVersion) {
        this.pdfVersion = pdfVersion;
    }

    /** {@inheritDoc} */
    @Override
    public String getMetadataTitle() {
        return metadataTitle;
    }

    /**
     * <p>Setter for the field <code>metadataTitle</code>.</p>
     *
     * @param metadataTitle a {@link java.lang.String} object.
     */
    public void setMetadataTitle(String metadataTitle) {
        this.metadataTitle = metadataTitle;
    }

    /** {@inheritDoc} */
    @Override
    public String getMetadataAuthor() {
        return metadataAuthor;
    }

    /**
     * <p>Setter for the field <code>metadataAuthor</code>.</p>
     *
     * @param metadataAuthor a {@link java.lang.String} object.
     */
    public void setMetadataAuthor(String metadataAuthor) {
        this.metadataAuthor = metadataAuthor;
    }

    /** {@inheritDoc} */
    @Override
    public String getMetadataSubject() {
        return metadataSubject;
    }

    /**
     * <p>Setter for the field <code>metadataSubject</code>.</p>
     *
     * @param metadataSubject a {@link java.lang.String} object.
     */
    public void setMetadataSubject(String metadataSubject) {
        this.metadataSubject = metadataSubject;
    }

    /** {@inheritDoc} */
    @Override
    public String getMetadataKeyWords() {
        return metadataKeyWords;
    }

    /**
     * <p>Setter for the field <code>metadataKeyWords</code>.</p>
     *
     * @param metadataKeyWords a {@link java.lang.String} object.
     */
    public void setMetadataKeyWords(String metadataKeyWords) {
        this.metadataKeyWords = metadataKeyWords;
    }

    /** {@inheritDoc} */
    @Override
    public String getMetadataCreator() {
        return metadataCreator;
    }

    /**
     * <p>Setter for the field <code>metadataCreator</code>.</p>
     *
     * @param metadataCreator a {@link java.lang.String} object.
     */
    public void setMetadataCreator(String metadataCreator) {
        this.metadataCreator = metadataCreator;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getForceSvgShapes() {
        return forceSvgShapes;
    }

    /**
     * <p>Setter for the field <code>forceSvgShapes</code>.</p>
     *
     * @param forceSvgShapes a {@link java.lang.Boolean} object.
     */
    public void setForceSvgShapes(Boolean forceSvgShapes) {
        this.forceSvgShapes = forceSvgShapes;
    }

    /** {@inheritDoc} */
    @Override
    public String getPdfJavaScript() {
        return pdfJavaScript;
    }

    /**
     * <p>Setter for the field <code>pdfJavaScript</code>.</p>
     *
     * @param pdfJavaScript a {@link java.lang.String} object.
     */
    public void setPdfJavaScript(String pdfJavaScript) {
        this.pdfJavaScript = pdfJavaScript;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getTagged() {
        return tagged;
    }

    /**
     * <p>Setter for the field <code>tagged</code>.</p>
     *
     * @param tagged a {@link java.lang.Boolean} object.
     */
    public void setTagged(Boolean tagged) {
        this.tagged = tagged;
    }

    /** {@inheritDoc} */
    @Override
    public String getTagLanguage() {
        return tagLanguage;
    }

    /**
     * <p>Setter for the field <code>tagLanguage</code>.</p>
     *
     * @param tagLanguage a {@link java.lang.String} object.
     */
    public void setTagLanguage(String tagLanguage) {
        this.tagLanguage = tagLanguage;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getCollapseMissingBookmarkLevels() {
        return collapseMissingBookmarkLevels;
    }

    /**
     * <p>Setter for the field <code>collapseMissingBookmarkLevels</code>.</p>
     *
     * @param collapseMissingBookmarkLevels a {@link java.lang.Boolean} object.
     */
    public void setCollapseMissingBookmarkLevels(Boolean collapseMissingBookmarkLevels) {
        this.collapseMissingBookmarkLevels = collapseMissingBookmarkLevels;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getSizePageToContent() {
        return sizePageToContent;
    }

    /**
     * <p>Setter for the field <code>sizePageToContent</code>.</p>
     *
     * @param sizePageToContent a {@link java.lang.Boolean} object.
     */
    public void setSizePageToContent(Boolean sizePageToContent) {
        this.sizePageToContent = sizePageToContent;
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
    public Boolean getForceLineBreakPolicy() {
        return forceLineBreakPolicy;
    }

    /**
     * <p>Setter for the field <code>forceLineBreakPolicy</code>.</p>
     *
     * @param forceLineBreakPolicy a {@link java.lang.Boolean} object.
     */
    public void setForceLineBreakPolicy(Boolean forceLineBreakPolicy) {
        this.forceLineBreakPolicy = forceLineBreakPolicy;
    }

    /** {@inheritDoc} */
    @Override
    public PdfPrintScaling getPrintScaling() {
        return printScaling;
    }

    /**
     * <p>Setter for the field <code>printScaling</code>.</p>
     *
     * @param printScaling a {@link net.sf.dynamicreports.report.constant.PdfPrintScaling} object.
     */
    public void setPrintScaling(PdfPrintScaling printScaling) {
        this.printScaling = printScaling;
    }

    /** {@inheritDoc} */
    @Override
    public PdfaConformance getPdfaConformance() {
        return pdfaConformance;
    }

    /**
     * <p>Setter for the field <code>pdfaConformance</code>.</p>
     *
     * @param pdfaConformance a {@link net.sf.dynamicreports.report.constant.PdfaConformance} object.
     */
    public void setPdfaConformance(PdfaConformance pdfaConformance) {
        this.pdfaConformance = pdfaConformance;
    }

    /** {@inheritDoc} */
    @Override
    public String getIccProfilePath() {
        return iccProfilePath;
    }

    /**
     * <p>Setter for the field <code>iccProfilePath</code>.</p>
     *
     * @param iccProfilePath a {@link java.lang.String} object.
     */
    public void setIccProfilePath(String iccProfilePath) {
        this.iccProfilePath = iccProfilePath;
    }

    /** {@inheritDoc} */
    @Override
    public String getAllowedPermissionsHint() {
        return allowedPermissionsHint;
    }

    /**
     * <p>Setter for the field <code>allowedPermissionsHint</code>.</p>
     *
     * @param allowedPermissionsHint a {@link java.lang.String} object.
     */
    public void setAllowedPermissionsHint(String allowedPermissionsHint) {
        this.allowedPermissionsHint = allowedPermissionsHint;
    }

    /** {@inheritDoc} */
    @Override
    public String getDeniedPermissionsHint() {
        return deniedPermissionsHint;
    }

    /**
     * <p>Setter for the field <code>deniedPermissionsHint</code>.</p>
     *
     * @param deniedPermissionsHint a {@link java.lang.String} object.
     */
    public void setDeniedPermissionsHint(String deniedPermissionsHint) {
        this.deniedPermissionsHint = deniedPermissionsHint;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getDisplayMetadataTitle() {
        return displayMetadataTitle;
    }

    /**
     * <p>Setter for the field <code>displayMetadataTitle</code>.</p>
     *
     * @param displayMetadataTitle a {@link java.lang.Boolean} object.
     */
    public void setDisplayMetadataTitle(Boolean displayMetadataTitle) {
        this.displayMetadataTitle = displayMetadataTitle;
    }

}

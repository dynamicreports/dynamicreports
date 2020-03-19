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
package net.sf.dynamicreports.jasper.builder.export;

import net.sf.dynamicreports.jasper.base.export.JasperPdfExporter;
import net.sf.dynamicreports.jasper.constant.PdfPermission;
import net.sf.dynamicreports.jasper.constant.PdfVersion;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.PdfPrintScaling;
import net.sf.dynamicreports.report.constant.PdfaConformance;
import org.apache.commons.lang3.Validate;

/**
 * <p>JasperPdfExporterBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class JasperPdfExporterBuilder extends AbstractJasperExporterBuilder<JasperPdfExporterBuilder, JasperPdfExporter> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for JasperPdfExporterBuilder.</p>
     */
    protected JasperPdfExporterBuilder() {
        super(new JasperPdfExporter());
    }

    /**
     * <p>setCreatingBatchModeBookmarks.</p>
     *
     * @param creatingBatchModeBookmarks a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setCreatingBatchModeBookmarks(Boolean creatingBatchModeBookmarks) {
        this.getObject().setCreatingBatchModeBookmarks(creatingBatchModeBookmarks);
        return this;
    }

    /**
     * <p>setCompressed.</p>
     *
     * @param compressed a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setCompressed(Boolean compressed) {
        this.getObject().setCompressed(compressed);
        return this;
    }

    /**
     * <p>setEncrypted.</p>
     *
     * @param encrypted a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setEncrypted(Boolean encrypted) {
        this.getObject().setEncrypted(encrypted);
        return this;
    }

    /**
     * <p>setBitKey128.</p>
     *
     * @param bitKey128 a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setBitKey128(Boolean bitKey128) {
        this.getObject().setBitKey128(bitKey128);
        return this;
    }

    /**
     * <p>setUserPassword.</p>
     *
     * @param userPassword a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setUserPassword(String userPassword) {
        this.getObject().setUserPassword(userPassword);
        return this;
    }

    /**
     * <p>setOwnerPassword.</p>
     *
     * @param ownerPassword a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setOwnerPassword(String ownerPassword) {
        this.getObject().setOwnerPassword(ownerPassword);
        return this;
    }

    /**
     * <p>permissions.</p>
     *
     * @param permissions a {@link net.sf.dynamicreports.jasper.constant.PdfPermission} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder permissions(PdfPermission... permissions) {
        return addPermission(permissions);
    }

    /**
     * <p>addPermission.</p>
     *
     * @param permissions a {@link net.sf.dynamicreports.jasper.constant.PdfPermission} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder addPermission(PdfPermission... permissions) {
        Validate.notNull(permissions, "permissions must not be null");
        Validate.noNullElements(permissions, "permissions must not contains null permission");
        for (PdfPermission permission : permissions) {
            this.getObject().addPermission(permission);
        }
        return this;
    }

    /**
     * <p>setPdfVersion.</p>
     *
     * @param pdfVersion a {@link net.sf.dynamicreports.jasper.constant.PdfVersion} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setPdfVersion(PdfVersion pdfVersion) {
        this.getObject().setPdfVersion(pdfVersion);
        return this;
    }

    /**
     * <p>setMetadataTitle.</p>
     *
     * @param metadataTitle a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setMetadataTitle(String metadataTitle) {
        this.getObject().setMetadataTitle(metadataTitle);
        return this;
    }

    /**
     * <p>setMetadataAuthor.</p>
     *
     * @param metadataAuthor a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setMetadataAuthor(String metadataAuthor) {
        this.getObject().setMetadataAuthor(metadataAuthor);
        return this;
    }

    /**
     * <p>setMetadataSubject.</p>
     *
     * @param metadataSubject a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setMetadataSubject(String metadataSubject) {
        this.getObject().setMetadataSubject(metadataSubject);
        return this;
    }

    /**
     * <p>setMetadataKeyWords.</p>
     *
     * @param metadataKeyWords a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setMetadataKeyWords(String metadataKeyWords) {
        this.getObject().setMetadataKeyWords(metadataKeyWords);
        return this;
    }

    /**
     * <p>setMetadataCreator.</p>
     *
     * @param metadataCreator a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setMetadataCreator(String metadataCreator) {
        this.getObject().setMetadataCreator(metadataCreator);
        return this;
    }

    /**
     * <p>setForceSvgShapes.</p>
     *
     * @param forceSvgShapes a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setForceSvgShapes(Boolean forceSvgShapes) {
        this.getObject().setForceSvgShapes(forceSvgShapes);
        return this;
    }

    /**
     * <p>setPdfJavaScript.</p>
     *
     * @param pdfJavaScript a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setPdfJavaScript(String pdfJavaScript) {
        this.getObject().setPdfJavaScript(pdfJavaScript);
        return this;
    }

    /**
     * <p>setTagged.</p>
     *
     * @param tagged a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setTagged(Boolean tagged) {
        this.getObject().setTagged(tagged);
        return this;
    }

    /**
     * <p>setTagLanguage.</p>
     *
     * @param tagLanguage a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setTagLanguage(String tagLanguage) {
        this.getObject().setTagLanguage(tagLanguage);
        return this;
    }

    /**
     * <p>setCollapseMissingBookmarkLevels.</p>
     *
     * @param collapseMissingBookmarkLevels a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setCollapseMissingBookmarkLevels(Boolean collapseMissingBookmarkLevels) {
        this.getObject().setCollapseMissingBookmarkLevels(collapseMissingBookmarkLevels);
        return this;
    }

    /**
     * <p>setSizePageToContent.</p>
     *
     * @param sizePageToContent a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setSizePageToContent(Boolean sizePageToContent) {
        this.getObject().setSizePageToContent(sizePageToContent);
        return this;
    }

    /**
     * <p>setIgnoreHyperLink.</p>
     *
     * @param ignoreHyperLink a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setIgnoreHyperLink(Boolean ignoreHyperLink) {
        this.getObject().setIgnoreHyperLink(ignoreHyperLink);
        return this;
    }

    /**
     * <p>setForceLineBreakPolicy.</p>
     *
     * @param forceLineBreakPolicy a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setForceLineBreakPolicy(Boolean forceLineBreakPolicy) {
        this.getObject().setForceLineBreakPolicy(forceLineBreakPolicy);
        return this;
    }

    /**
     * <p>setPrintScaling.</p>
     *
     * @param printScaling a {@link net.sf.dynamicreports.report.constant.PdfPrintScaling} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setPrintScaling(PdfPrintScaling printScaling) {
        this.getObject().setPrintScaling(printScaling);
        return this;
    }

    /**
     * <p>setPdfaConformance.</p>
     *
     * @param pdfaConformance a {@link net.sf.dynamicreports.report.constant.PdfaConformance} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setPdfaConformance(PdfaConformance pdfaConformance) {
        this.getObject().setPdfaConformance(pdfaConformance);
        return this;
    }

    /**
     * <p>setIccProfilePath.</p>
     *
     * @param iccProfilePath a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setIccProfilePath(String iccProfilePath) {
        this.getObject().setIccProfilePath(iccProfilePath);
        return this;
    }

    /**
     * <p>setAllowedPermissionsHint.</p>
     *
     * @param allowedPermissionsHint a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setAllowedPermissionsHint(String allowedPermissionsHint) {
        this.getObject().setAllowedPermissionsHint(allowedPermissionsHint);
        return this;
    }

    /**
     * <p>setDeniedPermissionsHint.</p>
     *
     * @param deniedPermissionsHint a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setDeniedPermissionsHint(String deniedPermissionsHint) {
        this.getObject().setDeniedPermissionsHint(deniedPermissionsHint);
        return this;
    }

    /**
     * <p>setDisplayMetadataTitle.</p>
     *
     * @param displayMetadataTitle a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder} object.
     */
    public JasperPdfExporterBuilder setDisplayMetadataTitle(Boolean displayMetadataTitle) {
        this.getObject().setDisplayMetadataTitle(displayMetadataTitle);
        return this;
    }
}

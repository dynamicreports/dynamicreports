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
package net.sf.dynamicreports.jasper.definition.export;

import net.sf.dynamicreports.jasper.constant.PdfPermission;
import net.sf.dynamicreports.jasper.constant.PdfVersion;
import net.sf.dynamicreports.report.constant.PdfPrintScaling;
import net.sf.dynamicreports.report.constant.PdfaConformance;

import java.util.List;

/**
 * <p>JasperIPdfExporter interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface JasperIPdfExporter extends JasperIExporter {

    /**
     * <p>getCreatingBatchModeBookmarks.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getCreatingBatchModeBookmarks();

    /**
     * <p>getCompressed.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getCompressed();

    /**
     * <p>getEncrypted.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getEncrypted();

    /**
     * <p>getBitKey128.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getBitKey128();

    /**
     * <p>getUserPassword.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUserPassword();

    /**
     * <p>getOwnerPassword.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getOwnerPassword();

    /**
     * <p>getPermissions.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<PdfPermission> getPermissions();

    /**
     * <p>getPdfVersion.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.constant.PdfVersion} object.
     */
    public PdfVersion getPdfVersion();

    /**
     * <p>getMetadataTitle.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMetadataTitle();

    /**
     * <p>getMetadataAuthor.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMetadataAuthor();

    /**
     * <p>getMetadataSubject.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMetadataSubject();

    /**
     * <p>getMetadataKeyWords.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMetadataKeyWords();

    /**
     * <p>getMetadataCreator.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getMetadataCreator();

    /**
     * <p>getForceSvgShapes.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getForceSvgShapes();

    /**
     * <p>getPdfJavaScript.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPdfJavaScript();

    /**
     * <p>getTagged.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getTagged();

    /**
     * <p>getTagLanguage.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTagLanguage();

    /**
     * <p>getCollapseMissingBookmarkLevels.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getCollapseMissingBookmarkLevels();

    /**
     * <p>getSizePageToContent.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getSizePageToContent();

    /**
     * <p>getIgnoreHyperLink.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getIgnoreHyperLink();

    /**
     * <p>getForceLineBreakPolicy.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getForceLineBreakPolicy();

    /**
     * <p>getPrintScaling.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.PdfPrintScaling} object.
     */
    public PdfPrintScaling getPrintScaling();

    /**
     * <p>getPdfaConformance.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.PdfaConformance} object.
     */
    public PdfaConformance getPdfaConformance();

    /**
     * <p>getIccProfilePath.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getIccProfilePath();

    /**
     * <p>getAllowedPermissionsHint.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getAllowedPermissionsHint();

    /**
     * <p>getDeniedPermissionsHint.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDeniedPermissionsHint();

    /**
     * <p>getDisplayMetadataTitle.</p>
     *
     * @return a {@link java.lang.Boolean} object.
     */
    public Boolean getDisplayMetadataTitle();
}

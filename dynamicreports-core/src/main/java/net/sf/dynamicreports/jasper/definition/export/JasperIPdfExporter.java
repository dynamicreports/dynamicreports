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

package net.sf.dynamicreports.jasper.definition.export;

import java.util.List;

import net.sf.dynamicreports.jasper.constant.PdfPermission;
import net.sf.dynamicreports.jasper.constant.PdfVersion;
import net.sf.dynamicreports.report.constant.PdfPrintScaling;
import net.sf.dynamicreports.report.constant.PdfaConformance;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public interface JasperIPdfExporter extends JasperIExporter {

	public Boolean getCreatingBatchModeBookmarks();

	public Boolean getCompressed();

	public Boolean getEncrypted();

	public Boolean getBitKey128();

	public String getUserPassword();

	public String getOwnerPassword();

	public List<PdfPermission> getPermissions();

	public PdfVersion getPdfVersion();

	public String getMetadataTitle();

	public String getMetadataAuthor();

	public String getMetadataSubject();

	public String getMetadataKeyWords();

	public String getMetadataCreator();

	public Boolean getForceSvgShapes();

	public String getPdfJavaScript();

	public Boolean getTagged();

	public String getTagLanguage();

	public Boolean getCollapseMissingBookmarkLevels();

	public Boolean getSizePageToContent();

	public Boolean getIgnoreHyperLink();

	public Boolean getForceLineBreakPolicy();

	public PdfPrintScaling getPrintScaling();

	public PdfaConformance getPdfaConformance();

	public String getIccProfilePath();

	public String getAllowedPermissionsHint();

	public String getDeniedPermissionsHint();

	public Boolean getDisplayMetadataTitle();
}

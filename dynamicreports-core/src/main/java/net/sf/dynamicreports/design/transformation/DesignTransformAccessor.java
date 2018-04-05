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

package net.sf.dynamicreports.design.transformation;

import java.util.Locale;
import java.util.ResourceBundle;

import net.sf.dynamicreports.design.base.DRDesignPage;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.definition.DRIDataset;
import net.sf.dynamicreports.report.definition.DRIReport;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public interface DesignTransformAccessor {

	public DRIReport getReport();

	public Integer getPageWidth();

	public ReportTransform getReportTransform();

	public TemplateTransform getTemplateTransform();

	public void transformToMainDataset();

	public void transformToDataset(DRIDataset dataset);

	public AbstractExpressionTransform getExpressionTransform();

	public PageTransform getPageTransform();

	public BandTransform getBandTransform();

	public ComponentTransform getComponentTransform();

	public GroupTransform getGroupTransform();

	public ColumnTransform getColumnTransform();

	public ColumnGridTransform getColumnGridTransform();

	public StyleTransform getStyleTransform();

	public ChartTransform getChartTransform();

	public BarcodeTransform getBarcodeTransform();

	public CrosstabTransform getCrosstabTransform();

	public DatasetTransform getDatasetTransform();

	public TableOfContentsTransform getTableOfContentsTransform();

	public boolean isTableOfContents();

	public DRDesignPage getPage();

	public Locale getLocale();

	public ResourceBundle getResourceBundle();

	public String getResourceBundleName();

	public WhenResourceMissingType getWhenResourceMissingType();
}

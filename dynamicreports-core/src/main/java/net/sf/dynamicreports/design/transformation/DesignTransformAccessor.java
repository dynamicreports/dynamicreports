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
 * <p>DesignTransformAccessor interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface DesignTransformAccessor {

	/**
	 * <p>getReport.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.definition.DRIReport} object.
	 */
	public DRIReport getReport();

	/**
	 * <p>getPageWidth.</p>
	 *
	 * @return a {@link java.lang.Integer} object.
	 */
	public Integer getPageWidth();

	/**
	 * <p>getReportTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.ReportTransform} object.
	 */
	public ReportTransform getReportTransform();

	/**
	 * <p>getTemplateTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.TemplateTransform} object.
	 */
	public TemplateTransform getTemplateTransform();

	/**
	 * <p>transformToMainDataset.</p>
	 */
	public void transformToMainDataset();

	/**
	 * <p>transformToDataset.</p>
	 *
	 * @param dataset a {@link net.sf.dynamicreports.report.definition.DRIDataset} object.
	 */
	public void transformToDataset(DRIDataset dataset);

	/**
	 * <p>getExpressionTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.AbstractExpressionTransform} object.
	 */
	public AbstractExpressionTransform getExpressionTransform();

	/**
	 * <p>getPageTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.PageTransform} object.
	 */
	public PageTransform getPageTransform();

	/**
	 * <p>getBandTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.BandTransform} object.
	 */
	public BandTransform getBandTransform();

	/**
	 * <p>getComponentTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.ComponentTransform} object.
	 */
	public ComponentTransform getComponentTransform();

	/**
	 * <p>getGroupTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.GroupTransform} object.
	 */
	public GroupTransform getGroupTransform();

	/**
	 * <p>getColumnTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.ColumnTransform} object.
	 */
	public ColumnTransform getColumnTransform();

	/**
	 * <p>getColumnGridTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.ColumnGridTransform} object.
	 */
	public ColumnGridTransform getColumnGridTransform();

	/**
	 * <p>getStyleTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.StyleTransform} object.
	 */
	public StyleTransform getStyleTransform();

	/**
	 * <p>getChartTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.ChartTransform} object.
	 */
	public ChartTransform getChartTransform();

	/**
	 * <p>getBarcodeTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.BarcodeTransform} object.
	 */
	public BarcodeTransform getBarcodeTransform();

	/**
	 * <p>getCrosstabTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.CrosstabTransform} object.
	 */
	public CrosstabTransform getCrosstabTransform();

	/**
	 * <p>getDatasetTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.DatasetTransform} object.
	 */
	public DatasetTransform getDatasetTransform();

	/**
	 * <p>getTableOfContentsTransform.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.transformation.TableOfContentsTransform} object.
	 */
	public TableOfContentsTransform getTableOfContentsTransform();

	/**
	 * <p>isTableOfContents.</p>
	 *
	 * @return a boolean.
	 */
	public boolean isTableOfContents();

	/**
	 * <p>getPage.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.design.base.DRDesignPage} object.
	 */
	public DRDesignPage getPage();

	/**
	 * <p>getLocale.</p>
	 *
	 * @return a {@link java.util.Locale} object.
	 */
	public Locale getLocale();

	/**
	 * <p>getResourceBundle.</p>
	 *
	 * @return a {@link java.util.ResourceBundle} object.
	 */
	public ResourceBundle getResourceBundle();

	/**
	 * <p>getResourceBundleName.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getResourceBundleName();

	/**
	 * <p>getWhenResourceMissingType.</p>
	 *
	 * @return a {@link net.sf.dynamicreports.report.constant.WhenResourceMissingType} object.
	 */
	public WhenResourceMissingType getWhenResourceMissingType();
}

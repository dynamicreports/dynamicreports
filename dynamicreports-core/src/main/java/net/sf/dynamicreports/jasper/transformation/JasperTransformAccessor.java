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

package net.sf.dynamicreports.jasper.transformation;

import java.util.Map;

import net.sf.dynamicreports.design.definition.DRIDesignDataset;
import net.sf.dynamicreports.design.definition.DRIDesignReport;
import net.sf.dynamicreports.jasper.base.JasperCustomValues;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.jasperreports.engine.design.JasperDesign;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public interface JasperTransformAccessor {

	public DRIDesignReport getReport();

	public JasperDesign getDesign();

	public JasperCustomValues getCustomValues();

	public Map<String, Object> getParameters();

	public Map<String, Object> getParameterValues();

	public Integer getStartPageNumber();

	public ReportParameters getMasterReportParameters();

	public ReportTransform getReportTransform();

	public void transformToMainDataset();

	public void transformToDataset(DRIDesignDataset dataset);

	public AbstractExpressionTransform getExpressionTransform();

	public AbstractExpressionTransform getExpressionTransform(DRIDesignDataset dataset);

	public GroupTransform getGroupTransform();

	public ComponentTransform getComponentTransform();

	public StyleTransform getStyleTransform();

	public ChartTransform getChartTransform();

	public BarcodeTransform getBarcodeTransform();

	public CrosstabTransform getCrosstabTransform();

	public DatasetTransform getDatasetTransform();
}

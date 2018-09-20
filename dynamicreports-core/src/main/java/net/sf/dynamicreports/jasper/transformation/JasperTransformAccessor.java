/*
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

import net.sf.dynamicreports.design.definition.DRIDesignDataset;
import net.sf.dynamicreports.design.definition.DRIDesignReport;
import net.sf.dynamicreports.jasper.base.JasperCustomValues;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.jasperreports.engine.design.JasperDesign;

import java.util.Map;

/**
 * <p>JasperTransformAccessor interface.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public interface JasperTransformAccessor {

    /**
     * <p>getReport.</p>
     *
     * @return a {@link net.sf.dynamicreports.design.definition.DRIDesignReport} object.
     */
    public DRIDesignReport getReport();

    /**
     * <p>getDesign.</p>
     *
     * @return a {@link net.sf.jasperreports.engine.design.JasperDesign} object.
     */
    public JasperDesign getDesign();

    /**
     * <p>getCustomValues.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.base.JasperCustomValues} object.
     */
    public JasperCustomValues getCustomValues();

    /**
     * <p>getParameters.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, Object> getParameters();

    /**
     * <p>getParameterValues.</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<String, Object> getParameterValues();

    /**
     * <p>getStartPageNumber.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getStartPageNumber();

    /**
     * <p>getMasterReportParameters.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.ReportParameters} object.
     */
    public ReportParameters getMasterReportParameters();

    /**
     * <p>getReportTransform.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.transformation.ReportTransform} object.
     */
    public ReportTransform getReportTransform();

    /**
     * <p>transformToMainDataset.</p>
     */
    public void transformToMainDataset();

    /**
     * <p>transformToDataset.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.design.definition.DRIDesignDataset} object.
     */
    public void transformToDataset(DRIDesignDataset dataset);

    /**
     * <p>getExpressionTransform.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.transformation.AbstractExpressionTransform} object.
     */
    public AbstractExpressionTransform getExpressionTransform();

    /**
     * <p>getExpressionTransform.</p>
     *
     * @param dataset a {@link net.sf.dynamicreports.design.definition.DRIDesignDataset} object.
     * @return a {@link net.sf.dynamicreports.jasper.transformation.AbstractExpressionTransform} object.
     */
    public AbstractExpressionTransform getExpressionTransform(DRIDesignDataset dataset);

    /**
     * <p>getGroupTransform.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.transformation.GroupTransform} object.
     */
    public GroupTransform getGroupTransform();

    /**
     * <p>getComponentTransform.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.transformation.ComponentTransform} object.
     */
    public ComponentTransform getComponentTransform();

    /**
     * <p>getStyleTransform.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.transformation.StyleTransform} object.
     */
    public StyleTransform getStyleTransform();

    /**
     * <p>getChartTransform.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.transformation.ChartTransform} object.
     */
    public ChartTransform getChartTransform();

    /**
     * <p>getBarcodeTransform.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.transformation.BarcodeTransform} object.
     */
    public BarcodeTransform getBarcodeTransform();

    /**
     * <p>getCrosstabTransform.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.transformation.CrosstabTransform} object.
     */
    public CrosstabTransform getCrosstabTransform();

    /**
     * <p>getDatasetTransform.</p>
     *
     * @return a {@link net.sf.dynamicreports.jasper.transformation.DatasetTransform} object.
     */
    public DatasetTransform getDatasetTransform();
}

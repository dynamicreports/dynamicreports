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
package net.sf.dynamicreports.jasper.transformation;

import net.sf.dynamicreports.design.definition.DRIDesignDataset;
import net.sf.dynamicreports.design.definition.DRIDesignReport;
import net.sf.dynamicreports.jasper.base.JasperCustomValues;
import net.sf.dynamicreports.jasper.base.JasperReportDesign;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.design.JasperDesign;

import java.util.Map;

/**
 * <p>JasperTransform class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class JasperTransform implements JasperTransformAccessor {
    private DRIDesignReport report;
    private JasperReportDesign jasperReportDesign;
    private ReportTransform reportTransform;
    private MainDatasetExpressionTransform mainDatasetExpressionTransform;
    private BandTransform bandTransform;
    private ComponentTransform componentTransform;
    private GroupTransform groupTransform;
    private StyleTransform styleTransform;
    private ChartTransform chartTransform;
    private BarcodeTransform barcodeTransform;
    private CrosstabTransform crosstabTransform;
    private DatasetTransform datasetTransform;
    private AbstractExpressionTransform expressionTransform;

    /**
     * <p>Constructor for JasperTransform.</p>
     *
     * @param report             a {@link net.sf.dynamicreports.design.definition.DRIDesignReport} object.
     * @param jasperReportDesign a {@link net.sf.dynamicreports.jasper.base.JasperReportDesign} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public JasperTransform(DRIDesignReport report, JasperReportDesign jasperReportDesign) throws DRException {
        this.report = report;
        this.jasperReportDesign = jasperReportDesign;
        init();
    }

    private void init() throws DRException {
        reportTransform = new ReportTransform(this);
        mainDatasetExpressionTransform = new MainDatasetExpressionTransform(this);
        groupTransform = new GroupTransform(this);
        bandTransform = new BandTransform(this);
        componentTransform = new ComponentTransform(this);
        styleTransform = new StyleTransform(this);
        chartTransform = new ChartTransform(this);
        barcodeTransform = new BarcodeTransform(this);
        crosstabTransform = new CrosstabTransform(this);
        datasetTransform = new DatasetTransform(this);
        transformToMainDataset();
    }

    /**
     * <p>transform.</p>
     */
    public void transform() {
        reportTransform.transform();
        datasetTransform.transform();
        groupTransform.transform();
        mainDatasetExpressionTransform.transform();
        reportTransform.transformExpressions();
        groupTransform.transformExpressions();
        styleTransform.transform();
        bandTransform.transform();
        reportTransform.addDependencies();
    }

    /** {@inheritDoc} */
    @Override
    public ReportTransform getReportTransform() {
        return reportTransform;
    }

    /** {@inheritDoc} */
    @Override
    public ChartTransform getChartTransform() {
        return chartTransform;
    }

    /** {@inheritDoc} */
    @Override
    public BarcodeTransform getBarcodeTransform() {
        return barcodeTransform;
    }

    /** {@inheritDoc} */
    @Override
    public CrosstabTransform getCrosstabTransform() {
        return crosstabTransform;
    }

    /** {@inheritDoc} */
    @Override
    public ComponentTransform getComponentTransform() {
        return componentTransform;
    }

    /** {@inheritDoc} */
    @Override
    public void transformToMainDataset() {
        transformToDataset(null);
    }

    /** {@inheritDoc} */
    @Override
    public void transformToDataset(DRIDesignDataset dataset) {
        if (dataset != null) {
            expressionTransform = datasetTransform.getDatasetExpressionTransform(dataset);
        } else {
            expressionTransform = mainDatasetExpressionTransform;
        }
    }

    /** {@inheritDoc} */
    @Override
    public AbstractExpressionTransform getExpressionTransform() {
        return expressionTransform;
    }

    /** {@inheritDoc} */
    @Override
    public AbstractExpressionTransform getExpressionTransform(DRIDesignDataset dataset) {
        if (dataset == null) {
            return mainDatasetExpressionTransform;
        } else {
            return getDatasetTransform().getDatasetExpressionTransform(dataset);
        }
    }

    /** {@inheritDoc} */
    @Override
    public GroupTransform getGroupTransform() {
        return groupTransform;
    }

    /** {@inheritDoc} */
    @Override
    public StyleTransform getStyleTransform() {
        return styleTransform;
    }

    /** {@inheritDoc} */
    @Override
    public DatasetTransform getDatasetTransform() {
        return datasetTransform;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignReport getReport() {
        return report;
    }

    /** {@inheritDoc} */
    @Override
    public JasperCustomValues getCustomValues() {
        return jasperReportDesign.getCustomValues();
    }

    /** {@inheritDoc} */
    @Override
    public JasperDesign getDesign() {
        return jasperReportDesign.getDesign();
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, Object> getParameters() {
        return jasperReportDesign.getParameters();
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, Object> getParameterValues() {
        return report.getParameterValues();
    }

    /** {@inheritDoc} */
    @Override
    public Integer getStartPageNumber() {
        return jasperReportDesign.getStartPageNumber();
    }

    /** {@inheritDoc} */
    @Override
    public ReportParameters getMasterReportParameters() {
        return jasperReportDesign.getMasterReportParameters();
    }
}

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
package net.sf.dynamicreports.design.base;

import net.sf.dynamicreports.design.definition.DRIDesignDataset;
import net.sf.dynamicreports.design.definition.DRIDesignField;
import net.sf.dynamicreports.design.definition.DRIDesignParameter;
import net.sf.dynamicreports.design.definition.DRIDesignReport;
import net.sf.dynamicreports.design.definition.DRIDesignSort;
import net.sf.dynamicreports.design.definition.DRIDesignTemplateDesign;
import net.sf.dynamicreports.design.definition.DRIDesignVariable;
import net.sf.dynamicreports.design.definition.expression.DRIDesignComplexExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignJasperExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSimpleExpression;
import net.sf.dynamicreports.design.definition.expression.DRIDesignSystemExpression;
import net.sf.dynamicreports.design.definition.style.DRIDesignStyle;
import net.sf.dynamicreports.design.transformation.AbstractExpressionTransform;
import net.sf.dynamicreports.design.transformation.BandTransform;
import net.sf.dynamicreports.design.transformation.BarcodeTransform;
import net.sf.dynamicreports.design.transformation.ChartTransform;
import net.sf.dynamicreports.design.transformation.ColumnGridTransform;
import net.sf.dynamicreports.design.transformation.ColumnTransform;
import net.sf.dynamicreports.design.transformation.ComponentTransform;
import net.sf.dynamicreports.design.transformation.CrosstabTransform;
import net.sf.dynamicreports.design.transformation.DatasetTransform;
import net.sf.dynamicreports.design.transformation.DesignTransformAccessor;
import net.sf.dynamicreports.design.transformation.GroupTransform;
import net.sf.dynamicreports.design.transformation.MainDatasetExpressionTransform;
import net.sf.dynamicreports.design.transformation.PageTransform;
import net.sf.dynamicreports.design.transformation.ReportTransform;
import net.sf.dynamicreports.design.transformation.StyleTransform;
import net.sf.dynamicreports.design.transformation.SubtotalTransform;
import net.sf.dynamicreports.design.transformation.TableOfContentsTransform;
import net.sf.dynamicreports.design.transformation.TemplateTransform;
import net.sf.dynamicreports.jasper.base.tableofcontents.JasperTocHeading;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.constant.RunDirection;
import net.sf.dynamicreports.report.constant.WhenNoDataType;
import net.sf.dynamicreports.report.constant.WhenResourceMissingType;
import net.sf.dynamicreports.report.definition.DRIDataset;
import net.sf.dynamicreports.report.definition.DRIReport;
import net.sf.dynamicreports.report.definition.DRIScriptlet;
import net.sf.dynamicreports.report.definition.DRITableOfContentsCustomizer;
import net.sf.dynamicreports.report.exception.DRException;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * <p>DRDesignReport class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignReport implements DesignTransformAccessor, DRIDesignReport {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIReport report;
    private Integer pageWidth;
    private Map<String, JasperTocHeading> tocHeadings;
    private ReportTransform reportTransform;
    private TemplateTransform templateTransform;
    private PageTransform pageTransform;
    private MainDatasetExpressionTransform mainDatasetExpressionTransform;
    private BandTransform bandTransform;
    private ComponentTransform componentTransform;
    private GroupTransform groupTransform;
    private ColumnGridTransform columnGridTransform;
    private ColumnTransform columnTransform;
    private SubtotalTransform subtotalTransform;
    private StyleTransform styleTransform;
    private ChartTransform chartTransform;
    private BarcodeTransform barcodeTransform;
    private CrosstabTransform crosstabTransform;
    private DatasetTransform datasetTransform;
    private TableOfContentsTransform tableOfContentsTransform;
    private AbstractExpressionTransform expressionTransform;

    /**
     * <p>Constructor for DRDesignReport.</p>
     *
     * @param report a {@link net.sf.dynamicreports.report.definition.DRIReport} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public DRDesignReport(DRIReport report) throws DRException {
        this(report, null, null);
    }

    /**
     * <p>Constructor for DRDesignReport.</p>
     *
     * @param report a {@link net.sf.dynamicreports.report.definition.DRIReport} object.
     * @param pageWidth a {@link java.lang.Integer} object.
     * @param tocHeadings a {@link java.util.Map} object.
     * @throws net.sf.dynamicreports.report.exception.DRException if any.
     */
    public DRDesignReport(DRIReport report, Integer pageWidth, Map<String, JasperTocHeading> tocHeadings) throws DRException {
        this.report = report;
        this.pageWidth = pageWidth;
        this.tocHeadings = tocHeadings;
        init();
        transform();
    }

    private void init() {
        reportTransform = new ReportTransform(this);
        templateTransform = new TemplateTransform(this);
        pageTransform = new PageTransform(this);
        mainDatasetExpressionTransform = new MainDatasetExpressionTransform(this);
        groupTransform = new GroupTransform(this);
        bandTransform = new BandTransform(this);
        componentTransform = new ComponentTransform(this);
        columnGridTransform = new ColumnGridTransform(this);
        columnTransform = new ColumnTransform(this);
        subtotalTransform = new SubtotalTransform(this);
        styleTransform = new StyleTransform(this);
        chartTransform = new ChartTransform(this);
        barcodeTransform = new BarcodeTransform(this);
        crosstabTransform = new CrosstabTransform(this);
        datasetTransform = new DatasetTransform(this);
        tableOfContentsTransform = new TableOfContentsTransform(this);
        transformToMainDataset();
    }

    private void transform() throws DRException {
        reportTransform.transform();
        pageTransform.transform();
        groupTransform.transform();
        mainDatasetExpressionTransform.transform();
        bandTransform.transform();
        columnGridTransform.transform();
        columnTransform.transform();
        groupTransform.transformHeaderAndFooter();
        pageTransform.transformPageWidth();
        subtotalTransform.transform();
        bandTransform.prepareBands();
        styleTransform.transformTemplateStyles();
    }

    /** {@inheritDoc} */
    @Override
    public DRIReport getReport() {
        return report;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getPageWidth() {
        return pageWidth;
    }

    /** {@inheritDoc} */
    @Override
    public ReportTransform getReportTransform() {
        return reportTransform;
    }

    /** {@inheritDoc} */
    @Override
    public TemplateTransform getTemplateTransform() {
        return templateTransform;
    }

    /** {@inheritDoc} */
    @Override
    public PageTransform getPageTransform() {
        return pageTransform;
    }

    /** {@inheritDoc} */
    @Override
    public void transformToMainDataset() {
        transformToDataset(null);
    }

    /** {@inheritDoc} */
    @Override
    public void transformToDataset(DRIDataset dataset) {
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
    public BandTransform getBandTransform() {
        return bandTransform;
    }

    /** {@inheritDoc} */
    @Override
    public ComponentTransform getComponentTransform() {
        return componentTransform;
    }

    /** {@inheritDoc} */
    @Override
    public GroupTransform getGroupTransform() {
        return groupTransform;
    }

    /** {@inheritDoc} */
    @Override
    public ColumnTransform getColumnTransform() {
        return columnTransform;
    }

    /** {@inheritDoc} */
    @Override
    public ColumnGridTransform getColumnGridTransform() {
        return columnGridTransform;
    }

    /** {@inheritDoc} */
    @Override
    public StyleTransform getStyleTransform() {
        return styleTransform;
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
    public DatasetTransform getDatasetTransform() {
        return datasetTransform;
    }

    /** {@inheritDoc} */
    @Override
    public TableOfContentsTransform getTableOfContentsTransform() {
        return tableOfContentsTransform;
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignTemplateDesign getTemplateDesign() {
        return reportTransform.getTemplateDesign();
    }

    /** {@inheritDoc} */
    @Override
    public String getReportName() {
        return templateTransform.getReportName();
    }

    /** {@inheritDoc} */
    @Override
    public Locale getLocale() {
        return templateTransform.getLocale();
    }

    /** {@inheritDoc} */
    @Override
    public ResourceBundle getResourceBundle() {
        return report.getResourceBundle();
    }

    /** {@inheritDoc} */
    @Override
    public String getResourceBundleName() {
        return templateTransform.getResourceBundleName();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isIgnorePagination() {
        return templateTransform.isIgnorePagination();
    }

    /** {@inheritDoc} */
    @Override
    public Properties getProperties() {
        return report.getProperties();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignQuery getQuery() {
        return reportTransform.getQuery();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignPage getPage() {
        return pageTransform.getPage();
    }

    /** {@inheritDoc} */
    @Override
    public WhenNoDataType getWhenNoDataType() {
        return templateTransform.getWhenNoDataType(getDetailBands().isEmpty(), getNoDataBand());
    }

    /** {@inheritDoc} */
    @Override
    public WhenResourceMissingType getWhenResourceMissingType() {
        return templateTransform.getWhenResourceMissingType();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isTitleOnANewPage() {
        return templateTransform.isTitleOnANewPage();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isSummaryOnANewPage() {
        return templateTransform.isSummaryOnANewPage();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isSummaryWithPageHeaderAndFooter() {
        return templateTransform.isSummaryWithPageHeaderAndFooter();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isFloatColumnFooter() {
        return templateTransform.isFloatColumnFooter();
    }

    /** {@inheritDoc} */
    @Override
    public Orientation getPrintOrder() {
        return templateTransform.getPrintOrder();
    }

    /** {@inheritDoc} */
    @Override
    public RunDirection getColumnDirection() {
        return templateTransform.getColumnDirection();
    }

    /** {@inheritDoc} */
    @Override
    public String getLanguage() {
        return templateTransform.getLanguage();
    }

    /** {@inheritDoc} */
    @Override
    public boolean isTableOfContents() {
        return templateTransform.isTableOfContents(tocHeadings);
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, JasperTocHeading> getTableOfContentsHeadings() {
        return tocHeadings;
    }

    /** {@inheritDoc} */
    @Override
    public DRITableOfContentsCustomizer getTableOfContentsCustomizer() {
        return templateTransform.getTableOfContentsCustomizer();
    }

    /** {@inheritDoc} */
    @Override
    public DRIDesignExpression getFilterExpression() {
        return reportTransform.getFilterExpression();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRIDesignParameter> getParameters() {
        return reportTransform.getParameters();
    }

    /** {@inheritDoc} */
    @Override
    public Map<String, Object> getParameterValues() {
        return report.getParameterValues();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRIScriptlet> getScriptlets() {
        return report.getScriptlets();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRIDesignField> getFields() {
        return mainDatasetExpressionTransform.getFields();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRIDesignSystemExpression> getSystemExpressions() {
        return mainDatasetExpressionTransform.getSystemExpressions();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRIDesignJasperExpression> getJasperExpressions() {
        return mainDatasetExpressionTransform.getJasperExpressions();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRIDesignSimpleExpression> getSimpleExpressions() {
        return mainDatasetExpressionTransform.getSimpleExpressions();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRIDesignStyle> getStyles() {
        return styleTransform.getStyles();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRDesignGroup> getGroups() {
        return groupTransform.getGroups();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRIDesignVariable> getVariables() {
        return mainDatasetExpressionTransform.getVariables();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRIDesignComplexExpression> getComplexExpressions() {
        return mainDatasetExpressionTransform.getComplexExpressions();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRIDesignSort> getSorts() {
        return mainDatasetExpressionTransform.getSorts();
    }

    /** {@inheritDoc} */
    @Override
    public Collection<DRIDesignDataset> getDatasets() {
        return datasetTransform.getDatasets();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignBand getTitleBand() {
        return bandTransform.getTitleBand();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignBand getPageHeaderBand() {
        return bandTransform.getPageHeaderBand();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignBand getPageFooterBand() {
        return bandTransform.getPageFooterBand();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignBand getColumnHeaderBand() {
        return bandTransform.getColumnHeaderBand();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignBand getColumnFooterBand() {
        return bandTransform.getColumnFooterBand();
    }

    /** {@inheritDoc} */
    @Override
    public List<DRDesignBand> getDetailBands() {
        return bandTransform.getDetailBands();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignBand getLastPageFooterBand() {
        return bandTransform.getLastPageFooterBand();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignBand getSummaryBand() {
        return bandTransform.getSummaryBand();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignBand getNoDataBand() {
        return bandTransform.getNoDataBand();
    }

    /** {@inheritDoc} */
    @Override
    public DRDesignBand getBackgroundBand() {
        return bandTransform.getBackgroundBand();
    }
}

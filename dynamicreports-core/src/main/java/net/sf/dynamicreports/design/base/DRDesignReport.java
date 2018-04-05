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

package net.sf.dynamicreports.design.base;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

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

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
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

	public DRDesignReport(DRIReport report) throws DRException {
		this(report, null, null);
	}

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

	@Override
	public DRIReport getReport() {
		return report;
	}

	@Override
	public Integer getPageWidth() {
		return pageWidth;
	}

	@Override
	public ReportTransform getReportTransform() {
		return reportTransform;
	}

	@Override
	public TemplateTransform getTemplateTransform() {
		return templateTransform;
	}

	@Override
	public PageTransform getPageTransform() {
		return pageTransform;
	}

	@Override
	public void transformToMainDataset() {
		transformToDataset(null);
	}

	@Override
	public void transformToDataset(DRIDataset dataset) {
		if (dataset != null) {
			expressionTransform = datasetTransform.getDatasetExpressionTransform(dataset);
		} else {
			expressionTransform = mainDatasetExpressionTransform;
		}
	}

	@Override
	public AbstractExpressionTransform getExpressionTransform() {
		return expressionTransform;
	}

	@Override
	public BandTransform getBandTransform() {
		return bandTransform;
	}

	@Override
	public ComponentTransform getComponentTransform() {
		return componentTransform;
	}

	@Override
	public GroupTransform getGroupTransform() {
		return groupTransform;
	}

	@Override
	public ColumnTransform getColumnTransform() {
		return columnTransform;
	}

	@Override
	public ColumnGridTransform getColumnGridTransform() {
		return columnGridTransform;
	}

	@Override
	public StyleTransform getStyleTransform() {
		return styleTransform;
	}

	@Override
	public ChartTransform getChartTransform() {
		return chartTransform;
	}

	@Override
	public BarcodeTransform getBarcodeTransform() {
		return barcodeTransform;
	}

	@Override
	public CrosstabTransform getCrosstabTransform() {
		return crosstabTransform;
	}

	@Override
	public DatasetTransform getDatasetTransform() {
		return datasetTransform;
	}

	@Override
	public TableOfContentsTransform getTableOfContentsTransform() {
		return tableOfContentsTransform;
	}

	@Override
	public DRIDesignTemplateDesign getTemplateDesign() {
		return reportTransform.getTemplateDesign();
	}

	@Override
	public String getReportName() {
		return templateTransform.getReportName();
	}

	@Override
	public Locale getLocale() {
		return templateTransform.getLocale();
	}

	@Override
	public ResourceBundle getResourceBundle() {
		return report.getResourceBundle();
	}

	@Override
	public String getResourceBundleName() {
		return templateTransform.getResourceBundleName();
	}

	@Override
	public boolean isIgnorePagination() {
		return templateTransform.isIgnorePagination();
	}

	@Override
	public Properties getProperties() {
		return report.getProperties();
	}

	@Override
	public DRDesignQuery getQuery() {
		return reportTransform.getQuery();
	}

	@Override
	public DRDesignPage getPage() {
		return pageTransform.getPage();
	}

	@Override
	public WhenNoDataType getWhenNoDataType() {
		return templateTransform.getWhenNoDataType(getDetailBands().isEmpty(), getNoDataBand());
	}

	@Override
	public WhenResourceMissingType getWhenResourceMissingType() {
		return templateTransform.getWhenResourceMissingType();
	}

	@Override
	public boolean isTitleOnANewPage() {
		return templateTransform.isTitleOnANewPage();
	}

	@Override
	public boolean isSummaryOnANewPage() {
		return templateTransform.isSummaryOnANewPage();
	}

	@Override
	public boolean isSummaryWithPageHeaderAndFooter() {
		return templateTransform.isSummaryWithPageHeaderAndFooter();
	}

	@Override
	public boolean isFloatColumnFooter() {
		return templateTransform.isFloatColumnFooter();
	}

	@Override
	public Orientation getPrintOrder() {
		return templateTransform.getPrintOrder();
	}

	@Override
	public RunDirection getColumnDirection() {
		return templateTransform.getColumnDirection();
	}

	@Override
	public String getLanguage() {
		return templateTransform.getLanguage();
	}

	@Override
	public boolean isTableOfContents() {
		return templateTransform.isTableOfContents(tocHeadings);
	}

	@Override
	public Map<String, JasperTocHeading> getTableOfContentsHeadings() {
		return tocHeadings;
	}

	@Override
	public DRITableOfContentsCustomizer getTableOfContentsCustomizer() {
		return templateTransform.getTableOfContentsCustomizer();
	}

	@Override
	public DRIDesignExpression getFilterExpression() {
		return reportTransform.getFilterExpression();
	}

	@Override
	public Collection<DRIDesignParameter> getParameters() {
		return reportTransform.getParameters();
	}

	@Override
	public Map<String, Object> getParameterValues() {
		return report.getParameterValues();
	}

	@Override
	public Collection<DRIScriptlet> getScriptlets() {
		return report.getScriptlets();
	}

	@Override
	public Collection<DRIDesignField> getFields() {
		return mainDatasetExpressionTransform.getFields();
	}

	@Override
	public Collection<DRIDesignSystemExpression> getSystemExpressions() {
		return mainDatasetExpressionTransform.getSystemExpressions();
	}

	@Override
	public Collection<DRIDesignJasperExpression> getJasperExpressions() {
		return mainDatasetExpressionTransform.getJasperExpressions();
	}

	@Override
	public Collection<DRIDesignSimpleExpression> getSimpleExpressions() {
		return mainDatasetExpressionTransform.getSimpleExpressions();
	}

	@Override
	public Collection<DRIDesignStyle> getStyles() {
		return styleTransform.getStyles();
	}

	@Override
	public Collection<DRDesignGroup> getGroups() {
		return groupTransform.getGroups();
	}

	@Override
	public Collection<DRIDesignVariable> getVariables() {
		return mainDatasetExpressionTransform.getVariables();
	}

	@Override
	public Collection<DRIDesignComplexExpression> getComplexExpressions() {
		return mainDatasetExpressionTransform.getComplexExpressions();
	}

	@Override
	public Collection<DRIDesignSort> getSorts() {
		return mainDatasetExpressionTransform.getSorts();
	}

	@Override
	public Collection<DRIDesignDataset> getDatasets() {
		return datasetTransform.getDatasets();
	}

	@Override
	public DRDesignBand getTitleBand() {
		return bandTransform.getTitleBand();
	}

	@Override
	public DRDesignBand getPageHeaderBand() {
		return bandTransform.getPageHeaderBand();
	}

	@Override
	public DRDesignBand getPageFooterBand() {
		return bandTransform.getPageFooterBand();
	}

	@Override
	public DRDesignBand getColumnHeaderBand() {
		return bandTransform.getColumnHeaderBand();
	}

	@Override
	public DRDesignBand getColumnFooterBand() {
		return bandTransform.getColumnFooterBand();
	}

	@Override
	public List<DRDesignBand> getDetailBands() {
		return bandTransform.getDetailBands();
	}

	@Override
	public DRDesignBand getLastPageFooterBand() {
		return bandTransform.getLastPageFooterBand();
	}

	@Override
	public DRDesignBand getSummaryBand() {
		return bandTransform.getSummaryBand();
	}

	@Override
	public DRDesignBand getNoDataBand() {
		return bandTransform.getNoDataBand();
	}

	@Override
	public DRDesignBand getBackgroundBand() {
		return bandTransform.getBackgroundBand();
	}
}

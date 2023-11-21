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
package net.sf.dynamicreports.jasper.transformation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.sf.dynamicreports.design.constant.EvaluationTime;
import net.sf.dynamicreports.design.constant.ResetType;
import net.sf.dynamicreports.design.definition.DRIDesignHyperLink;
import net.sf.dynamicreports.design.definition.chart.DRIDesignChart;
import net.sf.dynamicreports.design.definition.chart.DRIDesignChartLegend;
import net.sf.dynamicreports.design.definition.chart.DRIDesignChartSubtitle;
import net.sf.dynamicreports.design.definition.chart.DRIDesignChartTitle;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignCategoryChartSerie;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignCategoryDataset;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignChartDataset;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignChartSerie;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignGanttChartSerie;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignHighLowDataset;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignSeriesDataset;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignTimeSeriesDataset;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignValueDataset;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignXyChartSerie;
import net.sf.dynamicreports.design.definition.chart.dataset.DRIDesignXyzChartSerie;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignAxisFormat;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignAxisPlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignBar3DPlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignBarPlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignBasePlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignBubblePlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignCandlestickPlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignChartAxis;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignHighLowPlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignLinePlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignMeterInterval;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignMeterPlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignMultiAxisPlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignPie3DPlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignPiePlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignSpiderPlot;
import net.sf.dynamicreports.design.definition.chart.plot.DRIDesignThermometerPlot;
import net.sf.dynamicreports.jasper.base.JasperChartCustomizer;
import net.sf.dynamicreports.jasper.exception.JasperDesignException;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.MeterShape;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
import net.sf.jasperreports.charts.design.JRDesignAreaPlot;
import net.sf.jasperreports.charts.design.JRDesignBar3DPlot;
import net.sf.jasperreports.charts.design.JRDesignBarPlot;
import net.sf.jasperreports.charts.design.JRDesignBubblePlot;
import net.sf.jasperreports.charts.design.JRDesignCandlestickPlot;
import net.sf.jasperreports.charts.design.JRDesignCategoryDataset;
import net.sf.jasperreports.charts.design.JRDesignCategorySeries;
import net.sf.jasperreports.charts.design.JRDesignChartAxis;
import net.sf.jasperreports.charts.design.JRDesignDataRange;
import net.sf.jasperreports.charts.design.JRDesignGanttDataset;
import net.sf.jasperreports.charts.design.JRDesignGanttSeries;
import net.sf.jasperreports.charts.design.JRDesignHighLowDataset;
import net.sf.jasperreports.charts.design.JRDesignHighLowPlot;
import net.sf.jasperreports.charts.design.JRDesignLinePlot;
import net.sf.jasperreports.charts.design.JRDesignMeterPlot;
import net.sf.jasperreports.charts.design.JRDesignMultiAxisPlot;
import net.sf.jasperreports.charts.design.JRDesignPie3DPlot;
import net.sf.jasperreports.charts.design.JRDesignPieDataset;
import net.sf.jasperreports.charts.design.JRDesignPiePlot;
import net.sf.jasperreports.charts.design.JRDesignPieSeries;
import net.sf.jasperreports.charts.design.JRDesignScatterPlot;
import net.sf.jasperreports.charts.design.JRDesignThermometerPlot;
import net.sf.jasperreports.charts.design.JRDesignTimeSeries;
import net.sf.jasperreports.charts.design.JRDesignTimeSeriesDataset;
import net.sf.jasperreports.charts.design.JRDesignTimeSeriesPlot;
import net.sf.jasperreports.charts.design.JRDesignValueDataset;
import net.sf.jasperreports.charts.design.JRDesignValueDisplay;
import net.sf.jasperreports.charts.design.JRDesignXyDataset;
import net.sf.jasperreports.charts.design.JRDesignXySeries;
import net.sf.jasperreports.charts.design.JRDesignXyzDataset;
import net.sf.jasperreports.charts.design.JRDesignXyzSeries;
import net.sf.jasperreports.charts.util.JRMeterInterval;
import net.sf.jasperreports.components.ComponentsExtensionsRegistryFactory;
import net.sf.jasperreports.components.charts.ChartSettings;
import net.sf.jasperreports.components.spiderchart.SpiderChartComponent;
import net.sf.jasperreports.components.spiderchart.StandardChartSettings;
import net.sf.jasperreports.components.spiderchart.StandardSpiderDataset;
import net.sf.jasperreports.components.spiderchart.StandardSpiderPlot;
import net.sf.jasperreports.engine.JRChartPlot;
import net.sf.jasperreports.engine.JRChartPlot.JRSeriesColor;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRHyperlinkHelper;
import net.sf.jasperreports.engine.base.JRBaseChartPlot;
import net.sf.jasperreports.engine.component.ComponentKey;
import net.sf.jasperreports.engine.design.JRDesignChart;
import net.sf.jasperreports.engine.design.JRDesignChartDataset;
import net.sf.jasperreports.engine.design.JRDesignComponentElement;
import net.sf.jasperreports.engine.design.JRDesignElement;
import net.sf.jasperreports.engine.design.JRDesignElementDataset;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.type.HyperlinkTargetEnum;
import net.sf.jasperreports.engine.type.HyperlinkTypeEnum;

/**
 * <p>ChartTransform class.</p>
 *
 * @author Ricardo Mariaca
 *
 */
public class ChartTransform {
    private final JasperTransformAccessor accessor;

    /**
     * <p>Constructor for ChartTransform.</p>
     *
     * @param accessor a {@link net.sf.dynamicreports.jasper.transformation.JasperTransformAccessor} object.
     */
    public ChartTransform(JasperTransformAccessor accessor) {
        this.accessor = accessor;
    }

    // chart

    /**
     * <p>transform.</p>
     *
     * @param chart a {@link net.sf.dynamicreports.design.definition.chart.DRIDesignChart} object.
     * @return a {@link net.sf.jasperreports.engine.design.JRDesignElement} object.
     */
    protected JRDesignElement transform(DRIDesignChart chart) {
        if (chart.getChartType().equals(ChartType.SPIDER)) {
            return spiderChart(chart);
        } else {
            return chart(chart);
        }
    }

    private JRDesignChart chart(DRIDesignChart chart) {
        final JRDesignChart jrChart = new JRDesignChart(new JRDesignStyle().getDefaultStyleProvider(), ConstantTransform.chartType(chart.getChartType()));
        final EvaluationTime evaluationTime = chart.getEvaluationTime();
        jrChart.setEvaluationTime(ConstantTransform.evaluationTime(evaluationTime));
        if (evaluationTime != null && evaluationTime.equals(EvaluationTime.GROUP) && chart.getEvaluationGroup() != null) {
            jrChart.setEvaluationGroup(accessor.getGroupTransform().getGroup(chart.getEvaluationGroup()));
        }

        if (chart.getChartType().equals(ChartType.XYBAR)) {
            jrChart.setDataset(new JRDesignXyDataset(null));
        }
        jrChart.setTheme(chart.getTheme());

        jrChart.setAnchorNameExpression(accessor.getExpressionTransform().getExpression(chart.getAnchorNameExpression()));
        if (chart.getBookmarkLevel() != null) {
            jrChart.setBookmarkLevel(chart.getBookmarkLevel());
        }

        final DRIDesignHyperLink hyperLink = chart.getHyperLink();
        if (hyperLink != null) {
            jrChart.setHyperlinkAnchorExpression(accessor.getExpressionTransform().getExpression(hyperLink.getAnchorExpression()));
            jrChart.setHyperlinkPageExpression(accessor.getExpressionTransform().getExpression(hyperLink.getPageExpression()));
            jrChart.setHyperlinkReferenceExpression(accessor.getExpressionTransform().getExpression(hyperLink.getReferenceExpression()));
            jrChart.setHyperlinkTooltipExpression(accessor.getExpressionTransform().getExpression(hyperLink.getTooltipExpression()));
            if (hyperLink.getType() != null) {
                final HyperlinkTypeEnum hyperLinkType = ConstantTransform.hyperLinkType(hyperLink.getType());
                if (hyperLinkType != null) {
                    jrChart.setHyperlinkType(hyperLinkType);
                } else {
                    jrChart.setLinkType(hyperLink.getType());
                }
            }
            if (hyperLink.getTarget() != null) {
                final HyperlinkTargetEnum hyperLinkTarget = ConstantTransform.hyperLinkTarget(hyperLink.getTarget());
                if (hyperLinkTarget != null) {
                    jrChart.setHyperlinkTarget(hyperLinkTarget);
                } else {
                    jrChart.setLinkTarget(hyperLink.getTarget());
                }
            }
        }

        final DRIDesignChartTitle title = chart.getTitle();
        jrChart.setTitleColor(title.getColor());
        if (title.getFont() != null) {
            jrChart.setTitleFont(accessor.getStyleTransform().font(title.getFont()));
        }
        jrChart.setTitleExpression(accessor.getExpressionTransform().getExpression(title.getTitle()));
        jrChart.setTitlePosition(ConstantTransform.chartPosition(title.getPosition()));

        final DRIDesignChartSubtitle subtitle = chart.getSubtitle();
        jrChart.setSubtitleColor(subtitle.getColor());
        if (subtitle.getFont() != null) {
            jrChart.setSubtitleFont(accessor.getStyleTransform().font(subtitle.getFont()));
        }
        jrChart.setSubtitleExpression(accessor.getExpressionTransform().getExpression(subtitle.getTitle()));

        final DRIDesignChartLegend legend = chart.getLegend();
        jrChart.setLegendColor(legend.getColor());
        jrChart.setLegendBackgroundColor(legend.getBackgroundColor());
        jrChart.setShowLegend(legend.getShowLegend());
        if (legend.getFont() != null) {
            jrChart.setLegendFont(accessor.getStyleTransform().font(legend.getFont()));
        }
        jrChart.setLegendPosition(ConstantTransform.chartPosition(legend.getPosition()));

        if (!chart.getCustomizers().isEmpty()) {
            jrChart.setCustomizerClass(JasperChartCustomizer.class.getName());
            jrChart.setKey(chart.getUniqueName());
            addChartCustomizer(chart.getUniqueName(), chart.getCustomizers());
        }

        dataset(chart.getDataset(), (JRDesignChartDataset) jrChart.getDataset());
        plot((DRIDesignBasePlot) chart.getPlot(), jrChart.getPlot(), jrChart);

        return jrChart;
    }

    private JRDesignElement spiderChart(DRIDesignChart chart) {
        final SpiderChartComponent jrChart = new SpiderChartComponent();

        final EvaluationTime evaluationTime = chart.getEvaluationTime();
        jrChart.setEvaluationTime(ConstantTransform.evaluationTime(evaluationTime));
        if (evaluationTime != null && evaluationTime.equals(EvaluationTime.GROUP) && chart.getEvaluationGroup() != null) {
            jrChart.setEvaluationGroup(accessor.getGroupTransform().getGroup(chart.getEvaluationGroup()).getName());
        }

        jrChart.setChartSettings(spiderSettings(chart));
        final StandardSpiderDataset jrDataset = new StandardSpiderDataset();
        dataset(chart.getDataset(), jrDataset);
        jrChart.setDataset(jrDataset);
        final StandardSpiderPlot jrPlot = new StandardSpiderPlot();
        jrChart.setPlot(jrPlot);
        spiderPlot((DRIDesignSpiderPlot) chart.getPlot(), jrPlot);

        final JRDesignComponentElement jrComponent = new JRDesignComponentElement();
        jrComponent.setComponent(jrChart);
        jrComponent.setComponentKey(new ComponentKey(ComponentsExtensionsRegistryFactory.NAMESPACE, "jr", "spiderChart"));

        return jrComponent;
    }

    private void addChartCustomizer(String name, List<DRIChartCustomizer> chartCustomizers) {
        accessor.getCustomValues().addChartCustomizers(name, chartCustomizers);
    }

    // dataset
    private void dataset(DRIDesignChartDataset dataset, JRDesignElementDataset jrDataset) {
        if (dataset == null) {
            return;
        }

        jrDataset.setDatasetRun(accessor.getDatasetTransform().datasetRun(dataset.getSubDataset()));
        final ResetType resetType = dataset.getResetType();
        jrDataset.setResetType(ConstantTransform.variableDatasetResetType(resetType));
        if (resetType.equals(ResetType.GROUP) && dataset.getResetGroup() != null) {
            jrDataset.setResetGroup(accessor.getGroupTransform().getGroup(dataset.getResetGroup()));
        }

        accessor.transformToDataset(dataset.getSubDataset());
        if (jrDataset instanceof JRDesignCategoryDataset) {
            categoryDataset((DRIDesignCategoryDataset) dataset, (JRDesignCategoryDataset) jrDataset);
        } else if (jrDataset instanceof JRDesignPieDataset) {
            pieDataset((DRIDesignSeriesDataset) dataset, (JRDesignPieDataset) jrDataset);
        } else if (jrDataset instanceof JRDesignTimeSeriesDataset) {
            timeSeriesDataset((DRIDesignTimeSeriesDataset) dataset, (JRDesignTimeSeriesDataset) jrDataset);
        } else if (jrDataset instanceof JRDesignXyDataset) {
            xyDataset((DRIDesignSeriesDataset) dataset, (JRDesignXyDataset) jrDataset);
        } else if (jrDataset instanceof StandardSpiderDataset) {
            spiderDataset((DRIDesignCategoryDataset) dataset, (StandardSpiderDataset) jrDataset);
        } else if (jrDataset instanceof JRDesignXyzDataset) {
            xyzDataset((DRIDesignSeriesDataset) dataset, (JRDesignXyzDataset) jrDataset);
        } else if (jrDataset instanceof JRDesignGanttDataset) {
            ganttDataset((DRIDesignSeriesDataset) dataset, (JRDesignGanttDataset) jrDataset);
        } else if (jrDataset instanceof JRDesignHighLowDataset) {
            highLowDataset((DRIDesignHighLowDataset) dataset, (JRDesignHighLowDataset) jrDataset);
        } else if (jrDataset instanceof JRDesignValueDataset) {
            valueDataset((DRIDesignValueDataset) dataset, (JRDesignValueDataset) jrDataset);
        } else {
            throw new JasperDesignException("Dataset " + dataset.getClass().getName() + " not supported");
        }
        accessor.transformToMainDataset();
    }

    private void categoryDataset(DRIDesignCategoryDataset dataset, JRDesignCategoryDataset jrDataset) {
        final List<JRDesignCategorySeries> jrSeries = categorySeries(dataset);
        for (final JRDesignCategorySeries jrSerie : jrSeries) {
            jrDataset.addCategorySeries(jrSerie);
        }
    }

    private List<JRDesignCategorySeries> categorySeries(DRIDesignCategoryDataset dataset) {
        final List<JRDesignCategorySeries> series = new ArrayList<>();

        final AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        final JRDesignExpression exp1 = expressionTransform.getExpression(dataset.getValueExpression());
        for (final DRIDesignChartSerie serie : dataset.getSeries()) {
            final DRIDesignCategoryChartSerie categorySerie = (DRIDesignCategoryChartSerie) serie;
            final JRDesignCategorySeries jrSerie = new JRDesignCategorySeries();
            jrSerie.setItemHyperlink(accessor.getReportTransform().hyperLink(categorySerie.getItemHyperLink()));
            jrSerie.setValueExpression(expressionTransform.getExpression(categorySerie.getValueExpression()));

            final JRDesignExpression exp2 = expressionTransform.getExpression(categorySerie.getLabelExpression());
            final JRDesignExpression seriesExpression = expressionTransform.getExpression(serie.getSeriesExpression());
            if (dataset.isUseSeriesAsCategory()) {
                jrSerie.setCategoryExpression(exp2);
                if (seriesExpression != null) {
                    jrSerie.setSeriesExpression(seriesExpression);
                } else {
                    jrSerie.setSeriesExpression(exp1);
                }
                jrSerie.setLabelExpression(exp1);
            } else {
                jrSerie.setCategoryExpression(exp1);
                if (seriesExpression != null) {
                    jrSerie.setSeriesExpression(seriesExpression);
                } else {
                    jrSerie.setSeriesExpression(exp2);
                }
                jrSerie.setLabelExpression(exp2);
            }
            series.add(jrSerie);
        }

        return series;
    }

    private void pieDataset(DRIDesignSeriesDataset dataset, JRDesignPieDataset jrDataset) {
        final AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        final JRDesignExpression exp1 = expressionTransform.getExpression(dataset.getValueExpression());
        for (final DRIDesignChartSerie serie : dataset.getSeries()) {
            final DRIDesignCategoryChartSerie categorySerie = (DRIDesignCategoryChartSerie) serie;
            final JRDesignPieSeries jrSerie = new JRDesignPieSeries();
            jrSerie.setSectionHyperlink(accessor.getReportTransform().hyperLink(categorySerie.getItemHyperLink()));
            jrSerie.setKeyExpression(exp1);
            jrSerie.setValueExpression(expressionTransform.getExpression(categorySerie.getValueExpression()));
            jrDataset.addPieSeries(jrSerie);
        }
    }

    private void timeSeriesDataset(DRIDesignTimeSeriesDataset dataset, JRDesignTimeSeriesDataset jrDataset) {
        final AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        if (dataset.getTimePeriodType() != null) {
            jrDataset.setTimePeriod(ConstantTransform.timePeriodType(dataset.getTimePeriodType()));
        }

        final JRDesignExpression exp1 = expressionTransform.getExpression(dataset.getValueExpression());
        for (final DRIDesignChartSerie serie : dataset.getSeries()) {
            final DRIDesignCategoryChartSerie categorySerie = (DRIDesignCategoryChartSerie) serie;
            final JRDesignTimeSeries jrSerie = new JRDesignTimeSeries();
            jrSerie.setItemHyperlink(accessor.getReportTransform().hyperLink(categorySerie.getItemHyperLink()));
            jrSerie.setTimePeriodExpression(exp1);
            jrSerie.setValueExpression(expressionTransform.getExpression(categorySerie.getValueExpression()));
            final JRDesignExpression seriesExpression = expressionTransform.getExpression(serie.getSeriesExpression());
            final JRDesignExpression labelExpression = expressionTransform.getExpression(categorySerie.getLabelExpression());
            if (seriesExpression != null) {
                jrSerie.setSeriesExpression(seriesExpression);
            } else {
                jrSerie.setSeriesExpression(labelExpression);
            }
            jrSerie.setLabelExpression(labelExpression);
            jrDataset.addTimeSeries(jrSerie);
        }
    }

    private void xyDataset(DRIDesignSeriesDataset dataset, JRDesignXyDataset jrDataset) {
        final AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        for (final DRIDesignChartSerie serie : dataset.getSeries()) {
            final DRIDesignXyChartSerie xySerie = (DRIDesignXyChartSerie) serie;
            final JRDesignXySeries jrSerie = new JRDesignXySeries();
            jrSerie.setItemHyperlink(accessor.getReportTransform().hyperLink(xySerie.getItemHyperLink()));
            if (xySerie.getXValueExpression() != null) {
                jrSerie.setXValueExpression(expressionTransform.getExpression(xySerie.getXValueExpression()));
            } else {
                jrSerie.setXValueExpression(expressionTransform.getExpression(dataset.getValueExpression()));
            }
            jrSerie.setYValueExpression(expressionTransform.getExpression(xySerie.getYValueExpression()));
            final JRDesignExpression seriesExpression = expressionTransform.getExpression(serie.getSeriesExpression());
            final JRDesignExpression labelExpression = expressionTransform.getExpression(xySerie.getLabelExpression());
            if (seriesExpression != null) {
                jrSerie.setSeriesExpression(seriesExpression);
            } else {
                jrSerie.setSeriesExpression(labelExpression);
            }
            jrSerie.setLabelExpression(labelExpression);
            jrDataset.addXySeries(jrSerie);
        }
    }

    private void xyzDataset(DRIDesignSeriesDataset dataset, JRDesignXyzDataset jrDataset) {
        final AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        for (final DRIDesignChartSerie serie : dataset.getSeries()) {
            final DRIDesignXyzChartSerie xyzSerie = (DRIDesignXyzChartSerie) serie;
            final JRDesignXyzSeries jrSerie = new JRDesignXyzSeries();
            jrSerie.setItemHyperlink(accessor.getReportTransform().hyperLink(xyzSerie.getItemHyperLink()));
            if (xyzSerie.getXValueExpression() != null) {
                jrSerie.setXValueExpression(expressionTransform.getExpression(xyzSerie.getXValueExpression()));
            } else {
                jrSerie.setXValueExpression(expressionTransform.getExpression(dataset.getValueExpression()));
            }
            jrSerie.setYValueExpression(expressionTransform.getExpression(xyzSerie.getYValueExpression()));
            jrSerie.setZValueExpression(expressionTransform.getExpression(xyzSerie.getZValueExpression()));
            jrSerie.setSeriesExpression(expressionTransform.getExpression(serie.getSeriesExpression()));
            jrDataset.addXyzSeries(jrSerie);
        }
    }

    private void ganttDataset(DRIDesignSeriesDataset dataset, JRDesignGanttDataset jrDataset) {
        final AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        final JRDesignExpression taskExpression = expressionTransform.getExpression(dataset.getValueExpression());
        for (final DRIDesignChartSerie serie : dataset.getSeries()) {
            final DRIDesignGanttChartSerie ganttSerie = (DRIDesignGanttChartSerie) serie;
            final JRDesignGanttSeries jrSerie = new JRDesignGanttSeries();
            jrSerie.setItemHyperlink(accessor.getReportTransform().hyperLink(ganttSerie.getItemHyperLink()));
            jrSerie.setTaskExpression(taskExpression);
            jrSerie.setSubtaskExpression(taskExpression);
            jrSerie.setStartDateExpression(expressionTransform.getExpression(ganttSerie.getStartDateExpression()));
            jrSerie.setEndDateExpression(expressionTransform.getExpression(ganttSerie.getEndDateExpression()));
            jrSerie.setPercentExpression(expressionTransform.getExpression(ganttSerie.getPercentExpression()));
            final JRDesignExpression seriesExpression = expressionTransform.getExpression(ganttSerie.getSeriesExpression());
            final JRDesignExpression labelExpression = expressionTransform.getExpression(ganttSerie.getLabelExpression());
            if (seriesExpression != null) {
                jrSerie.setSeriesExpression(seriesExpression);
            } else {
                jrSerie.setSeriesExpression(labelExpression);
            }
            jrSerie.setLabelExpression(labelExpression);

            jrDataset.addGanttSeries(jrSerie);
        }
    }

    private void highLowDataset(DRIDesignHighLowDataset dataset, JRDesignHighLowDataset jrDataset) {
        final AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        jrDataset.setItemHyperlink(accessor.getReportTransform().hyperLink(dataset.getItemHyperLink()));
        jrDataset.setSeriesExpression(expressionTransform.getExpression(dataset.getSeriesExpression()));
        jrDataset.setDateExpression(expressionTransform.getExpression(dataset.getDateExpression()));
        jrDataset.setHighExpression(expressionTransform.getExpression(dataset.getHighExpression()));
        jrDataset.setLowExpression(expressionTransform.getExpression(dataset.getLowExpression()));
        jrDataset.setOpenExpression(expressionTransform.getExpression(dataset.getOpenExpression()));
        jrDataset.setCloseExpression(expressionTransform.getExpression(dataset.getCloseExpression()));
        jrDataset.setVolumeExpression(expressionTransform.getExpression(dataset.getVolumeExpression()));
    }

    private void valueDataset(DRIDesignValueDataset dataset, JRDesignValueDataset jrDataset) {
        final AbstractExpressionTransform expressionTransform = accessor.getExpressionTransform();
        jrDataset.setValueExpression(expressionTransform.getExpression(dataset.getValueExpression()));
    }

    private void spiderDataset(DRIDesignCategoryDataset dataset, StandardSpiderDataset jrDataset) {
        final List<JRDesignCategorySeries> jrSeries = categorySeries(dataset);
        for (final JRDesignCategorySeries jrSerie : jrSeries) {
            jrDataset.addCategorySeries(jrSerie);
        }
    }

    // plot
    private void plot(DRIDesignBasePlot plot, JRChartPlot jrPlot, JRDesignChart jrChart) {
        if (plot.getOrientation() != null) {
            jrPlot.setOrientation(ConstantTransform.chartPlotOrientation(plot.getOrientation()));
        }
        if (plot.getSeriesColors() != null) {
            final List<JRSeriesColor> colors = new ArrayList<>();
            int i = 1;
            for (final Color color : plot.getSeriesColors()) {
                colors.add(new JRBaseChartPlot.JRBaseSeriesColor(i++, color));
            }
            jrPlot.setSeriesColors(colors);
        }

        if (jrPlot instanceof JRDesignAreaPlot) {
            areaPlot((DRIDesignAxisPlot) plot, (JRDesignAreaPlot) jrPlot);
        } else if (jrPlot instanceof JRDesignBar3DPlot) {
            bar3DPlot((DRIDesignBar3DPlot) plot, (JRDesignBar3DPlot) jrPlot);
        } else if (jrPlot instanceof JRDesignBarPlot) {
            barPlot((DRIDesignBarPlot) plot, (JRDesignBarPlot) jrPlot);
        } else if (jrPlot instanceof JRDesignLinePlot) {
            linePlot((DRIDesignLinePlot) plot, (JRDesignLinePlot) jrPlot);
        } else if (jrPlot instanceof JRDesignPiePlot) {
            piePlot((DRIDesignPiePlot) plot, (JRDesignPiePlot) jrPlot);
        } else if (jrPlot instanceof JRDesignPie3DPlot) {
            pie3DPlot((DRIDesignPie3DPlot) plot, (JRDesignPie3DPlot) jrPlot);
        } else if (jrPlot instanceof JRDesignScatterPlot) {
            scatterPlot((DRIDesignLinePlot) plot, (JRDesignScatterPlot) jrPlot);
        } else if (jrPlot instanceof JRDesignTimeSeriesPlot) {
            timeSeriesPlot((DRIDesignLinePlot) plot, (JRDesignTimeSeriesPlot) jrPlot);
        } else if (jrPlot instanceof JRDesignMultiAxisPlot) {
            multiAxisPlot((DRIDesignMultiAxisPlot) plot, (JRDesignMultiAxisPlot) jrPlot, jrChart);
        } else if (jrPlot instanceof JRDesignBubblePlot) {
            bubblePlot((DRIDesignBubblePlot) plot, (JRDesignBubblePlot) jrPlot);
        } else if (jrPlot instanceof JRDesignCandlestickPlot) {
            candlestickPlot((DRIDesignCandlestickPlot) plot, (JRDesignCandlestickPlot) jrPlot);
        } else if (jrPlot instanceof JRDesignHighLowPlot) {
            highLowPlot((DRIDesignHighLowPlot) plot, (JRDesignHighLowPlot) jrPlot);
        } else if (jrPlot instanceof JRDesignMeterPlot) {
            meterPlot((DRIDesignMeterPlot) plot, (JRDesignMeterPlot) jrPlot, jrChart);
        } else if (jrPlot instanceof JRDesignThermometerPlot) {
            thermometerPlot((DRIDesignThermometerPlot) plot, (JRDesignThermometerPlot) jrPlot, jrChart);
        } else {
            throw new JasperDesignException("Plot " + plot.getClass().getName() + " not supported");
        }
    }

    private void areaPlot(DRIDesignAxisPlot plot, JRDesignAreaPlot jrPlot) {
        // category
        final DRIDesignAxisFormat categoryAxisFormat = plot.getXAxisFormat();
        jrPlot.setCategoryAxisLabelExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getLabelExpression()));
        jrPlot.setCategoryAxisTickLabelMask(categoryAxisFormat.getTickLabelMask());
        jrPlot.setCategoryAxisVerticalTickLabels(categoryAxisFormat.getVerticalTickLabels());
        jrPlot.setCategoryAxisTickLabelRotation(categoryAxisFormat.getTickLabelRotation());
        jrPlot.setCategoryAxisLabelColor(categoryAxisFormat.getLabelColor());
        if (categoryAxisFormat.getLabelFont() != null) {
            jrPlot.setCategoryAxisLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getLabelFont()));
        }
        jrPlot.setCategoryAxisLineColor(categoryAxisFormat.getLineColor());
        jrPlot.setCategoryAxisTickLabelColor(categoryAxisFormat.getTickLabelColor());
        if (categoryAxisFormat.getTickLabelFont() != null) {
            jrPlot.setCategoryAxisTickLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getTickLabelFont()));
        }
        jrPlot.setDomainAxisMinValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMinValueExpression()));
        jrPlot.setDomainAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMaxValueExpression()));

        // value
        final DRIDesignAxisFormat valueAxisFormat = plot.getYAxisFormat();
        jrPlot.setValueAxisLabelExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getLabelExpression()));
        jrPlot.setValueAxisTickLabelMask(valueAxisFormat.getTickLabelMask());
        jrPlot.setValueAxisVerticalTickLabels(valueAxisFormat.getVerticalTickLabels());
        jrPlot.setValueAxisLabelColor(valueAxisFormat.getLabelColor());
        if (valueAxisFormat.getLabelFont() != null) {
            jrPlot.setValueAxisLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getLabelFont()));
        }
        jrPlot.setValueAxisLineColor(valueAxisFormat.getLineColor());
        jrPlot.setValueAxisTickLabelColor(valueAxisFormat.getTickLabelColor());
        if (valueAxisFormat.getTickLabelFont() != null) {
            jrPlot.setValueAxisTickLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getTickLabelFont()));
        }
        jrPlot.setRangeAxisMinValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMinValueExpression()));
        jrPlot.setRangeAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMaxValueExpression()));
    }

    private void bar3DPlot(DRIDesignBar3DPlot plot, JRDesignBar3DPlot jrPlot) {
        // category
        final DRIDesignAxisFormat categoryAxisFormat = plot.getXAxisFormat();
        jrPlot.setCategoryAxisLabelExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getLabelExpression()));
        jrPlot.setCategoryAxisTickLabelMask(categoryAxisFormat.getTickLabelMask());
        jrPlot.setCategoryAxisVerticalTickLabels(categoryAxisFormat.getVerticalTickLabels());
        jrPlot.setCategoryAxisTickLabelRotation(categoryAxisFormat.getTickLabelRotation());
        jrPlot.setCategoryAxisLabelColor(categoryAxisFormat.getLabelColor());
        if (categoryAxisFormat.getLabelFont() != null) {
            jrPlot.setCategoryAxisLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getLabelFont()));
        }
        jrPlot.setCategoryAxisLineColor(categoryAxisFormat.getLineColor());
        jrPlot.setCategoryAxisTickLabelColor(categoryAxisFormat.getTickLabelColor());
        if (categoryAxisFormat.getTickLabelFont() != null) {
            jrPlot.setCategoryAxisTickLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getTickLabelFont()));
        }
        jrPlot.setDomainAxisMinValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMinValueExpression()));
        jrPlot.setDomainAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMaxValueExpression()));

        // value
        final DRIDesignAxisFormat valueAxisFormat = plot.getYAxisFormat();
        jrPlot.setValueAxisLabelExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getLabelExpression()));
        jrPlot.setValueAxisTickLabelMask(valueAxisFormat.getTickLabelMask());
        jrPlot.setValueAxisVerticalTickLabels(valueAxisFormat.getVerticalTickLabels());
        jrPlot.setValueAxisLabelColor(valueAxisFormat.getLabelColor());
        if (valueAxisFormat.getLabelFont() != null) {
            jrPlot.setValueAxisLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getLabelFont()));
        }
        jrPlot.setValueAxisLineColor(valueAxisFormat.getLineColor());
        jrPlot.setValueAxisTickLabelColor(valueAxisFormat.getTickLabelColor());
        if (valueAxisFormat.getTickLabelFont() != null) {
            jrPlot.setValueAxisTickLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getTickLabelFont()));
        }
        jrPlot.setRangeAxisMinValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMinValueExpression()));
        jrPlot.setRangeAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMaxValueExpression()));

        jrPlot.setShowLabels(plot.getShowLabels());
        jrPlot.setXOffset(plot.getXOffset());
        jrPlot.setYOffset(plot.getYOffset());
    }

    private void barPlot(DRIDesignBarPlot plot, JRDesignBarPlot jrPlot) {
        // category
        final DRIDesignAxisFormat categoryAxisFormat = plot.getXAxisFormat();
        jrPlot.setCategoryAxisLabelExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getLabelExpression()));
        jrPlot.setCategoryAxisTickLabelMask(categoryAxisFormat.getTickLabelMask());
        jrPlot.setCategoryAxisVerticalTickLabels(categoryAxisFormat.getVerticalTickLabels());
        jrPlot.setCategoryAxisTickLabelRotation(categoryAxisFormat.getTickLabelRotation());
        jrPlot.setCategoryAxisLabelColor(categoryAxisFormat.getLabelColor());
        if (categoryAxisFormat.getLabelFont() != null) {
            jrPlot.setCategoryAxisLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getLabelFont()));
        }
        jrPlot.setCategoryAxisLineColor(categoryAxisFormat.getLineColor());
        jrPlot.setCategoryAxisTickLabelColor(categoryAxisFormat.getTickLabelColor());
        if (categoryAxisFormat.getTickLabelFont() != null) {
            jrPlot.setCategoryAxisTickLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getTickLabelFont()));
        }
        jrPlot.setDomainAxisMinValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMinValueExpression()));
        jrPlot.setDomainAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMaxValueExpression()));

        // value
        final DRIDesignAxisFormat valueAxisFormat = plot.getYAxisFormat();
        jrPlot.setValueAxisLabelExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getLabelExpression()));
        jrPlot.setValueAxisTickLabelMask(valueAxisFormat.getTickLabelMask());
        jrPlot.setValueAxisVerticalTickLabels(valueAxisFormat.getVerticalTickLabels());
        jrPlot.setValueAxisLabelColor(valueAxisFormat.getLabelColor());
        if (valueAxisFormat.getLabelFont() != null) {
            jrPlot.setValueAxisLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getLabelFont()));
        }
        jrPlot.setValueAxisLineColor(valueAxisFormat.getLineColor());
        jrPlot.setValueAxisTickLabelColor(valueAxisFormat.getTickLabelColor());
        if (valueAxisFormat.getTickLabelFont() != null) {
            jrPlot.setValueAxisTickLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getTickLabelFont()));
        }
        jrPlot.setRangeAxisMinValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMinValueExpression()));
        jrPlot.setRangeAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMaxValueExpression()));

        jrPlot.setShowLabels(plot.getShowLabels());
        jrPlot.setShowTickLabels(plot.getShowTickLabels());
        jrPlot.setShowTickMarks(plot.getShowTickMarks());
    }

    private void linePlot(DRIDesignLinePlot plot, JRDesignLinePlot jrPlot) {
        // category
        final DRIDesignAxisFormat categoryAxisFormat = plot.getXAxisFormat();
        jrPlot.setCategoryAxisLabelExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getLabelExpression()));
        jrPlot.setCategoryAxisTickLabelMask(categoryAxisFormat.getTickLabelMask());
        jrPlot.setCategoryAxisVerticalTickLabels(categoryAxisFormat.getVerticalTickLabels());
        jrPlot.setCategoryAxisTickLabelRotation(categoryAxisFormat.getTickLabelRotation());
        jrPlot.setCategoryAxisLabelColor(categoryAxisFormat.getLabelColor());
        if (categoryAxisFormat.getLabelFont() != null) {
            jrPlot.setCategoryAxisLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getLabelFont()));
        }
        jrPlot.setCategoryAxisLineColor(categoryAxisFormat.getLineColor());
        jrPlot.setCategoryAxisTickLabelColor(categoryAxisFormat.getTickLabelColor());
        if (categoryAxisFormat.getTickLabelFont() != null) {
            jrPlot.setCategoryAxisTickLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getTickLabelFont()));
        }
        jrPlot.setDomainAxisMinValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMinValueExpression()));
        jrPlot.setDomainAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMaxValueExpression()));

        // value
        final DRIDesignAxisFormat valueAxisFormat = plot.getYAxisFormat();
        jrPlot.setValueAxisLabelExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getLabelExpression()));
        jrPlot.setValueAxisTickLabelMask(valueAxisFormat.getTickLabelMask());
        jrPlot.setValueAxisVerticalTickLabels(valueAxisFormat.getVerticalTickLabels());
        jrPlot.setValueAxisLabelColor(valueAxisFormat.getLabelColor());
        if (valueAxisFormat.getLabelFont() != null) {
            jrPlot.setValueAxisLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getLabelFont()));
        }
        jrPlot.setValueAxisLineColor(valueAxisFormat.getLineColor());
        jrPlot.setValueAxisTickLabelColor(valueAxisFormat.getTickLabelColor());
        if (valueAxisFormat.getTickLabelFont() != null) {
            jrPlot.setValueAxisTickLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getTickLabelFont()));
        }
        jrPlot.setRangeAxisMinValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMinValueExpression()));
        jrPlot.setRangeAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMaxValueExpression()));

        jrPlot.setShowShapes(plot.getShowShapes());
        jrPlot.setShowLines(plot.getShowLines());
    }

    private void piePlot(DRIDesignPiePlot plot, JRDesignPiePlot jrPlot) {
        jrPlot.setCircular(plot.getCircular());
        jrPlot.setLabelFormat(plot.getLabelFormat());
        jrPlot.setLegendLabelFormat(plot.getLegendLabelFormat());
    }

    private void pie3DPlot(DRIDesignPie3DPlot plot, JRDesignPie3DPlot jrPlot) {
        jrPlot.setCircular(plot.getCircular());
        jrPlot.setLabelFormat(plot.getLabelFormat());
        jrPlot.setLegendLabelFormat(plot.getLegendLabelFormat());
        jrPlot.setDepthFactor(plot.getDepthFactor());
    }

    private void scatterPlot(DRIDesignLinePlot plot, JRDesignScatterPlot jrPlot) {
        // x
        final DRIDesignAxisFormat xAxisFormat = plot.getXAxisFormat();
        jrPlot.setXAxisLabelExpression(accessor.getExpressionTransform().getExpression(xAxisFormat.getLabelExpression()));
        jrPlot.setXAxisTickLabelMask(xAxisFormat.getTickLabelMask());
        jrPlot.setXAxisVerticalTickLabels(xAxisFormat.getVerticalTickLabels());
        jrPlot.setXAxisLabelColor(xAxisFormat.getLabelColor());
        if (xAxisFormat.getLabelFont() != null) {
            jrPlot.setXAxisLabelFont(accessor.getStyleTransform().font(xAxisFormat.getLabelFont()));
        }
        jrPlot.setXAxisLineColor(xAxisFormat.getLineColor());
        jrPlot.setXAxisTickLabelColor(xAxisFormat.getTickLabelColor());
        if (xAxisFormat.getTickLabelFont() != null) {
            jrPlot.setXAxisTickLabelFont(accessor.getStyleTransform().font(xAxisFormat.getTickLabelFont()));
        }
        jrPlot.setDomainAxisMinValueExpression(accessor.getExpressionTransform().getExpression(xAxisFormat.getRangeMinValueExpression()));
        jrPlot.setDomainAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(xAxisFormat.getRangeMaxValueExpression()));

        // y
        final DRIDesignAxisFormat yAxisFormat = plot.getYAxisFormat();
        jrPlot.setYAxisLabelExpression(accessor.getExpressionTransform().getExpression(yAxisFormat.getLabelExpression()));
        jrPlot.setYAxisTickLabelMask(yAxisFormat.getTickLabelMask());
        jrPlot.setYAxisVerticalTickLabels(yAxisFormat.getVerticalTickLabels());
        jrPlot.setYAxisLabelColor(yAxisFormat.getLabelColor());
        if (yAxisFormat.getLabelFont() != null) {
            jrPlot.setYAxisLabelFont(accessor.getStyleTransform().font(yAxisFormat.getLabelFont()));
        }
        jrPlot.setYAxisLineColor(yAxisFormat.getLineColor());
        jrPlot.setYAxisTickLabelColor(yAxisFormat.getTickLabelColor());
        if (yAxisFormat.getTickLabelFont() != null) {
            jrPlot.setYAxisTickLabelFont(accessor.getStyleTransform().font(yAxisFormat.getTickLabelFont()));
        }
        jrPlot.setRangeAxisMinValueExpression(accessor.getExpressionTransform().getExpression(yAxisFormat.getRangeMinValueExpression()));
        jrPlot.setRangeAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(yAxisFormat.getRangeMaxValueExpression()));

        jrPlot.setShowShapes(plot.getShowShapes());
        jrPlot.setShowLines(plot.getShowLines());
    }

    private void timeSeriesPlot(DRIDesignLinePlot plot, JRDesignTimeSeriesPlot jrPlot) {
        // time
        final DRIDesignAxisFormat categoryAxisFormat = plot.getXAxisFormat();
        jrPlot.setTimeAxisLabelExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getLabelExpression()));
        jrPlot.setTimeAxisTickLabelMask(categoryAxisFormat.getTickLabelMask());
        jrPlot.setTimeAxisVerticalTickLabels(categoryAxisFormat.getVerticalTickLabels());
        jrPlot.setTimeAxisLabelColor(categoryAxisFormat.getLabelColor());
        if (categoryAxisFormat.getLabelFont() != null) {
            jrPlot.setTimeAxisLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getLabelFont()));
        }
        jrPlot.setTimeAxisLineColor(categoryAxisFormat.getLineColor());
        jrPlot.setTimeAxisTickLabelColor(categoryAxisFormat.getTickLabelColor());
        if (categoryAxisFormat.getTickLabelFont() != null) {
            jrPlot.setTimeAxisTickLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getTickLabelFont()));
        }
        jrPlot.setDomainAxisMinValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMinValueExpression()));
        jrPlot.setDomainAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMaxValueExpression()));

        // value
        final DRIDesignAxisFormat valueAxisFormat = plot.getYAxisFormat();
        jrPlot.setValueAxisLabelExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getLabelExpression()));
        jrPlot.setValueAxisTickLabelMask(valueAxisFormat.getTickLabelMask());
        jrPlot.setValueAxisVerticalTickLabels(valueAxisFormat.getVerticalTickLabels());
        jrPlot.setValueAxisLabelColor(valueAxisFormat.getLabelColor());
        if (valueAxisFormat.getLabelFont() != null) {
            jrPlot.setValueAxisLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getLabelFont()));
        }
        jrPlot.setValueAxisLineColor(valueAxisFormat.getLineColor());
        jrPlot.setValueAxisTickLabelColor(valueAxisFormat.getTickLabelColor());
        if (valueAxisFormat.getTickLabelFont() != null) {
            jrPlot.setValueAxisTickLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getTickLabelFont()));
        }
        jrPlot.setRangeAxisMinValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMinValueExpression()));
        jrPlot.setRangeAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMaxValueExpression()));

        jrPlot.setShowShapes(plot.getShowShapes());
        jrPlot.setShowLines(plot.getShowLines());
    }

    private void candlestickPlot(DRIDesignCandlestickPlot plot, JRDesignCandlestickPlot jrPlot) {
        // time
        final DRIDesignAxisFormat categoryAxisFormat = plot.getXAxisFormat();
        jrPlot.setTimeAxisLabelExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getLabelExpression()));
        jrPlot.setTimeAxisTickLabelMask(categoryAxisFormat.getTickLabelMask());
        jrPlot.setTimeAxisVerticalTickLabels(categoryAxisFormat.getVerticalTickLabels());
        jrPlot.setTimeAxisLabelColor(categoryAxisFormat.getLabelColor());
        if (categoryAxisFormat.getLabelFont() != null) {
            jrPlot.setTimeAxisLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getLabelFont()));
        }
        jrPlot.setTimeAxisLineColor(categoryAxisFormat.getLineColor());
        jrPlot.setTimeAxisTickLabelColor(categoryAxisFormat.getTickLabelColor());
        if (categoryAxisFormat.getTickLabelFont() != null) {
            jrPlot.setTimeAxisTickLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getTickLabelFont()));
        }
        jrPlot.setDomainAxisMinValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMinValueExpression()));
        jrPlot.setDomainAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMaxValueExpression()));

        // value
        final DRIDesignAxisFormat valueAxisFormat = plot.getYAxisFormat();
        jrPlot.setValueAxisLabelExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getLabelExpression()));
        jrPlot.setValueAxisTickLabelMask(valueAxisFormat.getTickLabelMask());
        jrPlot.setValueAxisVerticalTickLabels(valueAxisFormat.getVerticalTickLabels());
        jrPlot.setValueAxisLabelColor(valueAxisFormat.getLabelColor());
        if (valueAxisFormat.getLabelFont() != null) {
            jrPlot.setValueAxisLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getLabelFont()));
        }
        jrPlot.setValueAxisLineColor(valueAxisFormat.getLineColor());
        jrPlot.setValueAxisTickLabelColor(valueAxisFormat.getTickLabelColor());
        if (valueAxisFormat.getTickLabelFont() != null) {
            jrPlot.setValueAxisTickLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getTickLabelFont()));
        }
        jrPlot.setRangeAxisMinValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMinValueExpression()));
        jrPlot.setRangeAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMaxValueExpression()));

        jrPlot.setShowVolume(plot.getShowVolume());
    }

    private void highLowPlot(DRIDesignHighLowPlot plot, JRDesignHighLowPlot jrPlot) {
        // time
        final DRIDesignAxisFormat categoryAxisFormat = plot.getXAxisFormat();
        jrPlot.setTimeAxisLabelExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getLabelExpression()));
        jrPlot.setTimeAxisTickLabelMask(categoryAxisFormat.getTickLabelMask());
        jrPlot.setTimeAxisVerticalTickLabels(categoryAxisFormat.getVerticalTickLabels());
        jrPlot.setTimeAxisLabelColor(categoryAxisFormat.getLabelColor());
        if (categoryAxisFormat.getLabelFont() != null) {
            jrPlot.setTimeAxisLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getLabelFont()));
        }
        jrPlot.setTimeAxisLineColor(categoryAxisFormat.getLineColor());
        jrPlot.setTimeAxisTickLabelColor(categoryAxisFormat.getTickLabelColor());
        if (categoryAxisFormat.getTickLabelFont() != null) {
            jrPlot.setTimeAxisTickLabelFont(accessor.getStyleTransform().font(categoryAxisFormat.getTickLabelFont()));
        }
        jrPlot.setDomainAxisMinValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMinValueExpression()));
        jrPlot.setDomainAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(categoryAxisFormat.getRangeMaxValueExpression()));

        // value
        final DRIDesignAxisFormat valueAxisFormat = plot.getYAxisFormat();
        jrPlot.setValueAxisLabelExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getLabelExpression()));
        jrPlot.setValueAxisTickLabelMask(valueAxisFormat.getTickLabelMask());
        jrPlot.setValueAxisVerticalTickLabels(valueAxisFormat.getVerticalTickLabels());
        jrPlot.setValueAxisLabelColor(valueAxisFormat.getLabelColor());
        if (valueAxisFormat.getLabelFont() != null) {
            jrPlot.setValueAxisLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getLabelFont()));
        }
        jrPlot.setValueAxisLineColor(valueAxisFormat.getLineColor());
        jrPlot.setValueAxisTickLabelColor(valueAxisFormat.getTickLabelColor());
        if (valueAxisFormat.getTickLabelFont() != null) {
            jrPlot.setValueAxisTickLabelFont(accessor.getStyleTransform().font(valueAxisFormat.getTickLabelFont()));
        }
        jrPlot.setRangeAxisMinValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMinValueExpression()));
        jrPlot.setRangeAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(valueAxisFormat.getRangeMaxValueExpression()));

        jrPlot.setShowOpenTicks(plot.getShowOpenTicks());
        jrPlot.setShowCloseTicks(plot.getShowCloseTicks());
    }

    private void meterPlot(DRIDesignMeterPlot plot, JRDesignMeterPlot jrPlot, JRDesignChart jrChart) {
        final JRDesignDataRange jrDataRange = new JRDesignDataRange(null);
        jrDataRange.setLowExpression(accessor.getExpressionTransform().getExpression(plot.getDataRangeLowExpression()));
        jrDataRange.setHighExpression(accessor.getExpressionTransform().getExpression(plot.getDataRangeHighExpression()));
        try {
            jrPlot.setDataRange(jrDataRange);
        } catch (final JRException e) {
            throw new JasperDesignException("Registration failed for meter data range", e);
        }

        final JRDesignValueDisplay jrValueDisplay = new JRDesignValueDisplay(null, jrChart);
        jrValueDisplay.setColor(plot.getValueColor());
        jrValueDisplay.setMask(plot.getValueMask());
        jrValueDisplay.setFont(accessor.getStyleTransform().font(plot.getValueFont()));
        jrPlot.setValueDisplay(jrValueDisplay);

        final List<JRMeterInterval> intervals = new ArrayList<>();
        for (final DRIDesignMeterInterval meterInterval : plot.getIntervals()) {
            intervals.add(meterInterval(meterInterval));
        }
        jrPlot.setIntervals(intervals);

        try {
            jrPlot.setShape(ConstantTransform.meterShape(plot.getShape()));
        } catch (final JRException e) {
            throw new JasperDesignException("Registration failed for meter shape", e);
        }
        jrPlot.setMeterAngle(plot.getMeterAngle());
        jrPlot.setUnits(plot.getUnits());
        jrPlot.setTickInterval(plot.getTickInterval());
        jrPlot.setMeterBackgroundColor(plot.getMeterBackgroundColor());
        jrPlot.setNeedleColor(plot.getNeedleColor());
        if (plot.getTickColor() == null && plot.getShape() != null && plot.getShape().equals(MeterShape.DIAL)) {
            jrPlot.setTickColor(Color.BLACK);
        } else {
            jrPlot.setTickColor(plot.getTickColor());
        }
        jrPlot.setTickLabelFont(accessor.getStyleTransform().font(plot.getTickLabelFont()));
    }

    private void thermometerPlot(DRIDesignThermometerPlot plot, JRDesignThermometerPlot jrPlot, JRDesignChart jrChart) {
        JRDesignDataRange jrDataRange = new JRDesignDataRange(null);
        jrDataRange.setLowExpression(accessor.getExpressionTransform().getExpression(plot.getDataRangeLowExpression()));
        jrDataRange.setHighExpression(accessor.getExpressionTransform().getExpression(plot.getDataRangeHighExpression()));
        jrPlot.setDataRange(jrDataRange);

        final JRDesignValueDisplay jrValueDisplay = new JRDesignValueDisplay(null, jrChart);
        jrValueDisplay.setColor(plot.getValueColor());
        jrValueDisplay.setMask(plot.getValueMask());
        jrValueDisplay.setFont(accessor.getStyleTransform().font(plot.getValueFont()));
        jrPlot.setValueDisplay(jrValueDisplay);

        jrPlot.setValueLocation(ConstantTransform.valueLocation(plot.getValueLocation()));
        jrPlot.setMercuryColor(plot.getMercuryColor());

        jrDataRange = new JRDesignDataRange(null);
        jrDataRange.setLowExpression(accessor.getExpressionTransform().getExpression(plot.getLowDataRangeLowExpression()));
        jrDataRange.setHighExpression(accessor.getExpressionTransform().getExpression(plot.getLowDataRangeHighExpression()));
        jrPlot.setLowRange(jrDataRange);

        jrDataRange = new JRDesignDataRange(null);
        jrDataRange.setLowExpression(accessor.getExpressionTransform().getExpression(plot.getMediumDataRangeLowExpression()));
        jrDataRange.setHighExpression(accessor.getExpressionTransform().getExpression(plot.getMediumDataRangeHighExpression()));
        jrPlot.setMediumRange(jrDataRange);

        jrDataRange = new JRDesignDataRange(null);
        jrDataRange.setLowExpression(accessor.getExpressionTransform().getExpression(plot.getHighDataRangeLowExpression()));
        jrDataRange.setHighExpression(accessor.getExpressionTransform().getExpression(plot.getHighDataRangeHighExpression()));
        jrPlot.setHighRange(jrDataRange);
    }

    private JRMeterInterval meterInterval(DRIDesignMeterInterval meterInterval) {
        final JRMeterInterval jrMeterInterval = new JRMeterInterval();
        jrMeterInterval.setLabel(meterInterval.getLabel());
        jrMeterInterval.setBackgroundColor(meterInterval.getBackgroundColor());
        jrMeterInterval.setAlpha(meterInterval.getAlpha());

        final JRDesignDataRange jrDataRange = new JRDesignDataRange(null);
        jrDataRange.setLowExpression(accessor.getExpressionTransform().getExpression(meterInterval.getDataRangeLowExpression()));
        jrDataRange.setHighExpression(accessor.getExpressionTransform().getExpression(meterInterval.getDataRangeHighExpression()));
        jrMeterInterval.setDataRange(jrDataRange);

        return jrMeterInterval;
    }

    private void multiAxisPlot(DRIDesignMultiAxisPlot plot, JRDesignMultiAxisPlot jrPlot, JRDesignChart jrChart) {
        jrPlot.setChart(jrChart);
        for (final DRIDesignChartAxis axis : plot.getAxes()) {
            final JRDesignChartAxis jrAxis = new JRDesignChartAxis(jrChart);
            jrAxis.setPosition(ConstantTransform.chartAxisPosition(axis.getPosition()));
            final JRDesignChart chart = chart(axis.getChart());
            if (axis.getChart().getStyle() != null) {
                chart.setStyle(accessor.getStyleTransform().getStyle(axis.getChart().getStyle()));
            }
            jrAxis.setChart(chart);
            jrPlot.addAxis(jrAxis);
        }
    }

    private void bubblePlot(DRIDesignBubblePlot plot, JRDesignBubblePlot jrPlot) {
        // x
        final DRIDesignAxisFormat xAxisFormat = plot.getXAxisFormat();
        jrPlot.setXAxisLabelExpression(accessor.getExpressionTransform().getExpression(xAxisFormat.getLabelExpression()));
        jrPlot.setXAxisTickLabelMask(xAxisFormat.getTickLabelMask());
        jrPlot.setXAxisVerticalTickLabels(xAxisFormat.getVerticalTickLabels());
        jrPlot.setXAxisLabelColor(xAxisFormat.getLabelColor());
        if (xAxisFormat.getLabelFont() != null) {
            jrPlot.setXAxisLabelFont(accessor.getStyleTransform().font(xAxisFormat.getLabelFont()));
        }
        jrPlot.setXAxisLineColor(xAxisFormat.getLineColor());
        jrPlot.setXAxisTickLabelColor(xAxisFormat.getTickLabelColor());
        if (xAxisFormat.getTickLabelFont() != null) {
            jrPlot.setXAxisTickLabelFont(accessor.getStyleTransform().font(xAxisFormat.getTickLabelFont()));
        }
        jrPlot.setDomainAxisMinValueExpression(accessor.getExpressionTransform().getExpression(xAxisFormat.getRangeMinValueExpression()));
        jrPlot.setDomainAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(xAxisFormat.getRangeMaxValueExpression()));

        // y
        final DRIDesignAxisFormat yAxisFormat = plot.getYAxisFormat();
        jrPlot.setYAxisLabelExpression(accessor.getExpressionTransform().getExpression(yAxisFormat.getLabelExpression()));
        jrPlot.setYAxisTickLabelMask(yAxisFormat.getTickLabelMask());
        jrPlot.setYAxisVerticalTickLabels(yAxisFormat.getVerticalTickLabels());
        jrPlot.setYAxisLabelColor(yAxisFormat.getLabelColor());
        if (yAxisFormat.getLabelFont() != null) {
            jrPlot.setYAxisLabelFont(accessor.getStyleTransform().font(yAxisFormat.getLabelFont()));
        }
        jrPlot.setYAxisLineColor(yAxisFormat.getLineColor());
        jrPlot.setYAxisTickLabelColor(yAxisFormat.getTickLabelColor());
        if (yAxisFormat.getTickLabelFont() != null) {
            jrPlot.setYAxisTickLabelFont(accessor.getStyleTransform().font(yAxisFormat.getTickLabelFont()));
        }
        jrPlot.setRangeAxisMinValueExpression(accessor.getExpressionTransform().getExpression(yAxisFormat.getRangeMinValueExpression()));
        jrPlot.setRangeAxisMaxValueExpression(accessor.getExpressionTransform().getExpression(yAxisFormat.getRangeMaxValueExpression()));

        if (plot.getScaleType() != null) {
            jrPlot.setScaleType(ConstantTransform.scaleType(plot.getScaleType()));
        }
    }

    // spider
    private ChartSettings spiderSettings(DRIDesignChart chart) {
        final StandardChartSettings settings = new StandardChartSettings();

        settings.setAnchorNameExpression(accessor.getExpressionTransform().getExpression(chart.getAnchorNameExpression()));
        if (chart.getBookmarkLevel() != null) {
            settings.setBookmarkLevel(chart.getBookmarkLevel());
        }

        final DRIDesignHyperLink hyperLink = chart.getHyperLink();
        if (hyperLink != null) {
            settings.setHyperlinkAnchorExpression(accessor.getExpressionTransform().getExpression(hyperLink.getAnchorExpression()));
            settings.setHyperlinkPageExpression(accessor.getExpressionTransform().getExpression(hyperLink.getPageExpression()));
            settings.setHyperlinkReferenceExpression(accessor.getExpressionTransform().getExpression(hyperLink.getReferenceExpression()));
            settings.setHyperlinkTooltipExpression(accessor.getExpressionTransform().getExpression(hyperLink.getTooltipExpression()));
            if (hyperLink.getType() != null) {
                final HyperlinkTypeEnum hyperLinkType = ConstantTransform.hyperLinkType(hyperLink.getType());
                if (hyperLinkType != null) {
                    settings.setLinkType(JRHyperlinkHelper.getLinkType(hyperLinkType));
                } else {
                    settings.setLinkType(hyperLink.getType());
                }
            }
            if (hyperLink.getTarget() != null) {
                final HyperlinkTargetEnum hyperLinkTarget = ConstantTransform.hyperLinkTarget(hyperLink.getTarget());
                if (hyperLinkTarget != null) {
                    settings.setLinkTarget(JRHyperlinkHelper.getLinkTarget(hyperLinkTarget));
                } else {
                    settings.setLinkTarget(hyperLink.getTarget());
                }
            }
        }

        final DRIDesignChartTitle title = chart.getTitle();
        settings.setTitleColor(title.getColor());
        if (title.getFont() != null) {
            settings.setTitleFont(accessor.getStyleTransform().font(title.getFont()));
        }
        settings.setTitleExpression(accessor.getExpressionTransform().getExpression(title.getTitle()));
        settings.setTitlePosition(ConstantTransform.chartPosition(title.getPosition()));

        final DRIDesignChartSubtitle subtitle = chart.getSubtitle();
        settings.setSubtitleColor(subtitle.getColor());
        if (subtitle.getFont() != null) {
            settings.setSubtitleFont(accessor.getStyleTransform().font(subtitle.getFont()));
        }
        settings.setSubtitleExpression(accessor.getExpressionTransform().getExpression(subtitle.getTitle()));

        final DRIDesignChartLegend legend = chart.getLegend();
        settings.setLegendColor(legend.getColor());
        settings.setLegendBackgroundColor(legend.getBackgroundColor());
        settings.setShowLegend(legend.getShowLegend());
        if (legend.getFont() != null) {
            settings.setLegendFont(accessor.getStyleTransform().font(legend.getFont()));
        }
        settings.setLegendPosition(ConstantTransform.chartPosition(legend.getPosition()));

        if (!chart.getCustomizers().isEmpty()) {
            settings.setCustomizerClass(JasperChartCustomizer.class.getName());
            addChartCustomizer(chart.getUniqueName(), chart.getCustomizers());
        }

        return settings;
    }

    private void spiderPlot(DRIDesignSpiderPlot plot, StandardSpiderPlot jrPlot) {
        jrPlot.setMaxValueExpression(accessor.getExpressionTransform().getExpression(plot.getMaxValueExpression()));
        jrPlot.setRotation(ConstantTransform.spiderRotation(plot.getRotation()));
        jrPlot.setTableOrder(ConstantTransform.tableOrder(plot.getTableOrder()));
        jrPlot.setWebFilled(plot.getWebFilled());
        jrPlot.setStartAngle(plot.getStartAngle());
        jrPlot.setHeadPercent(plot.getHeadPercent());
        jrPlot.setInteriorGap(plot.getInteriorGap());
        jrPlot.setAxisLineColor(plot.getAxisLineColor());
        jrPlot.setAxisLineWidth(plot.getAxisLineWidth());
        if (plot.getLabelFont() != null) {
            jrPlot.setLabelFont(accessor.getStyleTransform().font(plot.getLabelFont()));
        }
        jrPlot.setLabelGap(plot.getLabelGap());
        jrPlot.setLabelColor(plot.getLabelColor());
    }
}

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
package net.sf.dynamicreports.design.transformation.chartcustomizer;

import java.awt.Paint;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.UnknownKeyException;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;

/**
 * <p>GroupedStackedBarRendererCustomizer class.</p>
 *
 * @author Ricardo Mariaca
 *
 */
public class GroupedStackedBarRendererCustomizer implements DRIChartCustomizer, Serializable {
    /**
     * Constant <code>GROUP_SERIES_KEY="-{group-series}-"</code>
     */
    public static final String GROUP_SERIES_KEY = "-{group-series}-";
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
    private KeyToGroupMap map;
    private Map<String, Paint> seriesColors;

    /** {@inheritDoc} */
    @Override
    public void customize(JFreeChart chart, ReportParameters reportParameters) {
        this.seriesColors = new LinkedHashMap<>();
        this.map = null;
        final Set<String> groups = new LinkedHashSet<>();
        CategoryDataset dataset = chart.getCategoryPlot().getDataset();

        for (int i = 0; i < dataset.getRowCount(); i++) {
            final String rowKey = (String) dataset.getRowKey(i);
            final String group = StringUtils.substringBefore(rowKey, GROUP_SERIES_KEY);
            final String series = StringUtils.substringAfter(rowKey, GROUP_SERIES_KEY);
            if (map == null) {
                map = new KeyToGroupMap(group);
            }
            map.mapKeyToGroup(rowKey, group);
            groups.add(group);
            if (!seriesColors.containsKey(series)) {
                final Paint paint = chart.getCategoryPlot().getDrawingSupplier().getNextPaint();
                seriesColors.put(series, paint);
            }
        }

        final DefaultCategoryDataset newDataset = new DefaultCategoryDataset();
        for (final Object column : dataset.getColumnKeys()) {
            for (final String group : groups) {
                for (final String series : seriesColors.keySet()) {
                    try {
                        final Number value = dataset.getValue(group + GROUP_SERIES_KEY + series, (Comparable<?>) column);
                        newDataset.addValue(value, group + GROUP_SERIES_KEY + series, (Comparable<?>) column);
                    } catch (final UnknownKeyException e) {
                        newDataset.addValue(0, group + GROUP_SERIES_KEY + series, (Comparable<?>) column);
                    }
                }

            }
        }
        dataset = newDataset;

        final GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        renderer.setSeriesToGroupMap(map);

        final StackedBarRenderer categoryRenderer = (StackedBarRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setDefaultItemLabelsVisible(categoryRenderer.getDefaultItemLabelsVisible());
        renderer.setDefaultItemLabelFont(categoryRenderer.getDefaultItemLabelFont());
        renderer.setDefaultItemLabelPaint(categoryRenderer.getDefaultItemLabelPaint());
        renderer.setDefaultItemLabelGenerator(categoryRenderer.getDefaultItemLabelGenerator());
        renderer.setShadowVisible(categoryRenderer.getShadowsVisible());

        renderer.setItemMargin(0.10);
        renderer.setDrawBarOutline(false);
        for (int i = 0; i < dataset.getRowCount(); i++) {
            final String rowKey = (String) dataset.getRowKey(i);
            final String score = StringUtils.substringAfter(rowKey, GROUP_SERIES_KEY);
            renderer.setSeriesPaint(i, seriesColors.get(score));
        }

        final CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();
        final SubCategoryAxis newDomainAxis = new SubCategoryAxis(domainAxis.getLabel());
        newDomainAxis.setLabelFont(domainAxis.getLabelFont());
        newDomainAxis.setTickLabelFont(domainAxis.getTickLabelFont());
        newDomainAxis.setLabelPaint(domainAxis.getLabelPaint());
        newDomainAxis.setTickLabelPaint(domainAxis.getTickLabelPaint());
        newDomainAxis.setAxisLinePaint(domainAxis.getAxisLinePaint());
        newDomainAxis.setTickMarkPaint(domainAxis.getTickMarkPaint());
        newDomainAxis.setTickLabelsVisible(domainAxis.isTickLabelsVisible());
        newDomainAxis.setTickMarksVisible(domainAxis.isTickMarksVisible());
        newDomainAxis.setCategoryMargin(0.05);
        for (final String group : groups) {
            newDomainAxis.addSubCategory(group);
        }

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(newDomainAxis);
        plot.setRenderer(renderer);

        final LegendItemCollection legendItems = new LegendItemCollection();
        for (final String item : seriesColors.keySet()) {
            legendItems.add(new LegendItem(item, seriesColors.get(item)));
        }
        plot.setFixedLegendItems(legendItems);

        chart.getCategoryPlot().setDataset(dataset);
    }

}

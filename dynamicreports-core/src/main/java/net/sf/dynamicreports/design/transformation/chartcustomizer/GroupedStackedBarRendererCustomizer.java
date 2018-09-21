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
package net.sf.dynamicreports.design.transformation.chartcustomizer;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
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

import java.awt.Paint;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>GroupedStackedBarRendererCustomizer class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class GroupedStackedBarRendererCustomizer implements DRIChartCustomizer, Serializable {
    /** Constant <code>GROUP_SERIES_KEY="-{group-series}-"</code> */
    public static final String GROUP_SERIES_KEY = "-{group-series}-";
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;
    private KeyToGroupMap map;
    private Map<String, Paint> seriesColors;

    /** {@inheritDoc} */
    @Override
    public void customize(JFreeChart chart, ReportParameters reportParameters) {
        this.seriesColors = new LinkedHashMap<String, Paint>();
        this.map = null;
        Set<String> groups = new LinkedHashSet<String>();
        CategoryDataset dataset = chart.getCategoryPlot()
                                       .getDataset();

        for (int i = 0; i < dataset.getRowCount(); i++) {
            String rowKey = (String) dataset.getRowKey(i);
            String group = StringUtils.substringBefore(rowKey, GROUP_SERIES_KEY);
            String series = StringUtils.substringAfter(rowKey, GROUP_SERIES_KEY);
            if (map == null) {
                map = new KeyToGroupMap(group);
            }
            map.mapKeyToGroup(rowKey, group);
            groups.add(group);
            if (!seriesColors.containsKey(series)) {
                Paint paint = chart.getCategoryPlot()
                                   .getDrawingSupplier()
                                   .getNextPaint();
                seriesColors.put(series, paint);
            }
        }

        DefaultCategoryDataset newDataset = new DefaultCategoryDataset();
        for (Object column : dataset.getColumnKeys()) {
            for (String group : groups) {
                for (String series : seriesColors.keySet()) {
                    try {
                        Number value = dataset.getValue(group + GROUP_SERIES_KEY + series, (Comparable<?>) column);
                        newDataset.addValue(value, group + GROUP_SERIES_KEY + series, (Comparable<?>) column);
                    } catch (UnknownKeyException e) {
                        newDataset.addValue(0, group + GROUP_SERIES_KEY + series, (Comparable<?>) column);
                    }
                }

            }
        }
        dataset = newDataset;

        GroupedStackedBarRenderer renderer = new GroupedStackedBarRenderer();
        renderer.setSeriesToGroupMap(map);

        StackedBarRenderer categoryRenderer = (StackedBarRenderer) chart.getCategoryPlot()
                                                                        .getRenderer();
        renderer.setBaseItemLabelsVisible(categoryRenderer.getBaseItemLabelsVisible());
        renderer.setBaseItemLabelFont(categoryRenderer.getBaseItemLabelFont());
        renderer.setBaseItemLabelPaint(categoryRenderer.getBaseItemLabelPaint());
        renderer.setBaseItemLabelGenerator(categoryRenderer.getBaseItemLabelGenerator());
        renderer.setShadowVisible(categoryRenderer.getShadowsVisible());

        renderer.setItemMargin(0.10);
        renderer.setDrawBarOutline(false);
        for (int i = 0; i < dataset.getRowCount(); i++) {
            String rowKey = (String) dataset.getRowKey(i);
            String score = StringUtils.substringAfter(rowKey, GROUP_SERIES_KEY);
            renderer.setSeriesPaint(i, seriesColors.get(score));
        }

        CategoryAxis domainAxis = chart.getCategoryPlot()
                                       .getDomainAxis();
        SubCategoryAxis newDomainAxis = new SubCategoryAxis(domainAxis.getLabel());
        newDomainAxis.setLabelFont(domainAxis.getLabelFont());
        newDomainAxis.setTickLabelFont(domainAxis.getTickLabelFont());
        newDomainAxis.setLabelPaint(domainAxis.getLabelPaint());
        newDomainAxis.setTickLabelPaint(domainAxis.getTickLabelPaint());
        newDomainAxis.setAxisLinePaint(domainAxis.getAxisLinePaint());
        newDomainAxis.setTickMarkPaint(domainAxis.getTickMarkPaint());
        newDomainAxis.setTickLabelsVisible(domainAxis.isTickLabelsVisible());
        newDomainAxis.setTickMarksVisible(domainAxis.isTickMarksVisible());
        newDomainAxis.setCategoryMargin(0.05);
        for (String group : groups) {
            newDomainAxis.addSubCategory(group);
        }

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(newDomainAxis);
        plot.setRenderer(renderer);

        LegendItemCollection legendItems = new LegendItemCollection();
        for (String item : seriesColors.keySet()) {
            legendItems.add(new LegendItem(item, seriesColors.get(item)));
        }
        plot.setFixedLegendItems(legendItems);

        chart.getCategoryPlot()
             .setDataset(dataset);
    }

}

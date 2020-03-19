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
package net.sf.dynamicreports.report.builder.chart;

import net.sf.dynamicreports.report.base.chart.DRChart;
import net.sf.dynamicreports.report.builder.DatasetBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.HyperLinkComponentBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.ChartType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.Position;
import net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.jasperreports.engine.JRDataSource;
import org.apache.commons.lang3.Validate;

import java.awt.Color;
import java.sql.Connection;

/**
 * <p>Abstract AbstractChartBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
@SuppressWarnings("unchecked")
public abstract class AbstractChartBuilder<T extends AbstractChartBuilder<T>> extends HyperLinkComponentBuilder<T, DRChart> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for AbstractChartBuilder.</p>
     *
     * @param chartType a {@link net.sf.dynamicreports.report.constant.ChartType} object.
     */
    protected AbstractChartBuilder(ChartType chartType) {
        super(new DRChart(chartType));
    }

    /**
     * Use addCustomizer or customizers
     *
     * @param customizer a {@link net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer} object.
     * @return a T object.
     */
    @Deprecated
    public T setCustomizer(DRIChartCustomizer customizer) {
        return customizers(customizer);
    }

    /**
     * <p>addCustomizer.</p>
     *
     * @param customizers a {@link net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer} object.
     * @return a T object.
     */
    public T addCustomizer(DRIChartCustomizer... customizers) {
        return customizers(customizers);
    }

    /**
     * <p>customizers.</p>
     *
     * @param customizers a {@link net.sf.dynamicreports.report.definition.chart.DRIChartCustomizer} object.
     * @return a T object.
     */
    public T customizers(DRIChartCustomizer... customizers) {
        Validate.notNull(customizers, "customizers must not be null");
        Validate.noNullElements(customizers, "customizers must not contains null customizer");
        for (DRIChartCustomizer customizer : customizers) {
            getObject().addCustomizer(customizer);
        }
        return (T) this;
    }

    // title

    /**
     * <p>setTitle.</p>
     *
     * @param title a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setTitle(String title) {
        getObject().getTitle().setTitle(Expressions.text(title));
        return (T) this;
    }

    /**
     * <p>setTitle.</p>
     *
     * @param titleExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setTitle(DRIExpression<String> titleExpression) {
        getObject().getTitle().setTitle(titleExpression);
        return (T) this;
    }

    /**
     * <p>setTitleColor.</p>
     *
     * @param titleColor a {@link java.awt.Color} object.
     * @return a T object.
     */
    public T setTitleColor(Color titleColor) {
        getObject().getTitle().setColor(titleColor);
        return (T) this;
    }

    /**
     * <p>setTitleFont.</p>
     *
     * @param titleFont a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     * @return a T object.
     */
    public T setTitleFont(FontBuilder titleFont) {
        Validate.notNull(titleFont, "titleFont must not be null");
        getObject().getTitle().setFont(titleFont.build());
        return (T) this;
    }

    /**
     * <p>setTitlePosition.</p>
     *
     * @param titlePosition a {@link net.sf.dynamicreports.report.constant.Position} object.
     * @return a T object.
     */
    public T setTitlePosition(Position titlePosition) {
        getObject().getTitle().setPosition(titlePosition);
        return (T) this;
    }

    // subtitle

    /**
     * <p>setSubtitle.</p>
     *
     * @param subtitle a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setSubtitle(String subtitle) {
        getObject().getSubtitle().setTitle(Expressions.text(subtitle));
        return (T) this;
    }

    /**
     * <p>setSubtitle.</p>
     *
     * @param subtitleExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setSubtitle(DRIExpression<String> subtitleExpression) {
        getObject().getSubtitle().setTitle(subtitleExpression);
        return (T) this;
    }

    /**
     * <p>setSubtitleColor.</p>
     *
     * @param subtitleColor a {@link java.awt.Color} object.
     * @return a T object.
     */
    public T setSubtitleColor(Color subtitleColor) {
        getObject().getSubtitle().setColor(subtitleColor);
        return (T) this;
    }

    /**
     * <p>setSubtitleFont.</p>
     *
     * @param subtitleFont a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     * @return a T object.
     */
    public T setSubtitleFont(FontBuilder subtitleFont) {
        Validate.notNull(subtitleFont, "subtitleFont must not be null");
        getObject().getSubtitle().setFont(subtitleFont.build());
        return (T) this;
    }

    // legend

    /**
     * <p>setLegendColor.</p>
     *
     * @param legendColor a {@link java.awt.Color} object.
     * @return a T object.
     */
    public T setLegendColor(Color legendColor) {
        getObject().getLegend().setColor(legendColor);
        return (T) this;
    }

    /**
     * <p>setLegendBackgroundColor.</p>
     *
     * @param legendBackgroundColor a {@link java.awt.Color} object.
     * @return a T object.
     */
    public T setLegendBackgroundColor(Color legendBackgroundColor) {
        getObject().getLegend().setBackgroundColor(legendBackgroundColor);
        return (T) this;
    }

    /**
     * <p>setShowLegend.</p>
     *
     * @param showLegend a {@link java.lang.Boolean} object.
     * @return a T object.
     */
    public T setShowLegend(Boolean showLegend) {
        getObject().getLegend().setShowLegend(showLegend);
        return (T) this;
    }

    /**
     * <p>setLegendFont.</p>
     *
     * @param legendFont a {@link net.sf.dynamicreports.report.builder.style.FontBuilder} object.
     * @return a T object.
     */
    public T setLegendFont(FontBuilder legendFont) {
        Validate.notNull(legendFont, "legendFont must not be null");
        getObject().getLegend().setFont(legendFont.build());
        return (T) this;
    }

    /**
     * <p>setLegendPosition.</p>
     *
     * @param legendPosition a {@link net.sf.dynamicreports.report.constant.Position} object.
     * @return a T object.
     */
    public T setLegendPosition(Position legendPosition) {
        getObject().getLegend().setPosition(legendPosition);
        return (T) this;
    }

    // subdataset

    /**
     * <p>setSubDataset.</p>
     *
     * @param subDataset a {@link net.sf.dynamicreports.report.builder.DatasetBuilder} object.
     * @return a T object.
     */
    public T setSubDataset(DatasetBuilder subDataset) {
        Validate.notNull(subDataset, "subDataset must not be null");
        getObject().getDataset().setSubDataset(subDataset.build());
        return (T) this;
    }

    /**
     * <p>setDataSource.</p>
     *
     * @param dataSource a {@link net.sf.jasperreports.engine.JRDataSource} object.
     * @return a T object.
     */
    public T setDataSource(JRDataSource dataSource) {
        DatasetBuilder dataset = DynamicReports.dataset();
        dataset.setDataSource(dataSource);
        return setSubDataset(dataset);
    }

    /**
     * <p>setDataSource.</p>
     *
     * @param dataSourceExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setDataSource(DRIExpression<JRDataSource> dataSourceExpression) {
        DatasetBuilder dataset = DynamicReports.dataset();
        dataset.setDataSource(dataSourceExpression);
        return setSubDataset(dataset);
    }

    /**
     * <p>setDataSource.</p>
     *
     * @param sql        a {@link java.lang.String} object.
     * @param connection a {@link java.sql.Connection} object.
     * @return a T object.
     */
    public T setDataSource(String sql, Connection connection) {
        DatasetBuilder dataset = DynamicReports.dataset();
        dataset.setDataSource(sql, connection);
        return setSubDataset(dataset);
    }

    /**
     * <p>getChart.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.chart.DRChart} object.
     */
    public DRChart getChart() {
        return build();
    }
}

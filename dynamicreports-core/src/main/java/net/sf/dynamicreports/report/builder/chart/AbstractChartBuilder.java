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

package net.sf.dynamicreports.report.builder.chart;

import java.awt.Color;
import java.sql.Connection;

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

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings("unchecked")
public abstract class AbstractChartBuilder<T extends AbstractChartBuilder<T>> extends HyperLinkComponentBuilder<T, DRChart> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected AbstractChartBuilder(ChartType chartType) {
		super(new DRChart(chartType));
	}

	/**
	 * Use addCustomizer or customizers
	 */
	@Deprecated
	public T setCustomizer(DRIChartCustomizer customizer) {
		return customizers(customizer);
	}

	public T addCustomizer(DRIChartCustomizer... customizers) {
		return customizers(customizers);
	}

	public T customizers(DRIChartCustomizer... customizers) {
		Validate.notNull(customizers, "customizers must not be null");
		Validate.noNullElements(customizers, "customizers must not contains null customizer");
		for (DRIChartCustomizer customizer : customizers) {
			getObject().addCustomizer(customizer);
		}
		return (T) this;
	}

	// title
	public T setTitle(String title) {
		getObject().getTitle().setTitle(Expressions.text(title));
		return (T) this;
	}

	public T setTitle(DRIExpression<String> titleExpression) {
		getObject().getTitle().setTitle(titleExpression);
		return (T) this;
	}

	public T setTitleColor(Color titleColor) {
		getObject().getTitle().setColor(titleColor);
		return (T) this;
	}

	public T setTitleFont(FontBuilder titleFont) {
		Validate.notNull(titleFont, "titleFont must not be null");
		getObject().getTitle().setFont(titleFont.build());
		return (T) this;
	}

	public T setTitlePosition(Position titlePosition) {
		getObject().getTitle().setPosition(titlePosition);
		return (T) this;
	}

	// subtitle
	public T setSubtitle(String subtitle) {
		getObject().getSubtitle().setTitle(Expressions.text(subtitle));
		return (T) this;
	}

	public T setSubtitle(DRIExpression<String> subtitleExpression) {
		getObject().getSubtitle().setTitle(subtitleExpression);
		return (T) this;
	}

	public T setSubtitleColor(Color subtitleColor) {
		getObject().getSubtitle().setColor(subtitleColor);
		return (T) this;
	}

	public T setSubtitleFont(FontBuilder subtitleFont) {
		Validate.notNull(subtitleFont, "subtitleFont must not be null");
		getObject().getSubtitle().setFont(subtitleFont.build());
		return (T) this;
	}

	// legend
	public T setLegendColor(Color legendColor) {
		getObject().getLegend().setColor(legendColor);
		return (T) this;
	}

	public T setLegendBackgroundColor(Color legendBackgroundColor) {
		getObject().getLegend().setBackgroundColor(legendBackgroundColor);
		return (T) this;
	}

	public T setShowLegend(Boolean showLegend) {
		getObject().getLegend().setShowLegend(showLegend);
		return (T) this;
	}

	public T setLegendFont(FontBuilder legendFont) {
		Validate.notNull(legendFont, "legendFont must not be null");
		getObject().getLegend().setFont(legendFont.build());
		return (T) this;
	}

	public T setLegendPosition(Position legendPosition) {
		getObject().getLegend().setPosition(legendPosition);
		return (T) this;
	}

	// subdataset
	public T setSubDataset(DatasetBuilder subDataset) {
		Validate.notNull(subDataset, "subDataset must not be null");
		getObject().getDataset().setSubDataset(subDataset.build());
		return (T) this;
	}

	public T setDataSource(JRDataSource dataSource) {
		DatasetBuilder dataset = DynamicReports.dataset();
		dataset.setDataSource(dataSource);
		return setSubDataset(dataset);
	}

	public T setDataSource(DRIExpression<JRDataSource> dataSourceExpression) {
		DatasetBuilder dataset = DynamicReports.dataset();
		dataset.setDataSource(dataSourceExpression);
		return setSubDataset(dataset);
	}

	public T setDataSource(String sql, Connection connection) {
		DatasetBuilder dataset = DynamicReports.dataset();
		dataset.setDataSource(sql, connection);
		return setSubDataset(dataset);
	}

	public DRChart getChart() {
		return build();
	}
}

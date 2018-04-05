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

import org.apache.commons.lang3.Validate;

import net.sf.dynamicreports.report.base.chart.dataset.DRChartSerie;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.HyperLinkBuilder;
import net.sf.dynamicreports.report.builder.column.ValueColumnBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings("unchecked")
public abstract class AbstractChartSerieBuilder<T extends AbstractChartSerieBuilder<T, U>, U extends DRChartSerie> extends AbstractBuilder<T, U> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected AbstractChartSerieBuilder(U object) {
		super(object);
	}

	public T setSeries(ValueColumnBuilder<?, ?> column) {
		Validate.notNull(column, "column must not be null");
		getObject().setSeriesExpression(column.getColumn());
		return (T) this;
	}

	public T setSeries(String fieldName, Class<?> valueClass) {
		return setSeries(DynamicReports.field(fieldName, valueClass));
	}

	public T setSeries(FieldBuilder<?> field) {
		Validate.notNull(field, "field must not be null");
		getObject().setSeriesExpression(field.build());
		return (T) this;
	}

	public T setSeries(DRIExpression<?> expression) {
		getObject().setSeriesExpression(expression);
		return (T) this;
	}

	public T setItemHyperLink(HyperLinkBuilder itemHyperLink) {
		Validate.notNull(itemHyperLink, "itemHyperLink must not be null");
		getObject().setItemHyperLink(itemHyperLink.build());
		return (T) this;
	}
}

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

package net.sf.dynamicreports.design.transformation.expressions;

import java.util.List;

import net.sf.dynamicreports.design.transformation.chartcustomizer.GroupedStackedBarRendererCustomizer;
import net.sf.dynamicreports.report.builder.expression.AbstractComplexExpression;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class GroupedSeriesExpression extends AbstractComplexExpression<String> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	public GroupedSeriesExpression(DRIExpression<?> groupExpression, DRIExpression<?> seriesExpression, DRIExpression<?> labelExpression, int index) {
		if (groupExpression != null) {
			addExpression(groupExpression);
		} else {
			addExpression(Expressions.text("group"));
		}
		if (seriesExpression != null) {
			addExpression(seriesExpression);
		} else {
			if (labelExpression != null) {
				addExpression(labelExpression);
			} else {
				addExpression(Expressions.text("serie" + index));
			}
		}
	}

	@Override
	public String evaluate(List<?> values, ReportParameters reportParameters) {
		String group = (String) values.get(0);
		String series = (String) values.get(1);
		return group + GroupedStackedBarRendererCustomizer.GROUP_SERIES_KEY + series;
	}
}

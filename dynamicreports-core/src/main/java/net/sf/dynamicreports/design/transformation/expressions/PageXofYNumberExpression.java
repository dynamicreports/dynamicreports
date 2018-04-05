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

import java.text.MessageFormat;
import java.util.List;

import net.sf.dynamicreports.report.builder.expression.AbstractComplexExpression;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class PageXofYNumberExpression extends AbstractComplexExpression<String> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private int index;

	public PageXofYNumberExpression(DRIExpression<String> pageNumberFormatExpression, int index) {
		addExpression(pageNumberFormatExpression);
		this.index = index;
	}

	@Override
	public String evaluate(List<?> values, ReportParameters reportParameters) {
		String pattern = (String) values.get(0);
		Validate.isTrue(StringUtils.contains(pattern, "{0}"), "Wrong format pattern \"" + pattern + "\", missing argument {0}");
		Validate.isTrue(StringUtils.contains(pattern, "{1}"), "Wrong format pattern \"" + pattern + "\", missing argument {1}");
		Validate.isTrue(pattern.indexOf("{0}") < pattern.indexOf("{1}"), "Wrong format pattern \"" + pattern + "\", argument {0} must be before {1}");
		int index1 = pattern.indexOf("{0}");
		if (index == 0) {
			pattern = pattern.substring(0, index1 + 3);
		} else {
			pattern = pattern.substring(index1 + 3);
		}
		MessageFormat format = new MessageFormat(pattern, reportParameters.getLocale());
		String result = format.format(new Object[] { reportParameters.getPageNumber(), reportParameters.getPageNumber() });
		return result;
	}
}

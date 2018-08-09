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

import java.util.ResourceBundle;

import net.sf.dynamicreports.report.base.expression.AbstractValueFormatter;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.ReportParameters;

/**
 * <p>BooleanTextValueFormatter class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class BooleanTextValueFormatter extends AbstractValueFormatter<String, Boolean> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String keyTrue;
	private String keyFalse;
	private boolean emptyWhenNullValue;

	/**
	 * <p>Constructor for BooleanTextValueFormatter.</p>
	 *
	 * @param keyTrue a {@link java.lang.String} object.
	 * @param keyFalse a {@link java.lang.String} object.
	 * @param emptyWhenNullValue a boolean.
	 */
	public BooleanTextValueFormatter(String keyTrue, String keyFalse, boolean emptyWhenNullValue) {
		this.keyTrue = keyTrue;
		this.keyFalse = keyFalse;
		this.emptyWhenNullValue = emptyWhenNullValue;
	}

	/** {@inheritDoc} */
	@Override
	public String format(Boolean value, ReportParameters reportParameters) {
		if (emptyWhenNullValue && value == null) {
			return "";
		}
		String key;
		if (value != null && value) {
			key = keyTrue;
		} else {
			key = keyFalse;
		}
		return ResourceBundle.getBundle(Constants.RESOURCE_BUNDLE_NAME, reportParameters.getLocale()).getString(key);
	}
}

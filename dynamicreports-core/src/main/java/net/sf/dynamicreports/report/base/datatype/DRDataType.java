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

package net.sf.dynamicreports.report.base.datatype;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.definition.expression.DRIValueFormatter;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDataType<U, T extends U> extends AbstractDataType<U, T> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private String pattern;
	private HorizontalTextAlignment horizontalTextAlignment;
	private DRIValueFormatter<?, ? extends U> valueFormatter;

	public DRDataType() {
	}

	public DRDataType(String pattern) {
		this.pattern = pattern;
	}

	public DRDataType(String pattern, HorizontalTextAlignment horizontalTextAlignment) {
		this.pattern = pattern;
		this.horizontalTextAlignment = horizontalTextAlignment;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String getPattern() {
		return pattern;
	}

	public void setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
		this.horizontalTextAlignment = horizontalTextAlignment;
	}

	@Override
	public HorizontalTextAlignment getHorizontalTextAlignment() {
		return horizontalTextAlignment;
	}

	public void setValueFormatter(DRIValueFormatter<?, ? extends U> valueFormatter) {
		this.valueFormatter = valueFormatter;
	}

	@Override
	public DRIValueFormatter<?, ? extends U> getValueFormatter() {
		return valueFormatter;
	}

	public String toString(T value) {
		return String.valueOf(value);
	}
}

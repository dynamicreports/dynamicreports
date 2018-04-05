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

package net.sf.dynamicreports.report.builder.component;

import net.sf.dynamicreports.report.base.component.DRFormatField;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings({ "unchecked", "deprecation" })
public abstract class AbstractFormatFieldBuilder<T extends AbstractFormatFieldBuilder<T, U>, U extends DRFormatField> extends HyperLinkComponentBuilder<T, U> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected AbstractFormatFieldBuilder(U formatField) {
		super(formatField);
	}

	public T setFormatExpression(String format) {
		getObject().setFormatExpression(Expressions.text(format));
		return (T) this;
	}

	public T setFormatExpression(DRIExpression<String> formatExpression) {
		getObject().setFormatExpression(formatExpression);
		return (T) this;
	}

	/**
	 * @deprecated use setHorizontalTextAlignment instead
	 */
	@Deprecated
	public T setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
		if (horizontalAlignment != null) {
			getObject().setHorizontalTextAlignment(HorizontalTextAlignment.valueOf(horizontalAlignment.name()));
		} else {
			getObject().setHorizontalTextAlignment(null);
		}
		return (T) this;
	}

	public T setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
		getObject().setHorizontalTextAlignment(horizontalTextAlignment);
		return (T) this;
	}
}

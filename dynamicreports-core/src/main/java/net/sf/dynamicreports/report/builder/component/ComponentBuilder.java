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

import net.sf.dynamicreports.report.base.component.DRComponent;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;
import net.sf.dynamicreports.report.builder.tableofcontents.TableOfContentsHeadingBuilder;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;
import net.sf.dynamicreports.report.definition.expression.DRIPropertyExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings("unchecked")
public abstract class ComponentBuilder<T extends ComponentBuilder<T, U>, U extends DRComponent> extends AbstractBuilder<T, U> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected ComponentBuilder(U object) {
		super(object);
	}

	public T setStyle(ReportStyleBuilder style) {
		if (style != null) {
			getObject().setStyle(style.getStyle());
		} else {
			getObject().setStyle(null);
		}
		return (T) this;
	}

	public T setPrintWhenExpression(DRIExpression<Boolean> printWhenExpression) {
		getObject().setPrintWhenExpression(printWhenExpression);
		return (T) this;
	}

	public T removeLineWhenBlank() {
		return setRemoveLineWhenBlank(true);
	}

	public T setRemoveLineWhenBlank(Boolean removeLineWhenBlank) {
		getObject().setRemoveLineWhenBlank(removeLineWhenBlank);
		return (T) this;
	}

	public T addProperty(DRIPropertyExpression propertyExpression) {
		getComponent().addPropertyExpression(propertyExpression);
		return (T) this;
	}

	public T addProperty(String name, DRIExpression<String> valueExpression) {
		getComponent().addPropertyExpression(Expressions.property(name, valueExpression));
		return (T) this;
	}

	public T addProperty(String name, String value) {
		getComponent().addPropertyExpression(Expressions.property(name, value));
		return (T) this;
	}

	public T setTableOfContentsHeading(String label) {
		TableOfContentsHeadingBuilder tocHeading = DynamicReports.tableOfContentsHeading(label);
		return setTableOfContentsHeading(tocHeading);
	}

	public T setTableOfContentsHeading(TableOfContentsHeadingBuilder tocHeading) {
		Validate.notNull(tocHeading, "tocHeading must not be null");
		getComponent().setTableOfContentsHeading(tocHeading.build());
		return (T) this;
	}

	public U getComponent() {
		return build();
	}
}

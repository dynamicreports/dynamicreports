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

import net.sf.dynamicreports.report.base.component.DRBooleanField;
import net.sf.dynamicreports.report.builder.FieldBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.BooleanComponentType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
@SuppressWarnings("deprecation")
public class BooleanFieldBuilder extends HyperLinkComponentBuilder<BooleanFieldBuilder, DRBooleanField> {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	protected BooleanFieldBuilder() {
		super(new DRBooleanField());
	}

	public BooleanFieldBuilder setValue(FieldBuilder<Boolean> field) {
		Validate.notNull(field, "field must not be null");
		getObject().setValueExpression(field.getField());
		return this;
	}

	public BooleanFieldBuilder setValue(DRIExpression<Boolean> valueExpression) {
		getObject().setValueExpression(valueExpression);
		return this;
	}

	public BooleanFieldBuilder setValue(Boolean value) {
		getObject().setValueExpression(Expressions.value(value));
		return this;
	}

	public BooleanFieldBuilder setComponentType(BooleanComponentType booleanComponentType) {
		getObject().setComponentType(booleanComponentType);
		return this;
	}

	public BooleanFieldBuilder setEmptyWhenNullValue(Boolean emptyWhenNullValue) {
		getObject().setEmptyWhenNullValue(emptyWhenNullValue);
		return this;
	}

	/**
	 * Sets the boolean image dimension. Has effect only when the boolean value is presented as an image.
	 *
	 * @param width
	 *          the image width
	 * @param height
	 *          the image height
	 * @return a column builder
	 */
	public BooleanFieldBuilder setImageDimension(Integer width, Integer height) {
		getObject().setImageWidth(width);
		getObject().setImageHeight(height);
		return this;
	}

	/**
	 * Sets the boolean image width. Has effect only when the boolean value is presented as an image.
	 *
	 * @param width
	 *          the image width
	 * @return a column builder
	 */
	public BooleanFieldBuilder setImageWidth(Integer width) {
		getObject().setImageWidth(width);
		return this;
	}

	/**
	 * Sets the boolean image height. Has effect only when the boolean value is presented as an image.
	 *
	 * @param height
	 *          the image height
	 * @return a column builder
	 */
	public BooleanFieldBuilder setImageHeight(Integer height) {
		getObject().setImageHeight(height);
		return this;
	}

	public BooleanFieldBuilder setHorizontalImageAlignment(HorizontalImageAlignment horizontalImageAlignment) {
		getObject().setHorizontalImageAlignment(horizontalImageAlignment);
		return this;
	}

	/**
	 * @deprecated use setHorizontalImageAlignment instead
	 */
	@Deprecated
	public BooleanFieldBuilder setHorizontalAlignment(HorizontalAlignment horizontalAlignment) {
		if (horizontalAlignment != null) {
			getObject().setHorizontalImageAlignment(HorizontalImageAlignment.valueOf(horizontalAlignment.name()));
		} else {
			getObject().setHorizontalImageAlignment(null);
		}
		return this;
	}

	public BooleanFieldBuilder setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
		getObject().setHorizontalTextAlignment(horizontalTextAlignment);
		return this;
	}
}

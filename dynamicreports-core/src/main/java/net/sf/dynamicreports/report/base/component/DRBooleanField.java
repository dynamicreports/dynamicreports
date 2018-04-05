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

package net.sf.dynamicreports.report.base.component;

import net.sf.dynamicreports.report.constant.BooleanComponentType;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.HorizontalImageAlignment;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;
import net.sf.dynamicreports.report.definition.component.DRIBooleanField;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

import org.apache.commons.lang3.Validate;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRBooleanField extends DRHyperLinkComponent implements DRIBooleanField {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIExpression<Boolean> valueExpression;
	private BooleanComponentType componentType;
	private Boolean emptyWhenNullValue;
	private Integer imageWidth;
	private Integer imageHeight;
	private HorizontalImageAlignment horizontalImageAlignment;
	private HorizontalTextAlignment horizontalTextAlignment;

	@Override
	public DRIExpression<Boolean> getValueExpression() {
		return valueExpression;
	}

	public void setValueExpression(DRIExpression<Boolean> valueExpression) {
		Validate.notNull(valueExpression, "valueExpression must not be null");
		this.valueExpression = valueExpression;
	}

	@Override
	public BooleanComponentType getComponentType() {
		return componentType;
	}

	public void setComponentType(BooleanComponentType componentType) {
		this.componentType = componentType;
	}

	@Override
	public Boolean getEmptyWhenNullValue() {
		return emptyWhenNullValue;
	}

	public void setEmptyWhenNullValue(Boolean emptyWhenNullValue) {
		this.emptyWhenNullValue = emptyWhenNullValue;
	}

	@Override
	public Integer getImageWidth() {
		return imageWidth;
	}

	public void setImageWidth(Integer imageWidth) {
		if (imageWidth != null) {
			Validate.isTrue(imageWidth >= 0, "imageWidth must be >= 0");
		}
		this.imageWidth = imageWidth;
	}

	@Override
	public Integer getImageHeight() {
		return imageHeight;
	}

	public void setImageHeight(Integer imageHeight) {
		if (imageHeight != null) {
			Validate.isTrue(imageHeight >= 0, "imageHeight must be >= 0");
		}
		this.imageHeight = imageHeight;
	}

	@Override
	public HorizontalImageAlignment getHorizontalImageAlignment() {
		return horizontalImageAlignment;
	}

	public void setHorizontalImageAlignment(HorizontalImageAlignment horizontalImageAlignment) {
		this.horizontalImageAlignment = horizontalImageAlignment;
	}

	@Override
	public HorizontalTextAlignment getHorizontalTextAlignment() {
		return horizontalTextAlignment;
	}

	public void setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
		this.horizontalTextAlignment = horizontalTextAlignment;
	}
}

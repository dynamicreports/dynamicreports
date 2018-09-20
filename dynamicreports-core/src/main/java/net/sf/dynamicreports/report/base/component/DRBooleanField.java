/*
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
 * <p>DRBooleanField class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
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

    /** {@inheritDoc} */
    @Override
    public DRIExpression<Boolean> getValueExpression() {
        return valueExpression;
    }

    /**
     * <p>Setter for the field <code>valueExpression</code>.</p>
     *
     * @param valueExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setValueExpression(DRIExpression<Boolean> valueExpression) {
        Validate.notNull(valueExpression, "valueExpression must not be null");
        this.valueExpression = valueExpression;
    }

    /** {@inheritDoc} */
    @Override
    public BooleanComponentType getComponentType() {
        return componentType;
    }

    /**
     * <p>Setter for the field <code>componentType</code>.</p>
     *
     * @param componentType a {@link net.sf.dynamicreports.report.constant.BooleanComponentType} object.
     */
    public void setComponentType(BooleanComponentType componentType) {
        this.componentType = componentType;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getEmptyWhenNullValue() {
        return emptyWhenNullValue;
    }

    /**
     * <p>Setter for the field <code>emptyWhenNullValue</code>.</p>
     *
     * @param emptyWhenNullValue a {@link java.lang.Boolean} object.
     */
    public void setEmptyWhenNullValue(Boolean emptyWhenNullValue) {
        this.emptyWhenNullValue = emptyWhenNullValue;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getImageWidth() {
        return imageWidth;
    }

    /**
     * <p>Setter for the field <code>imageWidth</code>.</p>
     *
     * @param imageWidth a {@link java.lang.Integer} object.
     */
    public void setImageWidth(Integer imageWidth) {
        if (imageWidth != null) {
            Validate.isTrue(imageWidth >= 0, "imageWidth must be >= 0");
        }
        this.imageWidth = imageWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getImageHeight() {
        return imageHeight;
    }

    /**
     * <p>Setter for the field <code>imageHeight</code>.</p>
     *
     * @param imageHeight a {@link java.lang.Integer} object.
     */
    public void setImageHeight(Integer imageHeight) {
        if (imageHeight != null) {
            Validate.isTrue(imageHeight >= 0, "imageHeight must be >= 0");
        }
        this.imageHeight = imageHeight;
    }

    /** {@inheritDoc} */
    @Override
    public HorizontalImageAlignment getHorizontalImageAlignment() {
        return horizontalImageAlignment;
    }

    /**
     * <p>Setter for the field <code>horizontalImageAlignment</code>.</p>
     *
     * @param horizontalImageAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalImageAlignment} object.
     */
    public void setHorizontalImageAlignment(HorizontalImageAlignment horizontalImageAlignment) {
        this.horizontalImageAlignment = horizontalImageAlignment;
    }

    /** {@inheritDoc} */
    @Override
    public HorizontalTextAlignment getHorizontalTextAlignment() {
        return horizontalTextAlignment;
    }

    /**
     * <p>Setter for the field <code>horizontalTextAlignment</code>.</p>
     *
     * @param horizontalTextAlignment a {@link net.sf.dynamicreports.report.constant.HorizontalTextAlignment} object.
     */
    public void setHorizontalTextAlignment(HorizontalTextAlignment horizontalTextAlignment) {
        this.horizontalTextAlignment = horizontalTextAlignment;
    }
}

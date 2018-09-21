/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.report.base.style;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.style.DRIPadding;
import org.apache.commons.lang3.Validate;

/**
 * <p>DRPadding class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRPadding implements DRIPadding {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Integer top;
    private Integer left;
    private Integer bottom;
    private Integer right;

    /**
     * <p>Constructor for DRPadding.</p>
     */
    public DRPadding() {
    }

    /**
     * <p>Constructor for DRPadding.</p>
     *
     * @param padding a {@link java.lang.Integer} object.
     */
    public DRPadding(Integer padding) {
        if (padding != null) {
            Validate.isTrue(padding >= 0, "padding must be >= 0");
        }
        top = padding;
        left = padding;
        bottom = padding;
        right = padding;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getTop() {
        return top;
    }

    /**
     * <p>Setter for the field <code>top</code>.</p>
     *
     * @param top a {@link java.lang.Integer} object.
     */
    public void setTop(Integer top) {
        if (top != null) {
            Validate.isTrue(top >= 0, "top must be >= 0");
        }
        this.top = top;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getLeft() {
        return left;
    }

    /**
     * <p>Setter for the field <code>left</code>.</p>
     *
     * @param left a {@link java.lang.Integer} object.
     */
    public void setLeft(Integer left) {
        if (left != null) {
            Validate.isTrue(left >= 0, "left must be >= 0");
        }
        this.left = left;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getBottom() {
        return bottom;
    }

    /**
     * <p>Setter for the field <code>bottom</code>.</p>
     *
     * @param bottom a {@link java.lang.Integer} object.
     */
    public void setBottom(Integer bottom) {
        if (bottom != null) {
            Validate.isTrue(bottom >= 0, "bottom must be >= 0");
        }
        this.bottom = bottom;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getRight() {
        return right;
    }

    /**
     * <p>Setter for the field <code>right</code>.</p>
     *
     * @param right a {@link java.lang.Integer} object.
     */
    public void setRight(Integer right) {
        if (right != null) {
            Validate.isTrue(right >= 0, "right must be >= 0");
        }
        this.right = right;
    }
}

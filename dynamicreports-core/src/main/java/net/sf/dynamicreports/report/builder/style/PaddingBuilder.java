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
package net.sf.dynamicreports.report.builder.style;

import net.sf.dynamicreports.report.base.style.DRPadding;
import net.sf.dynamicreports.report.builder.AbstractBuilder;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>PaddingBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class PaddingBuilder extends AbstractBuilder<PaddingBuilder, DRPadding> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for PaddingBuilder.</p>
     */
    protected PaddingBuilder() {
        super(new DRPadding());
    }

    /**
     * <p>Constructor for PaddingBuilder.</p>
     *
     * @param padding a int.
     */
    protected PaddingBuilder(int padding) {
        super(new DRPadding(padding));
    }

    /**
     * <p>setTop.</p>
     *
     * @param top a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.PaddingBuilder} object.
     */
    public PaddingBuilder setTop(Integer top) {
        getObject().setTop(top);
        return this;
    }

    /**
     * <p>setLeft.</p>
     *
     * @param left a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.PaddingBuilder} object.
     */
    public PaddingBuilder setLeft(Integer left) {
        getObject().setLeft(left);
        return this;
    }

    /**
     * <p>setBottom.</p>
     *
     * @param bottom a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.PaddingBuilder} object.
     */
    public PaddingBuilder setBottom(Integer bottom) {
        getObject().setBottom(bottom);
        return this;
    }

    /**
     * <p>setRight.</p>
     *
     * @param right a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.style.PaddingBuilder} object.
     */
    public PaddingBuilder setRight(Integer right) {
        getObject().setRight(right);
        return this;
    }

    /**
     * <p>getPadding.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.base.style.DRPadding} object.
     */
    public DRPadding getPadding() {
        return build();
    }
}

/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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
package net.sf.dynamicreports.report.builder.barcode;

import net.sf.dynamicreports.report.base.barcode.DRBarbecue;
import net.sf.dynamicreports.report.builder.component.DimensionComponentBuilder;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.BarbecueType;
import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>BarbecueBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class BarbecueBuilder extends DimensionComponentBuilder<BarbecueBuilder, DRBarbecue> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for BarbecueBuilder.</p>
     *
     * @param type a {@link net.sf.dynamicreports.report.constant.BarbecueType} object.
     * @param code a {@link java.lang.String} object.
     */
    protected BarbecueBuilder(BarbecueType type, String code) {
        super(new DRBarbecue());
        getObject().setType(type);
        setCode(code);
    }

    /**
     * <p>Constructor for BarbecueBuilder.</p>
     *
     * @param type           a {@link net.sf.dynamicreports.report.constant.BarbecueType} object.
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    protected BarbecueBuilder(BarbecueType type, DRIExpression<String> codeExpression) {
        super(new DRBarbecue());
        getObject().setType(type);
        setCode(codeExpression);
    }

    /**
     * <p>setCode.</p>
     *
     * @param code a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder setCode(String code) {
        getObject().setCodeExpression(Expressions.text(code));
        return this;
    }

    /**
     * <p>setCode.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder setCode(DRIExpression<String> codeExpression) {
        getObject().setCodeExpression(codeExpression);
        return this;
    }

    /**
     * <p>setApplicationIdentifierExpression.</p>
     *
     * @param applicationIdentifier a {@link java.lang.String} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder setApplicationIdentifierExpression(String applicationIdentifier) {
        getObject().setApplicationIdentifierExpression(Expressions.text(applicationIdentifier));
        return this;
    }

    /**
     * <p>setApplicationIdentifierExpression.</p>
     *
     * @param applicationIdentifierExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder setApplicationIdentifierExpression(DRIExpression<String> applicationIdentifierExpression) {
        getObject().setApplicationIdentifierExpression(applicationIdentifierExpression);
        return this;
    }

    /**
     * <p>setDrawText.</p>
     *
     * @param drawText a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder setDrawText(Boolean drawText) {
        getObject().setDrawText(drawText);
        return this;
    }

    /**
     * <p>setChecksumRequired.</p>
     *
     * @param checksumRequired a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder setChecksumRequired(Boolean checksumRequired) {
        getObject().setChecksumRequired(checksumRequired);
        return this;
    }

    /**
     * <p>setBarWidth.</p>
     *
     * @param barWidth a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder setBarWidth(Integer barWidth) {
        getObject().setBarWidth(barWidth);
        return this;
    }

    /**
     * <p>setBarHeight.</p>
     *
     * @param barHeight a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder setBarHeight(Integer barHeight) {
        getObject().setBarHeight(barHeight);
        return this;
    }

    /**
     * <p>setOrientation.</p>
     *
     * @param orientation a {@link net.sf.dynamicreports.report.constant.BarcodeOrientation} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.BarbecueBuilder} object.
     */
    public BarbecueBuilder setOrientation(BarcodeOrientation orientation) {
        getObject().setOrientation(orientation);
        return this;
    }
}

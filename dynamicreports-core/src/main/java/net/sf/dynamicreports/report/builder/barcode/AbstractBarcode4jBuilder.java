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
package net.sf.dynamicreports.report.builder.barcode;

import net.sf.dynamicreports.report.base.barcode.DRBarcode4j;
import net.sf.dynamicreports.report.builder.expression.Expressions;
import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.BarcodeTextPosition;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>Abstract AbstractBarcode4jBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
@SuppressWarnings("unchecked")
public abstract class AbstractBarcode4jBuilder<T extends AbstractBarcode4jBuilder<T, U>, U extends DRBarcode4j> extends AbstractBarcodeBuilder<T, U> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for AbstractBarcode4jBuilder.</p>
     *
     * @param code    a {@link java.lang.String} object.
     * @param barcode a U object.
     */
    protected AbstractBarcode4jBuilder(String code, U barcode) {
        super(code, barcode);
    }

    /**
     * <p>Constructor for AbstractBarcode4jBuilder.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param barcode        a U object.
     */
    protected AbstractBarcode4jBuilder(DRIExpression<String> codeExpression, U barcode) {
        super(codeExpression, barcode);
        setCode(codeExpression);
    }

    /**
     * <p>setPattern.</p>
     *
     * @param pattern a {@link java.lang.String} object.
     * @return a T object.
     */
    public T setPattern(String pattern) {
        getObject().setPatternExpression(Expressions.text(pattern));
        return (T) this;
    }

    /**
     * <p>setPattern.</p>
     *
     * @param patternExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @return a T object.
     */
    public T setPattern(DRIExpression<String> patternExpression) {
        getObject().setPatternExpression(patternExpression);
        return (T) this;
    }

    /**
     * <p>setModuleWidth.</p>
     *
     * @param moduleWidth a {@link java.lang.Double} object.
     * @return a T object.
     */
    public T setModuleWidth(Double moduleWidth) {
        getObject().setModuleWidth(moduleWidth);
        return (T) this;
    }

    /**
     * <p>setOrientation.</p>
     *
     * @param orientation a {@link net.sf.dynamicreports.report.constant.BarcodeOrientation} object.
     * @return a T object.
     */
    public T setOrientation(BarcodeOrientation orientation) {
        getObject().setOrientation(orientation);
        return (T) this;
    }

    /**
     * <p>setTextPosition.</p>
     *
     * @param textPosition a {@link net.sf.dynamicreports.report.constant.BarcodeTextPosition} object.
     * @return a T object.
     */
    public T setTextPosition(BarcodeTextPosition textPosition) {
        getObject().setTextPosition(textPosition);
        return (T) this;
    }

    /**
     * <p>setQuietZone.</p>
     *
     * @param quietZone a {@link java.lang.Double} object.
     * @return a T object.
     */
    public T setQuietZone(Double quietZone) {
        getObject().setQuietZone(quietZone);
        return (T) this;
    }

    /**
     * <p>setVerticalQuietZone.</p>
     *
     * @param verticalQuietZone a {@link java.lang.Double} object.
     * @return a T object.
     */
    public T setVerticalQuietZone(Double verticalQuietZone) {
        getObject().setVerticalQuietZone(verticalQuietZone);
        return (T) this;
    }
}

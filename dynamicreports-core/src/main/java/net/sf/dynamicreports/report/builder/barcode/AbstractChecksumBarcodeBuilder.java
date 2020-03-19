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

import net.sf.dynamicreports.report.base.barcode.DRChecksumBarcode;
import net.sf.dynamicreports.report.constant.BarcodeChecksumMode;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>Abstract AbstractChecksumBarcodeBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
@SuppressWarnings("unchecked")
public abstract class AbstractChecksumBarcodeBuilder<T extends AbstractBarcode4jBuilder<T, U>, U extends DRChecksumBarcode> extends AbstractBarcode4jBuilder<T, U> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for AbstractChecksumBarcodeBuilder.</p>
     *
     * @param code    a {@link java.lang.String} object.
     * @param barcode a U object.
     */
    protected AbstractChecksumBarcodeBuilder(String code, U barcode) {
        super(code, barcode);
    }

    /**
     * <p>Constructor for AbstractChecksumBarcodeBuilder.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     * @param barcode        a U object.
     */
    protected AbstractChecksumBarcodeBuilder(DRIExpression<String> codeExpression, U barcode) {
        super(codeExpression, barcode);
    }

    /**
     * <p>setChecksumMode.</p>
     *
     * @param checksumMode a {@link net.sf.dynamicreports.report.constant.BarcodeChecksumMode} object.
     * @return a T object.
     */
    public T setChecksumMode(BarcodeChecksumMode checksumMode) {
        getObject().setChecksumMode(checksumMode);
        return (T) this;
    }
}

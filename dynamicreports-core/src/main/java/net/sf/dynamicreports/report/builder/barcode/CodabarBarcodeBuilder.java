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

import net.sf.dynamicreports.report.base.barcode.DRCodabarBarcode;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>CodabarBarcodeBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class CodabarBarcodeBuilder extends AbstractBarcode4jBuilder<CodabarBarcodeBuilder, DRCodabarBarcode> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for CodabarBarcodeBuilder.</p>
     *
     * @param code a {@link java.lang.String} object.
     */
    protected CodabarBarcodeBuilder(String code) {
        super(code, new DRCodabarBarcode());
    }

    /**
     * <p>Constructor for CodabarBarcodeBuilder.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    protected CodabarBarcodeBuilder(DRIExpression<String> codeExpression) {
        super(codeExpression, new DRCodabarBarcode());
    }

    /**
     * <p>setWideFactor.</p>
     *
     * @param wideFactor a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.CodabarBarcodeBuilder} object.
     */
    public CodabarBarcodeBuilder setWideFactor(Double wideFactor) {
        getObject().setWideFactor(wideFactor);
        return this;
    }
}

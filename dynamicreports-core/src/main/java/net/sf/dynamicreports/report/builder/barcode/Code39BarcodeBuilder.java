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

import net.sf.dynamicreports.report.base.barcode.DRCode39Barcode;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>Code39BarcodeBuilder class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class Code39BarcodeBuilder extends AbstractChecksumBarcodeBuilder<Code39BarcodeBuilder, DRCode39Barcode> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for Code39BarcodeBuilder.</p>
     *
     * @param code a {@link java.lang.String} object.
     */
    protected Code39BarcodeBuilder(String code) {
        super(code, new DRCode39Barcode());
    }

    /**
     * <p>Constructor for Code39BarcodeBuilder.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    protected Code39BarcodeBuilder(DRIExpression<String> codeExpression) {
        super(codeExpression, new DRCode39Barcode());
    }

    /**
     * <p>setDisplayChecksum.</p>
     *
     * @param displayChecksum a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code39BarcodeBuilder} object.
     */
    public Code39BarcodeBuilder setDisplayChecksum(Boolean displayChecksum) {
        getObject().setDisplayChecksum(displayChecksum);
        return this;
    }

    /**
     * <p>setDisplayStartStop.</p>
     *
     * @param displayStartStop a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code39BarcodeBuilder} object.
     */
    public Code39BarcodeBuilder setDisplayStartStop(Boolean displayStartStop) {
        getObject().setDisplayStartStop(displayStartStop);
        return this;
    }

    /**
     * <p>setExtendedCharSetEnabled.</p>
     *
     * @param extendedCharSetEnabled a {@link java.lang.Boolean} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code39BarcodeBuilder} object.
     */
    public Code39BarcodeBuilder setExtendedCharSetEnabled(Boolean extendedCharSetEnabled) {
        getObject().setExtendedCharSetEnabled(extendedCharSetEnabled);
        return this;
    }

    /**
     * <p>setIntercharGapWidth.</p>
     *
     * @param intercharGapWidth a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code39BarcodeBuilder} object.
     */
    public Code39BarcodeBuilder setIntercharGapWidth(Double intercharGapWidth) {
        getObject().setIntercharGapWidth(intercharGapWidth);
        return this;
    }

    /**
     * <p>setWideFactor.</p>
     *
     * @param wideFactor a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.Code39BarcodeBuilder} object.
     */
    public Code39BarcodeBuilder setWideFactor(Double wideFactor) {
        getObject().setWideFactor(wideFactor);
        return this;
    }
}

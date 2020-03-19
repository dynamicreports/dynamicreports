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

import net.sf.dynamicreports.report.base.barcode.DRRoyalMailCustomerBarcode;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>RoyalMailCustomerBarcodeBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * 
 */
public class RoyalMailCustomerBarcodeBuilder extends AbstractChecksumBarcodeBuilder<RoyalMailCustomerBarcodeBuilder, DRRoyalMailCustomerBarcode> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for RoyalMailCustomerBarcodeBuilder.</p>
     *
     * @param code a {@link java.lang.String} object.
     */
    protected RoyalMailCustomerBarcodeBuilder(String code) {
        super(code, new DRRoyalMailCustomerBarcode());
    }

    /**
     * <p>Constructor for RoyalMailCustomerBarcodeBuilder.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    protected RoyalMailCustomerBarcodeBuilder(DRIExpression<String> codeExpression) {
        super(codeExpression, new DRRoyalMailCustomerBarcode());
    }

    /**
     * <p>setAscenderHeight.</p>
     *
     * @param ascenderHeight a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.RoyalMailCustomerBarcodeBuilder} object.
     */
    public RoyalMailCustomerBarcodeBuilder setAscenderHeight(Double ascenderHeight) {
        getObject().setAscenderHeight(ascenderHeight);
        return this;
    }

    /**
     * <p>setIntercharGapWidth.</p>
     *
     * @param intercharGapWidth a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.RoyalMailCustomerBarcodeBuilder} object.
     */
    public RoyalMailCustomerBarcodeBuilder setIntercharGapWidth(Double intercharGapWidth) {
        getObject().setIntercharGapWidth(intercharGapWidth);
        return this;
    }

    /**
     * <p>setTrackHeight.</p>
     *
     * @param trackHeight a {@link java.lang.Double} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.RoyalMailCustomerBarcodeBuilder} object.
     */
    public RoyalMailCustomerBarcodeBuilder setTrackHeight(Double trackHeight) {
        getObject().setTrackHeight(trackHeight);
        return this;
    }
}

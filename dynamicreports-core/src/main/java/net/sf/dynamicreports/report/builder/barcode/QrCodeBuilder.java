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

import net.sf.dynamicreports.report.base.barcode.DRQrCode;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.QrCodeErrorCorrectionLevel;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>QrCodeBuilder class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class QrCodeBuilder extends AbstractBarcodeBuilder<QrCodeBuilder, DRQrCode> {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    /**
     * <p>Constructor for QrCodeBuilder.</p>
     *
     * @param code a {@link java.lang.String} object.
     */
    protected QrCodeBuilder(String code) {
        super(code, new DRQrCode());
    }

    /**
     * <p>Constructor for QrCodeBuilder.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    protected QrCodeBuilder(DRIExpression<String> codeExpression) {
        super(codeExpression, new DRQrCode());
    }

    /**
     * <p>setMargin.</p>
     *
     * @param margin a {@link java.lang.Integer} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.QrCodeBuilder} object.
     */
    public QrCodeBuilder setMargin(Integer margin) {
        getObject().setMargin(margin);
        return this;
    }

    /**
     * <p>setErrorCorrectionLevel.</p>
     *
     * @param errorCorrectionLevel a {@link net.sf.dynamicreports.report.constant.QrCodeErrorCorrectionLevel} object.
     * @return a {@link net.sf.dynamicreports.report.builder.barcode.QrCodeBuilder} object.
     */
    public QrCodeBuilder setErrorCorrectionLevel(QrCodeErrorCorrectionLevel errorCorrectionLevel) {
        getObject().setErrorCorrectionLevel(errorCorrectionLevel);
        return this;
    }
}

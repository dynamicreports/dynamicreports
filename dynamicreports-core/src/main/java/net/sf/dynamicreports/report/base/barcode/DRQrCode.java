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
package net.sf.dynamicreports.report.base.barcode;

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.constant.QrCodeErrorCorrectionLevel;
import net.sf.dynamicreports.report.definition.barcode.DRIQrCode;

/**
 * <p>DRQrCode class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRQrCode extends DRBarcode implements DRIQrCode {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Integer margin;
    private QrCodeErrorCorrectionLevel errorCorrectionLevel;

    /** {@inheritDoc} */
    @Override
    public Integer getMargin() {
        return margin;
    }

    /**
     * <p>Setter for the field <code>margin</code>.</p>
     *
     * @param margin a {@link java.lang.Integer} object.
     */
    public void setMargin(Integer margin) {
        this.margin = margin;
    }

    /** {@inheritDoc} */
    @Override
    public QrCodeErrorCorrectionLevel getErrorCorrectionLevel() {
        return errorCorrectionLevel;
    }

    /**
     * <p>Setter for the field <code>errorCorrectionLevel</code>.</p>
     *
     * @param errorCorrectionLevel a {@link net.sf.dynamicreports.report.constant.QrCodeErrorCorrectionLevel} object.
     */
    public void setErrorCorrectionLevel(QrCodeErrorCorrectionLevel errorCorrectionLevel) {
        this.errorCorrectionLevel = errorCorrectionLevel;
    }

}

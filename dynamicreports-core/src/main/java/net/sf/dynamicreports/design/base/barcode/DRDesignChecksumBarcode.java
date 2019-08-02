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
package net.sf.dynamicreports.design.base.barcode;

import net.sf.dynamicreports.design.definition.barcode.DRIDesignChecksumBarcode;
import net.sf.dynamicreports.report.constant.BarcodeChecksumMode;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>Abstract DRDesignChecksumBarcode class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public abstract class DRDesignChecksumBarcode extends DRDesignBarcode4j implements DRIDesignChecksumBarcode {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private BarcodeChecksumMode checksumMode;

    /**
     * <p>Constructor for DRDesignChecksumBarcode.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public DRDesignChecksumBarcode(String name) {
        super(name);
    }

    /** {@inheritDoc} */
    @Override
    public BarcodeChecksumMode getChecksumMode() {
        return checksumMode;
    }

    /**
     * <p>Setter for the field <code>checksumMode</code>.</p>
     *
     * @param checksumMode a {@link net.sf.dynamicreports.report.constant.BarcodeChecksumMode} object.
     */
    public void setChecksumMode(BarcodeChecksumMode checksumMode) {
        this.checksumMode = checksumMode;
    }
}

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

import net.sf.dynamicreports.design.definition.barcode.DRIDesignDataMatrixBarcode;
import net.sf.dynamicreports.report.constant.BarcodeShape;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignDataMatrixBarcode class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignDataMatrixBarcode extends DRDesignBarcode4j implements DRIDesignDataMatrixBarcode {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private BarcodeShape shape;

    /**
     * <p>Constructor for DRDesignDataMatrixBarcode.</p>
     */
    public DRDesignDataMatrixBarcode() {
        super("DataMatrix");
    }

    /** {@inheritDoc} */
    @Override
    public BarcodeShape getShape() {
        return shape;
    }

    /**
     * <p>Setter for the field <code>shape</code>.</p>
     *
     * @param shape a {@link net.sf.dynamicreports.report.constant.BarcodeShape} object.
     */
    public void setShape(BarcodeShape shape) {
        this.shape = shape;
    }
}

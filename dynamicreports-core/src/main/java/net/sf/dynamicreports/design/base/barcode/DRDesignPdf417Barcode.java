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

import net.sf.dynamicreports.design.definition.barcode.DRIDesignPdf417Barcode;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignPdf417Barcode class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRDesignPdf417Barcode extends DRDesignBarcode4j implements DRIDesignPdf417Barcode {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Integer minColumns;
    private Integer maxColumns;
    private Integer minRows;
    private Integer maxRows;
    private Double widthToHeightRatio;
    private Integer errorCorrectionLevel;

    /**
     * <p>Constructor for DRDesignPdf417Barcode.</p>
     */
    public DRDesignPdf417Barcode() {
        super("PDF417");
    }

    /** {@inheritDoc} */
    @Override
    public Integer getMinColumns() {
        return minColumns;
    }

    /**
     * <p>Setter for the field <code>minColumns</code>.</p>
     *
     * @param minColumns a {@link java.lang.Integer} object.
     */
    public void setMinColumns(Integer minColumns) {
        this.minColumns = minColumns;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getMaxColumns() {
        return maxColumns;
    }

    /**
     * <p>Setter for the field <code>maxColumns</code>.</p>
     *
     * @param maxColumns a {@link java.lang.Integer} object.
     */
    public void setMaxColumns(Integer maxColumns) {
        this.maxColumns = maxColumns;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getMinRows() {
        return minRows;
    }

    /**
     * <p>Setter for the field <code>minRows</code>.</p>
     *
     * @param minRows a {@link java.lang.Integer} object.
     */
    public void setMinRows(Integer minRows) {
        this.minRows = minRows;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getMaxRows() {
        return maxRows;
    }

    /**
     * <p>Setter for the field <code>maxRows</code>.</p>
     *
     * @param maxRows a {@link java.lang.Integer} object.
     */
    public void setMaxRows(Integer maxRows) {
        this.maxRows = maxRows;
    }

    /** {@inheritDoc} */
    @Override
    public Double getWidthToHeightRatio() {
        return widthToHeightRatio;
    }

    /**
     * <p>Setter for the field <code>widthToHeightRatio</code>.</p>
     *
     * @param widthToHeightRatio a {@link java.lang.Double} object.
     */
    public void setWidthToHeightRatio(Double widthToHeightRatio) {
        this.widthToHeightRatio = widthToHeightRatio;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getErrorCorrectionLevel() {
        return errorCorrectionLevel;
    }

    /**
     * <p>Setter for the field <code>errorCorrectionLevel</code>.</p>
     *
     * @param errorCorrectionLevel a {@link java.lang.Integer} object.
     */
    public void setErrorCorrectionLevel(Integer errorCorrectionLevel) {
        this.errorCorrectionLevel = errorCorrectionLevel;
    }
}

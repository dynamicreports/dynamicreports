/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca
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

import net.sf.dynamicreports.design.definition.barcode.DRIDesignPostnetBarcode;
import net.sf.dynamicreports.report.constant.BarcodeBaselinePosition;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * <p>DRDesignPostnetBarcode class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRDesignPostnetBarcode extends DRDesignChecksumBarcode implements DRIDesignPostnetBarcode {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Boolean displayChecksum;
    private Double shortBarHeight;
    private BarcodeBaselinePosition baselinePosition;
    private Double intercharGapWidth;

    /**
     * <p>Constructor for DRDesignPostnetBarcode.</p>
     */
    public DRDesignPostnetBarcode() {
        super("POSTNET");
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getDisplayChecksum() {
        return displayChecksum;
    }

    /**
     * <p>Setter for the field <code>displayChecksum</code>.</p>
     *
     * @param displayChecksum a {@link java.lang.Boolean} object.
     */
    public void setDisplayChecksum(Boolean displayChecksum) {
        this.displayChecksum = displayChecksum;
    }

    /** {@inheritDoc} */
    @Override
    public Double getShortBarHeight() {
        return shortBarHeight;
    }

    /**
     * <p>Setter for the field <code>shortBarHeight</code>.</p>
     *
     * @param shortBarHeight a {@link java.lang.Double} object.
     */
    public void setShortBarHeight(Double shortBarHeight) {
        this.shortBarHeight = shortBarHeight;
    }

    /** {@inheritDoc} */
    @Override
    public BarcodeBaselinePosition getBaselinePosition() {
        return baselinePosition;
    }

    /**
     * <p>Setter for the field <code>baselinePosition</code>.</p>
     *
     * @param baselinePosition a {@link net.sf.dynamicreports.report.constant.BarcodeBaselinePosition} object.
     */
    public void setBaselinePosition(BarcodeBaselinePosition baselinePosition) {
        this.baselinePosition = baselinePosition;
    }

    /** {@inheritDoc} */
    @Override
    public Double getIntercharGapWidth() {
        return intercharGapWidth;
    }

    /**
     * <p>Setter for the field <code>intercharGapWidth</code>.</p>
     *
     * @param intercharGapWidth a {@link java.lang.Double} object.
     */
    public void setIntercharGapWidth(Double intercharGapWidth) {
        this.intercharGapWidth = intercharGapWidth;
    }
}

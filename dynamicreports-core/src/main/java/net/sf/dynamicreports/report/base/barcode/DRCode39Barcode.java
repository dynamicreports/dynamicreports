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
import net.sf.dynamicreports.report.definition.barcode.DRICode39Barcode;

/**
 * <p>DRCode39Barcode class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRCode39Barcode extends DRChecksumBarcode implements DRICode39Barcode {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private Boolean displayChecksum;
    private Boolean displayStartStop;
    private Boolean extendedCharSetEnabled;
    private Double intercharGapWidth;
    private Double wideFactor;

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getDisplayStartStop() {
        return displayStartStop;
    }

    /**
     * <p>Setter for the field <code>displayStartStop</code>.</p>
     *
     * @param displayStartStop a {@link java.lang.Boolean} object.
     */
    public void setDisplayStartStop(Boolean displayStartStop) {
        this.displayStartStop = displayStartStop;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean getExtendedCharSetEnabled() {
        return extendedCharSetEnabled;
    }

    /**
     * <p>Setter for the field <code>extendedCharSetEnabled</code>.</p>
     *
     * @param extendedCharSetEnabled a {@link java.lang.Boolean} object.
     */
    public void setExtendedCharSetEnabled(Boolean extendedCharSetEnabled) {
        this.extendedCharSetEnabled = extendedCharSetEnabled;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getWideFactor() {
        return wideFactor;
    }

    /**
     * <p>Setter for the field <code>wideFactor</code>.</p>
     *
     * @param wideFactor a {@link java.lang.Double} object.
     */
    public void setWideFactor(Double wideFactor) {
        this.wideFactor = wideFactor;
    }
}

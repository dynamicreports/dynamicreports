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

import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.BarcodeTextPosition;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.barcode.DRIBarcode4j;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>Abstract DRBarcode4j class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public abstract class DRBarcode4j extends DRBarcode implements DRIBarcode4j {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private DRIExpression<String> patternExpression;
    private Double moduleWidth;
    private BarcodeOrientation orientation;
    private BarcodeTextPosition textPosition;
    private Double quietZone;
    private Double verticalQuietZone;

    /**
     * {@inheritDoc}
     */
    @Override
    public DRIExpression<String> getPatternExpression() {
        return patternExpression;
    }

    /**
     * <p>Setter for the field <code>patternExpression</code>.</p>
     *
     * @param patternExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setPatternExpression(DRIExpression<String> patternExpression) {
        this.patternExpression = patternExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getModuleWidth() {
        return moduleWidth;
    }

    /**
     * <p>Setter for the field <code>moduleWidth</code>.</p>
     *
     * @param moduleWidth a {@link java.lang.Double} object.
     */
    public void setModuleWidth(Double moduleWidth) {
        this.moduleWidth = moduleWidth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BarcodeOrientation getOrientation() {
        return orientation;
    }

    /**
     * <p>Setter for the field <code>orientation</code>.</p>
     *
     * @param orientation a {@link net.sf.dynamicreports.report.constant.BarcodeOrientation} object.
     */
    public void setOrientation(BarcodeOrientation orientation) {
        this.orientation = orientation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BarcodeTextPosition getTextPosition() {
        return textPosition;
    }

    /**
     * <p>Setter for the field <code>textPosition</code>.</p>
     *
     * @param textPosition a {@link net.sf.dynamicreports.report.constant.BarcodeTextPosition} object.
     */
    public void setTextPosition(BarcodeTextPosition textPosition) {
        this.textPosition = textPosition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getQuietZone() {
        return quietZone;
    }

    /**
     * <p>Setter for the field <code>quietZone</code>.</p>
     *
     * @param quietZone a {@link java.lang.Double} object.
     */
    public void setQuietZone(Double quietZone) {
        this.quietZone = quietZone;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getVerticalQuietZone() {
        return verticalQuietZone;
    }

    /**
     * <p>Setter for the field <code>verticalQuietZone</code>.</p>
     *
     * @param verticalQuietZone a {@link java.lang.Double} object.
     */
    public void setVerticalQuietZone(Double verticalQuietZone) {
        this.verticalQuietZone = verticalQuietZone;
    }
}

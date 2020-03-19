/*
 * DynamicReports - Free Java reporting library for creating reports dynamically
 *
 * Copyright (C) 2010 - 2018 Ricardo Mariaca and the Dynamic Reports Contributors
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

import net.sf.dynamicreports.report.base.component.DRDimensionComponent;
import net.sf.dynamicreports.report.constant.BarbecueType;
import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.barcode.DRIBarbecue;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>DRBarbecue class.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public class DRBarbecue extends DRDimensionComponent implements DRIBarbecue {
    private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

    private BarbecueType type;
    private DRIExpression<String> codeExpression;
    private DRIExpression<String> applicationIdentifierExpression;
    private Boolean drawText;
    private Boolean checksumRequired;
    private Integer barWidth;
    private Integer barHeight;
    private BarcodeOrientation orientation;

    /** {@inheritDoc} */
    @Override
    public BarbecueType getType() {
        return type;
    }

    /**
     * <p>Setter for the field <code>type</code>.</p>
     *
     * @param type a {@link net.sf.dynamicreports.report.constant.BarbecueType} object.
     */
    public void setType(BarbecueType type) {
        this.type = type;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<String> getCodeExpression() {
        return codeExpression;
    }

    /**
     * <p>Setter for the field <code>codeExpression</code>.</p>
     *
     * @param codeExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setCodeExpression(DRIExpression<String> codeExpression) {
        this.codeExpression = codeExpression;
    }

    /** {@inheritDoc} */
    @Override
    public DRIExpression<String> getApplicationIdentifierExpression() {
        return applicationIdentifierExpression;
    }

    /**
     * <p>Setter for the field <code>applicationIdentifierExpression</code>.</p>
     *
     * @param applicationIdentifierExpression a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public void setApplicationIdentifierExpression(DRIExpression<String> applicationIdentifierExpression) {
        this.applicationIdentifierExpression = applicationIdentifierExpression;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getDrawText() {
        return drawText;
    }

    /**
     * <p>Setter for the field <code>drawText</code>.</p>
     *
     * @param drawText a {@link java.lang.Boolean} object.
     */
    public void setDrawText(Boolean drawText) {
        this.drawText = drawText;
    }

    /** {@inheritDoc} */
    @Override
    public Boolean getChecksumRequired() {
        return checksumRequired;
    }

    /**
     * <p>Setter for the field <code>checksumRequired</code>.</p>
     *
     * @param checksumRequired a {@link java.lang.Boolean} object.
     */
    public void setChecksumRequired(Boolean checksumRequired) {
        this.checksumRequired = checksumRequired;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getBarWidth() {
        return barWidth;
    }

    /**
     * <p>Setter for the field <code>barWidth</code>.</p>
     *
     * @param barWidth a {@link java.lang.Integer} object.
     */
    public void setBarWidth(Integer barWidth) {
        this.barWidth = barWidth;
    }

    /** {@inheritDoc} */
    @Override
    public Integer getBarHeight() {
        return barHeight;
    }

    /**
     * <p>Setter for the field <code>barHeight</code>.</p>
     *
     * @param barHeight a {@link java.lang.Integer} object.
     */
    public void setBarHeight(Integer barHeight) {
        this.barHeight = barHeight;
    }

    /** {@inheritDoc} */
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
}

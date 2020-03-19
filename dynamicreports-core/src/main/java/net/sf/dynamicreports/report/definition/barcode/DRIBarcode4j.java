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
package net.sf.dynamicreports.report.definition.barcode;

import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.BarcodeTextPosition;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * <p>DRIBarcode4j interface.</p>
 *
 * @author Ricardo Mariaca
 * 
 */
public interface DRIBarcode4j extends DRIBarcode {

    /**
     * <p>getPatternExpression.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.definition.expression.DRIExpression} object.
     */
    public DRIExpression<String> getPatternExpression();

    /**
     * <p>getModuleWidth.</p>
     *
     * @return a {@link java.lang.Double} object.
     */
    public Double getModuleWidth();

    /**
     * <p>getOrientation.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.BarcodeOrientation} object.
     */
    public BarcodeOrientation getOrientation();

    /**
     * <p>getTextPosition.</p>
     *
     * @return a {@link net.sf.dynamicreports.report.constant.BarcodeTextPosition} object.
     */
    public BarcodeTextPosition getTextPosition();

    /**
     * <p>getQuietZone.</p>
     *
     * @return a {@link java.lang.Double} object.
     */
    public Double getQuietZone();

    /**
     * <p>getVerticalQuietZone.</p>
     *
     * @return a {@link java.lang.Double} object.
     */
    public Double getVerticalQuietZone();
}

/**
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

package net.sf.dynamicreports.report.base.barcode;

import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.BarcodeTextPosition;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.barcode.DRIBarcode4j;
import net.sf.dynamicreports.report.definition.expression.DRIExpression;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class DRBarcode4j extends DRBarcode implements DRIBarcode4j {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIExpression<String> patternExpression;
	private Double moduleWidth;
	private BarcodeOrientation orientation;
	private BarcodeTextPosition textPosition;
	private Double quietZone;
	private Double verticalQuietZone;

	@Override
	public DRIExpression<String> getPatternExpression() {
		return patternExpression;
	}

	public void setPatternExpression(DRIExpression<String> patternExpression) {
		this.patternExpression = patternExpression;
	}

	@Override
	public Double getModuleWidth() {
		return moduleWidth;
	}

	public void setModuleWidth(Double moduleWidth) {
		this.moduleWidth = moduleWidth;
	}

	@Override
	public BarcodeOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(BarcodeOrientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public BarcodeTextPosition getTextPosition() {
		return textPosition;
	}

	public void setTextPosition(BarcodeTextPosition textPosition) {
		this.textPosition = textPosition;
	}

	@Override
	public Double getQuietZone() {
		return quietZone;
	}

	public void setQuietZone(Double quietZone) {
		this.quietZone = quietZone;
	}

	@Override
	public Double getVerticalQuietZone() {
		return verticalQuietZone;
	}

	public void setVerticalQuietZone(Double verticalQuietZone) {
		this.verticalQuietZone = verticalQuietZone;
	}
}

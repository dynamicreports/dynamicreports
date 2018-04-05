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

package net.sf.dynamicreports.design.base.barcode;

import net.sf.dynamicreports.design.definition.barcode.DRIDesignBarcode4j;
import net.sf.dynamicreports.design.definition.expression.DRIDesignExpression;
import net.sf.dynamicreports.report.constant.BarcodeOrientation;
import net.sf.dynamicreports.report.constant.BarcodeTextPosition;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public abstract class DRDesignBarcode4j extends DRDesignBarcode implements DRIDesignBarcode4j {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private DRIDesignExpression patternExpression;
	private Double moduleWidth;
	private BarcodeOrientation orientation;
	private BarcodeTextPosition textPosition;
	private Double quietZone;
	private Double verticalQuietZone;

	public DRDesignBarcode4j(String name) {
		super(name);
	}

	@Override
	public DRIDesignExpression getPatternExpression() {
		return patternExpression;
	}

	public void setPatternExpression(DRIDesignExpression patternExpression) {
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

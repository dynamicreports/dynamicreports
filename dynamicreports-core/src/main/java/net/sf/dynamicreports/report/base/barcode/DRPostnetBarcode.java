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

import net.sf.dynamicreports.report.constant.BarcodeBaselinePosition;
import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.barcode.DRIPostnetBarcode;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRPostnetBarcode extends DRChecksumBarcode implements DRIPostnetBarcode {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Boolean displayChecksum;
	private Double shortBarHeight;
	private BarcodeBaselinePosition baselinePosition;
	private Double intercharGapWidth;

	@Override
	public Boolean getDisplayChecksum() {
		return displayChecksum;
	}

	public void setDisplayChecksum(Boolean displayChecksum) {
		this.displayChecksum = displayChecksum;
	}

	@Override
	public Double getShortBarHeight() {
		return shortBarHeight;
	}

	public void setShortBarHeight(Double shortBarHeight) {
		this.shortBarHeight = shortBarHeight;
	}

	@Override
	public BarcodeBaselinePosition getBaselinePosition() {
		return baselinePosition;
	}

	public void setBaselinePosition(BarcodeBaselinePosition baselinePosition) {
		this.baselinePosition = baselinePosition;
	}

	@Override
	public Double getIntercharGapWidth() {
		return intercharGapWidth;
	}

	public void setIntercharGapWidth(Double intercharGapWidth) {
		this.intercharGapWidth = intercharGapWidth;
	}
}

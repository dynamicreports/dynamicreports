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

import net.sf.dynamicreports.report.constant.Constants;
import net.sf.dynamicreports.report.definition.barcode.DRIRoyalMailCustomerBarcode;

/**
 * <p>DRRoyalMailCustomerBarcode class.</p>
 *
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 * @version $Id: $Id
 */
public class DRRoyalMailCustomerBarcode extends DRChecksumBarcode implements DRIRoyalMailCustomerBarcode {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Double ascenderHeight;
	private Double intercharGapWidth;
	private Double trackHeight;

	/** {@inheritDoc} */
	@Override
	public Double getAscenderHeight() {
		return ascenderHeight;
	}

	/**
	 * <p>Setter for the field <code>ascenderHeight</code>.</p>
	 *
	 * @param ascenderHeight a {@link java.lang.Double} object.
	 */
	public void setAscenderHeight(Double ascenderHeight) {
		this.ascenderHeight = ascenderHeight;
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

	/** {@inheritDoc} */
	@Override
	public Double getTrackHeight() {
		return trackHeight;
	}

	/**
	 * <p>Setter for the field <code>trackHeight</code>.</p>
	 *
	 * @param trackHeight a {@link java.lang.Double} object.
	 */
	public void setTrackHeight(Double trackHeight) {
		this.trackHeight = trackHeight;
	}
}

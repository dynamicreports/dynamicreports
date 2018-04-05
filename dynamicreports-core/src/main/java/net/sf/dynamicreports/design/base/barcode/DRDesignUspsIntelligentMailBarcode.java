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

import net.sf.dynamicreports.design.definition.barcode.DRIDesignUspsIntelligentMailBarcode;
import net.sf.dynamicreports.report.constant.Constants;

/**
 * @author Ricardo Mariaca (r.mariaca@dynamicreports.org)
 */
public class DRDesignUspsIntelligentMailBarcode extends DRDesignChecksumBarcode implements DRIDesignUspsIntelligentMailBarcode {
	private static final long serialVersionUID = Constants.SERIAL_VERSION_UID;

	private Double ascenderHeight;
	private Double intercharGapWidth;
	private Double trackHeight;

	public DRDesignUspsIntelligentMailBarcode() {
		super("USPSIntelligentMail");
	}

	@Override
	public Double getAscenderHeight() {
		return ascenderHeight;
	}

	public void setAscenderHeight(Double ascenderHeight) {
		this.ascenderHeight = ascenderHeight;
	}

	@Override
	public Double getIntercharGapWidth() {
		return intercharGapWidth;
	}

	public void setIntercharGapWidth(Double intercharGapWidth) {
		this.intercharGapWidth = intercharGapWidth;
	}

	@Override
	public Double getTrackHeight() {
		return trackHeight;
	}

	public void setTrackHeight(Double trackHeight) {
		this.trackHeight = trackHeight;
	}
}
